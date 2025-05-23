package com.tencent.luggage.wxa.hf;

import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static Map f127095a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static Set f127097c = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static Set f127096b = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    public static Runnable f127098d = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            e.b();
        }
    }

    public static synchronized com.tencent.luggage.wxa.hf.a b(String str, String str2) {
        synchronized (e.class) {
            if ("invalid_map_id".equals(str2)) {
                w.b("MicroMsg.AppBrandMapManager", "[getMapView]INVALID_MAP_ID");
                return null;
            }
            HashMap hashMap = (HashMap) f127095a.get(str);
            if (hashMap == null) {
                return null;
            }
            com.tencent.luggage.wxa.k0.d.a(hashMap.get(str2));
            return null;
        }
    }

    public static synchronized boolean a(String str, String str2) {
        synchronized (e.class) {
            HashMap hashMap = (HashMap) f127095a.get(str);
            if (hashMap == null) {
                return false;
            }
            com.tencent.luggage.wxa.k0.d.a(hashMap.get(str2));
            w.b("MicroMsg.AppBrandMapManager", "[destroyMapView] mapview not exist, err");
            return false;
        }
    }

    public static void b() {
        HashSet hashSet = new HashSet(f127096b);
        f127096b.clear();
        Iterator it = hashSet.iterator();
        if (it.hasNext()) {
            com.tencent.luggage.wxa.k0.d.a(it.next());
            throw null;
        }
    }
}
