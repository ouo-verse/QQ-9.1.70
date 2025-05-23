package com.tencent.ad.tangram.views.canvas.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.halfScreen.AdHalfScreen;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.landing_page_collect_data;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdReportForAction;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.ad.tangram.statistics.canvas.AdReporterForDMPWithCanvas;
import com.tencent.ad.tangram.statistics.canvas.AdTimeStatistics;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.AdCanvasDownloadListener;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView;
import com.tencent.ad.tangram.views.canvas.components.fixedbutton.AdCanvasFixedButtonComponentData;
import com.tencent.ad.tangram.views.canvas.components.fixedbutton.AdCanvasFixedButtonComponentView;
import com.tencent.ad.tangram.views.canvas.components.keyelements.AdAutoLayoutTextView;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentData;
import com.tencent.ad.tangram.views.canvas.components.pictures.AdCanvasMultiPictureComponentData;
import com.tencent.ad.tangram.views.xijing.AdButtonData;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdCanvasView extends FrameLayout implements AdCanvasViewListener, AdAppDownloadManager.AppDataCallback {
    private static final int BOTTOM_FIXED_BTN_ID = 819;
    private static final String CANVAS_BAR = "iVBORw0KGgoAAAANSUhEUgAAAAIAAACgCAYAAAAmYr3BAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAAqADAAQAAAABAAAAoAAAAADn/3BcAAAAe0lEQVQ4Ec1SWwoAIQi03b3R3v9s5QQN+KFCQRUU5iNncoqI/LrlwYFF49NLNZ4jITQ1MCphJCFgl50sEjwBCyDtvEzOmVmM73XwGIR2FgkL50FUbR3TnCTGt9wCdU1sN7EIZJOIzWExV7Wgw1drC+opEhpByOT07vTQaJMEPn19hHfNAAAAAElFTkSuQmCC";
    private static final String CLOSE_ICON = "iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAt0lEQVR4AWL4//9/AhBfA+J6AO11gMFADERheNnDBxQFIEAg9E4FCsgdOo+GUPzgfzxiBh/sYC83sVr1E/P6PXYeIvo8nJVBz+vEZTQZGd7V1z+uoTNmdhIOaMK4hDIuooyLKOMiyriIMi6ijIso4R4KuIAC7qF8MvDBeSjgKjrh1DT0TiWc7xRwByVcQQWcUQFnVMAZFXBGBZxRA8+yAWrgLYs3oAa+9k/bqvYTlfBR/e47EBcBAMrZsFl4ehiPAAAAAElFTkSuQmCC";
    private static final int FLOADTING_PROGRESS_BTN_ID = 273;
    private static final String TAG = "AdCanvasView";
    private static final int TOP_FIXED_BTN_ID = 546;
    public static long sStartTimeMillis = -2147483648L;
    private AdCanvasFixedButtonComponentView bottomFixedButtonView;
    private RelativeLayout bottomFixedWebAppCommonButtonContainer;
    private RelativeLayout canvasViewContainer;
    private RelativeLayout closeIcon;
    private ImageView closeView;
    private FrameLayout contentView;

    @Nullable
    private AdCanvasData data;
    private AdCanvasAppBtnComponentView floatingAppBtnComponentView;
    private FrameLayout floatingProgressBar;
    private ImageView gradientLayerBg;
    private boolean hasComponentLoadFailed;
    private boolean isUserInteracted;
    private RelativeLayout keyElementsLayout;
    private boolean loadReportedForAction;
    private boolean loadReportedForDMP;
    private boolean loadSuccess;

    @NonNull
    private Set<String> loadTimeIds;

    @Nullable
    protected AdTimeStatistics loadTimeStatistics;

    @Nullable
    private AdAppDownloadManager mAppDownloadManager;

    @Nullable
    private AdCanvasPageView pageView;
    private boolean reportPageLoaded;

    @NonNull
    private AdTimeStatistics stayTimeStatistics;
    private RelativeLayout topBar;
    private AdCanvasFixedButtonComponentView topFixedButtonView;

    public AdCanvasView(@NonNull Context context) {
        super(context);
        this.loadTimeStatistics = new AdTimeStatistics();
        this.loadReportedForDMP = false;
        this.loadReportedForAction = false;
        this.loadSuccess = true;
        this.isUserInteracted = false;
        this.loadTimeIds = new HashSet();
        this.stayTimeStatistics = new AdTimeStatistics();
        this.hasComponentLoadFailed = false;
        this.reportPageLoaded = false;
        init();
    }

    private void addViewByOrder() {
        RelativeLayout relativeLayout = this.canvasViewContainer;
        FrameLayout frameLayout = this.contentView;
        relativeLayout.addView(frameLayout, frameLayout.getLayoutParams());
        RelativeLayout relativeLayout2 = this.canvasViewContainer;
        AdCanvasFixedButtonComponentView adCanvasFixedButtonComponentView = this.topFixedButtonView;
        relativeLayout2.addView(adCanvasFixedButtonComponentView, adCanvasFixedButtonComponentView.getLayoutParams());
        RelativeLayout relativeLayout3 = this.canvasViewContainer;
        AdCanvasFixedButtonComponentView adCanvasFixedButtonComponentView2 = this.bottomFixedButtonView;
        relativeLayout3.addView(adCanvasFixedButtonComponentView2, adCanvasFixedButtonComponentView2.getLayoutParams());
        RelativeLayout relativeLayout4 = this.canvasViewContainer;
        RelativeLayout relativeLayout5 = this.bottomFixedWebAppCommonButtonContainer;
        relativeLayout4.addView(relativeLayout5, relativeLayout5.getLayoutParams());
        this.canvasViewContainer.addView(this.floatingProgressBar);
        RelativeLayout relativeLayout6 = this.canvasViewContainer;
        RelativeLayout relativeLayout7 = this.topBar;
        relativeLayout6.addView(relativeLayout7, relativeLayout7.getLayoutParams());
    }

    private void dealXiJingDefaultPageIfTriggleDownload() {
        AdCanvasData adCanvasData = this.data;
        if (adCanvasData != null && adCanvasData.isValid() && this.mAppDownloadManager != null && this.data.f61337ad.isAppXiJingDefault()) {
            if ((this.mAppDownloadManager.hasStartedDownload() || this.data.getAutoDownLoad()) && this.bottomFixedButtonView.getVisibility() == 0) {
                this.floatingProgressBar.setVisibility(8);
                if (this.bottomFixedButtonView.getVisibility() == 0) {
                    this.bottomFixedButtonView.doClick();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Activity getActivity() {
        if (getContext() instanceof Activity) {
            return (Activity) getContext();
        }
        return null;
    }

    private void init() {
        startLoad();
        initCanvasViewContainer();
        initFloatingProgressBarContainer();
        initFixedBtnAndFloatingFixedBtnContainer();
        initTopBar();
        AdAppDownloadManager adAppDownloadManager = new AdAppDownloadManager();
        this.mAppDownloadManager = adAppDownloadManager;
        adAppDownloadManager.setAppDataCallback(new WeakReference<>(this));
        AdCanvasDownloadListener.getInstance().setDownloadListener(this.mAppDownloadManager);
    }

    private void initCanvasViewContainer() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        addView(linearLayout, layoutParams);
        this.keyElementsLayout = new RelativeLayout(getContext());
        linearLayout.addView(this.keyElementsLayout, new RelativeLayout.LayoutParams(-1, AdUIUtils.getValueDependsOnScreenWidth(getContext(), 750, 70)));
        this.keyElementsLayout.setBackgroundColor(Color.parseColor("#F5F6F8"));
        this.keyElementsLayout.setVisibility(8);
        this.canvasViewContainer = new RelativeLayout(getContext());
        linearLayout.addView(this.canvasViewContainer, new FrameLayout.LayoutParams(-1, -1));
    }

    private void initFixedBtnAndFloatingFixedBtnContainer() {
        this.topFixedButtonView = new AdCanvasFixedButtonComponentView(getContext(), (WeakReference<AdCanvasViewListener>) new WeakReference(this));
        this.topFixedButtonView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.topFixedButtonView.setVisibility(8);
        this.bottomFixedButtonView = new AdCanvasFixedButtonComponentView(getContext(), (WeakReference<AdCanvasViewListener>) new WeakReference(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        this.bottomFixedButtonView.setElevation(10.0f);
        this.bottomFixedButtonView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        this.bottomFixedButtonView.setStateListAnimator(null);
        this.bottomFixedButtonView.setLayoutParams(layoutParams);
        this.bottomFixedButtonView.setVisibility(8);
        this.bottomFixedWebAppCommonButtonContainer = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12, -1);
        this.bottomFixedWebAppCommonButtonContainer.setLayoutParams(layoutParams2);
        this.bottomFixedWebAppCommonButtonContainer.setVisibility(8);
    }

    private void initFloatingProgressBarContainer() {
        this.floatingProgressBar = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AdUIUtils.dp2px(40.0f, getResources()));
        this.floatingProgressBar.setId(273);
        this.floatingProgressBar.setLayoutParams(layoutParams);
        this.floatingProgressBar.setVisibility(8);
    }

    private void initTopBar() {
        this.topBar = new RelativeLayout(getContext());
        this.topBar.setLayoutParams(new RelativeLayout.LayoutParams(-1, AdUIUtils.dp2px(40.0f, getResources())));
        this.gradientLayerBg = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.gradientLayerBg.setLayoutParams(layoutParams);
        Bitmap bitmapFromString = AdUIUtils.getBitmapFromString(CANVAS_BAR);
        if (bitmapFromString != null) {
            this.gradientLayerBg.setBackgroundDrawable(new BitmapDrawable(bitmapFromString));
        }
        this.closeIcon = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(60.0f, getResources()), AdUIUtils.dp2px(60.0f, getResources()));
        this.closeIcon.setLayoutParams(layoutParams2);
        this.closeView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(15.0f, getResources()), AdUIUtils.dp2px(15.0f, getResources()));
        layoutParams3.leftMargin = AdUIUtils.dp2px(12.0f, getResources());
        layoutParams3.topMargin = AdUIUtils.dp2px(12.0f, getResources());
        this.closeView.setImageBitmap(AdUIUtils.getBitmapFromString(CLOSE_ICON));
        this.closeIcon.addView(this.closeView, layoutParams3);
        this.closeIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.canvas.framework.AdCanvasView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AdCanvasView.this.back();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.topBar.addView(this.gradientLayerBg, layoutParams);
        this.topBar.addView(this.closeIcon, layoutParams2);
    }

    private void reportLoadTimeForAction(long j3, boolean z16) {
        AdCanvasData adCanvasData;
        Context context;
        int i3;
        if (j3 >= 0 && (adCanvasData = this.data) != null && adCanvasData.isValid()) {
            if (this.loadReportedForAction) {
                return;
            }
            this.loadReportedForAction = true;
            AdReportForAction.Params params = new AdReportForAction.Params();
            Ad ad5 = null;
            if (getActivity() != null) {
                context = getActivity().getApplicationContext();
            } else {
                context = null;
            }
            params.context = new WeakReference<>(context);
            if (getData() != null) {
                ad5 = getData().f61337ad;
            }
            params.f61333ad = ad5;
            landing_page_collect_data.LandingPageCollectData landingPageCollectData = params.data;
            if (z16) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            landingPageCollectData.landing_page_action_type = i3;
            landingPageCollectData.landing_error_code = 0;
            landingPageCollectData.latency_ms = j3;
            AdReportForAction.report(params);
            return;
        }
        AdLog.e(TAG, "reportLoadTimeForAction error");
    }

    private void reportPageLoaded() {
        Ad ad5;
        if (!this.loadReportedForDMP && getData() != null && getData().isValid()) {
            Context context = getContext();
            AdCanvasData adCanvasData = this.data;
            if (adCanvasData != null) {
                ad5 = adCanvasData.f61337ad;
            } else {
                ad5 = null;
            }
            AdCanvasReporterForLinkEvent.reportForNativeLandingPage(context, ad5, sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_LOAD_COMPONENT_RENDERED, sStartTimeMillis, Integer.MIN_VALUE);
            AdReporterForDMPWithCanvas.reportLoadAsync(getData().f61337ad, getData().getAutoDownLoad());
            this.loadReportedForDMP = true;
        }
    }

    private void reportStayTimeForAction() {
        Context context;
        AdCanvasData adCanvasData = this.data;
        if (adCanvasData != null && adCanvasData.isValid()) {
            AdReportForAction.Params params = new AdReportForAction.Params();
            Ad ad5 = null;
            if (getActivity() != null) {
                context = getActivity().getApplicationContext();
            } else {
                context = null;
            }
            params.context = new WeakReference<>(context);
            if (getData() != null) {
                ad5 = getData().f61337ad;
            }
            params.f61333ad = ad5;
            landing_page_collect_data.LandingPageCollectData landingPageCollectData = params.data;
            landingPageCollectData.landing_page_action_type = 7;
            landingPageCollectData.landing_error_code = 0;
            landingPageCollectData.latency_ms = this.stayTimeStatistics.getTime();
            AdReportForAction.report(params);
            return;
        }
        AdLog.e(TAG, "reportStayTimeForAction error");
    }

    private void setFixedButtonData() {
        ArrayList<AdCanvasFixedButtonComponentData> arrayList;
        AdCanvasData adCanvasData = this.data;
        if (adCanvasData != null && (arrayList = adCanvasData.fixedButtonComponentDataList) != null && arrayList.size() > 0) {
            Iterator<AdCanvasFixedButtonComponentData> it = arrayList.iterator();
            while (it.hasNext()) {
                AdCanvasFixedButtonComponentData next = it.next();
                if (next != null && !TextUtils.isEmpty(next.position)) {
                    if (next.position.toLowerCase().equals("top")) {
                        this.topFixedButtonView.setVisibility(0);
                        this.topFixedButtonView.init(getContext(), next, this.data.f61337ad, new WeakReference<>(this));
                    } else if (next.position.toLowerCase().equals("bottom")) {
                        this.bottomFixedButtonView.setVisibility(0);
                        this.bottomFixedButtonView.init(getContext(), next, this.data.f61337ad, new WeakReference<>(this));
                    }
                }
            }
        }
    }

    private void setFixedCommonButtonData() {
        int i3;
        int i16;
        boolean z16;
        AdCanvasPageView adCanvasPageView;
        LinearLayout container;
        AdCanvasData adCanvasData = this.data;
        if (adCanvasData != null) {
            ArrayList<AdCanvasFixedButtonComponentData> arrayList = adCanvasData.fixedButtonComponentDataList;
            boolean z17 = false;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<AdCanvasFixedButtonComponentData> it = arrayList.iterator();
                i3 = 0;
                i16 = 0;
                z16 = false;
                while (it.hasNext()) {
                    AdCanvasFixedButtonComponentData next = it.next();
                    i3 += next.topWhiteSpace;
                    i16 += next.bottomWhiteSpace;
                    z16 = true;
                }
            } else {
                i3 = 0;
                i16 = 0;
                z16 = false;
            }
            ArrayList<AdCanvasAppBtnComponentData> arrayList2 = this.data.appFixedButtonComponentDataList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                boolean z18 = false;
                for (int i17 = 0; i17 < arrayList2.size(); i17++) {
                    if (arrayList2.get(i17) != null && arrayList2.get(i17) != null) {
                        AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = arrayList2.get(i17);
                        this.bottomFixedWebAppCommonButtonContainer.addView(new AdCanvasAppBtnComponentView(getContext(), new WeakReference(this), adCanvasAppBtnComponentData, adCanvasAppBtnComponentData.canShowProgress, false));
                        this.bottomFixedWebAppCommonButtonContainer.setVisibility(0);
                        i16 += arrayList2.get(i17).whiteSpace;
                        z18 = true;
                    }
                }
                z17 = z18;
            }
            if ((z16 || z17) && (adCanvasPageView = this.pageView) != null && (container = adCanvasPageView.getContainer()) != null) {
                container.setPadding(container.getPaddingLeft(), container.getPaddingTop() + i3, container.getPaddingRight(), container.getPaddingBottom() + i16);
            }
        }
    }

    private void setFloatingButtonData(String str) {
        AdCanvasPageData page;
        List<AdCanvasComponentData> list;
        ArrayList<AdCanvasPictureComponentData> arrayList;
        AdCanvasData adCanvasData = this.data;
        if (adCanvasData != null && (page = adCanvasData.getPage(0)) != null && (list = page.components) != null && !page.isFloatingBarStyleSetted) {
            for (AdCanvasComponentData adCanvasComponentData : list) {
                if (adCanvasComponentData != null && (adCanvasComponentData instanceof AdCanvasMultiPictureComponentData) && (arrayList = ((AdCanvasMultiPictureComponentData) adCanvasComponentData).imageList) != null) {
                    Iterator<AdCanvasPictureComponentData> it = arrayList.iterator();
                    while (it.hasNext()) {
                        AdCanvasPictureComponentData next = it.next();
                        if (next != null && next.f61339id.equals(str)) {
                            page.floatingBarTextColor = next.floatingBarTextColor;
                            page.floatingBarBackgroundColor = next.floatingBarBackgroundColor;
                            AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = new AdCanvasAppBtnComponentData();
                            adCanvasAppBtnComponentData.f61339id = String.format("XJFloatingButton_%s", str);
                            AdButtonData adButtonData = adCanvasAppBtnComponentData.button;
                            AdTextData adTextData = adButtonData.text;
                            adTextData.text = "\u4e0b\u8f7d";
                            adTextData.color = page.floatingBarTextColor;
                            adButtonData.backgroundColor = page.floatingBarBackgroundColor;
                            int i3 = 1080;
                            adTextData.size = AdUIUtils.getValueDependsOnScreenWidth(getContext(), 1080, 54);
                            adCanvasAppBtnComponentData.button.borderWidth = 0;
                            int physicalScreenWidth = AdUIUtils.getPhysicalScreenWidth(getContext());
                            if (physicalScreenWidth > 0) {
                                i3 = physicalScreenWidth;
                            }
                            adCanvasAppBtnComponentData.width = i3;
                            adCanvasAppBtnComponentData.height = AdUIUtils.dp2px(50.0f, getContext().getResources());
                            adCanvasAppBtnComponentData.gravity = 17;
                            adCanvasAppBtnComponentData.canShowProgress = true;
                            this.floatingAppBtnComponentView = new AdCanvasAppBtnComponentView(getContext(), new WeakReference(this), adCanvasAppBtnComponentData, true, true);
                            this.floatingProgressBar.addView(this.floatingAppBtnComponentView, new FrameLayout.LayoutParams(-1, -1));
                            this.floatingProgressBar.setVisibility(8);
                            page.isFloatingBarStyleSetted = true;
                        }
                    }
                }
            }
        }
    }

    private void showProgressBarIfTriggleDownload() {
        AdCanvasData adCanvasData = this.data;
        if (adCanvasData != null && this.mAppDownloadManager != null) {
            String str = adCanvasData.firstPictureComponentIdWithHotArea;
            if (!TextUtils.isEmpty(str)) {
                if (this.mAppDownloadManager.hasStartedDownload() || this.data.getAutoDownLoad()) {
                    setFloatingButtonData(str);
                    if (this.floatingAppBtnComponentView != null) {
                        Ad ad5 = this.data.f61337ad;
                        if (ad5 == null || ad5.isAppProductType()) {
                            showProgressBar(str, false);
                        }
                    }
                }
            }
        }
    }

    public boolean back() {
        AdCanvasPageView adCanvasPageView = this.pageView;
        if (adCanvasPageView != null && adCanvasPageView.back()) {
            return true;
        }
        if (getActivity() != null) {
            getActivity().finish();
            return true;
        }
        return false;
    }

    @Override // com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener
    @Nullable
    public AdCanvasPageView getContentView() {
        return this.pageView;
    }

    @Override // com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener
    @Nullable
    public AdCanvasData getData() {
        return this.data;
    }

    @Override // com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener
    @Nullable
    public AdAppDownloadManager getDownloadManager() {
        return this.mAppDownloadManager;
    }

    public int getMaxVisibleAreaRatio() {
        Throwable th5;
        int i3;
        int height;
        AdCanvasPageView adCanvasPageView = this.pageView;
        if (adCanvasPageView == null || adCanvasPageView.getChildAt(0) == null) {
            return 0;
        }
        int maxDepth = this.pageView.getMaxDepth() + getHeight();
        AdLog.d(TAG, String.valueOf(maxDepth));
        int i16 = maxDepth * 100;
        try {
            int height2 = this.pageView.getChildAt(0).getHeight();
            RelativeLayout relativeLayout = this.keyElementsLayout;
            if (relativeLayout == null) {
                height = 0;
            } else {
                height = relativeLayout.getHeight();
            }
            i3 = i16 / (height2 + height);
        } catch (Throwable th6) {
            th5 = th6;
            i3 = 0;
        }
        try {
            AdLog.d(TAG, String.valueOf(this.pageView.getChildAt(0).getHeight()));
        } catch (Throwable th7) {
            th5 = th7;
            AdLog.e(TAG, "getMaxVisibleAreaRatio error", th5);
            return i3;
        }
        return i3;
    }

    public int getPageViewScrollY() {
        AdCanvasPageView adCanvasPageView = this.pageView;
        if (adCanvasPageView != null) {
            return adCanvasPageView.getScrollY();
        }
        return 0;
    }

    public void hideBar() {
        RelativeLayout relativeLayout = this.closeIcon;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ImageView imageView = this.gradientLayerBg;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener
    public void hotAreaClick(String str, String str2, String str3) {
        if ("top".equals(str) && !TextUtils.isEmpty(str2)) {
            showProgressBar(str2, true);
        }
    }

    public void onActivityDestroy() {
        int i3;
        AdLog.i(TAG, "onActivityDestroy");
        AdCanvasPageView adCanvasPageView = this.pageView;
        if (adCanvasPageView != null) {
            adCanvasPageView.onActivityDestroy();
        }
        AdCanvasFixedButtonComponentView adCanvasFixedButtonComponentView = this.topFixedButtonView;
        if (adCanvasFixedButtonComponentView != null && adCanvasFixedButtonComponentView.getVisibility() == 0) {
            this.topFixedButtonView.onActivityDestroy();
        }
        AdCanvasFixedButtonComponentView adCanvasFixedButtonComponentView2 = this.bottomFixedButtonView;
        if (adCanvasFixedButtonComponentView2 != null && adCanvasFixedButtonComponentView2.getVisibility() == 0) {
            this.bottomFixedButtonView.onActivityDestroy();
        }
        AdCanvasAppBtnComponentView adCanvasAppBtnComponentView = this.floatingAppBtnComponentView;
        if (adCanvasAppBtnComponentView != null) {
            adCanvasAppBtnComponentView.onActivityDestroy();
        }
        AdCanvasDownloadListener.getInstance().removeDownloadListener(this.mAppDownloadManager);
        AdAppDownloadManager adAppDownloadManager = this.mAppDownloadManager;
        Ad ad5 = null;
        if (adAppDownloadManager != null) {
            adAppDownloadManager.onDestroy();
            this.mAppDownloadManager = null;
        }
        reportStayTimeForAction();
        reportLoadTimeForAction(this.stayTimeStatistics.getTime(), false);
        if (this.reportPageLoaded) {
            if (this.isUserInteracted) {
                i3 = sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_AFTER_LOAD_SUCCESS;
            } else {
                i3 = sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_WITHOUT_ACTION;
            }
        } else {
            i3 = sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_BEFORE_LOAD_SUCCESS;
        }
        int i16 = i3;
        Context context = getContext();
        AdCanvasData adCanvasData = this.data;
        if (adCanvasData != null) {
            ad5 = adCanvasData.f61337ad;
        }
        AdCanvasReporterForLinkEvent.reportForNativeLandingPage(context, ad5, i16, sStartTimeMillis, getMaxVisibleAreaRatio());
    }

    public void onActivityPause() {
        AdCanvasPageView adCanvasPageView = this.pageView;
        if (adCanvasPageView != null) {
            adCanvasPageView.onActivityPause();
        }
        this.stayTimeStatistics.stop();
    }

    public void onActivityResume() {
        AdLog.i(TAG, "onActivityResume");
        if (this.pageView != null) {
            AdAppDownloadManager adAppDownloadManager = this.mAppDownloadManager;
            if (adAppDownloadManager != null) {
                adAppDownloadManager.fetchDownloadStatus(new AdAppDownloadManager.DownloadStatusCallback() { // from class: com.tencent.ad.tangram.views.canvas.framework.AdCanvasView.1
                    @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.DownloadStatusCallback
                    public void getDownloadStatus(int i3) {
                        if (i3 == 8 || i3 == 2 || i3 == 3 || i3 == 6) {
                            AdLog.e(AdCanvasView.TAG, "getDownloadStatus" + i3);
                            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.framework.AdCanvasView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdCanvasView.this.showFloatingProgressButton();
                                }
                            }, 0);
                        }
                    }
                });
            }
            this.pageView.onActivityResume();
            AdAppDownloadManager adAppDownloadManager2 = this.mAppDownloadManager;
            if (adAppDownloadManager2 != null) {
                adAppDownloadManager2.onActivityResume();
            }
            AdCanvasFixedButtonComponentView adCanvasFixedButtonComponentView = this.topFixedButtonView;
            if (adCanvasFixedButtonComponentView != null && adCanvasFixedButtonComponentView.getVisibility() == 0) {
                this.topFixedButtonView.onActivityResume();
            }
            AdCanvasFixedButtonComponentView adCanvasFixedButtonComponentView2 = this.bottomFixedButtonView;
            if (adCanvasFixedButtonComponentView2 != null && adCanvasFixedButtonComponentView2.getVisibility() == 0) {
                this.bottomFixedButtonView.onActivityResume();
            }
            AdCanvasAppBtnComponentView adCanvasAppBtnComponentView = this.floatingAppBtnComponentView;
            if (adCanvasAppBtnComponentView != null) {
                adCanvasAppBtnComponentView.onActivityResume();
            }
            if (this.bottomFixedWebAppCommonButtonContainer != null) {
                for (int i3 = 0; i3 < this.bottomFixedWebAppCommonButtonContainer.getChildCount(); i3++) {
                    View childAt = this.bottomFixedWebAppCommonButtonContainer.getChildAt(i3);
                    if (childAt != null && (childAt instanceof AdCanvasComponentView)) {
                        ((AdCanvasComponentView) childAt).onActivityResume();
                    }
                }
            }
            reportPageLoaded();
            this.stayTimeStatistics.start();
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.AppDataCallback
    public void onFetchSuccess(@Nullable AdAppBtnData adAppBtnData) {
        if (adAppBtnData == null) {
            return;
        }
        final String str = adAppBtnData.name;
        final String str2 = adAppBtnData.authorName;
        final String str3 = adAppBtnData.versionName;
        final String str4 = getData().appInfoRightUrl;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.framework.AdCanvasView.3
                @Override // java.lang.Runnable
                public void run() {
                    AdCanvasView.this.keyElementsLayout.setVisibility(0);
                    AdCanvasView.this.keyElementsLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.canvas.framework.AdCanvasView.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            AdHalfScreen.getInstance().showWithoutAd(new WeakReference<>(AdCanvasView.this.getActivity()), str4);
                            AdReporterForEffect.reportAsync(new WeakReference(AdCanvasView.this.getContext()), AdCanvasView.this.getData().f61337ad, 322);
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                    AdAutoLayoutTextView adAutoLayoutTextView = new AdAutoLayoutTextView(AdCanvasView.this.getContext());
                    adAutoLayoutTextView.setTextContent("\u5e94\u7528\u540d\u79f0:" + str, "\u5e94\u7528\u7248\u672c:" + str3, "\u5f00\u53d1\u8005:" + str2);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13, -1);
                    AdCanvasView.this.keyElementsLayout.addView(adAutoLayoutTextView, layoutParams);
                }
            }, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (this.closeView == null) {
            AdLog.d(TAG, "closeView is null");
            return super.onInterceptTouchEvent(motionEvent);
        }
        Region region = new Region();
        region.set(new Rect(this.closeView.getLeft(), this.closeView.getTop(), this.closeView.getRight(), this.closeView.getBottom()));
        AdLog.d(TAG, "region area" + region.toString());
        if (region.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.isUserInteracted = true;
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener
    public void onLoaded(@Nullable AdCanvasComponentData adCanvasComponentData, long j3, boolean z16) {
        Set<String> set;
        Ad ad5;
        if (adCanvasComponentData != null && adCanvasComponentData.isValid() && getData() != null && getData().isValid()) {
            Ad ad6 = null;
            if (!z16 && !this.hasComponentLoadFailed) {
                this.hasComponentLoadFailed = true;
                Context context = getContext();
                AdCanvasData adCanvasData = this.data;
                if (adCanvasData != null) {
                    ad5 = adCanvasData.f61337ad;
                } else {
                    ad5 = null;
                }
                AdCanvasReporterForLinkEvent.reportForNativeLandingPage(context, ad5, sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_LOAD_FAILED, sStartTimeMillis, Integer.MIN_VALUE);
            }
            if (!this.loadReportedForAction && (set = this.loadTimeIds) != null && adCanvasComponentData.isAddToLoadStatistics) {
                this.loadSuccess = z16 & this.loadSuccess;
                set.add(adCanvasComponentData.f61339id);
                AdLog.d(TAG, "AdCanvasComponentData id:" + adCanvasComponentData.f61339id);
                if (this.loadTimeIds.size() == getData().getToLoadIdsize()) {
                    reportLoadTimeForAction(stopLoad(), this.loadSuccess);
                    if (this.loadSuccess) {
                        this.reportPageLoaded = true;
                        Context context2 = getContext();
                        AdCanvasData adCanvasData2 = this.data;
                        if (adCanvasData2 != null) {
                            ad6 = adCanvasData2.f61337ad;
                        }
                        AdCanvasReporterForLinkEvent.reportForNativeLandingPage(context2, ad6, sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_LOAD_SUCCESS, sStartTimeMillis, Integer.MIN_VALUE);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        AdLog.e(TAG, "onLoaded error");
    }

    public void setData(@Nullable AdCanvasData adCanvasData) {
        if (adCanvasData != null && adCanvasData.isValid()) {
            this.data = adCanvasData;
            if (!adCanvasData.f61337ad.isAppProductType()) {
                this.data.setAutoDownload(false);
            }
            if (this.data.getPage(0) != null) {
                setBackgroundColor(this.data.getPage(0).backgroundColor);
            }
            this.topFixedButtonView.setId(546);
            this.bottomFixedButtonView.setId(BOTTOM_FIXED_BTN_ID);
            this.contentView = new FrameLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, this.topFixedButtonView.getId());
            this.contentView.setLayoutParams(layoutParams);
            AdCanvasPageView adCanvasPageView = new AdCanvasPageView(getContext(), new WeakReference(this), this.data.getPage(0));
            this.pageView = adCanvasPageView;
            this.contentView.addView(adCanvasPageView);
            setFixedButtonData();
            setFixedCommonButtonData();
            showProgressBarIfTriggleDownload();
            dealXiJingDefaultPageIfTriggleDownload();
            if (this.data.isPageWithoutButton() && !TextUtils.isEmpty(this.data.firstPictureComponentIdWithHotArea)) {
                setFloatingButtonData(this.data.firstPictureComponentIdWithHotArea);
            }
            addViewByOrder();
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener
    public void setPageViewTopMargin(int i3) {
        AdCanvasPageView adCanvasPageView = this.pageView;
        if (adCanvasPageView != null) {
            adCanvasPageView.setPageViewLayoutParams(i3);
        }
    }

    public void setStartTimeMillis(long j3) {
        sStartTimeMillis = j3;
    }

    public void showFloatingProgressButton() {
        FrameLayout frameLayout;
        if (this.topFixedButtonView.getVisibility() != 0 && this.bottomFixedButtonView.getVisibility() != 0 && this.bottomFixedWebAppCommonButtonContainer.getChildCount() <= 0 && (frameLayout = this.floatingProgressBar) != null && frameLayout.getVisibility() != 0 && this.data.hasMultiPictureData) {
            this.floatingProgressBar.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.contentView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.addRule(3, this.floatingProgressBar.getId());
            }
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener
    public void showProgressBar(String str, boolean z16) {
        AdCanvasAppBtnComponentView adCanvasAppBtnComponentView;
        if (this.topFixedButtonView.getVisibility() == 0 || this.bottomFixedButtonView.getVisibility() == 0) {
            this.floatingProgressBar.setVisibility(8);
            if (this.topFixedButtonView.getVisibility() == 0) {
                this.topFixedButtonView.doClick();
                return;
            } else if (this.bottomFixedButtonView.getVisibility() == 0) {
                this.bottomFixedButtonView.doClick();
                return;
            }
        }
        if (this.bottomFixedWebAppCommonButtonContainer.getChildCount() > 0) {
            if (z16) {
                for (int i3 = 0; i3 < this.bottomFixedWebAppCommonButtonContainer.getChildCount(); i3++) {
                    View childAt = this.bottomFixedWebAppCommonButtonContainer.getChildAt(i3);
                    if (childAt != null && (childAt instanceof AdCanvasAppBtnComponentView)) {
                        AdCanvasAppBtnComponentView adCanvasAppBtnComponentView2 = (AdCanvasAppBtnComponentView) childAt;
                        if (adCanvasAppBtnComponentView2.getData() != null && adCanvasAppBtnComponentView2.getData().canShowProgress) {
                            adCanvasAppBtnComponentView2.doClick();
                        }
                    }
                }
                return;
            }
            return;
        }
        if (this.floatingProgressBar.getVisibility() == 8) {
            setFloatingButtonData(str);
        }
        showFloatingProgressButton();
        if (z16 && (adCanvasAppBtnComponentView = this.floatingAppBtnComponentView) != null) {
            adCanvasAppBtnComponentView.doClick();
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.contentView.getLayoutParams();
        if (this.floatingProgressBar.getVisibility() == 0) {
            layoutParams.addRule(3, this.floatingProgressBar.getId());
        }
    }

    protected void startLoad() {
        AdTimeStatistics adTimeStatistics = this.loadTimeStatistics;
        if (adTimeStatistics != null) {
            adTimeStatistics.start();
        }
    }

    protected long stopLoad() {
        long j3;
        AdTimeStatistics adTimeStatistics = this.loadTimeStatistics;
        if (adTimeStatistics != null) {
            adTimeStatistics.stop();
            j3 = this.loadTimeStatistics.getTime();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        this.loadTimeStatistics = null;
        return j3;
    }

    public AdCanvasView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadTimeStatistics = new AdTimeStatistics();
        this.loadReportedForDMP = false;
        this.loadReportedForAction = false;
        this.loadSuccess = true;
        this.isUserInteracted = false;
        this.loadTimeIds = new HashSet();
        this.stayTimeStatistics = new AdTimeStatistics();
        this.hasComponentLoadFailed = false;
        this.reportPageLoaded = false;
        init();
    }

    public AdCanvasView(@NonNull Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.loadTimeStatistics = new AdTimeStatistics();
        this.loadReportedForDMP = false;
        this.loadReportedForAction = false;
        this.loadSuccess = true;
        this.isUserInteracted = false;
        this.loadTimeIds = new HashSet();
        this.stayTimeStatistics = new AdTimeStatistics();
        this.hasComponentLoadFailed = false;
        this.reportPageLoaded = false;
        init();
    }
}
