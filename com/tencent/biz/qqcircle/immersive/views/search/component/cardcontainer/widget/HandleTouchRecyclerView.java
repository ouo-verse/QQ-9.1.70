package com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HandleTouchRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private int f91082f;

    /* renamed from: h, reason: collision with root package name */
    private float f91083h;

    /* renamed from: i, reason: collision with root package name */
    private float f91084i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f91085m;

    public HandleTouchRecyclerView(@NonNull Context context) {
        super(context);
        init();
    }

    private void C(float f16, float f17) {
        if (this.f91085m) {
            return;
        }
        float abs = Math.abs(this.f91083h - f16);
        float abs2 = Math.abs(this.f91084i - f17);
        if (abs2 > abs && abs2 > this.f91082f) {
            this.f91085m = true;
        } else if (abs > abs2 && abs > this.f91082f) {
            this.f91085m = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private void init() {
        this.f91082f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 2) {
                C(x16, y16);
            }
        } else {
            this.f91083h = x16;
            this.f91084i = y16;
            this.f91085m = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public HandleTouchRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HandleTouchRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
