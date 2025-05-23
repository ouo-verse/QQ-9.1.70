package com.tenpay.sdk.helper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.api.WXPayHelper;
import com.tenpay.util.Utils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class WechatPayHelper {
    private static final String TAG = "WechatPayHelper";
    private IResult mResult;
    public Handler mPayHandler = new Handler(new Handler.Callback() { // from class: com.tenpay.sdk.helper.WechatPayHelper.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            QwLog.i("pay handler msg: " + message);
            if (message.what == 10) {
                WechatPayHelper.this.wxHelper.removeObserver(WechatPayHelper.this.mPayHandler);
                Bundle data = message.getData();
                QwLog.i("in WXShareListener" + data);
                int i3 = data.getInt("errCode");
                QwLog.i("onPayFinish, errCode = " + i3);
                if (WechatPayHelper.this.mResult != null) {
                    WechatPayHelper.this.mResult.onResult(i3, data);
                    return false;
                }
                return false;
            }
            return false;
        }
    });
    private WXPayHelper wxHelper = WXPayHelper.getInstance();

    /* loaded from: classes27.dex */
    public interface IResult {
        void onResult(int i3, Bundle bundle);
    }

    public boolean canJumpToWxMiniProgram() {
        if (isWXinstalled() && this.wxHelper.getWXAppSupportAPI() >= 621086464) {
            return true;
        }
        return false;
    }

    public boolean isShowWxPayEntry() {
        if (isWXinstalled() && isWXsupportPayApi()) {
            return true;
        }
        return false;
    }

    public boolean isWXinstalled() {
        try {
            return this.wxHelper.isWXinstalled();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return true;
        }
    }

    public boolean isWXsupportPayApi() {
        try {
            if (this.wxHelper.getWXAppSupportAPI() < 570425345) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            QwLog.i("wx support api not right!");
            return false;
        }
    }

    public void pay(JSONObject jSONObject, IResult iResult) {
        this.mResult = iResult;
        Map<String, String> uriParams = Utils.getUriParams(jSONObject.optString("wxpay_sdk"));
        Bundle bundle = new Bundle();
        bundle.putString("appid", uriParams.get("appid"));
        bundle.putString("partnerid", uriParams.get("partnerid"));
        bundle.putString("prepayid", uriParams.get("prepayid"));
        bundle.putString("noncestr", uriParams.get("noncestr"));
        bundle.putString("timestamp", uriParams.get("timestamp"));
        bundle.putString("package", uriParams.get("package"));
        bundle.putString("sign", uriParams.get("sign"));
        QwLog.i("api.sendReq:" + bundle.toString());
        try {
            this.wxHelper.addObserver(this.mPayHandler);
            this.wxHelper.sendReq(bundle);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public void registerApp(String str) {
        this.wxHelper.registerApp(str);
    }

    public void release() {
        this.wxHelper.unRegisterApp();
    }
}
