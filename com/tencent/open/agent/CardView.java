package com.tencent.open.agent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CardView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected final int f339722d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f339723e;

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new DisplayMetrics();
        DisplayMetrics displayMetrics = super.getResources().getDisplayMetrics();
        this.f339722d = displayMetrics.widthPixels;
        this.f339723e = displayMetrics.heightPixels;
    }

    protected float a() {
        return 2.2149837f;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        for (int i19 = 0; i19 < super.getChildCount(); i19++) {
            super.getChildAt(i19).layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        float f16 = this.f339722d;
        super.setMeasuredDimension((int) f16, (int) (f16 / a()));
    }
}
