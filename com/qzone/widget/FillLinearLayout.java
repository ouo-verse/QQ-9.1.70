package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class FillLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f60402d;

    public FillLinearLayout(Context context) {
        super(context);
        this.f60402d = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.f60402d) {
            Object parent = getParent();
            if (parent != null && (parent instanceof ListView)) {
                int size = View.MeasureSpec.getSize(i3);
                int size2 = View.MeasureSpec.getSize(i16);
                View view = (View) parent;
                if (view.getHeight() > 0) {
                    size2 = Math.max(size2, view.getHeight());
                }
                i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
                i16 = View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
            } else {
                int size3 = View.MeasureSpec.getSize(i3);
                int size4 = View.MeasureSpec.getSize(i16);
                i3 = View.MeasureSpec.makeMeasureSpec(size3, Integer.MIN_VALUE);
                i16 = View.MeasureSpec.makeMeasureSpec(size4, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i3, i16);
    }

    public void setFillParent(boolean z16) {
        if (this.f60402d != z16) {
            this.f60402d = z16;
            requestLayout();
        }
    }

    public FillLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60402d = false;
    }
}
