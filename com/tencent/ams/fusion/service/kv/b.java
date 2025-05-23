package com.tencent.ams.fusion.service.kv;

import com.tencent.ams.fusion.a.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f70301b;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<a> f70302a;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b b() {
        if (f70301b == null) {
            synchronized (b.class) {
                if (f70301b == null) {
                    f70301b = new b();
                }
            }
        }
        return f70301b;
    }

    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        WeakReference<a> weakReference = this.f70302a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int c(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, str, str2, Integer.valueOf(i3))).intValue();
        }
        a a16 = a();
        if (a16 != null) {
            return a16.getInt(str, str2, i3);
        }
        return i3;
    }

    public long d(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, this, str, str2, Long.valueOf(j3))).longValue();
        }
        a a16 = a();
        if (a16 != null) {
            f.a("AdKVDataHelper getLong key:" + str2);
            return a16.getLong(str, str2, j3);
        }
        return j3;
    }

    public String e(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, this, str, str2, str3);
        }
        a a16 = a();
        if (a16 != null) {
            return a16.getString(str, str2, str3);
        }
        return str3;
    }

    public Set<String> f(String str, String str2, Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Set) iPatchRedirector.redirect((short) 14, this, str, str2, set);
        }
        a a16 = a();
        if (a16 != null) {
            f.a("AdKVDataHelper getLong key:" + str2);
            return a16.a(str, str2, set);
        }
        return set;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (a() != null) {
            return true;
        }
        return false;
    }

    public void h(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3));
            return;
        }
        a a16 = a();
        if (a16 != null) {
            f.a("AdKVDataHelper putInt key:" + str2 + ", value:" + i3);
            a16.putInt(str, str2, i3);
        }
    }

    public void i(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, Long.valueOf(j3));
            return;
        }
        a a16 = a();
        if (a16 != null) {
            f.a("AdKVDataHelper putLong key:" + str2 + ", value:" + j3);
            a16.putLong(str, str2, j3);
        }
    }

    public void j(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, str3);
            return;
        }
        a a16 = a();
        if (a16 != null) {
            f.a("AdKVDataHelper putString key:" + str2 + ", value:" + str3);
            a16.putString(str, str2, str3);
        }
    }

    public void k(String str, String str2, Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, set);
            return;
        }
        a a16 = a();
        if (a16 != null) {
            f.a("AdKVDataHelper putStringSet key:" + str2 + ", value:" + set);
            a16.b(str, str2, set);
        }
    }

    public void l(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
            return;
        }
        a a16 = a();
        if (a16 != null) {
            f.a("AdKVDataHelper removeKey key:" + str2);
            a16.c(str, str2);
        }
    }

    public void m(WeakReference<a> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) weakReference);
        } else {
            this.f70302a = weakReference;
        }
    }
}
