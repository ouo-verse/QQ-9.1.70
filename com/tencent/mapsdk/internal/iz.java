package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.ix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class iz extends ix {

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<ix> f148827c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<ix, e> f148828d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<e> f148829e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<e> f148830f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private boolean f148831g = true;

    /* renamed from: h, reason: collision with root package name */
    private a f148832h = null;

    /* renamed from: b, reason: collision with root package name */
    boolean f148826b = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f148833i = false;

    /* renamed from: j, reason: collision with root package name */
    private long f148834j = 0;

    /* renamed from: k, reason: collision with root package name */
    private jm f148835k = null;

    /* renamed from: l, reason: collision with root package name */
    private long f148836l = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements ix.a {

        /* renamed from: b, reason: collision with root package name */
        private iz f148841b;

        a(iz izVar) {
            this.f148841b = izVar;
        }

        @Override // com.tencent.mapsdk.internal.ix.a
        public final void a(ix ixVar) {
        }

        @Override // com.tencent.mapsdk.internal.ix.a
        public final void b() {
        }

        @Override // com.tencent.mapsdk.internal.ix.a
        public final void a() {
            ArrayList<ix.a> arrayList;
            iz izVar = iz.this;
            if (izVar.f148826b || izVar.f148827c.size() != 0 || (arrayList = iz.this.f148825a) == null) {
                return;
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                iz.this.f148825a.get(i3).a();
            }
        }

        @Override // com.tencent.mapsdk.internal.ix.a
        public final void b(ix ixVar) {
            ixVar.b(this);
            iz.this.f148827c.remove(ixVar);
            boolean z16 = true;
            ((e) this.f148841b.f148828d.get(ixVar)).f148856f = true;
            if (iz.this.f148826b) {
                return;
            }
            ArrayList arrayList = this.f148841b.f148830f;
            int size = arrayList.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (!((e) arrayList.get(i3)).f148856f) {
                    z16 = false;
                    break;
                }
                i3++;
            }
            if (z16) {
                ArrayList<ix.a> arrayList2 = iz.this.f148825a;
                if (arrayList2 != null) {
                    ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                    int size2 = arrayList3.size();
                    for (int i16 = 0; i16 < size2; i16++) {
                        ((ix.a) arrayList3.get(i16)).b(this.f148841b);
                    }
                }
                iz.d(this.f148841b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        static final int f148844a = 0;

        /* renamed from: b, reason: collision with root package name */
        static final int f148845b = 1;

        /* renamed from: c, reason: collision with root package name */
        public e f148846c;

        /* renamed from: d, reason: collision with root package name */
        public int f148847d;

        public c(e eVar, int i3) {
            this.f148846c = eVar;
            this.f148847d = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class d implements ix.a {

        /* renamed from: a, reason: collision with root package name */
        private iz f148848a;

        /* renamed from: b, reason: collision with root package name */
        private e f148849b;

        /* renamed from: c, reason: collision with root package name */
        private int f148850c;

        public d(iz izVar, e eVar, int i3) {
            this.f148848a = izVar;
            this.f148849b = eVar;
            this.f148850c = i3;
        }

        private void c(ix ixVar) {
            c cVar;
            if (this.f148848a.f148826b) {
                return;
            }
            int size = this.f148849b.f148853c.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    cVar = this.f148849b.f148853c.get(i3);
                    if (cVar.f148847d == this.f148850c && cVar.f148846c.f148851a == ixVar) {
                        ixVar.b(this);
                        break;
                    }
                    i3++;
                } else {
                    cVar = null;
                    break;
                }
            }
            this.f148849b.f148853c.remove(cVar);
            if (this.f148849b.f148853c.size() == 0) {
                this.f148849b.f148851a.a();
                this.f148848a.f148827c.add(this.f148849b.f148851a);
            }
        }

        @Override // com.tencent.mapsdk.internal.ix.a
        public final void a() {
        }

        @Override // com.tencent.mapsdk.internal.ix.a
        public final void b() {
        }

        @Override // com.tencent.mapsdk.internal.ix.a
        public final void a(ix ixVar) {
            if (this.f148850c == 0) {
                c(ixVar);
            }
        }

        @Override // com.tencent.mapsdk.internal.ix.a
        public final void b(ix ixVar) {
            if (this.f148850c == 1) {
                c(ixVar);
            }
        }
    }

    static /* synthetic */ boolean d(iz izVar) {
        izVar.f148833i = false;
        return false;
    }

    private ArrayList<ix> i() {
        ArrayList<ix> arrayList = new ArrayList<>();
        Iterator<e> it = this.f148829e.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f148851a);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.ix
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public iz clone() {
        iz izVar = (iz) super.clone();
        izVar.f148831g = true;
        izVar.f148826b = false;
        izVar.f148833i = false;
        izVar.f148827c = new ArrayList<>();
        izVar.f148828d = new HashMap<>();
        izVar.f148829e = new ArrayList<>();
        izVar.f148830f = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<e> it = this.f148829e.iterator();
        while (it.hasNext()) {
            e next = it.next();
            e clone = next.clone();
            hashMap.put(next, clone);
            izVar.f148829e.add(clone);
            izVar.f148828d.put(clone.f148851a, clone);
            ArrayList arrayList = null;
            clone.f148852b = null;
            clone.f148853c = null;
            clone.f148855e = null;
            clone.f148854d = null;
            ArrayList<ix.a> arrayList2 = clone.f148851a.f148825a;
            if (arrayList2 != null) {
                Iterator<ix.a> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    ix.a next2 = it5.next();
                    if (next2 instanceof a) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it6 = arrayList.iterator();
                    while (it6.hasNext()) {
                        arrayList2.remove((ix.a) it6.next());
                    }
                }
            }
        }
        Iterator<e> it7 = this.f148829e.iterator();
        while (it7.hasNext()) {
            e next3 = it7.next();
            e eVar = (e) hashMap.get(next3);
            ArrayList<c> arrayList3 = next3.f148852b;
            if (arrayList3 != null) {
                Iterator<c> it8 = arrayList3.iterator();
                while (it8.hasNext()) {
                    c next4 = it8.next();
                    eVar.a(new c((e) hashMap.get(next4.f148846c), next4.f148847d));
                }
            }
        }
        return izVar;
    }

    private void k() {
        if (this.f148831g) {
            this.f148830f.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.f148829e.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = this.f148829e.get(i3);
                ArrayList<c> arrayList2 = eVar.f148852b;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    arrayList.add(eVar);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    e eVar2 = (e) arrayList.get(i16);
                    this.f148830f.add(eVar2);
                    ArrayList<e> arrayList4 = eVar2.f148855e;
                    if (arrayList4 != null) {
                        int size3 = arrayList4.size();
                        for (int i17 = 0; i17 < size3; i17++) {
                            e eVar3 = eVar2.f148855e.get(i17);
                            eVar3.f148854d.remove(eVar2);
                            if (eVar3.f148854d.size() == 0) {
                                arrayList3.add(eVar3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList3);
                arrayList3.clear();
            }
            this.f148831g = false;
            if (this.f148830f.size() == this.f148829e.size()) {
                return;
            } else {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
        }
        int size4 = this.f148829e.size();
        for (int i18 = 0; i18 < size4; i18++) {
            e eVar4 = this.f148829e.get(i18);
            ArrayList<c> arrayList5 = eVar4.f148852b;
            if (arrayList5 != null && arrayList5.size() > 0) {
                int size5 = eVar4.f148852b.size();
                for (int i19 = 0; i19 < size5; i19++) {
                    c cVar = eVar4.f148852b.get(i19);
                    if (eVar4.f148854d == null) {
                        eVar4.f148854d = new ArrayList<>();
                    }
                    if (!eVar4.f148854d.contains(cVar.f148846c)) {
                        eVar4.f148854d.add(cVar.f148846c);
                    }
                }
            }
            eVar4.f148856f = false;
        }
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final boolean f() {
        Iterator<e> it = this.f148829e.iterator();
        while (it.hasNext()) {
            if (it.next().f148851a.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final boolean g() {
        return this.f148833i;
    }

    private void a(ix... ixVarArr) {
        if (ixVarArr != null) {
            this.f148831g = true;
            b a16 = a(ixVarArr[0]);
            for (int i3 = 1; i3 < ixVarArr.length; i3++) {
                a16.a(ixVarArr[i3]);
            }
        }
    }

    private void b(ix... ixVarArr) {
        if (ixVarArr != null) {
            this.f148831g = true;
            int i3 = 0;
            if (ixVarArr.length == 1) {
                a(ixVarArr[0]);
                return;
            }
            while (i3 < ixVarArr.length - 1) {
                b a16 = a(ixVarArr[i3]);
                i3++;
                a16.b(ixVarArr[i3]);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void c() {
        this.f148826b = true;
        if (this.f148833i) {
            if (this.f148830f.size() != this.f148829e.size()) {
                k();
                Iterator<e> it = this.f148830f.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (this.f148832h == null) {
                        this.f148832h = new a(this);
                    }
                    next.f148851a.a(this.f148832h);
                }
            }
            jm jmVar = this.f148835k;
            if (jmVar != null) {
                jmVar.b();
            }
            if (this.f148830f.size() > 0) {
                Iterator<e> it5 = this.f148830f.iterator();
                while (it5.hasNext()) {
                    it5.next().f148851a.c();
                }
            }
            ArrayList<ix.a> arrayList = this.f148825a;
            if (arrayList != null) {
                Iterator it6 = ((ArrayList) arrayList.clone()).iterator();
                while (it6.hasNext()) {
                    ((ix.a) it6.next()).b(this);
                }
            }
            this.f148833i = false;
        }
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final long d() {
        return this.f148834j;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final long e() {
        return this.f148836l;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b {

        /* renamed from: b, reason: collision with root package name */
        private e f148843b;

        b(ix ixVar) {
            e eVar = (e) iz.this.f148828d.get(ixVar);
            this.f148843b = eVar;
            if (eVar == null) {
                this.f148843b = new e(ixVar);
                iz.this.f148828d.put(ixVar, this.f148843b);
                iz.this.f148829e.add(this.f148843b);
            }
        }

        private b c(ix ixVar) {
            e eVar = (e) iz.this.f148828d.get(ixVar);
            if (eVar == null) {
                eVar = new e(ixVar);
                iz.this.f148828d.put(ixVar, eVar);
                iz.this.f148829e.add(eVar);
            }
            this.f148843b.a(new c(eVar, 1));
            return this;
        }

        public final b a(ix ixVar) {
            e eVar = (e) iz.this.f148828d.get(ixVar);
            if (eVar == null) {
                eVar = new e(ixVar);
                iz.this.f148828d.put(ixVar, eVar);
                iz.this.f148829e.add(eVar);
            }
            eVar.a(new c(this.f148843b, 0));
            return this;
        }

        public final b b(ix ixVar) {
            e eVar = (e) iz.this.f148828d.get(ixVar);
            if (eVar == null) {
                eVar = new e(ixVar);
                iz.this.f148828d.put(ixVar, eVar);
                iz.this.f148829e.add(eVar);
            }
            eVar.a(new c(this.f148843b, 1));
            return this;
        }

        private b a(long j3) {
            jm b16 = jm.b(0.0d, 1.0d);
            b16.b(j3);
            e eVar = (e) iz.this.f148828d.get(b16);
            if (eVar == null) {
                eVar = new e(b16);
                iz.this.f148828d.put(b16, eVar);
                iz.this.f148829e.add(eVar);
            }
            this.f148843b.a(new c(eVar, 1));
            return this;
        }
    }

    private void a(Collection<ix> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.f148831g = true;
        b bVar = null;
        for (ix ixVar : collection) {
            if (bVar == null) {
                bVar = a(ixVar);
            } else {
                bVar.a(ixVar);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void b() {
        ArrayList arrayList;
        this.f148826b = true;
        if (this.f148833i) {
            ArrayList<ix.a> arrayList2 = this.f148825a;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ix.a) it.next()).a();
                }
            } else {
                arrayList = null;
            }
            jm jmVar = this.f148835k;
            if (jmVar != null && jmVar.f()) {
                this.f148835k.b();
            } else if (this.f148830f.size() > 0) {
                Iterator<e> it5 = this.f148830f.iterator();
                while (it5.hasNext()) {
                    it5.next().f148851a.b();
                }
            }
            if (arrayList != null) {
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    ((ix.a) it6.next()).b(this);
                }
            }
            this.f148833i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public ix f148851a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<c> f148852b = null;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<c> f148853c = null;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<e> f148854d = null;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<e> f148855e = null;

        /* renamed from: f, reason: collision with root package name */
        public boolean f148856f = false;

        public e(ix ixVar) {
            this.f148851a = ixVar;
        }

        public final void a(c cVar) {
            if (this.f148852b == null) {
                this.f148852b = new ArrayList<>();
                this.f148854d = new ArrayList<>();
            }
            this.f148852b.add(cVar);
            if (!this.f148854d.contains(cVar.f148846c)) {
                this.f148854d.add(cVar.f148846c);
            }
            e eVar = cVar.f148846c;
            if (eVar.f148855e == null) {
                eVar.f148855e = new ArrayList<>();
            }
            eVar.f148855e.add(this);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e clone() {
            try {
                e eVar = (e) super.clone();
                eVar.f148851a = this.f148851a.clone();
                return eVar;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    private void a(List<ix> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f148831g = true;
        int i3 = 0;
        if (list.size() == 1) {
            a(list.get(0));
            return;
        }
        while (i3 < list.size() - 1) {
            b a16 = a(list.get(i3));
            i3++;
            a16.b(list.get(i3));
        }
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void a(Interpolator interpolator) {
        Iterator<e> it = this.f148829e.iterator();
        while (it.hasNext()) {
            it.next().f148851a.a(interpolator);
        }
    }

    private b a(ix ixVar) {
        if (ixVar == null) {
            return null;
        }
        this.f148831g = true;
        return new b(ixVar);
    }

    private iz c(long j3) {
        if (j3 >= 0) {
            Iterator<e> it = this.f148829e.iterator();
            while (it.hasNext()) {
                it.next().f148851a.b(j3);
            }
            this.f148836l = j3;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void a(long j3) {
        this.f148834j = j3;
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final /* synthetic */ ix b(long j3) {
        if (j3 >= 0) {
            Iterator<e> it = this.f148829e.iterator();
            while (it.hasNext()) {
                it.next().f148851a.b(j3);
            }
            this.f148836l = j3;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    @Override // com.tencent.mapsdk.internal.ix
    public final void a() {
        this.f148826b = false;
        this.f148833i = true;
        k();
        int size = this.f148830f.size();
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = this.f148830f.get(i3);
            ArrayList<ix.a> arrayList = eVar.f148851a.f148825a;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = new ArrayList(arrayList).iterator();
                while (it.hasNext()) {
                    ix.a aVar = (ix.a) it.next();
                    if ((aVar instanceof d) || (aVar instanceof a)) {
                        eVar.f148851a.b(aVar);
                    }
                }
            }
        }
        final ArrayList arrayList2 = new ArrayList();
        for (int i16 = 0; i16 < size; i16++) {
            e eVar2 = this.f148830f.get(i16);
            if (this.f148832h == null) {
                this.f148832h = new a(this);
            }
            ArrayList<c> arrayList3 = eVar2.f148852b;
            if (arrayList3 != null && arrayList3.size() != 0) {
                int size2 = eVar2.f148852b.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    c cVar = eVar2.f148852b.get(i17);
                    cVar.f148846c.f148851a.a(new d(this, eVar2, cVar.f148847d));
                }
                eVar2.f148853c = (ArrayList) eVar2.f148852b.clone();
            } else {
                arrayList2.add(eVar2);
            }
            eVar2.f148851a.a(this.f148832h);
        }
        if (this.f148834j <= 0) {
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                e eVar3 = (e) it5.next();
                eVar3.f148851a.a();
                this.f148827c.add(eVar3.f148851a);
            }
        } else {
            jm b16 = jm.b(0.0d, 1.0d);
            this.f148835k = b16;
            b16.b(this.f148834j);
            this.f148835k.a(new iy() { // from class: com.tencent.mapsdk.internal.iz.1

                /* renamed from: a, reason: collision with root package name */
                boolean f148837a = false;

                @Override // com.tencent.mapsdk.internal.iy, com.tencent.mapsdk.internal.ix.a
                public final void a() {
                    this.f148837a = true;
                }

                @Override // com.tencent.mapsdk.internal.iy, com.tencent.mapsdk.internal.ix.a
                public final void b(ix ixVar) {
                    if (!this.f148837a) {
                        int size3 = arrayList2.size();
                        for (int i18 = 0; i18 < size3; i18++) {
                            e eVar4 = (e) arrayList2.get(i18);
                            eVar4.f148851a.a();
                            iz.this.f148827c.add(eVar4.f148851a);
                        }
                    }
                }
            });
            this.f148835k.a();
        }
        ArrayList<ix.a> arrayList4 = this.f148825a;
        if (arrayList4 != null) {
            ArrayList arrayList5 = (ArrayList) arrayList4.clone();
            int size3 = arrayList5.size();
            for (int i18 = 0; i18 < size3; i18++) {
                ((ix.a) arrayList5.get(i18)).a(this);
            }
        }
        if (this.f148829e.size() == 0 && this.f148834j == 0) {
            this.f148833i = false;
            ArrayList<ix.a> arrayList6 = this.f148825a;
            if (arrayList6 != null) {
                ArrayList arrayList7 = (ArrayList) arrayList6.clone();
                int size4 = arrayList7.size();
                for (int i19 = 0; i19 < size4; i19++) {
                    ((ix.a) arrayList7.get(i19)).b(this);
                }
            }
        }
    }
}
