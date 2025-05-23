package com.tencent.mobileqq.guild.rolegroup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import androidx.annotation.RequiresApi;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildCommonMemberSearchGridView extends GridView {

    /* renamed from: d, reason: collision with root package name */
    private int f232802d;

    public GuildCommonMemberSearchGridView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    @RequiresApi(api = 16)
    protected void onMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        int minimumHeight = getMinimumHeight();
        if (mode == 1073741824 || mode == 0 || mode == Integer.MIN_VALUE) {
            size = Math.max(Math.min(size, this.f232802d), minimumHeight);
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setMaxHeight(int i3) {
        this.f232802d = i3;
        requestLayout();
    }

    public GuildCommonMemberSearchGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuildCommonMemberSearchGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
