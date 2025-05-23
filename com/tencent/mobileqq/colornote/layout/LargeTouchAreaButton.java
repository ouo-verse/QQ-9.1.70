package com.tencent.mobileqq.colornote.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import da1.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LargeTouchAreaButton extends Button {
    private int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private int f201408d;

    /* renamed from: e, reason: collision with root package name */
    private int f201409e;

    /* renamed from: f, reason: collision with root package name */
    private int f201410f;

    /* renamed from: h, reason: collision with root package name */
    private int f201411h;

    /* renamed from: i, reason: collision with root package name */
    private int f201412i;

    /* renamed from: m, reason: collision with root package name */
    private int f201413m;

    public LargeTouchAreaButton(Context context) {
        super(context);
        this.f201408d = -1;
        this.f201409e = -1;
        this.f201410f = -1;
        this.f201411h = -1;
        this.f201412i = 0;
        this.f201413m = 0;
        this.C = 0;
        this.D = 0;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f393450y1);
        int dimension = (int) obtainStyledAttributes.getDimension(b.f393456z1, 0.0f);
        this.f201412i = dimension;
        this.f201413m = dimension;
        this.C = dimension;
        this.D = dimension;
        this.f201412i = (int) obtainStyledAttributes.getDimension(b.A1, dimension);
        this.f201413m = (int) obtainStyledAttributes.getDimension(b.B1, this.f201413m);
        this.C = (int) obtainStyledAttributes.getDimension(b.C1, this.C);
        this.D = (int) obtainStyledAttributes.getDimension(b.D1, this.D);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (i3 != this.f201408d || i16 != this.f201411h || i17 != this.f201409e || i18 != this.f201410f) {
            this.f201408d = i3;
            this.f201411h = i16;
            this.f201409e = i17;
            this.f201410f = i18;
            ((View) getParent()).setTouchDelegate(new TouchDelegate(new Rect(i3 - this.f201413m, i16 - this.D, i17 + this.C, i18 + this.f201412i), this));
        }
    }

    public LargeTouchAreaButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f201408d = -1;
        this.f201409e = -1;
        this.f201410f = -1;
        this.f201411h = -1;
        this.f201412i = 0;
        this.f201413m = 0;
        this.C = 0;
        this.D = 0;
        a(context, attributeSet);
    }

    public LargeTouchAreaButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f201408d = -1;
        this.f201409e = -1;
        this.f201410f = -1;
        this.f201411h = -1;
        this.f201412i = 0;
        this.f201413m = 0;
        this.C = 0;
        this.D = 0;
        a(context, attributeSet);
    }
}
