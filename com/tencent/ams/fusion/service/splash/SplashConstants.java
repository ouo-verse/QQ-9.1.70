package com.tencent.ams.fusion.service.splash;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SplashConstants {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f70308a;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FailReason {
        public static final int SELECT_ORDER_CACHE_DATA_RESPONSE_IS_NULL = 2;
        public static final int SELECT_ORDER_CACHE_DATA_SERVICE_IS_NULL = 1;
        public static final int SELECT_ORDER_FIRST_PLAY_FAILURE = 64;
        public static final int SELECT_ORDER_LOCAL_FAILURE = 16;
        public static final int SELECT_ORDER_PRELOAD_INFO_INVALID = 4;
        public static final int SELECT_ORDER_PREVIEW_FAILURE = 128;
        public static final int SELECT_ORDER_REAL_TIME_FAILURE = 32;
        public static final int SELECT_ORDER_TIME_OUT = 8;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PreloadDownloadTaskFailReason {
        public static final int RESOURCE_DOWNLOAD_TASK_PARSE_DATA_IS_NULL = 2;
        public static final int RESOURCE_DOWNLOAD_TASK_REQUEST_IS_NULL = 1;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PreloadFailReason {
        public static final int PRELOAD_CHECK_VALID = 1;
        public static final int PRELOAD_DATA_PARSE_JSON_ERROR = 1024;
        public static final int PRELOAD_DATA_PARSE_PARAMS_INVALID = 256;
        public static final int PRELOAD_DATA_PARSE_PARAMS_TYPE_ERROR = 512;
        public static final int PRELOAD_DATA_PARSE_RETURN_NULL = 2048;
        public static final int PRELOAD_DESERIALIZE_DATA_FAILURE = 2;
        public static final int PRELOAD_DESERIALIZE_DATA_INVALID = 32;
        public static final int PRELOAD_DESERIALIZE_DATA_PARCELABLE_INVALID = 4;
        public static final int PRELOAD_DESERIALIZE_DATA_PARSE_JSON_ERROR = 128;
        public static final int PRELOAD_DESERIALIZE_DATA_PARSE_NOT_STRING = 64;
        public static final int PRELOAD_DESERIALIZE_DATA_RAW_DATA_INVALID = 16;
        public static final int PRELOAD_DESERIALIZE_DATA_SERIALIZE_INVALID = 8;
        public static final int PRELOAD_DESERIALIZE_DATA_SUCCESS = 1;
        public static final int PRELOAD_FUNCTION_CLOSED = 4;
        public static final int PRELOAD_NET_RESPONSE_NULL = 16;
        public static final int PRELOAD_PARAMS_INVALID = 2;
        public static final int PRELOAD_PARSE_DATA_NULL = 32;
        public static final int PRELOAD_REQUEST_OVER_MAX_RETRY_TIMES = 64;
        public static final int PRELOAD_SAVE_RAW_CHECK_INVALID = 1;
        public static final int PRELOAD_SAVE_RAW_DATA_NULL = 8;
        public static final int PRELOAD_SAVE_RAW_FAILURE = 4;
        public static final int PRELOAD_SAVE_RAW_POSID_NULL = 16;
        public static final int PRELOAD_SAVE_RAW_SUCCESS = 2;
        public static final int PRELOAD_SAVE_SERIALIZE_DATA_FINISH = 2;
        public static final int PRELOAD_SAVE_SERIALIZE_DATA_INVALID = 1;
        public static final int PRELOAD_SAVE_SERIALIZE_DATA_NULL = 16;
        public static final int PRELOAD_SAVE_SERIALIZE_DATA_TYPE_ERROR = 4;
        public static final int PRELOAD_SAVE_SERIALIZE_POSID_NULL = 8;
        public static final int PRELOAD_TASK_TIMEOUT = 128;
        public static final int PRELOAD_TOO_FREQUENTLY = 8;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface RawFailReason {
        public static final int FIRST_PLAY_HAS_PLAYED_TODAY = 8;
        public static final int FIRST_PLAY_NOT_SHOW_ONE_SHOT = 16;
        public static final int FIRST_PLAY_RES_DOWNLOAD_FAILED = 32;
        public static final int FIRST_PLAY_RES_DOWNLOAD_TIME_OUT = 64;
        public static final int HOT_LAUNCH_NOT_SHOW_FIRST_PLAY = 4;
        public static final int LOCAL_BRAND_LIST_CPM_CAN_NOT_PLAY = 64;
        public static final int LOCAL_BRAND_LIST_IS_EMPTY = 8;
        public static final int LOCAL_CPD_RESOURCE_NOT_READY = 4;
        public static final int LOCAL_EFFECT_LIST_CAN_NOT_PLAY = 128;
        public static final int LOCAL_EFFECT_LIST_IS_EMPTY = 16;
        public static final int LOCAL_LOW_PRIORITY_IS_NULL = 32;
        public static final int LOCAL_SELECT_CLOSED = 512;
        public static final int LOCAL_SELECT_NONE = 256;
        public static final int LOCAL_SELECT_NOT_USE_EFFECT_AD_LIST = 1024;
        public static final int PREVIEW_EMPTY = 4;
        public static final int PREVIEW_RESOURCE_NOT_READY = 8;
        public static final int REAL_TIME_NET_WORK_INVALID = 4;
        public static final int REAL_TIME_RESPONSE_INVALID = 16;
        public static final int REAL_TIME_RESPONSE_NULL = 8;
        public static final int REAL_TIME_RES_DOWNLOAD_URL_INVALID = 32;
        public static final int REAL_TIME_SELECT_DATA_NULL = 256;
        public static final int REAL_TIME_SELECT_DOWNLOAD_LEFT_TIME_NOT_ENOUGH = 512;
        public static final int REAL_TIME_SELECT_DOWNLOAD_NOT_ALLOWED = 32768;
        public static final int REAL_TIME_SELECT_DOWNLOAD_RES_TIME_OUT = 1024;
        public static final int REAL_TIME_SELECT_NOT_USE_REAL_TIME_RESPONSE = 8192;
        public static final int REAL_TIME_SELECT_NO_DATA_AVAILABLE = 128;
        public static final int REAL_TIME_SELECT_REQUEST_TIME_OUT = 16384;
        public static final int REAL_TIME_SELECT_SECOND_ORDER_NOT_DOWNLOAD_ONE_SHOT = 2048;
        public static final int REAL_TIME_SELECT_SECOND_ORDER_NOT_MATCH = 4096;
        public static final int REAL_TIME_SELECT_TIME_OUT = 64;
        public static final int SELECT_REQUEST_PARAMS_INVALID = 1;
        public static final int SELECT_REQUEST_PRELOAD_INFO_INVALID = 2;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SelectOrderType {
        public static final int EMPTY_ORDER = 5;
        public static final int FIRST_PLAY = 2;
        public static final int ILLEGAL = -1;
        public static final int LOCAL = 4;
        public static final int PREVIEW = 1;
        public static final int REALTIME = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface StartFrom {
        public static final int ICON = 0;
        public static final int OTHERS = 4;
        public static final int PUSH = 3;
        public static final int QQ = 2;
        public static final int UNKNOWN = 5;
        public static final int WX = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SubCode {
        public static final int LOCAL_ORDER_SELECT_MATERIAL_CHECK = 1;
        public static final int REAL_FULL_ORDER_IMAGE_EXISTED = 2;
        public static final int REAL_FULL_ORDER_VIDEO_EXISTED = 4;
        public static final int REAL_TIME_SELECT_EMPTY_ORDER = 8;
        public static final int SELECT_REQUEST_SECOND_ORDER_SELECTED_BY_BEST_ORDER_CLOSED = 512;
        public static final int SELECT_REQUEST_SECOND_ORDER_SELECTED_BY_DOWNLOAD_FAIL = 64;
        public static final int SELECT_REQUEST_SECOND_ORDER_SELECTED_BY_LEFT_TIME_NOT_ENOUGH = 256;
        public static final int SELECT_REQUEST_SECOND_ORDER_SELECTED_BY_NO_BEST_ORDER = 128;
        public static final int SELECT_REQUEST_SECOND_ORDER_SELECTED_BY_SRC_DOWNLOAD_TIMEOUT = 32;
        public static final int SELECT_REQUEST_SECOND_ORDER_SELECTED_BY_TIMEOUT = 16;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55495);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f70308a = "210628";
        }
    }
}
