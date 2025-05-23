package com.tencent.kuikly.core.render.android.css.animation;

import android.graphics.Rect;
import android.view.View;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/k;", "Lcom/tencent/kuikly/core/render/android/css/animation/KRCSSSpringAnimationHandler;", "Landroid/view/View;", "target", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "r", "()F", "finalFloatValue", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class k extends KRCSSSpringAnimationHandler {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"com/tencent/kuikly/core/render/android/css/animation/k$a", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", "Landroid/view/View;", "target", "", HippyTextInputController.COMMAND_getValue, "value", "", HippyTextInputController.COMMAND_setValue, "Landroid/graphics/Rect;", "a", "Landroid/graphics/Rect;", "startFrame", "b", "endFrame", "Lcom/tencent/kuikly/core/render/android/css/animation/b;", "c", "Lcom/tencent/kuikly/core/render/android/css/animation/b;", "frameEvaluator", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a extends FloatPropertyCompat<View> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Rect startFrame;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Rect endFrame;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final b frameEvaluator;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f117636e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, String str) {
            super(str);
            this.f117636e = view;
            this.startFrame = com.tencent.kuikly.core.render.android.css.ktx.b.f(view);
            Object finalValue = k.this.getFinalValue();
            if (finalValue != null) {
                this.endFrame = (Rect) finalValue;
                this.frameEvaluator = new b(view);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(@NotNull View target) {
            Intrinsics.checkNotNullParameter(target, "target");
            return 0.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(@NotNull View target, float value) {
            Intrinsics.checkNotNullParameter(target, "target");
            this.frameEvaluator.evaluate(value, this.startFrame, this.endFrame);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.css.animation.KRCSSSpringAnimationHandler
    @NotNull
    public FloatPropertyCompat<View> q(@NotNull View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return new a(target, "Frame");
    }

    @Override // com.tencent.kuikly.core.render.android.css.animation.KRCSSSpringAnimationHandler
    public float r() {
        return 1.0f;
    }
}
