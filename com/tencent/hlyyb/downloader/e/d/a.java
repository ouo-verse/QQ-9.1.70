package com.tencent.hlyyb.downloader.e.d;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<C5820a> f114492a;

    /* compiled from: P */
    /* renamed from: com.tencent.hlyyb.downloader.e.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C5820a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f114497a;

        /* renamed from: b, reason: collision with root package name */
        public int f114498b;

        /* renamed from: c, reason: collision with root package name */
        public String f114499c;

        public C5820a(long j3, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), str);
                return;
            }
            this.f114497a = j3;
            this.f114498b = i3;
            if (TextUtils.isEmpty(str)) {
                this.f114499c = "";
            } else {
                this.f114499c = com.tencent.hlyyb.common.b.b.b(str);
            }
        }

        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f114497a + "," + this.f114498b + "," + this.f114499c;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f114492a = new ArrayList();
        }
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        synchronized (this.f114492a) {
            if (this.f114492a.size() == 0) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator<C5820a> it = this.f114492a.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().a());
                sb5.append(";");
            }
            return sb5.toString();
        }
    }

    public final void a(C5820a c5820a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) c5820a);
            return;
        }
        synchronized (this.f114492a) {
            if (this.f114492a.size() < 20) {
                this.f114492a.add(c5820a);
            }
        }
    }
}
