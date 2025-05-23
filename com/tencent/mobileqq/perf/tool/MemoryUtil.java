package com.tencent.mobileqq.perf.tool;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.provider.Settings;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.theme.SkinEngine;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002\u00a2\u0006\u0004\b*\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0003J\b\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u000f\u0010\u0011\u001a\u00020\u0010H\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u0016J\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\tR\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0016\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u001b\u0010$\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010!\u001a\u0004\b%\u0010#R\u001b\u0010)\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/perf/tool/MemoryUtil;", "", "", "pid", "Landroid/os/Debug$MemoryInfo;", "l", "c", "Landroid/content/Context;", "context", "", "i", "", "k", "Lcom/tencent/mobileqq/perf/tool/MemoryUtil$a;", DomainData.DOMAIN_NAME, "d", "", "b", "()V", "j", "(I)Landroid/os/Debug$MemoryInfo;", "p", "", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", tl.h.F, "f", "J", "lastGetPssTimeStamp", "Landroid/os/Debug$MemoryInfo;", "lastMemInfo", "MIN_INTERVAL_FOR_GET_MEM_INFO", "Lkotlin/Lazy;", "o", "()J", "throttleTime", "r", "totalSystemMemSpace", "g", "()I", "machineMemSpaceLevel", "<init>", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MemoryUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MemoryUtil f258173a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastGetPssTimeStamp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Debug.MemoryInfo lastMemInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static long MIN_INTERVAL_FOR_GET_MEM_INFO;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy throttleTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy totalSystemMemSpace;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy machineMemSpaceLevel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b!\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\"\u0010\u001e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\"\u0010&\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\r\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/perf/tool/MemoryUtil$a;", "", "", "strStatm", "", "a", "(Ljava/lang/String;)V", "toString", "", "J", "getVmSize", "()J", "setVmSize", "(J)V", "vmSize", "b", "getResidentSize", "setResidentSize", "residentSize", "c", "getShareSize", "setShareSize", "shareSize", "d", "getTextSize", "setTextSize", "textSize", "e", "getLibSize", "setLibSize", "libSize", "f", "getDataSize", "setDataSize", "dataSize", "g", "getDirtySize", "setDirtySize", "dirtySize", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long vmSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long residentSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long shareSize;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long textSize;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long libSize;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long dataSize;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private long dirtySize;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final void a(@NotNull String strStatm) {
            List split$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, (Object) strStatm);
                return;
            }
            Intrinsics.checkNotNullParameter(strStatm, "strStatm");
            try {
                split$default = StringsKt__StringsKt.split$default((CharSequence) strStatm, new String[]{" "}, false, 0, 6, (Object) null);
                if (split$default.size() >= 7) {
                    com.tencent.mobileqq.perf.memory.gc.a aVar = com.tencent.mobileqq.perf.memory.gc.a.f257735a;
                    long i3 = aVar.i((String) split$default.get(0));
                    this.vmSize = i3;
                    if (i3 > 0) {
                        this.vmSize = i3 * k.f258207a;
                    }
                    long i16 = aVar.i((String) split$default.get(1));
                    this.residentSize = i16;
                    if (i16 > 0) {
                        this.residentSize = i16 * k.f258207a;
                    }
                    long i17 = aVar.i((String) split$default.get(2));
                    this.shareSize = i17;
                    if (i17 > 0) {
                        this.shareSize = i17 * k.f258207a;
                    }
                    long i18 = aVar.i((String) split$default.get(3));
                    this.textSize = i18;
                    if (i18 > 0) {
                        this.textSize = i18 * k.f258207a;
                    }
                    long i19 = aVar.i((String) split$default.get(4));
                    this.libSize = i19;
                    if (i19 > 0) {
                        this.libSize = i19 * k.f258207a;
                    }
                    long i26 = aVar.i((String) split$default.get(5));
                    this.dataSize = i26;
                    if (i26 > 0) {
                        this.dataSize = i26 * k.f258207a;
                    }
                    long i27 = aVar.i((String) split$default.get(6));
                    this.dirtySize = i27;
                    if (i27 > 0) {
                        this.dirtySize = i27 * k.f258207a;
                    }
                }
            } catch (Throwable th5) {
                QLog.e("ME", 1, "initByStatMString failed.", th5);
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(super.toString());
            sb5.append(" vmSize=" + this.vmSize);
            sb5.append(" residentSize=" + this.residentSize);
            sb5.append(" shareSize=" + this.shareSize);
            sb5.append(" textSize=" + this.textSize);
            sb5.append(" libSize=" + this.libSize);
            sb5.append(" dataSize=" + this.dataSize);
            sb5.append(" dirtySize=" + this.dirtySize);
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            return sb6;
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45012);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f258173a = new MemoryUtil();
        MIN_INTERVAL_FOR_GET_MEM_INFO = 10000L;
        lazy = LazyKt__LazyJVMKt.lazy(MemoryUtil$throttleTime$2.INSTANCE);
        throttleTime = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(MemoryUtil$totalSystemMemSpace$2.INSTANCE);
        totalSystemMemSpace = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(MemoryUtil$machineMemSpaceLevel$2.INSTANCE);
        machineMemSpaceLevel = lazy3;
    }

    MemoryUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b() {
        String d16 = f258173a.d();
        a n3 = n();
        QLog.i("testDebugMemoryInfoLog", 1, d16);
        QLog.i("testKernelMemoryInfoLog", 1, n3.toString());
    }

    private final Debug.MemoryInfo c() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    private final String d() {
        Debug.MemoryInfo c16 = c();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c16.toString());
        sb5.append(" totalPss=" + c16.getTotalPss());
        sb5.append(" dalvikPss=" + c16.dalvikPss);
        sb5.append(" nativePss=" + c16.nativePss);
        sb5.append(" otherPss=" + c16.otherPss);
        sb5.append(" totalSwappablePss=" + c16.getTotalSwappablePss());
        sb5.append(" totalSharedDirty=" + c16.getTotalSharedDirty());
        sb5.append(" dalvikSharedDirty=" + c16.dalvikSharedDirty);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(17)
    public final long i(Context context) {
        MatchResult find$default;
        String string = Settings.Global.getString(context.getContentResolver(), "activity_manager_constants");
        if (string == null || (find$default = Regex.find$default(new Regex("memory_info_throttle_time=\\d*"), string, 0, 2, null)) == null || !(!find$default.getGroupValues().isEmpty())) {
            return MiniBoxNoticeInfo.MIN_5;
        }
        String str = find$default.getGroupValues().get(0);
        com.tencent.mobileqq.perf.log.a.a("ME", "get memory_info_throttle_time, is " + str);
        String substring = str.substring(26, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        try {
            return Long.parseLong(substring);
        } catch (NumberFormatException unused) {
            return MiniBoxNoticeInfo.MIN_5;
        }
    }

    @JvmStatic
    @NotNull
    public static final String k() {
        long j3;
        long c16;
        long X;
        Debug.MemoryInfo[] processMemoryInfo;
        float f16;
        boolean z16;
        StringBuilder sb5 = new StringBuilder("RAM Info:all=");
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern("0.0");
        try {
            j3 = 1024;
            c16 = (m.c() / j3) / j3;
            X = (ah.X() / j3) / j3;
            Object systemService = BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) systemService, new int[]{Process.myPid()});
        } catch (Throwable unused) {
        }
        if (processMemoryInfo != null) {
            if (processMemoryInfo.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (true ^ z16) {
                f16 = processMemoryInfo[0].getTotalPss() / 1024;
                float f17 = 1024;
                float freeMemory = (((float) Runtime.getRuntime().freeMemory()) / f17) / f17;
                float f18 = (((float) Runtime.getRuntime().totalMemory()) / f17) / f17;
                float maxMemory = (((float) Runtime.getRuntime().maxMemory()) / f17) / f17;
                long j16 = (com.tencent.qqperf.opt.vm.a.f363350c / j3) / j3;
                sb5.append(c16);
                sb5.append("M,avaiable:");
                sb5.append(X);
                sb5.append("M used:");
                sb5.append(decimalFormat.format(f16));
                sb5.append("M freeMemory:");
                sb5.append(freeMemory);
                sb5.append("M,appTotalMemory:");
                sb5.append(f18);
                sb5.append("M,orgMaxMemory:");
                sb5.append(j16);
                sb5.append("M,maxMemory:");
                sb5.append(maxMemory);
                sb5.append("M, ImgCache:");
                sb5.append((com.tencent.cache.core.manager.api.c.f98725d.g() / j3) / j3);
                sb5.append("M,SkinCache:");
                sb5.append((SkinEngine.dumpDrawableCacheMemSize() / j3) / j3);
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "strMemory.toString()");
                return sb6;
            }
        }
        f16 = -1.0f;
        float f172 = 1024;
        float freeMemory2 = (((float) Runtime.getRuntime().freeMemory()) / f172) / f172;
        float f182 = (((float) Runtime.getRuntime().totalMemory()) / f172) / f172;
        float maxMemory2 = (((float) Runtime.getRuntime().maxMemory()) / f172) / f172;
        long j162 = (com.tencent.qqperf.opt.vm.a.f363350c / j3) / j3;
        sb5.append(c16);
        sb5.append("M,avaiable:");
        sb5.append(X);
        sb5.append("M used:");
        sb5.append(decimalFormat.format(f16));
        sb5.append("M freeMemory:");
        sb5.append(freeMemory2);
        sb5.append("M,appTotalMemory:");
        sb5.append(f182);
        sb5.append("M,orgMaxMemory:");
        sb5.append(j162);
        sb5.append("M,maxMemory:");
        sb5.append(maxMemory2);
        sb5.append("M, ImgCache:");
        sb5.append((com.tencent.cache.core.manager.api.c.f98725d.g() / j3) / j3);
        sb5.append("M,SkinCache:");
        sb5.append((SkinEngine.dumpDrawableCacheMemSize() / j3) / j3);
        String sb62 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb62, "strMemory.toString()");
        return sb62;
    }

    @JvmStatic
    @NotNull
    public static final Debug.MemoryInfo l(int pid) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = lastGetPssTimeStamp;
        if (j3 == 0 || currentTimeMillis - j3 > MIN_INTERVAL_FOR_GET_MEM_INFO) {
            lastMemInfo = f258173a.j(pid);
            lastGetPssTimeStamp = currentTimeMillis;
        }
        Debug.MemoryInfo memoryInfo = lastMemInfo;
        if (memoryInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastMemInfo");
            return null;
        }
        return memoryInfo;
    }

    public static /* synthetic */ Debug.MemoryInfo m(int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = Process.myPid();
        }
        return l(i3);
    }

    @JvmStatic
    @NotNull
    public static final a n() {
        a aVar = new a();
        ArrayList<String> a16 = k.a(Process.myPid(), "statm");
        if (a16 != null && a16.size() > 0) {
            String str = a16.get(0);
            Intrinsics.checkNotNullExpressionValue(str, "data[0]");
            aVar.a(str);
        }
        return aVar;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return Runtime.getRuntime().freeMemory();
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return q() - e();
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return ((Number) machineMemSpaceLevel.getValue()).intValue();
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return Runtime.getRuntime().maxMemory();
    }

    @NotNull
    public final Debug.MemoryInfo j(int pid) {
        Debug.MemoryInfo p16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Debug.MemoryInfo) iPatchRedirector.redirect((short) 5, (Object) this, pid);
        }
        if (Build.VERSION.SDK_INT > 28 && pid == Process.myPid()) {
            p16 = c();
        } else {
            p16 = p(pid);
        }
        com.tencent.mobileqq.perf.log.a.a("ME", "process:" + pid + " pss is " + p16.getTotalPss() + ", nativePss is " + p16.nativePss);
        return p16;
    }

    public final long o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return ((Number) throttleTime.getValue()).longValue();
    }

    @NotNull
    public final Debug.MemoryInfo p(int pid) {
        Debug.MemoryInfo[] memoryInfoArr;
        boolean z16;
        Debug.MemoryInfo memoryInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Debug.MemoryInfo) iPatchRedirector.redirect((short) 6, (Object) this, pid);
        }
        Object systemService = BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        try {
            memoryInfoArr = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) systemService, new int[]{pid});
        } catch (Exception e16) {
            QLog.e("ME", 1, e16, new Object[0]);
            memoryInfoArr = null;
        }
        if (memoryInfoArr != null) {
            if (memoryInfoArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && (memoryInfo = memoryInfoArr[0]) != null) {
                return memoryInfo;
            }
        }
        QLog.e("ME", 1, "getThrottledMemoryInfo get memInfo failed.");
        return new Debug.MemoryInfo();
    }

    public final long q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return Runtime.getRuntime().totalMemory();
    }

    public final long r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return ((Number) totalSystemMemSpace.getValue()).longValue();
    }

    @NotNull
    public final Map<String, Debug.MemoryInfo> s() {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Object systemService = BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        ArrayList arrayList = null;
        if (runningAppProcesses != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : runningAppProcesses) {
                String str = ((ActivityManager.RunningAppProcessInfo) obj).processName;
                Intrinsics.checkNotNullExpressionValue(str, "it.processName");
                String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
                Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, PACKAGE_NAME, false, 2, null);
                if (startsWith$default) {
                    arrayList2.add(obj);
                }
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault2);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add((ActivityManager.RunningAppProcessInfo) it.next());
            }
        }
        if (arrayList != null) {
            ArrayList<ActivityManager.RunningAppProcessInfo> arrayList3 = arrayList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList3) {
                Pair pair = TuplesKt.to(runningAppProcessInfo.processName, f258173a.p(runningAppProcessInfo.pid));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
        return new HashMap();
    }
}
