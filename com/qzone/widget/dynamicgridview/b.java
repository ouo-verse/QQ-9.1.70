package com.qzone.widget.dynamicgridview;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class b<T> extends com.qzone.widget.dynamicgridview.a implements e<T> {
    private c<T> C;
    private int F;
    private int G;

    /* renamed from: f, reason: collision with root package name */
    private Context f60837f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<a<T>> f60838h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<T> f60839i = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    protected boolean f60840m = true;
    protected boolean D = false;
    private boolean E = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public T f60841a;

        public a(T t16) {
            this.f60841a = t16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        this.f60837f = context;
    }

    private void p(int i3, int i16) {
        a<T> aVar = this.f60838h.get(i3);
        if (i3 < i16) {
            for (int i17 = i3 + 1; i17 <= i16 && i3 <= i16; i17++) {
                if (c(i17)) {
                    ArrayList<a<T>> arrayList = this.f60838h;
                    arrayList.set(i3, arrayList.get(i17));
                    c<T> cVar = this.C;
                    if (cVar != null) {
                        cVar.doSet(i3, this.f60838h.get(i17).f60841a);
                    }
                    do {
                        i3++;
                    } while (!c(i3));
                }
            }
        } else if (i3 > i16) {
            for (int i18 = i3 - 1; i18 >= i16 && i3 >= i16; i18--) {
                if (c(i18) || (this.D && c(i18 + 1))) {
                    ArrayList<a<T>> arrayList2 = this.f60838h;
                    arrayList2.set(i3, arrayList2.get(i18));
                    c<T> cVar2 = this.C;
                    if (cVar2 != null) {
                        cVar2.doSet(i3, this.f60838h.get(i18).f60841a);
                    }
                    do {
                        i3--;
                        if (!c(i3)) {
                        }
                    } while (i3 > 0);
                }
            }
        }
        this.f60838h.set(i16, aVar);
        c<T> cVar3 = this.C;
        if (cVar3 != null) {
            cVar3.doSet(i3, aVar.f60841a);
        }
    }

    private List<a<T>> r(Collection<? extends T> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(it.next()));
        }
        return arrayList;
    }

    @Override // com.qzone.widget.dynamicgridview.d
    public void a(int i3, int i16) {
        if (i16 < getCount()) {
            p(i3, i16);
            this.F = Math.min(i3, i16);
            this.G = Math.max(i3, i16);
            this.E = true;
            notifyDataSetChanged();
        }
    }

    @Override // com.qzone.widget.dynamicgridview.e
    public void add(int i3, T t16) {
        if (i3 < 0 || i3 > this.f60838h.size()) {
            return;
        }
        a<T> aVar = new a<>(t16);
        e(aVar);
        this.f60838h.add(i3, aVar);
        this.F = i3;
        this.G = getCount() - 1;
        this.E = true;
    }

    @Override // com.qzone.widget.dynamicgridview.e
    public void addAll(int i3, Collection<? extends T> collection) {
        if (i3 < 0 || i3 >= this.f60838h.size()) {
            return;
        }
        List<a<T>> r16 = r(collection);
        d(r16);
        this.f60838h.addAll(i3, r16);
        this.F = i3;
        this.G = getCount() - 1;
        this.E = true;
    }

    @Override // com.qzone.widget.dynamicgridview.e
    public void b(c<T> cVar) {
        this.C = cVar;
    }

    @Override // com.qzone.widget.dynamicgridview.d
    public boolean c(int i3) {
        return true;
    }

    @Override // com.qzone.widget.dynamicgridview.e
    public void clear() {
        f();
        this.f60838h.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f60838h.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i3) {
        a<T> g16 = g(i3);
        if (g16 == null) {
            return null;
        }
        return g16.f60841a;
    }

    public boolean j(int i3) {
        int i16;
        if (!this.D && i3 != 0 && this.E) {
            if (i3 == getCount() - 1) {
                this.E = false;
                this.F = -1;
                this.G = -1;
            }
            int i17 = this.F;
            if (i17 == -1 || (i16 = this.G) == -1) {
                this.E = false;
            } else if (i3 < i17 || i3 > i16) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context k() {
        return this.f60837f;
    }

    @Override // com.qzone.widget.dynamicgridview.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public a<T> g(int i3) {
        boolean z16 = this.D;
        if (z16 && i3 > 0) {
            i3--;
        } else if (z16 && i3 == 0) {
            return null;
        }
        if (i3 < 0 || i3 >= this.f60838h.size()) {
            return null;
        }
        return this.f60838h.get(i3);
    }

    public boolean m() {
        return this.D;
    }

    public List<T> n() {
        this.f60839i.clear();
        ArrayList<T> arrayList = this.f60839i;
        for (int i3 = 0; i3 < this.f60838h.size(); i3++) {
            arrayList.add(this.f60838h.get(i3).f60841a);
        }
        return arrayList;
    }

    public void q(List<T> list) {
        f();
        this.f60838h.clear();
        addAll(list);
    }

    @Override // com.qzone.widget.dynamicgridview.e
    public void remove(int i3) {
        if (i3 < 0 || i3 >= this.f60838h.size()) {
            return;
        }
        i(this.f60838h.get(i3));
        this.f60838h.remove(i3);
        this.F = i3;
        this.G = getCount() - 1;
        this.E = true;
    }

    public void o(int i3) {
        if (i3 < 0 || i3 >= this.f60838h.size()) {
            return;
        }
        i(this.f60838h.get(i3));
        this.f60838h.remove(i3);
        c<T> cVar = this.C;
        if (cVar != null) {
            cVar.doRemove(i3);
        }
        this.F = i3;
        this.G = getCount() - 1;
        this.E = true;
        notifyDataSetChanged();
    }

    @Override // com.qzone.widget.dynamicgridview.e
    public void set(int i3, T t16) {
        if (i3 < 0 || i3 >= this.f60838h.size()) {
            return;
        }
        this.f60838h.get(i3).f60841a = t16;
        this.F = i3;
        this.G = getCount() - 1;
        this.E = true;
    }

    @Override // com.qzone.widget.dynamicgridview.e
    public void remove(Object obj) {
        Iterator<a<T>> it = this.f60838h.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            a<T> next = it.next();
            if (next.f60841a == obj) {
                i(next);
                it.remove();
                this.F = i3;
                this.G = getCount() - 1;
                this.E = true;
                return;
            }
            i3++;
        }
    }

    @Override // com.qzone.widget.dynamicgridview.e
    public void add(T t16) {
        a<T> aVar = new a<>(t16);
        e(aVar);
        this.f60838h.add(aVar);
        this.F = 0;
        this.G = getCount() - 1;
        this.E = true;
    }

    @Override // com.qzone.widget.dynamicgridview.e
    public void addAll(Collection<? extends T> collection) {
        List<a<T>> r16 = r(collection);
        d(r16);
        this.f60838h.addAll(r16);
        this.F = 0;
        this.G = getCount() - 1;
        this.E = true;
    }
}
