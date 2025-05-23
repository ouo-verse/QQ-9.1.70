package com.tencent.mobileqq.qcircle.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleResDrawableApi extends QRouteApi {
    Bitmap getBitmapMemory(String str);

    Drawable getDrawable(int i3);

    void putBitmapMemory(String str, Bitmap bitmap);

    void release();

    void release(String str);
}
