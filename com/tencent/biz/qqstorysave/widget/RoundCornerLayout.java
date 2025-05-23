package com.tencent.biz.qqstorysave.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RoundCornerLayout extends RelativeLayout {
    public static final float[] G = {7.0f, 9.0f, 0.0f, 6.0f, 2.5f, 9.0f, 5.5f, 15.0f, 0.5f, 13.0f};
    private static boolean H;
    private Resources C;
    private Paint D;
    private Path E;
    public boolean F;

    /* renamed from: d, reason: collision with root package name */
    Paint f94533d;

    /* renamed from: e, reason: collision with root package name */
    float[] f94534e;

    /* renamed from: f, reason: collision with root package name */
    Path f94535f;

    /* renamed from: h, reason: collision with root package name */
    RectF f94536h;

    /* renamed from: i, reason: collision with root package name */
    RectF f94537i;

    /* renamed from: m, reason: collision with root package name */
    private float f94538m;

    static {
        boolean z16;
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (!upperCase.contains("BV0720") && !upperCase.contains("M821")) {
            z16 = false;
        } else {
            z16 = true;
        }
        H = z16;
    }

    public RoundCornerLayout(Context context) {
        super(context);
        b();
    }

    public static int a(float f16, Resources resources) {
        return (int) ((resources.getDisplayMetrics().density * f16) + 0.5f);
    }

    private void b() {
        this.F = H;
        this.C = getResources();
        Paint paint = new Paint();
        this.f94533d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f94533d.setAntiAlias(true);
        this.f94533d.setFilterBitmap(true);
        this.f94533d.setColor(-1);
        this.f94533d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f94535f = new Path();
        this.f94536h = new RectF();
        this.f94537i = new RectF();
        this.f94534e = new float[8];
        Paint paint2 = new Paint();
        this.D = paint2;
        paint2.setColor(-1);
        this.D.setAntiAlias(true);
        this.D.setStrokeWidth(4.0f);
        this.D.setStyle(Paint.Style.STROKE);
        this.E = new Path();
        setWillNotDraw(false);
    }

    public void c(float f16, float f17) {
        this.f94536h.set(0.0f, 0.0f, f16, f17);
        this.f94535f.reset();
        this.f94535f.addRoundRect(this.f94536h, this.f94534e, Path.Direction.CW);
        this.f94537i.set(2.0f, 2.0f, f16 - 2.0f, f17 - 2.0f);
        this.E.reset();
        this.E.addRoundRect(this.f94537i, this.f94534e, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.draw(canvas);
        canvas.drawPath(this.f94535f, this.f94533d);
        canvas.drawPath(this.E, this.D);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.F) {
            setLayerType(1, null);
        } else {
            setLayerType(2, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setLayerType(0, null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            c(getWidth(), getHeight());
        }
    }

    public void setRadius(float f16) {
        float a16 = a(f16, this.C);
        this.f94538m = a16;
        float[] fArr = this.f94534e;
        if (fArr != null) {
            Arrays.fill(fArr, a16);
        }
    }

    public RoundCornerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public RoundCornerLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
    }
}
