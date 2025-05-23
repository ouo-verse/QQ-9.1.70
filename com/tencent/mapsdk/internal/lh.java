package com.tencent.mapsdk.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class lh<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f149191a;

    /* renamed from: b, reason: collision with root package name */
    private int f149192b;

    /* renamed from: c, reason: collision with root package name */
    private int f149193c;

    /* renamed from: d, reason: collision with root package name */
    private int f149194d;

    /* renamed from: e, reason: collision with root package name */
    private int f149195e;

    /* renamed from: f, reason: collision with root package name */
    private int f149196f;

    /* renamed from: g, reason: collision with root package name */
    private int f149197g;

    /* renamed from: h, reason: collision with root package name */
    private int f149198h;

    public lh(int i3) {
        if (i3 > 0) {
            this.f149193c = i3;
            this.f149191a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private static V e() {
        return null;
    }

    private synchronized int f() {
        return this.f149197g;
    }

    private synchronized int g() {
        return this.f149198h;
    }

    private synchronized int h() {
        return this.f149195e;
    }

    private synchronized int i() {
        return this.f149194d;
    }

    private synchronized int j() {
        return this.f149196f;
    }

    protected int a(V v3) {
        return 1;
    }

    public final V b(K k3) {
        if (k3 != null) {
            synchronized (this) {
                V v3 = this.f149191a.get(k3);
                if (v3 != null) {
                    this.f149197g++;
                    return v3;
                }
                this.f149198h++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V c(K k3) {
        V remove;
        if (k3 != null) {
            synchronized (this) {
                remove = this.f149191a.remove(k3);
                if (remove != null) {
                    this.f149192b -= b(k3, remove);
                }
            }
            if (remove != null) {
                a(false, k3, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized Map<K, V> d() {
        return new LinkedHashMap(this.f149191a);
    }

    public final synchronized String toString() {
        int i3;
        int i16 = this.f149197g;
        int i17 = this.f149198h + i16;
        if (i17 != 0) {
            i3 = (i16 * 100) / i17;
        } else {
            i3 = 0;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f149193c), Integer.valueOf(this.f149197g), Integer.valueOf(this.f149198h), Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z16, K k3, V v3, V v16) {
    }

    public final void a(int i3) {
        if (i3 > 0) {
            synchronized (this) {
                this.f149193c = i3;
            }
            b(i3);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0071, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i3) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f149192b >= 0 && (!this.f149191a.isEmpty() || this.f149192b == 0)) {
                    if (this.f149192b <= i3 || this.f149191a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f149191a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f149191a.remove(key);
                    this.f149192b -= b(key, value);
                    this.f149196f++;
                } else {
                    break;
                }
            }
            a(true, key, value, null);
        }
    }

    public final synchronized int c() {
        return this.f149193c;
    }

    public final V a(K k3, V v3) {
        V put;
        if (k3 != null && v3 != null) {
            synchronized (this) {
                this.f149194d++;
                this.f149192b += b(k3, v3);
                put = this.f149191a.put(k3, v3);
                if (put != null) {
                    this.f149192b -= b(k3, put);
                }
            }
            if (put != null) {
                a(false, k3, put, v3);
            }
            b(this.f149193c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final void a() {
        b(-1);
    }

    private int b(K k3, V v3) {
        int a16 = a((lh<K, V>) v3);
        if (a16 >= 0) {
            return a16;
        }
        throw new IllegalStateException("Negative size: " + k3 + ContainerUtils.KEY_VALUE_DELIMITER + v3);
    }

    public final synchronized int b() {
        return this.f149192b;
    }
}
