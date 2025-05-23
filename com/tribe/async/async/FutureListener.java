package com.tribe.async.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.utils.AssertUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface FutureListener<Progress, Result> {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class FutureListenerWrapper<Progress, Result> extends Handler implements FutureListener<Progress, Result> {
        private static final int REQUEST_CANCEL = 1;
        private static final int REQUEST_DONE = 3;
        private static final int REQUEST_PROGRESS = 2;
        private FutureListener listener;

        public FutureListenerWrapper(Looper looper, FutureListener futureListener) {
            super(looper);
            this.listener = futureListener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.listener.onFutureDone(message.obj);
                        return;
                    }
                    return;
                } else {
                    AssertUtils.checkNotNull(message.obj);
                    this.listener.onFutureProgress(message.obj);
                    return;
                }
            }
            this.listener.onFutureCanceled();
        }

        @Override // com.tribe.async.async.FutureListener
        public void onFutureCanceled() {
            Message.obtain(this, 1).sendToTarget();
        }

        @Override // com.tribe.async.async.FutureListener
        public void onFutureDone(Result result) {
            Message.obtain(this, 3, result).sendToTarget();
        }

        @Override // com.tribe.async.async.FutureListener
        public void onFutureProgress(@NonNull Progress progress) {
            Message.obtain(this, 2, progress).sendToTarget();
        }
    }

    void onFutureCanceled();

    void onFutureDone(@Nullable Result result);

    void onFutureProgress(@NonNull Progress progress);

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class SimpleFutureListener<Progress, Result> implements FutureListener<Progress, Result> {
        @Override // com.tribe.async.async.FutureListener
        public void onFutureCanceled() {
        }

        @Override // com.tribe.async.async.FutureListener
        public void onFutureDone(@Nullable Result result) {
        }

        @Override // com.tribe.async.async.FutureListener
        public void onFutureProgress(@NonNull Progress progress) {
        }
    }
}
