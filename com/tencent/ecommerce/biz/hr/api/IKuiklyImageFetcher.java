package com.tencent.ecommerce.biz.hr.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jw\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062Q\u0010\u0012\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0002`\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/api/IKuiklyImageFetcher;", "", "Landroid/content/Context;", "context", "", "path", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "Lkotlin/Function3;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "errorCode", "errorMsg", "", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "callback", "fetchDrawable", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IKuiklyImageFetcher {
    void fetchDrawable(@NotNull Context context, @NotNull String path, @Nullable IECImageLoader.ImageLoaderOption option, @NotNull Function3<? super Drawable, ? super Integer, ? super String, Unit> callback);
}
