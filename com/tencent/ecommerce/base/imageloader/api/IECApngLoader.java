package com.tencent.ecommerce.base.imageloader.api;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader;", "", "", "url", "Landroid/graphics/drawable/Drawable;", "getAnimDrawable", "src", "Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader$a;", "option", "filePath", "getApngDrawable", "a", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECApngLoader {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader$a;", "", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final /* data */ class a {
    }

    @Nullable
    Drawable getAnimDrawable(@NotNull String url);

    @Nullable
    Drawable getApngDrawable(@NotNull String src, @NotNull a option, @NotNull String filePath);
}
