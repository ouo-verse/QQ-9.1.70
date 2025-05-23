package com.tencent.gdtad.basics.adshake.animatorview.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BitmapLayer extends AnimatorLayer {
    private Bitmap mBitmap;

    public BitmapLayer() {
        this(null);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, getMatrix(), getPaint());
        }
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17, float f18, float f19, float f26) {
        super.postScale(f16, f17, f18, f19, f26);
        getMatrix().postScale(f16, f17, f18, f19);
    }

    public BitmapLayer setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }

    public BitmapLayer setTintColor(int i3) {
        getPaint().setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
        return this;
    }

    public BitmapLayer(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
    }
}
