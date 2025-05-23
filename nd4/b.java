package nd4;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f419978a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f419979b = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        if (TextUtils.isEmpty(f419978a)) {
            f419978a = Build.BRAND;
        }
        return f419978a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        if (TextUtils.isEmpty(f419979b)) {
            f419979b = DeviceInfoMonitor.getModel();
        }
        return f419979b;
    }
}
