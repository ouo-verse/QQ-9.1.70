package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import com.tencent.commonsdk.util.notification.NotificationUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MyGridView extends GridView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f315863d;

    public MyGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315863d = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.f315863d) {
            return false;
        }
        return dispatchTouchEvent;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
    }

    @Override // android.view.View
    @TargetApi(9)
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public MyGridView(Context context) {
        super(context);
        this.f315863d = false;
    }

    public MyGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315863d = false;
    }
}
