package cooperation.qzone.sim;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.rmonitor.base.config.data.k;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.util.QZLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes38.dex */
public class DeviceInfoUtil {
    public static final int BUFFER_SIZE = 1024;
    public static final String TAG = "UniKingCardHelper/DeviceInfoUtil";
    private static final String TOP_COMMADN_CPU_PROCESS = "top -n 1 -m 10";
    private static final String TOP_COMMADN_CPU_THREAD = "top -n 1 -m 10 -t";
    private static String appVersionWithCode = null;
    private static String channelName = null;
    public static float density = 1.0f;
    public static int densityDpi = 0;
    private static String deviceId = "";
    private static String imsi = null;
    private static String localMacAddress = null;
    private static boolean mRegisterHandler = false;
    private static int orientation;
    private static long screenHeight;
    private static long screenWidth;

    public static String getAppMetaValue(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str, "");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String getAppVersion(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "getVersionException";
        }
    }

    public static String getAppVersionWithCode(Context context) {
        if (!TextUtils.isEmpty(appVersionWithCode)) {
            return appVersionWithCode;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            if (packageInfo != null) {
                String str = packageInfo.versionName + "." + packageInfo.versionCode;
                appVersionWithCode = str;
                return str;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return appVersionWithCode;
    }

    public static int getCpuNumber() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: cooperation.qzone.sim.DeviceInfoUtil.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuType() {
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
                                str2 = str2 + subStrings2String(split, 2, split.length).replaceAll(":", "$");
                            }
                            if (lowerCase.contains("mips")) {
                                str3 = subStrings2String(split, 2, split.length).replaceAll(":", "$");
                            }
                            if (lowerCase.contains(k.FEATURES_KEY)) {
                                str4 = subStrings2String(split, 2, split.length).replaceAll(":", "$");
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

    public static SimInfo getDataSimInfo(Context context) {
        SimManager simManager = SimManager.getInstance(DeviceInfoMonitor.getModel(), Build.VERSION.SDK_INT);
        simManager.initAllInfo(context);
        return simManager.getDataSimInfo();
    }

    public static String getDeviceBrand() {
        String str = Build.BRAND;
        return str == null ? "" : str;
    }

    public static String getDeviceModel() {
        String model = DeviceInfoMonitor.getModel();
        return model == null ? "" : model;
    }

    public static String getDeviceOSVersion() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "" : str;
    }

    public static String getIMEI(Context context) {
        String str = deviceId;
        if (str != null && str.length() > 0) {
            return deviceId;
        }
        String imei = PlatformInfor.g().getIMEI();
        deviceId = imei;
        if (imei == null) {
            deviceId = "";
        }
        return deviceId;
    }

    public static int getOsVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getPhoneNum(Context context) {
        return "";
    }

    public static String getProcessName(Context context) {
        int myPid = Process.myPid();
        if (context != null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                }
            } catch (Exception e16) {
                QZLog.e(TAG, "exception happened!" + e16.getMessage());
            }
        }
        return "";
    }

    public static int getVersionCode(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e16) {
            QZLog.e("AppSetting", "getVersionCode error:" + e16.getMessage());
            return 0;
        }
    }

    private static String subStrings2String(String[] strArr, int i3, int i16) {
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getCpuFrequency() {
        FileReader fileReader;
        Exception e16;
        FileReader fileReader2 = null;
        try {
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            } catch (Exception e17) {
                fileReader = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (fileReader2 != null) {
                }
                throw th;
            }
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                String readLine = bufferedReader.readLine();
                r0 = readLine != null ? Long.parseLong(readLine) / 1024 : 0L;
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th6) {
                th = th6;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e26) {
            e16 = e26;
            e16.printStackTrace();
            if (fileReader != null) {
                fileReader.close();
            }
            return r0;
        }
        return r0;
    }

    public static int getVersionCode(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e16) {
            QZLog.e("AppSetting", "getVersionCode error:" + e16.getMessage());
            return 0;
        }
    }
}
