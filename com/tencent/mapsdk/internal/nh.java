package com.tencent.mapsdk.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Pair;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ni;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class nh<T extends ni> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    protected final tk f149455a;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f149463i = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    protected final Map<Integer, ng<T>> f149456b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    protected final Map<Integer, ng<T>> f149457c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    protected final Map<Integer, ng<T>> f149458d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    protected final Map<Integer, ng<T>> f149459e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    protected final Map<Integer, ng<T>> f149460f = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    protected final Map<Integer, ng<T>> f149461g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    protected final Map<Integer, ng<T>> f149462h = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements TencentMap.IClickedObject {

        /* renamed from: a, reason: collision with root package name */
        LatLng f149464a;

        /* renamed from: b, reason: collision with root package name */
        String f149465b;

        /* renamed from: c, reason: collision with root package name */
        String f149466c;

        public a(LatLng latLng, String str, String str2) {
            this.f149464a = latLng;
            this.f149465b = str;
            this.f149466c = str2;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.IClickedObject
        public final String getIdentifier() {
            return this.f149465b;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.IClickedObject
        @Nullable
        public final String getName() {
            return this.f149466c;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.IClickedObject
        public final LatLng getPosition() {
            return this.f149464a;
        }
    }

    public nh(tk tkVar) {
        this.f149455a = tkVar;
    }

    private synchronized void g() {
        this.f149462h.clear();
        this.f149458d.clear();
        this.f149460f.clear();
        this.f149456b.clear();
    }

    public synchronized ng<T> a(int i3) {
        return this.f149456b.get(Integer.valueOf(i3));
    }

    protected abstract ng<T> a(T t16);

    public synchronized ng<T> b(@NonNull T t16) {
        ng<T> a16;
        a16 = a((nh<T>) t16);
        int incrementAndGet = this.f149463i.incrementAndGet();
        a16.f149451a = incrementAndGet;
        this.f149456b.put(Integer.valueOf(incrementAndGet), a16);
        this.f149458d.put(Integer.valueOf(a16.f149451a), a16);
        LogUtil.a("BufferingElement add mNextAdds " + a16.f149451a + " size:" + this.f149458d.size() + " this:" + this);
        this.f149455a.i(true);
        return a16;
    }

    protected abstract void c(ng<T> ngVar);

    public final synchronized void d() {
        c();
        a(this.f149462h, this.f149461g);
        a(this.f149460f, this.f149459e);
        a(this.f149458d, this.f149457c);
        this.f149458d.clear();
        this.f149460f.clear();
        this.f149462h.clear();
        Iterator<Map.Entry<Integer, ng<T>>> it = this.f149457c.entrySet().iterator();
        while (it.hasNext()) {
            c(it.next().getValue());
        }
        Iterator<Map.Entry<Integer, ng<T>>> it5 = this.f149459e.entrySet().iterator();
        while (it5.hasNext()) {
            d(it5.next().getValue());
        }
        Iterator<Map.Entry<Integer, ng<T>>> it6 = this.f149461g.entrySet().iterator();
        while (it6.hasNext()) {
            e(it6.next().getValue());
        }
        this.f149461g.clear();
        this.f149459e.clear();
        this.f149457c.clear();
        e();
    }

    protected abstract void d(ng<T> ngVar);

    protected abstract void e(ng<T> ngVar);

    protected abstract void f(ng<T> ngVar);

    public boolean f() {
        return false;
    }

    public final synchronized void a(@NonNull ng<T> ngVar) {
        if (this.f149456b.get(Integer.valueOf(ngVar.f149451a)) == null) {
            return;
        }
        this.f149460f.put(Integer.valueOf(ngVar.f149451a), ngVar);
        this.f149455a.i(true);
    }

    public final Context a() {
        tk tkVar = this.f149455a;
        if (tkVar == null) {
            return null;
        }
        return tkVar.A();
    }

    public final synchronized void b(@NonNull ng<T> ngVar) {
        f(ngVar);
        if (this.f149456b.get(Integer.valueOf(ngVar.f149451a)) == null) {
            return;
        }
        if (this.f149458d.get(Integer.valueOf(ngVar.f149451a)) == null) {
            this.f149462h.put(Integer.valueOf(ngVar.f149451a), ngVar);
        }
        this.f149456b.remove(Integer.valueOf(ngVar.f149451a));
        this.f149458d.remove(Integer.valueOf(ngVar.f149451a));
        this.f149460f.remove(Integer.valueOf(ngVar.f149451a));
        this.f149455a.i(true);
    }

    private static <A, B> void a(Map<A, B> map, Map<A, B> map2) {
        HashMap hashMap = new HashMap(map2);
        map2.clear();
        map2.putAll(map);
        map.clear();
        map.putAll(hashMap);
    }

    public Pair<VectorOverlay, TencentMap.IClickedObject> a(LatLng latLng, long j3, String str, String str2) {
        return new Pair<>(null, null);
    }

    public final synchronized void b() {
        g();
    }

    protected void c() {
    }

    protected void e() {
    }
}
