package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.qqlive.tvkplayer.api.ITVKLogReportListener;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogReporter {
    private static final String LOG_INDEX_AUDIO_JUMP_TIMES = "800005";
    private static final String LOG_INDEX_BY_GUID_REPORT = "800007";
    public static final String LOG_INDEX_CGI_HTTP_RESPONSE_TOO_LONG = "800011";
    public static final String LOG_INDEX_DRM_PREPARED_TO_PREPARED_AND_PREPARING_TO_DRM_PREPARING_TOO_LONG = "800014";
    public static final String LOG_INDEX_DRM_PREPARED_TO_PREPARED_TOO_LONG = "800013";
    private static final String LOG_INDEX_FIRST_BUFFER_LIVE = "800008";
    private static final String LOG_INDEX_FIRST_BUFFER_VOD = "800001";
    public static final String LOG_INDEX_GETVINFO_TOO_LONG_LIVE = "800016";
    public static final String LOG_INDEX_GETVINFO_TOO_LONG_VOD = "800015";
    public static final String LOG_INDEX_PREPARING_TO_DRM_PREPARING_TOO_LONG = "800012";
    public static final String LOG_INDEX_PROXY_AUTHENTICATION_FAILED = "800017";
    private static final String LOG_INDEX_SECOND_BUFFER_TIMES_COUNT_LIVE = "800010";
    private static final String LOG_INDEX_SECOND_BUFFER_TIMES_COUNT_VOD = "800003";
    private static final String LOG_INDEX_SECOND_BUFFER_TIME_LIVE = "800009";
    private static final String LOG_INDEX_SECOND_BUFFER_TIME_VOD = "800002";
    private static final String LOG_INDEX_VIDEO_JUMP_TIMES = "800004";
    private static final String LOG_INDEX_VIDEO_OR_AUDIO_CODEC_ERROR = "800006";
    public static final int PLAYER_TYPE_ANDROID = 1;
    public static final int PLAYER_TYPE_FFMPEG = 2;
    public static final int PLAYER_TYPE_MEDIACODEC = 3;
    public static final String TAG = "TVKPlayer[TVKLogReporter]";
    public static final int VIDEO_ENCODE_TYPE_H264 = 1;
    public static final int VIDEO_ENCODE_TYPE_HEVC = 2;
    private static long mLastUpload;
    private static ITVKLogReportListener mLogReportListener;
    private int mPlayerType = -1;
    private int mVideoEncodeType = -1;
    private int mTestId = -1;
    private int mVideoFmt = -1;

    private boolean isDefFormatIdConfigMatched() {
        if (TVKMediaPlayerConfig.PlayerConfig.upload_log_fmt_set.isEmpty()) {
            return true;
        }
        try {
            for (String str : TVKMediaPlayerConfig.PlayerConfig.upload_log_fmt_set.split(",")) {
                if (TextUtils.equals(str, String.valueOf(this.mVideoFmt))) {
                    return true;
                }
            }
            return false;
        } catch (PatternSyntaxException e16) {
            TVKLogUtil.e(TAG, e16);
            return false;
        }
    }

    private boolean isErrorCodeConfigMatched(@NonNull String str) {
        try {
            for (String str2 : TVKMediaPlayerConfig.PlayerConfig.upload_log_errcode_set.split(",")) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
            return false;
        } catch (PatternSyntaxException e16) {
            TVKLogUtil.e(TAG, e16);
            return false;
        }
    }

    private boolean isGuidConfigMatched(String str) {
        try {
            for (String str2 : TVKMediaPlayerConfig.PlayerConfig.upload_log_guid_sets.split(",")) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
            return false;
        } catch (PatternSyntaxException e16) {
            TVKLogUtil.e(TAG, e16);
            return false;
        }
    }

    private void logReportCommon(String str, String str2) {
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str.length() > 9) {
            str = str.substring(0, 9);
        }
        linkedHashMap.put("errcode", str);
        linkedHashMap.put("log_type", String.valueOf(3));
        linkedHashMap.put("player_type", String.valueOf(this.mPlayerType));
        linkedHashMap.put("bucket_id", String.valueOf(this.mTestId));
        linkedHashMap.put("video_format", String.valueOf(this.mVideoFmt));
        linkedHashMap.put(VRReportDefine$ReportParam.DOWNLOAD_TYPE, String.valueOf(TVKMediaPlayerConfig.PlayerConfig.qqlive_asset_player_use_proxy ? 1 : 0));
        if (this.mVideoEncodeType == 2) {
            str3 = "hevc" + str2;
        } else {
            str3 = "h264_defn_" + str2;
        }
        linkedHashMap.put("error", str3);
        TVKLogUtil.i(TAG, "callback for uploading log");
        onLogReport(linkedHashMap);
    }

    private static void onLogReport(Map<String, String> map) {
        ITVKLogReportListener iTVKLogReportListener = mLogReportListener;
        if (iTVKLogReportListener != null) {
            iTVKLogReportListener.onLogReport(map);
        }
    }

    public static void setOnLogReportListener(ITVKLogReportListener iTVKLogReportListener) {
        mLogReportListener = iTVKLogReportListener;
    }

    public void audioJumpTimesReport(int i3) {
        if (i3 >= TVKMediaPlayerConfig.PlayerConfig.audio_jump_log_report_times) {
            logReport(LOG_INDEX_AUDIO_JUMP_TIMES, "hd");
        }
    }

    public void firstBufferReportLive(long j3) {
        if (j3 >= TVKMediaPlayerConfig.PlayerConfig.report_log_first_buffer_threshold_live) {
            logReport(LOG_INDEX_FIRST_BUFFER_LIVE, "hd");
        }
    }

    public void firstBufferReportVod(long j3) {
        if (j3 >= TVKMediaPlayerConfig.PlayerConfig.report_log_first_buffer_threshold_vod) {
            logReport(LOG_INDEX_FIRST_BUFFER_VOD, "hd");
        }
    }

    public void logReport(@NonNull String str, String str2) {
        if (TVKMediaPlayerConfig.PlayerConfig.report_log_enable && TVKUtils.isHitting(TVKMediaPlayerConfig.PlayerConfig.report_log_sample)) {
            if (TextUtils.isEmpty(TVKMediaPlayerConfig.PlayerConfig.upload_log_errcode_set)) {
                logReportCommon(str, str2);
                return;
            }
            if (isErrorCodeConfigMatched(str) && isDefFormatIdConfigMatched()) {
                try {
                    logReportCommon(str, str2);
                } catch (Throwable th5) {
                    TVKLogUtil.i(TAG, "LogReport exception: " + th5.toString());
                }
            }
        }
    }

    public void logReportByGuid(String str) {
        try {
            if (!TVKMediaPlayerConfig.PlayerConfig.report_log_enable || !isGuidConfigMatched(str)) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = mLastUpload;
            if (j3 == 0 || elapsedRealtime - j3 >= TVKMediaPlayerConfig.PlayerConfig.report_log_by_guid_interval) {
                logReportCommon(LOG_INDEX_BY_GUID_REPORT, "unknown");
            }
            mLastUpload = elapsedRealtime;
        } catch (Throwable th5) {
            TVKLogUtil.i(TAG, "LogReport exception: " + th5.toString());
        }
    }

    public void logReportForce(String str, String str2) {
        try {
            if (TVKMediaPlayerConfig.PlayerConfig.report_log_enable) {
                logReportCommon(str, str2);
            }
        } catch (Throwable th5) {
            TVKLogUtil.i(TAG, "LogReport exception: " + th5.toString());
        }
    }

    public void proxyAuthFailedReport() {
        logReport(LOG_INDEX_PROXY_AUTHENTICATION_FAILED, "hd");
    }

    public void reportLiveCgiTimeConsumption(long j3) {
        if (j3 >= TVKMediaPlayerConfig.PlayerConfig.report_log_getvinfo_duration_threshold_live_ms) {
            logReport(LOG_INDEX_GETVINFO_TOO_LONG_LIVE, "hd");
        }
    }

    public void reportVodCgiTimeConsumption(long j3) {
        if (j3 >= TVKMediaPlayerConfig.PlayerConfig.report_log_getvinfo_duration_threshold_vod_ms) {
            logReport(LOG_INDEX_GETVINFO_TOO_LONG_VOD, "hd");
        }
    }

    public void reset() {
        this.mPlayerType = -1;
        this.mVideoEncodeType = -1;
        this.mTestId = -1;
        this.mVideoFmt = -1;
    }

    public void secondBufferTimeReportLive(long j3) {
        if (j3 >= TVKMediaPlayerConfig.PlayerConfig.report_log_second_buffer_time_threshold_live) {
            logReport(LOG_INDEX_SECOND_BUFFER_TIME_LIVE, "hd");
        }
    }

    public void secondBufferTimeReportVod(long j3) {
        if (j3 >= TVKMediaPlayerConfig.PlayerConfig.report_log_second_buffer_time_threshold_vod) {
            logReport(LOG_INDEX_SECOND_BUFFER_TIME_VOD, "hd");
        }
    }

    public void secondBufferTimesCountReportLive(int i3) {
        if (i3 >= TVKMediaPlayerConfig.PlayerConfig.report_log_second_buffer_times_count_threshold_live) {
            logReport(LOG_INDEX_SECOND_BUFFER_TIMES_COUNT_LIVE, "hd");
        }
    }

    public void secondBufferTimesCountReportVod(int i3) {
        if (i3 >= TVKMediaPlayerConfig.PlayerConfig.report_log_second_buffer_times_count_threshold_vod) {
            logReport(LOG_INDEX_SECOND_BUFFER_TIMES_COUNT_VOD, "hd");
        }
    }

    public void setCurrentPlayerType(int i3) {
        this.mPlayerType = i3;
    }

    public void setTestId(int i3) {
        this.mTestId = i3;
    }

    public void setVideoEncodeType(int i3) {
        this.mVideoEncodeType = i3;
    }

    public void setVideoFmt(int i3) {
        this.mVideoFmt = i3;
    }

    public void subtitleFailedReport(int i3) {
        logReport(String.valueOf(i3), "hd");
    }

    public void videoJumpTimesReport(int i3) {
        if (i3 >= TVKMediaPlayerConfig.PlayerConfig.video_jump_log_report_times) {
            logReport(LOG_INDEX_VIDEO_JUMP_TIMES, "hd");
        }
    }

    public void videoOrAudioCodecErrorReport() {
        logReport(LOG_INDEX_VIDEO_OR_AUDIO_CODEC_ERROR, "hd");
    }
}
