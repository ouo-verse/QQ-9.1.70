package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RadiusLinerLayout extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    public static final int f96395e = x.c(BaseApplication.context, 8.0f);

    /* renamed from: d, reason: collision with root package name */
    private int f96396d;

    public RadiusLinerLayout(Context context) {
        this(context, null);
    }

    private void a() {
        setWillNotDraw(false);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public RadiusLinerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadiusLinerLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f96396d = f96395e;
        a();
    }
}
