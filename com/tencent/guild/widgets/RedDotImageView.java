package com.tencent.guild.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RedDotImageView extends ImageView {
    private float C;

    /* renamed from: d, reason: collision with root package name */
    protected Drawable f112678d;

    /* renamed from: e, reason: collision with root package name */
    protected int f112679e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f112680f;

    /* renamed from: h, reason: collision with root package name */
    protected int f112681h;

    /* renamed from: i, reason: collision with root package name */
    private int f112682i;

    /* renamed from: m, reason: collision with root package name */
    protected float f112683m;

    public RedDotImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        if (QLog.isColorLevel() && toString().contains("qq_aio_panel_image")) {
            QLog.d("Q.recent", 2, " onDraw() : " + this.f112681h + "\uff0cthis = " + this);
        }
        if (this.f112681h > 0 && (drawable = this.f112678d) != null) {
            drawable.setState(getDrawableState());
            int ceil = (int) Math.ceil(getWidth() / 2);
            Drawable drawable2 = this.f112678d;
            int i3 = this.f112679e;
            drawable2.setBounds(ceil, 0, ceil + i3, i3);
            this.f112678d.draw(canvas);
            int ceil2 = (int) Math.ceil(this.f112680f.measureText(String.valueOf(this.f112681h)));
            String valueOf = String.valueOf(this.f112681h);
            double d16 = ceil;
            int i16 = this.f112679e;
            canvas.drawText(valueOf, (int) (d16 + ((i16 - ceil2) * 0.5d)), (int) (i16 - (this.f112683m * 0.5d)), this.f112680f);
        }
    }

    public void setReddotXOffsetPx(int i3) {
        if (i3 != this.f112679e) {
            this.f112679e = i3;
            postInvalidate();
        }
    }

    public void setUnreadNumber(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, " setUnreadNumber() : " + i3 + "\uff0cthis = " + this);
        }
        if (i3 > 0 && this.f112678d == null) {
            this.f112679e = (int) (this.C * 20.0f);
            Paint paint = new Paint();
            this.f112680f = paint;
            paint.setAntiAlias(true);
            this.f112680f.setColor(getResources().getColor(R.color.qui_button_text_primary_default));
            this.f112680f.setStyle(Paint.Style.FILL);
            this.f112680f.setTextSize(this.C * 12.0f);
            Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
            this.f112680f.getFontMetrics(fontMetrics);
            this.f112683m = Math.abs(fontMetrics.ascent);
            this.f112678d = getResources().getDrawable(R.drawable.qui_common_check_box_with_text_checked);
        }
        this.f112681h = i3;
        postInvalidate();
    }

    public RedDotImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f112678d = null;
        this.f112679e = 0;
        this.f112680f = null;
        this.f112681h = 0;
        this.f112682i = 0;
        this.f112683m = 0.0f;
        this.C = getResources().getDisplayMetrics().density;
    }

    public RedDotImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f112678d = null;
        this.f112679e = 0;
        this.f112680f = null;
        this.f112681h = 0;
        this.f112682i = 0;
        this.f112683m = 0.0f;
        this.C = getResources().getDisplayMetrics().density;
    }
}
