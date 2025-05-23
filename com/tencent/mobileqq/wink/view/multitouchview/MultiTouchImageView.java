package com.tencent.mobileqq.wink.view.multitouchview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class MultiTouchImageView extends URLImageView {

    /* renamed from: d, reason: collision with root package name */
    private PhotoViewAttacher f327022d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView.ScaleType f327023e;

    public MultiTouchImageView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f327022d = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f327023e;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f327023e = null;
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f327022d.C();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f327022d.E();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        boolean frame = super.setFrame(i3, i16, i17, i18);
        if (frame) {
            this.f327022d.X();
        }
        return frame;
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f327022d;
        if (photoViewAttacher != null) {
            photoViewAttacher.X();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        PhotoViewAttacher photoViewAttacher = this.f327022d;
        if (photoViewAttacher != null) {
            photoViewAttacher.X();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f327022d;
        if (photoViewAttacher != null) {
            photoViewAttacher.X();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f327022d.Q(onClickListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f327022d.R(onLongClickListener);
    }

    public void setOnViewTapListener(d dVar) {
        PhotoViewAttacher photoViewAttacher = this.f327022d;
        if (photoViewAttacher != null) {
            photoViewAttacher.T(dVar);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f327022d;
        if (photoViewAttacher == null) {
            this.f327023e = scaleType;
        } else {
            photoViewAttacher.V(scaleType);
        }
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
