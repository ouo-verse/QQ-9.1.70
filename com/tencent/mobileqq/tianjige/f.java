package com.tencent.mobileqq.tianjige;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, h> f292948a;

    /* renamed from: b, reason: collision with root package name */
    private static Map<Integer, i> f292949b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43695);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f292948a = new ArrayMap();
            f292949b = new ArrayMap();
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static i a() {
        return d(3);
    }

    public static i b() {
        return d(2);
    }

    public static h c(int i3) {
        h hVar = f292948a.get(Integer.valueOf(i3));
        if (hVar == null) {
            synchronized (f.class) {
                hVar = f292948a.get(Integer.valueOf(i3));
                if (hVar == null) {
                    hVar = new h(i3);
                    f292948a.put(Integer.valueOf(i3), hVar);
                }
            }
        }
        return hVar;
    }

    public static i d(int i3) {
        i iVar = f292949b.get(Integer.valueOf(i3));
        if (iVar == null) {
            synchronized (f.class) {
                iVar = f292949b.get(Integer.valueOf(i3));
                if (iVar == null) {
                    iVar = new i(c(i3));
                    f292949b.put(Integer.valueOf(i3), iVar);
                }
            }
        }
        return iVar;
    }

    public static void e(int i3, a aVar) {
        d(i3).p(aVar);
    }

    public static void f(int i3) {
        d(i3).f();
    }

    public static void g(int i3) {
        d(i3).q();
    }
}
