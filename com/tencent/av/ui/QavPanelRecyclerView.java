package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class QavPanelRecyclerView extends RecyclerView {
    private QavFunctionPanel C;

    /* renamed from: f, reason: collision with root package name */
    private float f75108f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f75109h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f75110i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f75111m;

    public QavPanelRecyclerView(@NonNull Context context) {
        super(context);
    }

    private boolean C() {
        return this.f75109h;
    }

    private boolean D() {
        return !canScrollVertically(-1);
    }

    private boolean E(float f16, float f17) {
        if (f16 < f17) {
            return true;
        }
        return false;
    }

    private boolean F() {
        return this.f75110i;
    }

    private void G() {
        this.f75111m = false;
    }

    private void H(MotionEvent motionEvent) {
        if (!this.f75111m) {
            motionEvent.setAction(10001);
            this.C.onInterceptTouchEvent(motionEvent);
            this.f75111m = true;
        }
    }

    private void I(boolean z16) {
        this.f75110i = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (D() && C()) {
                        I(true);
                    }
                    if (F()) {
                        suppressLayout(true);
                        H(motionEvent);
                        this.C.onTouchEvent(motionEvent);
                    }
                    if (E(motionEvent.getY(), this.f75108f)) {
                        setCurrentDropTop(false);
                    }
                    this.f75108f = motionEvent.getY();
                }
            } else {
                if (F()) {
                    suppressLayout(false);
                    I(false);
                    G();
                    this.C.onTouchEvent(motionEvent);
                }
                if (D()) {
                    setCurrentDropTop(true);
                }
            }
        } else {
            this.f75108f = motionEvent.getY();
        }
        return true;
    }

    public void setCurrentDropTop(boolean z16) {
        this.f75109h = z16;
    }

    public void setParentView(QavFunctionPanel qavFunctionPanel) {
        this.C = qavFunctionPanel;
    }

    public QavPanelRecyclerView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QavPanelRecyclerView(@NonNull Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
