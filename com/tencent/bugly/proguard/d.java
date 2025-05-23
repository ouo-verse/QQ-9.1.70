package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends c {

    /* renamed from: e, reason: collision with root package name */
    protected HashMap<String, byte[]> f98494e = null;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, Object> f98496g = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    k f98495f = new k();

    private void c(String str, Object obj) {
        this.f98496g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.c
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public void b() {
        this.f98494e = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.c
    public <T> void a(String str, T t16) {
        if (this.f98494e == null) {
            super.a(str, (String) t16);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t16 != null) {
            if (!(t16 instanceof Set)) {
                l lVar = new l();
                lVar.a(this.f98380c);
                lVar.a(t16, 0);
                this.f98494e.put(str, n.a(lVar.f98522a));
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    public final <T> T b(String str, T t16) throws b {
        HashMap<String, byte[]> hashMap = this.f98494e;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.f98496g.containsKey(str)) {
                return (T) this.f98496g.get(str);
            }
            try {
                this.f98495f.a(this.f98494e.get(str));
                this.f98495f.a(this.f98380c);
                T t17 = (T) this.f98495f.a((k) t16, 0, true);
                if (t17 != null) {
                    c(str, t17);
                }
                return t17;
            } catch (Exception e16) {
                throw new b(e16);
            }
        }
        if (!this.f98378a.containsKey(str)) {
            return null;
        }
        if (this.f98496g.containsKey(str)) {
            return (T) this.f98496g.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f98378a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this.f98495f.a(bArr);
            this.f98495f.a(this.f98380c);
            T t18 = (T) this.f98495f.a((k) t16, 0, true);
            c(str, t18);
            return t18;
        } catch (Exception e17) {
            throw new b(e17);
        }
    }

    @Override // com.tencent.bugly.proguard.c
    public byte[] a() {
        if (this.f98494e != null) {
            l lVar = new l(0);
            lVar.a(this.f98380c);
            lVar.a((Map) this.f98494e, 0);
            return n.a(lVar.f98522a);
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f98495f.a(bArr);
            this.f98495f.a(this.f98380c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f98494e = this.f98495f.a((Map) hashMap, 0, false);
        }
    }
}
