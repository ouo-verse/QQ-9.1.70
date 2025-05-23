package com.tencent.ams.mosaic.jsengine.component.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    View d();

    Context getContext();

    Drawable getDrawable();

    void setBorderColor(int i3);

    void setBorderWidth(float f16);

    void setImageBitmap(Bitmap bitmap);

    void setImageDrawable(Drawable drawable);

    void setMaskColor(int i3);

    void setMovie(Movie movie);

    void setRadius(float f16);

    void setRadius(float f16, float f17, float f18, float f19);

    void setRealDrawListener(a aVar);

    void setScaleType(ImageView.ScaleType scaleType);

    void setTintColorFilter(ColorFilter colorFilter);
}
