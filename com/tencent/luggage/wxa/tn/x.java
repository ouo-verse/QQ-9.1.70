package com.tencent.luggage.wxa.tn;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f141755a;

    /* renamed from: b, reason: collision with root package name */
    public int f141756b;

    /* renamed from: c, reason: collision with root package name */
    public int f141757c;

    /* renamed from: d, reason: collision with root package name */
    public int f141758d;

    /* renamed from: e, reason: collision with root package name */
    public int f141759e;

    /* renamed from: f, reason: collision with root package name */
    public int f141760f;

    /* renamed from: g, reason: collision with root package name */
    public int f141761g;

    /* renamed from: h, reason: collision with root package name */
    public int f141762h;

    public x(int i3) {
        if (i3 > 0) {
            this.f141757c = i3;
            this.f141755a = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public void a(boolean z16, Object obj, Object obj2, Object obj3) {
    }

    public int b(Object obj, Object obj2) {
        return 1;
    }

    public Object c(Object obj) {
        return null;
    }

    public final Object get(Object obj) {
        Object put;
        if (obj == null) {
            w.b("MicroMsg.LruMap", "key == null %s", w0.b().toString());
            return null;
        }
        synchronized (this) {
            Object obj2 = this.f141755a.get(obj);
            if (obj2 != null) {
                this.f141761g++;
                return obj2;
            }
            this.f141762h++;
            Object c16 = c(obj);
            if (c16 == null) {
                return null;
            }
            synchronized (this) {
                this.f141759e++;
                put = this.f141755a.put(obj, c16);
                if (put != null) {
                    this.f141755a.put(obj, put);
                } else {
                    this.f141756b += a(obj, c16);
                }
            }
            if (put != null) {
                a(false, obj, c16, put);
                return put;
            }
            a(this.f141757c);
            return c16;
        }
    }

    public Set keySet() {
        return this.f141755a.keySet();
    }

    public final Object put(Object obj, Object obj2) {
        Object put;
        if (obj == null || obj2 == null) {
            w.b("MicroMsg.LruMap", "put key == null or value == null [%s, %s], %s", obj, obj2, w0.b().toString());
        }
        synchronized (this) {
            this.f141758d++;
            this.f141756b += a(obj, obj2);
            put = this.f141755a.put(obj, obj2);
            if (put != null) {
                this.f141756b -= a(obj, put);
            }
        }
        if (put != null) {
            a(false, obj, put, obj2);
        }
        a(this.f141757c);
        return put;
    }

    public final Object remove(Object obj) {
        Object remove;
        if (obj != null) {
            synchronized (this) {
                remove = this.f141755a.remove(obj);
                if (remove != null) {
                    this.f141756b -= a(obj, remove);
                }
            }
            if (remove != null) {
                a(false, obj, remove, null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public final synchronized int size() {
        return this.f141756b;
    }

    public final synchronized String toString() {
        int i3;
        int i16 = this.f141761g;
        int i17 = this.f141762h + i16;
        if (i17 != 0) {
            i3 = (i16 * 100) / i17;
        } else {
            i3 = 0;
        }
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f141757c), Integer.valueOf(this.f141761g), Integer.valueOf(this.f141762h), Integer.valueOf(i3));
    }

    public synchronized boolean a(Object obj) {
        return this.f141755a.containsKey(obj);
    }

    public synchronized boolean b(Object obj) {
        return get(obj) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0071, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.f141756b >= 0 && (!this.f141755a.isEmpty() || this.f141756b == 0)) {
                    if (this.f141756b <= i3 || this.f141755a.isEmpty()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) this.f141755a.entrySet().iterator().next();
                    key = entry.getKey();
                    value = entry.getValue();
                    this.f141755a.remove(key);
                    this.f141756b -= a(key, value);
                    this.f141760f++;
                } else {
                    break;
                }
            }
            a(true, key, value, null);
        }
    }

    public final int a(Object obj, Object obj2) {
        int b16 = b(obj, obj2);
        if (b16 >= 0) {
            return b16;
        }
        throw new IllegalStateException("Negative size: " + obj + ContainerUtils.KEY_VALUE_DELIMITER + obj2);
    }

    public final synchronized int a() {
        return this.f141757c;
    }
}
