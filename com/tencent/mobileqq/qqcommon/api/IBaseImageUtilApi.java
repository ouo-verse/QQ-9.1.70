package com.tencent.mobileqq.qqcommon.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IBaseImageUtilApi extends QRouteApi {
    Bitmap drawableToBitmap(Drawable drawable);

    Bitmap getDefaultFaceBitmap();

    Bitmap getRoundFaceBitmap(Bitmap bitmap, int i3, int i16);
}
