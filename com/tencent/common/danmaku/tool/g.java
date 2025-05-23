package com.tencent.common.danmaku.tool;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final a<T> f99793a;

    /* renamed from: b, reason: collision with root package name */
    private final Comparator<T> f99794b;

    /* renamed from: c, reason: collision with root package name */
    private final b f99795c;

    /* renamed from: d, reason: collision with root package name */
    private int f99796d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b<T> {
        int a(T t16, long j3);
    }

    public g(Comparator<T> comparator, b<T> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) comparator, (Object) bVar);
            return;
        }
        this.f99796d = 0;
        this.f99795c = bVar;
        this.f99793a = new a<>();
        this.f99794b = comparator;
    }

    private void c(long j3, List<T> list, a<T> aVar) {
        if (com.tencent.common.danmaku.a.b().a().isDebug()) {
            if ((list == null || list.isEmpty()) && !e()) {
                T t16 = aVar.f99797a;
                if (t16 instanceof com.tencent.common.danmaku.data.a) {
                    Math.abs(((com.tencent.common.danmaku.data.a) t16).H() - j3);
                }
            }
        }
    }

    public boolean a(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16)).booleanValue();
        }
        if (t16 == null) {
            return false;
        }
        a<T> aVar = this.f99793a.f99798b;
        while (aVar != this.f99793a && this.f99794b.compare(aVar.f99797a, t16) < 0) {
            aVar = aVar.f99798b;
        }
        if (t16.equals(aVar.f99797a)) {
            return false;
        }
        a<T> aVar2 = new a<>(t16, aVar, aVar.f99799c);
        aVar.f99799c.f99798b = aVar2;
        aVar.f99799c = aVar2;
        this.f99796d++;
        return true;
    }

    public boolean b(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16)).booleanValue();
        }
        if (t16 == null) {
            return false;
        }
        a<T> aVar = this.f99793a.f99799c;
        while (aVar != this.f99793a && this.f99794b.compare(aVar.f99797a, t16) > 0) {
            aVar = aVar.f99799c;
        }
        if (t16.equals(aVar.f99797a)) {
            return false;
        }
        a<T> aVar2 = new a<>(t16, aVar.f99798b, aVar);
        aVar.f99798b.f99799c = aVar2;
        aVar.f99798b = aVar2;
        this.f99796d++;
        return true;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a<T> aVar = this.f99793a;
        aVar.f99798b = aVar;
        aVar.f99799c = aVar;
        this.f99796d = 0;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        a<T> aVar = this.f99793a;
        if (aVar.f99798b == aVar) {
            return true;
        }
        return false;
    }

    public T f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        a<T> aVar = this.f99793a;
        a<T> aVar2 = aVar.f99799c;
        if (aVar2 != aVar) {
            return aVar2.f99797a;
        }
        return null;
    }

    public List<T> g(long j3, List<T> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), list, Integer.valueOf(i3));
        }
        a<T> aVar = this.f99793a.f99798b;
        while (i16 < i3 && aVar != this.f99793a && this.f99795c.a(aVar.f99797a, j3) <= 0) {
            if (list != null) {
                list.add(aVar.f99797a);
                i16++;
            }
            this.f99796d--;
            aVar = aVar.f99798b;
        }
        c(j3, list, aVar);
        a<T> aVar2 = this.f99793a;
        aVar2.f99798b = aVar;
        aVar.f99799c = aVar2;
        return list;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f99796d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final T f99797a;

        /* renamed from: b, reason: collision with root package name */
        public a<T> f99798b;

        /* renamed from: c, reason: collision with root package name */
        public a<T> f99799c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f99797a = null;
            this.f99798b = this;
            this.f99799c = this;
        }

        public a(T t16, a<T> aVar, a<T> aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, t16, aVar, aVar2);
                return;
            }
            this.f99797a = t16;
            this.f99798b = aVar;
            this.f99799c = aVar2;
        }
    }
}
