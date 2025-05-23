package com.tencent.mobileqq.guild.robot.components.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RoundImageView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class CircleBorderRoundImageView extends RoundImageView {
    private final Context D;
    private int E;
    private int F;
    private int G;
    private int H;
    private Paint I;

    public CircleBorderRoundImageView(Context context) {
        super(context);
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.I = new Paint();
        this.D = context;
        d();
    }

    private void c(Canvas canvas, int i3, int i16) {
        this.I.setAntiAlias(true);
        this.I.setFilterBitmap(true);
        this.I.setDither(true);
        this.I.setColor(i16);
        this.I.setStyle(Paint.Style.STROKE);
        this.I.setStrokeWidth(this.E);
        canvas.drawCircle(this.F / 2, this.G / 2, i3, this.I);
    }

    private void d() {
        this.E = 2;
        this.H = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.RoundImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        if (this.F == 0) {
            this.F = getWidth();
        }
        if (this.G == 0) {
            this.G = getHeight();
        }
        if (ThemeUtil.isDefaultNightTheme()) {
            i3 = -14869216;
        } else {
            i3 = this.H;
        }
        int min = Math.min(this.F, this.G) / 2;
        int i16 = this.E;
        c(canvas, (min - i16) + (i16 / 2), i3);
    }

    public CircleBorderRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.I = new Paint();
        this.D = context;
    }

    public CircleBorderRoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.I = new Paint();
        this.D = context;
    }
}
