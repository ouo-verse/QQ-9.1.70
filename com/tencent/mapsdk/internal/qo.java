package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qo extends View {

    /* renamed from: a, reason: collision with root package name */
    qn f149885a;

    public qo(Context context) {
        super(context);
        qn qnVar = new qn();
        this.f149885a = qnVar;
        setBackground(qnVar);
        this.f149885a.a(getResources().getDisplayMetrics().density * 1.0f);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected final void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f149885a.setBounds(0, 0, i17 - i3, i18 - i16);
    }

    public final void setActivate(boolean z16) {
        qn qnVar = this.f149885a;
        if (qnVar == null) {
            return;
        }
        qnVar.f149882a = z16;
        postInvalidate();
    }

    public final void setArrowStrokeWidth(float f16) {
        qn qnVar = this.f149885a;
        if (qnVar == null) {
            return;
        }
        qnVar.a(f16);
        postInvalidate();
    }

    public final void setDarkStyle(boolean z16) {
        this.f149885a.f149883b = z16;
        invalidate();
    }
}
