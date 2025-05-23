package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.content.Intent;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/h;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "jsCallback", "", "a", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "b", "Lcom/tencent/mobileqq/qwallet/jsp/i;", "Lcom/tencent/mobileqq/qwallet/jsp/i;", "logic", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h extends QWInvokeHandler.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qwallet.jsp.i logic = new com.tencent.mobileqq.qwallet.jsp.i();

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.b
    public void a(@NotNull WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        this.logic.a(plugin, jsonData, jsCallback);
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.c
    public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        super.b(plugin, intent, requestCode, resultCode);
        this.logic.b(plugin, intent, requestCode);
    }
}
