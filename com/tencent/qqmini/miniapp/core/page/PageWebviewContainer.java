package com.tencent.qqmini.miniapp.core.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.qqmini.miniapp.core.page.c;
import com.tencent.qqmini.miniapp.core.page.widget.MiniSwipeRefreshLayout;
import com.tencent.qqmini.miniapp.plugin.MiniAppFileJsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.PageInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class PageWebviewContainer extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener, CoverView.JsRuntimeListener {
    private static final int ACCELEROMETER_ROTATION_OPENED = 1;
    public static final String EVENT_TO_SERVICE_ON_PULLDOWN_REFRESH = "onPullDownRefresh";
    public static final String TAG = "PageWebviewContainer";
    private boolean disableScroll;
    private boolean enableRefresh;
    private AbsAppBrandPage mBrandPage;
    private BrandPageWebview mBrandPageWebview;
    private IMiniAppContext mMiniAppContext;
    private NativeViewContainer mNaitveViewLayout;
    public int mNaitveViewScrollY;
    private RotationObserver mRotationObserver;
    private MiniSwipeRefreshLayout mSwipeRefreshLayout;
    private String pageOrientation;
    public int refreshStyleColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public static class RotationObserver extends ContentObserver {
        private WeakReference<PageWebviewContainer> mPageWebViewContainerReference;
        private ContentResolver mResolver;

        public RotationObserver(PageWebviewContainer pageWebviewContainer) {
            super(null);
            this.mPageWebViewContainerReference = new WeakReference<>(pageWebviewContainer);
            this.mResolver = pageWebviewContainer.getContext().getContentResolver();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            super.onChange(z16);
            try {
                this.mPageWebViewContainerReference.get().updateOrientation();
            } catch (Exception e16) {
                QMLog.e(PageWebviewContainer.TAG, Log.getStackTraceString(e16));
            }
        }

        public void registerObserver() {
            ContentResolver contentResolver = this.mResolver;
            if (contentResolver != null) {
                contentResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
            }
        }

        public void unregisterObserver() {
            ContentResolver contentResolver = this.mResolver;
            if (contentResolver != null) {
                contentResolver.unregisterContentObserver(this);
            }
        }
    }

    @Deprecated
    public PageWebviewContainer(IMiniAppContext iMiniAppContext) {
        super(iMiniAppContext.getContext());
        this.mNaitveViewScrollY = 0;
        this.refreshStyleColor = -1;
        this.enableRefresh = false;
        this.disableScroll = false;
        this.pageOrientation = WindowInfo.ORIENTATION_PORTRAIT;
        this.mMiniAppContext = iMiniAppContext;
    }

    private void handleDisableScrollBounce(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            if (jSONObject.has("disable")) {
                final boolean optBoolean = jSONObject.optBoolean("disable", false);
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PageWebviewContainer.this.enableRefresh && PageWebviewContainer.this.mSwipeRefreshLayout != null && !PageWebviewContainer.this.mSwipeRefreshLayout.isRefreshing()) {
                            PageWebviewContainer.this.mSwipeRefreshLayout.setEnabled(!optBoolean);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("setDisablePullDownRefresh !disable ");
                            sb5.append(!optBoolean);
                            QMLog.d(PageWebviewContainer.TAG, sb5.toString());
                        }
                        nativeViewRequestEvent.ok();
                    }
                });
            } else {
                QMLog.e(TAG, "EVENT_DISABLE_SROLL_BOUNCE params error.");
                nativeViewRequestEvent.fail(QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "EVENT_DISABLE_SROLL_BOUNCE error," + e16);
            nativeViewRequestEvent.fail(QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
        }
    }

    private void handleOpenDocument(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final String optString = new JSONObject(nativeViewRequestEvent.jsonParams).optString("filePath");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (PageWebviewContainer.this.mSwipeRefreshLayout != null) {
                        PageWebviewContainer.this.mSwipeRefreshLayout.setEnabled(false);
                    }
                    String absolutePath = ((MiniAppFileManager) PageWebviewContainer.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    if (!TextUtils.isEmpty(absolutePath)) {
                        File file = new File(absolutePath);
                        if (file.exists() && file.canRead()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("style", "1");
                            hashMap.put("local", "true");
                            hashMap.put("topBarBgColor", "#808080");
                            if (PageWebviewContainer.this.mMiniAppContext.getAttachActivity() == null) {
                                QMLog.e(PageWebviewContainer.TAG, "can't openFileReader because of activity is null.");
                                return;
                            } else if (QbSdk.openFileReader(PageWebviewContainer.this.mMiniAppContext.getAttachActivity(), absolutePath, hashMap, new ValueCallback<String>() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.5.1
                                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                                public void onReceiveValue(String str) {
                                    QMLog.d(PageWebviewContainer.TAG, "openFileReader callback  : " + str);
                                }
                            }) > 0) {
                                nativeViewRequestEvent.ok();
                            }
                        }
                    }
                    QMLog.e(PageWebviewContainer.TAG, "openDocument fail.");
                    nativeViewRequestEvent.fail();
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handlePageScrollTo(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            long optLong = new JSONObject(nativeViewRequestEvent.jsonParams).optLong("duration", 300L);
            int density = (int) ((DisplayUtil.getDensity(this.mMiniAppContext.getContext()) * r0.optInt("scrollTop")) + 0.5f);
            final PageWebview currentPageWebview = getCurrentPageWebview();
            if (currentPageWebview != null) {
                ValueAnimator duration = ValueAnimator.ofInt(currentPageWebview.getView().getScrollY(), density).setDuration(optLong);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                currentPageWebview.getView().scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                            }
                        });
                    }
                });
                duration.addListener(new Animator.AnimatorListener() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.4
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        nativeViewRequestEvent.fail();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        nativeViewRequestEvent.ok();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                duration.start();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, e16.getMessage(), e16);
            nativeViewRequestEvent.fail();
        }
    }

    private void handleStartPullDownRefresh(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.8
            @Override // java.lang.Runnable
            public void run() {
                if (PageWebviewContainer.this.mSwipeRefreshLayout != null) {
                    PageWebviewContainer.this.mSwipeRefreshLayout.setRefreshing(true);
                    PageWebviewContainer.this.onRefresh();
                    nativeViewRequestEvent.ok();
                } else {
                    QMLog.e(PageWebviewContainer.TAG, "EVENT_START_PULLDOWN_REFRESH mSwipeRefreshLayout is null.");
                    nativeViewRequestEvent.fail("refresh layout error");
                }
            }
        });
    }

    private void handleStopPullDownRefresh(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.7
            @Override // java.lang.Runnable
            public void run() {
                if (PageWebviewContainer.this.mSwipeRefreshLayout != null && PageWebviewContainer.this.mSwipeRefreshLayout.isRefreshing()) {
                    PageWebviewContainer.this.mSwipeRefreshLayout.setRefreshing(false);
                    PageWebviewContainer.this.mSwipeRefreshLayout.setEnabled(PageWebviewContainer.this.enableRefresh);
                    nativeViewRequestEvent.ok();
                } else {
                    QMLog.e(PageWebviewContainer.TAG, "EVENT_STOP_PULLDOWN_REFRESH mSwipeRefreshLayout is null.");
                    nativeViewRequestEvent.fail("refresh layout error");
                }
            }
        });
    }

    private void parsePageConfigByUrl(String str) {
        boolean booleanValue;
        boolean booleanValue2;
        boolean booleanValue3;
        Boolean bool = getApkgInfo().getAppConfigInfo().globalPageInfo.windowInfo.enablePullDownRefresh;
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        this.enableRefresh = booleanValue;
        this.pageOrientation = getApkgInfo().getAppConfigInfo().globalPageInfo.windowInfo.pageOrientation;
        PageInfo pageInfo = getApkgInfo().getAppConfigInfo().getPageInfo(str);
        if (pageInfo != null) {
            Boolean bool2 = pageInfo.windowInfo.enablePullDownRefresh;
            if (bool2 == null) {
                booleanValue2 = this.enableRefresh;
            } else {
                booleanValue2 = bool2.booleanValue();
            }
            this.enableRefresh = booleanValue2;
            Boolean bool3 = pageInfo.windowInfo.disableScroll;
            if (bool3 == null) {
                booleanValue3 = this.disableScroll;
            } else {
                booleanValue3 = bool3.booleanValue();
            }
            this.disableScroll = booleanValue3;
            String str2 = pageInfo.windowInfo.pageOrientation;
            if (!TextUtils.isEmpty(str2)) {
                this.pageOrientation = str2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOrientation() {
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (miniAppProxy != null && miniAppProxy.getDeviceType() == MiniAppProxy.DeviceType.TABLET) {
            QMLog.d(TAG, "UpdateOrientation device is pad");
            return;
        }
        if (miniAppProxy != null && miniAppProxy.getDeviceType() == MiniAppProxy.DeviceType.FOLD && miniAppProxy.isSplitView(getContext())) {
            QMLog.d(TAG, "UpdateOrientation device is fold.");
            this.mMiniAppContext.getAttachActivity().setRequestedOrientation(3);
            return;
        }
        int i3 = 0;
        int i16 = Settings.System.getInt(this.mMiniAppContext.getAttachActivity().getContentResolver(), "accelerometer_rotation", 0);
        if (WindowInfo.ORIENTATION_AUTO.equals(this.pageOrientation) && i16 == 1) {
            i3 = 4;
        } else if (!WindowInfo.ORIENTATION_LANDSCAPE.equals(this.pageOrientation)) {
            i3 = 1;
        }
        this.mMiniAppContext.getAttachActivity().setRequestedOrientation(i3);
    }

    public void addViewOnPage(View view) {
        AbsAppBrandPage absAppBrandPage = this.mBrandPage;
        if (absAppBrandPage != null) {
            absAppBrandPage.addView(view);
        }
    }

    public void callbackJsEventFail(String str, JSONObject jSONObject, int i3) {
        String str2;
        if (this.mBrandPageWebview != null) {
            JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(str, jSONObject);
            if (wrapCallbackFail != null) {
                str2 = wrapCallbackFail.toString();
            } else {
                str2 = "";
            }
            this.mBrandPageWebview.evaluateCallbackJs(i3, str2);
        }
    }

    public void callbackJsEventOK(String str, JSONObject jSONObject, int i3) {
        String str2;
        if (this.mBrandPageWebview != null) {
            JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str, jSONObject);
            if (wrapCallbackOk != null) {
                str2 = wrapCallbackOk.toString();
            } else {
                str2 = "";
            }
            this.mBrandPageWebview.evaluateCallbackJs(i3, str2);
        }
    }

    public void cleanUp() {
        QMLog.d(TAG, "clean up!");
        BrandPageWebview brandPageWebview = this.mBrandPageWebview;
        if (brandPageWebview != null) {
            brandPageWebview.cleanUp();
        }
        NativeViewContainer nativeViewContainer = this.mNaitveViewLayout;
        if (nativeViewContainer != null) {
            nativeViewContainer.destroy();
            this.mNaitveViewLayout.removeAllViews();
            this.mNaitveViewLayout = null;
        }
        RotationObserver rotationObserver = this.mRotationObserver;
        if (rotationObserver != null) {
            rotationObserver.unregisterObserver();
        }
        removeBrandPageWebview();
    }

    public void evaluateCallbackJs(int i3, String str) {
        BrandPageWebview brandPageWebview = this.mBrandPageWebview;
        if (brandPageWebview != null) {
            brandPageWebview.evaluateCallbackJs(i3, str);
        }
    }

    public void evaluateSubscribeJS(String str, String str2) {
        BrandPageWebview brandPageWebview = this.mBrandPageWebview;
        if (brandPageWebview != null) {
            brandPageWebview.evaluateSubscribeJS(str, str2, getWebViewId());
        }
    }

    public ApkgInfo getApkgInfo() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null) {
            return (ApkgInfo) this.mMiniAppContext.getMiniAppInfo().apkgInfo;
        }
        return null;
    }

    public Activity getAttachActivity() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            return iMiniAppContext.getAttachActivity();
        }
        return null;
    }

    public AppBrandPage getBrandPage() {
        return (AppBrandPage) this.mBrandPage;
    }

    public BrandPageWebview getBrandPageWebview() {
        return this.mBrandPageWebview;
    }

    public PageWebview getCurrentPageWebview() {
        AbsAppBrandPage absAppBrandPage = this.mBrandPage;
        if (absAppBrandPage != null) {
            return absAppBrandPage.getCurrentPageWebview();
        }
        return null;
    }

    public IMiniAppContext getMiniAppContext() {
        return this.mMiniAppContext;
    }

    public NativeViewContainer getNativeViewContainer() {
        return this.mNaitveViewLayout;
    }

    public int getNativeViewScrollY() {
        return this.mNaitveViewScrollY;
    }

    public NavigationBar getNaviBar() {
        AbsAppBrandPage absAppBrandPage = this.mBrandPage;
        if (absAppBrandPage != null) {
            return absAppBrandPage.getNaviBar();
        }
        return null;
    }

    public int getNaviBarHeight() {
        if (getNaviBar() != null) {
            return getNaviBar().getHeight();
        }
        return 0;
    }

    public String getPageOrientation() {
        return this.pageOrientation;
    }

    public int getWebViewId() {
        BrandPageWebview brandPageWebview = this.mBrandPageWebview;
        if (brandPageWebview != null && brandPageWebview.getRealView() != null) {
            return this.mBrandPageWebview.getRealView().getPageWebViewId();
        }
        return -1;
    }

    public boolean handleBackPressed() {
        NativeViewContainer nativeViewContainer = this.mNaitveViewLayout;
        if (nativeViewContainer != null && nativeViewContainer.handleBackPressed()) {
            return true;
        }
        return false;
    }

    public String handleNativeUIEvent(NativeViewRequestEvent nativeViewRequestEvent) {
        QMLog.d(TAG, "event = " + nativeViewRequestEvent.event + ", params = " + nativeViewRequestEvent.jsonParams);
        if ("startPullDownRefresh".equals(nativeViewRequestEvent.event)) {
            handleStartPullDownRefresh(nativeViewRequestEvent);
            return null;
        }
        if ("stopPullDownRefresh".equals(nativeViewRequestEvent.event)) {
            handleStopPullDownRefresh(nativeViewRequestEvent);
            return null;
        }
        if ("disableScrollBounce".equals(nativeViewRequestEvent.event)) {
            handleDisableScrollBounce(nativeViewRequestEvent);
            return null;
        }
        if (MiniAppFileJsPlugin.EVENT_OPEN_DOCUMENT.equals(nativeViewRequestEvent.event)) {
            handleOpenDocument(nativeViewRequestEvent);
            return null;
        }
        if ("scrollWebviewTo".equals(nativeViewRequestEvent.event)) {
            handlePageScrollTo(nativeViewRequestEvent);
            return null;
        }
        return null;
    }

    public boolean isCustomNavibar() {
        AbsAppBrandPage absAppBrandPage = this.mBrandPage;
        if (absAppBrandPage != null) {
            return absAppBrandPage.isCustomNavibar();
        }
        return false;
    }

    public void notifyChangePullDownRefreshStyle(int i3) {
        this.refreshStyleColor = i3;
        this.mSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(i3);
        if (i3 == -1) {
            this.mSwipeRefreshLayout.setColorSchemeColors(-16777216);
        } else {
            this.mSwipeRefreshLayout.setColorSchemeColors(-1);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener
    public void onCallbackJsEventFail(String str, JSONObject jSONObject, int i3) {
        callbackJsEventFail(str, jSONObject, i3);
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener
    public void onCallbackJsEventOK(String str, JSONObject jSONObject, int i3) {
        callbackJsEventOK(str, jSONObject, i3);
    }

    @Override // com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener
    public void onEvaluateSubscribeJS(String str, String str2) {
        evaluateSubscribeJS(str, str2);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(EVENT_TO_SERVICE_ON_PULLDOWN_REFRESH, new JSONObject().toString(), getWebViewId()));
        }
    }

    public void refreshOrientation() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null && !this.mMiniAppContext.getAttachActivity().isFinishing()) {
            updateOrientation();
        }
    }

    public void removeBrandPageWebview() {
        MiniSwipeRefreshLayout miniSwipeRefreshLayout = this.mSwipeRefreshLayout;
        if (miniSwipeRefreshLayout != null) {
            miniSwipeRefreshLayout.removeAllViews();
        }
    }

    public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener) {
        AbsAppBrandPage absAppBrandPage = this.mBrandPage;
        if (absAppBrandPage != null && absAppBrandPage.getRootContainer() != null) {
            this.mBrandPage.getRootContainer().removeSoftKeyboardStateListener(softKeyboardStateListener);
        }
    }

    public void setBrandPageWebview(BrandPageWebview brandPageWebview) {
        if (brandPageWebview != null) {
            this.mBrandPageWebview = brandPageWebview;
            if (brandPageWebview.getRealView() != null) {
                this.mBrandPageWebview.getRealView().addView(this.mNaitveViewLayout, new FrameLayout.LayoutParams(-1, -1));
                this.mSwipeRefreshLayout.addView(this.mBrandPageWebview.getRealView(), new ViewGroup.LayoutParams(-1, -1));
                this.mBrandPageWebview.getRealView().setOnWebviewScrollListener(new c.a() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.2
                    @Override // com.tencent.qqmini.miniapp.core.page.c.a
                    public void onVerticalScroll(int i3) {
                        if (PageWebviewContainer.this.mNaitveViewLayout != null && !PageWebviewContainer.this.mNaitveViewLayout.isVideoFullScreen() && !PageWebviewContainer.this.mNaitveViewLayout.isTextAreaFocused()) {
                            PageWebviewContainer pageWebviewContainer = PageWebviewContainer.this;
                            pageWebviewContainer.mNaitveViewScrollY = i3;
                            NativeViewContainer nativeViewContainer = pageWebviewContainer.mNaitveViewLayout;
                            if (PageWebviewContainer.this.disableScroll) {
                                i3 = 0;
                            }
                            nativeViewContainer.scrollTo(0, i3);
                            return;
                        }
                        if (PageWebviewContainer.this.mNaitveViewLayout != null && PageWebviewContainer.this.mNaitveViewLayout.isTextAreaFocused()) {
                            PageWebviewContainer.this.mNaitveViewLayout.scrollWebviewTo(0, PageWebviewContainer.this.mNaitveViewScrollY);
                        }
                    }
                });
                return;
            }
            return;
        }
        QMLog.d(TAG, "setBrandPageWebview brandPageWebview is null!");
    }

    public void setCurInputId(int i3) {
        AbsAppBrandPage absAppBrandPage = this.mBrandPage;
        if (absAppBrandPage != null && absAppBrandPage.getRootContainer() != null) {
            this.mBrandPage.getRootContainer().setCurShowingInputId(i3);
        }
    }

    public void setSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener) {
        AbsAppBrandPage absAppBrandPage = this.mBrandPage;
        if (absAppBrandPage != null && absAppBrandPage.getRootContainer() != null) {
            this.mBrandPage.getRootContainer().setSoftKeyboardStateListener(softKeyboardStateListener);
        }
    }

    public void updateContainerConfig(String str) {
        if (getApkgInfo() != null) {
            parsePageConfigByUrl(str);
            MiniSwipeRefreshLayout miniSwipeRefreshLayout = this.mSwipeRefreshLayout;
            if (miniSwipeRefreshLayout != null) {
                miniSwipeRefreshLayout.setEnabled(this.enableRefresh);
            }
            if (this.disableScroll && this.mBrandPageWebview.getRealView() != null) {
                this.mBrandPageWebview.getRealView().setVerticalScrollBarEnabled(false);
                this.mBrandPageWebview.getRealView().setHorizontalScrollBarEnabled(false);
                if (this.mBrandPageWebview.getRealView().getView() != null && this.mBrandPageWebview.getRealView().getView().getViewTreeObserver() != null && this.mBrandPageWebview.getRealView().getView().getViewTreeObserver().isAlive()) {
                    this.mBrandPageWebview.getRealView().getView().getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.1
                        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                        public void onScrollChanged() {
                            PageWebviewContainer.this.mBrandPageWebview.getRealView().getView().scrollTo(0, 0);
                        }
                    });
                }
            }
            refreshOrientation();
        }
    }

    public void addViewOnPage(View view, ViewGroup.LayoutParams layoutParams) {
        AbsAppBrandPage absAppBrandPage = this.mBrandPage;
        if (absAppBrandPage != null) {
            absAppBrandPage.addView(view, layoutParams);
        }
    }

    public PageWebviewContainer(IMiniAppContext iMiniAppContext, AbsAppBrandPage absAppBrandPage) {
        super(iMiniAppContext.getContext());
        this.mNaitveViewScrollY = 0;
        this.refreshStyleColor = -1;
        this.enableRefresh = false;
        this.disableScroll = false;
        this.pageOrientation = WindowInfo.ORIENTATION_PORTRAIT;
        this.mBrandPage = absAppBrandPage;
        this.mMiniAppContext = iMiniAppContext;
        NativeViewContainer nativeViewContainer = new NativeViewContainer(iMiniAppContext, this);
        this.mNaitveViewLayout = nativeViewContainer;
        ViewCompat.setImportantForAccessibility(nativeViewContainer, 4);
        MiniSwipeRefreshLayout miniSwipeRefreshLayout = new MiniSwipeRefreshLayout(getContext());
        this.mSwipeRefreshLayout = miniSwipeRefreshLayout;
        miniSwipeRefreshLayout.setOnRefreshListener(this);
        this.mSwipeRefreshLayout.setTouchSlop(100);
        addView(this.mSwipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
        notifyChangePullDownRefreshStyle(this.refreshStyleColor);
        RotationObserver rotationObserver = new RotationObserver(this);
        this.mRotationObserver = rotationObserver;
        rotationObserver.registerObserver();
    }
}
