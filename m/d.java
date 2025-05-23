package m;

import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f415886a = Build.MANUFACTURER;

    /* renamed from: b, reason: collision with root package name */
    public static final String f415887b = DeviceInfoMonitor.getModel();

    public static void a(String str, String str2) {
        QLog.e(str, 1, str2);
    }

    public static void b(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, str2);
        }
    }

    public static void c(String str, long j3, String str2) {
        if (!c.f415878f) {
            return;
        }
        b(str, str2 + "  \u7ed8\u5236\u8017\u65f6\uff1a" + (((float) (System.nanoTime() - j3)) / 1000000.0f) + "ms\n  \u624b\u673a\u578b\u53f7\uff1a" + f415886a + "  " + f415887b);
    }
}
