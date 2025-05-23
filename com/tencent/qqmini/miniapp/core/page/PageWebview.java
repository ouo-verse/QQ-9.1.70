package com.tencent.qqmini.miniapp.core.page;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.page.c;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientHolder;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class PageWebview extends BasePageWebview {
    private static final String TAG = "PageWebview";
    private static final boolean enableEmbeddedElementConfig;
    private static final boolean enableEmbeddedLiveConfig;
    private static final boolean enableEmbeddedVideoConfiog;
    private AppBrandPageContainer mAppBrandPageContainer;
    private BrandPageWebview mBrandPageWebview;
    private IMiniAppContext mContext;
    private EmbeddedState mEmbeddedState;
    protected EmbeddedWidgetClientFactory mEmbeddedWidgetClientFactory;
    private boolean mPageJsLoadSucc;
    private ShareState mShareState;

    /* loaded from: classes23.dex */
    public interface WebviewShotCallback {
        void onShotReady(Bitmap bitmap);
    }

    static {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (WnsConfig.getConfig("qqminiapp", "enable_embedded_video", 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        enableEmbeddedVideoConfiog = z16;
        if (WnsConfig.getConfig("qqminiapp", "enable_embedded_live", 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        enableEmbeddedLiveConfig = z17;
        if (WnsConfig.getConfig("qqminiapp", "enable_embedded_element", 1) != 1) {
            z18 = false;
        }
        enableEmbeddedElementConfig = z18;
    }

    public PageWebview(IMiniAppContext iMiniAppContext, AppBrandPageContainer appBrandPageContainer, BrandPageWebview brandPageWebview) {
        super(iMiniAppContext.getContext(), appBrandPageContainer);
        this.mPageJsLoadSucc = false;
        this.mContext = iMiniAppContext;
        this.mAppBrandPageContainer = appBrandPageContainer;
        this.mBrandPageWebview = brandPageWebview;
        this.mShareState = new ShareState();
        this.mEmbeddedState = new EmbeddedState();
        init();
    }

    public static Bitmap createBitmap(int i3, int i16) {
        try {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            QMLog.e(TAG, "createBitmap failed", e16);
            System.gc();
            try {
                return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e17) {
                QMLog.e(TAG, "createBitmap failed again", e17);
                return null;
            }
        }
    }

    private String getPageWebviewTitle(boolean z16) {
        String str;
        if (z16) {
            String str2 = null;
            if (this.mContext.getMiniAppInfo() != null) {
                str = this.mContext.getMiniAppInfo().appId;
            } else {
                str = null;
            }
            if (this.mAppBrandPageContainer.getShowingPage() != null) {
                str2 = this.mAppBrandPageContainer.getShowingPage().getCurShowingUrl();
            }
            return "\"" + str + ":" + str2 + ":VISIBLE\"";
        }
        if (this.mContext.getMiniAppInfo() != null) {
            return "\"" + this.mContext.getMiniAppInfo().name + "\"";
        }
        return "";
    }

    private void reportEmbeddedSupportResult(final int i3, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), i3, "0", str, null, null, null);
            }
        });
    }

    public static Bitmap screenShot(WebView webView, int i3, int i16) {
        Bitmap createBitmap;
        if (webView == null || i3 <= 0 || i16 <= 0 || (createBitmap = createBitmap(i3, i16)) == null) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        if (webView.getX5WebViewExtension() != null) {
            PaintFlagsDrawFilter paintFlagsDrawFilter = new PaintFlagsDrawFilter(134, 64);
            int tbsVersion = QbSdk.getTbsVersion(webView.getContext());
            if (tbsVersion >= 43000 && tbsVersion < 43105) {
                float measuredWidth = i3 / webView.getMeasuredWidth();
                canvas.scale(measuredWidth, measuredWidth);
                canvas.setDrawFilter(paintFlagsDrawFilter);
                webView.getX5WebViewExtension().snapshotVisible(canvas, false, false, false, false);
                QMLog.d(TAG, "snapshot with snapshotVisible()");
            } else {
                float contentWidth = i3 / webView.getContentWidth();
                canvas.scale(contentWidth, contentWidth);
                canvas.setDrawFilter(paintFlagsDrawFilter);
                webView.getX5WebViewExtension().snapshotWholePage(canvas, false, false);
                QMLog.d(TAG, "snapshot with snapshotWholePage()");
            }
            canvas.setDrawFilter(null);
        } else {
            float measuredWidth2 = i3 / webView.getMeasuredWidth();
            canvas.scale(measuredWidth2, measuredWidth2);
            Picture capturePicture = webView.capturePicture();
            if (capturePicture != null) {
                capturePicture.draw(canvas);
            }
        }
        return createBitmap;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.BasePageWebview, com.tencent.smtt.sdk.WebView
    public void destroy() {
        super.destroy();
        AppBrandPageContainer appBrandPageContainer = this.mAppBrandPageContainer;
        if (appBrandPageContainer != null) {
            appBrandPageContainer.notifyOnPageWebViewDestory();
        }
        EmbeddedWidgetClientFactory embeddedWidgetClientFactory = this.mEmbeddedWidgetClientFactory;
        if (embeddedWidgetClientFactory != null && embeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null) {
            Iterator<Map.Entry<Long, EmbeddedWidgetClientHolder>> it = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
            while (it.hasNext()) {
                EmbeddedWidgetClientHolder value = it.next().getValue();
                if (value != null) {
                    value.webViewDestroy();
                }
                it.remove();
            }
        }
    }

    public EmbeddedState getEmbeddedState() {
        return this.mEmbeddedState;
    }

    public EmbeddedWidgetClientFactory getEmbeddedWidgetClientFactory() {
        return this.mEmbeddedWidgetClientFactory;
    }

    public ShareState getShareState() {
        return this.mShareState;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.BasePageWebview, com.tencent.qqmini.miniapp.core.page.c
    public boolean handleBackPressed() {
        BrandPageWebview brandPageWebview = this.mBrandPageWebview;
        if (brandPageWebview != null) {
            return brandPageWebview.handleBackPressed();
        }
        return false;
    }

    public void init() {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        setScrollBarStyle(0);
        if (getX5WebViewExtension() != null) {
            getX5WebViewExtension().setVerticalTrackDrawable(null);
        }
        try {
            if (getX5WebViewExtension() != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mEmbeddedWidgetClientFactory = new EmbeddedWidgetClientFactory();
                boolean registerEmbeddedWidget = getX5WebViewExtension().registerEmbeddedWidget(new String[]{"video"}, this.mEmbeddedWidgetClientFactory);
                QMLog.d("miniapp-embedded", "registerEmbeddedWidget : " + registerEmbeddedWidget + "; " + (System.currentTimeMillis() - currentTimeMillis));
                if (!registerEmbeddedWidget) {
                    reportEmbeddedSupportResult(MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT, "registerEmbeddedWidget false");
                }
                MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                if (miniAppProxy.isDebugVersion()) {
                    String account = miniAppProxy.getAccount();
                    boolean z19 = AppLoaderFactory.g().getContext().getSharedPreferences(account + "_user_embedded_video_", 0).getBoolean("_user_embedded_video_", true);
                    boolean z26 = AppLoaderFactory.g().getContext().getSharedPreferences(account + "_user_embedded_live_", 0).getBoolean("_user_embedded_live_", true);
                    if (registerEmbeddedWidget && z19) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (registerEmbeddedWidget && z26) {
                        z18 = true;
                    }
                } else {
                    if (registerEmbeddedWidget && enableEmbeddedVideoConfiog) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (registerEmbeddedWidget && enableEmbeddedLiveConfig) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (registerEmbeddedWidget && enableEmbeddedElementConfig) {
                        z18 = true;
                    }
                    registerEmbeddedWidget = z18;
                    z18 = z17;
                }
                this.mEmbeddedState.setEnableEmbeddedVideo(z16);
                this.mEmbeddedState.setEnableEmbeddedLive(z18);
                this.mEmbeddedState.setEnableEmbeddedElement(registerEmbeddedWidget);
                return;
            }
            reportEmbeddedSupportResult(MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT, "getX5WebViewExtension null");
        } catch (Throwable th5) {
            QMLog.e("miniapp-embedded", "registerEmbeddedWidget error,", th5);
        }
    }

    public void onHide() {
        if (this.mAppBrandPageContainer.getShowingPage() != null) {
            final String curShowingUrl = this.mAppBrandPageContainer.getShowingPage().getCurShowingUrl();
            QMLog.d(TAG, "onHide :" + curShowingUrl + "  id:" + this.mPageWebviewId);
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebview.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ((MiniAppRealTimeLogReporter) PageWebview.this.mContext.getManager(MiniAppRealTimeLogReporter.class)).flush(curShowingUrl, PageWebview.this.mPageWebviewId, PageWebview.this.mContext.getBaseLibVersion(), PageWebview.this.mContext.getMiniAppInfo().appId);
                    } catch (Exception e16) {
                        QMLog.d(PageWebview.TAG, "MiniAppRealTimeLogReporter flush failed,", e16);
                    }
                }
            });
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void onPause() {
        super.onPause();
        QMLog.d(TAG, "pagewebview onPause, id is  " + this.mPageWebviewId);
        AppBrandPageContainer appBrandPageContainer = this.mAppBrandPageContainer;
        if (appBrandPageContainer != null) {
            appBrandPageContainer.notifyOnPageWebViewPause(this.mPageWebviewId);
        }
        BrandPageWebview brandPageWebview = this.mBrandPageWebview;
        if (brandPageWebview != null) {
            brandPageWebview.evaluateJs("document.title=\"\"", null);
        }
        EmbeddedWidgetClientFactory embeddedWidgetClientFactory = this.mEmbeddedWidgetClientFactory;
        if (embeddedWidgetClientFactory != null && embeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null) {
            Iterator<Map.Entry<Long, EmbeddedWidgetClientHolder>> it = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
            while (it.hasNext()) {
                EmbeddedWidgetClientHolder value = it.next().getValue();
                if (value != null) {
                    value.webViewPause();
                }
            }
        }
        onHide();
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void onResume() {
        super.onResume();
        QMLog.d(TAG, "pagewebview onResume, id is " + this.mPageWebviewId);
        AppBrandPageContainer appBrandPageContainer = this.mAppBrandPageContainer;
        if (appBrandPageContainer != null) {
            appBrandPageContainer.notifyOnPageWebViewResume();
        }
        if (this.mBrandPageWebview != null && this.mAppBrandPageContainer != null && this.mContext != null) {
            String pageWebviewTitle = getPageWebviewTitle(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion());
            this.mBrandPageWebview.evaluateJs("document.title=" + pageWebviewTitle, null);
        }
        EmbeddedWidgetClientFactory embeddedWidgetClientFactory = this.mEmbeddedWidgetClientFactory;
        if (embeddedWidgetClientFactory != null && embeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null) {
            Iterator<Map.Entry<Long, EmbeddedWidgetClientHolder>> it = this.mEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().entrySet().iterator();
            while (it.hasNext()) {
                EmbeddedWidgetClientHolder value = it.next().getValue();
                if (value != null) {
                    value.webViewResume();
                }
            }
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        ArrayList<c.a> arrayList = this.webviewScrollListenerList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<c.a> it = this.webviewScrollListenerList.iterator();
            while (it.hasNext()) {
                it.next().onVerticalScroll(i16);
            }
        }
        this.scrollY = i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.smtt.sdk.WebView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("windowWidth", (int) (i3 / DisplayUtil.getDensity(getContext())));
            jSONObject.put("windowHeight", (int) (i16 / DisplayUtil.getDensity(getContext())));
            jSONObject2.put("size", jSONObject);
        } catch (JSONException e16) {
            QMLog.e(TAG, "onSizeChanged, JSONException!", e16);
        }
        this.mContext.performAction(ServiceSubscribeEvent.obtain("onViewDidResize", jSONObject2.toString(), getPageWebViewId()));
        if (this.mPageJsLoadSucc) {
            this.mBrandPageWebview.evaluateSubscribeJS("onViewDidResize", jSONObject2.toString(), getPageWebViewId());
        } else {
            QMLog.d(TAG, "page not ready, do nothing.");
        }
    }

    public void setPageJsLoadSucc(boolean z16) {
        this.mPageJsLoadSucc = z16;
    }

    public void shotWebview(final WebviewShotCallback webviewShotCallback) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebview.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i3 = PageWebview.this.getContext().getResources().getDisplayMetrics().widthPixels;
                    Bitmap screenShot = PageWebview.screenShot(PageWebview.this, i3, (int) (i3 * 0.8d));
                    if (screenShot != null && !screenShot.isRecycled()) {
                        WebviewShotCallback webviewShotCallback2 = webviewShotCallback;
                        if (webviewShotCallback2 != null) {
                            webviewShotCallback2.onShotReady(screenShot);
                        }
                    } else {
                        WebviewShotCallback webviewShotCallback3 = webviewShotCallback;
                        if (webviewShotCallback3 != null) {
                            webviewShotCallback3.onShotReady(null);
                        }
                    }
                } catch (Throwable unused) {
                    QMLog.e(PageWebview.TAG, "shotWebview error.");
                    WebviewShotCallback webviewShotCallback4 = webviewShotCallback;
                    if (webviewShotCallback4 != null) {
                        webviewShotCallback4.onShotReady(null);
                    }
                }
            }
        });
    }
}
