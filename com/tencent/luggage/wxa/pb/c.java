package com.tencent.luggage.wxa.pb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends BitmapDrawable {
    public c(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBitmap() != null && !getBitmap().isRecycled()) {
            super.draw(canvas);
        }
    }
}
