package com.tencent.qqlive.module.videoreport.report.element;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EleExposeInfo {
    private static final long ELEMENT_EXPOSE_EXPIRE_TIME = TimeUnit.MILLISECONDS.convert(30, TimeUnit.MINUTES);
    private long mExposeTime;
    private boolean mHasReport;

    public boolean hasReport() {
        return this.mHasReport;
    }

    public void onExpose() {
        this.mExposeTime = SystemClock.elapsedRealtime();
    }

    public void onReport() {
        this.mHasReport = true;
    }

    public boolean reportOverTime() {
        if (SystemClock.elapsedRealtime() - this.mExposeTime > ELEMENT_EXPOSE_EXPIRE_TIME) {
            return true;
        }
        return false;
    }

    public void resetReport() {
        this.mHasReport = false;
    }

    public String toString() {
        return "EleExposeInfo{mExposeTime=" + this.mExposeTime + "reportOverTime=" + reportOverTime() + "mHasReport=" + this.mHasReport + '}';
    }
}
