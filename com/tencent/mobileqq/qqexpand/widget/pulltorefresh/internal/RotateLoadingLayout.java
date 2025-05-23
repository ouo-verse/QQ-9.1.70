package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RotateLoadingLayout extends a {
    private final Animation J;
    private final Matrix K;
    private final boolean L;
    private float M;
    private float N;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.L = typedArray.getBoolean(tg2.a.f436129b4, true);
        this.f264247d.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.K = matrix;
        this.f264247d.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.J = rotateAnimation;
        rotateAnimation.setInterpolator(a.I);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
    }

    private void q() {
        Matrix matrix = this.K;
        if (matrix != null) {
            matrix.reset();
            this.f264247d.setImageMatrix(this.K);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected int h() {
        return R.drawable.d5s;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    public void i(Drawable drawable) {
        if (drawable != null) {
            this.M = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.N = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void j(float f16) {
        float max;
        if (this.L) {
            max = f16 * 90.0f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (f16 * 360.0f) - 180.0f));
        }
        this.K.setRotate(max, this.M, this.N);
        this.f264247d.setImageMatrix(this.K);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void l() {
        this.f264247d.startAnimation(this.J);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void n() {
        this.f264247d.clearAnimation();
        q();
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
    protected void k() {
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a
    protected void m() {
    }
}
