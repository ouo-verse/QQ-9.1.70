package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.openpay.data.pay.PayResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tenpay.api.TenpayInterface;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.api.IRealNameSourceReportApi;
import cooperation.qwallet.open.api.IOpenPayApi;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LogicPay extends a {
    public LogicPay(Context context, Intent intent) {
        super(context, intent);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject q(int i3, String str, LogicPay logicPay, String str2) throws JSONException {
        Object obj;
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(QzoneIPCModule.RESULT_CODE, i3);
        if (i3 == 0) {
            jSONObject2.put("retmsg", "success");
            jSONObject2.put("data", jSONObject);
        } else {
            if (jSONObject.has("err_msg")) {
                obj = jSONObject.get("err_msg");
            } else {
                obj = "error";
            }
            jSONObject2.put("retmsg", obj);
            if (logicPay.f41633e == 4) {
                jSONObject2.put("data", jSONObject);
            } else {
                jSONObject2.put("data", new JSONObject());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.BasePayPluginLogic", 2, "tenpay result:" + jSONObject2.toString());
        }
        return jSONObject2;
    }

    private void r(String str, int i3, String str2) {
        PayResponse payResponse = new PayResponse();
        payResponse.apiMark = 1;
        payResponse.apiName = OpenConstants.ApiName.PAY;
        payResponse.serialNumber = str;
        payResponse.retCode = i3;
        if (!TextUtils.isEmpty(str2)) {
            u(payResponse, i3, str2);
        }
        String string = this.f41632d.getString("packageName");
        String string2 = this.f41632d.getString("callbackScheme");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            Intent intent = new Intent();
            intent.putExtra("big_brother_source_key", "biz_src_zf_qianbao_return");
            if (this.f41632d.getInt("appPayType") == 2) {
                String parseResponseFromJson = ((IOpenPayApi) QRoute.api(IOpenPayApi.class)).parseResponseFromJson(payResponse.retCode, payResponse.retMsg, payResponse.serialNumber);
                intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.setData(Uri.parse(string2 + QzoneWebViewOfflinePlugin.STR_DEVIDER + parseResponseFromJson));
                intent.setPackage(string);
                intent.putExtra(OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_KEY, OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_TAG);
            } else {
                Bundle bundle = new Bundle();
                payResponse.toBundle(bundle);
                intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.setData(Uri.parse(string2 + "://open_pay/pay"));
                intent.setPackage(string);
                intent.putExtras(bundle);
                intent.putExtra(OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_KEY, OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_TAG);
            }
            try {
                intent.addFlags(268435456);
                MobileQQ.sMobileQQ.getApplicationContext().startActivity(intent);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.qwallet.BasePayPluginLogic", 2, "QvipPayBridgeActivity.doAppCashPayResult error:" + e16.getMessage());
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                    return;
                }
                return;
            }
        }
        QLog.e("Q.qwallet.BasePayPluginLogic", 2, "QvipPayBridgeActivity.doOpenAppCashPayResult packageName&callbackScheme empty");
    }

    private void s(Context context, Bundle bundle) {
        final WeakReference weakReference = new WeakReference(this);
        TenpayInterface.gotoPay(context, bundle, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.qwallet.pay.LogicPay.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle2) {
                Bundle bundle3;
                QLog.i("Q.qwallet.BasePayPluginLogic", 2, "TenpayResultReceiver.onReceiveResult resultCode:" + i3);
                if (i3 != 99999 && i3 != 99998) {
                    LogicPay logicPay = (LogicPay) weakReference.get();
                    if (logicPay != null && (bundle3 = logicPay.f41632d) != null) {
                        int i16 = bundle3.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
                        String string = logicPay.f41632d.getString("callbackSn");
                        if (bundle2 == null) {
                            logicPay.t(i16, string, i3, "{'resultCode':" + i3 + ",'retmsg':'pay resultData is null'}");
                            QLog.e("Q.qwallet.BasePayPluginLogic", 2, "TenpayResultReceiver.onReceiveResult resultData == null");
                            return;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("resultCode=");
                        sb5.append(i3);
                        String string2 = bundle2.getString("retmsg");
                        if (!TextUtils.isEmpty(string2)) {
                            try {
                                sb5.append("&p=");
                                sb5.append(URLEncoder.encode(string2, "UTF-8"));
                            } catch (Exception e16) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                                }
                            }
                        }
                        try {
                            logicPay.t(i16, string, i3, LogicPay.this.q(i3, string2, logicPay, sb5.toString()).toString());
                            return;
                        } catch (Exception e17) {
                            QLog.w("Q.qwallet.BasePayPluginLogic", 1, "tenpay result json exception:", e17);
                            logicPay.t(i16, string, i3, "{'resultCode':" + i3 + ",'retmsg':'pay result json exception'}");
                            return;
                        }
                    }
                    QLog.e("Q.qwallet.BasePayPluginLogic", 2, "TenpayResultReceiver.onReceiveResult mActivity == null || mActivity.mPayBundle == null");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3, String str, int i16, String str2) {
        Bundle bundle = new Bundle();
        if (this.f41633e == 4) {
            r(str, i16, str2);
            bundle.putInt("payRetCode", i16);
        } else {
            bundle = new Bundle();
            bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, i3);
            bundle.putInt(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
            bundle.putString("callbackSn", str);
            bundle.putInt("payRetCode", i16);
            bundle.putString("result", str2);
        }
        e(bundle);
    }

    private void u(PayResponse payResponse, int i3, String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            payResponse.retMsg = jSONObject.optString("retmsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (i3 == 0 && optJSONObject != null) {
                payResponse.transactionId = optJSONObject.optString(CommonCode.MapKey.TRANSACTION_ID);
                payResponse.payTime = optJSONObject.optString("pay_time");
                payResponse.totalFee = optJSONObject.optString("total_fee");
                payResponse.callbackUrl = optJSONObject.optString("callback_url");
                payResponse.spData = optJSONObject.optString("sp_data");
                String optString = optJSONObject.optString("iswechatpay");
                payResponse.payChannelType = "0";
                if (!TextUtils.isEmpty(optString) && TextUtils.equals("1", optString)) {
                    payResponse.payChannelType = "1";
                }
            }
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("sdk_auth_data");
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() > 0) {
                JSONObject jSONObject2 = new JSONObject(str2);
                payResponse.openId = jSONObject2.optString("openId");
                v(jSONObject2, i3, payResponse);
            }
        } catch (JSONException unused) {
            QLog.w("Q.qwallet.BasePayPluginLogic", 1, "doOpenAppCashPayResult error:" + str);
        }
    }

    private void v(JSONObject jSONObject, int i3, PayResponse payResponse) {
        int optInt = jSONObject.optInt("ret");
        String optString = jSONObject.optString("errMsg");
        if (i3 != 0 && optInt != 0) {
            payResponse.retCode = -1012;
            payResponse.retMsg = optString;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x021c A[Catch: all -> 0x0206, TryCatch #1 {all -> 0x0206, blocks: (B:17:0x01ee, B:20:0x01f5, B:23:0x01fb, B:24:0x0216, B:26:0x021c, B:27:0x0222, B:29:0x0228, B:30:0x022e, B:40:0x0213), top: B:16:0x01ee }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0228 A[Catch: all -> 0x0206, TryCatch #1 {all -> 0x0206, blocks: (B:17:0x01ee, B:20:0x01f5, B:23:0x01fb, B:24:0x0216, B:26:0x021c, B:27:0x0222, B:29:0x0228, B:30:0x022e, B:40:0x0213), top: B:16:0x01ee }] */
    @Override // com.qwallet.pay.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(Context context) {
        int i3;
        String str;
        int i16;
        String str2;
        String str3;
        String str4;
        int i17;
        String str5;
        String str6;
        int i18;
        String str7;
        JSONObject jSONObject;
        String str8;
        super.g(context);
        n();
        String string = this.f41632d.getString("tokenId");
        String string2 = this.f41632d.getString("userId");
        String string3 = this.f41632d.getString("userName");
        int i19 = this.f41632d.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM);
        String string4 = this.f41632d.getString("appInfo");
        boolean z16 = this.f41632d.getBoolean("h5_success", false);
        String string5 = this.f41632d.getString("extra_data");
        String string6 = this.f41632d.getString("buttonTips");
        int i26 = this.f41632d.getInt("sdkChannel");
        String string7 = this.f41632d.getString("sdkData");
        int i27 = this.f41632d.getInt("pay_by", -1);
        int i28 = this.f41632d.getInt("bank_index");
        String string8 = this.f41632d.getString("bank_type");
        QWalletUtils.f41784c = string4;
        t.a().c(this.f41633e, string4, false);
        Bundle bundle = new Bundle();
        if (this.f41632d.getBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, false)) {
            i3 = i28;
            String string9 = this.f41632d.getString("noskey_json");
            str = "pay_by";
            if (string9 != null) {
                i16 = i27;
                try {
                    str8 = new JSONObject(string9).optString("uin");
                } catch (Exception e16) {
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                }
                bundle.putString("extra_data", this.f41632d.getString("noskey_json"));
                str3 = str8;
                str2 = "";
            } else {
                i16 = i27;
            }
            str8 = string2;
            bundle.putString("extra_data", this.f41632d.getString("noskey_json"));
            str3 = str8;
            str2 = "";
        } else {
            i3 = i28;
            str = "pay_by";
            i16 = i27;
            bundle.putString("extra_data", string5);
            str2 = string3;
            str3 = string2;
        }
        bundle.putString("token_id", string);
        bundle.putString("uin", str3);
        bundle.putString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, str2);
        bundle.putInt("come_from", i19);
        bundle.putString(com.tencent.mobileqq.msf.core.c0.j.T0, string4);
        bundle.putBoolean("h5_success", z16);
        bundle.putString("back_button_text", string6);
        bundle.putInt("iPayFrom", this.f41633e);
        bundle.putInt(str, i16);
        bundle.putInt("bank_index", i3);
        bundle.putString("bank_type", string8);
        if (i26 > 0) {
            i17 = i26;
            bundle.putInt("sdk_channel", i17);
            str4 = string7;
            bundle.putString("sdk_data", str4);
        } else {
            str4 = string7;
            i17 = i26;
        }
        String b16 = com.tencent.mobileqq.base.b.b();
        bundle.putString("appid", b16);
        bundle.putByteArray("guid", com.tencent.mobileqq.base.b.c());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("&ti=");
        sb5.append(string);
        sb5.append("&ui=");
        sb5.append(str3);
        sb5.append("&un=");
        sb5.append(str2);
        sb5.append("&cf=");
        sb5.append(i19);
        sb5.append("&ai=");
        sb5.append(string4);
        sb5.append("&ish5=");
        sb5.append(z16);
        sb5.append("&qqai=");
        sb5.append(b16);
        sb5.append("&qqagi=");
        sb5.append(com.tencent.mobileqq.base.b.d());
        sb5.append("&sc=");
        sb5.append(i17);
        sb5.append("&sd=");
        sb5.append(str4);
        if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.BasePayPluginLogic", 2, "doPay payBundle:" + ((Object) sb5));
        }
        s(context, bundle);
        String str9 = null;
        try {
            try {
                jSONObject = new JSONObject(string5);
                str6 = "sourceId";
            } catch (JSONException e17) {
                e = e17;
                str5 = RealNameSource.EXTRA_KEY_SOURCE_NAME;
                str6 = "sourceId";
            }
            try {
                str7 = jSONObject.optString(str6);
                str5 = RealNameSource.EXTRA_KEY_SOURCE_NAME;
                try {
                    str9 = jSONObject.optString(str5);
                } catch (JSONException e18) {
                    e = e18;
                    try {
                        QLog.e("Q.qwallet.BasePayPluginLogic", 1, e, new Object[0]);
                        if (TextUtils.isEmpty(str7)) {
                        }
                        if (TextUtils.isEmpty(str9)) {
                        }
                        ((IRealNameSourceReportApi) QRoute.api(IRealNameSourceReportApi.class)).setCurrentNameSource(new RealNameSource(str7, str9));
                    } catch (Throwable th5) {
                        th = th5;
                        i18 = 0;
                        QLog.e("Q.qwallet.BasePayPluginLogic", 1, th, new Object[i18]);
                    }
                }
            } catch (JSONException e19) {
                e = e19;
                str5 = RealNameSource.EXTRA_KEY_SOURCE_NAME;
                str7 = null;
                QLog.e("Q.qwallet.BasePayPluginLogic", 1, e, new Object[0]);
                if (TextUtils.isEmpty(str7)) {
                }
                if (TextUtils.isEmpty(str9)) {
                }
                ((IRealNameSourceReportApi) QRoute.api(IRealNameSourceReportApi.class)).setCurrentNameSource(new RealNameSource(str7, str9));
            }
            if (TextUtils.isEmpty(str7)) {
                str7 = this.f41632d.getString(str6);
            }
            if (TextUtils.isEmpty(str9)) {
                str9 = this.f41632d.getString(str5);
            }
            ((IRealNameSourceReportApi) QRoute.api(IRealNameSourceReportApi.class)).setCurrentNameSource(new RealNameSource(str7, str9));
        } catch (Throwable th6) {
            th = th6;
            i18 = 0;
            QLog.e("Q.qwallet.BasePayPluginLogic", 1, th, new Object[i18]);
        }
    }

    @Override // com.qwallet.pay.a
    protected boolean j() {
        return false;
    }
}
