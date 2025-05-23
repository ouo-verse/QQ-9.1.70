package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.gf.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gf<T extends a> {

    /* renamed from: c, reason: collision with root package name */
    private static final int f148481c = 50;

    /* renamed from: e, reason: collision with root package name */
    private static final int f148482e = 40;

    /* renamed from: a, reason: collision with root package name */
    private final fv f148483a;

    /* renamed from: b, reason: collision with root package name */
    private final int f148484b;

    /* renamed from: d, reason: collision with root package name */
    private Set<T> f148485d;

    /* renamed from: f, reason: collision with root package name */
    private List<gf<T>> f148486f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        fw a();
    }

    gf(double d16, double d17, double d18, double d19) {
        this(new fv(d16, d17, d18, d19));
    }

    private boolean b(T t16) {
        fw a16 = t16.a();
        if (!this.f148483a.a(a16.f148383a, a16.f148384b)) {
            return false;
        }
        double d16 = a16.f148383a;
        double d17 = a16.f148384b;
        gf<T> gfVar = this;
        while (true) {
            List<gf<T>> list = gfVar.f148486f;
            if (list == null) {
                break;
            }
            fv fvVar = gfVar.f148483a;
            if (d17 < fvVar.f148382f) {
                if (d16 < fvVar.f148381e) {
                    gfVar = list.get(0);
                } else {
                    gfVar = list.get(1);
                }
            } else if (d16 < fvVar.f148381e) {
                gfVar = list.get(2);
            } else {
                gfVar = list.get(3);
            }
        }
        Set<T> set = gfVar.f148485d;
        if (set == null) {
            return false;
        }
        return set.remove(t16);
    }

    public final void a(T t16) {
        fw a16 = t16.a();
        if (this.f148483a.a(a16.f148383a, a16.f148384b)) {
            a(a16.f148383a, a16.f148384b, t16);
        }
    }

    public gf(fv fvVar) {
        this(fvVar, 0);
    }

    gf(double d16, double d17, double d18, double d19, int i3) {
        this(new fv(d16, d17, d18, d19), i3);
    }

    gf(fv fvVar, int i3) {
        this.f148486f = null;
        this.f148483a = fvVar;
        this.f148484b = i3;
    }

    private void a(double d16, double d17, T t16) {
        gf<T> gfVar = this;
        while (true) {
            List<gf<T>> list = gfVar.f148486f;
            if (list == null) {
                break;
            }
            fv fvVar = gfVar.f148483a;
            if (d17 < fvVar.f148382f) {
                if (d16 < fvVar.f148381e) {
                    gfVar = list.get(0);
                } else {
                    gfVar = list.get(1);
                }
            } else if (d16 < fvVar.f148381e) {
                gfVar = list.get(2);
            } else {
                gfVar = list.get(3);
            }
        }
        if (gfVar.f148485d == null) {
            gfVar.f148485d = new HashSet();
        }
        gfVar.f148485d.add(t16);
        if (gfVar.f148485d.size() <= 50 || gfVar.f148484b >= 40) {
            return;
        }
        gfVar.a();
    }

    private boolean b(double d16, double d17, T t16) {
        gf<T> gfVar = this;
        while (true) {
            List<gf<T>> list = gfVar.f148486f;
            if (list == null) {
                break;
            }
            fv fvVar = gfVar.f148483a;
            if (d17 < fvVar.f148382f) {
                if (d16 < fvVar.f148381e) {
                    gfVar = list.get(0);
                } else {
                    gfVar = list.get(1);
                }
            } else if (d16 < fvVar.f148381e) {
                gfVar = list.get(2);
            } else {
                gfVar = list.get(3);
            }
        }
        Set<T> set = gfVar.f148485d;
        if (set == null) {
            return false;
        }
        return set.remove(t16);
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f148486f = arrayList;
        fv fvVar = this.f148483a;
        arrayList.add(new gf(fvVar.f148377a, fvVar.f148381e, fvVar.f148378b, fvVar.f148382f, this.f148484b + 1));
        List<gf<T>> list = this.f148486f;
        fv fvVar2 = this.f148483a;
        list.add(new gf<>(fvVar2.f148381e, fvVar2.f148379c, fvVar2.f148378b, fvVar2.f148382f, this.f148484b + 1));
        List<gf<T>> list2 = this.f148486f;
        fv fvVar3 = this.f148483a;
        list2.add(new gf<>(fvVar3.f148377a, fvVar3.f148381e, fvVar3.f148382f, fvVar3.f148380d, this.f148484b + 1));
        List<gf<T>> list3 = this.f148486f;
        fv fvVar4 = this.f148483a;
        list3.add(new gf<>(fvVar4.f148381e, fvVar4.f148379c, fvVar4.f148382f, fvVar4.f148380d, this.f148484b + 1));
        Set<T> set = this.f148485d;
        this.f148485d = null;
        for (T t16 : set) {
            a(t16.a().f148383a, t16.a().f148384b, t16);
        }
    }

    private void b() {
        this.f148486f = null;
        Set<T> set = this.f148485d;
        if (set != null) {
            set.clear();
        }
    }

    public final Collection<T> a(fv fvVar) {
        ArrayList arrayList = new ArrayList();
        a(fvVar, arrayList);
        return arrayList;
    }

    private void a(fv fvVar, Collection<T> collection) {
        if (this.f148483a.a(fvVar)) {
            List<gf<T>> list = this.f148486f;
            if (list != null) {
                Iterator<gf<T>> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(fvVar, collection);
                }
                return;
            }
            Set<T> set = this.f148485d;
            if (set != null) {
                fv fvVar2 = this.f148483a;
                if (fvVar2.f148377a >= fvVar.f148377a && fvVar2.f148379c <= fvVar.f148379c && fvVar2.f148378b >= fvVar.f148378b && fvVar2.f148380d <= fvVar.f148380d) {
                    collection.addAll(set);
                    return;
                }
                for (T t16 : set) {
                    fw a16 = t16.a();
                    if (fvVar.a(a16.f148383a, a16.f148384b)) {
                        collection.add(t16);
                    }
                }
            }
        }
    }
}
