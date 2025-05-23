package com.qzone.reborn.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneTopGestureLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0002*+B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#B\u001b\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b\"\u0010&B#\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010'\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010(J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007R\"\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001e\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/widget/QZoneExpandableLayout;", "Landroid/widget/FrameLayout;", "", "startHeight", "endHeight", "Lcom/tencent/mobileqq/widget/f;", "listener", "", "d", "i", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "Lcom/qzone/reborn/widget/QZoneExpandableLayout$b;", "dismissListener", "f", tl.h.F, "g", "Z", "isExpanded", "()Z", "setExpanded", "(Z)V", "", "e", "J", "showAnimationDelay", "defaultExpand", "isAnimating", "I", NodeProps.MAX_HEIGHT, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneExpandableLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isExpanded;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long showAnimationDelay;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean defaultExpand;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimating;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int maxHeight;
    private static final String C = "QZoneExpandableLayout";
    private static final int D = ViewUtils.dip2px(114.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/qzone/reborn/widget/QZoneExpandableLayout$b;", "", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneExpandableLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(QZoneExpandableLayout this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.getLayoutParams().height = ((Integer) animatedValue).intValue();
        this$0.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(QZoneExpandableLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d(0, this$0.maxHeight, new d());
    }

    public final void f(b dismissListener) {
        Intrinsics.checkNotNullParameter(dismissListener, "dismissListener");
        if (this.isAnimating) {
            QLog.e("QZoneFeedBottomContainer", 1, "execute dismiss animation,isAnimating return!");
            return;
        }
        if (this.isExpanded) {
            this.isAnimating = true;
            this.isExpanded = false;
            QLog.d("QZoneFeedBottomContainer", 2, "execute dismiss animation");
            d(this.maxHeight, 0, new c(dismissListener));
            return;
        }
        g();
        dismissListener.a();
    }

    public final void g() {
        getLayoutParams().height = 0;
        requestLayout();
        setVisibility(8);
        this.isExpanded = false;
        QLog.d("QZoneFeedBottomContainer", 2, "hide bottom container");
    }

    public final void h() {
        if (this.isAnimating && this.isExpanded) {
            QLog.e("QZoneFeedBottomContainer", 2, "execute expand animation,don't show direct return!");
            return;
        }
        getLayoutParams().height = this.maxHeight;
        setVisibility(0);
        this.isExpanded = true;
        requestLayout();
        QLog.d("QZoneFeedBottomContainer", 2, "show bottom container");
    }

    public final void i() {
        if (this.isAnimating) {
            QLog.e("QZoneFeedBottomContainer", 1, "execute expand animation,isAnimating return!");
            return;
        }
        setVisibility(0);
        this.isAnimating = true;
        this.isExpanded = true;
        getLayoutParams().height = 0;
        requestLayout();
        QLog.d("QZoneFeedBottomContainer", 2, "execute expand animation");
        postDelayed(new Runnable() { // from class: com.qzone.reborn.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                QZoneExpandableLayout.j(QZoneExpandableLayout.this);
            }
        }, this.showAnimationDelay);
    }

    public final void setExpanded(boolean z16) {
        this.isExpanded = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneExpandableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d(int startHeight, int endHeight, com.tencent.mobileqq.widget.f listener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(startHeight, endHeight);
        he0.b.m(ofInt, R.anim.f154986ut, 3.3f);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.reborn.widget.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QZoneExpandableLayout.e(QZoneExpandableLayout.this, valueAnimator);
            }
        });
        ofInt.addListener(listener);
        ofInt.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneExpandableLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showAnimationDelay = 500L;
        this.maxHeight = D;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e4.a.f395577c, i3, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026eLayout, defStyleAttr, 0)");
        this.defaultExpand = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        this.isExpanded = this.defaultExpand;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        if (r1 != false) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        boolean z16 = false;
        if (ev5 != null && ev5.getAction() == 0) {
            QZoneTopGestureLayout.setBackEnabled(false);
            FrameHelperActivity.gj(false, "QZoneFeedBottomContainerPresenter");
        } else {
            if (!(ev5 != null && ev5.getAction() == 3)) {
                if (ev5 != null && ev5.getAction() == 1) {
                    z16 = true;
                }
            }
            QZoneTopGestureLayout.setBackEnabled(true);
            FrameHelperActivity.gj(true, "QZoneFeedBottomContainerPresenter");
        }
        return super.dispatchTouchEvent(ev5);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/widget/QZoneExpandableLayout$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.tencent.mobileqq.widget.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f59625e;

        c(b bVar) {
            this.f59625e = bVar;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QZoneExpandableLayout.this.isAnimating = false;
            QZoneExpandableLayout.this.getLayoutParams().height = 0;
            QZoneExpandableLayout.this.requestLayout();
            QZoneExpandableLayout.this.setVisibility(8);
            this.f59625e.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/widget/QZoneExpandableLayout$d", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d extends com.tencent.mobileqq.widget.f {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QZoneExpandableLayout.this.isAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
