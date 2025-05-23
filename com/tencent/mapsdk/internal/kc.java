package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.jx;
import com.tencent.mapsdk.internal.ka;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kc<D extends ka> extends kh<D> implements jx<D> {

    /* renamed from: a, reason: collision with root package name */
    ArrayList<jz<D>> f148956a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f148957b = true;

    /* renamed from: c, reason: collision with root package name */
    private int f148958c;

    public kc(int i3) {
        this.f148958c = i3;
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final jx<D> a() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final void b() {
        Iterator<jz<D>> it = this.f148956a.iterator();
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof kg) {
                    ((kg) next).m().j();
                } else {
                    next.b();
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final long c() {
        long c16;
        Iterator<jz<D>> it = this.f148956a.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof kg) {
                    c16 = ((kg) next).m().k();
                } else {
                    c16 = next.c();
                }
                j3 += c16;
            }
        }
        return j3;
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final long d() {
        long d16;
        Iterator<jz<D>> it = this.f148956a.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof kg) {
                    d16 = ((kg) next).m().l();
                } else {
                    d16 = next.d();
                }
                j3 += d16;
            }
        }
        return j3;
    }

    @Override // com.tencent.mapsdk.internal.jz, com.tencent.mapsdk.internal.kg
    public final long e() {
        long e16;
        Iterator<jz<D>> it = this.f148956a.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof kg) {
                    e16 = ((kg) next).m().e();
                } else {
                    e16 = next.e();
                }
                j3 += e16;
            }
        }
        return j3;
    }

    private void a(boolean z16) {
        this.f148957b = z16;
    }

    private void a(jz<D>... jzVarArr) {
        this.f148956a.addAll(Arrays.asList(jzVarArr));
    }

    public final jz<D> a(int i3) {
        if (i3 >= this.f148956a.size()) {
            return null;
        }
        return this.f148956a.get(i3);
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final void a(String str, D d16) {
        lc.b(ky.f149110p, str, this.f148958c);
        lc.a(ky.f149111q, str, "put data length", Integer.valueOf(d16 == null ? 0 : d16.a()), this.f148958c);
        Iterator<jz<D>> it = this.f148956a.iterator();
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof kg) {
                    ((kg) next).m().b(str, (String) d16);
                } else {
                    next.a(str, (String) d16);
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void b(jx.a<Long> aVar) {
        Iterator<jz<D>> it = this.f148956a.iterator();
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof jx) {
                    ((jx) next).a().b(aVar);
                } else if (next instanceof kg) {
                    kg<D> m3 = ((kg) next).m();
                    if (aVar != null) {
                        aVar.callback(Long.valueOf(m3.k()));
                    }
                } else if (aVar != null) {
                    aVar.callback(Long.valueOf(next.c()));
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void c(jx.a<Long> aVar) {
        Iterator<jz<D>> it = this.f148956a.iterator();
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof jx) {
                    ((jx) next).a().c(aVar);
                } else if (next instanceof kg) {
                    kg<D> m3 = ((kg) next).m();
                    if (aVar != null) {
                        aVar.callback(Long.valueOf(m3.l()));
                    }
                } else if (aVar != null) {
                    aVar.callback(Long.valueOf(next.d()));
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void d(jx.a<Long> aVar) {
        Iterator<jz<D>> it = this.f148956a.iterator();
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof jx) {
                    ((jx) next).a().d(aVar);
                } else if (next instanceof kg) {
                    kg<D> m3 = ((kg) next).m();
                    if (aVar != null) {
                        aVar.callback(Long.valueOf(m3.e()));
                    }
                } else if (aVar != null) {
                    aVar.callback(Long.valueOf(next.e()));
                }
            }
        }
    }

    private static void a(String str, D d16, List<jz<D>> list) {
        for (jz<D> jzVar : list) {
            if (jzVar instanceof kg) {
                ((kg) jzVar).m().b(str, (String) d16);
            } else {
                jzVar.a(str, (String) d16);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final D a(String str, Class<D> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<jz<D>> it = this.f148956a.iterator();
        D d16 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof kg) {
                    d16 = ((kg) next).m().b(str, cls);
                } else {
                    d16 = next.a(str, cls);
                }
                if (d16 != null && d16.a() > 0) {
                    LogUtil.c(ky.f149101g, "\u4ece[" + next + "]\u7f13\u5b58\u4e2d\u83b7\u53d6\u6570\u636e\u6210\u529f");
                    break;
                }
                if (this.f148957b) {
                    lc.a(ky.f149110p, str, (Object) "back to fill ".concat(String.valueOf(next)), this.f148958c);
                    arrayList.add(next);
                }
            }
        }
        if (d16 != null && d16.a() > 0 && !arrayList.isEmpty()) {
            a(str, d16, arrayList);
        }
        lc.a(ky.f149110p, str, "get data length", Integer.valueOf(d16 == null ? 0 : d16.a()), this.f148958c);
        lc.f(ky.f149110p, str, this.f148958c);
        return d16;
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final boolean a(String str) {
        Iterator<jz<D>> it = this.f148956a.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof kg) {
                    z16 = ((kg) next).m().b(str);
                } else {
                    z16 = next.a(str);
                }
            }
        }
        return z16;
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void a(String str, D d16, jx.a<Boolean> aVar) {
        Iterator<jz<D>> it = this.f148956a.iterator();
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof jx) {
                    ((jx) next).a().a(str, (String) d16, aVar);
                } else if (next instanceof kg) {
                    ((kg) next).m().b(str, (String) d16);
                    if (aVar != null) {
                        aVar.callback(Boolean.TRUE);
                    }
                } else {
                    next.a(str, (String) d16);
                    if (aVar != null) {
                        aVar.callback(Boolean.TRUE);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void a(String str, Class<D> cls, jx.a<D> aVar) {
        Iterator<jz<D>> it = this.f148956a.iterator();
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof jx) {
                    ((jx) next).a().a(str, cls, aVar);
                } else if (next instanceof kg) {
                    kg<D> m3 = ((kg) next).m();
                    if (aVar != null) {
                        aVar.callback(m3.b(str, cls));
                    }
                } else if (aVar != null) {
                    aVar.callback(next.a(str, cls));
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void a(String str, jx.a<Boolean> aVar) {
        Iterator<jz<D>> it = this.f148956a.iterator();
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof jx) {
                    ((jx) next).a().a(str, aVar);
                } else if (next instanceof kg) {
                    kg<D> m3 = ((kg) next).m();
                    if (aVar != null) {
                        aVar.callback(Boolean.valueOf(m3.b(str)));
                    }
                } else if (aVar != null) {
                    aVar.callback(Boolean.valueOf(next.a(str)));
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void a(jx.a<Boolean> aVar) {
        Iterator<jz<D>> it = this.f148956a.iterator();
        while (it.hasNext()) {
            jz<D> next = it.next();
            if (next != null) {
                if (next instanceof jx) {
                    ((jx) next).a().a(aVar);
                } else if (next instanceof kg) {
                    ((kg) next).m().j();
                    if (aVar != null) {
                        aVar.callback(Boolean.TRUE);
                    }
                } else {
                    next.b();
                    if (aVar != null) {
                        aVar.callback(Boolean.TRUE);
                    }
                }
            }
        }
    }
}
