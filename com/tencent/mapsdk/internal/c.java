package com.tencent.mapsdk.internal;

import com.tencent.mobileqq.mini.cache.Entry;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f147971a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    protected HashMap<String, Object> f147972b = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Object> f147975e = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected String f147973c = "GBK";

    /* renamed from: d, reason: collision with root package name */
    m f147974d = new m();

    public String a() {
        return this.f147973c;
    }

    public void b() {
        this.f147975e.clear();
    }

    public Set<String> c() {
        return Collections.unmodifiableSet(this.f147971a.keySet());
    }

    public boolean d() {
        return this.f147971a.isEmpty();
    }

    public int e() {
        return this.f147971a.size();
    }

    public byte[] f() {
        n nVar = new n(0);
        nVar.a(this.f147973c);
        nVar.a((Map) this.f147971a, 0);
        return q.a(nVar.f149372a);
    }

    private Object d(String str, boolean z16, ClassLoader classLoader) {
        String a16 = o.a(str);
        if (a16 != null && !"".equals(a16)) {
            str = a16;
        }
        if (this.f147972b.containsKey(str)) {
            return this.f147972b.get(str);
        }
        Object a17 = a.a(str, z16, classLoader);
        this.f147972b.put(str, a17);
        return a17;
    }

    public void a(String str) {
        this.f147973c = str;
    }

    public boolean b(String str) {
        return this.f147971a.containsKey(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T c(String str, boolean z16, ClassLoader classLoader) throws b {
        String str2;
        byte[] bArr;
        if (!this.f147971a.containsKey(str)) {
            return null;
        }
        byte[] bArr2 = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f147971a.remove(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            str2 = next.getKey();
            bArr = next.getValue();
        } else {
            str2 = "";
            bArr = bArr2;
        }
        try {
            Object a16 = a.a(str2, z16, classLoader);
            this.f147974d.a(bArr);
            this.f147974d.a(this.f147973c);
            return (T) this.f147974d.a((m) a16, 0, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            throw new b(e16);
        }
    }

    public <T> void a(String str, T t16) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t16 != null) {
            if (!(t16 instanceof Set)) {
                n nVar = new n();
                nVar.a(this.f147973c);
                nVar.a(t16, 0);
                byte[] a16 = q.a(nVar.f149372a);
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList<String> arrayList = new ArrayList<>(1);
                a(arrayList, t16);
                hashMap.put(a.a(arrayList), a16);
                this.f147975e.remove(str);
                this.f147971a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T b(String str, boolean z16, ClassLoader classLoader) throws b {
        String str2 = null;
        if (!this.f147971a.containsKey(str)) {
            return null;
        }
        if (this.f147975e.containsKey(str)) {
            return (T) this.f147975e.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f147971a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            str2 = next.getKey();
            bArr = next.getValue();
        }
        try {
            Object d16 = d(str2, z16, classLoader);
            this.f147974d.a(bArr);
            this.f147974d.a(this.f147973c);
            T t16 = (T) this.f147974d.a((m) d16, 0, true);
            b(str, t16);
            return t16;
        } catch (Exception e16) {
            e16.printStackTrace();
            throw new b(e16);
        }
    }

    private void b(String str, Object obj) {
        this.f147975e.put(str, obj);
    }

    public <T> T a(String str, boolean z16, ClassLoader classLoader) throws b {
        String str2 = null;
        if (!this.f147971a.containsKey(str)) {
            return null;
        }
        if (this.f147975e.containsKey(str)) {
            return (T) this.f147975e.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f147971a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            str2 = next.getKey();
            bArr = next.getValue();
        }
        try {
            Object d16 = d(str2, z16, classLoader);
            this.f147974d.a(bArr);
            this.f147974d.a(this.f147973c);
            T t16 = (T) this.f147974d.a((p) d16);
            b(str, t16);
            return t16;
        } catch (Exception e16) {
            e16.printStackTrace();
            throw new b(e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(String str, Object obj, boolean z16, ClassLoader classLoader) {
        String str2;
        byte[] bArr;
        if (!this.f147971a.containsKey(str)) {
            return obj;
        }
        if (this.f147975e.containsKey(str)) {
            return (T) this.f147975e.get(str);
        }
        byte[] bArr2 = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f147971a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            str2 = next.getKey();
            bArr = next.getValue();
        } else {
            str2 = "";
            bArr = bArr2;
        }
        try {
            Object d16 = d(str2, z16, classLoader);
            this.f147974d.a(bArr);
            this.f147974d.a(this.f147973c);
            T t16 = (T) this.f147974d.a((m) d16, 0, true);
            b(str, t16);
            return t16;
        } catch (Exception e16) {
            e16.printStackTrace();
            b(str, obj);
            return obj;
        }
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        while (true) {
            if (obj.getClass().isArray()) {
                if (obj.getClass().getComponentType().toString().equals("byte")) {
                    if (Array.getLength(obj) > 0) {
                        arrayList.add("java.util.List");
                        obj = Array.get(obj, 0);
                    } else {
                        arrayList.add(Entry.DATA_TYPE_Array);
                        arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                        return;
                    }
                } else {
                    throw new IllegalArgumentException("only byte[] is supported");
                }
            } else if (!(obj instanceof Array)) {
                if (obj instanceof List) {
                    arrayList.add("java.util.List");
                    List list = (List) obj;
                    if (list.size() > 0) {
                        obj = list.get(0);
                    } else {
                        arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                        return;
                    }
                } else if (obj instanceof Map) {
                    arrayList.add("java.util.Map");
                    Map map = (Map) obj;
                    if (map.size() > 0) {
                        Object obj2 = map.get(map.keySet().iterator().next());
                        arrayList.add(a((c) obj));
                        obj = obj2;
                    } else {
                        arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                        arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                        return;
                    }
                } else {
                    arrayList.add(a((c) obj));
                    return;
                }
            } else {
                throw new IllegalArgumentException("can not support Array, please use List");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> String a(T t16) {
        String className = t16 instanceof p ? ((p) t16).className() : "";
        return "".equals(className) ? t16.getClass().getName() : className;
    }

    public void a(byte[] bArr) {
        this.f147974d.a(bArr);
        this.f147974d.a(this.f147973c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f147971a = this.f147974d.a((Map) hashMap, 0, false);
    }
}
