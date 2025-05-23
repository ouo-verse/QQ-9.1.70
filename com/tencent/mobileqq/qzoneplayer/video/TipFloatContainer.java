package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TipFloatContainer extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f279909d;

    /* renamed from: e, reason: collision with root package name */
    private int f279910e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f279911f;

    public TipFloatContainer(Context context) {
        super(context);
        this.f279911f = false;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.f279911f) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.f279909d, 1073741824);
            i16 = View.MeasureSpec.makeMeasureSpec(this.f279910e, 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    public void setContainerDimensionOverride(int i3, int i16, boolean z16) {
        this.f279909d = i3;
        this.f279910e = i16;
        this.f279911f = z16;
    }

    public TipFloatContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f279911f = false;
    }

    public TipFloatContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f279911f = false;
    }
}
