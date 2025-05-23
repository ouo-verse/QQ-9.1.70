package com.tencent.luggage.wxa.nb;

import android.text.TextUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f135603b;

    /* renamed from: a, reason: collision with root package name */
    public Map f135604a = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends ConcurrentHashMap {
        public b() {
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            if (obj == null) {
                return false;
            }
            return super.containsValue(obj);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (obj == null) {
                return null;
            }
            return super.get(obj);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            if (obj == null) {
                return null;
            }
            if (obj2 == null) {
                return super.remove(obj);
            }
            return super.put(obj, obj2);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return super.remove(obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Map f135605a = new b();

        public Set a() {
            return this.f135605a.keySet();
        }

        public c b(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                this.f135605a.put(str, obj);
            }
            return this;
        }

        public boolean c(String str) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.f135605a.get(str);
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            }
            return false;
        }

        public boolean a(String str) {
            return this.f135605a.containsKey(str);
        }

        public int a(String str, int i3) {
            if (TextUtils.isEmpty(str)) {
                return i3;
            }
            Object obj = this.f135605a.get(str);
            return obj instanceof Integer ? ((Integer) obj).intValue() : i3;
        }

        public c b(String str, boolean z16) {
            if (!TextUtils.isEmpty(str)) {
                this.f135605a.put(str, Boolean.valueOf(z16));
            }
            return this;
        }

        public boolean a(String str, boolean z16) {
            if (TextUtils.isEmpty(str)) {
                return z16;
            }
            Object obj = this.f135605a.get(str);
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z16;
        }

        public c b(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.f135605a.put(str, str2);
            }
            return this;
        }

        public String a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            Object obj = this.f135605a.get(str);
            return obj instanceof String ? (String) obj : str2;
        }

        public Object b(String str) {
            return this.f135605a.get(str);
        }

        public void b() {
            this.f135605a.clear();
        }

        public Object a(String str, Object obj) {
            Object b16 = b(str);
            return b16 != null ? b16 : obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public c f135606a = new c();

        /* renamed from: b, reason: collision with root package name */
        public long f135607b = System.currentTimeMillis();
    }

    public static a a() {
        if (f135603b == null) {
            synchronized (a.class) {
                if (f135603b == null) {
                    f135603b = new a();
                }
            }
        }
        return f135603b;
    }

    public static String b(String str) {
        return "SessionId@" + str + "#" + System.nanoTime();
    }

    public c c(String str) {
        d dVar = (d) this.f135604a.get(str);
        if (dVar != null) {
            return dVar.f135606a;
        }
        return null;
    }

    public c d(String str) {
        d dVar = (d) this.f135604a.remove(str);
        if (dVar != null) {
            return dVar.f135606a;
        }
        return null;
    }

    public String toString() {
        d dVar;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DataCenter \nDataStore size : ");
        sb5.append(this.f135604a.size());
        LinkedHashSet<Map.Entry> linkedHashSet = new LinkedHashSet(this.f135604a.entrySet());
        for (Map.Entry entry : linkedHashSet) {
            if (entry != null && (dVar = (d) entry.getValue()) != null) {
                sb5.append("\nDataStore id : ");
                sb5.append((String) entry.getKey());
                sb5.append(", CT : ");
                sb5.append(dVar.f135607b);
                sb5.append("ms");
                sb5.append(", TTL : ");
                sb5.append((currentTimeMillis - dVar.f135607b) / 1000);
                sb5.append(ReportConstant.COSTREPORT_PREFIX);
            }
        }
        linkedHashSet.clear();
        return sb5.toString();
    }

    public final d a(String str) {
        d dVar = new d();
        this.f135604a.put(str, dVar);
        return dVar;
    }

    public c a(String str, boolean z16) {
        d dVar = (d) this.f135604a.get(str);
        if (dVar == null) {
            if (!z16) {
                return null;
            }
            dVar = a(str);
        }
        return dVar.f135606a;
    }
}
