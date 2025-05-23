package com.tencent.mobileqq.hitrate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, ArrayList<d>> f236845a;

    /* renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap<String, c> f236846b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f236845a = new ConcurrentHashMap<>();
            f236846b = new ConcurrentHashMap<>();
        }
    }

    public static void a(d dVar) {
        synchronized (f236845a) {
            String c16 = dVar.c();
            ArrayList<d> arrayList = f236845a.get(c16);
            if (arrayList == null) {
                ArrayList<d> arrayList2 = new ArrayList<>();
                arrayList2.add(dVar);
                f236845a.put(c16, arrayList2);
            } else if (!arrayList.contains(dVar)) {
                arrayList.add(dVar);
            }
        }
    }

    public static void b() {
        synchronized (f236845a) {
            HashSet hashSet = new HashSet();
            Iterator<ArrayList<d>> it = f236845a.values().iterator();
            while (it.hasNext()) {
                Iterator<d> it5 = it.next().iterator();
                while (it5.hasNext()) {
                    d next = it5.next();
                    next.b();
                    hashSet.add(next.f236850c);
                }
            }
            Iterator it6 = hashSet.iterator();
            while (it6.hasNext()) {
                f((String) it6.next());
            }
        }
    }

    public static void c(String str) {
        synchronized (f236845a) {
            for (String str2 : f236845a.keySet()) {
                if (str2.startsWith(str)) {
                    Iterator<d> it = f236845a.get(str2).iterator();
                    while (it.hasNext()) {
                        it.next().b();
                    }
                }
            }
            f(str);
        }
    }

    public static void d(String str) {
        synchronized (f236845a) {
            c cVar = f236846b.get(str);
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    public static void e(String str) {
        synchronized (f236845a) {
            if (f236846b.get(str) == null) {
                c cVar = new c(str);
                f236846b.put(str, cVar);
                cVar.a();
            }
        }
    }

    public static void f(String str) {
        synchronized (f236845a) {
            c cVar = f236846b.get(str);
            if (cVar != null) {
                cVar.b();
                f236846b.remove(str);
            }
        }
    }

    public static void g(String str) {
        synchronized (f236845a) {
            for (String str2 : f236845a.keySet()) {
                if (str2.endsWith("plugin")) {
                    Iterator<d> it = f236845a.get(str2).iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        if (((b) next).f236847f.equals(str)) {
                            next.d();
                            next.b();
                        }
                    }
                }
            }
        }
    }
}
