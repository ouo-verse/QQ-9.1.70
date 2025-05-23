package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
class c extends b {

    /* renamed from: c, reason: collision with root package name */
    private LRULinkedHashMap<LatLng, PoiBean> f255532c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements PoiLoader.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LatLng f255533a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f255534b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PoiBean f255535c;

        a(LatLng latLng, int i3, PoiBean poiBean) {
            this.f255533a = latLng;
            this.f255534b = i3;
            this.f255535c = poiBean;
        }

        @Override // com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.a
        public void a(PoiBean poiBean) {
            if (QLog.isColorLevel()) {
                QLog.e(b.f255530b, 2, "[status][poiLoader][" + c.this.f255531a + "] memPut [fail already exist]. latLng: " + this.f255533a + " acceptAccuracy: " + this.f255534b + " put: " + this.f255535c + " cache: " + poiBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, int i3) {
        super(str);
        b.f255530b = "MemoryLoader";
        this.f255532c = new LRULinkedHashMap<>(i3);
    }

    public boolean c(LatLng latLng, int i3, PoiLoader.a aVar) {
        PoiBean poiBean;
        Iterator<LatLng> it = this.f255532c.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                LatLng next = it.next();
                if (a(next, latLng, i3)) {
                    poiBean = this.f255532c.get(next);
                    break;
                }
            } else {
                poiBean = null;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(b.f255530b, 2, "[status][poiLoader][" + this.f255531a + "] memGet latLng: " + latLng + " result: " + poiBean);
        }
        b("memGet", poiBean);
        if (poiBean != null) {
            aVar.a(poiBean);
        }
        if (poiBean != null) {
            return true;
        }
        return false;
    }

    public void d(LatLng latLng, int i3, PoiBean poiBean) {
        if (c(latLng, i3, new a(latLng, i3, poiBean))) {
            if (QLog.isColorLevel()) {
                QLog.e(b.f255530b, 2, "[status][poiLoader][" + this.f255531a + "] memPut [fail already exist]. latLng: " + latLng + " acceptAccuracy: " + i3 + " poiBean: " + poiBean);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(b.f255530b, 2, "[status][poiLoader][" + this.f255531a + "] memPut poiBean: " + poiBean);
        }
        b("memPut", poiBean);
        this.f255532c.put(poiBean.latLng, poiBean);
    }
}
