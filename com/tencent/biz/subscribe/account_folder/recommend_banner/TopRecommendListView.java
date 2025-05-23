package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.widget.SwipListView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TopRecommendListView extends SwipListView {

    /* renamed from: d, reason: collision with root package name */
    private int f95663d;

    /* renamed from: e, reason: collision with root package name */
    private int f95664e;

    /* renamed from: f, reason: collision with root package name */
    private int f95665f;

    /* renamed from: h, reason: collision with root package name */
    private int f95666h;

    /* renamed from: i, reason: collision with root package name */
    private View f95667i;

    public TopRecommendListView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.f95663d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // com.tencent.widget.SwipListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (this.f95667i instanceof TopPanelView) {
                if (this.f95664e < 0) {
                    return false;
                }
                int x16 = (int) (motionEvent.getX() + 0.5f);
                int y16 = (int) (motionEvent.getY() + 0.5f);
                int i3 = x16 - this.f95665f;
                int i16 = (int) ((y16 - this.f95666h) * 0.6f);
                if (Math.abs(i3) > this.f95663d && Math.abs(i3) >= Math.abs(i16)) {
                    return false;
                }
                if (Math.abs(i3) > this.f95663d && Math.abs(i16) > Math.abs(i3)) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
            } else {
                return super.onInterceptTouchEvent(motionEvent);
            }
        } else {
            this.f95665f = (int) (motionEvent.getX() + 0.5f);
            int y17 = (int) (motionEvent.getY() + 0.5f);
            this.f95666h = y17;
            int pointToPosition = pointToPosition(this.f95665f, y17);
            this.f95664e = pointToPosition;
            this.f95667i = getChildAt(pointToPosition - getFirstVisiblePosition());
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public TopRecommendListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.listViewStyle);
        init();
    }

    public TopRecommendListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
