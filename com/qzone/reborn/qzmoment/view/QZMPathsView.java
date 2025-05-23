package com.qzone.reborn.qzmoment.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import sn.c;

/* loaded from: classes37.dex */
public class QZMPathsView extends View {

    /* renamed from: d, reason: collision with root package name */
    protected c f59054d;

    public QZMPathsView(Context context) {
        this(context, null);
    }

    public boolean a(String... strArr) {
        return this.f59054d.e(strArr);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f59054d.draw(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            a(getTag().toString());
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f59054d.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i17 - i3) - getPaddingRight(), getPaddingLeft()), Math.max((i18 - i16) - getPaddingTop(), getPaddingTop()));
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        c cVar = this.f59054d;
        super.setMeasuredDimension(View.resolveSize(cVar.getBounds().width() + getPaddingLeft() + getPaddingRight(), i3), View.resolveSize(cVar.getBounds().height() + getPaddingTop() + getPaddingBottom(), i16));
    }

    public QZMPathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f59054d = new c();
    }
}
