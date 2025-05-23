package com.tencent.richframework.widget.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWMatrixImageView extends AppCompatImageView {
    private PhotoViewAttacher mAttacher;
    private ImageView.ScaleType mPendingScaleType;

    public RFWMatrixImageView(Context context) {
        this(context, null);
    }

    private int getActualHeight() {
        Bitmap bitmap;
        if (getDrawable() == null) {
            return 0;
        }
        if ((getDrawable() instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) getDrawable()).getBitmap()) != null) {
            return bitmap.getHeight();
        }
        return getDrawable().getIntrinsicHeight();
    }

    private int getActualWidth() {
        Bitmap bitmap;
        if (getDrawable() == null) {
            return 0;
        }
        if ((getDrawable() instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) getDrawable()).getBitmap()) != null) {
            return bitmap.getWidth();
        }
        return getDrawable().getIntrinsicWidth();
    }

    private void init() {
        this.mAttacher = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.mPendingScaleType;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.mPendingScaleType = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean magnifyLongPicIfNeeded(boolean z16) {
        if (getDrawable() == null) {
            RFWLog.e("RFWMatrixImageView", RFWLog.USR, "drawable is null");
            return false;
        }
        float height = getHeight();
        float width = getWidth();
        if (height > 0.0f && width > 0.0f) {
            int actualHeight = getActualHeight();
            int actualWidth = getActualWidth();
            if (actualHeight > 0 && actualWidth > 0) {
                RFWLog.i("RFWMatrixImageView", RFWLog.USR, "display height is " + height + "actualHeight is " + actualHeight + "display width is " + width + "actualWidth is " + actualWidth);
                float f16 = (((float) actualHeight) / height) / (((float) actualWidth) / width);
                if (f16 <= 3.0f) {
                    RFWLog.i("RFWMatrixImageView", RFWLog.USR, "not long pic, no need to scale");
                    return true;
                }
                if (f16 > getMaximumScale()) {
                    RFWLog.i("RFWMatrixImageView", RFWLog.USR, "target zoom is " + f16 + " bigger than max scale " + getMaximumScale());
                    f16 = getMaximumScale();
                }
                RFWLog.i("RFWMatrixImageView", RFWLog.USR, "target zoom is " + f16);
                setScale(f16, ((float) (getLeft() + getRight())) / 2.0f, 0.0f, z16);
                setIsAutoMagnified(true);
                return true;
            }
            RFWLog.e("RFWMatrixImageView", RFWLog.USR, "actual size less than 0");
            return false;
        }
        RFWLog.e("RFWMatrixImageView", RFWLog.USR, "displayHeight is less than 0f");
        return false;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.mAttacher.getImageMatrix();
    }

    public float getMaximumScale() {
        return this.mAttacher.getMaximumScale();
    }

    public float getMinimumScale() {
        return this.mAttacher.getMinimumScale();
    }

    public float getScale() {
        return this.mAttacher.getScale();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.mAttacher.getScaleType();
    }

    public void getSuppMatrix(Matrix matrix) {
        this.mAttacher.getSuppMatrix(matrix);
    }

    public boolean isAutoMagnified() {
        return this.mAttacher.isAutoMagnified();
    }

    public void setAllowParentInterceptOnEdge(boolean z16) {
        this.mAttacher.setAllowParentInterceptOnEdge(z16);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        boolean frame = super.setFrame(i3, i16, i17, i18);
        if (frame) {
            this.mAttacher.update();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.mAttacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        PhotoViewAttacher photoViewAttacher = this.mAttacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.mAttacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setIsAutoMagnified(boolean z16) {
        this.mAttacher.setIsAutoMagnified(z16);
    }

    public void setMaximumScale(float f16) {
        this.mAttacher.setMaximumScale(f16);
    }

    public void setMediumScale(float f16) {
        this.mAttacher.setMediumScale(f16);
    }

    public void setMinimumScale(float f16) {
        this.mAttacher.setMinimumScale(f16);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mAttacher.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.mAttacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mAttacher.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.mAttacher.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.mAttacher.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mAttacher.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnScaleBeginListener(OnScaleBeginListener onScaleBeginListener) {
        this.mAttacher.setOnScaleBeginListener(onScaleBeginListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.mAttacher.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnScaleEndListener(OnScaleEndListener onScaleEndListener) {
        this.mAttacher.setOnScaleEndListener(onScaleEndListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.mAttacher.setOnSingleFlingListener(onSingleFlingListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.mAttacher.setOnViewDragListener(onViewDragListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mAttacher.setOnViewTapListener(onViewTapListener);
    }

    public void setRotationBy(float f16) {
        this.mAttacher.setRotationBy(f16);
    }

    public void setRotationTo(float f16) {
        this.mAttacher.setRotationTo(f16);
    }

    public void setScale(float f16) {
        this.mAttacher.setScale(f16);
    }

    public void setScaleLevels(float f16, float f17, float f18) {
        this.mAttacher.setScaleLevels(f16, f17, f18);
    }

    public void setScaleLockState(boolean z16) {
        this.mAttacher.setScaleLockState(z16);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.mAttacher;
        if (photoViewAttacher == null) {
            this.mPendingScaleType = scaleType;
        } else {
            photoViewAttacher.setScaleType(scaleType);
        }
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.mAttacher.setDisplayMatrix(matrix);
    }

    public void setZoomTransitionDuration(int i3) {
        this.mAttacher.setZoomTransitionDuration(i3);
    }

    public void setZoomable(boolean z16) {
        this.mAttacher.setZoomable(z16);
    }

    public boolean tryMagnifyLongPic(final boolean z16) {
        if (getDrawable() == null) {
            RFWLog.e("RFWMatrixImageView", RFWLog.USR, "drawable is null");
            return false;
        }
        float height = getHeight();
        float width = getWidth();
        if (height > 0.0f && width > 0.0f) {
            return magnifyLongPicIfNeeded(z16);
        }
        RFWLog.e("RFWMatrixImageView", RFWLog.USR, "displayHeight is less than 0f");
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.richframework.widget.matrix.RFWMatrixImageView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RFWMatrixImageView.this.magnifyLongPicIfNeeded(z16);
            }
        });
        return false;
    }

    public RFWMatrixImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mAttacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setScale(float f16, boolean z16) {
        this.mAttacher.setScale(f16, z16);
    }

    public RFWMatrixImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }

    public void setScale(float f16, float f17, float f18, boolean z16) {
        this.mAttacher.setScale(f16, f17, f18, z16);
    }
}
