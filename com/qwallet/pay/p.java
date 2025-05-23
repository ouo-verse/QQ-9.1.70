package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.ads.data.AdParam;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p extends r {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f41665a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f41666b;

        a(int i3, String str) {
            this.f41665a = i3;
            this.f41666b = str;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            if (aPMidasResponse != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    String str = aPMidasResponse.resultMsg;
                    if (str != null && str.length() > 0) {
                        str = str.replace("\\", "\\\\");
                    }
                    jSONObject.put(QzoneIPCModule.RESULT_CODE, aPMidasResponse.resultCode);
                    jSONObject.put("retInnerCode", aPMidasResponse.resultInerCode);
                    jSONObject.put("realSaveNum", aPMidasResponse.realSaveNum);
                    jSONObject.put("payChannel", aPMidasResponse.payChannel);
                    jSONObject.put("payState", aPMidasResponse.payState);
                    jSONObject.put("provideState", aPMidasResponse.provideState);
                    jSONObject.put("resultMsg", str);
                    jSONObject.put("extendInfo", aPMidasResponse.extendInfo);
                    jSONObject.put("payReserve1", aPMidasResponse.payReserve1);
                    jSONObject.put("payReserve2", aPMidasResponse.payReserve2);
                    jSONObject.put("payReserve3", aPMidasResponse.payReserve3);
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.qwallet.BasePayPluginLogic", 2, "doSubscribeMonthCardPay result:" + jSONObject.toString());
                    }
                    p.this.r(this.f41665a, this.f41666b, aPMidasResponse.resultCode, jSONObject.toString());
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.qwallet.BasePayPluginLogic", 2, "subscribeMonthCardPay result json exception");
                    }
                    p.this.r(this.f41665a, this.f41666b, -1, "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay result json exception'}");
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "doSubscribeMonthCardPay payResponseInfo is null");
            }
            p.this.r(this.f41665a, this.f41666b, -1, "{'resultCode':-1,'resultMsg':'doSubscribeMonthCardPay payResponseInfo is null'}");
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "doSubscribeMonthCardPay auth login is error");
            }
            p.this.r(this.f41665a, this.f41666b, -1, "{'resultCode':-1,'resultMsg':'doSubscribeMonthCardPay auth login is error NeedLogin'}");
        }
    }

    public p(Context context, Intent intent) {
        super(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3, String str, int i16, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, i3);
        bundle.putInt(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        bundle.putString("callbackSn", str);
        bundle.putString("result", str2);
        bundle.putInt("payRetCode", i16);
        e(bundle);
    }

    @Override // com.qwallet.pay.a, com.qwallet.pay.b
    public boolean b() {
        return true;
    }

    @Override // com.qwallet.pay.r, com.qwallet.pay.a
    public void g(Context context) {
        boolean z16;
        super.g(context);
        int i3 = this.f41632d.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
        String string = this.f41632d.getString("callbackSn");
        String string2 = this.f41632d.getString("setEnv");
        boolean z17 = this.f41632d.getBoolean("setLogEnable", false);
        String string3 = this.f41632d.getString("offerId");
        boolean z18 = this.f41632d.getBoolean("isShowNum");
        String string4 = this.f41632d.getString("unit");
        String string5 = this.f41632d.getString("payChannel");
        String string6 = this.f41632d.getString("userId");
        String string7 = this.f41632d.getString("userKey");
        String string8 = this.f41632d.getString("sessionId");
        String string9 = this.f41632d.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        String string10 = this.f41632d.getString(AdParam.PF);
        String string11 = this.f41632d.getString("pfKey");
        String string12 = this.f41632d.getString("serviceCode");
        String string13 = this.f41632d.getString("serviceName");
        int i16 = this.f41632d.getInt("resId", 0);
        String string14 = this.f41632d.getString("saveValue");
        boolean z19 = this.f41632d.getBoolean("isCanChange");
        String string15 = this.f41632d.getString("remark");
        boolean z26 = this.f41632d.getBoolean("autoPay");
        String string16 = this.f41632d.getString("productId");
        this.f41632d.getString("couponId");
        this.f41632d.getString("payload");
        String string17 = this.f41632d.getString("drmInfo");
        String string18 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
        String string19 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
        String string20 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string21 = this.f41632d.getString("other");
        APMidasSubscribeRequest aPMidasSubscribeRequest = new APMidasSubscribeRequest();
        aPMidasSubscribeRequest.setOfferId(string3);
        aPMidasSubscribeRequest.setShowNum(z18);
        aPMidasSubscribeRequest.setUnit(string4);
        aPMidasSubscribeRequest.setPayChannel(string5);
        aPMidasSubscribeRequest.setOpenId(string6);
        aPMidasSubscribeRequest.setOpenKey(string7);
        aPMidasSubscribeRequest.setSessionId(string8);
        aPMidasSubscribeRequest.setSessionType(string9);
        aPMidasSubscribeRequest.setPf(string10);
        aPMidasSubscribeRequest.setPfKey(string11);
        aPMidasSubscribeRequest.setSaveValue(string14);
        aPMidasSubscribeRequest.setIsCanChange(z19);
        aPMidasSubscribeRequest.setResId(i16);
        aPMidasSubscribeRequest.setServiceCode(string12);
        aPMidasSubscribeRequest.setServiceName(string13);
        aPMidasSubscribeRequest.setRemark(string15);
        aPMidasSubscribeRequest.setAutoPay(z26);
        aPMidasSubscribeRequest.setProductId(string16);
        aPMidasSubscribeRequest.setDrmInfo(string17);
        aPMidasSubscribeRequest.setProvideUin(string18);
        aPMidasSubscribeRequest.setProvideType(string19);
        aPMidasSubscribeRequest.setDiscoutId(string20);
        aPMidasSubscribeRequest.setReserv(string21);
        a aVar = new a(i3, string);
        APMidasPayAPI.setEnv(string2);
        if (z17 && r.o()) {
            z16 = true;
        } else {
            z16 = false;
        }
        APMidasPayAPI.setLogEnable(z16);
        APMidasPayAPI.setLogCallback(v.class);
        APMidasPayAPI.init(this.f41629a, aPMidasSubscribeRequest);
        APMidasPayAPI.launchPay(p(), aPMidasSubscribeRequest, aVar);
    }
}
