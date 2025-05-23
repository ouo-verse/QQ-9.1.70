package com.tencent.mobileqq.mini.appbrand.jsapi;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.HashMap;

/* loaded from: classes33.dex */
public class PluginConst {

    /* loaded from: classes33.dex */
    public static class AdConst {
        public static final int ERROR_CODE_BANNED = 1007;
        public static final int ERROR_CODE_CLOSED = 1008;
        public static final int ERROR_CODE_INNER_ERROR = 1003;
        public static final int ERROR_CODE_INVALID_ADUNITID = 1002;
        public static final int ERROR_CODE_INVALID_POSITION = 1009;
        public static final int ERROR_CODE_IN_REVIEW = 1005;
        public static final int ERROR_CODE_NO_AD = 1004;
        public static final int ERROR_CODE_PARAM_ERROR = 1001;
        public static final int ERROR_CODE_REJECTED = 1006;
        public static final int ERROR_CODE_SERVICE_FAIL = 1000;
        public static final int KErrAdBlocked = -100100009;
        public static final int KErrAdDeleted = -100100002;
        public static final int KErrAdGdtNoData = -100100008;
        public static final int KErrAdNotFound = -100100007;
        public static final int KErrAdPositionExtIsNil = -100100005;
        public static final int KErrAdPositionIsNil = -100100004;
        public static final int KErrAdShutdown = -100100001;
        public static final int KErrAdStatusUnkown = -100100003;
        public static final int KErrAppNotFound = -100100006;
        public static final String ERROR_MSG_SERVICE_FAIL = HardCodeUtil.qqStr(R.string.p9m);
        public static final String ERROR_MSG_PARAM_ERROR = HardCodeUtil.qqStr(R.string.p9s);
        public static final String ERROR_MSG_INVALID_ADUNITID = HardCodeUtil.qqStr(R.string.p9q);
        public static final String ERROR_MSG_INNER_ERROR = HardCodeUtil.qqStr(R.string.p9t);
        public static final String ERROR_MSG_NO_AD = HardCodeUtil.qqStr(R.string.p9p);
        public static final String ERROR_MSG_IN_REVIEW = HardCodeUtil.qqStr(R.string.p9n);
        public static final String ERROR_MSG_REJECTED = HardCodeUtil.qqStr(R.string.p9o);
        public static final String ERROR_MSG_BANNED = HardCodeUtil.qqStr(R.string.p9r);
        public static final String ERROR_MSG_CLOSED = HardCodeUtil.qqStr(R.string.p9l);
        public static final String ERROR_MSG_INVALID_POSITION = HardCodeUtil.qqStr(R.string.f166972bo);
        public static final HashMap<Integer, String> CodeMsgMap = new HashMap<Integer, String>() { // from class: com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst.1
            {
                put(1000, AdConst.ERROR_MSG_SERVICE_FAIL);
                put(1001, AdConst.ERROR_MSG_PARAM_ERROR);
                put(1002, AdConst.ERROR_MSG_INVALID_ADUNITID);
                put(1003, AdConst.ERROR_MSG_INNER_ERROR);
                put(1004, AdConst.ERROR_MSG_NO_AD);
                put(1005, AdConst.ERROR_MSG_IN_REVIEW);
                put(1006, AdConst.ERROR_MSG_REJECTED);
                put(1007, AdConst.ERROR_MSG_BANNED);
                put(1008, AdConst.ERROR_MSG_CLOSED);
                put(1009, AdConst.ERROR_MSG_INVALID_POSITION);
            }
        };

        public static int getRetCodeByServerResult(int i3) {
            if (i3 >= -100101009 && i3 <= -100101000) {
                return 1000;
            }
            switch (i3) {
                case -100100009:
                    return 1007;
                case -100100008:
                    return 1004;
                case -100100007:
                case -100100004:
                case -100100003:
                    return 1002;
                case -100100006:
                case -100100005:
                    return 1001;
                case -100100002:
                case -100100001:
                    return 1008;
                default:
                    return -1;
            }
        }
    }

    /* loaded from: classes33.dex */
    public class AudioJsPluginConst {
        public static final String API_OPERATE_RECORDER = "operateRecorder";
        public static final String API_PAUSE_VOICE = "pauseVoice";
        public static final String API_PLAY_VOICE = "playVoice";
        public static final String API_START_RECORD = "startRecord";
        public static final String API_STOP_RECORD = "stopRecord";
        public static final String API_STOP_VOICE = "stopVoice";

