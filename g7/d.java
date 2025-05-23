package g7;

import com.qzone.jbox2d.collision.f;
import com.qzone.jbox2d.common.Vec2;
import f7.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d implements b {

    /* renamed from: e, reason: collision with root package name */
    private int f401494e;

    /* renamed from: f, reason: collision with root package name */
    private final Vec2[] f401495f = new Vec2[4];

    /* renamed from: g, reason: collision with root package name */
    private e[] f401496g = new e[20];

    /* renamed from: h, reason: collision with root package name */
    private int f401497h = 0;

    /* renamed from: i, reason: collision with root package name */
    private final Vec2 f401498i = new Vec2();

    /* renamed from: j, reason: collision with root package name */
    private final com.qzone.jbox2d.collision.a f401499j = new com.qzone.jbox2d.collision.a();

    /* renamed from: k, reason: collision with root package name */
    private final f f401500k = new f();

    /* renamed from: l, reason: collision with root package name */
    private final com.qzone.jbox2d.collision.a f401501l = new com.qzone.jbox2d.collision.a();

    /* renamed from: m, reason: collision with root package name */
    private final com.qzone.jbox2d.common.a f401502m = new com.qzone.jbox2d.common.a();

    /* renamed from: n, reason: collision with root package name */
    private final Vec2 f401503n = new Vec2();

    /* renamed from: a, reason: collision with root package name */
    private e f401490a = null;

    /* renamed from: c, reason: collision with root package name */
    private int f401492c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f401493d = 16;

    /* renamed from: b, reason: collision with root package name */
    private e[] f401491b = new e[16];

    public d() {
        int i3 = 0;
        int i16 = 16 - 1;
        while (i16 >= 0) {
            this.f401491b[i16] = new e(i16);
            e[] eVarArr = this.f401491b;
            e eVar = eVarArr[i16];
            eVar.f401506c = i16 == this.f401493d - 1 ? null : eVarArr[i16 + 1];
            eVar.f401510g = -1;
            i16--;
        }
        this.f401494e = 0;
        while (true) {
            Vec2[] vec2Arr = this.f401495f;
            if (i3 >= vec2Arr.length) {
                return;
            }
            vec2Arr[i3] = new Vec2();
            i3++;
        }
    }

    private final e d() {
        int i3;
        if (this.f401494e == -1) {
            e[] eVarArr = this.f401491b;
            int i16 = this.f401493d * 2;
            this.f401493d = i16;
            e[] eVarArr2 = new e[i16];
            this.f401491b = eVarArr2;
            System.arraycopy(eVarArr, 0, eVarArr2, 0, eVarArr.length);
            int i17 = this.f401493d;
            while (true) {
                i17--;
                i3 = this.f401492c;
                if (i17 < i3) {
                    break;
                }
                this.f401491b[i17] = new e(i17);
                e[] eVarArr3 = this.f401491b;
                e eVar = eVarArr3[i17];
                eVar.f401506c = i17 == this.f401493d + (-1) ? null : eVarArr3[i17 + 1];
                eVar.f401510g = -1;
            }
            this.f401494e = i3;
        }
        e eVar2 = this.f401491b[this.f401494e];
        e eVar3 = eVar2.f401506c;
        this.f401494e = eVar3 != null ? eVar3.f401509f : -1;
        eVar2.f401506c = null;
        eVar2.f401507d = null;
        eVar2.f401508e = null;
        eVar2.f401510g = 0;
        eVar2.f401505b = null;
        this.f401492c++;
        return eVar2;
    }

    private e e(e eVar) {
        e eVar2 = eVar.f401507d;
        if (eVar2 != null && eVar.f401510g >= 2) {
            e eVar3 = eVar.f401508e;
            int i3 = eVar3.f401510g - eVar2.f401510g;
            if (i3 > 1) {
                e eVar4 = eVar3.f401507d;
                e eVar5 = eVar3.f401508e;
                eVar3.f401507d = eVar;
                eVar3.f401506c = eVar.f401506c;
                eVar.f401506c = eVar3;
                e eVar6 = eVar3.f401506c;
                if (eVar6 != null) {
                    if (eVar6.f401507d == eVar) {
                        eVar6.f401507d = eVar3;
                    } else {
                        eVar6.f401508e = eVar3;
                    }
                } else {
                    this.f401490a = eVar3;
                }
                if (eVar4.f401510g > eVar5.f401510g) {
                    eVar3.f401508e = eVar4;
                    eVar.f401508e = eVar5;
                    eVar5.f401506c = eVar;
                    eVar.f401504a.a(eVar2.f401504a, eVar5.f401504a);
                    eVar3.f401504a.a(eVar.f401504a, eVar4.f401504a);
                    int k3 = com.qzone.jbox2d.common.b.k(eVar2.f401510g, eVar5.f401510g) + 1;
                    eVar.f401510g = k3;
                    eVar3.f401510g = com.qzone.jbox2d.common.b.k(k3, eVar4.f401510g) + 1;
                } else {
                    eVar3.f401508e = eVar5;
                    eVar.f401508e = eVar4;
                    eVar4.f401506c = eVar;
                    eVar.f401504a.a(eVar2.f401504a, eVar4.f401504a);
                    eVar3.f401504a.a(eVar.f401504a, eVar5.f401504a);
                    int k16 = com.qzone.jbox2d.common.b.k(eVar2.f401510g, eVar4.f401510g) + 1;
                    eVar.f401510g = k16;
                    eVar3.f401510g = com.qzone.jbox2d.common.b.k(k16, eVar5.f401510g) + 1;
                }
                return eVar3;
            }
            if (i3 < -1) {
                e eVar7 = eVar2.f401507d;
                e eVar8 = eVar2.f401508e;
                eVar2.f401507d = eVar;
                eVar2.f401506c = eVar.f401506c;
                eVar.f401506c = eVar2;
                e eVar9 = eVar2.f401506c;
                if (eVar9 != null) {
                    if (eVar9.f401507d == eVar) {
                        eVar9.f401507d = eVar2;
                    } else {
                        eVar9.f401508e = eVar2;
                    }
                } else {
                    this.f401490a = eVar2;
                }
                if (eVar7.f401510g > eVar8.f401510g) {
                    eVar2.f401508e = eVar7;
                    eVar.f401507d = eVar8;
                    eVar8.f401506c = eVar;
                    eVar.f401504a.a(eVar3.f401504a, eVar8.f401504a);
                    eVar2.f401504a.a(eVar.f401504a, eVar7.f401504a);
                    int k17 = com.qzone.jbox2d.common.b.k(eVar3.f401510g, eVar8.f401510g) + 1;
                    eVar.f401510g = k17;
                    eVar2.f401510g = com.qzone.jbox2d.common.b.k(k17, eVar7.f401510g) + 1;
                } else {
                    eVar2.f401508e = eVar8;
                    eVar.f401507d = eVar7;
                    eVar7.f401506c = eVar;
                    eVar.f401504a.a(eVar3.f401504a, eVar7.f401504a);
                    eVar2.f401504a.a(eVar.f401504a, eVar8.f401504a);
                    int k18 = com.qzone.jbox2d.common.b.k(eVar3.f401510g, eVar7.f401510g) + 1;
                    eVar.f401510g = k18;
                    eVar2.f401510g = com.qzone.jbox2d.common.b.k(k18, eVar8.f401510g) + 1;
                }
                return eVar2;
            }
        }
        return eVar;
    }

    private final void f(e eVar) {
        int i3 = this.f401494e;
        eVar.f401506c = i3 != -1 ? this.f401491b[i3] : null;
        eVar.f401510g = -1;
        this.f401494e = eVar.f401509f;
        this.f401492c--;
    }

    private final void g(int i3) {
        float b16;
        float b17;
        e eVar = this.f401491b[i3];
        e eVar2 = this.f401490a;
        if (eVar2 == null) {
            this.f401490a = eVar;
            eVar.f401506c = null;
            return;
        }
        com.qzone.jbox2d.collision.a aVar = eVar.f401504a;
        while (true) {
            e eVar3 = eVar2.f401507d;
            if (eVar3 == null) {
                break;
            }
            e eVar4 = eVar2.f401508e;
            float b18 = eVar2.f401504a.b();
            this.f401501l.a(eVar2.f401504a, aVar);
            float b19 = this.f401501l.b();
            float f16 = b19 * 2.0f;
            float f17 = (b19 - b18) * 2.0f;
            if (eVar3.f401507d == null) {
                this.f401501l.a(aVar, eVar3.f401504a);
                b16 = this.f401501l.b() + f17;
            } else {
                this.f401501l.a(aVar, eVar3.f401504a);
                b16 = (this.f401501l.b() - eVar3.f401504a.b()) + f17;
            }
            if (eVar4.f401507d == null) {
                this.f401501l.a(aVar, eVar4.f401504a);
                b17 = this.f401501l.b() + f17;
            } else {
                this.f401501l.a(aVar, eVar4.f401504a);
                b17 = (this.f401501l.b() - eVar4.f401504a.b()) + f17;
            }
            if (f16 < b16 && f16 < b17) {
                break;
            } else {
                eVar2 = b16 < b17 ? eVar3 : eVar4;
            }
        }
        e eVar5 = this.f401491b[eVar2.f401509f].f401506c;
        e d16 = d();
        d16.f401506c = eVar5;
        d16.f401505b = null;
        d16.f401504a.a(aVar, eVar2.f401504a);
        d16.f401510g = eVar2.f401510g + 1;
        if (eVar5 != null) {
            if (eVar5.f401507d == eVar2) {
                eVar5.f401507d = d16;
            } else {
                eVar5.f401508e = d16;
            }
            d16.f401507d = eVar2;
            d16.f401508e = eVar;
            eVar2.f401506c = d16;
            eVar.f401506c = d16;
        } else {
            d16.f401507d = eVar2;
            d16.f401508e = eVar;
            eVar2.f401506c = d16;
            eVar.f401506c = d16;
            this.f401490a = d16;
        }
        e eVar6 = eVar.f401506c;
        while (eVar6 != null) {
            e e16 = e(eVar6);
            e eVar7 = e16.f401507d;
            e eVar8 = e16.f401508e;
            e16.f401510g = com.qzone.jbox2d.common.b.k(eVar7.f401510g, eVar8.f401510g) + 1;
            e16.f401504a.a(eVar7.f401504a, eVar8.f401504a);
            eVar6 = e16.f401506c;
        }
    }

    private final void h(e eVar) {
        if (eVar == this.f401490a) {
            this.f401490a = null;
            return;
        }
        e eVar2 = eVar.f401506c;
        e eVar3 = eVar2.f401506c;
        e eVar4 = eVar2.f401507d;
        if (eVar4 == eVar) {
            eVar4 = eVar2.f401508e;
        }
        if (eVar3 != null) {
            if (eVar3.f401507d == eVar2) {
                eVar3.f401507d = eVar4;
            } else {
                eVar3.f401508e = eVar4;
            }
            eVar4.f401506c = eVar3;
            f(eVar2);
            while (eVar3 != null) {
                e e16 = e(eVar3);
                e eVar5 = e16.f401507d;
                e eVar6 = e16.f401508e;
                e16.f401504a.a(eVar5.f401504a, eVar6.f401504a);
                e16.f401510g = com.qzone.jbox2d.common.b.k(eVar5.f401510g, eVar6.f401510g) + 1;
                eVar3 = e16.f401506c;
            }
            return;
        }
        this.f401490a = eVar4;
        eVar4.f401506c = null;
        f(eVar2);
    }

    @Override // g7.b
    public final void a(g gVar, com.qzone.jbox2d.collision.a aVar) {
        e[] eVarArr = this.f401496g;
        this.f401497h = 0 + 1;
        eVarArr[0] = this.f401490a;
        while (true) {
            int i3 = this.f401497h;
            if (i3 <= 0) {
                return;
            }
            e[] eVarArr2 = this.f401496g;
            int i16 = i3 - 1;
            this.f401497h = i16;
            e eVar = eVarArr2[i16];
            if (eVar != null && com.qzone.jbox2d.collision.a.c(eVar.f401504a, aVar)) {
                if (eVar.f401507d == null) {
                    if (!gVar.treeCallback(eVar.f401509f)) {
                        return;
                    }
                } else {
                    e[] eVarArr3 = this.f401496g;
                    if ((eVarArr3.length - this.f401497h) - 2 <= 0) {
                        e[] eVarArr4 = new e[eVarArr3.length * 2];
                        System.arraycopy(eVarArr3, 0, eVarArr4, 0, eVarArr3.length);
                        this.f401496g = eVarArr4;
                    }
                    e[] eVarArr5 = this.f401496g;
                    int i17 = this.f401497h;
                    int i18 = i17 + 1;
                    eVarArr5[i17] = eVar.f401507d;
                    this.f401497h = i18 + 1;
                    eVarArr5[i18] = eVar.f401508e;
                }
            }
        }
    }

    @Override // g7.b
    public final boolean b(int i3, com.qzone.jbox2d.collision.a aVar, Vec2 vec2) {
        e eVar = this.f401491b[i3];
        com.qzone.jbox2d.collision.a aVar2 = eVar.f401504a;
        Vec2 vec22 = aVar2.f47986a;
        float f16 = vec22.f48119x;
        Vec2 vec23 = aVar.f47986a;
        if (f16 <= vec23.f48119x && vec22.f48120y <= vec23.f48120y) {
            Vec2 vec24 = aVar.f47987b;
            float f17 = vec24.f48119x;
            Vec2 vec25 = aVar2.f47987b;
            if (f17 <= vec25.f48119x && vec24.f48120y <= vec25.f48120y) {
                return false;
            }
        }
        h(eVar);
        Vec2 vec26 = aVar2.f47986a;
        Vec2 vec27 = aVar2.f47987b;
        Vec2 vec28 = aVar.f47986a;
        float f18 = vec28.f48119x;
        float f19 = com.qzone.jbox2d.common.d.f48143k;
        vec26.f48119x = f18 - f19;
        vec26.f48120y = vec28.f48120y - f19;
        Vec2 vec29 = aVar.f47987b;
        float f26 = vec29.f48119x + f19;
        vec27.f48119x = f26;
        float f27 = vec29.f48120y + f19;
        vec27.f48120y = f27;
        float f28 = vec2.f48119x;
        float f29 = com.qzone.jbox2d.common.d.f48144l;
        float f36 = f28 * f29;
        float f37 = vec2.f48120y * f29;
        if (f36 < 0.0f) {
            vec26.f48119x += f36;
        } else {
            vec27.f48119x = f26 + f36;
        }
        if (f37 < 0.0f) {
            vec26.f48120y += f37;
        } else {
            vec27.f48120y = f27 + f37;
        }
        g(i3);
        return true;
    }

    @Override // g7.b
    public final int c(com.qzone.jbox2d.collision.a aVar, Object obj) {
        e d16 = d();
        int i3 = d16.f401509f;
        com.qzone.jbox2d.collision.a aVar2 = d16.f401504a;
        Vec2 vec2 = aVar2.f47986a;
        Vec2 vec22 = aVar.f47986a;
        float f16 = vec22.f48119x;
        float f17 = com.qzone.jbox2d.common.d.f48143k;
        vec2.f48119x = f16 - f17;
        vec2.f48120y = vec22.f48120y - f17;
        Vec2 vec23 = aVar2.f47987b;
        Vec2 vec24 = aVar.f47987b;
        vec23.f48119x = vec24.f48119x + f17;
        vec23.f48120y = vec24.f48120y + f17;
        d16.f401505b = obj;
        g(i3);
        return i3;
    }

    @Override // g7.b
    public final void destroyProxy(int i3) {
        e eVar = this.f401491b[i3];
        h(eVar);
        f(eVar);
    }

    @Override // g7.b
    public final com.qzone.jbox2d.collision.a getFatAABB(int i3) {
        return this.f401491b[i3].f401504a;
    }

    @Override // g7.b
    public final Object getUserData(int i3) {
        return this.f401491b[i3].f401505b;
    }
}
