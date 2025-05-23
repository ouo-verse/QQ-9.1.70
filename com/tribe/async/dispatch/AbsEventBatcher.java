package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class AbsEventBatcher<EVENT> {
    private static final boolean DEBUG = false;
    private static final int MAX_BATCHING_TIME = 30;
    private static final int MSG_POST = 1;
    private static final int STATE_BATCHING = 2;
    private static final int STATE_EXECUTING = 3;
    private static final int STATE_WAIT_EVENT = 1;
    private static final String TAG = "async.dispatch.LightWeightExecutor";
    private int mEnqueueSize;
    private final Handler mHandler;
    private final int mMaxMillisInsideHandleMessage;
    private final SimpleQueue<EVENT> mQueue;
    private AtomicInteger mState = new AtomicInteger(1);

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class LightWeightHandler extends Handler {
        public LightWeightHandler(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            if (!AbsEventBatcher.this.mState.compareAndSet(2, 3)) {
                SLog.w(AbsEventBatcher.TAG, "Threre should not be STATE_BATCHING state. state = " + AbsEventBatcher.this.mState);
                AbsEventBatcher.this.mState.set(3);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                synchronized (AbsEventBatcher.this) {
                    Object poll = AbsEventBatcher.this.mQueue.poll();
                    if (poll == null) {
                        if (!AbsEventBatcher.this.mState.compareAndSet(3, 1)) {
                            SLog.d(AbsEventBatcher.TAG, "The state should be STATE_EXECUTING, state = " + AbsEventBatcher.this.mState);
                            AbsEventBatcher.this.mState.set(1);
                        }
                        return;
                    }
                    AbsEventBatcher.access$210(AbsEventBatcher.this);
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    AbsEventBatcher.this.handleItem(poll);
                    long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis2;
                    if (uptimeMillis3 > 50) {
                        SLog.w(AbsEventBatcher.TAG, "handle item %d ms!, item = %s", Long.valueOf(uptimeMillis3), poll);
                    }
                }
            } while (SystemClock.uptimeMillis() - uptimeMillis < AbsEventBatcher.this.mMaxMillisInsideHandleMessage);
            if (sendEmptyMessage(1)) {
            } else {
                throw new DispatcherException("Could not send handler message");
            }
        }
    }

    public AbsEventBatcher(Looper looper, SimpleQueue<EVENT> simpleQueue, int i3) {
        this.mQueue = simpleQueue;
        this.mHandler = new LightWeightHandler(looper);
        this.mMaxMillisInsideHandleMessage = i3;
    }

    static /* synthetic */ int access$210(AbsEventBatcher absEventBatcher) {
        int i3 = absEventBatcher.mEnqueueSize;
        absEventBatcher.mEnqueueSize = i3 - 1;
        return i3;
    }

    public void dumpAllEvent() {
        synchronized (this) {
            this.mQueue.dump();
        }
    }

    public void enqueue(@NonNull EVENT event) {
        synchronized (this) {
            this.mQueue.enqueue(event);
            this.mEnqueueSize++;
        }
        if (this.mState.compareAndSet(1, 2) && !this.mHandler.sendEmptyMessageDelayed(1, 30L)) {
            throw new RuntimeException("Could not send handler message");
        }
    }

    public int getCurState() {
        return this.mState.get();
    }

    public int getEnqueueSize() {
        return this.mEnqueueSize;
    }

    protected abstract void handleItem(EVENT event);
}
