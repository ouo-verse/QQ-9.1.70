package com.tencent.mobileqq.utils;

import OnlinePushPack.DeviceInfo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.util.QQDeviceInfo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ah extends m {

    /* renamed from: d, reason: collision with root package name */
    private static String f307403d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f307404e = "";

    /* renamed from: f, reason: collision with root package name */
    private static long f307405f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static long f307406g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static int f307407h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static float f307408i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public static int f307409j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static String f307410k = null;

    /* renamed from: l, reason: collision with root package name */
    private static String f307411l = null;

    /* renamed from: m, reason: collision with root package name */
    public static int f307412m = -1;

    /* renamed from: n, reason: collision with root package name */
    private static long f307413n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static long f307414o = 0;

    /* renamed from: p, reason: collision with root package name */
    private static DeviceInfo f307415p = null;

    /* renamed from: q, reason: collision with root package name */
    private static int f307416q = -1;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f307417a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f307418b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f307419c = "";
    }

    public static String A() {
        String str = f307404e;
        if (str != null && str.length() > 0) {
            return f307404e;
        }
        try {
            BaseApplication context = BaseApplication.getContext();
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PRIVILEGED_PHONE_STATE") == 0) {
                f307404e = DeviceInfoMonitor.getSubscriberId((TelephonyManager) context.getSystemService("phone"));
            }
        } catch (Exception e16) {
            QLog.e("DeviceInfoUtil", 1, "getIMSI failed!", e16);
        }
        return f307404e;
    }

    public static String B() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            String str = "";
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            bufferedReader.close();
                            fileInputStream.close();
                        }
                    } catch (Throwable th5) {
                        try {
                            bufferedReader.close();
                            fileInputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        throw th5;
                    }
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            bufferedReader.close();
            fileInputStream.close();
            if (str == "") {
                return "";
            }
            try {
                String substring = str.substring(str.indexOf("version ") + 8);
                return substring.substring(0, substring.indexOf(" "));
            } catch (IndexOutOfBoundsException e19) {
                e19.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException e26) {
            e26.printStackTrace();
            return "";
        }
    }

    public static String C() {
        return Build.MANUFACTURER;
    }

    public static String D() {
        try {
            try {
                Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "ro.product.manufacturer");
            } catch (Exception unused) {
                return Build.MANUFACTURER;
            }
        } catch (Exception unused2) {
            return "";
        }
    }

    public static long E() {
        return Runtime.getRuntime().maxMemory();
    }

    public static String F() {
        return DeviceInfoMonitor.getModel();
    }

    public static a G(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        a aVar = new a();
        aVar.f307419c = telephonyManager.getNetworkOperatorName();
        if (recentNetworkInfo != null && recentNetworkInfo.isAvailable()) {
            int type = NetworkMonitor.getType(recentNetworkInfo);
            if (type != 9) {
                switch (type) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        I(context, telephonyManager, aVar);
                        break;
                    case 1:
                    case 6:
                        aVar.f307417a = Global.TRACKING_WIFI;
                        break;
                    default:
                        aVar.f307417a = "unknown";
                        aVar.f307418b = "unknown";
                        break;
                }
            } else {
                aVar.f307417a = "cable";
            }
        }
        return aVar;
    }

    public static int H(Context context) {
        String simOperator;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || telephonyManager.getSimState() == 1 || (simOperator = DeviceInfoMonitor.getSimOperator(telephonyManager)) == null) {
            return 0;
        }
        if (simOperator.startsWith("46000") || simOperator.startsWith("46002") || simOperator.startsWith("46007") || simOperator.startsWith("46008")) {
            return 1;
        }
        if (!simOperator.startsWith("46001") && !simOperator.startsWith("46006") && !simOperator.startsWith("46009")) {
            if (!simOperator.startsWith("46003") && !simOperator.startsWith("46005") && !simOperator.startsWith("46011")) {
                return 0;
            }
            return 3;
        }
        return 2;
    }

    private static void I(Context context, TelephonyManager telephonyManager, a aVar) {
        int i3;
        try {
            NetworkInfo p16 = p(context);
            if (p16 != null) {
                i3 = NetworkMonitor.getSubtype(p16);
            } else {
                i3 = NetworkMonitor.getNetworkType(telephonyManager);
            }
        } catch (Exception e16) {
            QLog.e("DeviceInfoUtil", 1, "getNetworkType error:" + e16);
            i3 = 0;
        }
        switch (i3) {
            case 0:
                aVar.f307417a = "2G";
                aVar.f307418b = "unknown";
                return;
            case 1:
                aVar.f307417a = "2G";
                aVar.f307418b = "GPRS";
                return;
            case 2:
                aVar.f307417a = "2G";
                aVar.f307418b = "EDGE";
                return;
            case 3:
                aVar.f307417a = "3G";
                aVar.f307418b = "UMTS";
                return;
            case 4:
                aVar.f307417a = "2G";
                aVar.f307418b = "CDMA";
                return;
            case 5:
                aVar.f307417a = "3G";
                aVar.f307418b = "EVDO_0";
                return;
            case 6:
                aVar.f307417a = "3G";
                aVar.f307418b = "EVDO_A";
                return;
            case 7:
                aVar.f307417a = "2G";
                aVar.f307418b = "1xRTT";
                return;
            case 8:
                aVar.f307417a = "3G";
                aVar.f307418b = "SDPA";
                return;
            case 9:
                aVar.f307417a = "3G";
                aVar.f307418b = "HSUPA";
                return;
            case 10:
                aVar.f307417a = "3G";
                aVar.f307418b = "HSPA";
                return;
            case 11:
                aVar.f307417a = "2G";
                aVar.f307418b = "IDEN";
                return;
            case 12:
                aVar.f307417a = "3G";
                aVar.f307418b = "EVDO_B";
                return;
            case 13:
                aVar.f307417a = "4G";
                aVar.f307418b = "LTE";
                return;
            case 14:
                aVar.f307417a = "3G";
                aVar.f307418b = "EHRPD";
                return;
            case 15:
                aVar.f307417a = "3G";
                aVar.f307418b = "HSPAP";
                return;
            default:
                aVar.f307417a = "2G";
                aVar.f307418b = "unknown";
                return;
        }
    }

    @SuppressLint({"NewApi"})
    public static final int J() {
        if (f307412m == -1) {
            f307412m = Runtime.getRuntime().availableProcessors();
        }
        return f307412m;
    }

    public static int K() {
        return Build.VERSION.SDK_INT;
    }

    public static long L() {
        c0();
        if (f307407h == 2) {
            return f307405f;
        }
        return f307406g;
    }

    public static long M() {
        return N(false);
    }

    public static long N(boolean z16) {
        d0(z16);
        if (f307407h == 2) {
            return f307406g;
        }
        return f307405f;
    }

    @SuppressLint({"PrivateApi"})
    public static Map<String, Integer> O(Context context) {
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo;
        HashMap hashMap = new HashMap(9);
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                if (activityManager != null && (processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{Process.myPid()})) != null && processMemoryInfo.length > 0 && (memoryInfo = processMemoryInfo[0]) != null) {
                    for (Map.Entry<String, String> entry : memoryInfo.getMemoryStats().entrySet()) {
                        hashMap.put(entry.getKey(), Integer.valueOf(Integer.parseInt(entry.getValue())));
                    }
                }
            } catch (Throwable th5) {
                QLog.e("DeviceInfoUtil", 1, th5, new Object[0]);
            }
        }
        return hashMap;
    }

    public static String P() {
        if (!TextUtils.isEmpty(f307410k)) {
            return f307410k;
        }
        try {
            BaseApplication context = BaseApplication.getContext();
            f307410k = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            f307410k = "getVersionException";
        }
        return f307410k;
    }

    public static String Q(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(f307411l)) {
            return f307411l;
        }
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 0)) != null) {
                    String str = packageInfo.versionName + "." + packageInfo.versionCode;
                    f307411l = str;
                    return str;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        String str2 = AppSetting.f99551k + ".0";
        f307411l = str2;
        return str2;
    }

    public static String R() {
        BaseApplication context = BaseApplication.getContext();
        int i3 = context.getResources().getDisplayMetrics().widthPixels;
        int i16 = context.getResources().getDisplayMetrics().heightPixels;
        if (context.getResources().getConfiguration().orientation == 2) {
            i16 = i3;
            i3 = i16;
        }
        return i3 + "X" + i16;
    }

    public static String S() {
        return Build.DISPLAY;
    }

    public static long[] T() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return new long[]{Y() / 1048576, (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1048576};
        } catch (Exception e16) {
            e16.printStackTrace();
            return new long[]{-1, -1};
        }
    }

    public static long[] U() {
        try {
            long[] jArr = new long[2];
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockSize = statFs.getBlockSize();
                long blockCount = statFs.getBlockCount();
                long availableBlocks = statFs.getAvailableBlocks();
                jArr[0] = (blockCount * blockSize) / 1048576;
                jArr[1] = (blockSize * availableBlocks) / 1048576;
            }
            return jArr;
        } catch (Exception e16) {
            e16.printStackTrace();
            return new long[]{-1, -1};
        }
    }

    public static int V(Activity activity) {
        if (activity != null) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
                return 3;
            }
            if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public static double W() {
        try {
            DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
            return Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static long X() {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            try {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.availMem;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("DeviceInfoUtil", 2, "getSystemAvaialbeMemory call the getMemoryInfo method failed:", e16);
                }
            }
        }
        return -1L;
    }

    public static long Y() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static long Z() {
        int i3;
        long max;
        c0();
        int i16 = f307407h;
        if (i16 == 1) {
            max = Math.min(f307405f, f307406g);
        } else if (i16 == 2) {
            max = Math.max(f307405f, f307406g);
        } else {
            i3 = 0;
            return i3;
        }
        i3 = (int) max;
        return i3;
    }

    private static void a0(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Exception e16;
        long j3;
        int n3 = n();
        for (int i3 = 0; i3 < n3; i3++) {
            BufferedReader bufferedReader2 = null;
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/" + str);
                try {
                    bufferedReader = new BufferedReader(fileReader, 1024);
                } catch (Exception e17) {
                    bufferedReader = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e18) {
                bufferedReader = null;
                e16 = e18;
                fileReader = null;
            } catch (Throwable th6) {
                th = th6;
                fileReader = null;
            }
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        j3 = Long.parseLong(readLine);
                    } else {
                        j3 = 0;
                    }
                    if (f307414o < j3) {
                        f307414o = j3;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("DeviceInfoUtil", 2, String.format(Locale.getDefault(), "initCpuFreq  [%d, %d Khz]", Integer.valueOf(i3), Long.valueOf(j3)));
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                    try {
                        fileReader.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                } catch (Exception e27) {
                    e16 = e27;
                    e16.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e28) {
                            e28.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e29) {
                        e29.printStackTrace();
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        throw th;
                    } catch (Exception e36) {
                        e36.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        }
    }

    private static void b0() {
        a0("cpuinfo_max_freq");
    }

    private static void c0() {
        d0(false);
    }

    public static int d(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("46000") && !str.startsWith("46002") && !str.startsWith("46007") && !str.startsWith("46008")) {
                if (!str.startsWith("46001") && !str.startsWith("46006") && !str.startsWith("46009")) {
                    if (!str.startsWith("46003") && !str.startsWith("46005") && !str.startsWith("46011")) {
                        if (str.startsWith("46020")) {
                            return 4;
                        }
                        if (str.startsWith("46004")) {
                            return 5;
                        }
                    } else {
                        return 3;
                    }
                } else {
                    return 2;
                }
            } else {
                return 1;
            }
        }
        return 0;
    }

    private static void d0(boolean z16) {
        if (f307405f == 0 || f307406g == 0 || z16) {
            BaseApplication context = BaseApplication.getContext();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f307405f = displayMetrics.widthPixels;
            f307406g = displayMetrics.heightPixels;
            f307408i = displayMetrics.density;
            f307409j = displayMetrics.densityDpi;
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                f307407h = configuration.orientation;
                if (QLog.isColorLevel()) {
                    QLog.i("DeviceInfoUtil", 2, "initDispalyParams, [" + f307407h + "," + f307405f + "," + f307406g + "]");
                }
            }
        }
    }

    public static String e() {
        String string = DeviceInfoMonitor.getString(BaseApplication.getContext().getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return "";
    }

    public static boolean e0(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.hasSystemFeature("com.sec.feature.folder_type") && packageManager.hasSystemFeature("com.sec.feature.dual_lcd")) {
            return true;
        }
        return false;
    }

    public static int f(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static boolean f0(Context context) {
        if (context.getResources().getConfiguration().hardKeyboardHidden == 1) {
            return true;
        }
        return false;
    }

    public static long g(int i3) {
        return SystemMethodProxy.getPss() * 1024;
    }

    public static boolean g0() {
        return Build.MANUFACTURER.equalsIgnoreCase("honor");
    }

    public static int h() {
        try {
            Method method = Class.forName("android.hardware.Camera").getMethod("getNumberOfCameras", new Class[0]);
            if (method == null) {
                return 0;
            }
            return ((Integer) method.invoke(null, null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean h0() {
        return Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI);
    }

    public static final int i() {
        String imsi = QQDeviceInfo.getIMSI("7411ce");
        if (!TextUtils.isEmpty(imsi)) {
            if (!imsi.startsWith("46000") && !imsi.startsWith("46002")) {
                if (imsi.startsWith("46001")) {
                    return 2;
                }
                if (imsi.startsWith("46003")) {
                    return 3;
                }
            } else {
                return 1;
            }
        }
        return 0;
    }

    public static boolean i0() {
        if (!h0() && !g0()) {
            return false;
        }
        return true;
    }

    public static ArrayList<Integer> j() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        TelephonyManager telephonyManager = (TelephonyManager) BaseApplication.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            if (QLog.isColorLevel()) {
                QLog.d("DeviceInfoUtil", 2, "getCarrierList, but telephonyManager = null");
            }
            return arrayList;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int d16 = d(DeviceInfoMonitor.getSimOperator(telephonyManager));
            arrayList.add(Integer.valueOf(d16));
            if (QLog.isColorLevel()) {
                QLog.d("DeviceInfoUtil", 2, "getCarrierList, sdk < 22, carrier = " + d16);
            }
            return arrayList;
        }
        try {
            Object invoke = telephonyManager.getClass().getMethod("getSimCount", new Class[0]).invoke(telephonyManager, new Object[0]);
            if (invoke instanceof Integer) {
                int intValue = ((Integer) invoke).intValue();
                Class<?> cls = Class.forName("android.telephony.SubscriptionManager");
                Object invoke2 = cls.getMethod("from", Context.class).invoke(null, BaseApplication.getContext());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("getSubId", cls2);
                Object[] objArr = new Object[1];
                Method method2 = telephonyManager.getClass().getMethod("getSimOperator", cls2);
                Object[] objArr2 = new Object[1];
                for (int i3 = 0; i3 < intValue; i3++) {
                    objArr[0] = Integer.valueOf(i3);
                    Object invoke3 = method.invoke(invoke2, objArr);
                    if (invoke3 instanceof int[]) {
                        objArr2[0] = Integer.valueOf(((int[]) invoke3)[0]);
                        Object invoke4 = method2.invoke(telephonyManager, objArr2);
                        if ((invoke4 instanceof String) && !TextUtils.isEmpty((String) invoke4)) {
                            arrayList.add(Integer.valueOf(d((String) invoke4)));
                        }
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (arrayList.isEmpty()) {
            arrayList.add(Integer.valueOf(d(DeviceInfoMonitor.getSimOperator(telephonyManager))));
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append(" ");
            }
            QLog.d("DeviceInfoUtil", 2, "getCarrierList, sdk >= 22, carrier = " + sb5.toString());
        }
        return arrayList;
    }

    public static boolean j0() {
        return DeviceInfoMonitor.getModel().contains("Lenovo A750");
    }

    public static int k(Context context) {
        TelephonyManager telephonyManager;
        String simOperator;
        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || telephonyManager.getSimState() == 1 || (simOperator = DeviceInfoMonitor.getSimOperator(telephonyManager)) == null) {
            return 0;
        }
        if (simOperator.startsWith("46000") || simOperator.startsWith("46002") || simOperator.startsWith("46007") || simOperator.startsWith("46008")) {
            return 1;
        }
        if (!simOperator.startsWith("46001") && !simOperator.startsWith("46006") && !simOperator.startsWith("46009")) {
            if (!simOperator.startsWith("46003") && !simOperator.startsWith("46005") && !simOperator.startsWith("46011")) {
                return 0;
            }
            return 3;
        }
        return 2;
    }

    public static boolean k0() {
        int i3;
        if (f307416q == -1) {
            long c16 = m.c();
            if (J() > 2 && (c16 > WebViewConstants.WV.ENABLE_WEBAIO_SWITCH || c16 == 0)) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            f307416q = i3;
        }
        if (f307416q == 0) {
            return true;
        }
        return false;
    }

    public static long l() {
        BufferedReader bufferedReader;
        long j3 = f307413n;
        if (j3 > 0) {
            return j3;
        }
        int n3 = n();
        int i3 = 0;
        while (f307413n <= 0 && i3 < n3) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq"), 1024);
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    long parseLong = Long.parseLong(readLine);
                    f307413n = parseLong;
                    f307413n = parseLong / 1024;
                }
                bufferedReader.close();
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused3) {
                    }
                }
                i3++;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getCpuFrequency = ");
            sb5.append(f307413n);
            sb5.append("; CpuNum = ");
            sb5.append(i3 - 1);
            QLog.d("DeviceInfoUtil", 2, sb5.toString());
        }
        return f307413n;
    }

    public static boolean l0() {
        String model = DeviceInfoMonitor.getModel();
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO") && model.contains("X907")) {
            return true;
        }
        return false;
    }

    public static long m() {
        if (f307414o == 0) {
            b0();
        }
        return f307414o;
    }

    public static boolean m0() {
        String F = F();
        if (!TextUtils.isEmpty(F)) {
            F.equals("Lenovo A366t");
            return false;
        }
        return false;
    }

    public static int n() {
        return J();
    }

    public static boolean n0() {
        if (p0() && e0(BaseApplication.getContext()) && !f0(BaseApplication.getContext())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String o() {
        BufferedReader bufferedReader;
        String str = "";
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
                String str2 = " ";
                String str3 = " ";
                String str4 = str3;
                String str5 = str4;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("\\s+");
                        if (split != null && split.length >= 3) {
                            String lowerCase = split[0].toLowerCase();
                            if (lowerCase.contains("processor")) {
                                str2 = str2 + u0(split, 2, split.length).replaceAll(":", "$");
                            }
                            if (lowerCase.contains("mips")) {
                                str3 = u0(split, 2, split.length).replaceAll(":", "$");
                            }
                            if (lowerCase.contains(com.tencent.rmonitor.base.config.data.k.FEATURES_KEY)) {
                                str4 = u0(split, 2, split.length).replaceAll(":", "$");
                            }
                            if (split[1].toLowerCase().contains("architecture")) {
                                str5 = split[split.length - 1];
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                        fileReader = fileReader2;
                        try {
                            e.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return str;
                        } catch (Throwable th5) {
                            th = th5;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (bufferedReader == null) {
                                try {
                                    bufferedReader.close();
                                    throw th;
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileReader = fileReader2;
                        if (fileReader != null) {
                        }
                        if (bufferedReader == null) {
                        }
                    }
                }
                str = str2 + ProgressTracer.SEPARATOR + str3 + ProgressTracer.SEPARATOR + str4 + ProgressTracer.SEPARATOR + str5;
                bufferedReader.close();
                fileReader2.close();
            } catch (Exception e17) {
                e = e17;
                bufferedReader = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = null;
            }
        } catch (Exception e18) {
            e = e18;
            bufferedReader = null;
        } catch (Throwable th8) {
            th = th8;
            bufferedReader = null;
        }
        return str;
    }

    public static boolean o0() {
        return Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
    }

    private static NetworkInfo p(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static boolean p0() {
        return Build.MANUFACTURER.equalsIgnoreCase("Samsung");
    }

    public static float q() {
        c0();
        return f307408i;
    }

    public static boolean q0() {
        return BaseApplication.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch");
    }

    public static DeviceInfo r() {
        if (f307415p == null) {
            DeviceInfo deviceInfo = new DeviceInfo();
            f307415p = deviceInfo;
            deviceInfo.strDevType = DeviceInfoMonitor.getModel();
            f307415p.strOSVer = Build.VERSION.RELEASE;
            f307415p.strVendorName = ROMUtil.getRomName();
            f307415p.strVendorOSName = ROMUtil.getRomVersion(20);
        }
        f307415p.cNetType = (byte) NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        return f307415p;
    }

    public static boolean r0() {
        return true;
    }

    public static String s() {
        return DeviceInfoMonitor.getModel();
    }

    public static boolean s0() {
        boolean t06 = t0();
        if (!t06) {
            for (String str : Build.SUPPORTED_ABIS) {
                if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(ResourceAttributes.HostArchValues.X86)) {
                    t06 = true;
                }
            }
        }
        if (!t06 && QLog.isColorLevel()) {
            QLog.d("DeviceInfoUtil", 2, "os.arch: " + System.getProperty("os.arch"));
            QLog.d("DeviceInfoUtil", 2, "DeviceInfoUtil#getCpuType: " + o());
            QLog.d("DeviceInfoUtil", 2, "Build.CPU_ABI: " + Build.CPU_ABI);
            QLog.d("DeviceInfoUtil", 2, "Build.CPU_ABI2: " + Build.CPU_ABI2);
            QLog.d("DeviceInfoUtil", 2, "isX86: " + t06);
            QLog.d("DeviceInfoUtil", 2, "Build.SUPPORTED_ABIS: " + Arrays.toString(Build.SUPPORTED_ABIS));
        }
        return t06;
    }

    public static String t() {
        return Build.VERSION.RELEASE;
    }

    public static boolean t0() {
        String str = Build.CPU_ABI;
        String str2 = Build.CPU_ABI2;
        if (QLog.isColorLevel()) {
            QLog.d("DeviceInfoUtil", 2, "isX86Platform: Build.CPU_ABI=" + str + " Build.CPU_ABI2=" + str2);
        }
        if (str != null && !"".equals(str) && ResourceAttributes.HostArchValues.X86.equalsIgnoreCase(str)) {
            return true;
        }
        if (AVCoreSystemInfo.getCpuArchitecture() == 7) {
            if (QLog.isColorLevel()) {
                QLog.d("DeviceInfoUtil", 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int u() {
        int i3;
        if ((m.c() >>> 20) >= 600) {
            i3 = 1;
            if (n() != 1) {
                if ((m.c() >>> 20) >= 1536.0d && n() >= 4) {
                    i3 = 2;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DeviceInfoUtil", 2, "getDeviceType,DeviceInfoUtil.getSystemTotalMemory() =" + (m.c() >>> 20) + ",DeviceInfoUtil.getCpuNumber() = " + n() + ",phoneType = " + i3);
                }
                return i3;
            }
        }
        i3 = 0;
        if (QLog.isColorLevel()) {
        }
        return i3;
    }

    private static String u0(String[] strArr, int i3, int i16) {
        String str = "";
        if (strArr == null) {
            return "";
        }
        if (i3 >= 0 && strArr.length >= i16) {
            for (int i17 = 2; i17 < strArr.length; i17++) {
                str = str + strArr[i17] + " ";
            }
        }
        return str;
    }

    public static int v() {
        c0();
        return f307409j;
    }

    public static long w() {
        c0();
        return f307406g;
    }

    public static long x() {
        c0();
        return f307405f;
    }

    public static long y() {
        int i3;
        long min;
        c0();
        int i16 = f307407h;
        if (i16 == 1) {
            min = Math.max(f307405f, f307406g);
        } else if (i16 == 2) {
            min = Math.min(f307405f, f307406g);
        } else {
            i3 = 0;
            return i3;
        }
        i3 = (int) min;
        return i3;
    }

    public static String z() {
        return f307403d;
    }
}
