package com.tencent.mobileqq.gamecenter.qa.metadream;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.fragment.BaseHippyContainer;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamAttaReportApi;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ud1.MetaDreamFrameworkConfig;
import ud1.MetaDreamHippyConfig;

/* compiled from: P */
@Page(business = Business.Default, type = PageHierarchy.MainPage)
/* loaded from: classes12.dex */
public class MetaDreamFrame extends Frame implements BaseHippyContainer.LoadListener, Handler.Callback, View.OnClickListener, com.tencent.mobileqq.perf.memory.cache.a, h {
    private static final String DEFAULT_KUIKLY_PAGE_NAME = "meta_dream_page";
    private static final String DEFAULT_KUIKLY_RES_ID = "meta_dream_page";
    private static final String DEFAULT_KUIKLY_URL = "https://youxi.gamecenter.qq.com/ogame/meta-dream/home?adtag=tab";
    private static final String HIPPY_DOMAIN = "gamecenter.qq.com";
    private static final String HIPPY_ERROR_URL = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?_wv=18950115&_wwv=393&forceHtml=true";
    private static final String HIPPY_URL = "https://youxi.gamecenter.qq.com/ogame/meta-dream/home?params=adtag%253Dtab";
    private static final String LOADING_BG_URL = "https://img.gamecenter.qq.com/xgame/gm/1688009358462_2ff0d87b97a11c7a4bf3405e3b888cf4.png";
    private static final String LOADING_LOTTIE_ANIM = "metadream/lottie/metadream_loading.json";
    private static final int MSG_CODE_DESTROY_ENGINE = 1;
    private static final int MSG_CODE_REOPEN_WHEN_ORIENTATION_CHANGE = 2;
    private static final String TAG = "MetaDreamFrame";
    private static final String URL_KEY_PARAMS = "params";
    private FrameLayout mContentLayoutContainer;
    private String mCurrentBundleName;
    private FrameLayout mErrorContainer;
    private BaseHippyContainer mHippyContainer;
    private boolean mIsTabSelect;
    private g mKuiklyRenderView;
    private LottieAnimationView mLoadingAnimView;
    private URLImageView mLoadingBgView;
    private RelativeLayout mLoadingContainer;
    private OpenHippyInfo mNextPreloadHippyInfo;
    private ViewGroup mRootView;
    private boolean isFirstEnter = true;
    private WeakReferenceHandler mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    private b mErrorViewWrapper = new b();
    private int mFrameworkType = 0;
    private int mOrientation = 1;

    private void adjustContainerBottomMargin() {
        int bottomTabHeight = getBottomTabHeight();
        QLog.d(TAG, 1, "adjustContainerBottomMargin bottomTabHeight=", Integer.valueOf(bottomTabHeight));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentLayoutContainer.getLayoutParams();
        layoutParams.bottomMargin = bottomTabHeight;
        this.mContentLayoutContainer.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mLoadingContainer.getLayoutParams();
        layoutParams2.bottomMargin = bottomTabHeight;
        this.mLoadingContainer.setLayoutParams(layoutParams2);
        ((FrameLayout.LayoutParams) this.mErrorContainer.getLayoutParams()).bottomMargin = bottomTabHeight;
        this.mErrorContainer.setLayoutParams(layoutParams2);
    }

