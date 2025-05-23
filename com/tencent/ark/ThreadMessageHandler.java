package com.tencent.ark;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ThreadMessageHandler extends Handler {
    private static final int ASYNC_MESSAGE = 1;
    static final MessageWrapperImpl IMPL = new LollipopMr1MessageWrapperImpl();
    private static final int SYNC_MESSAGE = 2;
    private static final String TAG = "ArkApp.Thread";
    private final Object mSignalObject = new Object();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static final class LegacyMessageWrapperImpl implements MessageWrapperImpl {
        private Method mMessageMethodSetAsynchronous;

        LegacyMessageWrapperImpl() {
            try {
                this.mMessageMethodSetAsynchronous = Class.forName("android.os.Message").getMethod("setAsynchronous", Boolean.TYPE);
            } catch (ClassNotFoundException e16) {
                Log.e(ThreadMessageHandler.TAG, "Failed to find android.os.Message class", e16);
            } catch (NoSuchMethodException e17) {
                Log.e(ThreadMessageHandler.TAG, "Failed to load Message.setAsynchronous method", e17);
            } catch (RuntimeException e18) {
                Log.e(ThreadMessageHandler.TAG, "Exception while loading Message.setAsynchronous method", e18);
            }
        }

        @Override // com.tencent.ark.ThreadMessageHandler.MessageWrapperImpl
        public void setAsynchronous(Message message, boolean z16) {
            Method method = this.mMessageMethodSetAsynchronous;
            if (method == null) {
                return;
            }
            try {
                method.invoke(message, Boolean.valueOf(z16));
            } catch (IllegalAccessException unused) {
                Log.e(ThreadMessageHandler.TAG, "Illegal access to async message creation, disabling.");
                this.mMessageMethodSetAsynchronous = null;
            } catch (IllegalArgumentException unused2) {
                Log.e(ThreadMessageHandler.TAG, "Illegal argument for async message creation, disabling.");
                this.mMessageMethodSetAsynchronous = null;
            } catch (RuntimeException unused3) {
                Log.e(ThreadMessageHandler.TAG, "Runtime exception during async message creation, disabling.");
                this.mMessageMethodSetAsynchronous = null;
            } catch (InvocationTargetException unused4) {
                Log.e(ThreadMessageHandler.TAG, "Invocation exception during async message creation, disabling.");
                this.mMessageMethodSetAsynchronous = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static final class LollipopMr1MessageWrapperImpl implements MessageWrapperImpl {
        LollipopMr1MessageWrapperImpl() {
        }

        @Override // com.tencent.ark.ThreadMessageHandler.MessageWrapperImpl
        @TargetApi(22)
        public void setAsynchronous(Message message, boolean z16) {
            message.setAsynchronous(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface MessageWrapperImpl {
        void setAsynchronous(Message message, boolean z16);
    }

    ThreadMessageHandler() {
    }

    private static ThreadMessageHandler create() {
        return new ThreadMessageHandler();
    }

    private native boolean nativeDelegateCallback(long j3);

    private Message obtainAsyncMessage(int i3, long j3) {
        Message obtain = Message.obtain(this, i3, (int) j3, (int) (j3 >> 32));
        IMPL.setAsynchronous(obtain, true);
        return obtain;
    }

    private boolean postDelegate(long j3) {
        return sendMessage(obtainAsyncMessage(1, j3));
    }

    private boolean postDelegateDelayed(long j3, long j16) {
        return sendMessageDelayed(obtainAsyncMessage(1, j3), j16);
    }

    private boolean sendDelegate(long j3) {
        synchronized (this.mSignalObject) {
            if (!sendMessage(obtainAsyncMessage(2, j3))) {
                return false;
            }
            try {
                LockMethodProxy.wait(this.mSignalObject);
                return true;
            } catch (InterruptedException unused) {
                return false;
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1 && i3 != 2) {
            return;
        }
        nativeDelegateCallback((message.arg2 << 32) | message.arg1);
        if (message.what == 2) {
            synchronized (this.mSignalObject) {
                this.mSignalObject.notifyAll();
            }
        }
    }
}
