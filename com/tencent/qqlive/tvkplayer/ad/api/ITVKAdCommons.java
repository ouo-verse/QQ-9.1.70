package com.tencent.qqlive.tvkplayer.ad.api;

import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ITVKAdCommons {
    public static final int AD_CALLBACK_TYPE_CGIED = 2;
    public static final int AD_CALLBACK_TYPE_CGIING = 1;
    public static final int AD_CALLBACK_TYPE_COMPLETE = 6;
    public static final int AD_CALLBACK_TYPE_DOWNLOADED = 8;
    public static final int AD_CALLBACK_TYPE_ERROR = 9;
    public static final int AD_CALLBACK_TYPE_FINISH = 7;
    public static final int AD_CALLBACK_TYPE_NONE = 0;
    public static final int AD_CALLBACK_TYPE_PAUSE = 5;
    public static final int AD_CALLBACK_TYPE_PLAYING = 4;
    public static final int AD_CALLBACK_TYPE_PREPARED = 3;
    public static final int AD_CGI_ERROR_TYPE_GET_AD = 1;
    public static final int AD_CGI_ERROR_TYPE_GET_AD_TIMEOUT = 2;
    public static final int AD_CLOSE_REASON_TIMEOUT = 2;
    public static final int AD_CLOSE_REASON_USER_RETURN = 1;
    public static final int AD_ERROR_CODE_TIMEOUT = 10000;
    public static final int AD_ERROR_TYPE_UNKNOWN = 0;
    public static final int AD_PLAY_ERROR_TYPE_PLAY_AD = 3;
    public static final int AD_PLAY_ERROR_TYPE_PREPARED_ERROR = 4;
    public static final int AD_SKIP_REASON_USER_SKIP = 2;
    public static final int AD_SKIP_REASON_VIP_SKIP = 1;
    public static final int AD_STATE_CGIED = 3;
    public static final int AD_STATE_CGIING = 2;
    public static final int AD_STATE_DONE = 8;
    public static final int AD_STATE_NONE = 1;
    public static final int AD_STATE_PAUSED = 7;
    public static final int AD_STATE_PLAYING = 6;
    public static final int AD_STATE_PREPARED = 5;
    public static final int AD_STATE_PREPARING = 4;
    public static final int AD_TYPE_FRAME_IVB = 4;
    public static final int AD_TYPE_FRAME_LIVB = 7;
    public static final int AD_TYPE_FRAME_PAUSE = 6;
    public static final int AD_TYPE_FRAME_SIVB = 5;
    public static final int AD_TYPE_HLS_AD = 8;
    public static final int AD_TYPE_NONE = -1;
    public static final int AD_TYPE_VIDEO_MID = 2;
    public static final int AD_TYPE_VIDEO_POS = 3;
    public static final int AD_TYPE_VIDEO_PRE = 1;
    public static final int PLAYER_STATE_CGIED = 3;
    public static final int PLAYER_STATE_CGIING = 2;
    public static final int PLAYER_STATE_COMPLETE = 7;
    public static final int PLAYER_STATE_IDEL = 0;
    public static final int PLAYER_STATE_OPENING = 1;
    public static final int PLAYER_STATE_PREPARED = 5;
    public static final int PLAYER_STATE_PREPARING = 4;
    public static final int PLAYER_STATE_RUNNING = 6;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface AdCallbackType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface AdCloseReason {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface AdErrType {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class AdErrorInfo {
        public int adType;
        public long currentTimeSince1970Ms;
        public int errorCode;
        public String errorMsg;
        public int errorType;
        public long playTime;
        public boolean strategyNoAd;
        public boolean vipNoAd;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class AdExtraInfo {
        public long currentTimeSince1970Ms;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface AdSkipReason {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface AdState {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface AdType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface PlayerState {
    }

    public static String adStateString(int i3) {
        switch (i3) {
            case 1:
                return "none";
            case 2:
                return "cgiing";
            case 3:
                return "cgied";
            case 4:
                return "preparing";
            case 5:
                return "prepared";
            case 6:
                return QzoneWebMusicJsPlugin.EVENT_PLAYING;
            case 7:
                return "paused";
            case 8:
                return "done";
            default:
                return QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
    }

    public static String adTypeString(int i3) {
        switch (i3) {
            case 1:
                return "pre ad";
            case 2:
                return "mid ad";
            case 3:
                return "posttroll ad";
            case 4:
                return "IVB ad";
            case 5:
                return "SIVB ad";
            case 6:
                return "pause ad";
            default:
                return QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
    }

    public static boolean isVideoAd(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    public static boolean isVideoAdActive(int i3) {
        if (i3 != 1 && i3 != 8) {
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class AdResult {
        public int adType;
        public boolean success;

        public AdResult() {
            this.adType = -1;
            this.success = false;
        }

        public boolean suc() {
            if (this.adType != -1 && this.success) {
                return true;
            }
            return false;
        }

        public int type() {
            return this.adType;
        }

        public AdResult(int i3, boolean z16) {
            this.adType = i3;
            this.success = z16;
        }
    }
}
