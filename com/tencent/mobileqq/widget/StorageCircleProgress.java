package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes20.dex */
public class StorageCircleProgress extends View {
    protected Paint.Cap C;
    private final Path D;
    private Paint E;
    private int F;
    private float G;
    private final List<a> H;

    /* renamed from: d, reason: collision with root package name */
    protected int f316320d;

    /* renamed from: e, reason: collision with root package name */
    protected int f316321e;

    /* renamed from: f, reason: collision with root package name */
    protected final RectF f316322f;

    /* renamed from: h, reason: collision with root package name */
    protected float f316323h;

    /* renamed from: i, reason: collision with root package name */
    protected int f316324i;

    /* renamed from: m, reason: collision with root package name */
    protected float f316325m;

    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f316326a;

        /* renamed from: b, reason: collision with root package name */
        public Paint f316327b;

        /* renamed from: c, reason: collision with root package name */
        public Path f316328c;

        /* renamed from: d, reason: collision with root package name */
        public float f316329d;

        /* renamed from: e, reason: collision with root package name */
        public float f316330e;
    }

    public StorageCircleProgress(Context context) {
        this(context, null);
    }

    private boolean d(int i3) {
        Iterator<a> it = this.H.iterator();
        while (it.hasNext()) {
            if (it.next().f316326a == i3) {
                return true;
            }
        }
        return false;
    }

    private a e(int i3, float f16, float f17) {
        a aVar = new a();
        aVar.f316326a = i3;
        Path path = new Path();
        path.addArc(this.f316322f, f16, f17);
        aVar.f316328c = path;
        aVar.f316327b = g();
        aVar.f316329d = f16;
        aVar.f316330e = f17;
        return aVar;
    }

    private Paint g() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(this.C);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f316323h);
        return paint;
    }

    private void i(Context context, @Nullable AttributeSet attributeSet) {
        Resources resources = context.getResources();
        float dimension = resources.getDimension(R.dimen.c7v);
        int color = resources.getColor(R.color.f156875bc3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u51.a.f438329s);
        float f16 = obtainStyledAttributes.getFloat(u51.a.f438338v, 100.0f);
        this.f316325m = f16;
        this.G = obtainStyledAttributes.getFloat(u51.a.f438335u, f16);
        this.f316323h = obtainStyledAttributes.getDimension(u51.a.f438347y, dimension);
        this.F = obtainStyledAttributes.getColor(u51.a.f438332t, color);
        this.f316324i = obtainStyledAttributes.getInt(u51.a.f438341w, 0);
        int i3 = obtainStyledAttributes.getInt(u51.a.f438344x, 0);
        obtainStyledAttributes.recycle();
        this.C = o(i3);
        l();
    }

    private void j() {
        this.D.reset();
        float f16 = (this.G / this.f316325m) * 360.0f;
        float f17 = this.f316324i;
        float f18 = f17 + f16;
        if (f18 > 360.0f) {
            this.D.addArc(this.f316322f, f17, 360 - r2);
            this.D.addArc(this.f316322f, 0.0f, f18 % 360.0f);
            return;
        }
        this.D.addArc(this.f316322f, f17, f16);
    }

    private void k() {
        int i3 = this.f316320d;
        float f16 = this.f316323h;
        float f17 = (i3 / 2.0f) - (f16 / 2.0f);
        int i16 = this.f316321e;
        float f18 = (i16 / 2.0f) - (f16 / 2.0f);
        RectF rectF = this.f316322f;
        rectF.left = (i3 / 2.0f) - f17;
        rectF.right = (i3 / 2.0f) + f17;
        rectF.top = (i16 / 2.0f) - f18;
        rectF.bottom = (i16 / 2.0f) + f18;
        for (a aVar : this.H) {
            if (aVar.f316329d != 0.0f || aVar.f316330e != 0.0f) {
                aVar.f316328c.reset();
                aVar.f316328c.addArc(this.f316322f, aVar.f316329d, aVar.f316330e);
            }
        }
    }

    private void l() {
        Paint paint = new Paint();
        this.E = paint;
        paint.setAntiAlias(true);
        this.E.setStrokeCap(this.C);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth(this.f316323h);
        this.E.setColor(this.F);
    }

    private Paint.Cap o(int i3) {
        if (i3 == 1) {
            return Paint.Cap.ROUND;
        }
        if (i3 == 2) {
            return Paint.Cap.SQUARE;
        }
        return Paint.Cap.BUTT;
    }

    public void a(int i3, float f16, float f17, int i16) {
        if (d(i3)) {
            m(i3);
        }
        a e16 = e(i3, f16, f17);
        e16.f316327b.setColor(i16);
        this.H.add(e16);
        invalidate();
    }

    public void b(int i3, float f16, int i16) {
        a(i3, this.f316324i, (f16 / this.f316325m) * 360.0f, i16);
    }

    public void c(a aVar) {
        if (aVar == null) {
            return;
        }
        if (d(aVar.f316326a)) {
            n(aVar);
        }
        this.H.add(aVar);
        invalidate();
    }

    public Paint.Cap f() {
        return this.C;
    }

    public float h() {
        return this.f316323h;
    }

    public void m(int i3) {
        Iterator<a> it = this.H.iterator();
        while (it.hasNext()) {
            if (it.next().f316326a == i3) {
                it.remove();
                invalidate();
                return;
            }
        }
    }

    public void n(a aVar) {
        if (aVar != null && this.H.remove(aVar)) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.D, this.E);
        for (a aVar : this.H) {
            canvas.drawPath(aVar.f316328c, aVar.f316327b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f316320d = getWidth();
        this.f316321e = getHeight();
        k();
        j();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.F = i3;
        this.E.setColor(i3);
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.C = cap;
        this.E.setStrokeCap(cap);
        invalidate();
    }

    public void setMaxProgress(float f16) {
        this.f316325m = f16;
        j();
        invalidate();
    }

    public void setProgress(float f16) {
        this.G = f16;
        j();
        invalidate();
    }

    public void setStartAngel(int i3) {
        this.f316324i = i3;
        j();
        invalidate();
    }

    public void setStrokeWidth(float f16) {
        this.f316323h = f16;
        k();
        invalidate();
    }

    public StorageCircleProgress(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StorageCircleProgress(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316322f = new RectF();
        this.D = new Path();
        this.H = new ArrayList();
        i(context, attributeSet);
    }
}
