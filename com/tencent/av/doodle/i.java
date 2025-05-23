package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.av.business.manager.magicface.MagicfaceDataPendantJason;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.io.BufferedReader;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i {
    private boolean A;
    private int B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private float K;
    private float L;
    private float M;
    private float N;
    public float O;
    public float P;
    private float Q;
    private float R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private PathMeasure X;
    float[] Y;
    float[] Z;

    /* renamed from: a, reason: collision with root package name */
    private d f73634a;

    /* renamed from: b, reason: collision with root package name */
    private e f73635b;

    /* renamed from: c, reason: collision with root package name */
    private d f73636c;

    /* renamed from: d, reason: collision with root package name */
    private e f73637d;

    /* renamed from: e, reason: collision with root package name */
    private e f73638e;

    /* renamed from: f, reason: collision with root package name */
    private e f73639f;

    /* renamed from: g, reason: collision with root package name */
    private e f73640g;

    /* renamed from: h, reason: collision with root package name */
    private e f73641h;

    /* renamed from: i, reason: collision with root package name */
    private e f73642i;

    /* renamed from: j, reason: collision with root package name */
    private e f73643j;

    /* renamed from: k, reason: collision with root package name */
    private e f73644k;

    /* renamed from: l, reason: collision with root package name */
    private e f73645l;

    /* renamed from: m, reason: collision with root package name */
    private a f73646m;

    /* renamed from: n, reason: collision with root package name */
    private d f73647n;

    /* renamed from: o, reason: collision with root package name */
    private d f73648o;

    /* renamed from: p, reason: collision with root package name */
    private e f73649p;

    /* renamed from: q, reason: collision with root package name */
    private e f73650q;

    /* renamed from: r, reason: collision with root package name */
    private h f73651r;

    /* renamed from: s, reason: collision with root package name */
    private float f73652s;

    /* renamed from: t, reason: collision with root package name */
    private BitmapDrawable[] f73653t;

    /* renamed from: u, reason: collision with root package name */
    private b[] f73654u;

    /* renamed from: v, reason: collision with root package name */
    private int f73655v;

    /* renamed from: w, reason: collision with root package name */
    private int f73656w;

    /* renamed from: x, reason: collision with root package name */
    private String f73657x;

    /* renamed from: y, reason: collision with root package name */
    private int f73658y;

    /* renamed from: z, reason: collision with root package name */
    private boolean[] f73659z;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends c {

        /* renamed from: e, reason: collision with root package name */
        private static float[] f73660e = new float[4];

        /* renamed from: c, reason: collision with root package name */
        private float[] f73661c = {1.0f, 1.0f, 1.0f};

        /* renamed from: d, reason: collision with root package name */
        float[] f73662d = {0.0f};

        public a() {
            this.f73690b = true;
        }

        @Override // com.tencent.av.doodle.i.c
        public void a(BufferedReader bufferedReader) throws IOException {
            super.a(bufferedReader);
            if (!this.f73689a) {
                return;
            }
            this.f73661c = new float[i.j(bufferedReader, "colorsCount")];
            int i3 = 0;
            int i16 = 0;
            while (true) {
                float[] fArr = this.f73661c;
                if (i16 >= fArr.length) {
                    break;
                }
                fArr[i16] = i.i(bufferedReader, NodeProps.COLORS + i16);
                i16++;
            }
            this.f73662d = new float[i.j(bufferedReader, "timelineCount")];
            while (true) {
                float[] fArr2 = this.f73662d;
                if (i3 < fArr2.length) {
                    fArr2[i3] = i.i(bufferedReader, "timeline" + i3);
                    i3++;
                } else {
                    return;
                }
            }
        }

        public float[] c(float f16) {
            float[] fArr = this.f73662d;
            int length = fArr.length;
            int i3 = 0;
            int i16 = 1;
            while (true) {
                if (i16 < length) {
                    if (fArr[i16] > f16) {
                        break;
                    }
                    i3 = i16;
                    i16++;
                } else {
                    i16 = -1;
                    break;
                }
            }
            float f17 = fArr[i3];
            int i17 = i3 * 3;
            float[] fArr2 = this.f73661c;
            float f18 = fArr2[i17];
            float f19 = fArr2[i17 + 1];
            float f26 = fArr2[i17 + 2];
            if (i16 == -1) {
                float[] fArr3 = f73660e;
                fArr3[0] = f18;
                fArr3[1] = f19;
                fArr3[2] = f26;
                return fArr3;
            }
            float f27 = (f16 - f17) / (fArr[i16] - f17);
            int i18 = i16 * 3;
            float[] fArr4 = f73660e;
            fArr4[0] = f18 + ((fArr2[i18] - f18) * f27);
            fArr4[1] = f19 + ((fArr2[i18 + 1] - f19) * f27);
            fArr4[2] = f26 + ((fArr2[i18 + 2] - f26) * f27);
            return fArr4;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b extends BitmapDrawable {
        private float A;
        private Matrix B;

        /* renamed from: a, reason: collision with root package name */
        protected int f73663a;

        /* renamed from: b, reason: collision with root package name */
        protected int f73664b;

        /* renamed from: c, reason: collision with root package name */
        protected float f73665c;

        /* renamed from: d, reason: collision with root package name */
        protected float f73666d;

        /* renamed from: e, reason: collision with root package name */
        protected float f73667e;

        /* renamed from: f, reason: collision with root package name */
        protected float f73668f;

        /* renamed from: g, reason: collision with root package name */
        protected float f73669g;

        /* renamed from: h, reason: collision with root package name */
        protected float f73670h;

        /* renamed from: i, reason: collision with root package name */
        protected float f73671i;

        /* renamed from: j, reason: collision with root package name */
        protected float f73672j;

        /* renamed from: k, reason: collision with root package name */
        protected float f73673k;

        /* renamed from: l, reason: collision with root package name */
        protected float f73674l;

        /* renamed from: m, reason: collision with root package name */
        protected float f73675m;

        /* renamed from: n, reason: collision with root package name */
        protected float f73676n;

        /* renamed from: o, reason: collision with root package name */
        protected float f73677o;

        /* renamed from: p, reason: collision with root package name */
        protected float f73678p;

        /* renamed from: q, reason: collision with root package name */
        protected float f73679q;

        /* renamed from: r, reason: collision with root package name */
        protected float f73680r;

        /* renamed from: s, reason: collision with root package name */
        protected float[] f73681s;

        /* renamed from: t, reason: collision with root package name */
        private float f73682t;

        /* renamed from: u, reason: collision with root package name */
        private float f73683u;

        /* renamed from: v, reason: collision with root package name */
        private float f73684v;

        /* renamed from: w, reason: collision with root package name */
        private float f73685w;

        /* renamed from: x, reason: collision with root package name */
        private float f73686x;

        /* renamed from: y, reason: collision with root package name */
        private float f73687y;

        /* renamed from: z, reason: collision with root package name */
        private float f73688z;

        public b(BitmapDrawable bitmapDrawable) {
            super(bitmapDrawable.getBitmap());
            this.f73682t = 0.0f;
            this.f73683u = 0.0f;
            this.f73684v = 0.0f;
            this.f73685w = 1.0f;
            this.f73686x = 0.0f;
            this.f73687y = 0.0f;
            this.f73688z = 0.0f;
            this.A = 0.0f;
            this.B = new Matrix();
        }

        private void f() {
            this.B.reset();
            this.B.preRotate(this.f73684v, this.f73682t, this.f73683u);
            Matrix matrix = this.B;
            float f16 = this.f73685w;
            matrix.preScale(f16, f16, this.f73682t, this.f73683u);
        }

        public void a(float f16, float f17, float f18, float f19) {
            Rect bounds = getBounds();
            Rect rect = new Rect();
            this.f73686x = f16;
            this.f73687y = f17;
            this.f73688z = f18;
            this.A = f19;
            rect.left = (int) f16;
            rect.top = (int) f17;
            rect.right = (int) (f16 + f18);
            rect.bottom = (int) (f17 + f19);
            if (!bounds.equals(rect)) {
                setBounds(rect);
            }
        }

        public void b(float f16, float f17, float f18, float f19) {
            setColorFilter(Color.argb(255, (int) (f16 * 255.0f), (int) (f17 * 255.0f), (int) (f18 * 255.0f)), PorterDuff.Mode.SRC_ATOP);
            setAlpha((int) (f19 * 255.0f));
        }

        public void c(float f16) {
            if (this.f73684v != f16) {
                this.f73684v = f16;
                f();
            }
        }

        public void d(float f16) {
            if (this.f73685w != f16) {
                this.f73685w = f16;
                f();
            }
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.save();
            canvas.concat(this.B);
            super.draw(canvas);
            canvas.restore();
        }

        public void e(float f16, float f17) {
            a(this.f73686x + f16, this.f73687y + f17, this.f73688z, this.A);
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i3, int i16, int i17, int i18) {
            boolean z16;
            super.setBounds(i3, i16, i17, i18);
            float f16 = (i3 + i17) / 2;
            float f17 = (i16 + i18) / 2;
            boolean z17 = true;
            if (this.f73682t != f16) {
                this.f73682t = f16;
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.f73683u != f17) {
                this.f73683u = f17;
            } else {
                z17 = z16;
            }
            if (z17) {
                f();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f73689a;

        /* renamed from: b, reason: collision with root package name */
        boolean f73690b;

        public void a(BufferedReader bufferedReader) throws IOException {
            if (!this.f73690b) {
                this.f73689a = i.h(bufferedReader, "active");
            } else {
                this.f73689a = true;
            }
        }

        public void b(boolean z16) {
            this.f73690b = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d extends c {

        /* renamed from: c, reason: collision with root package name */
        private float f73691c;

        /* renamed from: d, reason: collision with root package name */
        private float f73692d;

        @Override // com.tencent.av.doodle.i.c
        public void a(BufferedReader bufferedReader) throws IOException {
            super.a(bufferedReader);
            if (!this.f73689a) {
                return;
            }
            this.f73691c = i.i(bufferedReader, "lowMin");
            this.f73692d = i.i(bufferedReader, "lowMax");
        }

        public float c() {
            float f16 = this.f73691c;
            return f16 + ((this.f73692d - f16) * com.tencent.av.doodle.e.e());
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class e extends d {

        /* renamed from: e, reason: collision with root package name */
        private float[] f73693e = {1.0f};

        /* renamed from: f, reason: collision with root package name */
        float[] f73694f = {0.0f};

        /* renamed from: g, reason: collision with root package name */
        private float f73695g;

        /* renamed from: h, reason: collision with root package name */
        private float f73696h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f73697i;

        @Override // com.tencent.av.doodle.i.d, com.tencent.av.doodle.i.c
        public void a(BufferedReader bufferedReader) throws IOException {
            super.a(bufferedReader);
            if (!this.f73689a) {
                return;
            }
            this.f73695g = i.i(bufferedReader, "highMin");
            this.f73696h = i.i(bufferedReader, "highMax");
            this.f73697i = i.h(bufferedReader, ParseCommon.LAYOUT_PARAMS_RELATIVE);
            this.f73693e = new float[i.j(bufferedReader, "scalingCount")];
            int i3 = 0;
            int i16 = 0;
            while (true) {
                float[] fArr = this.f73693e;
                if (i16 >= fArr.length) {
                    break;
                }
                fArr[i16] = i.i(bufferedReader, "scaling" + i16);
                i16++;
            }
            this.f73694f = new float[i.j(bufferedReader, "timelineCount")];
            while (true) {
                float[] fArr2 = this.f73694f;
                if (i3 < fArr2.length) {
                    fArr2[i3] = i.i(bufferedReader, "timeline" + i3);
                    i3++;
                } else {
                    return;
                }
            }
        }

        public float d(float f16) {
            float[] fArr = this.f73694f;
            int length = fArr.length;
            int i3 = 1;
            while (true) {
                if (i3 < length) {
                    if (fArr[i3] > f16) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 == -1) {
                return this.f73693e[length - 1];
            }
            float[] fArr2 = this.f73693e;
            int i16 = i3 - 1;
            float f17 = fArr2[i16];
            float f18 = fArr[i16];
            return f17 + ((fArr2[i3] - f17) * ((f16 - f18) / (fArr[i3] - f18)));
        }

        public boolean e() {
            return this.f73697i;
        }

        public float f() {
            float f16 = this.f73695g;
            return f16 + ((this.f73696h - f16) * com.tencent.av.doodle.e.e());
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class f {
        public static int a(String str) {
            if (str == null || str.equals(MagicfaceDataPendantJason.BELONG_TO_BOTH)) {
                return 0;
            }
            if (str.equals("top")) {
                return 1;
            }
            if (!str.equals("bottom")) {
                return 0;
            }
            return 2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class g {
        public static int a(String str) {
            if (str == null || str.equals("point")) {
                return 0;
            }
            if (str.equals("line")) {
                return 1;
            }
            if (str.equals("square")) {
                return 2;
            }
            if (!str.equals("ellipse")) {
                return 0;
            }
            return 3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class h extends c {

        /* renamed from: d, reason: collision with root package name */
        boolean f73699d;

        /* renamed from: c, reason: collision with root package name */
        int f73698c = 0;

        /* renamed from: e, reason: collision with root package name */
        int f73700e = 0;

        @Override // com.tencent.av.doodle.i.c
        public void a(BufferedReader bufferedReader) throws IOException {
            super.a(bufferedReader);
            if (!this.f73689a) {
                return;
            }
            int a16 = g.a(i.k(bufferedReader, "shape"));
            this.f73698c = a16;
            if (a16 == 3) {
                this.f73699d = i.h(bufferedReader, "edges");
                this.f73700e = f.a(i.k(bufferedReader, "side"));
            }
        }
    }

    public i() {
        this.f73634a = new d();
        this.f73635b = new e();
        this.f73636c = new d();
        this.f73637d = new e();
        this.f73638e = new e();
        this.f73639f = new e();
        this.f73640g = new e();
        this.f73641h = new e();
        this.f73642i = new e();
        this.f73643j = new e();
        this.f73644k = new e();
        this.f73645l = new e();
        this.f73646m = new a();
        this.f73647n = new e();
        this.f73648o = new e();
        this.f73649p = new e();
        this.f73650q = new e();
        this.f73651r = new h();
        this.f73656w = 4;
        this.O = 1.0f;
        this.W = true;
        this.X = null;
        this.Y = new float[2];
        this.Z = new float[2];
        e();
    }

    private void a(int i3) {
        float f16;
        b[] bVarArr = this.f73654u;
        b bVar = bVarArr[i3];
        if (bVar == null) {
            BitmapDrawable[] bitmapDrawableArr = this.f73653t;
            bVar = g(bitmapDrawableArr[com.tencent.av.doodle.e.g(bitmapDrawableArr.length - 1)]);
            bVarArr[i3] = bVar;
        }
        float f17 = this.P / this.O;
        int i16 = this.B;
        int d16 = this.I + ((int) (this.J * this.f73637d.d(f17)));
        bVar.f73663a = d16;
        bVar.f73664b = d16;
        e eVar = this.f73641h;
        if (eVar.f73689a) {
            bVar.f73669g = eVar.c();
            bVar.f73670h = this.f73641h.f();
            if (!this.f73641h.e()) {
                bVar.f73670h -= bVar.f73669g;
            }
        }
        bVar.f73671i = this.f73642i.c();
        bVar.f73672j = this.f73642i.f();
        if (!this.f73642i.e()) {
            bVar.f73672j -= bVar.f73671i;
        }
        if ((i16 & 2) == 0) {
            f16 = bVar.f73671i + (bVar.f73672j * this.f73642i.d(0.0f));
            bVar.f73671i = f16;
            bVar.f73673k = com.tencent.av.doodle.e.d(f16);
            bVar.f73674l = com.tencent.av.doodle.e.h(f16);
        } else {
            f16 = 0.0f;
        }
        float width = bVar.getBitmap().getWidth();
        bVar.f73665c = this.f73639f.c() / width;
        bVar.f73666d = this.f73639f.f() / width;
        if (!this.f73639f.e()) {
            bVar.f73666d -= bVar.f73665c;
        }
        bVar.d(bVar.f73665c + (bVar.f73666d * this.f73639f.d(0.0f)));
        e eVar2 = this.f73640g;
        if (eVar2.f73689a) {
            bVar.f73667e = eVar2.c();
            bVar.f73668f = this.f73640g.f();
            if (!this.f73640g.e()) {
                bVar.f73668f -= bVar.f73667e;
            }
            float d17 = bVar.f73667e + (bVar.f73668f * this.f73640g.d(0.0f));
            if (this.U) {
                d17 += f16;
            }
            bVar.c(d17);
        }
        e eVar3 = this.f73643j;
        if (eVar3.f73689a) {
            bVar.f73677o = eVar3.c();
            bVar.f73678p = this.f73643j.f();
            if (!this.f73643j.e()) {
                bVar.f73678p -= bVar.f73677o;
            }
        }
        e eVar4 = this.f73644k;
        if (eVar4.f73689a) {
            bVar.f73679q = eVar4.c();
            bVar.f73680r = this.f73644k.f();
            if (!this.f73644k.e()) {
                bVar.f73680r -= bVar.f73679q;
            }
        }
        float[] fArr = bVar.f73681s;
        if (fArr == null) {
            fArr = new float[3];
            bVar.f73681s = fArr;
        }
        float[] c16 = this.f73646m.c(0.0f);
        fArr[0] = c16[0];
        fArr[1] = c16[1];
        fArr[2] = c16[2];
        bVar.f73675m = this.f73645l.c();
        bVar.f73676n = this.f73645l.f() - bVar.f73675m;
        s(bVar, f17, width);
        int d18 = (int) (this.G + (this.H * this.f73635b.d(f17)));
        if (d18 > 0) {
            int i17 = bVar.f73664b;
            if (d18 >= i17) {
                d18 = i17 - 1;
            }
            r(bVar, d18 / 1000.0f, d18);
        }
    }

    private void e() {
        this.f73636c.b(true);
        this.f73638e.b(true);
        this.f73637d.b(true);
        this.f73639f.b(true);
        this.f73645l.b(true);
        this.f73651r.b(true);
        this.f73649p.b(true);
        this.f73650q.b(true);
    }

    static boolean h(BufferedReader bufferedReader, String str) throws IOException {
        return Boolean.parseBoolean(k(bufferedReader, str));
    }

    static float i(BufferedReader bufferedReader, String str) throws IOException {
        return Float.parseFloat(k(bufferedReader, str));
    }

    static int j(BufferedReader bufferedReader, String str) throws IOException {
        return Integer.parseInt(k(bufferedReader, str));
    }

    static String k(BufferedReader bufferedReader, String str) throws IOException {
        String readLine = bufferedReader.readLine();
        if (readLine != null) {
            return readLine.substring(readLine.indexOf(":") + 1).trim();
        }
        throw new IOException("Missing value: " + str);
    }

    private void l() {
        float f16;
        int i3;
        d dVar = this.f73634a;
        if (dVar.f73689a) {
            f16 = dVar.c();
        } else {
            f16 = 0.0f;
        }
        this.Q = f16;
        this.R = 0.0f;
        this.P -= this.O;
        this.O = this.f73636c.c();
        this.D = (int) this.f73638e.c();
        this.E = (int) this.f73638e.f();
        if (!this.f73638e.e()) {
            this.E -= this.D;
        }
        this.I = (int) this.f73637d.c();
        this.J = (int) this.f73637d.f();
        if (!this.f73637d.e()) {
            this.J -= this.I;
        }
        e eVar = this.f73635b;
        if (eVar.f73689a) {
            i3 = (int) eVar.c();
        } else {
            i3 = 0;
        }
        this.G = i3;
        this.H = (int) this.f73635b.f();
        if (!this.f73635b.e()) {
            this.H -= this.G;
        }
        this.K = this.f73649p.c();
        this.L = this.f73649p.f();
        if (!this.f73649p.e()) {
            this.L -= this.K;
        }
        this.M = this.f73650q.c();
        this.N = this.f73650q.f();
        if (!this.f73650q.e()) {
            this.N -= this.M;
        }
        this.B = 0;
        e eVar2 = this.f73642i;
        if (eVar2.f73689a && eVar2.f73694f.length > 1) {
            this.B = 0 | 2;
        }
        if (this.f73641h.f73689a) {
            this.B |= 8;
        }
        if (this.f73639f.f73694f.length > 1) {
            this.B |= 1;
        }
        e eVar3 = this.f73640g;
        if (eVar3.f73689a && eVar3.f73694f.length > 1) {
            this.B |= 4;
        }
        if (this.f73643j.f73689a) {
            this.B |= 16;
        }
        if (this.f73644k.f73689a) {
            this.B |= 32;
        }
        if (this.f73646m.f73662d.length > 1) {
            this.B |= 64;
        }
    }

    private boolean r(b bVar, float f16, int i3) {
        float[] fArr;
        float f17;
        float f18;
        int i16 = bVar.f73664b - i3;
        if (i16 <= 0) {
            return false;
        }
        bVar.f73664b = i16;
        float f19 = 1.0f - (i16 / bVar.f73663a);
        int i17 = this.B;
        if ((i17 & 1) != 0) {
            bVar.d(bVar.f73665c + (bVar.f73666d * this.f73639f.d(f19)));
        }
        if ((i17 & 8) != 0) {
            float d16 = (bVar.f73669g + (bVar.f73670h * this.f73641h.d(f19))) * f16;
            if ((i17 & 2) != 0) {
                float d17 = bVar.f73671i + (bVar.f73672j * this.f73642i.d(f19));
                f17 = com.tencent.av.doodle.e.d(d17) * d16;
                f18 = d16 * com.tencent.av.doodle.e.h(d17);
                if ((i17 & 4) != 0) {
                    float d18 = bVar.f73667e + (bVar.f73668f * this.f73640g.d(f19));
                    if (this.U) {
                        d18 += d17;
                    }
                    bVar.c(d18);
                }
            } else {
                f17 = d16 * bVar.f73673k;
                f18 = d16 * bVar.f73674l;
                if (this.U || (i17 & 4) != 0) {
                    float d19 = bVar.f73667e + (bVar.f73668f * this.f73640g.d(f19));
                    if (this.U) {
                        d19 += bVar.f73671i;
                    }
                    bVar.c(d19);
                }
            }
            if ((i17 & 16) != 0) {
                f17 += (bVar.f73677o + (bVar.f73678p * this.f73643j.d(f19))) * f16;
            }
            if ((i17 & 32) != 0) {
                f18 += (bVar.f73679q + (bVar.f73680r * this.f73644k.d(f19))) * f16;
            }
            bVar.e(f17, f18);
        } else if ((i17 & 4) != 0) {
            bVar.c(bVar.f73667e + (bVar.f73668f * this.f73640g.d(f19)));
        }
        if ((i17 & 64) != 0) {
            fArr = this.f73646m.c(f19);
        } else {
            fArr = bVar.f73681s;
        }
        bVar.b(fArr[0], fArr[1], fArr[2], bVar.f73675m + (bVar.f73676n * this.f73645l.d(f19)));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void s(b bVar, float f16, float f17) {
        float f18;
        float f19;
        d dVar;
        d dVar2;
        int i3;
        float f26;
        float f27;
        float f28;
        float f29;
        PathMeasure pathMeasure = this.X;
        if (pathMeasure != null) {
            float length = pathMeasure.getLength();
            if (length > 0.0f) {
                this.X.getPosTan(com.tencent.av.doodle.e.f(length), this.Y, this.Z);
                float[] fArr = this.Y;
                f18 = fArr[0];
                f19 = fArr[1];
                dVar = this.f73647n;
                if (dVar.f73689a) {
                    f18 += dVar.c();
                }
                dVar2 = this.f73648o;
                if (dVar2.f73689a) {
                    f19 += dVar2.c();
                }
                i3 = this.f73651r.f73698c;
                if (i3 == 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            float d16 = this.K + (this.L * this.f73649p.d(f16));
                            float d17 = this.M + (this.N * this.f73650q.d(f16));
                            float f36 = d16 / 2.0f;
                            float f37 = d17 / 2.0f;
                            if (f36 != 0.0f && f37 != 0.0f) {
                                float f38 = f36 / f37;
                                h hVar = this.f73651r;
                                if (hVar.f73699d) {
                                    int i16 = hVar.f73700e;
                                    if (i16 != 1) {
                                        if (i16 != 2) {
                                            f29 = com.tencent.av.doodle.e.f(360.0f);
                                        } else {
                                            f29 = com.tencent.av.doodle.e.f(179.0f);
                                        }
                                    } else {
                                        f29 = -com.tencent.av.doodle.e.f(179.0f);
                                    }
                                    float d18 = com.tencent.av.doodle.e.d(f29);
                                    float h16 = com.tencent.av.doodle.e.h(f29);
                                    f18 += d18 * f36;
                                    f19 += (f36 * h16) / f38;
                                    if ((this.B & 2) == 0) {
                                        bVar.f73671i = f29;
                                        bVar.f73673k = d18;
                                        bVar.f73674l = h16;
                                    }
                                } else {
                                    float f39 = f36 * f36;
                                    do {
                                        f27 = com.tencent.av.doodle.e.f(d16) - f36;
                                        f28 = com.tencent.av.doodle.e.f(d16) - f36;
                                    } while ((f27 * f27) + (f28 * f28) > f39);
                                    f18 += f27;
                                    f19 += f28 / f38;
                                }
                            }
                        }
                    } else {
                        float d19 = this.K + (this.L * this.f73649p.d(f16));
                        float d26 = this.M + (this.N * this.f73650q.d(f16));
                        f18 += com.tencent.av.doodle.e.f(d19) - (d19 / 2.0f);
                        f26 = com.tencent.av.doodle.e.f(d26) - (d26 / 2.0f);
                        f19 += f26;
                    }
                } else {
                    float d27 = this.K + (this.L * this.f73649p.d(f16));
                    float d28 = this.M + (this.N * this.f73650q.d(f16));
                    if (d27 != 0.0f) {
                        float e16 = com.tencent.av.doodle.e.e() * d27;
                        f18 += e16;
                        f26 = e16 * (d28 / d27);
                        f19 += f26;
                    } else {
                        f19 += d28 * com.tencent.av.doodle.e.e();
                    }
                }
                float height = bVar.getBitmap().getHeight();
                bVar.a(f18 - (f17 / 2.0f), f19 - (height / 2.0f), f17, height);
            }
        }
        f18 = Float.MAX_VALUE;
        f19 = Float.MAX_VALUE;
        dVar = this.f73647n;
        if (dVar.f73689a) {
        }
        dVar2 = this.f73648o;
        if (dVar2.f73689a) {
        }
        i3 = this.f73651r.f73698c;
        if (i3 == 1) {
        }
        float height2 = bVar.getBitmap().getHeight();
        bVar.a(f18 - (f17 / 2.0f), f19 - (height2 / 2.0f), f17, height2);
    }

    public void b() {
        int i3 = this.f73658y;
        if (i3 == this.f73656w) {
            return;
        }
        boolean[] zArr = this.f73659z;
        int length = zArr.length;
        for (int i16 = 0; i16 < length; i16++) {
            if (!zArr[i16]) {
                a(i16);
                zArr[i16] = true;
                this.f73658y = i3 + 1;
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
    
        a(r3);
        r0[r3] = true;
        r2 = r2 + 1;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(int i3) {
        int min = Math.min(i3, this.f73656w - this.f73658y);
        if (min == 0) {
            return;
        }
        boolean[] zArr = this.f73659z;
        int length = zArr.length;
        int i16 = 0;
        int i17 = 0;
        loop0: while (i16 < min) {
            while (i17 < length) {
                if (!zArr[i17]) {
                    break;
                } else {
                    i17++;
                }
            }
            break loop0;
        }
        this.f73658y += min;
    }

    public void d(Canvas canvas) {
        b[] bVarArr = this.f73654u;
        boolean[] zArr = this.f73659z;
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (zArr[i3]) {
                bVarArr[i3].draw(canvas);
            }
        }
    }

    public void f(BufferedReader bufferedReader) throws IOException {
        try {
            this.f73657x = k(bufferedReader, "name");
            bufferedReader.readLine();
            this.f73634a.a(bufferedReader);
            bufferedReader.readLine();
            this.f73636c.a(bufferedReader);
            bufferedReader.readLine();
            n(j(bufferedReader, "minParticleCount"));
            m(j(bufferedReader, "maxParticleCount"));
            bufferedReader.readLine();
            this.f73638e.a(bufferedReader);
            bufferedReader.readLine();
            this.f73637d.a(bufferedReader);
            bufferedReader.readLine();
            this.f73635b.a(bufferedReader);
            bufferedReader.readLine();
            this.f73647n.a(bufferedReader);
            bufferedReader.readLine();
            this.f73648o.a(bufferedReader);
            bufferedReader.readLine();
            this.f73651r.a(bufferedReader);
            bufferedReader.readLine();
            this.f73649p.a(bufferedReader);
            bufferedReader.readLine();
            this.f73650q.a(bufferedReader);
            bufferedReader.readLine();
            this.f73639f.a(bufferedReader);
            bufferedReader.readLine();
            this.f73641h.a(bufferedReader);
            bufferedReader.readLine();
            this.f73642i.a(bufferedReader);
            bufferedReader.readLine();
            this.f73640g.a(bufferedReader);
            bufferedReader.readLine();
            this.f73643j.a(bufferedReader);
            bufferedReader.readLine();
            this.f73644k.a(bufferedReader);
            bufferedReader.readLine();
            this.f73646m.a(bufferedReader);
            bufferedReader.readLine();
            this.f73645l.a(bufferedReader);
            bufferedReader.readLine();
            this.S = h(bufferedReader, "attached");
            this.T = h(bufferedReader, "continuous");
            this.U = h(bufferedReader, "aligned");
            this.W = h(bufferedReader, "additive");
            this.V = h(bufferedReader, "behind");
        } catch (RuntimeException e16) {
            if (this.f73657x == null) {
                throw e16;
            }
            throw new RuntimeException("Error parsing emitter: " + this.f73657x, e16);
        }
    }

    protected b g(BitmapDrawable bitmapDrawable) {
        return new b(bitmapDrawable);
    }

    public void m(int i3) {
        this.f73656w = i3;
        this.f73659z = new boolean[i3];
        this.f73658y = 0;
        this.f73654u = new b[i3];
    }

    public void n(int i3) {
        this.f73655v = i3;
    }

    public void o(PathMeasure pathMeasure) {
        this.X = pathMeasure;
    }

    public void p(BitmapDrawable[] bitmapDrawableArr) {
        this.f73653t = bitmapDrawableArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(float f16) {
        boolean z16;
        BitmapDrawable[] bitmapDrawableArr = this.f73653t;
        if (bitmapDrawableArr != null && bitmapDrawableArr.length > 0) {
            float f17 = this.f73652s + (f16 * 1000.0f);
            this.f73652s = f17;
            if (f17 < 1.0f) {
                return;
            }
            int i3 = (int) f17;
            float f18 = i3;
            this.f73652s = f17 - f18;
            float f19 = this.R;
            if (f19 < this.Q) {
                this.R = f19 + f18;
            } else {
                if (this.A) {
                    this.A = false;
                    b();
                }
                float f26 = this.P;
                if (f26 < this.O) {
                    this.P = f26 + f18;
                } else if (this.T && !this.C) {
                    l();
                } else {
                    z16 = true;
                    if (!z16) {
                        this.F += i3;
                        float d16 = this.D + (this.E * this.f73638e.d(this.P / this.O));
                        if (d16 > 0.0f) {
                            float f27 = 1000.0f / d16;
                            int i16 = this.F;
                            if (i16 >= f27) {
                                int min = Math.min((int) (i16 / f27), this.f73656w - this.f73658y);
                                this.F = (int) (((int) (this.F - (min * f27))) % f27);
                                c(min);
                            }
                        }
                        int i17 = this.f73658y;
                        int i18 = this.f73655v;
                        if (i17 < i18) {
                            c(i18 - i17);
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            boolean[] zArr = this.f73659z;
            int i19 = this.f73658y;
            b[] bVarArr = this.f73654u;
            int length = zArr.length;
            for (int i26 = 0; i26 < length; i26++) {
                if (zArr[i26] && !r(bVarArr[i26], f16, i3)) {
                    zArr[i26] = false;
                    i19--;
                }
            }
            this.f73658y = i19;
        }
    }

    public i(BufferedReader bufferedReader) throws IOException {
        this.f73634a = new d();
        this.f73635b = new e();
        this.f73636c = new d();
        this.f73637d = new e();
        this.f73638e = new e();
        this.f73639f = new e();
        this.f73640g = new e();
        this.f73641h = new e();
        this.f73642i = new e();
        this.f73643j = new e();
        this.f73644k = new e();
        this.f73645l = new e();
        this.f73646m = new a();
        this.f73647n = new e();
        this.f73648o = new e();
        this.f73649p = new e();
        this.f73650q = new e();
        this.f73651r = new h();
        this.f73656w = 4;
        this.O = 1.0f;
        this.W = true;
        this.X = null;
        this.Y = new float[2];
        this.Z = new float[2];
        e();
        f(bufferedReader);
    }
}
