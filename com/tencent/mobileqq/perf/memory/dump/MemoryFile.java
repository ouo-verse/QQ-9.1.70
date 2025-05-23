package com.tencent.mobileqq.perf.memory.dump;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Debug;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.common.heapdump.ForkJvmHeapDumper;
import com.tencent.bugly.common.heapdump.HeapDumpConfig;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.memory.FaultMonitor;
import com.tencent.mobileqq.perf.memory.util.ZipUtil;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.perf.upload.cos.PerfCosUploader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unusedcodecheck.api.IUnusedCodeCheck;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0004R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/dump/MemoryFile;", "", "Lcom/tencent/mobileqq/perf/memory/dump/MemoryFile$a;", "context", "", "e", "f", "", "url", "c", "i", "j", "d", "path", "a", "k", "hprofFilePath", "", "g", "b", "l", "Z", "isDumping", "isUploading", "", "J", "lastDumpTime", "<init>", "()V", "FromTag", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MemoryFile {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MemoryFile f257700a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isDumping;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isUploading;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile long lastDumpTime;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/dump/MemoryFile$FromTag;", "", "(Ljava/lang/String;I)V", "ignoreTimeLimit", "", "PerfTest", "FaultMonitor", "FloatWindow", "RaftKitWindow", "AIOMonitor", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class FromTag {
        private static final /* synthetic */ FromTag[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FromTag AIOMonitor;
        public static final FromTag FaultMonitor;
        public static final FromTag FloatWindow;
        public static final FromTag PerfTest;
        public static final FromTag RaftKitWindow;

        private static final /* synthetic */ FromTag[] $values() {
            return new FromTag[]{PerfTest, FaultMonitor, FloatWindow, RaftKitWindow, AIOMonitor};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30254);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            PerfTest = new FromTag("PerfTest", 0);
            FaultMonitor = new FromTag("FaultMonitor", 1);
            FloatWindow = new FromTag("FloatWindow", 2);
            RaftKitWindow = new FromTag("RaftKitWindow", 3);
            AIOMonitor = new FromTag("AIOMonitor", 4);
            $VALUES = $values();
        }

        FromTag(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static FromTag valueOf(String str) {
            return (FromTag) Enum.valueOf(FromTag.class, str);
        }

        public static FromTag[] values() {
            return (FromTag[]) $VALUES.clone();
        }

        public final boolean ignoreTimeLimit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this != FloatWindow && this != RaftKitWindow && this != PerfTest) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bQ\u0010RR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u0003\u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010%\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R.\u00103\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020&0-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\"\u00105\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b\u000b\u0010\u0019\"\u0004\b4\u0010\u001bR$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010@\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0017\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR$\u0010C\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R$\u0010F\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\f\u001a\u0004\b7\u0010\u000e\"\u0004\bE\u0010\u0010R\"\u0010L\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010H\u001a\u0004\b\u0016\u0010I\"\u0004\bJ\u0010KR\"\u0010N\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010H\u001a\u0004\b\u001d\u0010I\"\u0004\bM\u0010KR\"\u0010P\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010H\u001a\u0004\bD\u0010I\"\u0004\bO\u0010K\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/dump/MemoryFile$a;", "", "Lcom/tencent/mobileqq/perf/memory/dump/MemoryFile$FromTag;", "a", "Lcom/tencent/mobileqq/perf/memory/dump/MemoryFile$FromTag;", "c", "()Lcom/tencent/mobileqq/perf/memory/dump/MemoryFile$FromTag;", "r", "(Lcom/tencent/mobileqq/perf/memory/dump/MemoryFile$FromTag;)V", "fromTag", "", "b", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "setZipPath", "(Ljava/lang/String;)V", "zipPath", "o", BdhLogUtil.LogTag.Tag_Conn, "zipUuid", "", "d", "Z", "f", "()Z", "u", "(Z)V", "needGc", "e", "g", "v", "needLog", "p", "asyncDump", h.F, "w", "needStrip", "", "I", "j", "()I", "setStripConfig", "(I)V", "stripConfig", "", "i", "Ljava/util/Map;", "()Ljava/util/Map;", "setReportTagToSize", "(Ljava/util/Map;)V", "reportTagToSize", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "dumpCompleted", "Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;", "k", "Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;", "getTriggerType", "()Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/perf/memory/FaultMonitor$TriggerType;)V", "triggerType", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "uploadSucceed", "getUploadUrl", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "uploadUrl", DomainData.DOMAIN_NAME, "y", "uploadFailedReason", "", "J", "()J", ReportConstant.COSTREPORT_PREFIX, "(J)V", "hprofSize", "t", "logSize", "B", "zipSize", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private FromTag fromTag;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String zipPath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String zipUuid;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean needGc;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean needLog;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean asyncDump;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean needStrip;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @SuppressLint({"RestrictedApi"})
        private int stripConfig;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Map<String, Integer> reportTagToSize;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean dumpCompleted;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private FaultMonitor.TriggerType triggerType;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private boolean uploadSucceed;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String uploadUrl;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String uploadFailedReason;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private long hprofSize;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private long logSize;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private long zipSize;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.fromTag = FromTag.PerfTest;
            com.tencent.mobileqq.perf.memory.dump.a aVar = com.tencent.mobileqq.perf.memory.dump.a.f257721a;
            this.zipPath = com.tencent.mobileqq.perf.memory.dump.a.j(aVar, false, 1, null);
            this.zipUuid = aVar.k();
            this.needGc = true;
            this.needStrip = true;
            this.stripConfig = 9;
            this.reportTagToSize = new LinkedHashMap();
        }

        public final void A(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            } else {
                this.uploadUrl = str;
            }
        }

        public final void B(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                iPatchRedirector.redirect((short) 35, (Object) this, j3);
            } else {
                this.zipSize = j3;
            }
        }

        public final void C(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.zipUuid = str;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            return this.asyncDump;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
            }
            return this.dumpCompleted;
        }

        @NotNull
        public final FromTag c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FromTag) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.fromTag;
        }

        public final long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return ((Long) iPatchRedirector.redirect((short) 30, (Object) this)).longValue();
            }
            return this.hprofSize;
        }

        public final long e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return ((Long) iPatchRedirector.redirect((short) 32, (Object) this)).longValue();
            }
            return this.logSize;
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return this.needGc;
        }

        public final boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return this.needLog;
        }

        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
            }
            return this.needStrip;
        }

        @NotNull
        public final Map<String, Integer> i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Map) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this.reportTagToSize;
        }

        public final int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return this.stripConfig;
        }

        @Nullable
        public final String k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (String) iPatchRedirector.redirect((short) 28, (Object) this);
            }
            return this.uploadFailedReason;
        }

        public final boolean l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
            }
            return this.uploadSucceed;
        }

        @NotNull
        public final String m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.zipPath;
        }

        public final long n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return ((Long) iPatchRedirector.redirect((short) 34, (Object) this)).longValue();
            }
            return this.zipSize;
        }

        @NotNull
        public final String o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.zipUuid;
        }

        public final void p(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, z16);
            } else {
                this.asyncDump = z16;
            }
        }

        public final void q(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, z16);
            } else {
                this.dumpCompleted = z16;
            }
        }

        public final void r(@NotNull FromTag fromTag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) fromTag);
            } else {
                Intrinsics.checkNotNullParameter(fromTag, "<set-?>");
                this.fromTag = fromTag;
            }
        }

        public final void s(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this, j3);
            } else {
                this.hprofSize = j3;
            }
        }

        public final void t(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                iPatchRedirector.redirect((short) 33, (Object) this, j3);
            } else {
                this.logSize = j3;
            }
        }

        public final void u(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                this.needGc = z16;
            }
        }

        public final void v(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, z16);
            } else {
                this.needLog = z16;
            }
        }

        public final void w(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, z16);
            } else {
                this.needStrip = z16;
            }
        }

        public final void x(@Nullable FaultMonitor.TriggerType triggerType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) triggerType);
            } else {
                this.triggerType = triggerType;
            }
        }

        public final void y(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
            } else {
                this.uploadFailedReason = str;
            }
        }

        public final void z(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, z16);
            } else {
                this.uploadSucceed = z16;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f257700a = new MemoryFile();
        }
    }

    MemoryFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(String path) {
        File file = new File(path);
        FileUtils.delete(path, true);
        file.mkdirs();
    }

    private final void c(String url, a context) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://" + PerfCosUploader.BucketType.MEM.getBucketName() + "-70657.njc.vod.tencent-cloud.com", false, 2, null);
        if (startsWith$default) {
            context.z(true);
            context.A(url);
        } else {
            context.y(url);
        }
    }

    private final void d() {
        QLog.d("MemoryFileDump", 1, "ClassDump analysis result is " + ((IUnusedCodeCheck) QRoute.api(IUnusedCodeCheck.class)).analysis(BaseApplication.getContext(), new File(com.tencent.mobileqq.perf.memory.dump.a.f257721a.e()), false));
    }

    @JvmStatic
    public static final void e(@NotNull a context) {
        String c16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isDumping && !isUploading) {
            MemoryFile memoryFile = f257700a;
            memoryFile.k();
            if (!context.c().ignoreTimeLimit() && System.currentTimeMillis() - lastDumpTime < com.tencent.mobileqq.perf.memory.config.a.f257676a.k()) {
                context.q(false);
                QLog.d("MemoryFileDump", 1, "dump memory file ignore, lastDumpTime:" + lastDumpTime);
                return;
            }
            QLog.d("MemoryFileDump", 1, "dump file start, from: " + context.c());
            MemoryUtil memoryUtil = MemoryUtil.f258173a;
            long j3 = (long) 1024;
            long h16 = (memoryUtil.h() - memoryUtil.f()) / j3;
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            com.tencent.mobileqq.perf.memory.config.a aVar = com.tencent.mobileqq.perf.memory.config.a.f257676a;
            if (h16 >= aVar.l()) {
                try {
                    if (memoryInfo.availMem * j3 >= aVar.m()) {
                        try {
                            isDumping = true;
                            long currentTimeMillis = System.currentTimeMillis();
                            com.tencent.mobileqq.perf.memory.dump.a aVar2 = com.tencent.mobileqq.perf.memory.dump.a.f257721a;
                            memoryFile.a(aVar2.a());
                            if (context.f()) {
                                com.tencent.mobileqq.perf.memory.util.a.f257790a.b();
                            }
                            context.i().putAll(b.b(b.f257725a, false, 1, null));
                            memoryFile.j();
                            memoryFile.i();
                            if (!h(memoryFile, context, null, 2, null)) {
                                QLog.d("MemoryFileDump", 1, "dump memory file failed, hprof dump fail");
                                FileUtils.delete(aVar2.a(), true);
                                context.q(false);
                                isDumping = false;
                                memoryFile.l();
                                return;
                            }
                            memoryFile.d();
                            if (context.g() && (c16 = c.f257726a.c()) != null) {
                                context.t(new File(c16).length());
                            }
                            ZipUtil.f257789a.c(aVar2.a(), context.m());
                            FileUtils.delete(aVar2.a(), true);
                            QLog.d("MemoryFileDump", 1, "dump file, file size:" + new File(context.m()).length() + ", cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                            context.q(true);
                            isDumping = false;
                            memoryFile.l();
                            return;
                        } catch (OutOfMemoryError unused) {
                            QLog.d("MemoryFileDump", 1, "dump memory file failed, oom error");
                            isDumping = false;
                            f257700a.l();
                            return;
                        }
                    }
                } catch (Throwable th5) {
                    isDumping = false;
                    f257700a.l();
                    throw th5;
                }
            }
            QLog.d("MemoryFileDump", 1, "dump memory file failed, storage is not enough");
            context.q(false);
            return;
        }
        context.q(false);
        QLog.d("MemoryFileDump", 1, "dump memory file ignore, isDumping:" + isDumping + ", isUploading:" + isUploading);
    }

    @JvmStatic
    public static final void f(@NotNull a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        e(context);
        if (context.b()) {
            context.B(new File(context.m()).length());
            isUploading = true;
            f257700a.c(PerfCosUploader.d(PerfCosUploader.f258269a, PerfCosUploader.BucketType.MEM, context.m(), context.o(), false, 8, null), context);
            isUploading = false;
        }
    }

    public static /* synthetic */ boolean h(MemoryFile memoryFile, a aVar, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return memoryFile.g(aVar, str);
    }

    private final void i() {
        if (jd2.a.INSTANCE.a()) {
            String f16 = com.tencent.mobileqq.perf.memory.dump.a.f257721a.f();
            jd2.b.a(f16);
            QLog.d("MemoryFileDump", 1, "dump native file success\uff0cdumpPath\uff1a" + f16);
        }
    }

    private final void j() {
        QLog.d("MemoryFileDump", 1, "dump smaps start");
        com.tencent.mobileqq.perf.memory.dump.a aVar = com.tencent.mobileqq.perf.memory.dump.a.f257721a;
        String h16 = aVar.h();
        String g16 = aVar.g();
        FileUtils.copyFile(h16, g16);
        QLog.d("MemoryFileDump", 1, "dump smaps file success\uff0cdumpPath\uff1a" + g16);
    }

    private final void k() {
        if (lastDumpTime == 0) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            lastDumpTime = from.decodeLong("last_dump_memory_time", 0L);
        }
    }

    public final void b(@NotNull String path) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) path);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        if (file.exists()) {
            file.createNewFile();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g(@NotNull a context, @Nullable String hprofFilePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) hprofFilePath)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (hprofFilePath == null) {
            hprofFilePath = com.tencent.mobileqq.perf.memory.dump.a.f257721a.c();
        }
        QLog.d("MemoryFileDump", 1, "dump java heap begin, asyncDump: " + context.a() + ", filePath: " + hprofFilePath);
        b(hprofFilePath);
        int i3 = -1;
        try {
            if (context.a()) {
                i3 = new ForkJvmHeapDumper().dump(hprofFilePath, new HeapDumpConfig(context.h(), context.j(), "FaultMonitor"));
                QLog.d("MemoryFileDump", 1, "dump java heap\uff0cresult: " + i3);
            }
            if (!AppSetting.isPublicVersion() && (!context.a() || i3 == 102 || i3 == 104)) {
                Debug.dumpHprofData(hprofFilePath);
                try {
                    QLog.d("MemoryFileDump", 1, "dump java heap success");
                    i3 = 0;
                } catch (Exception e16) {
                    e = e16;
                    i3 = 0;
                    QLog.e("MemoryFileDump", 1, "dump java heap fail", e);
                    if (i3 != 0) {
                    }
                }
            }
            if (i3 == 0) {
                context.s(new File(hprofFilePath).length());
            }
        } catch (Exception e17) {
            e = e17;
        }
        if (i3 != 0) {
            return true;
        }
        return false;
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        lastDumpTime = System.currentTimeMillis();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeLong("last_dump_memory_time", lastDumpTime);
    }
}
