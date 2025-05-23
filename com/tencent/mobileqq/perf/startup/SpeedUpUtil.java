package com.tencent.mobileqq.perf.startup;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.perf.startup.SpeedUpUtil;
import com.tencent.mobileqq.perf.tool.AppInfoUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002@AB\t\b\u0002\u00a2\u0006\u0004\b?\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0007J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\bH\u0002R\u001b\u0010,\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00103\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b8G@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010+R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00105R\u001a\u0010;\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b9\u0010:\u001a\u0004\b7\u00108R\u001a\u0010>\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b=\u0010:\u001a\u0004\b<\u00108\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/perf/startup/SpeedUpUtil;", "", "", "t", "u", "v", "", "mmkvKey", "", "count", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, h.F, "time", "G", DomainData.DOMAIN_NAME, "", "status", "E", "default", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "expect", UserInfo.SEX_FEMALE, "D", "Lcom/tencent/mobileqq/perf/startup/SpeedUpUtil$a;", "dex2oatCallback", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, DownloadInfo.spKey_Config, "", "delayTime", "e", "r", ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Conn, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/perf/startup/SpeedUpUtil$LaunchType;", "type", "w", "l", "b", "Lkotlin/Lazy;", "i", "()I", "DEX2OAT_COST_THRESHOLD", "c", "Lcom/tencent/mobileqq/perf/startup/SpeedUpUtil$a;", "<set-?>", "d", "I", "j", "dex2oatProcess", "Landroid/os/Handler;", "Landroid/os/Handler;", "dex2oatTimer", "o", "()Z", "isCompiled$annotations", "()V", "isCompiled", "p", "isCompiledErrorTooMuch$annotations", "isCompiledErrorTooMuch", "<init>", "a", "LaunchType", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SpeedUpUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SpeedUpUtil f258026a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy DEX2OAT_COST_THRESHOLD;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a dex2oatCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int dex2oatProcess;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Handler dex2oatTimer;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/perf/startup/SpeedUpUtil$LaunchType;", "", "(Ljava/lang/String;I)V", "FIRST_LAUNCH", "FIRST_NO_OAT_LAUNCH", "NO_OAT_LAUNCH", "FIRST_OAT_LAUNCH", "RE_OAT_LAUNCH", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class LaunchType {
        private static final /* synthetic */ LaunchType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final LaunchType FIRST_LAUNCH;
        public static final LaunchType FIRST_NO_OAT_LAUNCH;
        public static final LaunchType FIRST_OAT_LAUNCH;
        public static final LaunchType NO_OAT_LAUNCH;
        public static final LaunchType RE_OAT_LAUNCH;

        private static final /* synthetic */ LaunchType[] $values() {
            return new LaunchType[]{FIRST_LAUNCH, FIRST_NO_OAT_LAUNCH, NO_OAT_LAUNCH, FIRST_OAT_LAUNCH, RE_OAT_LAUNCH};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44196);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            FIRST_LAUNCH = new LaunchType("FIRST_LAUNCH", 0);
            FIRST_NO_OAT_LAUNCH = new LaunchType("FIRST_NO_OAT_LAUNCH", 1);
            NO_OAT_LAUNCH = new LaunchType("NO_OAT_LAUNCH", 2);
            FIRST_OAT_LAUNCH = new LaunchType("FIRST_OAT_LAUNCH", 3);
            RE_OAT_LAUNCH = new LaunchType("RE_OAT_LAUNCH", 4);
            $VALUES = $values();
        }

        LaunchType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static LaunchType valueOf(String str) {
            return (LaunchType) Enum.valueOf(LaunchType.class, str);
        }

        public static LaunchType[] values() {
            return (LaunchType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/perf/startup/SpeedUpUtil$a;", "", "", "process", "", "a", "", QCircleWeakNetReporter.KEY_COST, "onSuccess", "onFailed", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(int process);

        void onFailed();

        void onSuccess(long cost);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/perf/startup/SpeedUpUtil$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends Handler {
        static IPatchRedirector $redirector_;

        b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (SpeedUpUtil.j() < 99) {
                SpeedUpUtil.dex2oatProcess = SpeedUpUtil.j() + 1;
            }
            a aVar = SpeedUpUtil.dex2oatCallback;
            if (aVar != null) {
                aVar.a(SpeedUpUtil.j());
            }
            sendEmptyMessageDelayed(0, 1000L);
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44198);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f258026a = new SpeedUpUtil();
        lazy = LazyKt__LazyJVMKt.lazy(SpeedUpUtil$DEX2OAT_COST_THRESHOLD$2.INSTANCE);
        DEX2OAT_COST_THRESHOLD = lazy;
        dex2oatTimer = new b(Looper.getMainLooper());
    }

    SpeedUpUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void A(String mmkvKey, int count) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeInt(mmkvKey, from.decodeInt(mmkvKey, 0) + count);
    }

    static /* synthetic */ void B(SpeedUpUtil speedUpUtil, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        speedUpUtil.A(str, i3);
    }

    private final void C() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putInt("version_dex2oat_count", fromV2.getInt("version_dex2oat_count", 0) + 1);
        fromV2.putLong("last_dex2oat_time", System.currentTimeMillis());
    }

    private final void D() {
        boolean z16 = false;
        B(this, "version_start_count", 0, 2, null);
        if (com.tencent.mobileqq.automator.a.f199911b && F("version_has_report_first_launch", false)) {
            if (Math.random() < 0.005d) {
                z16 = true;
            }
            E("is_need_report_in_public", z16);
            w(LaunchType.FIRST_LAUNCH);
            return;
        }
        if (com.tencent.mobileqq.startup.a.f289673n > i()) {
            B(this, "version_no_oat_start_count", 0, 2, null);
            E("is_last_launch_in_no_oat", true);
            if (F("version_has_report_no_oat", false)) {
                w(LaunchType.FIRST_NO_OAT_LAUNCH);
                H(this, "version_report_time_no_oat", null, 2, null);
                return;
            }
            w(LaunchType.NO_OAT_LAUNCH);
            QLog.i("SpeedUpUtil", 2, "is not first no oat launch. first report on " + n("version_report_time_no_oat"));
            return;
        }
        if (F("version_has_report_oat_suc", false)) {
            w(LaunchType.FIRST_OAT_LAUNCH);
            H(this, "version_report_time_oat_suc", null, 2, null);
        } else {
            if (F("is_last_launch_in_no_oat", true)) {
                w(LaunchType.RE_OAT_LAUNCH);
                return;
            }
            QLog.i("SpeedUpUtil", 2, "is not first oat launch. not report. first report on " + n("version_report_time_oat_suc"));
        }
    }

    private final void E(String mmkvKey, boolean status) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool(mmkvKey, status);
    }

    private final boolean F(String mmkvKey, boolean expect) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (from.decodeBool(mmkvKey, expect) == expect) {
            from.encodeBool(mmkvKey, !expect);
            return true;
        }
        return false;
    }

    private final void G(String mmkvKey, String time) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString(mmkvKey, time);
    }

    static /* synthetic */ void H(SpeedUpUtil speedUpUtil, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = new Date().toString();
            Intrinsics.checkNotNullExpressionValue(str2, "Date().toString()");
        }
        speedUpUtil.G(str, str2);
    }

    @JvmStatic
    public static final void e(@NotNull final String config, long delayTime) {
        Intrinsics.checkNotNullParameter(config, "config");
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.perf.startup.c
            @Override // java.lang.Runnable
            public final void run() {
                SpeedUpUtil.g(config);
            }
        }, 16, null, false, delayTime);
    }

    public static /* synthetic */ void f(String str, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 30000;
        }
        e(str, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String config) {
        SpeedUpUtil speedUpUtil;
        boolean equals;
        String str;
        Intrinsics.checkNotNullParameter(config, "$config");
        dex2oatProcess = 0;
        dex2oatTimer.sendEmptyMessageDelayed(0, 1000L);
        try {
            try {
                try {
                    equals = StringsKt__StringsJVMKt.equals(Build.BRAND, "oppo", true);
                    if (equals && Build.VERSION.SDK_INT >= 29) {
                        str = "pm bg-dexopt-job com.tencent.mobileqq";
                    } else {
                        str = "cmd package compile -m " + config + " -f com.tencent.mobileqq";
                    }
                    QLog.i("SpeedUpUtil", 1, "\u6b63\u5728\u6267\u884c dex2oat");
                    long currentTimeMillis = System.currentTimeMillis();
                    Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), str);
                    com.tencent.mobileqq.perf.terrible.d.f258073a.a(1.0d, "dex2oat_trigger");
                    StringBuilder sb5 = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    String str2 = "";
                    boolean z16 = false;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                Intrinsics.checkNotNullExpressionValue(readLine, "readLine()");
                                str2 = readLine;
                            } else {
                                readLine = null;
                            }
                            if (readLine == null) {
                                break;
                            }
                            sb5.append(str2);
                            sb5.append("\r\n");
                            if (Intrinsics.areEqual(str2, "Success")) {
                                z16 = true;
                            }
                        } finally {
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, null);
                    exec.waitFor();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (z16) {
                        com.tencent.mobileqq.perf.terrible.d.f258073a.a(currentTimeMillis2, "dex2oat_cost");
                        a aVar = dex2oatCallback;
                        if (aVar != null) {
                            aVar.onSuccess(currentTimeMillis2);
                        }
                        QLog.i("SpeedUpUtil", 1, "dex2oat success. cost: " + currentTimeMillis2 + '.');
                        f258026a.u();
                    } else {
                        QLog.i("SpeedUpUtil", 1, "dex2oat error. cost: " + currentTimeMillis2 + ". error msg: " + ((Object) sb5));
                        f258026a.v();
                        a aVar2 = dex2oatCallback;
                        if (aVar2 != null) {
                            aVar2.onFailed();
                        }
                    }
                    speedUpUtil = f258026a;
                } catch (IOException e16) {
                    QLog.e("SpeedUpUtil", 1, "dex2oat trigger error.", e16);
                    speedUpUtil = f258026a;
                    speedUpUtil.v();
                    a aVar3 = dex2oatCallback;
                    if (aVar3 != null) {
                        aVar3.onFailed();
                    }
                }
            } catch (InterruptedException e17) {
                QLog.e("SpeedUpUtil", 1, "dex2oat trigger error.", e17);
                speedUpUtil = f258026a;
                speedUpUtil.v();
                a aVar4 = dex2oatCallback;
                if (aVar4 != null) {
                    aVar4.onFailed();
                }
            }
            speedUpUtil.C();
            dex2oatTimer.removeMessages(0);
            dex2oatProcess = 0;
        } catch (Throwable th5) {
            f258026a.C();
            throw th5;
        }
    }

    private final int h(String mmkvKey) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeInt(mmkvKey, -1);
    }

    private final int i() {
        return ((Number) DEX2OAT_COST_THRESHOLD.getValue()).intValue();
    }

    @JvmStatic
    public static final int j() {
        return dex2oatProcess;
    }

    private final long k() {
        try {
            PackageManager packageManager = BaseApplication.getContext().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getContext().packageManager");
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, BaseApplication.getContext().getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "packageManager.getPackag\u2026Context().packageName, 0)");
            long j3 = packageInfo.lastUpdateTime;
            QLog.i("SpeedUpUtil", 2, "last update time :" + j3);
            return System.currentTimeMillis() - j3;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return -1L;
        }
    }

    private final int l() {
        List listOf;
        String str = new File(BaseApplication.getContext().getPackageCodePath()).getParent() + "/oat/arm64/";
        File file = new File(str);
        boolean exists = file.exists();
        boolean canRead = file.canRead();
        QLog.i("SpeedUpUtil", 1, "Oat targetDir exist:" + exists + ", canRead:" + canRead + ", path:" + str);
        int i3 = 0;
        if (exists && file.isDirectory()) {
            if (!canRead) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"vdex", "odex", "art"});
                Iterator it = listOf.iterator();
                while (it.hasNext()) {
                    File file2 = new File(file + "/base." + ((String) it.next()));
                    QLog.i("SpeedUpUtil", 1, "OatFile:" + file2.getName() + ", exist:" + file2.exists() + ", canRead:" + file2.canRead() + ", fileSize:" + (file2.length() / 1024) + "kb");
                    if (file2.exists()) {
                        i3++;
                    }
                }
                return i3;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0;
            }
            int length = listFiles.length;
            int i16 = 0;
            while (i3 < length) {
                File file3 = listFiles[i3];
                int i17 = i16 + 1;
                QLog.i("SpeedUpUtil", 1, "OatFile_" + i17 + ':' + file3.getName() + ", exist:" + file3.exists() + ", canRead:" + file3.canRead() + ", fileSize:" + (file3.length() / 1024) + "kb");
                i3++;
                i16 = i17;
            }
            return i16;
        }
        QLog.d("SpeedUpUtil", 1, "TargetDir does not exist or is not a directory.");
        return 0;
    }

    private final boolean m(String mmkvKey, boolean r46) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool(mmkvKey, r46);
    }

    private final String n(String mmkvKey) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString(mmkvKey, "no record.");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(mmkvKey, \"no record.\")");
        return decodeString;
    }

    public static final boolean o() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("has_force_compiled", false);
    }

    public static final boolean p() {
        boolean z16 = false;
        if (QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt("compiled_error_times", 0) > 3) {
            z16 = true;
        }
        if (z16) {
            QLog.e("SpeedUpUtil", 1, "dex2oat tooMuch Error.");
        }
        return z16;
    }

    private final boolean q() {
        return m("is_need_report_in_public", false);
    }

    private final boolean r() {
        if (AppInfoUtil.f258158a.a()) {
            QLog.e("SpeedUpUtil", 1, "notNeedEffect. because of debug version.");
            return true;
        }
        QQPerfConfigLoader qQPerfConfigLoader = QQPerfConfigLoader.f257603a;
        if (!qQPerfConfigLoader.b().c().c()) {
            QLog.e("SpeedUpUtil", 1, "notNeedEffect. because of switch false.");
            return true;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= qQPerfConfigLoader.b().c().b() && i3 <= qQPerfConfigLoader.b().c().a()) {
            if (!com.tencent.qqperf.tools.d.f363413a.c()) {
                QLog.e("SpeedUpUtil", 1, "notNeedEffect. appSysLaunch[" + com.tencent.mobileqq.startup.a.f289673n + "] not exceed.");
                return true;
            }
            if (p()) {
                QLog.e("SpeedUpUtil", 1, "notNeedEffect. because of isCompiledErrorTooMuch.");
                return true;
            }
            if (!s()) {
                QLog.e("SpeedUpUtil", 1, "notNeedEffect. because of not within version update valid time range.");
                return true;
            }
            return false;
        }
        QLog.e("SpeedUpUtil", 1, "notNeedEffect. because of error sdk int: " + i3 + '.');
        return true;
    }

    private final boolean s() {
        if (com.tencent.mobileqq.startup.a.f289673n > 8000) {
            return true;
        }
        int i3 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getInt("version_dex2oat_count", 0);
        long j3 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getLong("last_dex2oat_time", 0L);
        if (QLog.isColorLevel()) {
            QLog.d("SpeedUpUtil", 2, "versionOatCount:" + i3 + ", lastDex2oatTime:" + j3);
        }
        if (i3 <= 3 && System.currentTimeMillis() - j3 >= 3600000) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void t() {
        if (MobileQQ.sProcessId != 1) {
            QLog.d("SpeedUpUtil", 4, "not main process, break.");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpeedUpUtil", 2, "onCurrentVersionFirstLaunch, removeMMKVRecord");
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.removeKey("has_force_compiled");
        from.removeKey("compiled_error_times");
        from.removeKey("version_start_count");
        from.removeKey("version_no_oat_start_count");
        from.removeKey("version_has_report_no_oat");
        from.removeKey("version_has_report_oat_suc");
        from.removeKey("is_need_report_in_public");
        from.removeKey("version_dex2oat_count");
        from.removeKey("last_dex2oat_time");
    }

    private final void u() {
        if (QLog.isColorLevel()) {
            QLog.d("SpeedUpUtil", 2, "recordComplete");
        }
        E("has_force_compiled", true);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeInt("compiled_error_times", 0);
    }

    private final void v() {
        if (QLog.isColorLevel()) {
            QLog.d("SpeedUpUtil", 2, "recordCompleteError");
        }
        com.tencent.mobileqq.perf.terrible.d.f258073a.a(1.0d, "dex2oat_trigger_failed");
        B(this, "compiled_error_times", 0, 2, null);
    }

    private final void w(final LaunchType type) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.startup.d
            @Override // java.lang.Runnable
            public final void run() {
                SpeedUpUtil.x(SpeedUpUtil.LaunchType.this);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(LaunchType type) {
        String str;
        SimpleAccount firstSimpleAccount;
        Intrinsics.checkNotNullParameter(type, "$type");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("launch_type", type.name());
        SpeedUpUtil speedUpUtil = f258026a;
        hashMap.put("duration_of_app_update", String.valueOf(speedUpUtil.k()));
        hashMap.put("launch_count", String.valueOf(speedUpUtil.h("version_start_count")));
        hashMap.put("no_oat_launch_count", String.valueOf(speedUpUtil.h("version_no_oat_start_count")));
        hashMap.put("sys_launch_cost", String.valueOf(com.tencent.mobileqq.startup.a.f289673n));
        QLog.i("SpeedUpUtil", 1, "ready to report dex2oatStatus: " + hashMap);
        if (AppSetting.isPublicVersion() && !AppSetting.isGrayVersion() && !speedUpUtil.q()) {
            QLog.i("SpeedUpUtil", 1, "not hit sample.");
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (firstSimpleAccount = mobileQQ.getFirstSimpleAccount()) != null) {
            str = firstSimpleAccount.getUin();
        } else {
            str = null;
        }
        hashMap.put("real_uin", String.valueOf(str));
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103034", false)) {
            hashMap.put("oat_file_count", String.valueOf(speedUpUtil.l()));
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "dex2oat_status", true, 0L, 0L, hashMap, "");
    }

    @JvmStatic
    public static final void y(@Nullable a dex2oatCallback2) {
        dex2oatCallback = dex2oatCallback2;
    }

    @JvmStatic
    @JvmOverloads
    public static final void z() {
        if (!AppInfoUtil.f258158a.a()) {
            f258026a.D();
        }
        if (f258026a.r()) {
            QLog.i("SpeedUpUtil", 1, "\u4e0d\u7b26\u5408\u521a\u66f4\u65b0\u542f\u52a8\u89e6\u53d1 dex2oat \u7684\u6761\u4ef6\uff0c\u89e6\u53d1\u5931\u8d25.");
        } else {
            f("speed-profile", 0L, 2, null);
        }
    }
}
