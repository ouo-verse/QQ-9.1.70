package com.tencent.mobileqq.guild.component.multitouchimg;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FeedMultiTouchImageView extends AppCompatImageView {
    private ImageView.ScaleType C;

    /* renamed from: m, reason: collision with root package name */
    private PhotoViewScaleDetector f215947m;

    public FeedMultiTouchImageView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f215947m = new PhotoViewScaleDetector(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.C;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.C = null;
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f215947m.C();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f215947m.G();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        boolean frame = super.setFrame(i3, i16, i17, i18);
        if (frame) {
            this.f215947m.W();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        PhotoViewScaleDetector photoViewScaleDetector;
        super.setImageDrawable(drawable);
        PhotoViewScaleDetector photoViewScaleDetector2 = this.f215947m;
        if (photoViewScaleDetector2 != null) {
            photoViewScaleDetector2.W();
        }
        if (drawable == null && (photoViewScaleDetector = this.f215947m) != null) {
            photoViewScaleDetector.N();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        PhotoViewScaleDetector photoViewScaleDetector = this.f215947m;
        if (photoViewScaleDetector != null) {
            photoViewScaleDetector.W();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewScaleDetector photoViewScaleDetector = this.f215947m;
        if (photoViewScaleDetector != null) {
            photoViewScaleDetector.W();
        }
    }

    public void setOnEndDragListener(e eVar) {
        this.f215947m.S(eVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f215947m.T(onLongClickListener);
    }

    public void setOnMatrixChangeListener(g gVar) {
        this.f215947m.U(gVar);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewScaleDetector photoViewScaleDetector = this.f215947m;
        if (photoViewScaleDetector == null) {
            this.C = scaleType;
        } else {
            photoViewScaleDetector.V(scaleType);
        }
    }

    public FeedMultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedMultiTouchImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
