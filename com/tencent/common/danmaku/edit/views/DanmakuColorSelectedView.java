package com.tencent.common.danmaku.edit.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.common.danmaku.util.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DanmakuColorSelectedView extends View {
    static IPatchRedirector $redirector_;
    private String C;
    private int D;
    private int E;
    private int F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private int f99696d;

    /* renamed from: e, reason: collision with root package name */
    private int f99697e;

    /* renamed from: f, reason: collision with root package name */
    private int f99698f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f99699h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f99700i;

    /* renamed from: m, reason: collision with root package name */
    private String f99701m;

    public DanmakuColorSelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f99701m = "#FF0064";
        this.C = "#FFFFFF";
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f99700i = paint;
        paint.setColor(Color.parseColor(this.f99701m));
        Paint paint2 = new Paint(1);
        this.f99699h = paint2;
        paint2.setColor(Color.parseColor(this.C));
        this.f99699h.setStyle(Paint.Style.STROKE);
        this.f99699h.setStrokeWidth(c.b(2.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        canvas.drawCircle(this.f99696d / 2, this.f99697e / 2, this.f99698f, this.f99699h);
        canvas.drawCircle(this.f99696d / 2, this.f99697e / 2, this.f99698f, this.f99700i);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor(this.C));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(c.b(1.5f));
        int width = getWidth() / 2;
        int width2 = width - (getWidth() / 5);
        int i3 = this.f99698f;
        this.D = i3 / 3;
        this.E = i3 / 3;
        canvas.drawLine(width2, width, r4 + width2, r3 + width, paint);
        int i16 = this.D;
        int i17 = this.E;
        canvas.drawLine((width2 + i16) - 1, width + i17 + 1, i16 + width2 + width2, (width + i17) - width2, paint);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        this.f99696d = View.MeasureSpec.getSize(i3);
        this.f99697e = View.MeasureSpec.getSize(i16);
        this.f99698f = (this.f99696d / 2) - c.b(1.0f);
    }

    public DanmakuColorSelectedView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f99701m = "#FF0064";
        this.C = "#FFFFFF";
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        a(context);
    }
}
