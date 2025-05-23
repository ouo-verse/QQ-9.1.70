package mqq.os;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MqqInterceptHandler extends Handler implements IMqqMessageCallback {
    Handler mParentHandler;
    MqqMessageQueue mSubUIQueue;

    MqqInterceptHandler(Handler handler) {
        super(Looper.getMainLooper());
        this.mParentHandler = handler;
        this.mSubUIQueue = MqqMessageQueue.getSubMainThreadQueue();
    }

    public static Handler createMqqHandler(Handler handler) {
        if (handler.getLooper() == Looper.getMainLooper() && !(handler instanceof MqqInterceptHandler)) {
            try {
                if (Looper.getMainLooper().getQueue() == null) {
                    return null;
                }
                return new MqqInterceptHandler(handler);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // android.os.Handler, mqq.os.IMqqMessageCallback
    public void dispatchMessage(Message message) {
        this.mParentHandler.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(Message message, long j3) {
        MqqMessage obtain = MqqMessage.obtain(message);
        obtain.target = this;
        boolean enqueueMessage = this.mSubUIQueue.enqueueMessage(obtain, j3);
        if (!enqueueMessage) {
            return this.mParentHandler.sendMessageAtTime(message, j3);
        }
        return enqueueMessage;
    }
}
