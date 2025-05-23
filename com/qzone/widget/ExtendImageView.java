package com.qzone.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ExtendImageView extends ImageView {
    private static final ThreadLocal<Rect> sLocalTmpRect = new a();
    private boolean mAdjustViewBounds;
    private boolean mBlockMeasurement;
    private float mCornerRadius;
    private ab mForeground;
    private boolean mIgnoreContentBounds;
    private boolean mMeasuredExactly;
    private Path mPath;
    private RectF mTmpRectF;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends ThreadLocal<Rect> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect initialValue() {
            return new Rect();
        }
    }

    public ExtendImageView(Context context) {
        super(context);
        this.mMeasuredExactly = false;
        this.mBlockMeasurement = false;
        this.mIgnoreContentBounds = false;
        this.mAdjustViewBounds = false;
        this.mTmpRectF = new RectF();
        this.mForeground = new ab(this, null);
    }

    private boolean isBackgroundHasPadding(Drawable drawable, Drawable drawable2) {
        Rect rect = sLocalTmpRect.get();
        boolean z16 = drawable != null && drawable.getPadding(rect);
        if (z16) {
            return z16;
        }
        return drawable2 != null && drawable2.getPadding(rect);
    }

    private boolean isMeasuredExactly(int i3, int i16) {
        return View.MeasureSpec.getMode(i3) == 1073741824 && View.MeasureSpec.getMode(i16) == 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ab abVar = this.mForeground;
        if (abVar != null) {
            abVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f16 = this.mCornerRadius;
        if (f16 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            int save = canvas.save();
            try {
                try {
                    Path path = this.mPath;
                    RectF rectF = this.mTmpRectF;
                    rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                    path.reset();
                    path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
                    canvas.clipPath(path);
                    super.onDraw(canvas);
                    ab abVar = this.mForeground;
                    if (abVar != null) {
                        abVar.b(canvas);
                    }
                } catch (UnsupportedOperationException unused) {
                    super.onDraw(canvas);
                }
                return;
            } finally {
                canvas.restoreToCount(save);
            }
        }
        super.onDraw(canvas);
        ab abVar2 = this.mForeground;
        if (abVar2 != null) {
            abVar2.b(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        ab abVar = this.mForeground;
        if (abVar != null) {
            abVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        this.mMeasuredExactly = isMeasuredExactly(i3, i16);
        super.onMeasure(i3, i16);
        if (!this.mIgnoreContentBounds || this.mAdjustViewBounds) {
            return;
        }
        setMeasuredDimension(View.getDefaultSize(getMeasuredWidth(), i3), View.getDefaultSize(getMeasuredHeight(), i16));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        ab abVar = this.mForeground;
        if (abVar != null) {
            abVar.a();
        }
    }

    @Override // android.view.View
    public void requestLayout() {
        if (this.mBlockMeasurement && this.mMeasuredExactly) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z16) {
        super.setAdjustViewBounds(z16);
        this.mAdjustViewBounds = z16;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        this.mBlockMeasurement = !isBackgroundHasPadding(getBackground(), drawable);
        super.setBackgroundDrawable(drawable);
        this.mBlockMeasurement = false;
    }

    public void setCornerRadius(float f16) {
        if (this.mCornerRadius != f16) {
            this.mCornerRadius = f16;
            invalidate();
        }
    }

    public void setForeground(int i3) {
        this.mBlockMeasurement = true;
        setForeground(i3 != 0 ? getResources().getDrawable(i3) : null);
        this.mBlockMeasurement = false;
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
        ab abVar = this.mForeground;
        return (abVar == null ? null : abVar.d()) == drawable || super.verifyDrawable(drawable);
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
        super.setImageResource(i3);
        this.mBlockMeasurement = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageURIInternal(Uri uri) {
        this.mBlockMeasurement = true;
        super.setImageURI(uri);
        this.mBlockMeasurement = false;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.mBlockMeasurement = true;
        super.setBackgroundColor(i3);
        this.mBlockMeasurement = false;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        this.mBlockMeasurement = true;
        super.setBackgroundResource(i3);
        this.mBlockMeasurement = false;
    }

    public void setImageBitmap(final Bitmap bitmap, final Animation animation, Animation animation2) {
        if (animation2 != null) {
            scheduleAnimation(animation2, new Runnable() { // from class: com.qzone.widget.ExtendImageView.2
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
            scheduleAnimation(animation2, new Runnable() { // from class: com.qzone.widget.ExtendImageView.3
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
            scheduleAnimation(animation2, new Runnable() { // from class: com.qzone.widget.ExtendImageView.4
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
            scheduleAnimation(animation2, new Runnable() { // from class: com.qzone.widget.ExtendImageView.5
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
        this.mBlockMeasurement = true;
        this.mForeground.e(drawable);
        this.mBlockMeasurement = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAnimation(Animation animation, Runnable runnable) {
        if (animation == null) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            clearAnimation();
            animation.setAnimationListener(new b(runnable));
            startAnimation(animation);
        }
    }

    public ExtendImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMeasuredExactly = false;
        this.mBlockMeasurement = false;
        this.mIgnoreContentBounds = false;
        this.mAdjustViewBounds = false;
        this.mTmpRectF = new RectF();
        this.mForeground = new ab(this, null);
    }

    public ExtendImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mMeasuredExactly = false;
        this.mBlockMeasurement = false;
        this.mIgnoreContentBounds = false;
        this.mAdjustViewBounds = false;
        this.mTmpRectF = new RectF();
        this.mForeground = new ab(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f60368d;

        b(Runnable runnable) {
            this.f60368d = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Runnable runnable = this.f60368d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
