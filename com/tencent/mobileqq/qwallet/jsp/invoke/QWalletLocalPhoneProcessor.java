package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.app.Activity;
import com.qwallet.localphone.QWalletLocalPhoneModule;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.qwallet.pb.QWalletLocalPhone$GetMobileGWPhoneRsp;
import com.tencent.mobileqq.qwallet.pb.QWalletLocalPhone$SimpleContract;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWalletLocalPhoneProcessor;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletLocalPhone$GetMobileGWPhoneRsp;", "Lorg/json/JSONObject;", "f", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "jsonData", "", "jsCallback", "", "a", "c", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "qJob", "<init>", "()V", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletLocalPhoneProcessor extends QWInvokeHandler.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b qJob;

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject f(QWalletLocalPhone$GetMobileGWPhoneRsp qWalletLocalPhone$GetMobileGWPhoneRsp) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ServiceConst.PARA_SESSION_ID, qWalletLocalPhone$GetMobileGWPhoneRsp.session_id.get());
        jSONObject.put("phone_token", qWalletLocalPhone$GetMobileGWPhoneRsp.phone_token.get());
        JSONArray jSONArray = new JSONArray();
        List<QWalletLocalPhone$SimpleContract> list = qWalletLocalPhone$GetMobileGWPhoneRsp.mask_phone.contract.get();
        Intrinsics.checkNotNullExpressionValue(list, "mask_phone.contract.get()");
        for (QWalletLocalPhone$SimpleContract qWalletLocalPhone$SimpleContract : list) {
            jSONArray.mo162put(new JSONObject().put("name", qWalletLocalPhone$SimpleContract.name.get()).put("url", qWalletLocalPhone$SimpleContract.url.get()));
        }
        jSONObject.put("mask_phone", new JSONObject().put("mask", qWalletLocalPhone$GetMobileGWPhoneRsp.mask_phone.mask.get()).put("contract", jSONArray));
        jSONObject.put("plain_phone", new JSONObject().put("plain", qWalletLocalPhone$GetMobileGWPhoneRsp.plain_phone.plain.get()));
        jSONObject.put("ext_info", qWalletLocalPhone$GetMobileGWPhoneRsp.ext_info.get());
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.b
    public void a(@NotNull final WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable final String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Activity a16 = plugin.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            long optLong = jsonData.optLong("appId");
            String sign = jsonData.optString("sign");
            String sessionId = jsonData.optString("sessionId");
            QWalletLocalPhoneModule qWalletLocalPhoneModule = QWalletLocalPhoneModule.f41592a;
            Intrinsics.checkNotNullExpressionValue(sign, "sign");
            Intrinsics.checkNotNullExpressionValue(sessionId, "sessionId");
            this.qJob = qWalletLocalPhoneModule.i(optLong, sign, sessionId, new Function3<Integer, QWalletLocalPhone$GetMobileGWPhoneRsp, String, Unit>() { // from class: com.tencent.mobileqq.qwallet.jsp.invoke.QWalletLocalPhoneProcessor$process$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, QWalletLocalPhone$GetMobileGWPhoneRsp qWalletLocalPhone$GetMobileGWPhoneRsp, String str) {
                    invoke(num.intValue(), qWalletLocalPhone$GetMobileGWPhoneRsp, str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @Nullable QWalletLocalPhone$GetMobileGWPhoneRsp qWalletLocalPhone$GetMobileGWPhoneRsp, @Nullable String str) {
                    JSONObject f16;
                    QWalletLocalPhoneProcessor.this.qJob = null;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("retCode", i3);
                    jSONObject.put("retMsg", str);
                    if (qWalletLocalPhone$GetMobileGWPhoneRsp != null) {
                        f16 = QWalletLocalPhoneProcessor.this.f(qWalletLocalPhone$GetMobileGWPhoneRsp);
                        jSONObject.put("result", f16);
                    }
                    plugin.callJs(jsCallback, jSONObject.toString());
                }
            });
            return;
        }
        QLog.w("QWalletLocalPhoneProcessor", 1, "error, activity is finishing");
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.c
    public void c() {
        Job f16;
        super.c();
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.qJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        this.qJob = null;
    }
}
