package com.tencent.biz.richframework.layoutinflater.redirect;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/redirect/ICreateViewRedirectHandler;", "", "needCreateViewInMain", "", "name", "", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface ICreateViewRedirectHandler {
    boolean needCreateViewInMain(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attr);
}
