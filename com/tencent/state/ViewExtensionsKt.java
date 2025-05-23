package com.tencent.state;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.state.service.ImageService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\u001a\u0016\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t\u001a\"\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f\u001a2\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t\u001a\u0012\u0010\u0016\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0007\u001a\u0012\u0010\u0016\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u0010\u0016\u001a\u00020\t*\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0007\u001a\u0012\u0010\u0016\u001a\u00020\t*\u00020\u00182\u0006\u0010\u0017\u001a\u00020\t\u001a\n\u0010\u0019\u001a\u00020\u000b*\u00020\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u000b*\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u001a\u0012\u0010\u001e\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0001\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u0002\u001a-\u0010!\u001a\u00020\u000b\"\b\b\u0000\u0010\"*\u00020#*\u00020\u00022\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u00020\u000b0%\u00a2\u0006\u0002\b&\u001a2\u0010'\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t\u001a\n\u0010(\u001a\u00020 *\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\u00a8\u0006)"}, d2 = {"isVisible", "", "Landroid/view/View;", "(Landroid/view/View;)Z", "hypotenuse", "", "leg1", "", "leg2", "", "animateScrollBy", "", "dx", "dy", "duration", "", "copy", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "dip", "dpValue", "Landroidx/fragment/app/Fragment;", "removeFromSuperview", "setUri", "Landroid/widget/ImageView;", LayoutAttrDefine.CLICK_URI, "", "setVisibility", "squareAnimate", "Lcom/tencent/state/ISquareAnimator;", "updateLayoutParams", "LP", "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "updatePadding", "viewAnimate", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ViewExtensionsKt {
    public static final void animateScrollBy(final View animateScrollBy, float f16, float f17, long j3) {
        Intrinsics.checkNotNullParameter(animateScrollBy, "$this$animateScrollBy");
        ValueAnimator animator = ValueAnimator.ofObject(new TypeEvaluator<PointF>() { // from class: com.tencent.state.ViewExtensionsKt$animateScrollBy$animator$1
            @Override // android.animation.TypeEvaluator
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                Intrinsics.checkNotNullParameter(startValue, "startValue");
                Intrinsics.checkNotNullParameter(endValue, "endValue");
                float f18 = startValue.x;
                float f19 = f18 + ((endValue.x - f18) * fraction);
                float f26 = startValue.y;
                return new PointF(f19, f26 + ((endValue.y - f26) * fraction));
            }
        }, new PointF(animateScrollBy.getScrollX(), animateScrollBy.getScrollY()), new PointF(animateScrollBy.getScrollX() + f16, animateScrollBy.getScrollY() + f17));
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.setDuration(j3);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.state.ViewExtensionsKt$animateScrollBy$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                if (animatedValue != null) {
                    PointF pointF = (PointF) animatedValue;
                    animateScrollBy.scrollBy((int) (pointF.x - r0.getScrollX()), (int) (pointF.y - animateScrollBy.getScrollY()));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
            }
        });
        animator.start();
    }

    public static final Rect copy(Rect copy, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(copy, "$this$copy");
        return new Rect(i3, i16, i17, i18);
    }

    public static final int dip(Fragment dip, int i3) {
        Intrinsics.checkNotNullParameter(dip, "$this$dip");
        Resources resources = dip.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((i3 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static final int hypotenuse(int i3, int i16) {
        return (int) Math.sqrt((i3 * i3) + (i16 * i16));
    }

    public static final boolean isVisible(View isVisible) {
        Intrinsics.checkNotNullParameter(isVisible, "$this$isVisible");
        return isVisible.getVisibility() == 0;
    }

    public static final void removeFromSuperview(View removeFromSuperview) {
        Intrinsics.checkNotNullParameter(removeFromSuperview, "$this$removeFromSuperview");
        ViewParent parent = removeFromSuperview.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(removeFromSuperview);
        }
    }

    public static final void setUri(ImageView setUri, String str) {
        Intrinsics.checkNotNullParameter(setUri, "$this$setUri");
        ImageService.Companion companion = ImageService.INSTANCE;
        ImageLoader loader = companion.getLoader();
        if (loader != null) {
            loader.cancelDisplayTask(setUri);
        }
        ImageLoader loader2 = companion.getLoader();
        if (loader2 != null) {
            loader2.displayImage(str, setUri);
        }
    }

    public static final void setVisibility(View setVisibility, boolean z16) {
        Intrinsics.checkNotNullParameter(setVisibility, "$this$setVisibility");
        setVisibility.setVisibility(z16 ? 0 : 8);
    }

    public static final ISquareAnimator squareAnimate(View squareAnimate) {
        Intrinsics.checkNotNullParameter(squareAnimate, "$this$squareAnimate");
        return new SquarePropAnimator(squareAnimate);
    }

    public static final <LP extends ViewGroup.LayoutParams> void updateLayoutParams(View updateLayoutParams, Function1<? super LP, Unit> block) {
        Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewGroup.LayoutParams layoutParams = updateLayoutParams.getLayoutParams();
        if (layoutParams != null) {
            block.invoke(layoutParams);
            updateLayoutParams.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type LP");
    }

    public static final void updatePadding(View updatePadding, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(updatePadding, "$this$updatePadding");
        updatePadding.setPadding(i3, i16, i17, i18);
    }

    public static final ISquareAnimator viewAnimate(View viewAnimate) {
        Intrinsics.checkNotNullParameter(viewAnimate, "$this$viewAnimate");
        return new SquareViewAnimator(viewAnimate);
    }

    public static final int dip(Fragment dip, float f16) {
        Intrinsics.checkNotNullParameter(dip, "$this$dip");
        Resources resources = dip.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static final double hypotenuse(float f16, float f17) {
        return Math.sqrt((f16 * f16) + (f17 * f17));
    }

    public static final int dip(View dip, int i3) {
        Intrinsics.checkNotNullParameter(dip, "$this$dip");
        Resources resources = dip.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((i3 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static final float dip(View dip, float f16) {
        Intrinsics.checkNotNullParameter(dip, "$this$dip");
        Resources resources = dip.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (f16 * resources.getDisplayMetrics().density) + 0.5f;
    }

    public static /* synthetic */ Rect copy$default(Rect rect, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = rect.left;
        }
        if ((i19 & 2) != 0) {
            i16 = rect.top;
        }
        if ((i19 & 4) != 0) {
            i17 = rect.right;
        }
        if ((i19 & 8) != 0) {
            i18 = rect.bottom;
        }
        return copy(rect, i3, i16, i17, i18);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = view.getPaddingLeft();
        }
        if ((i19 & 2) != 0) {
            i16 = view.getPaddingTop();
        }
        if ((i19 & 4) != 0) {
            i17 = view.getPaddingRight();
        }
        if ((i19 & 8) != 0) {
            i18 = view.getPaddingBottom();
        }
        updatePadding(view, i3, i16, i17, i18);
    }
}
