package com.tencent.smtt.utils;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Timer {
    public final int timeOut;

    public Timer(int i3) {
        if (i3 >= 0) {
            this.timeOut = i3;
            return;
        }
        throw new IllegalArgumentException("time out can not < 0, current is " + i3);
    }

    public void onTimeOut() {
    }
}
