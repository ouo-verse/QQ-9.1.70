package com.tencent.kuikly.core.render.android.css.animation;

import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/f;", "Lcom/tencent/kuikly/core/render/android/css/animation/e;", "Landroid/view/View;", "target", "Landroid/animation/ValueAnimator;", "t", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class f extends e {
    @Override // com.tencent.kuikly.core.render.android.css.animation.e
    @NotNull
    public ValueAnimator t(@NotNull View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        a aVar = new a(target);
        Object[] objArr = new Object[2];
        objArr[0] = KRCSSViewExtensionKt.p(target);
        Object finalValue = getFinalValue();
        if (finalValue != null) {
            objArr[1] = Integer.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.w((String) finalValue));
            ValueAnimator ofObject = ValueAnimator.ofObject(aVar, objArr);
            Intrinsics.checkNotNullExpressionValue(ofObject, "ValueAnimator.ofObject(\n\u2026lue as String).toColor())");
            return ofObject;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
