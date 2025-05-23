package com.tencent.mobileqq.guild.rolegroup.adapters.extra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildTouchCrossLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f232292d;

    public GuildTouchCrossLinearLayout(Context context) {
        super(context);
        this.f232292d = 0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onInterceptTouchEvent(motionEvent);
        return false;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        int i3 = layoutParams.width;
        if (i3 == -1) {
            layoutParams.width = this.f232292d;
        } else {
            this.f232292d = i3;
        }
        super.setLayoutParams(layoutParams);
    }

    public GuildTouchCrossLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f232292d = 0;
    }

    public GuildTouchCrossLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f232292d = 0;
    }
}
