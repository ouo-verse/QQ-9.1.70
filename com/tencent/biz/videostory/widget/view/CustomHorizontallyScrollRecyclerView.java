package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CustomHorizontallyScrollRecyclerView extends RecyclerView {

    /* renamed from: d, reason: collision with root package name */
    private LinearLayoutManager f97222d;

    /* renamed from: e, reason: collision with root package name */
    private float f97223e;

    /* renamed from: f, reason: collision with root package name */
    private float f97224f;

    /* renamed from: h, reason: collision with root package name */
    private int f97225h;

    public CustomHorizontallyScrollRecyclerView(Context context) {
        this(context, null);
    }

    private void c() {
        this.f97225h = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private boolean d(float f16, float f17) {
        if (this.f97222d == null) {
            this.f97222d = (LinearLayoutManager) getLayoutManager();
        }
        if (this.f97222d.getChildCount() <= 0) {
            return false;
        }
        float f18 = f16 - this.f97223e;
        float f19 = f17 - this.f97224f;
        if (Math.abs(f19) <= this.f97225h || Math.abs(f19) <= Math.abs(f18)) {
            return false;
        }
        return true;
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
                    if (d(motionEvent.getX(), motionEvent.getY())) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            this.f97223e = motionEvent.getX();
            this.f97224f = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setScrollingTouchSlop(int i3) {
        super.setScrollingTouchSlop(i3);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 == 1) {
                this.f97225h = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
                return;
            }
            return;
        }
        this.f97225h = viewConfiguration.getScaledTouchSlop();
    }

    public CustomHorizontallyScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomHorizontallyScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f97223e = 0.0f;
        this.f97224f = 0.0f;
        c();
    }
}
