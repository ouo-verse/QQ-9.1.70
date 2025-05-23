package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.ads.data.AdParam;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LogicBuyGoods extends r {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class a implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        private com.tencent.mobileqq.qwallet.f<LogicBuyGoods> f41602a;

        /* renamed from: b, reason: collision with root package name */
        private int f41603b;

        /* renamed from: c, reason: collision with root package name */
        private String f41604c;

        public a(LogicBuyGoods logicBuyGoods, int i3, String str) {
            this.f41602a = new com.tencent.mobileqq.qwallet.f<>(logicBuyGoods, IQWalletUnitedConfigApi.QWALLET_BUY_GOODS_CALLBACK_WEAK_REF, true);
            this.f41603b = i3;
            this.f41604c = str;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            LogicBuyGoods a16;
            u.f(aPMidasResponse);
            LogicBuyGoods logicBuyGoods = null;
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
                        QLog.i("Q.qwallet.BasePayPluginLogic", 2, "buyGoods result:" + jSONObject.toString());
                    }
                    com.tencent.mobileqq.qwallet.f<LogicBuyGoods> fVar = this.f41602a;
                    if (fVar == null) {
                        a16 = null;
                    } else {
                        a16 = fVar.a();
                    }
                    if (a16 != null) {
                        a16.r(this.f41603b, this.f41604c, aPMidasResponse.resultCode, jSONObject.toString());
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.qwallet.BasePayPluginLogic", 2, "buyGoods result json exception:" + e16.getMessage());
                    }
                    com.tencent.mobileqq.qwallet.f<LogicBuyGoods> fVar2 = this.f41602a;
                    if (fVar2 != null) {
                        logicBuyGoods = fVar2.a();
                    }
                    if (logicBuyGoods != null) {
                        logicBuyGoods.r(this.f41603b, this.f41604c, -1, "{'resultCode':-1,'resultMsg':'buyGoods result json exception'}");
                    }
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "buyGoods payResponseInfo is null");
            }
            com.tencent.mobileqq.qwallet.f<LogicBuyGoods> fVar3 = this.f41602a;
            if (fVar3 != null) {
                logicBuyGoods = fVar3.a();
            }
            if (logicBuyGoods != null) {
                logicBuyGoods.r(this.f41603b, this.f41604c, -1, "{'resultCode':-1,'resultMsg':'buyGoods payResponseInfo is null'}");
            }
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            LogicBuyGoods a16;
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "buyGoods auth login is error");
            }
            com.tencent.mobileqq.qwallet.f<LogicBuyGoods> fVar = this.f41602a;
            if (fVar == null) {
                a16 = null;
            } else {
                a16 = fVar.a();
            }
            if (a16 != null) {
                a16.r(this.f41603b, this.f41604c, -1, "{'resultCode':-1,'resultMsg':'buyGoods auth login is error NeedLogin'}");
            }
        }
    }

    public LogicBuyGoods(Context context, Intent intent) {
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
        final int i3 = this.f41632d.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
        final String string = this.f41632d.getString("callbackSn");
        String string2 = this.f41632d.getString("setEnv");
        boolean z17 = this.f41632d.getBoolean("setLogEnable", false);
        String string3 = this.f41632d.getString("offerId");
        boolean z18 = this.f41632d.getBoolean("isShowNum", false);
        String string4 = this.f41632d.getString("unit");
        String string5 = this.f41632d.getString("userId");
        String string6 = this.f41632d.getString("userKey");
        String string7 = this.f41632d.getString("sessionId");
        String string8 = this.f41632d.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        String string9 = this.f41632d.getString("zoneId");
        String string10 = this.f41632d.getString(AdParam.PF);
        String string11 = this.f41632d.getString("pfKey");
        String string12 = this.f41632d.getString("tokenUrl");
        int i16 = this.f41632d.getInt("resId", 0);
        String string13 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string14 = this.f41632d.getString("other");
        this.f41632d.getString("payload");
        String string15 = this.f41632d.getString("drmInfo");
        String string16 = this.f41632d.getString("payChannel");
        int i17 = this.f41632d.getInt("tokenType", 1);
        final APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
        aPMidasGoodsRequest.setOfferId(string3);
        aPMidasGoodsRequest.setShowNum(z18);
        aPMidasGoodsRequest.setUnit(string4);
        aPMidasGoodsRequest.setOpenId(string5);
        aPMidasGoodsRequest.setOpenKey(string6);
        aPMidasGoodsRequest.setSessionId(string7);
        aPMidasGoodsRequest.setSessionType(string8);
        aPMidasGoodsRequest.setZoneId(string9);
        aPMidasGoodsRequest.setPf(string10);
        aPMidasGoodsRequest.setPfKey(string11);
        aPMidasGoodsRequest.setResId(i16);
        aPMidasGoodsRequest.setGoodsTokenUrl(string12);
        aPMidasGoodsRequest.setDiscoutId(string13);
        aPMidasGoodsRequest.setReserv(string14);
        aPMidasGoodsRequest.setDrmInfo(string15);
        aPMidasGoodsRequest.setTokenType(i17);
        aPMidasGoodsRequest.setPayChannel(string16);
        APMidasPayAPI.setEnv(string2);
        if (z17 && r.o()) {
            z16 = true;
        } else {
            z16 = false;
        }
        APMidasPayAPI.setLogEnable(z16);
        APMidasPayAPI.setLogCallback(v.class);
        APMidasPayAPI.init(this.f41629a, aPMidasGoodsRequest, new ResultReceiver(ThreadManagerV2.getUIHandlerV2()) { // from class: com.qwallet.pay.LogicBuyGoods.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i18, Bundle bundle) {
                APMidasPayAPI.launchPay(LogicBuyGoods.this.p(), aPMidasGoodsRequest, new a(LogicBuyGoods.this, i3, string));
            }
        });
    }
}
