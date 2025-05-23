package m;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes.dex */
public class a extends m {

    /* renamed from: d, reason: collision with root package name */
    private static int f415865d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static long f415866e;

    public static long d() {
        if (f415866e == 0) {
            h();
        }
        return f415866e;
    }

    private static int e() {
        return f();
    }

    @SuppressLint({"NewApi"})
    private static final int f() {
        if (f415865d == -1) {
            f415865d = Runtime.getRuntime().availableProcessors();
        }
        return f415865d;
    }

    private static void g(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Exception e16;
        long j3;
        int e17 = e();
        for (int i3 = 0; i3 < e17; i3++) {
            BufferedReader bufferedReader2 = null;
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/" + str);
                try {
                    bufferedReader = new BufferedReader(fileReader, 1024);
                } catch (Exception e18) {
                    bufferedReader = null;
                    e16 = e18;
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e19) {
                bufferedReader = null;
                e16 = e19;
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
                    if (f415866e < j3) {
                        f415866e = j3;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("DeviceInfoUtil", 2, String.format(Locale.getDefault(), "initCpuFreq  [%d, %d Khz]", Integer.valueOf(i3), Long.valueOf(j3)));
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                    try {
                        fileReader.close();
                    } catch (Exception e27) {
                        e27.printStackTrace();
                    }
                } catch (Exception e28) {
                    e16 = e28;
                    e16.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e29) {
                            e29.printStackTrace();
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
                    } catch (Exception e36) {
                        e36.printStackTrace();
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        throw th;
                    } catch (Exception e37) {
                        e37.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        }
    }

    private static void h() {
        g("cpuinfo_max_freq");
    }
}
