package com.tencent.mobileqq.vas.adv.maskad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.api.MaskAdDisappearListener;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00015B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u0013J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0006\u0010\"\u001a\u00020\u001eJ\u0006\u0010#\u001a\u00020\u001eJ\u0006\u0010$\u001a\u00020\u001eJ\b\u0010%\u001a\u00020\u001eH\u0002J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u0013J\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0013J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001cJ\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0002J\u000e\u00102\u001a\u00020\u001e2\u0006\u00100\u001a\u000201J\u000e\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u0013R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdRenderProxy;", "", "context", "Landroid/content/Context;", "source", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "resPath", "", "ad", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "(Landroid/content/Context;Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;Ljava/lang/String;Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V", "mAd", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAdExposureCheckerCallback", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mContext", "mExposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "mIsShowing", "", "mNeedReportAdExpose", "mProcessorProxy", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mRenderView", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdRenderView;", "mResFilePath", "mSource", "mUserActionReportInfo", "Ltencent/gdt/access$UserActionReportInfo;", "addClickAreaView", "", "getShowState", "handleMaskAdClick", "initExposeChecker", MosaicConstants$JsFunction.FUNC_ON_DESTROY, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "reportAdExpose", "setDisappearListener", "disappearListener", "Lcom/tencent/mobileqq/vas/adv/api/MaskAdDisappearListener;", "setIsTianShuAd", "isTianShu", "setNeedReportAdExpose", "needReport", "setUserActionReportInfo", "userActionReportInfo", "show", "parentView", "Landroid/view/ViewGroup;", "startShow", "updateShowState", ViewStickEventHelper.IS_SHOW, "Companion", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class MaskAdRenderProxy {

    @NotNull
    private static final String MASK_ZONE_VISIBLE_KEY = "key_debug_mask_ad_zone_show";
    private static final long REAL_TIME_LOAD_INTERNAL = 1500;

    @NotNull
    public static final String TAG = "MaskAdRenderProxy";

    @NotNull
    private GdtAd mAd;

    @Nullable
    private AdExposureChecker.ExposureCallback mAdExposureCheckerCallback;

    @Nullable
    private Context mContext;

    @Nullable
    private AdExposureChecker mExposureChecker;
    private boolean mIsShowing;
    private boolean mNeedReportAdExpose;

    @NotNull
    private final GdtThirdProcessorProxy mProcessorProxy;

    @Nullable
    private MaskAdRenderView mRenderView;

    @Nullable
    private String mResFilePath;

    @Nullable
    private MaskAdvName mSource;

    @Nullable
    private access.UserActionReportInfo mUserActionReportInfo;

    public MaskAdRenderProxy(@NotNull Context context, @NotNull MaskAdvName source, @NotNull String resPath, @NotNull qq_ad_get.QQAdGetRsp.AdInfo ad5) {
        MaskAdRenderView maskAdRenderView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(resPath, "resPath");
        Intrinsics.checkNotNullParameter(ad5, "ad");
        this.mAd = new GdtAd();
        this.mProcessorProxy = new GdtThirdProcessorProxy();
        this.mNeedReportAdExpose = true;
        this.mRenderView = new MaskAdRenderView(context, source, resPath, ad5);
        GdtAd gdtAd = new GdtAd(ad5);
        this.mAd = gdtAd;
        this.mContext = context;
        this.mSource = source;
        this.mResFilePath = resPath;
        if (MaskAdClickHelper.INSTANCE.checkIsNeedAddClickArea(gdtAd)) {
            addClickAreaView();
        }
        MaskAdRenderView maskAdRenderView2 = this.mRenderView;
        if (maskAdRenderView2 != null) {
            maskAdRenderView2.addSkipButton();
        }
        MaskAdRenderView maskAdRenderView3 = this.mRenderView;
        if (maskAdRenderView3 != null) {
            maskAdRenderView3.setAdClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.adv.maskad.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaskAdRenderProxy._init_$lambda$0(MaskAdRenderProxy.this, view);
                }
            });
        }
        Pair<Integer, Integer> pair = MaskAdRenderHelper.INSTANCE.getMMaskAdSizeMap().get(source);
        if (pair != null && (maskAdRenderView = this.mRenderView) != null) {
            maskAdRenderView.setHippyAdSize(pair.getFirst().intValue(), pair.getSecond().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MaskAdRenderProxy this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleMaskAdClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void addClickAreaView() {
        float coerceAtMost;
        float coerceAtMost2;
        float coerceAtLeast;
        float coerceAtLeast2;
        for (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ActionAreaItem actionAreaItem : this.mAd.getActionAreaItems()) {
            if (actionAreaItem.area_type.get() == 6) {
                View view = new View(this.mContext);
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ActionAreaItem.AreaBoundary areaBoundary = actionAreaItem.area_boundary.get();
                float f16 = (720 - areaBoundary.margin_left.get()) - areaBoundary.margin_right.get();
                float f17 = (1280 - areaBoundary.margin_top.get()) - areaBoundary.margin_bottom.get();
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(f16, 720.0f);
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(f17, 1280.0f);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0.0f, coerceAtMost * 0.541f);
                int dip2px = ViewUtils.dip2px(coerceAtLeast);
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(0.0f, coerceAtMost2 * 0.634f);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dip2px, ViewUtils.dip2px(coerceAtLeast2));
                view.setAlpha(0.0f);
                MMKVOptionEntity from = QMMKV.from(this.mContext, QMMKVFile.FILE_AD);
                Intrinsics.checkNotNullExpressionValue(from, "from(mContext, QMMKVFile.FILE_AD)");
                if (from.decodeBool(MASK_ZONE_VISIBLE_KEY, false)) {
                    view.setAlpha(0.3f);
                    view.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                }
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.adv.maskad.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        MaskAdRenderProxy.addClickAreaView$lambda$5(MaskAdRenderProxy.this, view2);
                    }
                });
                view.setX(ViewUtils.dip2px(areaBoundary.margin_left.get() * 0.541f));
                view.setY(ViewUtils.dip2px(areaBoundary.margin_top.get() * 0.634f));
                MaskAdRenderView maskAdRenderView = this.mRenderView;
                if (maskAdRenderView != null) {
                    maskAdRenderView.addClickAreaView(view, layoutParams);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addClickAreaView$lambda$5(MaskAdRenderProxy this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleMaskAdClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void handleMaskAdClick() {
        boolean z16;
        AdExposureChecker.onClick(this.mContext, this.mAd, new WeakReference(this.mAdExposureCheckerCallback));
        MaskAdClickHelper maskAdClickHelper = MaskAdClickHelper.INSTANCE;
        boolean isClickValid = maskAdClickHelper.isClickValid();
        Object obj = null;
        boolean z17 = false;
        if (isClickValid) {
            this.mProcessorProxy.c2sReportAsync(1, 0, this.mAd.info);
            MaskAdvName maskAdvName = this.mSource;
            if (maskAdvName != null) {
                ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).reportEventToBeacon(maskAdvName, MaskAdConstants.MASK_AD_DISPLAY_CLICK, null);
                MaskAdReportHelper.INSTANCE.reportWeatherHealthAction("new_folder_splashad_adclick", "", String.valueOf(this.mAd.getAId()), maskAdvName);
            }
            access.UserActionReportInfo userActionReportInfo = this.mUserActionReportInfo;
            if (userActionReportInfo != null) {
                MaskAdReportHelper.INSTANCE.reportAdByUrl(userActionReportInfo.click_url.get());
            }
            MaskAdRenderView maskAdRenderView = this.mRenderView;
            if (maskAdRenderView != null && maskAdRenderView.getIsTianShuAd()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                MaskAdReportHelper.INSTANCE.reportAdByUrl(this.mAd.getUrlForClick());
            }
        } else {
            QLog.e(TAG, 1, "handleMaskAdClick :click match rule, filter click");
        }
        MaskAdRenderView maskAdRenderView2 = this.mRenderView;
        if (maskAdRenderView2 != null && maskAdRenderView2.getIsTianShuAd()) {
            z17 = true;
        }
        if (z17) {
            Context context = this.mContext;
            if (context != null) {
                maskAdClickHelper.handleTianShuAdClick(this.mAd, context);
                return;
            }
            return;
        }
        GdtHandler.Params params = new GdtHandler.Params();
        params.f108486ad = this.mAd;
        Context context2 = this.mContext;
        if (context2 == null) {
            obj = QBaseActivity.sTopActivity;
        } else if (context2 instanceof Activity) {
            obj = (Activity) context2;
        }
        params.activity = new WeakReference<>(obj);
        Bundle bundle = new Bundle();
        params.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, AdDownloadConstants.DOWNLOAD_SOURCE_AD);
        params.reportForClick = isClickValid;
        params.startActivityRequestCode = MaskAdConstants.MASK_AD_ACTIVITY_RESULT_CODE;
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
    }

    private final void initExposeChecker() {
        View view;
        if (this.mAd.isValid() && this.mNeedReportAdExpose) {
            GdtAd gdtAd = this.mAd;
            MaskAdRenderView maskAdRenderView = this.mRenderView;
            if (maskAdRenderView != null) {
                view = maskAdRenderView.getAdContentView();
            } else {
                view = null;
            }
            this.mExposureChecker = new AdExposureChecker(gdtAd, new WeakReference(view));
            if (this.mAdExposureCheckerCallback == null) {
                this.mAdExposureCheckerCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.mobileqq.vas.adv.maskad.e
                    @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
                    public final void onExposure(WeakReference weakReference) {
                        MaskAdRenderProxy.initExposeChecker$lambda$12(MaskAdRenderProxy.this, weakReference);
                    }
                };
            }
            AdExposureChecker adExposureChecker = this.mExposureChecker;
            if (adExposureChecker != null) {
                adExposureChecker.setCallback(new WeakReference<>(this.mAdExposureCheckerCallback));
            }
            AdExposureChecker adExposureChecker2 = this.mExposureChecker;
            if (adExposureChecker2 != null) {
                adExposureChecker2.startCheck();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initExposeChecker$lambda$12(MaskAdRenderProxy this$0, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MaskAdvName maskAdvName = this$0.mSource;
        if (maskAdvName != null) {
            MaskAdReportHelper.INSTANCE.reportWeatherHealthAction("new_folder_splashad_expose1s", "", String.valueOf(this$0.mAd.getAId()), maskAdvName);
            ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).reportEventToBeacon(maskAdvName, MaskAdConstants.MASK_AD_DISPLAY_EXPOSE, null);
        }
    }

    private final void reportAdExpose() {
        if (!this.mAd.isValid()) {
            QLog.e(TAG, 1, "expose cancel, adInfo is null");
            return;
        }
        access.UserActionReportInfo userActionReportInfo = this.mUserActionReportInfo;
        if (userActionReportInfo != null) {
            MaskAdReportHelper.INSTANCE.reportAdByUrl(userActionReportInfo.exposure_url.get());
        }
        if (!this.mNeedReportAdExpose) {
            return;
        }
        MaskAdReportHelper maskAdReportHelper = MaskAdReportHelper.INSTANCE;
        maskAdReportHelper.doValidExpo(this.mAd);
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.mAd.info;
        if (adInfo != null) {
            maskAdReportHelper.reportAdByUrl(GdtOriginalExposureReporter.replaceUrlMacros(adInfo.report_info.original_exposure_url.get(), adInfo.product_type.get(), this.mContext, adInfo.app_info.app_package_name.get()));
        }
        this.mProcessorProxy.c2sReportAsync(0, 0, this.mAd.info);
    }

    private final void show(ViewGroup parentView) {
        MaskAdvName maskAdvName = this.mSource;
        String str = "";
        if (maskAdvName != null) {
            String valueOf = String.valueOf(this.mAd.getAId());
            ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).reportEventToBeacon(maskAdvName, MaskAdConstants.MASK_AD_DISPLAY_REQUEST, null);
            MaskAdReportHelper maskAdReportHelper = MaskAdReportHelper.INSTANCE;
            maskAdReportHelper.reportWeatherHealthAction("new_folder_splashad_playrequest", "", valueOf, maskAdvName);
            if (!TextUtils.isEmpty(this.mResFilePath) && ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).fileExists(this.mResFilePath)) {
                ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).reportEventToBeacon(maskAdvName, MaskAdConstants.MASK_AD_DISPLAY_WITHSOURCE, null);
                maskAdReportHelper.reportWeatherHealthAction("new_folder_splashad_playwithsource", "", valueOf, maskAdvName);
                ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).reportEventToBeacon(maskAdvName, MaskAdConstants.MASK_AD_DISPLAY_SUCCESS, null);
                maskAdReportHelper.reportWeatherHealthAction("new_folder_splashad_expose", "", valueOf, maskAdvName);
            } else {
                QLog.e(TAG, 1, "cancel show mask ad");
                ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).reportEventToBeacon(maskAdvName, MaskAdConstants.MASK_AD_DISPLAY_CANCEL, null);
                return;
            }
        }
        reportAdExpose();
        initExposeChecker();
        this.mIsShowing = true;
        MaskAdRenderView maskAdRenderView = this.mRenderView;
        if (maskAdRenderView != null) {
            maskAdRenderView.show(parentView);
        }
        if (TextUtils.equals(this.mAd.getPosId(), "7085109922408095")) {
            a aVar = a.f308093a;
            String traceId = this.mAd.getTraceId();
            if (traceId != null) {
                str = traceId;
            }
            aVar.k(str);
            return;
        }
        if (TextUtils.equals(this.mAd.getPosId(), "6011195015998218")) {
            a.f308093a.m();
        } else if (TextUtils.equals(this.mAd.getPosId(), "1082214467882419")) {
            a.f308093a.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShow$lambda$3$lambda$2(long j3, MaskAdvName it, MaskAdRenderProxy this$0, ViewGroup parentView, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        if (System.currentTimeMillis() - j3 <= 1500) {
            ArrayList<JSONObject> maskAdInfoList = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(it);
            if (maskAdInfoList != null && !maskAdInfoList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.e(TAG, 1, "ad no cache, cancel updateCacheAidSet");
                return;
            }
            Iterator<JSONObject> it5 = maskAdInfoList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                JSONObject next = it5.next();
                if (this$0.mAd.getAId() == next.optLong("aid", 0L)) {
                    String optString = next.optString(AdHippyFragment.RES_PATH, "");
                    MaskAdRenderView maskAdRenderView = this$0.mRenderView;
                    if (maskAdRenderView != null) {
                        maskAdRenderView.updateResPath(optString);
                    }
                    this$0.mResFilePath = optString;
                }
            }
            MaskAdReportHelper.INSTANCE.reportWeatherHealthAction("new_folder_splashad_realtime_load_success", "", String.valueOf(this$0.mAd.getAId()), it);
            this$0.show(parentView);
        }
    }

    /* renamed from: getShowState, reason: from getter */
    public final boolean getMIsShowing() {
        return this.mIsShowing;
    }

    public final void onDestroy() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.setCallback(null);
        }
        AdExposureChecker adExposureChecker2 = this.mExposureChecker;
        if (adExposureChecker2 != null) {
            adExposureChecker2.onActivityDestroy();
        }
        this.mContext = null;
        this.mRenderView = null;
    }

    public final void onPause() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
    }

    public final void onResume() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
    }

    public final void setDisappearListener(@NotNull MaskAdDisappearListener disappearListener) {
        Intrinsics.checkNotNullParameter(disappearListener, "disappearListener");
        MaskAdRenderView maskAdRenderView = this.mRenderView;
        if (maskAdRenderView != null) {
            maskAdRenderView.setDisappearListener(disappearListener);
        }
    }

    public final void setIsTianShuAd(boolean isTianShu) {
        MaskAdRenderView maskAdRenderView = this.mRenderView;
        if (maskAdRenderView != null) {
            maskAdRenderView.setIsTianShuAd(isTianShu);
        }
    }

    public final void setNeedReportAdExpose(boolean needReport) {
        this.mNeedReportAdExpose = needReport;
    }

    public final void setUserActionReportInfo(@NotNull access.UserActionReportInfo userActionReportInfo) {
        Intrinsics.checkNotNullParameter(userActionReportInfo, "userActionReportInfo");
        this.mUserActionReportInfo = userActionReportInfo;
    }

    public final void startShow(@NotNull final ViewGroup parentView) {
        boolean z16;
        final MaskAdvName maskAdvName;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        if (this.mIsShowing) {
            return;
        }
        if (!TextUtils.isEmpty(this.mResFilePath) && (((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).fileExists(this.mResFilePath) || !MaskAdClickHelper.INSTANCE.isImageAd(this.mAd.getInnerShowType()))) {
            show(parentView);
            return;
        }
        MaskAdRenderView maskAdRenderView = this.mRenderView;
        if (maskAdRenderView != null && true == maskAdRenderView.getIsTianShuAd()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (maskAdvName = this.mSource) != null && maskAdvName != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            MaskAdDownloadCallBack maskAdDownloadCallBack = new MaskAdDownloadCallBack() { // from class: com.tencent.mobileqq.vas.adv.maskad.c
                @Override // com.tencent.mobileqq.vas.adv.maskad.MaskAdDownloadCallBack
                public final void realTimeDownloadDone(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
                    MaskAdRenderProxy.startShow$lambda$3$lambda$2(currentTimeMillis, maskAdvName, this, parentView, adInfo);
                }
            };
            qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo = new qq_ad_get.QQAdGetRsp.PosAdInfo();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.mAd.info);
            posAdInfo.ads_info.set(arrayListOf);
            posAdInfo.pos_id.set(this.mAd.getPosId());
            MaskAdReportHelper.INSTANCE.reportWeatherHealthAction("new_folder_splashad_realtime_load_time", "", String.valueOf(this.mAd.getAId()), maskAdvName);
            ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).downloadMaskAdRealTime(posAdInfo, maskAdDownloadCallBack);
        }
    }

    public final void updateShowState(boolean isShow) {
        this.mIsShowing = isShow;
    }
}
