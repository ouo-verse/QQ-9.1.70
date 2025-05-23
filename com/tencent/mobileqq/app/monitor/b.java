package com.tencent.mobileqq.app.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<C7385b> f196290a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, c> f196291b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f196292c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements Comparator<c> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2)).intValue();
            }
            return cVar2.f196297b - cVar.f196297b;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.monitor.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C7385b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f196294a;

        /* renamed from: b, reason: collision with root package name */
        public String f196295b;

        public C7385b(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str);
            } else {
                this.f196294a = j3;
                this.f196295b = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f196296a;

        /* renamed from: b, reason: collision with root package name */
        public int f196297b;

        public c(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, str, Integer.valueOf(i3));
            } else {
                this.f196296a = str;
                this.f196297b = i3;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "RecorderJobItem{jobKey='" + this.f196296a + "', count=" + this.f196297b + '}';
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f196290a = new ArrayList();
        this.f196291b = new HashMap();
        this.f196292c = new Object();
    }

    private void b(String str) {
        c cVar = this.f196291b.get(str);
        if (cVar == null) {
            this.f196291b.put(str, new c(str, 1));
        } else {
            cVar.f196297b++;
        }
        this.f196290a.add(new C7385b(System.currentTimeMillis(), str));
    }

    private void c() {
        this.f196290a.clear();
        this.f196291b.clear();
    }

    private void d(long j3) {
        Iterator<C7385b> it = this.f196290a.iterator();
        while (it.hasNext()) {
            C7385b next = it.next();
            if (Math.abs(System.currentTimeMillis() - next.f196294a) > j3) {
                it.remove();
                f(next.f196295b);
            } else {
                return;
            }
        }
    }

    private c e() {
        ArrayList arrayList = new ArrayList(this.f196291b.values());
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList, new a());
        return (c) arrayList.get(0);
    }

    private void f(String str) {
        c cVar = this.f196291b.get(str);
        if (cVar != null) {
            int i3 = cVar.f196297b - 1;
            cVar.f196297b = i3;
            if (i3 < 1) {
                this.f196291b.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        synchronized (this.f196292c) {
            try {
                try {
                    b(str);
                    d(i3);
                    c e16 = e();
                    if (e16 != null && e16.f196297b >= i16) {
                        c();
                        return e16;
                    }
                } catch (Exception e17) {
                    QLog.e("ThreadPoolMonitorJobHighFreqRecorder", 1, "addAndCheckHighFreq error", e17);
                }
                return null;
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }
}
