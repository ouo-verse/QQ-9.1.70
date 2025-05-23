package com.tencent.ad.tangram.statistics.metric;

import com.tencent.ad.tangram.annotation.AdKeep;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdMetricTag {
    public static final String ERROR_CODE = "androidErrorCode";
    public static final String EVENT_NAME = "eventName";
    public static final String FALLBACK = "fallback";
    public static final String HTTP_RESPONSE_CODE = "httpResponseCode";
    public static final String JS_BUNDLE_VERSION = "jsBundleVersion";
    public static final String MANUFACTURER = "manufacturer";
    public static final String MANUFACTURER_OS_VERSION = "manufacturerOSVersion";
    public static final String MODEL = "model";
    public static final String ORIENTATION = "orientation";
    public static final String POS_ID = "posId";
    public static final String RESPONSE_CODE = "responseCode";
    public static final String TEMPLATE_ID = "templateId";
    public static final String URI_AUTHORITY = "uriAuthority";
    public static final String URI_SCHEME = "uriScheme";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Click {
        public static final String ACTION = "androidClickAction";
        public static final String FALLBACK_TO_REWARD_URL = "androidClickFallbackToRewardUrl";
        public static final String LAUNCH_APP_RESULT = "androidClickLaunchAppResult";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Common {
        public static final String APP_VERSION = "appVersion";
        public static final String BRAND = "brand";
        public static final String OS_TYPE = "os";
        public static final String OS_VERSION = "osVersion";
        public static final String PACKAGE_NAME = "packageName";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Kuikly {
        public static final String BUNDLE_NAME = "kuiklyBundleName";
        public static final String ON_PAGE_LOAD_FAILED_ERROR_CODE = "androidKuiklyOnPageLoadFailedErrorCode";
        public static final String PAGE_NAME = "kuiklyPageName";
        public static final String UPDATE_ERROR_CODE = "androidKuiklyUpdateErrorCode";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Orientation {
        public static final String LANDSCAPE = "landscape";
        public static final String PORTRAIT = "portrait";
        public static final String UNKNOWN = "unknown";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Report {
        public static final String TYPE = "reportType";

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class Type {
            public static final int CLICK_AND_FETCH = 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Reward {
        public static final String CONTAINER_DETAIL_TYPE = "androidRewardContainerDetailType";
        public static final String CONTAINER_TYPE = "androidRewardContainerType";
        public static final String ERROR_CODE_CREATE_VIEW = "androidRewardErrorCodeCreateView";
        public static final String ERROR_CODE_INITIALIZE_ENGINE = "androidRewardErrorCodeInitializeEngine";
        public static final String ERROR_CODE_LOAD_JS_BUNDLE = "androidRewardErrorCodeLoadJSBundle";
        public static final String ERROR_CODE_LOAD_LIBRARY = "androidRewardErrorCodeLoadLibrary";
        public static final String LAUNCH_MODE = "rewardLaunchMode";
        public static final String PLAY_TYPE = "rewardPlayType";
        public static final String RENDER_TYPE = "rewardRenderType";
        public static final String STYLE = "androidRewardStyle";

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public static final class ContainerDetailType {
            public static final int DIALOG = 3;
            public static final int DIALOG_FRAGMENT = 2;
            public static final int FRAGMENT = 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class SuperPlayer {
        public static final String ERROR_CODE = "androidSuperPlayerErrorCode";
        public static final String ERROR_MODEL = "androidSuperPlayerErrorModel";
        public static final String ERROR_TYPE = "androidSuperPlayerErrorType";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Turing {
        public static final String ERROR_CODE = "androidTuringErrorCode";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class WXMINIProgram {
        public static final String ERROR_CODE_PRIVATE_OPEN_URL_PARSE = "androidWXMINIProgramPrivateOpenUrlParseErrorCode";
    }
}
