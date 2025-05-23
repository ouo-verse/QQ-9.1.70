package com.tencent.cache.core.size.graph;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class e<K, V> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<WeakReference<K>, V> f98801a;

    /* renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<K> f98802b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a<T> {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b<T> extends WeakReference<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f98803a;

        public b(T t16, ReferenceQueue<T> referenceQueue) {
            super(t16, referenceQueue);
            int identityHashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16, (Object) referenceQueue);
                return;
            }
            if (t16 == null) {
                identityHashCode = 0;
            } else {
                identityHashCode = System.identityHashCode(t16);
            }
            this.f98803a = identityHashCode;
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            T t16 = get();
            if (t16 != null && t16 == bVar.get()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f98803a;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return String.valueOf(get());
        }
    }

    public e(a<V> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f98801a = new ConcurrentHashMap();
            this.f98802b = new ReferenceQueue<>();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        while (true) {
            Reference<? extends K> poll = this.f98802b.poll();
            if (poll != null) {
                this.f98801a.remove(poll);
            } else {
                return;
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        a();
        return this.f98801a.toString();
    }
}
