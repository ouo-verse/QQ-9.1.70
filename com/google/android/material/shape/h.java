package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final i[] f34077a = new i[4];

    /* renamed from: b, reason: collision with root package name */
    private final Matrix[] f34078b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix[] f34079c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    private final PointF f34080d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    private final Path f34081e = new Path();

    /* renamed from: f, reason: collision with root package name */
    private final Path f34082f = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final i f34083g = new i();

    /* renamed from: h, reason: collision with root package name */
    private final float[] f34084h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    private final float[] f34085i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    private final Path f34086j = new Path();

    /* renamed from: k, reason: collision with root package name */
    private final Path f34087k = new Path();

    /* renamed from: l, reason: collision with root package name */
    private boolean f34088l = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final h f34089a = new h();
    }

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface b {
        void a(i iVar, Matrix matrix, int i3);

        void b(i iVar, Matrix matrix, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public final g f34090a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        public final Path f34091b;

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        public final RectF f34092c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final b f34093d;

        /* renamed from: e, reason: collision with root package name */
        public final float f34094e;

        c(@NonNull g gVar, float f16, RectF rectF, @Nullable b bVar, Path path) {
            this.f34093d = bVar;
            this.f34090a = gVar;
            this.f34094e = f16;
            this.f34092c = rectF;
            this.f34091b = path;
        }
    }

    public h() {
        for (int i3 = 0; i3 < 4; i3++) {
            this.f34077a[i3] = new i();
            this.f34078b[i3] = new Matrix();
            this.f34079c[i3] = new Matrix();
        }
    }

    private float a(int i3) {
        return (i3 + 1) * 90;
    }

    private void b(@NonNull c cVar, int i3) {
        this.f34084h[0] = this.f34077a[i3].k();
        this.f34084h[1] = this.f34077a[i3].l();
        this.f34078b[i3].mapPoints(this.f34084h);
        if (i3 == 0) {
            Path path = cVar.f34091b;
            float[] fArr = this.f34084h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f34091b;
            float[] fArr2 = this.f34084h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f34077a[i3].d(this.f34078b[i3], cVar.f34091b);
        b bVar = cVar.f34093d;
        if (bVar != null) {
            bVar.a(this.f34077a[i3], this.f34078b[i3], i3);
        }
    }

    private void c(@NonNull c cVar, int i3) {
        int i16 = (i3 + 1) % 4;
        this.f34084h[0] = this.f34077a[i3].i();
        this.f34084h[1] = this.f34077a[i3].j();
        this.f34078b[i3].mapPoints(this.f34084h);
        this.f34085i[0] = this.f34077a[i16].k();
        this.f34085i[1] = this.f34077a[i16].l();
        this.f34078b[i16].mapPoints(this.f34085i);
        float f16 = this.f34084h[0];
        float[] fArr = this.f34085i;
        float max = Math.max(((float) Math.hypot(f16 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float i17 = i(cVar.f34092c, i3);
        this.f34083g.n(0.0f, 0.0f);
        com.google.android.material.shape.b j3 = j(i3, cVar.f34090a);
        j3.b(max, i17, cVar.f34094e, this.f34083g);
        this.f34086j.reset();
        this.f34083g.d(this.f34079c[i3], this.f34086j);
        if (this.f34088l && (j3.a() || l(this.f34086j, i3) || l(this.f34086j, i16))) {
            Path path = this.f34086j;
            path.op(path, this.f34082f, Path.Op.DIFFERENCE);
            this.f34084h[0] = this.f34083g.k();
            this.f34084h[1] = this.f34083g.l();
            this.f34079c[i3].mapPoints(this.f34084h);
            Path path2 = this.f34081e;
            float[] fArr2 = this.f34084h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f34083g.d(this.f34079c[i3], this.f34081e);
        } else {
            this.f34083g.d(this.f34079c[i3], cVar.f34091b);
        }
        b bVar = cVar.f34093d;
        if (bVar != null) {
            bVar.b(this.f34083g, this.f34079c[i3], i3);
        }
    }

    private void f(int i3, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    pointF.set(rectF.right, rectF.top);
                    return;
                } else {
                    pointF.set(rectF.left, rectF.top);
                    return;
                }
            }
            pointF.set(rectF.left, rectF.bottom);
            return;
        }
        pointF.set(rectF.right, rectF.bottom);
    }

    private j1.c g(int i3, @NonNull g gVar) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return gVar.t();
                }
                return gVar.r();
            }
            return gVar.j();
        }
        return gVar.l();
    }

    private j1.d h(int i3, @NonNull g gVar) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return gVar.s();
                }
                return gVar.q();
            }
            return gVar.i();
        }
        return gVar.k();
    }

    private float i(@NonNull RectF rectF, int i3) {
        float[] fArr = this.f34084h;
        i iVar = this.f34077a[i3];
        fArr[0] = iVar.f34097c;
        fArr[1] = iVar.f34098d;
        this.f34078b[i3].mapPoints(fArr);
        if (i3 != 1 && i3 != 3) {
            return Math.abs(rectF.centerY() - this.f34084h[1]);
        }
        return Math.abs(rectF.centerX() - this.f34084h[0]);
    }

    private com.google.android.material.shape.b j(int i3, @NonNull g gVar) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return gVar.o();
                }
                return gVar.p();
            }
            return gVar.n();
        }
        return gVar.h();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static h k() {
        return a.f34089a;
    }

    @RequiresApi(19)
    private boolean l(Path path, int i3) {
        this.f34087k.reset();
        this.f34077a[i3].d(this.f34078b[i3], this.f34087k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f34087k.computeBounds(rectF, true);
        path.op(this.f34087k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
            return true;
        }
        return false;
    }

    private void m(@NonNull c cVar, int i3) {
        h(i3, cVar.f34090a).b(this.f34077a[i3], 90.0f, cVar.f34094e, cVar.f34092c, g(i3, cVar.f34090a));
        float a16 = a(i3);
        this.f34078b[i3].reset();
        f(i3, cVar.f34092c, this.f34080d);
        Matrix matrix = this.f34078b[i3];
        PointF pointF = this.f34080d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f34078b[i3].preRotate(a16);
    }

    private void n(int i3) {
        this.f34084h[0] = this.f34077a[i3].i();
        this.f34084h[1] = this.f34077a[i3].j();
        this.f34078b[i3].mapPoints(this.f34084h);
        float a16 = a(i3);
        this.f34079c[i3].reset();
        Matrix matrix = this.f34079c[i3];
        float[] fArr = this.f34084h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f34079c[i3].preRotate(a16);
    }

    public void d(g gVar, float f16, RectF rectF, @NonNull Path path) {
        e(gVar, f16, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void e(g gVar, float f16, RectF rectF, b bVar, @NonNull Path path) {
        path.rewind();
        this.f34081e.rewind();
        this.f34082f.rewind();
        this.f34082f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(gVar, f16, rectF, bVar, path);
        for (int i3 = 0; i3 < 4; i3++) {
            m(cVar, i3);
            n(i3);
        }
        for (int i16 = 0; i16 < 4; i16++) {
            b(cVar, i16);
            c(cVar, i16);
        }
        path.close();
        this.f34081e.close();
        if (!this.f34081e.isEmpty()) {
            path.op(this.f34081e, Path.Op.UNION);
        }
    }
}
