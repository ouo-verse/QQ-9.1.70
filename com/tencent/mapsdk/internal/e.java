package com.tencent.mapsdk.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends c {

    /* renamed from: e, reason: collision with root package name */
    protected HashMap<String, byte[]> f148140e = null;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, Object> f148142g = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    m f148141f = new m();

    private <T> T f(String str, T t16) throws b {
        if (!this.f148140e.containsKey(str)) {
            return null;
        }
        if (t16 != null) {
            return (T) a(this.f148140e.remove(str), t16);
        }
        this.f148140e.remove(str);
        return null;
    }

    @Override // com.tencent.mapsdk.internal.c
    public final /* bridge */ /* synthetic */ String a() {
        return super.a();
    }

    @Override // com.tencent.mapsdk.internal.c
    public final void b() {
        this.f148142g.clear();
    }

    @Override // com.tencent.mapsdk.internal.c
    public final Set<String> c() {
        HashMap<String, byte[]> hashMap = this.f148140e;
        if (hashMap != null) {
            return Collections.unmodifiableSet(hashMap.keySet());
        }
        return Collections.unmodifiableSet(this.f147971a.keySet());
    }

    @Override // com.tencent.mapsdk.internal.c
    public final boolean d() {
        HashMap<String, byte[]> hashMap = this.f148140e;
        if (hashMap != null) {
            return hashMap.isEmpty();
        }
        return this.f147971a.isEmpty();
    }

    @Override // com.tencent.mapsdk.internal.c
    public final int e() {
        HashMap<String, byte[]> hashMap = this.f148140e;
        if (hashMap != null) {
            return hashMap.size();
        }
        return this.f147971a.size();
    }

    public void g() {
        this.f148140e = new HashMap<>();
    }

    @Override // com.tencent.mapsdk.internal.c
    public final /* bridge */ /* synthetic */ String a(Object obj) {
        return super.a((e) obj);
    }

    @Override // com.tencent.mapsdk.internal.c
    public final boolean b(String str) {
        HashMap<String, byte[]> hashMap = this.f148140e;
        if (hashMap != null) {
            return hashMap.containsKey(str);
        }
        return this.f147971a.containsKey(str);
    }

    @Override // com.tencent.mapsdk.internal.c
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    private <T> T c(String str, T t16) throws b {
        HashMap<String, byte[]> hashMap = this.f148140e;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.f148142g.containsKey(str)) {
                return (T) this.f148142g.get(str);
            }
            try {
                T t17 = (T) a(this.f148140e.get(str), t16);
                if (t17 != null) {
                    d(str, t17);
                }
                return t17;
            } catch (Exception e16) {
                throw new b(e16);
            }
        }
        if (!this.f147971a.containsKey(str)) {
            return null;
        }
        if (this.f148142g.containsKey(str)) {
            return (T) this.f148142g.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f147971a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this.f148141f.a(bArr);
            this.f148141f.a(this.f147973c);
            T t18 = (T) this.f148141f.a((m) t16, 0, true);
            d(str, t18);
            return t18;
        } catch (Exception e17) {
            throw new b(e17);
        }
    }

    private void d(String str, Object obj) {
        this.f148142g.put(str, obj);
    }

    private <T> T e(String str, Object obj) {
        return (T) a(str, obj, true, null);
    }

    @Override // com.tencent.mapsdk.internal.c
    public <T> void a(String str, T t16) {
        if (this.f148140e == null) {
            super.a(str, (String) t16);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t16 != null) {
            if (!(t16 instanceof Set)) {
                n nVar = new n();
                nVar.a(this.f147973c);
                nVar.a(t16, 0);
                this.f148140e.put(str, q.a(nVar.f149372a));
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    private <T> T b(String str, T t16) throws b {
        if (!this.f148140e.containsKey(str)) {
            return null;
        }
        if (this.f148142g.containsKey(str)) {
            return (T) this.f148142g.get(str);
        }
        try {
            T t17 = (T) a(this.f148140e.get(str), t16);
            if (t17 != null) {
                d(str, t17);
            }
            return t17;
        } catch (Exception e16) {
            throw new b(e16);
        }
    }

    private <T> T d(String str) throws b {
        return (T) b(str, true, (ClassLoader) null);
    }

    private <T> T e(String str) throws b {
        return (T) c(str, true, null);
    }

    @Override // com.tencent.mapsdk.internal.c
    public byte[] f() {
        if (this.f148140e != null) {
            n nVar = new n(0);
            nVar.a(this.f147973c);
            nVar.a((Map) this.f148140e, 0);
            return q.a(nVar.f149372a);
        }
        return super.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T b(String str, T t16, Object obj) {
        return !this.f148140e.containsKey(str) ? obj : (T) c(str, t16);
    }

    @Override // com.tencent.mapsdk.internal.c
    public final <T> T b(String str, boolean z16, ClassLoader classLoader) throws b {
        if (this.f148140e == null) {
            return (T) super.b(str, z16, classLoader);
        }
        throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
    }

    private <T> T a(String str, T t16, T t17) throws b {
        HashMap<String, byte[]> hashMap = this.f148140e;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return t17;
            }
            if (this.f148142g.containsKey(str)) {
                return (T) this.f148142g.get(str);
            }
            try {
                T t18 = (T) a(this.f148140e.get(str), t16);
                if (t18 != null) {
                    d(str, t18);
                }
                return t18;
            } catch (Exception e16) {
                throw new b(e16);
            }
        }
        if (!this.f147971a.containsKey(str)) {
            return t17;
        }
        if (this.f148142g.containsKey(str)) {
            return (T) this.f148142g.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f147971a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this.f148141f.a(bArr);
            this.f148141f.a(this.f147973c);
            T t19 = (T) this.f148141f.a((m) t16, 0, true);
            d(str, t19);
            return t19;
        } catch (Exception e17) {
            throw new b(e17);
        }
    }

    public void b(byte[] bArr) {
        this.f148141f.a(bArr);
        this.f148141f.a(this.f147973c);
        HashMap hashMap = new HashMap(1);
        hashMap.put("", new byte[0]);
        this.f148140e = this.f148141f.a((Map) hashMap, 0, false);
    }

    private <T> T c(String str) throws b {
        return (T) a(str, true, (ClassLoader) null);
    }

    @Override // com.tencent.mapsdk.internal.c
    public final <T> T c(String str, boolean z16, ClassLoader classLoader) throws b {
        HashMap<String, byte[]> hashMap = this.f148140e;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            this.f148140e.remove(str);
            return null;
        }
        return (T) super.c(str, z16, classLoader);
    }

    public void c(byte[] bArr) {
        super.a(bArr);
    }

    private Object a(byte[] bArr, Object obj) {
        this.f148141f.a(bArr);
        this.f148141f.a(this.f147973c);
        return this.f148141f.a((m) obj, 0, true);
    }

    @Override // com.tencent.mapsdk.internal.c
    public final <T> T a(String str, boolean z16, ClassLoader classLoader) throws b {
        if (this.f148140e == null) {
            return (T) super.a(str, z16, classLoader);
        }
        throw new RuntimeException("data is encoded by new version, please use getJceStruct(String name,T proxy)");
    }

    @Override // com.tencent.mapsdk.internal.c
    public final <T> T a(String str, Object obj, boolean z16, ClassLoader classLoader) {
        if (this.f148140e == null) {
            return (T) super.a(str, obj, z16, classLoader);
        }
        throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy, Object defaultValue)");
    }

    @Override // com.tencent.mapsdk.internal.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f148141f.a(bArr);
            this.f148141f.a(this.f147973c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f148140e = this.f148141f.a((Map) hashMap, 0, false);
        }
    }
}
