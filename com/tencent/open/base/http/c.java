package com.tencent.open.base.http;

import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.f;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    protected static final String f341017c = "com.tencent.open.base.http.c";

    /* renamed from: d, reason: collision with root package name */
    protected static c f341018d;

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.open.component.cache.database.b f341019a;

    /* renamed from: b, reason: collision with root package name */
    protected HashMap<String, b> f341020b;

    protected c() {
        String str;
        this.f341019a = null;
        this.f341020b = null;
        try {
            this.f341019a = rp3.a.a().a(b.class, 0L, "http_cache_table");
            int y16 = this.f341019a.y();
            this.f341020b = new HashMap<>(y16);
            for (int i3 = 0; i3 < y16; i3++) {
                b bVar = (b) this.f341019a.z(i3);
                if (bVar != null && (str = bVar.f341011a) != null) {
                    this.f341020b.put(str, bVar);
                }
            }
        } catch (Exception unused) {
            this.f341020b = new HashMap<>();
        }
    }

    public static synchronized c d() {
        c cVar;
        synchronized (c.class) {
            if (f341018d == null) {
                f341018d = new c();
            }
            cVar = f341018d;
        }
        return cVar;
    }

    public synchronized void a() {
        HashMap<String, b> hashMap = this.f341020b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    protected synchronized void b() {
        Iterator<b> it = this.f341020b.values().iterator();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = Long.MAX_VALUE;
        String str = null;
        while (it.hasNext()) {
            b next = it.next();
            long j16 = next.f341014d;
            if (currentTimeMillis - j16 >= 432000000) {
                f.a(f341017c, "Clear out of date cache. urlkey=" + next.f341011a);
                this.f341019a.x("urlKey='" + next.f341011a + "'");
                it.remove();
            } else if (j3 > j16) {
                str = next.f341011a;
                j3 = j16;
            }
        }
        if (this.f341020b.size() >= 50) {
            f.a(f341017c, "Reached max cache count:50. Clear last cache data. urlKey=" + this.f341020b.get(str).f341011a);
            this.f341020b.remove(str);
            this.f341019a.x("urlKey='" + str + "'");
        }
    }

    public String c(String str) {
        String str2;
        HashMap<String, b> hashMap = this.f341020b;
        if (hashMap != null && hashMap.size() != 0) {
            String encodeHexStr = MD5Utils.encodeHexStr(str);
            if (this.f341020b.get(encodeHexStr) != null) {
                str2 = this.f341020b.get(encodeHexStr).f341012b;
                f.a(f341017c, "Get ETag from cache. ETag=" + str2);
                return str2;
            }
        }
        str2 = "\"\"";
        f.a(f341017c, "Get ETag from cache. ETag=" + str2);
        return str2;
    }

    public long e(String str) {
        long j3;
        HashMap<String, b> hashMap = this.f341020b;
        if (hashMap != null && hashMap.size() != 0) {
            String encodeHexStr = MD5Utils.encodeHexStr(str);
            if (this.f341020b.get(encodeHexStr) != null) {
                j3 = this.f341020b.get(encodeHexStr).f341013c;
                f.a(f341017c, "Get lastModify from cache. lastModify=" + j3);
                return j3;
            }
        }
        j3 = 0;
        f.a(f341017c, "Get lastModify from cache. lastModify=" + j3);
        return j3;
    }

    public String f(String str) {
        String str2;
        HashMap<String, b> hashMap = this.f341020b;
        if (hashMap != null && hashMap.size() != 0) {
            String encodeHexStr = MD5Utils.encodeHexStr(str);
            if (this.f341020b.get(encodeHexStr) != null) {
                str2 = this.f341020b.get(encodeHexStr).f341016f;
                f.a(f341017c, "Get lastModify from cache. lastModify=" + str2);
                return str2;
            }
        }
        str2 = "";
        f.a(f341017c, "Get lastModify from cache. lastModify=" + str2);
        return str2;
    }

    public String g(String str) {
        HashMap<String, b> hashMap = this.f341020b;
        String str2 = "";
        if (hashMap != null && hashMap.size() != 0) {
            String encodeHexStr = MD5Utils.encodeHexStr(str);
            if (this.f341020b.get(encodeHexStr) != null) {
                str2 = this.f341020b.get(encodeHexStr).f341015e;
            }
            f.a(f341017c, "Get 304, Load response data from cache. urlKey=" + encodeHexStr);
        }
        return str2;
    }

    public synchronized void h(String str) {
        String encodeHexStr = MD5Utils.encodeHexStr(str);
        if (encodeHexStr != null) {
            this.f341020b.remove(encodeHexStr);
            this.f341019a.x("urlKey='" + encodeHexStr + "'");
        }
    }

    public void i(String str, String str2, long j3, String str3, String str4) {
        if (str != null) {
            try {
                if (!"".equals(str.trim()) && str3 != null) {
                    b bVar = new b(str, str2, j3, str3, str4);
                    String encodeHexStr = MD5Utils.encodeHexStr(str);
                    if (this.f341019a != null) {
                        if (this.f341020b.containsKey(encodeHexStr)) {
                            this.f341019a.D(bVar, "urlKey='" + encodeHexStr + "'");
                        } else {
                            b();
                            this.f341019a.A(bVar, 1);
                        }
                        this.f341020b.put(encodeHexStr, bVar);
                        f.a(f341017c, "Get 200, Save response data to cache. urlKey=" + encodeHexStr);
                        return;
                    }
                    return;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        f.c(f341017c, "saveResponse error. params error\n url=" + str + "; ETag=" + str2 + "; lastModify=" + j3 + "; response=" + str3);
    }
}
