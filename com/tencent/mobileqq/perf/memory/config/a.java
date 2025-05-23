package com.tencent.mobileqq.perf.memory.config;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.perf.process.config.g;
import com.tencent.mobileqq.perf.process.util.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.util.AppSetting;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\t\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002J,\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nH\u0002J,\u0010\r\u001a\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fH\u0002J:\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002J\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/perf/memory/config/a;", "", "", "o", "", "", "dataSetMap", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "f", "", h.F, "", "g", "", "defaultList", "i", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "Lcom/tencent/mobileqq/perf/memory/config/a$a;", DomainData.DOMAIN_NAME, "b", "Ljava/util/List;", "DEFAULT_NO_LIMIT_WHITE_LIST", "c", "Lcom/tencent/mobileqq/perf/memory/config/a$a;", DownloadInfo.spKey_Config, "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257676a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> DEFAULT_NO_LIMIT_WHITE_LIST;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static C8201a config;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b4\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u001a\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010 \u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\"\u0010(\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R(\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\"\u00106\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\"\u00109\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR(\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010+\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\"\u0010?\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b=\u0010\u0013\"\u0004\b>\u0010\u0015R\"\u0010F\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010I\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u0011\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R\"\u0010K\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0011\u001a\u0004\b%\u0010\u0013\"\u0004\bJ\u0010\u0015R\"\u0010M\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b*\u0010\u001d\"\u0004\bL\u0010\u001fR\"\u0010O\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u000e\u001a\u0004\b\u001b\u0010\u001d\"\u0004\bN\u0010\u001fR\"\u0010Q\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b!\u0010\u001d\"\u0004\bP\u0010\u001fR\"\u0010T\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\bS\u0010\u0015R\"\u0010W\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\"\u0004\bV\u0010\u0015R\"\u0010Z\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010\u0011\u001a\u0004\b@\u0010\u0013\"\u0004\bY\u0010\u0015\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/config/a$a;", "", "", "", "dataSetMap", "", "r", "toString", "", "reportCount", "", "i", "", "a", UserInfo.SEX_FEMALE, "maxPss", "b", "I", h.F, "()I", "setDailyLimit", "(I)V", "dailyLimit", "c", "p", "setProcessLimit", "processLimit", "d", "l", "()F", "setMaxUsedRatio", "(F)V", "maxUsedRatio", "e", "j", "setMaxRequiredDalvikMemory", "maxRequiredDalvikMemory", "f", "k", "setMaxRequiredMemory", "maxRequiredMemory", "", "g", "Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/List;", "setWhiteSceneList", "(Ljava/util/List;)V", "whiteSceneList", "getPublicUserWhiteList", "setPublicUserWhiteList", "publicUserWhiteList", "getPublicUserSampling", "setPublicUserSampling", "publicUserSampling", "getSecondReportMaxPss", "setSecondReportMaxPss", "secondReportMaxPss", "o", "setNoLimitWhiteList", "noLimitWhiteList", DomainData.DOMAIN_NAME, "setNoLimitTimePeriod", "noLimitTimePeriod", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "getOnlyWifiReport", "()Z", "setOnlyWifiReport", "(Z)V", "onlyWifiReport", "getProcessLiveTimeLimit", "setProcessLiveTimeLimit", "processLiveTimeLimit", "setCeilingReportLimit", "ceilingReportLimit", "setCeilingSampleRatio", "ceilingSampleRatio", "setCeilingJHeapThreshold", "ceilingJHeapThreshold", "setCeilingMaxPss", "ceilingMaxPss", ReportConstant.COSTREPORT_PREFIX, "setBackgroundCheckTime", "backgroundCheckTime", "t", "setBackgroundCheckInterval", "backgroundCheckInterval", "u", "setMemoryDumpMinInterval", "memoryDumpMinInterval", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.memory.config.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8201a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float maxPss;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int dailyLimit;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int processLimit;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float maxUsedRatio;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int maxRequiredDalvikMemory;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int maxRequiredMemory;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<String> whiteSceneList;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<String> publicUserWhiteList;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private float publicUserSampling;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private float secondReportMaxPss;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<String> noLimitWhiteList;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int noLimitTimePeriod;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean onlyWifiReport;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private int processLiveTimeLimit;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private int ceilingReportLimit;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private float ceilingSampleRatio;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private float ceilingJHeapThreshold;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        private float ceilingMaxPss;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        private int backgroundCheckTime;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        private int backgroundCheckInterval;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        private int memoryDumpMinInterval;

        public C8201a() {
            List<String> emptyList;
            List<String> emptyList2;
            List<String> emptyList3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.maxPss = 1572864.0f;
            this.dailyLimit = 5;
            this.processLimit = 2;
            this.maxUsedRatio = 0.9f;
            this.maxRequiredDalvikMemory = 15360;
            this.maxRequiredMemory = RFixConstants.MD5_FILE_BUF_LENGTH;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.whiteSceneList = emptyList;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.publicUserWhiteList = emptyList2;
            this.secondReportMaxPss = 1572864.0f;
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            this.noLimitWhiteList = emptyList3;
            this.noLimitTimePeriod = 3600000;
            this.onlyWifiReport = true;
            this.ceilingReportLimit = 2;
            this.ceilingSampleRatio = 1.0f;
            this.ceilingJHeapThreshold = 0.9f;
            this.ceilingMaxPss = 1572864.0f;
            this.backgroundCheckTime = 1800000;
            this.backgroundCheckInterval = 60000;
            this.memoryDumpMinInterval = 180000;
        }

        public final boolean a() {
            String str;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
                return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
            }
            if (!AppSetting.isPublicVersion()) {
                return true;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            if (str == null) {
                str = "null";
            }
            if ((!this.publicUserWhiteList.isEmpty()) && this.publicUserWhiteList.contains(str)) {
                return true;
            }
            if (this.onlyWifiReport && !AppNetConnInfo.isWifiConn()) {
                return false;
            }
            if (this.processLiveTimeLimit != 0) {
                long h16 = b.f257946a.h();
                int i3 = this.processLiveTimeLimit;
                long j3 = i3;
                if (1 <= j3 && j3 < h16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return false;
                }
                if (i3 < 0 && Math.abs(i3) > h16) {
                    return false;
                }
            }
            if (this.publicUserSampling > 0.0f && Math.random() < this.publicUserSampling) {
                return true;
            }
            return false;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
                return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
            }
            return this.backgroundCheckInterval;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
            }
            return this.backgroundCheckTime;
        }

        public final float d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return ((Float) iPatchRedirector.redirect((short) 32, (Object) this)).floatValue();
            }
            return this.ceilingJHeapThreshold;
        }

        public final float e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return ((Float) iPatchRedirector.redirect((short) 34, (Object) this)).floatValue();
            }
            return this.ceilingMaxPss;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
            }
            return this.ceilingReportLimit;
        }

        public final float g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return ((Float) iPatchRedirector.redirect((short) 30, (Object) this)).floatValue();
            }
            return this.ceilingSampleRatio;
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.dailyLimit;
        }

        public final float i(int reportCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
                return ((Float) iPatchRedirector.redirect((short) 44, (Object) this, reportCount)).floatValue();
            }
            if (reportCount >= 1) {
                return this.secondReportMaxPss;
            }
            return this.maxPss;
        }

        public final int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.maxRequiredDalvikMemory;
        }

        public final int k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.maxRequiredMemory;
        }

        public final float l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
            }
            return this.maxUsedRatio;
        }

        public final int m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
                return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
            }
            return this.memoryDumpMinInterval;
        }

        public final int n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
            }
            return this.noLimitTimePeriod;
        }

        @NotNull
        public final List<String> o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (List) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return this.noLimitWhiteList;
        }

        public final int p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.processLimit;
        }

        @NotNull
        public final List<String> q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (List) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.whiteSceneList;
        }

        public final void r(@NotNull Map<String, String> dataSetMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
                iPatchRedirector.redirect((short) 42, (Object) this, (Object) dataSetMap);
                return;
            }
            Intrinsics.checkNotNullParameter(dataSetMap, "dataSetMap");
            a aVar = a.f257676a;
            this.maxPss = aVar.g(dataSetMap, "main_max_pss", 1572864.0f);
            this.secondReportMaxPss = aVar.g(dataSetMap, "second_report_main_max_pss", 1572864.0f);
            this.dailyLimit = aVar.h(dataSetMap, "main_daily_count", 5);
            this.processLimit = aVar.h(dataSetMap, "main_process_count", 2);
            this.maxUsedRatio = aVar.g(dataSetMap, "main_remain_percent", 0.9f);
            this.maxRequiredDalvikMemory = aVar.h(dataSetMap, "max_req_java_mem", 15360);
            this.maxRequiredMemory = aVar.h(dataSetMap, "max_req_mem", RFixConstants.MD5_FILE_BUF_LENGTH);
            this.whiteSceneList = a.j(aVar, dataSetMap, "scene_white_list", null, 4, null);
            this.publicUserWhiteList = a.j(aVar, dataSetMap, "dialog_white_list", null, 4, null);
            this.publicUserSampling = aVar.g(dataSetMap, "dialog_sampling_v1", 0.0f);
            this.noLimitWhiteList = aVar.i(dataSetMap, "no_limit_white_list", a.DEFAULT_NO_LIMIT_WHITE_LIST);
            this.noLimitTimePeriod = aVar.h(dataSetMap, "no_limit_time_period", 3600000);
            this.onlyWifiReport = aVar.f(dataSetMap, "only_wifi", true);
            this.processLiveTimeLimit = aVar.h(dataSetMap, "process_live_time", 0);
            this.ceilingReportLimit = aVar.h(dataSetMap, "ceiling_daily_report_limit", 2);
            this.ceilingSampleRatio = aVar.g(dataSetMap, "ceiling_sample_ratio", 1.0f);
            this.ceilingJHeapThreshold = aVar.g(dataSetMap, "ceiling_jheap_threshold", 0.9f);
            this.ceilingMaxPss = aVar.g(dataSetMap, "ceiling_pss_max_value", 1572864.0f);
            this.backgroundCheckTime = aVar.h(dataSetMap, "background_check_time", 1800000);
            this.backgroundCheckInterval = aVar.h(dataSetMap, "background_check_interval", 60000);
            this.memoryDumpMinInterval = aVar.h(dataSetMap, "memory_dump_min_interval", 180000);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
                return (String) iPatchRedirector.redirect((short) 43, (Object) this);
            }
            return "maxPss: " + this.maxPss + ", secondReportMaxPss: " + this.secondReportMaxPss + ", dailyLimit: " + this.dailyLimit + ", processLimit: " + this.processLimit + ", maxUsedRatio: " + this.maxUsedRatio + ", maxRequiredDalvikMemory: " + this.maxRequiredDalvikMemory + ", maxRequiredMemory: " + this.maxRequiredMemory + ", whiteSceneList: " + this.whiteSceneList + ", publicUserSampling: " + this.publicUserSampling + ", noLimitTimePeriod: " + this.noLimitTimePeriod + ", onlyWifiReport: " + this.onlyWifiReport + ", processLiveTimeLimit: " + this.processLiveTimeLimit + ", ceilingReportLimit: " + this.ceilingReportLimit + ", ceilingSampleRatio: " + this.ceilingSampleRatio + ", ceilingJHeapThreshold: " + this.ceilingJHeapThreshold + ", ceilingMaxPss: " + this.ceilingMaxPss + ", backgroundCheckTime: " + this.backgroundCheckTime + ", backgroundCheckInterval: " + this.backgroundCheckInterval + ", memoryDumpMinInterval: " + this.memoryDumpMinInterval + ", ";
        }
    }

    static {
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30245);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f257676a = new a();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"289717882", "306392284"});
        DEFAULT_NO_LIMIT_WHITE_LIST = listOf;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(Map<String, String> dataSetMap, String key, boolean defaultValue) {
        boolean z16;
        String str = dataSetMap.get(key);
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                str = null;
            }
            if (str != null) {
                return str.equals("true");
            }
            return defaultValue;
        }
        return defaultValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float g(Map<String, String> dataSetMap, String key, float defaultValue) {
        boolean z16;
        String str = dataSetMap.get(key);
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                str = null;
            }
            if (str != null) {
                return Float.parseFloat(str);
            }
            return defaultValue;
        }
        return defaultValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h(Map<String, String> dataSetMap, String key, int defaultValue) {
        boolean z16;
        String str = dataSetMap.get(key);
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                str = null;
            }
            if (str != null) {
                return Integer.parseInt(str);
            }
            return defaultValue;
        }
        return defaultValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        r7 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r0, new java.lang.String[]{";"}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<String> i(Map<String, String> dataSetMap, String key, List<String> defaultList) {
        boolean z16;
        List<String> split$default;
        String str = dataSetMap.get(key);
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                str = null;
            }
            String str2 = str;
            if (str2 != null && split$default != null) {
                return split$default;
            }
            return defaultList;
        }
        return defaultList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List j(a aVar, Map map, String str, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return aVar.i(map, str, list);
    }

    private final boolean o() {
        if (AppSetting.isDebugVersion()) {
            return false;
        }
        if (!Intrinsics.areEqual(MobileQQ.processName, MobileQQ.PACKAGE_NAME)) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "MemoryFaultMonitor", "isEnabled false, not main process", false, null, 12, null);
            return false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("memory_fault_monitor", false);
        if (!isSwitchOn) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "MemoryFaultMonitor", "isEnabled false, feature switch is false", false, null, 12, null);
        }
        return isSwitchOn;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        C8201a n3 = n();
        if (n3 != null) {
            return n3.m();
        }
        return 180000;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        C8201a n3 = n();
        if (n3 != null) {
            return n3.j();
        }
        return 15360;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        C8201a n3 = n();
        if (n3 != null) {
            return n3.k();
        }
        return RFixConstants.MD5_FILE_BUF_LENGTH;
    }

    @Nullable
    public final C8201a n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (C8201a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        C8201a c8201a = config;
        if (c8201a != null) {
            return c8201a;
        }
        if (!o()) {
            return null;
        }
        try {
            HashMap<String, String> c16 = g.c(new JSONObject(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("memory_fault_monitor", "")));
            C8201a c8201a2 = new C8201a();
            c8201a2.r(c16);
            config = c8201a2;
            QLog.d("MemoryFaultMonitor", 1, "init config, " + config);
            return config;
        } catch (Throwable th5) {
            QLog.e("MemoryFaultMonitor", 1, th5, new Object[0]);
            return null;
        }
    }

    public final boolean p() {
        List<String> o16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        C8201a n3 = n();
        if (n3 != null && (o16 = n3.o()) != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            if (str == null) {
                str = "null";
            }
            return o16.contains(str);
        }
        return false;
    }
}
