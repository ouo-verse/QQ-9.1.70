package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes.dex */
public class y0 {
    public static boolean a(Handler handler) {
        return a(handler == null ? null : handler.getLooper());
    }

    public static boolean b(Handler handler, int i3) {
        return a(handler, i3, 0L);
    }

    public static boolean a(Looper looper) {
        return looper != null && looper.getThread().isAlive();
    }

    public static boolean b(Handler handler, int i3, int i16, int i17, Object obj) {
        if (handler == null) {
            return false;
        }
        return a(handler, a(handler, i3, i16, i17, obj));
    }

    public static boolean a(Handler handler, int i3, long j3) {
        return a(handler, handler == null ? null : handler.obtainMessage(i3), j3);
    }

    public static void b(Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public static boolean a(Handler handler, Message message) {
        return a(handler, message, 0L);
    }

    public static boolean a(Handler handler, Message message, long j3) {
        if (message == null || !a(handler)) {
            return false;
        }
        return handler.sendMessageDelayed(message, j3);
    }

    public static Message a(Handler handler, int i3, int i16, int i17, Object obj) {
        Message message = handler == null ? new Message() : handler.obtainMessage(i3);
        message.what = i3;
        message.arg1 = i16;
        message.arg2 = i17;
        message.obj = obj;
        return message;
    }

    public static boolean a(Handler handler, Runnable runnable) {
        return a(handler, runnable, 0L);
    }

    public static boolean a(Handler handler, Runnable runnable, long j3) {
        if (runnable == null || !a(handler)) {
            return false;
        }
        return handler.postDelayed(runnable, j3);
    }

    public static void a(Handler handler, int i3) {
        if (handler != null) {
            handler.removeMessages(i3);
        }
    }
}
