package com.tencent.luggage.wxa.tn;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class w0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f141744a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f141745b = {300, 200, 300, 200};

    /* renamed from: c, reason: collision with root package name */
    public static final long[] f141746c = {300, 50, 300, 50};

    /* renamed from: d, reason: collision with root package name */
    public static final TimeZone f141747d = TimeZone.getTimeZone("GMT");

    /* renamed from: e, reason: collision with root package name */
    public static final BigInteger f141748e = BigInteger.ONE.shiftLeft(64);

    /* renamed from: f, reason: collision with root package name */
    public static final char[] f141749f = {Typography.less, Typography.greater, '\"', '\'', Typography.amp, '\r', '\n', TokenParser.SP, '\t'};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f141750g = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};

    /* renamed from: h, reason: collision with root package name */
    public static Set f141751h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    public static long f141752i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f141753j = {"GPSLongitude", "GPSLatitude", "GPSLongitudeRef", "GPSLatitudeRef", "DeviceSettingDescription", "DateTime", "CameraOwnerName", "Model", "Make"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f141754k = {"GPSDestLongitude", "GPSDestLongitudeRef"};

    public static String a(long j3) {
        return new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new Date(j3 * 1000));
    }

    public static String b(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String c(long j3, double d16) {
        return "" + (Math.round((j3 * d16) / 1048576.0d) / d16) + " MB";
    }

    public static String d(String str) {
        return str == null ? "" : str;
    }

    public static long e(long j3) {
        return SystemClock.elapsedRealtime() - j3;
    }

    public static int f(String str) {
        return b(str, 0);
    }

    public static long g(String str) {
        return b(str, 0L);
    }

    public static String a(long j3, double d16) {
        return "" + (Math.round((j3 * d16) / 1.073741824E9d) / d16) + " GB";
    }

    public static boolean b(String str) {
        if (c(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(str).find();
    }

    public static long d() {
        return System.currentTimeMillis() / 1000;
    }

    public static float e(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            if (str != null) {
                w.b("MicroMsg.Util", "parseFloat error " + str);
            }
            return 0.0f;
        }
    }

    public static boolean c(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                return context.getApplicationInfo().targetSdkVersion >= 30;
            }
            return false;
        } catch (Exception e16) {
            w.a("MicroMsg.Util", e16, "isAffectedByPackageVisibility", new Object[0]);
            return false;
        }
    }

    public static long d(long j3) {
        return (System.currentTimeMillis() / 1000) - j3;
    }

    public static long a() {
        return SystemClock.elapsedRealtime();
    }

    public static long a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null) {
            return 0L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.availMem / 1024) / 1024;
    }

    public static boolean c(String str) {
        return str == null || str.length() <= 0;
    }

    public static String b(long j3, double d16) {
        if ((j3 >> 30) > 0) {
            return a(j3, d16);
        }
        if ((j3 >> 20) > 0) {
            return c(j3, d16);
        }
        if ((j3 >> 9) > 0) {
            return "" + (Math.round((j3 * d16) / 1024.0d) / d16) + " KB";
        }
        return "" + j3 + " B";
    }

    public static String c(Context context, int i3) {
        BufferedInputStream bufferedInputStream;
        int read;
        String str;
        if (context == null || i3 <= 0) {
            return "";
        }
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == i3 && (str = runningAppProcessInfo.processName) != null && !str.equals("")) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e16) {
            w.a("MicroMsg.Util", e16, "", new Object[0]);
        }
        byte[] bArr = new byte[128];
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream("/proc/" + i3 + "/cmdline"));
                    try {
                        read = bufferedInputStream.read(bArr);
                    } catch (Exception e17) {
                        e = e17;
                        bufferedInputStream2 = bufferedInputStream;
                        w.a("MicroMsg.Util", e, "", new Object[0]);
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        return "";
                    } catch (Throwable th5) {
                        th = th5;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream = bufferedInputStream2;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (Exception unused2) {
        }
        if (read <= 0) {
            bufferedInputStream.close();
            return "";
        }
        for (int i16 = 0; i16 < read; i16++) {
            byte b16 = bArr[i16];
            if (b16 <= 128 && b16 > 0) {
            }
            read = i16;
            break;
        }
        String str2 = new String(bArr, 0, read);
        try {
            bufferedInputStream.close();
        } catch (Exception unused3) {
        }
        return str2;
    }

    public static boolean a(Context context, Intent intent, boolean z16) {
        return a(context, intent, z16, false);
    }

    public static boolean a(Context context, Intent intent, boolean z16, boolean z17) {
        if (z16 && c(context)) {
            if (z17) {
                w.d("MicroMsg.Util", "isIntentAvailable return true by force");
            }
            return true;
        }
        List list = (List) com.tencent.luggage.wxa.ia.a.a(context.getPackageManager(), com.tencent.luggage.wxa.ja.b.a(65536, new com.tencent.luggage.wxa.ja.a()).a(intent).a(), "com/tencent/mm/sdk/platformtools/Util", "isIntentAvailable", "(Landroid/content/Context;Landroid/content/Intent;ZZ)Z", "android/content/pm/PackageManager", "queryIntentActivities", "(Landroid/content/Intent;I)Ljava/util/List;");
        boolean z18 = list != null && list.size() > 0;
        if (z17) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(z18);
            objArr[1] = Integer.valueOf(list != null ? list.size() : -1);
            w.d("MicroMsg.Util", "isIntentAvailable res:%s listSize:%s", objArr);
        }
        return z18;
    }

    public static String b(long j3) {
        return b(j3, 10.0d);
    }

    public static boolean b(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static int b(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            if (f141744a || str == null) {
                return i3;
            }
            w.b("MicroMsg.Util", "parserInt error " + str);
            if (Math.random() >= 0.01d) {
                return i3;
            }
            w.a("MicroMsg.Util", e16, "parserInt error", new Object[0]);
            return i3;
        }
    }

    public static String a(Object obj) {
        return obj != null ? obj.toString() : "null";
    }

    public static int a(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static int a(Integer num, int i3) {
        return num == null ? i3 : num.intValue();
    }

    public static long b(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (Exception e16) {
            if (f141744a || str == null) {
                return j3;
            }
            w.b("MicroMsg.Util", "parseLong error " + str);
            if (Math.random() >= 0.01d) {
                return j3;
            }
            w.a("MicroMsg.Util", e16, "parseLong error", new Object[0]);
            return j3;
        }
    }

    public static boolean a(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() <= 0;
    }

    public static long c() {
        return System.currentTimeMillis();
    }

    public static boolean a(int[] iArr) {
        return iArr == null || iArr.length <= 0;
    }

    public static long c(long j3) {
        return System.currentTimeMillis() - j3;
    }

    public static boolean a(String... strArr) {
        for (String str : strArr) {
            if (c(str)) {
                return true;
            }
        }
        return false;
    }

    public static String b(Context context, int i3) {
        w.d("MicroMsg.Util", "getProcessNameByPid, pid = " + i3);
        return m0.a(context, i3);
    }

    public static int a(String str, int i3) {
        if (str == null) {
            return i3;
        }
        try {
            return str.length() <= 0 ? i3 : Integer.decode(str).intValue();
        } catch (NumberFormatException e16) {
            w.a("MicroMsg.Util", e16, "", new Object[0]);
            return i3;
        }
    }

    public static d0 b() {
        return new d0();
    }

    public static long a(String str, long j3) {
        if (str == null) {
            return j3;
        }
        try {
            return str.length() <= 0 ? j3 : Long.decode(str).longValue();
        } catch (NumberFormatException e16) {
            w.a("MicroMsg.Util", e16, "", new Object[0]);
            return j3;
        }
    }

    public static int b(Context context) {
        if (context == null) {
            w.d("MicroMsg.Util", "getSelfMemInMB context is null.");
            return -1;
        }
        Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY), new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            return 0;
        }
        return processMemoryInfo[0].getTotalPss() / 1024;
    }

    public static boolean a(String str, boolean z16) {
        if (str == null) {
            return z16;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException e16) {
            w.a("MicroMsg.Util", e16, "", new Object[0]);
            return z16;
        }
    }

    public static float a(String str, float f16) {
        if (str == null) {
            return f16;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e16) {
            w.a("MicroMsg.Util", e16, "", new Object[0]);
            return f16;
        }
    }

    public static double a(String str, double d16) {
        if (str == null) {
            return d16;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e16) {
            w.a("MicroMsg.Util", e16, "", new Object[0]);
            return d16;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder("");
        if (bArr != null) {
            for (byte b16 : bArr) {
                sb5.append(String.format("%02x", Integer.valueOf(b16 & 255)));
            }
        }
        return sb5.toString();
    }

    public static byte[] a(String str) {
        if (str == null || str.length() <= 0) {
            return new byte[0];
        }
        try {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) (Integer.parseInt(str.substring(i16, i16 + 2), 16) & 255);
            }
            return bArr;
        } catch (NumberFormatException e16) {
            w.a("MicroMsg.Util", e16, "", new Object[0]);
            return new byte[0];
        }
    }

    public static String a(Throwable th5) {
        return d0.a(th5);
    }

    public static ActivityManager.RunningTaskInfo a(Context context, int i3) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1000)) {
            if (runningTaskInfo.id == i3) {
                return runningTaskInfo;
            }
        }
        return null;
    }

    public static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb5.append(readLine + "\n");
                    } else {
                        try {
                            break;
                        } catch (IOException e16) {
                            w.a("MicroMsg.Util", e16, "", new Object[0]);
                        }
                    }
                } catch (IOException e17) {
                    w.a("MicroMsg.Util", e17, "", new Object[0]);
                    try {
                        inputStream.close();
                    } catch (IOException e18) {
                        w.a("MicroMsg.Util", e18, "", new Object[0]);
                    }
                }
            } catch (Throwable th5) {
                try {
                    inputStream.close();
                } catch (IOException e19) {
                    w.a("MicroMsg.Util", e19, "", new Object[0]);
                }
                throw th5;
            }
        }
        inputStream.close();
        return sb5.toString();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                w.a("MicroMsg.Util", e16, "qualityClose", new Object[0]);
            }
        }
    }

    public static boolean a(String str, String str2) {
        if (c(str) && c(str2)) {
            return true;
        }
        if (c(str) && !c(str2)) {
            return false;
        }
        if (c(str) || !c(str2)) {
            return str.equals(str2);
        }
        return false;
    }
}
