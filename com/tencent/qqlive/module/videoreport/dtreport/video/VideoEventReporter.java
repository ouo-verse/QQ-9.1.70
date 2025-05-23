package com.tencent.qqlive.module.videoreport.dtreport.video;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoPlayRecorder;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoEventReporter {
    private static final String TAG = "video.VideoEventReporter";

    public static Map<String, Object> prepareEndParams(@NonNull VideoSession videoSession) {
        HashMap hashMap = new HashMap();
        if (videoSession.getCustomParams() != null) {
            hashMap.putAll(videoSession.getCustomParams());
        }
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_CONTENTID, videoSession.getContentId());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_END_REASON, videoSession.getPlayEndReason());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_END_TIME, String.valueOf(videoSession.getEndPosition()));
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_LENGTH, videoSession.getVideoDuration());
        hashMap.put("dt_play_duration", videoSession.getPlayedTime());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_START_TIME, String.valueOf(videoSession.getStartPosition()));
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_CONTENT_TYPE, String.valueOf(videoSession.getContentType()));
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_START_TYPE, videoSession.getStartPlayType());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_START_REASON, videoSession.getStartPlayReason());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_PLAY_START_TIME, Long.valueOf(videoSession.getVideoStartTime()));
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_PLAY_END_TIME, Long.valueOf(videoSession.getVideoEndTime()));
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_SEEK_RECORD, videoSession.getSeekRecord());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_SPEED_RATIO_RECORD, videoSession.getSpeedRatioRecord());
        hashMap.put(DTParamKey.REPORT_KEY_SUM_PLAY_DURATION, Long.valueOf(VideoPlayRecorder.getSumPlayDuration(videoSession)));
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_INDEX, Integer.valueOf(VideoPlayRecorder.getVideoIndex(videoSession)));
        hashMap.put(DTParamKey.REPORT_KEY_MEDIUM_PLAY_DURATION, Long.valueOf(VideoPlayRecorder.getDTMediumPlayDuration(videoSession)));
        hashMap.put(DTParamKey.REPORT_KEY_SUM_MEDIUM_PLAY_DURATION, Long.valueOf(VideoPlayRecorder.getDTSumMediumPlayDuration(videoSession)));
        setCurPageParam(hashMap, videoSession);
        return hashMap;
    }

    public static Map<String, Object> prepareStartParams(@NonNull VideoSession videoSession) {
        HashMap hashMap = new HashMap();
        if (videoSession.getCustomParams() != null) {
            hashMap.putAll(videoSession.getCustomParams());
        }
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_CONTENT_TYPE, String.valueOf(videoSession.getContentType()));
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_CONTENTID, videoSession.getContentId());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_START_TYPE, videoSession.getStartPlayType());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_START_REASON, videoSession.getStartPlayReason());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_START_TIME, String.valueOf(videoSession.getStartPosition()));
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_LENGTH, videoSession.getVideoDuration());
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_PLAY_START_TIME, Long.valueOf(videoSession.getVideoStartTime()));
        hashMap.put(DTParamKey.REPORT_KEY_VIDEO_INDEX, Integer.valueOf(VideoPlayRecorder.getVideoIndex(videoSession)));
        setCurPageParam(hashMap, videoSession);
        return hashMap;
    }

    public static void reportVideoEnd(Object obj, VideoSession videoSession) {
        if (videoSession == null) {
            Log.w(TAG, "reportVideoEnd, videoSession is null");
        } else {
            reportVideoEnd(obj, prepareEndParams(videoSession));
        }
    }

    public static void reportVideoStart(Object obj, VideoSession videoSession) {
        if (videoSession == null) {
            Log.w(TAG, "reportVideoStart, videoSession is null");
        } else {
            reportVideoStart(obj, prepareStartParams(videoSession));
        }
    }

    public static void setCurPageParam(Map<String, Object> map, @NonNull VideoSession videoSession) {
        Map<String, Object> curPage = videoSession.getCurPage();
        if (curPage != null) {
            Map copyNonNull = BaseUtils.copyNonNull(curPage);
            Object remove = copyNonNull.remove("ref_pg");
            if (remove instanceof Map) {
                copyNonNull.put("ref_pg", BaseUtils.copyNonNull((Map) remove));
            }
            map.put("cur_pg", copyNonNull);
        }
    }

    public static void stashVideoEnd(Object obj, VideoSession videoSession) {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey("dt_video_end");
        finalData.putAll(prepareEndParams(videoSession));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams("dt_video_end", finalData.getEventParams());
        }
        FinalDataTarget.handleWithStash(obj, finalData);
    }

    public static void stashVideoStart(Object obj, VideoSession videoSession) {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey("dt_video_start");
        finalData.putAll(prepareStartParams(videoSession));
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams("dt_video_start", finalData.getEventParams());
        }
        FinalDataTarget.handleWithStash(obj, finalData);
    }

    public static void reportVideoEnd(Object obj, Map<String, Object> map) {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey("dt_video_end");
        finalData.putAll(map);
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams("dt_video_end", finalData.getEventParams());
        }
        FinalDataTarget.handle(obj, finalData);
    }

    public static void reportVideoStart(Object obj, Map<String, Object> map) {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey("dt_video_start");
        finalData.putAll(map);
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams("dt_video_start", finalData.getEventParams());
        }
        FinalDataTarget.handle(obj, finalData);
    }
}
