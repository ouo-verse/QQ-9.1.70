package com.tencent.biz.qqcircle.widgets.multitouchimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleMultiTouchImageView extends AppCompatImageView {
    private ImageView.ScaleType C;

    /* renamed from: m, reason: collision with root package name */
    private PhotoViewAttacher f93666m;

    public QCircleMultiTouchImageView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f93666m = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.C;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.C = null;
        }
    }

    private void l() {
        PhotoViewAttacher photoViewAttacher;
        try {
            if (RFWConfig.getConfigValue("rfw_multi_touch_detached_cancel_switch", true) && (photoViewAttacher = this.f93666m) != null && photoViewAttacher.C() != null && this.f93666m.G() != null) {
                MotionEvent obtain = MotionEvent.obtain(this.f93666m.G());
                obtain.setAction(3);
                this.f93666m.C().onTouchEvent(obtain);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f93666m.D();
    }

    public float getScale() {
        return this.f93666m.H();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f93666m.I();
    }

    public void m() {
        PhotoViewAttacher photoViewAttacher = this.f93666m;
        if (photoViewAttacher != null) {
            photoViewAttacher.P();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    public void setAllowParentInterceptOnEdge(boolean z16) {
        this.f93666m.T(z16);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        boolean frame = super.setFrame(i3, i16, i17, i18);
        if (frame) {
            this.f93666m.w0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        PhotoViewAttacher photoViewAttacher = this.f93666m;
        if (photoViewAttacher != null) {
            photoViewAttacher.w0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f93666m;
        if (photoViewAttacher != null) {
            photoViewAttacher.w0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        PhotoViewAttacher photoViewAttacher = this.f93666m;
        if (photoViewAttacher != null) {
            photoViewAttacher.w0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f93666m;
        if (photoViewAttacher != null) {
            photoViewAttacher.w0();
        }
    }

    public void setMaximumScale(float f16) {
        this.f93666m.V(f16);
    }

    public void setMediumScale(float f16) {
        this.f93666m.W(f16);
    }

    public void setMinimumScale(float f16) {
        this.f93666m.X(f16);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f93666m.Y(onClickListener);
    }

    public void setOnDoubleTabListener(d dVar) {
        this.f93666m.Z(dVar);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f93666m.a0(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f93666m.c0(onLongClickListener);
    }

    public void setOnMatrixChangeListener(g gVar) {
        this.f93666m.d0(gVar);
    }

    public void setOnOutsidePhotoTapListener(h hVar) {
        this.f93666m.e0(hVar);
    }

    public void setOnPhotoTapListener(i iVar) {
        this.f93666m.f0(iVar);
    }

    public void setOnScaleBeginListener(j jVar) {
        this.f93666m.g0(jVar);
    }

    public void setOnScaleChangeListener(k kVar) {
        this.f93666m.h0(kVar);
    }

    public void setOnScaleEndListener(l lVar) {
        this.f93666m.i0(lVar);
    }

    public void setOnSingleFlingListener(m mVar) {
        this.f93666m.j0(mVar);
    }

    public void setOnViewDragListener(n nVar) {
        this.f93666m.k0(nVar);
    }

    public void setOnViewTapListener(o oVar) {
        this.f93666m.l0(oVar);
    }

    public void setRotationBy(float f16) {
        this.f93666m.m0(f16);
    }

    public void setRotationTo(float f16) {
        this.f93666m.n0(f16);
    }

    public void setScale(float f16) {
        this.f93666m.o0(f16);
    }

    public void setScaleLevels(float f16, float f17, float f18) {
        this.f93666m.r0(f16, f17, f18);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f93666m;
        if (photoViewAttacher == null) {
            this.C = scaleType;
        } else {
            photoViewAttacher.s0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i3) {
        this.f93666m.u0(i3);
    }

    public void setZoomable(boolean z16) {
        this.f93666m.v0(z16);
    }

    public QCircleMultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f16, boolean z16) {
        this.f93666m.q0(f16, z16);
    }

    public QCircleMultiTouchImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }

    public void setScale(float f16, float f17, float f18, boolean z16) {
        this.f93666m.p0(f16, f17, f18, z16);
    }
}
