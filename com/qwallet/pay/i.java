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
public class i extends r {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f41653a;

        a(int i3) {
            this.f41653a = i3;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            if (aPMidasResponse != null) {
                try {
                    String str = aPMidasResponse.resultMsg;
                    if (str != null && str.length() > 0) {
                        str = str.replace("\\", "\\\\");
                    }
                    int i3 = aPMidasResponse.resultCode;
                    String valueOf = String.valueOf(aPMidasResponse.resultInerCode);
                    int i16 = aPMidasResponse.payState;
                    int i17 = aPMidasResponse.provideState;
                    int i18 = aPMidasResponse.realSaveNum;
                    i.this.r(this.f41653a, i3, valueOf, str, i16, i17, aPMidasResponse.payChannel, i18);
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.qwallet.BasePayPluginLogic", 2, "open qzone vip openService result  exception");
                    }
                    i.this.r(this.f41653a, -5, "", "open service exception", -1, -1, -1, 0);
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "openService payResponseInfo is null");
            }
            i.this.r(this.f41653a, -5, "", "open service payResponseInfo is null", -1, -1, -1, 0);
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "openService auth login is error");
            }
            i.this.r(this.f41653a, -5, "", "openService auth login is error NeedLogin", -1, -1, -1, 0);
        }
    }

    public i(Context context, Intent intent) {
        super(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3, int i16, String str, String str2, int i17, int i18, int i19, int i26) {
        Intent intent = new Intent();
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, i3);
        intent.putExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        intent.putExtra("result", i16);
        intent.putExtra("retInnerCode", str);
        intent.putExtra("payState", i17);
        intent.putExtra("provideState", i18);
        intent.putExtra("realSaveNum", i26);
        intent.putExtra("payChannel", i19);
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
        String string3 = this.f41632d.getString("unit");
        String string4 = this.f41632d.getString("payChannel");
        String string5 = this.f41632d.getString("userId");
        String string6 = this.f41632d.getString("userKey");
        String string7 = this.f41632d.getString("sessionId");
        String string8 = this.f41632d.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        String string9 = this.f41632d.getString(AdParam.PF);
        String string10 = this.f41632d.getString("pfKey");
        String string11 = this.f41632d.getString("serviceCode");
        String string12 = this.f41632d.getString("serviceName");
        boolean z18 = this.f41632d.getBoolean("autoPay");
        int i16 = this.f41632d.getInt("resId", 0);
        String string13 = this.f41632d.getString("saveValue");
        boolean z19 = this.f41632d.getBoolean("isCanChange");
        String string14 = this.f41632d.getString("remark");
        String string15 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
        String string16 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
        String string17 = this.f41632d.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string18 = this.f41632d.getString("other");
        this.f41632d.getString("payload");
        APMidasMonthRequest aPMidasMonthRequest = new APMidasMonthRequest();
        aPMidasMonthRequest.setOfferId(string2);
        aPMidasMonthRequest.setUnit(string3);
        aPMidasMonthRequest.setPayChannel(string4);
        aPMidasMonthRequest.setOpenId(string5);
        aPMidasMonthRequest.setOpenKey(string6);
        aPMidasMonthRequest.setSessionId(string7);
        aPMidasMonthRequest.setSessionType(string8);
        aPMidasMonthRequest.setPf(string9);
        aPMidasMonthRequest.setPfKey(string10);
        aPMidasMonthRequest.setSaveValue(string13);
        aPMidasMonthRequest.setIsCanChange(z19);
        aPMidasMonthRequest.setServiceCode(string11);
        aPMidasMonthRequest.setServiceName(string12);
        aPMidasMonthRequest.setResId(i16);
        aPMidasMonthRequest.setAutoPay(z18);
        aPMidasMonthRequest.setProvideUin(string15);
        aPMidasMonthRequest.setProvideType(string16);
        aPMidasMonthRequest.setDiscoutId(string17);
        aPMidasMonthRequest.setRemark(string14);
        aPMidasMonthRequest.setReserv(string18);
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
