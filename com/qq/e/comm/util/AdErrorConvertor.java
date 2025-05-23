package com.qq.e.comm.util;

import com.tencent.qqmini.sdk.utils.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AdErrorConvertor {
    public static final int REWARDAD_ERROR_TYPE_DOWNLOAD_VIDEO_ERROR = 5002;
    public static final int REWARDAD_ERROR_TYPE_LOAD_AD_ERROR = 5001;
    public static final int REWARDAD_ERROR_TYPE_REWARDAD_SHOW_ERROR = 5003;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class ErrorCode {
        public static final int AD_DATA_EXPIRE = 5012;
        public static final int AD_DATA_NOT_READY = 4014;
        public static final int AD_MANAGER_INIT_ERROR = 200101;
        public static final int AD_REPLAY = 4015;
        public static final int AD_TYPE_DEPRECATED = 5021;
        public static final int APPID_NULL = 400102;
        public static final int CONSTRUCTOR_PARAM_ERROR = 4001;
        public static final int CONTENT_FORCE_EXPOSURE = 4012;
        public static final int CONTEXT_NULL = 400103;
        public static final int DEVICE_UNSUPPORT = 4007;
        public static final int IMAGE_LOAD_ERROR = 5008;
        public static final int INIT_ERROR = 2001;
        public static final int INNER_ERROR = 2002;
        public static final int JS_PARSE_NATIVE_PARAM_ERROR = 200202;
        public static final int MANIFEST_ERROR = 4002;
        public static final int NATIVE_CLICK_BEFORE_EXPOSE = 4006;
        public static final int NATIVE_EXPRESS_DATA_AND_TEMPLATE_NOT_MATCHED_ERROR = 5011;
        public static final int NATIVE_PARSE_JS_PARAM_ERROR = 200201;
        public static final int NETWORK_ERROR = 3001;
        public static final int NETWORK_TYPE_ERROR = 3003;
        public static final int NOT_SUPPORT_EXPRESS_VIDEO = 4013;
        public static final int NO_AD_FILL = 5004;
        public static final int ORENTATION_MISMATCH = 4016;
        public static final int PACKAGE_NAME_ERROR = 5006;
        public static final int PLUGIN_INIT_ERROR = 200102;
        public static final int POFACTORY_GET_INTERFACE_ERROR = 200103;
        public static final int POSID_ERROR = 4003;
        public static final int POSID_NULL = 400101;
        public static final int RENDER_TYPE_POSTYPE_NOTMATCH = 5010;
        public static final int RESOURCE_LOAD_ERROR = 5007;
        public static final int SCREEN_ORIENTATION_ERROR = 4008;
        public static final int SERVER_JSON_PARSE_ERROR = 5001;
        public static final int SKIP_VIEW_SIZE_ERROR = 4009;
        public static final int SPLASH_CONTAINER_HEIGHT_ERROR = 4005;
        public static final int SPLASH_CONTAINER_INVISIBLE = 4004;
        public static final int SPLASH_CONTAINER_NULL = 400104;
        public static final int SPLASH_DELAY_TIME_OUT = 4011;
        public static final int STUB_UNKNOWN_ERROR = 6000;
        public static final int TRAFFIC_CONTROL_DAY = 5005;
        public static final int TRAFFIC_CONTROL_HOUR = 5009;
        public static final int VIDEO_DOWNLOAD_FAIL = 5002;
        public static final int VIDEO_PLAY_ERROR = 5003;

        ErrorCode() {
        }
    }

    public static AdError formatErrorCode(int i3) {
        AdError adError;
        switch (i3) {
            case 400:
            case 403:
            case 3001:
                return new AdError(3001, "\u7f51\u7edc\u5f02\u5e38");
            case 404:
            case 4011:
                return new AdError(4011, "\u5f00\u5c4f\u5e7f\u544a\u62c9\u53d6\u8d85\u65f6");
            case 405:
            case 5007:
                return new AdError(5007, "\u8d44\u6e90\u52a0\u8f7d\u9519\u8bef");
            case 406:
            case 5008:
                return new AdError(5008, "\u56fe\u7247\u52a0\u8f7d\u9519\u8bef");
            case 500:
            case 4003:
                return new AdError(4003, "\u5e7f\u544a\u4f4d\u9519\u8bef");
            case 501:
            case 5004:
                return new AdError(5004, "\u6ca1\u6709\u5e7f\u544a");
            case 502:
            case 5001:
                return new AdError(5001, "\u670d\u52a1\u7aef\u6570\u636e\u9519\u8bef");
            case 600:
            case 4004:
                return new AdError(4004, "\u5f00\u5c4f\u5e7f\u544a\u5bb9\u5668\u4e0d\u53ef\u89c1");
            case 601:
            case 3003:
                return new AdError(3003, "\u7f51\u7edc\u7c7b\u578b\u9519\u8bef\uff0c\u5f53\u524d\u8bbe\u5907\u7684\u7f51\u7edc\u7c7b\u578b\u4e0d\u7b26\u5408\u5f00\u5c4f\u5e7f\u544a\u7684\u52a0\u8f7d\u6761\u4ef6");
            case 602:
            case 4002:
                return new AdError(4002, "Manifest\u6587\u4ef6\u4e2dActivity/Service/Permission\u7684\u58f0\u660e\u6709\u95ee\u9898\u6216\u8005Permission\u6743\u9650\u672a\u6388\u4e88");
            case 604:
            case ErrorCode.JS_PARSE_NATIVE_PARAM_ERROR /* 200202 */:
                return new AdError(2002, "\u5185\u90e8\u9519\u8bef\uff0c\u8be6\u7ec6\u7801\uff1a200202");
            case 700:
            case 5002:
                return new AdError(5002, "\u89c6\u9891\u7d20\u6750\u4e0b\u8f7d\u9519\u8bef");
            case 701:
            case 5003:
                return new AdError(5003, "\u89c6\u9891\u7d20\u6750\u64ad\u653e\u9519\u8bef");
            case 800:
                return new AdError(4012, "\u5185\u5bb9\u63a5\u53e3\u8c03\u7528\u987a\u5e8f\u9519\u8bef\uff0c\u8c03\u7528\u70b9\u51fb\u63a5\u53e3\u524d\u672a\u8c03\u7528\u66dd\u5149\u63a5\u53e3");
            case 2001:
                return new AdError(2001, "\u521d\u59cb\u5316\u9519\u8bef");
            case 2002:
                return new AdError(2002, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
            case 4001:
            case 400101:
            case 400102:
            case 400103:
            case 400104:
                adError = new AdError(4001, "\u4f20\u5165\u7684\u53c2\u6570\u6709\u9519\u8bef\uff0c\u8be6\u7ec6\u7801\uff1a" + i3);
                break;
            case 4006:
                return new AdError(4006, "\u539f\u751f\u5e7f\u544a\u63a5\u53e3\u8c03\u7528\u987a\u5e8f\u9519\u8bef\uff0c\u8c03\u7528\u70b9\u51fb\u63a5\u53e3\u524d\u672a\u8c03\u7528\u66dd\u5149\u63a5\u53e3");
            case 4007:
                return new AdError(4007, "\u5f53\u524d\u8bbe\u5907\u6216\u7cfb\u7edf\u4e0d\u652f\u6301");
            case 4008:
                return new AdError(4008, "\u8bbe\u5907\u65b9\u5411\u4e0d\u9002\u5408\u5c55\u793a\u5e7f\u544a");
            case 4009:
                return new AdError(4009, "\u5f00\u5c4f\u5e7f\u544a\u7684\u81ea\u5b9a\u4e49\u8df3\u8fc7\u6309\u94ae\u5c3a\u5bf8\u5c0f\u4e8e3x3dp");
            case 4014:
                return new AdError(4014, "\u5e7f\u544a\u6570\u636e\u5c1a\u672a\u51c6\u5907\u597d");
            case 4015:
                return new AdError(4015, "\u540c\u4e00\u6761\u5e7f\u544a\u4e0d\u5141\u8bb8\u591a\u6b21\u5c55\u793a\uff0c\u8bf7\u518d\u6b21\u62c9\u53d6\u540e\u5c55\u793a");
            case 5006:
            case 107030:
                return new AdError(5006, "\u5305\u540d\u6821\u9a8c\u9519\u8bef\uff0c\u5f53\u524dApp\u7684\u5305\u540d\u548c\u5e7f\u70b9\u901a\u79fb\u52a8\u8054\u76df\u5b98\u7f51\u6ce8\u518c\u7684\u5a92\u4f53\u5305\u540d\u4e0d\u4e00\u81f4\uff0c\u56e0\u6b64\u65e0\u5e7f\u544a\u8fd4\u56de");
            case 5011:
                return new AdError(5010, "\u539f\u751f\u6a21\u7248\u6e32\u67d3\u5931\u8d25");
            case 5012:
                return new AdError(5012, "\u5e7f\u544a\u6570\u636e\u5df2\u8fc7\u671f\uff0c\u8bf7\u91cd\u65b0\u62c9\u53d6\u5e7f\u544a");
            case 5021:
                return new AdError(5021, "\u8be5\u7c7b\u578b\u5e7f\u544a\u5df2\u5e9f\u5f03\uff0c\u8bf7\u4f7f\u7528\u5176\u4ed6\u7c7b\u578b\u7684\u5e7f\u544a");
            case 100159:
                return new AdError(4016, "\u5e94\u7528\u6a2a\u7ad6\u65b9\u5411\u53c2\u6570\u4e0e\u5e7f\u544a\u4f4d\u652f\u6301\u65b9\u5411\u4e0d\u5339\u914d");
            case 107034:
                return new AdError(5010, "\u5e7f\u544a\u6837\u5f0f\u6821\u9a8c\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u5e7f\u544a\u4f4d\u4e0e\u63a5\u53e3\u4f7f\u7528\u662f\u5426\u4e00\u81f4");
            case 107035:
                return new AdError(4013, "\u4f7f\u7528\u652f\u6301\u89c6\u9891\u7d20\u6750\u7684\u539f\u751f\u6a21\u677f\u5e7f\u544a\u4f4d\u524d\uff0c\u8bf7\u5347\u7ea7\u60a8\u7684SDK");
            case ErrorCode.AD_MANAGER_INIT_ERROR /* 200101 */:
                return new AdError(2001, "\u521d\u59cb\u5316\u9519\u8bef\uff0c\u8be6\u7ec6\u7801\uff1a200101");
            case ErrorCode.PLUGIN_INIT_ERROR /* 200102 */:
                return new AdError(2001, "\u521d\u59cb\u5316\u9519\u8bef\uff0c\u8be6\u7ec6\u7801\uff1a200102");
            case ErrorCode.POFACTORY_GET_INTERFACE_ERROR /* 200103 */:
                return new AdError(2001, "\u521d\u59cb\u5316\u9519\u8bef\uff0c\u8be6\u7ec6\u7801\uff1a200103");
            case ErrorCode.NATIVE_PARSE_JS_PARAM_ERROR /* 200201 */:
                return new AdError(2002, "\u5185\u90e8\u9519\u8bef\uff0c\u8be6\u7ec6\u7801\uff1a200201");
            default:
                adError = new AdError(6000, "\u672a\u77e5\u9519\u8bef\uff0c\u8be6\u7ec6\u7801\uff1a" + i3);
                break;
        }
        return adError;
    }

    public static AdError formatRewardErrorCode(int i3, int i16) {
        AdError adError;
        switch (i3) {
            case 5001:
                adError = new AdError(i3, "\u6fc0\u52b1\u5e7f\u544a\u62c9\u53d6\u5931\u8d25\uff0c\u8be6\u7ec6\u9519\u8bef\u7801\uff1a" + i16);
                break;
            case 5002:
                adError = new AdError(i3, "\u6fc0\u52b1\u89c6\u9891\u4e0b\u8f7d\u5931\u8d25\uff0c\u8be6\u7ec6\u9519\u8bef\u7801\uff1a" + i16);
                break;
            case 5003:
                adError = new AdError(i3, "\u6fc0\u52b1\u5e7f\u544a\u5c55\u793a\u5931\u8d25\uff0c\u8be6\u7ec6\u9519\u8bef\u7801\uff1a" + i16);
                break;
            default:
                adError = new AdError(i3, "\u672a\u77e5\u9519\u8bef\u7c7b\u578b\uff0c\u8be6\u7ec6\u9519\u8bef\u7801\uff1a" + i16);
                break;
        }
        adError.setSubErrorCode(i16);
        return adError;
    }
}
