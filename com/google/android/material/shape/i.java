package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f34095a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f34096b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f34097c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f34098d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f34099e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f34100f;

    /* renamed from: g, reason: collision with root package name */
    private final List<f> f34101g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<g> f34102h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private boolean f34103i;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f34104b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Matrix f34105c;

        a(List list, Matrix matrix) {
            this.f34104b = list;
            this.f34105c = matrix;
        }

        @Override // com.google.android.material.shape.i.g
        public void a(Matrix matrix, i1.a aVar, int i3, Canvas canvas) {
            Iterator it = this.f34104b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f34105c, aVar, i3, canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b extends g {

        /* renamed from: b, reason: collision with root package name */
        private final d f34107b;

        public b(d dVar) {
            this.f34107b = dVar;
        }

        @Override // com.google.android.material.shape.i.g
        public void a(Matrix matrix, @NonNull i1.a aVar, int i3, @NonNull Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f34107b.k(), this.f34107b.o(), this.f34107b.l(), this.f34107b.j()), i3, this.f34107b.m(), this.f34107b.n());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class c extends g {

        /* renamed from: b, reason: collision with root package name */
        private final e f34108b;

        /* renamed from: c, reason: collision with root package name */
        private final float f34109c;

        /* renamed from: d, reason: collision with root package name */
        private final float f34110d;

        public c(e eVar, float f16, float f17) {
            this.f34108b = eVar;
            this.f34109c = f16;
            this.f34110d = f17;
        }

        @Override // com.google.android.material.shape.i.g
        public void a(Matrix matrix, @NonNull i1.a aVar, int i3, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f34108b.f34119c - this.f34110d, this.f34108b.f34118b - this.f34109c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f34109c, this.f34110d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i3);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f34108b.f34119c - this.f34110d) / (this.f34108b.f34118b - this.f34109c)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        private static final RectF f34111h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f34112b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f34113c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f34114d;

        /* renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f34115e;

        /* renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f34116f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f34117g;

        public d(float f16, float f17, float f18, float f19) {
            q(f16);
            u(f17);
            r(f18);
            p(f19);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f34115e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f34112b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f34114d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f34116f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f34117g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f34113c;
        }

        private void p(float f16) {
            this.f34115e = f16;
        }

        private void q(float f16) {
            this.f34112b = f16;
        }

        private void r(float f16) {
            this.f34114d = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f16) {
            this.f34116f = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f16) {
            this.f34117g = f16;
        }

        private void u(float f16) {
            this.f34113c = f16;
        }

        @Override // com.google.android.material.shape.i.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f34120a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f34111h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        private float f34118b;

        /* renamed from: c, reason: collision with root package name */
        private float f34119c;

        @Override // com.google.android.material.shape.i.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f34120a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f34118b, this.f34119c);
            path.transform(matrix);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected final Matrix f34120a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        static final Matrix f34121a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, i1.a aVar, int i3, Canvas canvas);

        public final void b(i1.a aVar, int i3, Canvas canvas) {
            a(f34121a, aVar, i3, canvas);
        }
    }

    public i() {
        n(0.0f, 0.0f);
    }

    private void b(float f16) {
        if (g() == f16) {
            return;
        }
        float g16 = ((f16 - g()) + 360.0f) % 360.0f;
        if (g16 > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(g16);
        this.f34102h.add(new b(dVar));
        p(f16);
    }

    private void c(g gVar, float f16, float f17) {
        b(f16);
        this.f34102h.add(gVar);
        p(f17);
    }

    private float g() {
        return this.f34099e;
    }

    private float h() {
        return this.f34100f;
    }

    private void p(float f16) {
        this.f34099e = f16;
    }

    private void q(float f16) {
        this.f34100f = f16;
    }

    private void r(float f16) {
        this.f34097c = f16;
    }

    private void s(float f16) {
        this.f34098d = f16;
    }

    private void t(float f16) {
        this.f34095a = f16;
    }

    private void u(float f16) {
        this.f34096b = f16;
    }

    public void a(float f16, float f17, float f18, float f19, float f26, float f27) {
        boolean z16;
        float f28;
        d dVar = new d(f16, f17, f18, f19);
        dVar.s(f26);
        dVar.t(f27);
        this.f34101g.add(dVar);
        b bVar = new b(dVar);
        float f29 = f26 + f27;
        if (f27 < 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f26 = (f26 + 180.0f) % 360.0f;
        }
        if (z16) {
            f28 = (180.0f + f29) % 360.0f;
        } else {
            f28 = f29;
        }
        c(bVar, f26, f28);
        double d16 = f29;
        r(((f16 + f18) * 0.5f) + (((f18 - f16) / 2.0f) * ((float) Math.cos(Math.toRadians(d16)))));
        s(((f17 + f19) * 0.5f) + (((f19 - f17) / 2.0f) * ((float) Math.sin(Math.toRadians(d16)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f34101g.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f34101g.get(i3).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f34103i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f34102h), new Matrix(matrix));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f34097c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f34098d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.f34095a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f34096b;
    }

    public void m(float f16, float f17) {
        e eVar = new e();
        eVar.f34118b = f16;
        eVar.f34119c = f17;
        this.f34101g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f16);
        s(f17);
    }

    public void n(float f16, float f17) {
        o(f16, f17, 270.0f, 0.0f);
    }

    public void o(float f16, float f17, float f18, float f19) {
        t(f16);
        u(f17);
        r(f16);
        s(f17);
        p(f18);
        q((f18 + f19) % 360.0f);
        this.f34101g.clear();
        this.f34102h.clear();
        this.f34103i = false;
    }
}
