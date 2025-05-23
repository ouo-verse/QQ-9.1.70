package com.tribe.async.async;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class MainFreeJobScheduler implements JobScheduler {
    private static final int MSG_DISPATCH_JOB_SCHEDULE = 2;
    private static final int MSG_MAIN_THREAD_SCHEDULE = 1;
    private final Handler mDispatchHandler;
    private final Handler mMainHandler = new MainThreadScheduleHandler();
    private ChoreographerScheduler mChoreographerScheduler = new ChoreographerScheduler();

    /* compiled from: P */
    @TargetApi(16)
    /* loaded from: classes27.dex */
    private class ChoreographerScheduler {
        private Choreographer mChoreographer = Choreographer.getInstance();

        public ChoreographerScheduler() {
        }

        public void schedule() {
            this.mChoreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: com.tribe.async.async.MainFreeJobScheduler.ChoreographerScheduler.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j3) {
                    MainFreeJobScheduler.this.mMainHandler.sendEmptyMessageDelayed(1, 3L);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class DispatchScheduleHandler extends Handler {
        public DispatchScheduleHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                MainFreeJobScheduler.this.doSchedule();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class MainThreadScheduleHandler extends Handler {
        public MainThreadScheduleHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Message.obtain(MainFreeJobScheduler.this.mDispatchHandler, 2).sendToTarget();
            }
        }
    }

    public MainFreeJobScheduler(Looper looper) {
        this.mDispatchHandler = new DispatchScheduleHandler(looper);
    }

    public abstract void doSchedule();

    @Override // com.tribe.async.async.JobScheduler
    public void schedule() {
        this.mChoreographerScheduler.schedule();
    }
}
