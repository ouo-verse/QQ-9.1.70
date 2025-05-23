package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c;

import android.text.TextUtils;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.setting.QQSetting;
import com.qq.e.comm.pi.SrcDownloadPermissionListener;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.u;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.e;
import com.qq.e.comm.plugin.tangramsplash.selector.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.TGSplashPreCacheUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements com.tencent.ams.fusion.service.splash.data.b {

    /* renamed from: a, reason: collision with root package name */
    private final c.b f40046a = new c.b();

    public void a(String str, String str2, LoadAdParams loadAdParams) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || loadAdParams == null) {
            return;
        }
        c.b bVar = this.f40046a;
        bVar.f40338e = loadAdParams;
        bVar.f40334a = str;
        bVar.f40335b = str2;
        bVar.f40336c = com.qq.e.comm.plugin.k.a.a(str, str2, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId());
        c.b bVar2 = this.f40046a;
        bVar2.f40337d = new l(bVar2.f40335b, com.qq.e.comm.plugin.base.ad.b.SPLASH, (com.qq.e.comm.plugin.base.ad.definition.a) null);
    }

    @Override // com.tencent.ams.fusion.service.splash.data.b
    public rt.c a(Object obj) {
        if (!(obj instanceof JSONObject)) {
            GDTLogger.e("FusionAdapterServiceImpl parsePreloadResponse response not json");
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (!y.a(jSONObject)) {
            GDTLogger.e("FusionAdapterServiceImpl parsePreloadResponse jsonObject null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        com.qq.e.comm.plugin.base.ad.b bVar = com.qq.e.comm.plugin.base.ad.b.SPLASH;
        c.b bVar2 = this.f40046a;
        com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.a(jSONObject, bVar, bVar2.f40334a, bVar2.f40335b, bVar2.f40336c, null, arrayList, true);
        e eVar = new e();
        eVar.a(a((List<r>) arrayList));
        eVar.a(this.f40046a.f40335b);
        return eVar;
    }

    @Override // com.tencent.ams.fusion.service.splash.data.b
    public void a(int i3, nt.a aVar) {
        if (i3 == 1 && aVar != null) {
            GDTLogger.d("FusionAdapterServiceImpl processPreloadDownloadResult : " + i3 + ", ResType :" + aVar.c());
            if (aVar.c() == 2) {
                com.qq.e.comm.plugin.tangramsplash.c.b.b(aVar.d(), aVar.b());
            }
            com.tencent.ams.fusion.a.b.f(com.tencent.ams.fusion.a.b.c(aVar.c(), aVar.a()));
        }
    }

    @Override // com.tencent.ams.fusion.service.splash.data.b
    public void a(String str) {
        GDTLogger.i("FusionAdapter updateResState srcUrl\uff1a" + str);
        TGSplashPreCacheUtil.updateResState(str);
    }

    @Override // com.tencent.ams.fusion.service.splash.data.b
    public boolean a(String str, String str2, int i3) {
        WeakReference<SrcDownloadPermissionListener> srcDownloadPermissionListener = QQSetting.getSrcDownloadPermissionListener();
        SrcDownloadPermissionListener srcDownloadPermissionListener2 = srcDownloadPermissionListener != null ? srcDownloadPermissionListener.get() : null;
        int canDownload = srcDownloadPermissionListener2 != null ? srcDownloadPermissionListener2.canDownload(str, str2, i3) : Integer.MIN_VALUE;
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.b(str2);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("download_url", Integer.valueOf(i3));
        cVar.a("file_type", Integer.valueOf(i3));
        cVar.a("error_code", Integer.valueOf(canDownload));
        StatTracer.trackEvent(1310190, 0, bVar, cVar);
        return canDownload == 0;
    }

    private Map<String, rt.a> a(List<r> list) {
        List<u> bs5;
        if (g.b(list)) {
            GDTLogger.e("\u672c\u5730\u9884\u52a0\u8f7d\u5e7f\u544a\u6570\u636e\u65e0\u6548");
            return null;
        }
        HashMap hashMap = new HashMap();
        for (r rVar : list) {
            if (rVar != null && (bs5 = rVar.bs()) != null && bs5.size() > 0) {
                for (u uVar : bs5) {
                    if (hashMap.containsKey(uVar.a())) {
                        List list2 = (List) hashMap.get(uVar.a());
                        if (list2 == null) {
                            list2 = new ArrayList();
                            hashMap.put(uVar.a(), list2);
                        }
                        list2.add(rVar);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(rVar);
                        hashMap.put(uVar.a(), arrayList);
                    }
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && !TextUtils.isEmpty((CharSequence) entry.getKey())) {
                List list3 = (List) entry.getValue();
                com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.c cVar = new com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.c();
                com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.a(list3, false, cVar, true);
                hashMap2.put(entry.getKey(), cVar);
            }
        }
        return hashMap2;
    }
}
