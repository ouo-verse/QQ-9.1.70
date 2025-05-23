package com.tencent.luggage.wxa.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.tencent.luggage.wxa.a.b;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f120500g = true;

    /* renamed from: a, reason: collision with root package name */
    public g0 f120501a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f120502b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f120503c = "";

    /* renamed from: d, reason: collision with root package name */
    public float f120504d = 96.0f;

    /* renamed from: e, reason: collision with root package name */
    public b.r f120505e = new b.r();

    /* renamed from: f, reason: collision with root package name */
    public Map f120506f = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120507a;

        static {
            int[] iArr = new int[e1.values().length];
            f120507a = iArr;
            try {
                iArr[e1.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f120507a[e1.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f120507a[e1.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f120507a[e1.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f120507a[e1.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f120507a[e1.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f120507a[e1.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f120507a[e1.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f120507a[e1.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a0 extends m {

        /* renamed from: o, reason: collision with root package name */
        public float[] f120508o;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "polyline";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a1 extends z0 implements y0 {

        /* renamed from: o, reason: collision with root package name */
        public String f120509o;

        /* renamed from: p, reason: collision with root package name */
        public q f120510p;

        /* renamed from: q, reason: collision with root package name */
        public c1 f120511q;

        public void a(c1 c1Var) {
            this.f120511q = c1Var;
        }

        @Override // com.tencent.luggage.wxa.a.h.y0
        public c1 c() {
            return this.f120511q;
        }

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "textPath";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends n {

        /* renamed from: p, reason: collision with root package name */
        public String f120512p;

        @Override // com.tencent.luggage.wxa.a.h.n, com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "a";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b0 extends a0 {
        @Override // com.tencent.luggage.wxa.a.h.a0, com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "polygon";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class b1 extends z0 {

        /* renamed from: o, reason: collision with root package name */
        public List f120513o;

        /* renamed from: p, reason: collision with root package name */
        public List f120514p;

        /* renamed from: q, reason: collision with root package name */
        public List f120515q;

        /* renamed from: r, reason: collision with root package name */
        public List f120516r;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public float f120517a;

        /* renamed from: b, reason: collision with root package name */
        public float f120518b;

        /* renamed from: c, reason: collision with root package name */
        public float f120519c;

        /* renamed from: d, reason: collision with root package name */
        public float f120520d;

        public c(float f16, float f17, float f18, float f19) {
            this.f120517a = f16;
            this.f120518b = f17;
            this.f120519c = f18;
            this.f120520d = f19;
        }

        public static c a(float f16, float f17, float f18, float f19) {
            return new c(f16, f17, f18 - f16, f19 - f17);
        }

        public float b() {
            return this.f120518b + this.f120520d;
        }

        public String toString() {
            return "[" + this.f120517a + " " + this.f120518b + " " + this.f120519c + " " + this.f120520d + "]";
        }

        public float a() {
            return this.f120517a + this.f120519c;
        }

        public void a(c cVar) {
            float f16 = cVar.f120517a;
            if (f16 < this.f120517a) {
                this.f120517a = f16;
            }
            float f17 = cVar.f120518b;
            if (f17 < this.f120518b) {
                this.f120518b = f17;
            }
            if (cVar.a() > a()) {
                this.f120519c = cVar.a() - this.f120517a;
            }
            if (cVar.b() > b()) {
                this.f120520d = cVar.b() - this.f120518b;
            }
        }

        public c(c cVar) {
            this.f120517a = cVar.f120517a;
            this.f120518b = cVar.f120518b;
            this.f120519c = cVar.f120519c;
            this.f120520d = cVar.f120520d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c0 extends m {

        /* renamed from: o, reason: collision with root package name */
        public q f120521o;

        /* renamed from: p, reason: collision with root package name */
        public q f120522p;

        /* renamed from: q, reason: collision with root package name */
        public q f120523q;

        /* renamed from: r, reason: collision with root package name */
        public q f120524r;

        /* renamed from: s, reason: collision with root package name */
        public q f120525s;

        /* renamed from: t, reason: collision with root package name */
        public q f120526t;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return CanvasView.ACTION_RECT;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c1 {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public q f120527a;

        /* renamed from: b, reason: collision with root package name */
        public q f120528b;

        /* renamed from: c, reason: collision with root package name */
        public q f120529c;

        /* renamed from: d, reason: collision with root package name */
        public q f120530d;

        public d(q qVar, q qVar2, q qVar3, q qVar4) {
            this.f120527a = qVar;
            this.f120528b = qVar2;
            this.f120529c = qVar3;
            this.f120530d = qVar4;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d1 extends o0 implements y0 {

        /* renamed from: c, reason: collision with root package name */
        public String f120531c;

        /* renamed from: d, reason: collision with root package name */
        public c1 f120532d;

        public d1(String str) {
            this.f120531c = str;
        }

        @Override // com.tencent.luggage.wxa.a.h.y0
        public c1 c() {
            return this.f120532d;
        }

        public String toString() {
            return "TextChild: '" + this.f120531c + "'";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e extends m {

        /* renamed from: o, reason: collision with root package name */
        public q f120533o;

        /* renamed from: p, reason: collision with root package name */
        public q f120534p;

        /* renamed from: q, reason: collision with root package name */
        public q f120535q;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_CIRCLE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum e1 {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f extends n implements u {

        /* renamed from: p, reason: collision with root package name */
        public Boolean f120547p;

        @Override // com.tencent.luggage.wxa.a.h.n, com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "clipPath";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f1 extends n {

        /* renamed from: p, reason: collision with root package name */
        public String f120598p;

        /* renamed from: q, reason: collision with root package name */
        public q f120599q;

        /* renamed from: r, reason: collision with root package name */
        public q f120600r;

        /* renamed from: s, reason: collision with root package name */
        public q f120601s;

        /* renamed from: t, reason: collision with root package name */
        public q f120602t;

        @Override // com.tencent.luggage.wxa.a.h.n, com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return TransFileControllerImpl.VALUE_USE_PRE_CONN;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class g extends p0 {

        /* renamed from: b, reason: collision with root package name */
        public static final g f120603b = new g(-16777216);

        /* renamed from: c, reason: collision with root package name */
        public static final g f120604c = new g(0);

        /* renamed from: a, reason: collision with root package name */
        public int f120605a;

        public g(int i3) {
            this.f120605a = i3;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.f120605a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class g0 extends s0 {

        /* renamed from: q, reason: collision with root package name */
        public q f120606q;

        /* renamed from: r, reason: collision with root package name */
        public q f120607r;

        /* renamed from: s, reason: collision with root package name */
        public q f120608s;

        /* renamed from: t, reason: collision with root package name */
        public q f120609t;

        /* renamed from: u, reason: collision with root package name */
        public String f120610u;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "svg";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class g1 extends s0 implements u {
        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "view";
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a.h$h, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C5979h extends p0 {

        /* renamed from: a, reason: collision with root package name */
        public static C5979h f120611a = new C5979h();

        public static C5979h a() {
            return f120611a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface h0 {
        Set a();

        void a(String str);

        void a(Set set);

        String b();

        void b(Set set);

        void c(Set set);

        Set d();

        void d(Set set);

        Set e();

        Set f();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class i extends n implements u {
        @Override // com.tencent.luggage.wxa.a.h.n, com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "defs";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class i0 extends l0 implements k0, h0 {

        /* renamed from: i, reason: collision with root package name */
        public List f120612i = new ArrayList();

        /* renamed from: j, reason: collision with root package name */
        public Set f120613j = null;

        /* renamed from: k, reason: collision with root package name */
        public String f120614k = null;

        /* renamed from: l, reason: collision with root package name */
        public Set f120615l = null;

        /* renamed from: m, reason: collision with root package name */
        public Set f120616m = null;

        /* renamed from: n, reason: collision with root package name */
        public Set f120617n = null;

        @Override // com.tencent.luggage.wxa.a.h.h0
        public Set a() {
            return null;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void b(Set set) {
            this.f120613j = set;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void c(Set set) {
            this.f120615l = set;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public Set d() {
            return this.f120613j;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public Set e() {
            return this.f120616m;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public Set f() {
            return this.f120617n;
        }

        @Override // com.tencent.luggage.wxa.a.h.k0
        public List getChildren() {
            return this.f120612i;
        }

        @Override // com.tencent.luggage.wxa.a.h.k0
        public void a(o0 o0Var) {
            this.f120612i.add(o0Var);
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public String b() {
            return this.f120614k;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void d(Set set) {
            this.f120616m = set;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void a(String str) {
            this.f120614k = str;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void a(Set set) {
            this.f120617n = set;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class j extends m {

        /* renamed from: o, reason: collision with root package name */
        public q f120618o;

        /* renamed from: p, reason: collision with root package name */
        public q f120619p;

        /* renamed from: q, reason: collision with root package name */
        public q f120620q;

        /* renamed from: r, reason: collision with root package name */
        public q f120621r;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "ellipse";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class j0 extends l0 implements h0 {

        /* renamed from: i, reason: collision with root package name */
        public Set f120622i = null;

        /* renamed from: j, reason: collision with root package name */
        public String f120623j = null;

        /* renamed from: k, reason: collision with root package name */
        public Set f120624k = null;

        /* renamed from: l, reason: collision with root package name */
        public Set f120625l = null;

        /* renamed from: m, reason: collision with root package name */
        public Set f120626m = null;

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void a(String str) {
            this.f120623j = str;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void b(Set set) {
            this.f120622i = set;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void c(Set set) {
            this.f120624k = set;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public Set d() {
            return this.f120622i;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public Set e() {
            return this.f120625l;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public Set f() {
            return this.f120626m;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public Set a() {
            return this.f120624k;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public String b() {
            return this.f120623j;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void d(Set set) {
            this.f120625l = set;
        }

        @Override // com.tencent.luggage.wxa.a.h.h0
        public void a(Set set) {
            this.f120626m = set;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class k extends m0 implements k0 {

        /* renamed from: h, reason: collision with root package name */
        public List f120627h = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        public Boolean f120628i;

        /* renamed from: j, reason: collision with root package name */
        public Matrix f120629j;

        /* renamed from: k, reason: collision with root package name */
        public l f120630k;

        /* renamed from: l, reason: collision with root package name */
        public String f120631l;

        @Override // com.tencent.luggage.wxa.a.h.k0
        public void a(o0 o0Var) {
            if (o0Var instanceof e0) {
                this.f120627h.add(o0Var);
                return;
            }
            throw new com.tencent.luggage.wxa.a.k("Gradient elements cannot contain " + o0Var + " elements.");
        }

        @Override // com.tencent.luggage.wxa.a.h.k0
        public List getChildren() {
            return this.f120627h;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface k0 {
        void a(o0 o0Var);

        List getChildren();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum l {
        pad,
        reflect,
        repeat
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class l0 extends m0 {

        /* renamed from: h, reason: collision with root package name */
        public c f120636h = null;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class m extends j0 implements o {

        /* renamed from: n, reason: collision with root package name */
        public Matrix f120637n;

        @Override // com.tencent.luggage.wxa.a.h.o
        public void a(Matrix matrix) {
            this.f120637n = matrix;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class m0 extends o0 {

        /* renamed from: c, reason: collision with root package name */
        public String f120638c = null;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f120639d = null;

        /* renamed from: e, reason: collision with root package name */
        public f0 f120640e = null;

        /* renamed from: f, reason: collision with root package name */
        public f0 f120641f = null;

        /* renamed from: g, reason: collision with root package name */
        public List f120642g = null;

        public String toString() {
            return g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class n extends i0 implements o {

        /* renamed from: o, reason: collision with root package name */
        public Matrix f120643o;

        @Override // com.tencent.luggage.wxa.a.h.o
        public void a(Matrix matrix) {
            this.f120643o = matrix;
        }

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return VipFunCallConstants.KEY_GROUP;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class n0 extends k {

        /* renamed from: m, reason: collision with root package name */
        public q f120644m;

        /* renamed from: n, reason: collision with root package name */
        public q f120645n;

        /* renamed from: o, reason: collision with root package name */
        public q f120646o;

        /* renamed from: p, reason: collision with root package name */
        public q f120647p;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return NodeProps.LINEAR_GRADIENT;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface o {
        void a(Matrix matrix);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class o0 {

        /* renamed from: a, reason: collision with root package name */
        public h f120648a;

        /* renamed from: b, reason: collision with root package name */
        public k0 f120649b;

        public abstract String g();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class p extends q0 implements o {

        /* renamed from: p, reason: collision with root package name */
        public String f120650p;

        /* renamed from: q, reason: collision with root package name */
        public q f120651q;

        /* renamed from: r, reason: collision with root package name */
        public q f120652r;

        /* renamed from: s, reason: collision with root package name */
        public q f120653s;

        /* renamed from: t, reason: collision with root package name */
        public q f120654t;

        /* renamed from: u, reason: collision with root package name */
        public Matrix f120655u;

        @Override // com.tencent.luggage.wxa.a.h.o
        public void a(Matrix matrix) {
            this.f120655u = matrix;
        }

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "image";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class p0 implements Cloneable {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class q implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public float f120656a;

        /* renamed from: b, reason: collision with root package name */
        public e1 f120657b;

        public q(float f16, e1 e1Var) {
            this.f120656a = f16;
            this.f120657b = e1Var;
        }

        public float a() {
            return this.f120656a;
        }

        public float b(com.tencent.luggage.wxa.a.i iVar) {
            switch (a.f120507a[this.f120657b.ordinal()]) {
                case 1:
                    return this.f120656a;
                case 2:
                    return this.f120656a * iVar.f();
                case 3:
                    return this.f120656a * iVar.g();
                case 4:
                    return this.f120656a * iVar.i();
                case 5:
                    return (this.f120656a * iVar.i()) / 2.54f;
                case 6:
                    return (this.f120656a * iVar.i()) / 25.4f;
                case 7:
                    return (this.f120656a * iVar.i()) / 72.0f;
                case 8:
                    return (this.f120656a * iVar.i()) / 6.0f;
                case 9:
                    c h16 = iVar.h();
                    if (h16 == null) {
                        return this.f120656a;
                    }
                    return (this.f120656a * h16.f120519c) / 100.0f;
                default:
                    return this.f120656a;
            }
        }

        public float c(com.tencent.luggage.wxa.a.i iVar) {
            if (this.f120657b == e1.percent) {
                c h16 = iVar.h();
                if (h16 == null) {
                    return this.f120656a;
                }
                return (this.f120656a * h16.f120520d) / 100.0f;
            }
            return b(iVar);
        }

        public String toString() {
            return String.valueOf(this.f120656a) + this.f120657b;
        }

        public float a(com.tencent.luggage.wxa.a.i iVar) {
            if (this.f120657b == e1.percent) {
                c h16 = iVar.h();
                if (h16 == null) {
                    return this.f120656a;
                }
                float f16 = h16.f120519c;
                if (f16 == h16.f120520d) {
                    return (this.f120656a * f16) / 100.0f;
                }
                return (this.f120656a * ((float) (Math.sqrt((f16 * f16) + (r6 * r6)) / 1.414213562373095d))) / 100.0f;
            }
            return b(iVar);
        }

        public q(float f16) {
            this.f120656a = f16;
            this.f120657b = e1.px;
        }

        public boolean c() {
            return this.f120656a == 0.0f;
        }

        public float a(com.tencent.luggage.wxa.a.i iVar, float f16) {
            if (this.f120657b == e1.percent) {
                return (this.f120656a * f16) / 100.0f;
            }
            return b(iVar);
        }

        public float a(float f16) {
            int i3 = a.f120507a[this.f120657b.ordinal()];
            if (i3 != 1) {
                switch (i3) {
                    case 4:
                        return this.f120656a * f16;
                    case 5:
                        return (this.f120656a * f16) / 2.54f;
                    case 6:
                        return (this.f120656a * f16) / 25.4f;
                    case 7:
                        return (this.f120656a * f16) / 72.0f;
                    case 8:
                        return (this.f120656a * f16) / 6.0f;
                    default:
                        return this.f120656a;
                }
            }
            return this.f120656a;
        }

        public boolean b() {
            return this.f120656a < 0.0f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class q0 extends i0 {

        /* renamed from: o, reason: collision with root package name */
        public com.tencent.luggage.wxa.a.f f120658o = null;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class r extends m {

        /* renamed from: o, reason: collision with root package name */
        public q f120659o;

        /* renamed from: p, reason: collision with root package name */
        public q f120660p;

        /* renamed from: q, reason: collision with root package name */
        public q f120661q;

        /* renamed from: r, reason: collision with root package name */
        public q f120662r;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "line";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class r0 extends k {

        /* renamed from: m, reason: collision with root package name */
        public q f120663m;

        /* renamed from: n, reason: collision with root package name */
        public q f120664n;

        /* renamed from: o, reason: collision with root package name */
        public q f120665o;

        /* renamed from: p, reason: collision with root package name */
        public q f120666p;

        /* renamed from: q, reason: collision with root package name */
        public q f120667q;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "radialGradient";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class s extends s0 implements u {

        /* renamed from: q, reason: collision with root package name */
        public boolean f120668q;

        /* renamed from: r, reason: collision with root package name */
        public q f120669r;

        /* renamed from: s, reason: collision with root package name */
        public q f120670s;

        /* renamed from: t, reason: collision with root package name */
        public q f120671t;

        /* renamed from: u, reason: collision with root package name */
        public q f120672u;

        /* renamed from: v, reason: collision with root package name */
        public Float f120673v;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "marker";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class s0 extends q0 {

        /* renamed from: p, reason: collision with root package name */
        public c f120674p;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class t extends i0 implements u {

        /* renamed from: o, reason: collision with root package name */
        public Boolean f120675o;

        /* renamed from: p, reason: collision with root package name */
        public Boolean f120676p;

        /* renamed from: q, reason: collision with root package name */
        public q f120677q;

        /* renamed from: r, reason: collision with root package name */
        public q f120678r;

        /* renamed from: s, reason: collision with root package name */
        public q f120679s;

        /* renamed from: t, reason: collision with root package name */
        public q f120680t;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "mask";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class t0 extends n {
        @Override // com.tencent.luggage.wxa.a.h.n, com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface u {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class u0 extends s0 implements u {
        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "symbol";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class v extends p0 {

        /* renamed from: a, reason: collision with root package name */
        public String f120681a;

        /* renamed from: b, reason: collision with root package name */
        public p0 f120682b;

        public v(String str, p0 p0Var) {
            this.f120681a = str;
            this.f120682b = p0Var;
        }

        public String toString() {
            return this.f120681a + " " + this.f120682b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class v0 extends z0 implements y0 {

        /* renamed from: o, reason: collision with root package name */
        public String f120683o;

        /* renamed from: p, reason: collision with root package name */
        public c1 f120684p;

        public void a(c1 c1Var) {
            this.f120684p = c1Var;
        }

        @Override // com.tencent.luggage.wxa.a.h.y0
        public c1 c() {
            return this.f120684p;
        }

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "tref";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class w extends m {

        /* renamed from: o, reason: collision with root package name */
        public x f120685o;

        /* renamed from: p, reason: collision with root package name */
        public Float f120686p;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "path";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class w0 extends b1 implements y0 {

        /* renamed from: s, reason: collision with root package name */
        public c1 f120687s;

        public void a(c1 c1Var) {
            this.f120687s = c1Var;
        }

        @Override // com.tencent.luggage.wxa.a.h.y0
        public c1 c() {
            return this.f120687s;
        }

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "tspan";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class x implements y {

        /* renamed from: b, reason: collision with root package name */
        public int f120689b = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f120691d = 0;

        /* renamed from: a, reason: collision with root package name */
        public byte[] f120688a = new byte[8];

        /* renamed from: c, reason: collision with root package name */
        public float[] f120690c = new float[16];

        public boolean a() {
            return this.f120689b == 0;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void b(float f16, float f17) {
            a((byte) 1);
            a(2);
            float[] fArr = this.f120690c;
            int i3 = this.f120691d;
            int i16 = i3 + 1;
            fArr[i3] = f16;
            this.f120691d = i16 + 1;
            fArr[i16] = f17;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void close() {
            a((byte) 8);
        }

        public final void a(byte b16) {
            int i3 = this.f120689b;
            byte[] bArr = this.f120688a;
            if (i3 == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.f120688a = bArr2;
            }
            byte[] bArr3 = this.f120688a;
            int i16 = this.f120689b;
            this.f120689b = i16 + 1;
            bArr3[i16] = b16;
        }

        public final void a(int i3) {
            float[] fArr = this.f120690c;
            if (fArr.length < this.f120691d + i3) {
                float[] fArr2 = new float[fArr.length * 2];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.f120690c = fArr2;
            }
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17) {
            a((byte) 0);
            a(2);
            float[] fArr = this.f120690c;
            int i3 = this.f120691d;
            int i16 = i3 + 1;
            fArr[i3] = f16;
            this.f120691d = i16 + 1;
            fArr[i16] = f17;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17, float f18, float f19, float f26, float f27) {
            a((byte) 2);
            a(6);
            float[] fArr = this.f120690c;
            int i3 = this.f120691d;
            int i16 = i3 + 1;
            fArr[i3] = f16;
            int i17 = i16 + 1;
            fArr[i16] = f17;
            int i18 = i17 + 1;
            fArr[i17] = f18;
            int i19 = i18 + 1;
            fArr[i18] = f19;
            int i26 = i19 + 1;
            fArr[i19] = f26;
            this.f120691d = i26 + 1;
            fArr[i26] = f27;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17, float f18, float f19) {
            a((byte) 3);
            a(4);
            float[] fArr = this.f120690c;
            int i3 = this.f120691d;
            int i16 = i3 + 1;
            fArr[i3] = f16;
            int i17 = i16 + 1;
            fArr[i16] = f17;
            int i18 = i17 + 1;
            fArr[i17] = f18;
            this.f120691d = i18 + 1;
            fArr[i18] = f19;
        }

        @Override // com.tencent.luggage.wxa.a.h.y
        public void a(float f16, float f17, float f18, boolean z16, boolean z17, float f19, float f26) {
            a((byte) ((z16 ? 2 : 0) | 4 | (z17 ? 1 : 0)));
            a(5);
            float[] fArr = this.f120690c;
            int i3 = this.f120691d;
            int i16 = i3 + 1;
            fArr[i3] = f16;
            int i17 = i16 + 1;
            fArr[i16] = f17;
            int i18 = i17 + 1;
            fArr[i17] = f18;
            int i19 = i18 + 1;
            fArr[i18] = f19;
            this.f120691d = i19 + 1;
            fArr[i19] = f26;
        }

        public void a(y yVar) {
            int i3;
            int i16 = 0;
            for (int i17 = 0; i17 < this.f120689b; i17++) {
                byte b16 = this.f120688a[i17];
                if (b16 != 8) {
                    if (b16 == 0) {
                        float[] fArr = this.f120690c;
                        int i18 = i16 + 1;
                        i3 = i18 + 1;
                        yVar.a(fArr[i16], fArr[i18]);
                    } else if (b16 == 1) {
                        float[] fArr2 = this.f120690c;
                        int i19 = i16 + 1;
                        i3 = i19 + 1;
                        yVar.b(fArr2[i16], fArr2[i19]);
                    } else if (b16 == 2) {
                        float[] fArr3 = this.f120690c;
                        int i26 = i16 + 1;
                        float f16 = fArr3[i16];
                        int i27 = i26 + 1;
                        float f17 = fArr3[i26];
                        int i28 = i27 + 1;
                        float f18 = fArr3[i27];
                        int i29 = i28 + 1;
                        float f19 = fArr3[i28];
                        int i36 = i29 + 1;
                        float f26 = fArr3[i29];
                        i16 = i36 + 1;
                        yVar.a(f16, f17, f18, f19, f26, fArr3[i36]);
                    } else if (b16 != 3) {
                        boolean z16 = (b16 & 2) != 0;
                        boolean z17 = (b16 & 1) != 0;
                        float[] fArr4 = this.f120690c;
                        int i37 = i16 + 1;
                        float f27 = fArr4[i16];
                        int i38 = i37 + 1;
                        float f28 = fArr4[i37];
                        int i39 = i38 + 1;
                        float f29 = fArr4[i38];
                        int i46 = i39 + 1;
                        yVar.a(f27, f28, f29, z16, z17, fArr4[i39], fArr4[i46]);
                        i16 = i46 + 1;
                    } else {
                        float[] fArr5 = this.f120690c;
                        int i47 = i16 + 1;
                        int i48 = i47 + 1;
                        int i49 = i48 + 1;
                        yVar.a(fArr5[i16], fArr5[i47], fArr5[i48], fArr5[i49]);
                        i16 = i49 + 1;
                    }
                    i16 = i3;
                } else {
                    yVar.close();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class x0 extends b1 implements c1, o {

        /* renamed from: s, reason: collision with root package name */
        public Matrix f120692s;

        @Override // com.tencent.luggage.wxa.a.h.o
        public void a(Matrix matrix) {
            this.f120692s = matrix;
        }

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "text";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface y {
        void a(float f16, float f17);

        void a(float f16, float f17, float f18, float f19);

        void a(float f16, float f17, float f18, float f19, float f26, float f27);

        void a(float f16, float f17, float f18, boolean z16, boolean z17, float f19, float f26);

        void b(float f16, float f17);

        void close();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface y0 {
        c1 c();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class z extends s0 implements u {

        /* renamed from: q, reason: collision with root package name */
        public Boolean f120693q;

        /* renamed from: r, reason: collision with root package name */
        public Boolean f120694r;

        /* renamed from: s, reason: collision with root package name */
        public Matrix f120695s;

        /* renamed from: t, reason: collision with root package name */
        public q f120696t;

        /* renamed from: u, reason: collision with root package name */
        public q f120697u;

        /* renamed from: v, reason: collision with root package name */
        public q f120698v;

        /* renamed from: w, reason: collision with root package name */
        public q f120699w;

        /* renamed from: x, reason: collision with root package name */
        public String f120700x;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "pattern";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class z0 extends i0 {
        @Override // com.tencent.luggage.wxa.a.h.i0, com.tencent.luggage.wxa.a.h.k0
        public void a(o0 o0Var) {
            if (o0Var instanceof y0) {
                this.f120612i.add(o0Var);
                return;
            }
            throw new com.tencent.luggage.wxa.a.k("Text content elements cannot contain " + o0Var + " elements.");
        }
    }

    public static h a(InputStream inputStream) {
        return new com.tencent.luggage.wxa.a.l().a(inputStream, f120500g);
    }

    public static com.tencent.luggage.wxa.a.j e() {
        return null;
    }

    public List b() {
        return this.f120505e.a();
    }

    public float c() {
        if (this.f120501a != null) {
            return a(this.f120504d).f120520d;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float d() {
        if (this.f120501a != null) {
            return a(this.f120504d).f120519c;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public g0 f() {
        return this.f120501a;
    }

    public boolean g() {
        return !this.f120505e.b();
    }

    public Picture h() {
        return a((com.tencent.luggage.wxa.a.g) null);
    }

    public m0 b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.f120501a.f120638c)) {
            return this.f120501a;
        }
        if (this.f120506f.containsKey(str)) {
            return (m0) this.f120506f.get(str);
        }
        m0 a16 = a(this.f120501a, str);
        this.f120506f.put(str, a16);
        return a16;
    }

    public void e(String str) {
        this.f120502b = str;
    }

    public Picture a(com.tencent.luggage.wxa.a.g gVar) {
        q qVar;
        c cVar = (gVar == null || !gVar.e()) ? this.f120501a.f120674p : gVar.f120497d;
        if (gVar != null && gVar.f()) {
            return a((int) Math.ceil(gVar.f120499f.a()), (int) Math.ceil(gVar.f120499f.b()), gVar);
        }
        g0 g0Var = this.f120501a;
        q qVar2 = g0Var.f120608s;
        if (qVar2 != null) {
            e1 e1Var = qVar2.f120657b;
            e1 e1Var2 = e1.percent;
            if (e1Var != e1Var2 && (qVar = g0Var.f120609t) != null && qVar.f120657b != e1Var2) {
                return a((int) Math.ceil(qVar2.a(this.f120504d)), (int) Math.ceil(this.f120501a.f120609t.a(this.f120504d)), gVar);
            }
        }
        if (qVar2 != null && cVar != null) {
            return a((int) Math.ceil(qVar2.a(this.f120504d)), (int) Math.ceil((cVar.f120520d * r1) / cVar.f120519c), gVar);
        }
        q qVar3 = g0Var.f120609t;
        if (qVar3 != null && cVar != null) {
            return a((int) Math.ceil((cVar.f120519c * r1) / cVar.f120520d), (int) Math.ceil(qVar3.a(this.f120504d)), gVar);
        }
        return a(512, 512, gVar);
    }

    public o0 c(String str) {
        if (str == null) {
            return null;
        }
        String a16 = a(str);
        if (a16.length() <= 1 || !a16.startsWith("#")) {
            return null;
        }
        return b(a16.substring(1));
    }

    public void d(String str) {
        this.f120503c = str;
    }

    public Picture a(int i3, int i16, com.tencent.luggage.wxa.a.g gVar) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i3, i16);
        if (gVar == null || gVar.f120499f == null) {
            gVar = gVar == null ? new com.tencent.luggage.wxa.a.g() : new com.tencent.luggage.wxa.a.g(gVar);
            gVar.a(0.0f, 0.0f, i3, i16);
        }
        new com.tencent.luggage.wxa.a.i(beginRecording, this.f120504d).a(this, gVar);
        picture.endRecording();
        return picture;
    }

    public void a(g0 g0Var) {
        this.f120501a = g0Var;
    }

    public final String a(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", "\n");
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d0 extends m0 implements k0 {
        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "solidColor";
        }

        @Override // com.tencent.luggage.wxa.a.h.k0
        public List getChildren() {
            return Collections.emptyList();
        }

        @Override // com.tencent.luggage.wxa.a.h.k0
        public void a(o0 o0Var) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e0 extends m0 implements k0 {

        /* renamed from: h, reason: collision with root package name */
        public Float f120536h;

        @Override // com.tencent.luggage.wxa.a.h.o0
        public String g() {
            return "stop";
        }

        @Override // com.tencent.luggage.wxa.a.h.k0
        public List getChildren() {
            return Collections.emptyList();
        }

        @Override // com.tencent.luggage.wxa.a.h.k0
        public void a(o0 o0Var) {
        }
    }

    public final c a(float f16) {
        e1 e1Var;
        e1 e1Var2;
        e1 e1Var3;
        e1 e1Var4;
        float f17;
        e1 e1Var5;
        g0 g0Var = this.f120501a;
        q qVar = g0Var.f120608s;
        q qVar2 = g0Var.f120609t;
        if (qVar != null && !qVar.c() && (e1Var = qVar.f120657b) != (e1Var2 = e1.percent) && e1Var != (e1Var3 = e1.em) && e1Var != (e1Var4 = e1.ex)) {
            float a16 = qVar.a(f16);
            if (qVar2 != null) {
                if (!qVar2.c() && (e1Var5 = qVar2.f120657b) != e1Var2 && e1Var5 != e1Var3 && e1Var5 != e1Var4) {
                    f17 = qVar2.a(f16);
                } else {
                    return new c(-1.0f, -1.0f, -1.0f, -1.0f);
                }
            } else {
                c cVar = this.f120501a.f120674p;
                f17 = cVar != null ? (cVar.f120520d * a16) / cVar.f120519c : a16;
            }
            return new c(0.0f, 0.0f, a16, f17);
        }
        return new c(-1.0f, -1.0f, -1.0f, -1.0f);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f0 implements Cloneable {
        public g C;
        public List D;
        public q E;
        public Integer F;
        public b G;
        public g H;
        public EnumC5978h I;
        public f J;
        public Boolean K;
        public d L;
        public String M;
        public String N;
        public String O;
        public Boolean P;
        public Boolean Q;
        public p0 R;
        public Float S;
        public String T;
        public a U;
        public String V;
        public p0 W;
        public Float X;
        public p0 Y;
        public Float Z;

        /* renamed from: a, reason: collision with root package name */
        public long f120548a = 0;

        /* renamed from: a0, reason: collision with root package name */
        public i f120549a0;

        /* renamed from: b, reason: collision with root package name */
        public p0 f120550b;

        /* renamed from: b0, reason: collision with root package name */
        public e f120551b0;

        /* renamed from: c, reason: collision with root package name */
        public a f120552c;

        /* renamed from: d, reason: collision with root package name */
        public Float f120553d;

        /* renamed from: e, reason: collision with root package name */
        public p0 f120554e;

        /* renamed from: f, reason: collision with root package name */
        public Float f120555f;

        /* renamed from: g, reason: collision with root package name */
        public q f120556g;

        /* renamed from: h, reason: collision with root package name */
        public c f120557h;

        /* renamed from: i, reason: collision with root package name */
        public d f120558i;

        /* renamed from: j, reason: collision with root package name */
        public Float f120559j;

        /* renamed from: k, reason: collision with root package name */
        public q[] f120560k;

        /* renamed from: l, reason: collision with root package name */
        public q f120561l;

        /* renamed from: m, reason: collision with root package name */
        public Float f120562m;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum a {
            NonZero,
            EvenOdd
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum b {
            Normal,
            Italic,
            Oblique
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum c {
            Butt,
            Round,
            Square
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum d {
            Miter,
            Round,
            Bevel
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum e {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum f {
            Start,
            Middle,
            End
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum g {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.a.h$f0$h, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public enum EnumC5978h {
            LTR,
            RTL
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum i {
            None,
            NonScalingStroke
        }

        public static f0 a() {
            f0 f0Var = new f0();
            f0Var.f120548a = -1L;
            g gVar = g.f120603b;
            f0Var.f120550b = gVar;
            a aVar = a.NonZero;
            f0Var.f120552c = aVar;
            Float valueOf = Float.valueOf(1.0f);
            f0Var.f120553d = valueOf;
            f0Var.f120554e = null;
            f0Var.f120555f = valueOf;
            f0Var.f120556g = new q(1.0f);
            f0Var.f120557h = c.Butt;
            f0Var.f120558i = d.Miter;
            f0Var.f120559j = Float.valueOf(4.0f);
            f0Var.f120560k = null;
            f0Var.f120561l = new q(0.0f);
            f0Var.f120562m = valueOf;
            f0Var.C = gVar;
            f0Var.D = null;
            f0Var.E = new q(12.0f, e1.pt);
            f0Var.F = 400;
            f0Var.G = b.Normal;
            f0Var.H = g.None;
            f0Var.I = EnumC5978h.LTR;
            f0Var.J = f.Start;
            Boolean bool = Boolean.TRUE;
            f0Var.K = bool;
            f0Var.L = null;
            f0Var.M = null;
            f0Var.N = null;
            f0Var.O = null;
            f0Var.P = bool;
            f0Var.Q = bool;
            f0Var.R = gVar;
            f0Var.S = valueOf;
            f0Var.T = null;
            f0Var.U = aVar;
            f0Var.V = null;
            f0Var.W = null;
            f0Var.X = valueOf;
            f0Var.Y = null;
            f0Var.Z = valueOf;
            f0Var.f120549a0 = i.None;
            f0Var.f120551b0 = e.auto;
            return f0Var;
        }

        public Object clone() {
            f0 f0Var = (f0) super.clone();
            q[] qVarArr = this.f120560k;
            if (qVarArr != null) {
                f0Var.f120560k = (q[]) qVarArr.clone();
            }
            return f0Var;
        }

        public void a(boolean z16) {
            Boolean bool = Boolean.TRUE;
            this.P = bool;
            if (!z16) {
                bool = Boolean.FALSE;
            }
            this.K = bool;
            this.L = null;
            this.T = null;
            this.f120562m = Float.valueOf(1.0f);
            this.R = g.f120603b;
            this.S = Float.valueOf(1.0f);
            this.V = null;
            this.W = null;
            this.X = Float.valueOf(1.0f);
            this.Y = null;
            this.Z = Float.valueOf(1.0f);
            this.f120549a0 = i.None;
        }
    }

    public void a(b.r rVar) {
        this.f120505e.a(rVar);
    }

    public void a() {
        this.f120505e.a(b.u.RenderOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m0 a(k0 k0Var, String str) {
        m0 a16;
        m0 m0Var = (m0) k0Var;
        if (str.equals(m0Var.f120638c)) {
            return m0Var;
        }
        for (Object obj : k0Var.getChildren()) {
            if (obj instanceof m0) {
                m0 m0Var2 = (m0) obj;
                if (str.equals(m0Var2.f120638c)) {
                    return m0Var2;
                }
                if ((obj instanceof k0) && (a16 = a((k0) obj, str)) != null) {
                    return a16;
                }
            }
        }
        return null;
    }
}
