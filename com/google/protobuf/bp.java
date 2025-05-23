package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.a.AbstractC0252a;
import com.google.protobuf.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class bp<MType extends a, BType extends a.AbstractC0252a, IType extends ax> implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private a.b f35738a;

    /* renamed from: b, reason: collision with root package name */
    private List<MType> f35739b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f35740c;

    /* renamed from: d, reason: collision with root package name */
    private List<bu<MType, BType, IType>> f35741d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f35742e;

    public bp(List<MType> list, boolean z16, a.b bVar, boolean z17) {
        this.f35739b = list;
        this.f35740c = z16;
        this.f35738a = bVar;
        this.f35742e = z17;
    }

    private void g() {
        if (!this.f35740c) {
            this.f35739b = new ArrayList(this.f35739b);
            this.f35740c = true;
        }
    }

    private MType h(int i3, boolean z16) {
        List<bu<MType, BType, IType>> list = this.f35741d;
        if (list == null) {
            return this.f35739b.get(i3);
        }
        bu<MType, BType, IType> buVar = list.get(i3);
        if (buVar == null) {
            return this.f35739b.get(i3);
        }
        if (z16) {
            return buVar.b();
        }
        return buVar.f();
    }

    private void k() {
        a.b bVar;
        if (this.f35742e && (bVar = this.f35738a) != null) {
            bVar.a();
            this.f35742e = false;
        }
    }

    @Override // com.google.protobuf.a.b
    public void a() {
        k();
    }

    public bp<MType, BType, IType> b(Iterable<? extends MType> iterable) {
        int i3;
        Iterator<? extends MType> it = iterable.iterator();
        while (it.hasNext()) {
            ad.a(it.next());
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() == 0) {
                return this;
            }
            i3 = collection.size();
        } else {
            i3 = -1;
        }
        g();
        if (i3 >= 0) {
            List<MType> list = this.f35739b;
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + i3);
            }
        }
        Iterator<? extends MType> it5 = iterable.iterator();
        while (it5.hasNext()) {
            c(it5.next());
        }
        k();
        i();
        return this;
    }

    public bp<MType, BType, IType> c(MType mtype) {
        ad.a(mtype);
        g();
        this.f35739b.add(mtype);
        List<bu<MType, BType, IType>> list = this.f35741d;
        if (list != null) {
            list.add(null);
        }
        k();
        i();
        return this;
    }

    public List<MType> d() {
        boolean z16;
        this.f35742e = true;
        boolean z17 = this.f35740c;
        if (!z17 && this.f35741d == null) {
            return this.f35739b;
        }
        if (!z17) {
            int i3 = 0;
            while (true) {
                if (i3 < this.f35739b.size()) {
                    MType mtype = this.f35739b.get(i3);
                    bu<MType, BType, IType> buVar = this.f35741d.get(i3);
                    if (buVar != null && buVar.b() != mtype) {
                        z16 = false;
                        break;
                    }
                    i3++;
                } else {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                return this.f35739b;
            }
        }
        g();
        for (int i16 = 0; i16 < this.f35739b.size(); i16++) {
            this.f35739b.set(i16, h(i16, true));
        }
        List<MType> unmodifiableList = Collections.unmodifiableList(this.f35739b);
        this.f35739b = unmodifiableList;
        this.f35740c = false;
        return unmodifiableList;
    }

    public void e() {
        this.f35739b = Collections.emptyList();
        this.f35740c = false;
        List<bu<MType, BType, IType>> list = this.f35741d;
        if (list != null) {
            for (bu<MType, BType, IType> buVar : list) {
                if (buVar != null) {
                    buVar.d();
                }
            }
            this.f35741d = null;
        }
        k();
        i();
    }

    public void f() {
        this.f35738a = null;
    }

    public boolean j() {
        return this.f35739b.isEmpty();
    }

    private void i() {
    }
}
