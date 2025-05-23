package com.tencent.gdtad.splash;

import android.os.Bundle;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.setting.QQSetting;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.PrivacyPolicyListener;
import com.qq.e.tg.splash.adapter.TGSplashInterPage;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.splash.adapter.GdtSplashThreadPoolAdapter;
import com.tencent.gdtad.splash.impl.GdtCustomLandingPageListenerImpl;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class o {

    /* renamed from: i, reason: collision with root package name */
    private static volatile o f109393i;

    /* renamed from: a, reason: collision with root package name */
    private a f109394a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.gdtad.splash.adapter.a f109395b;

    /* renamed from: c, reason: collision with root package name */
    private final GdtSplashThreadPoolAdapter f109396c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.gdtad.splash.adapter.c f109397d;

    /* renamed from: e, reason: collision with root package name */
    private final GdtCustomLandingPageListenerImpl f109398e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.gdtad.splash.adapter.b f109399f;

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.gdtad.splash.a f109400g;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.gdtad.splash.view.d f109401h;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static final class a implements PrivacyPolicyListener {
        a() {
        }

        @Override // com.qq.e.comm.pi.PrivacyPolicyListener
        public boolean hasAgreed() {
            return PrivacyPolicyHelper.isUserAllow();
        }
    }

    o() {
        GdtSplashDeviceInfoUtil.b();
        QQSetting.setQQAppVersion(AppSetting.f99551k);
        QQSetting.setQQAppVersionId(AppSetting.f());
        this.f109394a = new a();
        QQSetting.setPrivacyPolicyListener(new WeakReference(this.f109394a));
        GdtSplashThreadPoolAdapter gdtSplashThreadPoolAdapter = new GdtSplashThreadPoolAdapter();
        this.f109396c = gdtSplashThreadPoolAdapter;
        GdtSDKThreadManager.getInstance().setAdapter(new WeakReference<>(gdtSplashThreadPoolAdapter));
        com.tencent.gdtad.splash.adapter.c cVar = new com.tencent.gdtad.splash.adapter.c();
        this.f109397d = cVar;
        GlobalSetting.setTangramAdLogger(cVar);
        this.f109395b = new com.tencent.gdtad.splash.adapter.a();
        com.tencent.ams.fusion.service.kv.b.b().m(new WeakReference<>(this.f109395b));
        GdtCustomLandingPageListenerImpl gdtCustomLandingPageListenerImpl = new GdtCustomLandingPageListenerImpl();
        this.f109398e = gdtCustomLandingPageListenerImpl;
        GlobalSetting.setCustomLandingPageListener(new WeakReference(gdtCustomLandingPageListenerImpl));
        GlobalSetting.setCustomBundle(a());
        com.tencent.gdtad.splash.adapter.b bVar = new com.tencent.gdtad.splash.adapter.b();
        this.f109399f = bVar;
        GlobalSetting.setTGChangeBackgroundStatusListener(new WeakReference(bVar));
        com.tencent.gdtad.splash.a aVar = new com.tencent.gdtad.splash.a();
        this.f109400g = aVar;
        QQSetting.setSrcDownloadPermissionListener(new WeakReference(aVar));
        ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).setAdRequestToTestSever();
        com.tencent.gdtad.splash.view.d dVar = new com.tencent.gdtad.splash.view.d();
        this.f109401h = dVar;
        TGSplashInterPage.getInstance().setAdapter(new WeakReference<>(dVar));
        TGSplashInterPage.getInstance().setClickListener(new WeakReference<>(com.tencent.gdtad.splash.view.c.f109468a.a()));
    }

    private static Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("big_brother_source_key", "biz_src_jc_splash_screen");
        return bundle;
    }

    public static o b() {
        if (f109393i == null) {
            synchronized (o.class) {
                if (f109393i == null) {
                    f109393i = new o();
                }
            }
        }
        return f109393i;
    }
}