    private String appendRedpointInfoToUrl(String str, com.tencent.mobileqq.gamecenter.metadream.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (aVar != null && !TextUtils.isEmpty(aVar.f212208c)) {
            String deleteParameter = URLUtil.deleteParameter(str, "params");
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("adtag=tab&extraType=1&extraInfo=");
                sb5.append(URLUtil.encodeUrl("jumpInfo=" + URLUtil.encodeUrl(aVar.f212208c)));
                str = URLUtil.addParameter(deleteParameter, "params", URLUtil.encodeUrl(sb5.toString()));
            } catch (Exception e16) {
                QLog.e(TAG, 1, "appendExtraInfoToUrl exception=", e16);
            }
        }
        QLog.d(TAG, 1, "appendExtraInfoToUrl url=", str);
        return str;
    }

    private void clearImgCache() {
        QLog.d(TAG, 1, "clearImgCache");
        URLDrawable.removeMemoryCacheByUrl(LOADING_BG_URL, getLoadingDrawableOptions());
        if (!isUseHippy()) {
            QCircleFeedPicLoader.g().release();
        }
    }

    private void clearMemory() {
        this.mContentLayoutContainer.removeAllViews();
        clearImgCache();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.metadream.MetaDreamFrame.1
            @Override // java.lang.Runnable
            public void run() {
                QQVideoPlaySDKManager.clearMemory(106);
            }
        }, 64, null, false);
    }

    private void deleteForbiddenVersionDir(MetaDreamHippyConfig metaDreamHippyConfig) {
        File moduleIndex;
        List<Integer> c16 = metaDreamHippyConfig.c();
        if (c16 != null && c16.size() > 0) {
            Iterator<Integer> it = c16.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue > 0 && (moduleIndex = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleIndex(metaDreamHippyConfig.getBundleName(), intValue)) != null && moduleIndex.exists()) {
                    QLog.d(TAG, 1, "deleteForbiddenVersionDir:", moduleIndex.getParentFile());
                    FileUtils.deleteDirectory(moduleIndex.getParentFile().getAbsolutePath());
                }
            }
        }
    }

    private void destroyHippyEngine() {
        if (this.mHippyContainer != null) {
            this.mErrorContainer.removeAllViews();
            this.mHippyContainer.onDestroy();
            this.mHippyContainer = null;
        }
        MetaDreamHippyConfig metaDreamHippyConfig = (MetaDreamHippyConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100909");
        if (1 == metaDreamHippyConfig.getHippyEngineLoadType() || 2 == metaDreamHippyConfig.getHippyEngineLoadType()) {
            OpenHippyInfo openHippyInfo = new OpenHippyInfo();
            openHippyInfo.bundleName = this.mCurrentBundleName;
            openHippyInfo.processName = "main";
            openHippyInfo.from = "metadream_tab";
            if (1 == metaDreamHippyConfig.getHippyEngineLoadType()) {
                openHippyInfo.preloadType = TabPreloadItem.PreloadType.PRE_LOAD;
            } else if (2 == metaDreamHippyConfig.getHippyEngineLoadType()) {
                openHippyInfo.preloadType = TabPreloadItem.PreloadType.PRE_DRAW;
            }
            this.mNextPreloadHippyInfo = openHippyInfo;
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage(openHippyInfo);
        }
        QLog.i(TAG, 1, "destroyHippyEngine preloadType:" + metaDreamHippyConfig.getHippyEngineLoadType());
    }

    private void destroyKuilkyView() {
        QLog.i(TAG, 1, "destroyKuilkyView");
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onPause();
            this.mKuiklyRenderView.onDetach();
            this.mKuiklyRenderView = null;
        }
    }

    private int getBottomTabHeight() {
        FrameFragment b16 = a.f212593a.b();
        if (b16 == null) {
            return 0;
        }
        int height = b16.mTabWidget.getHeight();
        int h16 = com.tencent.mobileqq.qui.b.f276860a.h(b16.getContext());
        QLog.d(TAG, 1, "getBottomTabHeight bottomTabHeight=", Integer.valueOf(height), ", navBarHeight=", Integer.valueOf(h16));
        return height - h16;
    }

    private void getFrameworkType() {
        MetaDreamFrameworkConfig metaDreamFrameworkConfig = (MetaDreamFrameworkConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101269");
        if (metaDreamFrameworkConfig != null) {
            this.mFrameworkType = metaDreamFrameworkConfig.getFrameworkType();
        } else {
            QLog.w(TAG, 1, "getFrameworkType config null");
        }
        QLog.d(TAG, 1, "getFrameworkType type=", Integer.valueOf(this.mFrameworkType));
    }

    private URLDrawable.URLDrawableOptions getLoadingDrawableOptions() {
        int screenWidth = DisplayUtil.getScreenWidth();
        int i3 = (screenWidth * 1137) / gdt_analysis_event.EVENT_GET_USER_AGENT;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = screenWidth;
        obtain.mRequestHeight = i3;
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        return obtain;
    }

    private OpenHippyInfo getOpenHippyInfo() {
        OpenHippyInfo openHippyInfo;
        MetaDreamHippyConfig metaDreamHippyConfig = (MetaDreamHippyConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100909");
        if (metaDreamHippyConfig != null) {
            deleteForbiddenVersionDir(metaDreamHippyConfig);
            openHippyInfo = new OpenHippyInfo(metaDreamHippyConfig.getOpenHippyInfo());
        } else {
            openHippyInfo = null;
        }
        if (openHippyInfo == null || TextUtils.isEmpty(openHippyInfo.bundleName)) {
            QLog.d(TAG, 1, "getOpenHippyInfo config null");
            openHippyInfo = new OpenHippyInfo();
            openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_META_DREAM;
            openHippyInfo.domain = "gamecenter.qq.com";
            openHippyInfo.url = HIPPY_URL;
            openHippyInfo.processName = "main";
            openHippyInfo.isTransparent = true;
            openHippyInfo.updateJsBundleType = 1;
            openHippyInfo.isAnimated = true;
            openHippyInfo.isStatusBarDarkFont = true;
        }
        this.mCurrentBundleName = openHippyInfo.bundleName;
        com.tencent.mobileqq.gamecenter.metadream.a tabRedpointInfo = ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getTabRedpointInfo();
        if (tabRedpointInfo != null) {
            openHippyInfo.url = appendRedpointInfoToUrl(openHippyInfo.url, tabRedpointInfo);
            ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setTabRedpointInfo(null);
        }
        return openHippyInfo;
    }

    private void hideHippyLoadingView() {
        QLog.i(TAG, 1, "hideLoadingView");
        if (this.mLoadingContainer.getVisibility() == 0) {
            this.mLoadingAnimView.pauseAnimation();
            this.mLoadingContainer.setVisibility(8);
        }
    }

    private void hideLoadErrorView() {
        FrameLayout frameLayout = this.mErrorContainer;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.mErrorViewWrapper.a();
    }

    private void initHippy() {
        QLog.i(TAG, 1, "initHippy");
        BaseHippyContainer baseHippyContainer = new BaseHippyContainer(getOpenHippyInfo());
        this.mHippyContainer = baseHippyContainer;
        baseHippyContainer.setLoadListener(this);
        this.mHippyContainer.onCreateView(getActivity(), a.f212593a.b(), this.mContentLayoutContainer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initKuiklyView() {
        Map<String, Object> map;
        String str;
        g createKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(this.mRootView.getContext(), this);
        this.mKuiklyRenderView = createKuiklyRenderView;
        this.mContentLayoutContainer.addView((View) createKuiklyRenderView);
        HashMap hashMap = new HashMap();
        MetaDreamHippyConfig metaDreamHippyConfig = (MetaDreamHippyConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100909");
        if (metaDreamHippyConfig != null) {
            str = metaDreamHippyConfig.getKuiklyPageName();
            map = KuiklyLaunchParams.INSTANCE.m(metaDreamHippyConfig.getOpenKuilyInfo());
        } else {
            map = hashMap;
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "meta_dream_page";
        }
        if (!map.containsKey("bundle_name")) {
            map.put("bundle_name", str);
        }
        if (!map.containsKey("url")) {
            map.put("url", DEFAULT_KUIKLY_URL);
        }
        int Z = (int) ah.Z();
        int y16 = (int) ah.y();
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getActivity());
        int bottomTabHeight = getBottomTabHeight();
        int i3 = (y16 + statusBarHeight) - bottomTabHeight;
        QLog.d(TAG, 1, "initKuiklyView pageName=", str, ", width=", Integer.valueOf(Z), ", height=", Integer.valueOf(i3), ", statusBarHeight=", Integer.valueOf(statusBarHeight), ", bottomTabHeight=", Integer.valueOf(bottomTabHeight), ", deviceHeight=", Integer.valueOf(y16));
        this.mKuiklyRenderView.b(str, map, new Size(Z, i3));
    }

    private void initView() {
        int i3 = this.mFrameworkType;
        if (i3 == 1) {
            initKuiklyView();
        } else if (i3 == 0) {
            initHippy();
        }
    }

    private boolean isUseHippy() {
        if (this.mFrameworkType == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadErrorToHippy() {
        QLog.i(TAG, 1, "loadErrorToHippy");
        this.mContentLayoutContainer.removeView((View) this.mKuiklyRenderView);
        destroyKuilkyView();
        this.mFrameworkType = 0;
        initHippy();
        this.mHippyContainer.onResume();
    }

    private void reportLoadResult(boolean z16, boolean z17) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        if (z17) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("ext1", str);
        IMetaDreamAttaReportApi iMetaDreamAttaReportApi = (IMetaDreamAttaReportApi) QRoute.api(IMetaDreamAttaReportApi.class);
        if (z16) {
            str2 = "1001103";
        } else {
            str2 = "1001104";
        }
        iMetaDreamAttaReportApi.report(str2, "8", "100", "10011", "page_home", "module_qqtab", hashMap);
    }

    private void reportShow() {
        HashMap hashMap = new HashMap();
        hashMap.put("ext1", String.valueOf(this.mFrameworkType));
        ((IMetaDreamAttaReportApi) QRoute.api(IMetaDreamAttaReportApi.class)).report("1001102", "8", "100", "10011", "page_home", "module_qqtab", hashMap);
    }

    private void showHippyLoadingView() {
        QLog.i(TAG, 1, "showLoadingView");
        this.mLoadingContainer.setVisibility(0);
        this.mLoadingBgView = (URLImageView) this.mLoadingContainer.findViewById(R.id.ef9);
        URLDrawable.URLDrawableOptions loadingDrawableOptions = getLoadingDrawableOptions();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLoadingBgView.getLayoutParams();
        layoutParams.width = loadingDrawableOptions.mRequestWidth;
        layoutParams.height = loadingDrawableOptions.mRequestHeight;
        this.mLoadingBgView.setLayoutParams(layoutParams);
        this.mLoadingBgView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mLoadingBgView.setImageDrawable(URLDrawable.getDrawable(LOADING_BG_URL, loadingDrawableOptions));
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.mLoadingContainer.findViewById(R.id.yta);
        this.mLoadingAnimView = lottieAnimationView;
        lottieAnimationView.setAnimation(LOADING_LOTTIE_ANIM);
        this.mLoadingAnimView.playAnimation();
    }

    private void showLoadErrorView() {
        FrameLayout frameLayout = this.mErrorContainer;
        if (frameLayout == null) {
            return;
        }
        if (frameLayout.getVisibility() != 0) {
            this.mErrorContainer.setVisibility(0);
        }
        this.mErrorViewWrapper.b(this.mErrorContainer, this);
    }

    public BaseHippyContainer getBaseHippyContainer() {
        return this.mHippyContainer;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleMessage msg.what:", Integer.valueOf(message.what));
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                QLog.d(TAG, 1, "handleMessage, reopen");
                clearMemory();
                if (isUseHippy()) {
                    destroyHippyEngine();
                    initHippy();
                    this.mHippyContainer.onResume();
                } else {
                    destroyKuilkyView();
                    initKuiklyView();
                    this.mKuiklyRenderView.onResume();
                }
                ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setMetaDreamFrameAlive(true);
            }
        } else {
            QLog.d(TAG, 1, "handleMessage, destroy engine");
            clearMemory();
            if (isUseHippy()) {
                destroyHippyEngine();
            } else {
                destroyKuilkyView();
            }
            ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setMetaDreamFrameAlive(false);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        hideHippyLoadingView();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyActivityResult(int i3, int i16, Intent intent) {
        g gVar;
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onActivityResult(i3, i16, intent);
        }
        if (this.mFrameworkType == 1 && (gVar = this.mKuiklyRenderView) != null) {
            gVar.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyConfigurationChanged(Configuration configuration) {
        super.notifyConfigurationChanged(configuration);
        QLog.d(TAG, 1, "onConfigurationChanged mIsTabSelect=", Boolean.valueOf(this.mIsTabSelect), ", new orientation=", Integer.valueOf(configuration.orientation), ", orientation=", Integer.valueOf(this.mOrientation));
        if (this.mIsTabSelect) {
            int i3 = this.mOrientation;
            int i16 = configuration.orientation;
            if (i3 != i16) {
                this.mOrientation = i16;
                this.mUIHandler.removeMessages(2);
                this.mUIHandler.sendEmptyMessage(2);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyCreate() {
        super.notifyCreate();
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onCreate();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public View notifyCreateView(LayoutInflater layoutInflater) {
        QLog.i(TAG, 1, "onCreateView this:" + this);
        a.f212593a.c(this);
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.fha, (ViewGroup) null, false);
        this.mRootView = viewGroup;
        this.mLoadingContainer = (RelativeLayout) viewGroup.findViewById(R.id.ef_);
        this.mContentLayoutContainer = (FrameLayout) this.mRootView.findViewById(R.id.x_x);
        this.mErrorContainer = (FrameLayout) this.mRootView.findViewById(R.id.by9);
        adjustContainerBottomMargin();
        getFrameworkType();
        initView();
        if (isUseHippy()) {
            com.tencent.mobileqq.perf.memory.cache.b.f257663a.c(this);
        }
        ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setMetaDreamFrameAlive(true);
        return this.mRootView;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyDestroy() {
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onDestroy();
        }
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onDetach();
        }
        super.notifyDestroy();
        ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setMetaDreamFrameAlive(false);
        com.tencent.mobileqq.perf.memory.cache.b.f257663a.f(this);
        if (this.mNextPreloadHippyInfo != null) {
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).destroyPreloadHippy(this.mNextPreloadHippyInfo);
            this.mNextPreloadHippyInfo = null;
            QLog.i(TAG, 1, "onDestroy destroyPreloadHippy");
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyNewIntent(Intent intent) {
        super.notifyNewIntent(intent);
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyPause(boolean z16) {
        super.notifyPause(z16);
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onPause();
        }
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyResume(boolean z16) {
        super.notifyResume(z16);
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onResume();
        }
        g gVar = this.mKuiklyRenderView;
        if (gVar != null) {
            gVar.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStart() {
        super.notifyStart();
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onStart();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStop() {
        super.notifyStop();
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onStop();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        hideLoadErrorView();
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.reload();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyContainer.LoadListener
    public void onLoadError() {
        showLoadErrorView();
        reportLoadResult(false, false);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyContainer.LoadListener
    public void onLoadingComplete() {
        hideHippyLoadingView();
        reportLoadResult(true, false);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyContainer.LoadListener
    public void onLoadingStart() {
        showHippyLoadingView();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean z16, @Nullable ErrorReason errorReason, @NonNull KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
        QLog.d(TAG, 1, "onPageLoadComplete result=", Boolean.valueOf(z16));
        if (!z16) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.metadream.MetaDreamFrame.2
                @Override // java.lang.Runnable
                public void run() {
                    MetaDreamFrame.this.loadErrorToHippy();
                }
            });
        }
        reportLoadResult(z16, true);
    }

    public void onTabChange(boolean z16) {
        int i3;
        QLog.d(TAG, 1, "onTabChange, isVisible=", Boolean.valueOf(z16));
        this.mIsTabSelect = z16;
        this.mUIHandler.removeMessages(1);
        if (!z16) {
            MetaDreamHippyConfig metaDreamHippyConfig = (MetaDreamHippyConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100909");
            if (metaDreamHippyConfig != null) {
                i3 = metaDreamHippyConfig.getDestroyDelay();
            } else {
                i3 = 3000;
            }
            QLog.d(TAG, 1, "onTabChange, destroy engine, delay=", Integer.valueOf(i3));
            this.mUIHandler.sendEmptyMessageDelayed(1, i3);
        } else {
            PerfFeature.a(PerfFeature.CustomFlag.MetaDream);
            QLog.d(TAG, 1, "onTabChange, isFirstEnter=", Boolean.valueOf(this.isFirstEnter), ", mHippyContainer=", this.mHippyContainer);
            if (!this.isFirstEnter && this.mHippyContainer == null && this.mKuiklyRenderView == null) {
                getFrameworkType();
                if (isUseHippy()) {
                    if (this.mHippyContainer == null) {
                        initHippy();
                        this.mHippyContainer.onResume();
                        ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setMetaDreamFrameAlive(true);
                    }
                } else if (this.mKuiklyRenderView == null) {
                    initKuiklyView();
                    g gVar = this.mKuiklyRenderView;
                    if (gVar != null) {
                        gVar.onResume();
                    }
                    ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setMetaDreamFrameAlive(true);
                }
            }
            reportShow();
        }
        this.isFirstEnter = false;
    }

    @Override // com.tencent.mobileqq.perf.memory.cache.a
    public void onTrimMemory(int i3) {
        if ((i3 >= 40 || i3 == 15) && this.mNextPreloadHippyInfo != null) {
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).destroyPreloadHippy(this.mNextPreloadHippyInfo);
            this.mNextPreloadHippyInfo = null;
            QLog.i(TAG, 1, "destroyPreloadHippy");
        }
        QLog.i(TAG, 1, "onTrimMemory");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        loadErrorToHippy();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        showHippyLoadingView();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
    }

    @Override // com.tencent.mobileqq.app.Frame
    public void fillData(boolean z16) {
    }

    @Override // com.tencent.mobileqq.perf.memory.cache.a
    public void onClear(@NonNull ClearMode clearMode, float f16) {
    }
}
