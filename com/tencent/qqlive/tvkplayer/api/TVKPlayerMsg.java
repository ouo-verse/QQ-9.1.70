package com.tencent.qqlive.tvkplayer.api;

/* loaded from: classes23.dex */
public class TVKPlayerMsg {
    public static final int PLAYER_ALIGNMENT_BOTTOM = 2;
    public static final int PLAYER_ALIGNMENT_CENTER = 0;
    public static final int PLAYER_ALIGNMENT_LEFT = 3;
    public static final int PLAYER_ALIGNMENT_RIGHT = 4;
    public static final int PLAYER_ALIGNMENT_TOP = 1;
    public static final String PLAYER_CHOICE_AUTO = "auto";
    public static final String PLAYER_CHOICE_SELF = "self";
    public static final String PLAYER_CHOICE_SELF_SOFT = "self_soft";
    public static final String PLAYER_CHOICE_SYSTEM = "system";
    public static final int PLAYER_FORCE_TYPE_NONE = 0;
    public static final int PLAYER_FORCE_TYPE_SELF = 2;
    public static final int PLAYER_FORCE_TYPE_SELF_SOFT = 3;
    public static final int PLAYER_FORCE_TYPE_SYS = 1;
    public static final int PLAYER_INFO_AB_TEST_EXPOSED = 84;
    public static final int PLAYER_INFO_AB_TEST_UNEXPOSED = 85;
    public static final int PLAYER_INFO_ADAPTIVE_SWITCH_DEFINITION_END = 67;
    public static final int PLAYER_INFO_ADAPTIVE_SWITCH_DEFINITION_FAILED = 68;
    public static final int PLAYER_INFO_ADAPTIVE_SWITCH_DEFINITION_START = 66;
    public static final int PLAYER_INFO_ADAPTIVE_SWITCH_DEFINITION_SUCCESS = 83;
    public static final int PLAYER_INFO_AD_CGI_RECEIVE = 49;
    public static final int PLAYER_INFO_BLINDNESS_CLOSED_BY_INTERNAL = 75;
    public static final int PLAYER_INFO_CDNID = 51;
    public static final int PLAYER_INFO_CDNSERVER = 52;
    public static final int PLAYER_INFO_CURRENT_VID_DOWNLOAD_FIN = 58;

    @Deprecated
    public static final int PLAYER_INFO_DECODER_BLOCK = 28;

    @Deprecated
    public static final int PLAYER_INFO_DEFINITION_FORCE = 45;
    public static final int PLAYER_INFO_DETECTED_MULTI_NETWORK_CARD_AND_LOW_SPEED = 89;
    public static final int PLAYER_INFO_DOLBY_DECODE_FAIL = 27;
    public static final int PLAYER_INFO_DOWNLOAD_PROGRESS_UPDATE = 97;
    public static final int PLAYER_INFO_DYNAMIC_LOGO = 57;
    public static final int PLAYER_INFO_ENDOF_BUFFERING = 22;
    public static final int PLAYER_INFO_END_GET_VINFO = 34;
    public static final int PLAYER_INFO_FETCH_NEXT_VIDEO_INFO = 36;
    public static final int PLAYER_INFO_FIRST_AUDIO_FRAME_RENDERED = 63;
    public static final int PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED = 62;
    public static final int PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED_AFTER_UPDATE_RENDER_TARGET = 95;
    public static final int PLAYER_INFO_FLOWID = 50;
    public static final int PLAYER_INFO_GET_VINFO_RESPONSE_HEADERS = 99;
    public static final int PLAYER_INFO_HDR10_ENHANCE_CLOSED_BY_INTERNAL = 74;
    public static final int PLAYER_INFO_INTERACTIVE_EOF = 69;
    public static final int PLAYER_INFO_INTERACTIVE_START = 70;
    public static final int PLAYER_INFO_LOOP_AD_START = 37;
    public static final int PLAYER_INFO_LOOP_VIDEO_START = 38;
    public static final int PLAYER_INFO_MULTI_NETWORK_CARD_STATUS_CHANGE = 90;
    public static final int PLAYER_INFO_NEXT_NET_VINFO = 35;
    public static final int PLAYER_INFO_OFFLINE_2_ONLINE = 42;
    public static final int PLAYER_INFO_OFFLINE_NOMORE_CACHE = 39;
    public static final int PLAYER_INFO_ONE_LOOP_COMPLETE = 55;
    public static final int PLAYER_INFO_ONE_LOOP_START = 56;
    public static final int PLAYER_INFO_ON_RICH_MEDIA_PREPARED = 79;
    public static final int PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED = 80;
    public static final int PLAYER_INFO_PLAYER_INSTANCE_UNRESPONSIVE = 100;
    public static final int PLAYER_INFO_PLAYER_TYPE = 31;

    @Deprecated
    public static final int PLAYER_INFO_PRE_AD_PLAYER_TYPE = 32;
    public static final int PLAYER_INFO_PRIVATE_HLS_M3U8_TAG = 53;
    public static final int PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE = 94;
    public static final int PLAYER_INFO_REFRESH_PLAYET_END = 77;
    public static final int PLAYER_INFO_REFRESH_PLAYET_START = 76;
    public static final int PLAYER_INFO_REFRESH_WITH_REOPEN_PLAYET_END = 87;
    public static final int PLAYER_INFO_REFRESH_WITH_REOPEN_PLAYET_START = 86;
    public static final int PLAYER_INFO_REQUEST_UPDATE_USER_INFO = 96;

