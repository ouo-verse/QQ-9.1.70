package com.tencent.qqlive.tvkplayer.api;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKReportEventListener {
    public static final String KEY_AD_CGI_DURATION_MS = "tvk_adCgiDurationMs";
    public static final String KEY_AD_COMPLETE_TO_VIDEO_REAL_PLAY_DURATION_MS = "tvk_adCompleteToVideoRealPlayDurationMs";
    public static final String KEY_AD_PREPARE_ERROR_DURATION_MS = "tvk_adPrepareErrorDurationMs";
    public static final String KEY_HAS_AD = "tvk_hasAd";
    public static final String KEY_IS_AD_CGIED = "tvk_isAdCGIed";
    public static final String KEY_MEDIA_TYPE = "tvk_mediaType";
    public static final String KEY_OPEN_TO_AD_PREPARE_ERROR_DURATION_MS = "tvk_openToAdPrepareErrorDurationMs";
    public static final String KEY_OPEN_TO_AD_REQUEST_BEGIN_DURATION_MS = "tvk_openToAdRequestBeginDurationMs";
    public static final String KEY_OPEN_TO_PREPARED_DURATION_MS = "tvk_openToPreparedDurationMs";
    public static final String KEY_OPEN_TO_REAL_PLAY_DURATION_MS = "tvk_openToRealPlayDurationMs";
    public static final String KEY_OPEN_TO_START_DURATION_MS = "tvk_openToStartDurationMs";
    public static final String KEY_PREPARED_DURATION_MS = "tvk_preparedDurationMs";
    public static final String KEY_REAL_PLAY_DURATION_MS = "tvk_realPlayDurationMs";
    public static final String KEY_START_DURATION_MS = "tvk_startDurationMs";
    public static final String KEY_VIDEO_CGI_DURATION_MS = "tvk_videoCgiDurationMs";
    public static final int MEDIA_TYPE_AD = 0;
    public static final int MEDIA_TYPE_VIDEO = 1;
    public static final int TYPE_FALSE = 0;
    public static final int TYPE_TRUE = 1;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum ReportEvent {
        TVK_REPORT_EVENT_UNKNOWN,
        TVK_REPORT_EVENT_PLAYER_OPEN_AD,
        TVK_REPORT_EVENT_PRE_AD_OPEN,
        TVK_REPORT_EVENT_PRE_AD_SEND_CGI_REQUEST,
        TVK_REPORT_EVENT_PRE_AD_CGI_RESPONSE_RECEIVED,
        TVK_REPORT_EVENT_PRE_AD_CALL_PLAYER_OPEN,
        TVK_REPORT_EVENT_PRE_AD_REQUEST_BEGIN,
        TVK_REPORT_EVENT_PRE_AD_CGIED,
        TVK_REPORT_EVENT_VIDEO_OPEN_MEDIA_PLAYER,
        TVK_REPORT_EVENT_CGI_SEND_HTTP_REQUEST,
        TVK_REPORT_EVENT_CGI_HTTP_RESPONSE_RECEIVED,
        TVK_REPORT_EVENT_CGI_PARSE_DATA_DONE,
        TVK_REPORT_EVENT_CGI_PARSE_DATA_RESPONSE,
        TVK_REPORT_EVENT_CGI_THREAD_CHANGE_TO_PLAYER_THREAD,
        TVK_REPORT_EVENT_PLAYER_BEFORE_SET_DATA_SOURCE_AND_PARAM,
        TVK_REPORT_EVENT_PLAYER_AFTER_SET_DATA_SOURCE_AND_PARAM,
        TVK_REPORT_EVENT_PLAYER_ON_PREPARED_CHANGED_THREAD_TO_APP_THREAD,
        TVK_REPORT_EVENT_VIDEO_CGIED,
        TVK_REPORT_EVENT_PRE_AD_PREPARED_ERROR,
        TVK_REPORT_EVENT_PREPARED,
        TVK_REPORT_EVENT_PLAYING,
        TVK_REPORT_EVENT_REAL_PLAYING,
        TVK_REPORT_EVENT_TRANSITION,
        TVK_REPORT_EVENT_PLAYER_SCHEDULING_THREAD_PREPARE_START,
        TVK_REPORT_EVENT_DEMUX_THREAD_PREPARE_START,
        TVK_REPORT_EVENT_DEMUXER_FILE_OPEN_START,
        TVK_REPORT_EVENT_DEMUXER_FILE_OPEN_END,
        TVK_REPORT_EVENT_DEMUX_THREAD_ON_PREPARED,
        TVK_REPORT_EVENT_PLAYER_SCHEDULING_THREAD_ON_PREPARED,
        TVK_REPORT_EVENT_FIRST_VIDEO_DECODER_CREATE_START,
        TVK_REPORT_EVENT_FIRST_AUDIO_DECODER_CREATE_START,
        TVK_REPORT_EVENT_FIRST_VIDEO_FRAME_RENDERED,
        TVK_REPORT_EVENT_FIRST_AUDIO_FRAME_RENDERED,
        TVK_REPORT_EVENT_TP_API_SET_DATA_SOURCE_START,
        TVK_REPORT_EVENT_TP_API_SET_DATA_SOURCE_END,
        TVK_REPORT_EVENT_TP_API_PREPARE_START,
        TVK_REPORT_EVENT_TP_API_ON_PREPARED,
        TVK_REPORT_EVENT_TP_API_ON_FIRST_VIDEO_FRAME_RENDERED,
        TVK_REPORT_EVENT_TP_API_ON_FIRST_AUDIO_FRAME_RENDERED
    }

    void onReportEvent(ITVKMediaPlayer iTVKMediaPlayer, ReportEvent reportEvent, ReportEventParams reportEventParams);

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ReportEventParams {
        protected String flowId;
        protected HashMap<String, Object> reportMap;
        protected long timeSince1970Ms;

        public String getFlowId() {
            return this.flowId;
        }

        public Object getParamByKey(String str) {
            HashMap<String, Object> hashMap = this.reportMap;
            if (hashMap == null || hashMap.isEmpty() || TextUtils.isEmpty(str) || !this.reportMap.containsKey(str)) {
                return null;
            }
            return this.reportMap.get(str);
        }

        public HashMap<String, Object> getReportMap() {
            return this.reportMap;
        }

        public long getTimeSince1970Ms() {
            return this.timeSince1970Ms;
        }

        public Object getParamByKey(String str, Object obj) {
            HashMap<String, Object> hashMap = this.reportMap;
            return (hashMap == null || hashMap.isEmpty() || TextUtils.isEmpty(str) || !this.reportMap.containsKey(str)) ? obj : this.reportMap.get(str);
        }
    }
}
