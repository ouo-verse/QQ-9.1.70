package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.util.ar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes37.dex */
public class DrawActionView extends View {
    private final List<Point> C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private a I;
    private final Path J;
    private PointF K;
    private PointF L;
    private final Set<Integer> M;

    /* renamed from: d, reason: collision with root package name */
    private Paint f60204d;

    /* renamed from: e, reason: collision with root package name */
    private int f60205e;

    /* renamed from: f, reason: collision with root package name */
    private int f60206f;

    /* renamed from: h, reason: collision with root package name */
    private int f60207h;

    /* renamed from: i, reason: collision with root package name */
    private int f60208i;

    /* renamed from: m, reason: collision with root package name */
    private final List<Point> f60209m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void onAction();

        boolean onClickAction();

        void onStateChange(boolean z16);
    }

    public DrawActionView(Context context) {
        super(context);
        this.f60209m = new ArrayList();
        this.C = new ArrayList();
        this.J = new Path();
        this.K = new PointF(0.0f, 0.0f);
        this.L = new PointF(0.0f, 0.0f);
        this.M = new HashSet();
        d(null, 0, 0);
    }

    private void b() {
        a aVar;
        PointF pointF;
        PointF pointF2;
        if (this.M.size() == this.f60209m.size() && this.I != null && (pointF = this.K) != null && (pointF2 = this.L) != null && ((pointF2.x == 0.0f && pointF2.y == 0.0f) || pointF.equals(pointF2))) {
            a();
            if (this.I.onClickAction()) {
                return;
            }
        }
        if (this.M.size() == this.f60209m.size() && (aVar = this.I) != null) {
            aVar.onAction();
        }
        a();
    }

    private List<Integer> c(float f16, float f17) {
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < this.f60209m.size(); i3++) {
            if (g(this.f60209m.get(i3), f16, f17)) {
                linkedList.add(Integer.valueOf(i3));
            }
        }
        return linkedList;
    }

    private void d(AttributeSet attributeSet, int i3, int i16) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, jj2.b.f410269z1, i3, i16);
        this.f60205e = obtainStyledAttributes.getColor(0, 0);
        int color = obtainStyledAttributes.getColor(1, -1);
        this.f60206f = obtainStyledAttributes.getDimensionPixelSize(2, ar.d(1.0f));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f60204d = paint;
        paint.setAntiAlias(true);
        this.f60204d.setColor(color);
        this.f60204d.setStrokeWidth(this.f60206f);
    }

    private boolean e(float f16, float f17) {
        if (this.f60209m.size() < 2) {
            return c(f16, f17).size() > 0;
        }
        for (int i3 = 1; i3 < this.f60209m.size(); i3++) {
            if (f(i3 - 1, i3, f16, f17)) {
                return true;
            }
        }
        return false;
    }

    private boolean g(Point point, float f16, float f17) {
        return Math.sqrt(Math.pow((double) (((float) point.x) - f16), 2.0d) + Math.pow((double) (((float) point.y) - f17), 2.0d)) <= ((double) this.F);
    }

    private Point h(Point point) {
        return new Point((point.x * this.f60207h) / this.D, (point.y * this.f60208i) / this.E);
    }

    public void a() {
        if (this.G) {
            this.G = false;
            this.J.reset();
            this.M.clear();
            PointF pointF = this.L;
            pointF.x = 0.0f;
            pointF.y = 0.0f;
            invalidate();
            a aVar = this.I;
            if (aVar != null) {
                aVar.onStateChange(false);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("DrawActionView", "onDetachedFromWindow: ");
        a();
        this.I = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.H && this.G) {
            this.f60204d.setStyle(Paint.Style.STROKE);
            canvas.drawColor(this.f60205e);
            canvas.drawPath(this.J, this.f60204d);
            if (this.f60206f > 1) {
                this.f60204d.setStyle(Paint.Style.FILL);
                float f16 = this.f60206f / 2.0f;
                PointF pointF = this.K;
                if ((pointF == null && this.L == null) || pointF == null || pointF.equals(this.L)) {
                    return;
                }
                PointF pointF2 = this.K;
                if (pointF2 != null) {
                    canvas.drawCircle(pointF2.x, pointF2.y, f16, this.f60204d);
                }
                PointF pointF3 = this.L;
                if (pointF3 != null) {
                    canvas.drawCircle(pointF3.x, pointF3.y, f16, this.f60204d);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f60207h && height == this.f60208i) {
            return;
        }
        Log.i("DrawActionView", "onLayout: " + width + " " + height);
        a();
        this.f60207h = width;
        this.f60208i = height;
        if (this.H) {
            this.f60209m.clear();
            Iterator<Point> it = this.C.iterator();
            while (it.hasNext()) {
                this.f60209m.add(h(it.next()));
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        Log.i("DrawActionView", "onMeasure: " + Integer.toHexString(i3) + " " + Integer.toHexString(i16));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r6 != 6) goto L36;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.H || (!this.G && motionEvent.getAction() != 0)) {
            return false;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    List<Integer> c16 = c(x16, y16);
                    if (c16.size() <= 0 && !e(x16, y16)) {
                        b();
                    } else {
                        this.M.addAll(c16);
                        this.J.lineTo(x16, y16);
                        this.L = new PointF(x16, y16);
                        invalidate();
                    }
                } else if (action != 3) {
                }
            }
            b();
        } else {
            List<Integer> c17 = c(x16, y16);
            if (c17.size() <= 0 && !e(x16, y16)) {
                return false;
            }
            this.G = true;
            this.M.addAll(c17);
            this.J.moveTo(x16, y16);
            this.K = new PointF(x16, y16);
            a aVar = this.I;
            if (aVar != null) {
                aVar.onStateChange(true);
            }
        }
        return true;
    }

    public void setBgColor(int i3) {
        if (this.f60205e == i3) {
            return;
        }
        this.f60205e = i3;
        invalidate();
    }

    public void setData(List<Point> list, int i3, int i16, int i17, boolean z16) {
        Log.i("DrawActionView", "setData: ", new Throwable());
        if (this.H) {
            a();
            this.C.clear();
            this.f60209m.clear();
        }
        if (list != null && !list.isEmpty() && i3 != 0 && i16 != 0) {
            this.D = i3;
            this.E = i16;
            this.F = i17;
            Log.i("DrawActionView", "setData: " + this.D + " " + this.E + " " + this.F);
            for (Point point : list) {
                Point point2 = new Point();
                point2.x = Math.min(this.D, Math.max(0, point.x));
                point2.y = Math.min(this.E, Math.max(0, point.y));
                this.C.add(point2);
                this.f60209m.add(h(point2));
            }
            if (this.C.size() > 2 && z16) {
                List<Point> list2 = this.C;
                list2.add(list2.get(0));
                List<Point> list3 = this.f60209m;
                list3.add(list3.get(0));
            }
            this.H = true;
            return;
        }
        this.H = false;
    }

    public void setDrawActionListener(a aVar) {
        this.I = aVar;
    }

    public void setLineStyle(int i3, int i16) {
        this.f60206f = i16;
        this.f60204d.setColor(i3);
        this.f60204d.setStrokeWidth(this.f60206f);
        invalidate();
    }

    private boolean f(int i3, int i16, float f16, float f17) {
        Point point;
        Point point2;
        double d16;
        float f18;
        double d17;
        int i17;
        Point point3 = this.f60209m.get(i3);
        Point point4 = this.f60209m.get(i16);
        if (point3.equals(point4)) {
            return g(point3, f16, f17);
        }
        int i18 = point3.x;
        int i19 = point4.x;
        if (i18 > i19 || (i18 == i19 && point3.y > point4.y)) {
            point = point3;
            point2 = point4;
        } else {
            point2 = point3;
            point = point4;
        }
        int i26 = point2.x;
        if (i26 == point.x) {
            d17 = i26;
            int i27 = point2.y;
            if (f17 >= i27) {
                i27 = point.y;
                if (f17 <= i27) {
                    d16 = f17;
                    f18 = f16;
                }
            }
            d16 = i27;
            f18 = f16;
        } else {
            double d18 = (point4.y - point3.y) / (i19 - i18);
            double pow = Math.pow(d18, 2.0d);
            double d19 = f16;
            double d26 = f17;
            int i28 = point3.x;
            int i29 = point3.y;
            double d27 = 1.0d + pow;
            double d28 = ((((d26 * d18) + d19) + (i28 * pow)) - (i29 * d18)) / d27;
            d16 = ((((d19 * d18) + (d26 * pow)) + i29) - (i28 * d18)) / d27;
            int i36 = point2.x;
            if (d28 < i36) {
                d17 = i36;
                i17 = point2.y;
            } else {
                int i37 = point.x;
                if (d28 > i37) {
                    d17 = i37;
                    i17 = point.y;
                } else {
                    f18 = f16;
                    d17 = d28;
                }
            }
            d16 = i17;
            f18 = f16;
        }
        return Math.sqrt(Math.pow(d17 - ((double) f18), 2.0d) + Math.pow(d16 - ((double) f17), 2.0d)) <= ((double) this.F);
    }

    public DrawActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60209m = new ArrayList();
        this.C = new ArrayList();
        this.J = new Path();
        this.K = new PointF(0.0f, 0.0f);
        this.L = new PointF(0.0f, 0.0f);
        this.M = new HashSet();
        d(attributeSet, 0, 0);
    }

    public DrawActionView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60209m = new ArrayList();
        this.C = new ArrayList();
        this.J = new Path();
        this.K = new PointF(0.0f, 0.0f);
        this.L = new PointF(0.0f, 0.0f);
        this.M = new HashSet();
        d(attributeSet, i3, 0);
    }
}
