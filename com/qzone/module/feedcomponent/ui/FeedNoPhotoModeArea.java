package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: classes39.dex */
public class FeedNoPhotoModeArea extends SubArea {
    Drawable mDrawable;
    int mPicHeight;
    int mPicWidth;

    public FeedNoPhotoModeArea(Drawable drawable) {
        this.mPicHeight = 46;
        this.mPicWidth = 46;
        this.mDrawable = drawable;
        if (drawable != null) {
            this.mPicWidth = drawable.getIntrinsicWidth();
            this.mPicHeight = this.mDrawable.getIntrinsicHeight();
        }
        this.mType = 38;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mPicHeight;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mPicWidth;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        if (paint != null) {
            paint.setFlags(6);
        }
        Drawable drawable = this.mDrawable;
        if (drawable == null) {
            return true;
        }
        drawable.setBounds(0, 0, this.mPicWidth, this.mPicHeight);
        this.mDrawable.draw(canvas);
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
    }
}
