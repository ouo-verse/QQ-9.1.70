package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.so.ResInfo;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.open.BeaconInitException;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.debug.api.IQQDebugApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqaudio.audioplayer.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import com.tencent.util.AudioHelperUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQAudioHelper {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f307072a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f307073b = false;

    /* renamed from: c, reason: collision with root package name */
    static final int[] f307074c = new int[39];

    /* renamed from: d, reason: collision with root package name */
    public static boolean f307075d = false;

    /* renamed from: e, reason: collision with root package name */
    private static long f307076e;

    /* renamed from: f, reason: collision with root package name */
    static String f307077f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f307078g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f307079h;

    /* renamed from: i, reason: collision with root package name */
    static boolean f307080i;

    /* renamed from: j, reason: collision with root package name */
    static String f307081j;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.utils.QQAudioHelper$3, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f307083d;

        @Override // java.lang.Runnable
        public void run() {
            QQToast makeText = QQToast.makeText(BaseApplication.getContext(), "de:" + this.f307083d, 1);
            makeText.setAutoTextSize();
            makeText.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseApplicationImpl f307084a;

        a(BaseApplicationImpl baseApplicationImpl) {
            this.f307084a = baseApplicationImpl;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && "tencent.video.q2v.debug".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("_debug_Event_index", -1);
                int intExtra2 = intent.getIntExtra("_debug_Event_value", -1);
                if (intExtra >= 0 && intExtra < 39) {
                    QQAudioHelper.f307074c[intExtra] = intExtra2;
                    QLog.w("AudioHelper", 1, "ReceiverDebugValue, [" + intExtra + "]=[" + intExtra2 + "]");
                }
                if (intExtra == 2) {
                    QQAudioHelper.s(this.f307084a.getApplicationContext());
                }
            }
        }
    }

    static {
        for (int i3 = 0; i3 < 39; i3++) {
            f307074c[i3] = -1000;
        }
        f307076e = 0L;
        f307077f = "actAVFunChatExpression";
        f307078g = false;
        f307079h = true;
        f307080i = false;
        f307081j = null;
    }

    @TargetApi(17)
    public static long a() {
        if (f307079h) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return 0L;
    }

    public static synchronized long b() {
        long genDebugSeq;
        synchronized (QQAudioHelper.class) {
            genDebugSeq = AudioHelperUtil.genDebugSeq();
        }
        return genDebugSeq;
    }

    public static int c(int i3) {
        if (!f307075d) {
            return -1;
        }
        int[] iArr = f307074c;
        if (iArr[i3] == -1000) {
            if (f307076e == 0) {
                QLog.w("AudioHelper", 1, "getDebugValue, uin is empty, [" + i3 + "]");
                return -1;
            }
            iArr[i3] = BaseApplication.getContext().getSharedPreferences("debugconfig_" + f307076e, 4).getInt("debugvalue" + i3, -1);
            QLog.w("AudioHelper", 1, "getDebugValue, [" + i3 + "]=[" + iArr[i3] + "]");
        }
        return iArr[i3];
    }

    public static String d(Object obj) {
        if (f()) {
            int i3 = 0;
            String str = "";
            if (obj instanceof String[]) {
                String[] strArr = (String[]) obj;
                int length = strArr.length;
                while (i3 < length) {
                    str = (str + strArr[i3]) + "|";
                    i3++;
                }
                return str;
            }
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length2 = iArr.length;
                while (i3 < length2) {
                    str = (str + iArr[i3]) + "|";
                    i3++;
                }
                return str;
            }
            return "" + obj;
        }
        if (obj == null) {
            return "null.";
        }
        if (obj instanceof String) {
            if (TextUtils.isEmpty((String) obj)) {
                return "*";
            }
            return "**";
        }
        return "***";
    }

    public static long e() {
        if (v()) {
            return System.currentTimeMillis();
        }
        return com.tencent.mobileqq.service.message.e.K0() * 1000;
    }

    public static boolean f() {
        return AudioHelperUtil.isDev();
    }

    public static boolean g(int i3) {
        Object systemService;
        if (QLog.isColorLevel()) {
            QLog.d("AudioHelper", 2, "SDK_INT: " + Build.VERSION.SDK_INT + " Man: " + Build.MANUFACTURER);
        }
        if (k() && (systemService = BaseApplication.getContext().getSystemService("appops")) != null && systemService.getClass().getSimpleName().equals(AudioRecorderJsPlugin.AudioManager.CLASS_NAME_APP_OPS_MANAGER)) {
            try {
                Class<?> cls = systemService.getClass();
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class);
                int i16 = AudioUtil.f306880b[i3];
                ApplicationInfo applicationInfo = BaseApplication.getContext().getApplicationInfo();
                int intValue = ((Integer) method.invoke(systemService, Integer.valueOf(i16), Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue();
                if (QLog.isColorLevel()) {
                    QLog.d(QQAudioHelper.class.getSimpleName(), 2, "isForbidByRubbishXiaomi(), result = " + intValue);
                }
                if (intValue == 0) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(QQAudioHelper.class.getSimpleName(), 2, e16.toString());
                }
            }
        }
        return false;
    }

    public static boolean h() {
        String str = Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel() + ";" + Build.VERSION.SDK_INT;
        String d06 = ea.d0(BaseApplication.getContext());
        if (StringUtil.isEmpty(d06)) {
            d06 = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24";
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioHelper", 2, "isHuaweiGreen greenList: " + d06 + ", feature :" + str);
        }
        String[] split = d06.split("\\|");
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                if (str2 != null && str2.equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioHelper", 2, "isHuaweiGreen true: " + str);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean i() {
        if (!((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isSegmentMediaCodecEncodeSwtichOpen()) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment true");
            }
            return true;
        }
        if (f307073b) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioHelper", 2, "isHuaweiGreenForSegmentLocal " + f307072a);
            }
            return f307072a;
        }
        f307073b = true;
        String str = Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel() + ";" + Build.VERSION.SDK_INT;
        String[] split = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;BLN-AL40;24|HUAWEI;FRD-AL10;24|HUAWEI;HUAWEI NXT-DL00;24|HUAWEI;NEXT;23|vivo;vivo X5Pro D;21|asus;ASUS_Z00ADB;21|HUAWEI;LON-AL00;26|HUAWEI;COL-AL10;27|HUAWEI;STF_AL00;26".split("\\|");
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                if (str2 != null && str2.equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment true: " + str);
                    }
                    f307072a = true;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean j() {
        return AudioHelperUtil.isLogColorOrGary();
    }

    private static boolean k() {
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static void l(String str, Bundle bundle) {
        m(str, bundle, false);
    }

    public static void m(String str, Bundle bundle, boolean z16) {
        String str2;
        if (z16 || QLog.isDevelopLevel()) {
            String str3 = "BundleValue[" + str + "]:\n";
            try {
                if (bundle != null) {
                    for (String str4 : bundle.keySet()) {
                        Object obj = bundle.get(str4);
                        String str5 = null;
                        if (obj != null && (obj instanceof long[])) {
                            long[] jArr = (long[]) obj;
                            str2 = "" + jArr.length;
                            for (int i3 = 0; i3 < jArr.length && i3 < 5; i3++) {
                                str2 = str2 + "[" + jArr[i3] + "]";
                            }
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            str2 = "" + obj;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str3);
                        sb5.append("    [");
                        sb5.append(str4);
                        sb5.append("]=[");
                        sb5.append(str2);
                        sb5.append("], [");
                        if (obj != null) {
                            str5 = obj.getClass().getSimpleName();
                        }
                        sb5.append(str5);
                        sb5.append("]\n");
                        str3 = sb5.toString();
                    }
                } else {
                    str3 = str3 + "bundle\u4e3a\u7a7a";
                }
                QLog.w("AudioHelper", 1, str3);
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.w("AudioHelper", 1, "log", e16);
                }
            }
        }
    }

    public static String n(AppInterface appInterface) {
        return o(appInterface, -1);
    }

    public static String o(AppInterface appInterface, int i3) {
        long l3;
        if (appInterface == null) {
            QLog.d("AudioHelper", 1, "BaseInfo, AppInterface is empty");
            return "BaseInfo, AppInterface is empty";
        }
        try {
            if (f307081j == null) {
                if (appInterface instanceof VideoAppInterface) {
                    l3 = AVCoreSystemInfo.getMaxCpuFreq();
                } else {
                    l3 = ah.l();
                }
                f307081j = "BaseInfo, APPID[" + AppSetting.f() + "], \nisPublicVersion[true], \nisGrayVersion[false], \nisDebugVersion[false], \nquaMainVersion[" + AppSetting.f99558r + "], \nversionCode[" + com.tencent.mobileqq.cooperation.a.a(appInterface.getApp()) + "], \nrevision[" + AppSetting.l() + "], \nisSupporImmersive[" + ImmersiveUtils.isSupporImmersive() + "], \nStatusBarHeight[" + ImmersiveUtils.getStatusBarHeight(appInterface.getApp()) + "], \nhasSmartBar[" + com.tencent.av.utils.ba.hasSmartBar() + "], \naboutSubVersionLog[" + AppSetting.c() + "], \ngetQUA[" + d(AppSetting.k()) + "], \nTYPE[" + Build.TYPE + "], \nTAGS[" + Build.TAGS + "], \nMANUFACTURER[" + Build.MANUFACTURER + "], \nPRODUCT[" + Build.PRODUCT + "], \nRELEASE[" + Build.VERSION.RELEASE + "], \nDISPLAY[" + Build.DISPLAY + "], \nCODENAME[" + Build.VERSION.CODENAME + "], \nINCREMENTAL[" + Build.VERSION.INCREMENTAL + "], \nBRAND[" + Build.BRAND + "], \nMODEL[" + DeviceInfoMonitor.getModel() + "], \nCPU_ABI[" + Build.CPU_ABI + "], \nCPU_ABI2[" + Build.CPU_ABI2 + "], \nCPU[" + Build.HARDWARE + "], \nCPUModel[" + AVCoreSystemInfo.getCpuModel() + "], \nisExistSDCard[" + com.tencent.mobileqq.util.cu.e() + "], \nsdkVersion[" + Build.VERSION.SDK_INT + "], \ndevicesInfo[" + m.b() + "], \nVendorId[" + AVCoreSystemInfo.getVendorId() + "], \nIsMarvell[" + AVCoreSystemInfo.getIsMarvell() + "], \nOpenGLVersion[" + AVCoreSystemInfo.getOpenGLVersion() + "], \nGLVersion[" + tv.c.c(appInterface.getApp()) + "], \ncupReport[" + AVCoreSystemInfo.getCpuReport() + "], \nFeature[" + AVCoreSystemInfo.getFeature() + "], \nMaxCpuFreq[" + l3 + "], \nSystemTotalMemory[" + m.c() + "], \nCpuNum[" + ah.n() + "], \nuid[" + appInterface.getApp().getApplicationInfo().uid + "], \nPermission_PackageName[" + appInterface.getApp().getPackageName() + "], \n";
            }
            DisplayMetrics displayMetrics = appInterface.getApp().getResources().getDisplayMetrics();
            String str = f307081j + "], \ndisplayMetrics[" + displayMetrics + "], \ndensity[" + displayMetrics.density + "], \ndensityDpi[" + displayMetrics.densityDpi + "], \nlogLevel[" + QLog.getUIN_REPORTLOG_LEVEL() + "], \nisDevelopLevel[" + QLog.isDevelopLevel() + "], \nisColorLevel[" + QLog.isColorLevel() + "], \nsProcessId[" + MobileQQ.sProcessId + "], \nprocessName[" + MobileQQ.processName + "], \nUIThread[" + ThreadManager.getUIHandler().getLooper().getThread().getId() + "], \nCurThread[" + Thread.currentThread().getId() + "], \nisTestEnvironment[" + i3 + "], \ntid[" + Process.myTid() + "], \nmyPid[" + Process.myPid() + "], \nmyUid[" + Process.myUid() + "]";
            QLog.d("AudioHelper", 1, str);
            return str;
        } catch (Exception e16) {
            QLog.w("AudioHelper", 1, "printBaseInfo, Exception", e16);
            return e16.getMessage();
        }
    }

    @TargetApi(17)
    public static void p(String str) {
        if (f307079h && f307080i) {
            QLog.w("AudioHelper", 1, "printTime[" + str + "], time[" + SystemClock.elapsedRealtimeNanos() + "]");
        }
    }

    public static boolean q(BaseApplicationImpl baseApplicationImpl, long j3) {
        if (!f307075d) {
            f307075d = f();
        }
        t(j3);
        if (baseApplicationImpl != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("tencent.video.q2v.debug");
            if (baseApplicationImpl.registerReceiver(new a(baseApplicationImpl), intentFilter) != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void r(int i3, f.a aVar) {
        String str = "!@$#_" + i3 + "_";
        PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putInt(str + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, aVar.f262192a).putInt(str + ReportConstant.COSTREPORT_PREFIX, aVar.f262193b).putBoolean(str + ResInfo.RES_TYPE_SO, aVar.f262194c).commit();
    }

    public static void s(Context context) {
        if (!f307075d) {
            f307075d = f();
        }
        if (c(2) == 1) {
            QLog.d("AudioHelper", 1, "setBeaconDebug begin");
            UserAction.setLogAble(!AppSetting.u(), true);
            if (context != null) {
                try {
                    UserAction.initUserAction(context);
                } catch (BeaconInitException e16) {
                    QLog.e("AudioHelper", 1, "[initUserAction] error, ", e16);
                }
            }
            UserAction.setLogAble(!AppSetting.u(), true);
            QLog.d("AudioHelper", 1, "setBeaconDebug end");
        }
    }

    public static void t(long j3) {
        if (f307076e != j3) {
            f307076e = j3;
            for (int i3 = 0; i3 < 39; i3++) {
                f307074c[i3] = -1000;
            }
        }
    }

    public static void u(final AppInterface appInterface) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQAudioHelper.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (QQAudioHelper.f()) {
                    i3 = ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).isTestEnvironment();
                } else {
                    i3 = -1;
                }
                QQAudioHelper.o(AppInterface.this, i3);
            }
        });
    }

    private static boolean v() {
        if (c(15) == 1) {
            w(HardCodeUtil.qqStr(R.string.jsl));
            return true;
        }
        return false;
    }

    public static final void w(String str) {
        QLog.w("\u6d4b\u8bd5\u5f00\u5173", 1, str);
    }
}
