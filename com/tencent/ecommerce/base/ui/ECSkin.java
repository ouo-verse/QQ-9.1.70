package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ui.api.IECSkinApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000b\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\fH\u0016JC\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112'\u0010\u0018\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040\u0013j\u0002`\u0017H\u0016Jm\u0010\u001d\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112Q\u0010\u0018\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00040\u0019j\u0002`\u001cH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECSkin;", "Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "Landroid/content/Context;", "context", "", "init", "loadResource", "Landroid/view/LayoutInflater$Factory2;", "getSkinFactory2", "", "resId", "getColor", "", "token", "(Ljava/lang/String;)Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "getDrawable", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "drawable", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "Lkotlin/Function3;", "errorCode", "errorMsg", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "getDrawableWithFetchCallback", "getUrl", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECSkin implements IECSkinApi {
    public static final ECSkin INSTANCE = new ECSkin();

    ECSkin() {
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public int getColor(int resId) {
        IECSkinApi h16;
        h16 = ECSkinKt.h();
        return h16.getColor(resId);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public Drawable getDrawable(int resId) {
        IECSkinApi h16;
        h16 = ECSkinKt.h();
        return h16.getDrawable(resId);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    public LayoutInflater.Factory2 getSkinFactory2() {
        IECSkinApi h16;
        h16 = ECSkinKt.h();
        return h16.getSkinFactory2();
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public String getUrl(String token) {
        IECSkinApi h16;
        h16 = ECSkinKt.h();
        return h16.getUrl(token);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    public void init(Context context) {
        IECSkinApi h16;
        h16 = ECSkinKt.h();
        h16.init(context);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    public void loadResource() {
        IECSkinApi h16;
        h16 = ECSkinKt.h();
        h16.loadResource();
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public Integer getColor(String token) {
        IECSkinApi h16;
        h16 = ECSkinKt.h();
        return h16.getColor(token);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public Drawable getDrawable(String token) {
        IECSkinApi h16;
        h16 = ECSkinKt.h();
        return h16.getDrawable(token);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public void getDrawable(String token, IECImageLoader.ImageLoaderOption option, Function1<? super Drawable, Unit> callback) {
        IECSkinApi h16;
        h16 = ECSkinKt.h();
        h16.getDrawable(token, option, callback);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public void getDrawableWithFetchCallback(String token, IECImageLoader.ImageLoaderOption option, Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
    }
}
