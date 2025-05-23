package com.tencent.qqperf.monitor.crash;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.hippy.qq.api.IHippyCrashHandler;
import com.tencent.icgame.common.api.IICGameCrashReportApi;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.microapp.util.MiniAppCrashUtils;
import com.tencent.mobileqq.mini.api.IMiniGameService;
import com.tencent.mobileqq.mini.api.report.IMiniReport;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.perf.memory.gc.a;
import com.tencent.mobileqq.perf.report.abtag.BuglyABManager;
import com.tencent.mobileqq.perf.thread.handlerthread.LightMessageQueueHookReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.mobileqq.soload.api.ISoLoaderCrashService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.api.IZPlanCrashUtil;
import com.tencent.mobileqq.zplan.utils.api.IZPlanFilamentCrashUtil;
import com.tencent.qbar.QbarCrashCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qqlive.common.api.IQQLiveCrashReportApi;
import com.tencent.qqperf.monitor.crash.tools.h;
import com.tencent.qqperf.monitor.crash.tools.i;
import com.tencent.qqperf.opt.suspendthread.SuspendThreadManager;
import com.tencent.shadow.dynamic.host.Constant;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneCrashHandler;
import cooperation.qzone.RDMEtraMsgCollector;
import java.util.Date;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONObject;
import us3.j;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c extends d {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {
        static /* bridge */ /* synthetic */ String a() {
            return e();
        }

        private static String b(int i3) {
            StringBuilder sb5 = new StringBuilder();
            for (int i16 = 0; i16 < i3; i16++) {
                sb5.append(" ");
            }
            return sb5.toString();
        }

        public static String c(@Nullable View view) {
            if (view == null) {
                return "(null)";
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                d(sb5, view, 0);
                return sb5.toString();
            } catch (Throwable th5) {
                return "exception: " + th5;
            }
        }

        private static void d(StringBuilder sb5, View view, int i3) {
            String str;
            if (view != null && view.getVisibility() == 0) {
                try {
                    try {
                        str = view.getResources().getResourceEntryName(view.getId());
                    } catch (Throwable th5) {
                        sb5.append(b(i3 * 2));
                        sb5.append("failed to dump view info due to " + th5.getClass().getSimpleName());
                        sb5.append('\n');
                        Log.i("CrashHandleProcessor", "[dumpViewTree] exception: " + th5);
                        return;
                    }
                } catch (Resources.NotFoundException unused) {
                    str = "(n/a)";
                }
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                sb5.append(b(i3 * 2));
                StringBuilder sb6 = new StringBuilder();
                sb6.append("id:");
                sb6.append(str);
                sb6.append(" class:");
                sb6.append(view.getClass().getName());
                sb6.append(" location:");
                sb6.append(iArr[0]);
                sb6.append(",");
                sb6.append(iArr[1]);
                sb6.append(" pos:");
                sb6.append((int) view.getX());
                sb6.append(",");
                sb6.append((int) view.getY());
                sb6.append(" size:");
                sb6.append(view.getWidth());
                sb6.append(",");
                sb6.append(view.getHeight());
                sb5.append(sb6.toString());
                sb5.append('\n');
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (int i16 = 0; i16 < childCount; i16++) {
                        d(sb5, ((ViewGroup) view).getChildAt(i16), i3 + 1);
                    }
                }
            }
        }

        private static String e() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ViewTree:\n");
            try {
                Activity topActivity = Foreground.getTopActivity();
                if (topActivity == null) {
                    sb5.append("top activity is null");
                } else {
                    sb5.append("activity: ");
                    sb5.append(topActivity.getClass().getName());
                    sb5.append('\n');
                    sb5.append("fragment: ");
                    sb5.append(g(topActivity));
                    sb5.append('\n');
                    sb5.append(c(topActivity.getWindow().getDecorView()));
                }
            } finally {
                try {
                    return sb5.toString();
                } finally {
                }
            }
            return sb5.toString();
        }

        public static Fragment f(@NonNull FragmentActivity fragmentActivity) {
            for (Fragment fragment : fragmentActivity.getSupportFragmentManager().getFragments()) {
                if (fragment != null && fragment.isVisible()) {
                    return fragment;
                }
            }
            return null;
        }

        public static String g(@Nullable Activity activity) {
            if (!(activity instanceof FragmentActivity)) {
                return "(not support fragment)";
            }
            Fragment f16 = f((FragmentActivity) activity);
            if (f16 == null) {
                return "(no visible fragment)";
            }
            return "[" + f16.getTag() + "]" + f16.getClass().getName();
        }
    }

    private void A(StringBuilder sb5) {
        if (NativeMonitorConfigHelper.getConfig(BaseApplicationImpl.getApplication().getRuntime()).getOpenBacktrace64() == 1) {
            String undetachThreads = NativeMemoryMonitor.getInstance().getUndetachThreads();
            if (!TextUtils.isEmpty(undetachThreads)) {
                sb5.append(undetachThreads);
            }
        }
    }

    private void B(StringBuilder sb5) {
        String str = QbarCrashCollector.sCurrentUrl;
        if (str != null && str.length() > 0) {
            sb5.append("\nQbar scanning url:");
            sb5.append(str);
        }
    }

    private void C(StringBuilder sb5) {
        sb5.append("QzoneConfig: preload qzone: " + QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_QZONE_PROCESS_ENABLE, 1));
        sb5.append("  notlocate: " + QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_NOT_LOCATE_FROM_PROFLIE, false));
        sb5.append("  notshowkapu: " + QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_NOT_SHOWKAPU_FROM_PROFLIE, false));
        sb5.append("\n");
        if (!TextUtils.isEmpty(QZoneCrashHandler.lastCrashedMeasuredText)) {
            sb5.append("lastCrashedText(Base64): " + Base64.encodeToString(QZoneCrashHandler.lastCrashedMeasuredText.getBytes(), 0) + "\n");
        }
        sb5.append(RDMEtraMsgCollector.getInstance().getEtraMsg());
        sb5.append("\n");
    }

    private void D(String str, String str2, StringBuilder sb5) {
        String d16;
        if (str.contains(TransactionTooLargeException.class.getSimpleName()) && (d16 = com.tencent.qqperf.monitor.crash.api.impl.a.d()) != null) {
            sb5.append("SaveInstanceStateInfo:\n" + d16);
            sb5.append("\n");
        }
    }

    private void F(String str, String str2, StringBuilder sb5) {
        try {
            if (!TextUtils.isEmpty(str) && str.contains("AssertionError") && !TextUtils.isEmpty(str2) && str2.contains("registerReceiver")) {
                sb5.append("\nReceivers:");
                i.a(BaseApplicationImpl.getApplication(), sb5);
            }
            if (("org.xmlpull.v1.XmlPullParserException".equals(str) && !TextUtils.isEmpty(str2) && str2.contains("<bitmap> requires a valid 'src' attribute")) || ("java.lang.ArrayIndexOutOfBoundsException".equals(str) && !TextUtils.isEmpty(str2) && str2.contains("android.content.res.ResourcesImpl.createFromResourceStream"))) {
                sb5.append("\n vivo crash system version=");
                sb5.append(cu.d("ro.vivo.product.version"));
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("CrashHandleProcessor", 2, "recordVIVOSysInfo exception ", e16);
            }
        }
    }

    private void G(StringBuilder sb5) {
        int[] iArr = WebpSoLoader.f306528a;
        if (iArr != null && iArr.length >= 3) {
            sb5.append(String.format("\nWebP support library v%d.%d.%d was loaded.", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2])));
            sb5.append("\n");
        }
    }

    private void H(StringBuilder sb5) {
        sb5.append("\nisXposedInstalled: " + PackageUtil.isAppInstalled(BaseApplication.getContext(), "de.robv.android.xposed.installer"));
    }

    private void I(StringBuilder sb5, String str, String str2) {
        if (str != null && str2 != null) {
            StringBuilder sb6 = new StringBuilder();
            try {
                if (str2.equalsIgnoreCase("com.tencent.mobileqq")) {
                    sb6.append("is Zplan Filament user:");
                    sb6.append(com.tencent.mobileqq.perf.report.a.c(BuglyABManager.ABTag.ZPlanFilament.name(), false));
                    sb6.append("\n");
                }
            } finally {
                try {
                } finally {
                }
            }
            if (!str.contains("zplan") && !str2.contains("zplan")) {
                return;
            }
            sb6.append("\nZplan Entry info: \n");
            sb6.append("is Zplan open:");
            sb6.append(com.tencent.mobileqq.perf.report.a.f258012a);
            sb6.append("\n");
            sb6.append("Zplan PreLoad state:");
            sb6.append(com.tencent.mobileqq.perf.report.a.f258014c);
            sb6.append("\n");
            IZPlanAccessibleHelper iZPlanAccessibleHelper = (IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class);
            if (iZPlanAccessibleHelper != null) {
                long parseLong = Long.parseLong(QQCrashReportManager.f363157a);
                int zplanAccessible = iZPlanAccessibleHelper.getZplanAccessible(1001L, parseLong);
                sb6.append("is Zplan FRONT_PAGE_RIGHT_ENTRANCE open:");
                sb6.append(zplanAccessible);
                sb6.append("\n");
                int zplanAccessible2 = iZPlanAccessibleHelper.getZplanAccessible(Constant.FROM_ID_UNINSTALL_PLUGIN, parseLong);
                sb6.append("is Zplan DYNAMIC_ENTRANCE open:");
                sb6.append(zplanAccessible2);
                sb6.append("\n");
                int zplanAccessible3 = iZPlanAccessibleHelper.getZplanAccessible(Constant.FROM_ID_START_ACTIVITY, parseLong);
                sb6.append("is Zplan SMALL_EMOJI_ENTRANCE open:");
                sb6.append(zplanAccessible3);
                sb6.append("\n");
                int zplanAccessible4 = iZPlanAccessibleHelper.getZplanAccessible(1004L, parseLong);
                sb6.append("is Zplan INFO_CARD_ENTRANCE open:");
                sb6.append(zplanAccessible4);
                sb6.append("\n");
                int zplanAccessible5 = iZPlanAccessibleHelper.getZplanAccessible(Constant.FROM_ID_STOP_SERVICE, parseLong);
                sb6.append("is Zplan C2C_PLUS_ENTRANCE open:");
                sb6.append(zplanAccessible5);
                sb6.append("\n");
                int zplanAccessible6 = iZPlanAccessibleHelper.getZplanAccessible(2001L, parseLong);
                sb6.append("is Zplan AIO_RIGHT_ENTRANCE open:");
                sb6.append(zplanAccessible6);
                sb6.append("\n");
                int zplanAccessible7 = iZPlanAccessibleHelper.getZplanAccessible(1011L, parseLong);
                sb6.append("is Zplan COUPLE_AVATAR_ENTRANCE open:");
                sb6.append(zplanAccessible7);
                sb6.append("\n");
            }
            if (!TextUtils.isEmpty(com.tencent.mobileqq.perf.report.a.f258013b)) {
                sb6.append("currGameMap:");
                sb6.append(com.tencent.mobileqq.perf.report.a.f258013b);
                sb6.append("\n");
            }
        }
    }

    private void J(String str, String str2) {
        if (((IHippyCrashHandler) QRoute.api(IHippyCrashHandler.class)).isSaveHippyStatus() && !TextUtils.isEmpty(str2) && str2.contains("hippy")) {
            ((IHippyCrashHandler) QRoute.api(IHippyCrashHandler.class)).reportCrash(str, str2);
        }
    }

    private static boolean L(String str) {
        String[] strArr = {"measure", "draw", TtmlNode.TAG_LAYOUT, "ViewGroup"};
        for (int i3 = 0; i3 < 4; i3++) {
            if (str.contains(strArr[i3])) {
                return true;
            }
        }
        return false;
    }

    private void M(String str, String str2) {
        ISoLoaderCrashService iSoLoaderCrashService = (ISoLoaderCrashService) QRoute.api(ISoLoaderCrashService.class);
        if (iSoLoaderCrashService != null) {
            iSoLoaderCrashService.handleCrash(str, str2);
        }
    }

    private void N(boolean z16, String str) {
        if (1 == MobileQQ.sProcessId && !TextUtils.isEmpty(str)) {
            if ((z16 && str.contains("libthreadsuspend")) || (!z16 && str.contains("SuspendThreadManager"))) {
                SuspendThreadManager.I().F();
            }
        }
    }

    private void O(boolean z16, String str, String str2, String str3) {
        if (str3.endsWith(":zplan")) {
            ((IZPlanCrashUtil) QRoute.api(IZPlanCrashUtil.class)).handleCrash(z16, str, str2);
        }
    }

    private void P(boolean z16, String str, String str2, String str3, int i3, long j3) {
        if (z16 && 1 == MobileQQ.sProcessId && str3 != null && str3.contains("libace_zplan")) {
            ((IZPlanFilamentCrashUtil) QRoute.api(IZPlanFilamentCrashUtil.class)).handleNativeCrash(str, str2, str3, i3, j3);
        }
    }

    private void k(boolean z16, String str, String str2, String str3) {
        if (!str3.equalsIgnoreCase("com.tencent.mobileqq")) {
            return;
        }
        if (z16) {
            if (str.equalsIgnoreCase("SIGABRT")) {
                LightMessageQueueHookReport.h().c();
            }
        } else if ("java.lang.OutOfMemoryError".equalsIgnoreCase(str)) {
            LightMessageQueueHookReport.h().c();
        }
    }

    private void l(String str, String str2, String str3, long j3, String str4) {
        if (((IICGameCrashReportApi) QRoute.api(IICGameCrashReportApi.class)).isICGameCrash(str, str2, str3, j3, str4)) {
            ((IICGameCrashReportApi) QRoute.api(IICGameCrashReportApi.class)).reportCrash(new tt0.b(str, str2, str3, String.valueOf(j3), str4, ah.Q(BaseApplication.context)));
        }
    }

    private void m(boolean z16, String str, String str2, String str3, int i3, long j3) {
        if (!TextUtils.isEmpty(str3) && str3.contains("kandianreport")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isNativeCrashed", z16);
                jSONObject.put("crashType", str);
                jSONObject.put("crashAddress", str2);
                jSONObject.put("crashStack", str3);
                jSONObject.put("native_SICODE", i3);
                jSONObject.put("crashTime", j3);
                ClassLoader classLoader = BaseApplicationImpl.sApplication.getClassLoader();
                if (classLoader != null) {
                    classLoader.loadClass("com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskException").getMethod("reportCrash", String.class).invoke(null, jSONObject.toString());
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    private void n(String str) {
        if (L(str.toLowerCase())) {
            QLog.e("CrashHandleProcessor", 1, a.a());
        } else {
            QLog.e("CrashHandleProcessor", 1, "skip dumping view tree");
        }
    }

    private void o(String str, String str2) {
        if (MobileQQ.processName.endsWith(":miniapp")) {
            MiniAppCrashUtils.reportCrash("msg:" + str + str2);
        }
    }

    private void p(boolean z16, String str, String str2, String str3, int i3, long j3, String str4) {
        if (!str4.endsWith(":mini") && !str4.endsWith(":mini1") && !str4.endsWith(":mini2") && !str4.endsWith(":mini3") && !str4.endsWith(":mini4") && !str4.endsWith(":mini5") && !str4.endsWith(":mini6") && !str4.endsWith(":mini7")) {
            if (j.b(str4)) {
                ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).reportCrash(z16, str, str2, str3, i3, j3, str4);
                return;
            }
            return;
        }
        String crashReportAppInfo = ((IMiniReport) QRoute.api(IMiniReport.class)).getCrashReportAppInfo();
        ((IMiniReport) QRoute.api(IMiniReport.class)).doCrashReport(QQCrashReportManager.f363157a, str4, crashReportAppInfo, z16, str, str2, str3, i3, j3);
        if (crashReportAppInfo != null && QLog.isColorLevel()) {
            QLog.d("CrashHandleProcessor", 2, "miniAppInfo = " + crashReportAppInfo);
        }
    }

    private void q(boolean z16, String str, String str2) {
        if (z16) {
            if (str2.endsWith(":qzone") || str2.endsWith(":picture")) {
                QLog.e("crash", 1, str);
                QZoneCrashHandler.saveLastCrashInf(str);
            }
        }
    }

    private void r(String str, String str2, String str3, long j3, String str4) {
        boolean z16;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((IQQLiveCrashReportApi) QRoute.api(IQQLiveCrashReportApi.class)).reportCrash(new et3.b(str, str2, str3, String.valueOf(j3), str4, ah.Q(BaseApplication.context)));
        }
    }

    private void s(String str, String str2) {
        if (MobileQQ.processName.endsWith(":tool") && str2 != null) {
            if (str2.contains("qwallet") || str2.contains(TenpayJumpActivity.TENPAY_SCHEME)) {
                ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).reportCrash("msg:" + str + str2);
            }
        }
    }

    private void t(String str, String str2, StringBuilder sb5) {
        if ("java.lang.OutOfMemoryError".equals(str) || (("java.lang.RuntimeException".equals(str) && str2.contains("channel file descriptors")) || (("java.lang.NullPointerException".equals(str) && str2.contains("SharedPreferencesProxyManager")) || ("java.lang.RuntimeException".equals(str) && str2.contains("Could not read input channel file descriptors"))))) {
            String format = ly3.a.f415787b.format(new Date(QQCrashReportManager.f363159c));
            sb5.append("\nFDStats countLastChecked: ");
            sb5.append(QQCrashReportManager.f363158b);
            sb5.append("datetimeFDLastChecked: ");
            sb5.append(format);
            sb5.append("\ncurrent fd info:\n");
            sb5.append(com.tencent.qqperf.monitor.crash.tools.d.a());
            sb5.append("\nall fd backtrace:\n");
        }
    }

    private void u(boolean z16, Context context, StringBuilder sb5, String str) {
        if (z16) {
            if (str.endsWith(":qzone") || str.endsWith(":picture") || str.endsWith(":tool")) {
                String string = context.getSharedPreferences("QQCrashReportManager", 4).getString("facefeature_ext_so_md5", null);
                sb5.append("\nfaceFeatureExtSoMD5:");
                sb5.append(string);
            }
        }
    }

    private void v(StringBuilder sb5, String str, String str2) {
        if ("java.lang.OutOfMemoryError".equalsIgnoreCase(str) || str2.toLowerCase().contains("finalize")) {
            a.C8202a c16 = com.tencent.mobileqq.perf.memory.gc.a.f257735a.c();
            sb5.append("gcInfo:");
            sb5.append(c16);
            sb5.append('\n');
        }
    }

    private void w(StringBuilder sb5) {
        if (((IHippyCrashHandler) QRoute.api(IHippyCrashHandler.class)).isSaveHippyStatus()) {
            String hippyStatus = ((IHippyCrashHandler) QRoute.api(IHippyCrashHandler.class)).getHippyStatus();
            sb5.append("hippy:");
            sb5.append(hippyStatus);
            sb5.append('\n');
        }
    }

    private void x(StringBuilder sb5, String str, String str2) {
        if (str != null && str2 != null) {
            StringBuilder sb6 = new StringBuilder();
            try {
                sb6.append("Login report login scene: ");
                sb6.append(((ILoginReporter) QRoute.api(ILoginReporter.class)).getLoginEntranceForReport());
                sb6.append("\n");
                sb6.append("Login report login account: ");
                sb6.append(((ILoginReporter) QRoute.api(ILoginReporter.class)).getLoginUinForReport());
                sb6.append("\n");
            } catch (Throwable th5) {
                QLog.e("CrashHandleProcessor", 1, "Login report info handleCrash error :", th5);
            }
            sb5.append((CharSequence) sb6);
        }
    }

    private void y(boolean z16, String str, String str2, StringBuilder sb5) {
        if ((z16 && !TextUtils.isEmpty(str2) && ((str2.contains("libhwui") || str2.contains("liblog")) && !TextUtils.isEmpty(str) && str.equalsIgnoreCase("SIGABRT"))) || (!TextUtils.isEmpty(str2) && str2.contains("GC"))) {
            sb5.append("\n\n");
            sb5.append("Memory Info Details:");
            sb5.append(h.b());
            sb5.append("\n\n");
            sb5.append("Activity Info Details:");
            sb5.append(com.tencent.qqperf.monitor.crash.tools.a.a());
        }
    }

    private void z(StringBuilder sb5, String str) {
        if (str.endsWith(ProcessConstant.MINI_3) || str.endsWith(ProcessConstant.MINI_4)) {
            String crashReportExtAppId = ((IMiniGameService) QRoute.api(IMiniGameService.class)).getCrashReportExtAppId();
            if (!TextUtils.isEmpty(crashReportExtAppId)) {
                sb5.append("miniGameAppId:");
                sb5.append(crashReportExtAppId);
                sb5.append('\n');
            }
            Integer crashReportExtState = ((IMiniGameService) QRoute.api(IMiniGameService.class)).getCrashReportExtState();
            if (crashReportExtState != null) {
                sb5.append("miniGameState:");
                sb5.append(crashReportExtState);
                sb5.append('\n');
            }
        }
    }

    public void E(String str, String str2) {
        if (com.tencent.mobileqq.perf.thread.proxy.b.INSTANCE.b().g() && str == "java.lang.OutOfMemoryError" && str2.contains("Thread.nativeCreate")) {
            CrashReport.putUserData(BaseApplication.getContext(), "activeThreadCount", String.valueOf(Thread.activeCount()));
            CrashReport.putUserData(BaseApplication.getContext(), "threadFdCount", String.valueOf(com.tencent.mobileqq.qqmatrix.threadleak.a.e()));
        }
    }

    @Override // com.tencent.qqperf.monitor.crash.d
    public boolean a(boolean z16, String str, String str2, String str3, int i3) {
        if (!TextUtils.isEmpty(str) && str.contains("ANR_EXCEPTION")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqperf.monitor.crash.d
    public void b(Context context, boolean z16, String str, String str2, String str3, int i3, long j3, String str4) {
        super.b(context, z16, str, str2, str3, i3, j3, str4);
        com.tencent.mobileqq.hodor.a.b(context, str, str3, j3, str4);
        ny3.b.e().d(str, str3, j3);
        K(str, str2, context);
        N(z16, str3);
        s(str, str3);
        M(str, str3);
        o(str, str3);
        m(z16, str, str2, str3, i3, j3);
        q(z16, str3, str4);
        p(z16, str, str2, str3, i3, j3, str4);
        O(z16, str, str3, str4);
        P(z16, str, str2, str3, i3, j3);
        r(str, str2, str3, j3, str4);
        l(str, str2, str3, j3, str4);
        J(str, str3);
        k(z16, str, str3, str4);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("crash_handler_log_view_tree", true)) {
            n(str3);
        }
        E(str, str3);
    }

    @Override // com.tencent.qqperf.monitor.crash.d
    public String c(Context context, boolean z16, String str, String str2, String str3, int i3, long j3, String str4) {
        StringBuilder sb5 = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        sb5.append(super.c(context, z16, str, str2, str3, i3, j3, str4));
        H(sb5);
        long d16 = d(currentTimeMillis, 2, "recordXposedInfo");
        I(sb5, str3, str4);
        long d17 = d(d16, 2, "recordZplanEntryInfo");
        x(sb5, str3, str4);
        long d18 = d(d17, 2, "recordLoginInfo");
        G(sb5);
        long d19 = d(d18, 2, "recordWebPCrashInfo");
        C(sb5);
        long d26 = d(d19, 2, "recordQZoneCrashInfo");
        A(sb5);
        long d27 = d(d26, 2, "recordNativeMemoryMonitorInfo");
        u(z16, context, sb5, str4);
        long d28 = d(d27, 2, "recordFaceFeatureInfo");
        B(sb5);
        long d29 = d(d28, 2, "recordQBarInfo");
        F(str, str3, sb5);
        long d36 = d(d29, 2, "recordVIVOSysInfo");
        t(str, str3, sb5);
        long d37 = d(d36, 2, "recordFDInfo");
        D(str, str3, sb5);
        long d38 = d(d37, 2, "recordSaveStateInfo");
        y(z16, str, str3, sb5);
        long d39 = d(d38, 2, "recordMemoryInfo");
        w(sb5);
        long d46 = d(d39, 2, "recordHippyInfo");
        z(sb5, str4);
        long d47 = d(d46, 2, "recordMiniGameInfo");
        v(sb5, str, str3);
        d(d47, 2, "recordGcInfo");
        return sb5.toString();
    }

    private void K(String str, String str2, Context context) {
    }
}
