package com.tencent.mobileqq.vas.adv.api.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qqshop.api.IQQShopApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.base.service.e;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.app.c;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.common.pb.AdvPush;
import com.tencent.mobileqq.vas.adv.common.pb.SplashAd;
import com.tencent.mobileqq.vas.adv.debug.VasAdDebugFragment;
import com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdManager;
import com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdView;
import com.tencent.mobileqq.vas.adv.kuikly.common.QQKuiklyAdModule;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdCheckCallBack;
import com.tencent.mobileqq.vas.adv.recommendad.f;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.QUA;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.adSchedule$QueryAllRsp;
import tencent.gdt.adSchedule$ReportReq;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 T2\u00020\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J)\u0010\u0012\u001a\u0004\u0018\u00010\u0004\"\u000e\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0016J0\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cH\u0016J\u0014\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010!\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J!\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016J\u001a\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u00100\u001a\u00020\b2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0016J\u0018\u00103\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00152\u0006\u0010/\u001a\u000202H\u0016J\u001e\u00107\u001a\u00020\b2\u0006\u00104\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020605H\u0016J\u0010\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208H\u0016J\u0010\u0010;\u001a\u00020\b2\u0006\u00109\u001a\u000208H\u0016J\u0016\u0010=\u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020<0\u001cH\u0016J\u0010\u0010@\u001a\u00020\b2\u0006\u0010?\u001a\u00020>H\u0016J\u0012\u0010A\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J(\u0010E\u001a\u00020\b2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0004H\u0016J\u0018\u0010H\u001a\u00020\b2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\nH\u0016J\b\u0010I\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020\u0006H\u0016J\u0018\u0010M\u001a\u00020\b2\u0006\u0010K\u001a\u00020\n2\u0006\u0010/\u001a\u00020LH\u0016R \u0010P\u001a\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020O0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/api/impl/VasAdvApiImpl;", "Lcom/tencent/mobileqq/vas/adv/api/IVasAdvApi;", "Landroid/content/Context;", "context", "", PushClientConstants.TAG_PKG_NAME, "", "isAppInstalled", "", "initTbsEnvironment", "", "from", "preTab", "requestPublicAccountAd", "getDeviceInfoAsJson", "Lcom/tencent/mobileqq/pb/PBField;", "T", "pbField", "convertPbToJson", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "jsonGdtAdInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "pbAdInfo", "position", "doOriginalExposure", "exposureUrl", "Landroid/view/View;", "adView", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "resultCallback", "doExposure", "gdtTangramAdJson", "getMarketPendantImgUrl", "getGdtCountdownTime", "", "getGdtDanmakuStrContents", "(Ljava/lang/String;)[Ljava/lang/String;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "params", "toLandingPage", "", "getIndustryLabels", "Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "vasNewAdParams", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "callback", "requestAd", "adInfo", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdCheckCallBack;", "shopMaskRealTimeCheck", "req", "Lez2/c;", "Lcom/tencent/mobileqq/vas/adv/common/pb/SplashAd$SplashAdGetRsp;", "reqSplashAd", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "registerExternalRenderView", "registerExternalModule", "Ltencent/gdt/adSchedule$QueryAllRsp;", "reqScheduleAd", "Ltencent/gdt/adSchedule$ReportReq;", Const.BUNDLE_KEY_REQUEST, "reportAdDownloadEvent", "startVasRewardAdDebugFragment", "posIds", "enableShowMask", GetAdInfoRequest.SOURCE_FROM, "startAsyncCardAdRequest", "preTabIndex", "tabIndex", "onMainTabChange", "isReqSceneTypeTABSwitchOn", "isReqSceneTypePageSwitchOn", "adSecondCategory", "Lcom/tencent/mobileqq/vas/adv/recommendad/f$a;", "requestRecommendAd", "Ljava/util/concurrent/ConcurrentHashMap;", "", "uin2nextRequestAdTime", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "Companion", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdvApiImpl implements IVasAdvApi {
    private static final long REQUEST_INTERVAL = 600000;

    @NotNull
    private static final String SHOP_MASK_CACHE_KEY = "specified_ads";

    @NotNull
    private static final String TAG = "VasAdvApiImpl";
    private static boolean isForegroundRegistered;

    @NotNull
    private final ConcurrentHashMap<Long, Long> uin2nextRequestAdTime = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/adv/api/impl/VasAdvApiImpl$b", "Lbz2/b;", "Lcom/tencent/mobileqq/vas/adv/common/pb/SplashAd$SplashAdGetRsp;", "", "returnCode", "rsp", "", "c", "code", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements bz2.b<SplashAd.SplashAdGetRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ez2.c<SplashAd.SplashAdGetRsp> f307947a;

        b(ez2.c<SplashAd.SplashAdGetRsp> cVar) {
            this.f307947a = cVar;
        }

        @Override // bz2.b
        public void a(int code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f307947a.a(code, null);
            QLog.e(VasAdvApiImpl.TAG, 1, "reqSplashAd  failed:" + code + TokenParser.SP + errMsg, e16);
        }

        @Override // bz2.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(int returnCode, @NotNull SplashAd.SplashAdGetRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            this.f307947a.a(returnCode, rsp);
            QLog.d(VasAdvApiImpl.TAG, 2, "reqSplashAd  rsp :" + rsp.ad_rsp.get());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/adv/api/impl/VasAdvApiImpl$c", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/AdvPush$AdvPushRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements bz2.a<AdvPush.AdvPushRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f307949b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f307950c;

        c(long j3, long j16) {
            this.f307949b = j3;
            this.f307950c = j16;
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            VasAdvApiImpl.this.uin2nextRequestAdTime.put(Long.valueOf(this.f307949b), Long.valueOf(this.f307950c + 600000));
            QLog.e(VasAdvApiImpl.TAG, 1, "error when request public account ad:" + errMsg, e16);
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull AdvPush.AdvPushRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            long j3 = rsp.next_req_gap.get();
            if (j3 <= 0) {
                j3 = 600000;
            }
            VasAdvApiImpl.this.uin2nextRequestAdTime.put(Long.valueOf(this.f307949b), Long.valueOf(this.f307950c + j3));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/adv/api/impl/VasAdvApiImpl$d", "Lcom/tencent/mobileqq/vas/adv/api/impl/a;", "", "onApplicationForeground", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d extends a {
        d() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IVasAdvApi.a.a(VasAdvApiImpl.this, 2, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPublicAccountAd$lambda$3(int i3, String preTab, boolean z16, long j3, VasAdvApiImpl this$0, long j16) {
        Intrinsics.checkNotNullParameter(preTab, "$preTab");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdvPush.AdvPushReq advPushReq = new AdvPush.AdvPushReq();
        AdvPush.UserInfo userInfo = advPushReq.user_info;
        AdvPush.UserInfo userInfo2 = new AdvPush.UserInfo();
        userInfo2.uin.set(j3);
        userInfo2.app.set("app");
        userInfo2.f308015os.set("and");
        userInfo2.version.set(AppSetting.f99551k);
        userInfo2.qua.set(QUA.getQUA3());
        userInfo2.client_mod.set(GdtDeviceInfoHelper.getClientMode());
        userInfo.set(userInfo2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device_info", VasAdvSupport.INSTANCE.a().getDeviceInfoAsJson());
        jSONObject.put(SHOP_MASK_CACHE_KEY, com.tencent.mobileqq.vas.adv.preload.a.f308150a.p());
        advPushReq.gdt_args.set(jSONObject.toString());
        advPushReq.req_scene_type.set(i3);
        advPushReq.source_from.set(preTab);
        if (z16) {
            boolean isSubscribedHealthPA = ((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isSubscribedHealthPA();
            QLog.d(TAG, 1, "requestPublicAccountAd isSubscribedHealthPA:" + isSubscribedHealthPA);
            AdvPush.BusiTypeArgs busiTypeArgs = new AdvPush.BusiTypeArgs();
            busiTypeArgs.busi_type.set(5);
            busiTypeArgs.is_subscribed.set(isSubscribedHealthPA);
            advPushReq.busi_type_args_list.add(busiTypeArgs);
            boolean isSubscribedQQShopPA = ((IQQShopApi) QRoute.api(IQQShopApi.class)).isSubscribedQQShopPA();
            QLog.d(TAG, 1, "requestPublicAccountAd isSubscribedQQShopPA:" + isSubscribedQQShopPA);
            AdvPush.BusiTypeArgs busiTypeArgs2 = new AdvPush.BusiTypeArgs();
            busiTypeArgs2.busi_type.set(3);
            busiTypeArgs2.is_subscribed.set(isSubscribedQQShopPA);
            advPushReq.busi_type_args_list.add(busiTypeArgs2);
        }
        e.f307985a.x(advPushReq, new c(j3, j16));
        if (i3 == 1 || i3 == 3) {
            ((IEcshopAdApi) QRoute.api(IEcshopAdApi.class)).updateShopAdAbTest();
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    @Nullable
    public <T extends PBField<T>> String convertPbToJson(@NotNull T pbField) {
        Intrinsics.checkNotNullParameter(pbField, "pbField");
        return VasAdvSupport.INSTANCE.a().convertPbToJson(pbField);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void doExposure(@NotNull String exposureUrl, @NotNull View adView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, @NotNull VasResultCallback<Boolean> resultCallback) {
        Intrinsics.checkNotNullParameter(exposureUrl, "exposureUrl");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        VasAdvSupport.INSTANCE.a().doExposure(exposureUrl, adView, pbAdInfo, resultCallback);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public boolean doOriginalExposure(@NotNull Context context, @Nullable String jsonGdtAdInfo, @Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo, int position) {
        Intrinsics.checkNotNullParameter(context, "context");
        return VasAdvSupport.INSTANCE.a().doOriginalExposure(context, jsonGdtAdInfo, pbAdInfo, position);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    @Nullable
    public String getDeviceInfoAsJson() {
        return VasAdvSupport.INSTANCE.a().getDeviceInfoAsJson();
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public int getGdtCountdownTime(@Nullable String gdtTangramAdJson) {
        return VasAdvSupport.INSTANCE.a().getGdtCountdownTime(gdtTangramAdJson);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    @Nullable
    public String[] getGdtDanmakuStrContents(@Nullable String gdtTangramAdJson) {
        return VasAdvSupport.INSTANCE.a().getGdtDanmakuStrContents(gdtTangramAdJson);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    @Nullable
    public List<String> getIndustryLabels(@Nullable qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo) {
        return VasAdvSupport.INSTANCE.a().getIndustryLabels(pbAdInfo);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    @Nullable
    public String getMarketPendantImgUrl(@Nullable String gdtTangramAdJson) {
        return VasAdvSupport.INSTANCE.a().getMarketPendantImgUrl(gdtTangramAdJson);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void initTbsEnvironment() {
        VasAdvSupport.INSTANCE.a().initTbsEnvironment();
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public boolean isAppInstalled(@NotNull Context context, @Nullable String pkgName) {
        Intrinsics.checkNotNullParameter(context, "context");
        return VasAdvSupport.INSTANCE.a().isAppInstalled(context, pkgName);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public boolean isReqSceneTypePageSwitchOn() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103112", false);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public boolean isReqSceneTypeTABSwitchOn() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103100", false);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void onMainTabChange(int preTabIndex, int tabIndex) {
        if (tabIndex == com.tencent.mobileqq.activity.home.impl.a.f183038a && isReqSceneTypeTABSwitchOn()) {
            String preTab = com.tencent.mobileqq.activity.home.impl.b.i(preTabIndex);
            Intrinsics.checkNotNullExpressionValue(preTab, "preTab");
            requestPublicAccountAd(4, preTab);
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        renderExport.a("QQKuiklyRewardVideoModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.vas.adv.api.impl.VasAdvApiImpl$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new hz2.a();
            }
        });
        renderExport.a("QQKuiklyAdDataModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.vas.adv.api.impl.VasAdvApiImpl$registerExternalModule$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.vas.adv.kuikly.cardad.b();
            }
        });
        renderExport.a("QQKuiklyAdModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.vas.adv.api.impl.VasAdvApiImpl$registerExternalModule$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new QQKuiklyAdModule();
            }
        });
        renderExport.a("QQKuiklyAdWieldSensorModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.vas.adv.api.impl.VasAdvApiImpl$registerExternalModule$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.vas.adv.kuikly.common.b();
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void registerExternalRenderView(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        b.a.a(renderExport, "QQWeatherCommonAdView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.adv.api.impl.VasAdvApiImpl$registerExternalRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasKuiklyCardAdView(it);
            }
        }, null, 4, null);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void reportAdDownloadEvent(@NotNull adSchedule$ReportReq request) {
        Intrinsics.checkNotNullParameter(request, "request");
        e.f307985a.s(request);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void reqScheduleAd(@NotNull VasResultCallback<adSchedule$QueryAllRsp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        e.f307985a.t(callback);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void reqSplashAd(@NotNull String req, @NotNull ez2.c<SplashAd.SplashAdGetRsp> callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        e.f307985a.y(req, new b(callback));
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void requestAd(@NotNull VasNewAdParams vasNewAdParams, @NotNull VasAdCallback callback) {
        Intrinsics.checkNotNullParameter(vasNewAdParams, "vasNewAdParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new com.tencent.mobileqq.vas.adv.base.service.d(vasNewAdParams, callback).j();
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void requestPublicAccountAd(final int from, @NotNull final String preTab) {
        long j3;
        GuardManager guardManager;
        Intrinsics.checkNotNullParameter(preTab, "preTab");
        QLog.i(TAG, 1, "requestPublicAccountAd, from: " + from + ", preTab: " + preTab);
        final long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            j3 = peekAppRuntime.getLongAccountUin();
        } else {
            j3 = 0;
        }
        Long l3 = this.uin2nextRequestAdTime.get(Long.valueOf(j3));
        if (l3 == null) {
            l3 = 0L;
        }
        long longValue = l3.longValue();
        if (longValue > serverTimeMillis) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "next request public account ad time is:" + longValue + ", current: " + serverTimeMillis);
                return;
            }
            return;
        }
        final boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106030", true);
        final long j16 = j3;
        c.a.a(VasAdvSupport.INSTANCE.a(), new Runnable() { // from class: com.tencent.mobileqq.vas.adv.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                VasAdvApiImpl.requestPublicAccountAd$lambda$3(from, preTab, isSwitchOn, j16, this, serverTimeMillis);
            }
        }, true, false, 4, null);
        if (!isForegroundRegistered && (guardManager = GuardManager.sInstance) != null) {
            isForegroundRegistered = true;
            guardManager.registerCallBack(new d());
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void requestRecommendAd(int adSecondCategory, @NotNull f.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        f.f308307a.d(adSecondCategory, callback);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void shopMaskRealTimeCheck(@NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull MaskAdCheckCallBack callback) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.vas.adv.preload.a.f308150a.a(adInfo, callback);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void startAsyncCardAdRequest(@Nullable List<String> posIds, boolean enableShowMask, @NotNull String sourceFrom) {
        Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
        VasKuiklyCardAdManager.f308031a.d(posIds, enableShowMask, sourceFrom);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void startVasRewardAdDebugFragment(@Nullable Activity activity) {
        if (activity != null) {
            VasAdDebugFragment.INSTANCE.a(activity);
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.api.IVasAdvApi
    public void toLandingPage(@NotNull Activity activity, @NotNull LandingPageParams params) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        VasAdvSupport.INSTANCE.a().toLandingPage(activity, params);
    }
}
