package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.minigame.ui.PayForFriendView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy = PayProxy.class)
/* loaded from: classes34.dex */
public class PayProxyImpl extends PayProxy {

    /* renamed from: a, reason: collision with root package name */
    private String f347498a = "PayProxyImpl";

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy
    public void callJs(String str, View view) {
        if (!TextUtils.isEmpty(str) && (view instanceof PayForFriendView)) {
            ((PayForFriendView) view).callJs(str);
        } else {
            QLog.d(PayForFriendView.TAG, 1, "PayProxyImpl callJs: param error");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy
    public View getPayForFriendView(Context context, String str, String str2, String str3, String str4, String str5, int i3) {
        QLog.d(PayForFriendView.TAG, 1, "PayProxyImpl getPayForFriendView: prepayId:" + str + " appId:" + str2);
        PayForFriendView payForFriendView = new PayForFriendView(context);
        if (payForFriendView.setUrl(str, str2, str3, str4, str5, i3)) {
            return payForFriendView;
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy
    public Bundle midasPay(Activity activity, String str, PayProxy.IPayResultCallBack iPayResultCallBack, Bundle bundle) {
        if (activity != null && bundle != null) {
            int i3 = bundle.getInt(PayProxy.Source.PAY_REQUEST_CODE_KEY, 0);
            if (i3 == 0) {
                QLog.d(this.f347498a, 1, "goMidasPay error, requestSource is empty");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("retCode", -1);
                return bundle2;
            }
            QLog.d(this.f347498a, 1, "goMidasPay requestSource = " + i3);
            return PayBridgeActivity.newPay(AppLoaderFactory.getMiniAppInterface(), activity, new PayResultRecevicer(new Handler(Looper.getMainLooper()), iPayResultCallBack) { // from class: com.tencent.qqmini.proxyimpl.PayProxyImpl.1
            }, i3, bundle);
        }
        QLog.d(this.f347498a, 1, "goMidasPay error, params is null");
        Bundle bundle3 = new Bundle();
        bundle3.putInt("retCode", -1);
        return bundle3;
    }

    /* loaded from: classes34.dex */
    class PayResultRecevicer extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        PayProxy.IPayResultCallBack f347500d;

        public PayResultRecevicer(Handler handler, PayProxy.IPayResultCallBack iPayResultCallBack) {
            super(handler);
            this.f347500d = iPayResultCallBack;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            QLog.d(PayProxyImpl.this.f347498a, 2, "onReceiveResult resultCode = " + i3 + " resultData = " + bundle);
            if (i3 == 6) {
                a(i3, bundle, PluginConst.PayJsPluginConst.API_REQUEST_MIDAS_PAYMENT);
                return;
            }
            if (i3 == 7) {
                a(i3, bundle, PluginConst.PayJsPluginConst.API_REQUEST_MIDAS_GOODS_PAY);
            } else if (i3 == 9) {
                a(i3, bundle, "requestPayment");
            } else {
                if (i3 != 14) {
                    return;
                }
                a(i3, bundle, PluginConst.PayJsPluginConst.API_REQUEST_MIDAS_MONTH_CARD_PAY);
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:1|(8:3|(2:32|33)(2:5|6)|7|8|9|(3:11|(1:14)|15)(3:22|(1:24)(1:26)|25)|16|(2:18|19)(1:21))|37|7|8|9|(0)(0)|16|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x010f, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0110, code lost:
        
            com.tencent.qphone.base.util.QLog.e(r16.f347501e.f347498a, 1, r0, new java.lang.Object[0]);
            r4.setResultCode(-1);
            r4.setPayState(2);
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x00d4 A[Catch: all -> 0x010f, TryCatch #2 {all -> 0x010f, blocks: (B:9:0x008e, B:11:0x00d4, B:14:0x00e3, B:15:0x00e6, B:24:0x00fc, B:25:0x010b, B:26:0x0104), top: B:8:0x008e }] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00f9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(int i3, Bundle bundle, String str) {
            int i16;
            PayProxy.IPayResultCallBack iPayResultCallBack;
            int optInt;
            PayProxy.PayResponse payResponse = new PayProxy.PayResponse();
            String string = bundle.getString("result");
            String string2 = bundle.getString("callbackSn");
            if (!TextUtils.isEmpty(string2)) {
                if (JSONUtil.isJson(string2)) {
                    try {
                        i16 = new JSONObject(string2).optInt("seq", -1);
                    } catch (JSONException e16) {
                        QLog.e(PayProxyImpl.this.f347498a, 1, e16, new Object[0]);
                    }
                } else {
                    try {
                        i16 = Integer.parseInt(string2);
                    } catch (NumberFormatException e17) {
                        QLog.e(PayProxyImpl.this.f347498a, 1, e17, new Object[0]);
                    }
                }
                QLog.d(PayProxyImpl.this.f347498a, 2, "onReceiveResult seq = " + i16 + " callbackSn=" + string2 + " result = " + string);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject(string);
                optInt = jSONObject2.optInt(QzoneIPCModule.RESULT_CODE, -1);
                String optString = jSONObject2.optString("resultMsg", "");
                JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                QLog.d(PayProxyImpl.this.f347498a, 1, "onReceiveResult seq = " + i16 + " callbackSn=" + string2 + " ret = " + optInt);
                jSONObject.put(QzoneIPCModule.RESULT_CODE, optInt);
                payResponse.setResultMsg(optString);
                if (optInt != 0) {
                    payResponse.setResultCode(0);
                    payResponse.setPayState(0);
                    if (i3 == 9 && optJSONObject != null) {
                        jSONObject.put("data", optJSONObject);
                    }
                    payResponse.setExtendInfo(jSONObject.toString());
                    payResponse.setPayChannel(jSONObject2.optInt("payChannel", -1));
                } else {
                    if (optInt == -1) {
                        payResponse.setResultCode(-1);
                        payResponse.setPayState(2);
                    } else {
                        payResponse.setResultCode(optInt);
                        payResponse.setPayState(2);
                    }
                    payResponse.setResultMsg(optString);
                }
                iPayResultCallBack = this.f347500d;
                if (iPayResultCallBack == null) {
                    iPayResultCallBack.onPayCallBack(payResponse);
                    return;
                }
                return;
            }
            i16 = -1;
            QLog.d(PayProxyImpl.this.f347498a, 2, "onReceiveResult seq = " + i16 + " callbackSn=" + string2 + " result = " + string);
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject22 = new JSONObject(string);
            optInt = jSONObject22.optInt(QzoneIPCModule.RESULT_CODE, -1);
            String optString2 = jSONObject22.optString("resultMsg", "");
            JSONObject optJSONObject2 = jSONObject22.optJSONObject("data");
            QLog.d(PayProxyImpl.this.f347498a, 1, "onReceiveResult seq = " + i16 + " callbackSn=" + string2 + " ret = " + optInt);
            jSONObject3.put(QzoneIPCModule.RESULT_CODE, optInt);
            payResponse.setResultMsg(optString2);
            if (optInt != 0) {
            }
            iPayResultCallBack = this.f347500d;
            if (iPayResultCallBack == null) {
            }
        }
    }
}
