package com.qzone.reborn.qzmoment.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.widgets.multitouchimg.PhotoViewAttacher;
import com.tencent.biz.qqcircle.widgets.multitouchimg.d;
import com.tencent.biz.qqcircle.widgets.multitouchimg.e;
import com.tencent.biz.qqcircle.widgets.multitouchimg.g;
import com.tencent.biz.qqcircle.widgets.multitouchimg.h;
import com.tencent.biz.qqcircle.widgets.multitouchimg.i;
import com.tencent.biz.qqcircle.widgets.multitouchimg.j;
import com.tencent.biz.qqcircle.widgets.multitouchimg.k;
import com.tencent.biz.qqcircle.widgets.multitouchimg.l;
import com.tencent.biz.qqcircle.widgets.multitouchimg.m;
import com.tencent.biz.qqcircle.widgets.multitouchimg.n;
import com.tencent.biz.qqcircle.widgets.multitouchimg.o;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneTouchImageView extends RoundCornerImageView {
    private PhotoViewAttacher G;
    private ImageView.ScaleType H;

    public QZoneTouchImageView(Context context) {
        this(context, null);
    }

    private void b() {
        this.G = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.H;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.H = null;
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.G.D();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.G.I();
    }

    public void setAllowParentInterceptOnEdge(boolean z16) {
        this.G.T(z16);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        boolean frame = super.setFrame(i3, i16, i17, i18);
        if (frame) {
            this.G.w0();
        }
        return frame;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.G;
        if (photoViewAttacher != null) {
            photoViewAttacher.w0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        PhotoViewAttacher photoViewAttacher = this.G;
        if (photoViewAttacher != null) {
            photoViewAttacher.w0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.G;
        if (photoViewAttacher != null) {
            photoViewAttacher.w0();
        }
    }

    public void setMaximumScale(float f16) {
        this.G.V(f16);
    }

    public void setMediumScale(float f16) {
        this.G.W(f16);
    }

    public void setMinimumScale(float f16) {
        this.G.X(f16);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.G.Y(onClickListener);
    }

    public void setOnDoubleTabListener(d dVar) {
        this.G.Z(dVar);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.G.a0(onDoubleTapListener);
    }

    public void setOnDragEndListener(e eVar) {
        this.G.b0(eVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.G.c0(onLongClickListener);
    }

    public void setOnMatrixChangeListener(g gVar) {
        this.G.d0(gVar);
    }

    public void setOnOutsidePhotoTapListener(h hVar) {
        this.G.e0(hVar);
    }

    public void setOnPhotoTapListener(i iVar) {
        this.G.f0(iVar);
    }

    public void setOnScaleBeginListener(j jVar) {
        this.G.g0(jVar);
    }

    public void setOnScaleChangeListener(k kVar) {
        this.G.h0(kVar);
    }

    public void setOnScaleEndListener(l lVar) {
        this.G.i0(lVar);
    }

    public void setOnSingleFlingListener(m mVar) {
        this.G.j0(mVar);
    }

    public void setOnViewDragListener(n nVar) {
        this.G.k0(nVar);
    }

    public void setOnViewTapListener(o oVar) {
        this.G.l0(oVar);
    }

    public void setRotationBy(float f16) {
        this.G.m0(f16);
    }

    public void setRotationTo(float f16) {
        this.G.n0(f16);
    }

    public void setScale(float f16) {
        this.G.o0(f16);
    }

    public void setScaleLevels(float f16, float f17, float f18) {
        this.G.r0(f16, f17, f18);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.G;
        if (photoViewAttacher == null) {
            this.H = scaleType;
        } else {
            photoViewAttacher.s0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i3) {
        this.G.u0(i3);
    }

    public void setZoomable(boolean z16) {
        this.G.v0(z16);
    }

    public QZoneTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f16, boolean z16) {
        this.G.q0(f16, z16);
    }

    public QZoneTouchImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
    }

    public void setScale(float f16, float f17, float f18, boolean z16) {
        this.G.p0(f16, f17, f18, z16);
    }
}
