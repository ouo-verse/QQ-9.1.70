package com.tencent.widget.calloutpopupwindow;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.shapes.Shape;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TriangleShape extends Shape {
    static IPatchRedirector $redirector_;
    private int direction;
    Path path;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface Direction {
        public static final int EAST = 35;
        public static final int NONE = 32;
        public static final int NORTH = 33;
        public static final int SOUTH = 34;
        public static final int WEST = 36;
    }

    public TriangleShape(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.path = new Path();
            this.direction = i3;
        }
    }

    private void getEquilateralTriangle(float f16, float f17, int i3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3;
        PointF pointF4;
        if (i3 == 33) {
            pointF = new PointF(0.0f, f17);
            pointF3 = new PointF(f16, f17);
            pointF2 = new PointF(f16 / 2.0f, 0.0f);
        } else {
            if (i3 == 34) {
                pointF = new PointF(0.0f, 0.0f);
                pointF3 = new PointF(f16, 0.0f);
                pointF4 = new PointF(f16 / 2.0f, f17);
            } else if (i3 == 35) {
                pointF = new PointF(0.0f, 0.0f);
                pointF3 = new PointF(0.0f, f17);
                pointF4 = new PointF(f16, f17 / 2.0f);
            } else if (i3 == 36) {
                pointF = new PointF(f16, 0.0f);
                pointF3 = new PointF(0.0f, f17 / 2.0f);
                pointF2 = new PointF(f16, f17);
            } else {
                pointF = null;
                pointF2 = null;
                pointF3 = null;
            }
            pointF2 = pointF4;
        }
        if (pointF != null) {
            this.path.moveTo(pointF.x, pointF.y);
        }
        if (pointF3 != null) {
            this.path.lineTo(pointF3.x, pointF3.y);
        }
        if (pointF2 != null) {
            this.path.lineTo(pointF2.x, pointF2.y);
        }
    }

    @Override // android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas, (Object) paint);
        } else {
            getEquilateralTriangle(getWidth(), getHeight(), this.direction);
            canvas.drawPath(this.path, paint);
        }
    }
}
