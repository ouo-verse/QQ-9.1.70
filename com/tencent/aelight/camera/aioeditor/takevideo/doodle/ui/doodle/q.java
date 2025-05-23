package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeOperator;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q {
    private static final int V = UIUtils.b(BaseApplication.getContext(), 160.5f);
    private static final int W = UIUtils.b(BaseApplication.getContext(), 53.5f);
    private static final int X = UIUtils.b(BaseApplication.getContext(), 15.0f);
    private static final int Y = ViewConfiguration.get(BaseApplication.getContext()).getScaledTouchSlop();
    private static final int Z = ViewConfiguration.getLongPressTimeout();
    private Path D;
    private Path E;
    private b F;
    private e G;
    private h H;
    private c I;
    private g J;
    private f K;
    private i L;
    private int N;
    protected int O;
    protected int P;
    private float Q;
    private d S;
    private long T;

    /* renamed from: a, reason: collision with root package name */
    protected Context f68439a;

    /* renamed from: b, reason: collision with root package name */
    protected ShapeOperator.Shape f68440b;

    /* renamed from: c, reason: collision with root package name */
    private float f68441c;

    /* renamed from: i, reason: collision with root package name */
    private boolean f68447i;

    /* renamed from: j, reason: collision with root package name */
    private float f68448j;

    /* renamed from: k, reason: collision with root package name */
    private float f68449k;

    /* renamed from: l, reason: collision with root package name */
    private float f68450l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f68451m;

    /* renamed from: n, reason: collision with root package name */
    private Bitmap f68452n;

    /* renamed from: s, reason: collision with root package name */
    private Paint f68457s;

    /* renamed from: w, reason: collision with root package name */
    private float f68461w;

    /* renamed from: x, reason: collision with root package name */
    private float f68462x;

    /* renamed from: y, reason: collision with root package name */
    private float f68463y;

    /* renamed from: z, reason: collision with root package name */
    private float f68464z;

    /* renamed from: d, reason: collision with root package name */
    private boolean f68442d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f68443e = false;

    /* renamed from: f, reason: collision with root package name */
    private Boolean f68444f = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f68445g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f68446h = false;

    /* renamed from: o, reason: collision with root package name */
    private Paint f68453o = new Paint();

    /* renamed from: p, reason: collision with root package name */
    private Paint f68454p = new Paint();

    /* renamed from: q, reason: collision with root package name */
    protected TextPaint f68455q = new TextPaint();

    /* renamed from: r, reason: collision with root package name */
    private Paint f68456r = new Paint();

    /* renamed from: t, reason: collision with root package name */
    private float f68458t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    private float f68459u = 0.0f;

    /* renamed from: v, reason: collision with root package name */
    private float f68460v = 1.0f;
    private float A = 0.0f;
    private RectF B = new RectF();
    private RectF C = new RectF();
    private final RectF M = new RectF();
    private Paint R = new Paint();
    private boolean U = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68465a;

        static {
            int[] iArr = new int[ShapeOperator.Shape.values().length];
            f68465a = iArr;
            try {
                iArr[ShapeOperator.Shape.RECT_HOLLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68465a[ShapeOperator.Shape.RECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68465a[ShapeOperator.Shape.OVAL_HOLLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68465a[ShapeOperator.Shape.OVAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68465a[ShapeOperator.Shape.LINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f68465a[ShapeOperator.Shape.ARROW.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends b {
        c() {
            super();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.b
        protected void b(MotionEvent motionEvent, float f16, float f17) {
            q.this.T(f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d {
        void a();

        void b(q qVar);

        void c(q qVar, MotionEvent motionEvent);

        void d(q qVar, RectF rectF);

        void e(q qVar, MotionEvent motionEvent);

        void f(q qVar, MotionEvent motionEvent);

        void g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e extends b {
        e() {
            super();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.b
        protected void a(MotionEvent motionEvent) {
            if (q.this.S != null) {
                q.this.S.f(q.this, motionEvent);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.b
        protected void b(MotionEvent motionEvent, float f16, float f17) {
            q.this.S(f16, f17);
            if (q.this.S != null) {
                q.this.S.c(q.this, motionEvent);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.b
        protected void c(MotionEvent motionEvent) {
            if (q.this.S != null) {
                q.this.S.e(q.this, motionEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f extends b {
        f() {
            super();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.b
        protected void b(MotionEvent motionEvent, float f16, float f17) {
            q.this.a0(f16, f17);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.b
        public boolean d(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                q.this.f68446h = true;
                q.this.Z();
            } else if (action == 1) {
                q.this.f68446h = false;
                q.this.Y();
                q qVar = q.this;
                qVar.f68461w = qVar.B.left;
                q qVar2 = q.this;
                qVar2.f68462x = qVar2.B.top;
                q qVar3 = q.this;
                qVar3.f68463y = qVar3.B.right;
                q qVar4 = q.this;
                qVar4.f68464z = qVar4.B.bottom;
            }
            return super.d(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g extends b {

        /* renamed from: d, reason: collision with root package name */
        private float f68472d;

        /* renamed from: e, reason: collision with root package name */
        private float f68473e;

        /* renamed from: f, reason: collision with root package name */
        private float f68474f;

        g() {
            super();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.b
        public boolean d(MotionEvent motionEvent) {
            float x16 = (motionEvent.getX() - q.this.f68458t) / q.this.f68460v;
            float y16 = (motionEvent.getY() - q.this.f68459u) / q.this.f68460v;
            PointF D = q.this.D();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f68474f = 0.0f;
                return true;
            }
            if (action != 1) {
                if (action == 2) {
                    float f16 = x16 - D.x;
                    float f17 = y16 - D.y;
                    float sqrt = (float) Math.sqrt((f16 * f16) + (f17 * f17));
                    float f18 = this.f68472d;
                    float f19 = this.f68473e;
                    float sqrt2 = (float) Math.sqrt((f18 * f18) + (f19 * f19));
                    if (sqrt != 0.0f) {
                        float asin = (float) ((Math.asin(((this.f68472d * f17) - (this.f68473e * f16)) / (sqrt2 * sqrt)) * 180.0d) / 3.141592653589793d);
                        if (this.f68474f != 0.0f) {
                            q.this.b0(asin);
                        }
                    }
                    this.f68472d = f16;
                    this.f68473e = f17;
                    this.f68474f = sqrt;
                } else if (action != 3) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h extends b {
        h() {
            super();
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.b
        protected void b(MotionEvent motionEvent, float f16, float f17) {
            q.this.U(f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i extends b {

        /* renamed from: d, reason: collision with root package name */
        private Context f68477d;

        /* renamed from: e, reason: collision with root package name */
        private float f68478e;

        /* renamed from: f, reason: collision with root package name */
        private float f68479f;

        i(Context context) {
            super();
            this.f68477d = context;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.b
        public boolean d(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f68478e = motionEvent.getX();
                this.f68479f = motionEvent.getY();
                return true;
            }
            if (action != 1) {
                return false;
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
            boolean z16 = eventTime <= ((long) q.Z);
            float x16 = motionEvent.getX() - this.f68478e;
            float y16 = motionEvent.getY() - this.f68479f;
            boolean z17 = Math.sqrt((double) ((x16 * x16) + (y16 * y16))) <= ((double) q.Y);
            ms.a.a("TipsControl", "handleTouchEvent--UP--elapse=" + eventTime + ", inTapTime=" + z16 + ", inTapDis=" + z17);
            if (z16 && z17) {
                q.this.V();
            }
            return true;
        }
    }

    public q(Context context, ShapeOperator.Shape shape, float f16, int i3) {
        this.f68439a = context;
        this.f68440b = shape;
        this.f68441c = f16;
        this.N = UIUtils.b(context, 5.0f);
        this.O = UIUtils.b(context, 7.0f);
        this.P = UIUtils.b(context, 20.0f);
        this.Q = UIUtils.b(context, 6.0f);
        this.f68448j = UIUtils.b(this.f68439a, 15.0f);
        float b16 = UIUtils.b(this.f68439a, 10.0f);
        this.f68449k = b16;
        this.f68450l = Math.max(b16, X);
        this.f68452n = BitmapFactory.decodeResource(context.getResources(), R.drawable.mjh);
        this.f68451m = BitmapFactory.decodeResource(context.getResources(), R.drawable.mjg);
        x();
        this.f68453o.setStrokeWidth(w(f16));
        this.f68453o.setColor(i3);
        ShapeOperator.Shape shape2 = this.f68440b;
        if (shape2 == ShapeOperator.Shape.OVAL || shape2 == ShapeOperator.Shape.RECT) {
            this.f68453o.setStyle(Paint.Style.FILL);
        }
        ShapeOperator.Shape shape3 = this.f68440b;
        if (shape3 == ShapeOperator.Shape.ARROW || shape3 == ShapeOperator.Shape.LINE) {
            this.f68453o.setStrokeCap(Paint.Cap.ROUND);
            this.f68453o.setStrokeJoin(Paint.Join.ROUND);
            this.f68454p.setColor(-789517);
        }
        this.f68457s = new Paint(this.f68453o);
    }

    private void B() {
        float strokeWidth = this.f68457s.getStrokeWidth() / 2.0f;
        int i3 = a.f68465a[this.f68440b.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            RectF rectF = this.C;
            RectF rectF2 = this.B;
            rectF.left = rectF2.left - strokeWidth;
            rectF.top = rectF2.top - strokeWidth;
            rectF.right = rectF2.right + strokeWidth;
            rectF.bottom = rectF2.bottom + strokeWidth;
        }
    }

    private double C(double d16) {
        double min = Math.min((this.f68453o.getStrokeWidth() * 1.4d) + 8.8d, d16 > ((double) V) ? W : d16 / 3.0d);
        return Math.sqrt(min * min * 2.0d);
    }

    private boolean H(MotionEvent motionEvent) {
        d dVar;
        float x16 = (motionEvent.getX() - this.f68458t) / this.f68460v;
        float y16 = (motionEvent.getY() - this.f68459u) / this.f68460v;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.T = System.currentTimeMillis();
            this.f68461w = x16;
            this.f68462x = y16;
            this.f68463y = x16;
            this.f68464z = y16;
            return true;
        }
        if (action != 1) {
            if (action != 2) {
                return action == 3;
            }
            if (System.currentTimeMillis() - this.T > 150) {
                this.U = false;
            }
            this.f68463y = x16;
            this.f68464z = y16;
            if (!this.U) {
                if (this.f68440b == ShapeOperator.Shape.ARROW) {
                    this.D = r();
                } else {
                    s();
                    B();
                }
            }
            return true;
        }
        this.f68463y = x16;
        this.f68464z = y16;
        float f16 = x16 - this.f68461w;
        float f17 = y16 - this.f68462x;
        long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
        boolean z16 = eventTime <= ((long) Z);
        double d16 = (f16 * f16) + (f17 * f17);
        boolean z17 = Math.sqrt(d16) <= ((double) Y);
        ms.a.a("ShapeEffect", "handleTouchWhenDrawing--UP--elapse=" + eventTime + ", inTapTime=" + z16 + ", inTapDis=" + z17);
        if (z16 && z17 && (dVar = this.S) != null) {
            dVar.g();
        }
        if (!this.U && Math.sqrt(d16) > UIUtils.b(this.f68439a, 10.0f)) {
            if (this.f68440b == ShapeOperator.Shape.ARROW) {
                this.D = r();
                this.E = A();
            } else {
                s();
                B();
            }
            this.f68442d = true;
        }
        return true;
    }

    private boolean I(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    b bVar = this.F;
                    if (bVar != null) {
                        return bVar.d(motionEvent);
                    }
                    return false;
                }
                if (action != 3) {
                    return false;
                }
            }
            this.f68445g = false;
            b bVar2 = this.F;
            if (bVar2 == null) {
                return false;
            }
            boolean d16 = bVar2.d(motionEvent);
            this.F = null;
            return d16;
        }
        this.f68445g = true;
        b d06 = d0((motionEvent.getX() - this.f68458t) / this.f68460v, (motionEvent.getY() - this.f68459u) / this.f68460v);
        this.F = d06;
        if (d06 == null) {
            return false;
        }
        d dVar = this.S;
        if (dVar != null) {
            dVar.b(this);
        }
        return this.F.d(motionEvent);
    }

    private boolean L(float f16, float f17) {
        float f18 = f16 - this.f68463y;
        float f19 = f17 - this.f68464z;
        return Math.sqrt((double) ((f18 * f18) + (f19 * f19))) < ((double) this.f68450l);
    }

    private boolean N(float f16, float f17, float f18) {
        float f19 = this.f68463y - this.f68461w;
        float f26 = this.f68464z - this.f68462x;
        double sqrt = Math.sqrt((f19 * f19) + (f26 * f26));
        double abs = Math.abs((f19 * (f17 - r3)) - (f26 * (f16 - r1))) / sqrt;
        float f27 = this.f68461w;
        float f28 = (f16 - f27) * (f16 - f27);
        float f29 = this.f68462x;
        double sqrt2 = Math.sqrt(f28 + ((f17 - f29) * (f17 - f29)));
        float f36 = this.f68463y;
        float f37 = (f16 - f36) * (f16 - f36);
        float f38 = this.f68464z;
        double sqrt3 = Math.sqrt(f37 + ((f17 - f38) * (f17 - f38)));
        double d16 = f18;
        if (sqrt2 < d16 || sqrt3 < d16) {
            return true;
        }
        return abs < d16 && sqrt2 < sqrt && sqrt3 < sqrt;
    }

    private boolean R(float f16, float f17) {
        float f18 = f16 - this.f68461w;
        float f19 = f17 - this.f68462x;
        return Math.sqrt((double) ((f18 * f18) + (f19 * f19))) < ((double) this.f68450l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(float f16, float f17) {
        this.f68463y += f16;
        this.f68464z += f17;
        if (this.f68440b == ShapeOperator.Shape.ARROW) {
            this.D = r();
            this.E = A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(float f16, float f17) {
        this.f68461w += f16;
        this.f68462x += f17;
        if (this.f68440b == ShapeOperator.Shape.ARROW) {
            this.D = r();
            this.E = A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        d dVar = this.S;
        if (dVar != null) {
            dVar.d(this, new RectF(this.M));
        }
    }

    private b d0(float f16, float f17) {
        if (M(f16, f17)) {
            if (this.L == null) {
                this.L = new i(this.f68439a);
            }
            return this.L;
        }
        ShapeOperator.Shape shape = this.f68440b;
        if (shape != ShapeOperator.Shape.LINE && shape != ShapeOperator.Shape.ARROW) {
            if (P(f16, f17)) {
                if (this.J == null) {
                    this.J = new g();
                }
                return this.J;
            }
            if (O(f16, f17)) {
                if (this.K == null) {
                    this.K = new f();
                }
                return this.K;
            }
        } else {
            if (R(f16, f17)) {
                if (this.H == null) {
                    this.H = new h();
                }
                return this.H;
            }
            if (L(f16, f17)) {
                if (this.I == null) {
                    this.I = new c();
                }
                return this.I;
            }
        }
        if (this.G == null) {
            this.G = new e();
        }
        return this.G;
    }

    private boolean i0() {
        return this.f68447i && !this.f68445g;
    }

    private Path r() {
        float f16 = this.f68461w - this.f68463y;
        float f17 = this.f68462x - this.f68464z;
        double C = C(Math.sqrt((f16 * f16) + (f17 * f17)));
        Path path = new Path();
        path.moveTo(this.f68461w, this.f68462x);
        path.lineTo(this.f68463y, this.f68464z);
        double[] c06 = c0(f16, f17, -0.7853981633974483d, C);
        path.lineTo(this.f68463y + ((float) c06[0]), this.f68464z + ((float) c06[1]));
        path.lineTo(this.f68463y, this.f68464z);
        double[] c07 = c0(f16, f17, 0.7853981633974483d, C);
        path.lineTo(this.f68463y + ((float) c07[0]), this.f68464z + ((float) c07[1]));
        path.lineTo(this.f68463y, this.f68464z);
        path.close();
        return path;
    }

    private void s() {
        float f16 = this.f68461w;
        float f17 = this.f68463y;
        if (f16 < f17) {
            RectF rectF = this.B;
            rectF.left = f16;
            rectF.right = f17;
        } else {
            RectF rectF2 = this.B;
            rectF2.left = f17;
            rectF2.right = f16;
        }
        float f18 = this.f68462x;
        float f19 = this.f68464z;
        if (f18 < f19) {
            RectF rectF3 = this.B;
            rectF3.top = f18;
            rectF3.bottom = f19;
        } else {
            RectF rectF4 = this.B;
            rectF4.top = f19;
            rectF4.bottom = f18;
        }
    }

    private boolean u(int i3, int i16) {
        this.E = A();
        RectF rectF = new RectF();
        this.E.computeBounds(rectF, true);
        Region region = new Region();
        region.setPath(this.E, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        return region.contains(i3, i16);
    }

    private float w(float f16) {
        return DoodleLayout.K(f16);
    }

    private void x() {
        this.f68453o.setShader(null);
        this.f68453o.setStyle(Paint.Style.STROKE);
        this.f68453o.setAntiAlias(true);
        this.f68453o.setDither(true);
        this.f68454p.setColor(-1);
        this.f68454p.setStrokeWidth(UIUtils.b(this.f68439a, 1.0f));
        this.f68454p.setStyle(Paint.Style.STROKE);
        this.f68456r.setColor(-1);
        this.f68456r.setStyle(Paint.Style.FILL);
        this.f68455q.setTypeface(Typeface.DEFAULT);
        this.f68455q.setTextAlign(Paint.Align.CENTER);
        this.f68455q.setAntiAlias(true);
        this.f68455q.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f68455q.setTextSize(UIUtils.b(this.f68439a, 12.0f));
        this.f68455q.setShadowLayer(UIUtils.b(this.f68439a, 2.0f), 0.0f, UIUtils.b(this.f68439a, 1.0f), 687865856);
        this.f68455q.setColor(-1);
        this.R.setStyle(Paint.Style.FILL);
        this.R.setColor(687865856);
        this.R.setAntiAlias(true);
    }

    public PointF D() {
        return new PointF(this.B.centerX(), this.B.centerY());
    }

    public int E() {
        return this.f68453o.getColor();
    }

    public float F() {
        return this.f68441c;
    }

    public ShapeOperator.Shape G() {
        return this.f68440b;
    }

    public void J(boolean z16) {
        this.f68447i = z16;
    }

    public boolean K(float f16, float f17) {
        ShapeOperator.Shape shape = this.f68440b;
        return (shape == ShapeOperator.Shape.LINE || shape == ShapeOperator.Shape.ARROW) ? R(f16, f17) || L(f16, f17) : P(f16, f17) || O(f16, f17);
    }

    public boolean M(float f16, float f17) {
        return this.f68447i && this.M.contains(f16, f17);
    }

    public boolean O(float f16, float f17) {
        Matrix matrix = new Matrix();
        matrix.setRotate(-this.A, this.B.centerX(), this.B.centerY());
        float[] fArr = {f16, f17};
        matrix.mapPoints(fArr);
        float f18 = fArr[0];
        RectF rectF = this.C;
        float f19 = f18 - rectF.right;
        float f26 = fArr[1] - rectF.bottom;
        return Math.sqrt((double) ((f19 * f19) + (f26 * f26))) < ((double) this.f68450l);
    }

    public boolean P(float f16, float f17) {
        Matrix matrix = new Matrix();
        matrix.setRotate(-this.A, this.B.centerX(), this.B.centerY());
        float[] fArr = {f16, f17};
        matrix.mapPoints(fArr);
        float f18 = fArr[0];
        RectF rectF = this.C;
        float f19 = f18 - rectF.left;
        float f26 = fArr[1] - rectF.top;
        return Math.sqrt((double) ((f19 * f19) + (f26 * f26))) < ((double) this.f68448j);
    }

    public boolean Q() {
        float f16 = this.f68463y - this.f68461w;
        float f17 = this.f68464z - this.f68462x;
        return Math.sqrt((double) ((f16 * f16) + (f17 * f17))) > ((double) UIUtils.b(this.f68439a, 10.0f));
    }

    public void S(float f16, float f17) {
        this.f68461w += f16;
        this.f68462x += f17;
        this.f68463y += f16;
        this.f68464z += f17;
        if (this.f68440b == ShapeOperator.Shape.ARROW) {
            this.D = r();
            this.E = A();
        } else {
            s();
            B();
        }
    }

    public boolean W(MotionEvent motionEvent) {
        if (!this.f68442d) {
            return H(motionEvent);
        }
        return I(motionEvent);
    }

    public void X(Canvas canvas) {
        ShapeOperator.Shape shape = this.f68440b;
        if (shape == ShapeOperator.Shape.LINE) {
            canvas.drawLine(this.f68461w, this.f68462x, this.f68463y, this.f68464z, this.f68457s);
            if (this.f68443e) {
                canvas.drawLine(this.f68461w, this.f68462x, this.f68463y, this.f68464z, this.f68454p);
                Bitmap bitmap = this.f68451m;
                float f16 = this.f68461w;
                float f17 = this.f68449k;
                float f18 = this.f68462x;
                canvas.drawBitmap(bitmap, (Rect) null, new RectF(f16 - f17, f18 - f17, f16 + f17, f18 + f17), (Paint) null);
                Bitmap bitmap2 = this.f68451m;
                float f19 = this.f68463y;
                float f26 = this.f68449k;
                float f27 = this.f68464z;
                canvas.drawBitmap(bitmap2, (Rect) null, new RectF(f19 - f26, f27 - f26, f19 + f26, f27 + f26), (Paint) null);
            }
            if (i0()) {
                float f28 = this.f68461w;
                float f29 = this.f68462x;
                y(canvas, f28, f29, f29 >= this.f68464z);
                return;
            }
            return;
        }
        if (shape == ShapeOperator.Shape.ARROW) {
            Path path = this.D;
            if (path != null) {
                canvas.drawPath(path, this.f68453o);
                if (this.f68443e) {
                    canvas.drawLine(this.f68461w, this.f68462x, this.f68463y, this.f68464z, this.f68454p);
                    Bitmap bitmap3 = this.f68451m;
                    float f36 = this.f68461w;
                    float f37 = this.f68449k;
                    float f38 = this.f68462x;
                    canvas.drawBitmap(bitmap3, (Rect) null, new RectF(f36 - f37, f38 - f37, f36 + f37, f38 + f37), (Paint) null);
                    Bitmap bitmap4 = this.f68451m;
                    float f39 = this.f68463y;
                    float f46 = this.f68449k;
                    float f47 = this.f68464z;
                    canvas.drawBitmap(bitmap4, (Rect) null, new RectF(f39 - f46, f47 - f46, f39 + f46, f47 + f46), (Paint) null);
                }
                if (i0()) {
                    float f48 = this.f68461w;
                    float f49 = this.f68462x;
                    y(canvas, f48, f49, f49 >= this.f68464z);
                    return;
                }
                return;
            }
            return;
        }
        canvas.save();
        if (this.f68446h) {
            canvas.rotate(this.A, this.f68461w, this.f68462x);
        } else {
            canvas.rotate(this.A, this.B.centerX(), this.B.centerY());
        }
        int i3 = a.f68465a[this.f68440b.ordinal()];
        if (i3 == 1) {
            canvas.drawRect(this.B, this.f68457s);
            if (this.f68443e) {
                canvas.drawRect(this.C, this.f68454p);
                Bitmap bitmap5 = this.f68451m;
                RectF rectF = this.C;
                float f56 = rectF.right;
                float f57 = this.f68449k;
                float f58 = rectF.bottom;
                canvas.drawBitmap(bitmap5, (Rect) null, new RectF(f56 - f57, f58 - f57, f56 + f57, f58 + f57), (Paint) null);
                Bitmap bitmap6 = this.f68452n;
                RectF rectF2 = this.C;
                float f59 = rectF2.left;
                float f65 = this.f68448j;
                float f66 = rectF2.top;
                canvas.drawBitmap(bitmap6, (Rect) null, new RectF(f59 - f65, f66 - f65, f59 + f65, f66 + f65), (Paint) null);
            }
        } else if (i3 == 2) {
            canvas.drawRect(this.B, this.f68457s);
            if (this.f68443e) {
                canvas.drawRect(this.B, this.f68454p);
                Bitmap bitmap7 = this.f68451m;
                RectF rectF3 = this.B;
                float f67 = rectF3.right;
                float f68 = this.f68449k;
                float f69 = rectF3.bottom;
                canvas.drawBitmap(bitmap7, (Rect) null, new RectF(f67 - f68, f69 - f68, f67 + f68, f69 + f68), (Paint) null);
                Bitmap bitmap8 = this.f68452n;
                RectF rectF4 = this.B;
                float f75 = rectF4.left;
                float f76 = this.f68448j;
                float f77 = rectF4.top;
                canvas.drawBitmap(bitmap8, (Rect) null, new RectF(f75 - f76, f77 - f76, f75 + f76, f77 + f76), (Paint) null);
            }
        } else if (i3 == 3 || i3 == 4) {
            canvas.drawOval(this.B, this.f68457s);
            if (this.f68443e) {
                canvas.drawRect(this.C, this.f68454p);
                Bitmap bitmap9 = this.f68451m;
                RectF rectF5 = this.C;
                float f78 = rectF5.right;
                float f79 = this.f68449k;
                float f85 = rectF5.bottom;
                canvas.drawBitmap(bitmap9, (Rect) null, new RectF(f78 - f79, f85 - f79, f78 + f79, f85 + f79), (Paint) null);
                Bitmap bitmap10 = this.f68452n;
                RectF rectF6 = this.C;
                float f86 = rectF6.left;
                float f87 = this.f68448j;
                float f88 = rectF6.top;
                canvas.drawBitmap(bitmap10, (Rect) null, new RectF(f86 - f87, f88 - f87, f86 + f87, f88 + f87), (Paint) null);
            }
        }
        canvas.restore();
        RectF rectF7 = new RectF();
        if (!this.f68446h) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.A, this.B.centerX(), this.B.centerY());
            matrix.mapRect(rectF7, this.C);
        } else {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(this.A, this.f68461w, this.f68462x);
            matrix2.mapRect(rectF7, this.C);
        }
        if (i0()) {
            z(canvas, rectF7);
        }
    }

    public void a0(float f16, float f17) {
        Matrix matrix = new Matrix();
        matrix.setRotate(-this.A);
        float[] fArr = {f16, f17};
        matrix.mapPoints(fArr);
        this.f68463y += fArr[0];
        this.f68464z += fArr[1];
        s();
        B();
    }

    public void b0(float f16) {
        this.A += f16;
    }

    public void e0(d dVar) {
        this.S = dVar;
    }

    public void f0(int i3) {
        this.f68453o.setColor(i3);
        this.f68457s.setColor(i3);
    }

    public void g0(float f16) {
        this.f68441c = f16;
        float w3 = w(f16);
        this.f68453o.setStrokeWidth(w3);
        this.f68457s.setStrokeWidth(w3);
        if (this.f68440b == ShapeOperator.Shape.ARROW) {
            this.D = r();
            this.E = A();
        } else {
            B();
        }
    }

    public boolean t(int i3, int i16) {
        if (this.f68440b == ShapeOperator.Shape.ARROW) {
            return u(i3, i16);
        }
        float strokeWidth = this.f68457s.getStrokeWidth() / 2.0f;
        int i17 = X;
        if (strokeWidth < i17) {
            strokeWidth = i17;
        }
        if (this.f68440b == ShapeOperator.Shape.LINE) {
            return N(i3, i16, strokeWidth);
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(-this.A, this.B.centerX(), this.B.centerY());
        float[] fArr = {i3, i16};
        matrix.mapPoints(fArr);
        float width = this.B.width() / 2.0f;
        float height = this.B.height() / 2.0f;
        float centerX = fArr[0] - this.B.centerX();
        float centerY = fArr[1] - this.B.centerY();
        int i18 = a.f68465a[this.f68440b.ordinal()];
        if (i18 == 1) {
            float f16 = fArr[0];
            RectF rectF = this.B;
            float f17 = rectF.left;
            if (f16 > f17 - strokeWidth) {
                float f18 = rectF.right;
                if (f16 < f18 + strokeWidth) {
                    float f19 = fArr[1];
                    float f26 = rectF.top;
                    if (f19 > f26 - strokeWidth) {
                        float f27 = rectF.bottom;
                        if (f19 < f27 + strokeWidth && (f16 <= f17 + strokeWidth || f16 >= f18 - strokeWidth || f19 <= f26 + strokeWidth || f19 >= f27 - strokeWidth)) {
                            return true;
                        }
                    }
                }
            }
        } else if (i18 == 2) {
            float f28 = fArr[0];
            RectF rectF2 = this.C;
            if (f28 > rectF2.left - strokeWidth && f28 < rectF2.right + strokeWidth) {
                float f29 = fArr[1];
                if (f29 > rectF2.top - strokeWidth && f29 < rectF2.bottom + strokeWidth) {
                    return true;
                }
            }
        } else if (i18 == 3) {
            float f36 = width - strokeWidth;
            float f37 = height - strokeWidth;
            float f38 = width + strokeWidth;
            float f39 = height + strokeWidth;
            float f46 = centerX * centerX;
            float f47 = centerY * centerY;
            float f48 = f38 * f38;
            if (((f47 * f48) / (f39 * f39)) + f46 < f48) {
                float f49 = f36 * f36;
                if (f46 + ((f47 * f49) / (f37 * f37)) > f49) {
                    return true;
                }
            }
        } else if (i18 == 4) {
            float f56 = width + strokeWidth;
            float f57 = height + strokeWidth;
            float f58 = f56 * f56;
            if ((centerX * centerX) + (((centerY * centerY) * f58) / (f57 * f57)) < f58) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean v(int i3, int i16) {
        switch (a.f68465a[this.f68440b.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                Matrix matrix = new Matrix();
                matrix.setRotate(-this.A, this.B.centerX(), this.B.centerY());
                float[] fArr = {i3, i16};
                matrix.mapPoints(fArr);
                float f16 = fArr[0];
                RectF rectF = this.C;
                if (f16 > rectF.left && f16 < rectF.right) {
                    float f17 = fArr[1];
                    if (f17 > rectF.top && f17 < rectF.bottom) {
                        return true;
                    }
                }
                return false;
            case 5:
            case 6:
                return t(i3, i16);
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(Canvas canvas, float f16, float f17, boolean z16) {
        float f18;
        int measureText = (int) this.f68455q.measureText("\u70b9\u51fb\u8f93\u5165\u6587\u5b57");
        int ceil = (int) Math.ceil(this.f68455q.descent() - this.f68455q.ascent());
        if (z16) {
            f18 = f17 + (ceil / 2.0f) + this.P;
        } else {
            f18 = (f17 - (ceil / 2.0f)) - this.P;
        }
        RectF rectF = this.M;
        int i3 = this.O;
        rectF.left = f16 - (((i3 * 2) + measureText) / 2.0f);
        rectF.right = ((measureText + (i3 * 2)) / 2.0f) + f16;
        int i16 = this.N;
        rectF.top = f18 - (((i16 * 2) + ceil) / 2.0f);
        rectF.bottom = ((ceil + (i16 * 2)) / 2.0f) + f18;
        float f19 = this.Q;
        canvas.drawRoundRect(rectF, f19, f19, this.R);
        canvas.drawText("\u70b9\u51fb\u8f93\u5165\u6587\u5b57", f16, f18 - ((this.f68455q.descent() + this.f68455q.ascent()) / 2.0f), this.f68455q);
    }

    protected void z(Canvas canvas, RectF rectF) {
        y(canvas, rectF.centerX(), rectF.bottom, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        float[] fArr = {this.B.centerX(), this.B.centerY()};
        float[] fArr2 = new float[2];
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, 1.0f);
        matrix.postRotate(this.A, this.f68461w, this.f68462x);
        matrix.mapPoints(fArr2, fArr);
        S(fArr2[0] - fArr[0], fArr2[1] - fArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        float[] fArr = {this.B.centerX(), this.B.centerY()};
        float[] fArr2 = new float[2];
        Matrix matrix = new Matrix();
        matrix.setRotate(-this.A, this.f68461w, this.f68462x);
        matrix.mapPoints(fArr2, fArr);
        float[] fArr3 = {fArr2[0] - fArr[0], fArr2[1] - fArr[1]};
        matrix.setRotate(this.A);
        matrix.mapPoints(fArr3);
        S(fArr3[0], fArr3[1]);
    }

    private double[] c0(float f16, float f17, double d16, double d17) {
        double d18 = f16;
        double d19 = f17;
        double cos = (Math.cos(d16) * d18) - (Math.sin(d16) * d19);
        double sin = (d18 * Math.sin(d16)) + (d19 * Math.cos(d16));
        double sqrt = Math.sqrt((cos * cos) + (sin * sin));
        return new double[]{(cos / sqrt) * d17, (sin / sqrt) * d17};
    }

    private Path A() {
        float strokeWidth = this.f68453o.getStrokeWidth() / 2.0f;
        int i3 = X;
        if (strokeWidth < i3) {
            strokeWidth = i3;
        }
        Path path = new Path();
        float f16 = this.f68463y - this.f68461w;
        float f17 = this.f68464z - this.f68462x;
        double C = C(Math.sqrt((f16 * f16) + (f17 * f17)));
        double d16 = strokeWidth;
        double[] c06 = c0(f16, f17, 0.0d, d16);
        float f18 = this.f68461w;
        double d17 = c06[0];
        float f19 = f18 - ((float) d17);
        float f26 = this.f68462x;
        double d18 = c06[1];
        float f27 = f26 - ((float) d18);
        float f28 = this.f68463y + ((float) d17);
        float f29 = this.f68464z + ((float) d18);
        double[] c07 = c0(f16, f17, 1.5707963267948966d, d16);
        path.moveTo(f19 + ((float) c07[0]), f27 + ((float) c07[1]));
        path.lineTo(f19 - ((float) c07[0]), f27 - ((float) c07[1]));
        float f36 = -f16;
        float f37 = -f17;
        double d19 = C + d16;
        double[] c08 = c0(f36, f37, 0.7853981633974483d, d19);
        path.lineTo(f28 + ((float) c08[0]), f29 + ((float) c08[1]));
        path.lineTo(f28, f29);
        double[] c09 = c0(f36, f37, -0.7853981633974483d, d19);
        path.lineTo(f28 + ((float) c09[0]), f29 + ((float) c09[1]));
        path.close();
        return path;
    }

    public void h0(boolean z16) {
        if (z16) {
            if (this.f68444f == null) {
                this.f68444f = Boolean.TRUE;
            }
        } else if (Boolean.TRUE.equals(this.f68444f)) {
            this.f68444f = Boolean.FALSE;
        }
        this.f68443e = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private float f68466a;

        /* renamed from: b, reason: collision with root package name */
        private float f68467b;

        protected b() {
        }

        public boolean d(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f68466a = motionEvent.getX();
                this.f68467b = motionEvent.getY();
                a(motionEvent);
                return true;
            }
            if (action == 1) {
                c(motionEvent);
                return true;
            }
            if (action != 2) {
                return action == 3;
            }
            float x16 = (motionEvent.getX() - this.f68466a) / q.this.f68460v;
            float y16 = (motionEvent.getY() - this.f68467b) / q.this.f68460v;
            this.f68466a = motionEvent.getX();
            this.f68467b = motionEvent.getY();
            b(motionEvent, x16, y16);
            return true;
        }

        protected void a(MotionEvent motionEvent) {
        }

        protected void c(MotionEvent motionEvent) {
        }

        protected void b(MotionEvent motionEvent, float f16, float f17) {
        }
    }
}
