package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BubbleViewLayout extends RelativeLayout {
    float[] C;
    private Resources D;
    RectF E;
    Path F;

    /* renamed from: d, reason: collision with root package name */
    private Paint f315473d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f315474e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315475f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f315476h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f315477i;

    /* renamed from: m, reason: collision with root package name */
    private float f315478m;

    public BubbleViewLayout(Context context) {
        super(context);
        this.f315475f = true;
        this.f315476h = true;
        this.f315477i = true;
        this.f315478m = 30.0f;
        b();
    }

    public static int a(float f16, Resources resources) {
        return (int) ((resources.getDisplayMetrics().density * f16) + 0.5f);
    }

    private void b() {
        Paint paint = new Paint();
        this.f315473d = paint;
        paint.setColor(-1);
        this.f315473d.setAntiAlias(true);
        this.f315473d.setStyle(Paint.Style.FILL);
        this.f315473d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Paint paint2 = new Paint();
        this.f315474e = paint2;
        paint2.setXfermode(null);
        this.F = new Path();
        this.E = new RectF();
        this.C = new float[8];
        this.D = getResources();
        setRadius(15.0f);
        setWillNotDraw(false);
    }

    public void c(float f16, float f17) {
        if (!this.f315475f) {
            this.E.set(0.0f, 0.0f, f16, f17);
            if (this.f315476h) {
                this.F.reset();
                this.F.addRoundRect(this.E, this.C, Path.Direction.CW);
                return;
            }
            return;
        }
        Resources resources = this.D;
        float a16 = a(10.0f, resources);
        if (this.f315477i) {
            this.E.set(0.0f, 0.0f, f16 - a16, f17);
        } else {
            this.E.set(a16, 0.0f, f16, f17);
        }
        this.F.reset();
        float a17 = a(5.0f, resources);
        if (this.f315477i) {
            this.F.addRoundRect(this.E, this.C, Path.Direction.CW);
            this.F.moveTo(f16 - a(14.0f, resources), a(8.0f, resources));
            this.F.quadTo(f16 - a(4.0f, resources), a(10.0f, resources), f16, a17);
            this.F.quadTo(f16 - a(1.0f, resources), a(14.0f, resources), f16 - a(10.0f, resources), a(16.0f, resources));
        } else {
            this.F.addRoundRect(this.E, this.C, Path.Direction.CCW);
            this.F.moveTo(a(14.0f, resources), a(8.0f, resources));
            this.F.quadTo(a(4.0f, resources), a(10.0f, resources), 0.0f, a17);
            this.F.quadTo(a(1.0f, resources), a(14.0f, resources), a(10.0f, resources), a(16.0f, resources));
        }
        this.F.close();
    }

    public void d(boolean z16) {
        this.f315476h = z16;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 28 && i3 != 29 && (i3 != 30 || !QQTheme.isNowSimpleUI())) {
            canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.f315474e, 31);
            super.dispatchDraw(canvas);
            canvas.drawPath(this.F, this.f315473d);
            canvas.restore();
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.clipPath(this.F);
        super.dispatchDraw(canvas);
    }

    public void e(boolean z16) {
        this.f315475f = z16;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            c(getWidth(), getHeight());
        }
    }

    public void setRadius(float f16) {
        float a16 = a(f16, this.D);
        this.f315478m = a16;
        float[] fArr = this.C;
        if (fArr != null) {
            Arrays.fill(fArr, a16);
        }
    }

    public void setRadiusTop(float f16) {
        float a16 = a(f16, this.D);
        this.f315478m = a16;
        float[] fArr = this.C;
        if (fArr != null) {
            Arrays.fill(fArr, 0, 4, a16);
            Arrays.fill(this.C, 4, 8, 0.0f);
        }
    }

    public BubbleViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315475f = true;
        this.f315476h = true;
        this.f315477i = true;
        this.f315478m = 30.0f;
        b();
    }
}
