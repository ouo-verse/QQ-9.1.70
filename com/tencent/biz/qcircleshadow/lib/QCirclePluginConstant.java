package com.tencent.biz.qcircleshadow.lib;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class QCirclePluginConstant {

    /* loaded from: classes4.dex */
    public static class AuthType {
        public static final int GROUP_AUTH = 2;
        public static final int NONE_AUTH = 0;
        public static final int PERSONAL_AUTH = 1;
        public static final int PERSONAL_AUTH_GRAY = 3;
        public static final int PERSONAL_AUTH_WHITE = 4;
    }

    /* loaded from: classes4.dex */
    public static class Business {
        public static final String KEY_EXTRAS = "KEY_EXTRAS";
        public static final String KEY_PLUGIN_PART_KEY = "KEY_PLUGIN_PART_KEY";
        public static final String KEY_PLUGIN_ZIP_PATH = "pluginZipPath";
        public static final String KEY_QCIRCLE_NEARBY_TAB_SWITCH = "key_qcircle_nearby_tab_switch";
        public static final String KEY_Q_CIRCLE_PLUGIN_INIT_BEAN = "KEY_Q_CIRCLE_PLUGIN_INIT_BEAN";
        public static final String KEY_SPLASH_ENTER = "KEY_SPLASH_ENTER";
        public static final String PART_KEY_PLUGIN_MAIN_APP = "qcircle-plugin";
        public static final String PLUGIN_SERVICE_NAME = "com.tencent.qcircle.activity.QCirclePreloadService";
        public static final String PLUGIN_SPLASH_NAME = "com.tencent.qcircle.activity.QCircleSplashActivity";
    }

    /* loaded from: classes4.dex */
    public static class DownLoad {
        public static final String URL_ANIMATION_DRAWABLE_ROCKEY_COUNT = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8925/rocket/qvideo_rocket_feed_push_text.zip";
        public static final String URL_ANIMATION_DRAWABLE_ROCKEY_END = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8925/rocket/qvideo_feed_push_rocket_10_seq.zip";
        public static final String URL_ANIMATION_DRAWABLE_ROCKEY_FIRST = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8925/rocket/qvideo_feed_push_rocket_1_seq.zip";
        public static final String URL_ANIMATION_DRAWABLE_ROCKEY_SECOND = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8925/rocket/qvideo_feed_push_rocket_2_seq.zip";
        public static final String URL_ANIMATION_DRAWABLE_ROCKEY_THIRD = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8925/rocket/qvideo_feed_push_rocket_3_seq.zip";
        public static final String URL_ANIMATION_DRAWABLE_SINGLE_CLICK = "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/8925/rocket/qvideo_feed_push_rocket_1_seq.zip";
    }

    /* loaded from: classes4.dex */
    public static class IPC {
        public static final String CLIENT_ACTION_INIT_SUCCESS = "CLIENT_ACTION_INIT_SUCCESS";
        public static final String Q_CIRCLE_CLIENT_MODULE_NAME = "Q_CIRCLE_CLIENT_MODULE_NAME";
        public static final String Q_CIRCLE_SERVICE_MODULE_NAME = "Q_CIRCLE_HOST_MODULE_NAME";
        public static final String SERVICE_ACTION_INIT_PLAY_SDK = "HOST_ACTION_INIT_PLAY_SDK";
    }

    /* loaded from: classes4.dex */
    public static class LoadAction {
        public static final int PLUGIN_PRELOAD_INSTALL = 1000;
        public static final int PLUGIN_PRE_START_PPS = 1005;
        public static final int PLUGIN_START_ACTIVITY = 1002;
        public static final int PLUGIN_START_SCHEME = 1003;
        public static final int PLUGIN_START_WITH_INSTALL = 1004;
        public static final Map<Integer, Integer> sAction;

        static {
            HashMap hashMap = new HashMap();
            sAction = hashMap;
            hashMap.put(1000, 1000);
            hashMap.put(1002, 1002);
            hashMap.put(1003, 1003);
            hashMap.put(1004, 1004);
            hashMap.put(1005, 1005);
        }
    }

    /* loaded from: classes4.dex */
    public static class PageId {
        public static final String KEY_PLUGIN_PAGE = "KEY_PLUGIN_PAGE";
        public static final int PAGE_FOLDER_ACTIVITY = 1;
        public static final int PAGE_FRAGMENT_ACTIVITY = 2;
    }

    /* loaded from: classes4.dex */
    public static class PluginType {
        public static final String Q_CIRCLE_PLUGIN_ASSET = "Q_CIRCLE_PLUGIN_ASSET";
        public static final String Q_CIRCLE_PLUGIN_NETWORK = "Q_CIRCLE_PLUGIN_NETWORK";
        public static final String Q_CIRCLE_PLUGIN_TEST = "Q_CIRCLE_PLUGIN_TEST";
    }
}
