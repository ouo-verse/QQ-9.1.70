package com.tencent.tmassistantbase.util;

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
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.CRC32;

/* compiled from: P */
/* loaded from: classes26.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f380482a = {"Y29tLnRlbmNlbnQubW0=", "Y29tLnRlbmNlbnQubW9iaWxlcXE="};

    private static long a() {
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
    private static String b() {
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

    private static String c() {
        return Locale.getDefault().getLanguage();
    }

    private static String d() {
        return Build.VERSION.RELEASE;
    }

    private static String e() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (AssertionError | Exception unused) {
            return "";
        }
    }

    private static String c(Context context) {
        return context.getApplicationContext().getResources().getConfiguration().locale.getCountry();
    }

    private static long d(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return 0L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static Pair<Integer, Integer> e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return new Pair<>(Integer.valueOf(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)), Integer.valueOf(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)));
    }

    private static String a(String str) {
        return new String(Base64.decode(str, 2));
    }

    private static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
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

    private static String a(char[] cArr, char[] cArr2) {
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

    private static char[] d(String str) {
        String c16 = c(str);
        char[] cArr = new char[16];
        for (int i3 = 8; i3 < 24; i3++) {
            cArr[i3 - 8] = c16.charAt(i3);
        }
        return cArr;
    }

    private static void a(char[] cArr) {
        String upperCase = Integer.toHexString(1).toUpperCase();
        if (upperCase.length() < 2) {
            cArr[0] = '0';
            cArr[1] = upperCase.charAt(0);
        } else {
            cArr[0] = upperCase.charAt(0);
            cArr[1] = upperCase.charAt(1);
        }
    }

    private static List<Long> b(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        for (String str : f380482a) {
            try {
                arrayList.add(Long.valueOf(InstalledAppListMonitor.getPackageInfo(packageManager, a(str), 0).firstInstallTime));
            } catch (Exception unused) {
                arrayList.add(-1L);
            }
        }
        return arrayList;
    }

    public static String a(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            String d16 = d();
            Pair<Integer, Integer> e16 = e(applicationContext);
            String b16 = b();
            long d17 = d(applicationContext);
            long a16 = a();
            String c16 = c();
            String c17 = c(applicationContext);
            String e17 = e();
            List<Long> b17 = b(applicationContext);
            Locale locale = Locale.US;
            String format = String.format(locale, "%s|%d|%d|%s|%d|%d", d16, e16.first, e16.second, b16, Long.valueOf(d17), Long.valueOf(a16));
            String format2 = String.format(locale, "%s|%s|%s|%s", c16, c17, e17, TextUtils.join("|", b17));
            char[] d18 = d(format);
            char[] d19 = d(format2);
            a(d18);
            b(d18, d19);
            return a(d18, d19);
        } catch (Error e18) {
            Log.w("AMS-QADID", "createQADID error: " + e18.getMessage());
            return "01000000000000000000000000000000";
        } catch (Throwable th5) {
            Log.w("AMS-QADID", "createQADID exception: " + th5.getMessage());
            return "01000000000000000000000000000000";
        }
    }

    private static void b(char[] cArr, char[] cArr2) {
        char[] cArr3 = new char[30];
        for (int i3 = 0; i3 < 30; i3++) {
            if (i3 < 16) {
                cArr3[i3] = cArr[i3];
            } else {
                cArr3[i3] = cArr2[i3 - 16];
            }
        }
        String upperCase = Integer.toHexString((int) (b(cArr3) % 256)).toUpperCase();
        if (upperCase.length() < 2) {
            cArr2[14] = '0';
            cArr2[15] = upperCase.charAt(0);
        } else {
            cArr2[14] = upperCase.charAt(0);
            cArr2[15] = upperCase.charAt(1);
        }
    }

    private static long b(char[] cArr) {
        StringBuilder sb5 = new StringBuilder();
        for (char c16 : cArr) {
            sb5.append(c16);
        }
        byte[] b16 = b(sb5.toString());
        CRC32 crc32 = new CRC32();
        crc32.update(b16);
        return crc32.getValue();
    }

    private static byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }
}
