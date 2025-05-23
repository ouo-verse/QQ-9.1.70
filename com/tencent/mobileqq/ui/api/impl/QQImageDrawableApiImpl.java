package com.tencent.mobileqq.ui.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.ui.api.IQQImageDrawableApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/ui/api/impl/QQImageDrawableApiImpl;", "Lcom/tencent/mobileqq/ui/api/IQQImageDrawableApi;", "", "uin", "Landroid/graphics/drawable/Drawable;", "getQQFaceDrawable", "Landroid/graphics/Bitmap;", "getDefaultFaceBitmap", "Landroid/content/Context;", "context", "url", "getApngUrlDrawable", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQImageDrawableApiImpl implements IQQImageDrawableApi {
    public static final String TAG = "QQImageDrawableApiImpl";

    @Override // com.tencent.mobileqq.ui.api.IQQImageDrawableApi
    public Drawable getApngUrlDrawable(Context context, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(TAG, url, new ApngOptions());
    }

    @Override // com.tencent.mobileqq.ui.api.IQQImageDrawableApi
    public Drawable getQQFaceDrawable(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable((QQAppInterface) runtime, 1, 4, uin);
        Intrinsics.checkNotNullExpressionValue(faceDrawable, "getFaceDrawable(\n       \u2026            uin\n        )");
        return faceDrawable;
    }

    @Override // com.tencent.mobileqq.ui.api.IQQImageDrawableApi
    public Bitmap getDefaultFaceBitmap() {
        Bitmap defaultFaceBitmap = BaseImageUtil.getDefaultFaceBitmap(true);
        Intrinsics.checkNotNullExpressionValue(defaultFaceBitmap, "getDefaultFaceBitmap(true)");
        return defaultFaceBitmap;
    }
}
