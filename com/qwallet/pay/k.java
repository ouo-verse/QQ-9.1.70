package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.ads.data.AdParam;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k extends r {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f41655a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f41656b;

        a(int i3, String str) {
            this.f41655a = i3;
            this.f41656b = str;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            u.f(aPMidasResponse);
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
                        QLog.i("Q.qwallet.BasePayPluginLogic", 2, "openService result:" + jSONObject.toString());
                    }
                    k.this.r(this.f41655a, this.f41656b, aPMidasResponse.resultCode, jSONObject.toString());
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.qwallet.BasePayPluginLogic", 2, "openService result json exception");
                    }
                    k.this.r(this.f41655a, this.f41656b, -1, "{'resultCode':-1,'resultMsg':'openService result json exception'}");
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "openService payResponseInfo is null");
            }
            k.this.r(this.f41655a, this.f41656b, -1, "{'resultCode':-1,'resultMsg':'openService payResponseInfo is null'}");
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "openService auth login is error");
            }
            k.this.r(this.f41655a, this.f41656b, -1, "{'resultCode':-1,'resultMsg':'openService auth login is error NeedLogin'}");
        }
    }

    public k(Context context, Intent intent) {
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
        boolean z18 = this.f41632d.getBoolean("isCanChange");
        String string15 = this.f41632d.getString("remark");
        String string16 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
        String string17 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
        String string18 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string19 = this.f41632d.getString("other");
        this.f41632d.getString("payload");
        boolean z19 = this.f41632d.getBoolean("autoPay");
        this.f41632d.getString("couponId");
        String string20 = this.f41632d.getString("drmInfo");
        APMidasMonthRequest aPMidasMonthRequest = new APMidasMonthRequest();
        aPMidasMonthRequest.setOfferId(string3);
        aPMidasMonthRequest.setUnit(string4);
        aPMidasMonthRequest.setPayChannel(string5);
        aPMidasMonthRequest.setOpenId(string6);
        aPMidasMonthRequest.setOpenKey(string7);
        aPMidasMonthRequest.setSessionId(string8);
        aPMidasMonthRequest.setSessionType(string9);
        aPMidasMonthRequest.setPf(string10);
        aPMidasMonthRequest.setPfKey(string11);
        aPMidasMonthRequest.setSaveValue(string14);
        aPMidasMonthRequest.setIsCanChange(z18);
        aPMidasMonthRequest.setServiceCode(string12);
        aPMidasMonthRequest.setServiceName(string13);
        aPMidasMonthRequest.setResId(i16);
        aPMidasMonthRequest.setAutoPay(z19);
        aPMidasMonthRequest.setProvideUin(string16);
        aPMidasMonthRequest.setProvideType(string17);
        aPMidasMonthRequest.setDiscoutId(string18);
        aPMidasMonthRequest.setRemark(string15);
        aPMidasMonthRequest.setReserv(string19);
        aPMidasMonthRequest.setDrmInfo(string20);
        a aVar = new a(i3, string);
        APMidasPayAPI.setEnv(string2);
        if (z17 && r.o()) {
            z16 = true;
        } else {
            z16 = false;
        }
        APMidasPayAPI.setLogEnable(z16);
        APMidasPayAPI.setLogCallback(v.class);
        APMidasPayAPI.init(this.f41629a, aPMidasMonthRequest);
        APMidasPayAPI.launchPay(p(), aPMidasMonthRequest, aVar);
    }
}
