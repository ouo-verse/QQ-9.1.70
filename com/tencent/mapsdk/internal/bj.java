package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class bj {

    /* renamed from: l, reason: collision with root package name */
    private static final Comparator<fb> f147860l = new Comparator<fb>() { // from class: com.tencent.mapsdk.internal.bj.1
        private static int a(fb fbVar, fb fbVar2) {
            if (fbVar.getLevel() != fbVar2.getLevel()) {
                return Float.compare(fbVar.getLevel(), fbVar2.getLevel());
            }
            if (fbVar.getZIndex() != fbVar2.getZIndex()) {
                return Float.compare(fbVar.getZIndex(), fbVar2.getZIndex());
            }
            return Long.compare(fbVar.o(), fbVar2.o());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(fb fbVar, fb fbVar2) {
            fb fbVar3 = fbVar;
            fb fbVar4 = fbVar2;
            if (fbVar3.getLevel() != fbVar4.getLevel()) {
                return Float.compare(fbVar3.getLevel(), fbVar4.getLevel());
            }
            if (fbVar3.getZIndex() != fbVar4.getZIndex()) {
                return Float.compare(fbVar3.getZIndex(), fbVar4.getZIndex());
            }
            return Long.compare(fbVar3.o(), fbVar4.o());
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private static final Comparator<fb> f147861m = new Comparator<fb>() { // from class: com.tencent.mapsdk.internal.bj.2
        private static int a(fb fbVar, fb fbVar2) {
            if (fbVar.getLevel() != fbVar2.getLevel()) {
                return Float.compare(fbVar2.getLevel(), fbVar.getLevel());
            }
            if (fbVar.getZIndex() != fbVar2.getZIndex()) {
                return Float.compare(fbVar2.getZIndex(), fbVar.getZIndex());
            }
            return Long.compare(fbVar2.o(), fbVar.o());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(fb fbVar, fb fbVar2) {
            fb fbVar3 = fbVar;
            fb fbVar4 = fbVar2;
            if (fbVar3.getLevel() != fbVar4.getLevel()) {
                return Float.compare(fbVar4.getLevel(), fbVar3.getLevel());
            }
            if (fbVar3.getZIndex() != fbVar4.getZIndex()) {
                return Float.compare(fbVar4.getZIndex(), fbVar3.getZIndex());
            }
            return Long.compare(fbVar4.o(), fbVar3.o());
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, fb> f147862a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final List<fb> f147863b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final List<fb> f147864c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final List<fb> f147865d = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final List<fb> f147866e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final List<fb> f147867f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final List<fb> f147868g = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List<ex> f147869h = new CopyOnWriteArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final bb f147870i;

    /* renamed from: j, reason: collision with root package name */
    public final bg f147871j;

    /* renamed from: k, reason: collision with root package name */
    private IndoorBuilding f147872k;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum a {
        ASC(bj.f147860l),
        DESC(bj.f147861m);


        /* renamed from: c, reason: collision with root package name */
        public final Comparator<fb> f147876c;

        a(Comparator comparator) {
            this.f147876c = comparator;
        }

        private Comparator<fb> a() {
            return this.f147876c;
        }
    }

    public bj(bb bbVar, bf bfVar) {
        this.f147870i = bbVar;
        this.f147871j = new bg(bfVar);
    }

    private Arc a(ArcOptions arcOptions) {
        pl plVar = new pl(arcOptions, this.f147870i);
        at atVar = new at(plVar);
        this.f147862a.put(plVar.getId(), atVar);
        this.f147865d.add(atVar);
        a((ex) plVar);
        return atVar;
    }

    private ey b(pp ppVar) {
        ps psVar = new ps((tr) this.f147870i, ppVar);
        this.f147864c.add(psVar);
        return psVar;
    }

    private List<fb> c(a aVar) {
        ArrayList arrayList = new ArrayList(this.f147867f);
        arrayList.addAll(this.f147868g);
        Collections.sort(arrayList, aVar.f147876c);
        return arrayList;
    }

    private List<Arc> d(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147865d) {
            if (fbVar instanceof at) {
                arrayList.add((at) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private List<fb> g() {
        return c(a.ASC);
    }

    private List<fb> h() {
        return c(a.ASC);
    }

    private List<fb> i() {
        return c(a.ASC);
    }

    private List<Arc> j() {
        a aVar = a.ASC;
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147865d) {
            if (fbVar instanceof at) {
                arrayList.add((at) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private List<ey> k() {
        a aVar = a.ASC;
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147864c) {
            if (fbVar instanceof ao) {
                arrayList.add((ao) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private List<Polyline> l() {
        a aVar = a.ASC;
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147866e) {
            if (fbVar instanceof az) {
                arrayList.add((az) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private List<Circle> m() {
        a aVar = a.ASC;
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147868g) {
            if (fbVar instanceof au) {
                arrayList.add((au) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private void n() {
        Iterator<fb> it = this.f147862a.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private Iterable<fb> o() {
        ArrayList arrayList = new ArrayList(this.f147862a.values());
        Collections.sort(arrayList, a.ASC.f147876c);
        return arrayList;
    }

    private List<ey> e(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147864c) {
            if (fbVar instanceof ao) {
                arrayList.add((ao) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private List<Marker> f(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147863b) {
            if (fbVar instanceof ax) {
                arrayList.add((ax) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private List<Polyline> g(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147866e) {
            if (fbVar instanceof az) {
                arrayList.add((az) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private List<Polygon> h(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147867f) {
            if (fbVar instanceof ay) {
                arrayList.add((ay) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private List<Circle> i(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147868g) {
            if (fbVar instanceof au) {
                arrayList.add((au) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private boolean b(String str) {
        aq f_;
        fb remove = this.f147862a.remove(str);
        if (remove != null) {
            if (remove instanceof ax) {
                this.f147863b.remove(remove);
            } else if (remove instanceof at) {
                this.f147865d.remove(remove);
            } else if (remove instanceof az) {
                this.f147866e.remove(remove);
            } else if (remove instanceof au) {
                this.f147868g.remove(remove);
            } else if (remove instanceof ao) {
                this.f147864c.remove(remove);
            } else if (remove instanceof ay) {
                this.f147867f.remove(remove);
            }
            if ((remove instanceof aw) && (f_ = ((aw) remove).f_()) != null) {
                this.f147869h.remove(f_);
            }
        }
        return remove != null;
    }

    public final List<Polygon> c() {
        a aVar = a.ASC;
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147867f) {
            if (fbVar instanceof ay) {
                arrayList.add((ay) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    public final Circle a(CircleOptions circleOptions) {
        pm pmVar = new pm(this.f147870i);
        pmVar.a(circleOptions);
        au auVar = new au(pmVar);
        this.f147862a.put(pmVar.getId(), auVar);
        this.f147868g.add(auVar);
        a((ex) pmVar);
        return auVar;
    }

    public final Iterable<fb> d() {
        return this.f147862a.values();
    }

    private Polygon a(PolygonOptions polygonOptions) {
        pq pqVar = new pq(this.f147870i, polygonOptions);
        ay ayVar = new ay(pqVar);
        this.f147862a.put(pqVar.getId(), ayVar);
        this.f147867f.add(ayVar);
        a((ex) pqVar);
        return ayVar;
    }

    public final Polyline a(PolylineOptions polylineOptions) {
        pr prVar = new pr(this.f147870i);
        prVar.setPolylineOptions(polylineOptions);
        az azVar = new az(prVar);
        this.f147862a.put(prVar.getId(), azVar);
        this.f147866e.add(azVar);
        a((ex) prVar);
        return azVar;
    }

    private List<fb> b(a aVar) {
        ArrayList arrayList = new ArrayList(this.f147866e);
        arrayList.addAll(this.f147865d);
        Collections.sort(arrayList, aVar.f147876c);
        return arrayList;
    }

    public final Marker a(MarkerOptions markerOptions) {
        tr trVar = (tr) this.f147870i;
        pp ppVar = new pp(trVar, markerOptions);
        ax axVar = new ax(ppVar);
        this.f147862a.put(ppVar.getId(), axVar);
        this.f147863b.add(axVar);
        pt ptVar = trVar.f151036ap;
        if (ptVar != null) {
            ptVar.a(ppVar);
        }
        a((ex) ppVar);
        return axVar;
    }

    public final List<Marker> b() {
        a aVar = a.ASC;
        ArrayList arrayList = new ArrayList();
        for (fb fbVar : this.f147863b) {
            if (fbVar instanceof ax) {
                arrayList.add((ax) fbVar);
            }
        }
        Collections.sort(arrayList, aVar.f147876c);
        return new ArrayList(arrayList);
    }

    private ey a(pp ppVar) {
        pn pnVar = new pn((tr) this.f147870i, ppVar);
        this.f147862a.put(pnVar.getId(), pnVar);
        this.f147864c.add(pnVar);
        return pnVar;
    }

    private void b(fb fbVar) {
        bg bgVar = this.f147871j;
        if (fbVar != null) {
            synchronized (bgVar.f147792a) {
                bgVar.f147792a.remove(fbVar);
                bgVar.f147793b.add(fbVar);
            }
        }
    }

    public final void a(ex exVar) {
        if (exVar == null || exVar.s() == null) {
            return;
        }
        IndoorBuilding indoorBuilding = this.f147872k;
        if (indoorBuilding != null) {
            exVar.a(indoorBuilding);
        } else {
            exVar.u();
        }
        this.f147869h.add(exVar);
    }

    public final fb a(String str) {
        return this.f147862a.get(str);
    }

    public final <T extends fb> T a(String str, Class<T> cls) {
        T t16 = (T) this.f147862a.get(str);
        if (t16 == null || t16.getClass() != cls) {
            return null;
        }
        return t16;
    }

    public final void a() {
        synchronized (this) {
            Iterator<fb> it = this.f147862a.values().iterator();
            while (it.hasNext()) {
                fb next = it.next();
                if (next != null) {
                    next.remove();
                    it.remove();
                }
            }
        }
        this.f147863b.clear();
        this.f147864c.clear();
        this.f147865d.clear();
        this.f147868g.clear();
        this.f147866e.clear();
        this.f147867f.clear();
    }

    public final List<fb> a(a aVar) {
        ArrayList arrayList = new ArrayList(this.f147863b);
        Collections.sort(arrayList, aVar.f147876c);
        return arrayList;
    }

    public final boolean a(IndoorBuilding indoorBuilding) {
        this.f147872k = indoorBuilding;
        boolean z16 = false;
        for (ex exVar : this.f147869h) {
            if (exVar.s() != null) {
                z16 = true;
                if (indoorBuilding != null) {
                    exVar.a(indoorBuilding);
                } else {
                    exVar.u();
                }
            }
        }
        return z16;
    }

    private void a(fb fbVar) {
        bg bgVar = this.f147871j;
        synchronized (bgVar.f147792a) {
            if (!bgVar.f147792a.contains(fbVar)) {
                bgVar.f147792a.add(fbVar);
            }
        }
        if (fbVar instanceof ex) {
            a((ex) fbVar);
        }
    }

    private void a(GL10 gl10) {
        this.f147871j.a(gl10);
    }

    private boolean a(float f16, float f17) {
        return this.f147871j.a(f16, f17);
    }
}
