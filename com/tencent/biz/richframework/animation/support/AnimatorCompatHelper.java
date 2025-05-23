package com.tencent.biz.richframework.animation.support;

import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class AnimatorCompatHelper {
    private static final AnimatorProvider IMPL = new HoneycombMr1AnimatorCompatProvider();

    public static void clearInterpolator(View view) {
        IMPL.clearInterpolator(view);
    }
}
