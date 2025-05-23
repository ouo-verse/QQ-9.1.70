package h7;

import com.qzone.jbox2d.collision.Manifold;
import com.qzone.jbox2d.common.Mat22;
import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;
import h7.i;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public com.qzone.jbox2d.dynamics.k f404506a;

    /* renamed from: b, reason: collision with root package name */
    public n[] f404507b;

    /* renamed from: c, reason: collision with root package name */
    public p[] f404508c;

    /* renamed from: f, reason: collision with root package name */
    public d[] f404511f;

    /* renamed from: g, reason: collision with root package name */
    public int f404512g;

    /* renamed from: h, reason: collision with root package name */
    private final Transform f404513h = new Transform();

    /* renamed from: i, reason: collision with root package name */
    private final Transform f404514i = new Transform();

    /* renamed from: j, reason: collision with root package name */
    private final com.qzone.jbox2d.collision.i f404515j = new com.qzone.jbox2d.collision.i();

    /* renamed from: k, reason: collision with root package name */
    private final o f404516k = new o();

    /* renamed from: d, reason: collision with root package name */
    public f[] f404509d = new f[256];

    /* renamed from: e, reason: collision with root package name */
    public i[] f404510e = new i[256];

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public com.qzone.jbox2d.dynamics.k f404517a;

        /* renamed from: b, reason: collision with root package name */
        public d[] f404518b;

        /* renamed from: c, reason: collision with root package name */
        public int f404519c;

        /* renamed from: d, reason: collision with root package name */
        public n[] f404520d;

        /* renamed from: e, reason: collision with root package name */
        public p[] f404521e;
    }

    public h() {
        for (int i3 = 0; i3 < 256; i3++) {
            this.f404509d[i3] = new f();
            this.f404510e[i3] = new i();
        }
    }

    public final void a(a aVar) {
        this.f404506a = aVar.f404517a;
        int i3 = aVar.f404519c;
        this.f404512g = i3;
        f[] fVarArr = this.f404509d;
        if (fVarArr.length < i3) {
            f[] fVarArr2 = new f[com.qzone.jbox2d.common.b.k(fVarArr.length * 2, i3)];
            this.f404509d = fVarArr2;
            System.arraycopy(fVarArr, 0, fVarArr2, 0, fVarArr.length);
            int length = fVarArr.length;
            while (true) {
                f[] fVarArr3 = this.f404509d;
                if (length >= fVarArr3.length) {
                    break;
                }
                fVarArr3[length] = new f();
                length++;
            }
        }
        i[] iVarArr = this.f404510e;
        int length2 = iVarArr.length;
        int i16 = this.f404512g;
        if (length2 < i16) {
            i[] iVarArr2 = new i[com.qzone.jbox2d.common.b.k(iVarArr.length * 2, i16)];
            this.f404510e = iVarArr2;
            System.arraycopy(iVarArr, 0, iVarArr2, 0, iVarArr.length);
            int length3 = iVarArr.length;
            while (true) {
                i[] iVarArr3 = this.f404510e;
                if (length3 >= iVarArr3.length) {
                    break;
                }
                iVarArr3[length3] = new i();
                length3++;
            }
        }
        this.f404507b = aVar.f404520d;
        this.f404508c = aVar.f404521e;
        this.f404511f = aVar.f404518b;
        for (int i17 = 0; i17 < this.f404512g; i17++) {
            d dVar = this.f404511f[i17];
            com.qzone.jbox2d.dynamics.e eVar = dVar.f404473f;
            com.qzone.jbox2d.dynamics.e eVar2 = dVar.f404474g;
            com.qzone.jbox2d.collision.shapes.f i18 = eVar.i();
            com.qzone.jbox2d.collision.shapes.f i19 = eVar2.i();
            float f16 = i18.f48104b;
            float f17 = i19.f48104b;
            com.qzone.jbox2d.dynamics.a f18 = eVar.f();
            com.qzone.jbox2d.dynamics.a f19 = eVar2.f();
            Manifold f26 = dVar.f();
            int i26 = f26.f47963e;
            i iVar = this.f404510e[i17];
            iVar.f404532k = dVar.f404480m;
            iVar.f404533l = dVar.f404481n;
            iVar.f404534m = dVar.f404482o;
            iVar.f404526e = f18.f48162c;
            iVar.f404527f = f19.f48162c;
            iVar.f404528g = f18.f48177r;
            iVar.f404529h = f19.f48177r;
            iVar.f404530i = f18.f48179t;
            iVar.f404531j = f19.f48179t;
            iVar.f404536o = i17;
            iVar.f404535n = i26;
            iVar.f404525d.setZero();
            iVar.f404524c.setZero();
            f fVar = this.f404509d[i17];
            fVar.f404492d = f18.f48162c;
            fVar.f404493e = f19.f48162c;
            fVar.f404494f = f18.f48177r;
            fVar.f404495g = f19.f48177r;
            fVar.f404496h.set(f18.f48165f.localCenter);
            fVar.f404497i.set(f19.f48165f.localCenter);
            fVar.f404498j = f18.f48179t;
            fVar.f404499k = f19.f48179t;
            fVar.f404490b.set(f26.f47960b);
            fVar.f404491c.set(f26.f47961c);
            fVar.f404503o = i26;
            fVar.f404501m = f16;
            fVar.f404502n = f17;
            fVar.f404500l = f26.f47962d;
            for (int i27 = 0; i27 < i26; i27++) {
                com.qzone.jbox2d.collision.e eVar3 = f26.f47959a[i27];
                i.a aVar2 = iVar.f404522a[i27];
                com.qzone.jbox2d.dynamics.k kVar = this.f404506a;
                if (kVar.f48274f) {
                    float f27 = kVar.f48271c;
                    aVar2.f404539c = eVar3.f48040b * f27;
                    aVar2.f404540d = f27 * eVar3.f48041c;
                } else {
                    aVar2.f404539c = 0.0f;
                    aVar2.f404540d = 0.0f;
                }
                aVar2.f404537a.setZero();
                aVar2.f404538b.setZero();
                aVar2.f404541e = 0.0f;
                aVar2.f404542f = 0.0f;
                aVar2.f404543g = 0.0f;
                Vec2 vec2 = fVar.f404489a[i27];
                Vec2 vec22 = eVar3.f48039a;
                vec2.f48119x = vec22.f48119x;
                vec2.f48120y = vec22.f48120y;
            }
        }
    }

    public void f() {
        for (int i3 = 0; i3 < this.f404512g; i3++) {
            i iVar = this.f404510e[i3];
            Manifold f16 = this.f404511f[iVar.f404536o].f();
            for (int i16 = 0; i16 < iVar.f404535n; i16++) {
                com.qzone.jbox2d.collision.e eVar = f16.f47959a[i16];
                i.a aVar = iVar.f404522a[i16];
                eVar.f48040b = aVar.f404539c;
                eVar.f48041c = aVar.f404540d;
            }
        }
    }

    public final void b() {
        Vec2 vec2;
        float f16;
        h hVar = this;
        int i3 = 0;
        while (i3 < hVar.f404512g) {
            i iVar = hVar.f404510e[i3];
            f fVar = hVar.f404509d[i3];
            float f17 = fVar.f404501m;
            float f18 = fVar.f404502n;
            Manifold f19 = hVar.f404511f[iVar.f404536o].f();
            int i16 = iVar.f404526e;
            int i17 = iVar.f404527f;
            float f26 = iVar.f404528g;
            float f27 = iVar.f404529h;
            float f28 = iVar.f404530i;
            float f29 = iVar.f404531j;
            Vec2 vec22 = fVar.f404496h;
            Vec2 vec23 = fVar.f404497i;
            n[] nVarArr = hVar.f404507b;
            n nVar = nVarArr[i16];
            int i18 = i3;
            Vec2 vec24 = nVar.f404544a;
            float f36 = nVar.f404545b;
            p[] pVarArr = hVar.f404508c;
            p pVar = pVarArr[i16];
            Vec2 vec25 = pVar.f404550a;
            float f37 = pVar.f404551b;
            n nVar2 = nVarArr[i17];
            Vec2 vec26 = vec25;
            Vec2 vec27 = nVar2.f404544a;
            float f38 = nVar2.f404545b;
            p pVar2 = pVarArr[i17];
            Vec2 vec28 = pVar2.f404550a;
            float f39 = pVar2.f404551b;
            Rot rot = hVar.f404513h.f48118q;
            Rot rot2 = hVar.f404514i.f48118q;
            rot.set(f36);
            rot2.set(f38);
            Transform transform = hVar.f404513h;
            Vec2 vec29 = transform.f48117p;
            Vec2 vec210 = vec28;
            float f46 = vec24.f48119x;
            float f47 = rot.f48110c;
            float f48 = vec22.f48119x * f47;
            float f49 = rot.f48111s;
            float f56 = vec22.f48120y;
            vec29.f48119x = f46 - (f48 - (f49 * f56));
            vec29.f48120y = vec24.f48120y - ((f49 * vec22.f48119x) + (f47 * f56));
            Transform transform2 = hVar.f404514i;
            Vec2 vec211 = transform2.f48117p;
            float f57 = vec27.f48119x;
            float f58 = rot2.f48110c;
            float f59 = vec23.f48119x * f58;
            float f65 = rot2.f48111s;
            float f66 = vec23.f48120y;
            vec211.f48119x = f57 - (f59 - (f65 * f66));
            vec211.f48120y = vec27.f48120y - ((f65 * vec23.f48119x) + (f58 * f66));
            hVar.f404515j.a(f19, transform, f17, transform2, f18);
            Vec2 vec212 = iVar.f404523b;
            Vec2 vec213 = hVar.f404515j.f48070a;
            vec212.f48119x = vec213.f48119x;
            vec212.f48120y = vec213.f48120y;
            int i19 = iVar.f404535n;
            int i26 = 0;
            while (i26 < i19) {
                i.a aVar = iVar.f404522a[i26];
                Vec2 vec214 = hVar.f404515j.f48071b[i26];
                Vec2 vec215 = aVar.f404537a;
                Vec2 vec216 = aVar.f404538b;
                vec215.f48119x = vec214.f48119x - vec24.f48119x;
                vec215.f48120y = vec214.f48120y - vec24.f48120y;
                float f67 = vec214.f48119x - vec27.f48119x;
                vec216.f48119x = f67;
                float f68 = vec214.f48120y - vec27.f48120y;
                vec216.f48120y = f68;
                float f69 = vec215.f48119x;
                float f75 = vec212.f48120y;
                float f76 = vec215.f48120y;
                float f77 = vec212.f48119x;
                float f78 = (f69 * f75) - (f76 * f77);
                float f79 = (f67 * f75) - (f68 * f77);
                float f85 = f26 + f27;
                float f86 = f85 + (f28 * f78 * f78) + (f29 * f79 * f79);
                aVar.f404541e = f86 > 0.0f ? 1.0f / f86 : 0.0f;
                float f87 = f75 * 1.0f;
                float f88 = (-1.0f) * f77;
                float f89 = (f69 * f88) - (f76 * f87);
                float f95 = (f88 * f67) - (f87 * f68);
                float f96 = f85 + (f28 * f89 * f89) + (f29 * f95 * f95);
                if (f96 > 0.0f) {
                    vec2 = vec24;
                    f16 = 1.0f / f96;
                } else {
                    vec2 = vec24;
                    f16 = 0.0f;
                }
                aVar.f404542f = f16;
                aVar.f404543g = 0.0f;
                Vec2 vec217 = vec210;
                int i27 = i19;
                Vec2 vec218 = vec26;
                float f97 = (f77 * (((vec217.f48119x + ((-f39) * f68)) - vec218.f48119x) - ((-f37) * f76))) + (f75 * (((vec217.f48120y + (f39 * f67)) - vec218.f48120y) - (f37 * f69)));
                if (f97 < (-com.qzone.jbox2d.common.d.f48150r)) {
                    aVar.f404543g = (-iVar.f404533l) * f97;
                }
                i26++;
                hVar = this;
                vec210 = vec217;
                vec26 = vec218;
                vec24 = vec2;
                i19 = i27;
            }
            if (iVar.f404535n == 2) {
                i.a[] aVarArr = iVar.f404522a;
                i.a aVar2 = aVarArr[0];
                i.a aVar3 = aVarArr[1];
                Vec2 vec219 = aVar2.f404537a;
                float f98 = vec219.f48119x;
                float f99 = vec212.f48120y;
                float f100 = vec219.f48120y;
                float f101 = vec212.f48119x;
                float f102 = (f98 * f99) - (f100 * f101);
                Vec2 vec220 = aVar2.f404538b;
                float f103 = (vec220.f48119x * f99) - (vec220.f48120y * f101);
                Vec2 vec221 = aVar3.f404537a;
                float f104 = (vec221.f48119x * f99) - (vec221.f48120y * f101);
                Vec2 vec222 = aVar3.f404538b;
                float f105 = (vec222.f48119x * f99) - (vec222.f48120y * f101);
                float f106 = f26 + f27;
                float f107 = f28 * f102;
                float f108 = f29 * f103;
                float f109 = (f102 * f107) + f106 + (f103 * f108);
                float f110 = (f28 * f104 * f104) + f106 + (f29 * f105 * f105);
                float f111 = f106 + (f107 * f104) + (f108 * f105);
                if (f109 * f109 < ((f109 * f110) - (f111 * f111)) * 100.0f) {
                    Mat22 mat22 = iVar.f404525d;
                    Vec2 vec223 = mat22.f48105ex;
                    vec223.f48119x = f109;
                    vec223.f48120y = f111;
                    Vec2 vec224 = mat22.f48106ey;
                    vec224.f48119x = f111;
                    vec224.f48120y = f110;
                    mat22.invertToOut(iVar.f404524c);
                } else {
                    iVar.f404535n = 1;
                }
            }
            i3 = i18 + 1;
            hVar = this;
        }
    }

    public final void e() {
        h hVar = this;
        int i3 = 0;
        while (i3 < hVar.f404512g) {
            i iVar = hVar.f404510e[i3];
            int i16 = iVar.f404526e;
            int i17 = iVar.f404527f;
            float f16 = iVar.f404528g;
            float f17 = iVar.f404529h;
            float f18 = iVar.f404530i;
            float f19 = iVar.f404531j;
            int i18 = iVar.f404535n;
            p[] pVarArr = hVar.f404508c;
            p pVar = pVarArr[i16];
            Vec2 vec2 = pVar.f404550a;
            float f26 = pVar.f404551b;
            p pVar2 = pVarArr[i17];
            Vec2 vec22 = pVar2.f404550a;
            float f27 = pVar2.f404551b;
            Vec2 vec23 = iVar.f404523b;
            float f28 = vec23.f48119x;
            float f29 = vec23.f48120y;
            float f36 = 1.0f * f29;
            float f37 = f28 * (-1.0f);
            float f38 = iVar.f404532k;
            int i19 = i3;
            int i26 = 0;
            float f39 = f26;
            float f46 = f27;
            while (i26 < i18) {
                int i27 = i18;
                i.a aVar = iVar.f404522a[i26];
                int i28 = i17;
                Vec2 vec24 = aVar.f404537a;
                int i29 = i16;
                Vec2 vec25 = aVar.f404538b;
                float f47 = aVar.f404542f * (-((((((((-f46) * vec25.f48120y) + vec22.f48119x) - vec2.f48119x) + (vec24.f48120y * f39)) * f36) + (((((vec25.f48119x * f46) + vec22.f48120y) - vec2.f48120y) - (vec24.f48119x * f39)) * f37)) - iVar.f404534m));
                float f48 = aVar.f404539c * f38;
                float c16 = com.qzone.jbox2d.common.b.c(aVar.f404540d + f47, -f48, f48);
                float f49 = c16 - aVar.f404540d;
                aVar.f404540d = c16;
                float f56 = f36 * f49;
                float f57 = f49 * f37;
                vec2.f48119x -= f56 * f16;
                vec2.f48120y -= f57 * f16;
                Vec2 vec26 = aVar.f404537a;
                f39 -= ((vec26.f48119x * f57) - (vec26.f48120y * f56)) * f18;
                vec22.f48119x += f56 * f17;
                vec22.f48120y += f57 * f17;
                Vec2 vec27 = aVar.f404538b;
                f46 += ((vec27.f48119x * f57) - (vec27.f48120y * f56)) * f19;
                i26++;
                i18 = i27;
                i17 = i28;
                i16 = i29;
                f29 = f29;
            }
            int i36 = i16;
            int i37 = i17;
            float f58 = f29;
            if (iVar.f404535n == 1) {
                i.a aVar2 = iVar.f404522a[0];
                Vec2 vec28 = aVar2.f404538b;
                float f59 = ((-f46) * vec28.f48120y) + vec22.f48119x;
                float f65 = vec2.f48119x;
                Vec2 vec29 = aVar2.f404537a;
                float f66 = (f59 - f65) + (vec29.f48120y * f39);
                float f67 = (vec28.f48119x * f46) + vec22.f48120y;
                float f68 = vec2.f48120y;
                float f69 = (-aVar2.f404541e) * (((f66 * f28) + (((f67 - f68) - (vec29.f48119x * f39)) * f58)) - aVar2.f404543g);
                float f75 = aVar2.f404539c;
                float f76 = f69 + f75;
                if (f76 <= 0.0f) {
                    f76 = 0.0f;
                }
                float f77 = f76 - f75;
                aVar2.f404539c = f76;
                float f78 = f28 * f77;
                float f79 = f58 * f77;
                vec2.f48119x = f65 - (f78 * f16);
                vec2.f48120y = f68 - (f16 * f79);
                f39 -= f18 * ((vec29.f48119x * f79) - (vec29.f48120y * f78));
                vec22.f48119x += f78 * f17;
                vec22.f48120y += f17 * f79;
                f46 += f19 * ((vec28.f48119x * f79) - (vec28.f48120y * f78));
            } else {
                i.a[] aVarArr = iVar.f404522a;
                i.a aVar3 = aVarArr[0];
                i.a aVar4 = aVarArr[1];
                Vec2 vec210 = aVar3.f404537a;
                Vec2 vec211 = aVar3.f404538b;
                Vec2 vec212 = aVar4.f404537a;
                Vec2 vec213 = aVar4.f404538b;
                float f85 = aVar3.f404539c;
                float f86 = aVar4.f404539c;
                float f87 = -f46;
                float f88 = vec211.f48120y * f87;
                float f89 = vec22.f48119x;
                float f95 = vec2.f48119x;
                float f96 = ((f88 + f89) - f95) + (vec210.f48120y * f39);
                float f97 = vec211.f48119x * f46;
                float f98 = vec22.f48120y;
                float f99 = vec2.f48120y;
                float f100 = ((f97 + f98) - f99) - (vec210.f48119x * f39);
                float f101 = (((((f87 * vec213.f48120y) + f89) - f95) + (vec212.f48120y * f39)) * f28) + (((((vec213.f48119x * f46) + f98) - f99) - (vec212.f48119x * f39)) * f58);
                float f102 = ((f96 * f28) + (f100 * f58)) - aVar3.f404543g;
                float f103 = f101 - aVar4.f404543g;
                Mat22 mat22 = iVar.f404525d;
                Vec2 vec214 = mat22.f48105ex;
                float f104 = vec214.f48119x * f85;
                Vec2 vec215 = mat22.f48106ey;
                float f105 = vec215.f48119x;
                float f106 = f102 - (f104 + (f105 * f86));
                float f107 = vec214.f48120y;
                float f108 = f103 - ((f107 * f85) + (vec215.f48120y * f86));
                Mat22 mat222 = iVar.f404524c;
                Vec2 vec216 = mat222.f48105ex;
                float f109 = vec216.f48119x * f106;
                Vec2 vec217 = mat222.f48106ey;
                float f110 = (f109 + (vec217.f48119x * f108)) * (-1.0f);
                float f111 = ((vec216.f48120y * f106) + (vec217.f48120y * f108)) * (-1.0f);
                if (f110 >= 0.0f && f111 >= 0.0f) {
                    float f112 = f110 - f85;
                    float f113 = f111 - f86;
                    float f114 = f112 * f28;
                    float f115 = f112 * f58;
                    float f116 = f28 * f113;
                    float f117 = f113 * f58;
                    float f118 = f114 + f116;
                    vec2.f48119x = f95 - (f16 * f118);
                    float f119 = f115 + f117;
                    vec2.f48120y = f99 - (f16 * f119);
                    vec22.f48119x += f118 * f17;
                    vec22.f48120y += f119 * f17;
                    f39 -= (((vec210.f48119x * f115) - (vec210.f48120y * f114)) + ((vec212.f48119x * f117) - (vec212.f48120y * f116))) * f18;
                    f46 += f19 * (((vec211.f48119x * f115) - (vec211.f48120y * f114)) + ((vec213.f48119x * f117) - (vec213.f48120y * f116)));
                    aVar3.f404539c = f110;
                    aVar4.f404539c = f111;
                } else {
                    float f120 = (-aVar3.f404541e) * f106;
                    float f121 = (f107 * f120) + f108;
                    if (f120 >= 0.0f && f121 >= 0.0f) {
                        float f122 = f120 - f85;
                        float f123 = 0.0f - f86;
                        float f124 = f28 * f122;
                        float f125 = f122 * f58;
                        float f126 = f28 * f123;
                        float f127 = f123 * f58;
                        float f128 = f124 + f126;
                        vec2.f48119x = f95 - (f16 * f128);
                        float f129 = f125 + f127;
                        vec2.f48120y = f99 - (f16 * f129);
                        vec22.f48119x += f17 * f128;
                        vec22.f48120y += f129 * f17;
                        f39 -= f18 * (((vec210.f48119x * f125) - (vec210.f48120y * f124)) + ((vec212.f48119x * f127) - (vec212.f48120y * f126)));
                        f46 += f19 * (((vec211.f48119x * f125) - (vec211.f48120y * f124)) + ((vec213.f48119x * f127) - (vec213.f48120y * f126)));
                        aVar3.f404539c = f120;
                        aVar4.f404539c = 0.0f;
                    } else {
                        float f130 = (-aVar4.f404541e) * f108;
                        float f131 = (f105 * f130) + f106;
                        if (f130 >= 0.0f && f131 >= 0.0f) {
                            float f132 = 0.0f - f85;
                            float f133 = f130 - f86;
                            float f134 = f28 * f132;
                            float f135 = f132 * f58;
                            float f136 = f28 * f133;
                            float f137 = f133 * f58;
                            float f138 = f134 + f136;
                            vec2.f48119x = f95 - (f16 * f138);
                            float f139 = f135 + f137;
                            vec2.f48120y = f99 - (f16 * f139);
                            vec22.f48119x += f17 * f138;
                            vec22.f48120y += f139 * f17;
                            f39 -= f18 * (((vec210.f48119x * f135) - (vec210.f48120y * f134)) + ((vec212.f48119x * f137) - (vec212.f48120y * f136)));
                            f46 += f19 * (((vec211.f48119x * f135) - (vec211.f48120y * f134)) + ((vec213.f48119x * f137) - (vec213.f48120y * f136)));
                            aVar3.f404539c = 0.0f;
                            aVar4.f404539c = f130;
                        } else if (f106 >= 0.0f && f108 >= 0.0f) {
                            float f140 = 0.0f - f85;
                            float f141 = 0.0f - f86;
                            float f142 = f28 * f140;
                            float f143 = f140 * f58;
                            float f144 = f28 * f141;
                            float f145 = f141 * f58;
                            float f146 = f142 + f144;
                            vec2.f48119x = f95 - (f16 * f146);
                            float f147 = f143 + f145;
                            vec2.f48120y = f99 - (f16 * f147);
                            vec22.f48119x += f146 * f17;
                            vec22.f48120y += f147 * f17;
                            f39 -= f18 * (((vec210.f48119x * f143) - (vec210.f48120y * f142)) + ((vec212.f48119x * f145) - (vec212.f48120y * f144)));
                            f46 += f19 * (((vec211.f48119x * f143) - (vec211.f48120y * f142)) + ((vec213.f48119x * f145) - (vec213.f48120y * f144)));
                            aVar3.f404539c = 0.0f;
                            aVar4.f404539c = 0.0f;
                        }
                    }
                }
            }
            float f148 = f39;
            p[] pVarArr2 = this.f404508c;
            pVarArr2[i36].f404551b = f148;
            pVarArr2[i37].f404551b = f46;
            i3 = i19 + 1;
            hVar = this;
        }
    }

    public void g() {
        int i3 = 0;
        while (i3 < this.f404512g) {
            i iVar = this.f404510e[i3];
            int i16 = iVar.f404526e;
            int i17 = iVar.f404527f;
            float f16 = iVar.f404528g;
            float f17 = iVar.f404530i;
            float f18 = iVar.f404529h;
            float f19 = iVar.f404531j;
            int i18 = iVar.f404535n;
            p[] pVarArr = this.f404508c;
            p pVar = pVarArr[i16];
            Vec2 vec2 = pVar.f404550a;
            float f26 = pVar.f404551b;
            p pVar2 = pVarArr[i17];
            Vec2 vec22 = pVar2.f404550a;
            float f27 = pVar2.f404551b;
            Vec2 vec23 = iVar.f404523b;
            float f28 = vec23.f48120y * 1.0f;
            float f29 = vec23.f48119x * (-1.0f);
            int i19 = i3;
            float f36 = f26;
            float f37 = f27;
            int i26 = 0;
            while (i26 < i18) {
                int i27 = i18;
                i.a aVar = iVar.f404522a[i26];
                i iVar2 = iVar;
                float f38 = aVar.f404540d;
                float f39 = f28 * f38;
                float f46 = f28;
                float f47 = vec23.f48119x;
                int i28 = i16;
                float f48 = aVar.f404539c;
                float f49 = f39 + (f47 * f48);
                float f56 = (f38 * f29) + (vec23.f48120y * f48);
                Vec2 vec24 = aVar.f404537a;
                f36 -= ((vec24.f48119x * f56) - (vec24.f48120y * f49)) * f17;
                vec2.f48119x -= f49 * f16;
                vec2.f48120y -= f56 * f16;
                Vec2 vec25 = aVar.f404538b;
                f37 += ((vec25.f48119x * f56) - (vec25.f48120y * f49)) * f19;
                vec22.f48119x += f49 * f18;
                vec22.f48120y += f56 * f18;
                i26++;
                i18 = i27;
                iVar = iVar2;
                f28 = f46;
                i16 = i28;
            }
            p[] pVarArr2 = this.f404508c;
            pVarArr2[i16].f404551b = f36;
            pVarArr2[i17].f404551b = f37;
            i3 = i19 + 1;
        }
    }

    public final boolean c() {
        int i3 = 0;
        float f16 = 0.0f;
        while (i3 < this.f404512g) {
            f fVar = this.f404509d[i3];
            int i16 = fVar.f404492d;
            int i17 = fVar.f404493e;
            float f17 = fVar.f404494f;
            float f18 = fVar.f404498j;
            Vec2 vec2 = fVar.f404496h;
            float f19 = vec2.f48119x;
            float f26 = vec2.f48120y;
            float f27 = fVar.f404495g;
            float f28 = fVar.f404499k;
            Vec2 vec22 = fVar.f404497i;
            float f29 = vec22.f48119x;
            float f36 = vec22.f48120y;
            int i18 = fVar.f404503o;
            n[] nVarArr = this.f404507b;
            float f37 = f16;
            n nVar = nVarArr[i16];
            int i19 = i3;
            Vec2 vec23 = nVar.f404544a;
            float f38 = nVar.f404545b;
            n nVar2 = nVarArr[i17];
            Vec2 vec24 = nVar2.f404544a;
            float f39 = nVar2.f404545b;
            float f46 = f37;
            int i26 = 0;
            float f47 = f38;
            while (i26 < i18) {
                int i27 = i18;
                Rot rot = this.f404513h.f48118q;
                float f48 = f18;
                Rot rot2 = this.f404514i.f48118q;
                rot.set(f47);
                rot2.set(f39);
                float f49 = f39;
                Transform transform = this.f404513h;
                float f56 = f47;
                Vec2 vec25 = transform.f48117p;
                float f57 = f17;
                float f58 = vec23.f48119x;
                float f59 = f27;
                float f65 = rot.f48110c;
                float f66 = rot.f48111s;
                vec25.f48119x = (f58 - (f65 * f19)) + (f66 * f26);
                vec25.f48120y = (vec23.f48120y - (f66 * f19)) - (f65 * f26);
                Transform transform2 = this.f404514i;
                Vec2 vec26 = transform2.f48117p;
                float f67 = vec24.f48119x;
                float f68 = rot2.f48110c;
                float f69 = rot2.f48111s;
                vec26.f48119x = (f67 - (f68 * f29)) + (f69 * f36);
                vec26.f48120y = (vec24.f48120y - (f69 * f29)) - (f68 * f36);
                o oVar = this.f404516k;
                oVar.a(fVar, transform, transform2, i26);
                Vec2 vec27 = oVar.f404546a;
                Vec2 vec28 = oVar.f404547b;
                float f75 = oVar.f404548c;
                float f76 = vec28.f48119x;
                float f77 = f76 - vec23.f48119x;
                float f78 = vec28.f48120y;
                float f79 = f78 - vec23.f48120y;
                f fVar2 = fVar;
                float f85 = f76 - vec24.f48119x;
                float f86 = f78 - vec24.f48120y;
                float l3 = com.qzone.jbox2d.common.b.l(f46, f75);
                float c16 = com.qzone.jbox2d.common.b.c(com.qzone.jbox2d.common.d.f48157y * (f75 + com.qzone.jbox2d.common.d.f48145m), -com.qzone.jbox2d.common.d.f48151s, 0.0f);
                float f87 = vec27.f48120y;
                float f88 = vec27.f48119x;
                float f89 = (f77 * f87) - (f79 * f88);
                float f95 = (f85 * f87) - (f86 * f88);
                float f96 = f57 + f59 + (f48 * f89 * f89) + (f28 * f95 * f95);
                float f97 = f96 > 0.0f ? (-c16) / f96 : 0.0f;
                float f98 = f88 * f97;
                float f99 = f87 * f97;
                vec23.f48119x -= f98 * f57;
                vec23.f48120y -= f99 * f57;
                float f100 = f56 - (((f77 * f99) - (f79 * f98)) * f48);
                vec24.f48119x += f98 * f59;
                vec24.f48120y += f99 * f59;
                f39 = f49 + (f28 * ((f85 * f99) - (f86 * f98)));
                i26++;
                f47 = f100;
                i18 = i27;
                f18 = f48;
                f17 = f57;
                f27 = f59;
                fVar = fVar2;
                f46 = l3;
            }
            float f101 = f39;
            n[] nVarArr2 = this.f404507b;
            nVarArr2[i16].f404545b = f47;
            nVarArr2[i17].f404545b = f101;
            i3 = i19 + 1;
            f16 = f46;
        }
        return f16 >= com.qzone.jbox2d.common.d.f48145m * (-3.0f);
    }

    public boolean d(int i3, int i16) {
        float f16;
        float f17;
        float f18;
        float f19;
        int i17 = i3;
        int i18 = i16;
        int i19 = 0;
        float f26 = 0.0f;
        while (i19 < this.f404512g) {
            f fVar = this.f404509d[i19];
            int i26 = fVar.f404492d;
            int i27 = fVar.f404493e;
            Vec2 vec2 = fVar.f404496h;
            Vec2 vec22 = fVar.f404497i;
            float f27 = vec2.f48119x;
            float f28 = vec2.f48120y;
            float f29 = vec22.f48119x;
            float f36 = vec22.f48120y;
            int i28 = fVar.f404503o;
            if (i26 == i17 || i26 == i18) {
                f16 = fVar.f404494f;
                f17 = fVar.f404498j;
            } else {
                f17 = 0.0f;
                f16 = 0.0f;
            }
            if (i27 == i17 || i27 == i18) {
                f18 = fVar.f404495g;
                f19 = fVar.f404499k;
            } else {
                f19 = 0.0f;
                f18 = 0.0f;
            }
            n[] nVarArr = this.f404507b;
            float f37 = f26;
            n nVar = nVarArr[i26];
            int i29 = i19;
            Vec2 vec23 = nVar.f404544a;
            float f38 = nVar.f404545b;
            n nVar2 = nVarArr[i27];
            Vec2 vec24 = nVar2.f404544a;
            float f39 = nVar2.f404545b;
            float f46 = f19;
            float f47 = f37;
            int i36 = 0;
            float f48 = f38;
            while (i36 < i28) {
                int i37 = i28;
                Rot rot = this.f404513h.f48118q;
                float f49 = f17;
                Rot rot2 = this.f404514i.f48118q;
                rot.set(f48);
                rot2.set(f39);
                float f56 = f39;
                Transform transform = this.f404513h;
                float f57 = f48;
                Vec2 vec25 = transform.f48117p;
                float f58 = f18;
                float f59 = vec23.f48119x;
                float f65 = f16;
                float f66 = rot.f48110c;
                float f67 = rot.f48111s;
                vec25.f48119x = (f59 - (f66 * f27)) + (f67 * f28);
                vec25.f48120y = (vec23.f48120y - (f67 * f27)) - (f66 * f28);
                Transform transform2 = this.f404514i;
                Vec2 vec26 = transform2.f48117p;
                float f68 = vec24.f48119x;
                float f69 = rot2.f48110c;
                float f75 = rot2.f48111s;
                vec26.f48119x = (f68 - (f69 * f29)) + (f75 * f36);
                vec26.f48120y = (vec24.f48120y - (f75 * f29)) - (f69 * f36);
                o oVar = this.f404516k;
                oVar.a(fVar, transform, transform2, i36);
                Vec2 vec27 = oVar.f404546a;
                Vec2 vec28 = oVar.f404547b;
                float f76 = oVar.f404548c;
                float f77 = vec28.f48119x;
                float f78 = f77 - vec23.f48119x;
                float f79 = vec28.f48120y;
                float f85 = f79 - vec23.f48120y;
                f fVar2 = fVar;
                float f86 = f77 - vec24.f48119x;
                float f87 = f79 - vec24.f48120y;
                float l3 = com.qzone.jbox2d.common.b.l(f47, f76);
                float c16 = com.qzone.jbox2d.common.b.c(com.qzone.jbox2d.common.d.f48158z * (f76 + com.qzone.jbox2d.common.d.f48145m), -com.qzone.jbox2d.common.d.f48151s, 0.0f);
                float f88 = vec27.f48120y;
                float f89 = vec27.f48119x;
                float f95 = (f78 * f88) - (f85 * f89);
                float f96 = (f86 * f88) - (f87 * f89);
                float f97 = f65 + f58 + (f49 * f95 * f95) + (f46 * f96 * f96);
                float f98 = f97 > 0.0f ? (-c16) / f97 : 0.0f;
                float f99 = f89 * f98;
                float f100 = f88 * f98;
                vec23.f48119x -= f99 * f65;
                vec23.f48120y -= f100 * f65;
                float f101 = f57 - (f49 * ((f78 * f100) - (f85 * f99)));
                vec24.f48119x += f99 * f58;
                vec24.f48120y += f100 * f58;
                f39 = f56 + (f46 * ((f86 * f100) - (f87 * f99)));
                i36++;
                f48 = f101;
                i28 = i37;
                f17 = f49;
                f18 = f58;
                f16 = f65;
                fVar = fVar2;
                f47 = l3;
            }
            n[] nVarArr2 = this.f404507b;
            nVarArr2[i26].f404545b = f48;
            nVarArr2[i27].f404545b = f39;
            i19 = i29 + 1;
            i17 = i3;
            i18 = i16;
            f26 = f47;
        }
        return f26 >= com.qzone.jbox2d.common.d.f48145m * (-1.5f);
    }
}
