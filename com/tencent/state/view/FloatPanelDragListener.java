package com.tencent.state.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/view/FloatPanelDragListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Landroid/view/View;", "onDismiss", "Lkotlin/Function1;", "", "", "(Landroid/content/Context;Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "handledMove", "", "lastMovedY", "targetViewHeight", "touchSlop", "", "onTouch", "v", "event", "Landroid/view/MotionEvent;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FloatPanelDragListener implements View.OnTouchListener {
    private boolean handledMove;
    private float lastMovedY;
    private final Function1<Float, Unit> onDismiss;
    private final View panel;
    private float targetViewHeight;
    private final int touchSlop;

    /* JADX WARN: Multi-variable type inference failed */
    public FloatPanelDragListener(Context context, View panel, Function1<? super Float, Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(panel, "panel");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        this.panel = panel;
        this.onDismiss = onDismiss;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v3, MotionEvent event) {
        if (event == null) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.targetViewHeight = this.panel.getHeight();
            this.lastMovedY = event.getY();
            this.handledMove = false;
        } else if (action == 1) {
            if (!this.handledMove || this.panel.getTranslationY() >= this.targetViewHeight / 4) {
                this.onDismiss.invoke(Float.valueOf(this.panel.getTranslationY() / this.targetViewHeight));
            }
            this.panel.setTranslationY(0.0f);
        } else if (action == 2 && Math.abs(event.getY() - this.lastMovedY) > this.touchSlop) {
            View view = this.panel;
            view.setTranslationY(Math.max(0.0f, view.getTranslationY() + (this.touchSlop * (event.getY() > this.lastMovedY ? 1 : -1))));
            this.handledMove = true;
            this.lastMovedY = event.getY();
        }
        return true;
    }
}
