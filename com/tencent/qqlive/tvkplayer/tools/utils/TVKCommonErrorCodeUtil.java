package com.tencent.qqlive.tvkplayer.tools.utils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKCommonErrorCodeUtil {
    private static final int ANDROID_PLATFORM_BASE = 10000;
    private static final int TV_PLATFORM_BASE = 50000;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static final class CODE {

        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static final class LIVE {
            public static final int CGI_PARAMS_ERR = 143004;
            public static final int CGI_PROTOCOL_BACKEND_BASE_ERR = 130000;
            public static final int CGI_PROTOCOL_NETWORK_BASE_ERR = 141000;
            public static final int CGI_UNKONWN_ERR = 144000;
            public static final int LIVEINFO_URL_EMPTY_ERR = 123001;
        }

        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static final class LOGIC {
            public static final int AUTH_FAILED_ERR = 111005;
            public static final int EMPTY_DEFINITION_LIST_ERR = 1300069;
            public static final int FORMAT_UNSUPPORTED_ERR = 111009;
            public static final int PARAM_INVALID_ERR = 111002;
            public static final int PERMISSION_TIMEOUT_ERR = 111012;
            public static final int PLAYER_CREATE_FAILED_ERR = 111004;
            public static final int PLAYER_NOT_SUPPORT_ERR = 111006;
            public static final int PLAYER_SELECT_TRACK_ERR = 111013;
            public static final int PLAYER_SET_DATASOURCE_ILLEGAL_ARG_EXCEPTION_ERR = 111014;
            public static final int PLAYER_STATE_ERR = 111003;
            public static final int PLAY_URL_EMPTY_ERR = 111007;
            public static final int PREVIEW_UNSUPPORTED_ERR = 111008;
            public static final int TRACK_URL_EMPTY_ERR = 111015;
            public static final int UNKNOWN_ERR = 111001;
        }

        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static final class SUBTITLE {
            public static final int LOAD_INIT_PARSER_ERR = 115001;
            public static final int LOAD_OPEN_FAILED_ERR = 115002;
            public static final int LOAD_PARSE_FAILED_ERR = 115003;
            public static final int UNKNOWN_ERR = 115000;
            public static final int USER_CANCEL_ERR = 115004;
        }

        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static final class VOD {
            public static final int CGI_GETVINFO_BACKEND_BASE_ERR = 1300000;
            public static final int CGI_GETVINFO_NETWORK_BASE_ERR = 1401000;
            public static final int VINFO_QQ_OPEN_BASE_ERR = 1300401;
            public static final int VINFO_URL_EMPTY_ERR = 1200012;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static final class MODULE {
        public static final int CGI_GETVINFO_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(101);
        public static final int CGI_GETPROGINFO_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(104);
        public static final int PLAY_QQLIVE_ASSET_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(200);
        public static final int PLAY_OTHER_ASSET_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(201);
        public static final int EXPORTER_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(203);
        public static final int SUBTITLE_LOAD_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(204);
        public static final int RICH_MEDIA_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(205);
        public static final int VIDEO_FX_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(206);
        public static final int MODULE_UPDATE_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(207);
        public static final int SR_MODULE_UPDATE_ERR = TVKCommonErrorCodeUtil.getModuleCodeWithPlatformBase(208);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getModuleCodeWithPlatformBase(int i3) {
        return i3 + 10000;
    }
}
