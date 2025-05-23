package fh4;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.ui.ViewWrapper;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yn4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0005*\u00020\u0000\u001a\u001e\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\n\u0010\f\u001a\u00020\u000b\"\u00020\u0005\u001a\u0016\u0010\u000f\u001a\u00020\r*\u00020\u00002\n\u0010\f\u001a\u00020\u000b\"\u00020\u0005\u001a*\u0010\u0015\u001a\u00020\r*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010\u001a\u0012\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0005\u001a\u001c\u0010\u001b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u001a\u0014\u0010\u001e\u001a\u00020\u0001*\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u001f"}, d2 = {"Landroid/view/View;", "", ViewStickEventHelper.IS_SHOW, "", "o", "", h.F, "j", "g", "i", "radius", "", NodeProps.COLORS, "Landroid/graphics/drawable/GradientDrawable;", "f", "c", "", "leftTop", "rightTop", "leftBottom", "rightBottom", "e", "height", "k", "targetHeight", "", "duration", "l", "Landroid/view/ViewGroup;", "view", "d", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g {
    @NotNull
    public static final GradientDrawable c(@NotNull View view, @NotNull int... colors) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(colors, "colors");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (colors.length > 1) {
            gradientDrawable.setColors(colors);
        } else {
            gradientDrawable.setColor(colors[0]);
        }
        view.setBackgroundDrawable(gradientDrawable);
        return gradientDrawable;
    }

    public static final boolean d(@NotNull ViewGroup viewGroup, @Nullable View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        if (view == null) {
            return false;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (Intrinsics.areEqual(viewGroup.getChildAt(i3), view)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final GradientDrawable e(@NotNull GradientDrawable gradientDrawable, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(gradientDrawable, "<this>");
        gradientDrawable.setCornerRadii(new float[]{f16, f16, f17, f17, f19, f19, f18, f18});
        return gradientDrawable;
    }

    @NotNull
    public static final GradientDrawable f(@NotNull View view, int i3, @NotNull int... colors) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(colors, "colors");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (colors.length > 1) {
            gradientDrawable.setColors(colors);
        } else {
            gradientDrawable.setColor(colors[0]);
        }
        gradientDrawable.setCornerRadius(i3);
        view.setBackgroundDrawable(gradientDrawable);
        return gradientDrawable;
    }

    public static final int g(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    public static final int h(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[0];
    }

    public static final int i(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    public static final int j(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public static final void k(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        l.b("ViewEx", "keyboardHeight: " + i3);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i3;
        }
        view.setLayoutParams(layoutParams);
    }

    public static final void l(@NotNull View view, final int i3, long j3) {
        Interpolator interpolator;
        Intrinsics.checkNotNullParameter(view, "<this>");
        l.i("ViewEx", " lp:" + view.getLayoutParams());
        if (view.getLayoutParams() == null) {
            return;
        }
        final ViewWrapper viewWrapper = new ViewWrapper(view);
        int height = viewWrapper.getHeight();
        l.i("ViewEx", "targetHeight:" + i3 + "  currentHeight:" + height + " ");
        if (height == i3) {
            return;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(viewWrapper, "height", height, i3);
        if (height > i3) {
            interpolator = b.f.f450694b;
        } else {
            interpolator = b.f.f450693a;
        }
        ofInt.setInterpolator(interpolator);
        ofInt.setDuration(j3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: fh4.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.m(ViewWrapper.this, valueAnimator);
            }
        });
        view.postDelayed(new Runnable() { // from class: fh4.f
            @Override // java.lang.Runnable
            public final void run() {
                g.n(ViewWrapper.this, i3);
            }
        }, j3 + 20);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ViewWrapper viewWrapper, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(viewWrapper, "$viewWrapper");
        if (QLog.isColorLevel()) {
            l.h("ViewEx", 2, "view:" + viewWrapper.getRView() + ", animv:" + valueAnimator.getAnimatedValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ViewWrapper viewWrapper, int i3) {
        Intrinsics.checkNotNullParameter(viewWrapper, "$viewWrapper");
        viewWrapper.setHeight(i3);
    }

    public static final void o(@NotNull View view, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z16) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}
