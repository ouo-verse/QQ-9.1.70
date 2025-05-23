package com.tencent.biz.richframework.animation.support;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes5.dex */
public class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
    private TimeInterpolator mDefaultInterpolator;

    @Override // com.tencent.biz.richframework.animation.support.AnimatorProvider
    public void clearInterpolator(View view) {
        if (this.mDefaultInterpolator == null) {
            this.mDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.mDefaultInterpolator);
    }
}
