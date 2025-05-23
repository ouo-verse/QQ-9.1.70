package cooperation.qzone.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.util.Pair;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneBaseThread {
    public static long cost;
    private BaseHandler handler;
    private HandlerThread thread;

    public QzoneBaseThread(String str, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str, i3);
        this.thread = baseHandlerThread;
        baseHandlerThread.start();
        this.handler = new BaseHandler(this.thread.getLooper());
        cost = System.currentTimeMillis() - currentTimeMillis;
    }

    private Pair<Object, Runnable> breakRefChain(Runnable runnable) {
        Object obj;
        Field declaredField;
        Object obj2 = null;
        try {
            declaredField = runnable.getClass().getDeclaredField("this$0");
            declaredField.setAccessible(true);
            obj = declaredField.get(runnable);
        } catch (IllegalAccessException e16) {
            e = e16;
        } catch (IllegalArgumentException e17) {
            e = e17;
        } catch (NoSuchFieldException e18) {
            e = e18;
        }
        try {
            declaredField.set(runnable, null);
        } catch (IllegalAccessException e19) {
            e = e19;
            obj2 = obj;
            if (QLog.isColorLevel()) {
                QLog.d(ThreadManagerV2.TAG, 2, "IllegalAccessException", e);
            }
            obj = obj2;
            return new Pair<>(obj, runnable);
        } catch (IllegalArgumentException e26) {
            e = e26;
            obj2 = obj;
            if (QLog.isColorLevel()) {
                QLog.d(ThreadManagerV2.TAG, 2, "IllegalArgumentException", e);
            }
            obj = obj2;
            return new Pair<>(obj, runnable);
        } catch (NoSuchFieldException e27) {
            e = e27;
            obj2 = obj;
            if (QLog.isColorLevel()) {
                QLog.d(ThreadManagerV2.TAG, 2, "NoSuchFieldException", e);
            }
            obj = obj2;
            return new Pair<>(obj, runnable);
        }
        return new Pair<>(obj, runnable);
    }

    private Runnable buildJob(Runnable runnable, boolean z16) {
        Pair<Object, Runnable> breakRefChain = breakRefChain(runnable);
        try {
            return new Job(breakRefChain.first, breakRefChain.second, z16);
        } catch (OutOfMemoryError e16) {
            QLog.e(ThreadManagerV2.TAG, 1, "buildJob " + runnable, e16);
            return null;
        }
    }

    public Handler getHandler() {
        return this.handler;
    }

    public HandlerThread getHandlerThread() {
        return this.thread;
    }

    public Looper getLooper() {
        return this.thread.getLooper();
    }

    public boolean isAlive() {
        return this.thread.isAlive();
    }

    public void post(Runnable runnable) {
        postDelayed(runnable, 0L);
    }

    public void postDelayed(Runnable runnable, long j3) {
        this.handler.postDelayed(runnable, j3);
    }

    public void postIrrevocableTask(Runnable runnable) {
        postIrrevocableTask(runnable, 0L);
    }

    public void removeAllMessages() {
        BaseHandler baseHandler = this.handler;
        if (baseHandler != null) {
            baseHandler.removeCallbacksAndMessages(null);
        }
    }

    public void removeTask(Runnable runnable) {
        this.handler.removeCallbacks(runnable);
    }

    public void setDaemon(boolean z16) {
        this.thread.setDaemon(z16);
    }

    public void start() {
        this.thread.start();
    }

    public void postIrrevocableTask(Runnable runnable, long j3) {
        postDelayed(buildJob(runnable, true), j3);
    }
}
