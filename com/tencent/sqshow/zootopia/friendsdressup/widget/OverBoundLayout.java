package com.tencent.sqshow.zootopia.friendsdressup.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00029:B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\f\u00a2\u0006\u0004\b6\u00107J\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ@\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J8\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fH\u0016J0\u0010 \u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\fH\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u0006;"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/widget/OverBoundLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent3;", "Landroid/view/View;", "", "detail", "", "c", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/OverBoundLayout$b;", "listener", "setListener", "target", "", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "", "consumed", "onNestedScroll", "child", "axes", "", "onStartNestedScroll", "onNestedScrollAccepted", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "onStopNestedScroll", "dx", "dy", "onNestedPreScroll", "d", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/OverBoundLayout$b;", "Landroidx/core/view/NestedScrollingParentHelper;", "e", "Landroidx/core/view/NestedScrollingParentHelper;", "getHelper", "()Landroidx/core/view/NestedScrollingParentHelper;", "helper", "Landroid/animation/Animator;", "f", "Landroid/animation/Animator;", "getAnimator", "()Landroid/animation/Animator;", "setAnimator", "(Landroid/animation/Animator;)V", "animator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class OverBoundLayout extends FrameLayout implements NestedScrollingParent3 {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final NestedScrollingParentHelper helper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Animator animator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/widget/OverBoundLayout$b;", "", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverBoundLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View target, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(target, "$target");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        target.setTranslationX(((Float) animatedValue).floatValue());
    }

    private final void c(View view, float f16) {
        b bVar;
        if ((view.getTranslationX() == 0.0f) && f16 < 0.0f && (bVar = this.listener) != null) {
            bVar.a();
        }
        view.setTranslationX(f16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.isRunning() == true) goto L8;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        boolean z16;
        Animator animator = this.animator;
        if (animator != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            return false;
        }
        return super.dispatchTouchEvent(ev5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
    
        r5 = (int) 0.0f;
        r6 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        r6 = r6 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        if (java.lang.Math.abs(r6) > java.lang.Math.abs(r5)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        if (java.lang.Math.abs(r6) > java.lang.Math.abs(r5)) goto L17;
     */
    @Override // androidx.core.view.NestedScrollingParent2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNestedPreScroll(View target, int dx5, int dy5, int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        float translationX = target.getTranslationX();
        if ((translationX == 0.0f) || dx5 == 0) {
            return;
        }
        if (dx5 > 0) {
            if (translationX >= 0.0f) {
            }
            dx5 = 0;
        } else {
            if (translationX <= 0.0f) {
            }
            dx5 = 0;
        }
        consumed[0] = dx5;
        c(target, translationX);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.helper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        return axes == 1;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(final View target, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        com.tencent.sqshow.zootopia.friendsdressup.a.b("AvatarBoundLayout", "onStopNestedScroll  " + type);
        float translationX = target.getTranslationX();
        Animator animator = this.animator;
        if (animator != null) {
            animator.cancel();
        }
        if (translationX == 0.0f) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(translationX, 0.0f);
        ofFloat.setDuration(50L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OverBoundLayout.b(target, valueAnimator);
            }
        });
        this.animator = ofFloat;
        ofFloat.start();
    }

    public final void setAnimator(Animator animator) {
        this.animator = animator;
    }

    public final void setListener(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverBoundLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (dxUnconsumed != 0) {
            c(target, target.getTranslationX() - (dxUnconsumed * 0.3f));
            consumed[0] = dyUnconsumed;
        }
    }

    public /* synthetic */ OverBoundLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverBoundLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.helper = new NestedScrollingParentHelper(this);
    }
}
