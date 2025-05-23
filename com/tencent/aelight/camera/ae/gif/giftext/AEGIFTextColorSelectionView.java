package com.tencent.aelight.camera.ae.gif.giftext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEGIFTextColorSelectionView extends View {
    private static String H = "#FFFFFF";
    private static String I = "#FFFFFF";
    private static String J = "#3CB6FF";
    private Context C;
    private Paint D;
    private Paint E;
    private Paint F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private int f65348d;

    /* renamed from: e, reason: collision with root package name */
    private int f65349e;

    /* renamed from: f, reason: collision with root package name */
    private int f65350f;

    /* renamed from: h, reason: collision with root package name */
    private int f65351h;

    /* renamed from: i, reason: collision with root package name */
    private int f65352i;

    /* renamed from: m, reason: collision with root package name */
    private String f65353m;

    public AEGIFTextColorSelectionView(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        this.C = context;
        this.G = true;
        this.f65353m = H;
        Paint paint = new Paint(1);
        this.D = paint;
        paint.setColor(Color.parseColor(this.f65353m));
        Paint paint2 = new Paint(1);
        this.F = paint2;
        paint2.setColor(Color.parseColor(I));
        Paint paint3 = new Paint(1);
        this.E = paint3;
        paint3.setColor(Color.parseColor(J));
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth(x.c(this.C, 2.0f));
    }

    public void a(Boolean bool) {
        if (bool.booleanValue() != this.G) {
            this.G = bool.booleanValue();
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.G) {
            canvas.drawCircle(this.f65348d / 2, this.f65349e / 2, this.f65352i, this.E);
        }
        canvas.drawCircle(this.f65348d / 2, this.f65349e / 2, this.f65350f, this.F);
        canvas.drawCircle(this.f65348d / 2, this.f65349e / 2, this.f65351h, this.D);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f65348d = View.MeasureSpec.getSize(i3);
        this.f65349e = View.MeasureSpec.getSize(i16);
        int c16 = (this.f65348d / 2) - x.c(this.C, 1.0f);
        this.f65352i = c16;
        int c17 = c16 - x.c(this.C, 5.0f);
        this.f65350f = c17;
        this.f65351h = c17 - x.c(this.C, 2.0f);
    }

    public void setColor(String str) {
        this.f65353m = str;
        this.D.setColor(Color.parseColor(str));
        invalidate();
    }

    public AEGIFTextColorSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public AEGIFTextColorSelectionView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context);
    }
}
