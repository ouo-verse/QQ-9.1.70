package mqq.os;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MqqHandler implements IMqqMessageCallback {
    public static MqqRegulatorCallback sRegulatorCallback;
    boolean beInjected;
    boolean beRegulatoring;
    Handler.Callback mCallback;
    final Looper mLooper;
    private NativeHandler mNativeHandler;
    MessageQueue mQueue;
    MqqMessageQueue mSubQueue;
    public static AtomicInteger sInjectCount = new AtomicInteger(0);
    private static boolean isMqqHandlerEnable = false;
    private static boolean isEnableInited = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class NativeHandler extends Handler {
        MqqHandler mParentHandler;

        public NativeHandler(Looper looper, Handler.Callback callback) {
            super(looper, callback);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            this.mParentHandler.dispatchMessage(message);
        }
    }

    public MqqHandler() {
        this(Looper.myLooper(), null);
    }

    private final Message getPostMessage(Runnable runnable) {
        return Message.obtain(this.mNativeHandler, runnable);
    }

    private final void handleCallback(Message message) {
        message.getCallback().run();
    }

    public static boolean isMqqHandlerEnable() {
        return true;
    }

    @Override // mqq.os.IMqqMessageCallback
    public void dispatchMessage(Message message) {
        if (this.beRegulatoring) {
            sRegulatorCallback.checkInRegulatorMsg();
        }
        if (message.getCallback() != null) {
            handleCallback(message);
            return;
        }
        Handler.Callback callback = this.mCallback;
        if (callback != null && callback.handleMessage(message)) {
            return;
        }
        handleMessage(message);
    }

    public final void dump(Printer printer, String str) {
        if (!this.beInjected) {
            this.mNativeHandler.dump(printer, str);
        }
    }

    public final Looper getLooper() {
        return this.mLooper;
    }

    public String getMessageName(Message message) {
        if (message.getCallback() != null) {
            return message.getCallback().getClass().getName();
        }
        return RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(message.what);
    }

    public final boolean hasMessages(int i3) {
        return this.beInjected ? this.mSubQueue.removeMessages(this, i3, null, false) : this.mNativeHandler.hasMessages(i3);
    }

    public final Message obtainMessage() {
        return Message.obtain(this.mNativeHandler);
    }

    public final boolean post(Runnable runnable) {
        return sendMessageDelayed(getPostMessage(runnable), 0L);
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        return sendMessageAtFrontOfQueue(getPostMessage(runnable));
    }

    public final boolean postAtTime(Runnable runnable, long j3) {
        return sendMessageAtTime(getPostMessage(runnable), j3);
    }

    public final boolean postDelayed(Runnable runnable, long j3) {
        return sendMessageDelayed(getPostMessage(runnable), j3);
    }

    public final void removeCallbacks(Runnable runnable) {
        if (this.beInjected) {
            this.mSubQueue.removeMessages(this, runnable, null);
        } else {
            this.mNativeHandler.removeCallbacks(runnable);
        }
    }

    public void removeCallbacksAndMessages(Object obj) {
        if (this.beInjected) {
            this.mSubQueue.removeCallbacksAndMessages(this, obj);
        } else {
            this.mNativeHandler.removeCallbacksAndMessages(obj);
        }
    }

    public final void removeMessages(int i3) {
        if (this.beInjected) {
            this.mSubQueue.removeMessages(this, i3, null, true);
        } else {
            this.mNativeHandler.removeMessages(i3);
        }
    }

    public final boolean sendEmptyMessage(int i3) {
        return sendEmptyMessageDelayed(i3, 0L);
    }

    public final boolean sendEmptyMessageAtTime(int i3, long j3) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        return sendMessageAtTime(obtain, j3);
    }

    public final boolean sendEmptyMessageDelayed(int i3, long j3) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        return sendMessageDelayed(obtain, j3);
    }

    public final boolean sendMessage(Message message) {
        return sendMessageDelayed(message, 0L);
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        if (this.beInjected) {
            MqqMessageQueue mqqMessageQueue = this.mSubQueue;
            if (mqqMessageQueue != null) {
                MqqMessage obtain = MqqMessage.obtain(message);
                obtain.target = this;
                return mqqMessageQueue.enqueueMessage(obtain, 0L);
            }
            throw new RuntimeException(this + " sendMessageAtTime() called with no mSubQueue");
        }
        return this.mNativeHandler.sendMessageAtFrontOfQueue(message);
    }

    public boolean sendMessageAtTime(Message message, long j3) {
        if (this.beInjected) {
            MqqMessageQueue mqqMessageQueue = this.mSubQueue;
            if (mqqMessageQueue != null) {
                MqqMessage obtain = MqqMessage.obtain(message);
                obtain.target = this;
                return mqqMessageQueue.enqueueMessage(obtain, j3);
            }
            throw new RuntimeException(this + " sendMessageAtTime() called with no mSubQueue");
        }
        return this.mNativeHandler.sendMessageAtTime(message, j3);
    }

    public final boolean sendMessageDelayed(Message message, long j3) {
        if (j3 < 0) {
            j3 = 0;
        }
        return sendMessageAtTime(message, SystemClock.uptimeMillis() + j3);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("Handler (");
        stringBuffer.append(getClass().getName());
        stringBuffer.append(") {");
        stringBuffer.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public MqqHandler(Handler.Callback callback) {
        this(Looper.myLooper(), callback);
    }

    private final Message getPostMessage(Runnable runnable, Object obj) {
        Message obtain = Message.obtain(this.mNativeHandler, runnable);
        obtain.obj = obj;
        return obtain;
    }

    public final boolean hasMessages(int i3, Object obj) {
        return this.beInjected ? this.mSubQueue.removeMessages(this, i3, obj, false) : this.mNativeHandler.hasMessages(i3, obj);
    }

    public Message obtainMessage(int i3, Runnable runnable) {
        Message obtain = Message.obtain(this.mNativeHandler, runnable);
        obtain.what = i3;
        return obtain;
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j3) {
        return sendMessageAtTime(getPostMessage(runnable, obj), j3);
    }

    public MqqHandler(Looper looper) {
        this(looper, null);
    }

    public MqqHandler(Looper looper, Handler.Callback callback) {
        this(looper, callback, false);
    }

    public final Message obtainMessage(int i3) {
        return Message.obtain(this.mNativeHandler, i3);
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        if (this.beInjected) {
            this.mSubQueue.removeMessages(this, runnable, obj);
        } else {
            this.mNativeHandler.removeCallbacks(runnable, obj);
        }
    }

    public final void removeMessages(int i3, Object obj) {
        if (this.beInjected) {
            this.mSubQueue.removeMessages(this, i3, obj, true);
        } else {
            this.mNativeHandler.removeMessages(i3, obj);
        }
    }

    public MqqHandler(Looper looper, Handler.Callback callback, boolean z16) {
        MqqRegulatorCallback mqqRegulatorCallback;
        this.beInjected = false;
        this.beRegulatoring = false;
        this.mLooper = looper;
        if (looper != null) {
            this.mCallback = callback;
            try {
                MessageQueue queue = looper.getQueue();
                this.mQueue = queue;
                if (queue != null && looper == Looper.getMainLooper() && isMqqHandlerEnable() && !z16) {
                    this.beInjected = true;
                    sInjectCount.incrementAndGet();
                    this.mSubQueue = MqqMessageQueue.getSubMainThreadQueue();
                } else if (looper != Looper.getMainLooper() && (mqqRegulatorCallback = sRegulatorCallback) != null) {
                    this.beRegulatoring = mqqRegulatorCallback.regulatorThread(looper.getThread());
                }
            } catch (Throwable unused) {
                this.beInjected = false;
            }
            NativeHandler nativeHandler = new NativeHandler(looper, callback);
            this.mNativeHandler = nativeHandler;
            nativeHandler.mParentHandler = this;
            return;
        }
        throw new RuntimeException("Can't create handler inside thread that has not called Looper.prepare()");
    }

    public final Message obtainMessage(int i3, Object obj) {
        return Message.obtain(this.mNativeHandler, i3, obj);
    }

    public final Message obtainMessage(int i3, int i16, int i17) {
        return Message.obtain(this.mNativeHandler, i3, i16, i17);
    }

    public final Message obtainMessage(int i3, int i16, int i17, Object obj) {
        return Message.obtain(this.mNativeHandler, i3, i16, i17, obj);
    }

    public static void setMqqHandlerEnable(boolean z16) {
    }

    public void handleMessage(Message message) {
    }
}
