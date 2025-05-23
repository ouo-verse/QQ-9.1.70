package com.qwallet.pay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.util.QQToastUtil;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.ConfirmTransactionActivity;
import com.tenpay.sdk.apilogic.ApiUtil;
import com.tenpay.sdk.fakeurl.FakeInfo;
import com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.net.NetSender;
import com.tenpay.sdk.paynet.Net;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0014R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/qwallet/pay/q;", "Lcom/qwallet/pay/a;", "", "u", "", "r", "Landroid/content/Context;", ReportConstant.COSTREPORT_PREFIX, "Lorg/json/JSONObject;", "qpayGateJSON", "t", "j", "context", "g", "Ljava/lang/ref/WeakReference;", "k", "Ljava/lang/ref/WeakReference;", "contextRef", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Context;Landroid/content/Intent;)V", "l", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class q extends a {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Context> contextRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/qwallet/pay/q$b", "Lcom/tenpay/sdk/paynet/Net$NetListener;", "", BrowserPlugin.KEY_REQUEST_URL, "Lorg/json/JSONObject;", "data", "", "onSuccess", "onBlError", "onError", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements Net.NetListener {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qwallet/pay/q$b$a", "Lcom/tenpay/sdk/fakeurl/FakeUrlDialogBuilder$OnClickButtonListener;", "Lcom/tenpay/sdk/fakeurl/FakeInfo;", "fakeInfo", "Lcom/tenpay/sdk/fakeurl/FakeUrlDialogBuilder$BtnIndex;", "index", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "onClickButton", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes3.dex */
        public static final class a implements FakeUrlDialogBuilder.OnClickButtonListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f41671a;

            a(q qVar) {
                this.f41671a = qVar;
            }

            @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
            public boolean onClickButton(@NotNull FakeInfo fakeInfo, @NotNull FakeUrlDialogBuilder.BtnIndex index, @Nullable Uri uri) {
                Intrinsics.checkNotNullParameter(fakeInfo, "fakeInfo");
                Intrinsics.checkNotNullParameter(index, "index");
                this.f41671a.e(new Bundle());
                return false;
            }
        }

        b() {
        }

        @Override // com.tenpay.sdk.paynet.Net.NetListener
        public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
            String string;
            if (data == null) {
                QLog.w("Q.qwallet.BasePayPluginLogic", 1, "onBlError: context is null, early return");
                q.this.e(new Bundle());
                return;
            }
            if (!new QWalletFakeUrlHandler(q.this.s(), com.tencent.mobileqq.base.a.c()).handle(requestUrl, data, new a(q.this))) {
                QLog.w("Q.qwallet.BasePayPluginLogic", 1, "prepareNativePayData fail: " + data);
                FakeInfo parseFrom = FakeInfo.INSTANCE.parseFrom(requestUrl, data);
                if (parseFrom == null || (string = parseFrom.getRetMsg()) == null) {
                    string = q.this.s().getString(R.string.e_t);
                    Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026.qb_tenpay_network_error)");
                }
                QQToastUtil.showQQToast(1, string);
                q.this.e(new Bundle());
            }
        }

        @Override // com.tenpay.sdk.paynet.Net.NetListener
        public void onError(@Nullable String requestUrl, @Nullable JSONObject data) {
            QQToastUtil.showQQToast(1, R.string.e_t);
            q.this.r();
        }

        @Override // com.tenpay.sdk.paynet.Net.NetListener
        public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
            if (data == null) {
                return;
            }
            t.a().c(q.this.f41633e, null, false);
            q.this.t(data);
            q.this.r();
        }
    }

    public q(@Nullable Context context, @Nullable Intent intent) {
        super(context, intent);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        Bundle bundle = new Bundle();
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 25);
        bundle.putInt("payRetCode", 0);
        bundle.putInt(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        e(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context s() {
        Context context;
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context == null) {
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            return sMobileQQ;
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(JSONObject qpayGateJSON) {
        Context s16 = s();
        QwLog.i("gotoPay..." + qpayGateJSON);
        try {
            String c16 = com.tencent.mobileqq.base.a.c();
            ApiUtil.enterSDK(c16);
            Intent intent = new Intent();
            intent.putExtra("uin", c16);
            intent.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, com.tencent.mobileqq.base.a.b());
            intent.putExtra("prossesId", System.currentTimeMillis());
            intent.putExtra("come_from", 11);
            intent.putExtra("sdk_channel", this.f41632d.getInt("sdkChannel"));
            intent.putExtra("token_id", qpayGateJSON.optString("token_id"));
            intent.putExtra("pay_gate", qpayGateJSON.toString());
            if (!(s16 instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.tencent.mobileqq.base.c.f(s16, intent, ConfirmTransactionActivity.class, false, 8, null);
        } catch (Throwable th5) {
            QwLog.e(th5.getMessage());
        }
    }

    private final boolean u() {
        boolean z16;
        Map mapOf;
        Map mutableMap;
        String string = this.f41632d.getString("payparmas_native_url");
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_QRCODE_URL, string);
        Unit unit = Unit.INSTANCE;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uin", com.tencent.mobileqq.base.a.c()), TuplesKt.to("come_from", "11"), TuplesKt.to("route_version", "wx"), TuplesKt.to("pay_auth_info", jSONObject.toString()));
        mutableMap = MapsKt__MapsKt.toMutableMap(mapOf);
        NetSender.with(s(), Cgi.URI_PAY_GATE, mutableMap, com.tencent.mobileqq.base.a.c()).request(new b());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qwallet.pay.a
    public void g(@Nullable Context context) {
        super.g(context);
        n();
        if (context == null) {
            return;
        }
        this.contextRef = new WeakReference<>(context);
        if (u()) {
            return;
        }
        QLog.w("Q.qwallet.BasePayPluginLogic", 1, "doPay payInfo is null");
    }

    @Override // com.qwallet.pay.a
    protected boolean j() {
        return false;
    }
}
