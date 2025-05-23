package com.tencent.mobileqq.qcircle.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleResDrawableApiImpl implements IQCircleResDrawableApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi
    public Bitmap getBitmapMemory(String str) {
        return d30.a.a(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi
    public Drawable getDrawable(int i3) {
        return d30.a.b(i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi
    public void putBitmapMemory(String str, Bitmap bitmap) {
        d30.a.c(str, bitmap);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi
    public void release() {
        d30.a.d("");
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi
    public void release(String str) {
        d30.a.d(str);
    }
}
