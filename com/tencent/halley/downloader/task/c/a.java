package com.tencent.halley.downloader.task.c;

import android.text.TextUtils;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<C1248a> f113852a;

    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.task.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1248a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f113853a;

        /* renamed from: b, reason: collision with root package name */
        int f113854b;

        /* renamed from: c, reason: collision with root package name */
        String f113855c;

        public C1248a(long j3, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), str);
                return;
            }
            this.f113853a = j3;
            this.f113854b = i3;
            if (TextUtils.isEmpty(str)) {
                this.f113855c = "";
            } else {
                this.f113855c = j.b(str);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113852a = new ArrayList();
        }
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        synchronized (this.f113852a) {
            if (this.f113852a.size() == 0) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            for (C1248a c1248a : this.f113852a) {
                sb5.append(c1248a.f113853a + "," + c1248a.f113854b + "," + c1248a.f113855c);
                sb5.append(";");
            }
            return sb5.toString();
        }
    }

    public final void a(C1248a c1248a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) c1248a);
            return;
        }
        synchronized (this.f113852a) {
            if (this.f113852a.size() < 20) {
                this.f113852a.add(c1248a);
            }
        }
    }
}
