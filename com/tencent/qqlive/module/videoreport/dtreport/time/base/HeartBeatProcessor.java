package com.tencent.qqlive.module.videoreport.dtreport.time.base;

import com.tencent.qqlive.module.videoreport.task.TimerTaskManager;

/* loaded from: classes22.dex */
public class HeartBeatProcessor implements ITimeProcessor {
    private long mBackgroundDuration;
    private TimePinProcessor mCurrentTimePinProcessor;
    private long mForegroundDuration;
    private IHeartBeatCallback mHeartBeatCallback;
    private boolean mIsInForeground;
    private int mProcessorState = -1;
    private String mSessionId;
    private long mTimePinInterval;
    private String mTimePinTaskKey;

    /* loaded from: classes22.dex */
    public interface IHeartBeatCallback {
        void reportHeartBeat(String str, long j3, long j16);

        void saveHeartBeatInfo(String str, long j3, long j16);
    }

    public HeartBeatProcessor(boolean z16, long j3) {
        this.mIsInForeground = z16;
        this.mTimePinInterval = j3;
        this.mCurrentTimePinProcessor = new TimePinProcessor(z16, j3);
        reset();
    }

    private void notifyReportHeartBeat() {
        IHeartBeatCallback iHeartBeatCallback = this.mHeartBeatCallback;
        if (iHeartBeatCallback != null) {
            iHeartBeatCallback.reportHeartBeat(this.mSessionId, this.mForegroundDuration, this.mBackgroundDuration);
        }
    }

    private void notifySaveHeartBeatInfo() {
        IHeartBeatCallback iHeartBeatCallback = this.mHeartBeatCallback;
        if (iHeartBeatCallback != null) {
            iHeartBeatCallback.saveHeartBeatInfo(this.mSessionId, this.mForegroundDuration, this.mBackgroundDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void triggerTiming(boolean z16) {
        this.mCurrentTimePinProcessor.stop();
        this.mForegroundDuration += this.mCurrentTimePinProcessor.getForegroundDuration();
        this.mBackgroundDuration += this.mCurrentTimePinProcessor.getBackgroundDuration();
        this.mCurrentTimePinProcessor.reset();
        if (!z16) {
            notifyReportHeartBeat();
        } else if (this.mProcessorState == 0) {
            this.mCurrentTimePinProcessor.start();
            notifySaveHeartBeatInfo();
        }
    }

    public synchronized void forbidTimePinTiming(boolean z16) {
        this.mCurrentTimePinProcessor.forbidTiming(z16);
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
        this.mTimePinTaskKey = null;
        this.mCurrentTimePinProcessor.reset();
    }

    public void setHeartBeatCallback(IHeartBeatCallback iHeartBeatCallback) {
        this.mHeartBeatCallback = iHeartBeatCallback;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void setInForeground(boolean z16) {
        this.mCurrentTimePinProcessor.setInForeground(z16);
        this.mIsInForeground = z16;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void start() {
        if (this.mProcessorState == 0) {
            stop();
        }
        this.mProcessorState = 0;
        TimerTaskManager timerTaskManager = TimerTaskManager.getInstance();
        Runnable runnable = new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                HeartBeatProcessor.this.triggerTiming(true);
            }
        };
        long j3 = this.mTimePinInterval;
        this.mTimePinTaskKey = timerTaskManager.addUIThreadTimerTask(runnable, j3, j3);
        this.mCurrentTimePinProcessor.start();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void stop() {
        if (this.mProcessorState == 0) {
            this.mProcessorState = 1;
            TimerTaskManager.getInstance().cancelTimerTask(this.mTimePinTaskKey);
            this.mTimePinTaskKey = null;
            triggerTiming(false);
        }
    }
}
