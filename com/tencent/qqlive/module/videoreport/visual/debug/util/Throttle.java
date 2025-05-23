package com.tencent.qqlive.module.videoreport.visual.debug.util;

import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Throttle {
    private Long delay;
    private volatile boolean needWait;
    private Runnable runnable;
    private Timer timer = new BaseTimer();

    public Throttle(Runnable runnable, long j3) {
        this.runnable = runnable;
        this.delay = Long.valueOf(j3);
    }

    public static Throttle build(Runnable runnable, long j3) {
        return new Throttle(runnable, j3);
    }

    public void execute() {
        if (!this.needWait) {
            this.needWait = true;
            this.timer.schedule(new TimerTask() { // from class: com.tencent.qqlive.module.videoreport.visual.debug.util.Throttle.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Throttle.this.runnable.run();
                    Throttle.this.needWait = false;
                }
            }, this.delay.longValue());
        }
    }
}
