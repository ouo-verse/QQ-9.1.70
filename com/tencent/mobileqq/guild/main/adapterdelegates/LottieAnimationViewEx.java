package com.tencent.mobileqq.guild.main.adapterdelegates;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class LottieAnimationViewEx extends LottieAnimationView {
    public LottieAnimationViewEx(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean isShown() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public LottieAnimationViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LottieAnimationViewEx(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
