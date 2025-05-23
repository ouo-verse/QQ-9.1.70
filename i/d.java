package i;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqbattery.feature.g;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f406971a;

    /* JADX WARN: Can't wrap try/catch for region: R(6:(6:12|13|(3:16|(1:18)(1:23)|14)|24|25|(3:20|21|22))|31|32|34|35|(8:37|(1:(1:52)(2:39|(2:42|43)(1:41)))|44|45|46|47|21|22)(2:53|54)) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:8|(6:12|13|(3:16|(1:18)(1:23)|14)|24|25|(3:20|21|22))|29|30|31|32|34|35|(8:37|(1:(1:52)(2:39|(2:42|43)(1:41)))|44|45|46|47|21|22)(2:53|54)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00aa, code lost:
    
        r7 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ab, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b0, code lost:
    
        android.util.Log.e("QQBattery_QQBatteryUtil", "getProcessNameInternal exception:" + r7.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c6, code lost:
    
        if (r2 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c8, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a8, code lost:
    
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d6, code lost:
    
        if (r4 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e4, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d8, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00dc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
    
        android.util.Log.e("QQBattery_QQBatteryUtil", r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00af, code lost:
    
        r7 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00cc, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00cd, code lost:
    
        android.util.Log.e("QQBattery_QQBatteryUtil", r7.getMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str;
        byte[] bArr;
        FileInputStream fileInputStream;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        String str2 = f406971a;
        if (str2 != null) {
            return str2;
        }
        int myPid = Process.myPid();
        if (context != null && myPid > 0) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            FileInputStream fileInputStream2 = null;
            try {
                if (activityManager != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
                    try {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (it.hasNext()) {
                            runningAppProcessInfo = it.next();
                            if (runningAppProcessInfo.pid == myPid) {
                                break;
                            }
                        }
                    } catch (Exception e16) {
                        StringBuilder a16 = g.a("getProcessNameInternal exception:");
                        a16.append(e16.getMessage());
                        Log.e("QQBattery_QQBatteryUtil", a16.toString());
                    }
                    runningAppProcessInfo = null;
                    if (runningAppProcessInfo != null) {
                        str = runningAppProcessInfo.processName;
                        f406971a = str;
                        return str;
                    }
                }
                fileInputStream = new FileInputStream("/proc/" + myPid + "/cmdline");
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= read) {
                            break;
                        }
                        if (bArr[i3] <= 0) {
                            read = i3;
                            break;
                        }
                        i3++;
                    }
                    String str3 = new String(bArr, 0, read, Charset.forName("UTF-8"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e17) {
                        Log.e("QQBattery_QQBatteryUtil", e17.getMessage());
                    }
                    str = str3;
                    f406971a = str;
                    return str;
                }
                fileInputStream.close();
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = fileInputStream2;
            }
            bArr = new byte[128];
        }
        str = "";
        f406971a = str;
        return str;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            try {
                String readLine = randomAccessFile.readLine();
                randomAccessFile.close();
                return readLine;
            } finally {
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_QQBatteryUtil", th5, "cat file fail", new Object[0]);
            return null;
        }
    }

    public static long c(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            if (str.length() <= 0) {
                return 0L;
            }
            return Long.decode(str).longValue();
        } catch (NumberFormatException e16) {
            StringBuilder a16 = g.a("parseLong error: ");
            a16.append(e16.getMessage());
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_QQBatteryUtil", a16.toString(), new Object[0]);
            return 0L;
        }
    }
}
