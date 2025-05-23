package com.tencent.mobileqq.ui.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IQQImageDrawableApi extends QRouteApi {
    Drawable getApngUrlDrawable(Context context, String str);

    Bitmap getDefaultFaceBitmap();

    Drawable getQQFaceDrawable(String str);
}
