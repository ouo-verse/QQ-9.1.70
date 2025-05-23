package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendGradientFootView extends View {

    /* renamed from: d, reason: collision with root package name */
    LinearGradient f264137d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f264138e;

    public ExtendFriendGradientFootView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f264138e);
    }

    public void setColor(int i3) {
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), 0, i3, Shader.TileMode.CLAMP);
        this.f264137d = linearGradient;
        this.f264138e.setShader(linearGradient);
        invalidate();
    }

    public ExtendFriendGradientFootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExtendFriendGradientFootView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264138e = new Paint();
    }
}
