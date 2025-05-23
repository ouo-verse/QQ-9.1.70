package com.qq.e.comm.plugin.router;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.tangramsplash.b.c;
import com.qq.e.comm.plugin.tangramsplash.e.d;
import com.qq.e.comm.plugin.tangramsplash.report.SplashLinkReporter;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.adapter.TGSplashInterPage;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SplashRouterHelper {
    static SplashPresenter sPresenter = new SplashPresenter();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class SplashPresenter extends BasePresenter implements PublicApi.SplashApi {
        SplashPresenter() {
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.SplashApi
        public boolean checkPreloadSplashMaterial(Object obj) {
            if (obj instanceof r) {
                return c.a((r) obj);
            }
            return false;
        }

        @Override // com.qq.e.comm.plugin.router.BasePresenter
        public Map<Class<? extends ModuleApi>, ModuleApi> getModuleApi() {
            HashMap hashMap = new HashMap();
            hashMap.put(PublicApi.SplashApi.class, this);
            return hashMap;
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.SplashApi
        public void reportOutSplashEvent(int i3, String str, String str2) {
            SplashLinkReporter.a(i3, str, str2);
        }

        @Override // com.qq.e.comm.plugin.router.PublicApi.SplashApi
        public void startInterPage(Object obj, int i3) {
            Context appContext = GDTADManager.getInstance().getAppContext();
            if (appContext == null) {
                GDTLogger.e("[startInterPage] context is null");
                return;
            }
            if (!(obj instanceof r)) {
                GDTLogger.e("[startInterPage] adInfo error");
                return;
            }
            final d dVar = new d(appContext, (r) obj);
            final long currentTimeMillis = System.currentTimeMillis();
            dVar.b();
            aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.router.SplashRouterHelper.SplashPresenter.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    int i16;
                    try {
                        i16 = dVar.a();
                    } catch (Throwable th5) {
                        GDTLogger.e("[startInterPage] error:", th5);
                        i16 = 0;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    dVar.a(0, i16 ^ 1, currentTimeMillis2);
                    GDTLogger.i("[startInterPage] + cost time:" + currentTimeMillis2);
                    if (i16 != 0) {
                        TGSplashInterPage.getInstance().startOlympicPage(dVar);
                    }
                }
            });
        }
    }
}
