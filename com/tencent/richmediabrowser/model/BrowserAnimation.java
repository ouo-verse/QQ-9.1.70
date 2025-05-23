package com.tencent.richmediabrowser.model;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class BrowserAnimation {
    public boolean isImgCenterCropMode;
    public Rect thubmRect;

    public static int getCutValue(Rect rect, Drawable drawable) {
        return 0;
    }

    public abstract Drawable getAnimationDrawable();

    public abstract int getCutValue();

    public Rect getStartSrcRect() {
        return null;
    }

    public int getStartX() {
        return 0;
    }

    public int getStartY() {
        return 0;
    }

    public Rect getThumbRect() {
        return this.thubmRect;
    }

    public boolean needAnimation(boolean z16) {
        return true;
    }
}
