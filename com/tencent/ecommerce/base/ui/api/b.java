package com.tencent.ecommerce.base.ui.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\f\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0016JC\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00060\u0014j\u0002`\u0018H\u0016Jm\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122Q\u0010\u0019\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00060\u001bj\u0002`\u001eH\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/base/ui/api/b;", "Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "Landroid/content/Context;", "context", "", "b", "", "loadResource", "Landroid/view/LayoutInflater$Factory2;", "getSkinFactory2", "", "resId", "getColor", "", "token", "(Ljava/lang/String;)Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "getDrawable", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "drawable", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "a", "Lkotlin/Function3;", "errorCode", "errorMsg", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "getDrawableWithFetchCallback", "getUrl", "Lkotlin/NotImplementedError;", "Lkotlin/NotImplementedError;", "notImplementError", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b implements IECSkinApi {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f101143b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final NotImplementedError notImplementError = new NotImplementedError("IECSkinApi \u4e3a\u5fc5\u8981\u63a5\u53e3\uff0c\u8bf7\u7b2c\u4e09\u65b9\u5bbf\u4e3b\u5b9e\u73b0\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528\u3002\u6ce8\u610f\u662f\u5426\u5728\u5de5\u7a0b\u4e2d\u4f7f\u7528 ECSkin \u7684\u65b9\u5f0f\u83b7\u53d6 IECSkinApi, \u8bf7\u52ff\u76f4\u63a5\u4f7f\u7528 QQEcommerceSdk.globalInternalSdk.skinApi \u7684\u65b9\u5f0f\u83b7\u53d6\u3002");

    b() {
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void getDrawable(@NotNull String token, @Nullable IECImageLoader.ImageLoaderOption option, @NotNull Function1<? super Drawable, Unit> callback) {
        throw notImplementError;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void init(@NotNull Context context) {
        throw notImplementError;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public int getColor(int resId) {
        throw notImplementError;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public void getDrawableWithFetchCallback(@NotNull String token, @Nullable IECImageLoader.ImageLoaderOption option, @NotNull Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    @NotNull
    public LayoutInflater.Factory2 getSkinFactory2() {
        throw notImplementError;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    @NotNull
    public String getUrl(@NotNull String token) {
        throw notImplementError;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    public void loadResource() {
        throw notImplementError;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    @NotNull
    public Integer getColor(@NotNull String token) {
        throw notImplementError;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    @NotNull
    public Drawable getDrawable(int resId) {
        throw notImplementError;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    @NotNull
    public Drawable getDrawable(@NotNull String token) {
        throw notImplementError;
    }
}
