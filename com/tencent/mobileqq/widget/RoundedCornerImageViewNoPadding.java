package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.PressDarkImageView;

/* loaded from: classes20.dex */
public class RoundedCornerImageViewNoPadding extends PressDarkImageView {
    private int C;
    private boolean D;
    private int E;
    private boolean F;

    /* renamed from: m, reason: collision with root package name */
    private Path f316199m;

    public RoundedCornerImageViewNoPadding(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int width = getWidth();
        RectF rectF = new RectF(0.0f, 0.0f, width, getHeight());
        int i3 = this.E;
        if (i3 <= 0) {
            i3 = width / 30;
        }
        if (!this.F) {
            this.f316199m.reset();
            float f16 = i3;
            this.f316199m.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
            this.f316199m.setFillType(Path.FillType.EVEN_ODD);
            this.F = true;
        }
        canvas.clipPath(this.f316199m);
        super.draw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.F = false;
    }

    public void setCorner(int i3) {
        if (i3 > 0) {
            this.E = i3;
            this.F = false;
            invalidate();
            return;
        }
        throw new IllegalArgumentException("should not be less than 0");
    }

    public RoundedCornerImageViewNoPadding(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedCornerImageViewNoPadding(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316199m = new Path();
        this.C = Color.parseColor("#FFD5D5D5");
        this.D = false;
        this.E = 0;
        this.F = false;
        super.setLayerType(2, null);
    }
}
