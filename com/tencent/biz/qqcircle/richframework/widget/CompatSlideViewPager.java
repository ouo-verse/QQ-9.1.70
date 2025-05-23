package com.tencent.biz.qqcircle.richframework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes5.dex */
public class CompatSlideViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private int f92066d;

    /* renamed from: e, reason: collision with root package name */
    private int f92067e;

    /* renamed from: f, reason: collision with root package name */
    private int f92068f;

    public CompatSlideViewPager(@NonNull Context context) {
        this(context, null);
    }

    private void init() {
        this.f92068f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        motionEvent.getActionIndex();
        if (action != 0) {
            if (action == 2) {
                motionEvent.getX();
                motionEvent.getY();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f92066d = (int) (motionEvent.getX() + 0.5f);
        this.f92067e = (int) (motionEvent.getY() + 0.5f);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public CompatSlideViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
