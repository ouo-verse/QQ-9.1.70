package com.tencent.mobileqq.qwallet.jsp;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.qwallet.pet.fragment.HalfWebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/e;", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "", "args", "jsCallback", "", "a", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "b", "Ljava/lang/String;", "currentCallbackId", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e extends QWalletJsPlugin.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentCallbackId;

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.c
    public void a(@NotNull WebViewPlugin plugin, @Nullable JSONObject jsonData, @NotNull String[] args, @Nullable String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(args, "args");
        this.currentCallbackId = jsCallback;
        Activity a16 = plugin.mRuntime.a();
        if (a16 != null && !a16.isFinishing() && jsonData != null) {
            String url = jsonData.optString("url");
            String merchantLogo = jsonData.optString("merchantLogo");
            String merchantTitle = jsonData.optString("merchantTitle");
            int optInt = jsonData.optInt("heightPercentage", 88);
            int optInt2 = jsonData.optInt("opacity", 50);
            HalfWebViewFragment.Companion companion = HalfWebViewFragment.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(url, "url");
            Intrinsics.checkNotNullExpressionValue(merchantLogo, "merchantLogo");
            Intrinsics.checkNotNullExpressionValue(merchantTitle, "merchantTitle");
            companion.d(plugin, url, merchantLogo, merchantTitle, optInt, optInt2, 1001);
            return;
        }
        QLog.w("OpenCustomWebViewHandler", 1, "error, activity is finishing or jsonData is null");
        this.currentCallbackId = null;
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.b
    public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        super.b(plugin, intent, requestCode, resultCode);
        if (requestCode == -23 && resultCode == -1) {
            String str3 = null;
            if (intent != null) {
                str = intent.getStringExtra("last_url");
            } else {
                str = null;
            }
            if (intent != null) {
                str3 = intent.getStringExtra("last_url_title");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", -100);
            jSONObject.put("retMsg", "cancel");
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            jSONObject.put("currentUrl", str2);
            QLog.d("OpenCustomWebViewHandler", 2, "calljs lastTitle=" + str3 + " lastUrl=" + str);
            plugin.callJs(this.currentCallbackId, jSONObject.toString());
        }
    }
}
