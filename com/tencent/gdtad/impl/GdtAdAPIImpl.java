package com.tencent.gdtad.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.adapter.y;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.aditem.GdtWxHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.splash.IGdtSplashAPI;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.statistics.GdtReporterForAnalysis;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.d;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.splashad.SplashEmptyReportHelper;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes6.dex */
public class GdtAdAPIImpl implements IGdtAdAPI {
    public static final String TAG = "GdtAdAPIImpl";

    @Override // com.tencent.gdtad.IGdtAdAPI
    public AdError checkWeChatApp(Context context, String str, int i3) {
        return y.a(context, str, i3);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void doAfterLoginAndMessageLoaded() {
        boolean z16;
        GdtLog.i(TAG, "doAfterLoginAndMessageLoaded");
        try {
            ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).doAfterLoginAndMessageLoaded();
        } catch (Throwable th5) {
            GdtLog.e(TAG, "doAfterLoginAndMessageLoaded", th5);
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                SplashADUtil.z(BaseApplication.getContext(), peekAppRuntime.getLongAccountUin());
            }
        } catch (Throwable th6) {
            GdtLog.e(TAG, "updateUin ", th6);
        }
        GdtReporterForAnalysis.d(BaseApplication.getContext());
        if (1 == MobileQQ.sProcessId) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AdMetricService.getInstance().setReportEnabled(new WeakReference<>(BaseApplication.getContext()), true);
        }
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void doCgiReport(String str) {
        GdtReporter.doCgiReport(str);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public String getSpUin() {
        return String.valueOf(SplashADUtil.i(BaseApplicationImpl.getApplication()));
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void handleGdtAdClick(GdtHandler.Params params) {
        GdtHandler.handle(params);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void initGdtContext(Context context, @Nullable InitGdtContextParams initGdtContextParams) {
        GdtManager.a aVar;
        if (initGdtContextParams != null) {
            aVar = new GdtManager.a();
        } else {
            aVar = null;
        }
        GdtManager.q().r(context, aVar);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public boolean isAmsSplashExceedLimit(boolean z16) {
        return SplashADUtil.x(2, z16);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public AdClickUtil.Result jumpToWechatMiniApp(Handler handler, @NonNull GdtAd gdtAd) {
        return GdtWxHandler.a(handler, gdtAd);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    @NonNull
    public GdtAdLoader loadAd(GdtAdLoader.Session session, WeakReference<GdtAdLoader.Listener> weakReference, WeakReference<Context> weakReference2) {
        GdtAdLoader gdtAdLoader = new GdtAdLoader(session, weakReference);
        gdtAdLoader.load(weakReference2);
        return gdtAdLoader;
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void pauseAdFileDownload(FileManagerEntity fileManagerEntity) {
        d.f109551a.g(fileManagerEntity);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void preLoadAfterAdExposure(Context context, GdtAd gdtAd) {
        GdtPreLoader.c().g(gdtAd);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void preLoadAfterAdLoaded(Context context, GdtAd gdtAd) {
        GdtPreLoader.c().h(gdtAd);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void refreshAdDownloadTipBanner() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gdtad.impl.GdtAdAPIImpl.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.gdtad.util.b.f109548a.g();
            }
        });
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void showFeedbackDialogFragment(AdFeedbackParams adFeedbackParams) {
        Activity activity;
        GdtLog.i(TAG, "[showFeedbackDialogFragment]");
        if (adFeedbackParams != null && adFeedbackParams.isValid()) {
            activity = adFeedbackParams.activity.get();
        } else {
            activity = null;
        }
        if (activity != null) {
            GdtManager.q().r(activity.getApplicationContext(), new GdtManager.a());
        }
        AdFeedbackDialogFragment.start(adFeedbackParams);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void startAdFileDownload(FileManagerEntity fileManagerEntity) {
        d.f109551a.h(fileManagerEntity);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void updateAdDownloadFile(DownloadInfo downloadInfo) {
        d.f109551a.i(downloadInfo);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void updateAdDownloadNotice(DownloadInfo downloadInfo) {
        com.tencent.open.appstore.notice.b.f340906a.c(downloadInfo);
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void updateAmsSplashShowTime(boolean z16, boolean z17) {
        if (z17) {
            SplashADUtil.E(2, z16);
        } else {
            SplashADUtil.B();
        }
    }

    @Override // com.tencent.gdtad.IGdtAdAPI
    public void updateSplashEmptyOrderParams(boolean z16, boolean z17, int i3) {
        SplashEmptyReportHelper.f288736a.d(z16, z17, i3);
    }
}
