package com.qwallet.pay;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tenpay.QwLog;
import com.tenpay.sdk.SDKCallbackManager;
import com.tenpay.sdk.activity.ConfirmTransactionActivity;
import com.tenpay.sdk.activity.PayActivity;
import com.tenpay.sdk.apilogic.ApiUtil;
import com.tenpay.sdk.helper.PayHelper;
import cooperation.qwallet.open.data.PayInfo;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import z05.OpenPayResult;
import z05.RspDataV1;
import z05.RspDataV2;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001 B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/qwallet/pay/LogicOpenPay;", "Lcom/qwallet/pay/a;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "payBundle", "Lcooperation/qwallet/open/data/PayInfo;", "payInfo", "", "r", "bundle", "Landroid/os/ResultReceiver;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "nInvokerId", "Lz05/b;", "result", ReportConstant.COSTREPORT_PREFIX, "", "j", "g", "k", "Lcooperation/qwallet/open/data/PayInfo;", "p", "()Lcooperation/qwallet/open/data/PayInfo;", "t", "(Lcooperation/qwallet/open/data/PayInfo;)V", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Context;Landroid/content/Intent;)V", "OpenPayResultReceiver", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class LogicOpenPay extends a {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public PayInfo payInfo;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/qwallet/pay/LogicOpenPay$OpenPayResultReceiver;", "Landroid/os/ResultReceiver;", "", "errorCode", "b", "Lcooperation/qwallet/open/data/PayInfo;", "payInfo", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "resultData", "payType", "Lz05/b;", "a", "", "onReceiveResult", "Ljava/lang/ref/SoftReference;", "Lcom/qwallet/pay/LogicOpenPay;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/SoftReference;", "logicRef", "logic", "Landroid/os/Handler;", "handler", "<init>", "(Lcom/qwallet/pay/LogicOpenPay;Landroid/os/Handler;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class OpenPayResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SoftReference<LogicOpenPay> logicRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenPayResultReceiver(@NotNull LogicOpenPay logic, @NotNull Handler handler) {
            super(handler);
            Intrinsics.checkNotNullParameter(logic, "logic");
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.logicRef = new SoftReference<>(logic);
        }

        private final OpenPayResult a(PayInfo payInfo, int resultCode, Bundle resultData, int payType) throws JSONException {
            String str;
            boolean z16;
            String str2;
            z05.c cVar = null;
            if (resultData != null) {
                str = resultData.getString("retmsg");
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (payInfo.o()) {
                    cVar = (z05.c) new GsonBuilder().create().fromJson(str, RspDataV2.class);
                } else {
                    cVar = (z05.c) new GsonBuilder().create().fromJson(str, RspDataV1.class);
                }
            }
            if (resultCode == 0) {
                str2 = "success";
            } else if (cVar instanceof RspDataV1) {
                str2 = ((RspDataV1) cVar).getErrorMsg();
            } else if (cVar instanceof RspDataV2) {
                str2 = ((RspDataV2) cVar).getErrorMsg();
            } else if (resultData == null || (str2 = resultData.getString("err_msg")) == null) {
                str2 = "";
            }
            String str3 = str2;
            if (payType != 4 && resultCode != 0) {
                return new OpenPayResult(Integer.valueOf(resultCode), str3, null, 4, null);
            }
            return new OpenPayResult(Integer.valueOf(resultCode), str3, cVar);
        }

        private final int b(int errorCode) {
            if (errorCode == -4 || errorCode == -3 || errorCode == -2) {
                return -1;
            }
            if (errorCode == -1) {
                return -11001;
            }
            return errorCode;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
            Bundle bundle;
            QwLog.i("TenpayResultReceiver.onReceiveResult resultCode:" + resultCode + " resultData:" + resultData);
            LogicOpenPay logicOpenPay = this.logicRef.get();
            if (logicOpenPay != null) {
                bundle = logicOpenPay.f41632d;
            } else {
                bundle = null;
            }
            if (bundle == null) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 1, "TenpayResultReceiver.onReceiveResult mActivity == null || mActivity.mPayBundle == null");
                return;
            }
            switch (resultCode) {
                case 99998:
                case 99999:
                    return;
                default:
                    int b16 = b(resultCode);
                    PayInfo p16 = logicOpenPay.p();
                    int i3 = logicOpenPay.f41632d.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
                    if (resultData == null) {
                        logicOpenPay.s(i3, p16, new OpenPayResult(Integer.valueOf(b16), "pay resultData is null", null, 4, null));
                        QLog.e("Q.qwallet.BasePayPluginLogic", 1, "TenpayResultReceiver.onReceiveResult resultData == null");
                        return;
                    }
                    String string = resultData.getString("retmsg");
                    if (string == null) {
                        logicOpenPay.s(i3, p16, new OpenPayResult(Integer.valueOf(b16), "pay retmsg is null", null, 4, null));
                        return;
                    }
                    try {
                        logicOpenPay.s(i3, p16, a(p16, b16, resultData, p16.getBase().getPayType()));
                        return;
                    } catch (Exception unused) {
                        QLog.w("Q.qwallet.BasePayPluginLogic", 1, "tenpay result json exception:" + string);
                        logicOpenPay.s(i3, p16, new OpenPayResult(Integer.valueOf(b16), "pay result json exception", null, 4, null));
                        return;
                    }
            }
        }
    }

    public LogicOpenPay(@Nullable Context context, @Nullable Intent intent) {
        super(context, intent);
        n();
    }

    private final void q(Context context, Bundle bundle, PayInfo payInfo, ResultReceiver callback) {
        Class cls;
        QwLog.i("gotoPay..." + bundle + " " + payInfo);
        String prepayId = payInfo.getPrepayId();
        String c16 = com.tencent.mobileqq.base.a.c();
        if ((payInfo.getBase().getPayFrom() == 4 && TextUtils.isEmpty(prepayId)) || TextUtils.isEmpty(c16)) {
            if (callback != null) {
                callback.send(-1, PayHelper.createResultForError(QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR));
            }
            QwLog.i("params error, token_id is " + prepayId + " | uin is " + c16);
            return;
        }
        try {
            ApiUtil.enterSDK(c16);
            Intent intent = new Intent();
            boolean z16 = false;
            if (bundle.getBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, false)) {
                String string = bundle.getString("noskey_json");
                if (string == null || string.length() == 0) {
                    z16 = true;
                }
                if (!z16) {
                    c16 = new JSONObject(string).optString("uin");
                    Intrinsics.checkNotNullExpressionValue(c16, "JSONObject(jsonStr).optString(\"uin\")");
                    intent.putExtra("extra_data", string);
                }
            } else {
                intent.putExtra("extra_data", bundle.getString("extra_data"));
            }
            intent.putExtra("uin", c16);
            intent.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, com.tencent.mobileqq.base.a.b());
            intent.putExtra("prossesId", System.currentTimeMillis());
            intent.putExtra("h5_success", bundle.getBoolean("h5_success"));
            intent.putExtra(SDKCallbackManager.SESSION_RECEIVER, callback);
            intent.putExtra(PayInfo.class.getName(), payInfo);
            int i3 = bundle.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM);
            intent.putExtra("come_from", i3);
            intent.putExtra("sdk_channel", bundle.getInt("sdkChannel"));
            if (i3 != 3 && i3 != 4) {
                cls = PayActivity.class;
            } else {
                cls = ConfirmTransactionActivity.class;
            }
            Class cls2 = cls;
            if (context instanceof Service) {
                intent.addFlags(268435456);
            }
            com.tencent.mobileqq.base.c.f(context, intent, cls2, false, 8, null);
        } catch (Throwable th5) {
            QwLog.e(th5.getMessage());
            if (callback != null) {
                callback.send(-1, PayHelper.createResultForError(QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR));
            }
        }
    }

    private final void r(Context context, Bundle payBundle, PayInfo payInfo) {
        q(context, payBundle, payInfo, new OpenPayResultReceiver(this, new Handler(Looper.getMainLooper())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(int nInvokerId, PayInfo payInfo, OpenPayResult result) {
        int i3;
        QLog.i("Q.qwallet.BasePayPluginLogic", 1, "onPayResult: payType=" + this.f41633e + " result=" + result);
        Bundle bundle = new Bundle();
        Integer resultCode = result.getResultCode();
        if (resultCode != null) {
            i3 = resultCode.intValue();
        } else {
            i3 = -11001;
        }
        bundle.putInt("payRetCode", i3);
        if (this.f41633e == 4) {
            z05.a.c(null, payInfo, result);
        } else {
            bundle = new Bundle();
            bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, nInvokerId);
            bundle.putInt(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
            bundle.putString("callbackSn", payInfo.getTransaction());
            bundle.putString("result", new GsonBuilder().create().toJson(result));
        }
        e(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qwallet.pay.a
    public void g(@Nullable Context context) {
        PayInfo payInfo;
        super.g(context);
        n();
        if (context == null) {
            return;
        }
        Parcelable parcelable = this.f41632d.getParcelable(PayInfo.class.getName());
        if (parcelable instanceof PayInfo) {
            payInfo = (PayInfo) parcelable;
        } else {
            payInfo = null;
        }
        if (payInfo == null) {
            QLog.w("Q.qwallet.BasePayPluginLogic", 1, "doPay payInfo is null");
            return;
        }
        t(payInfo);
        t.a().c(this.f41633e, null, false);
        Bundle mPayBundle = this.f41632d;
        Intrinsics.checkNotNullExpressionValue(mPayBundle, "mPayBundle");
        r(context, mPayBundle, p());
    }

    @Override // com.qwallet.pay.a
    protected boolean j() {
        return false;
    }

    @NotNull
    public final PayInfo p() {
        PayInfo payInfo = this.payInfo;
        if (payInfo != null) {
            return payInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("payInfo");
        return null;
    }

    public final void t(@NotNull PayInfo payInfo) {
        Intrinsics.checkNotNullParameter(payInfo, "<set-?>");
        this.payInfo = payInfo;
    }
}
