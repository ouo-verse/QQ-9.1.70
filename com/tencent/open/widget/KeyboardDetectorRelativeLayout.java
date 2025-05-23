package com.tencent.open.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes22.dex */
public class KeyboardDetectorRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected Rect f341792d;

    /* renamed from: e, reason: collision with root package name */
    protected a f341793e;

    public KeyboardDetectorRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f341792d = null;
        this.f341793e = null;
        this.f341792d = new Rect();
    }

    public void a(a aVar) {
        this.f341793e = aVar;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i16);
        Activity activity = (Activity) super.getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f341792d);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f341792d.top) - size;
        a aVar = this.f341793e;
        if (aVar != null && size != 0) {
            if (height > 100) {
                aVar.f0((Math.abs(this.f341792d.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                aVar.K0();
            }
        }
        super.onMeasure(i3, i16);
    }
}
