package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.ads.data.AdParam;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class n extends r {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f41659a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f41660b;

        a(int i3, String str) {
            this.f41659a = i3;
            this.f41660b = str;
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
                        QLog.i("Q.qwallet.BasePayPluginLogic", 2, "rechargeCurrency result:" + jSONObject.toString());
                    }
                    n.this.r(this.f41659a, this.f41660b, aPMidasResponse.resultCode, jSONObject.toString());
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.qwallet.BasePayPluginLogic", 2, "rechargeCurrency result json exception:" + e16.getMessage());
                    }
                    n.this.r(this.f41659a, this.f41660b, -1, "{'resultCode':-1,'resultMsg':'rechargeCurrency result json exception'}");
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "rechargeCurrency payResponseInfo is null");
            }
            n.this.r(this.f41659a, this.f41660b, -1, "{'resultCode':-1,'resultMsg':'rechargeCurrency payResponseInfo is null'}");
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "rechargeCurrency auth login is error");
            }
            n.this.r(this.f41659a, this.f41660b, -1, "{'resultCode':-1,'resultMsg':'rechargeCurrency auth login is error NeedLogin'}");
        }
    }

    public n(Context context, Intent intent) {
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
        Boolean valueOf = Boolean.valueOf(this.f41632d.getBoolean("isShowNum", false));
        String string4 = this.f41632d.getString("userId");
        String string5 = this.f41632d.getString("userKey");
        String string6 = this.f41632d.getString("sessionId");
        String string7 = this.f41632d.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        String string8 = this.f41632d.getString("zoneId");
        String string9 = this.f41632d.getString(AdParam.PF);
        String string10 = this.f41632d.getString("pfKey");
        String string11 = this.f41632d.getString("acctType");
        String string12 = this.f41632d.getString("saveValue");
        boolean z18 = this.f41632d.getBoolean("isCanChange", true);
        int i16 = this.f41632d.getInt("resId", 0);
        String string13 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string14 = this.f41632d.getString("other");
        this.f41632d.getString("payload");
        String string15 = this.f41632d.getString("drmInfo");
        String string16 = this.f41632d.getString("payChannel");
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        aPMidasGameRequest.setOfferId(string3);
        aPMidasGameRequest.setShowNum(valueOf.booleanValue());
        aPMidasGameRequest.setOpenId(string4);
        aPMidasGameRequest.setOpenKey(string5);
        aPMidasGameRequest.setSessionId(string6);
        aPMidasGameRequest.setSessionType(string7);
        aPMidasGameRequest.setZoneId(string8);
        aPMidasGameRequest.setPf(string9);
        aPMidasGameRequest.setPfKey(string10);
        aPMidasGameRequest.setSaveValue(string12);
        aPMidasGameRequest.setIsCanChange(z18);
        aPMidasGameRequest.setAcctType(string11);
        aPMidasGameRequest.setResId(i16);
        aPMidasGameRequest.setDiscoutId(string13);
        aPMidasGameRequest.setReserv(string14);
        aPMidasGameRequest.setDrmInfo(string15);
        aPMidasGameRequest.setPayChannel(string16);
        a aVar = new a(i3, string);
        APMidasPayAPI.setEnv(string2);
        if (z17 && r.o()) {
            z16 = true;
        } else {
            z16 = false;
        }
        APMidasPayAPI.setLogEnable(z16);
        APMidasPayAPI.setLogCallback(v.class);
        APMidasPayAPI.init(this.f41629a, aPMidasGameRequest);
        APMidasPayAPI.launchPay(p(), aPMidasGameRequest, aVar);
    }
}
