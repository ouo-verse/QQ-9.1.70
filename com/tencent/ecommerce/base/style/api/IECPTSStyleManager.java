package com.tencent.ecommerce.base.style.api;

import android.content.Context;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/style/api/IECPTSStyleManager;", "", "preloadStyle", "", "context", "Landroid/content/Context;", IECSearchBar.METHOD_UPDATE_STYLE, "pageName", "", "frameTreeJson", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECPTSStyleManager {
    void preloadStyle(@Nullable Context context);

    void updateStyle(@NotNull String pageName, @NotNull String frameTreeJson);
}
