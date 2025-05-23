package com.tencent.avcore.data;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVCoreSystemInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int CHIP_ARM_V5 = 1;
    public static final int CHIP_ARM_V6 = 2;
    public static final int CHIP_ARM_V7_NENO = 4;
    public static final int CHIP_ARM_V7_NO_NENO = 3;
    public static final int CHIP_ARM_V8 = 5;
    public static final int CHIP_MIPS = 6;
    public static final int CHIP_UNKNOWN = 0;
    public static final int CHIP_X86 = 7;
    public static final String SOC_MODEL_EMPTY_VALUE = "null";
    public static final String SOC_MODEL_KEY = "ro.soc.model";
    public static final String TAG = "AVCoreSystemInfo";
    public static int mChip;
    public static int mCoreNumber;
    public static int mCpuArchitecture;
    public static String mFeature;
    public static String mHardware;
    public static boolean mHasReadMemInfo;
    public static boolean mIsMarvell;
    public static boolean mIsSupportSharpAudio;
    public static boolean mIsSupportSharpVideo;
    public static long mMaxCpuFreq;
    public static long mMemoryTotal;
    public static int mOpenGLVersion;
    public static String mProcessorName;
    public static String mVendorId;
    public static boolean mfReadCpuInfo;
    static long mgMaxCpuFreq;
    static int mgNumCores;
    private static String strCPUModel;
    public int mScreenHeight;
    public int mScreenWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13500);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        mProcessorName = "";
        mFeature = "";
        mVendorId = null;
        mHardware = null;
        mCpuArchitecture = 5;
        mMaxCpuFreq = 0L;
        mCoreNumber = 1;
        mfReadCpuInfo = false;
        mMemoryTotal = 0L;
        mHasReadMemInfo = false;
        mOpenGLVersion = 2;
        mChip = 1;
        mIsSupportSharpAudio = true;
        mIsSupportSharpVideo = true;
        mIsMarvell = false;
        getCpuInfo();
        mgNumCores = 0;
        mgMaxCpuFreq = 0L;
    }

    public AVCoreSystemInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mScreenWidth = 320;
            this.mScreenHeight = 480;
        }
    }

    public static String getCPUName() {
        getCpuInfo();
        return mProcessorName;
    }

    public static int getCpuArchitecture() {
        getCpuInfo();
        return mChip;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x029e  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v67 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void getCpuInfo() {
        Throwable th5;
        int readNumCores;
        long readMaxCpuFreq;
        boolean z16;
        int indexOf;
        String trim;
        ?? r36 = 1;
        if (mfReadCpuInfo) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(1024);
        int i3 = 0;
        BufferedReader bufferedReader = null;
        long j3 = -1;
        float f16 = -1.0f;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"));
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.startsWith("Hardware")) {
                                int indexOf2 = readLine.indexOf(58);
                                if (indexOf2 > r36) {
                                    strCPUModel = readLine.substring(indexOf2 + 1, readLine.length()).trim().replace(" ", "");
                                }
                            } else if (readLine.startsWith("Processor")) {
                                int indexOf3 = readLine.indexOf(58);
                                if (indexOf3 > r36) {
                                    String substring = readLine.substring(indexOf3 + 1, readLine.length());
                                    mProcessorName = substring;
                                    mProcessorName = substring.trim();
                                    if (AVCoreLog.isColorLevel()) {
                                        sb5.append("[CpuInfo] mProcessorName=");
                                        sb5.append(mProcessorName);
                                        sb5.append(APLogFileUtil.SEPARATOR_LOG);
                                        sb5.append(readLine);
                                        sb5.append("\n");
                                    }
                                }
                            } else if (readLine.startsWith("CPU architecture")) {
                                int indexOf4 = readLine.indexOf(58);
                                if (indexOf4 > r36 && (trim = readLine.substring(indexOf4 + 1, readLine.length()).trim()) != null && trim.length() > 0) {
                                    if (trim.equalsIgnoreCase("aarch64")) {
                                        mCpuArchitecture = 8;
                                    } else {
                                        try {
                                            mCpuArchitecture = (int) Long.parseLong(trim);
                                        } catch (NumberFormatException unused) {
                                            int i16 = r36;
                                            while (i16 < trim.length()) {
                                                try {
                                                    mCpuArchitecture = (int) Long.parseLong(trim.substring(i3, trim.length() - i16));
                                                    break;
                                                } catch (NumberFormatException unused2) {
                                                    i16++;
                                                    i3 = 0;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (readLine.contains("5TE")) {
                                    mCpuArchitecture = 5;
                                }
                                if (AVCoreLog.isColorLevel()) {
                                    sb5.append("[CpuInfo] mCpuArchitecture=");
                                    sb5.append(mCpuArchitecture);
                                    sb5.append(APLogFileUtil.SEPARATOR_LOG);
                                    sb5.append(readLine);
                                    sb5.append("\n");
                                }
                            } else if (readLine.startsWith("Features")) {
                                int indexOf5 = readLine.indexOf(58);
                                if (indexOf5 > 1) {
                                    mFeature = readLine.substring(indexOf5 + 1, readLine.length()).trim();
                                }
                                if (AVCoreLog.isColorLevel()) {
                                    sb5.append("[CpuInfo] mFeature=");
                                    sb5.append(mFeature);
                                    sb5.append(APLogFileUtil.SEPARATOR_LOG);
                                    sb5.append(readLine);
                                    sb5.append("\n");
                                }
                            } else if (readLine.startsWith("vendor_id")) {
                                int indexOf6 = readLine.indexOf(58);
                                if (indexOf6 > 1) {
                                    mVendorId = readLine.substring(indexOf6 + 1, readLine.length()).trim();
                                }
                                if (AVCoreLog.isColorLevel()) {
                                    sb5.append("[CpuInfo] mVendorId=");
                                    sb5.append(mVendorId);
                                    sb5.append(APLogFileUtil.SEPARATOR_LOG);
                                    sb5.append(readLine);
                                    sb5.append("\n");
                                }
                            } else if (readLine.startsWith("Hardware")) {
                                mHardware = readLine.trim();
                                if (readLine.contains("PXA")) {
                                    mIsMarvell = true;
                                }
                                if (AVCoreLog.isColorLevel()) {
                                    sb5.append("[CpuInfo] mIsMarvell=");
                                    sb5.append(mIsMarvell);
                                    sb5.append(APLogFileUtil.SEPARATOR_LOG);
                                    sb5.append(readLine);
                                    sb5.append("\n");
                                }
                            } else if (readLine.startsWith("processor")) {
                                int indexOf7 = readLine.indexOf(58);
                                if (indexOf7 > 1) {
                                    try {
                                        long parseLong = Long.parseLong(readLine.substring(indexOf7 + 1, readLine.length()).trim());
                                        if (parseLong >= 0) {
                                            long j16 = parseLong + 1;
                                            if (j16 > j3) {
                                                j3 = j16;
                                            }
                                        }
                                    } catch (NumberFormatException unused3) {
                                    }
                                }
                            } else if (readLine.startsWith("BogoMIPS") && (indexOf = readLine.indexOf(58)) > 1) {
                                float parseFloat = Float.parseFloat(readLine.substring(indexOf + 1, readLine.length()).trim());
                                if (parseFloat > f16) {
                                    f16 = parseFloat;
                                }
                            }
                            r36 = 1;
                            i3 = 0;
                        } catch (FileNotFoundException unused4) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (Build.VERSION.SDK_INT >= 31) {
                            }
                            readNumCores = readNumCores();
                            if (readNumCores <= 0) {
                            }
                            readMaxCpuFreq = readMaxCpuFreq();
                            if (readMaxCpuFreq <= 0) {
                            }
                            if (mCoreNumber <= 0) {
                            }
                            if (AVCoreLog.isColorLevel()) {
                            }
                            mfReadCpuInfo = false;
                            mChip = readCpuArchitecture();
                            if (!AVCoreLog.isColorLevel()) {
                            }
                        } catch (IOException unused5) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (Build.VERSION.SDK_INT >= 31) {
                            }
                            readNumCores = readNumCores();
                            if (readNumCores <= 0) {
                            }
                            readMaxCpuFreq = readMaxCpuFreq();
                            if (readMaxCpuFreq <= 0) {
                            }
                            if (mCoreNumber <= 0) {
                            }
                            if (AVCoreLog.isColorLevel()) {
                            }
                            mfReadCpuInfo = false;
                            mChip = readCpuArchitecture();
                            if (!AVCoreLog.isColorLevel()) {
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    throw th5;
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                    } catch (NumberFormatException unused6) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (Build.VERSION.SDK_INT >= 31) {
                        }
                        readNumCores = readNumCores();
                        if (readNumCores <= 0) {
                        }
                        readMaxCpuFreq = readMaxCpuFreq();
                        if (readMaxCpuFreq <= 0) {
                        }
                        if (mCoreNumber <= 0) {
                        }
                        if (AVCoreLog.isColorLevel()) {
                        }
                        mfReadCpuInfo = false;
                        mChip = readCpuArchitecture();
                        if (!AVCoreLog.isColorLevel()) {
                        }
                    }
                }
                mfReadCpuInfo = r36;
                try {
                    bufferedReader2.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            } catch (FileNotFoundException unused7) {
            } catch (IOException unused8) {
            } catch (NumberFormatException unused9) {
            } catch (Throwable th7) {
                th5 = th7;
            }
        } catch (IOException e18) {
            e18.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            if (!"null".equalsIgnoreCase(strCPUModel) && !TextUtils.isEmpty(strCPUModel)) {
                z16 = false;
            } else {
                z16 = true;
            }
            String str = strCPUModel;
            if (z16) {
                str = getCpuModelV31(str);
            }
            strCPUModel = str;
        }
        readNumCores = readNumCores();
        if (readNumCores <= 0) {
            mCoreNumber = readNumCores;
            if (AVCoreLog.isColorLevel()) {
                sb5.append("[CpuInfo] mCoreNumber=");
                sb5.append(mCoreNumber);
                sb5.append("\n");
            }
        } else if (j3 > 0) {
            mCoreNumber = (int) j3;
            if (AVCoreLog.isColorLevel()) {
                sb5.append("[CpuInfo] mCoreNumber(bogoCoreNum)=");
                sb5.append(mCoreNumber);
                sb5.append("\n");
            }
        }
        readMaxCpuFreq = readMaxCpuFreq();
        if (readMaxCpuFreq <= 0) {
            mMaxCpuFreq = readMaxCpuFreq;
            if (AVCoreLog.isColorLevel()) {
                sb5.append("[CpuInfo] mMaxCpuFreq=");
                sb5.append(mMaxCpuFreq);
                sb5.append("\n");
            }
        } else if (f16 > 0.0f) {
            if (f16 < 1200.0f) {
                mMaxCpuFreq = (long) (f16 * 1.2d * 1000.0d);
            } else if (f16 > 2000.0f) {
                mMaxCpuFreq = (long) ((f16 / 1.8d) * 1000.0d);
            } else {
                mMaxCpuFreq = f16 * 1000.0f;
            }
            if (AVCoreLog.isColorLevel()) {
                sb5.append("[CpuInfo] mMaxCpuFreq(bogoMIPS)=");
                sb5.append(mMaxCpuFreq);
                sb5.append("\n");
            }
        }
        if (mCoreNumber <= 0 && mMaxCpuFreq > 0) {
            mfReadCpuInfo = true;
        } else {
            if (AVCoreLog.isColorLevel()) {
                sb5.append("[CpuInfo] read cpu info fail because of coreNumber= ");
                sb5.append(mCoreNumber);
                sb5.append(" or maxCpuFreq=");
                sb5.append(mMaxCpuFreq);
                sb5.append("\n");
            }
            mfReadCpuInfo = false;
        }
        mChip = readCpuArchitecture();
        if (!AVCoreLog.isColorLevel()) {
            sb5.append("[CpuInfo] Chip=");
            sb5.append(mChip);
            sb5.append(", Video=");
            sb5.append(mIsSupportSharpVideo);
            sb5.append(", Audio=");
            sb5.append(mIsSupportSharpAudio);
            sb5.append("\n");
            AVCoreLog.i(TAG, sb5.toString());
        }
    }

    public static String getCpuModel() {
        getCpuInfo();
        return strCPUModel;
    }

    public static String getCpuModelV31(String str) {
        if (Build.VERSION.SDK_INT < 31) {
            return str;
        }
        String systemProperty = getSystemProperty(SOC_MODEL_KEY);
        if (systemProperty != null) {
            return systemProperty;
        }
        return str;
    }

    public static String getCpuReport() {
        getCpuInfo();
        return "prcs(" + mProcessorName + ") arch(" + mCpuArchitecture + ") hard(" + mHardware + ") chip(" + mChip + ") freq(" + mMaxCpuFreq + ") num(" + mCoreNumber + ")";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0032 -> B:14:0x005c). Please report as a decompilation issue!!! */
    public static long getCurrentCpuFreq() {
        String str;
        BufferedReader bufferedReader;
        long j3 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                str = "";
                bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (NumberFormatException unused3) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    str = readLine.trim();
                }
                if (str != null && str.length() > 0) {
                    j3 = Long.parseLong(str);
                }
                bufferedReader.close();
            } catch (FileNotFoundException unused4) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return j3;
            } catch (IOException unused5) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return j3;
            } catch (NumberFormatException unused6) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return j3;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        return j3;
    }

    public static String getDeviceName() {
        return DeviceInfoMonitor.getModel();
    }

    public static String getDeviceNameForConfigSystem() {
        return Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel();
    }

    public static String getFeature() {
        getCpuInfo();
        return mFeature;
    }

    public static boolean getIsMarvell() {
        getCpuInfo();
        return mIsMarvell;
    }

    public static long getMaxCpuFreq() {
        getCpuInfo();
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, "getMaxCpuFreq: " + Build.BRAND + "|" + DeviceInfoMonitor.getModel() + "|" + mMaxCpuFreq);
        }
        return mMaxCpuFreq;
    }

    public static long getMemoryTotal() {
        BufferedReader bufferedReader;
        Throwable th5;
        if (mHasReadMemInfo) {
            return mMemoryTotal;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.startsWith("MemTotal")) {
                                int indexOf = readLine.indexOf(58);
                                if (indexOf > 1) {
                                    String trim = readLine.substring(indexOf + 1, readLine.length()).trim();
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 < readLine.length()) {
                                            if (trim.charAt(i3) < '0' || trim.charAt(i3) > '9') {
                                                break;
                                            }
                                            i3++;
                                        } else {
                                            i3 = 0;
                                            break;
                                        }
                                    }
                                    String trim2 = trim.substring(0, i3).trim();
                                    if (trim2 != null && trim2.length() > 0) {
                                        mMemoryTotal = Long.parseLong(trim2);
                                    }
                                }
                            }
                        } catch (Exception unused) {
                            bufferedReader2 = bufferedReader;
                            AVCoreLog.e(TAG, "get memory info failed!!");
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return mMemoryTotal;
                        } catch (Throwable th6) {
                            th5 = th6;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            throw th5;
                        }
                    }
                    mHasReadMemInfo = true;
                    bufferedReader.close();
                } catch (Throwable th7) {
                    bufferedReader = bufferedReader2;
                    th5 = th7;
                }
            } catch (Exception unused2) {
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        return mMemoryTotal;
    }

    public static String getModelReport() {
        getCpuInfo();
        return "model(" + DeviceInfoMonitor.getModel() + ") Mnfc(" + Build.MANUFACTURER + ") dev(" + Build.VERSION.INCREMENTAL + ") sdk(" + Build.VERSION.SDK_INT + ") gl(" + mOpenGLVersion + ")";
    }

    public static int getNumCores() {
        getCpuInfo();
        return mCoreNumber;
    }

    public static int getOpenGLVersion() {
        getCpuInfo();
        return mOpenGLVersion;
    }

    public static String getSystemProperty(String str) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, null);
        } catch (Exception unused) {
            AVCoreLog.printAllUserLog(TAG, "getSystemProperty " + str + " fail");
            return null;
        }
    }

    public static String getVendorId() {
        getCpuInfo();
        return mVendorId;
    }

    public static boolean hasFeature(String str) {
        try {
            String str2 = mFeature;
            if (str2 == null || str2.equals("")) {
                getCpuInfo();
            }
            if (mFeature.indexOf(str) > 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isBeautySupported() {
        if ((hasFeature("neon") || hasFeature("asimd")) && getNumCores() >= 2 && getCpuArchitecture() >= 4) {
            return true;
        }
        return false;
    }

    public static boolean isLowLevelDevice() {
        if (mgNumCores == 0) {
            mgNumCores = getNumCores();
        }
        if (mgMaxCpuFreq == 0) {
            mgMaxCpuFreq = getMaxCpuFreq();
        }
        if (mgNumCores <= 1 && mgMaxCpuFreq <= 1025000) {
            return true;
        }
        return false;
    }

    public static boolean isNormalSharp() {
        getCpuInfo();
        if (mChip >= 3 && mMaxCpuFreq / 1000 >= 800) {
            return true;
        }
        return false;
    }

    public static boolean isSupportSharpAudio() {
        return true;
    }

    public static boolean isSupportSharpVideo() {
        return true;
    }

    static int readCpuArchitecture() {
        if (mProcessorName.contains("ARMv6")) {
            return 2;
        }
        String str = Build.CPU_ABI;
        if (str.equalsIgnoreCase("armeabi-v7a")) {
            return 4;
        }
        if (str.equalsIgnoreCase("armeabi")) {
            return 2;
        }
        if (mCpuArchitecture == 7 && mFeature.indexOf("neon") < 0) {
            long maxCpuFreq = getMaxCpuFreq();
            int numCores = getNumCores();
            if (maxCpuFreq < 1100000 || numCores < 2) {
                return 3;
            }
        }
        if (str.equalsIgnoreCase(ResourceAttributes.HostArchValues.X86)) {
            return 7;
        }
        int i3 = mCpuArchitecture;
        if (i3 != 5) {
            if (i3 == 6) {
                return 2;
            }
            if (i3 == 7) {
                return 4;
            }
            if (i3 == 8) {
                return 5;
            }
            String str2 = mVendorId;
            if (str2 != null) {
                if (str2.equalsIgnoreCase("AuthenticAMD") || mVendorId.equalsIgnoreCase("GenuineIntel")) {
                    return 7;
                }
                return 0;
            }
            return 0;
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static long readMaxCpuFreq() {
        if (mCoreNumber < 1) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.i(TAG, "[CpuInfo] Use default core number 8");
            }
            mCoreNumber = 8;
        }
        boolean z16 = false;
        long j3 = 0;
        long j16 = 0;
        for (int i3 = 0; i3 < mCoreNumber; i3++) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    String str = "";
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq"));
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (!TextUtils.isEmpty(readLine)) {
                            str = readLine.trim();
                        }
                        if (str != null && str.length() > 0) {
                            j3 = Long.parseLong(str);
                        }
                        try {
                            bufferedReader2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    } catch (Exception e17) {
                        e = e17;
                        bufferedReader = bufferedReader2;
                        AVCoreLog.e(TAG, "getMaxCpuFreq of cup" + i3 + " failed.\n" + e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        z16 = true;
                        j3 = 0;
                        if (j3 > j16) {
                        }
                        if (!AVCoreLog.isColorLevel()) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e26) {
                    e = e26;
                }
                if (j3 > j16) {
                    j16 = j3;
                }
                if (!AVCoreLog.isColorLevel()) {
                    AVCoreLog.i(TAG, "[CpuInfo] readMaxCpuFreq core " + i3 + "  maxFreq  " + j3 + "  thisMaxFreq  " + j16);
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        if (z16) {
            long readMaxCpuFreqFromState = readMaxCpuFreqFromState();
            if (readMaxCpuFreqFromState > j3) {
                j16 = readMaxCpuFreqFromState;
            }
        }
        AVCoreLog.printAllUserLog(TAG, "[CpuInfo] readMaxCpuFreq end. thisMaxFreq  " + j16);
        return j16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0084: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:133), block:B:34:0x0084 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0044 -> B:21:0x006d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static long readMaxCpuFreqFromState() {
        BufferedReader bufferedReader;
        Exception e16;
        BufferedReader bufferedReader2;
        ?? r46;
        int indexOf;
        String substring;
        long j3 = 0;
        BufferedReader bufferedReader3 = null;
        try {
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpufreq/all_time_in_state"));
            } catch (Exception e18) {
                bufferedReader = null;
                e16 = e18;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedReader3 != null) {
                }
                throw th;
            }
            try {
                BufferedReader bufferedReader4 = bufferedReader.readLine();
                while (true) {
                    BufferedReader bufferedReader5 = bufferedReader4;
                    r46 = bufferedReader3;
                    bufferedReader3 = bufferedReader5;
                    if (bufferedReader3 == null) {
                        break;
                    }
                    bufferedReader4 = bufferedReader.readLine();
                }
                if (r46 == 0) {
                    indexOf = -1;
                } else {
                    indexOf = r46.indexOf(9);
                }
                if (indexOf != -1 && (substring = r46.substring(0, indexOf)) != null && substring.length() > 0) {
                    j3 = Long.parseLong(substring);
                }
                bufferedReader.close();
            } catch (Exception e19) {
                e16 = e19;
                Log.e(TAG, "readMaxCpuFreqFromState failed.\n" + e16.toString());
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                AVCoreLog.printAllUserLog(TAG, "[CpuInfo] readMaxCpuFreqFromState. maxFreq=" + j3);
                return j3;
            }
            AVCoreLog.printAllUserLog(TAG, "[CpuInfo] readMaxCpuFreqFromState. maxFreq=" + j3);
            return j3;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader3 = bufferedReader2;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            throw th;
        }
    }

    static int readNumCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.avcore.data.AVCoreSystemInfo.1CpuFilter
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file)).booleanValue();
                    }
                    if (Pattern.matches("cpu[0-9]", file.getName())) {
                        return true;
                    }
                    return false;
                }
            }).length;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getCameraFacing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 2;
    }

    public int getOSTypeFromSDKVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 23) {
            return 119;
        }
        if (i3 != 24 && i3 != 25) {
            if (i3 != 26 && i3 != 27) {
                if (i3 == 28) {
                    return 122;
                }
                return 200;
            }
            return 121;
        }
        return 120;
    }

    public int getOsType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        try {
            String str = Build.VERSION.RELEASE;
            int i3 = 118;
            if (str.equals("L")) {
                return 118;
            }
            char c16 = 0;
            char charAt = str.charAt(0);
            char charAt2 = str.charAt(2);
            if (str.length() >= 5) {
                c16 = str.charAt(4);
            }
            switch (charAt) {
                case '1':
                    if (charAt2 == '1') {
                        i3 = 101;
                        break;
                    } else if (charAt2 == '5') {
                        i3 = 102;
                        break;
                    } else {
                        if (charAt2 == '6') {
                            i3 = 103;
                            break;
                        }
                        i3 = 200;
                        break;
                    }
                case '2':
                    if (charAt2 == '0') {
                        if (c16 == '1') {
                            i3 = 105;
                            break;
                        } else {
                            i3 = 104;
                            break;
                        }
                    } else if (charAt2 == '1') {
                        i3 = 106;
                        break;
                    } else if (charAt2 == '2') {
                        if (c16 == '1') {
                            i3 = 108;
                            break;
                        } else {
                            i3 = 107;
                            break;
                        }
                    } else {
                        if (charAt2 == '3' && c16 >= '0' && c16 <= '9') {
                            i3 = 109;
                            break;
                        }
                        i3 = 200;
                        break;
                    }
                case '3':
                    if (charAt2 == '0') {
                        i3 = 110;
                        break;
                    } else if (charAt2 == '1') {
                        i3 = 111;
                        break;
                    } else {
                        if (charAt2 == '2') {
                            i3 = 112;
                            break;
                        }
                        i3 = 200;
                        break;
                    }
                case '4':
                    if (charAt2 == '0') {
                        i3 = 113;
                        break;
                    } else if (charAt2 == '1') {
                        i3 = 114;
                        break;
                    } else if (charAt2 == '2') {
                        i3 = 115;
                        break;
                    } else if (charAt2 == '3') {
                        i3 = 116;
                        break;
                    } else {
                        if (charAt2 == '4') {
                            i3 = 117;
                            break;
                        }
                        i3 = 200;
                        break;
                    }
                case '5':
                    if (charAt2 == '0') {
                        break;
                    }
                    i3 = 200;
                    break;
                case '6':
                    if (charAt2 == '0') {
                        i3 = 119;
                        break;
                    }
                    i3 = 200;
                    break;
                case '7':
                    if (charAt2 == '0') {
                        i3 = 120;
                        break;
                    }
                    i3 = 200;
                    break;
                default:
                    i3 = 200;
                    break;
            }
            if (i3 == 200) {
                return getOSTypeFromSDKVersion();
            }
            return i3;
        } catch (Exception unused) {
            return 200;
        }
    }

    public void setScreenSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mScreenWidth = i3;
            this.mScreenHeight = i16;
        }
    }
}
