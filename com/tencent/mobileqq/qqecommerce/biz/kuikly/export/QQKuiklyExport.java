package com.tencent.mobileqq.qqecommerce.biz.kuikly.export;

import android.content.Context;
import com.dataline.compose.DatalineModule;
import com.tencent.gdtad.kuikly.IGdtKuiklyAPI;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.filemanager.api.IQQFileKuiklyApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.gamecenter.kuikly.api.IQQKuiklyViewCreatorApi;
import com.tencent.mobileqq.guild.api.IGuildKuiklyApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyBundleModule;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyMediaModule;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyPlatformApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQUIModule;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.aa;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.al;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.h;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.i;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.j;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.p;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.r;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.t;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.QQAppTDFModule;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.QQOfflineModule;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.QQRedPointModule;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf.QQWidgetModule;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.x;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.y;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQComposeMarkdownShadow;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQComposeMarkdownView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyHippyView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPageView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyVideoAnimationView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyWebView;
import com.tencent.mobileqq.qqgamepub.api.IQQGameKuiklyApi;
import com.tencent.mobileqq.qqshop.api.IQQShopKuiklyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi;
import com.tencent.mobileqq.search.module.QQSearchModule;
import com.tencent.mobileqq.springhb.kuikly.SpringKuiklyModule;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthKuiklyApi;
import com.tencent.mobileqq.weather.api.IWeatherKuiklyApi;
import com.tencent.mobileqq.wxmini.api.IWxMiniAdAPI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi;
import com.tencent.qzonehub.api.IQZoneComposeApi;
import com.tencent.tdf.module.TDFBaseModule;
import com.tencent.tdf.module.TDFModuleContext;
import com.tencent.tdf.module.TDFModuleProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import of2.bh;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/QQKuiklyExport;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/e;", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "", "registerExternalModule", "registerTDFlModule", "registerExternalRenderView", "registerViewExternalPropHandler", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyExport implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e {

    /* renamed from: a, reason: collision with root package name */
    public static final QQKuiklyExport f262900a = new QQKuiklyExport();

    QQKuiklyExport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TDFBaseModule e(TDFModuleContext tDFModuleContext) {
        return new QQOfflineModule(tDFModuleContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TDFBaseModule f(TDFModuleContext tDFModuleContext) {
        return new QQRedPointModule(tDFModuleContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TDFBaseModule g(TDFModuleContext tDFModuleContext) {
        return new QQAppTDFModule(tDFModuleContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TDFBaseModule h(TDFModuleContext tDFModuleContext) {
        return new QQWidgetModule(tDFModuleContext);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerExternalModule(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        pg2.b.f426174a.d(kuiklyRenderExport);
        kuiklyRenderExport.a("QKRNetworkModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.b();
            }
        });
        kuiklyRenderExport.a("QQKuiklyPlatformApi", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new QQKuiklyPlatformApi();
            }
        });
        kuiklyRenderExport.a("QQKuiklyHippyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new h();
            }
        });
        kuiklyRenderExport.a("QQKuiklyBundleModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new QQKuiklyBundleModule();
            }
        });
        kuiklyRenderExport.a("QQKuiklyMediaModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new QQKuiklyMediaModule();
            }
        });
        kuiklyRenderExport.a("QQKuiklyPerformanceModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new j();
            }
        });
        kuiklyRenderExport.a("QQKuiklyFontModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.g();
            }
        });
        kuiklyRenderExport.a("QQKuiklyPublicAccountModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new p();
            }
        });
        kuiklyRenderExport.a("QQKuiklyVasJSIModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new r();
            }
        });
        kuiklyRenderExport.a("KRNotifyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new a();
            }
        });
        kuiklyRenderExport.a("QQUIModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new QQUIModule();
            }
        });
        kuiklyRenderExport.a("QQKuiklyDataModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f();
            }
        });
        kuiklyRenderExport.a("KRSSRModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new aa();
            }
        });
        kuiklyRenderExport.a("QQSearchModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new QQSearchModule();
            }
        });
        kuiklyRenderExport.a("QQPermissionModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.mobileqq.search.module.a();
            }
        });
        kuiklyRenderExport.a("QQKuiklyCalendarModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.e();
            }
        });
        kuiklyRenderExport.a("QQKuiklyLocationModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new i();
            }
        });
        kuiklyRenderExport.a("QQKuiklyWebSocketModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new y();
            }
        });
        kuiklyRenderExport.a("QQKuiklyWebDataModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new x();
            }
        });
        kuiklyRenderExport.a("DatalineModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new DatalineModule();
            }
        });
        kuiklyRenderExport.a("QQCirKuiklyAPIModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.d();
            }
        });
        kuiklyRenderExport.a("KTIKernelFlashTransferService", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new bh();
            }
        });
        kuiklyRenderExport.a("QQKuiklyWXModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new t();
            }
        });
        kuiklyRenderExport.a("VueModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalModule$1$25
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new al();
            }
        });
        ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IWeatherKuiklyApi) QRoute.api(IWeatherKuiklyApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IQWalletKuiklyApi) QRoute.api(IQWalletKuiklyApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IQQShopKuiklyApi) QRoute.api(IQQShopKuiklyApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IQQGameKuiklyApi) QRoute.api(IQQGameKuiklyApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IQQKuiklyViewCreatorApi) QRoute.api(IQQKuiklyViewCreatorApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IQQHealthKuiklyApi) QRoute.api(IQQHealthKuiklyApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IDTAPI) QRoute.api(IDTAPI.class)).registerExternalModule(kuiklyRenderExport);
        ((IGuildKuiklyApi) QRoute.api(IGuildKuiklyApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IO3AssistantRobotApi) QRoute.api(IO3AssistantRobotApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IQQFileKuiklyApi) QRoute.api(IQQFileKuiklyApi.class)).registerExternalModule(kuiklyRenderExport);
        ((IQZoneComposeApi) QRoute.api(IQZoneComposeApi.class)).registerExternalModule(kuiklyRenderExport);
        SpringKuiklyModule.INSTANCE.a(kuiklyRenderExport);
        try {
            ((IGdtKuiklyAPI) QRoute.api(IGdtKuiklyAPI.class)).registerExternalModule(kuiklyRenderExport);
        } catch (Throwable th5) {
            QLog.e("QQKuiklyExport", 1, "[registerExternalModule]IGdtKuiklyAPI", th5);
        }
        try {
            ((IWxMiniAdAPI) QRoute.api(IWxMiniAdAPI.class)).registerGameCenterKuiklyExternalModule(kuiklyRenderExport);
        } catch (Throwable th6) {
            QLog.e("QQKuiklyExport", 1, "[registerExternalModule]IGdtKuiklyAPI", th6);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerExternalRenderView(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        pg2.b.f426174a.e(kuiklyRenderExport);
        b.a.a(kuiklyRenderExport, "QQKuiklyPageView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new QQKuiklyPageView(it);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "QQKuiklyHippyView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalRenderView$1$2
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new QQKuiklyHippyView(it);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "QQKuiklyWebView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalRenderView$1$3
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new QQKuiklyWebView(it);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "QQKuiklyVideoAnimationView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalRenderView$1$4
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new QQKuiklyVideoAnimationView(it);
            }
        }, null, 4, null);
        kuiklyRenderExport.g("QQComposeMarkdownView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalRenderView$1$5
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new QQComposeMarkdownView(it);
            }
        }, new Function0<i01.b>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport$registerExternalRenderView$1$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.b invoke() {
                return new QQComposeMarkdownShadow();
            }
        });
        ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).registerExternalRenderView(kuiklyRenderExport);
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).registerExternalRenderView(kuiklyRenderExport);
        ((IDTAPI) QRoute.api(IDTAPI.class)).registerExternalView(kuiklyRenderExport);
        ((IGuildKuiklyApi) QRoute.api(IGuildKuiklyApi.class)).registerExternalRenderView(kuiklyRenderExport);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerTDFlModule(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        kuiklyRenderExport.f(QQOfflineModule.class, new TDFModuleProvider() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.c
            @Override // com.tencent.tdf.module.TDFModuleProvider
            public final TDFBaseModule get(TDFModuleContext tDFModuleContext) {
                TDFBaseModule e16;
                e16 = QQKuiklyExport.e(tDFModuleContext);
                return e16;
            }
        });
        kuiklyRenderExport.f(QQRedPointModule.class, new TDFModuleProvider() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.d
            @Override // com.tencent.tdf.module.TDFModuleProvider
            public final TDFBaseModule get(TDFModuleContext tDFModuleContext) {
                TDFBaseModule f16;
                f16 = QQKuiklyExport.f(tDFModuleContext);
                return f16;
            }
        });
        kuiklyRenderExport.f(QQAppTDFModule.class, new TDFModuleProvider() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.e
            @Override // com.tencent.tdf.module.TDFModuleProvider
            public final TDFBaseModule get(TDFModuleContext tDFModuleContext) {
                TDFBaseModule g16;
                g16 = QQKuiklyExport.g(tDFModuleContext);
                return g16;
            }
        });
        kuiklyRenderExport.f(QQWidgetModule.class, new TDFModuleProvider() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.f
            @Override // com.tencent.tdf.module.TDFModuleProvider
            public final TDFBaseModule get(TDFModuleContext tDFModuleContext) {
                TDFBaseModule h16;
                h16 = QQKuiklyExport.h(tDFModuleContext);
                return h16;
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerViewExternalPropHandler(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        pg2.b.f426174a.f(kuiklyRenderExport);
    }
}
