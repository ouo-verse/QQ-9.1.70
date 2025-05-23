package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ShapeOperator implements e, q.d {

    /* renamed from: a, reason: collision with root package name */
    private float f68302a;

    /* renamed from: b, reason: collision with root package name */
    private float f68303b;

    /* renamed from: d, reason: collision with root package name */
    private int f68305d;

    /* renamed from: e, reason: collision with root package name */
    private int f68306e;

    /* renamed from: f, reason: collision with root package name */
    private Context f68307f;

    /* renamed from: g, reason: collision with root package name */
    private Shape f68308g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f68309h;

    /* renamed from: i, reason: collision with root package name */
    private int f68310i;

    /* renamed from: j, reason: collision with root package name */
    private float f68311j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f68312k;

    /* renamed from: m, reason: collision with root package name */
    private q f68314m;

    /* renamed from: n, reason: collision with root package name */
    private q f68315n;

    /* renamed from: o, reason: collision with root package name */
    private q f68316o;

    /* renamed from: q, reason: collision with root package name */
    private q.d f68318q;

    /* renamed from: c, reason: collision with root package name */
    private float f68304c = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    private boolean f68313l = false;

    /* renamed from: p, reason: collision with root package name */
    private final LinkedList<q> f68317p = new LinkedList<>();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public enum Shape {
        RECT_HOLLOW,
        RECT,
        OVAL_HOLLOW,
        OVAL,
        LINE,
        ARROW,
        SEQUENCE_NUMBER
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68319a;

        static {
            int[] iArr = new int[Shape.values().length];
            f68319a = iArr;
            try {
                iArr[Shape.RECT_HOLLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68319a[Shape.OVAL_HOLLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68319a[Shape.ARROW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68319a[Shape.LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ShapeOperator(Context context) {
        this.f68307f = context;
    }

    private void E(MotionEvent motionEvent) {
        Shape shape;
        q p16 = p((int) ((motionEvent.getX() - this.f68302a) / this.f68304c), (int) ((motionEvent.getY() - this.f68303b) / this.f68304c));
        this.f68316o = p16;
        if (p16 != null) {
            this.f68317p.remove(p16);
            this.f68317p.add(this.f68316o);
        }
        if (this.f68316o != null || u() || (shape = this.f68308g) == null) {
            return;
        }
        this.f68315n = j(shape, this.f68307f, this.f68311j, this.f68310i, this);
    }

    private boolean l(MotionEvent motionEvent) {
        q qVar = this.f68315n;
        if (qVar != null) {
            return qVar.W(motionEvent);
        }
        q qVar2 = this.f68316o;
        if (qVar2 != null) {
            return qVar2.W(motionEvent);
        }
        return false;
    }

    private void n(Canvas canvas, boolean z16) {
        Iterator<q> it = this.f68317p.iterator();
        while (it.hasNext()) {
            q next = it.next();
            boolean z17 = true;
            next.h0(!z16 && next == this.f68316o);
            if (z16 || this.f68312k || next != this.f68314m) {
                z17 = false;
            }
            next.J(z17);
            next.X(canvas);
        }
        q qVar = this.f68315n;
        if (qVar != null) {
            qVar.X(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r4.f68316o.M(r1, r2) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private q p(int i3, int i16) {
        q qVar = this.f68316o;
        if (qVar != null) {
            if (!qVar.v(i3, i16) && !this.f68316o.t(i3, i16)) {
                float f16 = i3;
                float f17 = i16;
                if (!this.f68316o.K(f16, f17)) {
                }
            }
            return this.f68316o;
        }
        Iterator<q> descendingIterator = this.f68317p.descendingIterator();
        while (descendingIterator.hasNext()) {
            q next = descendingIterator.next();
            if (next.t(i3, i16) || next.M(i3, i16)) {
                return next;
            }
        }
        return null;
    }

    private void q(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            q qVar = this.f68315n;
            if (qVar != null) {
                if (qVar.Q()) {
                    this.f68317p.add(this.f68315n);
                    this.f68314m = this.f68315n;
                } else {
                    this.f68314m = null;
                }
                this.f68315n = null;
                return;
            }
            if (this.f68316o != this.f68314m) {
                this.f68314m = null;
                return;
            }
            return;
        }
        if (motionEvent.getAction() != 3 || this.f68315n == null) {
            return;
        }
        this.f68315n = null;
    }

    private boolean u() {
        return this.f68309h;
    }

    public boolean A(float f16) {
        ms.a.a("ShapeOperator", "setPenWidthFactor: " + f16);
        this.f68311j = f16;
        return false;
    }

    public boolean B(int i3) {
        ms.a.a("ShapeOperator", "setSelectedShapeColor: " + i3);
        q qVar = this.f68316o;
        if (qVar == null) {
            return false;
        }
        qVar.f0(i3);
        return true;
    }

    public boolean C(float f16) {
        ms.a.a("ShapeOperator", "setSelectedShapePenWidthFactor: " + f16);
        q qVar = this.f68316o;
        if (qVar == null) {
            return false;
        }
        qVar.g0(f16);
        return true;
    }

    public void D(int i3, int i16) {
        ms.a.a("ShapeOperator", "setViewSize: " + i3 + HippyTKDListViewAdapter.X + i16);
        this.f68305d = i3;
        this.f68306e = i16;
    }

    public boolean F(MotionEvent motionEvent) {
        return p((int) ((motionEvent.getX() - this.f68302a) / this.f68304c), (int) ((motionEvent.getY() - this.f68303b) / this.f68304c)) != null;
    }

    public void G() {
        if (this.f68317p.isEmpty()) {
            return;
        }
        if (this.f68316o == this.f68317p.removeLast()) {
            this.f68316o = null;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
    public void a() {
        q.d dVar = this.f68318q;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
    public void b(q qVar) {
        q.d dVar = this.f68318q;
        if (dVar != null) {
            dVar.b(this.f68316o);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
    public void c(q qVar, MotionEvent motionEvent) {
        q.d dVar = this.f68318q;
        if (dVar != null) {
            dVar.c(qVar, motionEvent);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
    public void d(q qVar, RectF rectF) {
        ms.a.f("ShapeOperator", "onClickTips---");
        q.d dVar = this.f68318q;
        if (dVar != null) {
            dVar.d(qVar, rectF);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
    public void e(q qVar, MotionEvent motionEvent) {
        q.d dVar = this.f68318q;
        if (dVar != null) {
            dVar.e(qVar, motionEvent);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
    public void f(q qVar, MotionEvent motionEvent) {
        q.d dVar = this.f68318q;
        if (dVar != null) {
            dVar.f(qVar, motionEvent);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.q.d
    public void g() {
        q.d dVar;
        if (this.f68313l || (dVar = this.f68318q) == null) {
            return;
        }
        dVar.g();
    }

    public void h() {
        this.f68317p.clear();
        this.f68315n = null;
        this.f68316o = null;
    }

    public boolean i() {
        boolean z16;
        if (this.f68314m != null) {
            this.f68314m = null;
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f68316o == null) {
            return z16;
        }
        this.f68316o = null;
        q.d dVar = this.f68318q;
        if (dVar == null) {
            return true;
        }
        dVar.a();
        return true;
    }

    protected q j(Shape shape, Context context, float f16, int i3, q.d dVar) {
        q qVar = new q(context, shape, f16, i3);
        qVar.e0(dVar);
        return qVar;
    }

    public void k() {
        q qVar = this.f68316o;
        if (qVar != null) {
            this.f68317p.remove(qVar);
            this.f68316o = null;
            q.d dVar = this.f68318q;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f68312k = true;
            this.f68313l = (this.f68316o == null && this.f68314m == null) ? false : true;
            E(motionEvent);
        }
        boolean l3 = l(motionEvent);
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            q(motionEvent);
            this.f68312k = false;
        }
        return l3;
    }

    public String r() {
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.f68317p.iterator();
        while (it.hasNext()) {
            Shape G = it.next().G();
            if (G != null) {
                int i3 = a.f68319a[G.ordinal()];
                if (i3 == 1) {
                    hashSet.add(1);
                } else if (i3 == 2) {
                    hashSet.add(2);
                } else if (i3 == 3) {
                    hashSet.add(3);
                } else if (i3 == 4) {
                    hashSet.add(4);
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            sb5.append((Integer) it5.next());
            sb5.append("|");
        }
        if (sb5.length() > 0) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        return sb5.toString();
    }

    public q s() {
        return this.f68316o;
    }

    public int t() {
        return this.f68317p.size();
    }

    public boolean v() {
        return this.f68317p.isEmpty();
    }

    public boolean x(int i3) {
        ms.a.a("ShapeOperator", "setColor: " + i3);
        this.f68310i = i3;
        return false;
    }

    public void y(q.d dVar) {
        this.f68318q = dVar;
    }

    public boolean z(Shape shape) {
        ms.a.a("ShapeOperator", "setMode: " + shape);
        this.f68308g = shape;
        return false;
    }

    public void m(Canvas canvas) {
        n(canvas, false);
    }

    public void o() {
        this.f68309h = false;
    }

    public void w(Canvas canvas) {
        n(canvas, true);
    }
}
