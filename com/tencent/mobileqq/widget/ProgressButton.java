package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.Button;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes20.dex */
public class ProgressButton extends Button {
    private final int C;

    /* renamed from: d, reason: collision with root package name */
    protected Paint f316001d;

    /* renamed from: e, reason: collision with root package name */
    private int f316002e;

    /* renamed from: f, reason: collision with root package name */
    protected float f316003f;

    /* renamed from: h, reason: collision with root package name */
    protected float f316004h;

    /* renamed from: i, reason: collision with root package name */
    protected int f316005i;

    /* renamed from: m, reason: collision with root package name */
    protected ClipDrawable f316006m;

    public ProgressButton(Context context) {
        super(context);
        this.f316002e = -1;
        this.f316004h = 0.0f;
        this.f316005i = 100;
        this.C = ViewUtils.dip2px(50.0f);
        c();
    }

    private void c() {
        this.f316001d = new Paint();
        int defaultColor = getResources().getColorStateList(R.color.skin_color_button_common_white).getDefaultColor();
        int i3 = this.f316002e;
        if (i3 == -1) {
            this.f316001d.setColor(defaultColor);
        } else {
            this.f316001d.setColor(i3);
        }
    }

    public ClipDrawable a(@ColorInt int i3) {
        return b(i3, this.C);
    }

    public ClipDrawable b(@ColorInt int i3, float f16) {
        ClipDrawable clipDrawable = this.f316006m;
        if (clipDrawable != null) {
            return clipDrawable;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, null, null));
        shapeDrawable.getPaint().setColor(i3);
        return new ClipDrawable(shapeDrawable, 8388611, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        ClipDrawable clipDrawable = this.f316006m;
        if (clipDrawable != null) {
            clipDrawable.setBounds(0, 0, getWidth(), getHeight());
            this.f316006m.setLevel((int) ((10000 / this.f316005i) * this.f316004h));
            this.f316006m.draw(canvas);
        } else {
            if (this.f316003f == 0.0f) {
                this.f316003f = getWidth() / this.f316005i;
            }
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.f316003f * this.f316004h, getHeight()), 5.0f, 5.0f, this.f316001d);
        }
        super.onDraw(canvas);
    }

    public void setMacProgress(int i3) {
        this.f316005i = i3;
    }

    public void setProgress(int i3) {
        this.f316004h = i3;
        invalidate();
    }

    public void setProgressColor(int i3) {
        this.f316002e = i3;
        this.f316001d.setColor(i3);
    }

    public void setProgressDrawable(ClipDrawable clipDrawable) {
        this.f316006m = clipDrawable;
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316002e = -1;
        this.f316004h = 0.0f;
        this.f316005i = 100;
        this.C = ViewUtils.dip2px(50.0f);
        c();
    }
}
