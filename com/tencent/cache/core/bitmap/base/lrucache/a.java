package com.tencent.cache.core.bitmap.base.lrucache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.cache.core.bitmap.base.lrucache.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a<K extends c, V> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final C1002a<K, V> f98641a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<K, C1002a<K, V>> f98642b;

    /* compiled from: P */
    /* renamed from: com.tencent.cache.core.bitmap.base.lrucache.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1002a<K, V> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final K f98643a;

        /* renamed from: b, reason: collision with root package name */
        public List<V> f98644b;

        /* renamed from: c, reason: collision with root package name */
        public C1002a<K, V> f98645c;

        /* renamed from: d, reason: collision with root package name */
        public C1002a<K, V> f98646d;

        public C1002a() {
            this(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Nullable
        public V a() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (V) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            List<V> list = this.f98644b;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                return this.f98644b.remove(i3 - 1);
            }
            return null;
        }

        public C1002a(K k3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) k3);
                return;
            }
            this.f98646d = this;
            this.f98645c = this;
            this.f98643a = k3;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f98641a = new C1002a<>();
            this.f98642b = new HashMap();
        }
    }

    @NonNull
    public String toString() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("GroupedLinkedMap( ");
        C1002a c1002a = this.f98641a.f98645c;
        boolean z16 = false;
        while (!c1002a.equals(this.f98641a)) {
            sb5.append('{');
            sb5.append(c1002a.f98643a);
            sb5.append(':');
            List<V> list = c1002a.f98644b;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append("}, ");
            c1002a = c1002a.f98645c;
            z16 = true;
        }
        if (z16) {
            sb5.delete(sb5.length() - 2, sb5.length());
        }
        sb5.append(" )");
        return sb5.toString();
    }
}
