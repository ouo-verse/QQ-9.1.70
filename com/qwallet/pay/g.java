package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qwallet.pay.g;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.wxapi.WXPayHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g extends r {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<g> f41648a;

        /* renamed from: b, reason: collision with root package name */
        private final int f41649b;

        /* renamed from: c, reason: collision with root package name */
        private final String f41650c;

        public a(g gVar, int i3, String str) {
            this.f41648a = new WeakReference<>(gVar);
            this.f41649b = i3;
            this.f41650c = str;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            u.f(aPMidasResponse);
            g gVar = this.f41648a.get();
            if (gVar == null) {
                QLog.w("Q.qwallet.BasePayPluginLogic", 1, "MidasPayCallBack callback fail, logic has release");
                return;
            }
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
                        QLog.i("Q.qwallet.BasePayPluginLogic", 2, "doLaunchWeChat result:" + jSONObject.toString());
                    }
                    gVar.t(this.f41649b, this.f41650c, aPMidasResponse.resultCode, jSONObject.toString());
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.qwallet.BasePayPluginLogic", 2, "doLaunchWeChat result json exception");
                    }
                    gVar.t(this.f41649b, this.f41650c, -1, "{'resultCode':-1,'resultMsg':'doLaunchWeChat result json exception'}");
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 2, "doLaunchWeChat payResponseInfo is null");
            }
            gVar.t(this.f41649b, this.f41650c, -1, "{'resultCode':-1,'resultMsg':'doLaunchWeChat payResponseInfo is null'}");
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            QLog.e("Q.qwallet.BasePayPluginLogic", 2, "doLaunchWeChat auth login is error");
            g gVar = this.f41648a.get();
            if (gVar != null) {
                gVar.t(this.f41649b, this.f41650c, -1, "{'resultCode':-1,'resultMsg':'doLaunchWeChat auth login is error NeedLogin'}");
            } else {
                QLog.w("Q.qwallet.BasePayPluginLogic", 1, "MidasPayNeedLogin callback fail, logic has release");
            }
        }
    }

    public g(Context context, Intent intent) {
        super(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3, String str, int i16, String str2) {
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
        String str;
        JSONObject jSONObject;
        super.g(context);
        int i3 = this.f41632d.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
        String string = this.f41632d.getString("callbackSn");
        String string2 = this.f41632d.getString("payType");
        String string3 = this.f41632d.getString("appId");
        String string4 = this.f41632d.getString("autoJump");
        String string5 = this.f41632d.getString("wxSignUrl");
        String string6 = this.f41632d.getString("bargainorId");
        String string7 = this.f41632d.getString("tokenId");
        String string8 = this.f41632d.getString(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY);
        String string9 = this.f41632d.getString(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
        String string10 = this.f41632d.getString("packageValue");
        String string11 = this.f41632d.getString("sign");
        String string12 = this.f41632d.getString(QFSEdgeItem.KEY_EXTEND);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("payType", string2);
            jSONObject2.put("appId", string3);
            jSONObject2.put("autoJump", string4);
            jSONObject2.put("wxSignUrl", string5);
            jSONObject2.put(QFSEdgeItem.KEY_EXTEND, string12);
            jSONObject2.put("bargainorId", string6);
            jSONObject2.put("tokenId", string7);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY, string8);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, string9);
            jSONObject2.put("packageValue", string10);
            jSONObject2.put("sign", string11);
            str = "Q.qwallet.BasePayPluginLogic";
        } catch (JSONException e16) {
            str = "Q.qwallet.BasePayPluginLogic";
            QLog.e(str, 1, "", e16);
        }
        if (!WXPayHelper.getInstance().isWXinstalled()) {
            QLog.e(str, 1, "doLaunchWeChat, not install wx app!");
            try {
                jSONObject = new JSONObject();
                jSONObject.put(QzoneIPCModule.RESULT_CODE, -1);
                jSONObject.put("resultMsg", context.getString(R.string.ehp));
            } catch (JSONException e17) {
                e = e17;
            }
            try {
                t(i3, string, -1, jSONObject.toString());
                return;
            } catch (JSONException e18) {
                e = e18;
                QLog.e(str, 1, "doLaunchWeChat, not install wx app!", e);
                return;
            }
        }
        final a aVar = new a(this, i3, string);
        APMidasPayAPI.init(this.f41629a, null);
        APMidasPayAPI.launchWeChat(p(), jSONObject2, aVar);
        if (!((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_DISABLE_CALLBACK_LAUNCH_WECHAT, false)) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.qwallet.pay.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.a.this.MidasPayCallBack(null);
                }
            }, 5000L);
        }
    }
}
