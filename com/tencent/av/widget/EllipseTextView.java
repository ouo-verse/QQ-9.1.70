package com.tencent.av.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EllipseTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private float f77217d;

    /* renamed from: e, reason: collision with root package name */
    private float f77218e;

    public EllipseTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f77217d = 1.0f;
        this.f77218e = 0.0f;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f16, float f17) {
        this.f77218e = f16;
        this.f77217d = f17;
        super.setLineSpacing(f16, f17);
    }

    public EllipseTextView(Context context) {
        super(context);
        this.f77217d = 1.0f;
        this.f77218e = 0.0f;
    }

    public EllipseTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f77217d = 1.0f;
        this.f77218e = 0.0f;
    }
}
