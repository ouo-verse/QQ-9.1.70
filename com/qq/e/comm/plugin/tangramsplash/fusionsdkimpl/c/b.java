package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c;

import android.text.TextUtils;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.tangramsplash.selector.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements qt.c {

    /* renamed from: a, reason: collision with root package name */
    private final c.b f40047a = new c.b();

    private void b(qt.a aVar) {
        if (aVar == null) {
            return;
        }
        c.b bVar = this.f40047a;
        bVar.f40336c = com.qq.e.comm.plugin.k.a.a(bVar.f40334a, bVar.f40335b, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId());
        this.f40047a.f40334a = aVar.b();
        this.f40047a.f40335b = aVar.c();
        c.b bVar2 = this.f40047a;
        bVar2.f40337d = new l(bVar2.f40335b, com.qq.e.comm.plugin.base.ad.b.SPLASH, (com.qq.e.comm.plugin.base.ad.definition.a) null);
    }

    @Override // mt.d
    public void a(qt.a aVar, mt.b<qt.a, qt.b> bVar) {
    }

    @Override // mt.d
    public qt.b a(qt.a aVar) {
        Map map;
        if (aVar == null) {
            return null;
        }
        b(aVar);
        com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.c cVar = new com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.c();
        cVar.f40030a = aVar.a();
        if (aVar.d()) {
            GDTLogger.i("[requestSync] read data from SplashController :" + com.qq.e.comm.plugin.tangramsplash.selector.c.f40320a);
            List<r> list = com.qq.e.comm.plugin.tangramsplash.selector.c.f40320a;
            map = new ConcurrentHashMap();
            map.put(aVar.a(), list);
            com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.a((Map<String, List<r>>) map);
        } else {
            map = com.qq.e.comm.plugin.tangramsplash.selector.a.f40309a;
        }
        if (map != null && !map.isEmpty()) {
            String a16 = cVar.a();
            if (TextUtils.isEmpty(a16)) {
                GDTLogger.e("[requestSync] date is null");
                return null;
            }
            List list2 = (List) map.get(a16);
            if (g.b(list2)) {
                GDTLogger.e("[requestSync] preloadDataList is null on " + a16);
                return null;
            }
            com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.a(list2, false, cVar, false);
            com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.b bVar = new com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.b();
            bVar.a(cVar);
            return bVar;
        }
        GDTLogger.e("[requestSync] preloadDataMap is null");
        return null;
    }
}
