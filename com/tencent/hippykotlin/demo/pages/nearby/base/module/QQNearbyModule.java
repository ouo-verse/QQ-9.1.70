package com.tencent.hippykotlin.demo.pages.nearby.base.module;

import c45.i;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPPerformanceInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.debug.NBPDebugSettings;
import com.tencent.hippykotlin.demo.pages.nearby.base.debug.NBPDebugSettingsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyAIOAccessService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyMapThemeRepo$fetchFeedShareInfo$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.SsoGetFeedShareInfoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NBPAddressUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProSafeTip;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import d45.a;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import m25.b;
import n25.j;
import n25.l;
import n35.v;
import n35.w;
import n35.z;
import org.apache.httpcore.message.TokenParser;
import p35.ag;
import p35.ah;
import p35.n;
import s35.af;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQNearbyModule extends Module {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public static void scrollToPositionOnMap$default(double d16, double d17) {
            Companion companion = QQNearbyModule.Companion;
            KLog kLog = KLog.INSTANCE;
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            kLog.i("feed_detail_page", "scrollToPositionOnMap " + d16 + TokenParser.SP + d17);
            e eVar = new e();
            e eVar2 = new e();
            eVar2.s("latitude", d16);
            eVar2.s("longitude", d17);
            eVar2.u("animateDuration", 300L);
            Unit unit = Unit.INSTANCE;
            eVar.v("nearbyData", eVar2);
            k.d((k) c.f117352a.g().acquireModule("KRNotifyModule"), "MSG_LOCATION_ACTION", eVar, false, 4, null);
        }

        public final QQNearbyModule getInstance() {
            return (QQNearbyModule) c.f117352a.g().acquireModule("QQNearbyModule");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070 A[Catch: all -> 0x00bb, TryCatch #0 {all -> 0x00bb, blocks: (B:5:0x0011, B:7:0x0024, B:9:0x002f, B:12:0x003b, B:18:0x0056, B:21:0x0061, B:27:0x0070, B:31:0x0077, B:33:0x0083, B:34:0x0086), top: B:4:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkAioAccess(final Function0<Unit> function0) {
        NearbyAIOAccessService companion = NearbyAIOAccessService.Companion.getInstance();
        Unit unit = null;
        r2 = null;
        Long l3 = null;
        if (companion != null) {
            Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$checkAioAccess$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Boolean bool) {
                    if (bool.booleanValue()) {
                        function0.invoke();
                    }
                    return Unit.INSTANCE;
                }
            };
            try {
                e object = Utils.INSTANCE.cacheModule("").getObject("nbp_aio_access_data_for_safe");
                boolean z16 = true;
                boolean f16 = object != null ? object.f("isAuthorized") : true;
                String p16 = object != null ? object.p("tips") : null;
                if (object != null) {
                    Long valueOf = Long.valueOf(object.n("nextPullTime"));
                    if ((valueOf.longValue() > 0) != false) {
                        l3 = valueOf;
                    }
                }
                function1.invoke(Boolean.valueOf(f16));
                if (!f16) {
                    if (p16 != null) {
                        if ((p16.length() > 0) == true) {
                            if (z16) {
                                NearbyProSafeTip.INSTANCE.dangerTip(p16);
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                    }
                }
                if (l3 != null) {
                    if (APICallTechReporterKt.NBPCurrentTime() > l3.longValue()) {
                        companion.fetch();
                    }
                }
                KLog.INSTANCE.i("NearbyAioSafeCheckService", "check, isRequesting: " + companion.isRequesting + ", tips: " + p16 + ", isAuthorized: " + f16 + ", nextPullTime=" + l3);
            } catch (Throwable th5) {
                function1.invoke(Boolean.TRUE);
                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("check, json error: ", th5, KLog.INSTANCE, "NearbyAioSafeCheckService");
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            function0.invoke();
        }
    }

    public final void enterAddFriendPage(String str, String str2) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("openId", str, "nickName", str2);
        Unit unit = Unit.INSTANCE;
        asyncToNativeMethod("enterAddFriendPage", m3, (Function1<? super e, Unit>) null);
    }

    public final m25.c getCommonExtInfo() {
        int i3 = 12;
        if (defpackage.k.a(c.f117352a)) {
            String bVar = toNative(false, "getCommonExtPB", null, null, true).toString();
            e eVar = bVar.length() > 0 ? new e(bVar) : null;
            Intrinsics.checkNotNull(eVar, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
            e m3 = eVar.m("clientInfo");
            b bVar2 = m3 != null ? new b(m3.p(VasUserData.Key.QQ_VER), m3.p("device"), m3.j("platform")) : null;
            byte[] a16 = a.a(eVar.p(PreloadTRTCPlayerParams.KEY_SIG));
            if (a16 != null) {
                if (!(a16.length == 0)) {
                    return new m25.c(bVar2, new c45.a(a16), i3);
                }
            }
            return new m25.c(bVar2, new c45.a(new byte[0]), i3);
        }
        e eVar2 = new e(syncToNativeMethod("getIOSClientInfo", (e) null, (Function1<? super e, Unit>) null));
        return new m25.c(new b(eVar2.p(VasUserData.Key.QQ_VER), eVar2.p("device"), eVar2.j("platform")), new c45.a(getSig()), i3);
    }

    public final MatchFriendUserSelfData getKLUserSelfInfo() {
        e eVar = new e(syncToNativeMethod("getKLUserSelfInfo", (e) null, (Function1<? super e, Unit>) null));
        MatchFriendUserSelfData matchFriendUserSelfData = new MatchFriendUserSelfData();
        matchFriendUserSelfData.userId = eVar.p("userId");
        matchFriendUserSelfData.userNickName = eVar.p("userNick");
        matchFriendUserSelfData.userAvatar = eVar.p("userAvatar");
        matchFriendUserSelfData.userConstellation = eVar.p("userConstellation");
        return matchFriendUserSelfData;
    }

    public final byte[] getSig() {
        byte[] a16;
        c cVar = c.f117352a;
        if (defpackage.k.a(cVar)) {
            a16 = a.a(syncToNativeMethod("getSig", (e) null, (Function1<? super e, Unit>) null));
        } else {
            a16 = a.a(((CacheModule) cVar.g().acquireModule("HRCacheModule")).getItem("nearbypro_sig_str"));
        }
        return a16 == null ? new byte[0] : a16;
    }

    public final String getStringFromQQCommonConfig(String str, String str2) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("key", str);
        Unit unit = Unit.INSTANCE;
        String syncToNativeMethod = syncToNativeMethod("getStringFromQQCommonConfig", m3, (Function1<? super e, Unit>) null);
        return syncToNativeMethod.length() == 0 ? str2 : syncToNativeMethod;
    }

    public final UserInfo getUserInfo() {
        if (defpackage.k.a(c.f117352a)) {
            String bVar = toNative(false, "getUserInfo", null, null, true).toString();
            if (!(bVar.length() > 0)) {
                return null;
            }
            e eVar = new e(bVar);
            return new UserInfo(eVar.q("nick", ""), eVar.i("altitude", 0.0d), eVar.i("longitude", 0.0d), eVar.i("latitude", 0.0d), eVar.q("tid", ""), eVar.q("avatar", ""), eVar.k("gender", 0), eVar.q("avatarDressBorderUrl", ""));
        }
        NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
        String str = userSelfInfo.nickName;
        NBPLatLng nBPLatLng = userSelfInfo.latLng;
        return new UserInfo(str, 0.0d, nBPLatLng.longitude, nBPLatLng.latitude, String.valueOf(userSelfInfo.tid), userSelfInfo.avatarUrl, userSelfInfo.gender, userSelfInfo.avatarDressBorderUrl);
    }

    public final boolean hadLocationPermission() {
        NBPDebugSettings loadIfNotPublic = NBPDebugSettings.Companion.loadIfNotPublic(getPageData());
        if (loadIfNotPublic == null || !loadIfNotPublic.enableMockLocation) {
            return Intrinsics.areEqual(syncToNativeMethod("hadLocationPermission", (e) null, (Function1<? super e, Unit>) null), "1");
        }
        return true;
    }

    public final boolean isFollowedPublicAccount(String str) {
        e eVar = new e();
        eVar.v("uin", str);
        try {
            return new e(syncToNativeMethod("isFollowedPublicAccount", eVar, (Function1<? super e, Unit>) null)).g("isFollowed", false);
        } catch (Exception e16) {
            KLog.INSTANCE.e("QQNearbyModule", "isFollowed result invalid " + e16);
            return false;
        }
    }

    public final void jumpReportPage(int i3, String str, String str2, String str3) {
        e eVar = new e();
        eVar.t("appId", i3);
        eVar.v("tid", str);
        eVar.v("contentId", str2);
        if (str3 != null) {
            eVar.v("chatType", str3);
        }
        Unit unit = Unit.INSTANCE;
        asyncToNativeMethod("doJumpReport", eVar, (Function1<? super e, Unit>) null);
    }

    public final void jumpReportPageV2(String str, String str2, String str3) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("appId", str, "evilUin", str2);
        m3.t("evilUinType", 2);
        m3.v("buddyFlag", "0");
        m3.w("isAnonymous", false);
        m3.v("contentId", str3);
        Unit unit = Unit.INSTANCE;
        asyncToNativeMethod("doJumpReportV2", m3, (Function1<? super e, Unit>) null);
    }

    public final void launchNearbyAIOFragment(final int i3, final String str, final String str2, final String str3) {
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        kLog.i("personal_detail_page", "launchNearbyAIOFragment, " + i3);
        checkAioAccess(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$launchNearbyAIOFragment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQNearbyModule qQNearbyModule = QQNearbyModule.this;
                e eVar = new e();
                int i16 = i3;
                String str4 = str;
                String str5 = str2;
                String str6 = str3;
                eVar.t("key_from", i16);
                eVar.v("key_peerId", str4);
                eVar.v("nick", str5);
                eVar.v(PhotoCategorySummaryInfo.AVATAR_URL, str6);
                Unit unit = Unit.INSTANCE;
                qQNearbyModule.asyncToNativeMethod("launchNearbyAIOFragment", eVar, (Function1<? super e, Unit>) null);
                return Unit.INSTANCE;
            }
        });
    }

    public final void launchZPlanScheme(String str) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m(ZPlanPublishSource.FROM_SCHEME, str);
        Unit unit = Unit.INSTANCE;
        asyncToNativeMethod("launchZPlanScheme", m3, (Function1<? super e, Unit>) null);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQNearbyModule";
    }

    public final void openFeedCommentPage(int i3, int i16, String str, String str2, String str3, String str4, String str5) {
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("openFeedCommentPage: source=");
        sb5.append(i3);
        sb5.append(", appId=");
        sb5.append(i16);
        sb5.append(", viewerUserId=");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(VasBusinessReportData$$ExternalSyntheticOutline0.m(sb5, str, ", posterUserId=", str4, ", feedId="), str5, kLog, "feed_detail_page");
        Companion.getInstance().setSharePenetratePageData(new byte[0]);
        QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&modal_mode=1&page_name=nearby_feed_comment&app_id=" + i16 + "&viewer_user_id=" + UriKt.encodeURIComponent(str) + "&viewer_nickname=" + UriKt.encodeURIComponent(str2) + "&viewer_avatar=" + UriKt.encodeURIComponent(str3) + "&poster_user_id=" + UriKt.encodeURIComponent(str4) + "&feed_id=" + UriKt.encodeURIComponent(str5) + "&with_keyboard=false&nbp_source=" + i3 + "&custom_back_pressed=1", false, 4);
    }

    public final void openFeedDetail(l lVar, int i3, e eVar) {
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("openFeedDetail ");
        m3.append(lVar.f418092d);
        m3.append(" text: ");
        m3.append(lVar.f418096i);
        m3.append(", ext: ");
        m3.append(eVar);
        m3.append(", from: ");
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, i3, kLog, "feed_detail_page");
        NBPJumpUtil.INSTANCE.jumpArticleFeedDetailPage(lVar, i3, eVar);
    }

    public final void openGreetingPage(final String str, final String str2, final String str3, final int i3, final int i16) {
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        kLog.i("feed_detail_page", QUISkinImage$$ExternalSyntheticOutline0.m("openGreetingPage ", str, " nick: ", str2));
        checkAioAccess(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$openGreetingPage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQNearbyModule qQNearbyModule = QQNearbyModule.this;
                e eVar = new e();
                String str4 = str;
                String str5 = str2;
                String str6 = str3;
                int i17 = i3;
                int i18 = i16;
                eVar.u("tinyId", Long.parseLong(str4));
                eVar.v("nickName", str5);
                eVar.v(PhotoCategorySummaryInfo.AVATAR_URL, str6);
                eVar.t(AdMetricTag.Report.TYPE, i17);
                eVar.t("tacitInvite", i18);
                Unit unit = Unit.INSTANCE;
                qQNearbyModule.asyncToNativeMethod("openGreetingPage", eVar, (Function1<? super e, Unit>) null);
                return Unit.INSTANCE;
            }
        });
    }

    public final void requestLocationPermission(final Function1<? super Integer, Unit> function1) {
        NBPDebugSettings loadIfNotPublic = NBPDebugSettings.Companion.loadIfNotPublic(getPageData());
        if (loadIfNotPublic != null && loadIfNotPublic.enableMockLocation) {
            function1.invoke(1);
        } else {
            final APICallTechReporter aPICallTechReporter = new APICallTechReporter(2, "QQNearbyModule.requestLocationPermission");
            syncToNativeMethod("requestLocationPermission", (e) null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$requestLocationPermission$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    APICallTechReporter.this.reportSuccess();
                    function1.invoke(Integer.valueOf(eVar2 != null ? eVar2.j("result") : 0));
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void sendAIOMessage(String str, String str2, Function1<? super e, Unit> function1) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("tid", str, "text", str2);
        Unit unit = Unit.INSTANCE;
        asyncToNativeMethod("sendAIOMessage", m3, function1);
    }

    public final void setSharePenetratePageData(byte[][] bArr) {
        Intrinsics.checkNotNull(bArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        syncToNativeMethod("setSharePenetratePageData", bArr, (Function1<Object, Unit>) null);
    }

    public final void showKLDatePicker(int i3, int i16, int i17, final Function1 function1) {
        e eVar = new e();
        eVar.t("year", i3);
        eVar.t("month", i16);
        eVar.t("day", i17);
        eVar.w("shouldLimit", false);
        asyncToNativeMethod("showKLDatePicker", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$showKLDatePicker$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                function1.invoke(eVar2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void showKLGenderPicker(int i3, final Function1 function1) {
        e eVar = new e();
        eVar.t("gender", i3);
        eVar.w("shouldLimit", false);
        asyncToNativeMethod("showKLGenderPicker", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$showKLGenderPicker$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                function1.invoke(eVar3 != null ? Integer.valueOf(eVar3.j("result")) : null);
                return Unit.INSTANCE;
            }
        });
    }

    public final void startLocation(boolean z16, final Function2<? super Integer, ? super NBPSsoLocation, Unit> function2) {
        NBPDebugSettings loadIfNotPublic = NBPDebugSettings.Companion.loadIfNotPublic(getPageData());
        if (loadIfNotPublic != null && loadIfNotPublic.enableMockLocation && loadIfNotPublic.mockLocation != null) {
            function2.invoke(0, NBPDebugSettingsKt.toNBPSsoLocation(loadIfNotPublic.mockLocation));
            return;
        }
        final APICallTechReporter aPICallTechReporter = new APICallTechReporter(2, "QQNearbyModule.startLocation");
        e eVar = new e();
        eVar.t("ignoreAppInBackground", d.b(z16));
        Unit unit = Unit.INSTANCE;
        syncToNativeMethod("startLocation", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$startLocation$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                if (eVar3 == null) {
                    eVar3 = new e();
                }
                final int j3 = eVar3.j("code");
                if (j3 == 0) {
                    APICallTechReporter.this.reportSuccess();
                } else {
                    APICallTechReporter.this.reportError(String.valueOf(j3));
                }
                final e m3 = eVar3.m("ssoLocation");
                if (m3 == null) {
                    m3 = new e();
                }
                if (Intrinsics.areEqual(m3.p("city"), "Unknown")) {
                    KLog.INSTANCE.i("QQNearbyModule", "no city, origin location: " + m3);
                    double h16 = m3.h("lat02");
                    double h17 = m3.h("lon02");
                    NBPAddressUtils nBPAddressUtils = NBPAddressUtils.INSTANCE;
                    final Function2<Integer, NBPSsoLocation, Unit> function22 = function2;
                    nBPAddressUtils.geo2Address(h16, h17, new Function1<NBPSsoLocation, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$startLocation$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(NBPSsoLocation nBPSsoLocation) {
                            NBPSsoLocation nBPSsoLocation2 = nBPSsoLocation;
                            if (nBPSsoLocation2 != null) {
                                e eVar4 = m3;
                                eVar4.v("name", nBPSsoLocation2.name);
                                eVar4.v("address", nBPSsoLocation2.address);
                                eVar4.v("nation", nBPSsoLocation2.nation);
                                eVar4.v("province", nBPSsoLocation2.province);
                                eVar4.v("city", nBPSsoLocation2.city);
                                eVar4.v(b8.a.CITYCODE, nBPSsoLocation2.cityCode);
                                eVar4.v("district", nBPSsoLocation2.district);
                                eVar4.v("street", nBPSsoLocation2.street);
                                eVar4.v("streetNo", nBPSsoLocation2.streetNo);
                            }
                            Function2<Integer, NBPSsoLocation, Unit> function23 = function22;
                            Integer valueOf = Integer.valueOf(j3);
                            e eVar5 = m3;
                            NBPSsoLocation nBPSsoLocation3 = new NBPSsoLocation();
                            if (eVar5 != null) {
                                nBPSsoLocation3.lat02 = eVar5.h("lat02");
                                nBPSsoLocation3.lon02 = eVar5.h("lon02");
                                nBPSsoLocation3.lat84 = eVar5.h("lat84");
                                nBPSsoLocation3.lon84 = eVar5.h("lon84");
                                nBPSsoLocation3.name = eVar5.p("name");
                                nBPSsoLocation3.address = eVar5.p("address");
                                nBPSsoLocation3.nation = eVar5.p("nation");
                                nBPSsoLocation3.province = eVar5.p("province");
                                nBPSsoLocation3.city = eVar5.p("city");
                                nBPSsoLocation3.cityCode = eVar5.p(b8.a.CITYCODE);
                                nBPSsoLocation3.district = eVar5.p("district");
                                eVar5.p("town");
                                eVar5.p("village");
                                nBPSsoLocation3.street = eVar5.p("street");
                                nBPSsoLocation3.streetNo = eVar5.p("streetNo");
                            }
                            function23.invoke(valueOf, nBPSsoLocation3);
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    Function2<Integer, NBPSsoLocation, Unit> function23 = function2;
                    Integer valueOf = Integer.valueOf(j3);
                    NBPSsoLocation nBPSsoLocation = new NBPSsoLocation();
                    nBPSsoLocation.lat02 = m3.h("lat02");
                    nBPSsoLocation.lon02 = m3.h("lon02");
                    nBPSsoLocation.lat84 = m3.h("lat84");
                    nBPSsoLocation.lon84 = m3.h("lon84");
                    nBPSsoLocation.name = m3.p("name");
                    nBPSsoLocation.address = m3.p("address");
                    nBPSsoLocation.nation = m3.p("nation");
                    nBPSsoLocation.province = m3.p("province");
                    nBPSsoLocation.city = m3.p("city");
                    nBPSsoLocation.cityCode = m3.p(b8.a.CITYCODE);
                    nBPSsoLocation.district = m3.p("district");
                    m3.p("town");
                    m3.p("village");
                    nBPSsoLocation.street = m3.p("street");
                    nBPSsoLocation.streetNo = m3.p("streetNo");
                    function23.invoke(valueOf, nBPSsoLocation);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void uploadImage(String str, final Function1<? super byte[], Unit> function1) {
        final APICallTechReporter aPICallTechReporter = new APICallTechReporter(2, "QQNearbyModule.uploadImage");
        if (str.length() == 0) {
            function1.invoke(null);
        } else {
            asyncToNativeMethod(InnerWebView.API_UPLOAD_IMAGE, new Object[]{str}, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$uploadImage$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    APICallTechReporter.this.reportSuccess();
                    if (obj != null && (obj instanceof byte[])) {
                        function1.invoke(obj);
                    } else {
                        function1.invoke(null);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void viewToImage(int i3, String str, boolean z16, final Function1<? super String, Unit> function1) {
        e eVar = new e();
        eVar.t(HippyHeaderListViewController.VIEW_TAG, i3);
        eVar.w("saveToAlbum", z16);
        eVar.v(WadlProxyConsts.PARAM_FILENAME, str);
        asyncToNativeMethod("viewToImage", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$viewToImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                function1.invoke(eVar3 != null ? eVar3.p("path") : null);
                return Unit.INSTANCE;
            }
        });
    }

    public final UserSelfBaseInfo getMatchFriendBaseInfo() {
        UserSelfBaseInfo userSelfBaseInfo;
        String bVar = toNative(false, "getMatchFriendBaseInfo", null, null, true).toString();
        try {
            if (bVar.length() == 0) {
                userSelfBaseInfo = new UserSelfBaseInfo(1, 14);
            } else {
                e eVar = new e(bVar);
                userSelfBaseInfo = new UserSelfBaseInfo(1, eVar.p("accountId"), eVar.p("nick"), eVar.p(PhotoCategorySummaryInfo.AVATAR_URL));
            }
            return userSelfBaseInfo;
        } catch (Throwable th5) {
            KLog.INSTANCE.e("MatchFriendBaseInfo", th5.toString());
            return new UserSelfBaseInfo(1, 14);
        }
    }

    public final NBPPerformanceInfo getPerformanceInfo() {
        e eVar;
        try {
            eVar = new e(toNative(false, "getPerformanceInfo", null, null, true).toString());
        } catch (Exception e16) {
            KLog kLog = KLog.INSTANCE;
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getPerformanceInfo error: ");
            m3.append(e16.getMessage());
            kLog.e("feed_detail_page", m3.toString());
            eVar = null;
        }
        if (eVar == null) {
            return null;
        }
        NBPPerformanceInfo nBPPerformanceInfo = new NBPPerformanceInfo();
        nBPPerformanceInfo.cpu = (float) eVar.i("cpu", 0.0d);
        nBPPerformanceInfo.memUsage = (float) eVar.i("memUsage", 0.0d);
        nBPPerformanceInfo.memLeft = (float) eVar.i("memLeft", 0.0d);
        return nBPPerformanceInfo;
    }

    public final Object[] getSharePenetratePageData() {
        Object syncToNativeMethod = syncToNativeMethod("getSharePenetratePageData", new Object[0], (Function1<Object, Unit>) null);
        if (syncToNativeMethod instanceof Object[]) {
            return (Object[]) syncToNativeMethod;
        }
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class UserInfo {
        public final double altitude;
        public final String avatar;
        public final String avatarDressBorderUrl;
        public final int gender;
        public final double latitude;
        public final double longitude;
        public final String nick;
        public final String tid;

        public UserInfo(String str, double d16, double d17, double d18, String str2, String str3, int i3, String str4) {
            this.nick = str;
            this.altitude = d16;
            this.longitude = d17;
            this.latitude = d18;
            this.tid = str2;
            this.avatar = str3;
            this.gender = i3;
            this.avatarDressBorderUrl = str4;
        }

        public final String getTid() {
            return this.tid;
        }

        public final int hashCode() {
            return this.avatarDressBorderUrl.hashCode() + QQAudioParams$$ExternalSyntheticOutline0.m(this.gender, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.avatar, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.tid, (gt0.a.a(this.latitude) + ((gt0.a.a(this.longitude) + ((gt0.a.a(this.altitude) + (this.nick.hashCode() * 31)) * 31)) * 31)) * 31, 31), 31), 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UserInfo(nick=");
            m3.append(this.nick);
            m3.append(", altitude=");
            m3.append(this.altitude);
            m3.append(", longitude=");
            m3.append(this.longitude);
            m3.append(", latitude=");
            m3.append(this.latitude);
            m3.append(", tid=");
            m3.append(this.tid);
            m3.append(", avatar=");
            m3.append(this.avatar);
            m3.append(", gender=");
            m3.append(this.gender);
            m3.append(", avatarDressBorderUrl=");
            return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.avatarDressBorderUrl, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserInfo)) {
                return false;
            }
            UserInfo userInfo = (UserInfo) obj;
            return Intrinsics.areEqual(this.nick, userInfo.nick) && Double.compare(this.altitude, userInfo.altitude) == 0 && Double.compare(this.longitude, userInfo.longitude) == 0 && Double.compare(this.latitude, userInfo.latitude) == 0 && Intrinsics.areEqual(this.tid, userInfo.tid) && Intrinsics.areEqual(this.avatar, userInfo.avatar) && this.gender == userInfo.gender && Intrinsics.areEqual(this.avatarDressBorderUrl, userInfo.avatarDressBorderUrl);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void openFeedShare$default(QQNearbyModule qQNearbyModule, final int i3, final int i16, l lVar, n nVar, boolean z16, Function1 function1, int i17) {
        String str;
        final Function1 function12;
        NearbyFeedPosterData nearbyFeedPosterData;
        Object firstOrNull;
        Object firstOrNull2;
        v vVar;
        Object firstOrNull3;
        String decodeToString;
        String str2;
        String str3;
        String str4;
        w wVar;
        List<z> list;
        Object firstOrNull4;
        String userId;
        boolean z17;
        e eVar;
        final byte[] encodeToByteArray;
        e eVar2;
        Object firstOrNull5;
        String str5;
        String str6;
        String valueOf;
        String str7;
        boolean isBlank;
        c45.a aVar;
        String str8;
        Object firstOrNull6;
        j jVar;
        v vVar2;
        w wVar2;
        List<z> list2;
        Object firstOrNull7;
        z zVar;
        byte[] bArr;
        String decodeToString2;
        CharSequence trim;
        String obj;
        String replace$default;
        boolean isBlank2;
        boolean isBlank3;
        l lVar2 = (i17 & 4) != 0 ? null : lVar;
        n nVar2 = (i17 & 8) != 0 ? null : nVar;
        final boolean z18 = (i17 & 16) != 0 ? false : z16;
        Function1 function13 = (i17 & 32) != 0 ? null : function1;
        qQNearbyModule.getClass();
        if (lVar2 != null) {
            firstOrNull5 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) lVar2.P);
            String str9 = (String) firstOrNull5;
            String str10 = str9 == null ? "" : str9;
            r25.e eVar3 = lVar2.f418093e;
            if (eVar3 == null || (str5 = eVar3.J) == null) {
                str5 = "";
            }
            if (eVar3 == null || (str6 = eVar3.L) == null) {
                str6 = "";
            }
            String str11 = lVar2.f418092d;
            if (eVar3 == null || (valueOf = Long.valueOf(eVar3.f430610d).toString()) == null) {
                valueOf = String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid);
            }
            String str12 = valueOf;
            UserInfo userInfo = Companion.getInstance().getUserInfo();
            if (userInfo != null && Intrinsics.areEqual(userInfo.tid, str12)) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str5);
                if (isBlank2) {
                    str5 = userInfo.nick;
                }
                isBlank3 = StringsKt__StringsJVMKt.isBlank(str6);
                if (isBlank3) {
                    str7 = userInfo.avatar;
                    isBlank = StringsKt__StringsJVMKt.isBlank(str5);
                    String str13 = !isBlank ? "\u9644\u8fd1\u7528\u6237" : str5;
                    aVar = lVar2.f418096i;
                    if (aVar != null && (bArr = aVar.f30291a) != null && decodeToString2 != null) {
                        trim = StringsKt__StringsKt.trim((CharSequence) decodeToString2);
                        obj = trim.toString();
                        if (obj != null && replace$default != null) {
                            str8 = replace$default;
                            n25.k kVar = lVar2.C;
                            NearbyFeedPosterData.AddressInfo addressInfo = kVar == null ? new NearbyFeedPosterData.AddressInfo(kVar.I, kVar.M, kVar.Q) : null;
                            firstOrNull6 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) lVar2.f418097m);
                            jVar = (j) firstOrNull6;
                            if (jVar != null && (wVar2 = jVar.f418083d) != null && (list2 = wVar2.f418273d) != null) {
                                firstOrNull7 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                                zVar = (z) firstOrNull7;
                                if (zVar != null) {
                                    vVar2 = zVar.f418280d;
                                    NearbyFeedPosterData.AddressInfo addressInfo2 = addressInfo;
                                    str = "";
                                    function12 = function13;
                                    nearbyFeedPosterData = new NearbyFeedPosterData(i3, str12, str11, vVar2, addressInfo2, str8, str7, str13, str10, 16);
                                }
                            }
                            vVar2 = null;
                            NearbyFeedPosterData.AddressInfo addressInfo22 = addressInfo;
                            str = "";
                            function12 = function13;
                            nearbyFeedPosterData = new NearbyFeedPosterData(i3, str12, str11, vVar2, addressInfo22, str8, str7, str13, str10, 16);
                        }
                    }
                    str8 = "";
                    n25.k kVar2 = lVar2.C;
                    if (kVar2 == null) {
                    }
                    firstOrNull6 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) lVar2.f418097m);
                    jVar = (j) firstOrNull6;
                    if (jVar != null) {
                        firstOrNull7 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                        zVar = (z) firstOrNull7;
                        if (zVar != null) {
                        }
                    }
                    vVar2 = null;
                    NearbyFeedPosterData.AddressInfo addressInfo222 = addressInfo;
                    str = "";
                    function12 = function13;
                    nearbyFeedPosterData = new NearbyFeedPosterData(i3, str12, str11, vVar2, addressInfo222, str8, str7, str13, str10, 16);
                }
            }
            str7 = str6;
            isBlank = StringsKt__StringsJVMKt.isBlank(str5);
            if (!isBlank) {
            }
            aVar = lVar2.f418096i;
            if (aVar != null) {
                decodeToString2 = StringsKt__StringsJVMKt.decodeToString(bArr);
                trim = StringsKt__StringsKt.trim((CharSequence) decodeToString2);
                obj = trim.toString();
                if (obj != null) {
                    replace$default = StringsKt__StringsJVMKt.replace$default(obj, "\n", " ", false, 4, (Object) null);
                    str8 = replace$default;
                    n25.k kVar22 = lVar2.C;
                    if (kVar22 == null) {
                    }
                    firstOrNull6 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) lVar2.f418097m);
                    jVar = (j) firstOrNull6;
                    if (jVar != null) {
                    }
                    vVar2 = null;
                    NearbyFeedPosterData.AddressInfo addressInfo2222 = addressInfo;
                    str = "";
                    function12 = function13;
                    nearbyFeedPosterData = new NearbyFeedPosterData(i3, str12, str11, vVar2, addressInfo2222, str8, str7, str13, str10, 16);
                }
            }
            str8 = "";
            n25.k kVar222 = lVar2.C;
            if (kVar222 == null) {
            }
            firstOrNull6 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) lVar2.f418097m);
            jVar = (j) firstOrNull6;
            if (jVar != null) {
            }
            vVar2 = null;
            NearbyFeedPosterData.AddressInfo addressInfo22222 = addressInfo;
            str = "";
            function12 = function13;
            nearbyFeedPosterData = new NearbyFeedPosterData(i3, str12, str11, vVar2, addressInfo22222, str8, str7, str13, str10, 16);
        } else {
            str = "";
            function12 = function13;
            if (nVar2 != null) {
                af afVar = nVar2.f425194e;
                String str14 = (afVar == null || (userId = StrangerUtilsKt.getUserId(afVar, i3)) == null) ? str : userId;
                ah ahVar = nVar2.C;
                NearbyFeedPosterData.AddressInfo addressInfo3 = ahVar != null ? new NearbyFeedPosterData.AddressInfo(ahVar.I, ahVar.M, ahVar.Q) : null;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) nVar2.I);
                String str15 = (String) firstOrNull;
                String str16 = str15 == null ? str : str15;
                String str17 = nVar2.f425193d;
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) nVar2.f425198m);
                ag agVar = (ag) firstOrNull2;
                if (agVar != null && (wVar = agVar.f425139d) != null && (list = wVar.f418273d) != null) {
                    firstOrNull4 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                    z zVar2 = (z) firstOrNull4;
                    if (zVar2 != null) {
                        vVar = zVar2.f418280d;
                        firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) nVar2.f425198m);
                        ag agVar2 = (ag) firstOrNull3;
                        String str18 = (agVar2 != null || (str4 = agVar2.f425140e) == null) ? str : str4;
                        decodeToString = StringsKt__StringsJVMKt.decodeToString(nVar2.f425197i.f30291a);
                        af afVar2 = nVar2.f425194e;
                        nearbyFeedPosterData = new NearbyFeedPosterData(i3, str14, str17, vVar, str18, addressInfo3, decodeToString, (afVar2 != null || (str3 = afVar2.E) == null) ? str : str3, (afVar2 != null || (str2 = afVar2.f433209f) == null) ? str : str2, str16);
                    }
                }
                vVar = null;
                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) nVar2.f425198m);
                ag agVar22 = (ag) firstOrNull3;
                if (agVar22 != null) {
                }
                decodeToString = StringsKt__StringsJVMKt.decodeToString(nVar2.f425197i.f30291a);
                af afVar22 = nVar2.f425194e;
                nearbyFeedPosterData = new NearbyFeedPosterData(i3, str14, str17, vVar, str18, addressInfo3, decodeToString, (afVar22 != null || (str3 = afVar22.E) == null) ? str : str3, (afVar22 != null || (str2 = afVar22.f433209f) == null) ? str : str2, str16);
            } else {
                nearbyFeedPosterData = null;
            }
        }
        if (nearbyFeedPosterData == null) {
            KLog kLog = KLog.INSTANCE;
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            kLog.i("feed_detail_page", "openFeedShare posterData is null");
            if (function12 != null) {
                function12.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        KLog kLog2 = KLog.INSTANCE;
        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
        StringBuilder m3 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("openFeedShare appId:", i3, " fid:");
        m3.append(nearbyFeedPosterData.feedId);
        m3.append(" tid:");
        m3.append(nearbyFeedPosterData.userId);
        m3.append(" from:");
        m3.append(i16);
        kLog2.i("feed_detail_page", m3.toString());
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("canOpenFeedSharePage: source=", i16, ", fid="), nearbyFeedPosterData.feedId, kLog2, "NearbyProShareUtils");
        if (i16 == 1) {
            Integer num = Utils.INSTANCE.cacheModule(str).getInt("nbp_feed_auto_share_after_publish_count");
            int intValue = num != null ? num.intValue() : 0;
            String stringFromQQCommonConfig = Companion.getInstance().getStringFromQQCommonConfig("102243", "{}");
            kLog2.i("NearbyProShareUtils", "getQQMCConfig: 102243: " + stringFromQQCommonConfig);
            try {
                eVar2 = new e(stringFromQQCommonConfig);
            } catch (Throwable unused) {
                eVar2 = new e();
            }
            int k3 = eVar2.k("auto_share_max_times", 999);
            KLog.INSTANCE.i("NearbyProShareUtils", "canAutoOpenSharePage: preCount=" + intValue + ", maxCount=" + k3);
            if (!(intValue < k3)) {
                z17 = false;
                if (z17) {
                    KLog kLog3 = KLog.INSTANCE;
                    NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                    kLog3.i("feed_detail_page", "openFeedShare canOpenFeedSharePage: false");
                    if (function12 != null) {
                        function12.invoke(Boolean.FALSE);
                        return;
                    }
                    return;
                }
                KLog kLog4 = KLog.INSTANCE;
                kLog4.i("NBPJumpUtil", "jumpArticleFeedSharePage: appId=" + i3 + " source=" + i16 + ", feedId=" + nearbyFeedPosterData.feedId);
                final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil$jumpArticleFeedSharePage$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Boolean bool) {
                        boolean booleanValue = bool.booleanValue();
                        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("jumpArticleFeedSharePage: success=", booleanValue, KLog.INSTANCE, "NBPJumpUtil");
                        if (booleanValue) {
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_common_share&app_id=");
                            m16.append(i3);
                            m16.append("&share_type=4&custom_back_pressed=1&modal_mode=1&nbp_source=");
                            m16.append(i16);
                            String sb5 = m16.toString();
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.openPage$default(sb5, z18, 4);
                            Function1<Boolean, Unit> function15 = function12;
                            if (function15 != null) {
                                function15.invoke(Boolean.TRUE);
                            }
                        } else {
                            Function1<Boolean, Unit> function16 = function12;
                            if (function16 != null) {
                                function16.invoke(Boolean.FALSE);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                String str19 = nearbyFeedPosterData.feedId;
                String str20 = nearbyFeedPosterData.themeId;
                e eVar4 = new e();
                eVar4.t("appId", nearbyFeedPosterData.appId);
                eVar4.v("userId", nearbyFeedPosterData.userId);
                eVar4.v("feedId", nearbyFeedPosterData.feedId);
                eVar4.v("feedFallbackImage", nearbyFeedPosterData.feedFallbackImage);
                v vVar3 = nearbyFeedPosterData.feedImage;
                eVar4.v("feedImage", vVar3 != null ? i.c(vVar3) : null);
                NearbyFeedPosterData.AddressInfo addressInfo4 = nearbyFeedPosterData.feedAddress;
                if (addressInfo4 != null) {
                    eVar = new e();
                    eVar.v("city", addressInfo4.city);
                    eVar.v("district", addressInfo4.district);
                    eVar.v(CommonConstant.KEY_DISPLAY_NAME, addressInfo4.displayName);
                } else {
                    eVar = null;
                }
                eVar4.v("feedAddress", eVar);
                eVar4.v("feedTitle", nearbyFeedPosterData.feedTitle);
                eVar4.v("userAvatar", nearbyFeedPosterData.userAvatar);
                eVar4.v("userNickname", nearbyFeedPosterData.userNickname);
                eVar4.v("themeId", nearbyFeedPosterData.themeId);
                encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(eVar4.toString());
                if (i16 != 1) {
                    Companion.getInstance().setSharePenetratePageData(new byte[][]{encodeToByteArray});
                    function14.invoke(Boolean.TRUE);
                    return;
                }
                Function1<PbResponse<v25.e>, Unit> function15 = new Function1<PbResponse<v25.e>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil$prepareFeedSharePageData$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PbResponse<v25.e> pbResponse) {
                        String str21;
                        PbResponse<v25.e> pbResponse2 = pbResponse;
                        v25.e eVar5 = pbResponse2.rsp;
                        if (pbResponse2.success && eVar5 != null) {
                            byte[] d16 = i.d(eVar5);
                            if (d16 == null) {
                                d16 = new byte[0];
                            }
                            QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{encodeToByteArray, d16});
                            function14.invoke(Boolean.TRUE);
                        } else {
                            KLog kLog5 = KLog.INSTANCE;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchPosterConfig: ");
                            m16.append(pbResponse2.code);
                            m16.append(", ");
                            m16.append(pbResponse2.f114187msg);
                            kLog5.e("NBPJumpUtil", m16.toString());
                            if (i16 != 1) {
                                if (NearbyProUtilsKt.isShowBackendErrorMsg(pbResponse2.code)) {
                                    str21 = pbResponse2.f114187msg;
                                } else {
                                    str21 = "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                }
                                Utils.INSTANCE.currentBridgeModule().qToast(str21, QToastMode.Info);
                            }
                            function14.invoke(Boolean.FALSE);
                        }
                        return Unit.INSTANCE;
                    }
                };
                boolean z19 = str20.length() == 0;
                if ((str20.length() > 0) && !new Regex("^[a-zA-Z0-9]+$").matches(str20)) {
                    z19 = true;
                    str20 = str;
                }
                StringBuilder a16 = defpackage.j.a("start fetch feed share info: ", str19, ", ", str20, ", ");
                a16.append(z19);
                kLog4.i("NearbyMapThemeRepo", a16.toString());
                QQKuiklyPlatformApi.Companion.sendPbRequest$default(new SsoGetFeedShareInfoRequest(str19, str20, z19), null, new NearbyApi$sendPbRequest$1(new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGetFeedShareInfo"), new NearbyMapThemeRepo$fetchFeedShareInfo$1(function15)), 6);
                return;
            }
            Utils utils = Utils.INSTANCE;
            Integer num2 = utils.cacheModule(str).getInt("nbp_feed_auto_share_after_publish_count");
            utils.cacheModule(str).setInt("nbp_feed_auto_share_after_publish_count", Integer.valueOf((num2 != null ? num2.intValue() : 0) + 1));
        }
        z17 = true;
        if (z17) {
        }
    }
}
