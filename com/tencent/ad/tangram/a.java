package com.tencent.ad.tangram;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.CRC32;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    private static final String MD5 = "MD5";
    private static final int MD5_DIGEST_LENGTH = 32;
    private static final String[] PACKAGE_LIST = {"Y29tLnRlbmNlbnQubW0=", "Y29tLnRlbmNlbnQubW9iaWxlcXE="};
    private static final String TAG = "AMS-QADID";
    private static final int VERSION = 1;

    private static String base64Decode2String(String str) {
        return new String(Base64.decode(str, 2));
    }

    private static String combineTwoParts(char[] cArr, char[] cArr2) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < 32; i3++) {
            if (i3 < 16) {
                sb5.append(cArr[i3]);
            } else {
                sb5.append(cArr2[i3 - 16]);
            }
        }
        return sb5.toString();
    }

    public static String createQADID(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            String oSVersion = getOSVersion();
            Pair<Integer, Integer> screenSize = getScreenSize(applicationContext);
            String kernelVersion = getKernelVersion();
            long memoryTotal = getMemoryTotal(applicationContext);
            long internalStorageTotal = getInternalStorageTotal();
            String language = getLanguage();
            String countryCode = getCountryCode(applicationContext);
            String timeZone = getTimeZone();
            List<Long> appInstallInfo = getAppInstallInfo(applicationContext);
            Locale locale = Locale.US;
            String format = String.format(locale, "%s|%d|%d|%s|%d|%d", oSVersion, screenSize.first, screenSize.second, kernelVersion, Long.valueOf(memoryTotal), Long.valueOf(internalStorageTotal));
            String format2 = String.format(locale, "%s|%s|%s|%s", language, countryCode, timeZone, TextUtils.join("|", appInstallInfo));
            char[] md5ToHalfCharArray = md5ToHalfCharArray(format);
            char[] md5ToHalfCharArray2 = md5ToHalfCharArray(format2);
            fillVersionInfo(md5ToHalfCharArray);
            fillCheckSum(md5ToHalfCharArray, md5ToHalfCharArray2);
            return combineTwoParts(md5ToHalfCharArray, md5ToHalfCharArray2);
        } catch (Error e16) {
            Log.w(TAG, "createQADID error: " + e16.getMessage());
            return "01000000000000000000000000000000";
        } catch (Throwable th5) {
            Log.w(TAG, "createQADID exception: " + th5.getMessage());
            return "01000000000000000000000000000000";
        }
    }

    private static void fillCheckSum(char[] cArr, char[] cArr2) {
        char[] cArr3 = new char[30];
        for (int i3 = 0; i3 < 30; i3++) {
            if (i3 < 16) {
                cArr3[i3] = cArr[i3];
            } else {
                cArr3[i3] = cArr2[i3 - 16];
            }
        }
        String upperCase = Integer.toHexString((int) (getCRC(cArr3) % 256)).toUpperCase();
        if (upperCase.length() < 2) {
            cArr2[14] = '0';
            cArr2[15] = upperCase.charAt(0);
        } else {
            cArr2[14] = upperCase.charAt(0);
            cArr2[15] = upperCase.charAt(1);
        }
    }

    private static void fillVersionInfo(char[] cArr) {
        String upperCase = Integer.toHexString(1).toUpperCase();
        if (upperCase.length() < 2) {
            cArr[0] = '0';
            cArr[1] = upperCase.charAt(0);
        } else {
            cArr[0] = upperCase.charAt(0);
            cArr[1] = upperCase.charAt(1);
        }
    }

    private static List<Long> getAppInstallInfo(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        for (String str : PACKAGE_LIST) {
            try {
                arrayList.add(Long.valueOf(InstalledAppListMonitor.getPackageInfo(packageManager, base64Decode2String(str), 0).firstInstallTime));
            } catch (Exception unused) {
                arrayList.add(-1L);
            }
        }
        return arrayList;
    }

    private static long getCRC(char[] cArr) {
        StringBuilder sb5 = new StringBuilder();
        for (char c16 : cArr) {
            sb5.append(c16);
        }
        byte[] hexStringToBytes = hexStringToBytes(sb5.toString());
        CRC32 crc32 = new CRC32();
        crc32.update(hexStringToBytes);
        return crc32.getValue();
    }

    private static String getCountryCode(Context context) {
        return context.getApplicationContext().getResources().getConfiguration().locale.getCountry();
    }

    private static long getInternalStorageTotal() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        if (r2 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
    
        if (r2 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getKernelVersion() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String property = System.getProperty("os.version");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                fileReader = new FileReader("/proc/version");
                try {
                    bufferedReader = new BufferedReader(fileReader, 8192);
                } catch (FileNotFoundException unused) {
                } catch (IOException unused2) {
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (FileNotFoundException unused3) {
                fileReader = null;
            } catch (IOException unused4) {
                fileReader = null;
            } catch (Throwable th6) {
                th = th6;
                fileReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    property = readLine;
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
                fileReader.close();
            } catch (FileNotFoundException unused6) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused7) {
                    }
                }
            } catch (IOException unused8) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused9) {
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused10) {
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        throw th;
                    } catch (IOException unused11) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (IOException unused12) {
        }
        return property;
    }

    private static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    private static long getMemoryTotal(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        return 0L;
    }

    private static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static Map<String, Object> getQADIDDebugInfo(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("alv", 1);
        hashMap.put(GdtADFlyingStreamingReportHelper.PARAM_KEY_OV, getOSVersion());
        hashMap.put("lg", getLanguage());
        hashMap.put("cc", getCountryCode(context));
        hashMap.put("tz", getTimeZone());
        hashMap.put("sw", getScreenSize(context).first);
        hashMap.put("sh", getScreenSize(context).second);
        hashMap.put("rs", Long.valueOf(getMemoryTotal(context)));
        hashMap.put("is", Long.valueOf(getInternalStorageTotal()));
        hashMap.put("cv", getKernelVersion());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("fit", getAppInstallInfo(context));
        hashMap.put("al", hashMap2);
        return hashMap;
    }

    private static Pair<Integer, Integer> getScreenSize(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return new Pair<>(Integer.valueOf(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)), Integer.valueOf(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)));
    }

    private static String getTimeZone() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (AssertionError | Exception unused) {
            return "";
        }
    }

    private static byte[] hexStringToBytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    private static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if (i3 < 16) {
                    sb5.append("0");
                }
                sb5.append(Integer.toHexString(i3));
            }
            return sb5.toString().toUpperCase();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static char[] md5ToHalfCharArray(String str) {
        String md5 = md5(str);
        char[] cArr = new char[16];
        for (int i3 = 8; i3 < 24; i3++) {
            cArr[i3 - 8] = md5.charAt(i3);
        }
        return cArr;
    }
}
