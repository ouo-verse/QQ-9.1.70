package com.tencent.component.media.image.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.component.media.utils.ImageManagerLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ExtendImageView extends ImageView {
    private static final ThreadLocal<Rect> sLocalTmpRect = new ThreadLocal<Rect>() { // from class: com.tencent.component.media.image.view.ExtendImageView.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Rect initialValue() {
            return new Rect();
        }
    };
    private boolean mAdjustViewBounds;
    private boolean mBlockMeasurement;
    private ViewForeground mForeground;
    private int mForegroundResource;
    private boolean mIgnoreContentBounds;
    private boolean mMeasuredExactly;

    public ExtendImageView(Context context) {
        super(context);
        this.mMeasuredExactly = false;
        this.mBlockMeasurement = false;
        this.mIgnoreContentBounds = false;
        this.mAdjustViewBounds = false;
        this.mForegroundResource = 0;
        this.mForeground = new ViewForeground(this, (Drawable) null);
    }

    private boolean isBackgroundHasPadding(Drawable drawable, Drawable drawable2) {
        boolean z16;
        Rect rect = sLocalTmpRect.get();
        boolean z17 = true;
        if (drawable != null && drawable.getPadding(rect)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (drawable2 == null || !drawable2.getPadding(rect)) {
                z17 = false;
            }
            return z17;
        }
        return z16;
    }

    private boolean isMeasuredExactly(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (mode == 1073741824 && mode2 == 1073741824) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAnimation(Animation animation, final Runnable runnable) {
        if (animation == null) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            clearAnimation();
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.component.media.image.view.ExtendImageView.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                }
            });
            startAnimation(animation);
        }
    }

    private void setForegroundInternal(Drawable drawable) {
        this.mBlockMeasurement = true;
        this.mForeground.setDrawable(drawable);
        this.mBlockMeasurement = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageBitmapInternal(Bitmap bitmap) {
        this.mBlockMeasurement = true;
        super.setImageBitmap(bitmap);
        this.mBlockMeasurement = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageDrawableInternal(Drawable drawable) {
        this.mBlockMeasurement = true;
        super.setImageDrawable(drawable);
        this.mBlockMeasurement = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageResourceInternal(int i3) {
        this.mBlockMeasurement = true;
        try {
            super.setImageResource(i3);
            this.mBlockMeasurement = false;
        } catch (OutOfMemoryError e16) {
            ImageManagerLog.e("ExtendImageView", "out of memory " + e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageURIInternal(Uri uri) {
        this.mBlockMeasurement = true;
        super.setImageURI(uri);
        this.mBlockMeasurement = false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ViewForeground viewForeground = this.mForeground;
        if (viewForeground != null) {
            viewForeground.drawableStateChanged();
        }
    }

    @Override // android.widget.ImageView
    public boolean getAdjustViewBounds() {
        return this.mAdjustViewBounds;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ViewForeground viewForeground = this.mForeground;
        if (viewForeground != null) {
            viewForeground.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        ViewForeground viewForeground = this.mForeground;
        if (viewForeground != null) {
            viewForeground.boundsChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        this.mMeasuredExactly = isMeasuredExactly(i3, i16);
        super.onMeasure(i3, i16);
        if (this.mIgnoreContentBounds && !this.mAdjustViewBounds) {
            setMeasuredDimension(View.getDefaultSize(getMeasuredWidth(), i3), View.getDefaultSize(getMeasuredHeight(), i16));
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        ViewForeground viewForeground = this.mForeground;
        if (viewForeground != null) {
            viewForeground.boundsChanged();
        }
    }

    @Override // android.view.View
    public void requestLayout() {
        if (!this.mBlockMeasurement || !this.mMeasuredExactly) {
            super.requestLayout();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z16) {
        super.setAdjustViewBounds(z16);
        this.mAdjustViewBounds = z16;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.mBlockMeasurement = true;
        super.setBackgroundColor(i3);
        this.mBlockMeasurement = false;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        this.mBlockMeasurement = !isBackgroundHasPadding(getBackground(), drawable);
        super.setBackgroundDrawable(drawable);
        this.mBlockMeasurement = false;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        this.mBlockMeasurement = true;
        super.setBackgroundResource(i3);
        this.mBlockMeasurement = false;
    }

    public void setForeground(int i3) {
        if (i3 == 0 || i3 != this.mForegroundResource) {
            this.mForegroundResource = i3;
            setForegroundInternal(i3 != 0 ? getResources().getDrawable(i3) : null);
        }
    }

    public void setIgnoreContentBounds(boolean z16) {
        if (this.mIgnoreContentBounds != z16) {
            this.mIgnoreContentBounds = z16;
            requestLayout();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmapInternal(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        setImageDrawableInternal(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        setImageResourceInternal(i3);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageURIInternal(uri);
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2;
        ViewForeground viewForeground = this.mForeground;
        if (viewForeground == null) {
            drawable2 = null;
        } else {
            drawable2 = viewForeground.getDrawable();
        }
        if (drawable2 != drawable && !super.verifyDrawable(drawable)) {
            return false;
        }
        return true;
    }

    public void setImageBitmap(final Bitmap bitmap, final Animation animation, Animation animation2) {
        if (animation2 != null) {
            scheduleAnimation(animation2, new Runnable() { // from class: com.tencent.component.media.image.view.ExtendImageView.2
                @Override // java.lang.Runnable
                public void run() {
                    ExtendImageView.this.setImageBitmapInternal(bitmap);
                    Animation animation3 = animation;
                    if (animation3 != null) {
                        ExtendImageView.this.scheduleAnimation(animation3, null);
                    }
                }
            });
            return;
        }
        setImageBitmapInternal(bitmap);
        if (animation != null) {
            scheduleAnimation(animation, null);
        }
    }

    public void setImageDrawable(final Drawable drawable, final Animation animation, Animation animation2) {
        if (animation2 != null) {
            scheduleAnimation(animation2, new Runnable() { // from class: com.tencent.component.media.image.view.ExtendImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    ExtendImageView.this.setImageDrawableInternal(drawable);
                    Animation animation3 = animation;
                    if (animation3 != null) {
                        ExtendImageView.this.scheduleAnimation(animation3, null);
                    }
                }
            });
            return;
        }
        setImageDrawableInternal(drawable);
        if (animation != null) {
            scheduleAnimation(animation, null);
        }
    }

    public void setImageResource(final int i3, final Animation animation, Animation animation2) {
        if (animation2 != null) {
            scheduleAnimation(animation2, new Runnable() { // from class: com.tencent.component.media.image.view.ExtendImageView.4
                @Override // java.lang.Runnable
                public void run() {
                    ExtendImageView.this.setImageResourceInternal(i3);
                    Animation animation3 = animation;
                    if (animation3 != null) {
                        ExtendImageView.this.scheduleAnimation(animation3, null);
                    }
                }
            });
            return;
        }
        setImageResourceInternal(i3);
        if (animation != null) {
            scheduleAnimation(animation, null);
        }
    }

    public void setImageURI(final Uri uri, final Animation animation, Animation animation2) {
        if (animation2 != null) {
            scheduleAnimation(animation2, new Runnable() { // from class: com.tencent.component.media.image.view.ExtendImageView.5
                @Override // java.lang.Runnable
                public void run() {
                    ExtendImageView.this.setImageURIInternal(uri);
                    Animation animation3 = animation;
                    if (animation3 != null) {
                        ExtendImageView.this.scheduleAnimation(animation3, null);
                    }
                }
            });
            return;
        }
        setImageURIInternal(uri);
        if (animation != null) {
            scheduleAnimation(animation, null);
        }
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        if (drawable == this.mForeground.getDrawable()) {
            return;
        }
        this.mForegroundResource = 0;
        setForegroundInternal(drawable);
    }

    public ExtendImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMeasuredExactly = false;
        this.mBlockMeasurement = false;
        this.mIgnoreContentBounds = false;
        this.mAdjustViewBounds = false;
        this.mForegroundResource = 0;
        this.mForeground = new ViewForeground(this, (Drawable) null);
    }

    public ExtendImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mMeasuredExactly = false;
        this.mBlockMeasurement = false;
        this.mIgnoreContentBounds = false;
        this.mAdjustViewBounds = false;
        this.mForegroundResource = 0;
        this.mForeground = new ViewForeground(this, (Drawable) null);
    }
}
