package com.tencent.mobileqq.vas.adv.base.support.gdt;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ark.ark;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.app.c;
import com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvConstant;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import dz2.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;
import tl.h;
import tz2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010>\u001a\u00020;\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\f\u0010\u0012\u001a\u00020\u0011*\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016J)\u0010\u001a\u001a\u0004\u0018\u00010\f\"\u000e\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ2\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J8\u0010#\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010%\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010\fH\u0016J,\u0010,\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\f2\b\u0010)\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020*H\u0016J0\u00101\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\f2\u0006\u0010.\u001a\u00020-2\b\u0010)\u001a\u0004\u0018\u00010\n2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110/H\u0016J\u0014\u00103\u001a\u0004\u0018\u00010\f2\b\u00102\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u00104\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u00010\fH\u0016J!\u00106\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001052\b\u00102\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b6\u00107J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010:\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001092\b\u0010)\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtImpl;", "Ldz2/b;", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "params", "Lcom/tencent/gdtad/aditem/GdtHandler$Params;", "g", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "adInfo", "", "rewardText", ark.APP_SPECIFIC_BIZSRC, "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData;", "c", "", "j", "b", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "getDeviceInfo", "getDeviceInfoAsJson", "Lcom/tencent/mobileqq/pb/PBField;", "T", "pbField", "convertPbToJson", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "Lsz2/a;", "profitableCallback", "", h.F, "Ljava/lang/ref/WeakReference;", "Ltz2/a;", "profitableCallbackRef", "e", "exposureUrl", "i", "Landroid/content/Context;", "context", "jsonGdtAdInfo", "pbAdInfo", "", "position", "doOriginalExposure", "Landroid/view/View;", "adView", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "resultCallback", "doExposure", "gdtTangramAdJson", "getMarketPendantImgUrl", "getGdtCountdownTime", "", "getGdtDanmakuStrContents", "(Ljava/lang/String;)[Ljava/lang/String;", "toLandingPage", "", "getIndustryLabels", "Lcom/tencent/mobileqq/vas/adv/base/support/app/c;", "a", "Lcom/tencent/mobileqq/vas/adv/base/support/app/c;", "appInterface", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "exposureCallback", "<init>", "(Lcom/tencent/mobileqq/vas/adv/base/support/app/c;)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdvGdtImpl implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c appInterface;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker.ExposureCallback exposureCallback;

    public VasAdvGdtImpl(@NotNull c appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        this.appInterface = appInterface;
    }

    private final GdtMotiveVideoPageData c(qq_ad_get.QQAdGetRsp.AdInfo adInfo, String rewardText, String bizSrc) {
        String obj;
        String str;
        boolean startsWith$default;
        GdtAd gdtAd = new GdtAd(adInfo);
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.appInterface.f(), gdtAd);
        GdtMotiveVideoPageData gdtMotiveVideoPageData = new GdtMotiveVideoPageData();
        gdtMotiveVideoPageData.productType = gdtAd.getProductType();
        gdtMotiveVideoPageData.vSize = gdtAd.getCreativeSize();
        gdtMotiveVideoPageData.screenOrientation = 1;
        gdtMotiveVideoPageData.adId = gdtAd.getAdvertiserId();
        gdtMotiveVideoPageData.vid = gdtAd.getTencent_video_id();
        String videoUrl = gdtAd.getVideoUrl();
        gdtMotiveVideoPageData.url = videoUrl;
        String str2 = null;
        if (!TextUtils.isEmpty(videoUrl)) {
            String url = gdtMotiveVideoPageData.url;
            boolean z16 = false;
            if (url != null) {
                Intrinsics.checkNotNullExpressionValue(url, "url");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                if (startsWith$default) {
                    z16 = true;
                }
            }
            if (z16) {
                String url2 = gdtMotiveVideoPageData.url;
                if (url2 != null) {
                    Intrinsics.checkNotNullExpressionValue(url2, "url");
                    str = new Regex("https://").replaceFirst(url2, "http://");
                } else {
                    str = null;
                }
                gdtMotiveVideoPageData.url = str;
            }
        }
        String str3 = "";
        if (gdtAd.getImageData() == null) {
            str2 = "";
        } else {
            GdtImageData imageData = gdtAd.getImageData();
            if (imageData != null) {
                str2 = imageData.url;
            }
        }
        gdtMotiveVideoPageData.previewImgUrl = str2;
        gdtMotiveVideoPageData.bannerImgName = gdtAd.getAdvertiser_corporate_image_name();
        gdtMotiveVideoPageData.bannerBaseInfoText = gdtAd.getText();
        gdtMotiveVideoPageData.bannerLogo = gdtAd.getAdvertiser_corporate_logo();
        gdtMotiveVideoPageData.exposureUrl = gdtAd.getUrlForImpression();
        gdtMotiveVideoPageData.appScore = gdtAd.getAppScore();
        gdtMotiveVideoPageData.downloadNum = gdtAd.getAppDownloadNum();
        gdtMotiveVideoPageData.style = gdtAd.getStyle();
        gdtMotiveVideoPageData.endcardUrl = gdtAd.getEndcardUrl();
        gdtMotiveVideoPageData.endcardLoadTime = gdtAd.getEndcardLoadTime();
        gdtMotiveVideoPageData.bottomCardUrl = gdtAd.getBottomCardUrl();
        gdtMotiveVideoPageData.bottomCardLoadTime = gdtAd.getBottomCardLoadTime();
        Object pbToJson = GdtJsonPbUtil.pbToJson(gdtAd.info);
        if (pbToJson != null && (obj = pbToJson.toString()) != null) {
            str3 = obj;
        }
        gdtMotiveVideoPageData.adsContent = str3;
        gdtMotiveVideoPageData.processId = MobileQQ.sProcessId;
        gdtMotiveVideoPageData.refId = bizSrc;
        if (rewardText != null) {
            gdtMotiveVideoPageData.setRewardText(rewardText);
        }
        gdtMotiveVideoPageData.rewardType = gdtAd.getRewardType();
        gdtMotiveVideoPageData.renderType = gdtAd.getRenderType();
        gdtMotiveVideoPageData.playType = gdtAd.getRewardPlayType();
        gdtMotiveVideoPageData.passThroughData = gdtAd.getRewardPassThroughData();
        gdtMotiveVideoPageData.hippyParams = GdtUtil.buildHippyParams(gdtAd);
        gdtMotiveVideoPageData.supportOpenMotiveAd = true;
        return gdtMotiveVideoPageData;
    }

    private final AdExposureChecker.ExposureCallback d() {
        return new AdExposureChecker.ExposureCallback() { // from class: dz2.a
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                VasAdvGdtImpl.f(VasAdvGdtImpl.this, weakReference);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(VasAdvGdtImpl this$0, WeakReference weakReference) {
        dz2.c cVar;
        VasResultCallback<Boolean> vasResultCallback;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (weakReference instanceof dz2.c) {
            cVar = (dz2.c) weakReference;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            this$0.i(cVar.getExposureUrl());
            WeakReference<VasResultCallback<Boolean>> a16 = cVar.a();
            if (a16 != null && (vasResultCallback = a16.get()) != null) {
                vasResultCallback.onResult(Boolean.TRUE);
            }
            cVar.d(null);
            WeakReference<VasResultCallback<Boolean>> a17 = cVar.a();
            if (a17 != null) {
                a17.clear();
            }
        }
    }

    private final GdtHandler.Params g(Activity activity, LandingPageParams params) {
        GdtHandler.Params params2 = new GdtHandler.Params();
        params2.f108486ad = params.getGdtAd();
        params2.reportForClick = true;
        params2.activity = new WeakReference<>(activity);
        params2.sceneID = params.getSceneId();
        params2.componentID = params.getComponentId();
        params2.appAutoDownload = params.getAutoDownloadApp();
        params2.processId = 1;
        params2.videoCeilingSupportedIfNotInstalled = false;
        params2.videoCeilingSupportedIfInstalled = false;
        params2.directPlay = true;
        Bundle bundle = new Bundle();
        bundle.putString(LaunchParam.KEY_REF_ID, params.getSrcId());
        params2.extra = bundle;
        return params2;
    }

    private final boolean j(GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        if (GdtUtil.parseDataType(gdtMotiveVideoPageData) == 1) {
            return true;
        }
        return false;
    }

    @Override // dz2.b
    @NotNull
    public String b() {
        return VasAdvConstant.VAS_GDT_BIZ_ID;
    }

    @Override // dz2.b
    @Nullable
    public <T extends PBField<T>> String convertPbToJson(@NotNull T pbField) {
        Intrinsics.checkNotNullParameter(pbField, "pbField");
        Object pbToJson = GdtJsonPbUtil.pbToJson(pbField);
        if (pbToJson != null) {
            return pbToJson.toString();
        }
        return null;
    }

    @Override // dz2.b
    public void doExposure(@NotNull String exposureUrl, @NotNull View adView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, @NotNull VasResultCallback<Boolean> resultCallback) {
        Intrinsics.checkNotNullParameter(exposureUrl, "exposureUrl");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        if (this.exposureCallback == null) {
            this.exposureCallback = d();
        }
        WeakReference<VasResultCallback<Boolean>> weakReference = new WeakReference<>(resultCallback);
        dz2.c cVar = new dz2.c(adView);
        cVar.c(weakReference);
        cVar.d(exposureUrl);
        AdExposureChecker adExposureChecker = new AdExposureChecker(new GdtAd(pbAdInfo), cVar);
        adExposureChecker.setCallback(new WeakReference<>(this.exposureCallback));
        adExposureChecker.startCheck();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00cb A[Catch: all -> 0x00fb, TryCatch #1 {all -> 0x00fb, blocks: (B:3:0x000f, B:7:0x0043, B:9:0x0047, B:13:0x007f, B:15:0x00cb, B:16:0x00ea, B:28:0x0054, B:30:0x005c, B:32:0x0060, B:34:0x0064, B:35:0x0068), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f0  */
    @Override // dz2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doOriginalExposure(@NotNull Context context, @Nullable String jsonGdtAdInfo, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, int position) {
        Integer num;
        String str;
        PBStringField pBStringField;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String sb5;
        PBUInt32Field pBUInt32Field;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String rawUrl = new JSONObject(jsonGdtAdInfo).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0).optJSONObject(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO).optString("original_exposure_url");
            if (!TextUtils.isEmpty(rawUrl)) {
                String str2 = null;
                if (pbAdInfo != null && (pBUInt32Field = pbAdInfo.product_type) != null) {
                    num = Integer.valueOf(pBUInt32Field.get());
                } else {
                    num = null;
                }
                if (num != null && num.intValue() == 12) {
                    qq_ad_get.QQAdGetRsp.AdInfo.AppInfo appInfo = pbAdInfo.app_info;
                    if (appInfo != null && (pBStringField = appInfo.app_package_name) != null) {
                        str2 = pBStringField.get();
                    }
                    if (VasAdvSupport.INSTANCE.a().isAppInstalled(context, str2)) {
                        str = "2";
                    } else {
                        str = "1";
                    }
                    String str3 = str;
                    StringBuilder sb6 = new StringBuilder();
                    Intrinsics.checkNotNullExpressionValue(rawUrl, "rawUrl");
                    replace$default = StringsKt__StringsJVMKt.replace$default(rawUrl, "__ACTION_TYPE__", str3, false, 4, (Object) null);
                    replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "__VIEW_PERCENT__", "1", false, 4, (Object) null);
                    replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "__VIEW_TIME__", "0", false, 4, (Object) null);
                    sb6.append(replace$default3);
                    sb6.append("&slot=");
                    sb6.append(position);
                    sb5 = sb6.toString();
                    if (QLog.isColorLevel()) {
                        QLog.d("VasAdvGdtImpl", 2, "original exposure raw url: " + rawUrl + ", final exposure url: " + sb5);
                    }
                    if (!TextUtils.isEmpty(sb5)) {
                        try {
                            i(sb5);
                            return true;
                        } catch (Throwable th5) {
                            th = th5;
                            QLog.e("VasAdvGdtImpl", 1, "getOriginalExposureUrl fail ", th);
                            return false;
                        }
                    }
                }
                str = "0";
                String str32 = str;
                StringBuilder sb62 = new StringBuilder();
                Intrinsics.checkNotNullExpressionValue(rawUrl, "rawUrl");
                replace$default = StringsKt__StringsJVMKt.replace$default(rawUrl, "__ACTION_TYPE__", str32, false, 4, (Object) null);
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "__VIEW_PERCENT__", "1", false, 4, (Object) null);
                replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "__VIEW_TIME__", "0", false, 4, (Object) null);
                sb62.append(replace$default3);
                sb62.append("&slot=");
                sb62.append(position);
                sb5 = sb62.toString();
                if (QLog.isColorLevel()) {
                }
                if (!TextUtils.isEmpty(sb5)) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        return false;
    }

    @Override // dz2.b
    public void e(@NotNull final Activity activity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull final WeakReference<a> profitableCallbackRef, @Nullable String rewardText, @NotNull String bizSrc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(profitableCallbackRef, "profitableCallbackRef");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        GdtMotiveVideoPageData c16 = c(adInfo, rewardText, bizSrc);
        if (j(c16)) {
            c16.motiveBrowsingKey = "cooperation.vip.impl.vas_browsing_ad_action#";
            activity.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl$showMotiveAd$browsingAdReceiver$2
                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    String str;
                    activity.unregisterReceiver(this);
                    if (intent != null) {
                        str = intent.getAction();
                    } else {
                        str = null;
                    }
                    if (str != null && str.hashCode() == 403339419 && str.equals("cooperation.vip.impl.vas_browsing_ad_action")) {
                        boolean booleanExtra = intent.getBooleanExtra("profitable_flag", false);
                        int intExtra = intent.getIntExtra("elapsed_time", 0);
                        int intExtra2 = intent.getIntExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, 0);
                        a aVar = profitableCallbackRef.get();
                        if (aVar != null) {
                            aVar.a(booleanExtra, intExtra, intExtra2);
                            return;
                        }
                        return;
                    }
                    a aVar2 = profitableCallbackRef.get();
                    if (aVar2 != null) {
                        aVar2.a(false, 0, 0);
                    }
                }
            }, new IntentFilter("cooperation.vip.impl.vas_browsing_ad_action"));
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.build(activity, c16));
        } else {
            final Handler handler = new Handler(Looper.getMainLooper());
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.build(activity, c16, new ResultReceiver(handler) { // from class: com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl$showMotiveAd$motiveAdReceiver$2
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                    if (resultData == null) {
                        a aVar = profitableCallbackRef.get();
                        if (aVar != null) {
                            aVar.a(false, 0, 0);
                            return;
                        }
                        return;
                    }
                    if (resultCode == -1) {
                        boolean z16 = resultData.getBoolean("profitable_flag", false);
                        int i3 = resultData.getInt("elapsed_time", 0);
                        int i16 = resultData.getInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, 0);
                        a aVar2 = profitableCallbackRef.get();
                        if (aVar2 != null) {
                            aVar2.a(z16, i3, i16);
                            return;
                        }
                        return;
                    }
                    a aVar3 = profitableCallbackRef.get();
                    if (aVar3 != null) {
                        aVar3.a(false, 0, 0);
                    }
                }
            }));
        }
    }

    @Override // dz2.b
    @Nullable
    public qq_ad_get.QQAdGet.DeviceInfo getDeviceInfo() {
        try {
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(this.appInterface.f(), new GdtDeviceInfoHelper.Params());
            if (create != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("VasAdvGdtImpl", 2, "gdt device info init success");
                }
                return create.deviceInfo;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("VasAdvGdtImpl", 1, "Error when get gdt device info", e16);
            return null;
        }
    }

    @Override // dz2.b
    @Nullable
    public String getDeviceInfoAsJson() {
        Object pbToJson;
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = getDeviceInfo();
        if (deviceInfo == null || (pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo)) == null) {
            return null;
        }
        return pbToJson.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        r8 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r8);
     */
    @Override // dz2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getGdtCountdownTime(@Nullable String gdtTangramAdJson) {
        Integer intOrNull;
        if (gdtTangramAdJson == null) {
            return 0;
        }
        try {
            String optString = new JSONObject(gdtTangramAdJson).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optString("ext_json");
            if (optString == null || (r8 = new JSONObject(optString).optString("countdown_end_time")) == null || intOrNull == null) {
                return 0;
            }
            return (int) (intOrNull.intValue() - (System.currentTimeMillis() / 1000));
        } catch (Throwable th5) {
            QLog.e("VasAdvGdtImpl", 1, "fail to get count down time", th5);
            return 0;
        }
    }

    @Override // dz2.b
    @Nullable
    public String[] getGdtDanmakuStrContents(@Nullable String gdtTangramAdJson) {
        JSONArray optJSONArray;
        if (gdtTangramAdJson == null) {
            return null;
        }
        try {
            String optString = new JSONObject(gdtTangramAdJson).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optString("ext_json");
            if (optString == null || (optJSONArray = new JSONObject(optString).optJSONArray("bullet_screen")) == null) {
                return null;
            }
            int length = optJSONArray.length();
            String[] strArr = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                strArr[i3] = optJSONArray.get(i3).toString();
            }
            return strArr;
        } catch (Throwable th5) {
            QLog.e("VasAdvGdtImpl", 1, "fail to get count down time", th5);
            return null;
        }
    }

    @Override // dz2.b
    @Nullable
    public List<String> getIndustryLabels(@Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo) {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent creativeElementStructureContent;
        PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> pBRepeatMessageField;
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> list;
        int collectionSizeOrDefault;
        if (pbAdInfo != null && (displayInfo = pbAdInfo.display_info) != null && (basicInfo = displayInfo.basic_info) != null && (creativeElementStructureContent = basicInfo.element_structure_content) != null && (pBRepeatMessageField = creativeElementStructureContent.label) != null && (list = pBRepeatMessageField.get()) != null) {
            List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label) it.next()).get().content.get());
            }
            return arrayList;
        }
        return null;
    }

    @Override // dz2.b
    @Nullable
    public String getMarketPendantImgUrl(@Nullable String gdtTangramAdJson) {
        if (gdtTangramAdJson == null) {
            return null;
        }
        try {
            return new JSONObject(gdtTangramAdJson).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optJSONObject("display_info").optJSONObject("basic_info").optString("marketing_pendant");
        } catch (JSONException e16) {
            QLog.e("VasAdvGdtImpl", 1, "fail to get market pendant img url", e16);
            return null;
        }
    }

    @Override // dz2.b
    public void h(@NotNull final Activity activity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull final sz2.a profitableCallback, @Nullable String rewardText, @NotNull String bizSrc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(profitableCallback, "profitableCallback");
        Intrinsics.checkNotNullParameter(bizSrc, "bizSrc");
        GdtMotiveVideoPageData c16 = c(adInfo, rewardText, bizSrc);
        if (j(c16)) {
            c16.motiveBrowsingKey = "cooperation.vip.impl.vas_browsing_ad_action#";
            activity.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl$showMotiveAd$browsingAdReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    String str;
                    activity.unregisterReceiver(this);
                    if (intent != null) {
                        str = intent.getAction();
                    } else {
                        str = null;
                    }
                    boolean z16 = false;
                    if (str != null && str.hashCode() == 403339419 && str.equals("cooperation.vip.impl.vas_browsing_ad_action")) {
                        z16 = intent.getBooleanExtra("profitable_flag", false);
                    }
                    profitableCallback.onResult(z16);
                }
            }, new IntentFilter("cooperation.vip.impl.vas_browsing_ad_action"));
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.build(activity, c16));
        } else {
            final Handler handler = new Handler(Looper.getMainLooper());
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.build(activity, c16, new ResultReceiver(handler) { // from class: com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl$showMotiveAd$motiveAdReceiver$1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                    boolean z16 = false;
                    if (resultCode == -1 && resultData != null) {
                        z16 = resultData.getBoolean("profitable_flag");
                    }
                    profitableCallback.onResult(z16);
                }
            }));
        }
    }

    public void i(@Nullable String exposureUrl) {
        if (!TextUtils.isEmpty(exposureUrl)) {
            GdtReporter.doCgiReport(exposureUrl);
        } else if (QLog.isColorLevel()) {
            QLog.d("VasAdvGdtImpl", 2, "originalExposureReport is empty");
        }
    }

    @Override // dz2.b
    public void toLandingPage(@NotNull Activity activity, @NotNull LandingPageParams params) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            GdtHandler.Params g16 = g(activity, params);
            if (params.getShouldShowVideoCeiling()) {
                g16.videoCeilingSupportedIfNotInstalled = true;
            }
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(g16);
        } catch (Throwable th5) {
            QLog.e("VasAdvGdtImpl", 1, "fail to jump to landing page", th5);
        }
    }
}
