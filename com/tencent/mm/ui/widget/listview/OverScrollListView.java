package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.luggage.wxa.lo.n;

/* compiled from: P */
/* loaded from: classes9.dex */
public class OverScrollListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public int f153366a;

    /* renamed from: b, reason: collision with root package name */
    public float f153367b;

    /* renamed from: c, reason: collision with root package name */
    public float f153368c;

    public OverScrollListView(Context context) {
        super(context);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float y16 = motionEvent.getY(0);
                this.f153368c = y16;
                this.f153366a = (int) Math.abs(y16 - this.f153367b);
            }
        } else {
            this.f153367b = motionEvent.getY(0);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        n.a("OverScrollListView", "dancy test maxOverScrollYDis: %s", Integer.valueOf(this.f153366a));
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, this.f153366a / 2, z16);
    }

    public OverScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OverScrollListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public OverScrollListView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }
}
