package com.tencent.halley.common.d.b.a;

import com.tencent.halley.common.d.i;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f113473a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f113474b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18691);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f113473a = null;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113474b = new LinkedHashMap<String, String>() { // from class: com.tencent.halley.common.d.b.a.b.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
                    }
                }

                @Override // java.util.LinkedHashMap
                protected final boolean removeEldestEntry(Map.Entry<String, String> entry) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) entry)).booleanValue();
                    }
                    if (size() > 8) {
                        return true;
                    }
                    return false;
                }
            };
            a(i.b(c(), "", true), false);
        }
    }

    public static b a() {
        if (f113473a == null) {
            synchronized (b.class) {
                if (f113473a == null) {
                    f113473a = new b();
                }
            }
        }
        return f113473a;
    }

    private static String c() {
        return "HalleyOperInfo_" + com.tencent.halley.common.a.c();
    }

    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        synchronized (this.f113474b) {
            ArrayList arrayList = new ArrayList(this.f113474b.keySet());
            ArrayList arrayList2 = new ArrayList(this.f113474b.values());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = (String) arrayList.get(i3);
                String str2 = (String) arrayList2.get(i3);
                sb5.append(str);
                sb5.append("h,l");
                sb5.append(str2);
                sb5.append("h;l");
            }
        }
        return sb5.toString();
    }

    public final String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (j.a(str) || "unknown".equals(str)) {
            return "";
        }
        synchronized (this.f113474b) {
            String str2 = this.f113474b.get(str);
            return !j.a(str2) ? str2 : "";
        }
    }

    public final void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (j.a(str) || "unknown".equals(str) || j.a(str2) || "unknown".equals(str2)) {
            return;
        }
        synchronized (this.f113474b) {
            if (!str2.equals(this.f113474b.get(str))) {
                this.f113474b.put(str, str2);
                i.a(c(), b(), true);
            }
        }
    }

    public final void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            return;
        }
        try {
            if (j.a(str)) {
                return;
            }
            synchronized (this.f113474b) {
                this.f113474b.clear();
                String[] split = str.split("h;l");
                if (split != null) {
                    for (String str2 : split) {
                        String[] split2 = str2.split("h,l");
                        if (split2.length == 2) {
                            this.f113474b.put(split2[0], split2[1]);
                        }
                    }
                }
            }
            if (z16) {
                i.a(c(), str, true);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
