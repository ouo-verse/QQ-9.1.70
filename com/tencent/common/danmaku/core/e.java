package com.tencent.common.danmaku.core;

import android.graphics.Canvas;
import android.graphics.Point;
import com.tencent.common.danmaku.inject.m;
import com.tencent.common.danmaku.tool.f;
import com.tencent.common.danmaku.tool.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    protected int f99655j;

    /* renamed from: k, reason: collision with root package name */
    private int f99656k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f99657l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.common.danmaku.data.a[] f99658m;

    /* renamed from: n, reason: collision with root package name */
    protected List<List<com.tencent.common.danmaku.data.a>> f99659n;

    /* renamed from: o, reason: collision with root package name */
    private int f99660o;

    /* renamed from: p, reason: collision with root package name */
    private int f99661p;

    /* renamed from: q, reason: collision with root package name */
    private int f99662q;

    public e(com.tencent.common.danmaku.inject.b bVar, b bVar2, Comparator<com.tencent.common.danmaku.data.a> comparator, f fVar, com.tencent.common.danmaku.tool.c cVar) {
        super(bVar, bVar2, comparator, fVar, cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, bVar2, comparator, fVar, cVar);
        } else {
            this.f99660o = 1;
        }
    }

    private int q(com.tencent.common.danmaku.data.a aVar) {
        if (aVar == null || this.f99657l == null || this.f99659n == null) {
            return -1;
        }
        int i3 = -1;
        for (int i16 = 0; i16 < this.f99657l.length; i16++) {
            if (aVar.I() == this.f99657l[i16]) {
                i3 = i16;
            }
        }
        if (this.f99659n.size() <= i3) {
            return -1;
        }
        return i3;
    }

    private boolean s(com.tencent.common.danmaku.data.a aVar) {
        Iterator<List<com.tencent.common.danmaku.data.a>> it = this.f99659n.iterator();
        while (it.hasNext()) {
            if (it.next().contains(aVar)) {
                com.tencent.common.danmaku.util.e.b("Danmaku_R2LWindow", aVar, " is repeat");
                return true;
            }
        }
        return false;
    }

    private void t() {
        int z16;
        int i3;
        boolean z17;
        int k3 = com.tencent.common.danmaku.inject.b.p().k();
        Iterator<com.tencent.common.danmaku.data.a> it = this.f99635b.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            com.tencent.common.danmaku.data.a next = it.next();
            it.remove();
            if (!next.Q(this.f99642i.a()) && !next.W(this.f99641h.a()) && !s(next)) {
                if (!next.S()) {
                    DanmakuMeasureManager.c(this.f99639f, next);
                }
                int r16 = next.r(this.f99656k);
                if (r16 >= 0) {
                    z16 = r16;
                } else {
                    z16 = next.z(this.f99656k);
                }
                if (r16 >= 0) {
                    i3 = z16 + 1;
                } else {
                    i3 = this.f99656k + z16;
                }
                int i17 = Integer.MAX_VALUE;
                while (z16 < i3) {
                    int i18 = z16;
                    while (true) {
                        int i19 = this.f99656k;
                        if (i18 < i19) {
                            break;
                        } else {
                            i18 -= i19;
                        }
                    }
                    int p16 = p(i18, next);
                    com.tencent.common.danmaku.data.a[] aVarArr = this.f99658m;
                    com.tencent.common.danmaku.data.a aVar = aVarArr[p16];
                    if (aVar == null) {
                        aVarArr[p16] = next;
                        this.f99659n.get(p16).add(next);
                        this.f99634a++;
                        u(next, this.f99657l[p16], k3);
                    } else {
                        if (!aVar.U()) {
                            int i26 = i16;
                            int e16 = com.tencent.common.danmaku.util.c.e(this.f99658m[p16], next, this.f99642i.a());
                            if (e16 < i17) {
                                i17 = e16;
                                i16 = p16;
                            } else {
                                i16 = i26;
                            }
                            if (i17 < 0) {
                                this.f99658m[p16] = next;
                                this.f99659n.get(p16).add(next);
                                this.f99634a++;
                                u(next, this.f99657l[p16], k3);
                            }
                        }
                        z16++;
                    }
                    z17 = true;
                    break;
                }
                z17 = false;
                if (!z17 && next.d0(i17)) {
                    this.f99658m[i16] = next;
                    this.f99659n.get(i16).add(next);
                    this.f99634a++;
                    u(next, this.f99657l[i16], k3);
                    z17 = true;
                }
                if (!z17) {
                    this.f99636c.add(next);
                    if (com.tencent.common.danmaku.util.e.f99819b >= 4) {
                        com.tencent.common.danmaku.util.e.b("Danmaku_R2LWindow", "layoutDanmakuLines faile, danmaku=", next);
                    }
                } else if (com.tencent.common.danmaku.util.e.f99819b >= 4) {
                    com.tencent.common.danmaku.util.e.b("Danmaku_R2LWindow", "layoutDanmakuLines success, line=", Integer.valueOf(i16), ", danmaku=", next);
                }
            } else {
                if (com.tencent.common.danmaku.util.e.f99819b >= 4) {
                    com.tencent.common.danmaku.util.e.b("Danmaku_R2LWindow", "layoutDanmakuLines danmaku timeOut, just remove, danmku=", next);
                }
                this.f99636c.add(next);
            }
        }
    }

    private void u(com.tencent.common.danmaku.data.a aVar, int i3, int i16) {
        if (aVar.O()) {
            this.f99640g.c(aVar, this.f99639f);
        }
        aVar.Z(i16, i3, this.f99641h.a(), this.f99642i.a());
    }

    private void v(List<List<com.tencent.common.danmaku.data.a>> list, int[] iArr) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<com.tencent.common.danmaku.data.a> it = list.get(i3).iterator();
            while (it.hasNext()) {
                com.tencent.common.danmaku.data.d dVar = (com.tencent.common.danmaku.data.d) it.next();
                dVar.c();
                long a16 = this.f99642i.a();
                int t16 = (int) dVar.t();
                g(dVar);
                dVar.p0(a16 - ((int) ((dVar.F() - t16) / (-dVar.G()))));
                dVar.z0(iArr[i3]);
                dVar.y0(t16);
            }
        }
    }

    private void w(m mVar) {
        com.tencent.common.danmaku.util.e.b("Danmaku_R2LWindow", "relayoutDanmakuLines statr , mLineTops = ", this.f99657l, ",mRowCount:", Integer.valueOf(this.f99656k));
        if (this.f99657l == null || this.f99656k != mVar.i()) {
            int i3 = mVar.i();
            this.f99656k = i3;
            this.f99657l = new int[i3];
            com.tencent.common.danmaku.data.a[] aVarArr = new com.tencent.common.danmaku.data.a[i3];
            com.tencent.common.danmaku.data.a[] aVarArr2 = this.f99658m;
            if (aVarArr2 != null) {
                System.arraycopy(aVarArr2, 0, aVarArr, 0, Math.min(i3, aVarArr2.length));
            }
            this.f99658m = aVarArr;
            int c16 = com.tencent.common.danmaku.util.c.c(this.f99656k / 3.0f);
            this.f99660o = c16;
            this.f99661p = c16;
            this.f99662q = c16 * 2;
            List<List<com.tencent.common.danmaku.data.a>> list = this.f99659n;
            if (list != null) {
                int size = list.size();
                if (size < this.f99656k) {
                    while (size < this.f99656k) {
                        this.f99659n.add(new LinkedList());
                        size++;
                    }
                } else {
                    for (int i16 = size - 1; i16 >= this.f99656k; i16--) {
                        this.f99659n.remove(i16);
                    }
                }
            } else {
                this.f99659n = new ArrayList(this.f99656k);
                for (int i17 = 0; i17 < this.f99656k; i17++) {
                    this.f99659n.add(new LinkedList());
                }
            }
        }
        int j3 = this.f99639f.j();
        for (int i18 = 0; i18 < this.f99656k; i18++) {
            int l3 = this.f99639f.l(i18, mVar);
            if (i18 > 0) {
                int[] iArr = this.f99657l;
                int i19 = iArr[i18 - 1];
                if (l3 > 0) {
                    iArr[i18] = i19 + l3;
                } else {
                    iArr[i18] = i19 + j3;
                }
            } else {
                this.f99657l[0] = this.f99655j;
            }
        }
        v(this.f99659n, this.f99657l);
    }

    private void x() {
        int size = this.f99659n.size();
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<com.tencent.common.danmaku.data.a> it = this.f99659n.get(i3).iterator();
            while (it.hasNext()) {
                com.tencent.common.danmaku.data.a next = it.next();
                if (next.Q(this.f99642i.a()) || !next.V()) {
                    com.tencent.common.danmaku.data.a[] aVarArr = this.f99658m;
                    if (next == aVarArr[i3]) {
                        aVarArr[i3] = null;
                        com.tencent.common.danmaku.util.e.b("Danmaku_R2LWindow", next, " trimDanmakuLines rowIndex:", Integer.valueOf(i3), "\uff0cisShown\uff1a", Boolean.valueOf(next.V()));
                    }
                    it.remove();
                    this.f99634a--;
                    this.f99636c.add(next);
                }
            }
        }
    }

    @Override // com.tencent.common.danmaku.core.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.f99656k; i3++) {
            this.f99658m[i3] = null;
        }
        int size = this.f99659n.size();
        for (int i16 = 0; i16 < size; i16++) {
            Iterator<com.tencent.common.danmaku.data.a> it = this.f99659n.get(i16).iterator();
            while (it.hasNext()) {
                com.tencent.common.danmaku.data.a next = it.next();
                it.remove();
                this.f99634a--;
                this.f99636c.add(next);
            }
        }
    }

    @Override // com.tencent.common.danmaku.core.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.a("layoutDanmakuLines");
        t();
        com.tencent.common.danmaku.util.e.d();
        com.tencent.common.danmaku.util.e.a("trimDanmakuLines");
        x();
        com.tencent.common.danmaku.util.e.d();
    }

    @Override // com.tencent.common.danmaku.core.a
    public com.tencent.common.danmaku.data.a k(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.common.danmaku.data.a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) hVar);
        }
        int size = this.f99659n.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (com.tencent.common.danmaku.data.a aVar : this.f99659n.get(i3)) {
                if (aVar.M()) {
                    Point point = hVar.f99801b;
                    if (aVar.K(point.x, point.y, hVar.f99802c, hVar.f99800a)) {
                        if (com.tencent.common.danmaku.util.e.f99819b >= 5) {
                            com.tencent.common.danmaku.util.e.g("Danmaku_R2LWindow", "onClick:", aVar, "[left:", Float.valueOf(aVar.t()), ",top:", Float.valueOf(aVar.I()), "]");
                        }
                        return aVar;
                    }
                }
            }
        }
        com.tencent.common.danmaku.util.e.g("Danmaku_R2LWindow", "onClick:null");
        return null;
    }

    @Override // com.tencent.common.danmaku.core.a
    public void l(Canvas canvas, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, Long.valueOf(j3));
            return;
        }
        int size = this.f99659n.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (com.tencent.common.danmaku.data.a aVar : this.f99659n.get(i3)) {
                aVar.c0(this.f99642i.b(), this.f99642i.a());
                if (!aVar.P(this.f99642i.a())) {
                    e(canvas, aVar);
                }
            }
        }
    }

    @Override // com.tencent.common.danmaku.core.a
    public void m(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        int q16 = q(aVar);
        if (q16 < 0) {
            return;
        }
        boolean z16 = false;
        for (com.tencent.common.danmaku.data.a aVar2 : this.f99659n.get(q16)) {
            if (aVar2 == aVar) {
                z16 = true;
            }
            if (z16) {
                aVar2.b0();
            }
        }
    }

    @Override // com.tencent.common.danmaku.core.a
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        m p16 = com.tencent.common.danmaku.inject.b.p();
        this.f99655j = p16.m();
        w(p16);
        v(this.f99659n, this.f99657l);
    }

    @Override // com.tencent.common.danmaku.core.a
    public void o(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        int q16 = q(aVar);
        if (q16 < 0) {
            return;
        }
        Iterator<com.tencent.common.danmaku.data.a> it = this.f99659n.get(q16).iterator();
        while (it.hasNext()) {
            it.next().f0();
        }
    }

    public int p(int i3, com.tencent.common.danmaku.data.a aVar) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) aVar)).intValue();
        }
        this.f99660o = com.tencent.common.danmaku.util.c.c(this.f99656k / 3.0f);
        int A = aVar.A();
        if (A != 2) {
            if (A != 3) {
                if (A == 4) {
                    int i17 = this.f99661p;
                    if (i3 < i17) {
                        i16 = this.f99660o;
                    } else {
                        if (i17 > i3 || i3 >= this.f99662q) {
                            return i3 - this.f99660o;
                        }
                        return i3;
                    }
                } else {
                    return i3;
                }
            } else {
                int i18 = this.f99661p;
                if (i3 < i18) {
                    i16 = this.f99660o * 2;
                } else if (i18 <= i3 && i3 < this.f99662q) {
                    i16 = this.f99660o;
                } else {
                    return i3;
                }
            }
            return i3 + i16;
        }
        return i3 % this.f99660o;
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        List<List<com.tencent.common.danmaku.data.a>> list = this.f99659n;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                List<com.tencent.common.danmaku.data.a> list2 = this.f99659n.get(i3);
                if (list2 != null && list2.size() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
