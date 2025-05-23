package com.tencent.state.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.SquareUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u001e\u001a\u00020\u000b2\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fJ\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0017J\b\u0010)\u001a\u00020\u000bH\u0002R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0004\u0018\u0001`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/view/CommonDragView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionUpCallBack", "Lkotlin/Function0;", "", "Lcom/tencent/state/view/CallbackFunc;", "barHeight", "downTime", "", "downX", "", "downY", "hideSize", "isDrag", "", "mHeight", "mWidth", "moveBottom", "moveLeft", "moveRight", "moveTop", "screenHeight", "screenWidth", "actionUp", "cb", "animSlide", "from", "to", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setViewNewLocation", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CommonDragView extends RelativeLayout {
    private static final String TAG = "CommonDragView";
    private Function0<Unit> actionUpCallBack;
    private int barHeight;
    private long downTime;
    private float downX;
    private float downY;
    private final int hideSize;
    private boolean isDrag;
    private int mHeight;
    private int mWidth;
    private int moveBottom;
    private int moveLeft;
    private int moveRight;
    private int moveTop;
    private int screenHeight;
    private int screenWidth;

    public CommonDragView(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setViewNewLocation() {
        if (getTop() < this.barHeight) {
            return;
        }
        ViewExtensionsKt.updateLayoutParams(this, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.view.CommonDragView$setViewNewLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.gravity = 14;
                receiver.setMargins(CommonDragView.this.getLeft(), CommonDragView.this.getTop(), 0, 0);
            }
        });
        setPressed(false);
    }

    public final void actionUp(Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.actionUpCallBack = cb5;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int coerceAtLeast;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        SquareUtil squareUtil = SquareUtil.INSTANCE;
        this.screenWidth = SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null);
        this.screenHeight = SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(squareUtil.getStatusBarHeight(context), com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 20.0f));
        this.barHeight = coerceAtLeast + com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 35.0f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.isDrag = false;
            this.downX = event.getX();
            this.downY = event.getY();
            this.downTime = System.currentTimeMillis();
        } else if (action != 1) {
            if (action == 2) {
                float x16 = event.getX() - this.downX;
                float y16 = event.getY() - this.downY;
                float f16 = 10;
                if (Math.abs(x16) > f16 || Math.abs(y16) > f16) {
                    this.isDrag = true;
                    int left = (int) (getLeft() + x16);
                    this.moveLeft = left;
                    this.moveRight = left + this.mWidth;
                    int top = (int) (getTop() + y16);
                    this.moveTop = top;
                    int i3 = this.mHeight;
                    int i16 = top + i3;
                    this.moveBottom = i16;
                    int i17 = this.moveLeft;
                    int i18 = this.hideSize;
                    if (i17 < (-i18)) {
                        this.moveLeft = -i18;
                        this.moveRight = this.mWidth - i18;
                    } else {
                        int i19 = this.moveRight;
                        int i26 = this.screenWidth;
                        if (i19 > i26 + i18) {
                            this.moveRight = i26;
                            this.moveLeft = (i26 - this.mWidth) + i18;
                        }
                    }
                    int i27 = this.barHeight;
                    if (top < i27) {
                        this.moveTop = i27;
                        this.moveBottom = i3 + i27;
                    } else {
                        int i28 = this.screenHeight;
                        if (i16 > i28) {
                            this.moveBottom = i28;
                            this.moveTop = i28 - i3;
                        }
                    }
                    layout(this.moveLeft, this.moveTop, this.moveRight, this.moveBottom);
                }
            } else if (action == 3) {
                setPressed(false);
            }
        } else if (this.isDrag) {
            if (getLeft() < (this.screenWidth - getLeft()) / 2) {
                animSlide(getLeft(), -this.hideSize);
            } else {
                animSlide(getLeft(), (this.screenWidth - this.mWidth) + this.hideSize);
            }
            Function0<Unit> function0 = this.actionUpCallBack;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (System.currentTimeMillis() - this.downTime <= 300) {
            performClick();
        }
        return true;
    }

    public CommonDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final void animSlide(int from, int to5) {
        ValueAnimator ofInt = ValueAnimator.ofInt(from, to5);
        ofInt.setDuration(250L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.state.view.CommonDragView$animSlide$$inlined$apply$lambda$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                CommonDragView.this.setViewNewLocation();
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.state.view.CommonDragView$animSlide$$inlined$apply$lambda$2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                int i3;
                int i16;
                int i17;
                Object animatedValue = animation != null ? animation.getAnimatedValue() : null;
                Integer num = (Integer) (animatedValue instanceof Integer ? animatedValue : null);
                if (num != null) {
                    int intValue = num.intValue();
                    CommonDragView commonDragView = CommonDragView.this;
                    i3 = commonDragView.moveTop;
                    i16 = CommonDragView.this.mWidth;
                    i17 = CommonDragView.this.moveBottom;
                    commonDragView.layout(intValue, i3, i16 + intValue, i17);
                }
            }
        });
        ofInt.start();
    }

    public /* synthetic */ CommonDragView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonDragView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hideSize = com.tencent.state.square.common.ViewExtensionsKt.dip(context, -18);
    }
}
