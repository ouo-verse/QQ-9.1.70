package com.google.android.exoplayer2.ext.mediaplayer;

import android.os.Handler;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Repeater {
    private Handler delayedHandler;
    private RepeatListener listener;
    private volatile boolean repeaterRunning = false;
    private int repeatDelay = 1000;
    private PollRunnable pollRunnable = new PollRunnable();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class PollRunnable implements Runnable {
        PollRunnable() {
        }

        void performPoll() {
            Repeater.this.delayedHandler.postDelayed(Repeater.this.pollRunnable, Repeater.this.repeatDelay);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Repeater.this.listener != null) {
                Repeater.this.listener.onUpdate();
            }
            if (Repeater.this.repeaterRunning) {
                performPoll();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    interface RepeatListener {
        void onUpdate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Repeater(Handler handler) {
        this.delayedHandler = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRepeatListener(RepeatListener repeatListener) {
        this.listener = repeatListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRepeaterDelay(int i3) {
        this.repeatDelay = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        if (!this.repeaterRunning) {
            this.repeaterRunning = true;
            this.pollRunnable.performPoll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        this.repeaterRunning = false;
    }
}
