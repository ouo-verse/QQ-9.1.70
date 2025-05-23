package com.tencent.qqmini.miniapp.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.core.utils.g;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AdReportData;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import com.tencent.qqmini.sdk.widget.media.IVideoPlayerUIImpl;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppBrandRuntime extends BaseAppBrandRuntime {
    public static final String MAP_TAG = "MiniAppMapTag";
    private static final String TAG = "minisdk-start_AppBrandRuntime";
    public static final String VIEW_TAG = "MiniAppVideoPlayer";
    public static volatile boolean webviewDataDirectoryInited = false;
    private Boolean isGettingScreenShot;
    private List<String> loadedAppServiceJsList;
    public MiniAppWorkerManager mMiniAppWorkerManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CaptureImageListener implements AbsVideoPlayer.OnCaptureImageListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<Activity> f346214a;

        /* renamed from: b, reason: collision with root package name */
        private ViewGroup f346215b;

        /* renamed from: c, reason: collision with root package name */
        private View f346216c;

        /* renamed from: d, reason: collision with root package name */
        private ICaptureImageCallback f346217d;

        public CaptureImageListener(Activity activity, ViewGroup viewGroup, View view, ICaptureImageCallback iCaptureImageCallback) {
            this.f346214a = new WeakReference<>(activity);
            this.f346215b = viewGroup;
            this.f346216c = view;
            this.f346217d = iCaptureImageCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Bitmap bitmap, int i3, final Bitmap bitmap2) {
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                Canvas canvas = new Canvas(bitmap2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f346216c.getLayoutParams();
                canvas.drawBitmap(bitmap, marginLayoutParams.leftMargin, marginLayoutParams.topMargin, (Paint) null);
                ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.AppBrandRuntime.CaptureImageListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CaptureImageListener.this.f346217d != null) {
                            CaptureImageListener.this.f346217d.onResult(bitmap2);
                        }
                    }
                });
                return;
            }
            ICaptureImageCallback iCaptureImageCallback = this.f346217d;
            if (iCaptureImageCallback != null) {
                iCaptureImageCallback.onResult(null);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener
        public void onCaptureImageFailed() {
            WeakReference<Activity> weakReference = this.f346214a;
            if (weakReference != null && weakReference.get() != null) {
                SaveCaptureImageUtil.c(this.f346214a.get(), this.f346215b, this.f346217d);
            } else {
                QMLog.e(AppBrandRuntime.TAG, "onCaptureImageFailed mRefActivity is null!");
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener
        public void onCaptureImageSucceed(final Bitmap bitmap) {
            WeakReference<Activity> weakReference = this.f346214a;
            if (weakReference != null && weakReference.get() != null) {
                if (bitmap != null) {
                    SaveCaptureImageUtil.e(this.f346214a.get(), this.f346215b, new SaveCaptureImageUtil.b() { // from class: com.tencent.qqmini.miniapp.core.a
                        @Override // com.tencent.qqmini.sdk.utils.SaveCaptureImageUtil.b
                        public final void onScreenShotFinished(int i3, Bitmap bitmap2) {
                            AppBrandRuntime.CaptureImageListener.this.c(bitmap, i3, bitmap2);
                        }
                    });
                    return;
                } else {
                    SaveCaptureImageUtil.c(this.f346214a.get(), this.f346215b, this.f346217d);
                    return;
                }
            }
            QMLog.e(AppBrandRuntime.TAG, "onCaptureImageSucceed mRefActivity is null!");
        }
    }

    public AppBrandRuntime(Context context) {
        super(context);
        this.isGettingScreenShot = Boolean.FALSE;
        this.loadedAppServiceJsList = new ArrayList();
        g.b(context);
    }

    private void captureImageForVideoPlayer(ICaptureImageCallback iCaptureImageCallback, ViewGroup viewGroup, View view) {
        QMLog.i(TAG, "captureImageForVideoPlayer!");
        ((IVideoPlayerUIImpl) view).getController().captureImage(new CaptureImageListener(this.mActivity, viewGroup, view, iCaptureImageCallback));
    }

    private void initEmbeddedState() {
        IAppBrandService iAppBrandService = this.appBrandService;
        if (iAppBrandService != null) {
            iAppBrandService.initEmbeddedState(getEmbeddedState());
        }
    }

    private void shotWebview(final ICaptureImageCallback iCaptureImageCallback, AppBrandPage appBrandPage, final ViewGroup viewGroup) {
        appBrandPage.getCurrentPageWebview().shotWebview(new PageWebview.WebviewShotCallback() { // from class: com.tencent.qqmini.miniapp.core.AppBrandRuntime.4
            @Override // com.tencent.qqmini.miniapp.core.page.PageWebview.WebviewShotCallback
            public void onShotReady(final Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.AppBrandRuntime.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ICaptureImageCallback iCaptureImageCallback2 = iCaptureImageCallback;
                            if (iCaptureImageCallback2 != null) {
                                iCaptureImageCallback2.onResult(bitmap);
                                AppBrandRuntime.this.isGettingScreenShot = Boolean.FALSE;
                            }
                        }
                    });
                    return;
                }
                ICaptureImageCallback iCaptureImageCallback2 = iCaptureImageCallback;
                if (iCaptureImageCallback2 != null) {
                    SaveCaptureImageUtil.c(AppBrandRuntime.this.mActivity, viewGroup, iCaptureImageCallback2);
                    AppBrandRuntime.this.isGettingScreenShot = Boolean.FALSE;
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void captureImage(final ICaptureImageCallback iCaptureImageCallback) {
        this.isGettingScreenShot = Boolean.TRUE;
        AppBrandPage showingPage = ((AppBrandPageContainer) this.pageContainer).getShowingPage();
        if (showingPage != null) {
            FrameLayout centerLayout = showingPage.getCenterLayout();
            PageWebviewContainer pageWebviewContainer = showingPage.getPageWebviewContainer();
            View findViewWithTag = pageWebviewContainer.findViewWithTag("MiniAppVideoPlayer");
            View findViewWithTag2 = pageWebviewContainer.findViewWithTag("MiniAppMapTag");
            EmbeddedWidgetClientFactory currentX5EmbeddedWidgetClientFactory = showingPage.getRootContainer().getCurrentX5EmbeddedWidgetClientFactory();
            if (findViewWithTag instanceof IVideoPlayerUIImpl) {
                captureImageForVideoPlayer(iCaptureImageCallback, centerLayout, findViewWithTag);
                return;
            }
            if (findViewWithTag2 != null) {
                ((MapProxy) ProxyManager.get(MapProxy.class)).captureImage(this, findViewWithTag2, centerLayout, new MapProxy.MapSnapshotCallback() { // from class: com.tencent.qqmini.miniapp.core.AppBrandRuntime.3
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy.MapSnapshotCallback
                    public void onSnapshotReady(Bitmap bitmap) {
                        ICaptureImageCallback iCaptureImageCallback2 = iCaptureImageCallback;
                        if (iCaptureImageCallback2 != null) {
                            iCaptureImageCallback2.onResult(bitmap);
                            AppBrandRuntime.this.isGettingScreenShot = Boolean.FALSE;
                        }
                    }
                });
                return;
            }
            if (currentX5EmbeddedWidgetClientFactory != null && currentX5EmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null && currentX5EmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().size() > 0) {
                shotWebview(iCaptureImageCallback, showingPage, centerLayout);
                return;
            } else {
                SaveCaptureImageUtil.c(this.mActivity, centerLayout, iCaptureImageCallback);
                this.isGettingScreenShot = Boolean.FALSE;
                return;
            }
        }
        if (iCaptureImageCallback != null) {
            QMLog.e(TAG, "captureImage, current page is null, callback null.");
            iCaptureImageCallback.onResult(null);
            this.isGettingScreenShot = Boolean.FALSE;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public AdReportData getAdReportData() {
        AdReportData adReportData = super.getAdReportData();
        adReportData.path = "";
        adReportData.canScroll = 0;
        adReportData.referPath = "";
        IAppBrandPageContainer iAppBrandPageContainer = this.pageContainer;
        if (iAppBrandPageContainer != null && (iAppBrandPageContainer instanceof AppBrandPageContainer)) {
            adReportData.path = ((AppBrandPageContainer) iAppBrandPageContainer).getCurrentPageUrl();
            adReportData.referPath = ((AppBrandPageContainer) this.pageContainer).getReferPageUrl();
            adReportData.lastClicks = ((AppBrandPageContainer) this.pageContainer).getLastClicks();
        }
        adReportData.networkType = NetworkUtil.getActiveNetworkType(getContext());
        adReportData.isGame = 0;
        return adReportData;
    }

    public EmbeddedState getEmbeddedState() {
        IAppBrandPageContainer iAppBrandPageContainer = this.pageContainer;
        if ((iAppBrandPageContainer instanceof AppBrandPageContainer) && ((AppBrandPageContainer) iAppBrandPageContainer).getAppBrandPagePool() != null) {
            return ((AppBrandPageContainer) this.pageContainer).getAppBrandPagePool().getEmbeddedState((AppBrandPageContainer) this.pageContainer);
        }
        QMLog.e(TAG, "Failed to get embedded state, pageContainer is null");
        return null;
    }

    public MiniAppWorkerManager getMiniAppWorkerManager() {
        return this.mMiniAppWorkerManager;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void getScreenshot(final GetScreenshot.Callback callback) {
        captureImage(new ICaptureImageCallback() { // from class: com.tencent.qqmini.miniapp.core.AppBrandRuntime.2
            @Override // com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback
            public void onResult(Bitmap bitmap) {
                if (bitmap == null) {
                    callback.onGetScreenshot(WnsUtil.defaultShareImg());
                } else {
                    callback.onGetScreenshot(SaveCaptureImageUtil.b(AppBrandRuntime.this, bitmap));
                }
                AppBrandRuntime.this.setScreenShotState(false);
            }
        });
    }

    @Override // com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime, com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public ShareState getShareState() {
        AppBrandPage showingPage = ((AppBrandPageContainer) this.pageContainer).getShowingPage();
        if (showingPage == null) {
            QMLog.e(TAG, "Failed to get share state, AppBrandPage is null");
            return null;
        }
        PageWebview currentPageWebview = showingPage.getCurrentPageWebview();
        if (currentPageWebview == null) {
            QMLog.e(TAG, "Failed to get share state, PageWebview is null");
            return null;
        }
        return currentPageWebview.getShareState();
    }

    public void loadSubPkgAppService(String str) {
        if (TextUtils.isEmpty(str)) {
            QMLog.e(TAG, "loadSubPkgAppService url is null.");
            return;
        }
        ApkgInfo apkgInfo = this.mApkgInfo;
        if (apkgInfo == null) {
            QMLog.e(TAG, "loadSubPkgAppService ApkgInfo is null.");
            return;
        }
        final String rootPath = apkgInfo.getRootPath(str);
        if (TextUtils.isEmpty(rootPath)) {
            QMLog.e(TAG, "loadSubPkgAppService subPkgRoot is null.");
            return;
        }
        if (this.loadedAppServiceJsList.contains(rootPath)) {
            QMLog.e(TAG, "loadSubPkgAppService has loaded.");
            return;
        }
        String appServiceJsContent = this.mApkgInfo.getAppServiceJsContent(rootPath);
        if (TextUtils.isEmpty(appServiceJsContent)) {
            QMLog.e(TAG, "loadSubPkgAppService appServiceJsStr is null.");
        } else {
            this.appBrandService.evaluateJs(appServiceJsContent, new ValueCallback() { // from class: com.tencent.qqmini.miniapp.core.AppBrandRuntime.1
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                public void onReceiveValue(Object obj) {
                    AppBrandRuntime.this.loadedAppServiceJsList.add(rootPath);
                }
            });
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime, com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void onRuntimeCreate() {
        super.onRuntimeCreate();
        this.pageContainer = new AppBrandPageContainer(this, this.mEventListener);
        this.mMiniAppWorkerManager = new MiniAppWorkerManager(this);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void setScreenShotState(boolean z16) {
        this.isGettingScreenShot = Boolean.valueOf(z16);
    }

    @Override // com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime, com.tencent.qqmini.sdk.core.Preloadable
    public void init(IAppBrandService iAppBrandService) {
        super.init(iAppBrandService);
        initEmbeddedState();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeDestroy() {
    }
}
