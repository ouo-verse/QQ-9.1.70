package p4;

import android.view.ViewGroup;
import com.qzone.proxy.feedcomponent.util.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    public static final String f425239i = c.f425249q;

    /* renamed from: a, reason: collision with root package name */
    private c f425240a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<p4.a> f425241b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<p4.a> f425242c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<p4.a> f425243d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, p4.a> f425244e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f425245f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f425246g;

    /* renamed from: h, reason: collision with root package name */
    private Comparator<p4.a> f425247h = new a();

    public b(c cVar) {
        this.f425246g = true;
        this.f425240a = cVar;
        if (cVar != null) {
            this.f425241b = new ArrayList<>();
            this.f425242c = new ArrayList<>();
            this.f425243d = new ArrayList<>();
            this.f425244e = new HashMap<>();
            this.f425245f = this.f425240a.f();
            ViewGroup o16 = this.f425240a.o();
            if (o16 == null) {
                return;
            }
            if (o16.getChildCount() != this.f425245f.length) {
                j.c(f425239i, "AlbumTitleBarWidgetMgr init error : tmpContainer size != initIDLst with size ->" + o16.getChildCount());
                return;
            }
            for (int i3 = 0; i3 < o16.getChildCount(); i3++) {
                int id5 = o16.getChildAt(i3).getId();
                int i16 = this.f425245f[i3];
                if (id5 != i16) {
                    j.c(f425239i, "AlbumTitleBarWidgetMgr init error : id seq not the same");
                    return;
                }
                p4.a n3 = this.f425240a.n(i16);
                if (n3 == null) {
                    j.c(f425239i, "AlbumTitleBarWidgetMgr init error : cant create TitleBarWidget");
                    return;
                }
                n3.f425234b = 0;
                n3.f425235c = i3;
                this.f425243d.add(n3);
                this.f425244e.put(Integer.valueOf(n3.f425233a), n3);
            }
            this.f425246g = true;
        }
    }

    private void a(p4.a aVar, int i3) {
        if (this.f425242c.isEmpty()) {
            c(aVar, 2, i3);
            return;
        }
        if (this.f425241b.isEmpty()) {
            c(aVar, 1, i3);
            return;
        }
        if (!l(2)) {
            c(aVar, 2, i3);
        } else if (!l(1)) {
            c(aVar, 1, i3);
        } else {
            c(aVar, 2, i3);
        }
    }

    private void c(p4.a aVar, int i3, int i16) {
        ArrayList<p4.a> g16 = g(i3);
        if (aVar == null || g16 == null) {
            return;
        }
        aVar.f425238f = i16;
        g16.add(aVar);
        aVar.f425234b = i3;
        aVar.f425235c = g16.size() - 1;
    }

    private void e(int i3) {
        p4.a remove;
        ArrayList<p4.a> g16 = g(i3);
        if (g16 == null) {
            return;
        }
        for (int i16 = 0; i16 < g16.size(); i16++) {
            p4.a aVar = g16.get(i16);
            if (aVar.f425238f == 8) {
                if (!o(aVar, i3)) {
                    j.c(f425239i, "checkContainer error : can not remove widget from container ->" + i3);
                } else {
                    c(aVar, i3, 8);
                }
            }
        }
        Iterator<p4.a> it = q(0, 0, h(i3)).iterator();
        while (it.hasNext()) {
            c(it.next(), i3, 0);
        }
        if (!l(i3)) {
            Iterator<p4.a> it5 = q(0, 0, 0).iterator();
            while (it5.hasNext()) {
                c(it5.next(), i3, 0);
            }
        }
        Collections.sort(g16, this.f425247h);
        if (this.f425243d == null) {
            j.c(f425239i, "checkContainer error : tmpContainer is NULL!");
            return;
        }
        Iterator<p4.a> it6 = g16.iterator();
        int i17 = 0;
        while (it6.hasNext()) {
            p4.a next = it6.next();
            next.f425235c = i17;
            if (i17 != 0) {
                it6.remove();
                c(next, 0, next.f425238f);
            }
            i17++;
        }
        int m3 = m();
        if (m3 != -1) {
            if (m3 != 2) {
                j.c(f425239i, "checkContainer error : Cannot handle this greedy widget pos = " + m3);
                return;
            }
            ArrayList<p4.a> g17 = g(1);
            if (g17.size() != 1 || (remove = g17.remove(0)) == null) {
                return;
            }
            c(remove, 0, remove.f425238f);
        }
    }

    private int h(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        return 0;
    }

    private void i() {
        ArrayList<p4.a> arrayList = this.f425241b;
        if (arrayList == null || this.f425242c == null || arrayList.size() != 1 || !this.f425242c.isEmpty()) {
            return;
        }
        p4.a aVar = this.f425241b.get(0);
        if (o(aVar, 1)) {
            c(aVar, 2, aVar.f425238f);
        }
    }

    private boolean k() {
        ArrayList<p4.a> arrayList = this.f425241b;
        if (arrayList == null || this.f425242c == null) {
            return true;
        }
        if (arrayList.size() > 1 || this.f425242c.size() > 1) {
            return false;
        }
        if (this.f425241b.isEmpty() || !this.f425242c.isEmpty()) {
            return (m() == -1 || this.f425241b.size() <= 0) && !n(0, 0);
        }
        return false;
    }

    private boolean n(int i3, int i16) {
        ArrayList<p4.a> g16 = g(i3);
        if (g16 != null && !g16.isEmpty()) {
            Iterator<p4.a> it = g16.iterator();
            while (it.hasNext()) {
                if (it.next().f425238f == i16) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean o(p4.a aVar, int i3) {
        ArrayList<p4.a> g16 = g(i3);
        if (aVar != null && aVar.a(i3) && g16 != null && aVar.f425235c < g16.size()) {
            p4.a aVar2 = g16.get(aVar.f425235c);
            if (aVar2.f425233a == aVar.f425233a) {
                g16.remove(aVar2.f425235c);
                p(g16);
                return true;
            }
        }
        return false;
    }

    private ArrayList<p4.a> q(int i3, int i16, int i17) {
        ArrayList<p4.a> arrayList = new ArrayList<>();
        ArrayList<p4.a> g16 = g(i3);
        if (g16 != null && !g16.isEmpty()) {
            Iterator<p4.a> it = g16.iterator();
            while (it.hasNext()) {
                p4.a next = it.next();
                if (next.f425236d == i17 && next.f425238f == i16) {
                    arrayList.add(next);
                }
            }
            Iterator<p4.a> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                o(it5.next(), i3);
            }
        }
        return arrayList;
    }

    public void j(int i3) {
        if (this.f425244e.containsKey(Integer.valueOf(i3))) {
            p4.a aVar = this.f425244e.get(Integer.valueOf(i3));
            if (aVar.b()) {
                return;
            }
            int i16 = aVar.f425234b;
            if (i16 != 0) {
                if (!o(aVar, i16)) {
                    j.c(f425239i, "hideWidget error : can not remove widget from container : " + aVar.f425234b);
                    return;
                }
                c(aVar, 0, 8);
            } else {
                aVar.f425238f = 8;
            }
            if (k()) {
                return;
            }
            d();
        }
    }

    public void r(int i3) {
        if (this.f425244e.containsKey(Integer.valueOf(i3))) {
            p4.a aVar = this.f425244e.get(Integer.valueOf(i3));
            if (aVar.c()) {
                return;
            }
            if (!o(aVar, 0)) {
                j.c(f425239i, "showWidget error : can not find the widget in tmp container");
                return;
            }
            b(aVar, 0);
            if (k()) {
                return;
            }
            d();
        }
    }

    private void d() {
        e(2);
        e(1);
        i();
    }

    private int m() {
        ArrayList<p4.a> g16 = g(1);
        ArrayList<p4.a> g17 = g(2);
        if (g16 != null && !g16.isEmpty() && g17 != null && !g17.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(g16);
            arrayList.addAll(g17);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                p4.a aVar = (p4.a) it.next();
                if (aVar.f425236d == 3) {
                    return aVar.f425234b;
                }
            }
        }
        return -1;
    }

    public int[] f() {
        int[] iArr = new int[2];
        if (this.f425241b.size() <= 1 && this.f425242c.size() <= 1) {
            if (this.f425241b.isEmpty()) {
                iArr[0] = 99;
            } else {
                iArr[0] = this.f425241b.get(0).f425233a;
            }
            if (this.f425242c.isEmpty()) {
                iArr[1] = 99;
            } else {
                iArr[1] = this.f425242c.get(0).f425233a;
            }
        } else {
            iArr[0] = -99;
            iArr[1] = -99;
        }
        return iArr;
    }

    private void b(p4.a aVar, int i3) {
        if (aVar == null || this.f425241b == null || this.f425242c == null) {
            return;
        }
        int i16 = aVar.f425236d;
        if (i16 == 0) {
            a(aVar, i3);
        } else if (i16 == 1) {
            c(aVar, 1, i3);
        } else {
            c(aVar, 2, i3);
        }
    }

    private void p(ArrayList<p4.a> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList.get(i3).f425235c = i3;
        }
    }

    private boolean l(int i3) {
        if (i3 == 0) {
            return false;
        }
        int h16 = h(i3);
        ArrayList<p4.a> g16 = g(i3);
        if (g16 == null) {
            return false;
        }
        Iterator<p4.a> it = g16.iterator();
        while (it.hasNext()) {
            if (it.next().f425236d == h16) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Comparator<p4.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(p4.a aVar, p4.a aVar2) {
            int i3;
            if (aVar == null || aVar2 == null) {
                return 0;
            }
            int i16 = aVar.f425236d;
            if (i16 == 3 || (i3 = aVar2.f425236d) == 3) {
                if (i16 != aVar2.f425236d) {
                    return i16 == 3 ? -1 : 1;
                }
                int i17 = aVar.f425237e;
                int i18 = aVar2.f425237e;
                if (i17 == i18) {
                    return 0;
                }
                return i17 > i18 ? -1 : 1;
            }
            if (i16 != i3 && i16 > 0 && i3 > 0) {
                int i19 = aVar.f425234b;
                if (i19 == aVar2.f425234b && i19 != 0 && aVar.f425237e == aVar2.f425237e) {
                    return i19 == i16 ? -1 : 1;
                }
                return 0;
            }
            if (i16 != i3) {
                return (i16 <= 0 || i3 != 0) ? 1 : -1;
            }
            int i26 = aVar.f425237e;
            int i27 = aVar2.f425237e;
            if (i26 == i27) {
                return 0;
            }
            return i26 > i27 ? -1 : 1;
        }
    }

    private ArrayList<p4.a> g(int i3) {
        if (i3 == 0) {
            return this.f425243d;
        }
        if (i3 == 1) {
            return this.f425241b;
        }
        if (i3 != 2) {
            return null;
        }
        return this.f425242c;
    }
}
