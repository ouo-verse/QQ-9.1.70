package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes16.dex */
public class FlipLoadingLayout extends com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a {
    private final Animation J;
    private final Animation K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f264246a;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            f264246a = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f264246a[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FlipLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        int i3;
        if (mode == PullToRefreshBase.Mode.PULL_FROM_START) {
            i3 = -180;
        } else {
            i3 = 180;
        }
        float f16 = i3;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f16, 1, 0.5f, 1, 0.5f);
        this.J = rotateAnimation;
        Interpolator interpolator = com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a.I;
        rotateAnimation.setInterpolator(interpolator);
        rotateAnimation.setDuration(150L);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(f16, 0.0f, 1, 0.5f, 1, 0.5f);
        this.K = rotateAnimation2;
        rotateAnimation2.setInterpolator(interpolator);
        rotateAnimation2.setDuration(150L);
        rotateAnimation2.setFillAfter(true);
    }

    private float q() {
        int i3 = a.f264246a[this.f264249f.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && this.f264250h == PullToRefreshBase.Orientation.HORIZONTAL) {
                return 270.0f;
            }
            return 0.0f;
        }
        if (this.f264250h == PullToRefreshBase.Orientation.HORIZONTAL) {
            return 90.0f;
        }
        return 180.0f;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase
    public /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected int h() {
        return R.drawable.ci9;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void i(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.f264247d.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.f264247d.requestLayout();
            this.f264247d.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(q(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.f264247d.setImageMatrix(matrix);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void k() {
        if (this.J == this.f264247d.getAnimation()) {
            this.f264247d.startAnimation(this.K);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void l() {
        this.f264247d.clearAnimation();
        this.f264247d.setVisibility(4);
        this.f264248e.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void m() {
        this.f264247d.startAnimation(this.J);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void n() {
        this.f264247d.clearAnimation();
        this.f264248e.setVisibility(8);
        this.f264247d.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public /* bridge */ /* synthetic */ void setLastUpdatedLabel(CharSequence charSequence) {
        super.setLastUpdatedLabel(charSequence);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public /* bridge */ /* synthetic */ void setPullLabel(CharSequence charSequence) {
        super.setPullLabel(charSequence);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public /* bridge */ /* synthetic */ void setRefreshResultLabel(CharSequence charSequence) {
        super.setRefreshResultLabel(charSequence);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public /* bridge */ /* synthetic */ void setRefreshingLabel(CharSequence charSequence) {
        super.setRefreshingLabel(charSequence);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public /* bridge */ /* synthetic */ void setReleaseLabel(CharSequence charSequence) {
        super.setReleaseLabel(charSequence);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase
    public /* bridge */ /* synthetic */ void setTextTypeface(Typeface typeface) {
        super.setTextTypeface(typeface);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void j(float f16) {
    }
}
