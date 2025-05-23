package com.tencent.mobileqq.guild.nt.share.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.nt.share.api.IWxShareApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/share/api/impl/WxShareApiImpl;", "Lcom/tencent/mobileqq/guild/nt/share/api/IWxShareApi;", "()V", DTConstants.TAG.API, "Lcom/tencent/mobileqq/wxapi/api/IWXShareHelper;", "getApi", "()Lcom/tencent/mobileqq/wxapi/api/IWXShareHelper;", "isWxInstalled", "", "isWxSupportApi", "shareImageToWx", "", "filePath", "", "bmp", "Landroid/graphics/Bitmap;", "scene", "", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class WxShareApiImpl implements IWxShareApi {
    @NotNull
    public final IWXShareHelper getApi() {
        QRouteApi api = QRoute.api(IWXShareHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWXShareHelper::class.java)");
        return (IWXShareHelper) api;
    }

    @Override // com.tencent.mobileqq.guild.nt.share.api.IWxShareApi
    public boolean isWxInstalled() {
        return getApi().isWXInstalled();
    }

    @Override // com.tencent.mobileqq.guild.nt.share.api.IWxShareApi
    public boolean isWxSupportApi() {
        return getApi().isWXsupportApi();
    }

    @Override // com.tencent.mobileqq.guild.nt.share.api.IWxShareApi
    public void shareImageToWx(@Nullable String filePath, @Nullable Bitmap bmp, int scene) {
        getApi().shareImageToWX(filePath, bmp, scene);
    }
}
