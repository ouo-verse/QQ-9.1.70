package com.tencent.mobileqq.guild.component.multitouchimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class MultiTouchImageView extends AppCompatImageView {
    private ImageView.ScaleType C;

    /* renamed from: m, reason: collision with root package name */
    private PhotoViewAttacher f215948m;

    public MultiTouchImageView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f215948m = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.C;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.C = null;
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f215948m.C();
    }

    public float getMaximumScale() {
        return this.f215948m.F();
    }

    public float getMinimumScale() {
        return this.f215948m.H();
    }

    public float getScale() {
        return this.f215948m.I();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f215948m.J();
    }

    public PhotoViewAttacher l() {
        return this.f215948m;
    }

    public float m() {
        return this.f215948m.G();
    }

    public void setAllowParentInterceptOnEdge(boolean z16) {
        this.f215948m.T(z16);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        boolean frame = super.setFrame(i3, i16, i17, i18);
        if (frame) {
            this.f215948m.x0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        PhotoViewAttacher photoViewAttacher = this.f215948m;
        if (photoViewAttacher != null) {
            photoViewAttacher.x0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f215948m;
        if (photoViewAttacher != null) {
            photoViewAttacher.x0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        PhotoViewAttacher photoViewAttacher = this.f215948m;
        if (photoViewAttacher != null) {
            photoViewAttacher.x0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f215948m;
        if (photoViewAttacher != null) {
            photoViewAttacher.x0();
        }
    }

    public void setMaximumScale(float f16) {
        this.f215948m.W(f16);
    }

    public void setMediumScale(float f16) {
        this.f215948m.X(f16);
    }

    public void setMinimumScale(float f16) {
        this.f215948m.Y(f16);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f215948m.Z(onClickListener);
    }

    public void setOnDoubleTabListener(d dVar) {
        this.f215948m.a0(dVar);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f215948m.b0(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f215948m.d0(onLongClickListener);
    }

    public void setOnMatrixChangeListener(g gVar) {
        this.f215948m.e0(gVar);
    }

    public void setOnOutsidePhotoTapListener(h hVar) {
        this.f215948m.f0(hVar);
    }

    public void setOnPhotoTapListener(i iVar) {
        this.f215948m.g0(iVar);
    }

    public void setOnScaleBeginListener(j jVar) {
        this.f215948m.h0(jVar);
    }

    public void setOnScaleChangeListener(k kVar) {
        this.f215948m.i0(kVar);
    }

    public void setOnScaleEndListener(l lVar) {
        this.f215948m.j0(lVar);
    }

    public void setOnSingleFlingListener(n nVar) {
        this.f215948m.k0(nVar);
    }

    public void setOnViewDragListener(o oVar) {
        this.f215948m.l0(oVar);
    }

    public void setOnViewTapListener(p pVar) {
        this.f215948m.m0(pVar);
    }

    public void setRotationBy(float f16) {
        this.f215948m.n0(f16);
    }

    public void setRotationTo(float f16) {
        this.f215948m.o0(f16);
    }

    public void setScale(float f16) {
        this.f215948m.p0(f16);
    }

    public void setScaleLevels(float f16, float f17, float f18) {
        this.f215948m.s0(f16, f17, f18);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f215948m;
        if (photoViewAttacher == null) {
            this.C = scaleType;
        } else {
            photoViewAttacher.u0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i3) {
        this.f215948m.v0(i3);
    }

    public void setZoomable(boolean z16) {
        this.f215948m.w0(z16);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f16, boolean z16) {
        this.f215948m.r0(f16, z16);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }

    public void setScale(float f16, float f17, float f18, boolean z16) {
        this.f215948m.q0(f16, f17, f18, z16);
    }
}
