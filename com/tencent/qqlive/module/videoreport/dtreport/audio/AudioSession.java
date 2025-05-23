package com.tencent.qqlive.module.videoreport.dtreport.audio;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.appstatus.AppStatusManager;
import com.tencent.qqlive.module.videoreport.appstatus.IAppStatusListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.AudioTimerPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioInfoChangeListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioDataManager;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity;
import com.tencent.qqlive.module.videoreport.dtreport.audio.timer.AudioReportData;
import com.tencent.qqlive.module.videoreport.dtreport.audio.timer.AudioTimerHelper;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.TimerTaskManager;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AudioSession implements ITimeProcessor, IAudioSessionListener, IAppStatusListener, IAudioInfoChangeListener {
    private static final long DEFAULT_HEART_BEAT_INTERVAL = 60000;
    private static final long DEFAULT_TIME_PIN_INTERVAL = 5000;
    private static final long MIN_TIME_PIN_INTERVAL = 5000;
    private AudioEntity mAudioEntity;
    private Object mAudioPlayer;
    private String mAudioSessionId;
    private long mBackgroundDuration;
    private HeartBeatProcessor mCurrentHeartBeatProcessor;
    private long mForegroundDuration;
    private String mHeartBeatTaskKey;
    private boolean mIsInEndState = false;
    private int mProcessorState = -1;
    private long mStartTime = -1;
    private boolean mNeedReStartAfterAudioInfoChanged = false;
    private long mHeartBeatInterval = VideoReportInner.getInstance().getConfiguration().getAudioReportHearBeatInterval() * 1000;
    private long mTimePinInterval = VideoReportInner.getInstance().getConfiguration().getAudioTimePinInterval() * 1000;

    public AudioSession(Object obj) {
        this.mAudioPlayer = obj;
        initHeartBeatProcessor();
        AppStatusManager.getInstance().register(this);
        AudioDataManager.getInstance().registerListener(this);
        reset();
    }

    private void initHeartBeatProcessor() {
        if (this.mHeartBeatInterval <= 0) {
            this.mHeartBeatInterval = 60000L;
        }
        if (this.mTimePinInterval <= 0) {
            this.mTimePinInterval = 5000L;
        }
        if (this.mTimePinInterval < 5000) {
            this.mTimePinInterval = 5000L;
        }
        long j3 = this.mTimePinInterval;
        if (j3 > this.mHeartBeatInterval) {
            this.mHeartBeatInterval = j3;
        }
        HeartBeatProcessor heartBeatProcessor = new HeartBeatProcessor(AppStatusManager.getInstance().isAppForground(), this.mTimePinInterval);
        this.mCurrentHeartBeatProcessor = heartBeatProcessor;
        heartBeatProcessor.setHeartBeatCallback(new a());
    }

    private void startHeartBeatProcessor() {
        this.mAudioEntity = AudioDataManager.getInstance().getAudioInfo(this.mAudioPlayer);
        this.mCurrentHeartBeatProcessor.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void triggerTiming() {
        this.mCurrentHeartBeatProcessor.stop();
        this.mForegroundDuration += this.mCurrentHeartBeatProcessor.getForegroundDuration();
        this.mBackgroundDuration += this.mCurrentHeartBeatProcessor.getBackgroundDuration();
        this.mCurrentHeartBeatProcessor.reset();
        if (this.mProcessorState == 0) {
            startHeartBeatProcessor();
        }
    }

    public AudioEntity getAudioEntity() {
        return this.mAudioEntity;
    }

    public String getAudioSessionId() {
        return this.mAudioSessionId;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public long getBackgroundDuration() {
        return this.mBackgroundDuration;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public long getForegroundDuration() {
        return this.mForegroundDuration;
    }

    public long getHeartBeatInterval() {
        return this.mHeartBeatInterval;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getTimePinInterval() {
        return this.mTimePinInterval;
    }

    public boolean isInEndState() {
        return this.mIsInEndState;
    }

    public void mergeLastAudioReportData(AudioReportData audioReportData) {
        if (audioReportData == null) {
            return;
        }
        this.mStartTime = audioReportData.startTime;
        this.mForegroundDuration += audioReportData.foregroundDuration;
        this.mBackgroundDuration += audioReportData.backgroundDuration;
        AudioEntity audioEntity = this.mAudioEntity;
        if (audioEntity != null) {
            audioEntity.mergeOldParams(audioReportData.customParams);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.appstatus.IAppStatusListener
    public void onAppStatusChanged(int i3) {
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        setInForeground(z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.IAudioSessionListener
    public void onAudioEnd() {
        this.mIsInEndState = true;
        stop();
        if (AudioTimerHelper.getStopType(this.mAudioPlayer) == AudioTimerPolicy.StopType.TYPE_STASH) {
            AudioTimerHelper.stashAudioReportData(this.mAudioPlayer.hashCode(), this);
            AudioEventReporter.stashAudioEnd(this.mAudioPlayer, this.mForegroundDuration, this.mBackgroundDuration, this);
        } else {
            AudioEventReporter.reportAudioEnd(this.mAudioPlayer, this);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioInfoChangeListener
    public void onAudioInfoChangedEnd(Object obj, @NonNull AudioEntity audioEntity, Map<String, Object> map) {
        if (obj == this.mAudioPlayer && this.mNeedReStartAfterAudioInfoChanged) {
            onAudioStart();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioInfoChangeListener
    public void onAudioInfoChangedStart(Object obj, @NonNull AudioEntity audioEntity, Map<String, Object> map) {
        if (obj == this.mAudioPlayer && this.mProcessorState == 0) {
            this.mNeedReStartAfterAudioInfoChanged = false;
            AudioEntity audioEntity2 = this.mAudioEntity;
            if (audioEntity2 != null && !audioEntity2.isSameAudio(audioEntity)) {
                this.mAudioEntity.appendParams(map);
                onAudioEnd();
                reset();
                this.mNeedReStartAfterAudioInfoChanged = true;
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.IAudioSessionListener
    public void onAudioPause() {
        stop();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.IAudioSessionListener
    public void onAudioResume() {
        start();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.IAudioSessionListener
    public void onAudioStart() {
        this.mIsInEndState = false;
        start();
        this.mStartTime = System.currentTimeMillis();
        boolean needMergeAudioReportData = AudioTimerHelper.needMergeAudioReportData(AudioTimerHelper.getStartType(this.mAudioPlayer), this, this.mAudioPlayer.hashCode());
        AudioReportData stashAudioReportData = AudioTimerHelper.getStashAudioReportData();
        if (needMergeAudioReportData) {
            mergeLastAudioReportData(stashAudioReportData);
        } else {
            AudioEventReporter.reportAudioEnd(stashAudioReportData);
            AudioEventReporter.reportAudioStart(this.mAudioPlayer, this);
        }
        AudioTimerHelper.clearStashAudioReportData();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.IAudioSessionListener
    public void onBufferingEnd() {
        this.mCurrentHeartBeatProcessor.forbidTimePinTiming(false);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.IAudioSessionListener
    public void onBufferingStart() {
        this.mCurrentHeartBeatProcessor.forbidTimePinTiming(true);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public void reset() {
        if (this.mProcessorState == 0) {
            stop();
        }
        this.mAudioSessionId = ReportUtils.generateSessionId();
        this.mProcessorState = -1;
        this.mForegroundDuration = 0L;
        this.mBackgroundDuration = 0L;
        this.mHeartBeatTaskKey = null;
        this.mCurrentHeartBeatProcessor.reset();
        this.mCurrentHeartBeatProcessor.setSessionId(this.mAudioSessionId);
        this.mCurrentHeartBeatProcessor.forbidTimePinTiming(false);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public void setInForeground(boolean z16) {
        this.mCurrentHeartBeatProcessor.setInForeground(z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public void start() {
        if (this.mProcessorState == 0) {
            stop();
        }
        this.mProcessorState = 0;
        TimerTaskManager timerTaskManager = TimerTaskManager.getInstance();
        Runnable runnable = new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.AudioSession.1
            @Override // java.lang.Runnable
            public void run() {
                AudioSession.this.triggerTiming();
            }
        };
        long j3 = this.mHeartBeatInterval;
        this.mHeartBeatTaskKey = timerTaskManager.addUIThreadTimerTask(runnable, j3, j3);
        startHeartBeatProcessor();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public void stop() {
        if (this.mProcessorState == 0) {
            this.mProcessorState = 1;
            TimerTaskManager.getInstance().cancelTimerTask(this.mHeartBeatTaskKey);
            this.mHeartBeatTaskKey = null;
            triggerTiming();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements HeartBeatProcessor.IHeartBeatCallback {
        a() {
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.IHeartBeatCallback
        public void saveHeartBeatInfo(String str, long j3, long j16) {
            AudioEventReporter.stashAudioEnd(AudioSession.this.mAudioPlayer, AudioSession.this.mForegroundDuration + j3, AudioSession.this.mBackgroundDuration + j16, AudioSession.this);
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.IHeartBeatCallback
        public void reportHeartBeat(String str, long j3, long j16) {
        }
    }
}
