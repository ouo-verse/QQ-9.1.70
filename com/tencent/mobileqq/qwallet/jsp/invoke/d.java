package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.app.Activity;
import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.face.FaceVerifyErr;
import com.tenpay.face.QWalletFaceProxyFragment;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/d;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "jsCallback", "", "a", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "b", "Ljava/lang/String;", "currentCallbackId", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends QWInvokeHandler.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentCallbackId;

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.b
    public void a(@NotNull WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable String jsCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        this.currentCallbackId = jsCallback;
        FaceVerifyBean faceVerifyBean = new FaceVerifyBean(jsonData.optString("tokenId"), jsonData.optString("channelInfo"), jsonData.optString(WadlProxyConsts.CHANNEL), jsonData.optString("name"), jsonData.optString("idNum"), null, 32, null);
        QLog.i("QWalletJsPlugin.qw.invoke", 1, "handle js faceBean = " + faceVerifyBean);
        Activity a16 = plugin.mRuntime.a();
        if (a16 != null) {
            QWalletFaceProxyFragment.INSTANCE.start(a16, faceVerifyBean, com.tencent.mobileqq.webview.swift.utils.i.f(1, ao.a(plugin)));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletJsPlugin.qw.invoke", 1, "current context is null");
        }
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.c
    public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
        Integer num;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        super.b(plugin, intent, requestCode, resultCode);
        if (requestCode != 1) {
            return;
        }
        String str = null;
        if (intent != null) {
            num = Integer.valueOf(intent.getIntExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_CODE, FaceVerifyErr.ERROR_CANCEL.getRetCode()));
        } else {
            num = null;
        }
        if (intent != null) {
            str = intent.getStringExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_MSG);
        }
        QLog.w("QWalletJsPlugin.qw.invoke", 1, "requestCode=" + ((int) requestCode) + ", resultCode=" + resultCode + ", faceRetCode=" + num + ", faceRetMsg=" + str);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retCode", num);
        jSONObject.put("retMsg", str);
        plugin.callJs(this.currentCallbackId, jSONObject.toString());
    }
}
