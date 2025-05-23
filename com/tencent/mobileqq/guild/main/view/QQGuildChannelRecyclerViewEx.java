package com.tencent.mobileqq.guild.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildChannelRecyclerViewEx extends OverScrollRecyclerViewWithHeaderFooter {
    private View.OnTouchListener I;

    public QQGuildChannelRecyclerViewEx(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        View.OnTouchListener onTouchListener = this.I;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        return onInterceptTouchEvent;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        View.OnTouchListener onTouchListener = this.I;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public void setTouchHandler(View.OnTouchListener onTouchListener) {
        this.I = onTouchListener;
    }

    public QQGuildChannelRecyclerViewEx(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QQGuildChannelRecyclerViewEx(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
