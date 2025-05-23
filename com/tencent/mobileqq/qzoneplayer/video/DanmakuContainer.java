package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes35.dex */
public class DanmakuContainer extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f279617d;

    /* renamed from: e, reason: collision with root package name */
    private int f279618e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f279619f;

    public DanmakuContainer(Context context) {
        super(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.f279619f) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.f279617d, 1073741824);
            i16 = View.MeasureSpec.makeMeasureSpec(this.f279618e, 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    public void setContainerDimensionOverride(int i3, int i16, boolean z16) {
        this.f279617d = i3;
        this.f279618e = i16;
        this.f279619f = z16;
    }

    public DanmakuContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanmakuContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
