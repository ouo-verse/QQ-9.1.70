package com.tencent.mobileqq.leba.zplan.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b72.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ZplanFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f240844d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f240845e;

    /* renamed from: f, reason: collision with root package name */
    private a f240846f;

    public ZplanFrameLayout(@NonNull Context context) {
        super(context);
    }

    public void a() {
        this.f240846f = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f240846f == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked() & 255;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    this.f240845e = false;
                } else if (Math.abs(((int) motionEvent.getY()) - this.f240844d) > 5.0f) {
                    boolean handleZPlanEvent = this.f240846f.handleZPlanEvent(motionEvent);
                    this.f240845e = handleZPlanEvent;
                    if (handleZPlanEvent) {
                        return true;
                    }
                }
            } else {
                this.f240846f.handleZPlanEvent(motionEvent);
                if (this.f240845e) {
                    this.f240845e = false;
                    return true;
                }
            }
        } else {
            this.f240845e = false;
            this.f240844d = (int) motionEvent.getY();
            this.f240846f.handleZPlanEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setZPlanHandleEventListener(a aVar) {
        this.f240846f = aVar;
    }

    public ZplanFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ZplanFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
