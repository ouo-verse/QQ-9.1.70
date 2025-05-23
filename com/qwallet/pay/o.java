package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.ads.data.AdParam;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasAccountRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class o extends r {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<o> f41662a;

        /* renamed from: b, reason: collision with root package name */
        private int f41663b;

        /* renamed from: c, reason: collision with root package name */
        private String f41664c;

        public a(o oVar, int i3, String str) {
            this.f41662a = new WeakReference<>(oVar);
            this.f41663b = i3;
            this.f41664c = str;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            o oVar = this.f41662a.get();
            if (oVar == null) {
                return;
            }
            u.f(aPMidasResponse);
            if (aPMidasResponse != null) {
                try {
                    String str = aPMidasResponse.resultMsg;
                    if (str != null && str.length() > 0) {
                        str = str.replace("\\", "\\\\");
                    }
                    JSONObject jSONObject = new JSONObject();
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
                        QLog.i("Q.qwallet.BasePayPluginLogic", 2, "rechargeQb result:" + jSONObject.toString());
                    }
                    oVar.r(this.f41663b, this.f41664c, aPMidasResponse.resultCode, jSONObject.toString());
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.qwallet.BasePayPluginLogic", 2, "rechargeQb result json exception");
                    }
                    oVar.r(this.f41663b, this.f41664c, -1, "{'resultCode':-1,'resultMsg':'rechargeQb result json exception'}");
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "rechargeQb payResponseInfo is null");
            }
            oVar.r(this.f41663b, this.f41664c, -1, "{'resultCode':-1,'resultMsg':'rechargeQb payResponseInfo is null'}");
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            o oVar = this.f41662a.get();
            if (oVar == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "rechargeQb auth login is error");
            }
            oVar.r(this.f41663b, this.f41664c, -1, "{'resultCode':-1,'resultMsg':'rechargeQb auth login is error NeedLogin'}");
        }
    }

    public o(Context context, Intent intent) {
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
        String string12 = this.f41632d.getString("saveValue");
        String string13 = this.f41632d.getString("acctType", "qb");
        String string14 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
        String string15 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
        String string16 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string17 = this.f41632d.getString("other");
        boolean z18 = this.f41632d.getBoolean("isCanChange", false);
        this.f41632d.getString("payload");
        APMidasAccountRequest aPMidasAccountRequest = new APMidasAccountRequest();
        aPMidasAccountRequest.setOfferId(string3);
        aPMidasAccountRequest.setUnit(string4);
        aPMidasAccountRequest.setPayChannel(string5);
        aPMidasAccountRequest.setOpenId(string6);
        aPMidasAccountRequest.setOpenKey(string7);
        aPMidasAccountRequest.setSessionId(string8);
        aPMidasAccountRequest.setSessionType(string9);
        aPMidasAccountRequest.setPf(string10);
        aPMidasAccountRequest.setPfKey(string11);
        aPMidasAccountRequest.setSaveValue(string12);
        aPMidasAccountRequest.setAcctType(string13);
        aPMidasAccountRequest.setProvideUin(string14);
        aPMidasAccountRequest.setProvideType(string15);
        aPMidasAccountRequest.setDiscoutId(string16);
        aPMidasAccountRequest.setReserv(string17);
        aPMidasAccountRequest.setIsCanChange(z18);
        a aVar = new a(this, i3, string);
        APMidasPayAPI.setEnv(string2);
        if (z17 && r.o()) {
            z16 = true;
        } else {
            z16 = false;
        }
        APMidasPayAPI.setLogEnable(z16);
        APMidasPayAPI.setLogCallback(v.class);
        APMidasPayAPI.init(this.f41629a, aPMidasAccountRequest);
        APMidasPayAPI.launchPay(p(), aPMidasAccountRequest, aVar);
    }
}
