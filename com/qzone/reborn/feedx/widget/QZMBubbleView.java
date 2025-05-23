package com.qzone.reborn.feedx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMBubbleView extends ViewGroup {
    private int C;
    private int D;
    private boolean E;
    private a F;
    private Rect G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private float M;
    private float N;
    private int P;
    private Path Q;
    private Path R;
    private Paint S;
    private int T;
    private int U;

    /* renamed from: d, reason: collision with root package name */
    private int f55924d;

    /* renamed from: e, reason: collision with root package name */
    private int f55925e;

    /* renamed from: f, reason: collision with root package name */
    private int f55926f;

    /* renamed from: h, reason: collision with root package name */
    private int f55927h;

    /* renamed from: i, reason: collision with root package name */
    private int f55928i;

    /* renamed from: m, reason: collision with root package name */
    private int f55929m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void a(Path path, int i3, int i16, int i17, int i18);

        void b(Path path, int i3, int i16, int i17, int i18);

        void c(Path path, int i3, int i16, int i17, int i18);

        void d(Path path, int i3, int i16, int i17, int i18);
    }

    public QZMBubbleView(Context context) {
        this(context, null);
    }

    private void a() {
        Path path = this.Q;
        int i3 = this.f55925e;
        float f16 = i3 / 2;
        float f17 = (int) ((i3 * 0.2f) + 0.5f);
        float f18 = this.T - (i3 / 2);
        float f19 = (this.U - ((int) ((i3 * 0.8f) + 0.5f))) - this.f55927h;
        int i16 = this.f55929m;
        path.addRoundRect(f16, f17, f18, f19, i16, i16, Path.Direction.CW);
        int i17 = this.T;
        float e16 = e(i17 - r1, this.f55925e / 2);
        Rect rect = this.G;
        int i18 = this.f55928i;
        int i19 = this.U;
        int i26 = this.f55925e;
        rect.set((int) (e16 - (i18 / 2)), (i19 - ((int) ((i26 * 0.8f) + 0.5f))) - this.f55927h, (int) (e16 + (i18 / 2)), i19 - ((int) ((i26 * 0.8f) + 0.5f)));
        a aVar = this.F;
        Path path2 = this.R;
        Rect rect2 = this.G;
        aVar.a(path2, rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void b() {
        Path path = this.Q;
        int i3 = this.f55927h;
        int i16 = this.f55925e;
        float f16 = i3 + (i16 / 2);
        float f17 = (int) ((i16 * 0.2f) + 0.5f);
        float f18 = this.T - (i16 / 2);
        float f19 = this.U - ((int) ((i16 * 0.8f) + 0.5f));
        int i17 = this.f55929m;
        path.addRoundRect(f16, f17, f18, f19, i17, i17, Path.Direction.CW);
        int i18 = this.U;
        float e16 = e(i18 - r1, this.f55925e / 2);
        Rect rect = this.G;
        int i19 = this.f55925e;
        int i26 = this.f55928i;
        rect.set(i19 / 2, (int) (e16 - (i26 / 2)), this.f55927h + (i19 / 2), (int) (e16 + (i26 / 2)));
        a aVar = this.F;
        Path path2 = this.R;
        Rect rect2 = this.G;
        aVar.d(path2, rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void c() {
        Path path = this.Q;
        int i3 = this.f55925e;
        float f16 = i3 / 2;
        float f17 = (int) ((i3 * 0.2f) + 0.5f);
        float f18 = (this.T - (i3 / 2)) - this.f55927h;
        float f19 = this.U - ((int) ((i3 * 0.8f) + 0.5f));
        int i16 = this.f55929m;
        path.addRoundRect(f16, f17, f18, f19, i16, i16, Path.Direction.CW);
        int i17 = this.U;
        float e16 = e(i17 - r1, this.f55925e / 2);
        Rect rect = this.G;
        int i18 = this.T;
        int i19 = this.f55925e;
        int i26 = (i18 - (i19 / 2)) - this.f55927h;
        int i27 = this.f55928i;
        rect.set(i26, (int) (e16 - (i27 / 2)), i18 - (i19 / 2), (int) (e16 + (i27 / 2)));
        a aVar = this.F;
        Path path2 = this.R;
        Rect rect2 = this.G;
        aVar.c(path2, rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void d() {
        Path path = this.Q;
        int i3 = this.f55925e;
        float f16 = i3 / 2;
        float f17 = this.f55927h + ((int) ((i3 * 0.2f) + 0.5f));
        float f18 = this.T - (i3 / 2);
        float f19 = this.U - ((int) ((i3 * 0.8f) + 0.5f));
        int i16 = this.f55929m;
        path.addRoundRect(f16, f17, f18, f19, i16, i16, Path.Direction.CW);
        int i17 = this.T;
        float e16 = e(i17 - r1, this.f55925e / 2);
        Rect rect = this.G;
        int i18 = this.f55928i;
        int i19 = this.f55925e;
        rect.set((int) (e16 - (i18 / 2)), (int) ((i19 * 0.2f) + 0.5f), (int) (e16 + (i18 / 2)), this.f55927h + ((int) ((i19 * 0.2f) + 0.5f)));
        a aVar = this.F;
        Path path2 = this.R;
        Rect rect2 = this.G;
        aVar.b(path2, rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private float e(double d16, int i3) {
        int i16 = this.L;
        if (i16 == 4) {
            return g(d16, this.M, i3);
        }
        if (i16 == 5) {
            float f16 = this.N;
            if (f16 == 0.0f) {
                return g(d16, 0.5f, i3);
            }
            if (f16 > 0.0f) {
                return g(d16, 0.0f, i3) + this.N;
            }
            return g(d16, 1.0f, i3) + this.N;
        }
        if (i16 != 16) {
            return g(d16, 0.5f, i3);
        }
        int i17 = this.P;
        if (i17 == 0) {
            return g(d16, 0.0f, i3);
        }
        if (i17 == 2) {
            return g(d16, 1.0f, i3);
        }
        return g(d16, 0.5f, i3);
    }

    private int f(float f16) {
        return (int) ((f16 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private float g(double d16, float f16, int i3) {
        return (float) ((((d16 - (r0 * 2)) - this.f55928i) * f16) + this.f55929m + i3 + (r1 / 2));
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BubbleView);
        this.f55926f = obtainStyledAttributes.getColor(0, -1);
        int integer = obtainStyledAttributes.getInteger(3, 0);
        if (integer == 1) {
            this.D = 1;
        } else if (integer == 2) {
            this.D = 2;
        } else if (integer != 3) {
            this.D = 0;
        } else {
            this.D = 3;
        }
        this.E = obtainStyledAttributes.getBoolean(2, false);
        this.f55929m = (int) obtainStyledAttributes.getDimension(11, f(8.0f));
        this.f55927h = (int) obtainStyledAttributes.getDimension(4, f(8.0f));
        this.f55928i = (int) obtainStyledAttributes.getDimension(6, f(8.0f));
        this.f55925e = (int) obtainStyledAttributes.getDimension(1, 0.0f);
        this.f55924d = obtainStyledAttributes.getColor(12, 436207616);
        int type = obtainStyledAttributes.getType(5);
        this.L = type;
        if (type == 4) {
            float f16 = obtainStyledAttributes.getFloat(5, 0.5f);
            this.M = f16;
            if (f16 < 0.0f) {
                this.M = 0.0f;
            } else if (f16 > 1.0f) {
                this.M = 1.0f;
            }
        } else if (type == 5) {
            this.N = obtainStyledAttributes.getDimension(5, -1.0f);
        } else if (type == 16) {
            this.P = obtainStyledAttributes.getInt(5, -1);
        }
        this.H = (int) obtainStyledAttributes.getDimension(8, -1.0f);
        this.I = (int) obtainStyledAttributes.getDimension(7, -1.0f);
        this.J = (int) obtainStyledAttributes.getDimension(10, -1.0f);
        this.K = (int) obtainStyledAttributes.getDimension(9, -1.0f);
        this.C = (int) obtainStyledAttributes.getDimension(13, -1.0f);
    }

    private void j() {
        this.Q.reset();
        this.R.reset();
        int i3 = this.D;
        if (i3 == 0) {
            b();
        } else if (i3 == 1) {
            d();
        } else if (i3 != 2) {
            a();
        } else {
            c();
        }
        this.Q.close();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint = this.S;
        int i3 = this.f55925e;
        paint.setShadowLayer(i3 / 2, 0.0f, i3 / 4, this.f55924d);
        this.Q.addPath(this.R);
        if (this.C > 0) {
            this.Q.op(this.R, Path.Op.UNION);
        }
        canvas.drawPath(this.Q, this.S);
        canvas.clipPath(this.Q);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (!this.E) {
            int i19 = this.D;
            if (i19 == 0) {
                int i26 = this.f55927h;
                int i27 = this.f55925e;
                i(i26 + (i27 / 2), (int) ((i27 * 0.2f) + 0.5f), i17 - (i27 / 2), i18 - ((int) ((i27 * 0.8f) + 0.5f)));
                return;
            } else if (i19 == 1) {
                int i28 = this.f55925e;
                i(i28 / 2, this.f55927h + ((int) ((i28 * 0.2f) + 0.5f)), i17 - (i28 / 2), i18 - ((int) ((i28 * 0.8f) + 0.5f)));
                return;
            } else if (i19 == 2) {
                int i29 = this.f55925e;
                i(i29 / 2, (int) ((i29 * 0.2f) + 0.5f), (i17 - (i29 / 2)) - this.f55927h, i18 - ((int) ((i29 * 0.8f) + 0.5f)));
                return;
            } else {
                if (i19 != 3) {
                    return;
                }
                int i36 = this.f55925e;
                i(i36 / 2, (int) ((i36 * 0.2f) + 0.5f), i17 - (i36 / 2), (i18 - ((int) ((i36 * 0.8f) + 0.5f))) - this.f55927h);
                return;
            }
        }
        int i37 = this.f55925e;
        i(i37 / 2, (int) ((i37 * 0.2f) + 0.5f), i17 - (i37 / 2), i18 - ((int) ((i37 * 0.8f) + 0.5f)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        if (r7 != 3) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0104, code lost:
    
        if (r1 == 0) goto L66;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int paddingTop;
        int i17;
        int paddingLeft;
        int i18;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int i19 = this.H;
        int i26 = Integer.MIN_VALUE;
        if (i19 > 0) {
            if (i19 < this.J) {
                QLog.e("BubbleView", 1, "\u6700\u5927\u5bbd\u5ea6\u4e0d\u80fd\u6bd4\u6700\u5c0f\u5bbd\u5ea6\u5c0f");
                return;
            }
            if (mode == 0) {
                size = i19;
            } else if (mode == Integer.MIN_VALUE) {
                size = Math.min(size, i19);
            }
            mode = 1073741824;
        }
        int i27 = this.I;
        if (i27 > 0) {
            if (i27 < this.K) {
                QLog.e("BubbleView", 1, "\u6700\u5927\u9ad8\u5ea6\u4e0d\u80fd\u6bd4\u6700\u5c0f\u9ad8\u5ea6\u5c0f");
                return;
            }
            if (mode2 == 0) {
                size2 = i27;
            } else if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(size2, i27);
            }
            mode2 = 1073741824;
        }
        int i28 = this.f55925e;
        int i29 = size - i28;
        int i36 = size2 - i28;
        if (!this.E) {
            int i37 = this.D;
            if (i37 != 0) {
                if (i37 != 1) {
                    if (i37 != 2) {
                    }
                }
                i36 -= this.f55927h;
            }
            i29 -= this.f55927h;
        }
        measureChildren(View.MeasureSpec.makeMeasureSpec(i29, mode), View.MeasureSpec.makeMeasureSpec(i36, mode2));
        if (mode != 1073741824) {
            int i38 = 0;
            for (int i39 = 0; i39 < getChildCount(); i39++) {
                i38 = Math.max(getChildAt(i39).getMeasuredWidth(), i38);
            }
            int i46 = this.D;
            if ((i46 == 0 || i46 == 2) && !this.E) {
                paddingLeft = i38 + getPaddingLeft() + getPaddingRight() + this.f55927h;
                i18 = this.f55925e;
            } else {
                paddingLeft = i38 + getPaddingLeft() + getPaddingRight();
                i18 = this.f55925e;
            }
            size = Math.max(paddingLeft + i18, this.J);
            if (mode == 0) {
                mode = Integer.MIN_VALUE;
            }
        }
        if (mode2 != 1073741824) {
            int i47 = 0;
            for (int i48 = 0; i48 < getChildCount(); i48++) {
                i47 = Math.max(getChildAt(i48).getMeasuredHeight(), i47);
            }
            int i49 = this.D;
            if ((i49 == 1 || i49 == 3) && !this.E) {
                paddingTop = i47 + getPaddingTop() + getPaddingBottom() + this.f55927h;
                i17 = this.f55925e;
            } else {
                paddingTop = i47 + getPaddingTop() + getPaddingBottom();
                i17 = this.f55925e;
            }
            size2 = Math.max(paddingTop + i17, this.K);
        }
        i26 = mode2;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, i26));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.T = i3;
        this.U = i16;
        j();
        super.onSizeChanged(i3, i16, i17, i18);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private class b implements a {
        b() {
        }

        @Override // com.qzone.reborn.feedx.widget.QZMBubbleView.a
        public void a(Path path, int i3, int i16, int i17, int i18) {
            float f16 = i16;
            path.moveTo(i3, f16);
            path.lineTo(i3 + ((i17 - i3) / 2), i18);
            path.lineTo(i17, f16);
        }

        @Override // com.qzone.reborn.feedx.widget.QZMBubbleView.a
        public void b(Path path, int i3, int i16, int i17, int i18) {
            float f16 = i18;
            path.moveTo(i3, f16);
            path.lineTo(i3 + ((i17 - i3) / 2), i16);
            path.lineTo(i17, f16);
        }

        @Override // com.qzone.reborn.feedx.widget.QZMBubbleView.a
        public void c(Path path, int i3, int i16, int i17, int i18) {
            float f16 = i3;
            path.moveTo(f16, i16);
            path.lineTo(i17, i16 + ((i18 - i16) / 2));
            path.lineTo(f16, i18);
        }

        @Override // com.qzone.reborn.feedx.widget.QZMBubbleView.a
        public void d(Path path, int i3, int i16, int i17, int i18) {
            float f16 = i17;
            path.moveTo(f16, i16);
            path.lineTo(i3, i16 + ((i18 - i16) / 2));
            path.lineTo(f16, i18);
        }
    }

    public QZMBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void i(int i3, int i16, int i17, int i18) {
        for (int i19 = 0; i19 < getChildCount(); i19++) {
            View childAt = getChildAt(i19);
            childAt.layout(getPaddingLeft() + i3, getPaddingTop() + i16, childAt.getMeasuredWidth() + i3 + getPaddingLeft(), childAt.getMeasuredHeight() + i16 + getPaddingTop());
        }
    }

    public QZMBubbleView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public QZMBubbleView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f55925e = 0;
        this.f55926f = -1;
        this.f55927h = f(8.0f);
        this.f55928i = f(8.0f);
        this.f55929m = f(8.0f);
        this.C = 0;
        this.D = 3;
        this.E = false;
        this.F = new b();
        this.G = new Rect();
        setBackgroundColor(0);
        h(context, attributeSet);
        this.Q = new Path();
        this.R = new Path();
        Paint paint = new Paint(1);
        this.S = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        if (this.C > 0) {
            this.S.setStyle(Paint.Style.STROKE);
            this.S.setStrokeWidth(this.C);
        } else {
            this.S.setStyle(Paint.Style.FILL);
        }
        this.S.setColor(this.f55926f);
        if (this.f55925e > 0) {
            setLayerType(1, null);
        }
    }
}
