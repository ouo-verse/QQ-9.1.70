package com.tencent.biz.qqcircle.immersive.part.publishprogress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxBubbleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "F0", "E0", "B0", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSTriangleView;", "d", "Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/QFSTriangleView;", "bubbleArrowView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "bubbleText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRectBoxBubbleView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QFSTriangleView bubbleArrowView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView bubbleText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSRectBoxBubbleView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(QFSRectBoxBubbleView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bubbleText.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(QFSRectBoxBubbleView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.getLayoutParams().width = ((Integer) animatedValue).intValue();
        this$0.requestLayout();
    }

    private final void F0() {
        SpannableString spannableString = new SpannableString("\u53d1\u5e03\u6210\u529f\u540e\u53ef\u4ee5\u5728\n\u4e2a\u4eba\u4e3b\u9875\u67e5\u770b\u4f5c\u54c1");
        spannableString.setSpan(new StyleSpan(1), 8, 13, 33);
        this.bubbleText.setText(spannableString);
    }

    public final void B0() {
        if (getVisibility() != 0) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSRectBoxBubbleView.C0(QFSRectBoxBubbleView.this);
            }
        }, 80L);
        ValueAnimator ofInt = ValueAnimator.ofInt(getWidth(), com.tencent.qqnt.base.utils.c.f353052a.b(64));
        ofInt.setDuration(250L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.part.publishprogress.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSRectBoxBubbleView.D0(QFSRectBoxBubbleView.this, valueAnimator);
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(250L);
        ofInt.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        ofFloat.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofFloat);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    public final void E0() {
        F0();
        setVisibility(0);
    }

    public /* synthetic */ QFSRectBoxBubbleView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSRectBoxBubbleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.gq6, this);
        View findViewById = findViewById(R.id.f5178291);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_rect_box_bubble_arrow)");
        this.bubbleArrowView = (QFSTriangleView) findViewById;
        View findViewById2 = findViewById(R.id.f5180293);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_rect_box_bubble_text)");
        this.bubbleText = (TextView) findViewById2;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/publishprogress/QFSRectBoxBubbleView$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            QFSRectBoxBubbleView.this.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            QFSRectBoxBubbleView.this.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
