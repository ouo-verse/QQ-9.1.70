package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import com.tencent.ads.data.AdParam;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h extends r {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f41651a;

        a(int i3) {
            this.f41651a = i3;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            String str;
            String str2;
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            if (aPMidasResponse != null) {
                int i26 = aPMidasResponse.realSaveNum;
                String valueOf = String.valueOf(aPMidasResponse.resultInerCode);
                int i27 = aPMidasResponse.payChannel;
                int i28 = aPMidasResponse.payState;
                int i29 = aPMidasResponse.provideState;
                i16 = aPMidasResponse.resultCode;
                str = "";
                i3 = i26;
                str2 = valueOf;
                i17 = i27;
                i18 = i28;
                i19 = i29;
            } else {
                str = "payResp null";
                str2 = "";
                i3 = 0;
                i16 = -1;
                i17 = -1;
                i18 = -1;
                i19 = -1;
            }
            h.this.r(this.f41651a, i16, str2, i3, i17, i18, i19, str);
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "PayGameNeedLogin");
            }
            h.this.r(this.f41651a, 5, "", 0, -1, -1, -1, "pay need login");
        }
    }

    public h(Context context, Intent intent) {
        super(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3, int i16, String str, int i17, int i18, int i19, int i26, String str2) {
        Intent intent = new Intent();
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, i3);
        intent.putExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        intent.putExtra("result", i16);
        intent.putExtra("retInnerCode", str);
        intent.putExtra("realSaveNum", i17);
        intent.putExtra("payChannel", i18);
        intent.putExtra("payState", i19);
        intent.putExtra("provideState", i26);
        intent.putExtra("message", str2);
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
        String string3 = this.f41632d.getString("userId");
        String string4 = this.f41632d.getString("userKey");
        String string5 = this.f41632d.getString("sessionId");
        String string6 = this.f41632d.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        String string7 = this.f41632d.getString(AdParam.PF);
        String string8 = this.f41632d.getString("pfKey");
        String string9 = this.f41632d.getString("serviceCode");
        String string10 = this.f41632d.getString("serviceName");
        int i16 = this.f41632d.getInt("resId", 0);
        String string11 = this.f41632d.getString("saveValue");
        boolean z18 = this.f41632d.getBoolean("isCanChange");
        String string12 = this.f41632d.getString("remark");
        String string13 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
        String string14 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
        String string15 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string16 = this.f41632d.getString("other");
        this.f41632d.getString("payload");
        String string17 = this.f41632d.getString("drmInfo");
        APMidasMonthRequest aPMidasMonthRequest = new APMidasMonthRequest();
        aPMidasMonthRequest.setOfferId(string2);
        aPMidasMonthRequest.setOpenId(string3);
        aPMidasMonthRequest.setOpenKey(string4);
        aPMidasMonthRequest.setSessionId(string5);
        aPMidasMonthRequest.setSessionType(string6);
        aPMidasMonthRequest.setPf(string7);
        aPMidasMonthRequest.setPfKey(string8);
        aPMidasMonthRequest.setSaveValue(string11);
        aPMidasMonthRequest.setIsCanChange(z18);
        aPMidasMonthRequest.setServiceCode(string9);
        aPMidasMonthRequest.setServiceName(string10);
        aPMidasMonthRequest.setResId(i16);
        aPMidasMonthRequest.setProvideUin(string13);
        aPMidasMonthRequest.setProvideType(string14);
        aPMidasMonthRequest.setDiscoutId(string15);
        aPMidasMonthRequest.setRemark(string12);
        aPMidasMonthRequest.setReserv(string16);
        aPMidasMonthRequest.setDrmInfo(string17);
        a aVar = new a(i3);
        APMidasPayAPI.setEnv(string);
        if (z17 && r.o()) {
            z16 = true;
        } else {
            z16 = false;
        }
        APMidasPayAPI.setLogEnable(z16);
        APMidasPayAPI.init(this.f41629a, aPMidasMonthRequest);
        APMidasPayAPI.setLogCallback(v.class);
        APMidasPayAPI.launchPay(p(), aPMidasMonthRequest, aVar);
    }
}
