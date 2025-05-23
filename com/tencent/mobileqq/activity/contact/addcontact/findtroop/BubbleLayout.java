package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BubbleLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private RectF C;
    int D;
    int E;
    boolean F;
    float G;

    /* renamed from: d, reason: collision with root package name */
    private int f181083d;

    /* renamed from: e, reason: collision with root package name */
    @Direction
    private int f181084e;

    /* renamed from: f, reason: collision with root package name */
    private Point f181085f;

    /* renamed from: h, reason: collision with root package name */
    private int f181086h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f181087i;

    /* renamed from: m, reason: collision with root package name */
    private Path f181088m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private @interface Direction {
    }

    public BubbleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            f(context, attributeSet);
        }
    }

    private void a() {
        int i3 = this.f181084e;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                }
            }
            this.f181085f.x += this.f181086h;
            return;
        }
        this.f181085f.y += this.f181086h;
    }

    private void b(Canvas canvas) {
        if (getPaddingBottom() == 0) {
            return;
        }
        this.f181088m.reset();
        Path path = this.f181088m;
        RectF rectF = this.C;
        int i3 = this.f181083d;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CCW);
        if (this.F) {
            Path path2 = this.f181088m;
            RectF rectF2 = this.C;
            int i16 = this.f181083d;
            path2.addRoundRect(rectF2, i16, i16, Path.Direction.CCW);
            Path path3 = this.f181088m;
            Point point = this.f181085f;
            path3.moveTo(point.x + r0, point.y);
            Path path4 = this.f181088m;
            Point point2 = this.f181085f;
            path4.lineTo(point2.x, point2.y + r0);
            Path path5 = this.f181088m;
            Point point3 = this.f181085f;
            path5.lineTo(point3.x - r0, point3.y);
            this.f181087i.setPathEffect(new CornerPathEffect(this.G));
        }
        canvas.drawPath(this.f181088m, this.f181087i);
    }

    private void c(Canvas canvas) {
        if (getPaddingLeft() == 0) {
            return;
        }
        this.f181088m.reset();
        Path path = this.f181088m;
        RectF rectF = this.C;
        int i3 = this.f181083d;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CCW);
        if (this.F) {
            Path path2 = this.f181088m;
            Point point = this.f181085f;
            path2.moveTo(point.x, point.y - r0);
            Path path3 = this.f181088m;
            Point point2 = this.f181085f;
            path3.lineTo(point2.x - r0, point2.y);
            Path path4 = this.f181088m;
            Point point3 = this.f181085f;
            path4.lineTo(point3.x, point3.y + r0);
            this.f181087i.setPathEffect(new CornerPathEffect(this.G));
        }
        canvas.drawPath(this.f181088m, this.f181087i);
    }

    private void d(Canvas canvas) {
        if (getPaddingRight() == 0) {
            return;
        }
        this.f181088m.reset();
        Path path = this.f181088m;
        RectF rectF = this.C;
        int i3 = this.f181083d;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CCW);
        if (this.F) {
            Path path2 = this.f181088m;
            Point point = this.f181085f;
            path2.moveTo(point.x, point.y - r0);
            Path path3 = this.f181088m;
            Point point2 = this.f181085f;
            path3.lineTo(point2.x + r0, point2.y);
            Path path4 = this.f181088m;
            Point point3 = this.f181085f;
            path4.lineTo(point3.x, point3.y + r0);
            this.f181087i.setPathEffect(new CornerPathEffect(this.G));
        }
        canvas.drawPath(this.f181088m, this.f181087i);
    }

    private void e(Canvas canvas) {
        if (getPaddingTop() == 0) {
            return;
        }
        this.f181088m.reset();
        Path path = this.f181088m;
        RectF rectF = this.C;
        int i3 = this.f181083d;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CCW);
        if (this.F) {
            Path path2 = this.f181088m;
            Point point = this.f181085f;
            path2.moveTo(point.x + r0, point.y);
            Path path3 = this.f181088m;
            Point point2 = this.f181085f;
            path3.lineTo(point2.x, point2.y - r0);
            Path path4 = this.f181088m;
            Point point3 = this.f181085f;
            path4.lineTo(point3.x - r0, point3.y);
            this.f181087i.setPathEffect(new CornerPathEffect(this.G));
        }
        canvas.drawPath(this.f181088m, this.f181087i);
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410078i);
        this.E = obtainStyledAttributes.getColor(jj2.b.f410089j, -1);
        this.D = Color.parseColor("#F5F6FA");
        int color = obtainStyledAttributes.getColor(jj2.b.f410133n, Color.parseColor("#999999"));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410144o, (int) TypedValue.applyDimension(0, 0.0f, getResources().getDisplayMetrics()));
        this.f181083d = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410100k, 0);
        this.G = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410156p, 0);
        this.f181084e = obtainStyledAttributes.getInt(jj2.b.f410111l, 4);
        this.f181086h = obtainStyledAttributes.getDimensionPixelOffset(jj2.b.f410122m, 0);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f181087i = paint;
        paint.setAntiAlias(true);
        this.f181087i.setColor(this.D);
        this.f181087i.setShadowLayer(dimensionPixelSize, 0.0f, 0.0f, color);
        this.f181088m = new Path();
        this.C = new RectF();
        this.f181085f = new Point();
        setWillNotDraw(false);
        setLayerType(1, null);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        int i3 = this.f181084e;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                }
            }
            this.f181085f.x -= this.f181086h;
            return;
        }
        this.f181085f.y -= this.f181086h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        Point point = this.f181085f;
        if (point.x > 0 && point.y > 0) {
            if (this.F) {
                this.f181087i.setColor(this.E);
            } else {
                this.f181087i.setColor(this.D);
            }
        }
        int i3 = this.f181084e;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        b(canvas);
                        return;
                    }
                    return;
                }
                d(canvas);
                return;
            }
            e(canvas);
            return;
        }
        c(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        this.C.left = getPaddingLeft();
        this.C.top = getPaddingTop();
        this.C.right = i3 - getPaddingRight();
        this.C.bottom = i16 - getPaddingBottom();
        int i19 = this.f181084e;
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 != 3) {
                    if (i19 == 4) {
                        Point point = this.f181085f;
                        point.x = i3 / 2;
                        point.y = i16 - getPaddingBottom();
                    }
                } else {
                    this.f181085f.x = i3 - getPaddingRight();
                    this.f181085f.y = i16 / 2;
                }
            } else {
                Point point2 = this.f181085f;
                point2.x = i3 / 2;
                point2.y = getPaddingTop();
            }
        } else {
            this.f181085f.x = getPaddingLeft();
            this.f181085f.y = i16 / 2;
        }
        if (this.f181086h != 0) {
            a();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.F = z16;
            postInvalidate();
        }
    }

    public void setSelectedColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        try {
            this.E = Color.parseColor(str);
        } catch (IllegalArgumentException e16) {
            QLog.d("BubbleLayout", 1, "setSelectedColor error", e16);
        }
    }

    public void setTriangleOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        g();
        this.f181086h = i3;
        a();
        invalidate();
    }

    public void setUnselectedColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        try {
            this.D = Color.parseColor(str);
        } catch (IllegalArgumentException e16) {
            QLog.d("BubbleLayout", 1, "setUnselectedColor error", e16);
        }
    }

    public void setSelectedColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.E = i3;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    public void setUnselectedColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.D = i3;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }
}
