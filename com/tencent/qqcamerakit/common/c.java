package com.tencent.qqcamerakit.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected String f344914a;

    /* renamed from: b, reason: collision with root package name */
    private a<Integer, d> f344915b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class a<K, V> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private HashMap<K, ArrayList<V>> f344916a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            } else {
                this.f344916a = new HashMap<>();
            }
        }

        public ArrayList<V> a(K k3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3);
            }
            return this.f344916a.get(k3);
        }

        public void b(K k3, V v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) k3, (Object) v3);
                return;
            }
            ArrayList<V> arrayList = this.f344916a.get(k3);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f344916a.put(k3, arrayList);
            }
            if (!arrayList.contains(v3)) {
                arrayList.add(v3);
            }
        }

        public void c(V v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
                return;
            }
            for (Map.Entry<K, ArrayList<V>> entry : this.f344916a.entrySet()) {
                ArrayList<V> value = entry.getValue();
                int i3 = 0;
                while (i3 < value.size()) {
                    V v16 = value.get(i3);
                    if (v16 != v3 && (v16 == null || !v16.equals(v3))) {
                        i3++;
                    } else {
                        entry.getValue().remove(v3);
                    }
                }
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f344914a = getClass().getSimpleName();
            this.f344915b = new a<>();
        }
    }

    public synchronized void a(d dVar, int... iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) iArr);
            return;
        }
        for (int i3 : iArr) {
            this.f344915b.b(Integer.valueOf(i3), dVar);
        }
    }

    public void b(int i3, int i16, String str, Object... objArr) {
        ArrayList<d> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), str, objArr);
            return;
        }
        synchronized (this) {
            a16 = this.f344915b.a(Integer.valueOf(i3));
        }
        if (a16 != null && !a16.isEmpty()) {
            Iterator<d> it = a16.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.notify(i3, i16, str, objArr);
                }
            }
        }
    }

    public synchronized void c(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
        } else {
            this.f344915b.c(dVar);
        }
    }
}
