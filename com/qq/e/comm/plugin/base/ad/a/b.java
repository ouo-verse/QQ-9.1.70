package com.qq.e.comm.plugin.base.ad.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.TADLDI;
import com.qq.e.comm.plugin.base.ad.c.f;
import com.qq.e.comm.plugin.base.ad.e.c;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.tangram.ad.TAdRequest;
import com.qq.e.tg.tangram.ad.TangramAdListener;
import com.qq.e.tg.tangram.module.TangramAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements TADLDI {

    /* renamed from: a, reason: collision with root package name */
    private Handler f38345a = new Handler(Looper.getMainLooper());

    public b(Context context, String str) {
    }

    private int b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("cfg")) == null || (optJSONObject2 = optJSONObject.optJSONObject("playcfg")) == null) {
            return -1;
        }
        return optJSONObject2.optInt("11064");
    }

    @Override // com.qq.e.comm.pi.TADLDI
    public void asyncLoad(final TAdRequest tAdRequest, final TangramAdListener tangramAdListener) {
        if (tAdRequest != null && tAdRequest.isValid()) {
            final String a16 = com.qq.e.comm.plugin.k.a.a(tAdRequest.appId, tAdRequest.posId, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId());
            com.qq.e.comm.plugin.base.ad.e.c.a(a(tAdRequest), new com.qq.e.comm.plugin.base.ad.model.a(a16, com.qq.e.comm.plugin.base.ad.b.GDTNATIVEAD, tAdRequest.posId), new c.b() { // from class: com.qq.e.comm.plugin.base.ad.a.b.1
                @Override // com.qq.e.comm.plugin.base.ad.e.c.b
                public void a(JSONObject jSONObject) {
                    if (jSONObject.optInt("ret") != 0) {
                        b.this.a(tangramAdListener, jSONObject.optInt("ret"));
                    } else {
                        b.this.a(tangramAdListener, tAdRequest, jSONObject, a16);
                    }
                }

                @Override // com.qq.e.comm.plugin.base.ad.e.c.b
                public void a(com.qq.e.comm.plugin.base.ad.e.b.a aVar) {
                    GDTLogger.w("LoadGDTNativeADFail", aVar);
                    b.this.a(tangramAdListener, aVar.a());
                }
            });
            return;
        }
        a(tangramAdListener, 0);
    }

    private com.qq.e.comm.plugin.base.ad.model.b a(TAdRequest tAdRequest) {
        LoadAdParams loadAdParams;
        com.qq.e.comm.plugin.base.ad.model.b bVar = new com.qq.e.comm.plugin.base.ad.model.b();
        bVar.a(tAdRequest.posId);
        bVar.a(1);
        bVar.b(a(tAdRequest.adCount));
        bVar.c(2);
        bVar.f(com.qq.e.comm.plugin.base.ad.b.GDTNATIVEAD.b());
        if (SDKStatus.getSDKVersionCode() >= 160 && (loadAdParams = tAdRequest.loadAdParams) != null) {
            bVar.c(loadAdParams.getUin());
            bVar.g(tAdRequest.loadAdParams.getFlowSourceId());
            bVar.a(tAdRequest.loadAdParams.getLoginType());
            bVar.d(tAdRequest.loadAdParams.getLoginAppId());
            bVar.b(tAdRequest.loadAdParams.getLoginOpenid());
            bVar.a(tAdRequest.loadAdParams.getPassThroughInfo());
            bVar.e(tAdRequest.loadAdParams.getUid());
            bVar.a(tAdRequest.loadAdParams.getExperimentId());
            bVar.m(tAdRequest.loadAdParams.getExperimentType());
        }
        return bVar;
    }

    private int a(int i3) {
        if (i3 < 1) {
            GDTLogger.w("\u539f\u751f\u5e7f\u544a\u8bf7\u6c42\u6570\u91cf\u8303\u56f4\u4e3a[1, 10]\uff0c\u5df2\u5c06\u672c\u6b21\u5e7f\u544a\u8bf7\u6c42\u7684\u5e7f\u544a\u6570\u91cf\u8bbe\u4e3a1");
            i3 = 1;
        }
        if (i3 <= 10) {
            return i3;
        }
        GDTLogger.w("\u539f\u751f\u5e7f\u544a\u8bf7\u6c42\u6570\u91cf\u8303\u56f4\u4e3a[1, 10]\uff0c\u5df2\u5c06\u672c\u6b21\u5e7f\u544a\u8bf7\u6c42\u7684\u5e7f\u544a\u6570\u91cf\u8bbe\u4e3a10");
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TangramAdListener tangramAdListener, TAdRequest tAdRequest, JSONObject jSONObject, String str) {
        int optInt = jSONObject.optInt("ret");
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        bVar.a(tAdRequest.posId);
        cVar.a("posId", tAdRequest.posId);
        if (optInt != 0) {
            a(tangramAdListener, 501);
            StatTracer.trackEvent(30022, 501, bVar, cVar);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            a(tangramAdListener, 501);
            StatTracer.trackEvent(30032, 1, bVar, cVar);
            return;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(tAdRequest.posId);
        if (optJSONObject2 == null) {
            a(tangramAdListener, 501);
            StatTracer.trackEvent(30032, 2, bVar, cVar);
            return;
        }
        if (optJSONObject2.optInt("ret") != 0) {
            a(tangramAdListener, optJSONObject2.optInt("ret"));
            StatTracer.trackEvent(30042, optInt, bVar, cVar);
            return;
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            boolean a16 = a(optJSONObject2);
            List<TangramAd> arrayList = new ArrayList<>();
            Iterator<JSONObject> it = f.a(optJSONArray, new l(tAdRequest.posId, com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD, (com.qq.e.comm.plugin.base.ad.definition.a) null), str).iterator();
            while (it.hasNext()) {
                c cVar2 = new c(tAdRequest.appId, tAdRequest.posId, str, com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD, a16, it.next());
                cVar2.a(tangramAdListener);
                arrayList.add(cVar2);
            }
            if (arrayList.size() > 0) {
                StatTracer.trackEvent(30142, 0, bVar, cVar);
                a(tangramAdListener, arrayList);
                return;
            } else {
                StatTracer.trackEvent(30052, 0, bVar, cVar);
                a(tangramAdListener, 501);
                return;
            }
        }
        a(tangramAdListener, 501);
        StatTracer.trackEvent(30032, 3, bVar, cVar);
    }

    private void a(final TangramAdListener tangramAdListener, final List<TangramAd> list) {
        this.f38345a.post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                TangramAdListener tangramAdListener2 = tangramAdListener;
                if (tangramAdListener2 != null) {
                    tangramAdListener2.onADLoaded(list);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final TangramAdListener tangramAdListener, final int i3) {
        this.f38345a.post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                tangramAdListener.onNoAd(new AdError(i3, null));
            }
        });
    }

    private boolean a(JSONObject jSONObject) {
        return b(jSONObject) == 31;
    }
}
