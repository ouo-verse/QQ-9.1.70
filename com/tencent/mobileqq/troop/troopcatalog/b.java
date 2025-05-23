package com.tencent.mobileqq.troop.troopcatalog;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopcreate.classify.detail.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    protected static Object f299965c;

    /* renamed from: d, reason: collision with root package name */
    protected static b f299966d;

    /* renamed from: a, reason: collision with root package name */
    protected a f299967a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<a> f299968b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29231);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f299965c = new Object();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f299968b = new ArrayList<>(0);
        }
    }

    private a a(a aVar, String str) {
        if (!aVar.f299961c.equals(str)) {
            ArrayList<a> arrayList = aVar.f299962d;
            a aVar2 = null;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<a> it = aVar.f299962d.iterator();
                while (it.hasNext() && (aVar2 = a(it.next(), str)) == null) {
                }
            }
            return aVar2;
        }
        return aVar;
    }

    private ArrayList<a> e(ArrayList<a> arrayList, String str) {
        ArrayList<a> arrayList2 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            ArrayList<a> arrayList3 = next.f299962d;
            if (arrayList3 != null && arrayList3.size() > 0) {
                if (next.f299961c.equals(str)) {
                    return next.f299962d;
                }
                arrayList2 = e(next.f299962d, str);
                if (arrayList2 != null) {
                    return arrayList2;
                }
            }
        }
        return arrayList2;
    }

    public static b g() {
        synchronized (f299965c) {
            if (f299966d == null) {
                f299966d = new b();
            }
        }
        return f299966d;
    }

    private ArrayList<a> i() {
        if (this.f299968b.isEmpty()) {
            this.f299968b = g.e("GroupCatalogTool");
        }
        return this.f299968b;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f299968b != null) {
            synchronized (f299965c) {
                this.f299968b.clear();
            }
        }
        this.f299967a = null;
    }

    public a c(String str) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        synchronized (f299965c) {
            Iterator<a> it = i().iterator();
            aVar = null;
            while (it.hasNext() && (aVar = a(it.next(), str)) == null) {
            }
        }
        return aVar;
    }

    public ArrayList<a> d(String str) {
        ArrayList<a> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        synchronized (f299965c) {
            e16 = e(i(), str);
        }
        return e16;
    }

    public ArrayList<a> f() {
        ArrayList<a> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        synchronized (f299965c) {
            arrayList = new ArrayList<>(Arrays.asList(new a[this.f299968b.size()]));
            Collections.copy(arrayList, this.f299968b);
        }
        return arrayList;
    }

    public a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f299967a;
    }

    public void j(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f299967a = aVar;
        }
    }
}
