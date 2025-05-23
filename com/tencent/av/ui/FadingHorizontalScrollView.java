package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FadingHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: d, reason: collision with root package name */
    private int f74782d;

    public FadingHorizontalScrollView(Context context) {
        super(context);
        this.f74782d = 1;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected float getRightFadingEdgeStrength() {
        if (this.f74782d != 1) {
            return super.getRightFadingEdgeStrength();
        }
        return 0.0f;
    }

    public void setFadingMode(int i3) {
        this.f74782d = i3;
    }

    public FadingHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f74782d = 1;
    }

    public FadingHorizontalScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f74782d = 1;
    }
}
