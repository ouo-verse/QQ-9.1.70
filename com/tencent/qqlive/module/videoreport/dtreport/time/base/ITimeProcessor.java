package com.tencent.qqlive.module.videoreport.dtreport.time.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes22.dex */
public interface ITimeProcessor {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface ProcessorState {
        public static final int INIT = -1;
        public static final int STARTED = 0;
        public static final int STOPPED = 1;
    }

    long getBackgroundDuration();

    long getForegroundDuration();

    void reset();

    void setInForeground(boolean z16);

    void start();

    void stop();
}
