package com.tencent.mobileqq.guild.nt.avatar.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/avatar/api/impl/QQAvatarUtilApiImpl;", "Lcom/tencent/mobileqq/guild/nt/avatar/api/IQQAvatarUtilApi;", "()V", "avatarUtil", "Lcom/tencent/mobileqq/avatar/api/IQQAvatarUtilApi;", "getAvatarUtil", "()Lcom/tencent/mobileqq/avatar/api/IQQAvatarUtilApi;", "getDefaultFaceDrawable", "Landroid/graphics/drawable/Drawable;", "forceCircle", "", "getFaceDrawableByUser", "appInterface", "Lcom/tencent/common/app/AppInterface;", "uin", "", "getUserFaceDrawable", "avatarShape", "", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class QQAvatarUtilApiImpl implements IQQAvatarUtilApi {
    private final com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi getAvatarUtil() {
        QRouteApi api = QRoute.api(com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQAvatarUtilApi::class.java)");
        return (com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi) api;
    }

    @Override // com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi
    @NotNull
    public Drawable getDefaultFaceDrawable(boolean forceCircle) {
        Drawable defaultFaceDrawable = getAvatarUtil().getDefaultFaceDrawable(forceCircle);
        Intrinsics.checkNotNullExpressionValue(defaultFaceDrawable, "avatarUtil.getDefaultFaceDrawable(forceCircle)");
        return defaultFaceDrawable;
    }

    @Override // com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi
    @NotNull
    public Drawable getFaceDrawableByUser(@Nullable AppInterface appInterface, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(appInterface, 1, uin);
        Intrinsics.checkNotNullExpressionValue(faceDrawable, "getFaceDrawable(\n       \u2026            uin\n        )");
        return faceDrawable;
    }

    @Override // com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi
    @Nullable
    public Drawable getUserFaceDrawable(@Nullable AppInterface appInterface, @NotNull String uin, byte avatarShape) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return FaceDrawable.getUserFaceDrawable(appInterface, uin, avatarShape);
    }
}
