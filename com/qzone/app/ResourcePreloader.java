package com.qzone.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.qzone.common.account.LoginData;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.IOnPictrueLoadListener;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.TimeCostTrace;

/* loaded from: classes39.dex */
public class ResourcePreloader {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f44466c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ResourcePreloader f44467d = null;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f44468e = false;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f44469f;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f44470a = false;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f44471b = false;

    public static ResourcePreloader b() {
        if (f44467d == null) {
            synchronized (f44466c) {
                if (f44467d == null) {
                    f44467d = new ResourcePreloader();
                }
            }
        }
        return f44467d;
    }

    public Context c() {
        return BaseApplication.getContext();
    }

    public void d() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.app.ResourcePreloader.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady();
                } catch (Exception e16) {
                    QLog.e(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preloadAEResource", e16);
                }
            }
        });
    }

    public void e() {
        if (this.f44470a) {
            return;
        }
        PerfTracer.traceStart(PerfTracer.PRELOAD_COVER);
        CoverComponentProxy coverComponentProxy = CoverComponentProxy.f50099g;
        CoverCacheData coverFromCache = coverComponentProxy.getServiceInterface().getCoverFromCache(LoginData.getInstance().getUin());
        RFWLog.d("QZonePreloader", RFWLog.USR, "preloadCover: " + coverFromCache);
        if (coverFromCache == null) {
            PerfTracer.traceEnd(PerfTracer.PRELOAD_COVER);
            return;
        }
        coverComponentProxy.getServiceInterface().getCoverPreviewPictureUrl(coverFromCache, new a(coverFromCache));
        QZoneHelper.isBestPerformanceDevice();
        PerfTracer.traceEnd(PerfTracer.PRELOAD_COVER);
    }

    public void f(Context context) {
        PerfTracer.traceStart("preload_facade_resource");
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_FACADE, 1);
        QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "preload_facade_resource preloadFlagType=" + config);
        if (context == null) {
            QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "preload_facade_resource context is null");
            return;
        }
        int e16 = com.qzone.homepage.ui.Facade.h.l().e(LoginData.getInstance().getUin());
        QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "@facateshow isShowFacade =" + e16);
        if (e16 == 0 || config == 0) {
            return;
        }
        if (config != 0) {
            if (config == 1) {
                if (!com.qzone.homepage.ui.Facade.h.l().m().equals(com.qzone.homepage.ui.Facade.h.l().f(context, LoginData.getInstance().getUin()))) {
                    QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "@facateshow preload_facade_resource preloadFlagType =" + config + "first show date");
                    com.qzone.homepage.ui.Facade.h.l().h(LoginData.getInstance().getUin());
                } else {
                    QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "@facateshow preload_facade_resource preloadFlagType =" + config + "date equal");
                    com.qzone.homepage.ui.Facade.h.l().w(true);
                }
            } else if (config == 2) {
                QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "preload_facade_resource preloadFlagType =" + config);
                com.qzone.homepage.ui.Facade.h.l().h(LoginData.getInstance().getUin());
            }
        }
        PerfTracer.traceEnd("preload_facade_resource");
    }

    public void g() {
        if (((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isFirstLaunchNew()) {
            QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "first launch: preloadFeedDataWhenNoCache");
            h();
        }
    }

    public void h() {
        if (this.f44470a) {
            return;
        }
        PerfTracer.traceStart(PerfTracer.PRELOAD_FRIENDFEED_DATA);
        QZoneFeedService U = QZoneFeedService.U();
        U.o0();
        if (!U.f0() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_ACTIVEFEEDS, 1) == 1) {
            U.n0();
        }
        f44468e = true;
        PerfTracer.traceEnd(PerfTracer.PRELOAD_FRIENDFEED_DATA);
    }

    public void i() {
        if (this.f44470a) {
            return;
        }
        PerfTracer.traceStart(PerfTracer.PRELOAD_NICK_NAME);
        s8.f.f().j();
        PerfTracer.traceEnd(PerfTracer.PRELOAD_NICK_NAME);
    }

    public void j() {
        if (f44469f) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.app.ResourcePreloader.4
            @Override // java.lang.Runnable
            public void run() {
                com.qzone.business.surprise.b.h().e();
                ResourcePreloader.f44469f = true;
                QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "start preload surprise resource.");
            }
        });
    }

    public void l(String str) {
        if (ImageLoader.getInstance().loadImage(str, new b()) != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "download card sucess,url:" + str);
            }
            Intent intent = new Intent("QZoneCardPreDownload");
            intent.putExtra("cardurl", str);
            intent.putExtra("result", "sucess");
            if (QLog.isColorLevel()) {
                QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "actionString: " + intent.getAction());
            }
            BaseApplication.getContext().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements IOnPictrueLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CoverCacheData f44472a;

        a(CoverCacheData coverCacheData) {
            this.f44472a = coverCacheData;
        }

        @Override // com.qzone.proxy.covercomponent.IOnPictrueLoadListener
        public void onImageLoaded(String str, Drawable drawable) {
            if (str == null || str.length() <= 0 || QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(this.f44472a.type)) {
                return;
            }
            CoverComponentProxy.f50099g.getServiceInterface().setLoginUserCoverUrl(str);
        }
    }

    public void k() {
        this.f44470a = false;
    }

    /* loaded from: classes39.dex */
    class b implements ImageLoader.ImageLoadListener {
        b() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            if (QZLog.isColorLevel()) {
                QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "download card canceled,url:" + str);
            }
            Intent intent = new Intent("QZoneCardPreDownload");
            intent.putExtra("cardurl", str);
            intent.putExtra("result", "sucess");
            if (QLog.isColorLevel()) {
                QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "actionString: " + intent.getAction());
            }
            BaseApplication.getContext().sendBroadcast(intent);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            if (QZLog.isColorLevel()) {
                QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "download card failed,url:" + str);
            }
            Intent intent = new Intent("QZoneCardPreDownload");
            intent.putExtra("cardurl", str);
            intent.putExtra("result", "sucess");
            if (QLog.isColorLevel()) {
                QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "actionString: " + intent.getAction());
            }
            BaseApplication.getContext().sendBroadcast(intent);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (QZLog.isColorLevel()) {
                QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "download card onImageLoaded sucess,url:" + str);
            }
            Intent intent = new Intent("QZoneCardPreDownload");
            intent.putExtra("cardurl", str);
            intent.putExtra("result", "sucess");
            if (QLog.isColorLevel()) {
                QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "actionString: " + intent.getAction());
            }
            BaseApplication.getContext().sendBroadcast(intent);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
