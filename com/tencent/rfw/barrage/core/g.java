package com.tencent.rfw.barrage.core;

import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tz3.i;
import tz3.k;
import vz3.h;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g extends a {

    /* renamed from: j, reason: collision with root package name */
    protected int f365051j;

    /* renamed from: k, reason: collision with root package name */
    private int f365052k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f365053l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.rfw.barrage.data.a[] f365054m;

    /* renamed from: n, reason: collision with root package name */
    protected List<List<com.tencent.rfw.barrage.data.a>> f365055n;

    public g(i iVar, f fVar, Comparator<com.tencent.rfw.barrage.data.a> comparator, vz3.c cVar, vz3.a aVar) {
        super(iVar, fVar, comparator, cVar, aVar);
    }

    private boolean n(com.tencent.rfw.barrage.data.a aVar) {
        boolean z16;
        if (aVar == null) {
            return true;
        }
        if (!aVar.S(this.f365027i.a()) && !aVar.Y(this.f365026h.a()) && !o(aVar)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 || aVar.N()) {
            return false;
        }
        this.f365021c.add(aVar);
        return true;
    }

    private boolean o(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        Iterator<List<com.tencent.rfw.barrage.data.a>> it = this.f365055n.iterator();
        while (it.hasNext()) {
            if (it.next().contains(aVar)) {
                wz3.b.b("RFWR2LWindow", aVar, " is repeat");
                return true;
            }
        }
        return false;
    }

    private void p() {
        int z16;
        int i3;
        boolean z17;
        int k3 = i.l().k();
        Iterator<com.tencent.rfw.barrage.data.a> it = this.f365020b.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            com.tencent.rfw.barrage.data.a next = it.next();
            it.remove();
            if (!n(next)) {
                if (!next.U()) {
                    e.c(this.f365024f, next);
                }
                int r16 = next.r(this.f365052k);
                if (r16 >= 0) {
                    z16 = r16;
                } else {
                    z16 = next.z(this.f365052k);
                }
                if (r16 >= 0) {
                    i3 = z16 + 1;
                } else {
                    i3 = this.f365052k + z16;
                }
                int i17 = Integer.MAX_VALUE;
                while (z16 < i3) {
                    int i18 = z16;
                    while (true) {
                        int i19 = this.f365052k;
                        if (i18 < i19) {
                            break;
                        } else {
                            i18 -= i19;
                        }
                    }
                    com.tencent.rfw.barrage.data.a[] aVarArr = this.f365054m;
                    com.tencent.rfw.barrage.data.a aVar = aVarArr[i18];
                    if (aVar == null) {
                        aVarArr[i18] = next;
                        this.f365055n.get(i18).add(next);
                        this.f365019a++;
                        q(next, this.f365053l[i18], k3);
                    } else {
                        if (!aVar.W() || aVar.N()) {
                            int i26 = i16;
                            int d16 = wz3.d.d(aVar, next, this.f365027i.a());
                            if (d16 < i17) {
                                i17 = d16;
                                i16 = i18;
                            } else {
                                i16 = i26;
                            }
                            if (i17 < 0) {
                                this.f365054m[i18] = next;
                                this.f365055n.get(i18).add(next);
                                this.f365019a++;
                                q(next, this.f365053l[i18], k3);
                                wz3.b.b("RFWR2LWindow", next, " layout success:", Integer.valueOf(i18), ",top:", this.f365053l[i18] + ", hitTime = " + i17);
                            }
                        }
                        z16++;
                    }
                    z17 = true;
                }
                z17 = false;
                if (!z17 && next.f0(i17)) {
                    this.f365054m[i16] = next;
                    this.f365055n.get(i16).add(next);
                    this.f365019a++;
                    q(next, this.f365053l[i16], k3);
                    wz3.b.b("RFWR2LWindow", next, " layout success:", Integer.valueOf(i16), ",top:", this.f365053l[i16] + ", danmakuRepeatTime = " + next.C());
                    z17 = true;
                }
                if (!z17) {
                    this.f365021c.add(next);
                    wz3.b.b("RFWR2LWindow", next, " can not in window");
                }
                if (next.V() && z17) {
                    wz3.b.a("RFWR2LWindow", "must show danmaku layout success :" + next);
                }
            }
        }
    }

    private void q(com.tencent.rfw.barrage.data.a aVar, int i3, int i16) {
        vz3.c cVar;
        if (aVar == null || (cVar = this.f365026h) == null || this.f365027i == null) {
            return;
        }
        aVar.c0(i16, i3, cVar.a(), this.f365027i.a());
    }

    private void r(List<List<com.tencent.rfw.barrage.data.a>> list, int[] iArr) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<com.tencent.rfw.barrage.data.a> it = list.get(i3).iterator();
            while (it.hasNext()) {
                com.tencent.rfw.barrage.data.d dVar = (com.tencent.rfw.barrage.data.d) it.next();
                dVar.c();
                long a16 = this.f365027i.a();
                int t16 = (int) dVar.t();
                g(dVar);
                dVar.u0(a16 - ((int) ((dVar.F() - t16) / (-dVar.G()))));
                dVar.F0(iArr[i3]);
                dVar.D0(t16);
            }
        }
    }

    private void s(k kVar) {
        String str;
        if (this.f365053l == null || this.f365052k != kVar.i()) {
            int i3 = kVar.i();
            this.f365052k = i3;
            this.f365053l = new int[i3];
            com.tencent.rfw.barrage.data.a[] aVarArr = new com.tencent.rfw.barrage.data.a[i3];
            com.tencent.rfw.barrage.data.a[] aVarArr2 = this.f365054m;
            if (aVarArr2 != null) {
                System.arraycopy(aVarArr2, 0, aVarArr, 0, Math.min(i3, aVarArr2.length));
            }
            this.f365054m = aVarArr;
            List<List<com.tencent.rfw.barrage.data.a>> list = this.f365055n;
            if (list != null) {
                int size = list.size();
                if (size < this.f365052k) {
                    while (size < this.f365052k) {
                        this.f365055n.add(new LinkedList());
                        size++;
                    }
                } else {
                    for (int i16 = size - 1; i16 >= this.f365052k; i16--) {
                        this.f365055n.remove(i16);
                    }
                }
            } else {
                this.f365055n = new ArrayList(this.f365052k);
                for (int i17 = 0; i17 < this.f365052k; i17++) {
                    this.f365055n.add(new LinkedList());
                }
            }
        }
        int h16 = this.f365024f.h();
        StringBuilder sb5 = new StringBuilder("[");
        for (int i18 = 0; i18 < this.f365052k; i18++) {
            int[] iArr = this.f365053l;
            int i19 = (i18 * h16) + this.f365051j;
            iArr[i18] = i19;
            sb5.append(i19);
            if (i18 != this.f365052k - 1) {
                str = ", ";
            } else {
                str = "";
            }
            sb5.append(str);
        }
        sb5.append("]");
        wz3.b.b("RFWR2LWindow", "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.f365052k), Integer.valueOf(this.f365051j), Integer.valueOf(h16), sb5);
        r(this.f365055n, this.f365053l);
    }

    private void t() {
        int size = this.f365055n.size();
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<com.tencent.rfw.barrage.data.a> it = this.f365055n.get(i3).iterator();
            while (it.hasNext()) {
                com.tencent.rfw.barrage.data.a next = it.next();
                if (!next.N() && (next.S(this.f365027i.a()) || !next.X())) {
                    com.tencent.rfw.barrage.data.a[] aVarArr = this.f365054m;
                    if (next == aVarArr[i3]) {
                        aVarArr[i3] = null;
                    }
                    it.remove();
                    this.f365019a--;
                    this.f365021c.add(next);
                }
            }
        }
    }

    @Override // com.tencent.rfw.barrage.core.a
    public void c() {
        for (int i3 = 0; i3 < this.f365052k; i3++) {
            this.f365054m[i3] = null;
        }
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f365055n;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            Iterator<com.tencent.rfw.barrage.data.a> it = this.f365055n.get(i16).iterator();
            while (it.hasNext()) {
                com.tencent.rfw.barrage.data.a next = it.next();
                it.remove();
                this.f365019a--;
                this.f365021c.add(next);
            }
        }
    }

    @Override // com.tencent.rfw.barrage.core.a
    public boolean i() {
        return false;
    }

    @Override // com.tencent.rfw.barrage.core.a
    public void j() {
        p();
        t();
    }

    @Override // com.tencent.rfw.barrage.core.a
    public com.tencent.rfw.barrage.data.a k(h hVar) {
        List<List<com.tencent.rfw.barrage.data.a>> list = this.f365055n;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (com.tencent.rfw.barrage.data.a aVar : this.f365055n.get(i3)) {
                if (aVar.M()) {
                    Point point = hVar.f443802b;
                    if (aVar.K(point.x, point.y, hVar.f443803c, hVar.f443801a)) {
                        return aVar;
                    }
                }
            }
        }
        wz3.b.h("RFWR2LWindow", "onClick:null");
        return null;
    }

    @Override // com.tencent.rfw.barrage.core.a
    public void l(Canvas canvas, long j3) {
        int size = this.f365055n.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (com.tencent.rfw.barrage.data.a aVar : this.f365055n.get(i3)) {
                aVar.e0(this.f365027i.b(), this.f365027i.a());
                if (!aVar.R(this.f365027i.a())) {
                    e(canvas, aVar);
                }
            }
        }
    }

    @Override // com.tencent.rfw.barrage.core.a
    public void m() {
        k l3 = i.l();
        this.f365051j = l3.m();
        s(l3);
        r(this.f365055n, this.f365053l);
    }
}
