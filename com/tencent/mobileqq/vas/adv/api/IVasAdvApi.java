package com.tencent.mobileqq.vas.adv.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.common.pb.SplashAd;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdCheckCallBack;
import com.tencent.mobileqq.vas.adv.recommendad.f;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.vivo.push.PushClientConstants;
import ez2.c;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.adSchedule$QueryAllRsp;
import tencent.gdt.adSchedule$ReportReq;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\t\u001a\u00020\bH&J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0004H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H&J)\u0010\u0012\u001a\u0004\u0018\u00010\u0004\"\u000e\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\nH&J0\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cH&J\u0014\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010!\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H&J!\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H&J\u001a\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0018\u00100\u001a\u00020\b2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H&J\u0018\u00103\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00152\u0006\u0010/\u001a\u000202H&J\u001e\u00107\u001a\u00020\b2\u0006\u00104\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020605H&J\u0010\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208H&J\u0010\u0010;\u001a\u00020\b2\u0006\u00109\u001a\u000208H&J\u0016\u0010=\u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020<0\u001cH&J\u0010\u0010@\u001a\u00020\b2\u0006\u0010?\u001a\u00020>H&J\u0012\u0010A\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010%H&J,\u0010E\u001a\u00020\b2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*2\b\b\u0002\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0004H&J\u0018\u0010H\u001a\u00020\b2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\nH&J\b\u0010I\u001a\u00020\u0006H&J\b\u0010J\u001a\u00020\u0006H&J\u0018\u0010M\u001a\u00020\b2\u0006\u0010K\u001a\u00020\n2\u0006\u0010/\u001a\u00020LH&\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/api/IVasAdvApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", PushClientConstants.TAG_PKG_NAME, "", "isAppInstalled", "", "initTbsEnvironment", "", "from", "preTab", "requestPublicAccountAd", "getDeviceInfoAsJson", "Lcom/tencent/mobileqq/pb/PBField;", "T", "pbField", "convertPbToJson", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "jsonGdtAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "pbAdInfo", "position", "doOriginalExposure", "exposureUrl", "Landroid/view/View;", "adView", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "resultCallback", "doExposure", "gdtTangramAdJson", "getMarketPendantImgUrl", "getGdtCountdownTime", "", "getGdtDanmakuStrContents", "(Ljava/lang/String;)[Ljava/lang/String;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "params", "toLandingPage", "", "getIndustryLabels", "Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "vasNewAdParams", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "callback", "requestAd", "adInfo", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdCheckCallBack;", "shopMaskRealTimeCheck", "req", "Lez2/c;", "Lcom/tencent/mobileqq/vas/adv/common/pb/SplashAd$SplashAdGetRsp;", "reqSplashAd", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "registerExternalRenderView", "registerExternalModule", "Ltencent/gdt/adSchedule$QueryAllRsp;", "reqScheduleAd", "Ltencent/gdt/adSchedule$ReportReq;", Const.BUNDLE_KEY_REQUEST, "reportAdDownloadEvent", "startVasRewardAdDebugFragment", "posIds", "enableShowMask", GetAdInfoRequest.SOURCE_FROM, "startAsyncCardAdRequest", "preTabIndex", "tabIndex", "onMainTabChange", "isReqSceneTypeTABSwitchOn", "isReqSceneTypePageSwitchOn", "adSecondCategory", "Lcom/tencent/mobileqq/vas/adv/recommendad/f$a;", "requestRecommendAd", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAdvApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class a {
        public static /* synthetic */ void a(IVasAdvApi iVasAdvApi, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    str = "";
                }
                iVasAdvApi.requestPublicAccountAd(i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestPublicAccountAd");
        }

        public static /* synthetic */ void b(IVasAdvApi iVasAdvApi, List list, boolean z16, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    str = "";
                }
                iVasAdvApi.startAsyncCardAdRequest(list, z16, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAsyncCardAdRequest");
        }
    }

    @Nullable
    <T extends PBField<T>> String convertPbToJson(@NotNull T pbField);

    void doExposure(@NotNull String exposureUrl, @NotNull View adView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, @NotNull VasResultCallback<Boolean> resultCallback);

    boolean doOriginalExposure(@NotNull Context context, @Nullable String jsonGdtAdInfo, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, int position);

    @Nullable
    String getDeviceInfoAsJson();

    int getGdtCountdownTime(@Nullable String gdtTangramAdJson);

    @Nullable
    String[] getGdtDanmakuStrContents(@Nullable String gdtTangramAdJson);

    @Nullable
    List<String> getIndustryLabels(@Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo);

    @Nullable
    String getMarketPendantImgUrl(@Nullable String gdtTangramAdJson);

    void initTbsEnvironment();

    boolean isAppInstalled(@NotNull Context context, @Nullable String pkgName);

    boolean isReqSceneTypePageSwitchOn();

    boolean isReqSceneTypeTABSwitchOn();

    void onMainTabChange(int preTabIndex, int tabIndex);

    void registerExternalModule(@NotNull b renderExport);

    void registerExternalRenderView(@NotNull b renderExport);

    void reportAdDownloadEvent(@NotNull adSchedule$ReportReq request);

    void reqScheduleAd(@NotNull VasResultCallback<adSchedule$QueryAllRsp> callback);

    void reqSplashAd(@NotNull String req, @NotNull c<SplashAd.SplashAdGetRsp> callback);

    void requestAd(@NotNull VasNewAdParams vasNewAdParams, @NotNull VasAdCallback callback);

    void requestPublicAccountAd(int from, @NotNull String preTab);

    void requestRecommendAd(int adSecondCategory, @NotNull f.a callback);

    void shopMaskRealTimeCheck(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull MaskAdCheckCallBack callback);

    void startAsyncCardAdRequest(@Nullable List<String> posIds, boolean enableShowMask, @NotNull String sourceFrom);

    void startVasRewardAdDebugFragment(@Nullable Activity activity);

    void toLandingPage(@NotNull Activity activity, @NotNull LandingPageParams params);
}
