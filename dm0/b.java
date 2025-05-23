package dm0;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static void b(Runnable runnable) {
        a(Looper.getMainLooper(), runnable);
    }

    public static void a(Looper looper, Runnable runnable) {
        if (looper == null || runnable == null) {
            return;
        }
        if (looper == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(looper).post(runnable);
        }
    }
}
