package com.tencent.qqprotect.qsec;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.view.accessibility.AccessibilityManager;
import androidx.core.app.NotificationCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<String> f363502a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<String> f363503b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<String> f363504c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f363505d;

    /* compiled from: P */
    /* renamed from: com.tencent.qqprotect.qsec.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class C9714a extends com.tencent.qqprotect.qsec.utils.b {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f363506f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f363507g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C9714a(long j3, long j16, String str, Context context) {
            super(j3, j16);
            this.f363506f = str;
            this.f363507g = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), str, context);
            }
        }

        @Override // com.tencent.qqprotect.qsec.utils.b
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            d.a().d();
            b.a().d();
            c.a().d();
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).collectReport(null, this.f363506f, a.e(this.f363507g, a.f363502a, a.f363503b, a.f363504c), null);
            a.f363502a.clear();
            a.f363504c.clear();
            a.f363503b.clear();
            a.f363505d = false;
        }

        @Override // com.tencent.qqprotect.qsec.utils.b
        public void f(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
                return;
            }
            a.f363502a.add(a.s());
            a.f363503b.add(a.q());
            a.f363504c.add(a.r());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18720);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f363502a = new ArrayList<>();
        f363503b = new ArrayList<>();
        f363504c = new ArrayList<>();
        f363505d = false;
    }

    public static String A() {
        try {
            List<String> B = B();
            if (B != null && B.size() > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                Iterator<String> it = B.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                if (!TextUtils.isEmpty(stringBuffer)) {
                    return com.tencent.qqprotect.qsec.utils.c.a(stringBuffer.toString());
                }
            }
            return "CK_N";
        } catch (Throwable unused) {
            return "CK_PE";
        }
    }

    private static List<String> B() {
        return null;
    }

    private static String C(Context context) {
        if (context == null) {
            return "";
        }
        try {
            ArrayMap arrayMap = new ArrayMap();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                arrayMap.put("available", Long.valueOf(memoryInfo.availMem));
                arrayMap.put("free", Long.valueOf(memoryInfo.threshold));
                arrayMap.put("total", Long.valueOf(memoryInfo.totalMem));
            }
            return arrayMap.toString();
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    private static String D() {
        try {
            return String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    private static String E() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    @RequiresApi(api = 19)
    private static String F(Context context) {
        if (context == null) {
            return "";
        }
        ArrayMap arrayMap = new ArrayMap();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            arrayMap.put("call", Integer.valueOf(SystemMethodProxy.getStreamVolume(audioManager, 0)));
            arrayMap.put(NotificationCompat.CATEGORY_SYSTEM, Integer.valueOf(SystemMethodProxy.getStreamVolume(audioManager, 1)));
            arrayMap.put(IndividuationUrlHelper.UrlId.RING_HOME, Integer.valueOf(SystemMethodProxy.getStreamVolume(audioManager, 2)));
            arrayMap.put("music", Integer.valueOf(SystemMethodProxy.getStreamVolume(audioManager, 3)));
            arrayMap.put(NotificationCompat.CATEGORY_ALARM, Integer.valueOf(SystemMethodProxy.getStreamVolume(audioManager, 4)));
            arrayMap.put("notif", Integer.valueOf(SystemMethodProxy.getStreamVolume(audioManager, 5)));
        }
        return arrayMap.toString();
    }

    public static int G(Context context) {
        int i3 = -1;
        if (context == null) {
            return -1;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            i3 = 1;
            int simState = telephonyManager.getSimState();
            if (simState != 0 && simState != 1) {
                return 1;
            }
            return 0;
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return i3;
        }
    }

    public static void H(Context context, String str, String str2) {
        if (f363505d || !f(str)) {
            return;
        }
        d.a().c(context);
        b.a().c(context);
        c.a().c(context);
        f363505d = true;
        new C9714a(30000L, 5000L, str2, context).g();
    }

    public static String e(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        JSONObject jSONObject = new JSONObject();
        if (arrayList == null) {
            try {
                arrayList = new ArrayList<>();
                arrayList.add(s());
            } catch (Throwable th5) {
                QLog.e("O3_CollectInfo", 2, "error! " + th5);
            }
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
            arrayList2.add(q());
        }
        if (arrayList3 == null) {
            arrayList3 = new ArrayList<>();
            arrayList3.add(r());
        }
        jSONObject.put(String.valueOf(1), o(context));
        jSONObject.put(String.valueOf(2), E());
        jSONObject.put(String.valueOf(3), n(context));
        jSONObject.put(String.valueOf(4), "");
        jSONObject.put(String.valueOf(5), z(context));
        jSONObject.put(String.valueOf(6), "");
        jSONObject.put(String.valueOf(7), w(context));
        jSONObject.put(String.valueOf(8), j(context));
        jSONObject.put(String.valueOf(9), D());
        jSONObject.put(String.valueOf(10), t());
        jSONObject.put(String.valueOf(11), G(context));
        jSONObject.put(String.valueOf(12), p(context));
        jSONObject.put(String.valueOf(13), m(context));
        jSONObject.put(String.valueOf(14), A());
        jSONObject.put(String.valueOf(15), arrayList2.toString());
        jSONObject.put(String.valueOf(16), arrayList.toString());
        jSONObject.put(String.valueOf(17), arrayList3.toString());
        jSONObject.put(String.valueOf(18), y());
        jSONObject.put(String.valueOf(19), x(context));
        jSONObject.put(String.valueOf(21), C(context));
        jSONObject.put(String.valueOf(23), l());
        jSONObject.put(String.valueOf(24), k());
        jSONObject.put(String.valueOf(25), F(context));
        jSONObject.put(String.valueOf(26), u(context));
        jSONObject.put(String.valueOf(27), "");
        jSONObject.put(String.valueOf(28), "");
        jSONObject.put(String.valueOf(29), "");
        jSONObject.put(String.valueOf(30), h(context));
        jSONObject.put(String.valueOf(31), i(context));
        jSONObject.put(String.valueOf(32), g(context));
        jSONObject.put(String.valueOf(33), v());
        return jSONObject.toString();
    }

    private static boolean f(String str) {
        String format = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        String str2 = str + "_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (TextUtils.equals(from.decodeString(str2, ""), format)) {
            return false;
        }
        from.encodeString(str2, format);
        return true;
    }

    private static String g(Context context) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        if (context == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null) {
                Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getResolveInfo().serviceInfo.packageName);
                }
            }
            return arrayList.toString();
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return arrayList.toString();
        }
    }

    private static int h(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null) {
                return accessibilityManager.isEnabled() ? 1 : 0;
            }
            return -1;
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return -1;
        }
    }

    private static String i(Context context) {
        List<AccessibilityServiceInfo> installedAccessibilityServiceList;
        if (context == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && (installedAccessibilityServiceList = accessibilityManager.getInstalledAccessibilityServiceList()) != null) {
                Iterator<AccessibilityServiceInfo> it = installedAccessibilityServiceList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getId());
                }
            }
            return arrayList.toString();
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return arrayList.toString();
        }
    }

    private static Map j(Context context) {
        HashMap hashMap = new HashMap();
        if (context != null) {
            try {
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (registerReceiver != null) {
                    int intExtra = registerReceiver.getIntExtra("status", 0);
                    int intExtra2 = registerReceiver.getIntExtra("level", 0);
                    int intExtra3 = registerReceiver.getIntExtra("scale", 100);
                    int intExtra4 = registerReceiver.getIntExtra("temperature", 0);
                    int intExtra5 = registerReceiver.getIntExtra("voltage", 0);
                    hashMap.put("status", Integer.valueOf(intExtra));
                    hashMap.put("level", Integer.valueOf(intExtra2));
                    hashMap.put("scale", Integer.valueOf(intExtra3));
                    hashMap.put(FaceUtil.IMG_TEMP, Integer.valueOf(intExtra4));
                    hashMap.put("vol", Integer.valueOf(intExtra5));
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    private static String k() {
        try {
            return com.tencent.mobileqq.qsec.qsecest.a.a("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    private static String l() {
        return "Unknow";
    }

    private static String m(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String string = DeviceInfoMonitor.getString(context.getContentResolver(), "default_input_method");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string.split("/")[0];
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return null;
        }
    }

    private static String n(Context context) {
        return "";
    }

    private static String o(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return DeviceInfoMonitor.getString(context.getContentResolver(), "bluetooth_name");
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    private static String p(Context context) {
        if (context == null) {
            return "";
        }
        try {
            ArrayMap arrayMap = new ArrayMap();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                arrayMap.put("width", Integer.valueOf(displayMetrics.widthPixels));
                arrayMap.put("height", Integer.valueOf(displayMetrics.heightPixels));
            }
            return arrayMap.toString();
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    public static String q() {
        try {
            return b.a().b();
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    public static String r() {
        try {
            return c.a().b();
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    public static String s() {
        try {
            return String.format(Locale.CHINA, "%f", Float.valueOf(d.a().b()));
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    private static String t() {
        try {
            return (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, "sys.usb.config");
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    private static long u(Context context) {
        String str = "error! ";
        if (context != null) {
            try {
                try {
                    str = new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified();
                    return str;
                } catch (Throwable th5) {
                    QLog.e("O3_CollectInfo", 2, "error! " + th5);
                    return 0L;
                }
            } catch (Throwable th6) {
                QLog.e("O3_CollectInfo", 2, str + th6);
                return 0L;
            }
        }
        return 0L;
    }

    private static int v() {
        try {
            return Process.myPid();
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return -1;
        }
    }

    private static int w(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                return -1;
            }
            return Settings.System.getInt(contentResolver, "screen_brightness", 125);
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return -1;
        }
    }

    private static boolean x(Context context) {
        if (context != null) {
            try {
                return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure();
            } catch (Throwable th5) {
                QLog.e("O3_CollectInfo", 2, "error! " + th5);
                return false;
            }
        }
        return false;
    }

    private static String y() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("available", Long.valueOf(statFs.getAvailableBytes()));
            arrayMap.put("free", Long.valueOf(statFs.getFreeBytes()));
            arrayMap.put("total", Long.valueOf(statFs.getTotalBytes()));
            return arrayMap.toString();
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }

    private static String z(Context context) {
        SensorManager sensorManager;
        if (context == null) {
            return "";
        }
        try {
            if (!GuardManager.sInstance.isApplicationForeground() || (sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)) == null) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayMap arrayMap = new ArrayMap();
            List<Sensor> sensorList = SensorMonitor.getSensorList(sensorManager, -1);
            if (sensorList == null) {
                return "";
            }
            for (Sensor sensor : sensorList) {
                arrayMap.put("Sensor Type", String.valueOf(sensor.getType()));
                arrayMap.put("Sensor Name", sensor.getName());
                arrayMap.put("Sensor Version", String.valueOf(sensor.getVersion()));
                arrayMap.put("Sensor Vendor", String.valueOf(sensor.getVendor()));
                arrayMap.put("Maximum Range", String.valueOf(sensor.getMaximumRange()));
                arrayMap.put("Minimum Delay", String.valueOf(sensor.getMinDelay()));
                arrayMap.put("Power", String.valueOf(sensor.getPower()));
                arrayMap.put("Resolution", String.valueOf(sensor.getResolution()));
                arrayList.add(arrayMap.toString());
                arrayMap.clear();
            }
            return com.tencent.qqprotect.qsec.utils.c.a(arrayList.toString());
        } catch (Throwable th5) {
            QLog.e("O3_CollectInfo", 2, "error! " + th5);
            return "";
        }
    }
}
