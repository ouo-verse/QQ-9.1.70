package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.f;
import com.google.protobuf.ax;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class bo<MType extends GeneratedMessage, BType extends GeneratedMessage.f, IType extends ax> implements GeneratedMessage.g {

    /* renamed from: a, reason: collision with root package name */
    private GeneratedMessage.g f35727a;

    /* renamed from: b, reason: collision with root package name */
    private List<MType> f35728b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f35729c;

    /* renamed from: d, reason: collision with root package name */
    private List<bt<MType, BType, IType>> f35730d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f35731e;

    /* renamed from: f, reason: collision with root package name */
    private b<MType, BType, IType> f35732f;

    /* renamed from: g, reason: collision with root package name */
    private a<MType, BType, IType> f35733g;

    /* renamed from: h, reason: collision with root package name */
    private c<MType, BType, IType> f35734h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a<MType extends GeneratedMessage, BType extends GeneratedMessage.f, IType extends ax> extends AbstractList<BType> implements List<BType> {

        /* renamed from: d, reason: collision with root package name */
        bo<MType, BType, IType> f35735d;

        a(bo<MType, BType, IType> boVar) {
            this.f35735d = boVar;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BType get(int i3) {
            return this.f35735d.l(i3);
        }

        void d() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f35735d.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<MType extends GeneratedMessage, BType extends GeneratedMessage.f, IType extends ax> extends AbstractList<MType> implements List<MType> {

        /* renamed from: d, reason: collision with root package name */
        bo<MType, BType, IType> f35736d;

        b(bo<MType, BType, IType> boVar) {
            this.f35736d = boVar;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MType get(int i3) {
            return this.f35736d.o(i3);
        }

        void d() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f35736d.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c<MType extends GeneratedMessage, BType extends GeneratedMessage.f, IType extends ax> extends AbstractList<IType> implements List<IType> {

        /* renamed from: d, reason: collision with root package name */
        bo<MType, BType, IType> f35737d;

        c(bo<MType, BType, IType> boVar) {
            this.f35737d = boVar;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IType get(int i3) {
            return this.f35737d.r(i3);
        }

        void d() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f35737d.n();
        }
    }

    public bo(List<MType> list, boolean z16, GeneratedMessage.g gVar, boolean z17) {
        this.f35728b = list;
        this.f35729c = z16;
        this.f35727a = gVar;
        this.f35731e = z17;
    }

    private void j() {
        if (this.f35730d == null) {
            this.f35730d = new ArrayList(this.f35728b.size());
            for (int i3 = 0; i3 < this.f35728b.size(); i3++) {
                this.f35730d.add(null);
            }
        }
    }

    private void k() {
        if (!this.f35729c) {
            this.f35728b = new ArrayList(this.f35728b);
            this.f35729c = true;
        }
    }

    private MType p(int i3, boolean z16) {
        List<bt<MType, BType, IType>> list = this.f35730d;
        if (list == null) {
            return this.f35728b.get(i3);
        }
        bt<MType, BType, IType> btVar = list.get(i3);
        if (btVar == null) {
            return this.f35728b.get(i3);
        }
        if (z16) {
            return btVar.b();
        }
        return btVar.f();
    }

    private void t() {
        b<MType, BType, IType> bVar = this.f35732f;
        if (bVar != null) {
            bVar.d();
        }
        a<MType, BType, IType> aVar = this.f35733g;
        if (aVar != null) {
            aVar.d();
        }
        c<MType, BType, IType> cVar = this.f35734h;
        if (cVar != null) {
            cVar.d();
        }
    }

    private void v() {
        GeneratedMessage.g gVar;
        if (this.f35731e && (gVar = this.f35727a) != null) {
            gVar.a();
            this.f35731e = false;
        }
    }

    @Override // com.google.protobuf.a.b
    public void a() {
        v();
    }

    public bo<MType, BType, IType> b(Iterable<? extends MType> iterable) {
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
        k();
        if (i3 >= 0) {
            List<MType> list = this.f35728b;
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + i3);
            }
        }
        Iterator<? extends MType> it5 = iterable.iterator();
        while (it5.hasNext()) {
            f(it5.next());
        }
        v();
        t();
        return this;
    }

    public BType c(int i3, MType mtype) {
        k();
        j();
        bt<MType, BType, IType> btVar = new bt<>(mtype, this, this.f35731e);
        this.f35728b.add(i3, null);
        this.f35730d.add(i3, btVar);
        v();
        t();
        return btVar.e();
    }

    public BType d(MType mtype) {
        k();
        j();
        bt<MType, BType, IType> btVar = new bt<>(mtype, this, this.f35731e);
        this.f35728b.add(null);
        this.f35730d.add(btVar);
        v();
        t();
        return btVar.e();
    }

    public bo<MType, BType, IType> e(int i3, MType mtype) {
        ad.a(mtype);
        k();
        this.f35728b.add(i3, mtype);
        List<bt<MType, BType, IType>> list = this.f35730d;
        if (list != null) {
            list.add(i3, null);
        }
        v();
        t();
        return this;
    }

    public bo<MType, BType, IType> f(MType mtype) {
        ad.a(mtype);
        k();
        this.f35728b.add(mtype);
        List<bt<MType, BType, IType>> list = this.f35730d;
        if (list != null) {
            list.add(null);
        }
        v();
        t();
        return this;
    }

    public List<MType> g() {
        boolean z16;
        this.f35731e = true;
        boolean z17 = this.f35729c;
        if (!z17 && this.f35730d == null) {
            return this.f35728b;
        }
        if (!z17) {
            int i3 = 0;
            while (true) {
                if (i3 < this.f35728b.size()) {
                    MType mtype = this.f35728b.get(i3);
                    bt<MType, BType, IType> btVar = this.f35730d.get(i3);
                    if (btVar != null && btVar.b() != mtype) {
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
                return this.f35728b;
            }
        }
        k();
        for (int i16 = 0; i16 < this.f35728b.size(); i16++) {
            this.f35728b.set(i16, p(i16, true));
        }
        List<MType> unmodifiableList = Collections.unmodifiableList(this.f35728b);
        this.f35728b = unmodifiableList;
        this.f35729c = false;
        return unmodifiableList;
    }

    public void h() {
        this.f35728b = Collections.emptyList();
        this.f35729c = false;
        List<bt<MType, BType, IType>> list = this.f35730d;
        if (list != null) {
            for (bt<MType, BType, IType> btVar : list) {
                if (btVar != null) {
                    btVar.d();
                }
            }
            this.f35730d = null;
        }
        v();
        t();
    }

    public void i() {
        this.f35727a = null;
    }

    public BType l(int i3) {
        j();
        bt<MType, BType, IType> btVar = this.f35730d.get(i3);
        if (btVar == null) {
            bt<MType, BType, IType> btVar2 = new bt<>(this.f35728b.get(i3), this, this.f35731e);
            this.f35730d.set(i3, btVar2);
            btVar = btVar2;
        }
        return btVar.e();
    }

    public List<BType> m() {
        if (this.f35733g == null) {
            this.f35733g = new a<>(this);
        }
        return this.f35733g;
    }

    public int n() {
        return this.f35728b.size();
    }

    public MType o(int i3) {
        return p(i3, false);
    }

    public List<MType> q() {
        if (this.f35732f == null) {
            this.f35732f = new b<>(this);
        }
        return this.f35732f;
    }

    public IType r(int i3) {
        List<bt<MType, BType, IType>> list = this.f35730d;
        if (list == null) {
            return this.f35728b.get(i3);
        }
        bt<MType, BType, IType> btVar = list.get(i3);
        if (btVar == null) {
            return this.f35728b.get(i3);
        }
        return btVar.g();
    }

    public List<IType> s() {
        if (this.f35734h == null) {
            this.f35734h = new c<>(this);
        }
        return this.f35734h;
    }

    public boolean u() {
        return this.f35728b.isEmpty();
    }

    public void w(int i3) {
        bt<MType, BType, IType> remove;
        k();
        this.f35728b.remove(i3);
        List<bt<MType, BType, IType>> list = this.f35730d;
        if (list != null && (remove = list.remove(i3)) != null) {
            remove.d();
        }
        v();
        t();
    }

    public bo<MType, BType, IType> x(int i3, MType mtype) {
        bt<MType, BType, IType> btVar;
        ad.a(mtype);
        k();
        this.f35728b.set(i3, mtype);
        List<bt<MType, BType, IType>> list = this.f35730d;
        if (list != null && (btVar = list.set(i3, null)) != null) {
            btVar.d();
        }
        v();
        t();
        return this;
    }
}
