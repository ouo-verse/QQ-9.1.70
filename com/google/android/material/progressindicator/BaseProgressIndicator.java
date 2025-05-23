package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.internal.o;
import com.google.android.material.progressindicator.b;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.b> extends ProgressBar {
    static final int K = 2131953476;
    private long C;
    com.google.android.material.progressindicator.a D;
    private boolean E;
    private int F;
    private final Runnable G;
    private final Runnable H;
    private final Animatable2Compat.AnimationCallback I;
    private final Animatable2Compat.AnimationCallback J;

    /* renamed from: d, reason: collision with root package name */
    S f33936d;

    /* renamed from: e, reason: collision with root package name */
    private int f33937e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33938f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33939h;

    /* renamed from: i, reason: collision with root package name */
    private final int f33940i;

    /* renamed from: m, reason: collision with root package name */
    private final int f33941m;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface ShowAnimationBehavior {
    }

    /* loaded from: classes2.dex */
    class a extends Animatable2Compat.AnimationCallback {
        a() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.f33937e, BaseProgressIndicator.this.f33938f);
        }
    }

    /* loaded from: classes2.dex */
    class b extends Animatable2Compat.AnimationCallback {
        b() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (!BaseProgressIndicator.this.E) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setVisibility(baseProgressIndicator.F);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(k1.a.c(context, attributeSet, i3, K), attributeSet, i3);
        this.C = -1L;
        this.E = false;
        this.F = 4;
        this.G = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.p();
            }
        };
        this.H = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.2
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.o();
                BaseProgressIndicator.this.C = -1L;
            }
        };
        this.I = new a();
        this.J = new b();
        Context context2 = getContext();
        this.f33936d = i(context2, attributeSet);
        TypedArray h16 = o.h(context2, attributeSet, w0.a.Q, i3, i16, new int[0]);
        this.f33940i = h16.getInt(w0.a.V, -1);
        this.f33941m = Math.min(h16.getInt(w0.a.T, -1), 1000);
        h16.recycle();
        this.D = new com.google.android.material.progressindicator.a();
        this.f33939h = true;
    }

    @Nullable
    private g<S> j() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().y();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ((f) getCurrentDrawable()).t(false, false, true);
        if (r()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f33941m > 0) {
            this.C = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean r() {
        if ((getProgressDrawable() != null && getProgressDrawable().isVisible()) || (getIndeterminateDrawable() != null && getIndeterminateDrawable().isVisible())) {
            return false;
        }
        return true;
    }

    private void s() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().x().d(this.I);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.J);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.J);
        }
    }

    private void t() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.J);
            getIndeterminateDrawable().x().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.J);
        }
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        if (isIndeterminate()) {
            return getIndeterminateDrawable();
        }
        return getProgressDrawable();
    }

    protected void h(boolean z16) {
        if (!this.f33939h) {
            return;
        }
        ((f) getCurrentDrawable()).t(u(), false, z16);
    }

    abstract S i(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar
    @Nullable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public i<S> getIndeterminateDrawable() {
        return (i) super.getIndeterminateDrawable();
    }

    @NonNull
    public int[] l() {
        return this.f33936d.f33952c;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e<S> getProgressDrawable() {
        return (e) super.getProgressDrawable();
    }

    @Px
    public int n() {
        return this.f33936d.f33950a;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
        if (u()) {
            p();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.H);
        removeCallbacks(this.G);
        ((f) getCurrentDrawable()).j();
        t();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i3, int i16) {
        int paddingLeft;
        int paddingTop;
        super.onMeasure(i3, i16);
        g<S> j3 = j();
        if (j3 == null) {
            return;
        }
        int e16 = j3.e();
        int d16 = j3.d();
        if (e16 < 0) {
            paddingLeft = getMeasuredWidth();
        } else {
            paddingLeft = e16 + getPaddingLeft() + getPaddingRight();
        }
        if (d16 < 0) {
            paddingTop = getMeasuredHeight();
        } else {
            paddingTop = d16 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i3) {
        boolean z16;
        super.onVisibilityChanged(view, i3);
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        h(z16);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        h(false);
    }

    boolean q() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() != 0) {
                    return false;
                }
                return true;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull com.google.android.material.progressindicator.a aVar) {
        this.D = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f33977f = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f33977f = aVar;
        }
    }

    public void setHideAnimationBehavior(int i3) {
        this.f33936d.f33955f = i3;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z16) {
        if (z16 == isIndeterminate()) {
            return;
        }
        f fVar = (f) getCurrentDrawable();
        if (fVar != null) {
            fVar.j();
        }
        super.setIndeterminate(z16);
        f fVar2 = (f) getCurrentDrawable();
        if (fVar2 != null) {
            fVar2.t(u(), false, false);
        }
        if ((fVar2 instanceof i) && u()) {
            ((i) fVar2).x().g();
        }
        this.E = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (drawable instanceof i) {
                ((f) drawable).j();
                super.setIndeterminateDrawable(drawable);
                return;
            }
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{z0.a.b(getContext(), R.attr.a88, -1)};
        }
        if (!Arrays.equals(l(), iArr)) {
            this.f33936d.f33952c = iArr;
            getIndeterminateDrawable().x().c();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i3) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i3, false);
    }

    public void setProgressCompat(int i3, boolean z16) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.f33937e = i3;
                this.f33938f = z16;
                this.E = true;
                if (getIndeterminateDrawable().isVisible() && this.D.a(getContext().getContentResolver()) != 0.0f) {
                    getIndeterminateDrawable().x().f();
                    return;
                } else {
                    this.I.onAnimationEnd(getIndeterminateDrawable());
                    return;
                }
            }
            return;
        }
        super.setProgress(i3);
        if (getProgressDrawable() != null && !z16) {
            getProgressDrawable().jumpToCurrentState();
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (drawable instanceof e) {
                e eVar = (e) drawable;
                eVar.j();
                super.setProgressDrawable(eVar);
                eVar.D(getProgress() / getMax());
                return;
            }
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i3) {
        this.f33936d.f33954e = i3;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i3) {
        S s16 = this.f33936d;
        if (s16.f33953d != i3) {
            s16.f33953d = i3;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i3) {
        S s16 = this.f33936d;
        if (s16.f33951b != i3) {
            s16.f33951b = Math.min(i3, s16.f33950a / 2);
        }
    }

    public void setTrackThickness(@Px int i3) {
        S s16 = this.f33936d;
        if (s16.f33950a != i3) {
            s16.f33950a = i3;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i3) {
        if (i3 != 0 && i3 != 4 && i3 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.F = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        if (ViewCompat.isAttachedToWindow(this) && getWindowVisibility() == 0 && q()) {
            return true;
        }
        return false;
    }
}
