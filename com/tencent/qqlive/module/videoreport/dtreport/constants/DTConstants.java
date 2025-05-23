package com.tencent.qqlive.module.videoreport.dtreport.constants;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTConstants {
    public static final String IDENTIFIER_SCROLL_PRIEF = "identifier_scroll";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class APPStatusConstant {
        public static final String ACTION_APP_PROCESS_IN_OUT = "action_app_in_out";
        public static final String ACTION_APP_PROCESS_START = "action_app_process_start";
        public static final int APP_BACKGROUND = 2;
        public static final int APP_FORGROUND = 1;
        public static final String APP_PROCESS_ID = "app_process_id";
        public static final String APP_STATUS = "app_status";
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum ClickEventSource {
        METHOND_BEFORE,
        METHOND_AFTER
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class CroProcessKey {
        public static final String KEY_ARG_VISUAL_DEBUG_GET_DEBUG_INFO = "key_arg_visual_debug_get_debug_info";
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class DTExtendMapKey {
        public static final String AUDIO_TIMER_LISTENER = "audio_timer_listener";
        public static final String ELEMENT_EXPOSURE_INTERVAL_TIME = "element_exposure_interval_time";
        public static final String ELEMENT_EXPOSURE_IS_FIRST_SCROLL_EXPOSURE = "element_is_first_scroll_exposure";
        public static final String ELEMENT_EXPOSURE_REUSE_ID = "element_exposure_reuseid";
        public static final String ELEMENT_EXPOSURE_TIME = "element_exposure_time";
        public static final String ELEMENT_SCROLL_EXPOSURE = "element_scroll_exposure";
        public static final String ENABLE_ANDROID_RV_EXPOSURE = "enable_androidx_rv_exposure";
        public static final String FLUTTER_API = "flutter_api";
        public static final String LISTVIEW_SCROLL_STATE = "listview_scroll_state";
        public static final String SUBMIT_TARGET = "submitTarget";
        public static final String VIEW_EXPOSURE_AREA_LIMIT = "view_exposure_area_limit";
        public static final String VIEW_REPORT_BEFORE_CLICK = "view_report_before_click";
        public static final String VIEW_REPORT_BEFORE_LONG_CLICK = "view_report_before_long_click";
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum JsCallbackPolicy {
        JS_METHOND_CALLBACK,
        JS_WINDOWS_CALLBACK
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class KeyBoardAction {
        public static final String ACTION_DONE = "DONE";
        public static final String ACTION_GO = "GO";
        public static final String ACTION_SEARCH = "SEARCH";
        public static final String ACTION_SEND = "SEND";
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class KeyBoardFrom {
        public static final int FROM_APP_BTN = 2;
        public static final int FROM_KEY_BOARD = 1;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TAG {
        public static final String API = "api";
        public static final String APP = "app";
        public static final String AUDIO = "audio";
        public static final String COMMON = "common";
        public static final String ELEMENT = "element";
        public static final String HOOK = "hook";
        public static final String JS_BRIDGE = "jsbridge";
        public static final String PAGE = "page";
        public static final String REMOTE_CONFIG = "DT.RemoteConfig";
        public static final String SAMPLER = "DT.sampler";
        public static final String SDK_INIT = "sdk_init";
        public static final String VIDEO = "video";
    }
}
