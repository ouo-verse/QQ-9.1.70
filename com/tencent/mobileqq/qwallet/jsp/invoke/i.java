package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\b\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/i;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "retCode", "", "retMsg", "", "d", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Ljava/lang/Integer;Ljava/lang/String;)V", "plugin", "Lorg/json/JSONObject;", "jsonData", "jsCallback", "a", "Ljava/lang/String;", "currentCallbackId", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class i extends QWInvokeHandler.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentCallbackId;

    private final void d(WebViewPlugin webViewPlugin, Integer num, String str) {
        if (this.currentCallbackId == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", num);
        jSONObject.put("msg", str);
        webViewPlugin.callJs(this.currentCallbackId, jSONObject.toString());
        this.currentCallbackId = null;
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.b
    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    public void a(@NotNull WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        this.currentCallbackId = jsCallback;
        Activity a16 = plugin.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            if (com.tencent.mobileqq.qwallet.h5.b.f277185a.b(plugin.mRuntime.e().getUrl())) {
                QLog.i("QWalletJsPlugin.qw.invoke", 1, "checkPreLogin finish: has cookies");
                d(plugin, 0, "callback qpaySilentLogin: has cookies");
                return;
            } else {
                QLog.i("QWalletJsPlugin.qw.invoke", 1, "qpaySilentLogin fail, no cookies");
                d(plugin, -1, "qpaySilentLogin fail, no cookies");
                return;
            }
        }
        QLog.w("QWalletJsPlugin.qw.invoke", 1, "error, activity is finishing");
    }
}
