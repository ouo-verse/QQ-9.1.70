package com.tencent.camerasdk.avreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DeviceInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String[] SU_FILES;
    private static final String TAG = "MobileBase-DeviceInfo";
    private static final String[] VM_APPS;
    private static final String[] VM_FILES;
    private static String roDebuggable;
    private static String roSecure;
    private static Map<String, String> systemProperties;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SU_FILES = new String[]{"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
        VM_APPS = new String[]{"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};
        VM_FILES = new String[]{"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};
        systemProperties = null;
        roSecure = null;
        roDebuggable = null;
    }

    DeviceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkIsHaveCard() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when checking external card.", th5);
            return false;
        }
    }

    public static List<String> executeCommand(Context context, String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        if (AppInfo.isLowMemory(context)) {
            return new ArrayList(Collections.singletonList("unknown(low memory)"));
        }
        ArrayList arrayList = new ArrayList();
        try {
            String str2 = "/system/bin/sh";
            if (!new File("/system/bin/sh").exists() || !new File("/system/bin/sh").canExecute()) {
                str2 = "sh";
            }
            ArrayList arrayList2 = new ArrayList(Arrays.asList(str2, LogCmdOptions.CLEAR));
            arrayList2.add(str);
            Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), (String[]) arrayList2.toArray(new String[3]));
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader2 = null;
                }
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        try {
                            break;
                        } catch (IOException e16) {
                            AVRLogUtils.e(TAG, "Exception occurred when getting process name.", e16);
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        AVRLogUtils.w(TAG, "Exception occurred when executing command.", th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e17) {
                                AVRLogUtils.e(TAG, "Exception occurred when getting process name.", e17);
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e18) {
                                AVRLogUtils.e(TAG, "Exception occurred when getting process name.", e18);
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            }
            bufferedReader.close();
            try {
                bufferedReader2.close();
            } catch (IOException e19) {
                AVRLogUtils.e(TAG, "Exception occurred when getting process name.", e19);
            }
            return arrayList;
        } catch (Throwable th7) {
            th = th7;
            bufferedReader = null;
            bufferedReader2 = null;
        }
    }

    public static String formatIpAddress(int i3) {
        if (i3 < 0) {
            return "null";
        }
        return (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
    }

    @SuppressLint({"HardwareIds"})
    public static String getAndroidId(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            str = "0";
            return "0".toLowerCase();
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting Android ID.", th5);
            return str;
        }
    }

    public static int getApiLevelInt() {
        try {
            return DeviceInstance.getSDKVersion();
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting API level.", th5);
            return -1;
        }
    }

    public static String getBrand() {
        try {
            return DeviceInstance.PHONE_BRAND;
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting brand.", th5);
            return "fail";
        }
    }

    public static String getCountry() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting country name.", th5);
            return "fail";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0054, code lost:
    
        r1 = java.lang.System.getProperty("os.arch");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuAbi(Context context, boolean z16) {
        String str = null;
        if (z16) {
            try {
                String systemProperty = getSystemProperty(context, "ro.product.cpu.abilist");
                if (TextUtils.isEmpty(systemProperty) || systemProperty.equals("fail")) {
                    systemProperty = getSystemProperty(context, TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI);
                }
                if (!TextUtils.isEmpty(systemProperty) && !systemProperty.equals("fail")) {
                    AVRLogUtils.d(TAG, "ABI list: " + systemProperty);
                    str = systemProperty.split(",")[0];
                }
            } catch (Throwable th5) {
                AVRLogUtils.w(TAG, "Exception occurred when getting CPU ABI.", th5);
                return "fail";
            }
        }
        return "" + str;
    }

    public static String getCpuName(Context context) {
        return getSystemProperty(context, "ro.board.platform");
    }

    public static String getDebugInfo(Context context) {
        BufferedReader bufferedReader;
        Throwable th5;
        String readLine;
        StringBuilder sb5 = new StringBuilder();
        if (roSecure == null) {
            roSecure = getSystemProperty(context, "ro.secure");
        }
        if (roSecure != null) {
            sb5.append("ro.secure");
            sb5.append("|");
            sb5.append(roSecure);
            sb5.append("\n");
        }
        if (roDebuggable == null) {
            roDebuggable = getSystemProperty(context, "ro.debuggable");
        }
        if (roDebuggable != null) {
            sb5.append("ro.debuggable");
            sb5.append("|");
            sb5.append(roDebuggable);
            sb5.append("\n");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    try {
                        AVRLogUtils.w(TAG, "Exception occurred when getting debug information.", th5);
                        return sb5.toString();
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e16) {
                                AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e16);
                            }
                        }
                    }
                }
            } while (!readLine.startsWith("TracerPid:"));
            if (readLine != null) {
                String trim = readLine.substring(10).trim();
                sb5.append("tracer_pid");
                sb5.append("|");
                sb5.append(trim);
            }
            String sb6 = sb5.toString();
            try {
                bufferedReader.close();
            } catch (IOException e17) {
                AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e17);
            }
            return sb6;
        } catch (Throwable th7) {
            bufferedReader = null;
            th5 = th7;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0038 -> B:11:0x004d). Please report as a decompilation issue!!! */
    public static long getDeviceBootTime(Context context) {
        BufferedReader bufferedReader;
        Throwable th5;
        float f16 = 0.0f;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/uptime"));
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    f16 = (((float) System.currentTimeMillis()) / 1000.0f) - Float.parseFloat(readLine.split(" ")[0]);
                }
                bufferedReader.close();
            } catch (Throwable th7) {
                th5 = th7;
                try {
                    AVRLogUtils.w(TAG, "Exception occurred when getting boot time of device.", th5);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return f16;
                } catch (Throwable th8) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e16) {
                            AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e16);
                        }
                    }
                    throw th8;
                }
            }
        } catch (IOException e17) {
            AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e17);
        }
        return f16;
    }

    public static String getDeviceName() {
        try {
            return DeviceInstance.PHONE_MODEL;
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting device name.", th5);
            return "fail";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00be A[Catch: IOException -> 0x00c2, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x00c2, blocks: (B:20:0x00be, B:61:0x00b1), top: B:2:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getElectronicfo() {
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                if (new File("/sys/class/power_supply/ac/online").exists()) {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/sys/class/power_supply/ac/online"));
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb5.append("ac_online");
                            sb5.append("|");
                            sb5.append(readLine);
                        }
                        bufferedReader2.close();
                        bufferedReader = bufferedReader2;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        try {
                            AVRLogUtils.w(TAG, "Exception occurred when getting debug information.", th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb5.toString();
                        } catch (Throwable th6) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e16) {
                                    AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e16);
                                }
                            }
                            throw th6;
                        }
                    }
                }
                sb5.append("\n");
                if (new File("/sys/class/power_supply/usb/online").exists()) {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader("/sys/class/power_supply/usb/online"));
                    try {
                        String readLine2 = bufferedReader3.readLine();
                        if (readLine2 != null) {
                            sb5.append("usb_online");
                            sb5.append("|");
                            sb5.append(readLine2);
                        }
                        bufferedReader3.close();
                        bufferedReader = bufferedReader3;
                    } catch (Throwable th7) {
                        th = th7;
                        bufferedReader = bufferedReader3;
                        AVRLogUtils.w(TAG, "Exception occurred when getting debug information.", th);
                        if (bufferedReader != null) {
                        }
                        return sb5.toString();
                    }
                }
                sb5.append("\n");
                if (new File("/sys/class/power_supply/battery/capacity").exists()) {
                    BufferedReader bufferedReader4 = new BufferedReader(new FileReader("/sys/class/power_supply/battery/capacity"));
                    try {
                        String readLine3 = bufferedReader4.readLine();
                        if (readLine3 != null) {
                            sb5.append("battery_capacity");
                            sb5.append("|");
                            sb5.append(readLine3);
                        }
                        bufferedReader4.close();
                        bufferedReader = bufferedReader4;
                    } catch (Throwable th8) {
                        th = th8;
                        bufferedReader = bufferedReader4;
                        AVRLogUtils.w(TAG, "Exception occurred when getting debug information.", th);
                        if (bufferedReader != null) {
                        }
                        return sb5.toString();
                    }
                }
            } catch (Throwable th9) {
                th = th9;
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e17) {
            AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e17);
        }
        return sb5.toString();
    }

    @SuppressLint({"HardwareIds"})
    public static String getHardwareSerialNumber() {
        try {
            return DeviceInfoMonitor.getSerialByField();
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting hardware serial number.", th5);
            return "fail";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMmccid() {
        BufferedReader bufferedReader;
        try {
            StringBuilder sb5 = new StringBuilder();
            if (new File("/sys/block/mmcblk0/device/type").exists()) {
                bufferedReader = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/type"));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb5.append(readLine);
                    }
                    bufferedReader.close();
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        AVRLogUtils.w(TAG, "Exception occurred when getting CID of memory card.", th);
                        if (bufferedReader != null) {
                        }
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e16) {
                                AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e16);
                            }
                        }
                    }
                }
            } else {
                bufferedReader = null;
            }
            sb5.append(",");
            if (new File("/sys/block/mmcblk0/device/name").exists()) {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/name"));
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        sb5.append(readLine2);
                    }
                    bufferedReader2.close();
                    bufferedReader = bufferedReader2;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = bufferedReader2;
                    AVRLogUtils.w(TAG, "Exception occurred when getting CID of memory card.", th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e17) {
                            AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e17);
                        }
                    }
                    return null;
                }
            }
            sb5.append(",");
            if (new File("/sys/block/mmcblk0/device/cid").exists()) {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/cid"));
                try {
                    String readLine3 = bufferedReader3.readLine();
                    if (readLine3 != null) {
                        sb5.append(readLine3);
                    }
                    bufferedReader = bufferedReader3;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedReader = bufferedReader3;
                    AVRLogUtils.w(TAG, "Exception occurred when getting CID of memory card.", th);
                    if (bufferedReader != null) {
                    }
                    return null;
                }
            }
            return sb5.toString();
        } catch (Throwable th8) {
            th = th8;
            bufferedReader = null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0039. Please report as an issue. */
    public static String getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        String str;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return null;
            }
            if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                str = Global.TRACKING_WIFI;
            } else {
                if (NetworkMonitor.getType(activeNetworkInfo) != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                    return "unknown";
                }
                int networkType = NetworkMonitor.getNetworkType(telephonyManager);
                switch (networkType) {
                    case 1:
                        str = "GPRS";
                        break;
                    case 2:
                        str = "EDGE";
                        break;
                    case 3:
                        str = "UMTS";
                        break;
                    case 4:
                        str = "CDMA";
                        break;
                    case 5:
                        str = "EVDO_0";
                        break;
                    case 6:
                        str = "EVDO_A";
                        break;
                    case 7:
                        str = "1xRTT";
                        break;
                    case 8:
                        str = "HSDPA";
                        break;
                    case 9:
                        str = "HSUPA";
                        break;
                    case 10:
                        str = "HSPA";
                        break;
                    case 11:
                        str = "iDen";
                        break;
                    case 12:
                        str = "EVDO_B";
                        break;
                    case 13:
                        str = "LTE";
                        break;
                    case 14:
                        str = "eHRPD";
                        break;
                    case 15:
                        str = "HSPA+";
                        break;
                    default:
                        str = "MOBILE(" + networkType + ")";
                        break;
                }
            }
            return str;
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting type of network.", th5);
            return "unknown";
        }
    }

    public static byte getNetworkClass(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting class of network.", th5);
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return (byte) -1;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return (byte) 1;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return (byte) -1;
        }
        switch (NetworkMonitor.getNetworkType(telephonyManager)) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return (byte) 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return (byte) 3;
            case 13:
                return (byte) 4;
            default:
                return (byte) -1;
        }
    }

    public static long getRamAvailSize() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e16) {
                    AVRLogUtils.w(TAG, "Exception occurred when closing buffered reader.", e16);
                }
                try {
                    fileReader.close();
                } catch (IOException e17) {
                    AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e17);
                }
                return -1L;
            }
            long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + 0;
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e18) {
                    AVRLogUtils.w(TAG, "Exception occurred when closing buffered reader.", e18);
                }
                try {
                    fileReader.close();
                } catch (IOException e19) {
                    AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e19);
                }
                return -1L;
            }
            long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            Long.signum(parseLong2);
            long j3 = parseLong + (parseLong2 * 1024);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e26) {
                    AVRLogUtils.w(TAG, "Exception occurred when closing buffered reader.", e26);
                }
                try {
                    fileReader.close();
                } catch (IOException e27) {
                    AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e27);
                }
                return -1L;
            }
            long parseLong3 = j3 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
            try {
                bufferedReader.close();
            } catch (IOException e28) {
                AVRLogUtils.w(TAG, "Exception occurred when closing buffered reader.", e28);
            }
            try {
                fileReader.close();
            } catch (IOException e29) {
                AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e29);
            }
            return parseLong3;
        } catch (Throwable th7) {
            th = th7;
            bufferedReader2 = bufferedReader;
            try {
                AVRLogUtils.w(TAG, "Exception occurred when getting available size of RAM.", th);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e36) {
                        AVRLogUtils.w(TAG, "Exception occurred when closing buffered reader.", e36);
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e37) {
                        AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e37);
                        return -2L;
                    }
                }
                return -2L;
            } finally {
            }
        }
    }

    public static long getRamTotalSize() {
        FileReader fileReader;
        Throwable th5;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th6) {
                th5 = th6;
                bufferedReader = null;
            }
        } catch (Throwable th7) {
            fileReader = null;
            th5 = th7;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e16) {
                    AVRLogUtils.w(TAG, "Exception occurred when closing buffered reader.", e16);
                }
                try {
                    fileReader.close();
                    return -1L;
                } catch (IOException e17) {
                    AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e17);
                    return -1L;
                }
            }
            long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
            try {
                bufferedReader.close();
            } catch (IOException e18) {
                AVRLogUtils.w(TAG, "Exception occurred when closing buffered reader.", e18);
            }
            try {
                fileReader.close();
            } catch (IOException e19) {
                AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e19);
            }
            return parseLong;
        } catch (Throwable th8) {
            th5 = th8;
            try {
                AVRLogUtils.w(TAG, "Exception occurred when getting total size of RAM.", th5);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e26) {
                        AVRLogUtils.w(TAG, "Exception occurred when closing buffered reader.", e26);
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e27) {
                        AVRLogUtils.w(TAG, "Exception occurred when closing file reader.", e27);
                        return -2L;
                    }
                }
                return -2L;
            } finally {
            }
        }
    }

    public static long getRomAvailSize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting available size of ROM.", th5);
            return -1L;
        }
    }

    public static String getRomFingerprint(Context context) {
        String systemProperty = getSystemProperty(context, "ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(systemProperty) && !systemProperty.equals("fail")) {
            return "XiaoMi/MIUI/" + systemProperty;
        }
        String systemProperty2 = getSystemProperty(context, "ro.build.version.emui");
        if (!TextUtils.isEmpty(systemProperty2) && !systemProperty2.equals("fail")) {
            return "HuaWei/EMOTION/" + systemProperty2;
        }
        String systemProperty3 = getSystemProperty(context, "ro.lenovo.series");
        if (!TextUtils.isEmpty(systemProperty3) && !systemProperty3.equals("fail")) {
            return "Lenovo/VIBE/" + getSystemProperty(context, "ro.build.version.incremental");
        }
        String systemProperty4 = getSystemProperty(context, "ro.build.nubia.rom.name");
        if (!TextUtils.isEmpty(systemProperty4) && !systemProperty4.equals("fail")) {
            return "Zte/NUBIA/" + systemProperty4 + "_" + getSystemProperty(context, "ro.build.nubia.rom.code");
        }
        String systemProperty5 = getSystemProperty(context, "ro.meizu.product.model");
        if (!TextUtils.isEmpty(systemProperty5) && !systemProperty5.equals("fail")) {
            return "Meizu/FLYME/" + getSystemProperty(context, "ro.build.display.id");
        }
        String systemProperty6 = getSystemProperty(context, "ro.build.version.opporom");
        if (!TextUtils.isEmpty(systemProperty6) && !systemProperty6.equals("fail")) {
            return "Oppo/COLOROS/" + systemProperty6;
        }
        String systemProperty7 = getSystemProperty(context, "ro.vivo.os.build.display.id");
        if (!TextUtils.isEmpty(systemProperty7) && !systemProperty7.equals("fail")) {
            return "vivo/FUNTOUCH/" + systemProperty7;
        }
        String systemProperty8 = getSystemProperty(context, "ro.aa.romver");
        if (!TextUtils.isEmpty(systemProperty8) && !systemProperty8.equals("fail")) {
            return "htc/" + systemProperty8 + "/" + getSystemProperty(context, ROMUtil.KEY_BUILD_DESCRIPTION);
        }
        String systemProperty9 = getSystemProperty(context, "ro.lewa.version");
        if (!TextUtils.isEmpty(systemProperty9) && !systemProperty9.equals("fail")) {
            return "tcl/" + systemProperty9 + "/" + getSystemProperty(context, "ro.build.display.id");
        }
        String systemProperty10 = getSystemProperty(context, "ro.gn.gnromvernumber");
        if (!TextUtils.isEmpty(systemProperty10) && !systemProperty10.equals("fail")) {
            return "amigo/" + systemProperty10 + "/" + getSystemProperty(context, "ro.build.display.id");
        }
        String systemProperty11 = getSystemProperty(context, "ro.build.tyd.kbstyle_version");
        if (!TextUtils.isEmpty(systemProperty11) && !systemProperty11.equals("fail")) {
            return "dido/" + systemProperty11;
        }
        return "Android";
    }

    public static long getRomTotalSize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting total size of ROM.", th5);
            return -1L;
        }
    }

    public static String getSimInfo(Context context) {
        StringBuilder sb5 = new StringBuilder();
        String systemProperty = getSystemProperty(context, "gsm.sim.state");
        if (systemProperty != null) {
            sb5.append("gsm.sim.state");
            sb5.append("|");
            sb5.append(systemProperty);
        }
        sb5.append("\n");
        String systemProperty2 = getSystemProperty(context, "gsm.sim.state2");
        if (systemProperty2 != null) {
            sb5.append("gsm.sim.state2");
            sb5.append("|");
            sb5.append(systemProperty2);
        }
        return sb5.toString();
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getSimSerialNumber(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "fail";
            }
            if (ActivityCompat.checkSelfPermission(context, DeviceInfoUtil.PERMISSION_READ_PHONE) != 0) {
                str = DeviceInfoMonitor.getSimSerialNumber(telephonyManager);
            }
            if (str == null) {
                return "null";
            }
            return str;
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting SIM serial number.", th5);
            return str;
        }
    }

    public static String getSystemProperty(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (systemProperties == null) {
            systemProperties = new HashMap();
            List<String> executeCommand = executeCommand(context, "getprop");
            if (executeCommand != null && !executeCommand.isEmpty()) {
                AVRLogUtils.d(TAG, "Successfully get 'getprop' list.");
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                Iterator<String> it = executeCommand.iterator();
                while (it.hasNext()) {
                    Matcher matcher = compile.matcher(it.next());
                    if (matcher.find()) {
                        systemProperties.put(matcher.group(1), matcher.group(2));
                    }
                }
                AVRLogUtils.d(TAG, "System properties number: " + systemProperties.size());
            }
        }
        if (systemProperties.containsKey(str)) {
            return systemProperties.get(str);
        }
        return "fail";
    }

    public static String getVersion() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th5) {
            AVRLogUtils.w(TAG, "Exception occurred when getting release version.", th5);
            return "fail";
        }
    }

    public static boolean isDeviceRooted() {
        boolean z16;
        boolean z17;
        String[] strArr = SU_FILES;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (new File(strArr[i3]).exists()) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && !z16) {
            return false;
        }
        return true;
    }
}
