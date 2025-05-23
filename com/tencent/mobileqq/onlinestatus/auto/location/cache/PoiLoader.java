package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes16.dex */
public class PoiLoader {

    /* renamed from: a, reason: collision with root package name */
    private final String f255514a;

    /* renamed from: b, reason: collision with root package name */
    private int f255515b;

    /* renamed from: c, reason: collision with root package name */
    c f255516c;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.mobileqq.onlinestatus.auto.location.cache.a f255517d;

    /* renamed from: e, reason: collision with root package name */
    d f255518e;

    /* loaded from: classes16.dex */
    public interface a {
        void a(PoiBean poiBean);
    }

    public PoiLoader(String str, int i3, int i16, int i17) {
        this.f255514a = str;
        this.f255515b = i3;
        this.f255518e = new d(str);
        this.f255517d = new com.tencent.mobileqq.onlinestatus.auto.location.cache.a(str, i17);
        this.f255516c = new c(str, Math.max(i16 + this.f255517d.c(), 10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(LatLng latLng, int i3, a aVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(LatLng latLng, int i3, a aVar) {
        return this.f255516c.c(latLng, i3, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final LatLng latLng, final int i3, final a aVar) {
        this.f255518e.c(latLng, i3, new a() { // from class: com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.3
            @Override // com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.a
            public void a(final PoiBean poiBean) {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.d("PoiLoader", 2, "[status][poiLoader][" + PoiLoader.this.f255514a + "] loadPoiFromNetwork. latLng: " + latLng + " poiBean: " + poiBean);
                        }
                        PoiBean poiBean2 = poiBean;
                        if (poiBean2 != null) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            PoiLoader.this.f255516c.d(poiBean2.latLng, i3, poiBean2);
                        }
                        aVar.a(poiBean);
                    }
                });
            }
        });
    }

    public void f(final LatLng latLng, final a aVar) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1
            @Override // java.lang.Runnable
            public void run() {
                PoiLoader poiLoader = PoiLoader.this;
                if (poiLoader.h(latLng, poiLoader.f255515b, aVar)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("PoiLoader", 2, "[status][poiLoader][" + PoiLoader.this.f255514a + "] loadPoi loadPoiFromMemory. latLng: " + latLng + " onCompleted.");
                        return;
                    }
                    return;
                }
                PoiLoader poiLoader2 = PoiLoader.this;
                if (poiLoader2.g(latLng, poiLoader2.f255515b, aVar)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("PoiLoader", 2, "[status][poiLoader][" + PoiLoader.this.f255514a + "] loadPoi loadPoiFromDisk. latLng: " + latLng + " onCompleted.");
                        return;
                    }
                    return;
                }
                PoiLoader poiLoader3 = PoiLoader.this;
                poiLoader3.i(latLng, poiLoader3.f255515b, aVar);
                if (QLog.isColorLevel()) {
                    QLog.i("PoiLoader", 2, "[status][poiLoader][" + PoiLoader.this.f255514a + "] loadPoi loadPoiFromNetwork. latLng: " + latLng + " onCompleted.");
                }
            }
        });
    }
}
