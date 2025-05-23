package com.tencent.aelight.camera.ae.album.nocropper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECropperImageView extends ImageView {
    private float C;
    private float D;
    private float E;
    private boolean F;
    private boolean G;
    private boolean H;
    public Bitmap I;
    private boolean J;
    private g K;
    private boolean L;
    private boolean M;
    private boolean N;
    private int P;
    private boolean Q;
    private boolean R;
    Animator.AnimatorListener S;
    private int T;

    /* renamed from: d, reason: collision with root package name */
    private float[] f62152d;

    /* renamed from: e, reason: collision with root package name */
    protected GestureDetector f62153e;

    /* renamed from: f, reason: collision with root package name */
    protected ScaleGestureDetector f62154f;

    /* renamed from: h, reason: collision with root package name */
    private float f62155h;

    /* renamed from: i, reason: collision with root package name */
    private float f62156i;

    /* renamed from: m, reason: collision with root package name */
    private float f62157m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    public @interface RatioType {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f62158d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f62159e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f62160f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f62161h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f62162i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ float f62163m;

        a(float f16, float f17, float f18, float f19, float f26, float f27) {
            this.f62158d = f16;
            this.f62159e = f17;
            this.f62160f = f18;
            this.f62161h = f19;
            this.f62162i = f26;
            this.f62163m = f27;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Matrix imageMatrix = AECropperImageView.this.getImageMatrix();
            imageMatrix.reset();
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            float intValue = (((this.f62158d - this.f62159e) * num.intValue()) / 20.0f) + this.f62159e;
            imageMatrix.postScale(intValue, intValue);
            imageMatrix.postTranslate((((this.f62160f - this.f62161h) * num.intValue()) / 20.0f) + this.f62161h, (((this.f62162i - this.f62163m) * num.intValue()) / 20.0f) + this.f62163m);
            AECropperImageView.this.setImageMatrix(imageMatrix);
            AECropperImageView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AECropperImageView.this.M = false;
            Animator.AnimatorListener animatorListener = AECropperImageView.this.S;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AECropperImageView.this.M = false;
            Animator.AnimatorListener animatorListener = AECropperImageView.this.S;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            AECropperImageView.this.M = true;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AECropperImageView.this.M = true;
            Animator.AnimatorListener animatorListener = AECropperImageView.this.S;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Matrix f62165d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f62166e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f62167f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f62168h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f62169i;

        c(Matrix matrix, float f16, float f17, float f18, float f19) {
            this.f62165d = matrix;
            this.f62166e = f16;
            this.f62167f = f17;
            this.f62168h = f18;
            this.f62169i = f19;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Matrix imageMatrix = AECropperImageView.this.getImageMatrix();
            imageMatrix.postTranslate((this.f62166e * floatValue) - (AECropperImageView.this.D(this.f62165d, 2) - this.f62167f), (this.f62168h * floatValue) - (AECropperImageView.this.D(this.f62165d, 5) - this.f62169i));
            AECropperImageView.this.setImageMatrix(imageMatrix);
            AECropperImageView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends com.tencent.mobileqq.widget.f {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AECropperImageView.this.M = false;
            Animator.AnimatorListener animatorListener = AECropperImageView.this.S;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AECropperImageView.this.M = false;
            Animator.AnimatorListener animatorListener = AECropperImageView.this.S;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            AECropperImageView.this.M = true;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AECropperImageView.this.M = true;
            Animator.AnimatorListener animatorListener = AECropperImageView.this.S;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f62172d;

        e(float f16) {
            this.f62172d = f16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Matrix imageMatrix = AECropperImageView.this.getImageMatrix();
            if (AECropperImageView.this.G(imageMatrix) <= AECropperImageView.this.f62156i) {
                return;
            }
            float pow = (float) Math.pow(AECropperImageView.this.f62156i / this.f62172d, 0.05000000074505806d);
            imageMatrix.postScale(pow, pow, AECropperImageView.this.D, AECropperImageView.this.E);
            AECropperImageView.this.setImageMatrix(imageMatrix);
            AECropperImageView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f extends com.tencent.mobileqq.widget.f {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AECropperImageView.this.M = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AECropperImageView.this.M = false;
            AECropperImageView.this.n();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            AECropperImageView.this.M = true;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AECropperImageView.this.M = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface g {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        h() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (!AECropperImageView.this.R) {
                return false;
            }
            if (AECropperImageView.this.N) {
                ms.a.c("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
                return false;
            }
            if (motionEvent != null && motionEvent2 != null && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1) {
                AECropperImageView.this.J(f16, f17);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        i() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (!AECropperImageView.this.R || AECropperImageView.this.T == 2) {
                return false;
            }
            if (AECropperImageView.this.N) {
                ms.a.c("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
                return false;
            }
            Matrix imageMatrix = AECropperImageView.this.getImageMatrix();
            AECropperImageView.this.D = scaleGestureDetector.getFocusX();
            AECropperImageView.this.E = scaleGestureDetector.getFocusY();
            imageMatrix.postScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            AECropperImageView.this.setImageMatrix(imageMatrix);
            AECropperImageView.this.invalidate();
            return true;
        }
    }

    public AECropperImageView(Context context) {
        super(context);
        this.f62152d = new float[9];
        this.f62155h = 0.0f;
        this.f62156i = 0.0f;
        this.f62157m = 0.0f;
        this.C = 0.0f;
        this.F = false;
        this.G = false;
        this.H = true;
        this.J = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.P = -1;
        this.Q = false;
        this.R = true;
        this.S = null;
        this.T = 1;
        H(context, null);
    }

    private float A(int i3, int i16, int i17) {
        float f16;
        float f17;
        float f18 = i3;
        float f19 = i16;
        float f26 = (f18 * 1.0f) / f19;
        if (f26 <= 0.33333334f) {
            f16 = i17;
            f18 /= 0.33333334f;
        } else {
            if (f26 >= 1.7777778f) {
                f17 = i17;
                f19 *= 1.7777778f;
            } else if (f26 < 1.0f) {
                f17 = i17 * 1.0f;
            } else {
                f16 = i17 * 1.0f;
            }
            return f17 / f19;
        }
        return f16 / f18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float D(Matrix matrix, int i3) {
        matrix.getValues(this.f62152d);
        return this.f62152d[i3];
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x035b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean K() {
        float width;
        float f16;
        float f17;
        float f18;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return false;
        }
        Matrix imageMatrix = getImageMatrix();
        float D = D(imageMatrix, 2);
        float D2 = D(imageMatrix, 5);
        float D3 = D(imageMatrix, 0);
        float D4 = D(imageMatrix, 4);
        if (this.Q) {
            ms.a.a("AECropperImageView", "onUp( tx = " + D + ", ty = " + D2 + ")");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onUp() - scale: ");
            sb5.append(D3);
            ms.a.a("AECropperImageView", sb5.toString());
            ms.a.a("AECropperImageView", "onUp() - min, max, base zoom: " + this.f62155h + ", " + this.f62156i + ", " + this.f62157m);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("onUp() - imageview size: ");
            sb6.append(getWidth());
            sb6.append(" ");
            sb6.append(getHeight());
            ms.a.a("AECropperImageView", sb6.toString());
            ms.a.a("AECropperImageView", "onUp() - drawable size: " + drawable.getIntrinsicWidth() + " " + drawable.getIntrinsicHeight());
            ms.a.a("AECropperImageView", "onUp() - scaled drawable size: " + (((float) drawable.getIntrinsicWidth()) * D3) + " " + (((float) drawable.getIntrinsicHeight()) * D4));
            StringBuilder sb7 = new StringBuilder();
            sb7.append("onUp() - h diff: ");
            sb7.append(((((float) drawable.getIntrinsicHeight()) * D4) + D2) - ((float) getHeight()));
            ms.a.a("AECropperImageView", sb7.toString());
        }
        float f19 = this.f62155h;
        float f26 = 0.0f;
        if (D3 < f19 && f19 >= this.f62157m) {
            ms.a.f("AECropperImageView", "onUp(" + D3 + ", " + this.f62155h + ", " + this.f62157m + ") - 1 scaleX < mMinZoom && mMinZoom >= mBaseZoom");
            if (this.Q) {
                ms.a.a("AECropperImageView", "onUp() - set scale to min zoom: " + this.f62155h);
            }
            float width2 = (getWidth() / 2) - ((this.f62155h * drawable.getIntrinsicWidth()) / 2.0f);
            float height = (getHeight() / 2) - ((this.f62155h * drawable.getIntrinsicHeight()) / 2.0f);
            if (drawable.getIntrinsicHeight() > drawable.getIntrinsicWidth()) {
                if (D2 >= 0.0f) {
                    f18 = width2;
                    height = 0.0f;
                } else {
                    if ((drawable.getIntrinsicHeight() * D4) + D2 <= getHeight()) {
                        height = getHeight() - (this.f62155h * drawable.getIntrinsicHeight());
                    } else {
                        float f27 = this.E;
                        height = ((D2 - f27) * (this.f62155h / D4)) + f27;
                    }
                    f18 = width2;
                }
            } else if (D >= 0.0f) {
                f18 = 0.0f;
            } else {
                if ((drawable.getIntrinsicWidth() * D3) + D <= getWidth()) {
                    f17 = getWidth() - (this.f62155h * drawable.getIntrinsicWidth());
                } else {
                    float f28 = this.D;
                    f17 = ((D - f28) * (this.f62155h / D3)) + f28;
                }
                f18 = f17;
            }
            if (L()) {
                p(D, f18, D2, height, D3, this.f62155h);
            } else {
                imageMatrix.reset();
                float f29 = this.f62155h;
                imageMatrix.setScale(f29, f29);
                imageMatrix.postTranslate(f18, height);
                setImageMatrix(imageMatrix);
                invalidate();
                if (this.Q) {
                    ms.a.a("AECropperImageView", "onUp() - scale after invalidate: " + G(imageMatrix));
                }
            }
            return true;
        }
        if (D3 > this.f62157m && D3 > this.C) {
            if (this.F && D3 > this.f62156i) {
                ms.a.f("AECropperImageView", "onUp(" + D3 + ", " + this.f62155h + ", " + this.f62157m + ") - 3 isMaxZoomSet && scaleX > mMaxZoom");
                if (this.Q) {
                    ms.a.a("AECropperImageView", "onUp() - set to max zoom");
                    ms.a.a("AECropperImageView", "onUp() - isMaxZoomSet: " + this.F);
                }
                if (L()) {
                    q();
                } else {
                    float f36 = this.f62156i;
                    imageMatrix.postScale(f36 / D3, f36 / D3, this.D, this.E);
                    setImageMatrix(imageMatrix);
                    invalidate();
                    n();
                }
                return true;
            }
            if (this.Q) {
                ms.a.a("AECropperImageView", "onUp() - adjust to sides");
            }
            n();
            return true;
        }
        ms.a.f("AECropperImageView", "onUp(" + D3 + ", " + this.f62155h + ", " + this.f62157m + ") - 2 scaleX <= mBaseZoom || scaleX <= mBaseZoomBigger");
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicHeight <= intrinsicWidth) {
            f16 = (getHeight() / 2) - ((intrinsicHeight * D3) / 2.0f);
            if (D < 0.0f) {
                width = getWidth() - (D3 * drawable.getIntrinsicWidth());
                if (D >= width) {
                    f26 = D;
                }
                f26 = width;
            }
            if (L()) {
                imageMatrix.reset();
                float f37 = this.f62157m;
                imageMatrix.postScale(f37, f37);
                imageMatrix.postTranslate(D, D2);
                setImageMatrix(imageMatrix);
                o(f26 - D, f16 - D2);
            } else {
                imageMatrix.reset();
                float f38 = this.f62157m;
                imageMatrix.postScale(f38, f38);
                imageMatrix.postTranslate(f26, f16);
                setImageMatrix(imageMatrix);
                invalidate();
            }
            return true;
        }
        width = (getWidth() / 2) - ((D3 * intrinsicWidth) / 2.0f);
        if (D2 < 0.0f) {
            f26 = getHeight() - (D4 * drawable.getIntrinsicHeight());
            if (D2 >= f26) {
                f26 = width;
                f16 = D2;
                if (L()) {
                }
                return true;
            }
        }
        f16 = f26;
        f26 = width;
        if (L()) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n() {
        float f16;
        float f17;
        boolean z16 = false;
        if (getDrawable() == null) {
            return false;
        }
        Matrix imageMatrix = getImageMatrix();
        float D = D(imageMatrix, 2);
        float D2 = D(imageMatrix, 5);
        float D3 = D(imageMatrix, 0);
        float D4 = D(imageMatrix, 4);
        float f18 = 0.0f;
        boolean z17 = true;
        if (D > 0.0f) {
            f17 = -D;
        } else {
            float width = getWidth() - (D3 * r0.getIntrinsicWidth());
            if (D >= width) {
                f16 = 0.0f;
                if (D2 <= 0.0f) {
                    f18 = -D2;
                } else {
                    float height = getHeight() - (D4 * r0.getIntrinsicHeight());
                    if (D2 < height) {
                        f18 = height - D2;
                    } else {
                        z17 = z16;
                    }
                }
                if (z17) {
                    if (L()) {
                        o(f16, f18);
                    } else {
                        imageMatrix.postTranslate(f16, f18);
                        setImageMatrix(imageMatrix);
                        invalidate();
                    }
                }
                return z17;
            }
            f17 = width - D;
        }
        f16 = f17;
        z16 = true;
        if (D2 <= 0.0f) {
        }
        if (z17) {
        }
        return z17;
    }

    private void o(float f16, float f17) {
        Matrix imageMatrix = getImageMatrix();
        float D = D(imageMatrix, 2);
        float D2 = D(imageMatrix, 5);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new c(imageMatrix, f16, D, f17, D2));
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    private void q() {
        float G = G(getImageMatrix());
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 20);
        ofInt.addUpdateListener(new e(G));
        ofInt.addListener(new f());
        ofInt.start();
    }

    private void s(Drawable drawable, int i3) {
        if (drawable == null) {
            if (this.Q) {
                ms.a.c("AECropperImageView", "Drawable is null. I can't fit anything");
            }
        } else {
            if (i3 == 0) {
                if (this.Q) {
                    ms.a.c("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
                    return;
                }
                return;
            }
            this.T = 1;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float x16 = x(this.I.getWidth(), this.I.getHeight(), getWidth());
            Matrix matrix = new Matrix();
            matrix.setScale(x16, x16, this.I.getWidth() / 2.0f, this.I.getHeight() / 2.0f);
            matrix.postTranslate((i3 - intrinsicWidth) / 2, (i3 - intrinsicHeight) / 2);
            setImageMatrix(matrix);
        }
    }

    private void v(Drawable drawable, int i3, boolean z16) {
        if (drawable == null) {
            if (this.Q) {
                ms.a.c("AECropperImageView", "Drawable is null. I can't fit anything");
                return;
            }
            return;
        }
        if (i3 == 0) {
            if (this.Q) {
                ms.a.c("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
                return;
            }
            return;
        }
        this.T = 2;
        if (!z16) {
            int width = this.I.getWidth();
            int height = this.I.getHeight();
            float A = A(width, height, getWidth());
            Matrix matrix = new Matrix();
            matrix.setScale(A, A, width / 2.0f, height / 2.0f);
            matrix.postTranslate((i3 - width) / 2, (i3 - height) / 2);
            setImageMatrix(matrix);
            float D = D(matrix, 2);
            float D2 = D(matrix, 5);
            float D3 = D(matrix, 0);
            if (D3 < this.f62155h) {
                p(D, (getWidth() / 2) - ((this.f62155h * drawable.getIntrinsicWidth()) / 2.0f), D2, (getHeight() / 2) - ((this.f62155h * drawable.getIntrinsicHeight()) / 2.0f), D3, this.f62155h);
                return;
            }
            return;
        }
        int width2 = this.I.getWidth();
        int height2 = this.I.getHeight();
        float A2 = A(width2, height2, getWidth());
        Matrix matrix2 = new Matrix();
        matrix2.setScale(A2, A2, width2 / 2.0f, height2 / 2.0f);
        matrix2.postTranslate((i3 - width2) / 2, (i3 - height2) / 2);
        float D4 = D(matrix2, 2);
        float D5 = D(matrix2, 5);
        float D6 = D(getImageMatrix(), 0);
        int width3 = getWidth() / 2;
        drawable.getIntrinsicWidth();
        int height3 = getHeight() / 2;
        drawable.getIntrinsicHeight();
        p(D4, D4, D5, D5, D6, A2);
    }

    private float x(int i3, int i16, int i17) {
        float f16 = i3;
        float f17 = i16;
        if ((f16 * 1.0f) / f17 <= 1.0f) {
            return (i17 * 1.0f) / f16;
        }
        return (i17 * 1.0f) / f17;
    }

    public int B() {
        Bitmap bitmap = this.I;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return 0;
    }

    public int C() {
        Bitmap bitmap = this.I;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return 0;
    }

    public float E() {
        return this.f62155h;
    }

    public int F() {
        return this.T;
    }

    public boolean I() {
        return this.R;
    }

    public boolean J(float f16, float f17) {
        Matrix imageMatrix = getImageMatrix();
        imageMatrix.postTranslate(-f16, -f17);
        setImageMatrix(imageMatrix);
        invalidate();
        return true;
    }

    public boolean L() {
        return this.L;
    }

    public void M() {
        if (this.I == null) {
            return;
        }
        if (this.T == 2) {
            r();
        } else {
            t();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.Q) {
            ms.a.a("AECropperImageView", "onLayout: " + z16 + " [" + i3 + ", " + i16 + ", " + i17 + ", " + i18 + "]");
        }
        if (this.H) {
            if (getDrawable() == null) {
                if (this.Q) {
                    ms.a.c("AECropperImageView", "drawable is null");
                    return;
                }
                return;
            }
            if (getResources().getConfiguration().orientation == 2) {
                float f16 = i17 - i3;
                this.f62157m = f16 / Math.max(r4.getIntrinsicHeight(), r4.getIntrinsicWidth());
                this.C = f16 / Math.min(r4.getIntrinsicHeight(), r4.getIntrinsicWidth());
            } else {
                float f17 = i18 - i16;
                this.f62157m = f17 / Math.max(r4.getIntrinsicHeight(), r4.getIntrinsicWidth());
                this.C = f17 / Math.min(r4.getIntrinsicHeight(), r4.getIntrinsicWidth());
            }
            if (this.F) {
                float f18 = this.f62157m;
                float f19 = this.f62156i;
                if (f18 > f19) {
                    this.f62157m = f19;
                    this.C = f19;
                    if (this.f62155h > f19) {
                        ms.a.c("AECropperImageView", "min zoom is greater than max zoom. Changing min zoom = max zoom");
                        m(this.f62156i);
                    }
                }
            }
            if (this.f62155h <= 0.0f || !this.G) {
                m(this.f62157m);
            }
            this.H = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int i17 = getContext().getResources().getConfiguration().orientation;
        if (i17 != 1 && i17 != 0) {
            int size = View.MeasureSpec.getSize(i16);
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), size);
        } else {
            int size2 = View.MeasureSpec.getSize(i3);
            setMeasuredDimension(size2, View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.M) {
            ms.a.a("AECropperImageView", "onTouchEvent(isAdjusting) - Can't perform this action right now.");
            return true;
        }
        if (this.N) {
            ms.a.a("AECropperImageView", "onTouchEvent(isCropping) - Can't perform this action right now.");
            return true;
        }
        ms.a.a("AECropperImageView", "onTouchEvent(" + motionEvent.getActionMasked() + ", " + motionEvent.getAction() + ")");
        getParent().requestDisallowInterceptTouchEvent(true);
        if (motionEvent.getActionMasked() == 0) {
            ms.a.a("AECropperImageView", "onTouchEvent(MotionEvent.ACTION_DOWN)");
            g gVar = this.K;
            if (gVar != null) {
                gVar.b();
            }
        }
        this.f62154f.onTouchEvent(motionEvent);
        if (!this.f62154f.isInProgress()) {
            this.f62153e.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 1 && action != 3) {
            return true;
        }
        ms.a.a("AECropperImageView", "onTouchEvent(MotionEvent.ACTION_UP)");
        g gVar2 = this.K;
        if (gVar2 != null) {
            gVar2.a();
        }
        return K();
    }

    public void r() {
        if (this.N) {
            ms.a.c("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            s(drawable, getWidth());
        }
    }

    public void setDEBUG(boolean z16) {
        this.Q = z16;
    }

    public void setGestureCallback(g gVar) {
        this.K = gVar;
    }

    public void setGestureEnabled(boolean z16) {
        this.R = z16;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.N) {
            ms.a.c("AECropperImageView", "Cropping current bitmap. Can't set bitmap now");
            return;
        }
        this.H = true;
        if (bitmap == null) {
            this.I = null;
            super.setImageBitmap(null);
            return;
        }
        if (bitmap.getHeight() > 1280 || (bitmap.getWidth() > 1280 && this.Q)) {
            ms.a.i("AECropperImageView", "Bitmap size greater than 1280. This might cause memory issues");
        }
        this.I = bitmap;
        setMinZoom(A(bitmap.getWidth(), this.I.getHeight(), getWidth()));
        super.setImageBitmap(bitmap);
        if (this.T == 2) {
            u(getDrawable(), getWidth());
        } else {
            s(getDrawable(), getWidth());
        }
        requestLayout();
    }

    public void setMinZoom(float f16) {
        if (m(f16)) {
            this.G = true;
        }
    }

    public void setShowAnimation(boolean z16) {
        this.L = z16;
    }

    public void w(boolean z16) {
        if (this.N) {
            ms.a.c("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            v(drawable, getWidth(), z16);
        }
    }

    public float y() {
        Bitmap bitmap = this.I;
        if (bitmap != null) {
            return x(bitmap.getWidth(), this.I.getHeight(), getWidth());
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.tencent.aelight.camera.ae.album.nocropper.a z() {
        Rect rect;
        int height;
        int i3;
        byte b16;
        if (this.I == null) {
            ms.a.c("AECropperImageView", "original image is not available");
            return null;
        }
        Matrix imageMatrix = getImageMatrix();
        float D = D(imageMatrix, 2);
        float D2 = D(imageMatrix, 5);
        boolean z16 = false;
        z16 = false;
        float D3 = D(imageMatrix, 0);
        if (this.Q) {
            ms.a.a("AECropperImageView", "xTrans: " + D + ", yTrans: " + D2 + " , scale: " + D3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("old bitmap: ");
            sb5.append(this.I.getWidth());
            sb5.append(" ");
            sb5.append(this.I.getHeight());
            ms.a.a("AECropperImageView", sb5.toString());
        }
        if (D > 0.0f && D2 > 0.0f && D3 <= this.f62155h) {
            return com.tencent.aelight.camera.ae.album.nocropper.a.a(this.I, this.J, this.I.getWidth() <= this.I.getHeight() ? (this.I.getHeight() - this.I.getWidth()) / 2 : 0, this.I.getHeight() > this.I.getWidth() ? 0 : (this.I.getWidth() - this.I.getHeight()) / 2, this.P);
        }
        float f16 = (-D2) / D3;
        float height2 = getHeight() / D3;
        float f17 = (-D) / D3;
        float width = getWidth() / D3;
        if (this.Q) {
            ms.a.a("AECropperImageView", "cropY: " + f16);
            ms.a.a("AECropperImageView", "Y: " + height2);
            ms.a.a("AECropperImageView", "cropX: " + f17);
            ms.a.a("AECropperImageView", "X: " + width);
        }
        if (f16 + height2 > this.I.getHeight()) {
            f16 = this.I.getHeight() - height2;
            if (this.Q) {
                ms.a.a("AECropperImageView", "readjust cropY to: " + f16);
            }
        } else if (f16 < 0.0f) {
            if (this.Q) {
                ms.a.a("AECropperImageView", "readjust cropY to: 0.0");
            }
            f16 = 0.0f;
        }
        if (f17 + width > this.I.getWidth()) {
            f17 = this.I.getWidth() - width;
            if (this.Q) {
                ms.a.a("AECropperImageView", "readjust cropX to: " + f17);
            }
        } else if (f17 < 0.0f) {
            if (this.Q) {
                ms.a.a("AECropperImageView", "readjust cropX to: 0.0");
            }
            f17 = 0.0f;
        }
        if (this.I.getHeight() > this.I.getWidth()) {
            if (D >= 0.0f) {
                rect = new Rect(0, (int) f16, this.I.getWidth(), (int) (f16 + height2));
                i3 = (int) ((height2 - this.I.getWidth()) / 2.0f);
                height = 0;
                b16 = true;
            } else {
                rect = new Rect((int) f17, (int) f16, (int) (f17 + width), (int) (f16 + height2));
                i3 = 0;
                height = 0;
                b16 = false;
            }
        } else if (D2 >= 0.0f) {
            rect = new Rect((int) f17, 0, (int) (f17 + width), this.I.getHeight());
            height = (int) ((width - this.I.getHeight()) / 2.0f);
            i3 = 0;
            b16 = true;
        } else {
            rect = new Rect((int) f17, (int) f16, (int) (f17 + width), (int) (f16 + height2));
            i3 = 0;
            height = 0;
            b16 = false;
        }
        byte b17 = b16 == true && !(i3 == 0 && height == 0);
        if (this.J && b17 != false) {
            z16 = true;
        }
        return com.tencent.aelight.camera.ae.album.nocropper.a.b(rect, z16, i3, height, this.P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float G(Matrix matrix) {
        return D(matrix, 0);
    }

    private void p(float f16, float f17, float f18, float f19, float f26, float f27) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 20);
        ofInt.addUpdateListener(new a(f27, f26, f17, f16, f19, f18));
        ofInt.addListener(new b());
        ofInt.start();
    }

    private void u(Drawable drawable, int i3) {
        v(drawable, i3, false);
    }

    public void t() {
        w(false);
    }

    private void H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ls.a.f415480d)) != null) {
            this.P = obtainStyledAttributes.getColor(2, this.P);
            this.J = obtainStyledAttributes.getBoolean(0, true);
            if (obtainStyledAttributes.getBoolean(1, false)) {
                this.T = 2;
            } else {
                this.T = 1;
            }
            obtainStyledAttributes.recycle();
        }
        this.f62153e = new GestureDetector(context, new h(), null, true);
        this.f62154f = new ScaleGestureDetector(context, new i());
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setMaxZoom(float f16) {
        if (f16 <= 0.0f) {
            ms.a.c("AECropperImageView", "Max zoom must be greater than 0");
            return;
        }
        float f17 = this.f62155h;
        if (f17 > 0.0f && f16 < f17) {
            ms.a.c("AECropperImageView", "Max zoom must be greater than min zoom");
        } else {
            this.f62156i = f16;
            this.F = true;
        }
    }

    private boolean m(float f16) {
        if (f16 <= 0.0f) {
            ms.a.c("AECropperImageView", "Min zoom must be greater than 0");
            return false;
        }
        if (this.F && f16 > this.f62156i) {
            ms.a.c("AECropperImageView", "Min zoom must not be greater than max zoom");
            this.f62156i = f16;
        }
        this.G = false;
        this.f62155h = f16;
        return true;
    }

    public AECropperImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62152d = new float[9];
        this.f62155h = 0.0f;
        this.f62156i = 0.0f;
        this.f62157m = 0.0f;
        this.C = 0.0f;
        this.F = false;
        this.G = false;
        this.H = true;
        this.J = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.P = -1;
        this.Q = false;
        this.R = true;
        this.S = null;
        this.T = 1;
        H(context, attributeSet);
    }

    public AECropperImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f62152d = new float[9];
        this.f62155h = 0.0f;
        this.f62156i = 0.0f;
        this.f62157m = 0.0f;
        this.C = 0.0f;
        this.F = false;
        this.G = false;
        this.H = true;
        this.J = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.P = -1;
        this.Q = false;
        this.R = true;
        this.S = null;
        this.T = 1;
        H(context, attributeSet);
    }
}
