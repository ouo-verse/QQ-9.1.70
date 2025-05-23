package com.tencent.qqlive.tvkplayer.logo.impl;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoImageView extends AppCompatImageView {
    private Bitmap mBitmap;

    public TVKLogoImageView(Context context) {
        super(context);
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        setImageBitmap(bitmap);
    }
}
