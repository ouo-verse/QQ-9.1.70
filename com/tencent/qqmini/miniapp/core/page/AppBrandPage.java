package com.tencent.qqmini.miniapp.core.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.action.LoadSubPkgAppService;
import com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout;
import com.tencent.qqmini.miniapp.plugin.NavigationBarPlugin;
import com.tencent.qqmini.miniapp.plugin.TabBarJsPlugin;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAIOEntranceProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.MiniAppUtils;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.DefaultNavigationBar;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;
import common.config.service.QzoneConfig;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class AppBrandPage extends AbsAppBrandPage implements SwipeBackLayout.Callback, NavigationBar.a {
    public static final String TAG = "minisdk-startAppBrandPage";
    private FrameLayout centerLayout;
    private PageWebviewContainer mCurPageWebviewContainer;
    private LaunchParam mLaunchParam;
    private IMiniAppContext mMiniAppContext;
    private final int mNaviHeight;
    private NavigationBar mNavigationBar;
    private String mNavigationStyle;
    private String mPageUrl;
    private PageWebviewContainer mPageWebviewContainer;
    private AppBrandPageContainer mRootContainer;
    private RelativeLayout mRootView;
    private TabBar mTabBar;
    private boolean mTabBarState;
    private Map<String, PageWebviewContainer> mTabPageCache;
    private MiniAIOEntranceProxy miniAIOEntryView;

    public AppBrandPage(IMiniAppContext iMiniAppContext, AppBrandPageContainer appBrandPageContainer) {
        super(iMiniAppContext.getContext());
        this.mNavigationStyle = "default";
        this.mTabBarState = false;
        this.mNaviHeight = 40;
        this.mMiniAppContext = iMiniAppContext;
        this.mRootContainer = appBrandPageContainer;
        init();
    }

    private ApkgInfo getApkgInfo() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null) {
            return (ApkgInfo) this.mMiniAppContext.getMiniAppInfo().apkgInfo;
        }
        return null;
    }

    private BrandPageWebview getBrandPageWebviewByUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!isTabBarPage()) {
            if (!str.equals(this.mPageUrl)) {
                return null;
            }
            return getBrandPageWebview();
        }
        String urlWithoutParams = AppBrandUtil.getUrlWithoutParams(str);
        for (Map.Entry<String, PageWebviewContainer> entry : this.mTabPageCache.entrySet()) {
            if (urlWithoutParams.equals(entry.getKey())) {
                if (entry.getValue() == null) {
                    return null;
                }
                return entry.getValue().getBrandPageWebview();
            }
        }
        return null;
    }

    @Nullable
    private EntryModel getEntryModel() {
        if (isEntryModelValid()) {
            return this.mMiniAppContext.getMiniAppInfo().launchParam.entryModel;
        }
        return null;
    }

    private void handleLoadedPage(String str, String str2, PageEventListener pageEventListener) {
        for (Map.Entry<String, PageWebviewContainer> entry : this.mTabPageCache.entrySet()) {
            PageWebviewContainer value = entry.getValue();
            if (entry.getKey().equals(str)) {
                if (value.getParent() == null) {
                    this.centerLayout.addView(value, new FrameLayout.LayoutParams(-1, -1));
                }
                value.setVisibility(0);
                this.mCurPageWebviewContainer = value;
                if (isPageWebViewReady(str)) {
                    pageEventListener.onWebViewReady(str2, this.mPageUrl, this.mRootContainer.getShowingPageWebViewId());
                }
            } else {
                value.setVisibility(8);
            }
        }
    }

    private void handleNewPage(String str, String str2, PageEventListener pageEventListener, boolean z16) {
        QMLog.d(TAG, "handleNewPage: url" + str);
        this.mMiniAppContext.performAction(LoadSubPkgAppService.obtain(this.mPageUrl));
        PageWebviewContainer pageWebviewContainer = this.mPageWebviewContainer;
        this.mPageWebviewContainer = null;
        this.mCurPageWebviewContainer = pageWebviewContainer;
        if (pageWebviewContainer == null) {
            pageWebviewContainer = new PageWebviewContainer(this.mMiniAppContext, this);
            this.mCurPageWebviewContainer = pageWebviewContainer;
        }
        BrandPageWebview appBrandPage = this.mRootContainer.getAppBrandPagePool().getPageWebviewPool().getAppBrandPage(this.mRootContainer);
        appBrandPage.setWebViewEventListener(pageEventListener);
        try {
            appBrandPage.setApkgInfo(getApkgInfo());
            appBrandPage.loadUrl(str, str2);
        } catch (Throwable th5) {
            QMLog.e(TAG, "Error when loading BrandPageWebview: ", th5);
        }
        pageWebviewContainer.setBrandPageWebview(appBrandPage);
        pageWebviewContainer.updateContainerConfig(str);
        if (pageWebviewContainer.getParent() == null) {
            this.centerLayout.addView(pageWebviewContainer, new FrameLayout.LayoutParams(-1, -1));
        }
        if (z16) {
            this.mTabPageCache.put(AppBrandUtil.getUrlWithoutParams(str), pageWebviewContainer);
        }
    }

    private void handlePageScrollTo(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            long optLong = new JSONObject(nativeViewRequestEvent.jsonParams).optLong("duration", 300L);
            int density = (int) ((DisplayUtil.getDensity(getContext()) * r0.optInt("scrollTop")) + 0.5f);
            final PageWebview currentPageWebview = getCurrentPageWebview();
            if (currentPageWebview != null) {
                ValueAnimator duration = ValueAnimator.ofInt(currentPageWebview.getView().getScrollY(), density).setDuration(optLong);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                currentPageWebview.getView().scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                            }
                        });
                    }
                });
                duration.addListener(new Animator.AnimatorListener() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.3
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

    private void hideNavbarHomeButton(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            if (getPageWebviewId() == new JSONObject(nativeViewRequestEvent.jsonParams).optInt("webviewId") && this.mNavigationBar != null) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.9
                    @Override // java.lang.Runnable
                    public void run() {
                        AppBrandPage.this.mNavigationBar.setHomeIconVisibility(8);
                        nativeViewRequestEvent.ok();
                    }
                });
            } else {
                nativeViewRequestEvent.fail("hideNavbarHomeButton error");
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "hideNavbarHomeButton error.", e16);
            nativeViewRequestEvent.fail("hideNavbarHomeButton exception");
        }
    }

    private void hideNavbarLoading(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.5
            @Override // java.lang.Runnable
            public void run() {
                if (AppBrandPage.this.mNavigationBar != null) {
                    AppBrandPage.this.mNavigationBar.hideLoading();
                    nativeViewRequestEvent.ok();
                } else {
                    nativeViewRequestEvent.fail("native view error");
                }
            }
        });
    }

    private void hideRedDot(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("index", -1);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.8
                @Override // java.lang.Runnable
                public void run() {
                    if (AppBrandPage.this.mTabBar != null) {
                        AppBrandPage.this.mTabBar.hideTabBarRedDot(optInt);
                    }
                }
            });
            nativeViewRequestEvent.ok();
        } catch (Throwable th5) {
            QMLog.e(TAG, "API_SET_TABBAR_BADGE error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void hidetabbar(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final boolean optBoolean = new JSONObject(nativeViewRequestEvent.jsonParams).optBoolean("animation", false);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.15
                @Override // java.lang.Runnable
                public void run() {
                    if (AppBrandPage.this.mTabBar != null) {
                        AppBrandPage.this.mTabBar.hideTabBar(optBoolean);
                    }
                    nativeViewRequestEvent.ok();
                }
            });
        } catch (Throwable th5) {
            QMLog.e(TAG, "API_HIDE_TABBAR error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void init() {
        this.mTabPageCache = new HashMap();
        PageWebviewContainer pageWebviewContainer = new PageWebviewContainer(this.mMiniAppContext, this);
        this.mPageWebviewContainer = pageWebviewContainer;
        pageWebviewContainer.setContentDescription(PageWebviewContainer.TAG);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.centerLayout = frameLayout;
        frameLayout.setContentDescription("centerLayout");
        this.centerLayout.setBackgroundColor(-1);
        initNavigationBar();
        TabBar tabBar = new TabBar(getContext(), this.mMiniAppContext);
        this.mTabBar = tabBar;
        tabBar.setContentDescription("TabBar");
        this.mTabBar.setId(R.id.mini_sdk_tab_bar);
        this.mTabBar.setOnTabItemClickListener(this.mRootContainer);
        this.mPageWebviewContainer.setImportantForAccessibility(2);
        this.centerLayout.setImportantForAccessibility(2);
        this.mTabBar.setImportantForAccessibility(2);
        updateViewStyle(this.mNavigationStyle);
        setSwipeBackCallback(this);
    }

    private void initNavigationBar() {
        NavigationBar tryCreateCustomerNavigation = tryCreateCustomerNavigation();
        this.mNavigationBar = tryCreateCustomerNavigation;
        if (tryCreateCustomerNavigation == null) {
            this.mNavigationBar = new DefaultNavigationBar(getContext(), getMiniAppContext());
        }
        this.mNavigationBar.setImportantForAccessibility(2);
        this.mNavigationBar.setClickBackListener(this);
        this.mNavigationBar.setContentDescription(QzoneConfig.MAIN_KEY_NAVIGATOR_BAR);
        this.mNavigationBar.setId(R.id.mini_sdk_navigation_bar);
    }

    private boolean isAppConfigInfoEnable() {
        if (this.mMiniAppContext != null && getApkgInfo() != null && getApkgInfo().getAppConfigInfo() != null) {
            return true;
        }
        return false;
    }

    private boolean isEntryModelValid() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null && this.mMiniAppContext.getMiniAppInfo().launchParam != null && this.mMiniAppContext.getMiniAppInfo().launchParam.entryModel != null) {
            return true;
        }
        return false;
    }

    private boolean isHalf2FullMini() {
        EntryModel entryModel;
        LaunchParam launchParam = this.mLaunchParam;
        if (launchParam != null && (entryModel = launchParam.entryModel) != null && entryModel.type == 10) {
            return true;
        }
        return false;
    }

    private boolean isHalfMini() {
        EntryModel entryModel;
        LaunchParam launchParam = this.mLaunchParam;
        if (launchParam != null && (entryModel = launchParam.entryModel) != null && entryModel.type == 9) {
            return true;
        }
        return false;
    }

    private boolean isHomeIconShow() {
        if (this.mRootContainer.getShowingPage() == null || this.mRootContainer.getShowingPage().getNaviBar() == null || this.mRootContainer.getShowingPage().getNaviBar().getHomeIconVisibility() != 0) {
            return false;
        }
        return true;
    }

    private boolean isPageWebViewReady(String str) {
        BrandPageWebview brandPageWebviewByUrl = getBrandPageWebviewByUrl(str);
        if (brandPageWebviewByUrl != null) {
            return brandPageWebviewByUrl.isReady();
        }
        return false;
    }

    private boolean isReadyLoadUrl(String str) {
        if (!TextUtils.isEmpty(str) && this.mMiniAppContext != null && getApkgInfo() != null) {
            return true;
        }
        return false;
    }

    private boolean isShowHomeButtonByPageTypeFromAppId() {
        if (!this.mRootContainer.isPageInStackBottom(this) && !isHomePage() && !isTabPage()) {
            return true;
        }
        return false;
    }

    private boolean isShowHomeButtonByPageTypeNotFromPageId() {
        if (this.mRootContainer.isPageInStackBottom(this) && !isHomePage() && !isTabPage()) {
            return true;
        }
        return false;
    }

    private boolean isShowHomeButtonFromAppConfig(String str) {
        if (!isAppConfigInfoEnable()) {
            return false;
        }
        Boolean bool = getApkgInfo().getAppConfigInfo().globalPageInfo.windowInfo.homeButtonIsShow;
        Boolean bool2 = getApkgInfo().getAppConfigInfo().getPageInfo(str).windowInfo.homeButtonIsShow;
        if (bool != null && bool.booleanValue() && bool2 == null) {
            return true;
        }
        if (bool != null && bool.booleanValue() && bool2.booleanValue()) {
            return true;
        }
        if (bool != null && !bool.booleanValue() && bool2 != null && bool2.booleanValue()) {
            return true;
        }
        if (bool != null || bool2 == null || !bool2.booleanValue()) {
            return false;
        }
        return true;
    }

    private boolean needRecreateNavigation() {
        boolean equals;
        if (this.mNavigationBar == null) {
            return true;
        }
        EntryModel entryModel = getEntryModel();
        String name = this.mNavigationBar.getClass().getName();
        if (entryModel != null && !TextUtils.isEmpty(entryModel.titleBarClassName)) {
            equals = name.equals(entryModel.titleBarClassName);
        } else {
            equals = name.equals(DefaultNavigationBar.class.getName());
        }
        boolean z16 = !equals;
        if (z16) {
            QMLog.d(TAG, "needRecreate, target is current is " + name);
        }
        return z16;
    }

    private void realLoadUrl(String str, String str2, PageEventListener pageEventListener) {
        boolean z16;
        this.mPageUrl = str;
        boolean z17 = true;
        if (getApkgInfo() != null && getApkgInfo().isTabBarPage(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        Map<String, PageWebviewContainer> map = this.mTabPageCache;
        if (map == null || !map.containsKey(AppBrandUtil.getUrlWithoutParams(str))) {
            z17 = false;
        }
        if (z17) {
            handleLoadedPage(str, str2, pageEventListener);
        } else {
            handleNewPage(str, str2, pageEventListener, z16);
        }
    }

    private void removeTabbarBadge(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("index", -1);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.11
                @Override // java.lang.Runnable
                public void run() {
                    if (AppBrandPage.this.mTabBar != null) {
                        AppBrandPage.this.mTabBar.removeTabBarBadge(optInt);
                    }
                }
            });
            nativeViewRequestEvent.ok();
        } catch (Throwable th5) {
            QMLog.e(TAG, "API_SET_TABBAR_BADGE error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void setNavbarBgColor(final NativeViewRequestEvent nativeViewRequestEvent) {
        String str;
        long j3;
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final String optString = jSONObject.optString("frontColor");
            final String optString2 = jSONObject.optString("backgroundColor");
            JSONObject optJSONObject = jSONObject.optJSONObject("animation");
            if (optJSONObject != null) {
                j3 = optJSONObject.optLong("duration");
                str = optJSONObject.optString("timingFunc");
            } else {
                str = null;
                j3 = 0;
            }
            final String str2 = str;
            final long j16 = j3;
            if (this.mNavigationBar != null) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.4
                    @Override // java.lang.Runnable
                    public void run() {
                        String str3;
                        boolean z16;
                        boolean equals = "#000000".equals(optString);
                        NavigationBar navigationBar = AppBrandPage.this.mNavigationBar;
                        if (equals) {
                            str3 = "black";
                        } else {
                            str3 = "white";
                        }
                        navigationBar.setTextStyle(str3);
                        if (AppBrandPage.this.mMiniAppContext.getAttachActivity() != null) {
                            z16 = ImmersiveUtils.setStatusTextColor(equals, AppBrandPage.this.mMiniAppContext.getAttachActivity().getWindow());
                        } else {
                            z16 = false;
                        }
                        AppBrandPage.this.mNavigationBar.setUseCustomStatusBarStyle(z16);
                        if (!TextUtils.isEmpty(optString2)) {
                            if (!TextUtils.isEmpty(str2)) {
                                AppBrandPage.this.mNavigationBar.setNavBackgroundColor(ColorUtils.parseColor(optString2), j16, str2);
                            } else {
                                AppBrandPage.this.mNavigationBar.setNavBackgroundColor(ColorUtils.parseColor(optString2));
                            }
                        }
                        nativeViewRequestEvent.ok();
                    }
                });
            } else {
                nativeViewRequestEvent.fail("native view error");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "SET_NAV_BAR_BG_COLOR error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void setNavbarTitle(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final String optString = new JSONObject(nativeViewRequestEvent.jsonParams).optString("title");
            if (this.mNavigationBar != null) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AppBrandPage.this.mNavigationBar.setTitleTextFromMiniApp(optString);
                        nativeViewRequestEvent.ok();
                    }
                });
            } else {
                nativeViewRequestEvent.fail("native view error");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "SET_NAV_BAR_TITLE error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void setShowRedDot(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("index", -1);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.10
                @Override // java.lang.Runnable
                public void run() {
                    if (AppBrandPage.this.mTabBar != null) {
                        AppBrandPage.this.mTabBar.showTabBarRedDot(optInt);
                    }
                }
            });
            nativeViewRequestEvent.ok();
        } catch (Throwable th5) {
            QMLog.e(TAG, "API_SET_TABBAR_BADGE error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void setTabbarBadge(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final String optString = jSONObject.optString("type");
            final int optInt = jSONObject.optInt("index", -1);
            final String optString2 = jSONObject.optString("text");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.12
                @Override // java.lang.Runnable
                public void run() {
                    if (AppBrandPage.this.mTabBar != null) {
                        if (optString.equals("text")) {
                            AppBrandPage.this.mTabBar.setTabBarBadge(optInt, optString2);
                        } else if (optString.equals("redDot")) {
                            AppBrandPage.this.mTabBar.showTabBarRedDot(optInt);
                        } else if (optString.equals("none")) {
                            AppBrandPage.this.mTabBar.hideBadge(optInt);
                        }
                    }
                }
            });
            nativeViewRequestEvent.ok();
        } catch (Throwable th5) {
            QMLog.e(TAG, "API_SET_TABBAR_BADGE error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void setTabbarItem(NativeViewRequestEvent nativeViewRequestEvent) {
        final Bitmap bitmap;
        final Bitmap bitmap2;
        ByteArrayInputStream readApkgToStream;
        ByteArrayInputStream readApkgToStream2;
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final int optInt = jSONObject.optInt("index", -1);
            if (optInt >= 0 && optInt <= 3) {
                final String optString = jSONObject.optString("text");
                String optString2 = jSONObject.optString("iconPath");
                String optString3 = jSONObject.optString("selectedIconPath");
                Bitmap localBitmap = ImageUtil.getLocalBitmap(this.mMiniAppContext.getMiniAppInfo().apkgInfo.getChildFileAbsolutePath(optString2));
                Bitmap localBitmap2 = ImageUtil.getLocalBitmap(this.mMiniAppContext.getMiniAppInfo().apkgInfo.getChildFileAbsolutePath(optString3));
                ApkgInfo apkgInfo = getApkgInfo();
                if (localBitmap == null && apkgInfo != null && (readApkgToStream2 = apkgInfo.readApkgToStream(optString2)) != null) {
                    bitmap = BitmapFactory.decodeStream(readApkgToStream2);
                } else {
                    bitmap = localBitmap;
                }
                if (localBitmap2 == null && apkgInfo != null && (readApkgToStream = apkgInfo.readApkgToStream(optString3)) != null) {
                    bitmap2 = BitmapFactory.decodeStream(readApkgToStream);
                } else {
                    bitmap2 = localBitmap2;
                }
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.14
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AppBrandPage.this.mTabBar != null) {
                            AppBrandPage.this.mTabBar.setTabBarItem(optInt, optString, bitmap, bitmap2);
                        }
                    }
                });
                nativeViewRequestEvent.ok();
                return;
            }
            nativeViewRequestEvent.fail("invalid index");
        } catch (Throwable th5) {
            QMLog.e(TAG, "API_SET_TABBAR_ITEM error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void setTabbarStyle(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final String optString = jSONObject.optString("color");
            final String optString2 = jSONObject.optString("selectedColor");
            final String optString3 = jSONObject.optString("backgroundColor");
            final String optString4 = jSONObject.optString(NodeProps.BORDER_STYLES, "black");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.13
                @Override // java.lang.Runnable
                public void run() {
                    if (AppBrandPage.this.mTabBar != null) {
                        AppBrandPage.this.mTabBar.setTabBarStyle(optString, optString2, optString3, optString4);
                    }
                }
            });
            nativeViewRequestEvent.ok();
        } catch (Throwable th5) {
            QMLog.e(TAG, "API_SET_TABBAR_STYLE error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void showNabbarLoading(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.6
            @Override // java.lang.Runnable
            public void run() {
                if (AppBrandPage.this.mNavigationBar != null) {
                    AppBrandPage.this.mNavigationBar.showLoading();
                    nativeViewRequestEvent.ok();
                } else {
                    nativeViewRequestEvent.fail("native view error");
                }
            }
        });
    }

    private void showTabbar(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final boolean optBoolean = new JSONObject(nativeViewRequestEvent.jsonParams).optBoolean("animation", false);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.16
                @Override // java.lang.Runnable
                public void run() {
                    if (AppBrandPage.this.mTabBar != null && AppBrandPage.this.mCurPageWebviewContainer != null && AppBrandPage.this.mCurPageWebviewContainer.getNativeViewContainer() != null && !AppBrandPage.this.mCurPageWebviewContainer.getNativeViewContainer().isInnerWebView()) {
                        AppBrandPage.this.mTabBar.showTabBar(optBoolean);
                    }
                    nativeViewRequestEvent.ok();
                }
            });
        } catch (Throwable th5) {
            QMLog.e(TAG, "API_SHOW_TABBAR error.", th5);
            nativeViewRequestEvent.fail("native exception");
        }
    }

    private void switchTab(String str) {
        if (getApkgInfo() != null && getApkgInfo().isTabBarPage(str)) {
            if (this.mTabBar.getNeedShow()) {
                this.mTabBar.setVisibility(0);
            }
            this.mTabBar.setTabSelected(str);
        } else {
            TabBar tabBar = this.mTabBar;
            if (tabBar != null) {
                tabBar.setVisibility(8);
            }
        }
    }

    private NavigationBar tryCreateCustomerNavigation() {
        EntryModel entryModel = getEntryModel();
        if (entryModel == null) {
            return null;
        }
        String str = entryModel.titleBarClassName;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            NavigationBar navigationBar = (NavigationBar) Class.forName(str).getConstructor(Context.class).newInstance(getContext());
            QMLog.d(TAG, "tryCreateCustomerNavigation success:" + str);
            return navigationBar;
        } catch (Exception e16) {
            QMLog.e(TAG, "navigationClassName is " + str + "fail because:" + e16);
            return null;
        }
    }

    private void updateHomeIconState(String str) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null && this.mMiniAppContext.getMiniAppInfo().isReportTypeMiniApp()) {
            if (!"default".equals(this.mNavigationStyle)) {
                this.mNavigationBar.setHomeIconVisibility(8);
                return;
            }
            if (this.mRootContainer.isHomePageInStackBottom()) {
                if (isShowHomeButtonFromAppConfig(str) && isShowHomeButtonByPageTypeFromAppId()) {
                    this.mNavigationBar.setHomeIconVisibility(0);
                    return;
                } else {
                    this.mNavigationBar.setHomeIconVisibility(8);
                    return;
                }
            }
            if (isShowHomeButtonByPageTypeNotFromPageId()) {
                this.mNavigationBar.setHomeIconVisibility(0);
                return;
            } else if (isShowHomeButtonByPageTypeFromAppId() && isShowHomeButtonFromAppConfig(str)) {
                this.mNavigationBar.setHomeIconVisibility(0);
                return;
            } else {
                this.mNavigationBar.setHomeIconVisibility(8);
                return;
            }
        }
        this.mNavigationBar.setHomeIconVisibility(8);
    }

    private void updateNavigationBar(String str) {
        WindowInfo windowInfo;
        int pageCount = this.mRootContainer.getPageCount();
        if (isAppConfigInfoEnable()) {
            windowInfo = getApkgInfo().getAppConfigInfo().getPageInfo(str).windowInfo;
        } else {
            windowInfo = null;
        }
        this.mNavigationBar.setPageCount(pageCount);
        this.mNavigationBar.updateByWindowInfo(windowInfo, this.mMiniAppContext.getAttachActivity());
        this.mNavigationBar.updateByMiniAppContext(this.mMiniAppContext);
        updateHomeIconState(str);
    }

    private void updatePadOrientation() {
        boolean z16;
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (miniAppProxy != null && miniAppProxy.getDeviceType() == MiniAppProxy.DeviceType.PHONE) {
            return;
        }
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null && this.mMiniAppContext.getContext() != null) {
            String pageOrientation = this.mRootContainer.getPageOrientation();
            boolean z17 = false;
            if (pageOrientation != null && !TextUtils.equals(pageOrientation, "portrait") && !TextUtils.isEmpty(pageOrientation)) {
                z16 = false;
            } else {
                z16 = true;
            }
            QMLog.d(TAG, "UpdatePadOrientation isPagePortrait: " + z16 + " " + pageOrientation);
            boolean equals = TextUtils.equals(pageOrientation, "auto");
            if (miniAppProxy != null && miniAppProxy.getDeviceType() == MiniAppProxy.DeviceType.FOLD) {
                refreshOrientation();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = DisplayUtil.getScreenHeight(this.mMiniAppContext.getAttachActivity());
                if (!miniAppProxy.isSplitView(getContext())) {
                    layoutParams.gravity = 17;
                    QMLog.d(TAG, "UpdatePadOrientation folder open and not split!");
                    return;
                }
                return;
            }
            QMLog.d(TAG, "UpdatePadOrientation tablet.");
            if (equals) {
                QMLog.d(TAG, "UpdatePadOrientation orientation auto");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = DisplayUtil.getScreenHeight(this.mMiniAppContext.getAttachActivity());
                return;
            }
            if (getResources().getConfiguration().orientation == 1) {
                z17 = true;
            }
            QMLog.d(TAG, "UpdatePadOrientation  isSystemPortrait: " + z17);
            if (z16 && z17) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                layoutParams3.width = -1;
                layoutParams3.height = DisplayUtil.getScreenHeight(this.mMiniAppContext.getAttachActivity());
                return;
            }
            if (!z16 && !z17) {
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                layoutParams4.width = -1;
                layoutParams4.height = -1;
                return;
            } else {
                if (!z17 && z16) {
                    FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                    layoutParams5.width = (int) (((DisplayUtil.getRealHeight(getContext()) * 1.0f) / DisplayUtil.getRealScreenWidth(getContext())) * DisplayUtil.getRealHeight(getContext()));
                    layoutParams5.height = DisplayUtil.getScreenHeight(this.mMiniAppContext.getAttachActivity());
                    layoutParams5.gravity = 17;
                    return;
                }
                if (z17 && !z16) {
                    FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                    layoutParams6.width = -1;
                    layoutParams6.height = (int) (((DisplayUtil.getRealScreenWidth(getContext()) * 1.0f) / DisplayUtil.getRealHeight(getContext())) * DisplayUtil.getRealScreenWidth(getContext()));
                    layoutParams6.gravity = 17;
                    return;
                }
                return;
            }
        }
        QMLog.e(TAG, "UpdatePadOrientation error, context is null");
    }

    private void updatePageStyle(String str) {
        String str2;
        boolean z16 = false;
        if (isAppConfigInfoEnable()) {
            str2 = getApkgInfo().getAppConfigInfo().getPageInfo(str).windowInfo.navigationBarInfo.style;
            PageWebviewContainer pageWebviewContainer = this.mCurPageWebviewContainer;
            if ((pageWebviewContainer == null || pageWebviewContainer.getNativeViewContainer() == null || !this.mCurPageWebviewContainer.getNativeViewContainer().isInnerWebView()) && getApkgInfo().getAppConfigInfo().tabBarInfo != null && !getApkgInfo().getAppConfigInfo().tabBarInfo.custom) {
                z16 = true;
            }
        } else {
            str2 = null;
        }
        if (!this.mNavigationStyle.equals(str2) || this.mTabBarState != z16) {
            updateViewStyle(str2);
            this.mTabBarState = z16;
            this.mNavigationStyle = str2;
        }
    }

    private void updateSwipeBack() {
        boolean z16;
        boolean z17;
        IMiniAppContext iMiniAppContext;
        boolean z18 = false;
        int i3 = 1;
        if (this.mRootContainer.getPageCount() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getApkgInfo() != null && getApkgInfo().mMiniAppInfo != null) {
            z17 = getApkgInfo().mMiniAppInfo.isLimitedAccessApp();
        } else {
            z17 = false;
        }
        if (!z16 || !z17) {
            z18 = true;
        }
        setSwipeBackEnable(z18);
        if (z16) {
            setViewDragHelper(this.mRootContainer, this);
        } else {
            setViewDragHelper(this, this.mContentView);
        }
        if (z16) {
            i3 = 2;
        }
        setScrollDirection(i3);
        PageGestureProxy pageGestureProxy = this.mPageGuestProxy;
        if (pageGestureProxy != null && (iMiniAppContext = this.mMiniAppContext) != null) {
            pageGestureProxy.onLoadUrl(iMiniAppContext);
        }
    }

    private void updateTabBar(RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2) {
        if (this.mTabBar.getNeedShow()) {
            this.mTabBar.setVisibility(0);
        }
        this.mTabBar.setInfo(getApkgInfo().getAppConfigInfo().tabBarInfo, isHalf2FullMini());
        if ("top".equals(getApkgInfo().getAppConfigInfo().tabBarInfo.position)) {
            if ("default".equals(this.mNavigationStyle)) {
                this.mRootView.addView(this.centerLayout);
                this.mRootView.addView(this.mTabBar);
                this.mRootView.addView(this.mNavigationBar);
                layoutParams.addRule(3, this.mTabBar.getId());
                return;
            }
            if ("custom".equals(this.mNavigationStyle)) {
                addView(this.centerLayout);
                addView(this.mTabBar);
                addView(this.mNavigationBar);
                return;
            }
            return;
        }
        if (this.mNavigationBar.shouldContentBelow(this.mNavigationStyle)) {
            this.mRootView.addView(this.centerLayout);
            this.mRootView.addView(this.mTabBar);
            this.mRootView.addView(this.mNavigationBar);
            layoutParams.addRule(3, this.mNavigationBar.getId());
            layoutParams.addRule(2, this.mTabBar.getId());
            layoutParams2.addRule(12, -1);
            if (isHalfMini()) {
                this.mNavigationBar.setCapsuleVisible(8);
                return;
            } else {
                if (isHalf2FullMini()) {
                    this.mNavigationBar.setMaskVisible(8);
                    this.mNavigationBar.setCapsuleVisible(0);
                    return;
                }
                return;
            }
        }
        if ("custom".equals(this.mNavigationStyle)) {
            this.mRootView.addView(this.centerLayout);
            this.mRootView.addView(this.mTabBar);
            this.mRootView.addView(this.mNavigationBar);
            if (isHalfMini()) {
                layoutParams.addRule(3, this.mNavigationBar.getId());
                this.mNavigationBar.setCapsuleVisible(8);
            } else if (isHalf2FullMini()) {
                this.mNavigationBar.setMaskVisible(8);
                this.mNavigationBar.setCapsuleVisible(0);
            }
            layoutParams.addRule(2, this.mTabBar.getId());
            layoutParams2.addRule(12, -1);
            if (isHalfMini()) {
                layoutParams.topMargin = -DisplayUtil.dip2px(this.mMiniAppContext.getContext(), 40.0f);
            }
        }
    }

    public void cleanUp() {
        Iterator<Map.Entry<String, PageWebviewContainer>> it = this.mTabPageCache.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cleanUp();
            it.remove();
        }
        PageWebviewContainer pageWebviewContainer = this.mCurPageWebviewContainer;
        if (pageWebviewContainer != null) {
            pageWebviewContainer.cleanUp();
            this.mCurPageWebviewContainer = null;
        }
        try {
            removeAllViews();
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
        }
        this.mRootView = null;
        this.mPageUrl = null;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.AbsAppBrandPage
    public View createContentView() {
        if (this.mRootView == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.mRootView = relativeLayout;
            relativeLayout.setContentDescription("rootview");
            this.mRootView.setImportantForAccessibility(2);
            this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, DisplayUtil.getRealHeight(getContext())));
        }
        return this.mRootView;
    }

    public BrandPageWebview getBrandPageWebview() {
        if (getPageWebviewContainer() != null) {
            return getPageWebviewContainer().getBrandPageWebview();
        }
        return null;
    }

    public BrandPageWebview getBrandPageWebviewById(int i3) {
        if (!isTabBarPage()) {
            if (getPageWebviewId() != i3) {
                return null;
            }
            return getBrandPageWebview();
        }
        Iterator<Map.Entry<String, PageWebviewContainer>> it = this.mTabPageCache.entrySet().iterator();
        while (it.hasNext()) {
            PageWebviewContainer value = it.next().getValue();
            if (value.getWebViewId() == i3) {
                return value.getBrandPageWebview();
            }
        }
        return null;
    }

    public CapsuleButton getCapsuleButton() {
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            return navigationBar.getCapsuleButton();
        }
        return null;
    }

    public FrameLayout getCenterLayout() {
        return this.centerLayout;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.AbsAppBrandPage
    public String getCurShowingUrl() {
        return this.mPageUrl;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.AbsAppBrandPage
    public PageWebview getCurrentPageWebview() {
        BrandPageWebview brandPageWebview = getBrandPageWebview();
        if (brandPageWebview != null) {
            return brandPageWebview.getRealView();
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar.a
    public IMiniAppContext getMiniAppContext() {
        return this.mMiniAppContext;
    }

    public NavigationBar getNavBar() {
        return this.mNavigationBar;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.AbsAppBrandPage
    public NavigationBar getNaviBar() {
        return this.mNavigationBar;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar.a
    public RelativeLayout getPageRootView() {
        return this.mRootView;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.AbsAppBrandPage
    public PageWebviewContainer getPageWebviewContainer() {
        return this.mCurPageWebviewContainer;
    }

    public int getPageWebviewId() {
        if (getPageWebviewContainer() != null) {
            return getPageWebviewContainer().getWebViewId();
        }
        return -1;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.AbsAppBrandPage
    public AppBrandPageContainer getRootContainer() {
        return this.mRootContainer;
    }

    public TabBar getTabBar() {
        return this.mTabBar;
    }

    public boolean handleBackPressed() {
        PageWebviewContainer pageWebviewContainer = this.mCurPageWebviewContainer;
        if (pageWebviewContainer != null && pageWebviewContainer.handleBackPressed()) {
            return true;
        }
        return false;
    }

    public String handleNativeUIEvent(NativeViewRequestEvent nativeViewRequestEvent) {
        QMLog.d(TAG, "event = " + nativeViewRequestEvent.event + ", params = " + nativeViewRequestEvent.jsonParams);
        if ("showTabBar".equals(nativeViewRequestEvent.event)) {
            showTabbar(nativeViewRequestEvent);
            return null;
        }
        if ("hideTabBar".equals(nativeViewRequestEvent.event)) {
            hidetabbar(nativeViewRequestEvent);
            return null;
        }
        if ("setTabBarItem".equals(nativeViewRequestEvent.event)) {
            setTabbarItem(nativeViewRequestEvent);
            return null;
        }
        if ("setTabBarStyle".equals(nativeViewRequestEvent.event)) {
            setTabbarStyle(nativeViewRequestEvent);
            return null;
        }
        if ("setTabBarBadge".equals(nativeViewRequestEvent.event)) {
            setTabbarBadge(nativeViewRequestEvent);
            return null;
        }
        if (TabBarJsPlugin.API_REMOVE_TABBAR_BADGE.equals(nativeViewRequestEvent.event)) {
            removeTabbarBadge(nativeViewRequestEvent);
            return null;
        }
        if (TabBarJsPlugin.API_SHOW_RED_DOT.equals(nativeViewRequestEvent.event)) {
            setShowRedDot(nativeViewRequestEvent);
            return null;
        }
        if (TabBarJsPlugin.API_HITD_RED_DOT.equals(nativeViewRequestEvent.event)) {
            hideRedDot(nativeViewRequestEvent);
            return null;
        }
        if ("setNavigationBarTitle".equals(nativeViewRequestEvent.event)) {
            setNavbarTitle(nativeViewRequestEvent);
            return null;
        }
        if ("showNavigationBarLoading".equals(nativeViewRequestEvent.event)) {
            showNabbarLoading(nativeViewRequestEvent);
            return null;
        }
        if ("hideNavigationBarLoading".equals(nativeViewRequestEvent.event)) {
            hideNavbarLoading(nativeViewRequestEvent);
            return null;
        }
        if ("setNavigationBarColor".equals(nativeViewRequestEvent.event)) {
            setNavbarBgColor(nativeViewRequestEvent);
            return null;
        }
        if ("scrollWebviewTo".equals(nativeViewRequestEvent.event)) {
            handlePageScrollTo(nativeViewRequestEvent);
            return null;
        }
        if (NavigationBarPlugin.HIDE_NAVBAR_HOME_BUTTON.equals(nativeViewRequestEvent.event)) {
            hideNavbarHomeButton(nativeViewRequestEvent);
            return null;
        }
        return null;
    }

    public void hideMiniAIOEntrance() {
        MiniAIOEntranceProxy miniAIOEntranceProxy = this.miniAIOEntryView;
        if (miniAIOEntranceProxy != null) {
            miniAIOEntranceProxy.setVisibility(8);
            this.miniAIOEntryView.onDestroy();
            this.miniAIOEntryView = null;
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.AbsAppBrandPage
    public boolean isCustomNavibar() {
        String str = this.mNavigationStyle;
        if (str != null) {
            return str.equals("custom");
        }
        return false;
    }

    public boolean isHomePage() {
        if (this.mMiniAppContext != null && getApkgInfo() != null) {
            return getApkgInfo().isHomePage(this.mPageUrl);
        }
        return false;
    }

    public boolean isTabBarPage() {
        if (getApkgInfo() != null) {
            return getApkgInfo().isTabBarPage(this.mPageUrl);
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar.a
    public boolean isTabPage() {
        return isTabBarPage();
    }

    public void loadUrl(String str, String str2, PageEventListener pageEventListener) {
        List<TabBarInfo.ButtonInfo> list;
        if (!isReadyLoadUrl(str)) {
            QMLog.e(TAG, "loadurl not ready, return , error url:" + str);
            return;
        }
        if (isHalf2FullMini() && getApkgInfo().getAppConfigInfo() != null && getApkgInfo().getAppConfigInfo().tabBarInfo != null && (list = getApkgInfo().getAppConfigInfo().tabBarInfo.list) != null && !list.isEmpty() && !TextUtils.equals(str, list.get(0).pagePath)) {
            str = list.get(0).pagePath;
        }
        if (str.equals(this.mPageUrl)) {
            if (isPageWebViewReady(this.mPageUrl)) {
                pageEventListener.onWebViewReady(str2, this.mPageUrl, this.mRootContainer.getShowingPageWebViewId());
                onResume();
                return;
            }
            return;
        }
        this.mRootContainer.hideSoftInput(this);
        realLoadUrl(str, str2, pageEventListener);
        updatePageStyle(str);
        updateNavigationBar(str);
        updateSwipeBack();
        switchTab(str);
        updatePadOrientation();
        onResume();
    }

    public void notifyChangePullDownRefreshStyle(int i3) {
        Map<String, PageWebviewContainer> map = this.mTabPageCache;
        if (map == null) {
            QMLog.d(TAG, "No need to notifyChangePullDownRefreshStyle. tab page cache is null");
            return;
        }
        Iterator<Map.Entry<String, PageWebviewContainer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().notifyChangePullDownRefreshStyle(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar.a
    public void onClickBack(NavigationBar navigationBar) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null && !this.mMiniAppContext.getAttachActivity().isFinishing()) {
            this.mMiniAppContext.getAttachActivity().onBackPressed();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar.a
    public void onClickHome(NavigationBar navigationBar) {
        ApkgInfo apkgInfo = getApkgInfo();
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null && !this.mMiniAppContext.getAttachActivity().isFinishing() && apkgInfo != null && apkgInfo.getAppConfigInfo() != null && isHomeIconShow()) {
            this.mRootContainer.switchTab(apkgInfo.mAppConfigInfo.entryPagePath);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updatePadOrientation();
    }

    @Override // com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout.Callback
    public void onMoveAppBrandToBack() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null && !this.mMiniAppContext.getAttachActivity().isFinishing()) {
            this.mMiniAppContext.getAttachActivity().moveTaskToBack(true);
        }
    }

    public void onPause() {
        QMLog.d(TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        if (getCurrentPageWebview() != null) {
            getCurrentPageWebview().onPause();
        }
        PageWebviewContainer pageWebviewContainer = this.mCurPageWebviewContainer;
        if (pageWebviewContainer != null && pageWebviewContainer.getNativeViewContainer() != null) {
            this.mCurPageWebviewContainer.getNativeViewContainer().onPause();
        }
        MiniAIOEntranceProxy miniAIOEntranceProxy = this.miniAIOEntryView;
        if (miniAIOEntranceProxy != null) {
            miniAIOEntranceProxy.onPause();
        }
        if (isHalfMini() && MiniAppUtils.getMiniAppInfo() != null) {
            SDKMiniProgramLpReportDC04239.reportAsyncR9(MiniAppUtils.getMiniAppInfo(), "page_view", "2hide", "", "", "", "halfscreen");
        } else if (MiniAppUtils.getMiniAppInfo() != null) {
            SDKMiniProgramLpReportDC04239.reportAsyncR9(MiniAppUtils.getMiniAppInfo(), "page_view", "2hide", "", "", "", ReportConst.ACTION.FULLSCREEN);
        }
    }

    public void onResume() {
        QMLog.d(TAG, " onResume");
        if (getCurrentPageWebview() != null) {
            getCurrentPageWebview().onResume();
        }
        PageWebviewContainer pageWebviewContainer = this.mCurPageWebviewContainer;
        if (pageWebviewContainer != null && pageWebviewContainer.getNativeViewContainer() != null) {
            this.mCurPageWebviewContainer.getNativeViewContainer().onResume();
        }
        MiniAIOEntranceProxy miniAIOEntranceProxy = this.miniAIOEntryView;
        if (miniAIOEntranceProxy != null) {
            miniAIOEntranceProxy.onResume();
        }
        if (needRecreateNavigation() || isHalf2FullMini()) {
            initNavigationBar();
            updateViewStyle(this.mNavigationStyle);
            updateNavigationBar(this.mPageUrl);
            if (isHalf2FullMini()) {
                MiniAppUtils.getMiniAppInfo().launchParam.entryModel.type = 9;
            }
        }
        if (isHalfMini() && MiniAppUtils.getMiniAppInfo() != null) {
            SDKMiniProgramLpReportDC04239.reportAsyncR9(MiniAppUtils.getMiniAppInfo(), "page_view", "2show", this.mPageUrl, MiniAppReportManager2.ReportShowReserve.CODE_PATH_PAGE_SHOW, "", "", "halfscreen");
        } else if (MiniAppUtils.getMiniAppInfo() != null) {
            SDKMiniProgramLpReportDC04239.reportAsyncR9(MiniAppUtils.getMiniAppInfo(), "page_view", "2show", this.mPageUrl, MiniAppReportManager2.ReportShowReserve.CODE_PATH_PAGE_SHOW, "", "", ReportConst.ACTION.FULLSCREEN);
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout.Callback
    public void onSwipeFinish() {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPage.1
            @Override // java.lang.Runnable
            public void run() {
                AppBrandPage.this.mRootContainer.navigateBack(1, -1);
            }
        });
    }

    public void refreshOrientation() {
        PageWebviewContainer pageWebviewContainer = this.mCurPageWebviewContainer;
        if (pageWebviewContainer != null) {
            pageWebviewContainer.refreshOrientation();
        }
    }

    public boolean showMiniAIOEntrance(JSONObject jSONObject) {
        String str;
        int i3;
        int i16 = -10;
        if (jSONObject != null) {
            int density = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt(HippyTKDListViewAdapter.X, -10)) + 0.5f);
            int density2 = (int) ((DisplayUtil.getDensity(getContext()) * jSONObject.optInt("y", -10)) + 0.5f);
            str = jSONObject.optString("style");
            i3 = density2;
            i16 = density;
        } else {
            str = "";
            i3 = -10;
        }
        if (i16 >= 0 && i3 >= 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = i16;
            layoutParams.topMargin = i3;
            MiniAIOEntranceProxy miniAIOEntranceProxy = this.miniAIOEntryView;
            if (miniAIOEntranceProxy == null) {
                MiniAIOEntranceProxy miniAIOEntranceView = ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getMiniAIOEntranceView(this.mMiniAppContext.getAttachActivity(), str);
                this.miniAIOEntryView = miniAIOEntranceView;
                this.mRootView.addView(miniAIOEntranceView, layoutParams);
                return true;
            }
            miniAIOEntranceProxy.setMiniAIOStyle(str);
            this.miniAIOEntryView.setLayoutParams(layoutParams);
            requestLayout();
            return true;
        }
        return false;
    }

    public void updateNavigationByWindowInfo(Activity activity) {
        if (!TextUtils.isEmpty(this.mPageUrl) && isAppConfigInfoEnable()) {
            WindowInfo windowInfo = getApkgInfo().getAppConfigInfo().getPageInfo(this.mPageUrl).windowInfo;
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null && windowInfo != null) {
                navigationBar.updateByWindowInfo(windowInfo, activity);
            }
        }
    }

    public void updateViewStyle(String str) {
        this.mNavigationStyle = str;
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout == null) {
            QMLog.e(TAG, " mRootView is null ");
            return;
        }
        if (relativeLayout.getChildCount() > 0) {
            this.mRootView.removeAllViews();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, NavigationBar.getDefaultNaviBarHeight(this.mMiniAppContext.getContext()));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, TabBar.getDefaultTabBarHeight(this.mMiniAppContext.getContext()));
        if (isEntryModelValid()) {
            LaunchParam launchParam = this.mMiniAppContext.getMiniAppInfo().launchParam;
            this.mLaunchParam = launchParam;
            if (launchParam.entryModel.type == 9) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, NavigationBar.getHalfNaviBarHeight(this.mMiniAppContext.getContext()));
            }
        }
        if (this.mMiniAppContext != null && getApkgInfo() != null && getApkgInfo().getAppConfigInfo() != null && getApkgInfo().getAppConfigInfo().tabBarInfo != null && !getApkgInfo().getAppConfigInfo().tabBarInfo.custom) {
            updateTabBar(layoutParams, layoutParams3);
        } else if (this.mNavigationBar.shouldContentBelow(this.mNavigationStyle)) {
            this.mRootView.addView(this.mNavigationBar);
            this.mRootView.addView(this.centerLayout);
            layoutParams.addRule(12);
            layoutParams.addRule(3, this.mNavigationBar.getId());
        } else if ("custom".equals(this.mNavigationStyle)) {
            this.mRootView.addView(this.centerLayout);
            this.mRootView.addView(this.mNavigationBar);
            if (isHalfMini()) {
                layoutParams.addRule(12, -1);
                layoutParams.addRule(3, this.mNavigationBar.getId());
                layoutParams.topMargin = -DisplayUtil.dip2px(this.mMiniAppContext.getContext(), 40.0f);
            }
        }
        this.centerLayout.setLayoutParams(layoutParams);
        this.mTabBar.setLayoutParams(layoutParams3);
        this.mNavigationBar.setLayoutParams(layoutParams2);
        this.mNavigationBar.setBarStyle(this.mNavigationStyle);
    }
}
