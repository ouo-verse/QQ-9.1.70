package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import com.tencent.mobileqq.activity.aio.doodle.k;
import com.tencent.mobileqq.activity.aio.doodle.m;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o implements k {

    /* renamed from: k, reason: collision with root package name */
    public static final k.a<o> f178572k = new a();

    /* renamed from: a, reason: collision with root package name */
    private Path f178573a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<b> f178574b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f178575c;

    /* renamed from: d, reason: collision with root package name */
    private int f178576d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f178577e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f178578f;

    /* renamed from: g, reason: collision with root package name */
    public int f178579g;

    /* renamed from: h, reason: collision with root package name */
    private List<m.a> f178580h;

    /* renamed from: i, reason: collision with root package name */
    private m.a f178581i;

    /* renamed from: j, reason: collision with root package name */
    private l f178582j;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements k.a<o> {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.k.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public o a(j jVar) {
            return new o(jVar);
        }
    }

    public o(m mVar, int i3, int i16, int i17, int i18, int i19, int i26, float f16) {
        this.f178573a = new Path();
        this.f178574b = new ArrayList<>();
        this.f178575c = new Paint();
        this.f178576d = -1;
        this.f178577e = new Rect();
        this.f178578f = new Rect();
        this.f178579g = -1;
        this.f178580h = new ArrayList();
        this.f178581i = null;
        this.f178582j = null;
        this.f178579g = mVar.f178563d;
        this.f178577e.set(0, 0, i3, i16);
        this.f178580h.addAll(mVar.h());
        HalfAlgorithm halfAlgorithm = new HalfAlgorithm();
        this.f178582j = halfAlgorithm;
        halfAlgorithm.h(i19, i26, f16);
        this.f178582j.l(mVar.h(), this.f178573a, this.f178574b, 1000);
        QLog.d("PathDrawer", 2, "after transPath, segments count:" + this.f178574b.size());
        this.f178582j = null;
        if (mVar.g() > 0) {
            this.f178581i = new m.a(mVar.e());
        }
        o(mVar.d(), mVar.i());
        if (i3 > 0 && i16 > 0) {
            t(0, 0, i17, i18);
        } else {
            this.f178578f.set(this.f178577e);
        }
    }

    private float c() {
        float width = (this.f178578f.width() * 1.0f) / this.f178577e.width();
        float height = (this.f178578f.height() * 1.0f) / this.f178577e.height();
        if (width < height) {
            return width;
        }
        return height;
    }

    private void f(Canvas canvas, m.a aVar) {
        Paint paint;
        if (canvas != null && aVar != null && (paint = this.f178575c) != null) {
            paint.setStrokeWidth(aVar.c() / 2.0f);
            canvas.drawCircle(aVar.d(), aVar.e(), aVar.c() / 4.0f, this.f178575c);
        }
    }

    private void g(Canvas canvas, b bVar) {
        if (canvas != null) {
            this.f178575c.setStrokeWidth(bVar.f());
            canvas.drawPath(bVar.c(), this.f178575c);
        }
    }

    private int j(long j3, boolean z16) {
        int size = this.f178574b.size();
        if (size == 0) {
            return -1;
        }
        int i3 = 0;
        if (size == 1) {
            long e16 = this.f178574b.get(0).e();
            if (z16) {
                if (e16 < j3) {
                    return -1;
                }
                return 0;
            }
            if (e16 <= j3) {
                return -1;
            }
            return 0;
        }
        if (this.f178574b.get(size - 1).e() < j3) {
            return -1;
        }
        while (size > i3) {
            int i16 = (size + i3) / 2;
            long e17 = this.f178574b.get(i16).e();
            if (e17 == j3) {
                if (z16) {
                    return i16 - this.f178574b.get(i16).d();
                }
                int i17 = i16 + 1;
                while (i17 < this.f178574b.size() && e17 >= this.f178574b.get(i17).e()) {
                    i17++;
                }
                if (i17 == this.f178574b.size()) {
                    return -1;
                }
                return i17;
            }
            if (e17 < j3) {
                i3 = i16 + 1;
            } else if (e17 > j3) {
                size = i16 - this.f178574b.get(i16).d();
            }
        }
        return size - this.f178574b.get(size).d();
    }

    private void o(int i3, int i16) {
        this.f178575c.setAntiAlias(true);
        this.f178575c.setStyle(Paint.Style.STROKE);
        this.f178575c.setStrokeJoin(Paint.Join.ROUND);
        this.f178575c.setStrokeCap(Paint.Cap.ROUND);
        this.f178575c.setXfermode(null);
        u(i3);
        v(i16);
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.k
    public void a(j jVar, int i3) {
        jVar.l(1);
        jVar.q(this.f178580h);
        jVar.q(this.f178574b);
        jVar.l(this.f178576d);
        jVar.l(this.f178575c.getColor());
        jVar.p(this.f178577e);
        jVar.p(this.f178578f);
        jVar.o(this.f178581i);
        jVar.l(this.f178579g);
    }

    public void b(float f16, float f17, float f18, long j3) {
        l lVar = this.f178582j;
        if (lVar != null) {
            lVar.b(f16, f17, f18, j3, this.f178573a, this.f178574b);
        }
    }

    public void d() {
        this.f178580h = null;
    }

    public void e(Canvas canvas) {
        if (this.f178574b.size() == 0) {
            m.a aVar = this.f178581i;
            if (aVar != null) {
                f(canvas, aVar);
                return;
            }
            return;
        }
        Iterator<b> it = this.f178574b.iterator();
        while (it.hasNext()) {
            g(canvas, it.next());
        }
    }

    public boolean h(Canvas canvas, int i3, int i16) {
        m.a aVar;
        if (i16 < 0 || i3 > i16) {
            return false;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 == 0 && this.f178574b.size() == 0) {
            m.a aVar2 = this.f178581i;
            if (aVar2 != null) {
                f(canvas, aVar2);
            }
            return true;
        }
        if (this.f178574b.size() == 0) {
            if (i3 == 0 && (aVar = this.f178581i) != null) {
                f(canvas, aVar);
            }
            return false;
        }
        if (i16 > this.f178574b.size()) {
            i16 = this.f178574b.size();
        }
        while (i3 < i16) {
            g(canvas, this.f178574b.get(i3));
            i3++;
        }
        if (i16 >= this.f178574b.size()) {
            return false;
        }
        return true;
    }

    public boolean i(Canvas canvas, long j3, long j16) {
        m.a aVar;
        if (j16 < 0 || j3 > j16) {
            return false;
        }
        if (j3 < 0) {
            j3 = 0;
        }
        if (j16 == 0 && this.f178574b.size() == 0) {
            m.a aVar2 = this.f178581i;
            if (aVar2 != null) {
                f(canvas, aVar2);
            }
            return true;
        }
        if (this.f178574b.size() == 0) {
            if (j3 == 0 && (aVar = this.f178581i) != null) {
                f(canvas, aVar);
            }
            return false;
        }
        if (j16 == 0 && this.f178574b.size() != 0) {
            return true;
        }
        int j17 = j(j3, true);
        int j18 = j(j16, false);
        if (j17 < 0) {
            return true;
        }
        if (j18 < 0) {
            j18 = this.f178574b.size();
        } else if (j18 == j17) {
            if (this.f178574b.size() <= j18) {
                return true;
            }
            g(canvas, this.f178574b.get(j17));
            return false;
        }
        while (j17 < j18) {
            g(canvas, this.f178574b.get(j17));
            j17++;
        }
        if (j18 >= this.f178574b.size()) {
            return false;
        }
        return true;
    }

    public void k(boolean z16) {
        l lVar = this.f178582j;
        if (lVar != null) {
            if (!z16) {
                lVar.e(this.f178573a, this.f178574b);
            } else {
                lVar.j(this.f178574b, 0);
                this.f178582j = null;
            }
        }
    }

    public long l() {
        if (this.f178574b.size() > 0) {
            return this.f178574b.get(r0.size() - 1).e();
        }
        return 0L;
    }

    public int m() {
        if (this.f178574b.size() > 0) {
            return this.f178574b.size();
        }
        if (this.f178581i != null) {
            return 1;
        }
        return 0;
    }

    public int n() {
        return this.f178576d;
    }

    public void p(float f16, float f17, float f18, long j3) {
        this.f178581i = new m.a(f16, f17, f18, j3);
        if (this.f178582j == null) {
            this.f178582j = new HalfAlgorithm();
        }
        this.f178582j.i(f16, f17, f18, 0L, this.f178573a, this.f178574b);
    }

    public boolean q() {
        if ((this.f178574b.size() > 0 && !this.f178573a.isEmpty()) || (this.f178574b.size() == 0 && this.f178581i != null)) {
            return true;
        }
        return false;
    }

    public void r() {
        this.f178575c.reset();
        this.f178573a.reset();
        this.f178574b.clear();
        this.f178581i = null;
        this.f178576d = -1;
    }

    public void s(float f16, boolean z16) {
        m.a aVar;
        if (!this.f178573a.isEmpty()) {
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f16);
            Path path = new Path();
            path.addPath(this.f178573a, matrix);
            this.f178573a = path;
        }
        if (this.f178574b.size() > 0) {
            Iterator<b> it = this.f178574b.iterator();
            while (it.hasNext()) {
                b next = it.next();
                next.h(f16);
                if (z16) {
                    next.m(next.f() * f16);
                }
            }
        }
        if (z16 && (aVar = this.f178581i) != null) {
            aVar.f(f16);
        }
    }

    public void t(int i3, int i16, int i17, int i18) {
        int i19;
        Rect rect;
        float f16;
        int i26 = i17 - i3;
        if (i26 == 0 || (i19 = i18 - i16) == 0 || (rect = this.f178578f) == null) {
            return;
        }
        if (rect.width() == i26 && this.f178578f.height() == i19) {
            QLog.d("PathDrawer", 2, "draw area not change.");
            return;
        }
        if (!this.f178578f.isEmpty() && !this.f178577e.isEmpty() && !this.f178578f.equals(this.f178577e)) {
            f16 = c();
        } else {
            f16 = 1.0f;
        }
        this.f178578f.set(i3, i16, i17, i18);
        QLog.d("PathDrawer", 2, "setArea:" + this.f178578f);
        float c16 = c();
        QLog.d("PathDrawer", 2, "scale:" + c16 + "  Old:" + f16);
        float f17 = c16 / f16;
        double d16 = (double) (f17 - 1.0f);
        if (d16 < 1.0E-6d && d16 > -1.0E-6d) {
            QLog.d("PathDrawer", 2, "scale no change, return:");
        }
        s(f17, true);
    }

    public void u(int i3) {
        v(-1);
        this.f178575c.setColor(i3);
    }

    public void v(int i3) {
        if (i3 > 0) {
            this.f178575c.setShader(null);
            Bitmap b16 = DoodleResHelper.k().b(0, i3);
            if (b16 != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                this.f178575c.setShader(new BitmapShader(b16, tileMode, tileMode));
            }
        } else {
            this.f178575c.setShader(null);
        }
        this.f178576d = i3;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b implements k {

        /* renamed from: f, reason: collision with root package name */
        public static final k.a<b> f178583f = new a();

        /* renamed from: a, reason: collision with root package name */
        private Path f178584a;

        /* renamed from: b, reason: collision with root package name */
        private float f178585b;

        /* renamed from: c, reason: collision with root package name */
        private long f178586c;

        /* renamed from: d, reason: collision with root package name */
        private float f178587d;

        /* renamed from: e, reason: collision with root package name */
        private int f178588e;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements k.a<b> {
            a() {
            }

            @Override // com.tencent.mobileqq.activity.aio.doodle.k.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(j jVar) {
                return new b(jVar);
            }
        }

        public b(Path path) {
            this.f178588e = 0;
            this.f178584a = path;
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.k
        public void a(j jVar, int i3) {
            jVar.l(1);
            jVar.k(this.f178585b);
            jVar.n(this.f178586c);
            jVar.l(this.f178588e);
            jVar.k(this.f178587d);
        }

        public float b() {
            return this.f178587d;
        }

        public Path c() {
            return this.f178584a;
        }

        public int d() {
            return this.f178588e;
        }

        public long e() {
            return this.f178586c;
        }

        public float f() {
            return this.f178585b;
        }

        public void g(b bVar) {
            Path path = this.f178584a;
            if (path != null) {
                path.addPath(bVar.f178584a);
                this.f178587d += bVar.f178587d;
            }
        }

        public void h(float f16) {
            if (this.f178584a == null) {
                return;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f16);
            Path path = new Path();
            path.addPath(this.f178584a, matrix);
            this.f178584a = path;
        }

        public void i(float f16) {
            this.f178587d = f16;
        }

        public void j(Path path) {
            this.f178584a = path;
        }

        public void k(int i3) {
            this.f178588e = i3;
        }

        public void l(long j3) {
            this.f178586c = j3;
        }

        public void m(float f16) {
            this.f178585b = f16;
        }

        public b(j jVar) {
            this.f178588e = 0;
            jVar.d();
            this.f178585b = jVar.c();
            this.f178586c = jVar.f();
            this.f178588e = jVar.d();
            this.f178587d = jVar.c();
        }
    }

    public o(j jVar) {
        Rect rect;
        this.f178573a = new Path();
        this.f178574b = new ArrayList<>();
        this.f178575c = new Paint();
        this.f178576d = -1;
        this.f178577e = new Rect();
        this.f178578f = new Rect();
        this.f178579g = -1;
        this.f178580h = new ArrayList();
        this.f178581i = null;
        this.f178582j = null;
        jVar.d();
        List<m.a> list = this.f178580h;
        if (list != null) {
            jVar.i(list, m.a.f178564e);
        }
        jVar.i(this.f178574b, b.f178583f);
        o(jVar.d(), jVar.d());
        this.f178577e = jVar.h();
        this.f178578f = jVar.h();
        this.f178581i = (m.a) jVar.g(m.a.f178564e);
        this.f178579g = jVar.d();
        HalfAlgorithm halfAlgorithm = new HalfAlgorithm();
        this.f178582j = halfAlgorithm;
        List<m.a> list2 = this.f178580h;
        if (list2 != null) {
            halfAlgorithm.k(list2, this.f178573a, this.f178574b);
            this.f178580h = null;
        } else {
            this.f178573a.reset();
        }
        this.f178582j = null;
        Rect rect2 = this.f178578f;
        if (rect2 != null && (rect = this.f178577e) != null && !rect2.equals(rect)) {
            float c16 = c();
            QLog.d("PathDrawer", 2, "scale:" + c16);
            s(c16, false);
            return;
        }
        QLog.d("PathDrawer", 2, "data area equal draw area, no scale.");
    }
}
