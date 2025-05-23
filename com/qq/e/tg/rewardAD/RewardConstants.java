package com.qq.e.tg.rewardAD;

/* compiled from: P */
/* loaded from: classes3.dex */
class RewardConstants {
    public static final int REWARD_NETWORK_SELECT_ORDER_TIMEOUT = 1;
    public static final int REWARD_NEW_INTERFACE = 1;
    public static final int REWARD_OLD_INTERFACE = 2;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    interface ErrorCode {
        public static final int AD_CACHE_SIZE_FULL = 5003;
        public static final int CONFIG_CHECK_ERROR = 6003;
        public static final int DELEGATE_INIT_ERROR = 6000;
        public static final int ERRORCODE_CANCEL_BY_FLOW = 5015;
        public static final int NET_AD_IS_NULL = 50010;
        public static final int PLUGIN_INIT_ERROR = 6002;
        public static final int POFACTORY_INIT_ERROR = 6001;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    interface EventId {
        public static final int TANGRAM_REWARD_AD_SHOW_SUCCESS = 1020040;
        public static final int TANGRAM_REWARD_REALTIME_LOAD_SUCCESS = 1020300;
        public static final int TANGRAM_REWARD_REALTIME_SHOW_FIRST_AD = 1020301;
        public static final int TANGRAM_REWARD_VIDEO_AD_CACHE_DELETED = 1020075;
        public static final int TANGRAM_REWARD_VIDEO_AD_SHOW_ERROR = 1020074;
        public static final int TANGRAM_REWARD_VIDEO_AD_SHOW_SUCCESS = 1020073;
        public static final int TANGRAM_REWARD_VIDEO_EVENT_REPORT_BY_FLOW = 1020079;
        public static final int TANGRAM_REWARD_VIDEO_INIT_ERROR = 1020100;
        public static final int TANGRAM_REWARD_VIDEO_NATIVE_SELECT_AD_ERROR = 1020072;
        public static final int TANGRAM_REWARD_VIDEO_NATIVE_SELECT_AD_SUCCESS = 1020071;
        public static final int TANGRAM_REWARD_VIDEO_NET_SELECT_AD_FAIL = 1020069;
        public static final int TANGRAM_REWARD_VIDEO_NET_SELECT_AD_SUCCESS = 1020066;
        public static final int TANGRAM_REWARD_VIDEO_NET_SELECT_TIMEOUT = 1020068;
        public static final int TANGRAM_REWARD_VIDEO_PRELOAD_AD_CACHED_SUCCESS = 1020076;
        public static final int TANGRAM_REWARD_VIDEO_PRELOAD_AD_CALL = 1020060;
        public static final int TANGRAM_REWARD_VIDEO_PRELOAD_AD_CALL_FAIL = 1020062;
        public static final int TANGRAM_REWARD_VIDEO_PRELOAD_AD_CALL_SUCCESS = 1020061;
        public static final int TANGRAM_REWARD_VIDEO_PRELOAD_AD_FAIL = 1020064;
        public static final int TANGRAM_REWARD_VIDEO_PRELOAD_AD_SUCCESS = 1020063;
        public static final int TANGRAM_REWARD_VIDEO_SHOW_AD_CALL = 1020065;
        public static final int TANGRAM_REWARD_VIDEO_START_SHOW_AD = 1020067;
        public static final int TANGRAM_REWARD_VIDEO_STAR_NATIVE_SELECT_AD = 1020070;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    interface EventValue {
        public static final int AD_IS_SHOWN = 1;
        public static final int AD_NOT_SHOW = 2;
        public static final int ORDER_FROM_LOCAL = 1;
        public static final int ORDER_FROM_NETWORK = 2;
        public static final int TANGRAM_REWARD_VIDEO_PRELOAD_AD_CALL_BY_FLOW = 1;
        public static final int TANGRAM_REWARD_VIDEO_PRELOAD_AD_CALL_BY_SDK = 2;
    }

    RewardConstants() {
    }
}
