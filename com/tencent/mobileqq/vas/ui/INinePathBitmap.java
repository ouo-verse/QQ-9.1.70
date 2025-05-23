package com.tencent.mobileqq.vas.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: classes20.dex */
public interface INinePathBitmap {
    void draw(Canvas canvas, Rect rect, Rect rect2, Paint paint);

    Bitmap getBitmap();

    void next(Bitmap bitmap);

    void recycle();
}
