package com.tencent.bugly.proguard;

import com.tencent.mobileqq.mini.cache.Entry;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f98378a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    protected HashMap<String, Object> f98379b = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Object> f98382e = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected String f98380c = "GBK";

    /* renamed from: d, reason: collision with root package name */
    k f98381d = new k();

    public void a(String str) {
        this.f98380c = str;
    }

    public <T> void a(String str, T t16) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t16 != null) {
            if (!(t16 instanceof Set)) {
                l lVar = new l();
                lVar.a(this.f98380c);
                lVar.a(t16, 0);
                byte[] a16 = n.a(lVar.f98522a);
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList arrayList = new ArrayList(1);
                a((ArrayList<String>) arrayList, t16);
                hashMap.put(a.a(arrayList), a16);
                this.f98382e.remove(str);
                this.f98378a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    private static void a(ArrayList<String> arrayList, Object obj) {
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
                        Object next = map.keySet().iterator().next();
                        obj = map.get(next);
                        arrayList.add(next.getClass().getName());
                    } else {
                        arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                        arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                        return;
                    }
                } else {
                    arrayList.add(obj.getClass().getName());
                    return;
                }
            } else {
                throw new IllegalArgumentException("can not support Array, please use List");
            }
        }
    }

    public byte[] a() {
        l lVar = new l(0);
        lVar.a(this.f98380c);
        lVar.a((Map) this.f98378a, 0);
        return n.a(lVar.f98522a);
    }

    public void a(byte[] bArr) {
        this.f98381d.a(bArr);
        this.f98381d.a(this.f98380c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f98378a = this.f98381d.a((Map) hashMap, 0, false);
    }
}
