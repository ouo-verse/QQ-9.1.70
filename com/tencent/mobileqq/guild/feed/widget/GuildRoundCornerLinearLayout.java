package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildRoundCornerLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private Path f224271d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f224272e;

    /* renamed from: f, reason: collision with root package name */
    private float f224273f;

    public GuildRoundCornerLinearLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f224271d = new Path();
        this.f224272e = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f224271d.reset();
        this.f224272e.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.f224271d;
        RectF rectF = this.f224272e;
        float f16 = this.f224273f;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        canvas.clipPath(this.f224271d);
        super.dispatchDraw(canvas);
    }

    public void setRadius(float f16) {
        this.f224273f = f16;
    }

    public GuildRoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public GuildRoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
