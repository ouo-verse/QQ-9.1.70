package com.tencent.mobileqq.troop.troopcatalog;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f299959a;

    /* renamed from: b, reason: collision with root package name */
    public String f299960b;

    /* renamed from: c, reason: collision with root package name */
    public String f299961c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<a> f299962d;

    /* renamed from: e, reason: collision with root package name */
    public a f299963e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f299964f;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f299962d = new ArrayList<>();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String c() {
        return "fakeId:" + hashCode();
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f299962d.add(aVar);
        }
    }

    public boolean b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        ArrayList<a> arrayList = this.f299962d;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<a> it = this.f299962d.iterator();
            while (it.hasNext()) {
                if (it.next().f299961c.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = this.f299960b;
        a aVar = this;
        while (true) {
            aVar = aVar.f299963e;
            if (aVar != null) {
                str = aVar.f299960b + "-" + str;
            } else {
                return str;
            }
        }
    }

    public boolean e(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar)).booleanValue();
        }
        if (aVar != null && aVar.f299959a + 1 == this.f299959a) {
            this.f299963e = aVar;
            return true;
        }
        return false;
    }

    public a(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
            return;
        }
        this.f299962d = new ArrayList<>();
        this.f299959a = i3;
        if (TextUtils.isEmpty(str)) {
            this.f299961c = c();
        } else {
            this.f299961c = str;
        }
        this.f299960b = str2;
    }
}
