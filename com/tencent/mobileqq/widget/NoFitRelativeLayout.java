package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NoFitRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f315881d;

    public NoFitRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315881d = false;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f315881d) {
            rect.top = 0;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z16) {
        super.setFitsSystemWindows(z16);
        this.f315881d = true;
    }

    public NoFitRelativeLayout(Context context) {
        super(context);
        this.f315881d = false;
    }
}
