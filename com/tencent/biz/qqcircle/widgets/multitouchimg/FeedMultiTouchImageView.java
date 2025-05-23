package com.tencent.biz.qqcircle.widgets.multitouchimg;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FeedMultiTouchImageView extends AppCompatImageView {
    private ImageView.ScaleType C;

    /* renamed from: m, reason: collision with root package name */
    private PhotoViewScaleDetector f93612m;

    public FeedMultiTouchImageView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f93612m = new PhotoViewScaleDetector(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.C;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.C = null;
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f93612m.C();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f93612m.G();
    }

    public PhotoViewScaleDetector l() {
        return this.f93612m;
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        boolean frame = super.setFrame(i3, i16, i17, i18);
        if (frame) {
            this.f93612m.X();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        PhotoViewScaleDetector photoViewScaleDetector;
        super.setImageDrawable(drawable);
        PhotoViewScaleDetector photoViewScaleDetector2 = this.f93612m;
        if (photoViewScaleDetector2 != null) {
            photoViewScaleDetector2.X();
        }
        if (drawable == null && (photoViewScaleDetector = this.f93612m) != null) {
            photoViewScaleDetector.N();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        PhotoViewScaleDetector photoViewScaleDetector = this.f93612m;
        if (photoViewScaleDetector != null) {
            photoViewScaleDetector.X();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewScaleDetector photoViewScaleDetector = this.f93612m;
        if (photoViewScaleDetector != null) {
            photoViewScaleDetector.X();
        }
    }

    public void setOnEndDragListener(e eVar) {
        this.f93612m.T(eVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f93612m.U(onLongClickListener);
    }

    public void setOnMatrixChangeListener(g gVar) {
        this.f93612m.V(gVar);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewScaleDetector photoViewScaleDetector = this.f93612m;
        if (photoViewScaleDetector == null) {
            this.C = scaleType;
        } else {
            photoViewScaleDetector.W(scaleType);
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
