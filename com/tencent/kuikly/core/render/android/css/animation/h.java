package com.tencent.kuikly.core.render.android.css.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/h;", "Lcom/tencent/kuikly/core/render/android/css/animation/e;", "Landroid/view/View;", "target", "Landroid/animation/ValueAnimator;", "t", "<init>", "()V", "l", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class h extends e {
    @Override // com.tencent.kuikly.core.render.android.css.animation.e
    @NotNull
    public ValueAnimator t(@NotNull View target) {
        float f16;
        Intrinsics.checkNotNullParameter(target, "target");
        Property property = View.ALPHA;
        Intrinsics.checkNotNullExpressionValue(property, "View.ALPHA");
        String name = property.getName();
        float[] fArr = new float[2];
        fArr[0] = target.getAlpha();
        Object finalValue = getFinalValue();
        if (finalValue != null) {
            f16 = com.tencent.kuikly.core.render.android.css.ktx.b.H(finalValue);
        } else {
            f16 = 1.0f;
        }
        fArr[1] = f16;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(target, name, fArr);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ObjectAnimator.ofFloat(\n\u2026() ?: DEFAULT_ALPHA\n    )");
        return ofFloat;
    }
}
