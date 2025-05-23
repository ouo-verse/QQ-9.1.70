package com.qzone.jbox2d.collision;

import com.qzone.jbox2d.collision.ContactID;
import com.qzone.jbox2d.collision.Manifold;
import com.qzone.jbox2d.collision.b;
import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Collision {

    /* renamed from: z, reason: collision with root package name */
    private static Vec2 f47884z = new Vec2();

    /* renamed from: a, reason: collision with root package name */
    private final k7.b f47885a;

    /* renamed from: k, reason: collision with root package name */
    private final a[] f47895k;

    /* renamed from: r, reason: collision with root package name */
    private final a[] f47902r;

    /* renamed from: s, reason: collision with root package name */
    private final a[] f47903s;

    /* renamed from: b, reason: collision with root package name */
    private final com.qzone.jbox2d.collision.c f47886b = new com.qzone.jbox2d.collision.c();

    /* renamed from: c, reason: collision with root package name */
    private final b.d f47887c = new b.d();

    /* renamed from: d, reason: collision with root package name */
    private final com.qzone.jbox2d.collision.d f47888d = new com.qzone.jbox2d.collision.d();

    /* renamed from: e, reason: collision with root package name */
    private final Vec2 f47889e = new Vec2();

    /* renamed from: f, reason: collision with root package name */
    private final Transform f47890f = new Transform();

    /* renamed from: g, reason: collision with root package name */
    private final Vec2 f47891g = new Vec2();

    /* renamed from: h, reason: collision with root package name */
    private final Vec2 f47892h = new Vec2();

    /* renamed from: i, reason: collision with root package name */
    private final c f47893i = new c();

    /* renamed from: j, reason: collision with root package name */
    private final c f47894j = new c();

    /* renamed from: l, reason: collision with root package name */
    private final Vec2 f47896l = new Vec2();

    /* renamed from: m, reason: collision with root package name */
    private final Vec2 f47897m = new Vec2();

    /* renamed from: n, reason: collision with root package name */
    private final Vec2 f47898n = new Vec2();

    /* renamed from: o, reason: collision with root package name */
    private final Vec2 f47899o = new Vec2();

    /* renamed from: p, reason: collision with root package name */
    private final Vec2 f47900p = new Vec2();

    /* renamed from: q, reason: collision with root package name */
    private final Vec2 f47901q = new Vec2();

    /* renamed from: t, reason: collision with root package name */
    private final Vec2 f47904t = new Vec2();

    /* renamed from: u, reason: collision with root package name */
    private final Vec2 f47905u = new Vec2();

    /* renamed from: v, reason: collision with root package name */
    private final ContactID f47906v = new ContactID();

    /* renamed from: w, reason: collision with root package name */
    private final Vec2 f47907w = new Vec2();

    /* renamed from: x, reason: collision with root package name */
    private final Vec2 f47908x = new Vec2();

    /* renamed from: y, reason: collision with root package name */
    private final b f47909y = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class EPAxis {

        /* renamed from: a, reason: collision with root package name */
        Type f47910a;

        /* renamed from: b, reason: collision with root package name */
        int f47911b;

        /* renamed from: c, reason: collision with root package name */
        float f47912c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes39.dex */
        public enum Type {
            UNKNOWN,
            EDGE_A,
            EDGE_B
        }

        EPAxis() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Vec2 f47913a = new Vec2();

        /* renamed from: b, reason: collision with root package name */
        public final ContactID f47914b = new ContactID();

        public void a(a aVar) {
            Vec2 vec2 = aVar.f47913a;
            Vec2 vec22 = this.f47913a;
            vec22.f48119x = vec2.f48119x;
            vec22.f48120y = vec2.f48120y;
            ContactID contactID = aVar.f47914b;
            ContactID contactID2 = this.f47914b;
            contactID2.f47955d = contactID.f47955d;
            contactID2.f47956e = contactID.f47956e;
            contactID2.f47957f = contactID.f47957f;
            contactID2.f47958h = contactID.f47958h;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static class b {

        /* renamed from: n, reason: collision with root package name */
        float f47928n;

        /* renamed from: o, reason: collision with root package name */
        boolean f47929o;

        /* renamed from: a, reason: collision with root package name */
        final e f47915a = new e();

        /* renamed from: b, reason: collision with root package name */
        final Transform f47916b = new Transform();

        /* renamed from: c, reason: collision with root package name */
        final Vec2 f47917c = new Vec2();

        /* renamed from: d, reason: collision with root package name */
        Vec2 f47918d = new Vec2();

        /* renamed from: e, reason: collision with root package name */
        Vec2 f47919e = new Vec2();

        /* renamed from: f, reason: collision with root package name */
        Vec2 f47920f = new Vec2();

        /* renamed from: g, reason: collision with root package name */
        Vec2 f47921g = new Vec2();

        /* renamed from: h, reason: collision with root package name */
        final Vec2 f47922h = new Vec2();

        /* renamed from: i, reason: collision with root package name */
        final Vec2 f47923i = new Vec2();

        /* renamed from: j, reason: collision with root package name */
        final Vec2 f47924j = new Vec2();

        /* renamed from: k, reason: collision with root package name */
        final Vec2 f47925k = new Vec2();

        /* renamed from: l, reason: collision with root package name */
        final Vec2 f47926l = new Vec2();

        /* renamed from: m, reason: collision with root package name */
        final Vec2 f47927m = new Vec2();

        /* renamed from: p, reason: collision with root package name */
        private final Vec2 f47930p = new Vec2();

        /* renamed from: q, reason: collision with root package name */
        private final Vec2 f47931q = new Vec2();

        /* renamed from: r, reason: collision with root package name */
        private final Vec2 f47932r = new Vec2();

        /* renamed from: s, reason: collision with root package name */
        private final Vec2 f47933s = new Vec2();

        /* renamed from: t, reason: collision with root package name */
        private final a[] f47934t = new a[2];

        /* renamed from: u, reason: collision with root package name */
        private final a[] f47935u = new a[2];

        /* renamed from: v, reason: collision with root package name */
        private final a[] f47936v = new a[2];

        /* renamed from: w, reason: collision with root package name */
        private final d f47937w = new d();

        /* renamed from: x, reason: collision with root package name */
        private final EPAxis f47938x = new EPAxis();

        /* renamed from: y, reason: collision with root package name */
        private final EPAxis f47939y = new EPAxis();

        /* renamed from: z, reason: collision with root package name */
        private final Vec2 f47940z = new Vec2();
        private final Vec2 A = new Vec2();

        public b() {
            for (int i3 = 0; i3 < 2; i3++) {
                this.f47934t[i3] = new a();
                this.f47935u[i3] = new a();
                this.f47936v[i3] = new a();
            }
        }

        public void a(Manifold manifold, com.qzone.jbox2d.collision.shapes.c cVar, Transform transform, com.qzone.jbox2d.collision.shapes.e eVar, Transform transform2) {
            float f16;
            boolean z16;
            float f17;
            boolean z17;
            e eVar2;
            int i3;
            Transform.mulTransToOutUnsafe(transform, transform2, this.f47916b);
            Transform.mulToOutUnsafe(this.f47916b, eVar.f48094c, this.f47917c);
            this.f47918d = cVar.f48086e;
            this.f47919e = cVar.f48084c;
            Vec2 vec2 = cVar.f48085d;
            this.f47920f = vec2;
            this.f47921g = cVar.f48087f;
            boolean z18 = cVar.f48088g;
            boolean z19 = cVar.f48089h;
            this.f47930p.set(vec2).subLocal(this.f47919e);
            this.f47930p.normalize();
            Vec2 vec22 = this.f47923i;
            Vec2 vec23 = this.f47930p;
            vec22.set(vec23.f48120y, -vec23.f48119x);
            float dot = Vec2.dot(this.f47923i, this.f47931q.set(this.f47917c).subLocal(this.f47919e));
            if (z18) {
                this.f47932r.set(this.f47919e).subLocal(this.f47918d);
                this.f47932r.normalize();
                Vec2 vec24 = this.f47922h;
                Vec2 vec25 = this.f47932r;
                vec24.set(vec25.f48120y, -vec25.f48119x);
                z16 = Vec2.cross(this.f47932r, this.f47930p) >= 0.0f;
                f16 = Vec2.dot(this.f47922h, this.f47931q.set(this.f47917c).subLocal(this.f47918d));
            } else {
                f16 = 0.0f;
                z16 = false;
            }
            if (z19) {
                this.f47933s.set(this.f47921g).subLocal(this.f47920f);
                this.f47933s.normalize();
                Vec2 vec26 = this.f47924j;
                Vec2 vec27 = this.f47933s;
                vec26.set(vec27.f48120y, -vec27.f48119x);
                z17 = Vec2.cross(this.f47930p, this.f47933s) > 0.0f;
                f17 = Vec2.dot(this.f47924j, this.f47931q.set(this.f47917c).subLocal(this.f47920f));
            } else {
                f17 = 0.0f;
                z17 = false;
            }
            if (z18 && z19) {
                if (z16 && z17) {
                    boolean z26 = f16 >= 0.0f || dot >= 0.0f || f17 >= 0.0f;
                    this.f47929o = z26;
                    if (z26) {
                        Vec2 vec28 = this.f47925k;
                        Vec2 vec29 = this.f47923i;
                        vec28.f48119x = vec29.f48119x;
                        vec28.f48120y = vec29.f48120y;
                        Vec2 vec210 = this.f47926l;
                        Vec2 vec211 = this.f47922h;
                        vec210.f48119x = vec211.f48119x;
                        vec210.f48120y = vec211.f48120y;
                        Vec2 vec212 = this.f47927m;
                        Vec2 vec213 = this.f47924j;
                        vec212.f48119x = vec213.f48119x;
                        vec212.f48120y = vec213.f48120y;
                    } else {
                        Vec2 vec214 = this.f47925k;
                        Vec2 vec215 = this.f47923i;
                        vec214.f48119x = -vec215.f48119x;
                        vec214.f48120y = -vec215.f48120y;
                        Vec2 vec216 = this.f47926l;
                        vec216.f48119x = -vec215.f48119x;
                        vec216.f48120y = -vec215.f48120y;
                        Vec2 vec217 = this.f47927m;
                        vec217.f48119x = -vec215.f48119x;
                        vec217.f48120y = -vec215.f48120y;
                    }
                } else if (z16) {
                    boolean z27 = f16 >= 0.0f || (dot >= 0.0f && f17 >= 0.0f);
                    this.f47929o = z27;
                    if (z27) {
                        Vec2 vec218 = this.f47925k;
                        Vec2 vec219 = this.f47923i;
                        vec218.f48119x = vec219.f48119x;
                        vec218.f48120y = vec219.f48120y;
                        Vec2 vec220 = this.f47926l;
                        Vec2 vec221 = this.f47922h;
                        vec220.f48119x = vec221.f48119x;
                        vec220.f48120y = vec221.f48120y;
                        Vec2 vec222 = this.f47927m;
                        vec222.f48119x = vec219.f48119x;
                        vec222.f48120y = vec219.f48120y;
                    } else {
                        Vec2 vec223 = this.f47925k;
                        Vec2 vec224 = this.f47923i;
                        vec223.f48119x = -vec224.f48119x;
                        vec223.f48120y = -vec224.f48120y;
                        Vec2 vec225 = this.f47926l;
                        Vec2 vec226 = this.f47924j;
                        vec225.f48119x = -vec226.f48119x;
                        vec225.f48120y = -vec226.f48120y;
                        Vec2 vec227 = this.f47927m;
                        vec227.f48119x = -vec224.f48119x;
                        vec227.f48120y = -vec224.f48120y;
                    }
                } else if (z17) {
                    boolean z28 = f17 >= 0.0f || (f16 >= 0.0f && dot >= 0.0f);
                    this.f47929o = z28;
                    if (z28) {
                        Vec2 vec228 = this.f47925k;
                        Vec2 vec229 = this.f47923i;
                        vec228.f48119x = vec229.f48119x;
                        vec228.f48120y = vec229.f48120y;
                        Vec2 vec230 = this.f47926l;
                        vec230.f48119x = vec229.f48119x;
                        vec230.f48120y = vec229.f48120y;
                        Vec2 vec231 = this.f47927m;
                        Vec2 vec232 = this.f47924j;
                        vec231.f48119x = vec232.f48119x;
                        vec231.f48120y = vec232.f48120y;
                    } else {
                        Vec2 vec233 = this.f47925k;
                        Vec2 vec234 = this.f47923i;
                        vec233.f48119x = -vec234.f48119x;
                        vec233.f48120y = -vec234.f48120y;
                        Vec2 vec235 = this.f47926l;
                        vec235.f48119x = -vec234.f48119x;
                        vec235.f48120y = -vec234.f48120y;
                        Vec2 vec236 = this.f47927m;
                        Vec2 vec237 = this.f47922h;
                        vec236.f48119x = -vec237.f48119x;
                        vec236.f48120y = -vec237.f48120y;
                    }
                } else {
                    boolean z29 = f16 >= 0.0f && dot >= 0.0f && f17 >= 0.0f;
                    this.f47929o = z29;
                    if (z29) {
                        Vec2 vec238 = this.f47925k;
                        Vec2 vec239 = this.f47923i;
                        vec238.f48119x = vec239.f48119x;
                        vec238.f48120y = vec239.f48120y;
                        Vec2 vec240 = this.f47926l;
                        vec240.f48119x = vec239.f48119x;
                        vec240.f48120y = vec239.f48120y;
                        Vec2 vec241 = this.f47927m;
                        vec241.f48119x = vec239.f48119x;
                        vec241.f48120y = vec239.f48120y;
                    } else {
                        Vec2 vec242 = this.f47925k;
                        Vec2 vec243 = this.f47923i;
                        vec242.f48119x = -vec243.f48119x;
                        vec242.f48120y = -vec243.f48120y;
                        Vec2 vec244 = this.f47926l;
                        Vec2 vec245 = this.f47924j;
                        vec244.f48119x = -vec245.f48119x;
                        vec244.f48120y = -vec245.f48120y;
                        Vec2 vec246 = this.f47927m;
                        Vec2 vec247 = this.f47922h;
                        vec246.f48119x = -vec247.f48119x;
                        vec246.f48120y = -vec247.f48120y;
                    }
                }
            } else if (z18) {
                if (z16) {
                    boolean z36 = f16 >= 0.0f || dot >= 0.0f;
                    this.f47929o = z36;
                    if (z36) {
                        Vec2 vec248 = this.f47925k;
                        Vec2 vec249 = this.f47923i;
                        vec248.f48119x = vec249.f48119x;
                        vec248.f48120y = vec249.f48120y;
                        Vec2 vec250 = this.f47926l;
                        Vec2 vec251 = this.f47922h;
                        vec250.f48119x = vec251.f48119x;
                        vec250.f48120y = vec251.f48120y;
                        Vec2 vec252 = this.f47927m;
                        vec252.f48119x = -vec249.f48119x;
                        vec252.f48120y = -vec249.f48120y;
                    } else {
                        Vec2 vec253 = this.f47925k;
                        Vec2 vec254 = this.f47923i;
                        vec253.f48119x = -vec254.f48119x;
                        vec253.f48120y = -vec254.f48120y;
                        Vec2 vec255 = this.f47926l;
                        vec255.f48119x = vec254.f48119x;
                        vec255.f48120y = vec254.f48120y;
                        Vec2 vec256 = this.f47927m;
                        vec256.f48119x = -vec254.f48119x;
                        vec256.f48120y = -vec254.f48120y;
                    }
                } else {
                    boolean z37 = f16 >= 0.0f && dot >= 0.0f;
                    this.f47929o = z37;
                    if (z37) {
                        Vec2 vec257 = this.f47925k;
                        Vec2 vec258 = this.f47923i;
                        vec257.f48119x = vec258.f48119x;
                        vec257.f48120y = vec258.f48120y;
                        Vec2 vec259 = this.f47926l;
                        vec259.f48119x = vec258.f48119x;
                        vec259.f48120y = vec258.f48120y;
                        Vec2 vec260 = this.f47927m;
                        vec260.f48119x = -vec258.f48119x;
                        vec260.f48120y = -vec258.f48120y;
                    } else {
                        Vec2 vec261 = this.f47925k;
                        Vec2 vec262 = this.f47923i;
                        vec261.f48119x = -vec262.f48119x;
                        vec261.f48120y = -vec262.f48120y;
                        Vec2 vec263 = this.f47926l;
                        vec263.f48119x = vec262.f48119x;
                        vec263.f48120y = vec262.f48120y;
                        Vec2 vec264 = this.f47927m;
                        Vec2 vec265 = this.f47922h;
                        vec264.f48119x = -vec265.f48119x;
                        vec264.f48120y = -vec265.f48120y;
                    }
                }
            } else if (!z19) {
                boolean z38 = dot >= 0.0f;
                this.f47929o = z38;
                if (z38) {
                    Vec2 vec266 = this.f47925k;
                    Vec2 vec267 = this.f47923i;
                    vec266.f48119x = vec267.f48119x;
                    vec266.f48120y = vec267.f48120y;
                    Vec2 vec268 = this.f47926l;
                    vec268.f48119x = -vec267.f48119x;
                    vec268.f48120y = -vec267.f48120y;
                    Vec2 vec269 = this.f47927m;
                    vec269.f48119x = -vec267.f48119x;
                    vec269.f48120y = -vec267.f48120y;
                } else {
                    Vec2 vec270 = this.f47925k;
                    Vec2 vec271 = this.f47923i;
                    vec270.f48119x = -vec271.f48119x;
                    vec270.f48120y = -vec271.f48120y;
                    Vec2 vec272 = this.f47926l;
                    vec272.f48119x = vec271.f48119x;
                    vec272.f48120y = vec271.f48120y;
                    Vec2 vec273 = this.f47927m;
                    vec273.f48119x = vec271.f48119x;
                    vec273.f48120y = vec271.f48120y;
                }
            } else if (z17) {
                boolean z39 = dot >= 0.0f || f17 >= 0.0f;
                this.f47929o = z39;
                if (z39) {
                    Vec2 vec274 = this.f47925k;
                    Vec2 vec275 = this.f47923i;
                    vec274.f48119x = vec275.f48119x;
                    vec274.f48120y = vec275.f48120y;
                    Vec2 vec276 = this.f47926l;
                    vec276.f48119x = -vec275.f48119x;
                    vec276.f48120y = -vec275.f48120y;
                    Vec2 vec277 = this.f47927m;
                    Vec2 vec278 = this.f47924j;
                    vec277.f48119x = vec278.f48119x;
                    vec277.f48120y = vec278.f48120y;
                } else {
                    Vec2 vec279 = this.f47925k;
                    Vec2 vec280 = this.f47923i;
                    vec279.f48119x = -vec280.f48119x;
                    vec279.f48120y = -vec280.f48120y;
                    Vec2 vec281 = this.f47926l;
                    vec281.f48119x = -vec280.f48119x;
                    vec281.f48120y = -vec280.f48120y;
                    Vec2 vec282 = this.f47927m;
                    vec282.f48119x = vec280.f48119x;
                    vec282.f48120y = vec280.f48120y;
                }
            } else {
                boolean z46 = dot >= 0.0f && f17 >= 0.0f;
                this.f47929o = z46;
                if (z46) {
                    Vec2 vec283 = this.f47925k;
                    Vec2 vec284 = this.f47923i;
                    vec283.f48119x = vec284.f48119x;
                    vec283.f48120y = vec284.f48120y;
                    Vec2 vec285 = this.f47926l;
                    vec285.f48119x = -vec284.f48119x;
                    vec285.f48120y = -vec284.f48120y;
                    Vec2 vec286 = this.f47927m;
                    vec286.f48119x = vec284.f48119x;
                    vec286.f48120y = vec284.f48120y;
                } else {
                    Vec2 vec287 = this.f47925k;
                    Vec2 vec288 = this.f47923i;
                    vec287.f48119x = -vec288.f48119x;
                    vec287.f48120y = -vec288.f48120y;
                    Vec2 vec289 = this.f47926l;
                    Vec2 vec290 = this.f47924j;
                    vec289.f48119x = -vec290.f48119x;
                    vec289.f48120y = -vec290.f48120y;
                    Vec2 vec291 = this.f47927m;
                    vec291.f48119x = vec288.f48119x;
                    vec291.f48120y = vec288.f48120y;
                }
            }
            this.f47915a.f47954c = eVar.f48097f;
            for (int i16 = 0; i16 < eVar.f48097f; i16++) {
                Transform.mulToOutUnsafe(this.f47916b, eVar.f48095d[i16], this.f47915a.f47952a[i16]);
                Rot.mulToOutUnsafe(this.f47916b.f48118q, eVar.f48096e[i16], this.f47915a.f47953b[i16]);
            }
            this.f47928n = com.qzone.jbox2d.common.d.f48147o * 2.0f;
            manifold.f47963e = 0;
            b(this.f47938x);
            EPAxis ePAxis = this.f47938x;
            EPAxis.Type type = ePAxis.f47910a;
            EPAxis.Type type2 = EPAxis.Type.UNKNOWN;
            if (type != type2 && ePAxis.f47912c <= this.f47928n) {
                c(this.f47939y);
                EPAxis ePAxis2 = this.f47939y;
                EPAxis.Type type3 = ePAxis2.f47910a;
                if (type3 == type2 || ePAxis2.f47912c <= this.f47928n) {
                    if (type3 == type2) {
                        ePAxis2 = this.f47938x;
                    } else {
                        float f18 = ePAxis2.f47912c;
                        EPAxis ePAxis3 = this.f47938x;
                        if (f18 <= (ePAxis3.f47912c * 0.98f) + 0.001f) {
                            ePAxis2 = ePAxis3;
                        }
                    }
                    a[] aVarArr = this.f47934t;
                    a aVar = aVarArr[0];
                    a aVar2 = aVarArr[1];
                    if (ePAxis2.f47910a == EPAxis.Type.EDGE_A) {
                        manifold.f47962d = Manifold.ManifoldType.FACE_A;
                        float dot2 = Vec2.dot(this.f47925k, this.f47915a.f47953b[0]);
                        int i17 = 1;
                        int i18 = 0;
                        while (true) {
                            eVar2 = this.f47915a;
                            i3 = eVar2.f47954c;
                            if (i17 >= i3) {
                                break;
                            }
                            float dot3 = Vec2.dot(this.f47925k, eVar2.f47953b[i17]);
                            if (dot3 < dot2) {
                                i18 = i17;
                                dot2 = dot3;
                            }
                            i17++;
                        }
                        int i19 = i18 + 1;
                        if (i19 >= i3) {
                            i19 = 0;
                        }
                        aVar.f47913a.set(eVar2.f47952a[i18]);
                        ContactID contactID = aVar.f47914b;
                        contactID.f47955d = (byte) 0;
                        contactID.f47956e = (byte) i18;
                        ContactID.Type type4 = ContactID.Type.FACE;
                        contactID.f47957f = (byte) type4.ordinal();
                        ContactID contactID2 = aVar.f47914b;
                        ContactID.Type type5 = ContactID.Type.VERTEX;
                        contactID2.f47958h = (byte) type5.ordinal();
                        aVar2.f47913a.set(this.f47915a.f47952a[i19]);
                        ContactID contactID3 = aVar2.f47914b;
                        contactID3.f47955d = (byte) 0;
                        contactID3.f47956e = (byte) i19;
                        contactID3.f47957f = (byte) type4.ordinal();
                        aVar2.f47914b.f47958h = (byte) type5.ordinal();
                        if (this.f47929o) {
                            d dVar = this.f47937w;
                            dVar.f47943a = 0;
                            dVar.f47944b = 1;
                            dVar.f47945c.set(this.f47919e);
                            this.f47937w.f47946d.set(this.f47920f);
                            this.f47937w.f47947e.set(this.f47923i);
                        } else {
                            d dVar2 = this.f47937w;
                            dVar2.f47943a = 1;
                            dVar2.f47944b = 0;
                            dVar2.f47945c.set(this.f47920f);
                            this.f47937w.f47946d.set(this.f47919e);
                            this.f47937w.f47947e.set(this.f47923i).negateLocal();
                        }
                    } else {
                        manifold.f47962d = Manifold.ManifoldType.FACE_B;
                        aVar.f47913a.set(this.f47919e);
                        ContactID contactID4 = aVar.f47914b;
                        contactID4.f47955d = (byte) 0;
                        contactID4.f47956e = (byte) ePAxis2.f47911b;
                        ContactID.Type type6 = ContactID.Type.VERTEX;
                        contactID4.f47957f = (byte) type6.ordinal();
                        ContactID contactID5 = aVar.f47914b;
                        ContactID.Type type7 = ContactID.Type.FACE;
                        contactID5.f47958h = (byte) type7.ordinal();
                        aVar2.f47913a.set(this.f47920f);
                        ContactID contactID6 = aVar2.f47914b;
                        contactID6.f47955d = (byte) 0;
                        contactID6.f47956e = (byte) ePAxis2.f47911b;
                        contactID6.f47957f = (byte) type6.ordinal();
                        aVar2.f47914b.f47958h = (byte) type7.ordinal();
                        d dVar3 = this.f47937w;
                        int i26 = ePAxis2.f47911b;
                        dVar3.f47943a = i26;
                        int i27 = i26 + 1;
                        e eVar3 = this.f47915a;
                        dVar3.f47944b = i27 < eVar3.f47954c ? i26 + 1 : 0;
                        dVar3.f47945c.set(eVar3.f47952a[i26]);
                        d dVar4 = this.f47937w;
                        dVar4.f47946d.set(this.f47915a.f47952a[dVar4.f47944b]);
                        d dVar5 = this.f47937w;
                        dVar5.f47947e.set(this.f47915a.f47953b[dVar5.f47943a]);
                    }
                    d dVar6 = this.f47937w;
                    Vec2 vec292 = dVar6.f47948f;
                    Vec2 vec293 = dVar6.f47947e;
                    vec292.set(vec293.f48120y, -vec293.f48119x);
                    d dVar7 = this.f47937w;
                    dVar7.f47950h.set(dVar7.f47948f).negateLocal();
                    d dVar8 = this.f47937w;
                    dVar8.f47949g = Vec2.dot(dVar8.f47948f, dVar8.f47945c);
                    d dVar9 = this.f47937w;
                    dVar9.f47951i = Vec2.dot(dVar9.f47950h, dVar9.f47946d);
                    a[] aVarArr2 = this.f47935u;
                    a[] aVarArr3 = this.f47934t;
                    d dVar10 = this.f47937w;
                    if (Collision.a(aVarArr2, aVarArr3, dVar10.f47948f, dVar10.f47949g, dVar10.f47943a) < com.qzone.jbox2d.common.d.f48141i) {
                        return;
                    }
                    a[] aVarArr4 = this.f47936v;
                    a[] aVarArr5 = this.f47935u;
                    d dVar11 = this.f47937w;
                    if (Collision.a(aVarArr4, aVarArr5, dVar11.f47950h, dVar11.f47951i, dVar11.f47944b) < com.qzone.jbox2d.common.d.f48141i) {
                        return;
                    }
                    if (ePAxis2.f47910a == EPAxis.Type.EDGE_A) {
                        manifold.f47960b.set(this.f47937w.f47947e);
                        manifold.f47961c.set(this.f47937w.f47945c);
                    } else {
                        manifold.f47960b.set(eVar.f48096e[this.f47937w.f47943a]);
                        manifold.f47961c.set(eVar.f48095d[this.f47937w.f47943a]);
                    }
                    int i28 = 0;
                    for (int i29 = 0; i29 < com.qzone.jbox2d.common.d.f48141i; i29++) {
                        if (Vec2.dot(this.f47937w.f47947e, this.f47931q.set(this.f47936v[i29].f47913a).subLocal(this.f47937w.f47945c)) <= this.f47928n) {
                            com.qzone.jbox2d.collision.e eVar4 = manifold.f47959a[i28];
                            if (ePAxis2.f47910a == EPAxis.Type.EDGE_A) {
                                Transform.mulTransToOutUnsafe(this.f47916b, this.f47936v[i29].f47913a, eVar4.f48039a);
                                eVar4.f48042d.k(this.f47936v[i29].f47914b);
                            } else {
                                eVar4.f48039a.set(this.f47936v[i29].f47913a);
                                ContactID contactID7 = eVar4.f48042d;
                                ContactID contactID8 = this.f47936v[i29].f47914b;
                                contactID7.f47957f = contactID8.f47958h;
                                contactID7.f47958h = contactID8.f47957f;
                                contactID7.f47955d = contactID8.f47956e;
                                contactID7.f47956e = contactID8.f47955d;
                            }
                            i28++;
                        }
                    }
                    manifold.f47963e = i28;
                }
            }
        }

        public void b(EPAxis ePAxis) {
            ePAxis.f47910a = EPAxis.Type.EDGE_A;
            ePAxis.f47911b = !this.f47929o ? 1 : 0;
            ePAxis.f47912c = Float.MAX_VALUE;
            Vec2 vec2 = this.f47925k;
            float f16 = vec2.f48119x;
            float f17 = vec2.f48120y;
            int i3 = 0;
            while (true) {
                e eVar = this.f47915a;
                if (i3 >= eVar.f47954c) {
                    return;
                }
                Vec2 vec22 = eVar.f47952a[i3];
                float f18 = vec22.f48119x;
                Vec2 vec23 = this.f47919e;
                float f19 = ((f18 - vec23.f48119x) * f16) + ((vec22.f48120y - vec23.f48120y) * f17);
                if (f19 < ePAxis.f47912c) {
                    ePAxis.f47912c = f19;
                }
                i3++;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00b9 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(EPAxis ePAxis) {
            int i3;
            ePAxis.f47910a = EPAxis.Type.UNKNOWN;
            ePAxis.f47911b = -1;
            ePAxis.f47912c = -3.4028235E38f;
            Vec2 vec2 = this.f47940z;
            Vec2 vec22 = this.f47925k;
            vec2.f48119x = -vec22.f48120y;
            vec2.f48120y = vec22.f48119x;
            while (true) {
                e eVar = this.f47915a;
                if (i3 >= eVar.f47954c) {
                    return;
                }
                Vec2 vec23 = eVar.f47953b[i3];
                Vec2 vec24 = eVar.f47952a[i3];
                Vec2 vec25 = this.A;
                float f16 = -vec23.f48119x;
                vec25.f48119x = f16;
                float f17 = -vec23.f48120y;
                vec25.f48120y = f17;
                float f18 = vec24.f48119x;
                Vec2 vec26 = this.f47919e;
                float f19 = f18 - vec26.f48119x;
                float f26 = vec24.f48120y;
                float f27 = (f19 * f16) + ((f26 - vec26.f48120y) * f17);
                Vec2 vec27 = this.f47920f;
                float l3 = com.qzone.jbox2d.common.b.l(f27, (f16 * (f18 - vec27.f48119x)) + (f17 * (f26 - vec27.f48120y)));
                if (l3 > this.f47928n) {
                    ePAxis.f47910a = EPAxis.Type.EDGE_B;
                    ePAxis.f47911b = i3;
                    ePAxis.f47912c = l3;
                    return;
                }
                Vec2 vec28 = this.A;
                float f28 = vec28.f48119x;
                Vec2 vec29 = this.f47940z;
                if ((f28 * vec29.f48119x) + (vec28.f48120y * vec29.f48120y) >= 0.0f) {
                    i3 = Vec2.dot(this.f47931q.set(vec28).subLocal(this.f47927m), this.f47925k) < (-com.qzone.jbox2d.common.d.f48146n) ? i3 + 1 : 0;
                    if (l3 <= ePAxis.f47912c) {
                        ePAxis.f47910a = EPAxis.Type.EDGE_B;
                        ePAxis.f47911b = i3;
                        ePAxis.f47912c = l3;
                    }
                } else {
                    if (Vec2.dot(this.f47931q.set(vec28).subLocal(this.f47926l), this.f47925k) < (-com.qzone.jbox2d.common.d.f48146n)) {
                    }
                    if (l3 <= ePAxis.f47912c) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public float f47941a;

        /* renamed from: b, reason: collision with root package name */
        public int f47942b;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        int f47943a;

        /* renamed from: b, reason: collision with root package name */
        int f47944b;

        /* renamed from: g, reason: collision with root package name */
        float f47949g;

        /* renamed from: i, reason: collision with root package name */
        float f47951i;

        /* renamed from: c, reason: collision with root package name */
        final Vec2 f47945c = new Vec2();

        /* renamed from: d, reason: collision with root package name */
        final Vec2 f47946d = new Vec2();

        /* renamed from: e, reason: collision with root package name */
        final Vec2 f47947e = new Vec2();

        /* renamed from: f, reason: collision with root package name */
        final Vec2 f47948f = new Vec2();

        /* renamed from: h, reason: collision with root package name */
        final Vec2 f47950h = new Vec2();

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        final Vec2[] f47952a;

        /* renamed from: b, reason: collision with root package name */
        final Vec2[] f47953b;

        /* renamed from: c, reason: collision with root package name */
        int f47954c;

        public e() {
            int i3 = com.qzone.jbox2d.common.d.f48142j;
            this.f47952a = new Vec2[i3];
            this.f47953b = new Vec2[i3];
            int i16 = 0;
            while (true) {
                Vec2[] vec2Arr = this.f47952a;
                if (i16 >= vec2Arr.length) {
                    return;
                }
                vec2Arr[i16] = new Vec2();
                this.f47953b[i16] = new Vec2();
                i16++;
            }
        }
    }

    public Collision(k7.b bVar) {
        this.f47895k = r1;
        this.f47902r = r2;
        this.f47903s = r0;
        a[] aVarArr = {new a(), new a()};
        a[] aVarArr2 = {new a(), new a()};
        a[] aVarArr3 = {new a(), new a()};
        this.f47885a = bVar;
    }

    public void d(Manifold manifold, com.qzone.jbox2d.collision.shapes.c cVar, Transform transform, com.qzone.jbox2d.collision.shapes.e eVar, Transform transform2) {
        this.f47909y.a(manifold, cVar, transform, eVar, transform2);
    }

    public final boolean i(com.qzone.jbox2d.collision.shapes.f fVar, int i3, com.qzone.jbox2d.collision.shapes.f fVar2, int i16, Transform transform, Transform transform2) {
        this.f47886b.f48030a.c(fVar, i3);
        this.f47886b.f48031b.c(fVar2, i16);
        this.f47886b.f48032c.set(transform);
        this.f47886b.f48033d.set(transform2);
        this.f47886b.f48034e = true;
        this.f47887c.f48020b = 0;
        this.f47885a.getDistance().a(this.f47888d, this.f47887c, this.f47886b);
        return this.f47888d.f48037c < 1.1920929E-6f;
    }

    public static final int a(a[] aVarArr, a[] aVarArr2, Vec2 vec2, float f16, int i3) {
        int i16 = 0;
        a aVar = aVarArr2[0];
        a aVar2 = aVarArr2[1];
        Vec2 vec22 = aVar.f47913a;
        Vec2 vec23 = aVar2.f47913a;
        float dot = Vec2.dot(vec2, vec22) - f16;
        float dot2 = Vec2.dot(vec2, vec23) - f16;
        if (dot <= 0.0f) {
            aVarArr[0].a(aVar);
            i16 = 1;
        }
        if (dot2 <= 0.0f) {
            aVarArr[i16].a(aVar2);
            i16++;
        }
        if (dot * dot2 >= 0.0f) {
            return i16;
        }
        float f17 = dot / (dot - dot2);
        a aVar3 = aVarArr[i16];
        Vec2 vec24 = aVar3.f47913a;
        float f18 = vec22.f48119x;
        vec24.f48119x = f18 + ((vec23.f48119x - f18) * f17);
        float f19 = vec22.f48120y;
        vec24.f48120y = f19 + (f17 * (vec23.f48120y - f19));
        ContactID contactID = aVar3.f47914b;
        contactID.f47955d = (byte) i3;
        contactID.f47956e = aVar.f47914b.f47956e;
        contactID.f47957f = (byte) ContactID.Type.VERTEX.ordinal();
        aVar3.f47914b.f47958h = (byte) ContactID.Type.FACE.ordinal();
        return i16 + 1;
    }

    public final void b(Manifold manifold, com.qzone.jbox2d.collision.shapes.b bVar, Transform transform, com.qzone.jbox2d.collision.shapes.b bVar2, Transform transform2) {
        manifold.f47963e = 0;
        Vec2 vec2 = bVar.f48083c;
        Vec2 vec22 = bVar2.f48083c;
        Rot rot = transform.f48118q;
        float f16 = rot.f48110c;
        float f17 = vec2.f48119x;
        float f18 = rot.f48111s;
        float f19 = vec2.f48120y;
        Vec2 vec23 = transform.f48117p;
        float f26 = ((f16 * f17) - (f18 * f19)) + vec23.f48119x;
        float f27 = (f18 * f17) + (f16 * f19) + vec23.f48120y;
        Rot rot2 = transform2.f48118q;
        float f28 = rot2.f48110c;
        float f29 = vec22.f48119x;
        float f36 = rot2.f48111s;
        float f37 = vec22.f48120y;
        Vec2 vec24 = transform2.f48117p;
        float f38 = (((f28 * f29) - (f36 * f37)) + vec24.f48119x) - f26;
        float f39 = (((f36 * f29) + (f28 * f37)) + vec24.f48120y) - f27;
        float f46 = (f38 * f38) + (f39 * f39);
        float f47 = bVar.f48104b + bVar2.f48104b;
        if (f46 > f47 * f47) {
            return;
        }
        manifold.f47962d = Manifold.ManifoldType.CIRCLES;
        manifold.f47961c.set(vec2);
        manifold.f47960b.setZero();
        manifold.f47963e = 1;
        manifold.f47959a[0].f48039a.set(vec22);
        manifold.f47959a[0].f48042d.l();
    }

    public void c(Manifold manifold, com.qzone.jbox2d.collision.shapes.c cVar, Transform transform, com.qzone.jbox2d.collision.shapes.b bVar, Transform transform2) {
        manifold.f47963e = 0;
        Transform.mulToOutUnsafe(transform2, bVar.f48083c, this.f47889e);
        Transform.mulTransToOutUnsafe(transform, this.f47889e, this.f47904t);
        Vec2 vec2 = cVar.f48084c;
        Vec2 vec22 = cVar.f48085d;
        this.f47905u.set(vec22).subLocal(vec2);
        float dot = Vec2.dot(this.f47905u, this.f47889e.set(vec22).subLocal(this.f47904t));
        float dot2 = Vec2.dot(this.f47905u, this.f47889e.set(this.f47904t).subLocal(vec2));
        float f16 = cVar.f48104b + bVar.f48104b;
        ContactID contactID = this.f47906v;
        contactID.f47956e = (byte) 0;
        ContactID.Type type = ContactID.Type.VERTEX;
        contactID.f47958h = (byte) type.ordinal();
        if (dot2 <= 0.0f) {
            f47884z.set(this.f47904t).subLocal(vec2);
            Vec2 vec23 = f47884z;
            if (Vec2.dot(vec23, vec23) > f16 * f16) {
                return;
            }
            if (cVar.f48088g) {
                this.f47907w.set(vec2).subLocal(cVar.f48086e);
                if (Vec2.dot(this.f47907w, this.f47889e.set(vec2).subLocal(this.f47904t)) > 0.0f) {
                    return;
                }
            }
            ContactID contactID2 = this.f47906v;
            contactID2.f47955d = (byte) 0;
            contactID2.f47957f = (byte) type.ordinal();
            manifold.f47963e = 1;
            manifold.f47962d = Manifold.ManifoldType.CIRCLES;
            manifold.f47960b.setZero();
            manifold.f47961c.set(vec2);
            manifold.f47959a[0].f48042d.k(this.f47906v);
            manifold.f47959a[0].f48039a.set(bVar.f48083c);
            return;
        }
        if (dot <= 0.0f) {
            f47884z.set(this.f47904t).subLocal(vec22);
            Vec2 vec24 = f47884z;
            if (Vec2.dot(vec24, vec24) > f16 * f16) {
                return;
            }
            if (cVar.f48089h) {
                Vec2 vec25 = cVar.f48087f;
                Vec2 vec26 = this.f47907w;
                vec26.set(vec25).subLocal(vec22);
                if (Vec2.dot(vec26, this.f47889e.set(this.f47904t).subLocal(vec22)) > 0.0f) {
                    return;
                }
            }
            ContactID contactID3 = this.f47906v;
            contactID3.f47955d = (byte) 1;
            contactID3.f47957f = (byte) type.ordinal();
            manifold.f47963e = 1;
            manifold.f47962d = Manifold.ManifoldType.CIRCLES;
            manifold.f47960b.setZero();
            manifold.f47961c.set(vec22);
            manifold.f47959a[0].f48042d.k(this.f47906v);
            manifold.f47959a[0].f48039a.set(bVar.f48083c);
            return;
        }
        Vec2 vec27 = this.f47905u;
        float dot3 = Vec2.dot(vec27, vec27);
        this.f47908x.set(vec2).mulLocal(dot).addLocal(this.f47889e.set(vec22).mulLocal(dot2));
        this.f47908x.mulLocal(1.0f / dot3);
        f47884z.set(this.f47904t).subLocal(this.f47908x);
        Vec2 vec28 = f47884z;
        if (Vec2.dot(vec28, vec28) > f16 * f16) {
            return;
        }
        Vec2 vec29 = this.f47891g;
        Vec2 vec210 = this.f47905u;
        vec29.f48119x = -vec210.f48120y;
        vec29.f48120y = vec210.f48119x;
        if (Vec2.dot(vec29, this.f47889e.set(this.f47904t).subLocal(vec2)) < 0.0f) {
            Vec2 vec211 = this.f47891g;
            vec211.set(-vec211.f48119x, -vec211.f48120y);
        }
        this.f47891g.normalize();
        ContactID contactID4 = this.f47906v;
        contactID4.f47955d = (byte) 0;
        contactID4.f47957f = (byte) ContactID.Type.FACE.ordinal();
        manifold.f47963e = 1;
        manifold.f47962d = Manifold.ManifoldType.FACE_A;
        manifold.f47960b.set(this.f47891g);
        manifold.f47961c.set(vec2);
        manifold.f47959a[0].f48042d.k(this.f47906v);
        manifold.f47959a[0].f48039a.set(bVar.f48083c);
    }

    public final void f(Manifold manifold, com.qzone.jbox2d.collision.shapes.e eVar, Transform transform, com.qzone.jbox2d.collision.shapes.e eVar2, Transform transform2) {
        Transform transform3;
        Transform transform4;
        int i3;
        boolean z16;
        com.qzone.jbox2d.collision.shapes.e eVar3;
        float f16;
        float f17;
        manifold.f47963e = 0;
        com.qzone.jbox2d.collision.shapes.e eVar4 = eVar2;
        float f18 = eVar.f48104b + eVar4.f48104b;
        h(this.f47893i, eVar, transform, eVar2, transform2);
        if (this.f47893i.f47941a > f18) {
            return;
        }
        h(this.f47894j, eVar2, transform2, eVar, transform);
        c cVar = this.f47894j;
        float f19 = cVar.f47941a;
        if (f19 > f18) {
            return;
        }
        float f26 = com.qzone.jbox2d.common.d.f48145m * 0.1f;
        c cVar2 = this.f47893i;
        if (f19 > cVar2.f47941a + f26) {
            int i16 = cVar.f47942b;
            manifold.f47962d = Manifold.ManifoldType.FACE_B;
            transform4 = transform;
            transform3 = transform2;
            i3 = i16;
            z16 = true;
            eVar3 = eVar;
        } else {
            int i17 = cVar2.f47942b;
            manifold.f47962d = Manifold.ManifoldType.FACE_A;
            transform3 = transform;
            transform4 = transform2;
            i3 = i17;
            z16 = false;
            eVar3 = eVar4;
            eVar4 = eVar;
        }
        Rot rot = transform3.f48118q;
        g(this.f47895k, eVar4, transform3, i3, eVar3, transform4);
        int i18 = eVar4.f48097f;
        Vec2[] vec2Arr = eVar4.f48095d;
        int i19 = i3 + 1;
        if (i19 >= i18) {
            i19 = 0;
        }
        this.f47900p.set(vec2Arr[i3]);
        this.f47901q.set(vec2Arr[i19]);
        Vec2 vec2 = this.f47896l;
        Vec2 vec22 = this.f47901q;
        float f27 = vec22.f48119x;
        Vec2 vec23 = this.f47900p;
        vec2.f48119x = f27 - vec23.f48119x;
        vec2.f48120y = vec22.f48120y - vec23.f48120y;
        vec2.normalize();
        Vec2 vec24 = this.f47897m;
        Vec2 vec25 = this.f47896l;
        vec24.f48119x = vec25.f48120y * 1.0f;
        vec24.f48120y = vec25.f48119x * (-1.0f);
        Vec2 vec26 = this.f47898n;
        Vec2 vec27 = this.f47900p;
        float f28 = vec27.f48119x;
        Vec2 vec28 = this.f47901q;
        vec26.f48119x = (f28 + vec28.f48119x) * 0.5f;
        vec26.f48120y = (vec27.f48120y + vec28.f48120y) * 0.5f;
        Vec2 vec29 = this.f47899o;
        float f29 = rot.f48110c;
        float f36 = vec25.f48119x * f29;
        float f37 = rot.f48111s;
        float f38 = vec25.f48120y;
        float f39 = f36 - (f37 * f38);
        vec29.f48119x = f39;
        float f46 = (f37 * vec25.f48119x) + (f29 * f38);
        vec29.f48120y = f46;
        float f47 = f46 * 1.0f;
        float f48 = f39 * (-1.0f);
        Transform.mulToOut(transform3, vec27, vec27);
        Vec2 vec210 = this.f47901q;
        Transform.mulToOut(transform3, vec210, vec210);
        Vec2 vec211 = this.f47900p;
        float f49 = vec211.f48119x;
        float f56 = vec211.f48120y;
        float f57 = (f47 * f49) + (f48 * f56);
        Vec2 vec212 = this.f47899o;
        float f58 = vec212.f48119x;
        float f59 = vec212.f48120y;
        float f65 = (-((f49 * f58) + (f56 * f59))) + f18;
        Vec2 vec213 = this.f47901q;
        float f66 = (f58 * vec213.f48119x) + (f59 * vec213.f48120y) + f18;
        vec212.negateLocal();
        int a16 = a(this.f47902r, this.f47895k, this.f47899o, f65, i3);
        this.f47899o.negateLocal();
        if (a16 >= 2 && a(this.f47903s, this.f47902r, this.f47899o, f66, i19) >= 2) {
            manifold.f47960b.set(this.f47897m);
            manifold.f47961c.set(this.f47898n);
            int i26 = 0;
            int i27 = 0;
            while (i26 < com.qzone.jbox2d.common.d.f48141i) {
                a aVar = this.f47903s[i26];
                Vec2 vec214 = aVar.f47913a;
                float f67 = vec214.f48119x;
                float f68 = vec214.f48120y;
                if (((f47 * f67) + (f48 * f68)) - f57 <= f18) {
                    com.qzone.jbox2d.collision.e eVar5 = manifold.f47959a[i27];
                    Vec2 vec215 = eVar5.f48039a;
                    Vec2 vec216 = transform4.f48117p;
                    f16 = f57;
                    float f69 = f67 - vec216.f48119x;
                    float f75 = f68 - vec216.f48120y;
                    Rot rot2 = transform4.f48118q;
                    float f76 = rot2.f48110c;
                    float f77 = rot2.f48111s;
                    f17 = f48;
                    vec215.f48119x = (f76 * f69) + (f77 * f75);
                    vec215.f48120y = ((-f77) * f69) + (f76 * f75);
                    eVar5.f48042d.k(aVar.f47914b);
                    if (z16) {
                        eVar5.f48042d.h();
                    }
                    i27++;
                } else {
                    f16 = f57;
                    f17 = f48;
                }
                i26++;
                f57 = f16;
                f48 = f17;
            }
            manifold.f47963e = i27;
        }
    }

    public final void g(a[] aVarArr, com.qzone.jbox2d.collision.shapes.e eVar, Transform transform, int i3, com.qzone.jbox2d.collision.shapes.e eVar2, Transform transform2) {
        int i16 = eVar.f48097f;
        Vec2[] vec2Arr = eVar.f48096e;
        int i17 = eVar2.f48097f;
        Vec2[] vec2Arr2 = eVar2.f48095d;
        Vec2[] vec2Arr3 = eVar2.f48096e;
        a aVar = aVarArr[0];
        a aVar2 = aVarArr[1];
        Rot rot = transform.f48118q;
        Rot rot2 = transform2.f48118q;
        Vec2 vec2 = vec2Arr[i3];
        float f16 = rot.f48110c;
        float f17 = vec2.f48119x;
        float f18 = rot.f48111s;
        float f19 = vec2.f48120y;
        float f26 = (f16 * f17) - (f18 * f19);
        float f27 = (f18 * f17) + (f16 * f19);
        float f28 = rot2.f48110c;
        float f29 = rot2.f48111s;
        float f36 = (f28 * f26) + (f29 * f27);
        float f37 = ((-f29) * f26) + (f28 * f27);
        float f38 = Float.MAX_VALUE;
        int i18 = 0;
        for (int i19 = 0; i19 < i17; i19++) {
            Vec2 vec22 = vec2Arr3[i19];
            float f39 = (vec22.f48119x * f36) + (vec22.f48120y * f37);
            if (f39 < f38) {
                i18 = i19;
                f38 = f39;
            }
        }
        int i26 = i18 + 1;
        int i27 = i26 < i17 ? i26 : 0;
        Vec2 vec23 = vec2Arr2[i18];
        Vec2 vec24 = aVar.f47913a;
        float f46 = rot2.f48110c;
        float f47 = vec23.f48119x * f46;
        float f48 = rot2.f48111s;
        float f49 = vec23.f48120y;
        Vec2 vec25 = transform2.f48117p;
        vec24.f48119x = (f47 - (f48 * f49)) + vec25.f48119x;
        vec24.f48120y = (f48 * vec23.f48119x) + (f46 * f49) + vec25.f48120y;
        ContactID contactID = aVar.f47914b;
        byte b16 = (byte) i3;
        contactID.f47955d = b16;
        contactID.f47956e = (byte) i18;
        ContactID.Type type = ContactID.Type.FACE;
        contactID.f47957f = (byte) type.ordinal();
        ContactID contactID2 = aVar.f47914b;
        ContactID.Type type2 = ContactID.Type.VERTEX;
        contactID2.f47958h = (byte) type2.ordinal();
        Vec2 vec26 = vec2Arr2[i27];
        Vec2 vec27 = aVar2.f47913a;
        float f56 = rot2.f48110c;
        float f57 = vec26.f48119x * f56;
        float f58 = rot2.f48111s;
        float f59 = vec26.f48120y;
        Vec2 vec28 = transform2.f48117p;
        vec27.f48119x = (f57 - (f58 * f59)) + vec28.f48119x;
        vec27.f48120y = (f58 * vec26.f48119x) + (f56 * f59) + vec28.f48120y;
        ContactID contactID3 = aVar2.f47914b;
        contactID3.f47955d = b16;
        contactID3.f47956e = (byte) i27;
        contactID3.f47957f = (byte) type.ordinal();
        aVar2.f47914b.f47958h = (byte) type2.ordinal();
    }

    public final void h(c cVar, com.qzone.jbox2d.collision.shapes.e eVar, Transform transform, com.qzone.jbox2d.collision.shapes.e eVar2, Transform transform2) {
        Collision collision = this;
        int i3 = eVar.f48097f;
        int i16 = eVar2.f48097f;
        Vec2[] vec2Arr = eVar.f48096e;
        Vec2[] vec2Arr2 = eVar.f48095d;
        Vec2[] vec2Arr3 = eVar2.f48095d;
        Transform.mulTransToOutUnsafe(transform2, transform, collision.f47890f);
        Rot rot = collision.f47890f.f48118q;
        float f16 = -3.4028235E38f;
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            Rot.mulToOutUnsafe(rot, vec2Arr[i17], collision.f47891g);
            Transform.mulToOutUnsafe(collision.f47890f, vec2Arr2[i17], collision.f47892h);
            float f17 = Float.MAX_VALUE;
            int i19 = 0;
            while (i19 < i16) {
                Vec2 vec2 = vec2Arr3[i19];
                Vec2 vec22 = collision.f47891g;
                float f18 = vec22.f48119x;
                Vec2[] vec2Arr4 = vec2Arr2;
                float f19 = vec2.f48119x;
                Vec2[] vec2Arr5 = vec2Arr3;
                Vec2 vec23 = collision.f47892h;
                float f26 = (f18 * (f19 - vec23.f48119x)) + (vec22.f48120y * (vec2.f48120y - vec23.f48120y));
                if (f26 < f17) {
                    f17 = f26;
                }
                i19++;
                collision = this;
                vec2Arr3 = vec2Arr5;
                vec2Arr2 = vec2Arr4;
            }
            Vec2[] vec2Arr6 = vec2Arr2;
            Vec2[] vec2Arr7 = vec2Arr3;
            if (f17 > f16) {
                i18 = i17;
                f16 = f17;
            }
            i17++;
            collision = this;
            vec2Arr3 = vec2Arr7;
            vec2Arr2 = vec2Arr6;
        }
        cVar.f47942b = i18;
        cVar.f47941a = f16;
    }

    public final void e(Manifold manifold, com.qzone.jbox2d.collision.shapes.e eVar, Transform transform, com.qzone.jbox2d.collision.shapes.b bVar, Transform transform2) {
        manifold.f47963e = 0;
        Vec2 vec2 = bVar.f48083c;
        Rot rot = transform2.f48118q;
        Rot rot2 = transform.f48118q;
        float f16 = rot.f48110c;
        float f17 = vec2.f48119x;
        float f18 = rot.f48111s;
        float f19 = vec2.f48120y;
        Vec2 vec22 = transform2.f48117p;
        float f26 = ((f16 * f17) - (f18 * f19)) + vec22.f48119x;
        float f27 = (f18 * f17) + (f16 * f19) + vec22.f48120y;
        Vec2 vec23 = transform.f48117p;
        float f28 = f26 - vec23.f48119x;
        float f29 = f27 - vec23.f48120y;
        float f36 = rot2.f48110c;
        float f37 = rot2.f48111s;
        float f38 = (f36 * f28) + (f37 * f29);
        float f39 = ((-f37) * f28) + (f36 * f29);
        float f46 = eVar.f48104b + bVar.f48104b;
        int i3 = eVar.f48097f;
        Vec2[] vec2Arr = eVar.f48095d;
        Vec2[] vec2Arr2 = eVar.f48096e;
        float f47 = -3.4028235E38f;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            Vec2 vec24 = vec2Arr[i17];
            float f48 = f38 - vec24.f48119x;
            float f49 = f39 - vec24.f48120y;
            Vec2 vec25 = vec2Arr2[i17];
            float f56 = (vec25.f48119x * f48) + (vec25.f48120y * f49);
            if (f56 > f46) {
                return;
            }
            if (f56 > f47) {
                i16 = i17;
                f47 = f56;
            }
        }
        int i18 = i16 + 1;
        if (i18 >= i3) {
            i18 = 0;
        }
        Vec2 vec26 = vec2Arr[i16];
        Vec2 vec27 = vec2Arr[i18];
        if (f47 < 1.1920929E-7f) {
            manifold.f47963e = 1;
            manifold.f47962d = Manifold.ManifoldType.FACE_A;
            Vec2 vec28 = vec2Arr2[i16];
            Vec2 vec29 = manifold.f47960b;
            vec29.f48119x = vec28.f48119x;
            vec29.f48120y = vec28.f48120y;
            Vec2 vec210 = manifold.f47961c;
            vec210.f48119x = (vec26.f48119x + vec27.f48119x) * 0.5f;
            vec210.f48120y = (vec26.f48120y + vec27.f48120y) * 0.5f;
            com.qzone.jbox2d.collision.e eVar2 = manifold.f47959a[0];
            Vec2 vec211 = eVar2.f48039a;
            vec211.f48119x = vec2.f48119x;
            vec211.f48120y = vec2.f48120y;
            eVar2.f48042d.l();
            return;
        }
        float f57 = vec26.f48119x;
        float f58 = vec26.f48120y;
        float f59 = vec27.f48119x;
        float f65 = vec27.f48120y;
        float f66 = ((f38 - f59) * (f57 - f59)) + ((f39 - f65) * (f58 - f65));
        if (((f38 - f57) * (f59 - f57)) + ((f39 - f58) * (f65 - f58)) <= 0.0f) {
            float f67 = f38 - f57;
            float f68 = f39 - f58;
            if ((f67 * f67) + (f68 * f68) > f46 * f46) {
                return;
            }
            manifold.f47963e = 1;
            manifold.f47962d = Manifold.ManifoldType.FACE_A;
            Vec2 vec212 = manifold.f47960b;
            vec212.f48119x = f38 - f57;
            vec212.f48120y = f39 - f58;
            vec212.normalize();
            manifold.f47961c.set(vec26);
            manifold.f47959a[0].f48039a.set(vec2);
            manifold.f47959a[0].f48042d.l();
            return;
        }
        if (f66 <= 0.0f) {
            float f69 = f38 - f59;
            float f75 = f39 - f65;
            if ((f69 * f69) + (f75 * f75) > f46 * f46) {
                return;
            }
            manifold.f47963e = 1;
            manifold.f47962d = Manifold.ManifoldType.FACE_A;
            Vec2 vec213 = manifold.f47960b;
            vec213.f48119x = f38 - f59;
            vec213.f48120y = f39 - f65;
            vec213.normalize();
            manifold.f47961c.set(vec27);
            manifold.f47959a[0].f48039a.set(vec2);
            manifold.f47959a[0].f48042d.l();
            return;
        }
        float f76 = (f57 + f59) * 0.5f;
        float f77 = (f58 + f65) * 0.5f;
        Vec2 vec214 = vec2Arr2[i16];
        if (((f38 - f76) * vec214.f48119x) + ((f39 - f77) * vec214.f48120y) > f46) {
            return;
        }
        manifold.f47963e = 1;
        manifold.f47962d = Manifold.ManifoldType.FACE_A;
        manifold.f47960b.set(vec214);
        Vec2 vec215 = manifold.f47961c;
        vec215.f48119x = f76;
        vec215.f48120y = f77;
        manifold.f47959a[0].f48039a.set(vec2);
        manifold.f47959a[0].f48042d.l();
    }
}
