package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.app.Activity;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/e;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "jsCallback", "", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e extends QWInvokeHandler.c {
    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.b
    public void a(@NotNull WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Activity a16 = plugin.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            k.h(a16, jsonData.optString("url"));
        } else {
            QLog.w("QWalletFullWebViewProcessor", 1, "error, activity is finishing");
        }
    }
}
