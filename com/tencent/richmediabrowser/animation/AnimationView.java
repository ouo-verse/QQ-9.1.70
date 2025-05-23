package com.tencent.richmediabrowser.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AnimationView extends View {
    public static final int ANIMATE_HEIGHT = 2;
    public static final int ANIMATE_NONE = 0;
    public static final int ANIMATE_WIDTH = 1;
    private static final int ANIMATION_STATE_DONE = 3;
    private static final int ANIMATION_STATE_RUNNING = 2;
    private static final int ANIMATION_STATE_STARTING = 1;
    AccelerateDecelerateInterpolator accelerateDecelerateInterpolator;
    private AnimationLister animationListener;
    private int backState;
    float bottom;
    private int cutValue;
    private Drawable drawable;
    private Rect drawableRect;
    private RectF dst;
    private Rect endDstRect;
    private Rect endSrcRect;
    boolean freeMode;
    float input;
    private boolean isBackAnimationing;
    boolean isEnter;
    private boolean isEnterAnimationing;
    public boolean isImgCenterCropMode;
    boolean isInAnimation;
    float left;
    private long mAnimationDuringTime;
    private long mAnimationStartTime;
    Paint paint;
    float right;
    private Rect src;
    private Rect startDstRect;
    private Rect startSrcRect;
    private int startState;
    long startTime;
    private int startX;
    private int startY;
    private Rect tempBounds;
    float top;
    ViscousFluidInterpolator viscousFluidInterpolator;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class CutValue {
        public static final int HEIGHT = 2;
        public static final int NONE = 0;
        public static final int WIDTH = 1;
    }

    public AnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.viscousFluidInterpolator = new ViscousFluidInterpolator();
        this.accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.isInAnimation = false;
        this.freeMode = false;
        this.isEnter = true;
        this.startTime = 0L;
        this.paint = new Paint(6);
        this.startState = 3;
        this.backState = 3;
        this.mAnimationDuringTime = 350L;
        this.src = new Rect();
        this.dst = new RectF();
        this.tempBounds = new Rect();
    }

    private void createBackAnimation(Canvas canvas) {
        int i3 = this.backState;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    AnimationLister animationLister = this.animationListener;
                    if (animationLister != null) {
                        animationLister.onExitAnimationEnd();
                    }
                    this.isBackAnimationing = false;
                    this.drawable.setBounds(this.drawableRect);
                    return;
                }
                return;
            }
            doBackAniRun(canvas);
            return;
        }
        if (this.startDstRect != null && this.endDstRect != null && this.drawable != null) {
            this.mAnimationStartTime = SystemClock.uptimeMillis();
            this.backState = 2;
            doBackAniRun(canvas);
            return;
        }
        this.backState = 3;
        this.isBackAnimationing = false;
        super.draw(canvas);
        AnimationLister animationLister2 = this.animationListener;
        if (animationLister2 != null) {
            animationLister2.onExitAnimationEnd();
        }
    }

    private void createEnterAnimation(Canvas canvas) {
        int i3 = this.startState;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.isEnterAnimationing = false;
                    AnimationLister animationLister = this.animationListener;
                    if (animationLister != null) {
                        animationLister.onEnterAnimationEnd();
                    }
                    canvas.save();
                    this.drawable.setBounds(this.endDstRect);
                    this.drawable.draw(canvas);
                    canvas.restore();
                    this.drawable.setBounds(this.drawableRect);
                    return;
                }
                return;
            }
            doEnterAniRun(canvas);
            return;
        }
        if (this.startDstRect != null && this.endDstRect != null && this.drawable != null) {
            this.mAnimationStartTime = SystemClock.uptimeMillis();
            this.startState = 2;
            canvas.save();
            doEnterAniRun(canvas);
            return;
        }
        this.startState = 3;
        this.isEnterAnimationing = false;
        AnimationLister animationLister2 = this.animationListener;
        if (animationLister2 != null) {
            animationLister2.onEnterAnimationEnd();
        }
        super.draw(canvas);
    }

    private void doBackAniRun(Canvas canvas) {
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mAnimationStartTime)) / ((float) this.mAnimationDuringTime);
        if (uptimeMillis >= 1.0f) {
            this.backState = 3;
        }
        float interpolation = this.viscousFluidInterpolator.getInterpolation(Math.min(uptimeMillis, 1.0f));
        Rect rect = this.startDstRect;
        Rect rect2 = this.endDstRect;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i3 = rect2.left;
        int i16 = iArr[0];
        int i17 = rect2.top;
        int i18 = iArr[1];
        Rect rect3 = new Rect(i3 + i16, i17 + i18, rect2.right + i16, rect2.bottom + i18);
        int i19 = rect3.right - rect3.left;
        float f16 = (rect.right - rect.left) + this.startX;
        float f17 = (rect.bottom - rect.top) + this.startY;
        float f18 = i19;
        float f19 = f16 / f18;
        float f26 = rect3.bottom - rect3.top;
        float f27 = f17 / f26;
        canvas.save();
        int i26 = this.cutValue;
        if (i26 == 1) {
            int i27 = rect.left;
            int i28 = iArr[0];
            int i29 = rect.top;
            int i36 = iArr[1];
            canvas.translate((((i27 - i28) - this.startX) - ((rect3.left - i28) * f27)) * interpolation, (((i29 - i36) - this.startY) - ((rect3.top - i36) * f27)) * interpolation);
            float f28 = 1.0f - ((1.0f - f27) * interpolation);
            canvas.scale(f28, f28);
            if (this.isImgCenterCropMode) {
                float f29 = (i19 - r9) / 2.0f;
                canvas.translate((-f29) * interpolation, 0.0f);
                int i37 = rect3.left;
                int i38 = iArr[0];
                float f36 = f29 * interpolation;
                int i39 = rect3.top;
                int i46 = iArr[1];
                canvas.clipRect((i37 - i38) + f36, i39 - i46, (rect3.right - i38) - f36, rect3.bottom - i46);
            } else {
                int i47 = rect3.left;
                int i48 = iArr[0];
                int i49 = rect3.top;
                int i56 = iArr[1];
                canvas.clipRect((i47 - i48) + ((this.startX / f28) * interpolation), (i49 - i56) + ((this.startY / f28) * interpolation), (rect3.right - i48) - ((f18 - (f16 / f27)) * interpolation), rect3.bottom - i56);
            }
        } else if (i26 == 2) {
            int i57 = rect.left;
            int i58 = iArr[0];
            int i59 = rect.top;
            int i65 = iArr[1];
            canvas.translate((((i57 - i58) - this.startX) - ((rect3.left - i58) * f19)) * interpolation, (((i59 - i65) - this.startY) - ((rect3.top - i65) * f19)) * interpolation);
            float f37 = 1.0f - ((1.0f - f19) * interpolation);
            canvas.scale(f37, f37);
            if (this.isImgCenterCropMode) {
                float f38 = (r9 - i19) / 2.0f;
                canvas.translate(0.0f, (-f38) * interpolation);
                int i66 = rect3.left;
                int i67 = iArr[0];
                int i68 = rect3.top;
                int i69 = iArr[1];
                float f39 = f38 * interpolation;
                canvas.clipRect(i66 - i67, (i68 - i69) + f39, rect3.right - i67, (rect3.bottom - i69) - f39);
            } else {
                int i75 = rect3.left;
                int i76 = iArr[0];
                int i77 = rect3.top;
                int i78 = iArr[1];
                canvas.clipRect((i75 - i76) + ((this.startX / f37) * interpolation), (i77 - i78) + ((this.startY / f37) * interpolation), rect3.right - i76, (rect3.bottom - i78) - ((f26 - (f17 / f19)) * interpolation));
            }
        } else {
            int i79 = rect.left;
            int i85 = iArr[0];
            float f46 = ((i79 - i85) - ((rect3.left - i85) * f19)) * interpolation;
            int i86 = rect.top;
            int i87 = iArr[1];
            canvas.translate(f46, ((i86 - i87) - ((rect3.top - i87) * f27)) * interpolation);
            canvas.scale(1.0f - ((1.0f - f19) * interpolation), 1.0f - ((1.0f - f27) * interpolation));
        }
        this.drawable.setBounds(this.endDstRect);
        this.drawable.draw(canvas);
        canvas.restore();
        invalidate();
    }

    private void doEnterAniRun(Canvas canvas) {
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mAnimationStartTime)) / ((float) this.mAnimationDuringTime);
        if (uptimeMillis >= 1.0f) {
            this.startState = 3;
        }
        float interpolation = 1.0f - this.accelerateDecelerateInterpolator.getInterpolation(Math.min(uptimeMillis, 1.0f));
        Rect rect = this.startDstRect;
        Rect rect2 = this.endDstRect;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i3 = rect2.left;
        int i16 = iArr[0];
        int i17 = rect2.top;
        int i18 = iArr[1];
        Rect rect3 = new Rect(i3 + i16, i17 + i18, rect2.right + i16, rect2.bottom + i18);
        int width = rect3.width();
        int height = rect3.height();
        float width2 = rect.width();
        float height2 = rect.height();
        float f16 = width;
        float f17 = width2 / f16;
        float f18 = height;
        float f19 = height2 / f18;
        canvas.save();
        int i19 = this.cutValue;
        if (i19 == 1) {
            int i26 = rect.left;
            int i27 = iArr[0];
            int i28 = rect.top;
            int i29 = iArr[1];
            canvas.translate(((i26 - i27) - ((rect3.left - i27) * f19)) * interpolation, ((i28 - i29) - ((rect3.top - i29) * f19)) * interpolation);
            float f26 = 1.0f - ((1.0f - f19) * interpolation);
            canvas.scale(f26, f26);
            if (this.isImgCenterCropMode) {
                float f27 = (width - height) / 2.0f;
                canvas.translate((-f27) * interpolation, 0.0f);
                int i36 = rect3.left;
                int i37 = iArr[0];
                float f28 = f27 * interpolation;
                int i38 = rect3.top;
                int i39 = iArr[1];
                canvas.clipRect((i36 - i37) + f28, i38 - i39, (rect3.right - i37) - f28, rect3.bottom - i39);
            } else {
                int i46 = rect3.left;
                int i47 = iArr[0];
                int i48 = rect3.top;
                int i49 = iArr[1];
                canvas.clipRect(i46 - i47, i48 - i49, (rect3.right - i47) - ((f16 - (width2 / f19)) * interpolation), rect3.bottom - i49);
            }
        } else if (i19 == 2) {
            int i56 = rect.left;
            int i57 = iArr[0];
            int i58 = rect.top;
            int i59 = iArr[1];
            canvas.translate(((i56 - i57) - ((rect3.left - i57) * f17)) * interpolation, ((i58 - i59) - ((rect3.top - i59) * f17)) * interpolation);
            float f29 = 1.0f - ((1.0f - f17) * interpolation);
            canvas.scale(f29, f29);
            if (this.isImgCenterCropMode) {
                float f36 = (height - width) / 2.0f;
                canvas.translate(0.0f, (-f36) * interpolation);
                int i65 = rect3.left;
                int i66 = iArr[0];
                int i67 = rect3.top;
                int i68 = iArr[1];
                float f37 = f36 * interpolation;
                canvas.clipRect(i65 - i66, (i67 - i68) + f37, rect3.right - i66, (rect3.bottom - i68) - f37);
            } else {
                int i69 = rect3.left;
                int i75 = iArr[0];
                int i76 = rect3.top;
                int i77 = iArr[1];
                canvas.clipRect(i69 - i75, i76 - i77, rect3.right - i75, (rect3.bottom - i77) - ((f18 - (height2 / f17)) * interpolation));
            }
        } else {
            int i78 = rect.left;
            int i79 = iArr[0];
            float f38 = ((i78 - i79) - ((rect3.left - i79) * f17)) * interpolation;
            int i85 = rect.top;
            int i86 = iArr[1];
            canvas.translate(f38, ((i85 - i86) - ((rect3.top - i86) * f19)) * interpolation);
            canvas.scale(1.0f - ((1.0f - f17) * interpolation), 1.0f - ((1.0f - f19) * interpolation));
        }
        this.drawable.setBounds(this.endDstRect);
        this.drawable.draw(canvas);
        canvas.restore();
        invalidate();
    }

    private void onDrawFreeMode(Canvas canvas) {
        super.draw(canvas);
        canvas.save();
        if (this.startTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.startTime;
            float f16 = ((float) currentTimeMillis) / ((float) this.mAnimationDuringTime);
            this.input = f16;
            if (this.isEnter) {
                this.input = this.accelerateDecelerateInterpolator.getInterpolation(f16);
            } else {
                this.input = this.viscousFluidInterpolator.getInterpolation(f16);
            }
            float f17 = this.input;
            float f18 = 1.0f - f17;
            if (this.isInAnimation) {
                if (currentTimeMillis <= this.mAnimationDuringTime) {
                    Rect rect = this.startSrcRect;
                    Rect rect2 = this.endSrcRect;
                    float f19 = (rect.top * f18) + (rect2.top * f17);
                    this.top = f19;
                    float f26 = (rect.bottom * f18) + (rect2.bottom * f17);
                    this.bottom = f26;
                    float f27 = (rect.left * f18) + (rect2.left * f17);
                    this.left = f27;
                    float f28 = (rect.right * f18) + (rect2.right * f17);
                    this.right = f28;
                    this.src.set((int) f27, (int) f19, (int) f28, (int) f26);
                    Rect rect3 = this.startDstRect;
                    float f29 = this.endDstRect.top;
                    float f36 = this.input;
                    float f37 = (rect3.top * f18) + (f29 * f36);
                    this.top = f37;
                    float f38 = (rect3.bottom * f18) + (r2.bottom * f36);
                    this.bottom = f38;
                    float f39 = (rect3.left * f18) + (r2.left * f36);
                    this.left = f39;
                    float f46 = (rect3.right * f18) + (r2.right * f36);
                    this.right = f46;
                    this.dst.set(f39, f37, f46, f38);
                } else {
                    this.isInAnimation = false;
                    AnimationLister animationLister = this.animationListener;
                    if (animationLister != null) {
                        if (this.isEnter) {
                            animationLister.onEnterAnimationEnd();
                        } else {
                            animationLister.onExitAnimationEnd();
                        }
                    }
                }
            }
            float width = this.dst.width() / this.src.width();
            float height = this.dst.height() / this.src.height();
            RectF rectF = this.dst;
            float f47 = rectF.left;
            Rect rect4 = this.src;
            canvas.translate(f47 - (rect4.left * width), rectF.top - (rect4.top * height));
            canvas.scale(width, height);
            canvas.clipRect(this.src);
            this.drawable.draw(canvas);
            invalidate();
        }
        canvas.restore();
    }

    private void startAnimation() {
        this.startTime = System.currentTimeMillis();
        this.isInAnimation = true;
        this.drawableRect = this.drawable.copyBounds();
        Rect rect = new Rect(0, 0, this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
        this.tempBounds = rect;
        this.drawable.setBounds(rect);
    }

    public void onDestroy() {
        setAnimationListener(null);
        this.isInAnimation = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.freeMode) {
            onDrawFreeMode(canvas);
            return;
        }
        if (this.isEnterAnimationing) {
            createEnterAnimation(canvas);
        } else if (this.isBackAnimationing) {
            createBackAnimation(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    public void setAnimationListener(AnimationLister animationLister) {
        this.animationListener = animationLister;
    }

    public void startBackAnimation(Drawable drawable, Rect rect, Rect rect2, int i3, int i16, int i17, long j3) {
        this.backState = 1;
        this.isBackAnimationing = true;
        this.drawable = drawable;
        this.drawableRect = drawable.copyBounds();
        this.startDstRect = rect;
        this.endDstRect = rect2;
        this.cutValue = i3;
        this.startX = i16;
        this.startY = i17;
        this.mAnimationDuringTime = j3;
        AnimationLister animationLister = this.animationListener;
        if (animationLister != null) {
            animationLister.onExitAnimationStart();
        }
        invalidate();
    }

    public void startBackAnimationFreeMode(Drawable drawable, Rect rect, Rect rect2, Rect rect3, Rect rect4, long j3) {
        this.freeMode = true;
        this.isEnter = false;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        Rect rect5 = new Rect(rect3);
        rect5.offset(iArr[0], -iArr[1]);
        this.startSrcRect = rect2;
        this.endSrcRect = rect;
        this.startDstRect = rect4;
        this.endDstRect = rect5;
        this.drawable = drawable;
        this.mAnimationDuringTime = j3;
        startAnimation();
        AnimationLister animationLister = this.animationListener;
        if (animationLister != null) {
            animationLister.onExitAnimationStart();
        }
    }

    public void startEnterAnimation(Drawable drawable, Rect rect, Rect rect2, int i3, long j3) {
        this.startState = 1;
        this.isEnterAnimationing = true;
        this.drawable = drawable;
        this.drawableRect = drawable.copyBounds();
        this.startDstRect = rect;
        this.endDstRect = rect2;
        this.cutValue = i3;
        this.mAnimationDuringTime = j3;
        AnimationLister animationLister = this.animationListener;
        if (animationLister != null) {
            animationLister.onEnterAnimationStart();
        }
        invalidate();
    }

    public void startEnterAnimationFreeMode(Drawable drawable, Rect rect, Rect rect2, Rect rect3, Rect rect4, long j3) {
        this.freeMode = true;
        this.isEnter = true;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        Rect rect5 = new Rect(rect3);
        rect5.offset(iArr[0], -iArr[1]);
        this.startSrcRect = rect;
        this.endSrcRect = rect2;
        this.startDstRect = rect5;
        this.endDstRect = rect4;
        this.drawable = drawable;
        this.mAnimationDuringTime = j3;
        startAnimation();
        AnimationLister animationLister = this.animationListener;
        if (animationLister != null) {
            animationLister.onEnterAnimationStart();
        }
    }
}
