package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import com.tencent.ads.data.AdParam;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends r {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f41640a;

        a(int i3) {
            this.f41640a = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x005f, code lost:
        
            if (r13 == 2) goto L15;
         */
        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            int i3;
            String str;
            int i16;
            int i17;
            int i18;
            int i19;
            if (QLog.isColorLevel()) {
                QLog.i("Q.qwallet.BasePayPluginLogic", 2, "PayGameServiceCallBack");
            }
            int i26 = 0;
            if (aPMidasResponse != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.qwallet.BasePayPluginLogic", 2, "PayGameServiceCallBackpay resultcode:" + aPMidasResponse.resultCode);
                }
                String str2 = "result:" + aPMidasResponse.resultCode + ",resultMsg:" + aPMidasResponse.resultMsg;
                int i27 = aPMidasResponse.realSaveNum;
                int i28 = aPMidasResponse.payChannel;
                int i29 = aPMidasResponse.payState;
                int i36 = aPMidasResponse.provideState;
                int i37 = aPMidasResponse.resultCode;
                int i38 = aPMidasResponse.payState;
                if (i37 != 0) {
                    if (i37 != 2) {
                        i26 = -1;
                        str = str2;
                        i17 = i28;
                        i18 = i29;
                        i19 = i36;
                        i16 = i26;
                        i3 = i27;
                    }
                    i26 = 6;
                    str = str2;
                    i17 = i28;
                    i18 = i29;
                    i19 = i36;
                    i16 = i26;
                    i3 = i27;
                }
            } else {
                i3 = 0;
                str = "payResp null";
                i16 = -1;
                i17 = -1;
                i18 = -1;
                i19 = -1;
            }
            c.this.r(this.f41640a, i16, i3, i17, i18, i19, str);
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "PayGameNeedLogin");
            }
            c.this.r(this.f41640a, 5, 0, -1, -1, -1, "pay need login");
        }
    }

    public c(Context context, Intent intent) {
        super(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3, int i16, int i17, int i18, int i19, int i26, String str) {
        Intent intent = new Intent();
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, i3);
        intent.putExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        intent.putExtra("result", i16);
        intent.putExtra("realSaveNum", i17);
        intent.putExtra("payChannel", i18);
        intent.putExtra("payState", i19);
        intent.putExtra("provideState", i26);
        intent.putExtra("message", str);
        intent.putExtra("payRetCode", i16);
        e(intent.getExtras());
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
        String string = this.f41632d.getString("setEnv");
        boolean z17 = this.f41632d.getBoolean("setLogEnable", false);
        String string2 = this.f41632d.getString("offerId");
        boolean z18 = this.f41632d.getBoolean("isShowNum", false);
        String string3 = this.f41632d.getString("userId");
        String string4 = this.f41632d.getString("userKey");
        String string5 = this.f41632d.getString("sessionId");
        String string6 = this.f41632d.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        String string7 = this.f41632d.getString("zoneId");
        String string8 = this.f41632d.getString(AdParam.PF);
        String string9 = this.f41632d.getString("pfKey");
        String string10 = this.f41632d.getString("tokenUrl");
        int i16 = this.f41632d.getInt("resId", 0);
        String string11 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string12 = this.f41632d.getString("other");
        this.f41632d.getString("payload");
        String string13 = this.f41632d.getString("drmInfo");
        int i17 = this.f41632d.getInt("tokenType", 1);
        APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
        aPMidasGoodsRequest.setOfferId(string2);
        aPMidasGoodsRequest.setShowNum(z18);
        aPMidasGoodsRequest.setOpenId(string3);
        aPMidasGoodsRequest.setOpenKey(string4);
        aPMidasGoodsRequest.setSessionId(string5);
        aPMidasGoodsRequest.setSessionType(string6);
        aPMidasGoodsRequest.setZoneId(string7);
        aPMidasGoodsRequest.setPf(string8);
        aPMidasGoodsRequest.setPfKey(string9);
        aPMidasGoodsRequest.setResId(i16);
        aPMidasGoodsRequest.setGoodsTokenUrl(string10);
        aPMidasGoodsRequest.setDiscoutId(string11);
        aPMidasGoodsRequest.setReserv(string12);
        aPMidasGoodsRequest.setDrmInfo(string13);
        aPMidasGoodsRequest.setTokenType(i17);
        a aVar = new a(i3);
        APMidasPayAPI.setEnv(string);
        if (z17 && r.o()) {
            z16 = true;
        } else {
            z16 = false;
        }
        APMidasPayAPI.setLogEnable(z16);
        APMidasPayAPI.setLogCallback(v.class);
        APMidasPayAPI.init(this.f41629a, aPMidasGoodsRequest);
        APMidasPayAPI.launchPay(p(), aPMidasGoodsRequest, aVar);
    }
}
