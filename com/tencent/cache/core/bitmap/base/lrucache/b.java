package com.tencent.cache.core.bitmap.base.lrucache;

import android.annotation.SuppressLint;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.cache.core.util.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b<K, V> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f98647a;

    /* renamed from: b, reason: collision with root package name */
    private int f98648b;

    /* renamed from: c, reason: collision with root package name */
    private int f98649c;

    /* renamed from: d, reason: collision with root package name */
    private int f98650d;

    /* renamed from: e, reason: collision with root package name */
    private int f98651e;

    /* renamed from: f, reason: collision with root package name */
    private int f98652f;

    /* renamed from: g, reason: collision with root package name */
    private int f98653g;

    /* renamed from: h, reason: collision with root package name */
    private int f98654h;

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            if (i3 > 0) {
                this.f98649c = i3;
                this.f98647a = new LinkedHashMap<>(0, 0.75f, true);
                return;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    private int m(K k3, V v3, boolean z16) {
        int o16 = o(k3, v3, z16);
        if (o16 >= 0) {
            return o16;
        }
        throw new IllegalStateException("Negative size: " + k3 + ContainerUtils.KEY_VALUE_DELIMITER + v3);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.f98647a.size();
    }

    public V b(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (V) iPatchRedirector.redirect((short) 10, (Object) this, (Object) k3);
        }
        return null;
    }

    public void c(boolean z16, K k3, V v3, V v16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), k3, v3, v16);
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            r(-1);
        }
    }

    public final V e(K k3) {
        V v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (V) iPatchRedirector.redirect((short) 3, (Object) this, (Object) k3);
        }
        if (k3 != null) {
            synchronized (this) {
                V v16 = this.f98647a.get(k3);
                if (v16 != null) {
                    this.f98653g++;
                    return v16;
                }
                this.f98654h++;
                V b16 = b(k3);
                if (b16 == null) {
                    return null;
                }
                synchronized (this) {
                    this.f98651e++;
                    v3 = (V) this.f98647a.put(k3, b16);
                    if (v3 != null) {
                        this.f98647a.put(k3, v3);
                    } else {
                        this.f98648b += m(k3, b16, true);
                    }
                }
                if (v3 != null) {
                    c(false, k3, b16, v3);
                    return v3;
                }
                r(this.f98649c);
                return b16;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.f98653g;
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        int i16 = this.f98648b - i3;
        this.f98648b = i16;
        if (i16 < 0) {
            this.f98648b = 0;
        }
    }

    public final synchronized int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.f98654h;
    }

    public final V i(K k3, V v3) {
        V put;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3, (Object) v3);
        }
        if (k3 != null && v3 != null) {
            synchronized (this) {
                this.f98650d++;
                this.f98648b += m(k3, v3, true);
                put = this.f98647a.put(k3, v3);
                if (put != null) {
                    g(m(k3, put, false));
                }
            }
            if (put != null) {
                c(false, k3, put, v3);
            }
            r(this.f98649c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final V j(K k3) {
        V remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (V) iPatchRedirector.redirect((short) 8, (Object) this, (Object) k3);
        }
        if (k3 != null) {
            synchronized (this) {
                remove = this.f98647a.remove(k3);
                if (remove != null) {
                    g(m(k3, remove, false));
                }
            }
            if (remove != null) {
                c(false, k3, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V k(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (V) iPatchRedirector.redirect((short) 7, (Object) this, obj);
        }
        if (obj != 0) {
            return j(obj);
        }
        throw new NullPointerException("key == null");
    }

    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            if (i3 > 0) {
                synchronized (this) {
                    this.f98649c = i3;
                }
                r(i3);
                return;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    public final synchronized int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f98648b;
    }

    public int o(K k3, V v3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return 1;
        }
        return ((Integer) iPatchRedirector.redirect((short) 11, this, k3, v3, Boolean.valueOf(z16))).intValue();
    }

    public final synchronized Map<K, V> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Map) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return new LinkedHashMap(this.f98647a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Pair<Integer, Integer> q(int i3, Set<String> set) {
        String joinToString$default;
        String joinToString$default2;
        Map.Entry<K, V> next;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Pair) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) set);
        }
        Iterator<Map.Entry<K, V>> it = this.f98647a.entrySet().iterator();
        ArrayList removed = new ArrayList();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i18 = this.f98648b;
            if (i18 < 0) {
                this.f98648b = 0;
                com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
                StringBuilder a16 = com.tencent.cache.api.collection.c.a("size < 0 happen, size:");
                a16.append(this.f98648b);
                bVar.h("MemoryControl_LruCache", 1, a16.toString());
                break;
            }
            if (i18 <= i3 || this.f98647a.isEmpty() || (next = it.next()) == null) {
                break;
            }
            K key = next.getKey();
            V value = next.getValue();
            int m3 = m(key, value, false);
            if ((value instanceof com.tencent.cache.core.bitmap.cache.b) && set.contains(((com.tencent.cache.core.bitmap.cache.b) value).f98665g)) {
                i16 += m3;
            } else {
                it.remove();
                if (com.tencent.cache.core.util.b.f98831d) {
                    removed.add(value);
                }
                this.f98652f++;
                i17 = Math.min(this.f98648b, m3) + i17;
                g(m3);
                c(true, key, value, null);
            }
        }
        if (!removed.isEmpty()) {
            com.tencent.cache.core.util.b bVar2 = com.tencent.cache.core.util.b.f98833f;
            Intrinsics.checkNotNullParameter(removed, "removed");
            if (com.tencent.cache.core.util.b.f98831d) {
                StringBuilder a17 = com.tencent.cache.api.collection.c.a("removed Detail Info, ");
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(removed, null, null, null, 0, null, com.tencent.cache.core.util.c.f98834a, 31, null);
                a17.append(joinToString$default);
                bVar2.d("GlobalImageCache", 1, a17.toString());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it5 = removed.iterator();
                while (it5.hasNext()) {
                    Object next2 = it5.next();
                    String str = ((com.tencent.cache.core.bitmap.cache.b) next2).f98665g;
                    Object obj = linkedHashMap.get(str);
                    if (obj == null) {
                        obj = new ArrayList();
                        linkedHashMap.put(str, obj);
                    }
                    ((List) obj).add(next2);
                }
                joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(linkedHashMap.entrySet(), null, null, null, 0, null, d.f98835a, 31, null);
                bVar2.d("GlobalImageCache", 1, "removed Detail Info grouped, " + joinToString$default2);
            }
        }
        return new Pair<>(Integer.valueOf(i17), Integer.valueOf(i16));
    }

    public void r(int i3) {
        Map.Entry<K, V> next;
        K key;
        V value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        while (true) {
            synchronized (this) {
                int i16 = this.f98648b;
                if (i16 < 0) {
                    this.f98648b = 0;
                    com.tencent.cache.core.util.b.f98833f.h("MemoryControl_LruCache", 1, "size < 0 happen, size:" + this.f98648b);
                    break;
                }
                if (i16 <= i3 || this.f98647a.isEmpty() || (next = this.f98647a.entrySet().iterator().next()) == null) {
                    break;
                }
                key = next.getKey();
                value = next.getValue();
                this.f98647a.remove(key);
                g(m(key, value, false));
                this.f98652f++;
            }
            c(true, key, value, null);
        }
    }

    public synchronized void s(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            this.f98648b += i3;
        } else {
            g(i3);
        }
    }

    @NonNull
    @SuppressLint({"DefaultLocale"})
    public final synchronized String toString() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        int i16 = this.f98653g;
        int i17 = this.f98654h + i16;
        if (i17 != 0) {
            i3 = (i16 * 100) / i17;
        } else {
            i3 = 0;
        }
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f98649c), Integer.valueOf(this.f98653g), Integer.valueOf(this.f98654h), Integer.valueOf(i3));
    }
}
