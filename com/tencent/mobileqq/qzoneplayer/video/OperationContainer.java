package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes35.dex */
public class OperationContainer extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f279896d;

    /* renamed from: e, reason: collision with root package name */
    private int f279897e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f279898f;

    public OperationContainer(Context context) {
        super(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.f279898f) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.f279896d, 1073741824);
            i16 = View.MeasureSpec.makeMeasureSpec(this.f279897e, 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    public void setContainerDimensionOverride(int i3, int i16, boolean z16) {
        this.f279896d = i3;
        this.f279897e = i16;
        this.f279898f = z16;
    }

    public OperationContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OperationContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
