package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c;

import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.pi.ICustomAdDataGenerator;
import com.qq.e.comm.pi.TGTQUICADLoader;
import com.qq.e.comm.plugin.base.ad.e.c;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.u;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.tangramsplash.c.c;
import com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b;
import com.qq.e.comm.plugin.tangramsplash.report.c;
import com.qq.e.comm.plugin.tangramsplash.selector.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.TGSplashPreCacheUtil;
import com.tencent.ams.fusion.service.splash.data.SplashNetDataRequest;
import com.tencent.ams.fusion.service.splash.data.e;
import com.tencent.ams.fusion.service.splash.data.f;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements f {

    /* renamed from: a, reason: collision with root package name */
    private ICustomAdDataGenerator f40048a;

    private static JSONObject b(com.tencent.ams.fusion.service.splash.data.b.a aVar) {
        if (SDKStatus.getSDKVersionCode() < 440) {
            GDTLogger.e("FusionAd[buildSplashTimeParam] PluginFeature is not supported");
            return null;
        }
        if (aVar == null) {
            GDTLogger.e("FusionAd[buildSplashTimeParam] splashNetDataRequest is null");
            return null;
        }
        JSONObject a16 = y.a();
        if (aVar.m() != Integer.MIN_VALUE) {
            y.a(a16, "sp_fetch_tt", aVar.m());
        }
        if (aVar.n() != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            y.a(a16, "sp_fetch_bt", aVar.n());
        }
        y.a(a16, "req_bt", System.currentTimeMillis());
        return a16;
    }

    @Override // mt.d
    public e a(SplashNetDataRequest splashNetDataRequest) {
        return null;
    }

    @Override // mt.d
    public void a(SplashNetDataRequest splashNetDataRequest, mt.b<SplashNetDataRequest, mt.c> bVar) {
        if (splashNetDataRequest != null && bVar != null) {
            if (splashNetDataRequest instanceof com.tencent.ams.fusion.service.splash.data.b.a) {
                com.tencent.ams.fusion.service.splash.data.b.a aVar = (com.tencent.ams.fusion.service.splash.data.b.a) splashNetDataRequest;
                c.b a16 = a(aVar);
                if (aVar.k()) {
                    a(a16, aVar, bVar);
                    return;
                } else {
                    a(a16, aVar, bVar, System.currentTimeMillis());
                    return;
                }
            }
            return;
        }
        GDTLogger.e("FusionAd requestAsync return invalid params");
    }

    private void a(final c.b bVar, final com.tencent.ams.fusion.service.splash.data.b.a aVar, final mt.b<SplashNetDataRequest, mt.c> bVar2) {
        if (bVar == null || bVar.f40338e == null || aVar == null || bVar2 == null) {
            return;
        }
        final c.a aVar2 = new c.a();
        aVar2.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                final long currentTimeMillis = System.currentTimeMillis();
                c.b bVar3 = bVar;
                com.qq.e.comm.plugin.base.ad.model.a aVar3 = new com.qq.e.comm.plugin.base.ad.model.a(bVar3.f40336c, com.qq.e.comm.plugin.base.ad.b.SPLASH, bVar3.f40335b);
                com.qq.e.comm.plugin.base.ad.model.b a16 = c.this.a(bVar);
                if (c.this.a(aVar3, currentTimeMillis, a16, bVar, aVar, bVar2, aVar2, false)) {
                    GDTLogger.i("FusionAddo custom ad loader");
                } else {
                    com.qq.e.comm.plugin.base.ad.e.c.a(a16, aVar3, new c.b() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.c.1.1
                        @Override // com.qq.e.comm.plugin.base.ad.e.c.b
                        public void a(JSONObject jSONObject) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (!c.this.a(bVar, jSONObject)) {
                                a(new com.qq.e.comm.plugin.base.ad.e.b.a("\u975e\u6cd5\u5e7f\u544a", -102));
                                return;
                            }
                            aVar2.d();
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            c.this.a(jSONObject, currentTimeMillis, aVar, bVar, (mt.b<SplashNetDataRequest, mt.c>) bVar2);
                        }

                        @Override // com.qq.e.comm.plugin.base.ad.e.c.b
                        public void a(com.qq.e.comm.plugin.base.ad.e.b.a aVar4) {
                            aVar2.e();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c.this.a(aVar4, aVar, (mt.b<SplashNetDataRequest, mt.c>) bVar2, currentTimeMillis, bVar);
                        }
                    });
                }
            }
        });
        com.qq.e.comm.plugin.tangramsplash.c.c.a().a(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final com.qq.e.comm.plugin.base.ad.model.a aVar, final long j3, final com.qq.e.comm.plugin.base.ad.model.b bVar, final c.b bVar2, final com.tencent.ams.fusion.service.splash.data.b.a aVar2, final mt.b<SplashNetDataRequest, mt.c> bVar3, final c.a aVar3, final boolean z16) {
        ICustomAdDataGenerator iCustomAdDataGenerator = this.f40048a;
        if (iCustomAdDataGenerator == null) {
            return false;
        }
        try {
            final String a16 = com.qq.e.comm.plugin.base.ad.e.c.a(com.qq.e.comm.plugin.base.ad.b.SPLASH);
            Map<String, String> a17 = com.qq.e.comm.plugin.base.ad.a.a(new PlainRequest(a16, 1, (byte[]) null), GDTADManager.getInstance(), bVar);
            final com.tencent.ams.fusion.service.splash.data.b.b bVar4 = new com.tencent.ams.fusion.service.splash.data.b.b();
            return iCustomAdDataGenerator.loadAD(a16, a17, new ICustomAdDataGenerator.LoadADCallback() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.c.2
                @Override // com.qq.e.comm.pi.ICustomAdDataGenerator.LoadADCallback
                public void onADLoadErr(int i3) {
                    if (z16) {
                        GDTLogger.e("FusionAd: LoadGDTSplashADFail:" + i3);
                        com.tencent.ams.fusion.service.splash.data.b.b bVar5 = bVar4;
                        bVar5.f70522b = i3;
                        bVar3.a(aVar2, bVar5);
                        return;
                    }
                    c.a aVar4 = aVar3;
                    if (aVar4 != null) {
                        aVar4.e();
                    }
                    c.this.a(new com.qq.e.comm.plugin.base.ad.e.b.a(new Exception(), i3), aVar2, (mt.b<SplashNetDataRequest, mt.c>) bVar3, j3, bVar2);
                }

                @Override // com.qq.e.comm.pi.ICustomAdDataGenerator.LoadADCallback
                public void onADLoadSucc(String str) {
                    com.qq.e.comm.plugin.base.ad.e.c.a(new PlainRequest(a16, 1, (byte[]) null), (Response) null, new c.a(bVar, aVar, new c.b() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.c.2.1
                        @Override // com.qq.e.comm.plugin.base.ad.e.c.b
                        public void a(JSONObject jSONObject) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (!c.this.a(bVar2, jSONObject)) {
                                a(new com.qq.e.comm.plugin.base.ad.e.b.a("\u975e\u6cd5\u5e7f\u544a", -102));
                                return;
                            }
                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                            if (z16) {
                                GDTLogger.i("FusionAd: SplashOnADLoadSuccess");
                                AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                                c.this.a(jSONObject, bVar3, bVar2, aVar2, j3);
                            } else {
                                c.a aVar4 = aVar3;
                                if (aVar4 != null) {
                                    aVar4.d();
                                }
                                AnonymousClass2 anonymousClass24 = AnonymousClass2.this;
                                c.this.a(jSONObject, j3, aVar2, bVar2, (mt.b<SplashNetDataRequest, mt.c>) bVar3);
                            }
                        }

                        @Override // com.qq.e.comm.plugin.base.ad.e.c.b
                        public void a(com.qq.e.comm.plugin.base.ad.e.b.a aVar4) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z16) {
                                GDTLogger.e("FusionAd: LoadGDTSplashADFail", aVar4);
                                bVar4.f70522b = aVar4.a();
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                bVar3.a(aVar2, bVar4);
                                return;
                            }
                            c.a aVar5 = aVar3;
                            if (aVar5 != null) {
                                aVar5.e();
                            }
                            AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                            c.this.a(aVar4, aVar2, (mt.b<SplashNetDataRequest, mt.c>) bVar3, j3, bVar2);
                        }
                    }, System.currentTimeMillis()).a(str));
                }
            });
        } catch (Throwable unused) {
            a(new com.qq.e.comm.plugin.base.ad.e.b.a(new Exception(), -101), aVar2, bVar3, j3, bVar2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c.b bVar, JSONObject jSONObject) {
        if (bVar != null && y.a(jSONObject)) {
            ArrayList arrayList = new ArrayList();
            com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.a(jSONObject, com.qq.e.comm.plugin.base.ad.b.SPLASH, bVar.f40334a, bVar.f40335b, bVar.f40336c, null, arrayList, false);
            if (g.b(arrayList)) {
                GDTLogger.e("no ad found");
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310531, bVar.f40335b, (r) null, -2);
                return false;
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                r rVar = (r) arrayList.get(i3);
                if (rVar != null) {
                    if (rVar.bR()) {
                        GDTLogger.e("not support AlternateAd!");
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310531, bVar.f40335b, (r) null, -3);
                        return false;
                    }
                    if (com.qq.e.comm.plugin.tangramsplash.a.c.a(rVar)) {
                        GDTLogger.e("not support first play!");
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310531, bVar.f40335b, (r) null, -4);
                        return false;
                    }
                    if (rVar.ax()) {
                        GDTLogger.e("not support PreviewOrder!");
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310531, bVar.f40335b, (r) null, -5);
                        return false;
                    }
                    if (com.qq.e.comm.plugin.tangramsplash.d.a.b(rVar) != null) {
                        GDTLogger.e("not support dayTimeCreativeInfo!");
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310531, bVar.f40335b, (r) null, -6);
                        return false;
                    }
                    if (com.qq.e.comm.plugin.tangramsplash.d.f.a(rVar)) {
                        GDTLogger.e("not support sub order!");
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310531, bVar.f40335b, (r) null, -7);
                        return false;
                    }
                    if (rVar.cc()) {
                        GDTLogger.e("not support AlphaVideo!");
                        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310531, bVar.f40335b, (r) null, -8);
                        return false;
                    }
                }
            }
            return true;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310531, (String) null, (r) null, -1);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, long j3, com.tencent.ams.fusion.service.splash.data.b.a aVar, c.b bVar, mt.b<SplashNetDataRequest, mt.c> bVar2) {
        LoadAdParams loadAdParams;
        GDTLogger.i("FusionAd onPreloadSuccess :");
        com.tencent.ams.fusion.service.splash.data.b.c cVar = new com.tencent.ams.fusion.service.splash.data.b.c();
        if (bVar != null && aVar != null && bVar2 != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("FusionAd onPreloadSuccess is refresh ?");
            LoadAdParams loadAdParams2 = bVar.f40338e;
            sb5.append(loadAdParams2 != null && loadAdParams2.isRefreshAdRequest());
            GDTLogger.i(sb5.toString());
            long currentTimeMillis = System.currentTimeMillis() - j3;
            l lVar = new l(bVar.f40335b, com.qq.e.comm.plugin.base.ad.b.SPLASH, (com.qq.e.comm.plugin.base.ad.definition.a) null);
            JSONArray a16 = com.qq.e.comm.plugin.k.b.a(jSONObject, bVar.f40335b);
            if (y.a(a16)) {
                GDTLogger.e("FusionAd onADLoadSuccess adList is empty");
                cVar.f70523a = 16;
                cVar.f70525c = bVar.f40338e.isRefreshAdRequest() ? 1 : 0;
                a(j3, aVar, bVar2, cVar);
                return;
            }
            for (int i3 = 0; i3 < a16.length(); i3++) {
                com.qq.e.comm.plugin.base.ad.c.f.a(a16.optJSONObject(i3), lVar, bVar.f40336c);
            }
            com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.d dVar = new com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.d();
            dVar.a(y.a(jSONObject) ? jSONObject.toString() : null);
            dVar.b(bVar.f40335b);
            cVar.f70524b = dVar;
            cVar.f70525c = bVar.f40338e.isRefreshAdRequest() ? 1 : 0;
            bVar2.b(aVar, cVar);
            LoadAdParams loadAdParams3 = bVar.f40338e;
            if (loadAdParams3 != null && !loadAdParams3.isRefreshAdRequest()) {
                TGSplashPreCacheUtil.clearResStateData();
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1320055, bVar.f40335b);
            }
            com.qq.e.comm.plugin.tangramsplash.c.e.a().a(bVar, currentTimeMillis, com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e), jSONObject);
            a();
            return;
        }
        GDTLogger.e("FusionAd params is invalid!");
        cVar.f70523a = -100;
        cVar.f70525c = (bVar == null || (loadAdParams = bVar.f40338e) == null || !loadAdParams.isRefreshAdRequest()) ? 0 : 1;
        a(j3, aVar, bVar2, cVar);
    }

    private static void a() {
        com.qq.e.comm.plugin.g.a.c.a();
    }

    private void a(long j3, com.tencent.ams.fusion.service.splash.data.b.a aVar, mt.b<SplashNetDataRequest, mt.c> bVar, com.tencent.ams.fusion.service.splash.data.b.c cVar) {
        if (bVar != null) {
            bVar.a(aVar, cVar);
        }
        if (aVar != null) {
            com.qq.e.comm.plugin.tangramsplash.c.e.a().a(aVar.b(), cVar != null ? cVar.f70523a : 0, System.currentTimeMillis() - j3, (String) null, aVar.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.base.ad.e.b.a aVar, com.tencent.ams.fusion.service.splash.data.b.a aVar2, mt.b<SplashNetDataRequest, mt.c> bVar, long j3, c.b bVar2) {
        LoadAdParams loadAdParams;
        GDTLogger.e("FusionAd \u9884\u52a0\u8f7d\u5931\u8d25\uff01", aVar);
        com.tencent.ams.fusion.service.splash.data.b.c cVar = new com.tencent.ams.fusion.service.splash.data.b.c();
        cVar.f70523a = aVar.a();
        cVar.f70525c = (bVar2 == null || (loadAdParams = bVar2.f40338e) == null || !loadAdParams.isRefreshAdRequest()) ? 0 : 1;
        a(j3, aVar2, bVar, cVar);
        a();
    }

    private void a(final c.b bVar, final com.tencent.ams.fusion.service.splash.data.b.a aVar, final mt.b<SplashNetDataRequest, mt.c> bVar2, final long j3) {
        if (bVar != null && aVar != null) {
            com.qq.e.comm.plugin.base.ad.model.b a16 = a(bVar, aVar);
            final com.tencent.ams.fusion.service.splash.data.b.b bVar3 = new com.tencent.ams.fusion.service.splash.data.b.b();
            if (SDKStatus.getSDKVersionCode() >= 400) {
                WeakReference<TGTQUICADLoader> tQUICLoader = GlobalSetting.getTQUICLoader();
                if (a16 != null && tQUICLoader != null && tQUICLoader.get() != null && com.qq.e.comm.plugin.j.c.a("openTQUIC", 0, 1)) {
                    GDTLogger.d("tquic open use custom TGTQUICLoader");
                    try {
                        String a17 = com.qq.e.comm.plugin.base.ad.e.c.a(com.qq.e.comm.plugin.base.ad.b.SPLASH);
                        tQUICLoader.get().request(a17, com.qq.e.comm.plugin.base.ad.a.a(new PlainRequest(a17, 1, (byte[]) null), GDTADManager.getInstance(), a16), new TGTQUICADLoader.Callback() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.c.3
                            @Override // com.qq.e.comm.pi.TGTQUICADLoader.Callback
                            public void onError(TGTQUICADLoader.Error error) {
                                if (error != null && error.getErrorType() != null) {
                                    GDTLogger.e("FusionAd: LoadGDTSplashADFail by TQUIC :" + error.getErrorCode());
                                    bVar3.f70522b = error.getErrorType().getType();
                                }
                                bVar2.a(aVar, bVar3);
                            }

                            @Override // com.qq.e.comm.pi.TGTQUICADLoader.Callback
                            public void onSuccess(String str) {
                                GDTLogger.d("FusionAd: SplashOnADLoadSuccess by TQUIC");
                                if (!c.this.a(bVar, y.a(str))) {
                                    onError(new TGTQUICADLoader.Error(TGTQUICADLoader.ErrorType.UNKNOWN, -102));
                                } else {
                                    c.this.a(y.a(str), bVar2, bVar, aVar, j3);
                                }
                            }
                        });
                        return;
                    } catch (Throwable th5) {
                        GDTLogger.e("FusionAd", th5);
                        return;
                    }
                }
                a(bVar, aVar, bVar2, a16, j3);
                return;
            }
            a(bVar, aVar, bVar2, a16, j3);
            return;
        }
        GDTLogger.e("setUpRealtimeRequest return paramsHolder == null || splashNetDataRequest == null");
    }

    private void a(final c.b bVar, final com.tencent.ams.fusion.service.splash.data.b.a aVar, final mt.b<SplashNetDataRequest, mt.c> bVar2, com.qq.e.comm.plugin.base.ad.model.b bVar3, final long j3) {
        com.qq.e.comm.plugin.base.ad.model.a aVar2 = new com.qq.e.comm.plugin.base.ad.model.a(bVar.f40336c, com.qq.e.comm.plugin.base.ad.b.SPLASH, aVar.b());
        if (a(aVar2, System.currentTimeMillis(), bVar3, bVar, aVar, bVar2, null, true)) {
            GDTLogger.i("FusionAddo custom ad loader in real time");
        } else {
            final com.tencent.ams.fusion.service.splash.data.b.b bVar4 = new com.tencent.ams.fusion.service.splash.data.b.b();
            com.qq.e.comm.plugin.base.ad.e.c.a(bVar3, aVar2, new c.b() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.c.4
                @Override // com.qq.e.comm.plugin.base.ad.e.c.b
                public void a(JSONObject jSONObject) {
                    GDTLogger.d("FusionAd: SplashOnADLoadSuccess");
                    if (!c.this.a(bVar, jSONObject)) {
                        a(new com.qq.e.comm.plugin.base.ad.e.b.a("\u975e\u6cd5\u5e7f\u544a", -102));
                    } else {
                        c.this.a(jSONObject, bVar2, bVar, aVar, j3);
                    }
                }

                @Override // com.qq.e.comm.plugin.base.ad.e.c.b
                public void a(com.qq.e.comm.plugin.base.ad.e.b.a aVar3) {
                    GDTLogger.e("FusionAd: LoadGDTSplashADFail", aVar3);
                    bVar4.f70522b = aVar3.a();
                    bVar2.a(aVar, bVar4);
                }
            });
        }
    }

    private c.b a(com.tencent.ams.fusion.service.splash.data.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        c.b bVar = new c.b();
        bVar.f40334a = aVar.a();
        String b16 = aVar.b();
        bVar.f40335b = b16;
        bVar.f40336c = com.qq.e.comm.plugin.k.a.a(bVar.f40334a, b16, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId());
        Map j3 = aVar.j();
        bVar.f40339f = j3 != null && ((Boolean) j3.get("fetch_ad_only")).booleanValue();
        bVar.f40340g = j3 != null ? ((Integer) j3.get("splashPreloadGap")).intValue() : 0;
        bVar.f40337d = new l(bVar.f40335b, com.qq.e.comm.plugin.base.ad.b.SPLASH, (com.qq.e.comm.plugin.base.ad.definition.a) null);
        bVar.f40338e = aVar.l() instanceof LoadAdParams ? (LoadAdParams) aVar.l() : null;
        return bVar;
    }

    public void a(ICustomAdDataGenerator iCustomAdDataGenerator) {
        this.f40048a = iCustomAdDataGenerator;
    }

    public e a(JSONObject jSONObject, final mt.b<SplashNetDataRequest, mt.c> bVar, c.b bVar2, final com.tencent.ams.fusion.service.splash.data.b.a aVar, long j3) {
        final com.tencent.ams.fusion.service.splash.data.b.b bVar3 = new com.tencent.ams.fusion.service.splash.data.b.b();
        com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b bVar4 = new com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b();
        bVar4.a(j3);
        bVar4.a(bVar2);
        bVar4.a(new b.a() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.c.5
            @Override // com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.a
            public void a(e eVar) {
                GDTLogger.d("FusionAddata service parseData success");
                bVar3.f70521a = eVar != null ? eVar.a() : null;
                bVar.b(aVar, bVar3);
            }

            @Override // com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.a
            public void a(int i3, int i16) {
                GDTLogger.d("FusionAddata service parseData onError failReason " + i3 + " errorCode " + i16);
                com.tencent.ams.fusion.service.splash.data.b.b bVar5 = bVar3;
                bVar5.f70522b = i16;
                bVar.a(aVar, bVar5);
            }
        });
        bVar4.a(jSONObject);
        return bVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qq.e.comm.plugin.base.ad.model.b a(c.b bVar) {
        LoadAdParams loadAdParams;
        com.qq.e.comm.plugin.base.ad.model.b a16 = a(bVar, false);
        JSONObject jSONObject = null;
        if (a16 == null) {
            return null;
        }
        a16.a(true);
        a16.l(1);
        if (bVar != null && (loadAdParams = bVar.f40338e) != null) {
            a16.c(loadAdParams.getUin());
            a16.b(bVar.f40338e.getLoginOpenid());
            a16.d(bVar.f40338e.getLoginAppId());
            a16.a(bVar.f40338e.getLoginType());
            a16.i(bVar.f40338e.getBlockEffectValue());
            if (SDKStatus.getSDKVersionCode() >= 50) {
                a16.a(bVar.f40338e.getPassThroughInfo());
            }
            if (SDKStatus.getSDKVersionCode() >= 70) {
                a16.e(bVar.f40338e.getUid());
            }
            if (SDKStatus.getSDKVersionCode() >= 90) {
                a16.a(bVar.f40338e.getExperimentId());
                a16.m(bVar.f40338e.getExperimentType());
            }
            if (SDKStatus.getSDKVersionCode() >= 450) {
                JSONObject a17 = y.a();
                if (bVar.f40338e.isGooglePlayVersion()) {
                    y.a(a17, "is_googleplay_version", true);
                }
                if (y.a(a17)) {
                    a16.b(a17);
                }
            }
            if (bVar.f40338e.isRefreshAdRequest()) {
                a16.h(1);
                List<r> a18 = com.qq.e.comm.plugin.tangramsplash.c.e.a().a(bVar.f40334a, bVar.f40335b, bVar.f40336c, com.qq.e.comm.plugin.base.ad.b.SPLASH, bVar.f40338e.isHotStart(), new c.a(0, 0));
                if (g.a(a18)) {
                    jSONObject = y.a();
                    for (int i3 = 0; i3 < a18.size(); i3++) {
                        y.a(jSONObject, i3 + "", a(a18.get(i3), true));
                    }
                }
                a16.a(jSONObject);
            }
        }
        return a16;
    }

    private com.qq.e.comm.plugin.base.ad.model.b a(c.b bVar, com.tencent.ams.fusion.service.splash.data.b.a aVar) {
        com.qq.e.comm.plugin.base.ad.model.b a16 = a(bVar, true);
        JSONObject jSONObject = null;
        if (a16 == null) {
            return null;
        }
        LoadAdParams loadAdParams = bVar.f40338e;
        if (loadAdParams != null) {
            a16.c(loadAdParams.getUin());
            a16.b(loadAdParams.getLoginOpenid());
            a16.d(loadAdParams.getLoginAppId());
            a16.a(loadAdParams.getLoginType());
            if (SDKStatus.getSDKVersionCode() >= 50) {
                a16.a(loadAdParams.getPassThroughInfo());
            }
            if (SDKStatus.getSDKVersionCode() >= 70) {
                a16.e(loadAdParams.getUid());
            }
            if (SDKStatus.getSDKVersionCode() >= 90) {
                a16.a(loadAdParams.getExperimentId());
                a16.m(loadAdParams.getExperimentType());
            }
            a16.c(b(aVar));
        }
        List<r> list = com.qq.e.comm.plugin.tangramsplash.selector.c.f40320a;
        if (list != null && list.size() > 0) {
            jSONObject = new JSONObject();
            for (r rVar : list) {
                List<u> bs5 = rVar.bs();
                if (bs5 != null && bs5.size() > 0) {
                    Iterator<u> it = bs5.iterator();
                    while (it.hasNext()) {
                        List<Integer> c16 = it.next().c();
                        if (c16 != null && c16.size() > 0) {
                            Iterator<Integer> it5 = c16.iterator();
                            while (it5.hasNext()) {
                                try {
                                    jSONObject.put(it5.next().toString(), a(rVar, false));
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
        a16.a(jSONObject);
        return a16;
    }

    private com.qq.e.comm.plugin.base.ad.model.b a(c.b bVar, boolean z16) {
        if (bVar != null && bVar.f40338e != null) {
            com.qq.e.comm.plugin.base.ad.model.b bVar2 = new com.qq.e.comm.plugin.base.ad.model.b();
            bVar2.a(bVar.f40335b);
            bVar2.a(1);
            if (z16) {
                bVar2.b(1);
            } else {
                bVar2.b(GDTADManager.getInstance().getSM().getInteger("splashPreloadAdCount", 5));
            }
            bVar2.c(2);
            com.qq.e.comm.plugin.base.ad.b bVar3 = com.qq.e.comm.plugin.base.ad.b.SPLASH;
            bVar2.f(bVar3.b());
            com.qq.e.comm.plugin.base.ad.definition.a a16 = com.qq.e.comm.plugin.base.ad.a.a(bVar3, GDTADManager.getInstance().getDeviceStatus().getDeviceDensity());
            if (a16 != null) {
                bVar2.d(a16.a());
                bVar2.e(a16.b());
            }
            boolean a17 = com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e);
            GDTLogger.d("getAdRequestData is hotStart :" + a17);
            if (a17) {
                bVar2.j(com.qq.e.comm.plugin.tangramsplash.d.f.d(bVar.f40335b));
            } else {
                bVar2.j(com.qq.e.comm.plugin.tangramsplash.d.f.c(bVar.f40335b));
            }
            bVar2.c(a17);
            bVar2.b(z16);
            bVar2.f("__QQOPENID__");
            return bVar2;
        }
        GDTLogger.d("getAdRequestData return");
        return null;
    }

    private JSONObject a(r rVar, boolean z16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_id", rVar.f());
            jSONObject.put("cid", rVar.at());
            jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UOID, rVar.bn());
            if (!z16) {
                jSONObject.put("is_empty", rVar.bk() ? 1 : 0);
                jSONObject.put("is_contract", rVar.bb() ? 1 : 0);
                jSONObject.put("status", com.qq.e.comm.plugin.tangramsplash.b.c.a(rVar) ? 0 : 1);
            }
        } catch (JSONException e16) {
            GDTLogger.e("real time selector error", e16);
        }
        return jSONObject;
    }
}
