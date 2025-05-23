package com.qzone.reborn.compat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class CustomHorizontallyScrollRecyclerViewX extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private LinearLayoutManager f53808f;

    /* renamed from: h, reason: collision with root package name */
    private float f53809h;

    /* renamed from: i, reason: collision with root package name */
    private float f53810i;

    /* renamed from: m, reason: collision with root package name */
    private int f53811m;

    public CustomHorizontallyScrollRecyclerViewX(Context context) {
        this(context, null);
    }

    private boolean C(float f16, float f17) {
        if (this.f53808f == null) {
            this.f53808f = (LinearLayoutManager) getLayoutManager();
        }
        if (this.f53808f.getChildCount() <= 0) {
            return false;
        }
        float f18 = f16 - this.f53809h;
        float f19 = f17 - this.f53810i;
        return Math.abs(f19) > ((float) this.f53811m) && Math.abs(f19) > Math.abs(f18);
    }

    private void init() {
        this.f53811m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
    
        if (r0 != 3) goto L18;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (C(motionEvent.getX(), motionEvent.getY())) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            this.f53809h = motionEvent.getX();
            this.f53810i = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i3) {
        super.setScrollingTouchSlop(i3);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 == 0) {
            this.f53811m = viewConfiguration.getScaledTouchSlop();
        } else {
            if (i3 != 1) {
                return;
            }
            this.f53811m = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    public CustomHorizontallyScrollRecyclerViewX(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomHorizontallyScrollRecyclerViewX(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f53809h = 0.0f;
        this.f53810i = 0.0f;
        init();
    }
}
