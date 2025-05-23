package com.tencent.qqlive.module.videoreport.dtreport.time.base;

import android.os.SystemClock;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;

/* loaded from: classes22.dex */
public class TimePinProcessor implements ITimeProcessor {
    private static final String TAG = "TimePinProcessor";
    private long mBackgroundDuration;
    private long mForegroundDuration;
    private boolean mIsInForeground;
    private boolean mIsTimeForbidden;
    private long mPinDeviation;
    private int mProcessorState = -1;
    private long mStartTime;

    public TimePinProcessor(boolean z16, long j3) {
        this.mIsInForeground = z16;
        this.mPinDeviation = j3 * 2;
        reset();
    }

    private void printErrorLog(long j3) {
        if (VideoReport.isDebugMode()) {
            Log.i(TAG, "\u5fc3\u8df3\u95f4\u9694\u5f02\u5e38\uff0cexpected interval = " + (((float) this.mPinDeviation) / 2.0f) + ", actual interval = " + j3);
        }
    }

    private synchronized void triggerTiming() {
        if (this.mIsTimeForbidden) {
            return;
        }
        if (this.mProcessorState == 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
            long j3 = this.mPinDeviation;
            if (elapsedRealtime > j3) {
                printErrorLog(j3);
                elapsedRealtime = j3;
            }
            if (this.mIsInForeground) {
                this.mForegroundDuration += elapsedRealtime;
            } else {
                this.mBackgroundDuration += elapsedRealtime;
            }
            this.mStartTime = SystemClock.elapsedRealtime();
        }
    }

    public synchronized void forbidTiming(boolean z16) {
        triggerTiming();
        this.mIsTimeForbidden = z16;
        if (!z16) {
            this.mStartTime = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized long getBackgroundDuration() {
        return this.mBackgroundDuration;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized long getForegroundDuration() {
        return this.mForegroundDuration;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void reset() {
        if (this.mProcessorState == 0) {
            stop();
        }
        this.mProcessorState = -1;
        this.mForegroundDuration = 0L;
        this.mBackgroundDuration = 0L;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void setInForeground(boolean z16) {
        if (this.mIsInForeground != z16) {
            triggerTiming();
            this.mIsInForeground = z16;
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void start() {
        if (this.mProcessorState == 0) {
            stop();
        }
        this.mProcessorState = 0;
        this.mStartTime = SystemClock.elapsedRealtime();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void stop() {
        triggerTiming();
        this.mProcessorState = 1;
    }
}