        public AudioJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class CMShowJsPluginConst {
        public static final String API_GET_CM_SHOW_INFO = "getCMShowInfo";

        public CMShowJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class ChannelJsPluginConst {
        public static final String API_GET_CHANNEL_USER_INFO = "getChannelUserInfo";

        public ChannelJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class DataJsPluginConst {
        public static final String API_AUTHORIZE = "authorize";
        public static final String API_BOOKSHELF_INSERT = "insertBookshelf";
        public static final String API_GET_GROUP_INFO = "getGroupInfo";
        public static final String API_GET_GROUP_INFO_EXTRA = "getGroupInfoExtra";
        public static final String API_GET_NATIVE_USER_INFO = "getNativeUserInfo";
        public static final String API_GET_NATIVE_WERUN_DATA = "getNativeWeRunData";
        public static final String API_GET_PHONE_NUMBER = "getPhoneNumber";
        public static final String API_GET_USERINFO_OPENDATA = "getOpenDataUserInfo";
        public static final String API_INVOKE_GROUP_JS = "invokeGroupJSApi";
        public static final String API_MAKE_PHONE_CALL = "makePhoneCall";
        public static final String API_OPEN_WERUN_SETTING = "openWeRunSetting";
        public static final String API_OPERATE_WXDATA = "operateWXData";
        public static final String API_RECENT_COLOR_SIGN = "addRecentColorSign";
        public static final String API_REPORT_SUBMIT_FORM = "reportSubmitForm";
        public static final String PRIVATE_API_GET_NATIVE_USER_INFO_EXTRA = "getUserInfoExtra";

        public DataJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class ExpandJsPluginConst {
        public static final String API_GET_GET_EXPAND_USER_INFO = "getExpandUserInfo";

        public ExpandJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class ImageJsPluginConst {
        public static final String API_CHOOSE_IMAGE = "chooseImage";
        public static final String API_COMPRESS_IMAGE = "compressImage";
        public static final String API_GET_IMAGE_INFO = "getImageInfo";
        public static final String API_PREVIEW_IMAGE = "previewImage";
        public static final String API_SAVE_IMAGE_TO_ALBUM = "saveImageToPhotosAlbum";

        public ImageJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class MapJsPluginConst {
        public static final String API_CHOOSE_LOCATION = "chooseLocation";
        public static final String API_GET_LOCATION = "getLocation";
        public static final String API_OPEN_LOCATION = "openLocation";

        public MapJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class MediaJsPluginConst {
        public static final String EVENT_OPERATE_CAMERA = "operateCamera";
        public static final String EVENT_REMOVE_CAMERA = "removeCamera";
        public static final String EVENT_UPDATE_CAMERA = "updateCamera";

        public MediaJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class NearbyJsPluginConst {
        public static final String API_GET_GET_NEARBY_USER_INFO = "getNearbyUserInfo";

        public NearbyJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class OtherJsPluginConst {
        public static final String API_ADD_COLOR_SIGN = "addColorSign";
        public static final String API_ADD_COLOR_SIGN_DIRECTLY = "addColorSignDirectly";
        public static final String API_GET_SETTING = "getSetting";
        public static final String API_GUILD_ROLES = "guildRoles";
        public static final String API_IS_COLOR_SIGN_EXIST = "isColorSignExistSync";
        public static final String API_OPEN_ADDRESS = "openAddress";
        public static final String API_OPEN_SETTING = "openSetting";
        public static final String API_QUERY_APP_INFO = "queryAppInfo";
        public static final String API_SCAN_CODE = "scanCode";

        public OtherJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class OuterJsPluginConst {
        public static final String API_AD_CREATE_REWARDED_VIDEO_AD = "createRewardedVideoAd";
        public static final String API_AD_OPERATE_REWARDED_VIDEO_AD = "operateRewardedAd";
        public static final String API_CHOOSE_INVOICE = "chooseInvoice";
        public static final String API_CHOOSE_INVOICE_TITLE = "chooseInvoiceTitle";

        public OuterJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class PayJsPluginConst {
        public static final String API_CHECK_H5_PAY_STATUS = "checkH5PayStatus";
        public static final String API_CONSUME_STAR_CURRENTY = "consumeStarCurrency";
        public static final String API_PAY_BY_FRIEND = "requestFriendPayment";
        public static final String API_PAY_BY_H5 = "requestMidasPaymentByH5";
        public static final String API_PAY_COIN_BY_H5 = "requestMidasCoinPaymentByH5";
        public static final String API_RECHARGE_AND_CONSUME = "rechargeAndConsumeStarCurrency";
        public static final String API_RECHARGE_STAR_CURRENCY = "rechargeStarCurrency";
        public static final String API_REQUEST_MIDAS_GOODS_PAY = "requestMidasGoodsPay";
        public static final String API_REQUEST_MIDAS_MONTH_CARD_PAY = "requestMidasMonthCardPay";
        public static final String API_REQUEST_MIDAS_PAYMENT = "requestMidasPayment";
        public static final String API_REQUEST_PAYMENT = "requestPayment";
        public static final String API_REQUEST_STAR_CURRENCY = "queryStarCurrency";
        public static final String API_REQUEST_WX_PAYMENT = "requestWxPayment";

        public PayJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class SchemeJsPluginConst {
        public static final String API_OPEN_SCHEME = "openScheme";
        public static final String API_PERSONALIZE = "Personalize";

        public SchemeJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class SubscribeJsPluginConst {
        public static final String API_SUBSCRIBE_APP_MSG = "subscribeAppMsg";
        public static final String API_SUBSCRIBE_ONCE_APP_MSG = "subscribeOnceAppMsg";
        public static final String API_SUBSCRIBE_SYS_MSG = "requestSubscribeSystemMessage";

        public SubscribeJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class UIJsPluginConst {
        public static final String EVENT_INSERT_CAMERA = "insertCamera";
        public static final String EVENT_INSERT_HTML_WEBVIEW = "insertHTMLWebView";
        public static final String EVENT_REMOVE_HTML_WEBVIEW = "removeHTMLWebView";
        public static final String EVENT_UPDATE_HTML_WEBVIEW = "updateHTMLWebView";
        public static final String EVENT_WEBVIEW_INVOKE_APPSERVICE = "onWebInvokeAppService";

        public UIJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class VideoJsPluginConst {
        public static final String API_CHOOSE_MEDIA = "chooseMedia";
        public static final String API_CHOOSE_VIDEO = "chooseVideo";
        public static final String API_MAKE_MEDIA = "makeMedia";
        public static final String API_SAVE_VIDEO_TO_ALBUM = "saveVideoToPhotosAlbum";

        public VideoJsPluginConst() {
        }
    }

    /* loaded from: classes33.dex */
    public class VoIPPluginConst {
        public static final String API_JOIN_IP_CHAT = "joinVoIPChat";

        public VoIPPluginConst() {
        }
    }
}
