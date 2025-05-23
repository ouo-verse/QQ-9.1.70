package com.tencent.qqlive.module.videoreport.dtreport.audio;

import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity;
import com.tencent.qqlive.module.videoreport.dtreport.audio.timer.AudioReportData;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AudioEventReporter extends DefaultEventListener {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final AudioEventReporter INSTANCE;

        static {
            AudioEventReporter audioEventReporter = new AudioEventReporter();
            INSTANCE = audioEventReporter;
            audioEventReporter.init();
        }

        InstanceHolder() {
        }
    }

    private static void addAudioPublicParams(AudioEntity audioEntity, Map<String, Object> map) {
        if (audioEntity != null && map != null) {
            map.put(DTParamKey.REPORT_KEY_AUDIO_CONTENTID, audioEntity.getContentId());
            Map<String, Object> audioCustomParams = audioEntity.getAudioCustomParams();
            if (audioCustomParams != null) {
                map.putAll(audioCustomParams);
            }
        }
    }

    public static AudioEventReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        EventCollector.getInstance().registerEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stashAudioEnd$0(Object obj, long j3, long j16, AudioSession audioSession) {
        if (!ReportHelper.isEventReportEnable(2)) {
            return;
        }
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(DTEventKey.AUDIO_END);
        finalData.putAll(prepareStashAudioEndReportData(obj, j3, j16, audioSession));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(DTEventKey.AUDIO_END, finalData.getEventParams());
        }
        FinalDataTarget.handleWithStash(obj, finalData);
    }

    private static Map<String, Object> prepareAudioEndReportData(Object obj, AudioSession audioSession) {
        HashMap hashMap = new HashMap();
        if (obj != null && audioSession != null) {
            addAudioPublicParams(audioSession.getAudioEntity(), hashMap);
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_ENDTIME, Long.valueOf(System.currentTimeMillis()));
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_SESSIONID, audioSession.getAudioSessionId());
            long foregroundDuration = audioSession.getForegroundDuration();
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_DURATION_FOREGROUND, Long.valueOf(foregroundDuration));
            long backgroundDuration = audioSession.getBackgroundDuration();
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_DURATION_BACKGROUND, Long.valueOf(backgroundDuration));
            hashMap.put("dt_play_duration", Long.valueOf(backgroundDuration + foregroundDuration));
        }
        return hashMap;
    }

    private static Map<String, Object> prepareAudioStartReportData(Object obj, AudioSession audioSession) {
        HashMap hashMap = new HashMap();
        if (obj != null && audioSession != null) {
            addAudioPublicParams(audioSession.getAudioEntity(), hashMap);
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_STARTTIME, Long.valueOf(audioSession.getStartTime()));
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_SESSIONID, audioSession.getAudioSessionId());
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_HEARTBEAT_INTERVAL, Long.valueOf(audioSession.getHeartBeatInterval() / 1000));
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_FILE_INTERVAL, Long.valueOf(audioSession.getTimePinInterval() / 1000));
            AudioEntity audioEntity = audioSession.getAudioEntity();
            if (audioEntity != null) {
                hashMap.put(DTParamKey.REPORT_KEY_PLAY_TYPE, audioEntity.getPlayType());
            }
            if (obj instanceof IAudioPlayer) {
                hashMap.put(DTParamKey.REPORT_KEY_AUDIO_PLAYER_TYPE, Integer.valueOf(((IAudioPlayer) obj).getPlayerType__()));
            }
        }
        return hashMap;
    }

    private static Map<String, Object> prepareStashAudioEndReportData(Object obj, long j3, long j16, AudioSession audioSession) {
        HashMap hashMap = new HashMap();
        if (obj != null && audioSession != null) {
            addAudioPublicParams(audioSession.getAudioEntity(), hashMap);
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_ENDTIME, Long.valueOf(System.currentTimeMillis()));
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_SESSIONID, audioSession.getAudioSessionId());
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_DURATION_FOREGROUND, Long.valueOf(j3));
            hashMap.put(DTParamKey.REPORT_KEY_AUDIO_DURATION_BACKGROUND, Long.valueOf(j16));
            hashMap.put("dt_play_duration", Long.valueOf(j3 + j16));
        }
        return hashMap;
    }

    public static void reportAudioEnd(AudioReportData audioReportData) {
        if (audioReportData != null && ReportHelper.isEventReportEnable(2)) {
            FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
            finalData.setEventKey(DTEventKey.AUDIO_END);
            finalData.putAll(prepareAudioEndReportData(audioReportData));
            IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
            if (eventDynamicParams != null) {
                eventDynamicParams.setEventDynamicParams(DTEventKey.AUDIO_END, finalData.getEventParams());
            }
            FinalDataTarget.handle(null, finalData);
        }
    }

    public static void reportAudioStart(Object obj, AudioSession audioSession) {
        if (obj == null || audioSession == null || !ReportHelper.isEventReportEnable(1)) {
            return;
        }
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(DTEventKey.AUDIO_START);
        finalData.putAll(prepareAudioStartReportData(obj, audioSession));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(DTEventKey.AUDIO_START, finalData.getEventParams());
        }
        FinalDataTarget.handle(obj, finalData);
    }

    public static void stashAudioEnd(final Object obj, final long j3, final long j16, final AudioSession audioSession) {
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.a
            @Override // java.lang.Runnable
            public final void run() {
                AudioEventReporter.lambda$stashAudioEnd$0(obj, j3, j16, audioSession);
            }
        });
    }

    public static void reportAudioEnd(Object obj, AudioSession audioSession) {
        if (obj == null || audioSession == null || !ReportHelper.isEventReportEnable(2)) {
            return;
        }
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(DTEventKey.AUDIO_END);
        finalData.putAll(prepareAudioEndReportData(obj, audioSession));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(DTEventKey.AUDIO_END, finalData.getEventParams());
        }
        FinalDataTarget.handle(obj, finalData);
    }

    private static Map<String, ?> prepareAudioEndReportData(AudioReportData audioReportData) {
        HashMap hashMap = new HashMap();
        if (audioReportData == null) {
            return hashMap;
        }
        hashMap.put(DTParamKey.REPORT_KEY_AUDIO_CONTENTID, audioReportData.contentId);
        Map<String, Object> map = audioReportData.customParams;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(DTParamKey.REPORT_KEY_AUDIO_ENDTIME, Long.valueOf(audioReportData.endTime));
        hashMap.put(DTParamKey.REPORT_KEY_AUDIO_SESSIONID, audioReportData.audioSessionId);
        hashMap.put(DTParamKey.REPORT_KEY_AUDIO_DURATION_FOREGROUND, Long.valueOf(audioReportData.foregroundDuration));
        hashMap.put(DTParamKey.REPORT_KEY_AUDIO_DURATION_BACKGROUND, Long.valueOf(audioReportData.backgroundDuration));
        hashMap.put("dt_play_duration", Long.valueOf(audioReportData.foregroundDuration + audioReportData.backgroundDuration));
        return hashMap;
    }
}
