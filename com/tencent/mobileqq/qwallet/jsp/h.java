package com.tencent.mobileqq.qwallet.jsp;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qwallet.authorize.AuthorizeEntryFragment;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/h;", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "", "args", "jsCallback", "", "a", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "b", "Ljava/lang/String;", "currentCallbackId", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h extends QWalletJsPlugin.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentCallbackId;

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.c
    public void a(@NotNull WebViewPlugin plugin, @Nullable JSONObject jsonData, @NotNull String[] args, @Nullable String jsCallback) {
        Activity activity;
        long j3;
        String str;
        String str2;
        int i3;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(args, "args");
        if (QLog.isColorLevel()) {
            QLog.i("QWalletAuthorizeHandler", 2, "QWalletAuthorizeHandler...");
        }
        this.currentCallbackId = jsCallback;
        WebViewPlugin.b bVar = plugin.mRuntime;
        String str3 = null;
        Activity activity2 = null;
        if (bVar != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        if (activity == null) {
            WebViewPlugin.b bVar2 = plugin.mRuntime;
            if (bVar2 != null) {
                activity2 = bVar2.a();
            }
            QLog.i("QWalletAuthorizeHandler", 2, "activity error : activity: " + activity2 + " is null");
            return;
        }
        if (jsonData != null) {
            j3 = jsonData.optLong("appId");
        } else {
            j3 = 0;
        }
        if (jsonData != null) {
            str = jsonData.optString("openId");
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        if (jsonData != null) {
            str2 = jsonData.optString(CommonConstant.KEY_ACCESS_TOKEN);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (jsonData != null) {
            str3 = jsonData.optString("sign");
        }
        if (str3 != null) {
            str4 = str3;
        }
        if (jsonData != null) {
            i3 = jsonData.optInt("isChangeAccount");
        } else {
            i3 = 0;
        }
        Intent intent = new Intent(activity, (Class<?>) QPublicTransFragmentActivity.class);
        intent.putExtra("extra_key_authorize_appid", j3);
        intent.putExtra("extra_key_authorize_openid", str);
        intent.putExtra("extra_key_authorize_access_token", str2);
        intent.putExtra("extra_key_authorize_sign", str4);
        intent.putExtra("extra_key_authorize_change_account", i3);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("public_fragment_class", AuthorizeEntryFragment.class.getName());
        plugin.startActivityForResult(intent, (byte) 100);
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.b
    public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
        String str;
        String stringExtra;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        super.b(plugin, intent, requestCode, resultCode);
        if (requestCode != 100) {
            return;
        }
        int i3 = -1;
        if (intent != null) {
            i3 = intent.getIntExtra("extra_key_result_code", -1);
        }
        String str2 = "";
        if (intent == null || (str = intent.getStringExtra("extra_key_result_msg")) == null) {
            str = "";
        }
        if (intent != null && (stringExtra = intent.getStringExtra("extra_key_result_data")) != null) {
            str2 = stringExtra;
        }
        QLog.d("QWalletAuthorizeHandler", 1, "onCallback: retCode = " + i3 + " retMsg = " + str);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retCode", i3);
        jSONObject.put("retMsg", str);
        jSONObject.put("result", str2);
        plugin.callJs(this.currentCallbackId, jSONObject.toString());
    }
}
