package com.tencent.wcdb.support;

import android.annotation.SuppressLint;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b<K, V> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f384442a;

    /* renamed from: b, reason: collision with root package name */
    private int f384443b;

    /* renamed from: c, reason: collision with root package name */
    private int f384444c;

    /* renamed from: d, reason: collision with root package name */
    private int f384445d;

    /* renamed from: e, reason: collision with root package name */
    private int f384446e;

    /* renamed from: f, reason: collision with root package name */
    private int f384447f;

    /* renamed from: g, reason: collision with root package name */
    private int f384448g;

    /* renamed from: h, reason: collision with root package name */
    private int f384449h;

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            if (i3 > 0) {
                this.f384444c = i3;
                this.f384442a = new LinkedHashMap<>(0, 0.75f, true);
                return;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    private int h(K k3, V v3) {
        int i3 = i(k3, v3);
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalStateException("Negative size: " + k3 + ContainerUtils.KEY_VALUE_DELIMITER + v3);
    }

    protected V a(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (V) iPatchRedirector.redirect((short) 8, (Object) this, (Object) k3);
        }
        return null;
    }

    protected void b(boolean z16, K k3, V v3, V v16) {
        throw null;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            j(-1);
        }
    }

    public final V d(K k3) {
        V v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (V) iPatchRedirector.redirect((short) 3, (Object) this, (Object) k3);
        }
        if (k3 != null) {
            synchronized (this) {
                V v16 = this.f384442a.get(k3);
                if (v16 != null) {
                    this.f384448g++;
                    return v16;
                }
                this.f384449h++;
                V a16 = a(k3);
                if (a16 == null) {
                    return null;
                }
                synchronized (this) {
                    this.f384446e++;
                    v3 = (V) this.f384442a.put(k3, a16);
                    if (v3 != null) {
                        this.f384442a.put(k3, v3);
                    } else {
                        this.f384443b += h(k3, a16);
                    }
                }
                if (v3 != null) {
                    b(false, k3, a16, v3);
                    return v3;
                }
                j(this.f384444c);
                return a16;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V e(K k3, V v3) {
        V put;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3, (Object) v3);
        }
        if (k3 != null && v3 != null) {
            synchronized (this) {
                this.f384445d++;
                this.f384443b += h(k3, v3);
                put = this.f384442a.put(k3, v3);
                if (put != null) {
                    this.f384443b -= h(k3, put);
                }
            }
            if (put != null) {
                b(false, k3, put, v3);
            }
            j(this.f384444c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final V f(K k3) {
        V remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (V) iPatchRedirector.redirect((short) 6, (Object) this, (Object) k3);
        }
        if (k3 != null) {
            synchronized (this) {
                remove = this.f384442a.remove(k3);
                if (remove != null) {
                    this.f384443b -= h(k3, remove);
                }
            }
            if (remove != null) {
                b(false, k3, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            if (i3 > 0) {
                synchronized (this) {
                    this.f384444c = i3;
                }
                j(i3);
                return;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    protected int i(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) k3, (Object) v3)).intValue();
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0076, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(int i3) {
        Map.Entry<K, V> entry;
        K key;
        V value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        while (true) {
            synchronized (this) {
                if (this.f384443b >= 0 && (!this.f384442a.isEmpty() || this.f384443b == 0)) {
                    if (this.f384443b <= i3 || this.f384442a.isEmpty()) {
                        break;
                    }
                    if (this.f384442a.entrySet().iterator().hasNext()) {
                        entry = this.f384442a.entrySet().iterator().next();
                    } else {
                        entry = null;
                    }
                    if (entry != null) {
                        key = entry.getKey();
                        value = entry.getValue();
                        this.f384442a.remove(key);
                        this.f384443b -= h(key, value);
                        this.f384447f++;
                    } else {
                        return;
                    }
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @SuppressLint({"DefaultLocale"})
    public final synchronized String toString() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        int i16 = this.f384448g;
        int i17 = this.f384449h + i16;
        if (i17 != 0) {
            i3 = (i16 * 100) / i17;
        } else {
            i3 = 0;
        }
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f384444c), Integer.valueOf(this.f384448g), Integer.valueOf(this.f384449h), Integer.valueOf(i3));
    }
}
