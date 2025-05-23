package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.widget.CoverView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CoverImageView extends CoverView {
    private ImageView imageView;

    public CoverImageView(@NonNull Context context) {
        super(context);
        this.imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.imageView, layoutParams);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.imageView.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        this.imageView.setImageDrawable(drawable);
    }
}
