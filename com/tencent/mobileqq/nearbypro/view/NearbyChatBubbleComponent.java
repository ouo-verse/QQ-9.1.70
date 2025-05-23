package com.tencent.mobileqq.nearbypro.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.land.AreaMsgBubbleComponent;
import com.tencent.mobileqq.nearbypro.utils.d;
import ga2.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0005R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/view/NearbyChatBubbleComponent;", "Landroid/widget/FrameLayout;", "", "Landroid/animation/Animator;", "animatorList", "", h.F, "", "f", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/nearbypro/view/Level;", "b", "", "content", "d", "c", "targetView", "level", "e", "a", "g", "Landroid/animation/Animator;", "animatorSet", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyChatBubbleComponent extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private static int f253964f = d.b(20);

    /* renamed from: h, reason: collision with root package name */
    private static int f253965h = d.b(3);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator animatorSet;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253967a;

        static {
            int[] iArr = new int[Level.values().length];
            try {
                iArr[Level.LEVEL_BIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Level.LEVEL_HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Level.LEVEL_SMALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Level.LEVEL_MIDDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f253967a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyChatBubbleComponent(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Level b(View view) {
        Level level;
        Object tag = view.getTag();
        if (tag instanceof Level) {
            level = (Level) tag;
        } else {
            level = null;
        }
        if (level == null) {
            return Level.LEVEL_HIDE;
        }
        return Level.values()[level.ordinal() + 1];
    }

    private final View c(String content) {
        TextView textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        int i3 = f253965h;
        textView.setPadding(i3, i3, i3, i3);
        textView.setLayoutParams(layoutParams);
        textView.setText(content);
        textView.setGravity(17);
        textView.setTextSize(11.0f);
        textView.setSingleLine(true);
        textView.setTextColor(getResources().getColor(R.color.black));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setBackgroundResource(R.drawable.k2l);
        textView.setAlpha(0.2f);
        textView.setScaleX(0.3f);
        textView.setScaleY(0.3f);
        textView.setTranslationY(f253964f);
        textView.setTag(Level.LEVEL_BIG);
        textView.measure(View.MeasureSpec.makeMeasureSpec(AreaMsgBubbleComponent.INSTANCE.a(), 1073741824), 0);
        return textView;
    }

    private final Animator d(String content) {
        View c16 = c(content);
        addView(c16);
        return e(c16, Level.LEVEL_BIG);
    }

    private final Animator e(View targetView, Level level) {
        int i3 = b.f253967a[level.ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.SCALE_X, level.getScale()));
            animatorSet.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.SCALE_Y, level.getScale()));
            animatorSet.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.ALPHA, level.getAlpha()));
            animatorSet.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.TRANSLATION_Y, targetView.getTranslationY() - (targetView.getMeasuredHeight() + f253965h)));
            return animatorSet;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.SCALE_X, level.getScale()));
        animatorSet2.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.SCALE_Y, level.getScale()));
        animatorSet2.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.ALPHA, level.getAlpha()));
        animatorSet2.playTogether(ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.TRANSLATION_Y, 0.0f));
        return animatorSet2;
    }

    private final List<Animator> f() {
        ArrayList arrayList = new ArrayList();
        a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("NearbyChatBubbleComponent", "handleOtherMsgItemStatus childCount=" + getChildCount());
        }
        if (getChildCount() > 3) {
            removeViewAt(0);
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childView = getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            Level b16 = b(childView);
            childView.setTag(b16);
            Animator e16 = e(childView, b16);
            if (e16 != null) {
                arrayList.add(e16);
            }
        }
        return arrayList;
    }

    private final void h(List<? extends Animator> animatorList) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorList);
        animatorSet.setDuration(500L);
        this.animatorSet = animatorSet;
        animatorSet.start();
    }

    public final void a(@NotNull String content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        Animator animator = this.animatorSet;
        boolean z17 = true;
        if (animator != null && animator.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            a c16 = j.c();
            if (c16.isColorLevel()) {
                c16.e("NearbyChatBubbleComponent", "anim isRunning");
                return;
            }
            return;
        }
        if (content.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            List<Animator> f16 = f();
            Animator d16 = d(content);
            if (d16 != null) {
                f16.add(d16);
            }
            h(f16);
        }
    }

    public final void g() {
        Animator animator = this.animatorSet;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyChatBubbleComponent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
