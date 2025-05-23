package ku2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import yu2.d;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f413040a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, ArrayList<String>>> f413041b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedList<Integer> f413042c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f413043d;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static a f413044a = new a();
    }

    private ArrayList<String> a(ConcurrentHashMap<Integer, ArrayList<String>> concurrentHashMap) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (concurrentHashMap != null) {
            Iterator<ArrayList<String>> it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next());
            }
        }
        return arrayList;
    }

    public static a c() {
        return b.f413044a;
    }

    public HashMap<String, ArrayList<String>> b() {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (Map.Entry<String, ConcurrentHashMap<Integer, ArrayList<String>>> entry : this.f413041b.entrySet()) {
            hashMap.put(entry.getKey(), a(entry.getValue()));
        }
        return hashMap;
    }

    a() {
        this.f413041b = new ConcurrentHashMap<>();
        this.f413043d = new Object();
        this.f413042c = new LinkedList<>();
        this.f413040a = d.a();
    }
}
