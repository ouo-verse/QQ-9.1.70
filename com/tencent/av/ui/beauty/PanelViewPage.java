package com.tencent.av.ui.beauty;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class PanelViewPage extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private int f75451d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f75452e;

    public PanelViewPage(Context context) {
        super(context);
        this.f75451d = 0;
        this.f75452e = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f75452e && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 0 && (i17 = this.f75451d) > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        } else if (mode == 1073741824 && size > 0) {
            this.f75451d = size;
        }
        super.onMeasure(i3, i16);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f75452e && super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setIsPagingEnabled(boolean z16) {
        this.f75452e = z16;
    }

    public PanelViewPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75451d = 0;
        this.f75452e = true;
    }
}
