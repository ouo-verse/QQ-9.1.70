package com.tencent.ecommerce.base.ui.api;

import android.graphics.drawable.Drawable;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u0004\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005H&JE\u0010\t\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011H&Jo\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2Q\u0010\u0012\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0013j\u0002`\u0016H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/base/ui/api/IECCoreSkinApi;", "", "", "resId", "getColor", "", "token", "(Ljava/lang/String;)Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "getDrawable", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "drawable", "", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "Lkotlin/Function3;", "errorCode", "errorMsg", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "getDrawableWithFetchCallback", "getUrl", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECCoreSkinApi {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(IECCoreSkinApi iECCoreSkinApi, String str, IECImageLoader.ImageLoaderOption imageLoaderOption, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    imageLoaderOption = null;
                }
                iECCoreSkinApi.getDrawable(str, imageLoaderOption, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDrawable");
        }
    }

    int getColor(int resId);

    @Nullable
    Integer getColor(@NotNull String token);

    @Nullable
    Drawable getDrawable(int resId);

    @Nullable
    Drawable getDrawable(@NotNull String token);

    void getDrawable(@NotNull String token, @Nullable IECImageLoader.ImageLoaderOption option, @NotNull Function1<? super Drawable, Unit> callback);

    void getDrawableWithFetchCallback(@NotNull String token, @Nullable IECImageLoader.ImageLoaderOption option, @NotNull Function3<? super Drawable, ? super Integer, ? super String, Unit> callback);

    @Nullable
    String getUrl(@NotNull String token);
}
