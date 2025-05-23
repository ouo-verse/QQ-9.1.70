package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;

/* loaded from: classes23.dex */
public abstract class PayProxy {
    public static final String MINI_EVENT_NAME = "mini_event_name";
    public static final String MINI_EVENT_SEQ = "mini_event_seq";
    public static final String MINI_RESPONSE_STR = "mini_response_str";

    /* loaded from: classes23.dex */
    public interface IPayResultCallBack {
        void onPayCallBack(PayResponse payResponse);

        void payNeedLogin();
    }

    /* loaded from: classes23.dex */
    public class PayResponse {
        public static final int PAYCHANEL_ACCT_QBQD = 11;
        public static final int PAYCHANEL_ACCT_QDQB = 0;
        public static final int PAYCHANEL_GOLDCOUPONS = 10;
        public static final int PAYCHANEL_HF = 9;
        public static final int PAYCHANEL_MCARD = 5;
        public static final int PAYCHANEL_QQCARD = 4;
        public static final int PAYCHANEL_TENPAY_BANK = 2;
        public static final int PAYCHANEL_TENPAY_CFT = 1;
        public static final int PAYCHANEL_TENPAY_KJ = 3;
        public static final int PAYCHANEL_UNKOWN = -1;
        public static final int PAYCHANEL_WECHAT = 8;
        public static final int PAYCHANEL_YB = 7;
        public static final int PAYPROVIDESTATE_SUCC = 0;
        public static final int PAYPROVIDESTATE_UNKOWN = -1;
        public static final int PAYRESULT_ALREADY_OWNED = 1159;
        public static final int PAYRESULT_CANCEL = 2;
        public static final int PAYRESULT_ERROR = -1;
        public static final int PAYRESULT_PARAMERROR = 3;
        public static final int PAYRESULT_PENDING = 101;
        public static final int PAYRESULT_SUCC = 0;
        public static final int PAYRESULT_UNKOWN = 100;
        public static final int PAYSTATE_PAYCANCEL = 1;
        public static final int PAYSTATE_PAYERROR = 2;
        public static final int PAYSTATE_PAYSUCC = 0;
        public static final int PAYSTATE_PAYUNKOWN = -1;
        public int resultCode = -1;
        public int resultInerCode = 0;
        public int realSaveNum = 0;
        public int payChannel = -1;
        public int payState = -1;
        public int provideState = -1;
        public String resultMsg = "";
        public String extendInfo = "";
        public String payReserve1 = "";
        public String payReserve2 = "";
        public String payReserve3 = "";

        public PayResponse() {
        }

        public String getExtendInfo() {
            return this.extendInfo;
        }

        public int getPayChannel() {
            return this.payChannel;
        }

        public String getPayReserve1() {
            return this.payReserve1;
        }

        public String getPayReserve2() {
            return this.payReserve2;
        }

        public String getPayReserve3() {
            return this.payReserve3;
        }

        public int getPayState() {
            return this.payState;
        }

        public int getProvideState() {
            return this.provideState;
        }

        public int getRealSaveNum() {
            return this.realSaveNum;
        }

        public int getResultCode() {
            return this.resultCode;
        }

        public int getResultInerCode() {
            return this.resultInerCode;
        }

        public String getResultMsg() {
            return this.resultMsg;
        }

        public void reset() {
            this.realSaveNum = 0;
            this.resultCode = -1;
            this.resultInerCode = 0;
            this.payChannel = -1;
            this.payState = -1;
            this.provideState = -1;
            this.resultMsg = "";
            this.extendInfo = "";
            this.payReserve1 = "";
            this.payReserve2 = "";
            this.payReserve3 = "";
        }

        public void setExtendInfo(String str) {
            this.extendInfo = str;
        }

        public void setPayChannel(int i3) {
            this.payChannel = i3;
        }

        public void setPayReserve1(String str) {
            this.payReserve1 = str;
        }

        public void setPayReserve2(String str) {
            this.payReserve2 = str;
        }

        public void setPayReserve3(String str) {
            this.payReserve3 = str;
        }

        public void setPayState(int i3) {
            this.payState = i3;
        }

        public void setProvideState(int i3) {
            this.provideState = i3;
        }

        public void setRealSaveNum(int i3) {
            this.realSaveNum = i3;
        }

        public void setResultCode(int i3) {
            this.resultCode = i3;
        }

        public void setResultInerCode(int i3) {
            this.resultInerCode = i3;
        }

        public void setResultMsg(String str) {
            this.resultMsg = str;
        }
    }

    /* loaded from: classes23.dex */
    public static class Source {
        public static final String PAY_CALLBACK_SN_EXTRA_KEY = "payparmas_callback_sn";
        public static final String PAY_H5_START_EXTRA_KEY = "payparmas_h5_start";
        public static final int PAY_INVOKER_BUY_GOODS = 7;
        public static final int PAY_INVOKER_OPEN_PAY = 24;
        public static final int PAY_INVOKER_PAY = 9;
        public static final int PAY_INVOKER_RECHARGE_GAME_CURRENCY = 6;
        public static final int PAY_INVOKER_SUBSCRIBE_MONTH_CARD = 14;
        public static final String PAY_IS_LOCK_WITHDRAW = "payparmas_is_lock_withdraw";
        public static final String PAY_JSON_EXTRA_KEY = "payparmas_json";
        public static final String PAY_REQUEST_APPID_KEY = "appId";
        public static final String PAY_REQUEST_CODE_KEY = "payparmas_request_code";
        public static final String PAY_REQUEST_NONCE_STR_KEY = "nonceStr";
        public static final String PAY_REQUEST_PACKAGE_KEY = "package";
        public static final String PAY_REQUEST_PAY_COME_FROM = "comeForm";
        public static final String PAY_REQUEST_PAY_SIGN_KEY = "paySign";
        public static final String PAY_REQUEST_PAY_VERSION_KEY = "payVersion";
        public static final String PAY_REQUEST_SDK_PF = "payparmas_sdk_pf";
        public static final String PAY_REQUEST_SIGN_TYPE_KEY = "signType";
        public static final String PAY_REQUEST_TIME_STAMP_KEY = "timeStamp";
        public static final String PAY_TYPE_EXTRA_KEY = "payparmas_paytype";
        public static final String PAY_URL_APPINFO_EXTRA_KEY = "payparmas_url_appinfo";
    }

    public static String getPayStateMsg(int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return "";
                    }
                    return "\u652f\u4ed8\u51fa\u9519";
                }
                return ShareJsPlugin.ERRMSG_INVITE_CANCEL;
            }
            return "\u652f\u4ed8\u6210\u529f";
        }
        return "\u652f\u4ed8\u72b6\u6001\u672a\u77e5";
    }

    public static String getResultCodeMsg(int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return "";
                    }
                    return MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR;
                }
                return ShareJsPlugin.ERRMSG_INVITE_CANCEL;
            }
            return "\u652f\u4ed8\u6d41\u7a0b\u6210\u529f";
        }
        return "\u652f\u4ed8\u6d41\u7a0b\u5931\u8d25";
    }

    public View getPayForFriendView(Context context, String str, String str2, String str3, String str4, String str5, int i3) {
        return null;
    }

    public abstract Bundle midasPay(Activity activity, String str, IPayResultCallBack iPayResultCallBack, Bundle bundle);

    public void callJs(String str, View view) {
    }
}
