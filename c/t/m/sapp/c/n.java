package c.t.m.sapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes.dex */
public class n {
    public static boolean a(Handler handler) {
        return a(handler == null ? null : handler.getLooper());
    }

    public static boolean a(Looper looper) {
        return looper != null && looper.getThread().isAlive();
    }

    public static boolean a(Handler handler, int i3, long j3) {
        return a(handler, handler == null ? null : handler.obtainMessage(i3), j3);
    }

    public static boolean a(Handler handler, Message message, long j3) {
        if (message == null || !a(handler)) {
            return false;
        }
        return handler.sendMessageDelayed(message, j3);
    }
}
