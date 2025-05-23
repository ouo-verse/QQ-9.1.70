package com.tencent.luggage.wxa.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.luggage.wxa.a.b;
import com.tencent.luggage.wxa.a.f;
import com.tencent.luggage.wxa.a.h;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.thumbplayer.api.common.TPChannelLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i {

    /* renamed from: i, reason: collision with root package name */
    public static HashSet f120701i;

    /* renamed from: a, reason: collision with root package name */
    public Canvas f120702a;

    /* renamed from: b, reason: collision with root package name */
    public float f120703b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.a.h f120704c;

    /* renamed from: d, reason: collision with root package name */
    public h f120705d;

    /* renamed from: e, reason: collision with root package name */
    public Stack f120706e;

    /* renamed from: f, reason: collision with root package name */
    public Stack f120707f;

    /* renamed from: g, reason: collision with root package name */
    public Stack f120708g;

    /* renamed from: h, reason: collision with root package name */
    public b.q f120709h = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120710a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f120711b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f120712c;

        static {
            int[] iArr = new int[h.f0.d.values().length];
            f120712c = iArr;
            try {
                iArr[h.f0.d.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f120712c[h.f0.d.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f120712c[h.f0.d.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[h.f0.c.values().length];
            f120711b = iArr2;
            try {
                iArr2[h.f0.c.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f120711b[h.f0.c.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f120711b[h.f0.c.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[f.a.values().length];
            f120710a = iArr3;
            try {
                iArr3[f.a.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f120710a[f.a.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f120710a[f.a.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f120710a[f.a.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f120710a[f.a.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f120710a[f.a.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f120710a[f.a.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f120710a[f.a.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements h.y {

        /* renamed from: b, reason: collision with root package name */
        public float f120714b;

        /* renamed from: c, reason: collision with root package name */
        public float f120715c;

        /* renamed from: h, reason: collision with root package name */
        public boolean f120720h;

        /* renamed from: a, reason: collision with root package name */
        public List f120713a = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public c f120716d = null;

        /* renamed from: e, reason: collision with root package name */
        public boolean f120717e = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f120718f = true;

        /* renamed from: g, reason: collision with root package name */
        public int f120719g = -1;

        public b(h.x xVar) {
            if (xVar == null) {
                return;
            }
            xVar.a(this);
            if (this.f120720h) {
                this.f120716d.a((c) this.f120713a.get(this.f120719g));
                this.f120713a.set(this.f120719g, this.f120716d);
                this.f120720h = false;
            }
            c cVar = this.f120716d;
            if (cVar != null) {
                this.f120713a.add(cVar);
            }
        }

        public List a() {
            return this.f120713a;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void b(float f16, float f17) {
            this.f120716d.a(f16, f17);
            this.f120713a.add(this.f120716d);
            i iVar = i.this;
            c cVar = this.f120716d;
            this.f120716d = new c(f16, f17, f16 - cVar.f120722a, f17 - cVar.f120723b);
            this.f120720h = false;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void close() {
            this.f120713a.add(this.f120716d);
            b(this.f120714b, this.f120715c);
            this.f120720h = true;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17) {
            if (this.f120720h) {
                this.f120716d.a((c) this.f120713a.get(this.f120719g));
                this.f120713a.set(this.f120719g, this.f120716d);
                this.f120720h = false;
            }
            c cVar = this.f120716d;
            if (cVar != null) {
                this.f120713a.add(cVar);
            }
            this.f120714b = f16;
            this.f120715c = f17;
            this.f120716d = new c(f16, f17, 0.0f, 0.0f);
            this.f120719g = this.f120713a.size();
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17, float f18, float f19, float f26, float f27) {
            if (this.f120718f || this.f120717e) {
                this.f120716d.a(f16, f17);
                this.f120713a.add(this.f120716d);
                this.f120717e = false;
            }
            this.f120716d = new c(f26, f27, f26 - f18, f27 - f19);
            this.f120720h = false;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17, float f18, float f19) {
            this.f120716d.a(f16, f17);
            this.f120713a.add(this.f120716d);
            this.f120716d = new c(f18, f19, f18 - f16, f19 - f17);
            this.f120720h = false;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17, float f18, boolean z16, boolean z17, float f19, float f26) {
            this.f120717e = true;
            this.f120718f = false;
            c cVar = this.f120716d;
            i.b(cVar.f120722a, cVar.f120723b, f16, f17, f18, z16, z17, f19, f26, this);
            this.f120718f = true;
            this.f120720h = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d implements h.y {

        /* renamed from: a, reason: collision with root package name */
        public Path f120728a = new Path();

        /* renamed from: b, reason: collision with root package name */
        public float f120729b;

        /* renamed from: c, reason: collision with root package name */
        public float f120730c;

        public d(h.x xVar) {
            if (xVar == null) {
                return;
            }
            xVar.a(this);
        }

        public Path a() {
            return this.f120728a;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void b(float f16, float f17) {
            this.f120728a.lineTo(f16, f17);
            this.f120729b = f16;
            this.f120730c = f17;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void close() {
            this.f120728a.close();
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17) {
            this.f120728a.moveTo(f16, f17);
            this.f120729b = f16;
            this.f120730c = f17;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17, float f18, float f19, float f26, float f27) {
            this.f120728a.cubicTo(f16, f17, f18, f19, f26, f27);
            this.f120729b = f26;
            this.f120730c = f27;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17, float f18, float f19) {
            this.f120728a.quadTo(f16, f17, f18, f19);
            this.f120729b = f18;
            this.f120730c = f19;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17, float f18, boolean z16, boolean z17, float f19, float f26) {
            i.b(this.f120729b, this.f120730c, f16, f17, f18, z16, z17, f19, f26, this);
            this.f120729b = f19;
            this.f120730c = f26;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e extends f {

        /* renamed from: e, reason: collision with root package name */
        public Path f120731e;

        public e(Path path, float f16, float f17) {
            super(f16, f17);
            this.f120731e = path;
        }

        @Override // com.tencent.luggage.wxa.a.i.f, com.tencent.luggage.wxa.a.i.j
        public void a(String str) {
            if (i.this.s()) {
                if (i.this.f120705d.f120741b) {
                    i.this.f120702a.drawTextOnPath(str, this.f120731e, this.f120733b, this.f120734c, i.this.f120705d.f120743d);
                }
                if (i.this.f120705d.f120742c) {
                    i.this.f120702a.drawTextOnPath(str, this.f120731e, this.f120733b, this.f120734c, i.this.f120705d.f120744e);
                }
            }
            this.f120733b += i.this.f120705d.f120743d.measureText(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends j {

        /* renamed from: b, reason: collision with root package name */
        public float f120733b;

        /* renamed from: c, reason: collision with root package name */
        public float f120734c;

        public f(float f16, float f17) {
            super(i.this, null);
            this.f120733b = f16;
            this.f120734c = f17;
        }

        @Override // com.tencent.luggage.wxa.a.i.j
        public void a(String str) {
            i.d("TextSequence render", new Object[0]);
            if (i.this.s()) {
                if (i.this.f120705d.f120741b) {
                    i.this.f120702a.drawText(str, this.f120733b, this.f120734c, i.this.f120705d.f120743d);
                }
                if (i.this.f120705d.f120742c) {
                    i.this.f120702a.drawText(str, this.f120733b, this.f120734c, i.this.f120705d.f120744e);
                }
            }
            this.f120733b += i.this.f120705d.f120743d.measureText(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public abstract class j {
        public j() {
        }

        public abstract void a(String str);

        public boolean a(h.z0 z0Var) {
            return true;
        }

        public /* synthetic */ j(i iVar, a aVar) {
            this();
        }
    }

    public i(Canvas canvas, float f16) {
        this.f120702a = canvas;
        this.f120703b = f16;
    }

    public static void d(String str, Object... objArr) {
    }

    public static void e(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    public static synchronized void k() {
        synchronized (i.class) {
            HashSet hashSet = new HashSet();
            f120701i = hashSet;
            hashSet.add("Structure");
            f120701i.add("BasicStructure");
            f120701i.add("ConditionalProcessing");
            f120701i.add("Image");
            f120701i.add("Style");
            f120701i.add("ViewportAttribute");
            f120701i.add(ComponentFactory.ComponentType.SHAPE);
            f120701i.add("BasicText");
            f120701i.add("PaintAttribute");
            f120701i.add("BasicPaintAttribute");
            f120701i.add("OpacityAttribute");
            f120701i.add("BasicGraphicsAttribute");
            f120701i.add("Marker");
            f120701i.add("Gradient");
            f120701i.add("Pattern");
            f120701i.add("Clip");
            f120701i.add("BasicClip");
            f120701i.add("Mask");
            f120701i.add("View");
        }
    }

    public final float a(float f16, float f17, float f18, float f19) {
        return (f16 * f18) + (f17 * f19);
    }

    public float f() {
        return this.f120705d.f120743d.getTextSize();
    }

    public float g() {
        return this.f120705d.f120743d.getTextSize() / 2.0f;
    }

    public h.c h() {
        h hVar = this.f120705d;
        h.c cVar = hVar.f120746g;
        if (cVar != null) {
            return cVar;
        }
        return hVar.f120745f;
    }

    public float i() {
        return this.f120703b;
    }

    public final Path.FillType j() {
        h.f0.a aVar = this.f120705d.f120740a.f120552c;
        if (aVar != null && aVar == h.f0.a.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    public final void l() {
        this.f120707f.pop();
        this.f120708g.pop();
    }

    public final boolean m() {
        h.o0 c16;
        if (!n()) {
            return false;
        }
        this.f120702a.saveLayerAlpha(null, a(this.f120705d.f120740a.f120562m.floatValue()), 31);
        this.f120706e.push(this.f120705d);
        h hVar = new h(this.f120705d);
        this.f120705d = hVar;
        String str = hVar.f120740a.V;
        if (str != null && ((c16 = this.f120704c.c(str)) == null || !(c16 instanceof h.t))) {
            e("Mask reference '%s' not found", this.f120705d.f120740a.V);
            this.f120705d.f120740a.V = null;
        }
        return true;
    }

    public final boolean n() {
        if (this.f120705d.f120740a.f120562m.floatValue() >= 1.0f && this.f120705d.f120740a.V == null) {
            return false;
        }
        return true;
    }

    public final void o() {
        this.f120705d = new h();
        this.f120706e = new Stack();
        a(this.f120705d, h.f0.a());
        h hVar = this.f120705d;
        hVar.f120745f = null;
        hVar.f120747h = false;
        this.f120706e.push(new h(hVar));
        this.f120708g = new Stack();
        this.f120707f = new Stack();
    }

    public final void p() {
        this.f120702a.restore();
        this.f120705d = (h) this.f120706e.pop();
    }

    public final void q() {
        this.f120702a.save();
        this.f120706e.push(this.f120705d);
        this.f120705d = new h(this.f120705d);
    }

    public final void r() {
        int i3;
        h.f0 f0Var = this.f120705d.f120740a;
        h.p0 p0Var = f0Var.Y;
        if (p0Var instanceof h.g) {
            i3 = ((h.g) p0Var).f120605a;
        } else if (p0Var instanceof h.C5979h) {
            i3 = f0Var.C.f120605a;
        } else {
            return;
        }
        Float f16 = f0Var.Z;
        if (f16 != null) {
            i3 = a(i3, f16.floatValue());
        }
        this.f120702a.drawColor(i3);
    }

    public final boolean s() {
        Boolean bool = this.f120705d.f120740a.Q;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g extends j {

        /* renamed from: b, reason: collision with root package name */
        public float f120736b;

        /* renamed from: c, reason: collision with root package name */
        public float f120737c;

        /* renamed from: d, reason: collision with root package name */
        public Path f120738d;

        public g(float f16, float f17, Path path) {
            super(i.this, null);
            this.f120736b = f16;
            this.f120737c = f17;
            this.f120738d = path;
        }

        @Override // com.tencent.luggage.wxa.a.i.j
        public boolean a(h.z0 z0Var) {
            if (!(z0Var instanceof h.a1)) {
                return true;
            }
            i.f("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // com.tencent.luggage.wxa.a.i.j
        public void a(String str) {
            if (i.this.s()) {
                Path path = new Path();
                i.this.f120705d.f120743d.getTextPath(str, 0, str.length(), this.f120736b, this.f120737c, path);
                this.f120738d.addPath(path);
            }
            this.f120736b += i.this.f120705d.f120743d.measureText(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k extends j {

        /* renamed from: b, reason: collision with root package name */
        public float f120754b;

        public k() {
            super(i.this, null);
            this.f120754b = 0.0f;
        }

        @Override // com.tencent.luggage.wxa.a.i.j
        public void a(String str) {
            this.f120754b += i.this.f120705d.f120743d.measureText(str);
        }

        public /* synthetic */ k(i iVar, a aVar) {
            this();
        }
    }

    public static int a(float f16) {
        int i3 = (int) (f16 * 256.0f);
        if (i3 < 0) {
            return 0;
        }
        if (i3 > 255) {
            return 255;
        }
        return i3;
    }

    public static void f(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    public final void d(h.l0 l0Var) {
        if (l0Var.f120649b == null || l0Var.f120636h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (((Matrix) this.f120708g.peek()).invert(matrix)) {
            h.c cVar = l0Var.f120636h;
            h.c cVar2 = l0Var.f120636h;
            h.c cVar3 = l0Var.f120636h;
            float[] fArr = {cVar.f120517a, cVar.f120518b, cVar.a(), cVar2.f120518b, cVar2.a(), l0Var.f120636h.b(), cVar3.f120517a, cVar3.b()};
            matrix.preConcat(this.f120702a.getMatrix());
            matrix.mapPoints(fArr);
            float f16 = fArr[0];
            float f17 = fArr[1];
            RectF rectF = new RectF(f16, f17, f16, f17);
            for (int i3 = 2; i3 <= 6; i3 += 2) {
                float f18 = fArr[i3];
                if (f18 < rectF.left) {
                    rectF.left = f18;
                }
                if (f18 > rectF.right) {
                    rectF.right = f18;
                }
                float f19 = fArr[i3 + 1];
                if (f19 < rectF.top) {
                    rectF.top = f19;
                }
                if (f19 > rectF.bottom) {
                    rectF.bottom = f19;
                }
            }
            h.l0 l0Var2 = (h.l0) this.f120707f.peek();
            h.c cVar4 = l0Var2.f120636h;
            if (cVar4 == null) {
                l0Var2.f120636h = h.c.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                cVar4.a(h.c.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    public final Path.FillType e() {
        h.f0.a aVar = this.f120705d.f120740a.U;
        if (aVar != null && aVar == h.f0.a.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    public final void b(Path path) {
        h hVar = this.f120705d;
        if (hVar.f120740a.f120549a0 == h.f0.i.NonScalingStroke) {
            Matrix matrix = this.f120702a.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.f120702a.setMatrix(new Matrix());
            Shader shader = this.f120705d.f120744e.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.f120702a.drawPath(path2, this.f120705d.f120744e);
            this.f120702a.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.f120702a.drawPath(path, hVar.f120744e);
    }

    public final void c(h.o0 o0Var) {
        if (o0Var instanceof h.u) {
            return;
        }
        q();
        a(o0Var);
        if (o0Var instanceof h.g0) {
            a((h.g0) o0Var);
        } else if (o0Var instanceof h.f1) {
            a((h.f1) o0Var);
        } else if (o0Var instanceof h.t0) {
            a((h.t0) o0Var);
        } else if (o0Var instanceof h.n) {
            a((h.n) o0Var);
        } else if (o0Var instanceof h.p) {
            a((h.p) o0Var);
        } else if (o0Var instanceof h.w) {
            a((h.w) o0Var);
        } else if (o0Var instanceof h.c0) {
            b((h.c0) o0Var);
        } else if (o0Var instanceof h.e) {
            b((h.e) o0Var);
        } else if (o0Var instanceof h.j) {
            b((h.j) o0Var);
        } else if (o0Var instanceof h.r) {
            c((h.r) o0Var);
        } else if (o0Var instanceof h.b0) {
            a((h.b0) o0Var);
        } else if (o0Var instanceof h.a0) {
            c((h.a0) o0Var);
        } else if (o0Var instanceof h.x0) {
            b((h.x0) o0Var);
        }
        p();
    }

    public void a(com.tencent.luggage.wxa.a.h hVar, com.tencent.luggage.wxa.a.g gVar) {
        h.c cVar;
        com.tencent.luggage.wxa.a.f fVar;
        if (gVar != null) {
            this.f120704c = hVar;
            h.g0 f16 = hVar.f();
            if (f16 == null) {
                f("Nothing to render. Document is empty.", new Object[0]);
                return;
            }
            if (gVar.d()) {
                h.m0 b16 = this.f120704c.b(gVar.f120498e);
                if (b16 == null || !(b16 instanceof h.g1)) {
                    Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", gVar.f120498e));
                    return;
                }
                h.g1 g1Var = (h.g1) b16;
                cVar = g1Var.f120674p;
                if (cVar == null) {
                    Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", gVar.f120498e));
                    return;
                }
                fVar = g1Var.f120658o;
            } else {
                cVar = gVar.e() ? gVar.f120497d : f16.f120674p;
                fVar = gVar.b() ? gVar.f120495b : f16.f120658o;
            }
            if (gVar.a()) {
                hVar.a(gVar.f120494a);
            }
            if (gVar.c()) {
                b.q qVar = new b.q();
                this.f120709h = qVar;
                qVar.f120451a = hVar.b(gVar.f120496c);
            }
            o();
            a((h.o0) f16);
            q();
            h.c cVar2 = new h.c(gVar.f120499f);
            h.q qVar2 = f16.f120608s;
            if (qVar2 != null) {
                cVar2.f120519c = qVar2.a(this, cVar2.f120519c);
            }
            h.q qVar3 = f16.f120609t;
            if (qVar3 != null) {
                cVar2.f120520d = qVar3.a(this, cVar2.f120520d);
            }
            a(f16, cVar2, cVar, fVar);
            p();
            if (gVar.a()) {
                hVar.a();
                return;
            }
            return;
        }
        throw new NullPointerException("renderOptions shouldn't be null");
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public float f120722a;

        /* renamed from: b, reason: collision with root package name */
        public float f120723b;

        /* renamed from: c, reason: collision with root package name */
        public float f120724c;

        /* renamed from: d, reason: collision with root package name */
        public float f120725d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f120726e = false;

        public c(float f16, float f17, float f18, float f19) {
            this.f120724c = 0.0f;
            this.f120725d = 0.0f;
            this.f120722a = f16;
            this.f120723b = f17;
            double sqrt = Math.sqrt((f18 * f18) + (f19 * f19));
            if (sqrt != 0.0d) {
                this.f120724c = (float) (f18 / sqrt);
                this.f120725d = (float) (f19 / sqrt);
            }
        }

        public void a(float f16, float f17) {
            float f18 = f16 - this.f120722a;
            float f19 = f17 - this.f120723b;
            double sqrt = Math.sqrt((f18 * f18) + (f19 * f19));
            if (sqrt != 0.0d) {
                f18 = (float) (f18 / sqrt);
                f19 = (float) (f19 / sqrt);
            }
            float f26 = this.f120724c;
            if (f18 == (-f26) && f19 == (-this.f120725d)) {
                this.f120726e = true;
                this.f120724c = -f19;
                this.f120725d = f18;
            } else {
                this.f120724c = f26 + f18;
                this.f120725d += f19;
            }
        }

        public String toString() {
            return "(" + this.f120722a + "," + this.f120723b + " " + this.f120724c + "," + this.f120725d + ")";
        }

        public void a(c cVar) {
            float f16 = cVar.f120724c;
            float f17 = this.f120724c;
            if (f16 == (-f17)) {
                float f18 = cVar.f120725d;
                if (f18 == (-this.f120725d)) {
                    this.f120726e = true;
                    this.f120724c = -f18;
                    this.f120725d = cVar.f120724c;
                    return;
                }
            }
            this.f120724c = f17 + f16;
            this.f120725d += cVar.f120725d;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a.i$i, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C5980i extends j {

        /* renamed from: b, reason: collision with root package name */
        public float f120749b;

        /* renamed from: c, reason: collision with root package name */
        public float f120750c;

        /* renamed from: d, reason: collision with root package name */
        public RectF f120751d;

        public C5980i(float f16, float f17) {
            super(i.this, null);
            this.f120751d = new RectF();
            this.f120749b = f16;
            this.f120750c = f17;
        }

        @Override // com.tencent.luggage.wxa.a.i.j
        public boolean a(h.z0 z0Var) {
            if (!(z0Var instanceof h.a1)) {
                return true;
            }
            h.a1 a1Var = (h.a1) z0Var;
            h.o0 c16 = z0Var.f120648a.c(a1Var.f120509o);
            if (c16 == null) {
                i.e("TextPath path reference '%s' not found", a1Var.f120509o);
                return false;
            }
            h.w wVar = (h.w) c16;
            Path a16 = new d(wVar.f120685o).a();
            Matrix matrix = wVar.f120637n;
            if (matrix != null) {
                a16.transform(matrix);
            }
            RectF rectF = new RectF();
            a16.computeBounds(rectF, true);
            this.f120751d.union(rectF);
            return false;
        }

        @Override // com.tencent.luggage.wxa.a.i.j
        public void a(String str) {
            if (i.this.s()) {
                Rect rect = new Rect();
                i.this.f120705d.f120743d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f120749b, this.f120750c);
                this.f120751d.union(rectF);
            }
            this.f120749b += i.this.f120705d.f120743d.measureText(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        public h.f0 f120740a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f120741b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f120742c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f120743d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f120744e;

        /* renamed from: f, reason: collision with root package name */
        public h.c f120745f;

        /* renamed from: g, reason: collision with root package name */
        public h.c f120746g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f120747h;

        public h() {
            Paint paint = new Paint();
            this.f120743d = paint;
            paint.setFlags(193);
            this.f120743d.setHinting(0);
            this.f120743d.setStyle(Paint.Style.FILL);
            this.f120743d.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.f120744e = paint2;
            paint2.setFlags(193);
            this.f120744e.setHinting(0);
            this.f120744e.setStyle(Paint.Style.STROKE);
            this.f120744e.setTypeface(Typeface.DEFAULT);
            this.f120740a = h.f0.a();
        }

        public h(h hVar) {
            this.f120741b = hVar.f120741b;
            this.f120742c = hVar.f120742c;
            this.f120743d = new Paint(hVar.f120743d);
            this.f120744e = new Paint(hVar.f120744e);
            h.c cVar = hVar.f120745f;
            if (cVar != null) {
                this.f120745f = new h.c(cVar);
            }
            h.c cVar2 = hVar.f120746g;
            if (cVar2 != null) {
                this.f120746g = new h.c(cVar2);
            }
            this.f120747h = hVar.f120747h;
            try {
                this.f120740a = (h.f0) hVar.f120740a.clone();
            } catch (CloneNotSupportedException e16) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e16);
                this.f120740a = h.f0.a();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(h.t0 t0Var) {
        Set a16;
        String language = Locale.getDefault().getLanguage();
        com.tencent.luggage.wxa.a.h.e();
        for (h.o0 o0Var : t0Var.getChildren()) {
            if (o0Var instanceof h.h0) {
                h.h0 h0Var = (h.h0) o0Var;
                if (h0Var.b() == null && ((a16 = h0Var.a()) == null || (!a16.isEmpty() && a16.contains(language)))) {
                    Set d16 = h0Var.d();
                    if (d16 != null) {
                        if (f120701i == null) {
                            k();
                        }
                        if (!d16.isEmpty() && f120701i.containsAll(d16)) {
                        }
                    }
                    Set e16 = h0Var.e();
                    if (e16 != null) {
                        e16.isEmpty();
                    } else {
                        Set f16 = h0Var.f();
                        if (f16 != null) {
                            f16.isEmpty();
                        } else {
                            c(o0Var);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void d(h.l0 l0Var, h.c cVar) {
        if (this.f120705d.f120740a.V != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f120702a.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.f120702a.saveLayer(null, paint2, 31);
            h.t tVar = (h.t) this.f120704c.c(this.f120705d.f120740a.V);
            a(tVar, l0Var, cVar);
            this.f120702a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f120702a.saveLayer(null, paint3, 31);
            a(tVar, l0Var, cVar);
            this.f120702a.restore();
            this.f120702a.restore();
        }
        p();
    }

    public final void c(h.l0 l0Var) {
        d(l0Var, l0Var.f120636h);
    }

    public final void c(h.r rVar) {
        d("Line render", new Object[0]);
        a(this.f120705d, rVar);
        if (c() && s() && this.f120705d.f120742c) {
            Matrix matrix = rVar.f120637n;
            if (matrix != null) {
                this.f120702a.concat(matrix);
            }
            Path b16 = b(rVar);
            d(rVar);
            b((h.l0) rVar);
            a((h.l0) rVar);
            boolean m3 = m();
            b(b16);
            a((h.m) rVar);
            if (m3) {
                c((h.l0) rVar);
            }
        }
    }

    public final void b(h.c0 c0Var) {
        d("Rect render", new Object[0]);
        h.q qVar = c0Var.f120523q;
        if (qVar == null || c0Var.f120524r == null || qVar.c() || c0Var.f120524r.c()) {
            return;
        }
        a(this.f120705d, c0Var);
        if (c() && s()) {
            Matrix matrix = c0Var.f120637n;
            if (matrix != null) {
                this.f120702a.concat(matrix);
            }
            Path a16 = a(c0Var);
            d(c0Var);
            b((h.l0) c0Var);
            a((h.l0) c0Var);
            boolean m3 = m();
            if (this.f120705d.f120741b) {
                a(c0Var, a16);
            }
            if (this.f120705d.f120742c) {
                b(a16);
            }
            if (m3) {
                c((h.l0) c0Var);
            }
        }
    }

    public final void a(h.k0 k0Var, boolean z16) {
        if (z16) {
            a(k0Var);
        }
        Iterator it = k0Var.getChildren().iterator();
        while (it.hasNext()) {
            c((h.o0) it.next());
        }
        if (z16) {
            l();
        }
    }

    public final h.f0.f d() {
        h.f0.f fVar;
        h.f0 f0Var = this.f120705d.f120740a;
        if (f0Var.I != h.f0.EnumC5978h.LTR && (fVar = f0Var.J) != h.f0.f.Middle) {
            h.f0.f fVar2 = h.f0.f.Start;
            return fVar == fVar2 ? h.f0.f.End : fVar2;
        }
        return f0Var.J;
    }

    public final void a(h.k0 k0Var) {
        this.f120707f.push(k0Var);
        this.f120708g.push(this.f120702a.getMatrix());
    }

    public final void a(h hVar, h.m0 m0Var) {
        hVar.f120740a.a(m0Var.f120649b == null);
        h.f0 f0Var = m0Var.f120640e;
        if (f0Var != null) {
            a(hVar, f0Var);
        }
        if (this.f120704c.g()) {
            for (b.p pVar : this.f120704c.b()) {
                if (com.tencent.luggage.wxa.a.b.a(this.f120709h, pVar.f120448a, m0Var)) {
                    a(hVar, pVar.f120449b);
                }
            }
        }
        h.f0 f0Var2 = m0Var.f120641f;
        if (f0Var2 != null) {
            a(hVar, f0Var2);
        }
    }

    public final void c(h.a0 a0Var) {
        d("PolyLine render", new Object[0]);
        a(this.f120705d, a0Var);
        if (c() && s()) {
            h hVar = this.f120705d;
            if (hVar.f120742c || hVar.f120741b) {
                Matrix matrix = a0Var.f120637n;
                if (matrix != null) {
                    this.f120702a.concat(matrix);
                }
                if (a0Var.f120508o.length < 2) {
                    return;
                }
                Path b16 = b(a0Var);
                d(a0Var);
                b16.setFillType(j());
                b((h.l0) a0Var);
                a((h.l0) a0Var);
                boolean m3 = m();
                if (this.f120705d.f120741b) {
                    a(a0Var, b16);
                }
                if (this.f120705d.f120742c) {
                    b(b16);
                }
                a((h.m) a0Var);
                if (m3) {
                    c((h.l0) a0Var);
                }
            }
        }
    }

    public final void b(h.e eVar) {
        d("Circle render", new Object[0]);
        h.q qVar = eVar.f120535q;
        if (qVar == null || qVar.c()) {
            return;
        }
        a(this.f120705d, eVar);
        if (c() && s()) {
            Matrix matrix = eVar.f120637n;
            if (matrix != null) {
                this.f120702a.concat(matrix);
            }
            Path a16 = a(eVar);
            d(eVar);
            b((h.l0) eVar);
            a((h.l0) eVar);
            boolean m3 = m();
            if (this.f120705d.f120741b) {
                a(eVar, a16);
            }
            if (this.f120705d.f120742c) {
                b(a16);
            }
            if (m3) {
                c((h.l0) eVar);
            }
        }
    }

    public final void a(h.o0 o0Var) {
        Boolean bool;
        if ((o0Var instanceof h.m0) && (bool = ((h.m0) o0Var).f120639d) != null) {
            this.f120705d.f120747h = bool.booleanValue();
        }
    }

    public final void a(h.l0 l0Var, Path path) {
        h.p0 p0Var = this.f120705d.f120740a.f120550b;
        if (p0Var instanceof h.v) {
            h.o0 c16 = this.f120704c.c(((h.v) p0Var).f120681a);
            if (c16 instanceof h.z) {
                a(l0Var, path, (h.z) c16);
                return;
            }
        }
        this.f120702a.drawPath(path, this.f120705d.f120743d);
    }

    public final void a(h.g0 g0Var) {
        a(g0Var, a(g0Var.f120606q, g0Var.f120607r, g0Var.f120608s, g0Var.f120609t), g0Var.f120674p, g0Var.f120658o);
    }

    public final void a(h.g0 g0Var, h.c cVar) {
        a(g0Var, cVar, g0Var.f120674p, g0Var.f120658o);
    }

    public final void a(h.g0 g0Var, h.c cVar, h.c cVar2, com.tencent.luggage.wxa.a.f fVar) {
        d("Svg render", new Object[0]);
        if (cVar.f120519c == 0.0f || cVar.f120520d == 0.0f) {
            return;
        }
        if (fVar == null && (fVar = g0Var.f120658o) == null) {
            fVar = com.tencent.luggage.wxa.a.f.f120471e;
        }
        a(this.f120705d, g0Var);
        if (c()) {
            h hVar = this.f120705d;
            hVar.f120745f = cVar;
            if (!hVar.f120740a.K.booleanValue()) {
                h.c cVar3 = this.f120705d.f120745f;
                b(cVar3.f120517a, cVar3.f120518b, cVar3.f120519c, cVar3.f120520d);
            }
            b(g0Var, this.f120705d.f120745f);
            if (cVar2 != null) {
                this.f120702a.concat(a(this.f120705d.f120745f, cVar2, fVar));
                this.f120705d.f120746g = g0Var.f120674p;
            } else {
                Canvas canvas = this.f120702a;
                h.c cVar4 = this.f120705d.f120745f;
                canvas.translate(cVar4.f120517a, cVar4.f120518b);
            }
            boolean m3 = m();
            r();
            a((h.k0) g0Var, true);
            if (m3) {
                c((h.l0) g0Var);
            }
            d(g0Var);
        }
    }

    public final void b(h.j jVar) {
        d("Ellipse render", new Object[0]);
        h.q qVar = jVar.f120620q;
        if (qVar == null || jVar.f120621r == null || qVar.c() || jVar.f120621r.c()) {
            return;
        }
        a(this.f120705d, jVar);
        if (c() && s()) {
            Matrix matrix = jVar.f120637n;
            if (matrix != null) {
                this.f120702a.concat(matrix);
            }
            Path a16 = a(jVar);
            d(jVar);
            b((h.l0) jVar);
            a((h.l0) jVar);
            boolean m3 = m();
            if (this.f120705d.f120741b) {
                a(jVar, a16);
            }
            if (this.f120705d.f120742c) {
                b(a16);
            }
            if (m3) {
                c((h.l0) jVar);
            }
        }
    }

    public final boolean c() {
        Boolean bool = this.f120705d.f120740a.P;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void c(h.l0 l0Var, h.c cVar) {
        h.o0 c16 = l0Var.f120648a.c(this.f120705d.f120740a.T);
        if (c16 == null) {
            e("ClipPath reference '%s' not found", this.f120705d.f120740a.T);
            return;
        }
        h.f fVar = (h.f) c16;
        if (fVar.f120612i.isEmpty()) {
            this.f120702a.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = fVar.f120547p;
        boolean z16 = bool == null || bool.booleanValue();
        if ((l0Var instanceof h.n) && !z16) {
            f("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", l0Var.g());
            return;
        }
        b();
        if (!z16) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(cVar.f120517a, cVar.f120518b);
            matrix.preScale(cVar.f120519c, cVar.f120520d);
            this.f120702a.concat(matrix);
        }
        Matrix matrix2 = fVar.f120643o;
        if (matrix2 != null) {
            this.f120702a.concat(matrix2);
        }
        this.f120705d = b((h.o0) fVar);
        a((h.l0) fVar);
        Path path = new Path();
        Iterator it = fVar.f120612i.iterator();
        while (it.hasNext()) {
            a((h.o0) it.next(), true, path, new Matrix());
        }
        this.f120702a.clipPath(path);
        a();
    }

    public final h.c a(h.q qVar, h.q qVar2, h.q qVar3, h.q qVar4) {
        float b16 = qVar != null ? qVar.b(this) : 0.0f;
        float c16 = qVar2 != null ? qVar2.c(this) : 0.0f;
        h.c h16 = h();
        return new h.c(b16, c16, qVar3 != null ? qVar3.b(this) : h16.f120519c, qVar4 != null ? qVar4.c(this) : h16.f120520d);
    }

    public final void b(h.x0 x0Var) {
        d("Text render", new Object[0]);
        a(this.f120705d, x0Var);
        if (c()) {
            Matrix matrix = x0Var.f120692s;
            if (matrix != null) {
                this.f120702a.concat(matrix);
            }
            List list = x0Var.f120513o;
            float f16 = 0.0f;
            float b16 = (list == null || list.size() == 0) ? 0.0f : ((h.q) x0Var.f120513o.get(0)).b(this);
            List list2 = x0Var.f120514p;
            float c16 = (list2 == null || list2.size() == 0) ? 0.0f : ((h.q) x0Var.f120514p.get(0)).c(this);
            List list3 = x0Var.f120515q;
            float b17 = (list3 == null || list3.size() == 0) ? 0.0f : ((h.q) x0Var.f120515q.get(0)).b(this);
            List list4 = x0Var.f120516r;
            if (list4 != null && list4.size() != 0) {
                f16 = ((h.q) x0Var.f120516r.get(0)).c(this);
            }
            h.f0.f d16 = d();
            if (d16 != h.f0.f.Start) {
                float a16 = a((h.z0) x0Var);
                if (d16 == h.f0.f.Middle) {
                    a16 /= 2.0f;
                }
                b16 -= a16;
            }
            if (x0Var.f120636h == null) {
                C5980i c5980i = new C5980i(b16, c16);
                a((h.z0) x0Var, (j) c5980i);
                RectF rectF = c5980i.f120751d;
                x0Var.f120636h = new h.c(rectF.left, rectF.top, rectF.width(), c5980i.f120751d.height());
            }
            d(x0Var);
            b((h.l0) x0Var);
            a((h.l0) x0Var);
            boolean m3 = m();
            a((h.z0) x0Var, new f(b16 + b17, c16 + f16));
            if (m3) {
                c((h.l0) x0Var);
            }
        }
    }

    public final void a(h.n nVar) {
        d(nVar.g() + " render", new Object[0]);
        a(this.f120705d, nVar);
        if (c()) {
            Matrix matrix = nVar.f120643o;
            if (matrix != null) {
                this.f120702a.concat(matrix);
            }
            a((h.l0) nVar);
            boolean m3 = m();
            a((h.k0) nVar, true);
            if (m3) {
                c((h.l0) nVar);
            }
            d(nVar);
        }
    }

    public final void a(h.t0 t0Var) {
        d("Switch render", new Object[0]);
        a(this.f120705d, t0Var);
        if (c()) {
            Matrix matrix = t0Var.f120643o;
            if (matrix != null) {
                this.f120702a.concat(matrix);
            }
            a((h.l0) t0Var);
            boolean m3 = m();
            b(t0Var);
            if (m3) {
                c((h.l0) t0Var);
            }
            d(t0Var);
        }
    }

    public final void b(float f16, float f17, float f18, float f19) {
        float f26 = f18 + f16;
        float f27 = f19 + f17;
        h.d dVar = this.f120705d.f120740a.L;
        if (dVar != null) {
            f16 += dVar.f120530d.b(this);
            f17 += this.f120705d.f120740a.L.f120527a.c(this);
            f26 -= this.f120705d.f120740a.L.f120528b.b(this);
            f27 -= this.f120705d.f120740a.L.f120529c.c(this);
        }
        this.f120702a.clipRect(f16, f17, f26, f27);
    }

    public final void a(h.f1 f1Var) {
        d("Use render", new Object[0]);
        h.q qVar = f1Var.f120601s;
        if (qVar == null || !qVar.c()) {
            h.q qVar2 = f1Var.f120602t;
            if (qVar2 == null || !qVar2.c()) {
                a(this.f120705d, f1Var);
                if (c()) {
                    h.o0 c16 = f1Var.f120648a.c(f1Var.f120598p);
                    if (c16 == null) {
                        e("Use reference '%s' not found", f1Var.f120598p);
                        return;
                    }
                    Matrix matrix = f1Var.f120643o;
                    if (matrix != null) {
                        this.f120702a.concat(matrix);
                    }
                    h.q qVar3 = f1Var.f120599q;
                    float b16 = qVar3 != null ? qVar3.b(this) : 0.0f;
                    h.q qVar4 = f1Var.f120600r;
                    this.f120702a.translate(b16, qVar4 != null ? qVar4.c(this) : 0.0f);
                    a((h.l0) f1Var);
                    boolean m3 = m();
                    a((h.k0) f1Var);
                    if (c16 instanceof h.g0) {
                        h.c a16 = a((h.q) null, (h.q) null, f1Var.f120601s, f1Var.f120602t);
                        q();
                        a((h.g0) c16, a16);
                        p();
                    } else if (c16 instanceof h.u0) {
                        h.q qVar5 = f1Var.f120601s;
                        if (qVar5 == null) {
                            qVar5 = new h.q(100.0f, h.e1.percent);
                        }
                        h.q qVar6 = f1Var.f120602t;
                        if (qVar6 == null) {
                            qVar6 = new h.q(100.0f, h.e1.percent);
                        }
                        h.c a17 = a((h.q) null, (h.q) null, qVar5, qVar6);
                        q();
                        a((h.u0) c16, a17);
                        p();
                    } else {
                        c(c16);
                    }
                    l();
                    if (m3) {
                        c((h.l0) f1Var);
                    }
                    d(f1Var);
                }
            }
        }
    }

    public static void b(float f16, float f17, float f18, float f19, float f26, boolean z16, boolean z17, float f27, float f28, h.y yVar) {
        if (f16 == f27 && f17 == f28) {
            return;
        }
        if (f18 != 0.0f && f19 != 0.0f) {
            float abs = Math.abs(f18);
            float abs2 = Math.abs(f19);
            double radians = Math.toRadians(f26 % 360.0d);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d16 = (f16 - f27) / 2.0d;
            double d17 = (f17 - f28) / 2.0d;
            double d18 = (cos * d16) + (sin * d17);
            double d19 = ((-sin) * d16) + (d17 * cos);
            double d26 = abs * abs;
            double d27 = abs2 * abs2;
            double d28 = d18 * d18;
            double d29 = d19 * d19;
            double d36 = (d28 / d26) + (d29 / d27);
            if (d36 > 0.99999d) {
                double sqrt = Math.sqrt(d36) * 1.00001d;
                abs = (float) (abs * sqrt);
                abs2 = (float) (sqrt * abs2);
                d26 = abs * abs;
                d27 = abs2 * abs2;
            }
            double d37 = z16 == z17 ? -1.0d : 1.0d;
            double d38 = d26 * d27;
            double d39 = d26 * d29;
            double d46 = d27 * d28;
            double d47 = ((d38 - d39) - d46) / (d39 + d46);
            if (d47 < 0.0d) {
                d47 = 0.0d;
            }
            double sqrt2 = d37 * Math.sqrt(d47);
            double d48 = abs;
            double d49 = abs2;
            double d56 = ((d48 * d19) / d49) * sqrt2;
            float f29 = abs;
            float f36 = abs2;
            double d57 = sqrt2 * (-((d49 * d18) / d48));
            double d58 = ((f16 + f27) / 2.0d) + ((cos * d56) - (sin * d57));
            double d59 = ((f17 + f28) / 2.0d) + (sin * d56) + (cos * d57);
            double d65 = (d18 - d56) / d48;
            double d66 = (d19 - d57) / d49;
            double d67 = ((-d18) - d56) / d48;
            double d68 = ((-d19) - d57) / d49;
            double d69 = (d65 * d65) + (d66 * d66);
            double acos = (d66 < 0.0d ? -1.0d : 1.0d) * Math.acos(d65 / Math.sqrt(d69));
            double a16 = ((d65 * d68) - (d66 * d67) >= 0.0d ? 1.0d : -1.0d) * a(((d65 * d67) + (d66 * d68)) / Math.sqrt(d69 * ((d67 * d67) + (d68 * d68))));
            if (a16 == 0.0d) {
                yVar.b(f27, f28);
                return;
            }
            if (!z17 && a16 > 0.0d) {
                a16 -= 6.283185307179586d;
            } else if (z17 && a16 < 0.0d) {
                a16 += 6.283185307179586d;
            }
            float[] a17 = a(acos % 6.283185307179586d, a16 % 6.283185307179586d);
            Matrix matrix = new Matrix();
            matrix.postScale(f29, f36);
            matrix.postRotate(f26);
            matrix.postTranslate((float) d58, (float) d59);
            matrix.mapPoints(a17);
            a17[a17.length - 2] = f27;
            a17[a17.length - 1] = f28;
            for (int i3 = 0; i3 < a17.length; i3 += 6) {
                yVar.a(a17[i3], a17[i3 + 1], a17[i3 + 2], a17[i3 + 3], a17[i3 + 4], a17[i3 + 5]);
            }
            return;
        }
        yVar.b(f27, f28);
    }

    public final h b(h.o0 o0Var) {
        h hVar = new h();
        a(hVar, h.f0.a());
        return a(o0Var, hVar);
    }

    public final void b(h.l0 l0Var) {
        h.p0 p0Var = this.f120705d.f120740a.f120550b;
        if (p0Var instanceof h.v) {
            a(true, l0Var.f120636h, (h.v) p0Var);
        }
        h.p0 p0Var2 = this.f120705d.f120740a.f120554e;
        if (p0Var2 instanceof h.v) {
            a(false, l0Var.f120636h, (h.v) p0Var2);
        }
    }

    public final void a(h.w wVar) {
        d("Path render", new Object[0]);
        if (wVar.f120685o == null) {
            return;
        }
        a(this.f120705d, wVar);
        if (c() && s()) {
            h hVar = this.f120705d;
            if (hVar.f120742c || hVar.f120741b) {
                Matrix matrix = wVar.f120637n;
                if (matrix != null) {
                    this.f120702a.concat(matrix);
                }
                Path a16 = new d(wVar.f120685o).a();
                if (wVar.f120636h == null) {
                    wVar.f120636h = a(a16);
                }
                d(wVar);
                b((h.l0) wVar);
                a((h.l0) wVar);
                boolean m3 = m();
                if (this.f120705d.f120741b) {
                    a16.setFillType(j());
                    a(wVar, a16);
                }
                if (this.f120705d.f120742c) {
                    b(a16);
                }
                a((h.m) wVar);
                if (m3) {
                    c((h.l0) wVar);
                }
            }
        }
    }

    public final void b(h.l0 l0Var, h.c cVar) {
        Path a16;
        if (this.f120705d.f120740a.T == null || (a16 = a(l0Var, cVar)) == null) {
            return;
        }
        this.f120702a.clipPath(a16);
    }

    public final void b() {
        com.tencent.luggage.wxa.a.c.a(this.f120702a, com.tencent.luggage.wxa.a.c.f120462a);
        this.f120706e.push(this.f120705d);
        this.f120705d = new h(this.f120705d);
    }

    public final Path b(h.r rVar) {
        h.q qVar = rVar.f120659o;
        float b16 = qVar == null ? 0.0f : qVar.b(this);
        h.q qVar2 = rVar.f120660p;
        float c16 = qVar2 == null ? 0.0f : qVar2.c(this);
        h.q qVar3 = rVar.f120661q;
        float b17 = qVar3 == null ? 0.0f : qVar3.b(this);
        h.q qVar4 = rVar.f120662r;
        float c17 = qVar4 != null ? qVar4.c(this) : 0.0f;
        if (rVar.f120636h == null) {
            rVar.f120636h = new h.c(Math.min(b16, b17), Math.min(c16, c17), Math.abs(b17 - b16), Math.abs(c17 - c16));
        }
        Path path = new Path();
        path.moveTo(b16, c16);
        path.lineTo(b17, c17);
        return path;
    }

    public final Path b(h.a0 a0Var) {
        Path path = new Path();
        float[] fArr = a0Var.f120508o;
        path.moveTo(fArr[0], fArr[1]);
        int i3 = 2;
        while (true) {
            float[] fArr2 = a0Var.f120508o;
            if (i3 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i3], fArr2[i3 + 1]);
            i3 += 2;
        }
        if (a0Var instanceof h.b0) {
            path.close();
        }
        if (a0Var.f120636h == null) {
            a0Var.f120636h = a(path);
        }
        return path;
    }

    public final h.c a(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new h.c(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    public final List a(h.r rVar) {
        h.q qVar = rVar.f120659o;
        float b16 = qVar != null ? qVar.b(this) : 0.0f;
        h.q qVar2 = rVar.f120660p;
        float c16 = qVar2 != null ? qVar2.c(this) : 0.0f;
        h.q qVar3 = rVar.f120661q;
        float b17 = qVar3 != null ? qVar3.b(this) : 0.0f;
        h.q qVar4 = rVar.f120662r;
        float c17 = qVar4 != null ? qVar4.c(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f16 = b17 - b16;
        float f17 = c17 - c16;
        arrayList.add(new c(b16, c16, f16, f17));
        arrayList.add(new c(b17, c17, f16, f17));
        return arrayList;
    }

    public final List a(h.a0 a0Var) {
        int length = a0Var.f120508o.length;
        int i3 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = a0Var.f120508o;
        c cVar = new c(fArr[0], fArr[1], 0.0f, 0.0f);
        float f16 = 0.0f;
        float f17 = 0.0f;
        while (i3 < length) {
            float[] fArr2 = a0Var.f120508o;
            float f18 = fArr2[i3];
            float f19 = fArr2[i3 + 1];
            cVar.a(f18, f19);
            arrayList.add(cVar);
            i3 += 2;
            cVar = new c(f18, f19, f18 - cVar.f120722a, f19 - cVar.f120723b);
            f17 = f19;
            f16 = f18;
        }
        if (a0Var instanceof h.b0) {
            float[] fArr3 = a0Var.f120508o;
            float f26 = fArr3[0];
            if (f16 != f26) {
                float f27 = fArr3[1];
                if (f17 != f27) {
                    cVar.a(f26, f27);
                    arrayList.add(cVar);
                    c cVar2 = new c(f26, f27, f26 - cVar.f120722a, f27 - cVar.f120723b);
                    cVar2.a((c) arrayList.get(0));
                    arrayList.add(cVar2);
                    arrayList.set(0, cVar2);
                }
            }
        } else {
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public final void a(h.b0 b0Var) {
        d("Polygon render", new Object[0]);
        a(this.f120705d, b0Var);
        if (c() && s()) {
            h hVar = this.f120705d;
            if (hVar.f120742c || hVar.f120741b) {
                Matrix matrix = b0Var.f120637n;
                if (matrix != null) {
                    this.f120702a.concat(matrix);
                }
                if (b0Var.f120508o.length < 2) {
                    return;
                }
                Path b16 = b((h.a0) b0Var);
                d(b0Var);
                b((h.l0) b0Var);
                a((h.l0) b0Var);
                boolean m3 = m();
                if (this.f120705d.f120741b) {
                    a(b0Var, b16);
                }
                if (this.f120705d.f120742c) {
                    b(b16);
                }
                a((h.m) b0Var);
                if (m3) {
                    c((h.l0) b0Var);
                }
            }
        }
    }

    public final void a(h.z0 z0Var, j jVar) {
        if (c()) {
            Iterator it = z0Var.f120612i.iterator();
            boolean z16 = true;
            while (it.hasNext()) {
                h.o0 o0Var = (h.o0) it.next();
                if (o0Var instanceof h.d1) {
                    jVar.a(a(((h.d1) o0Var).f120531c, z16, !it.hasNext()));
                } else {
                    a(o0Var, jVar);
                }
                z16 = false;
            }
        }
    }

    public final void a(h.o0 o0Var, j jVar) {
        float f16;
        float f17;
        float f18;
        h.f0.f d16;
        if (jVar.a((h.z0) o0Var)) {
            if (o0Var instanceof h.a1) {
                q();
                a((h.a1) o0Var);
                p();
                return;
            }
            if (o0Var instanceof h.w0) {
                d("TSpan render", new Object[0]);
                q();
                h.w0 w0Var = (h.w0) o0Var;
                a(this.f120705d, w0Var);
                if (c()) {
                    List list = w0Var.f120513o;
                    boolean z16 = list != null && list.size() > 0;
                    boolean z17 = jVar instanceof f;
                    float f19 = 0.0f;
                    if (z17) {
                        float b16 = !z16 ? ((f) jVar).f120733b : ((h.q) w0Var.f120513o.get(0)).b(this);
                        List list2 = w0Var.f120514p;
                        if (list2 != null && list2.size() != 0) {
                            f17 = ((h.q) w0Var.f120514p.get(0)).c(this);
                        } else {
                            f17 = ((f) jVar).f120734c;
                        }
                        List list3 = w0Var.f120515q;
                        f18 = (list3 == null || list3.size() == 0) ? 0.0f : ((h.q) w0Var.f120515q.get(0)).b(this);
                        List list4 = w0Var.f120516r;
                        if (list4 != null && list4.size() != 0) {
                            f19 = ((h.q) w0Var.f120516r.get(0)).c(this);
                        }
                        f16 = f19;
                        f19 = b16;
                    } else {
                        f16 = 0.0f;
                        f17 = 0.0f;
                        f18 = 0.0f;
                    }
                    if (z16 && (d16 = d()) != h.f0.f.Start) {
                        float a16 = a((h.z0) w0Var);
                        if (d16 == h.f0.f.Middle) {
                            a16 /= 2.0f;
                        }
                        f19 -= a16;
                    }
                    b((h.l0) w0Var.c());
                    if (z17) {
                        f fVar = (f) jVar;
                        fVar.f120733b = f19 + f18;
                        fVar.f120734c = f17 + f16;
                    }
                    boolean m3 = m();
                    a((h.z0) w0Var, jVar);
                    if (m3) {
                        c((h.l0) w0Var);
                    }
                }
                p();
                return;
            }
            if (o0Var instanceof h.v0) {
                q();
                h.v0 v0Var = (h.v0) o0Var;
                a(this.f120705d, v0Var);
                if (c()) {
                    b((h.l0) v0Var.c());
                    h.o0 c16 = o0Var.f120648a.c(v0Var.f120683o);
                    if (c16 == null || !(c16 instanceof h.z0)) {
                        e("Tref reference '%s' not found", v0Var.f120683o);
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        a((h.z0) c16, sb5);
                        if (sb5.length() > 0) {
                            jVar.a(sb5.toString());
                        }
                    }
                }
                p();
            }
        }
    }

    public final void a(h.a1 a1Var) {
        d("TextPath render", new Object[0]);
        a(this.f120705d, a1Var);
        if (c() && s()) {
            h.o0 c16 = a1Var.f120648a.c(a1Var.f120509o);
            if (c16 == null) {
                e("TextPath reference '%s' not found", a1Var.f120509o);
                return;
            }
            h.w wVar = (h.w) c16;
            Path a16 = new d(wVar.f120685o).a();
            Matrix matrix = wVar.f120637n;
            if (matrix != null) {
                a16.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(a16, false);
            h.q qVar = a1Var.f120510p;
            float a17 = qVar != null ? qVar.a(this, pathMeasure.getLength()) : 0.0f;
            h.f0.f d16 = d();
            if (d16 != h.f0.f.Start) {
                float a18 = a((h.z0) a1Var);
                if (d16 == h.f0.f.Middle) {
                    a18 /= 2.0f;
                }
                a17 -= a18;
            }
            b((h.l0) a1Var.c());
            boolean m3 = m();
            a((h.z0) a1Var, (j) new e(a16, a17, 0.0f));
            if (m3) {
                c((h.l0) a1Var);
            }
        }
    }

    public final float a(h.z0 z0Var) {
        k kVar = new k(this, null);
        a(z0Var, (j) kVar);
        return kVar.f120754b;
    }

    public final void a(h.z0 z0Var, StringBuilder sb5) {
        Iterator it = z0Var.f120612i.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            h.o0 o0Var = (h.o0) it.next();
            if (o0Var instanceof h.z0) {
                a((h.z0) o0Var, sb5);
            } else if (o0Var instanceof h.d1) {
                sb5.append(a(((h.d1) o0Var).f120531c, z16, !it.hasNext()));
            }
            z16 = false;
        }
    }

    public final String a(String str, boolean z16, boolean z17) {
        if (this.f120705d.f120747h) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll(RedTouch.NEWLINE_CHAR, "").replaceAll("\\t", " ");
        if (z16) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z17) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    public final void a(h.u0 u0Var, h.c cVar) {
        d("Symbol render", new Object[0]);
        if (cVar.f120519c == 0.0f || cVar.f120520d == 0.0f) {
            return;
        }
        com.tencent.luggage.wxa.a.f fVar = u0Var.f120658o;
        if (fVar == null) {
            fVar = com.tencent.luggage.wxa.a.f.f120471e;
        }
        a(this.f120705d, u0Var);
        h hVar = this.f120705d;
        hVar.f120745f = cVar;
        if (!hVar.f120740a.K.booleanValue()) {
            h.c cVar2 = this.f120705d.f120745f;
            b(cVar2.f120517a, cVar2.f120518b, cVar2.f120519c, cVar2.f120520d);
        }
        h.c cVar3 = u0Var.f120674p;
        if (cVar3 != null) {
            this.f120702a.concat(a(this.f120705d.f120745f, cVar3, fVar));
            this.f120705d.f120746g = u0Var.f120674p;
        } else {
            Canvas canvas = this.f120702a;
            h.c cVar4 = this.f120705d.f120745f;
            canvas.translate(cVar4.f120517a, cVar4.f120518b);
        }
        boolean m3 = m();
        a((h.k0) u0Var, true);
        if (m3) {
            c((h.l0) u0Var);
        }
        d(u0Var);
    }

    public final void a(h.p pVar) {
        h.q qVar;
        String str;
        d("Image render", new Object[0]);
        h.q qVar2 = pVar.f120653s;
        if (qVar2 == null || qVar2.c() || (qVar = pVar.f120654t) == null || qVar.c() || (str = pVar.f120650p) == null) {
            return;
        }
        com.tencent.luggage.wxa.a.f fVar = pVar.f120658o;
        if (fVar == null) {
            fVar = com.tencent.luggage.wxa.a.f.f120471e;
        }
        Bitmap a16 = a(str);
        if (a16 == null) {
            com.tencent.luggage.wxa.a.h.e();
            return;
        }
        h.c cVar = new h.c(0.0f, 0.0f, a16.getWidth(), a16.getHeight());
        a(this.f120705d, pVar);
        if (c() && s()) {
            Matrix matrix = pVar.f120655u;
            if (matrix != null) {
                this.f120702a.concat(matrix);
            }
            h.q qVar3 = pVar.f120651q;
            float b16 = qVar3 != null ? qVar3.b(this) : 0.0f;
            h.q qVar4 = pVar.f120652r;
            this.f120705d.f120745f = new h.c(b16, qVar4 != null ? qVar4.c(this) : 0.0f, pVar.f120653s.b(this), pVar.f120654t.b(this));
            if (!this.f120705d.f120740a.K.booleanValue()) {
                h.c cVar2 = this.f120705d.f120745f;
                b(cVar2.f120517a, cVar2.f120518b, cVar2.f120519c, cVar2.f120520d);
            }
            pVar.f120636h = this.f120705d.f120745f;
            d(pVar);
            a((h.l0) pVar);
            boolean m3 = m();
            r();
            this.f120702a.save();
            this.f120702a.concat(a(this.f120705d.f120745f, cVar, fVar));
            this.f120702a.drawBitmap(a16, 0.0f, 0.0f, new Paint(this.f120705d.f120740a.f120551b0 != h.f0.e.optimizeSpeed ? 2 : 0));
            this.f120702a.restore();
            if (m3) {
                c((h.l0) pVar);
            }
        }
    }

    public final Bitmap a(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e16) {
            Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e16);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0082, code lost:
    
        if (r12 != 8) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Matrix a(h.c cVar, h.c cVar2, com.tencent.luggage.wxa.a.f fVar) {
        float f16;
        float f17;
        Matrix matrix = new Matrix();
        if (fVar != null && fVar.a() != null) {
            float f18 = cVar.f120519c / cVar2.f120519c;
            float f19 = cVar.f120520d / cVar2.f120520d;
            float f26 = -cVar2.f120517a;
            float f27 = -cVar2.f120518b;
            if (fVar.equals(com.tencent.luggage.wxa.a.f.f120470d)) {
                matrix.preTranslate(cVar.f120517a, cVar.f120518b);
                matrix.preScale(f18, f19);
                matrix.preTranslate(f26, f27);
                return matrix;
            }
            float max = fVar.b() == f.b.slice ? Math.max(f18, f19) : Math.min(f18, f19);
            float f28 = cVar.f120519c / max;
            float f29 = cVar.f120520d / max;
            int[] iArr = a.f120710a;
            switch (iArr[fVar.a().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    f17 = (cVar2.f120519c - f28) / 2.0f;
                    break;
                case 4:
                case 5:
                case 6:
                    f17 = cVar2.f120519c - f28;
                    break;
            }
            f26 -= f17;
            int i3 = iArr[fVar.a().ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                            }
                        }
                    }
                }
                f16 = cVar2.f120520d - f29;
                f27 -= f16;
                matrix.preTranslate(cVar.f120517a, cVar.f120518b);
                matrix.preScale(max, max);
                matrix.preTranslate(f26, f27);
            }
            f16 = (cVar2.f120520d - f29) / 2.0f;
            f27 -= f16;
            matrix.preTranslate(cVar.f120517a, cVar.f120518b);
            matrix.preScale(max, max);
            matrix.preTranslate(f26, f27);
        }
        return matrix;
    }

    public final boolean a(h.f0 f0Var, long j3) {
        return (f0Var.f120548a & j3) != 0;
    }

    public final void a(h hVar, h.f0 f0Var) {
        if (a(f0Var, 4096L)) {
            hVar.f120740a.C = f0Var.C;
        }
        if (a(f0Var, 2048L)) {
            hVar.f120740a.f120562m = f0Var.f120562m;
        }
        if (a(f0Var, 1L)) {
            hVar.f120740a.f120550b = f0Var.f120550b;
            h.p0 p0Var = f0Var.f120550b;
            hVar.f120741b = (p0Var == null || p0Var == h.g.f120604c) ? false : true;
        }
        if (a(f0Var, 4L)) {
            hVar.f120740a.f120553d = f0Var.f120553d;
        }
        if (a(f0Var, 6149L)) {
            a(hVar, true, hVar.f120740a.f120550b);
        }
        if (a(f0Var, 2L)) {
            hVar.f120740a.f120552c = f0Var.f120552c;
        }
        if (a(f0Var, 8L)) {
            hVar.f120740a.f120554e = f0Var.f120554e;
            h.p0 p0Var2 = f0Var.f120554e;
            hVar.f120742c = (p0Var2 == null || p0Var2 == h.g.f120604c) ? false : true;
        }
        if (a(f0Var, 16L)) {
            hVar.f120740a.f120555f = f0Var.f120555f;
        }
        if (a(f0Var, 6168L)) {
            a(hVar, false, hVar.f120740a.f120554e);
        }
        if (a(f0Var, 34359738368L)) {
            hVar.f120740a.f120549a0 = f0Var.f120549a0;
        }
        if (a(f0Var, 32L)) {
            h.f0 f0Var2 = hVar.f120740a;
            h.q qVar = f0Var.f120556g;
            f0Var2.f120556g = qVar;
            hVar.f120744e.setStrokeWidth(qVar.a(this));
        }
        if (a(f0Var, 64L)) {
            hVar.f120740a.f120557h = f0Var.f120557h;
            int i3 = a.f120711b[f0Var.f120557h.ordinal()];
            if (i3 == 1) {
                hVar.f120744e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i3 == 2) {
                hVar.f120744e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i3 == 3) {
                hVar.f120744e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (a(f0Var, 128L)) {
            hVar.f120740a.f120558i = f0Var.f120558i;
            int i16 = a.f120712c[f0Var.f120558i.ordinal()];
            if (i16 == 1) {
                hVar.f120744e.setStrokeJoin(Paint.Join.MITER);
            } else if (i16 == 2) {
                hVar.f120744e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i16 == 3) {
                hVar.f120744e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (a(f0Var, 256L)) {
            hVar.f120740a.f120559j = f0Var.f120559j;
            hVar.f120744e.setStrokeMiter(f0Var.f120559j.floatValue());
        }
        if (a(f0Var, 512L)) {
            hVar.f120740a.f120560k = f0Var.f120560k;
        }
        if (a(f0Var, 1024L)) {
            hVar.f120740a.f120561l = f0Var.f120561l;
        }
        Typeface typeface = null;
        if (a(f0Var, 1536L)) {
            h.q[] qVarArr = hVar.f120740a.f120560k;
            if (qVarArr == null) {
                hVar.f120744e.setPathEffect(null);
            } else {
                int length = qVarArr.length;
                int i17 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i17];
                float f16 = 0.0f;
                for (int i18 = 0; i18 < i17; i18++) {
                    float a16 = hVar.f120740a.f120560k[i18 % length].a(this);
                    fArr[i18] = a16;
                    f16 += a16;
                }
                if (f16 == 0.0f) {
                    hVar.f120744e.setPathEffect(null);
                } else {
                    float a17 = hVar.f120740a.f120561l.a(this);
                    if (a17 < 0.0f) {
                        a17 = (a17 % f16) + f16;
                    }
                    hVar.f120744e.setPathEffect(new DashPathEffect(fArr, a17));
                }
            }
        }
        if (a(f0Var, 16384L)) {
            float f17 = f();
            hVar.f120740a.E = f0Var.E;
            hVar.f120743d.setTextSize(f0Var.E.a(this, f17));
            hVar.f120744e.setTextSize(f0Var.E.a(this, f17));
        }
        if (a(f0Var, 8192L)) {
            hVar.f120740a.D = f0Var.D;
        }
        if (a(f0Var, 32768L)) {
            if (f0Var.F.intValue() == -1 && hVar.f120740a.F.intValue() > 100) {
                h.f0 f0Var3 = hVar.f120740a;
                f0Var3.F = Integer.valueOf(f0Var3.F.intValue() - 100);
            } else if (f0Var.F.intValue() == 1 && hVar.f120740a.F.intValue() < 900) {
                h.f0 f0Var4 = hVar.f120740a;
                f0Var4.F = Integer.valueOf(f0Var4.F.intValue() + 100);
            } else {
                hVar.f120740a.F = f0Var.F;
            }
        }
        if (a(f0Var, 65536L)) {
            hVar.f120740a.G = f0Var.G;
        }
        if (a(f0Var, 106496L)) {
            if (hVar.f120740a.D != null && this.f120704c != null) {
                com.tencent.luggage.wxa.a.h.e();
                for (String str : hVar.f120740a.D) {
                    h.f0 f0Var5 = hVar.f120740a;
                    typeface = a(str, f0Var5.F, f0Var5.G);
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                h.f0 f0Var6 = hVar.f120740a;
                typeface = a(C.SERIF_NAME, f0Var6.F, f0Var6.G);
            }
            hVar.f120743d.setTypeface(typeface);
            hVar.f120744e.setTypeface(typeface);
        }
        if (a(f0Var, 131072L)) {
            hVar.f120740a.H = f0Var.H;
            Paint paint = hVar.f120743d;
            h.f0.g gVar = f0Var.H;
            h.f0.g gVar2 = h.f0.g.LineThrough;
            paint.setStrikeThruText(gVar == gVar2);
            Paint paint2 = hVar.f120743d;
            h.f0.g gVar3 = f0Var.H;
            h.f0.g gVar4 = h.f0.g.Underline;
            paint2.setUnderlineText(gVar3 == gVar4);
            hVar.f120744e.setStrikeThruText(f0Var.H == gVar2);
            hVar.f120744e.setUnderlineText(f0Var.H == gVar4);
        }
        if (a(f0Var, TPChannelLayout.TP_CH_TOP_SIDE_LEFT)) {
            hVar.f120740a.I = f0Var.I;
        }
        if (a(f0Var, 262144L)) {
            hVar.f120740a.J = f0Var.J;
        }
        if (a(f0Var, 524288L)) {
            hVar.f120740a.K = f0Var.K;
        }
        if (a(f0Var, 2097152L)) {
            hVar.f120740a.M = f0Var.M;
        }
        if (a(f0Var, 4194304L)) {
            hVar.f120740a.N = f0Var.N;
        }
        if (a(f0Var, VasBusiness.CHAT_FONT_SWITCH)) {
            hVar.f120740a.O = f0Var.O;
        }
        if (a(f0Var, 16777216L)) {
            hVar.f120740a.P = f0Var.P;
        }
        if (a(f0Var, 33554432L)) {
            hVar.f120740a.Q = f0Var.Q;
        }
        if (a(f0Var, 1048576L)) {
            hVar.f120740a.L = f0Var.L;
        }
        if (a(f0Var, VasBusiness.QWALLET)) {
            hVar.f120740a.T = f0Var.T;
        }
        if (a(f0Var, 536870912L)) {
            hVar.f120740a.U = f0Var.U;
        }
        if (a(f0Var, 1073741824L)) {
            hVar.f120740a.V = f0Var.V;
        }
        if (a(f0Var, 67108864L)) {
            hVar.f120740a.R = f0Var.R;
        }
        if (a(f0Var, 134217728L)) {
            hVar.f120740a.S = f0Var.S;
        }
        if (a(f0Var, 8589934592L)) {
            hVar.f120740a.Y = f0Var.Y;
        }
        if (a(f0Var, 17179869184L)) {
            hVar.f120740a.Z = f0Var.Z;
        }
        if (a(f0Var, TPChannelLayout.TP_CH_TOP_SIDE_RIGHT)) {
            hVar.f120740a.f120551b0 = f0Var.f120551b0;
        }
    }

    public final void a(h hVar, boolean z16, h.p0 p0Var) {
        int i3;
        float floatValue = (z16 ? hVar.f120740a.f120553d : hVar.f120740a.f120555f).floatValue();
        if (p0Var instanceof h.g) {
            i3 = ((h.g) p0Var).f120605a;
        } else if (!(p0Var instanceof h.C5979h)) {
            return;
        } else {
            i3 = hVar.f120740a.C.f120605a;
        }
        int a16 = a(i3, floatValue);
        if (z16) {
            hVar.f120743d.setColor(a16);
        } else {
            hVar.f120744e.setColor(a16);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
    
        if (r6.equals("monospace") == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Typeface a(String str, Integer num, h.f0.b bVar) {
        char c16 = 1;
        boolean z16 = bVar == h.f0.b.Italic;
        int i3 = num.intValue() > 500 ? z16 ? 3 : 1 : z16 ? 2 : 0;
        str.hashCode();
        switch (str.hashCode()) {
            case -1536685117:
                if (str.equals("sans-serif")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1431958525:
                break;
            case -1081737434:
                if (str.equals("fantasy")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 109326717:
                if (str.equals(C.SERIF_NAME)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1126973893:
                if (str.equals("cursive")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                return Typeface.create(Typeface.SANS_SERIF, i3);
            case 1:
                return Typeface.create(Typeface.MONOSPACE, i3);
            case 2:
                return Typeface.create(Typeface.SANS_SERIF, i3);
            case 3:
                return Typeface.create(Typeface.SERIF, i3);
            case 4:
                return Typeface.create(Typeface.SANS_SERIF, i3);
            default:
                return null;
        }
    }

    public static int a(int i3, float f16) {
        int i16 = 255;
        int round = Math.round(((i3 >> 24) & 255) * f16);
        if (round < 0) {
            i16 = 0;
        } else if (round <= 255) {
            i16 = round;
        }
        return (i3 & 16777215) | (i16 << 24);
    }

    public static double a(double d16) {
        if (d16 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d16 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d16);
    }

    public static float[] a(double d16, double d17) {
        int ceil = (int) Math.ceil((Math.abs(d17) * 2.0d) / 3.141592653589793d);
        double d18 = d17 / ceil;
        double d19 = d18 / 2.0d;
        double sin = (Math.sin(d19) * 1.3333333333333333d) / (Math.cos(d19) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i3 = 0;
        for (int i16 = 0; i16 < ceil; i16++) {
            double d26 = d16 + (i16 * d18);
            double cos = Math.cos(d26);
            double sin2 = Math.sin(d26);
            int i17 = i3 + 1;
            fArr[i3] = (float) (cos - (sin * sin2));
            int i18 = i17 + 1;
            fArr[i17] = (float) (sin2 + (cos * sin));
            d18 = d18;
            double d27 = d26 + d18;
            double cos2 = Math.cos(d27);
            double sin3 = Math.sin(d27);
            int i19 = i18 + 1;
            fArr[i18] = (float) ((sin * sin3) + cos2);
            int i26 = i19 + 1;
            fArr[i19] = (float) (sin3 - (sin * cos2));
            int i27 = i26 + 1;
            fArr[i26] = (float) cos2;
            i3 = i27 + 1;
            fArr[i27] = (float) sin3;
        }
        return fArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(h.m mVar) {
        h.s sVar;
        String str;
        h.s sVar2;
        String str2;
        h.s sVar3;
        List a16;
        int size;
        int i3;
        h.f0 f0Var = this.f120705d.f120740a;
        String str3 = f0Var.M;
        if (str3 == null && f0Var.N == null && f0Var.O == null) {
            return;
        }
        if (str3 != null) {
            h.o0 c16 = mVar.f120648a.c(str3);
            if (c16 != null) {
                sVar = (h.s) c16;
                str = this.f120705d.f120740a.N;
                if (str != null) {
                    h.o0 c17 = mVar.f120648a.c(str);
                    if (c17 != null) {
                        sVar2 = (h.s) c17;
                        str2 = this.f120705d.f120740a.O;
                        if (str2 != null) {
                            h.o0 c18 = mVar.f120648a.c(str2);
                            if (c18 != null) {
                                sVar3 = (h.s) c18;
                                if (!(mVar instanceof h.w)) {
                                    a16 = new b(((h.w) mVar).f120685o).a();
                                } else if (mVar instanceof h.r) {
                                    a16 = a((h.r) mVar);
                                } else {
                                    a16 = a((h.a0) mVar);
                                }
                                if (a16 == null && (size = a16.size()) != 0) {
                                    h.f0 f0Var2 = this.f120705d.f120740a;
                                    f0Var2.O = null;
                                    f0Var2.N = null;
                                    f0Var2.M = null;
                                    if (sVar != null) {
                                        a(sVar, (c) a16.get(0));
                                    }
                                    if (sVar2 != null && a16.size() > 2) {
                                        c cVar = (c) a16.get(0);
                                        c cVar2 = (c) a16.get(1);
                                        i3 = 1;
                                        while (i3 < size - 1) {
                                            i3++;
                                            c cVar3 = (c) a16.get(i3);
                                            cVar = cVar2.f120726e ? a(cVar, cVar2, cVar3) : cVar2;
                                            a(sVar2, cVar);
                                            cVar2 = cVar3;
                                        }
                                    }
                                    if (sVar3 == null) {
                                        a(sVar3, (c) a16.get(size - 1));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            e("Marker reference '%s' not found", this.f120705d.f120740a.O);
                        }
                        sVar3 = null;
                        if (!(mVar instanceof h.w)) {
                        }
                        if (a16 == null) {
                            return;
                        }
                        h.f0 f0Var22 = this.f120705d.f120740a;
                        f0Var22.O = null;
                        f0Var22.N = null;
                        f0Var22.M = null;
                        if (sVar != null) {
                        }
                        if (sVar2 != null) {
                            c cVar4 = (c) a16.get(0);
                            c cVar22 = (c) a16.get(1);
                            i3 = 1;
                            while (i3 < size - 1) {
                            }
                        }
                        if (sVar3 == null) {
                        }
                    } else {
                        e("Marker reference '%s' not found", this.f120705d.f120740a.N);
                    }
                }
                sVar2 = null;
                str2 = this.f120705d.f120740a.O;
                if (str2 != null) {
                }
                sVar3 = null;
                if (!(mVar instanceof h.w)) {
                }
                if (a16 == null) {
                }
            } else {
                e("Marker reference '%s' not found", this.f120705d.f120740a.M);
            }
        }
        sVar = null;
        str = this.f120705d.f120740a.N;
        if (str != null) {
        }
        sVar2 = null;
        str2 = this.f120705d.f120740a.O;
        if (str2 != null) {
        }
        sVar3 = null;
        if (!(mVar instanceof h.w)) {
        }
        if (a16 == null) {
        }
    }

    public final c a(c cVar, c cVar2, c cVar3) {
        float a16 = a(cVar2.f120724c, cVar2.f120725d, cVar2.f120722a - cVar.f120722a, cVar2.f120723b - cVar.f120723b);
        if (a16 == 0.0f) {
            a16 = a(cVar2.f120724c, cVar2.f120725d, cVar3.f120722a - cVar2.f120722a, cVar3.f120723b - cVar2.f120723b);
        }
        if (a16 > 0.0f) {
            return cVar2;
        }
        if (a16 == 0.0f && (cVar2.f120724c > 0.0f || cVar2.f120725d >= 0.0f)) {
            return cVar2;
        }
        cVar2.f120724c = -cVar2.f120724c;
        cVar2.f120725d = -cVar2.f120725d;
        return cVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ff, code lost:
    
        if (r7 != 8) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(h.s sVar, c cVar) {
        float f16;
        h.c cVar2;
        boolean m3;
        float f17;
        float f18;
        float f19;
        float min;
        q();
        Float f26 = sVar.f120673v;
        float f27 = 0.0f;
        if (f26 != null) {
            if (Float.isNaN(f26.floatValue())) {
                float f28 = cVar.f120724c;
                if (f28 != 0.0f || cVar.f120725d != 0.0f) {
                    f16 = (float) Math.toDegrees(Math.atan2(cVar.f120725d, f28));
                }
            } else {
                f16 = sVar.f120673v.floatValue();
            }
            float a16 = !sVar.f120668q ? 1.0f : this.f120705d.f120740a.f120556g.a(this.f120703b);
            this.f120705d = b((h.o0) sVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(cVar.f120722a, cVar.f120723b);
            matrix.preRotate(f16);
            matrix.preScale(a16, a16);
            h.q qVar = sVar.f120669r;
            float b16 = qVar == null ? qVar.b(this) : 0.0f;
            h.q qVar2 = sVar.f120670s;
            float c16 = qVar2 == null ? qVar2.c(this) : 0.0f;
            h.q qVar3 = sVar.f120671t;
            float b17 = qVar3 == null ? qVar3.b(this) : 3.0f;
            h.q qVar4 = sVar.f120672u;
            float c17 = qVar4 != null ? qVar4.c(this) : 3.0f;
            cVar2 = sVar.f120674p;
            if (cVar2 == null) {
                float f29 = b17 / cVar2.f120519c;
                float f36 = c17 / cVar2.f120520d;
                com.tencent.luggage.wxa.a.f fVar = sVar.f120658o;
                if (fVar == null) {
                    fVar = com.tencent.luggage.wxa.a.f.f120471e;
                }
                if (!fVar.equals(com.tencent.luggage.wxa.a.f.f120470d)) {
                    if (fVar.b() == f.b.slice) {
                        min = Math.max(f29, f36);
                    } else {
                        min = Math.min(f29, f36);
                    }
                    f29 = min;
                    f36 = f29;
                }
                matrix.preTranslate((-b16) * f29, (-c16) * f36);
                this.f120702a.concat(matrix);
                h.c cVar3 = sVar.f120674p;
                float f37 = cVar3.f120519c * f29;
                float f38 = cVar3.f120520d * f36;
                int[] iArr = a.f120710a;
                switch (iArr[fVar.a().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        f17 = (b17 - f37) / 2.0f;
                        f18 = 0.0f - f17;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        f17 = b17 - f37;
                        f18 = 0.0f - f17;
                        break;
                    default:
                        f18 = 0.0f;
                        break;
                }
                int i3 = iArr[fVar.a().ordinal()];
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 != 7) {
                                }
                            }
                        }
                    }
                    f19 = c17 - f38;
                    f27 = 0.0f - f19;
                    if (!this.f120705d.f120740a.K.booleanValue()) {
                        b(f18, f27, b17, c17);
                    }
                    matrix.reset();
                    matrix.preScale(f29, f36);
                    this.f120702a.concat(matrix);
                }
                f19 = (c17 - f38) / 2.0f;
                f27 = 0.0f - f19;
                if (!this.f120705d.f120740a.K.booleanValue()) {
                }
                matrix.reset();
                matrix.preScale(f29, f36);
                this.f120702a.concat(matrix);
            } else {
                matrix.preTranslate(-b16, -c16);
                this.f120702a.concat(matrix);
                if (!this.f120705d.f120740a.K.booleanValue()) {
                    b(0.0f, 0.0f, b17, c17);
                }
            }
            m3 = m();
            a((h.k0) sVar, false);
            if (m3) {
                c((h.l0) sVar);
            }
            p();
        }
        f16 = 0.0f;
        if (!sVar.f120668q) {
        }
        this.f120705d = b((h.o0) sVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(cVar.f120722a, cVar.f120723b);
        matrix2.preRotate(f16);
        matrix2.preScale(a16, a16);
        h.q qVar5 = sVar.f120669r;
        if (qVar5 == null) {
        }
        h.q qVar22 = sVar.f120670s;
        if (qVar22 == null) {
        }
        h.q qVar32 = sVar.f120671t;
        if (qVar32 == null) {
        }
        h.q qVar42 = sVar.f120672u;
        if (qVar42 != null) {
        }
        cVar2 = sVar.f120674p;
        if (cVar2 == null) {
        }
        m3 = m();
        a((h.k0) sVar, false);
        if (m3) {
        }
        p();
    }

    public final h a(h.o0 o0Var, h hVar) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (o0Var instanceof h.m0) {
                arrayList.add(0, (h.m0) o0Var);
            }
            Object obj = o0Var.f120649b;
            if (obj == null) {
                break;
            }
            o0Var = (h.o0) obj;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a(hVar, (h.m0) it.next());
        }
        h hVar2 = this.f120705d;
        hVar.f120746g = hVar2.f120746g;
        hVar.f120745f = hVar2.f120745f;
        return hVar;
    }

    public final void a(boolean z16, h.c cVar, h.v vVar) {
        h.o0 c16 = this.f120704c.c(vVar.f120681a);
        if (c16 == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z16 ? "Fill" : "Stroke";
            objArr[1] = vVar.f120681a;
            e("%s reference '%s' not found", objArr);
            h.p0 p0Var = vVar.f120682b;
            if (p0Var != null) {
                a(this.f120705d, z16, p0Var);
                return;
            } else if (z16) {
                this.f120705d.f120741b = false;
                return;
            } else {
                this.f120705d.f120742c = false;
                return;
            }
        }
        if (c16 instanceof h.n0) {
            a(z16, cVar, (h.n0) c16);
        } else if (c16 instanceof h.r0) {
            a(z16, cVar, (h.r0) c16);
        } else if (c16 instanceof h.d0) {
            a(z16, (h.d0) c16);
        }
    }

    public final void a(boolean z16, h.c cVar, h.n0 n0Var) {
        float a16;
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        int i3;
        String str = n0Var.f120631l;
        if (str != null) {
            a(n0Var, str);
        }
        Boolean bool = n0Var.f120628i;
        int i16 = 0;
        boolean z17 = bool != null && bool.booleanValue();
        Paint paint = z16 ? this.f120705d.f120743d : this.f120705d.f120744e;
        if (z17) {
            h.c h16 = h();
            h.q qVar = n0Var.f120644m;
            f16 = qVar != null ? qVar.b(this) : 0.0f;
            h.q qVar2 = n0Var.f120645n;
            a16 = qVar2 != null ? qVar2.c(this) : 0.0f;
            h.q qVar3 = n0Var.f120646o;
            f17 = qVar3 != null ? qVar3.b(this) : h16.f120519c;
            h.q qVar4 = n0Var.f120647p;
            if (qVar4 != null) {
                f27 = f17;
                f18 = f16;
                f26 = a16;
                f19 = qVar4.c(this);
            }
            f27 = f17;
            f18 = f16;
            f26 = a16;
            f19 = 0.0f;
        } else {
            h.q qVar5 = n0Var.f120644m;
            float a17 = qVar5 != null ? qVar5.a(this, 1.0f) : 0.0f;
            h.q qVar6 = n0Var.f120645n;
            a16 = qVar6 != null ? qVar6.a(this, 1.0f) : 0.0f;
            h.q qVar7 = n0Var.f120646o;
            float a18 = qVar7 != null ? qVar7.a(this, 1.0f) : 1.0f;
            h.q qVar8 = n0Var.f120647p;
            if (qVar8 != null) {
                float a19 = qVar8.a(this, 1.0f);
                f18 = a17;
                f19 = a19;
                f26 = a16;
                f27 = a18;
            } else {
                f16 = a17;
                f17 = a18;
                f27 = f17;
                f18 = f16;
                f26 = a16;
                f19 = 0.0f;
            }
        }
        q();
        this.f120705d = b(n0Var);
        Matrix matrix = new Matrix();
        if (!z17) {
            matrix.preTranslate(cVar.f120517a, cVar.f120518b);
            matrix.preScale(cVar.f120519c, cVar.f120520d);
        }
        Matrix matrix2 = n0Var.f120629j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = n0Var.f120627h.size();
        if (size == 0) {
            p();
            if (z16) {
                this.f120705d.f120741b = false;
                return;
            } else {
                this.f120705d.f120742c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator it = n0Var.f120627h.iterator();
        float f28 = -1.0f;
        while (it.hasNext()) {
            h.e0 e0Var = (h.e0) ((h.o0) it.next());
            Float f29 = e0Var.f120536h;
            float floatValue = f29 != null ? f29.floatValue() : 0.0f;
            if (i16 != 0 && floatValue < f28) {
                fArr[i16] = f28;
            } else {
                fArr[i16] = floatValue;
                f28 = floatValue;
            }
            q();
            a(this.f120705d, e0Var);
            h.f0 f0Var = this.f120705d.f120740a;
            h.g gVar = (h.g) f0Var.R;
            if (gVar == null) {
                gVar = h.g.f120603b;
            }
            iArr[i16] = a(gVar.f120605a, f0Var.S.floatValue());
            i16++;
            p();
        }
        if (f18 == f27 && f26 == f19) {
            i3 = 1;
        } else {
            i3 = 1;
            if (size != 1) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                h.l lVar = n0Var.f120630k;
                if (lVar != null) {
                    if (lVar == h.l.reflect) {
                        tileMode = Shader.TileMode.MIRROR;
                    } else if (lVar == h.l.repeat) {
                        tileMode = Shader.TileMode.REPEAT;
                    }
                }
                p();
                LinearGradient linearGradient = new LinearGradient(f18, f26, f27, f19, iArr, fArr, tileMode);
                linearGradient.setLocalMatrix(matrix);
                paint.setShader(linearGradient);
                paint.setAlpha(a(this.f120705d.f120740a.f120553d.floatValue()));
                return;
            }
        }
        p();
        paint.setColor(iArr[size - i3]);
    }

    public final void a(boolean z16, h.c cVar, h.r0 r0Var) {
        float f16;
        float f17;
        float f18;
        String str = r0Var.f120631l;
        if (str != null) {
            a(r0Var, str);
        }
        Boolean bool = r0Var.f120628i;
        int i3 = 0;
        boolean z17 = bool != null && bool.booleanValue();
        Paint paint = z16 ? this.f120705d.f120743d : this.f120705d.f120744e;
        if (z17) {
            h.q qVar = new h.q(50.0f, h.e1.percent);
            h.q qVar2 = r0Var.f120663m;
            float b16 = qVar2 != null ? qVar2.b(this) : qVar.b(this);
            h.q qVar3 = r0Var.f120664n;
            float c16 = qVar3 != null ? qVar3.c(this) : qVar.c(this);
            h.q qVar4 = r0Var.f120665o;
            f17 = qVar4 != null ? qVar4.a(this) : qVar.a(this);
            f16 = b16;
            f18 = c16;
        } else {
            h.q qVar5 = r0Var.f120663m;
            float a16 = qVar5 != null ? qVar5.a(this, 1.0f) : 0.5f;
            h.q qVar6 = r0Var.f120664n;
            float a17 = qVar6 != null ? qVar6.a(this, 1.0f) : 0.5f;
            h.q qVar7 = r0Var.f120665o;
            if (qVar7 != null) {
                f16 = a16;
                f17 = qVar7.a(this, 1.0f);
            } else {
                f16 = a16;
                f17 = 0.5f;
            }
            f18 = a17;
        }
        q();
        this.f120705d = b(r0Var);
        Matrix matrix = new Matrix();
        if (!z17) {
            matrix.preTranslate(cVar.f120517a, cVar.f120518b);
            matrix.preScale(cVar.f120519c, cVar.f120520d);
        }
        Matrix matrix2 = r0Var.f120629j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = r0Var.f120627h.size();
        if (size == 0) {
            p();
            if (z16) {
                this.f120705d.f120741b = false;
                return;
            } else {
                this.f120705d.f120742c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator it = r0Var.f120627h.iterator();
        float f19 = -1.0f;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h.e0 e0Var = (h.e0) ((h.o0) it.next());
            Float f26 = e0Var.f120536h;
            float floatValue = f26 != null ? f26.floatValue() : 0.0f;
            if (i3 != 0 && floatValue < f19) {
                fArr[i3] = f19;
            } else {
                fArr[i3] = floatValue;
                f19 = floatValue;
            }
            q();
            a(this.f120705d, e0Var);
            h.f0 f0Var = this.f120705d.f120740a;
            h.g gVar = (h.g) f0Var.R;
            if (gVar == null) {
                gVar = h.g.f120603b;
            }
            iArr[i3] = a(gVar.f120605a, f0Var.S.floatValue());
            i3++;
            p();
        }
        if (f17 != 0.0f && size != 1) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            h.l lVar = r0Var.f120630k;
            if (lVar != null) {
                if (lVar == h.l.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (lVar == h.l.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            p();
            RadialGradient radialGradient = new RadialGradient(f16, f18, f17, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            paint.setAlpha(a(this.f120705d.f120740a.f120553d.floatValue()));
            return;
        }
        p();
        paint.setColor(iArr[size - 1]);
    }

    public final void a(h.k kVar, String str) {
        h.o0 c16 = kVar.f120648a.c(str);
        if (c16 == null) {
            f("Gradient reference '%s' not found", str);
            return;
        }
        if (!(c16 instanceof h.k)) {
            e("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (c16 == kVar) {
            e("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        h.k kVar2 = (h.k) c16;
        if (kVar.f120628i == null) {
            kVar.f120628i = kVar2.f120628i;
        }
        if (kVar.f120629j == null) {
            kVar.f120629j = kVar2.f120629j;
        }
        if (kVar.f120630k == null) {
            kVar.f120630k = kVar2.f120630k;
        }
        if (kVar.f120627h.isEmpty()) {
            kVar.f120627h = kVar2.f120627h;
        }
        try {
            if (kVar instanceof h.n0) {
                a((h.n0) kVar, (h.n0) c16);
            } else {
                a((h.r0) kVar, (h.r0) c16);
            }
        } catch (ClassCastException unused) {
        }
        String str2 = kVar2.f120631l;
        if (str2 != null) {
            a(kVar, str2);
        }
    }

    public final void a(h.n0 n0Var, h.n0 n0Var2) {
        if (n0Var.f120644m == null) {
            n0Var.f120644m = n0Var2.f120644m;
        }
        if (n0Var.f120645n == null) {
            n0Var.f120645n = n0Var2.f120645n;
        }
        if (n0Var.f120646o == null) {
            n0Var.f120646o = n0Var2.f120646o;
        }
        if (n0Var.f120647p == null) {
            n0Var.f120647p = n0Var2.f120647p;
        }
    }

    public final void a(h.r0 r0Var, h.r0 r0Var2) {
        if (r0Var.f120663m == null) {
            r0Var.f120663m = r0Var2.f120663m;
        }
        if (r0Var.f120664n == null) {
            r0Var.f120664n = r0Var2.f120664n;
        }
        if (r0Var.f120665o == null) {
            r0Var.f120665o = r0Var2.f120665o;
        }
        if (r0Var.f120666p == null) {
            r0Var.f120666p = r0Var2.f120666p;
        }
        if (r0Var.f120667q == null) {
            r0Var.f120667q = r0Var2.f120667q;
        }
    }

    public final void a(boolean z16, h.d0 d0Var) {
        if (z16) {
            if (a(d0Var.f120640e, 2147483648L)) {
                h hVar = this.f120705d;
                h.f0 f0Var = hVar.f120740a;
                h.p0 p0Var = d0Var.f120640e.W;
                f0Var.f120550b = p0Var;
                hVar.f120741b = p0Var != null;
            }
            if (a(d0Var.f120640e, 4294967296L)) {
                this.f120705d.f120740a.f120553d = d0Var.f120640e.X;
            }
            if (a(d0Var.f120640e, 6442450944L)) {
                h hVar2 = this.f120705d;
                a(hVar2, z16, hVar2.f120740a.f120550b);
                return;
            }
            return;
        }
        if (a(d0Var.f120640e, 2147483648L)) {
            h hVar3 = this.f120705d;
            h.f0 f0Var2 = hVar3.f120740a;
            h.p0 p0Var2 = d0Var.f120640e.W;
            f0Var2.f120554e = p0Var2;
            hVar3.f120742c = p0Var2 != null;
        }
        if (a(d0Var.f120640e, 4294967296L)) {
            this.f120705d.f120740a.f120555f = d0Var.f120640e.X;
        }
        if (a(d0Var.f120640e, 6442450944L)) {
            h hVar4 = this.f120705d;
            a(hVar4, z16, hVar4.f120740a.f120554e);
        }
    }

    public final void a(h.l0 l0Var) {
        b(l0Var, l0Var.f120636h);
    }

    public final Path a(h.l0 l0Var, h.c cVar) {
        Path a16;
        h.o0 c16 = l0Var.f120648a.c(this.f120705d.f120740a.T);
        if (c16 == null) {
            e("ClipPath reference '%s' not found", this.f120705d.f120740a.T);
            return null;
        }
        h.f fVar = (h.f) c16;
        this.f120706e.push(this.f120705d);
        this.f120705d = b((h.o0) fVar);
        Boolean bool = fVar.f120547p;
        boolean z16 = bool == null || bool.booleanValue();
        Matrix matrix = new Matrix();
        if (!z16) {
            matrix.preTranslate(cVar.f120517a, cVar.f120518b);
            matrix.preScale(cVar.f120519c, cVar.f120520d);
        }
        Matrix matrix2 = fVar.f120643o;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (h.o0 o0Var : fVar.f120612i) {
            if ((o0Var instanceof h.l0) && (a16 = a((h.l0) o0Var, true)) != null) {
                path.op(a16, Path.Op.UNION);
            }
        }
        if (this.f120705d.f120740a.T != null) {
            if (fVar.f120636h == null) {
                fVar.f120636h = a(path);
            }
            Path a17 = a(fVar, fVar.f120636h);
            if (a17 != null) {
                path.op(a17, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.f120705d = (h) this.f120706e.pop();
        return path;
    }

    public final Path a(h.l0 l0Var, boolean z16) {
        Path a16;
        Path a17;
        this.f120706e.push(this.f120705d);
        h hVar = new h(this.f120705d);
        this.f120705d = hVar;
        a(hVar, l0Var);
        if (c() && s()) {
            if (l0Var instanceof h.f1) {
                if (!z16) {
                    e("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
                h.f1 f1Var = (h.f1) l0Var;
                h.o0 c16 = l0Var.f120648a.c(f1Var.f120598p);
                if (c16 == null) {
                    e("Use reference '%s' not found", f1Var.f120598p);
                    this.f120705d = (h) this.f120706e.pop();
                    return null;
                }
                if (!(c16 instanceof h.l0)) {
                    this.f120705d = (h) this.f120706e.pop();
                    return null;
                }
                a16 = a((h.l0) c16, false);
                if (a16 == null) {
                    return null;
                }
                if (f1Var.f120636h == null) {
                    f1Var.f120636h = a(a16);
                }
                Matrix matrix = f1Var.f120643o;
                if (matrix != null) {
                    a16.transform(matrix);
                }
            } else if (l0Var instanceof h.m) {
                h.m mVar = (h.m) l0Var;
                if (l0Var instanceof h.w) {
                    a16 = new d(((h.w) l0Var).f120685o).a();
                    if (l0Var.f120636h == null) {
                        l0Var.f120636h = a(a16);
                    }
                } else {
                    a16 = l0Var instanceof h.c0 ? a((h.c0) l0Var) : l0Var instanceof h.e ? a((h.e) l0Var) : l0Var instanceof h.j ? a((h.j) l0Var) : l0Var instanceof h.a0 ? b((h.a0) l0Var) : null;
                }
                if (a16 == null) {
                    return null;
                }
                if (mVar.f120636h == null) {
                    mVar.f120636h = a(a16);
                }
                Matrix matrix2 = mVar.f120637n;
                if (matrix2 != null) {
                    a16.transform(matrix2);
                }
                a16.setFillType(e());
            } else {
                if (!(l0Var instanceof h.x0)) {
                    e("Invalid %s element found in clipPath definition", l0Var.g());
                    return null;
                }
                h.x0 x0Var = (h.x0) l0Var;
                a16 = a(x0Var);
                if (a16 == null) {
                    return null;
                }
                Matrix matrix3 = x0Var.f120692s;
                if (matrix3 != null) {
                    a16.transform(matrix3);
                }
                a16.setFillType(e());
            }
            if (this.f120705d.f120740a.T != null && (a17 = a(l0Var, l0Var.f120636h)) != null) {
                a16.op(a17, Path.Op.INTERSECT);
            }
            this.f120705d = (h) this.f120706e.pop();
            return a16;
        }
        this.f120705d = (h) this.f120706e.pop();
        return null;
    }

    public final void a(h.o0 o0Var, boolean z16, Path path, Matrix matrix) {
        if (c()) {
            b();
            if (o0Var instanceof h.f1) {
                if (z16) {
                    a((h.f1) o0Var, path, matrix);
                } else {
                    e("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (o0Var instanceof h.w) {
                a((h.w) o0Var, path, matrix);
            } else if (o0Var instanceof h.x0) {
                a((h.x0) o0Var, path, matrix);
            } else if (o0Var instanceof h.m) {
                a((h.m) o0Var, path, matrix);
            } else {
                e("Invalid %s element found in clipPath definition", o0Var.toString());
            }
            a();
        }
    }

    public final void a() {
        this.f120702a.restore();
        this.f120705d = (h) this.f120706e.pop();
    }

    public final void a(h.w wVar, Path path, Matrix matrix) {
        a(this.f120705d, wVar);
        if (c() && s()) {
            Matrix matrix2 = wVar.f120637n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path a16 = new d(wVar.f120685o).a();
            if (wVar.f120636h == null) {
                wVar.f120636h = a(a16);
            }
            a((h.l0) wVar);
            path.setFillType(e());
            path.addPath(a16, matrix);
        }
    }

    public final void a(h.m mVar, Path path, Matrix matrix) {
        Path b16;
        a(this.f120705d, mVar);
        if (c() && s()) {
            Matrix matrix2 = mVar.f120637n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            if (mVar instanceof h.c0) {
                b16 = a((h.c0) mVar);
            } else if (mVar instanceof h.e) {
                b16 = a((h.e) mVar);
            } else if (mVar instanceof h.j) {
                b16 = a((h.j) mVar);
            } else if (!(mVar instanceof h.a0)) {
                return;
            } else {
                b16 = b((h.a0) mVar);
            }
            a((h.l0) mVar);
            path.setFillType(e());
            path.addPath(b16, matrix);
        }
    }

    public final void a(h.f1 f1Var, Path path, Matrix matrix) {
        a(this.f120705d, f1Var);
        if (c() && s()) {
            Matrix matrix2 = f1Var.f120643o;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            h.o0 c16 = f1Var.f120648a.c(f1Var.f120598p);
            if (c16 == null) {
                e("Use reference '%s' not found", f1Var.f120598p);
            } else {
                a((h.l0) f1Var);
                a(c16, false, path, matrix);
            }
        }
    }

    public final void a(h.x0 x0Var, Path path, Matrix matrix) {
        a(this.f120705d, x0Var);
        if (c()) {
            Matrix matrix2 = x0Var.f120692s;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            List list = x0Var.f120513o;
            float f16 = 0.0f;
            float b16 = (list == null || list.size() == 0) ? 0.0f : ((h.q) x0Var.f120513o.get(0)).b(this);
            List list2 = x0Var.f120514p;
            float c16 = (list2 == null || list2.size() == 0) ? 0.0f : ((h.q) x0Var.f120514p.get(0)).c(this);
            List list3 = x0Var.f120515q;
            float b17 = (list3 == null || list3.size() == 0) ? 0.0f : ((h.q) x0Var.f120515q.get(0)).b(this);
            List list4 = x0Var.f120516r;
            if (list4 != null && list4.size() != 0) {
                f16 = ((h.q) x0Var.f120516r.get(0)).c(this);
            }
            if (this.f120705d.f120740a.J != h.f0.f.Start) {
                float a16 = a((h.z0) x0Var);
                if (this.f120705d.f120740a.J == h.f0.f.Middle) {
                    a16 /= 2.0f;
                }
                b16 -= a16;
            }
            if (x0Var.f120636h == null) {
                C5980i c5980i = new C5980i(b16, c16);
                a((h.z0) x0Var, (j) c5980i);
                RectF rectF = c5980i.f120751d;
                x0Var.f120636h = new h.c(rectF.left, rectF.top, rectF.width(), c5980i.f120751d.height());
            }
            a((h.l0) x0Var);
            Path path2 = new Path();
            a((h.z0) x0Var, new g(b16 + b17, c16 + f16, path2));
            path.setFillType(e());
            path.addPath(path2, matrix);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Path a(h.c0 c0Var) {
        float b16;
        float c16;
        float min;
        float b17;
        float c17;
        float f16;
        float f17;
        Path path;
        Path path2;
        h.q qVar = c0Var.f120525s;
        if (qVar == null && c0Var.f120526t == null) {
            c16 = 0.0f;
        } else if (qVar == null) {
            c16 = c0Var.f120526t.c(this);
        } else if (c0Var.f120526t == null) {
            c16 = qVar.b(this);
        } else {
            b16 = qVar.b(this);
            c16 = c0Var.f120526t.c(this);
            min = Math.min(b16, c0Var.f120523q.b(this) / 2.0f);
            float min2 = Math.min(c16, c0Var.f120524r.c(this) / 2.0f);
            h.q qVar2 = c0Var.f120521o;
            b17 = qVar2 == null ? qVar2.b(this) : 0.0f;
            h.q qVar3 = c0Var.f120522p;
            c17 = qVar3 == null ? qVar3.c(this) : 0.0f;
            float b18 = c0Var.f120523q.b(this);
            float c18 = c0Var.f120524r.c(this);
            if (c0Var.f120636h == null) {
                c0Var.f120636h = new h.c(b17, c17, b18, c18);
            }
            f16 = b17 + b18;
            f17 = c17 + c18;
            path = new Path();
            if (min == 0.0f && min2 != 0.0f) {
                float f18 = min * 0.5522848f;
                float f19 = 0.5522848f * min2;
                float f26 = c17 + min2;
                path.moveTo(b17, f26);
                float f27 = f26 - f19;
                float f28 = b17 + min;
                float f29 = f28 - f18;
                path.cubicTo(b17, f27, f29, c17, f28, c17);
                float f36 = f16 - min;
                path.lineTo(f36, c17);
                float f37 = f36 + f18;
                path.cubicTo(f37, c17, f16, f27, f16, f26);
                float f38 = f17 - min2;
                path.lineTo(f16, f38);
                float f39 = f38 + f19;
                path2 = path;
                path.cubicTo(f16, f39, f37, f17, f36, f17);
                path2.lineTo(f28, f17);
                path2.cubicTo(f29, f17, b17, f39, b17, f38);
                path2.lineTo(b17, f26);
            } else {
                path2 = path;
                path2.moveTo(b17, c17);
                path2.lineTo(f16, c17);
                path2.lineTo(f16, f17);
                path2.lineTo(b17, f17);
                path2.lineTo(b17, c17);
            }
            path2.close();
            return path2;
        }
        b16 = c16;
        min = Math.min(b16, c0Var.f120523q.b(this) / 2.0f);
        float min22 = Math.min(c16, c0Var.f120524r.c(this) / 2.0f);
        h.q qVar22 = c0Var.f120521o;
        if (qVar22 == null) {
        }
        h.q qVar32 = c0Var.f120522p;
        if (qVar32 == null) {
        }
        float b182 = c0Var.f120523q.b(this);
        float c182 = c0Var.f120524r.c(this);
        if (c0Var.f120636h == null) {
        }
        f16 = b17 + b182;
        f17 = c17 + c182;
        path = new Path();
        if (min == 0.0f) {
        }
        path2 = path;
        path2.moveTo(b17, c17);
        path2.lineTo(f16, c17);
        path2.lineTo(f16, f17);
        path2.lineTo(b17, f17);
        path2.lineTo(b17, c17);
        path2.close();
        return path2;
    }

    public final Path a(h.e eVar) {
        h.q qVar = eVar.f120533o;
        float b16 = qVar != null ? qVar.b(this) : 0.0f;
        h.q qVar2 = eVar.f120534p;
        float c16 = qVar2 != null ? qVar2.c(this) : 0.0f;
        float a16 = eVar.f120535q.a(this);
        float f16 = b16 - a16;
        float f17 = c16 - a16;
        float f18 = b16 + a16;
        float f19 = c16 + a16;
        if (eVar.f120636h == null) {
            float f26 = 2.0f * a16;
            eVar.f120636h = new h.c(f16, f17, f26, f26);
        }
        float f27 = 0.5522848f * a16;
        Path path = new Path();
        path.moveTo(b16, f17);
        float f28 = b16 + f27;
        float f29 = c16 - f27;
        path.cubicTo(f28, f17, f18, f29, f18, c16);
        float f36 = c16 + f27;
        path.cubicTo(f18, f36, f28, f19, b16, f19);
        float f37 = b16 - f27;
        path.cubicTo(f37, f19, f16, f36, f16, c16);
        path.cubicTo(f16, f29, f37, f17, b16, f17);
        path.close();
        return path;
    }

    public final Path a(h.j jVar) {
        h.q qVar = jVar.f120618o;
        float b16 = qVar != null ? qVar.b(this) : 0.0f;
        h.q qVar2 = jVar.f120619p;
        float c16 = qVar2 != null ? qVar2.c(this) : 0.0f;
        float b17 = jVar.f120620q.b(this);
        float c17 = jVar.f120621r.c(this);
        float f16 = b16 - b17;
        float f17 = c16 - c17;
        float f18 = b16 + b17;
        float f19 = c16 + c17;
        if (jVar.f120636h == null) {
            jVar.f120636h = new h.c(f16, f17, b17 * 2.0f, 2.0f * c17);
        }
        float f26 = b17 * 0.5522848f;
        float f27 = 0.5522848f * c17;
        Path path = new Path();
        path.moveTo(b16, f17);
        float f28 = b16 + f26;
        float f29 = c16 - f27;
        path.cubicTo(f28, f17, f18, f29, f18, c16);
        float f36 = f27 + c16;
        path.cubicTo(f18, f36, f28, f19, b16, f19);
        float f37 = b16 - f26;
        path.cubicTo(f37, f19, f16, f36, f16, c16);
        path.cubicTo(f16, f29, f37, f17, b16, f17);
        path.close();
        return path;
    }

    public final Path a(h.x0 x0Var) {
        List list = x0Var.f120513o;
        float f16 = 0.0f;
        float b16 = (list == null || list.size() == 0) ? 0.0f : ((h.q) x0Var.f120513o.get(0)).b(this);
        List list2 = x0Var.f120514p;
        float c16 = (list2 == null || list2.size() == 0) ? 0.0f : ((h.q) x0Var.f120514p.get(0)).c(this);
        List list3 = x0Var.f120515q;
        float b17 = (list3 == null || list3.size() == 0) ? 0.0f : ((h.q) x0Var.f120515q.get(0)).b(this);
        List list4 = x0Var.f120516r;
        if (list4 != null && list4.size() != 0) {
            f16 = ((h.q) x0Var.f120516r.get(0)).c(this);
        }
        if (this.f120705d.f120740a.J != h.f0.f.Start) {
            float a16 = a((h.z0) x0Var);
            if (this.f120705d.f120740a.J == h.f0.f.Middle) {
                a16 /= 2.0f;
            }
            b16 -= a16;
        }
        if (x0Var.f120636h == null) {
            C5980i c5980i = new C5980i(b16, c16);
            a((h.z0) x0Var, (j) c5980i);
            RectF rectF = c5980i.f120751d;
            x0Var.f120636h = new h.c(rectF.left, rectF.top, rectF.width(), c5980i.f120751d.height());
        }
        Path path = new Path();
        a((h.z0) x0Var, new g(b16 + b17, c16 + f16, path));
        return path;
    }

    public final void a(h.l0 l0Var, Path path, h.z zVar) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        Boolean bool = zVar.f120693q;
        boolean z16 = bool != null && bool.booleanValue();
        String str = zVar.f120700x;
        if (str != null) {
            a(zVar, str);
        }
        if (z16) {
            h.q qVar = zVar.f120696t;
            f16 = qVar != null ? qVar.b(this) : 0.0f;
            h.q qVar2 = zVar.f120697u;
            f18 = qVar2 != null ? qVar2.c(this) : 0.0f;
            h.q qVar3 = zVar.f120698v;
            f19 = qVar3 != null ? qVar3.b(this) : 0.0f;
            h.q qVar4 = zVar.f120699w;
            f17 = qVar4 != null ? qVar4.c(this) : 0.0f;
        } else {
            h.q qVar5 = zVar.f120696t;
            float a16 = qVar5 != null ? qVar5.a(this, 1.0f) : 0.0f;
            h.q qVar6 = zVar.f120697u;
            float a17 = qVar6 != null ? qVar6.a(this, 1.0f) : 0.0f;
            h.q qVar7 = zVar.f120698v;
            float a18 = qVar7 != null ? qVar7.a(this, 1.0f) : 0.0f;
            h.q qVar8 = zVar.f120699w;
            float a19 = qVar8 != null ? qVar8.a(this, 1.0f) : 0.0f;
            h.c cVar = l0Var.f120636h;
            float f27 = cVar.f120517a;
            float f28 = cVar.f120519c;
            f16 = (a16 * f28) + f27;
            float f29 = cVar.f120518b;
            float f36 = cVar.f120520d;
            float f37 = a18 * f28;
            f17 = a19 * f36;
            f18 = (a17 * f36) + f29;
            f19 = f37;
        }
        if (f19 == 0.0f || f17 == 0.0f) {
            return;
        }
        com.tencent.luggage.wxa.a.f fVar = zVar.f120658o;
        if (fVar == null) {
            fVar = com.tencent.luggage.wxa.a.f.f120471e;
        }
        q();
        this.f120702a.clipPath(path);
        h hVar = new h();
        a(hVar, h.f0.a());
        hVar.f120740a.K = Boolean.FALSE;
        this.f120705d = a(zVar, hVar);
        h.c cVar2 = l0Var.f120636h;
        Matrix matrix = zVar.f120695s;
        if (matrix != null) {
            this.f120702a.concat(matrix);
            Matrix matrix2 = new Matrix();
            if (zVar.f120695s.invert(matrix2)) {
                h.c cVar3 = l0Var.f120636h;
                h.c cVar4 = l0Var.f120636h;
                h.c cVar5 = l0Var.f120636h;
                float[] fArr = {cVar3.f120517a, cVar3.f120518b, cVar3.a(), cVar4.f120518b, cVar4.a(), l0Var.f120636h.b(), cVar5.f120517a, cVar5.b()};
                matrix2.mapPoints(fArr);
                float f38 = fArr[0];
                float f39 = fArr[1];
                RectF rectF = new RectF(f38, f39, f38, f39);
                for (int i3 = 2; i3 <= 6; i3 += 2) {
                    float f46 = fArr[i3];
                    if (f46 < rectF.left) {
                        rectF.left = f46;
                    }
                    if (f46 > rectF.right) {
                        rectF.right = f46;
                    }
                    float f47 = fArr[i3 + 1];
                    if (f47 < rectF.top) {
                        rectF.top = f47;
                    }
                    if (f47 > rectF.bottom) {
                        rectF.bottom = f47;
                    }
                }
                float f48 = rectF.left;
                float f49 = rectF.top;
                cVar2 = new h.c(f48, f49, rectF.right - f48, rectF.bottom - f49);
            }
        }
        float floor = f16 + (((float) Math.floor((cVar2.f120517a - f16) / f19)) * f19);
        float a26 = cVar2.a();
        float b16 = cVar2.b();
        h.c cVar6 = new h.c(0.0f, 0.0f, f19, f17);
        boolean m3 = m();
        for (float floor2 = f18 + (((float) Math.floor((cVar2.f120518b - f18) / f17)) * f17); floor2 < b16; floor2 += f17) {
            float f56 = floor;
            while (f56 < a26) {
                cVar6.f120517a = f56;
                cVar6.f120518b = floor2;
                q();
                if (this.f120705d.f120740a.K.booleanValue()) {
                    f26 = floor;
                } else {
                    f26 = floor;
                    b(cVar6.f120517a, cVar6.f120518b, cVar6.f120519c, cVar6.f120520d);
                }
                h.c cVar7 = zVar.f120674p;
                if (cVar7 != null) {
                    this.f120702a.concat(a(cVar6, cVar7, fVar));
                } else {
                    Boolean bool2 = zVar.f120694r;
                    boolean z17 = bool2 == null || bool2.booleanValue();
                    this.f120702a.translate(f56, floor2);
                    if (!z17) {
                        Canvas canvas = this.f120702a;
                        h.c cVar8 = l0Var.f120636h;
                        canvas.scale(cVar8.f120519c, cVar8.f120520d);
                    }
                }
                Iterator it = zVar.f120612i.iterator();
                while (it.hasNext()) {
                    c((h.o0) it.next());
                }
                p();
                f56 += f19;
                floor = f26;
            }
        }
        if (m3) {
            c((h.l0) zVar);
        }
        p();
    }

    public final void a(h.z zVar, String str) {
        h.o0 c16 = zVar.f120648a.c(str);
        if (c16 == null) {
            f("Pattern reference '%s' not found", str);
            return;
        }
        if (!(c16 instanceof h.z)) {
            e("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (c16 == zVar) {
            e("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        h.z zVar2 = (h.z) c16;
        if (zVar.f120693q == null) {
            zVar.f120693q = zVar2.f120693q;
        }
        if (zVar.f120694r == null) {
            zVar.f120694r = zVar2.f120694r;
        }
        if (zVar.f120695s == null) {
            zVar.f120695s = zVar2.f120695s;
        }
        if (zVar.f120696t == null) {
            zVar.f120696t = zVar2.f120696t;
        }
        if (zVar.f120697u == null) {
            zVar.f120697u = zVar2.f120697u;
        }
        if (zVar.f120698v == null) {
            zVar.f120698v = zVar2.f120698v;
        }
        if (zVar.f120699w == null) {
            zVar.f120699w = zVar2.f120699w;
        }
        if (zVar.f120612i.isEmpty()) {
            zVar.f120612i = zVar2.f120612i;
        }
        if (zVar.f120674p == null) {
            zVar.f120674p = zVar2.f120674p;
        }
        if (zVar.f120658o == null) {
            zVar.f120658o = zVar2.f120658o;
        }
        String str2 = zVar2.f120700x;
        if (str2 != null) {
            a(zVar, str2);
        }
    }

    public final void a(h.t tVar, h.l0 l0Var, h.c cVar) {
        float f16;
        float f17;
        d("Mask render", new Object[0]);
        Boolean bool = tVar.f120675o;
        boolean z16 = true;
        if (bool != null && bool.booleanValue()) {
            h.q qVar = tVar.f120679s;
            f16 = qVar != null ? qVar.b(this) : cVar.f120519c;
            h.q qVar2 = tVar.f120680t;
            f17 = qVar2 != null ? qVar2.c(this) : cVar.f120520d;
        } else {
            h.q qVar3 = tVar.f120679s;
            float a16 = qVar3 != null ? qVar3.a(this, 1.0f) : 1.2f;
            h.q qVar4 = tVar.f120680t;
            float a17 = qVar4 != null ? qVar4.a(this, 1.0f) : 1.2f;
            f16 = a16 * cVar.f120519c;
            f17 = a17 * cVar.f120520d;
        }
        if (f16 == 0.0f || f17 == 0.0f) {
            return;
        }
        q();
        h b16 = b((h.o0) tVar);
        this.f120705d = b16;
        b16.f120740a.f120562m = Float.valueOf(1.0f);
        boolean m3 = m();
        this.f120702a.save();
        Boolean bool2 = tVar.f120676p;
        if (bool2 != null && !bool2.booleanValue()) {
            z16 = false;
        }
        if (!z16) {
            this.f120702a.translate(cVar.f120517a, cVar.f120518b);
            this.f120702a.scale(cVar.f120519c, cVar.f120520d);
        }
        a((h.k0) tVar, false);
        this.f120702a.restore();
        if (m3) {
            d(l0Var, cVar);
        }
        p();
    }
}
