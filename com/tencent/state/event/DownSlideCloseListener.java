package com.tencent.state.event;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J\b\u0010\u0018\u001a\u00020\bH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/event/DownSlideCloseListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "slideView", "Landroid/view/View;", "closeCallback", "Lkotlin/Function0;", "", "(Landroid/content/Context;Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "handledMove", "", "lastMovedY", "", "resetTranslationYAnim", "Landroid/animation/ObjectAnimator;", "startY", "targetViewHeight", "touchSlop", "", "onTouch", "v", "event", "Landroid/view/MotionEvent;", "resetTranslationY", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public class DownSlideCloseListener implements View.OnTouchListener {
    private final Function0<Unit> closeCallback;
    private boolean handledMove;
    private float lastMovedY;
    private ObjectAnimator resetTranslationYAnim;
    private final View slideView;
    private float startY;
    private float targetViewHeight;
    private final int touchSlop;

    public DownSlideCloseListener(Context context, View slideView, Function0<Unit> closeCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(slideView, "slideView");
        Intrinsics.checkNotNullParameter(closeCallback, "closeCallback");
        this.slideView = slideView;
        this.closeCallback = closeCallback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    private final void resetTranslationY() {
        ObjectAnimator objectAnimator = this.resetTranslationYAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        View view = this.slideView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), 0.0f);
        ofFloat.start();
        Unit unit = Unit.INSTANCE;
        this.resetTranslationYAnim = ofFloat;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v3, MotionEvent event) {
        if (event == null) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.targetViewHeight = this.slideView.getHeight();
            this.startY = event.getRawY();
            this.lastMovedY = event.getY();
            this.handledMove = false;
            ObjectAnimator objectAnimator = this.resetTranslationYAnim;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            this.resetTranslationYAnim = null;
        } else if (action != 1) {
            if (action == 2 && (this.handledMove || Math.abs(event.getY() - this.lastMovedY) > this.touchSlop)) {
                this.slideView.setTranslationY(Math.max(0.0f, event.getRawY() - this.startY));
                this.handledMove = true;
                this.lastMovedY = event.getY();
            }
        } else {
            if (!this.handledMove || this.slideView.getTranslationY() >= this.targetViewHeight * 0.25f) {
                this.closeCallback.invoke();
            }
            resetTranslationY();
        }
        return true;
    }
}
