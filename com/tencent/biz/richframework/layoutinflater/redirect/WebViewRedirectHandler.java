package com.tencent.biz.richframework.layoutinflater.redirect;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.richframework.layoutinflater.PreloadRuntimeException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/redirect/WebViewRedirectHandler;", "Lcom/tencent/biz/richframework/layoutinflater/redirect/ICreateViewRedirectHandler;", "()V", "needCreateViewInMain", "", "name", "", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class WebViewRedirectHandler implements ICreateViewRedirectHandler {
    @Override // com.tencent.biz.richframework.layoutinflater.redirect.ICreateViewRedirectHandler
    public boolean needCreateViewInMain(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attr) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "WebView", false, 2, (Object) null);
        if (!contains$default) {
            return false;
        }
        throw new PreloadRuntimeException("WebView can't create in subThread");
    }
}
