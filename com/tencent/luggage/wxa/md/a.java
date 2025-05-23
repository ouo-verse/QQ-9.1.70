package com.tencent.luggage.wxa.md;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static a f134417d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f134418a = false;

    /* renamed from: c, reason: collision with root package name */
    public List f134420c = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public Map f134419b = new HashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.md.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6469a {
        void a(c cVar);

        void b(c cVar);

        void c(c cVar);
    }

    public static a c() {
        if (f134417d == null) {
            synchronized (a.class) {
                if (f134417d == null) {
                    f134417d = new a();
                }
            }
        }
        return f134417d;
    }

    public boolean a(String str) {
        return this.f134419b.containsKey(str);
    }

    public c b(String str) {
        return (c) this.f134419b.get(str);
    }

    public void d() {
        this.f134418a = true;
    }

    public void a(String str, c cVar) {
        boolean z16;
        if (this.f134418a) {
            return;
        }
        int i3 = 0;
        if (this.f134419b.containsKey(str)) {
            c cVar2 = (c) this.f134419b.get(str);
            if (cVar2 != null && cVar2.equals(cVar)) {
                Log.d("DeviceManager", "has device uuid=" + str);
                return;
            }
            z16 = false;
        } else {
            z16 = true;
        }
        Log.d("DeviceManager", "new device uuid=" + str);
        this.f134419b.put(str, cVar);
        while (i3 < this.f134420c.size()) {
            InterfaceC6469a interfaceC6469a = (InterfaceC6469a) this.f134420c.get(i3);
            if (interfaceC6469a != null) {
                if (z16) {
                    interfaceC6469a.c(cVar);
                } else {
                    interfaceC6469a.a(cVar);
                }
                i3++;
            } else {
                this.f134420c.remove(i3);
            }
        }
    }

    public Collection b() {
        return this.f134419b.values();
    }

    public void b(InterfaceC6469a interfaceC6469a) {
        this.f134420c.remove(interfaceC6469a);
    }

    public void c(String str) {
        if (this.f134418a) {
            return;
        }
        c cVar = (c) this.f134419b.remove(str);
        int i3 = 0;
        while (i3 < this.f134420c.size()) {
            InterfaceC6469a interfaceC6469a = (InterfaceC6469a) this.f134420c.get(i3);
            if (interfaceC6469a != null) {
                interfaceC6469a.b(cVar);
                i3++;
            } else {
                this.f134420c.remove(i3);
            }
        }
    }

    public void a(InterfaceC6469a interfaceC6469a) {
        if (this.f134418a || this.f134420c.contains(interfaceC6469a)) {
            return;
        }
        this.f134420c.add(interfaceC6469a);
    }

    public void a() {
        this.f134419b.clear();
        f134417d = null;
    }
}
