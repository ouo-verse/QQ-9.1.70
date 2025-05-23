package com.tencent.mobileqq.vas.hippy.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasLottieAnimationView extends LottieAnimationView {
    public VasLottieAnimationView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 26) {
            cancelAnimation();
        }
    }

    public VasLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VasLottieAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
