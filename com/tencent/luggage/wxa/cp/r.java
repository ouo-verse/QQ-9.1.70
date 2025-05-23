package com.tencent.luggage.wxa.cp;

import android.util.Pair;
import com.tencent.luggage.wxa.cp.k;
import com.tencent.luggage.wxa.cp.p;
import com.tencent.luggage.wxa.cp.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r implements p {

    /* renamed from: i, reason: collision with root package name */
    public static final u f123826i = new u(new m(""));

    /* renamed from: a, reason: collision with root package name */
    public final q f123827a;

    /* renamed from: b, reason: collision with root package name */
    public final List f123828b;

    /* renamed from: c, reason: collision with root package name */
    public final u f123829c;

    /* renamed from: d, reason: collision with root package name */
    public Map f123830d = null;

    /* renamed from: e, reason: collision with root package name */
    public Map f123831e = null;

    /* renamed from: f, reason: collision with root package name */
    public Map f123832f = null;

    /* renamed from: g, reason: collision with root package name */
    public Map f123833g = null;

    /* renamed from: h, reason: collision with root package name */
    public List f123834h = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.f123817a.compareTo(bVar2.f123817a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends p.a implements Comparable {

        /* renamed from: c, reason: collision with root package name */
        public final int f123835c;

        /* renamed from: d, reason: collision with root package name */
        public k.a f123836d;

        public b(String str, String str2, int i3, k.a aVar) {
            super(str, str2);
            this.f123835c = i3;
            this.f123836d = aVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(String str) {
            return this.f123817a.compareTo(str);
        }
    }

    public r(q qVar) {
        this.f123827a = qVar;
        this.f123828b = a(qVar);
        u uVar = qVar.f123825f;
        this.f123829c = uVar == null ? f123826i : uVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List a(q qVar) {
        int i3;
        SortedMap sortedMap = qVar.f123823d;
        Map map = qVar.f123821b;
        Map map2 = qVar.f123824e;
        ArrayList arrayList = new ArrayList(sortedMap.size());
        Iterator it = sortedMap.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                g gVar = (g) entry.getKey();
                String str = (String) entry.getValue();
                u uVar = (u) map.get(str);
                if (uVar != null) {
                    String[] b16 = gVar.b(map2);
                    if (b16 != null && b16.length != 0) {
                        for (String str2 : b16) {
                            arrayList.add(new b(str2, str, -1, (k.a) uVar.f123838b));
                        }
                    }
                } else {
                    throw new IllegalArgumentException("FileSystem '" + str + "' for mount point '" + gVar + "' not exist.");
                }
            } else {
                b[] bVarArr = (b[]) arrayList.toArray(new b[0]);
                Arrays.sort(bVarArr, new a());
                for (int i16 = 1; i16 < bVarArr.length; i16++) {
                    b bVar = bVarArr[i16];
                    String str3 = bVar.f123817a;
                    int i17 = i16 - 1;
                    b bVar2 = bVarArr[i17];
                    if (str3.equals(bVar2.f123817a)) {
                        com.tencent.luggage.wxa.yp.b.e("VFS.ResolverState", "Oops, duplicated mount point detected: " + bVar + " <=> " + bVar2);
                        i3 = bVar2.f123835c;
                        if (i3 < 0) {
                            bVarArr[i16] = new b(bVar.f123817a, bVar.f123818b, i3, bVar.f123836d);
                        }
                    }
                    do {
                        b bVar3 = bVarArr[i17];
                        if (str3.startsWith(bVar3.f123817a) && str3.charAt(bVar3.f123817a.length()) == '/') {
                            break;
                        }
                        i17 = bVar3.f123835c;
                    } while (i17 >= 0);
                    i3 = i17;
                    if (i3 < 0) {
                    }
                }
                return Arrays.asList(bVarArr);
            }
        }
    }

    public k.a b(String str) {
        u uVar = (u) this.f123827a.f123821b.get(str);
        if (uVar == null) {
            return null;
        }
        return (k.a) uVar.a(a(), str);
    }

    public k.a c(String str) {
        u uVar = (u) this.f123827a.f123822c.get(str);
        if (uVar == null) {
            return null;
        }
        return (k.a) uVar.a(a(), str);
    }

    public k.a d() {
        return (k.a) this.f123829c.a(a(), "(root)");
    }

    public Set e() {
        return this.f123827a.f123820a.keySet();
    }

    public String toString() {
        return "schemes: " + this.f123827a.f123820a.size() + ", fileSystems: " + this.f123827a.f123821b.size() + ", mountPoints: " + this.f123827a.f123823d.size() + " (" + this.f123828b + " active), envVars: " + this.f123827a.f123824e.size();
    }

    public s.a d(String str) {
        u uVar = (u) this.f123827a.f123820a.get(str);
        if (uVar == null) {
            return null;
        }
        return (s.a) uVar.a(a(), str);
    }

    public Set b() {
        return this.f123827a.f123821b.keySet();
    }

    public Set c() {
        return this.f123827a.f123822c.keySet();
    }

    public Map a() {
        if (this.f123833g == null) {
            this.f123833g = Collections.unmodifiableMap(this.f123827a.f123824e);
        }
        return this.f123833g;
    }

    public Pair a(String str, String[] strArr) {
        b bVar;
        String str2;
        b bVar2;
        k.a aVar;
        List list = this.f123828b;
        String str3 = null;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String a16 = c0.a(str, true, false);
        int binarySearch = Collections.binarySearch(list, a16);
        if (binarySearch >= 0) {
            bVar2 = (b) list.get(binarySearch);
            str2 = "";
        } else {
            int i3 = (-binarySearch) - 2;
            while (true) {
                if (i3 >= 0) {
                    bVar = (b) list.get(i3);
                    if (a16.startsWith(bVar.f123817a) && a16.charAt(bVar.f123817a.length()) == '/') {
                        break;
                    }
                    i3 = bVar.f123835c;
                } else {
                    bVar = null;
                    break;
                }
            }
            if (i3 >= 0) {
                a16 = a16.substring(bVar.f123817a.length() + 1);
            } else if (!a16.isEmpty() && a16.charAt(0) == '/') {
                a16 = a16.substring(1);
            }
            str2 = a16;
            bVar2 = bVar;
        }
        if (bVar2 == null) {
            aVar = d();
        } else {
            if (bVar2.f123836d == null) {
                bVar2.f123836d = b(bVar2.f123818b);
            }
            k.a aVar2 = bVar2.f123836d;
            str3 = bVar2.f123818b;
            aVar = aVar2;
        }
        if (strArr != null) {
            strArr[0] = str3;
        }
        return new Pair(aVar, str2);
    }

    @Override // com.tencent.luggage.wxa.cp.p
    public Pair a(String str) {
        return a(str, null);
    }
}
