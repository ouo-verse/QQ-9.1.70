package com.tencent.state.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareTroopMessageBubbleBinding;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b*\u0001\r\u0018\u0000 !2\u00020\u0001:\u0001!B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0006\u0010\u001d\u001a\u00020\u0014J\u0006\u0010\u001e\u001a\u00020\u0014J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0014H\u0003R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/view/SquareTroopMessageBubble;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareTroopMessageBubbleBinding;", "index", "messageHandler", "com/tencent/state/view/SquareTroopMessageBubble$messageHandler$1", "Lcom/tencent/state/view/SquareTroopMessageBubble$messageHandler$1;", "topView", "Landroid/view/View;", "transition", "Landroid/animation/LayoutTransition;", "addNewMessage", "", "text", "", "isContainEmo", "", "delay", "", "bindAddAnimator", "view", QCircleLpReportDc05507.KEY_CLEAR, "destroy", "obtainSummaryView", "topAddAnimator", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareTroopMessageBubble extends FrameLayout {
    public static final int MAX_POOL_LIMIT = 2;
    private final VasSquareTroopMessageBubbleBinding binding;
    private int index;
    private final SquareTroopMessageBubble$messageHandler$1 messageHandler;
    private View topView;
    private final LayoutTransition transition;

    public SquareTroopMessageBubble(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View obtainSummaryView(String text, int isContainEmo) {
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISquareSummaryView summaryView$default = ICommonUtils.DefaultImpls.getSummaryView$default(commonUtils, context, null, 2, null);
        if (summaryView$default != null) {
            summaryView$default.setSummaryMsgText(text, isContainEmo == 1);
        }
        BubbleBgDrawable bubbleBgDrawable = new BubbleBgDrawable(-1, ViewExtensionsKt.dip(getContext(), 15), 0.0f, null, false, 24, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewExtensionsKt.dip(getContext(), 26));
        layoutParams.topMargin = ViewExtensionsKt.dip(getContext(), 2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = ViewExtensionsKt.dip(getContext(), 4);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackground(bubbleBgDrawable);
        relativeLayout.addView(summaryView$default != null ? summaryView$default.getView() : null, layoutParams2);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void topAddAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.topView, c.f123400v, 0.6f, 0.3f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.topView, BasicAnimation.KeyPath.SCALE_X, 0.9f, 0.8f);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(480L);
        animatorSet.setInterpolator(decelerateInterpolator);
        animatorSet.start();
    }

    public final void addNewMessage(String text, boolean isContainEmo, long delay) {
        Intrinsics.checkNotNullParameter(text, "text");
        Message message = new Message();
        message.what = 0;
        message.arg1 = isContainEmo ? 1 : 0;
        message.obj = text;
        sendMessageDelayed(message, delay);
    }

    public SquareTroopMessageBubble(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindAddAnimator(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c.f123400v, 1.0f, 0.6f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.9f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.9f);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(480L);
        animatorSet.setInterpolator(decelerateInterpolator);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.state.view.SquareTroopMessageBubble$bindAddAnimator$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                VasSquareTroopMessageBubbleBinding vasSquareTroopMessageBubbleBinding;
                SquareTroopMessageBubble$messageHandler$1 squareTroopMessageBubble$messageHandler$1;
                vasSquareTroopMessageBubbleBinding = SquareTroopMessageBubble.this.binding;
                LinearLayout linearLayout = vasSquareTroopMessageBubbleBinding.bubbleContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bubbleContainer");
                if (linearLayout.getChildCount() == 3) {
                    squareTroopMessageBubble$messageHandler$1 = SquareTroopMessageBubble.this.messageHandler;
                    squareTroopMessageBubble$messageHandler$1.sendEmptyMessage(2);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                VasSquareTroopMessageBubbleBinding vasSquareTroopMessageBubbleBinding;
                SquareTroopMessageBubble$messageHandler$1 squareTroopMessageBubble$messageHandler$1;
                vasSquareTroopMessageBubbleBinding = SquareTroopMessageBubble.this.binding;
                LinearLayout linearLayout = vasSquareTroopMessageBubbleBinding.bubbleContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bubbleContainer");
                if (linearLayout.getChildCount() == 3) {
                    squareTroopMessageBubble$messageHandler$1 = SquareTroopMessageBubble.this.messageHandler;
                    squareTroopMessageBubble$messageHandler$1.sendEmptyMessage(1);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.start();
    }

    public final void clear() {
        this.topView = null;
        this.binding.bubbleContainer.removeAllViews();
    }

    public final void destroy() {
        this.topView = null;
        this.binding.bubbleContainer.removeAllViews();
        removeMessages(0);
    }

    public /* synthetic */ SquareTroopMessageBubble(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.tencent.state.view.SquareTroopMessageBubble$messageHandler$1] */
    public SquareTroopMessageBubble(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareTroopMessageBubbleBinding inflate = VasSquareTroopMessageBubbleBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareTroopMessageBub\u2026ater.from(context), this)");
        this.binding = inflate;
        LayoutTransition layoutTransition = new LayoutTransition();
        this.transition = layoutTransition;
        this.messageHandler = new Handler() { // from class: com.tencent.state.view.SquareTroopMessageBubble$messageHandler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg2) {
                View obtainSummaryView;
                VasSquareTroopMessageBubbleBinding vasSquareTroopMessageBubbleBinding;
                int i16;
                int i17;
                VasSquareTroopMessageBubbleBinding vasSquareTroopMessageBubbleBinding2;
                LayoutTransition layoutTransition2;
                VasSquareTroopMessageBubbleBinding vasSquareTroopMessageBubbleBinding3;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                int i18 = msg2.what;
                if (i18 != 0) {
                    if (i18 != 1) {
                        if (i18 != 2) {
                            return;
                        }
                        vasSquareTroopMessageBubbleBinding3 = SquareTroopMessageBubble.this.binding;
                        vasSquareTroopMessageBubbleBinding3.bubbleContainer.removeViewAt(0);
                        return;
                    }
                    vasSquareTroopMessageBubbleBinding2 = SquareTroopMessageBubble.this.binding;
                    ViewPropertyAnimator alpha = vasSquareTroopMessageBubbleBinding2.bubbleContainer.getChildAt(0).animate().alpha(0.0f);
                    layoutTransition2 = SquareTroopMessageBubble.this.transition;
                    alpha.setDuration(layoutTransition2.getDuration(2)).start();
                    return;
                }
                int i19 = msg2.arg1;
                Object obj = msg2.obj;
                if (obj != null) {
                    obtainSummaryView = SquareTroopMessageBubble.this.obtainSummaryView((String) obj, i19);
                    vasSquareTroopMessageBubbleBinding = SquareTroopMessageBubble.this.binding;
                    vasSquareTroopMessageBubbleBinding.bubbleContainer.addView(obtainSummaryView);
                    SquareTroopMessageBubble.this.topAddAnimator();
                    SquareTroopMessageBubble.this.bindAddAnimator(obtainSummaryView);
                    SquareTroopMessageBubble.this.topView = obtainSummaryView;
                    SquareTroopMessageBubble squareTroopMessageBubble = SquareTroopMessageBubble.this;
                    i16 = squareTroopMessageBubble.index;
                    squareTroopMessageBubble.index = i16 + 1;
                    i17 = SquareTroopMessageBubble.this.index;
                    if (i17 == 2) {
                        SquareTroopMessageBubble.this.index = 0;
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        };
        layoutTransition.setAnimator(3, ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(c.f123400v, 0.0f, 0.0f)).setDuration(layoutTransition.getDuration(3)));
        LinearLayout linearLayout = inflate.bubbleContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bubbleContainer");
        linearLayout.setLayoutTransition(layoutTransition);
    }

    public static /* synthetic */ void addNewMessage$default(SquareTroopMessageBubble squareTroopMessageBubble, String str, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = 0;
        }
        squareTroopMessageBubble.addNewMessage(str, z16, j3);
    }
}
