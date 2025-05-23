package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubScribeSwipeRefreshLayout extends SwipeRefreshLayout {
    private TopGestureLayout C;

    /* renamed from: d, reason: collision with root package name */
    private Rect f95656d;

    /* renamed from: e, reason: collision with root package name */
    private int f95657e;

    /* renamed from: f, reason: collision with root package name */
    private int f95658f;

    /* renamed from: h, reason: collision with root package name */
    private int f95659h;

    /* renamed from: i, reason: collision with root package name */
    private int f95660i;

    /* renamed from: m, reason: collision with root package name */
    private View f95661m;

    public SubScribeSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void c() {
        this.f95657e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    protected void d() {
        if (this.C == null) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null && (childAt instanceof DragFrameLayout)) {
                viewGroup = (ViewGroup) childAt;
            }
            View childAt2 = viewGroup.getChildAt(0);
            if (childAt2 instanceof TopGestureLayout) {
                this.C = (TopGestureLayout) childAt2;
            }
        }
        TopGestureLayout topGestureLayout = this.C;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchEventListener(new a());
        }
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int actionIndex = motionEvent.getActionIndex();
        if (action != 0) {
            if (action != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int x16 = (int) (motionEvent.getX() + 0.5f);
            int y16 = (int) (motionEvent.getY() + 0.5f);
            int i3 = x16 - this.f95659h;
            int i16 = (int) ((y16 - this.f95660i) * 0.6f);
            if (Math.abs(i3) > this.f95657e && Math.abs(i3) >= Math.abs(i16)) {
                return false;
            }
            if (Math.abs(i3) > this.f95657e && Math.abs(i16) > Math.abs(i3)) {
                return super.onInterceptTouchEvent(motionEvent);
            }
        } else {
            this.f95659h = (int) (motionEvent.getX() + 0.5f);
            this.f95660i = (int) (motionEvent.getY() + 0.5f);
            this.f95658f = MotionEventCompat.findPointerIndex(motionEvent, actionIndex);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setConflictView(View view) {
        this.f95661m = view;
        this.f95656d = new Rect();
        d();
    }

    public SubScribeSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements TopGestureLayout.InterceptTouchEventListener {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public boolean OnInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x16 = (int) (motionEvent.getX() + 0.5f);
                int y16 = (int) (motionEvent.getY() + 0.5f);
                if (SubScribeSwipeRefreshLayout.this.f95661m != null) {
                    SubScribeSwipeRefreshLayout.this.f95661m.getLocalVisibleRect(SubScribeSwipeRefreshLayout.this.f95656d);
                    if (SubScribeSwipeRefreshLayout.this.f95656d.contains(x16, y16)) {
                        return false;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public void OnDispatchTouchEvent(MotionEvent motionEvent) {
        }
    }
}
