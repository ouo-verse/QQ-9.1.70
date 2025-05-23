package com.tencent.mobileqq.avatar.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IQQAvatarUtilApi extends QRouteApi {
    Bitmap genSquareFaceBmpByShape(Bitmap bitmap);

    String get1080QQHeadDownLoadUrl(String str, byte b16);

    Bitmap getBitmapWithCache(String str, int i3);

    Drawable getDefaultDiscusionFaceDrawable();

    Drawable getDefaultFaceDrawable(boolean z16);

    Drawable getDefaultTroopFaceDrawable();

    Bitmap getDrawableBitmap(Drawable drawable);

    String getIp(String str, boolean z16);

    Bitmap getRoundFaceBitmap(Bitmap bitmap);

    Bitmap getShapeRoundFaceBitmap(Bitmap bitmap, int i3, int i16, int i17);
}
