package com.tencent.mobileqq.wink.publish.widget.multitouchimg;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QCircleMultiTouchImageView extends URLImageView {

    /* renamed from: d, reason: collision with root package name */
    private PhotoViewAttacher f326119d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView.ScaleType f326120e;

    public QCircleMultiTouchImageView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f326119d = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f326120e;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f326120e = null;
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f326119d.F();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f326119d.J();
    }

    public void setAllowParentInterceptOnEdge(boolean z16) {
        this.f326119d.N(z16);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        boolean frame = super.setFrame(i3, i16, i17, i18);
        if (frame) {
            this.f326119d.o0();
        }
        return frame;
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f326119d;
        if (photoViewAttacher != null) {
            photoViewAttacher.o0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        PhotoViewAttacher photoViewAttacher = this.f326119d;
        if (photoViewAttacher != null) {
            photoViewAttacher.o0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f326119d;
        if (photoViewAttacher != null) {
            photoViewAttacher.o0();
        }
    }

    public void setMaximumScale(float f16) {
        this.f326119d.P(f16);
    }

    public void setMediumScale(float f16) {
        this.f326119d.Q(f16);
    }

    public void setMinimumScale(float f16) {
        this.f326119d.R(f16);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f326119d.S(onClickListener);
    }

    public void setOnDoubleTabListener(c cVar) {
        this.f326119d.T(cVar);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f326119d.U(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f326119d.V(onLongClickListener);
    }

    public void setOnMatrixChangeListener(e eVar) {
        this.f326119d.W(eVar);
    }

    public void setOnOutsidePhotoTapListener(f fVar) {
        this.f326119d.X(fVar);
    }

    public void setOnPhotoTapListener(g gVar) {
        this.f326119d.Y(gVar);
    }

    public void setOnScaleBeginListener(h hVar) {
        this.f326119d.Z(hVar);
    }

    public void setOnScaleChangeListener(i iVar) {
        this.f326119d.a0(iVar);
    }

    public void setOnScaleEndListener(j jVar) {
        this.f326119d.b0(jVar);
    }

    public void setOnSingleFlingListener(k kVar) {
        this.f326119d.c0(kVar);
    }

    public void setOnViewDragListener(l lVar) {
        this.f326119d.d0(lVar);
    }

    public void setOnViewTapListener(m mVar) {
        this.f326119d.e0(mVar);
    }

    public void setRotationBy(float f16) {
        this.f326119d.f0(f16);
    }

    public void setRotationTo(float f16) {
        this.f326119d.g0(f16);
    }

    public void setScale(float f16) {
        this.f326119d.h0(f16);
    }

    public void setScaleLevels(float f16, float f17, float f18) {
        this.f326119d.k0(f16, f17, f18);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f326119d;
        if (photoViewAttacher == null) {
            this.f326120e = scaleType;
        } else {
            photoViewAttacher.l0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i3) {
        this.f326119d.m0(i3);
    }

    public void setZoomable(boolean z16) {
        this.f326119d.n0(z16);
    }

    public QCircleMultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f16, boolean z16) {
        this.f326119d.j0(f16, z16);
    }

    public QCircleMultiTouchImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }

    public void setScale(float f16, float f17, float f18, boolean z16) {
        this.f326119d.i0(f16, f17, f18, z16);
    }
}