    @Deprecated
    public static final int PLAYER_INFO_RESTORED = 71;
    public static final int PLAYER_INFO_RETRY_PLAYER = 29;
    public static final int PLAYER_INFO_RETRY_PLAYER_DONE = 47;

    @Deprecated
    public static final int PLAYER_INFO_RETRY_URL = 30;
    public static final int PLAYER_INFO_RETURN_VIDEO_DURATION = 26;
    public static final int PLAYER_INFO_SEAMLESS_SWITCH_DEFN_DONE = 43;
    public static final int PLAYER_INFO_SEAMLESS_SWITCH_DEFN_FAIL = 44;
    public static final int PLAYER_INFO_SET_VIEW_SECURE_FAILED = 81;
    public static final int PLAYER_INFO_SIMULATED_LIVE_BEGINNING_OF_VID = 98;
    public static final int PLAYER_INFO_SKIPAD_FOR_VIPUSER = 25;
    public static final int PLAYER_INFO_START_BUFFERING = 21;
    public static final int PLAYER_INFO_START_GET_VINFO = 33;
    public static final int PLAYER_INFO_SUBTITLE_FIRST_LOAD = 72;
    public static final int PLAYER_INFO_SUBTITLE_SEL_END = 65;
    public static final int PLAYER_INFO_SUBTITLE_SEL_START = 64;
    public static final int PLAYER_INFO_SUCC_SET_DECODER_MODE = 24;
    public static final int PLAYER_INFO_SURFACE_DESTROYED_ASYNC_RESOURCE_RELEASED = 93;
    public static final int PLAYER_INFO_SWITCH_AUDIOTRACK_DONE = 60;

    @Deprecated
    public static final int PLAYER_INFO_SWITCH_AUDIOTRACK_FAIL = 61;
    public static final int PLAYER_INFO_SWITCH_AUDIOTRACK_START = 59;
    public static final int PLAYER_INFO_SWITCH_DEFN_TYPE = 46;
    public static final int PLAYER_INFO_TV_TEST_CDN_URL = 54;
    public static final int PLAYER_INFO_UNKNOWN = 20;
    public static final int PLAYER_INFO_VIDEOFX_WARNING = 88;
    public static final int PLAYER_INFO_VIDEO_HIGH_FRAME_DROP_RATE_ALERT = 92;
    public static final int PLAYER_INFO_VIDEO_LOW_FRAME_RATE_ALERT = 91;
    public static final int PLAYER_INFO_VIDEO_METADATA_CHANGED = 101;
    public static final int PLAYER_INFO_VIDEO_SEI_INFO = 82;
    public static final int PLAYER_REALTIME_INFO_TYPE_ADAPTIVE_MODE = 16;
    public static final int PLAYER_REALTIME_INFO_TYPE_AD_ENABLE_CLICK = 4;
    public static final int PLAYER_REALTIME_INFO_TYPE_AD_REALTIME_STRATEGY = 5;
    public static final int PLAYER_REALTIME_INFO_TYPE_AD_REQUEST_PARAM = 3;
    public static final int PLAYER_REALTIME_INFO_TYPE_BACKGROUND_PLAY = 10;
    public static final int PLAYER_REALTIME_INFO_TYPE_DYNAMIC_LOGO_OPEN = 12;
    public static final int PLAYER_REALTIME_INFO_TYPE_ENABLE_SETNEXTMEDIAINFO = 7;
    public static final int PLAYER_REALTIME_INFO_TYPE_IS_PRELOAD = 1;

    @Deprecated
    public static final int PLAYER_REALTIME_INFO_TYPE_LOGO_OPEN = 9;

    @Deprecated
    public static final int PLAYER_REALTIME_INFO_TYPE_LOGO_SCENE = 8;
    public static final int PLAYER_REALTIME_INFO_TYPE_MEDIALABVR_VIEWPORT_CHANGED = 14;
    public static final int PLAYER_REALTIME_INFO_TYPE_REAL_USER_PLAY = 15;
    public static final int PLAYER_REALTIME_INFO_TYPE_SKIP_POS = 6;
    public static final int PLAYER_REALTIME_INFO_TYPE_STATIC_LOGO_OPEN = 11;
    public static final int PLAYER_REALTIME_INFO_TYPE_USER_SCENE = 2;
    public static final int PLAYER_SCALE_BOTH_FULLSCREEN = 1;
    public static final int PLAYER_SCALE_ORIGINAL_FULLSCREEN = 2;
    public static final int PLAYER_SCALE_ORIGINAL_RATIO = 0;
    public static final int PLAYER_SCALE_ORIGINAL_RATIO_SQUARE = 6;
    public static final int PLAYER_SWITCH_DEF_TYPE_REOPEN = 0;
    public static final int PLAYER_SWITCH_DEF_TYPE_SEAMLESS = 1;
}
