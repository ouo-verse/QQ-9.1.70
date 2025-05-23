package com.qzone.jbox2d.collision;

import com.qzone.jbox2d.collision.b;
import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Sweep;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public b.C0398b f48048a;

    /* renamed from: b, reason: collision with root package name */
    public b.C0398b f48049b;

    /* renamed from: c, reason: collision with root package name */
    public Type f48050c;

    /* renamed from: f, reason: collision with root package name */
    public Sweep f48053f;

    /* renamed from: g, reason: collision with root package name */
    public Sweep f48054g;

    /* renamed from: d, reason: collision with root package name */
    public final Vec2 f48051d = new Vec2();

    /* renamed from: e, reason: collision with root package name */
    public final Vec2 f48052e = new Vec2();

    /* renamed from: h, reason: collision with root package name */
    private final Vec2 f48055h = new Vec2();

    /* renamed from: i, reason: collision with root package name */
    private final Vec2 f48056i = new Vec2();

    /* renamed from: j, reason: collision with root package name */
    private final Vec2 f48057j = new Vec2();

    /* renamed from: k, reason: collision with root package name */
    private final Vec2 f48058k = new Vec2();

    /* renamed from: l, reason: collision with root package name */
    private final Vec2 f48059l = new Vec2();

    /* renamed from: m, reason: collision with root package name */
    private final Vec2 f48060m = new Vec2();

    /* renamed from: n, reason: collision with root package name */
    private final Vec2 f48061n = new Vec2();

    /* renamed from: o, reason: collision with root package name */
    private final Vec2 f48062o = new Vec2();

    /* renamed from: p, reason: collision with root package name */
    private final Vec2 f48063p = new Vec2();

    /* renamed from: q, reason: collision with root package name */
    private final Vec2 f48064q = new Vec2();

    /* renamed from: r, reason: collision with root package name */
    private final Transform f48065r = new Transform();

    /* renamed from: s, reason: collision with root package name */
    private final Transform f48066s = new Transform();

    /* renamed from: t, reason: collision with root package name */
    private final Vec2 f48067t = new Vec2();

    /* renamed from: u, reason: collision with root package name */
    private final Vec2 f48068u = new Vec2();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f48069a;

        static {
            int[] iArr = new int[Type.values().length];
            f48069a = iArr;
            try {
                iArr[Type.POINTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48069a[Type.FACE_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48069a[Type.FACE_B.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public float a(int i3, int i16, float f16) {
        this.f48053f.getTransform(this.f48065r, f16);
        this.f48054g.getTransform(this.f48066s, f16);
        int i17 = a.f48069a[this.f48050c.ordinal()];
        if (i17 == 1) {
            this.f48055h.set(this.f48048a.b(i3));
            this.f48056i.set(this.f48049b.b(i16));
            Transform.mulToOutUnsafe(this.f48065r, this.f48055h, this.f48057j);
            Transform.mulToOutUnsafe(this.f48066s, this.f48056i, this.f48058k);
            return Vec2.dot(this.f48058k.subLocal(this.f48057j), this.f48052e);
        }
        if (i17 == 2) {
            Rot.mulToOutUnsafe(this.f48065r.f48118q, this.f48052e, this.f48061n);
            Transform.mulToOutUnsafe(this.f48065r, this.f48051d, this.f48057j);
            this.f48056i.set(this.f48049b.b(i16));
            Transform.mulToOutUnsafe(this.f48066s, this.f48056i, this.f48058k);
            return Vec2.dot(this.f48058k.subLocal(this.f48057j), this.f48061n);
        }
        if (i17 != 3) {
            return 0.0f;
        }
        Rot.mulToOutUnsafe(this.f48066s.f48118q, this.f48052e, this.f48061n);
        Transform.mulToOutUnsafe(this.f48066s, this.f48051d, this.f48058k);
        this.f48055h.set(this.f48048a.b(i3));
        Transform.mulToOutUnsafe(this.f48065r, this.f48055h, this.f48057j);
        return Vec2.dot(this.f48057j.subLocal(this.f48058k), this.f48061n);
    }

    public float b(int[] iArr, float f16) {
        this.f48053f.getTransform(this.f48065r, f16);
        this.f48054g.getTransform(this.f48066s, f16);
        int i3 = a.f48069a[this.f48050c.ordinal()];
        if (i3 == 1) {
            Rot.mulTransUnsafe(this.f48065r.f48118q, this.f48052e, this.f48067t);
            Rot.mulTransUnsafe(this.f48066s.f48118q, this.f48052e.negateLocal(), this.f48068u);
            this.f48052e.negateLocal();
            iArr[0] = this.f48048a.a(this.f48067t);
            iArr[1] = this.f48049b.a(this.f48068u);
            this.f48055h.set(this.f48048a.b(iArr[0]));
            this.f48056i.set(this.f48049b.b(iArr[1]));
            Transform.mulToOutUnsafe(this.f48065r, this.f48055h, this.f48057j);
            Transform.mulToOutUnsafe(this.f48066s, this.f48056i, this.f48058k);
            return Vec2.dot(this.f48058k.subLocal(this.f48057j), this.f48052e);
        }
        if (i3 == 2) {
            Rot.mulToOutUnsafe(this.f48065r.f48118q, this.f48052e, this.f48061n);
            Transform.mulToOutUnsafe(this.f48065r, this.f48051d, this.f48057j);
            Rot.mulTransUnsafe(this.f48066s.f48118q, this.f48061n.negateLocal(), this.f48068u);
            this.f48061n.negateLocal();
            iArr[0] = -1;
            int a16 = this.f48049b.a(this.f48068u);
            iArr[1] = a16;
            this.f48056i.set(this.f48049b.b(a16));
            Transform.mulToOutUnsafe(this.f48066s, this.f48056i, this.f48058k);
            return Vec2.dot(this.f48058k.subLocal(this.f48057j), this.f48061n);
        }
        if (i3 != 3) {
            iArr[0] = -1;
            iArr[1] = -1;
            return 0.0f;
        }
        Rot.mulToOutUnsafe(this.f48066s.f48118q, this.f48052e, this.f48061n);
        Transform.mulToOutUnsafe(this.f48066s, this.f48051d, this.f48058k);
        Rot.mulTransUnsafe(this.f48065r.f48118q, this.f48061n.negateLocal(), this.f48067t);
        this.f48061n.negateLocal();
        iArr[1] = -1;
        int a17 = this.f48048a.a(this.f48067t);
        iArr[0] = a17;
        this.f48055h.set(this.f48048a.b(a17));
        Transform.mulToOutUnsafe(this.f48065r, this.f48055h, this.f48057j);
        return Vec2.dot(this.f48057j.subLocal(this.f48058k), this.f48061n);
    }

    public float c(b.d dVar, b.C0398b c0398b, Sweep sweep, b.C0398b c0398b2, Sweep sweep2, float f16) {
        this.f48048a = c0398b;
        this.f48049b = c0398b2;
        int i3 = dVar.f48020b;
        this.f48053f = sweep;
        this.f48054g = sweep2;
        sweep.getTransform(this.f48065r, f16);
        this.f48054g.getTransform(this.f48066s, f16);
        if (i3 == 1) {
            this.f48050c = Type.POINTS;
            this.f48055h.set(this.f48048a.b(dVar.f48021c[0]));
            this.f48056i.set(this.f48049b.b(dVar.f48022d[0]));
            Transform.mulToOutUnsafe(this.f48065r, this.f48055h, this.f48057j);
            Transform.mulToOutUnsafe(this.f48066s, this.f48056i, this.f48058k);
            this.f48052e.set(this.f48058k).subLocal(this.f48057j);
            return this.f48052e.normalize();
        }
        int[] iArr = dVar.f48021c;
        int i16 = iArr[0];
        if (i16 == iArr[1]) {
            this.f48050c = Type.FACE_B;
            this.f48062o.set(this.f48049b.b(dVar.f48022d[0]));
            this.f48063p.set(this.f48049b.b(dVar.f48022d[1]));
            this.f48064q.set(this.f48063p).subLocal(this.f48062o);
            Vec2.crossToOutUnsafe(this.f48064q, 1.0f, this.f48052e);
            this.f48052e.normalize();
            Rot.mulToOutUnsafe(this.f48066s.f48118q, this.f48052e, this.f48061n);
            this.f48051d.set(this.f48062o).addLocal(this.f48063p).mulLocal(0.5f);
            Transform.mulToOutUnsafe(this.f48066s, this.f48051d, this.f48058k);
            this.f48055h.set(c0398b.b(dVar.f48021c[0]));
            Transform.mulToOutUnsafe(this.f48065r, this.f48055h, this.f48057j);
            this.f48064q.set(this.f48057j).subLocal(this.f48058k);
            float dot = Vec2.dot(this.f48064q, this.f48061n);
            if (dot >= 0.0f) {
                return dot;
            }
            this.f48052e.negateLocal();
            return -dot;
        }
        this.f48050c = Type.FACE_A;
        this.f48059l.set(this.f48048a.b(i16));
        this.f48060m.set(this.f48048a.b(dVar.f48021c[1]));
        this.f48064q.set(this.f48060m).subLocal(this.f48059l);
        Vec2.crossToOutUnsafe(this.f48064q, 1.0f, this.f48052e);
        this.f48052e.normalize();
        Rot.mulToOutUnsafe(this.f48065r.f48118q, this.f48052e, this.f48061n);
        this.f48051d.set(this.f48059l).addLocal(this.f48060m).mulLocal(0.5f);
        Transform.mulToOutUnsafe(this.f48065r, this.f48051d, this.f48057j);
        this.f48056i.set(this.f48049b.b(dVar.f48022d[0]));
        Transform.mulToOutUnsafe(this.f48066s, this.f48056i, this.f48058k);
        this.f48064q.set(this.f48058k).subLocal(this.f48057j);
        float dot2 = Vec2.dot(this.f48064q, this.f48061n);
        if (dot2 >= 0.0f) {
            return dot2;
        }
        this.f48052e.negateLocal();
        return -dot2;
    }
}
