package com.tencent.mtt.supportui.adapters.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface IDrawableTarget {
    Bitmap getBitmap();

    Drawable getDrawable();

    Object getExtraData();

    String getImageType();

    String getSource();

    void onDrawableAttached();

    void onDrawableDetached();
}
