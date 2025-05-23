package com.tencent.mobileqq.activity.qqsettingme.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.InputStream;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes10.dex */
public interface IRedTouchTextViewApi extends QRouteApi {
    Drawable getApngURLDrawable(String str);

    double getOptRatio(InputStream inputStream, int i3, int i16);

    Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f16, int i3, int i16);
}
