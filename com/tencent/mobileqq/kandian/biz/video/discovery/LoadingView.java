package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LoadingView extends View {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;

    /* renamed from: d, reason: collision with root package name */
    private Paint f239638d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f239639e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f239640f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f239641h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f239642i;

    /* renamed from: m, reason: collision with root package name */
    private int f239643m;

    public LoadingView(Context context) {
        super(context);
        e();
    }

    private void a(Canvas canvas) {
        this.f239640f.left = getLeft() + getPaddingLeft();
        RectF rectF = this.f239640f;
        int i3 = (this.D + (this.H * 2)) / 2;
        int i16 = this.f239643m;
        float f16 = i3 - (i16 / 2);
        rectF.top = f16;
        rectF.right = rectF.left + i16;
        rectF.bottom = f16 + i16;
        canvas.drawRect(rectF, this.f239638d);
    }

    private void b(Canvas canvas) {
        this.f239641h.left = (int) (getLeft() + this.G + this.f239640f.right);
        Rect rect = this.f239641h;
        int i3 = this.H;
        rect.top = i3;
        rect.right = rect.left + this.C;
        rect.bottom = i3 + this.D;
        canvas.drawRect(rect, this.f239638d);
    }

    private void c(Canvas canvas) {
        Rect rect = this.f239642i;
        int i3 = rect.left;
        int i16 = this.F;
        canvas.drawLine(i3 + i16, rect.top, i16 + i3, i3 + r0 + this.E, this.f239639e);
        Rect rect2 = this.f239642i;
        int i17 = rect2.left;
        int i18 = this.F;
        canvas.drawLine((i18 * 2) + i17, rect2.top, i17 + (i18 * 2), r0 + this.E, this.f239639e);
        Rect rect3 = this.f239642i;
        int i19 = rect3.left;
        int i26 = this.F;
        canvas.drawLine((i26 * 3) + i19, rect3.top, i19 + (i26 * 3), r0 + this.E, this.f239639e);
    }

    private void d(Canvas canvas) {
        this.f239642i.left = getLeft() + getPaddingLeft();
        Rect rect = this.f239642i;
        rect.top = this.f239641h.bottom + this.H;
        rect.right = rect.left + ((int) ah.M());
        Rect rect2 = this.f239642i;
        rect2.bottom = rect2.top + this.E;
        canvas.drawRect(rect2, this.f239638d);
    }

    private void e() {
        this.f239640f = new RectF();
        this.f239641h = new Rect();
        this.f239642i = new Rect();
        Paint paint = new Paint();
        this.f239638d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f239638d.setColor(Color.parseColor("#E8E8E7"));
        Paint paint2 = new Paint();
        this.f239639e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f239639e.setStrokeWidth(BaseAIOUtils.f(2.0f, getResources()));
        this.f239639e.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.f239643m = BaseAIOUtils.f(28.0f, getResources());
        this.C = BaseAIOUtils.f(100.0f, getResources());
        this.D = BaseAIOUtils.f(15.0f, getResources());
        int M = (int) (ah.M() * 0.29d);
        this.F = M;
        this.E = (M * 4) / 3;
        this.G = BaseAIOUtils.f(9.0f, getResources());
        this.H = BaseAIOUtils.f(18.0f, getResources());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        a(canvas);
        b(canvas);
        d(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension((int) ah.M(), this.D + (this.H * 2) + this.E);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e();
    }
}
