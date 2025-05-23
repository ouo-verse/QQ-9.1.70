package h91;

import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f404591a = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f404592b = false;

    static {
        if (DeviceInfoMonitor.getModel().contains("Android SDK built for x86")) {
            f404592b = true;
        }
        String str = Build.CPU_ABI;
        String str2 = Build.CPU_ABI2;
        if (!f404592b) {
            if (a(str).booleanValue() || a(str2).booleanValue()) {
                f404591a = true;
            }
        }
    }

    private static Boolean a(String str) {
        boolean z16;
        if (!str.equalsIgnoreCase("armeabi-v7a") && !str.equalsIgnoreCase("arm64-v8a")) {
            z16 = false;
        } else {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    public static String b() {
        String c16 = a.d().c();
        File file = new File(c16);
        if (!file.exists()) {
            file.mkdirs();
        }
        return c16;
    }
}
