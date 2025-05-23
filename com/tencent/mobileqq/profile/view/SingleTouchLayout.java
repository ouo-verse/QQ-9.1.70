package com.tencent.mobileqq.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SingleTouchLayout extends FrameLayout {
    static IPatchRedirector $redirector_;
    public int C;
    private float D;
    private float E;
    private int F;
    private int G;
    public Point H;
    public Point I;
    public Point J;
    public Point K;
    Point L;
    Point M;
    Rect N;
    Matrix P;
    Bitmap Q;
    Bitmap R;
    Bitmap S;
    Bitmap T;
    public int U;
    public int V;
    Path W;

    /* renamed from: a0, reason: collision with root package name */
    Paint f260440a0;

    /* renamed from: b0, reason: collision with root package name */
    float f260441b0;

    /* renamed from: c0, reason: collision with root package name */
    float f260442c0;

    /* renamed from: d, reason: collision with root package name */
    public float f260443d;

    /* renamed from: d0, reason: collision with root package name */
    int f260444d0;

    /* renamed from: e, reason: collision with root package name */
    public float f260445e;

    /* renamed from: e0, reason: collision with root package name */
    int f260446e0;

    /* renamed from: f, reason: collision with root package name */
    private PointF f260447f;

    /* renamed from: f0, reason: collision with root package name */
    int f260448f0;

    /* renamed from: g0, reason: collision with root package name */
    int f260449g0;

    /* renamed from: h, reason: collision with root package name */
    public int f260450h;

    /* renamed from: h0, reason: collision with root package name */
    boolean f260451h0;

    /* renamed from: i, reason: collision with root package name */
    public int f260452i;

    /* renamed from: i0, reason: collision with root package name */
    boolean f260453i0;

    /* renamed from: j0, reason: collision with root package name */
    DisplayMetrics f260454j0;

    /* renamed from: k0, reason: collision with root package name */
    PointF f260455k0;

    /* renamed from: l0, reason: collision with root package name */
    PointF f260456l0;

    /* renamed from: m, reason: collision with root package name */
    public int f260457m;

    /* renamed from: m0, reason: collision with root package name */
    int f260458m0;

    /* renamed from: n0, reason: collision with root package name */
    int f260459n0;

    /* renamed from: o0, reason: collision with root package name */
    View f260460o0;

    /* renamed from: p0, reason: collision with root package name */
    int f260461p0;

    /* renamed from: q0, reason: collision with root package name */
    int f260462q0;

    /* renamed from: r0, reason: collision with root package name */
    boolean f260463r0;

    /* renamed from: s0, reason: collision with root package name */
    boolean f260464s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f260465t0;

    /* renamed from: u0, reason: collision with root package name */
    boolean f260466u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f260467v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f260468w0;

    /* renamed from: x0, reason: collision with root package name */
    float f260469x0;

    /* renamed from: y0, reason: collision with root package name */
    float f260470y0;

    /* renamed from: z0, reason: collision with root package name */
    long f260471z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Point f260472a;

        /* renamed from: b, reason: collision with root package name */
        Point f260473b;

        /* renamed from: c, reason: collision with root package name */
        Point f260474c;

        /* renamed from: d, reason: collision with root package name */
        Point f260475d;

        /* renamed from: e, reason: collision with root package name */
        Point f260476e;

        /* renamed from: f, reason: collision with root package name */
        Point f260477f;

        /* renamed from: g, reason: collision with root package name */
        int f260478g;

        /* renamed from: h, reason: collision with root package name */
        int f260479h;

        /* renamed from: i, reason: collision with root package name */
        int f260480i;

        /* renamed from: j, reason: collision with root package name */
        int f260481j;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SingleTouchLayout.this);
            }
        }
    }

    public SingleTouchLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    public static double d(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    public static Point l(Point point, Point point2, float f16) {
        double d16;
        double asin;
        double d17;
        int i3;
        int i16;
        Point point3 = new Point();
        point3.x = point2.x - point.x;
        point3.y = point2.y - point.y;
        Point point4 = new Point();
        int i17 = point3.x;
        int i18 = point3.y;
        double sqrt = Math.sqrt((i17 * i17) + (i18 * i18));
        int i19 = point3.x;
        if (i19 == 0 && point3.y == 0) {
            return point;
        }
        if (i19 >= 0 && (i16 = point3.y) >= 0) {
            d16 = Math.asin(i16 / sqrt);
        } else {
            if (i19 < 0 && point3.y >= 0) {
                asin = Math.asin(Math.abs(i19) / sqrt);
                d17 = 1.5707963267948966d;
            } else if (i19 < 0 && (i3 = point3.y) < 0) {
                asin = Math.asin(Math.abs(i3) / sqrt);
                d17 = 3.141592653589793d;
            } else if (i19 >= 0 && point3.y < 0) {
                asin = Math.asin(i19 / sqrt);
                d17 = 4.71238898038469d;
            } else {
                d16 = 0.0d;
            }
            d16 = asin + d17;
        }
        double d18 = d(n(d16) + f16);
        point4.x = (int) Math.round(Math.cos(d18) * sqrt);
        int round = (int) Math.round(sqrt * Math.sin(d18));
        point4.y = round;
        point4.x += point.x;
        point4.y = round + point.y;
        return point4;
    }

    public static double n(double d16) {
        return (d16 * 180.0d) / 3.141592653589793d;
    }

    Point a(int i3, a aVar) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return aVar.f260472a;
                    }
                    return aVar.f260475d;
                }
                return aVar.f260474c;
            }
            return aVar.f260473b;
        }
        return aVar.f260472a;
    }

    void b() {
        int i3 = this.f260450h + this.U;
        int i16 = this.f260452i + this.V;
        PointF pointF = this.f260447f;
        int i17 = (int) (pointF.x - (i3 / 2));
        int i18 = (int) (pointF.y - (i16 / 2));
        if (this.F != i17 || this.G != i18) {
            this.F = i17;
            this.G = i18;
        }
        layout(i17, i18, i3 + i17, i16 + i18);
    }

    a c(int i3, int i16, int i17, int i18, float f16) {
        Point point = new Point(i3, i16);
        Point point2 = new Point(i17, i16);
        Point point3 = new Point(i17, i18);
        Point point4 = new Point(i3, i18);
        Point point5 = new Point((i3 + i17) / 2, (i16 + i18) / 2);
        a aVar = new a();
        aVar.f260472a = l(point5, point, f16);
        aVar.f260473b = l(point5, point2, f16);
        aVar.f260474c = l(point5, point3, f16);
        aVar.f260475d = l(point5, point4, f16);
        int g16 = g(Integer.valueOf(aVar.f260472a.x), Integer.valueOf(aVar.f260473b.x), Integer.valueOf(aVar.f260474c.x), Integer.valueOf(aVar.f260475d.x));
        int h16 = h(Integer.valueOf(aVar.f260472a.x), Integer.valueOf(aVar.f260473b.x), Integer.valueOf(aVar.f260474c.x), Integer.valueOf(aVar.f260475d.x));
        aVar.f260478g = g16 - h16;
        int g17 = g(Integer.valueOf(aVar.f260472a.y), Integer.valueOf(aVar.f260473b.y), Integer.valueOf(aVar.f260474c.y), Integer.valueOf(aVar.f260475d.y));
        int h17 = h(Integer.valueOf(aVar.f260472a.y), Integer.valueOf(aVar.f260473b.y), Integer.valueOf(aVar.f260474c.y), Integer.valueOf(aVar.f260475d.y));
        aVar.f260479h = g17 - h17;
        Point point6 = new Point((g16 + h16) / 2, (g17 + h17) / 2);
        int i19 = (aVar.f260478g / 2) - point6.x;
        aVar.f260480i = i19;
        int i26 = (aVar.f260479h / 2) - point6.y;
        aVar.f260481j = i26;
        int i27 = this.U / 2;
        int i28 = this.V / 2;
        Point point7 = aVar.f260472a;
        point7.x += i19 + i27;
        Point point8 = aVar.f260473b;
        point8.x += i19 + i27;
        Point point9 = aVar.f260474c;
        point9.x += i19 + i27;
        Point point10 = aVar.f260475d;
        point10.x += i19 + i27;
        point7.y += i26 + i28;
        point8.y += i26 + i28;
        point9.y += i26 + i28;
        point10.y += i26 + i28;
        aVar.f260476e = a(this.f260461p0, aVar);
        aVar.f260477f = a(this.f260462q0, aVar);
        return aVar;
    }

    double e(PointF pointF, PointF pointF2) {
        float f16 = pointF2.x - pointF.x;
        float f17 = pointF2.y - pointF.y;
        return Math.sqrt((f16 * f16) + (f17 * f17));
    }

    public PointF f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (PointF) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.f260447f;
    }

    public int g(Integer... numArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) numArr)).intValue();
        }
        List asList = Arrays.asList(numArr);
        Collections.sort(asList);
        return ((Integer) asList.get(asList.size() - 1)).intValue();
    }

    public int h(Integer... numArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) numArr)).intValue();
        }
        List asList = Arrays.asList(numArr);
        Collections.sort(asList);
        return ((Integer) asList.get(0)).intValue();
    }

    boolean i(int i3, int i16) {
        if (!this.f260463r0) {
            return true;
        }
        int i17 = i3 + this.U;
        int i18 = i16 + this.V;
        PointF pointF = this.f260447f;
        int i19 = (int) (pointF.x - (i17 / 2));
        int i26 = (int) (pointF.y - (i18 / 2));
        if (QLog.isColorLevel()) {
            QLog.d("SingleTouchLayout", 2, String.format("inBounds: l=%s, t=%s, w=%s, h=%s, cp.x=%s, cp.y=%s, width=%s, height=%s", Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i17), Integer.valueOf(i18), Float.valueOf(this.f260447f.x), Float.valueOf(this.f260447f.y), Integer.valueOf(this.f260457m), Integer.valueOf(this.f260457m)));
        }
        if (i19 >= 0 && i26 >= 0 && i19 + i17 <= this.f260457m && i26 + i18 <= this.C) {
            return true;
        }
        return false;
    }

    void j() {
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.f260440a0 = paint;
        paint.setAntiAlias(true);
        this.f260440a0.setDither(true);
        this.f260440a0.setColor(this.f260448f0);
        this.f260440a0.setStrokeWidth(this.f260449g0);
        this.f260440a0.setStyle(Paint.Style.STROKE);
        this.f260441b0 = BaseAIOUtils.f(2.0f, getResources());
        float f16 = BaseAIOUtils.f(1.0f, getResources());
        this.f260442c0 = f16;
        this.f260440a0.setShadowLayer(this.f260441b0, 0.0f, f16, -16777216);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 320;
        options.inTargetDensity = getResources().getDisplayMetrics().densityDpi;
        if (this.Q == null) {
            try {
                this.Q = BitmapFactory.decodeResource(getResources(), R.drawable.fsr, options);
            } catch (OutOfMemoryError unused) {
                QLog.e("SingleTouchLayout", 1, "controlDrawable decode failed");
            }
        }
        if (this.S == null) {
            try {
                this.S = BitmapFactory.decodeResource(getResources(), R.drawable.fss, options);
            } catch (OutOfMemoryError unused2) {
                QLog.e("SingleTouchLayout", 1, "deleteDrawable decode failed");
            }
        }
        Bitmap bitmap = this.Q;
        if (bitmap != null) {
            setIconSize(bitmap.getWidth(), this.Q.getHeight());
        }
        p();
    }

    int k(float f16, float f17) {
        if (e(new PointF(f16, f17), new PointF(this.L)) < Math.min(this.U / 2, this.V / 2)) {
            return 2;
        }
        return 1;
    }

    void m(AttributeSet attributeSet) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f260454j0 = displayMetrics;
        this.f260446e0 = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
        this.f260449g0 = (int) TypedValue.applyDimension(1, 1.0f, this.f260454j0);
        this.f260448f0 = -1;
        this.E = 1.0f;
        this.D = 0.0f;
        this.f260461p0 = 2;
        this.f260462q0 = 0;
        this.f260451h0 = true;
    }

    void o() {
        this.P.setRotate(this.D);
        Bitmap bitmap = this.R;
        if (bitmap != null && bitmap != this.Q) {
            bitmap.recycle();
        }
        Bitmap bitmap2 = this.Q;
        this.R = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.Q.getHeight(), this.P, false);
        Bitmap bitmap3 = this.T;
        if (bitmap3 != null && bitmap3 != this.S) {
            bitmap3.recycle();
        }
        Bitmap bitmap4 = this.S;
        this.T = Bitmap.createBitmap(bitmap4, 0, 0, bitmap4.getWidth(), this.S.getHeight(), this.P, false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        PointF pointF = this.f260447f;
        if (pointF.x != 0.0f && pointF.y != 0.0f) {
            if (this.f260457m == 0 || this.C == 0) {
                this.f260457m = viewGroup.getWidth();
                this.C = viewGroup.getHeight();
                p();
            }
        } else {
            this.f260457m = viewGroup.getWidth();
            this.C = viewGroup.getHeight();
            this.f260447f.set(this.f260457m / 2, r0 / 2);
            p();
        }
        if (!this.f260466u0) {
            p();
        }
        super.onDraw(canvas);
        if (this.f260451h0 && this.H != null && this.I != null && this.J != null && this.K != null && this.L != null && this.M != null) {
            this.W.reset();
            Path path = this.W;
            Point point = this.H;
            path.moveTo(point.x, point.y);
            Path path2 = this.W;
            Point point2 = this.I;
            path2.lineTo(point2.x, point2.y);
            Path path3 = this.W;
            Point point3 = this.J;
            path3.lineTo(point3.x, point3.y);
            Path path4 = this.W;
            Point point4 = this.K;
            path4.lineTo(point4.x, point4.y);
            Path path5 = this.W;
            Point point5 = this.H;
            path5.lineTo(point5.x, point5.y);
            Path path6 = this.W;
            Point point6 = this.I;
            path6.lineTo(point6.x, point6.y);
            canvas.drawPath(this.W, this.f260440a0);
            this.f260440a0.setFilterBitmap(true);
            Rect rect = this.N;
            Point point7 = this.L;
            int i3 = point7.x;
            int i16 = this.U;
            int i17 = point7.y;
            int i18 = this.V;
            rect.set(i3 - (i16 / 2), i17 - (i18 / 2), i3 + (i16 / 2), i17 + (i18 / 2));
            Bitmap bitmap = this.R;
            if (bitmap == null) {
                bitmap = this.Q;
            }
            canvas.drawBitmap(bitmap, (Rect) null, this.N, this.f260440a0);
            Rect rect2 = this.N;
            Point point8 = this.M;
            int i19 = point8.x;
            int i26 = this.U;
            int i27 = point8.y;
            int i28 = this.V;
            rect2.set(i19 - (i26 / 2), i27 - (i28 / 2), i19 + (i26 / 2), i27 + (i28 / 2));
            Bitmap bitmap2 = this.T;
            if (bitmap2 == null) {
                bitmap2 = this.S;
            }
            canvas.drawBitmap(bitmap2, (Rect) null, this.N, this.f260440a0);
            this.f260440a0.setFilterBitmap(false);
        }
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bb, code lost:
    
        if (r7 >= r1) goto L30;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f260451h0 && !this.f260453i0) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SingleTouchLayout", 4, "ActionMove: x=" + motionEvent.getX() + ", y=" + motionEvent.getY());
                    }
                    this.f260456l0.set(motionEvent.getX() + this.F, motionEvent.getY() + this.G);
                    int i3 = this.f260444d0;
                    if (i3 == 2) {
                        if (this.f260451h0) {
                            int width = this.f260460o0.getWidth() / 2;
                            int height = this.f260460o0.getHeight() / 2;
                            double e16 = e(this.f260447f, this.f260456l0) / Math.sqrt((width * width) + (height * height));
                            float f17 = this.f260445e;
                            if (e16 > f17) {
                                f17 = this.f260443d;
                            }
                            e16 = f17;
                            if (this.f260464s0) {
                                double e17 = e(this.f260447f, this.f260455k0);
                                double e18 = e(this.f260455k0, this.f260456l0);
                                double e19 = e(this.f260447f, this.f260456l0);
                                double d16 = (((e17 * e17) + (e19 * e19)) - (e18 * e18)) / ((e17 * 2.0d) * e19);
                                if (d16 >= 1.0d) {
                                    d16 = 1.0d;
                                }
                                f16 = (float) n(Math.acos(d16));
                                PointF pointF = this.f260455k0;
                                float f18 = pointF.x;
                                PointF pointF2 = this.f260447f;
                                PointF pointF3 = new PointF(f18 - pointF2.x, pointF.y - pointF2.y);
                                PointF pointF4 = this.f260456l0;
                                float f19 = pointF4.x;
                                PointF pointF5 = this.f260447f;
                                PointF pointF6 = new PointF(f19 - pointF5.x, pointF4.y - pointF5.y);
                                if ((pointF3.x * pointF6.y) - (pointF3.y * pointF6.x) < 0.0f) {
                                    f16 = -f16;
                                }
                            } else {
                                f16 = 0.0f;
                            }
                            float f26 = (float) e16;
                            if (q(f26, this.D + f16)) {
                                this.D += f16;
                                this.E = f26;
                                if (f16 != 0.0f) {
                                    o();
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("SingleTouchLayout", 4, "ActionMove-Zoom: scale=" + this.E + ", deltaY=" + this.D);
                                }
                            }
                            this.f260455k0.set(this.f260456l0);
                        }
                    } else {
                        if (i3 == 1) {
                            if (this.f260453i0) {
                                PointF pointF7 = this.f260456l0;
                                float f27 = pointF7.x;
                                PointF pointF8 = this.f260455k0;
                                float f28 = f27 - pointF8.x;
                                float f29 = pointF7.y - pointF8.y;
                                if (this.f260463r0) {
                                    if (getLeft() + f28 >= 0.0f && getRight() + f28 <= this.f260457m) {
                                        this.f260447f.x += f28;
                                    }
                                    if (getTop() + f29 >= 0.0f && getBottom() + f29 <= this.C) {
                                        this.f260447f.y += f29;
                                    }
                                } else {
                                    PointF pointF9 = this.f260447f;
                                    pointF9.x += f28;
                                    pointF9.y += f29;
                                }
                                b();
                            }
                        }
                        this.f260455k0.set(this.f260456l0);
                    }
                }
            } else {
                Log.d("SingleTouchLayout", "ActionUp -- (" + motionEvent.getX() + ", " + motionEvent.getY() + ")");
                this.f260444d0 = 0;
            }
        } else {
            this.f260471z0 = System.currentTimeMillis();
            this.f260469x0 = motionEvent.getRawX();
            this.f260470y0 = motionEvent.getRawY();
            this.f260455k0.set(motionEvent.getX() + this.F, motionEvent.getY() + this.G);
            this.f260444d0 = k(motionEvent.getX(), motionEvent.getY());
            Log.d("SingleTouchLayout", "ActionDown -- (" + motionEvent.getX() + ", " + motionEvent.getY() + ")");
        }
        return true;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return q(this.E, this.D);
    }

    @TargetApi(11)
    public boolean q(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (this.f260460o0 == null) {
            return true;
        }
        int i3 = this.f260467v0;
        if (i3 > 0 && this.f260468w0 > 0) {
            this.f260466u0 = true;
        }
        int i16 = (int) (i3 * f16);
        int i17 = (int) (this.f260468w0 * f16);
        if (QLog.isColorLevel()) {
            QLog.d("SingleTouchLayout", 2, "transformDraw(): mActualViewWidth=" + i16 + ", mActualViewHeight=" + i17);
        }
        int i18 = this.f260446e0;
        a c16 = c(-i18, -i18, i16 + i18, i17 + i18, f17);
        if (!i(c16.f260478g, c16.f260479h) && this.f260466u0) {
            PointF pointF = this.f260447f;
            if (pointF.x != 0.0f && pointF.y != 0.0f && this.f260451h0) {
                return false;
            }
        }
        this.H = c16.f260472a;
        this.I = c16.f260473b;
        this.J = c16.f260474c;
        this.K = c16.f260475d;
        this.L = c16.f260476e;
        this.M = c16.f260477f;
        this.f260450h = c16.f260478g;
        this.f260452i = c16.f260479h;
        this.f260458m0 = c16.f260480i;
        this.f260459n0 = c16.f260481j;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f260460o0.getLayoutParams();
        layoutParams.leftMargin = ((this.f260450h + this.U) - this.f260460o0.getWidth()) / 2;
        layoutParams.topMargin = ((this.f260452i + this.V) - this.f260460o0.getHeight()) / 2;
        this.f260460o0.setLayoutParams(layoutParams);
        this.f260460o0.setScaleX(f16);
        this.f260460o0.setScaleY(f16);
        this.f260460o0.setRotation(f17 % 360.0f);
        if (QLog.isColorLevel()) {
            QLog.d("SingleTouchLayout", 2, "transformDraw(): mViewWidth=" + this.f260450h + ", mViewHeight=" + this.f260452i);
        }
        b();
        return true;
    }

    public void setActualViewSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (this.f260460o0 != null) {
            this.f260467v0 = i3;
            this.f260468w0 = i16;
            p();
        }
    }

    public void setBoundLimited(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f260463r0 = z16;
        }
    }

    public void setCenterPoint(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f260447f = new PointF(f16, f17);
            b();
        }
    }

    public void setEditable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.f260451h0 = z16;
            invalidate();
        }
    }

    public void setFrameWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            if (this.f260449g0 == i3) {
                return;
            }
            float f16 = i3;
            this.f260449g0 = (int) TypedValue.applyDimension(1, f16, this.f260454j0);
            this.f260440a0.setStrokeWidth(f16);
            invalidate();
        }
    }

    public void setIconSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.U = i3;
        this.V = i16;
        p();
    }

    public void setImageDegree(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16));
        } else if (this.D != f16) {
            this.D = f16;
            o();
            p();
        }
    }

    public void setImageScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16));
        } else if (this.E != f16) {
            this.E = f16;
            p();
        }
    }

    public void setMovable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.f260453i0 = z16;
        }
    }

    public void setRotateEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f260464s0 = z16;
        }
    }

    public void setScaleLimit(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f260445e = f16;
            this.f260443d = f17;
        }
    }

    public SingleTouchLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }

    public SingleTouchLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f260443d = 4.0f;
        this.f260445e = 0.3f;
        this.f260447f = new PointF();
        this.D = 0.0f;
        this.E = 1.0f;
        this.L = new Point();
        this.M = new Point();
        this.N = new Rect();
        this.P = new Matrix();
        this.W = new Path();
        this.f260444d0 = 0;
        this.f260446e0 = 8;
        this.f260448f0 = -1;
        this.f260449g0 = 1;
        this.f260451h0 = true;
        this.f260453i0 = true;
        this.f260455k0 = new PointF();
        this.f260456l0 = new PointF();
        this.f260461p0 = 2;
        this.f260462q0 = 0;
        this.f260463r0 = false;
        this.f260464s0 = true;
        this.f260465t0 = 0;
        this.f260466u0 = false;
        m(attributeSet);
        j();
    }
}
