package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* loaded from: classes13.dex */
public class GuildFeedProgress extends ImageView {
    int C;
    int D;
    int E;
    Paint F;
    float G;
    RectF H;
    boolean I;
    boolean J;

    /* renamed from: d, reason: collision with root package name */
    int f224182d;

    /* renamed from: e, reason: collision with root package name */
    float f224183e;

    /* renamed from: f, reason: collision with root package name */
    int f224184f;

    /* renamed from: h, reason: collision with root package name */
    int f224185h;

    /* renamed from: i, reason: collision with root package name */
    int f224186i;

    /* renamed from: m, reason: collision with root package name */
    int f224187m;

    public GuildFeedProgress(Context context) {
        super(context);
        this.H = new RectF();
        this.I = true;
        this.J = true;
        a();
    }

    private void a() {
        this.f224183e = getResources().getDisplayMetrics().density;
        this.f224184f = getResources().getColor(R.color.j_);
        this.f224187m = getResources().getColor(R.color.f157037i4);
        this.f224186i = 51;
        this.C = 255;
        this.f224185h = getResources().getColor(R.color.f157067iz);
        Paint paint = new Paint();
        this.F = paint;
        paint.setAntiAlias(true);
        this.F.setStyle(Paint.Style.STROKE);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.D = getWidth();
        this.E = getHeight();
        this.F.setColor(this.f224184f);
        if (this.I) {
            this.F.setAlpha((this.f224186i * 255) / 100);
        }
        this.F.setShadowLayer(9.0f, 0.0f, 0.0f, this.f224185h);
        RectF rectF = this.H;
        int i3 = this.f224182d;
        rectF.set(i3, i3, this.D - i3, this.E - i3);
        canvas.drawArc(this.H, -90.0f, 360.0f, false, this.F);
        this.F.setColor(this.f224187m);
        if (this.J) {
            this.F.setAlpha((this.C * 255) / 100);
        }
        this.F.setShadowLayer(9.0f, 0.0f, 0.0f, this.f224185h);
        RectF rectF2 = this.H;
        int i16 = this.f224182d;
        rectF2.set(i16, i16, this.D - i16, this.E - i16);
        canvas.drawArc(this.H, -90.0f, (float) (this.G * 3.6d), false, this.F);
    }

    public void setBgAndProgressColor(int i3, int i16, int i17, int i18) {
        this.f224184f = i16;
        this.f224186i = i3;
        this.f224187m = i18;
        this.C = i17;
    }

    public void setBgAndProgressUseAlpha(boolean z16, boolean z17) {
        this.I = z16;
        this.J = z17;
    }

    public void setProgress(float f16) {
        if (f16 > 100.0f) {
            this.G = 100.0f;
        } else if (f16 < 0.0f) {
            this.G = 0.0f;
        } else {
            this.G = f16;
        }
        invalidate();
    }

    public void setStrokeWidth(float f16) {
        int i3 = (int) ((f16 * this.f224183e) + 0.5d);
        this.f224182d = i3;
        this.F.setStrokeWidth(i3);
    }

    public void setmShadowColor(int i3) {
        this.f224185h = i3;
    }

    public GuildFeedProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = new RectF();
        this.I = true;
        this.J = true;
        a();
    }
}
