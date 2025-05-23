package cooperation.qwallet.open.api.impl;

import android.app.Activity;
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
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.base.c;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.openpay.data.pay.PayResponse;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.qwallet.i;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tenpay.api.TenpayInterface;
import com.tenpay.sdk.activity.ConfirmTransactionActivity;
import com.tenpay.sdk.apilogic.ApiGotoview;
import cooperation.qwallet.open.api.IOpenPayApi;
import cooperation.qwallet.open.data.PayInfo;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import z05.OpenPayResult;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u00042\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J$\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J*\u0010\u001b\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a8\u0006 "}, d2 = {"Lcooperation/qwallet/open/api/impl/OpenPayApiImpl;", "Lcooperation/qwallet/open/api/IOpenPayApi;", "Landroid/os/Bundle;", "outBundle", "Landroid/content/Intent;", "inIntent", "", "fixMidasSdkSkeyType", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "intent", "", "launchCompatOpenPay", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "fragmentClass", "launchQWalletFragment", "getConfirmTransactionClazz", "", "retCode", "", "retMsg", "serialNumber", "parseResponseFromJson", "Lcooperation/qwallet/open/data/PayInfo;", "payInfo", "callbackOpenPayResult", "<init>", "()V", "Companion", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class OpenPayApiImpl implements IOpenPayApi {

    @NotNull
    private static final String TAG = "Q.qwallet.payOpenPayApiImpl";

    private final void fixMidasSdkSkeyType(Bundle outBundle, Intent inIntent) {
        boolean startsWith$default;
        String stringExtra = inIntent.getStringExtra("_mqqpay_payapi_sessionType");
        String stringExtra2 = inIntent.getStringExtra("_mqqpay_payapi_skey_type");
        boolean z16 = false;
        if (stringExtra != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(stringExtra, "pskey", false, 2, null);
            if (startsWith$default) {
                z16 = true;
            }
        }
        if (z16 && !Intrinsics.areEqual(stringExtra2, "2")) {
            outBundle.putString("skey_type", "2");
        } else if (Intrinsics.areEqual(stringExtra, "st_local_third_party") && !Intrinsics.areEqual(stringExtra2, "2")) {
            outBundle.putString("skey_type", "2");
            outBundle.putString("uin", a.c());
        }
    }

    @Override // cooperation.qwallet.open.api.IOpenPayApi
    public void callbackOpenPayResult(@Nullable Context context, @NotNull PayInfo payInfo, int retCode, @NotNull String retMsg) {
        Intrinsics.checkNotNullParameter(payInfo, "payInfo");
        Intrinsics.checkNotNullParameter(retMsg, "retMsg");
        z05.a.c(context, payInfo, new OpenPayResult(Integer.valueOf(retCode), retMsg, null, 4, null));
    }

    @Override // cooperation.qwallet.open.api.IOpenPayApi
    @NotNull
    public Class<?> getConfirmTransactionClazz() {
        return ConfirmTransactionActivity.class;
    }

    @Override // cooperation.qwallet.open.api.IOpenPayApi
    public boolean launchCompatOpenPay(@Nullable Activity activity, @Nullable Intent intent) {
        if (activity == null || intent == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("skey", intent.getStringExtra("_mqqpay_payapi_skey"));
        bundle.putString("skey_type", intent.getStringExtra("_mqqpay_payapi_skey_type"));
        bundle.putString("token_id", intent.getStringExtra("_mqqpay_payapi_tokenid"));
        bundle.putString("uin", intent.getStringExtra("_mqqpay_payapi_uin"));
        bundle.putString("appid", intent.getStringExtra("_mqqpay_baseapi_appid"));
        bundle.putInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 2);
        bundle.putBoolean(ApiGotoview.CALLBACK_WHEN_CANCEL_PAY, true);
        fixMidasSdkSkeyType(bundle, intent);
        final i iVar = new i(activity, IQWalletFeatureApi.QWALLET_OPEN_PAY_ACTIVITY_REFERENCE, false, 4, null);
        final String stringExtra = intent.getStringExtra("_mqqpay_payapi_callbackscheme");
        final String stringExtra2 = intent.getStringExtra("_mqqpay_payapi_packageName");
        final Handler handler = new Handler(Looper.getMainLooper());
        ResultReceiver resultReceiver = new ResultReceiver(handler) { // from class: cooperation.qwallet.open.api.impl.OpenPayApiImpl$launchCompatOpenPay$resultReceiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                String str;
                String str2;
                JSONObject jSONObject;
                super.onReceiveResult(resultCode, resultData);
                Activity b16 = iVar.b();
                if (b16 == null) {
                    QLog.d("Q.qwallet.payOpenPayApiImpl", 1, "onReceiveResult: activity reference is NULL");
                    return;
                }
                switch (resultCode) {
                    case 99998:
                    case 99999:
                        return;
                    default:
                        if (resultData == null || (str = resultData.getString("retmsg")) == null) {
                            str = "{}";
                        }
                        Bundle bundle2 = new Bundle();
                        PayResponse payResponse = new PayResponse();
                        payResponse.apiMark = 1;
                        payResponse.apiName = OpenConstants.ApiName.PAY;
                        payResponse.retCode = resultCode;
                        payResponse.payChannelType = "0";
                        try {
                            jSONObject = new JSONObject(str);
                            payResponse.transactionId = jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID);
                            payResponse.payTime = jSONObject.optString("pay_time");
                            payResponse.spData = jSONObject.optString("sp_data");
                            payResponse.callbackUrl = jSONObject.optString("callback_url");
                            payResponse.totalFee = jSONObject.optString("total_fee");
                        } catch (Exception e16) {
                            QLog.e("Q.qwallet.payOpenPayApiImpl", 1, "launchCompatOpenPay: ", e16);
                        }
                        if (resultCode != 0) {
                            str2 = jSONObject.optString("err_msg", "error");
                            Intrinsics.checkNotNullExpressionValue(str2, "retObj.optString(\"err_msg\", \"error\")");
                            payResponse.retMsg = str2;
                            payResponse.toBundle(bundle2);
                            Intent intent2 = new Intent();
                            String str3 = stringExtra;
                            String str4 = stringExtra2;
                            intent2.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                            intent2.setData(Uri.parse(str3 + "://open_pay/pay"));
                            intent2.setPackage(str4);
                            intent2.addFlags(268435456);
                            intent2.putExtras(bundle2);
                            intent2.putExtra(OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_KEY, OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_TAG);
                            b16.startActivity(intent2);
                            b16.finish();
                            iVar.a();
                            return;
                        }
                        str2 = "success";
                        payResponse.retMsg = str2;
                        payResponse.toBundle(bundle2);
                        Intent intent22 = new Intent();
                        String str32 = stringExtra;
                        String str42 = stringExtra2;
                        intent22.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                        intent22.setData(Uri.parse(str32 + "://open_pay/pay"));
                        intent22.setPackage(str42);
                        intent22.addFlags(268435456);
                        intent22.putExtras(bundle2);
                        intent22.putExtra(OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_KEY, OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_TAG);
                        b16.startActivity(intent22);
                        b16.finish();
                        iVar.a();
                        return;
                }
            }
        };
        try {
            QLog.i(TAG, 1, "gotoPay: " + bundle);
            TenpayInterface.gotoPay(activity, bundle, resultReceiver);
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "launchCompatOpenPay: ", e16);
            return false;
        }
    }

    @Override // cooperation.qwallet.open.api.IOpenPayApi
    public void launchQWalletFragment(@Nullable Context context, @NotNull Intent intent, @NotNull Class<?> fragmentClass) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        c.f(context, intent, fragmentClass, false, 8, null);
    }

    @Override // cooperation.qwallet.open.api.IOpenPayApi
    @NotNull
    public String parseResponseFromJson(int retCode, @Nullable String retMsg, @Nullable String serialNumber) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", OpenConstants.ApiName.PAY);
            jSONObject2.put(IECDtReport.ACTION_IDENTIFIER, serialNumber);
            jSONObject.put("action", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("code", retCode);
            jSONObject3.put("message", retMsg);
            jSONObject.put("params", jSONObject3);
            String jSONObject4 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject4, "JSONObject().apply {\n   \u2026\n            }.toString()");
            if (!TextUtils.isEmpty(jSONObject4)) {
                try {
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = jSONObject4.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    byte[] d16 = com.tencent.mobileqq.util.i.d(bytes, 0);
                    Intrinsics.checkNotNullExpressionValue(d16, "encode(root.toByteArray(), Baze64.DEFAULT)");
                    return new String(d16, charset);
                } catch (Exception e16) {
                    QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                }
            }
        } catch (JSONException e17) {
            QLog.e(TAG, 1, "parseResponseFromJson error: ", e17);
        }
        return "";
    }
}
