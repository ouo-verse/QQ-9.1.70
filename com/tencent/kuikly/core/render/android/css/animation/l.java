package com.tencent.kuikly.core.render.android.css.animation;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/l;", "Lcom/tencent/kuikly/core/render/android/css/animation/KRCSSSpringAnimationHandler;", "Landroid/view/View;", "target", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "r", "()F", "finalFloatValue", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class l extends KRCSSSpringAnimationHandler {
    @Override // com.tencent.kuikly.core.render.android.css.animation.KRCSSSpringAnimationHandler
    @NotNull
    public FloatPropertyCompat<View> q(@NotNull View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        DynamicAnimation.ViewProperty viewProperty = DynamicAnimation.ALPHA;
        Intrinsics.checkNotNullExpressionValue(viewProperty, "SpringAnimation.ALPHA");
        return viewProperty;
    }

    @Override // com.tencent.kuikly.core.render.android.css.animation.KRCSSSpringAnimationHandler
    public float r() {
        Object finalValue = getFinalValue();
        if (finalValue != null) {
            return com.tencent.kuikly.core.render.android.css.ktx.b.H(finalValue);
        }
        return 1.0f;
    }
}
