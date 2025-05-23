package com.tencent.mobileqq.qwallet.jsp;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/d;", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "", "args", "jsCallback", "", "a", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends QWalletJsPlugin.b {
    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.c
    public void a(@NotNull WebViewPlugin plugin, @Nullable JSONObject jsonData, @NotNull String[] args, @Nullable String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(args, "args");
        Activity a16 = plugin.mRuntime.a();
        int h16 = x.h(a16, ImmersiveUtils.getStatusBarHeight(a16));
        int h17 = x.h(a16, a16.getResources().getDimension(R.dimen.title_bar_height));
        QLog.i("QWallet.Pet.GetTopBarInfo", 1, "statusHeight=" + h16 + ", naviHeight=" + h17);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("statusHeight", h16);
        jSONObject.put("naviHeight", h17);
        Unit unit = Unit.INSTANCE;
        plugin.callJs(jsCallback, jSONObject.toString());
    }
}
