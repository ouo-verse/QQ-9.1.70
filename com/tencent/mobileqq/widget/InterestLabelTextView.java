package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class InterestLabelTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    RoundRectShape f315757d;

    /* renamed from: e, reason: collision with root package name */
    ShapeDrawable f315758e;

    public InterestLabelTextView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f315757d = new RoundRectShape(new float[]{6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f, 6.0f}, new RectF(2.0f, 2.0f, 2.0f, 2.0f), new float[]{3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f});
        ShapeDrawable shapeDrawable = new ShapeDrawable(this.f315757d);
        this.f315758e = shapeDrawable;
        shapeDrawable.getPaint().setColor(-16777216);
        setBackgroundDrawable(this.f315758e);
    }

    public void setColorFormat(int i3) {
        this.f315758e.getPaint().setColor(i3);
        setTextColor(i3);
    }

    public InterestLabelTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterestLabelTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315757d = null;
        this.f315758e = null;
        a();
    }
}
