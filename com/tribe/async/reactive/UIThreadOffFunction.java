package com.tribe.async.reactive;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.log.SLog;
import com.tribe.async.utils.AssertUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UIThreadOffFunction<IN> extends StreamFunction<IN, IN> {
    private static final int MSG_THREAD_OFF_ERROR = 2;
    private static final int MSG_THREAD_OFF_RESULT = 1;
    private static final String TAG = "async.UIThreadOffFunction";
    private Handler mHandler = new InnerHandler(Looper.getMainLooper());
    private WeakReference<IEventReceiver> mRef;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class InnerHandler extends Handler {
        public InnerHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!UIThreadOffFunction.this.isValidate()) {
                return;
            }
            AssertUtils.checkNotNull(message.obj);
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    UIThreadOffFunction.this.notifyError((java.lang.Error) message.obj);
                    return;
                }
                return;
            }
            UIThreadOffFunction.this.notifyResult(message.obj);
        }
    }

    public UIThreadOffFunction(@Nullable IEventReceiver iEventReceiver) {
        if (iEventReceiver != null) {
            this.mRef = new WeakReference<>(iEventReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidate() {
        WeakReference<IEventReceiver> weakReference = this.mRef;
        if (weakReference == null) {
            return true;
        }
        IEventReceiver iEventReceiver = weakReference.get();
        if (iEventReceiver == null) {
            SLog.w(TAG, "receiver is null for WeakReference.");
            return false;
        }
        return iEventReceiver.isValidate();
    }

    @Override // com.tribe.async.reactive.StreamFunction
    protected void call(IN in5) {
        if (!isValidate()) {
            return;
        }
        Message.obtain(this.mHandler, 1, in5).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.reactive.StreamFunction
    public void error(java.lang.Error error) {
        if (!isValidate()) {
            return;
        }
        Message.obtain(this.mHandler, 2, error).sendToTarget();
    }
}
