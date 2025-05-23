package com.tencent.mobileqq.qwallet.jsp;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/c;", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "", "args", "jsCallback", "", "a", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c extends QWalletJsPlugin.b {
    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.c
    public void a(@NotNull WebViewPlugin plugin, @Nullable JSONObject jsonData, @NotNull String[] args, @Nullable String jsCallback) {
        Activity activity;
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(args, "args");
        if (QLog.isColorLevel()) {
            QLog.i("GetPayAdInfoHandler", 2, "prosGetPayAdInfo...");
        }
        WebViewPlugin.b bVar = plugin.mRuntime;
        x05.a aVar = null;
        if (bVar != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        if (bVar != null) {
            appInterface = bVar.b();
        } else {
            appInterface = null;
        }
        if (appInterface instanceof x05.a) {
            aVar = (x05.a) appInterface;
        }
        if (aVar == null) {
            QLog.i("GetPayAdInfoHandler", 2, "activity error : " + activity);
            return;
        }
        int c16 = aVar.c(activity);
        QLog.i("GetPayAdInfoHandler", 2, "bzCode = " + c16);
        if (1 != c16) {
            return;
        }
        Bundle b16 = aVar.b(activity);
        if (b16 == null) {
            QLog.i("GetPayAdInfoHandler", 2, "error bundle is null...");
            return;
        }
        String string = b16.getString("paySuccJsonData");
        int i3 = b16.getInt("ScreenHeight");
        int i16 = b16.getInt("PayHeight");
        int i17 = b16.getInt("ADHeight");
        QLog.i("GetPayAdInfoHandler", 2, "data = " + string + " sh = " + i3 + " ph = " + i16 + " ah = " + i17);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ScreenHeight", i3);
            jSONObject2.put("PayHeight", i16);
            jSONObject2.put("ADHeight", i17);
            jSONObject.put("display", jSONObject2);
            jSONObject.put("paySuccJsonData", string);
            QLog.i("GetPayAdInfoHandler", 2, jsCallback + " => " + jSONObject);
            plugin.callJs(jsCallback, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.w("GetPayAdInfoHandler", 1, "GetPayAdInfoHandler error", e16);
        }
    }
}
