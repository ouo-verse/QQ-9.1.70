package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes22.dex */
public class VideoPlayRecorder {
    private static final String TAG = "VideoPlayRecorder";
    private static Map<String, PlayDuration> sDTSumPlayDurationMap = new ConcurrentHashMap();
    private static Map<String, Integer> sDTVideoIndexMap = new ConcurrentHashMap();
    private static Map<String, MediumPlayDuration> sDTMediumPlayDurationMap = new ConcurrentHashMap();

    public static synchronized void dealSumPlayDuration(VideoSession videoSession) {
        synchronized (VideoPlayRecorder.class) {
            PlayDuration playDuration = getPlayDuration(videoSession);
            long parseLong = Long.parseLong(videoSession.getPlayedTime());
            playDuration.setSumPlayDuration(playDuration.getSumPlayDuration() + (parseLong - playDuration.getLastStashPlayedTime()));
            playDuration.setLastStashPlayedTime(parseLong);
            Log.i(TAG, "dealSumPlayDuration playedTime:" + parseLong + " ,sumPlayDuration:" + playDuration.getSumPlayDuration());
        }
    }

    public static synchronized void dealVideoIndex(VideoSession videoSession) {
        synchronized (VideoPlayRecorder.class) {
            String key = getKey(videoSession);
            Integer num = sDTVideoIndexMap.get(key);
            int i3 = 1;
            if (num != null) {
                i3 = 1 + num.intValue();
            }
            sDTVideoIndexMap.put(key, Integer.valueOf(i3));
        }
    }

    public static synchronized long getDTMediumPlayDuration(@NonNull VideoSession videoSession) {
        long mediumPlayedTime;
        synchronized (VideoPlayRecorder.class) {
            mediumPlayedTime = getMediumPlayDuration(videoSession).getMediumPlayedTime();
        }
        return mediumPlayedTime;
    }

    public static synchronized long getDTSumMediumPlayDuration(@NonNull VideoSession videoSession) {
        long sumMediumPlayedTime;
        synchronized (VideoPlayRecorder.class) {
            sumMediumPlayedTime = getMediumPlayDuration(videoSession).getSumMediumPlayedTime();
        }
        return sumMediumPlayedTime;
    }

    private static String getKey(@NonNull VideoSession videoSession) {
        return videoSession.getContentId() + videoSession.getContentType();
    }

    private static MediumPlayDuration getMediumPlayDuration(@NonNull VideoSession videoSession) {
        String key = getKey(videoSession);
        MediumPlayDuration mediumPlayDuration = sDTMediumPlayDurationMap.get(key);
        if (mediumPlayDuration == null) {
            mediumPlayDuration = new MediumPlayDuration();
        }
        sDTMediumPlayDurationMap.put(key, mediumPlayDuration);
        return mediumPlayDuration;
    }

    private static synchronized PlayDuration getPlayDuration(@NonNull VideoSession videoSession) {
        PlayDuration playDuration;
        synchronized (VideoPlayRecorder.class) {
            String key = getKey(videoSession);
            playDuration = sDTSumPlayDurationMap.get(key);
            if (playDuration == null) {
                playDuration = new PlayDuration();
                sDTSumPlayDurationMap.put(key, playDuration);
            }
        }
        return playDuration;
    }

    public static synchronized long getSumPlayDuration(@NonNull VideoSession videoSession) {
        long sumPlayDuration;
        synchronized (VideoPlayRecorder.class) {
            sumPlayDuration = getPlayDuration(videoSession).getSumPlayDuration();
        }
        return sumPlayDuration;
    }

    public static synchronized int getVideoIndex(@NonNull VideoSession videoSession) {
        int i3;
        synchronized (VideoPlayRecorder.class) {
            Integer num = sDTVideoIndexMap.get(getKey(videoSession));
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
        }
        return i3;
    }

    public static synchronized void playEnd(@NonNull VideoSession videoSession) {
        synchronized (VideoPlayRecorder.class) {
            MediumPlayDuration mediumPlayDuration = getMediumPlayDuration(videoSession);
            long parseLong = Long.parseLong(videoSession.getPlayedTime());
            float lastPlayedTime = ((float) (parseLong - mediumPlayDuration.getLastPlayedTime())) * mediumPlayDuration.getSpeedRatio();
            mediumPlayDuration.setSumMediumPlayedTime(((float) mediumPlayDuration.getSumMediumPlayedTime()) + lastPlayedTime);
            mediumPlayDuration.setMediumPlayedTime(((float) mediumPlayDuration.getMediumPlayedTime()) + lastPlayedTime);
            mediumPlayDuration.setLastPlayedTime(parseLong);
            Log.i(TAG, "medium_play_duration=" + mediumPlayDuration.getMediumPlayedTime() + " ,play_duration=" + videoSession.getPlayedTime());
        }
    }

    public static synchronized void playStart(@NonNull VideoSession videoSession, float f16) {
        synchronized (VideoPlayRecorder.class) {
            Log.e(TAG, "playStart=" + videoSession.getStartPosition());
            getPlayDuration(videoSession).setLastStashPlayedTime(0L);
            MediumPlayDuration mediumPlayDuration = getMediumPlayDuration(videoSession);
            mediumPlayDuration.setMediumPlayedTime(0L);
            mediumPlayDuration.setLastPlayedTime(0L);
            Log.d(TAG, "playStart speedRatio: " + f16);
            mediumPlayDuration.setSpeedRatio(f16);
        }
    }

    public static synchronized void speedRatioPlay(@NonNull VideoSession videoSession, float f16, long j3) {
        synchronized (VideoPlayRecorder.class) {
            Log.e(TAG, "speedRatioPlay speedRatio:" + f16 + " \uff0cposition:" + j3);
            MediumPlayDuration mediumPlayDuration = getMediumPlayDuration(videoSession);
            if (f16 == mediumPlayDuration.getSpeedRatio()) {
                return;
            }
            playEnd(videoSession);
            mediumPlayDuration.setSpeedRatio(f16);
        }
    }

    public static synchronized void stagingEnd(@NonNull VideoSession videoSession) {
        synchronized (VideoPlayRecorder.class) {
            dealSumPlayDuration(videoSession);
            playEnd(videoSession);
        }
    }
}
