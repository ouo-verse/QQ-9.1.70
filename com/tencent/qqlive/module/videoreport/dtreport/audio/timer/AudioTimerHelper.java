package com.tencent.qqlive.module.videoreport.dtreport.audio.timer;

import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.audio.AudioSession;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.AudioTimerPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioTimerListener;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AudioTimerHelper {
    private static AudioReportData mLastAudioReportData;

    private static boolean allowCrossAudio(AudioTimerPolicy.StartType startType, AudioSession audioSession) {
        if (startType == AudioTimerPolicy.StartType.TYPE_MERGE_ALL && audioSession.getAudioEntity().getContentId().equals(mLastAudioReportData.contentId)) {
            return true;
        }
        return false;
    }

    private static boolean allowSameAudio(AudioTimerPolicy.StartType startType, AudioSession audioSession, int i3) {
        if (startType == AudioTimerPolicy.StartType.TYPE_MERGE && i3 == mLastAudioReportData.audioPlayerId && audioSession.getAudioEntity().getContentId().equals(mLastAudioReportData.contentId)) {
            return true;
        }
        return false;
    }

    public static void clearStashAudioReportData() {
        mLastAudioReportData = null;
    }

    private static IAudioTimerListener getIAudioTimerListener(Object obj) {
        Object extendParam = DataRWProxy.getExtendParam(obj, DTConstants.DTExtendMapKey.AUDIO_TIMER_LISTENER);
        if (extendParam instanceof WeakReference) {
            WeakReference weakReference = (WeakReference) extendParam;
            if (weakReference.get() != null && (weakReference.get() instanceof IAudioTimerListener)) {
                return (IAudioTimerListener) weakReference.get();
            }
            return null;
        }
        return null;
    }

    public static AudioTimerPolicy.StartType getStartType(Object obj) {
        AudioTimerPolicy.StartType startType = AudioTimerPolicy.StartType.TYPE_NORMAL;
        IAudioTimerListener iAudioTimerListener = getIAudioTimerListener(obj);
        if (iAudioTimerListener != null) {
            return iAudioTimerListener.onAudioStart();
        }
        return startType;
    }

    public static AudioReportData getStashAudioReportData() {
        return mLastAudioReportData;
    }

    public static AudioTimerPolicy.StopType getStopType(Object obj) {
        AudioTimerPolicy.StopType stopType = AudioTimerPolicy.StopType.TYPE_NORMAL;
        IAudioTimerListener iAudioTimerListener = getIAudioTimerListener(obj);
        if (iAudioTimerListener != null) {
            return iAudioTimerListener.onAudioStop();
        }
        return stopType;
    }

    public static boolean needMergeAudioReportData(AudioTimerPolicy.StartType startType, AudioSession audioSession, int i3) {
        if (mLastAudioReportData == null || audioSession.getAudioEntity() == null) {
            return false;
        }
        if (!allowSameAudio(startType, audioSession, i3) && !allowCrossAudio(startType, audioSession)) {
            return false;
        }
        return true;
    }

    public static void stashAudioReportData(int i3, AudioSession audioSession) {
        AudioReportData audioReportData = new AudioReportData();
        mLastAudioReportData = audioReportData;
        audioReportData.startTime = audioSession.getStartTime();
        mLastAudioReportData.endTime = System.currentTimeMillis();
        AudioReportData audioReportData2 = mLastAudioReportData;
        audioReportData2.audioPlayerId = i3;
        audioReportData2.audioSessionId = audioSession.getAudioSessionId();
        mLastAudioReportData.backgroundDuration = audioSession.getBackgroundDuration();
        mLastAudioReportData.foregroundDuration = audioSession.getForegroundDuration();
        mLastAudioReportData.customParams = audioSession.getAudioEntity().getAudioCustomParams();
        mLastAudioReportData.contentId = audioSession.getAudioEntity().getContentId();
    }
}
