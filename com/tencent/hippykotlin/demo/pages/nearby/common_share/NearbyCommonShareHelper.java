package com.tencent.hippykotlin.demo.pages.nearby.common_share;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareContentData;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.MiddlePageShareConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyCalendarPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMoodPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.PosterDataHolder;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.BDHService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishRepository;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM.NBPBaseShareVM;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.IStrangerArkRepo;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.JiebanArkRepo;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemePosterConfig;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import d45.a;
import j35.b;
import j35.g;
import j35.j;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import n25.k;
import n25.l;
import n25.m;
import n35.v;
import n35.w;
import p35.af;
import p35.ah;
import s25.f;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyCommonShareHelper {
    public final Function2<Boolean, String, Unit> onError;
    public final Function3<Integer, Boolean, String, Unit> onSuccess;
    public final String pagerId;
    public final IStrangerArkRepo repo;
    public final NBPBaseShareVM<?> viewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public NearbyCommonShareHelper(String str, NBPBaseShareVM<?> nBPBaseShareVM, Function3<? super Integer, ? super Boolean, ? super String, Unit> function3, Function2<? super Boolean, ? super String, Unit> function2) {
        IStrangerArkRepo iStrangerArkRepo;
        this.pagerId = str;
        this.viewModel = nBPBaseShareVM;
        this.onSuccess = function3;
        this.onError = function2;
        int appId = nBPBaseShareVM.getAppId();
        if (appId == 1) {
            iStrangerArkRepo = JiebanArkRepo.INSTANCE;
        } else if (appId != 2) {
            iStrangerArkRepo = NBPInteractiveRepo.INSTANCE;
        } else {
            iStrangerArkRepo = NBPInteractiveRepo.INSTANCE;
        }
        this.repo = iStrangerArkRepo;
    }

    public static final void access$shareByCopyLink(NearbyCommonShareHelper nearbyCommonShareHelper, Object obj, PosterDataHolder posterDataHolder) {
        String str;
        String str2;
        nearbyCommonShareHelper.viewModel.reportElementClick(10);
        if ((posterDataHolder instanceof NearbyFeedPosterData) && (obj instanceof NBPThemePosterConfig)) {
            NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) posterDataHolder;
            Utils.INSTANCE.currentBridgeModule().copyToPasteboard(((NBPThemePosterConfig) obj).getWxShareH5Url(nearbyFeedPosterData.appId, nearbyFeedPosterData.userId, nearbyFeedPosterData.feedId));
            nearbyCommonShareHelper.onSuccess.invoke(10, Boolean.TRUE, "\u590d\u5236\u6210\u529f");
            return;
        }
        if (posterDataHolder instanceof NearbyMiddlePosterData) {
            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
            ah ahVar = ((NearbyMiddlePosterData) posterDataHolder).poiData.f447113d;
            if (ahVar == null || (str2 = ahVar.R) == null) {
                str2 = "";
            }
            String m3 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("nbp_forward=4&poi_key=", str2, "&nbp_forward_source=19&local_bundle_name=nearbypro");
            StringBuilder m16 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?page_name=nearbypro_main&target=52&channel=2&version=1&src_type=app&source=", 103, "&key_scheme=");
            m16.append(UriKt.encodeURIComponent(m3));
            String sb5 = m16.toString();
            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("https://ti.qq.com/open_qq/index.html?url=");
            m17.append(UriKt.encodeURIComponent(sb5));
            currentBridgeModule.copyToPasteboard(m17.toString());
            nearbyCommonShareHelper.onSuccess.invoke(10, Boolean.TRUE, "\u590d\u5236\u6210\u529f");
            return;
        }
        if (posterDataHolder instanceof NearbyMoodPosterData) {
            BridgeModule currentBridgeModule2 = Utils.INSTANCE.currentBridgeModule();
            if (((NearbyMoodPosterData) posterDataHolder).mid == 1) {
                str = "https://ti.qq.com/open_qq/index.html?url=mqqapi%3A%2F%2Fkuikly%2Fopen%3Fpage_name%3Dnearbypro_main%26target%3D52%26channel%3D2%26version%3D1%26src_type%3Dapp%26source%3D10%26key_scheme%3Dmqqapi%253A%252F%252Fkuikly%252Fopen%253Fversion%253D1%2526src_type%253Dapp%2526page_name%253Dnbp_mood_group%2526%2526nbp_source%253D4%2526mid%253D1%2526kr_turbo_display%253D1%2526auto_join%253D0%2526local_bundle_name%253Dnearbypro";
            } else {
                str = "https://ti.qq.com/open_qq/index.html?url=mqqapi%3A%2F%2Fkuikly%2Fopen%3Fpage_name%3Dnearbypro_main%26target%3D52%26channel%3D2%26version%3D1%26src_type%3Dapp%26source%3D10%26key_scheme%3Dmqqapi%253A%252F%252Fkuikly%252Fopen%253Fversion%253D1%2526src_type%253Dapp%2526page_name%253Dnbp_mood_group%2526%2526nbp_source%253D4%2526mid%253D2%2526kr_turbo_display%253D2%2526auto_join%253D0%2526local_bundle_name%253Dnearbypro";
            }
            currentBridgeModule2.copyToPasteboard(str);
            nearbyCommonShareHelper.onSuccess.invoke(10, Boolean.TRUE, "\u590d\u5236\u6210\u529f");
            return;
        }
        if (posterDataHolder instanceof NearbyCalendarPosterData) {
            BridgeModule currentBridgeModule3 = Utils.INSTANCE.currentBridgeModule();
            StringBuilder m18 = NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?page_name=nearbypro_main&target=52&channel=2&version=1&src_type=app&source=", 104, "&key_scheme=");
            m18.append(UriKt.encodeURIComponent("mqqapi://kuikly/open?version=1&src_type=app&page_name=nbp_pray_calendar&local_bundle_name=nearbypro&mid=2"));
            String sb6 = m18.toString();
            StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("https://ti.qq.com/open_qq/index.html?url=");
            m19.append(UriKt.encodeURIComponent(sb6));
            currentBridgeModule3.copyToPasteboard(m19.toString());
            nearbyCommonShareHelper.onSuccess.invoke(10, Boolean.TRUE, "\u590d\u5236\u6210\u529f");
            return;
        }
        nearbyCommonShareHelper.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    }

    public static final void access$shareByFeed(final NearbyCommonShareHelper nearbyCommonShareHelper, int i3, final PosterDataHolder posterDataHolder) {
        nearbyCommonShareHelper.viewModel.setPreparing(true);
        nearbyCommonShareHelper.viewModel.reportElementClick(6);
        QQNearbyModule.Companion.getInstance().viewToImage(i3, nearbyCommonShareHelper.getTmpFileName(), false, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByFeed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(String str) {
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    NearbyCommonShareHelper.this.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                } else {
                    QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                    final NearbyCommonShareHelper nearbyCommonShareHelper2 = NearbyCommonShareHelper.this;
                    final PosterDataHolder<?> posterDataHolder2 = posterDataHolder;
                    companion.uploadImage(str2, new Function1<byte[], Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByFeed$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(byte[] bArr) {
                            List<m> emptyList;
                            final List<String> listOf;
                            CharSequence trim;
                            List<w> mutableList;
                            ah ahVar;
                            byte[] bArr2 = bArr;
                            w wVar = bArr2 != null ? (w) i.b(new w(null, null, 3, null), bArr2) : null;
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            listOf = CollectionsKt__CollectionsJVMKt.listOf(NearbyCommonShareHelper.this.viewModel.mapThemeId);
                            List listOf2 = wVar != null ? CollectionsKt__CollectionsJVMKt.listOf(wVar) : CollectionsKt__CollectionsKt.emptyList();
                            NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                            NBPLatLng nBPLatLng = userSelfInfo.latLng;
                            double d16 = 1000000;
                            n25.i iVar = new n25.i((long) (nBPLatLng.latitude * d16), (long) (nBPLatLng.longitude * d16), 12);
                            String str3 = userSelfInfo.locationAddress;
                            String str4 = userSelfInfo.locationCountry;
                            String str5 = userSelfInfo.locationProvince;
                            String str6 = userSelfInfo.locationCity;
                            String str7 = userSelfInfo.locationDistrict;
                            String str8 = userSelfInfo.locationName;
                            k kVar = new k((String) null, str8, 0, (String) null, str3, 0, iVar, 0, 0, (String) null, str4, str5, str6, 0, 0, (String) null, str7, (String) null, (String) null, str8, 1500077);
                            PosterDataHolder<?> posterDataHolder3 = posterDataHolder2;
                            if ((posterDataHolder3 instanceof NearbyMiddlePosterData) && (ahVar = ((NearbyMiddlePosterData) posterDataHolder3).poiData.f447113d) != null) {
                                af afVar = ahVar.C;
                                kVar = new k((String) null, ahVar.f425144e, 0, (String) null, ahVar.f425147i, 0, new n25.i(afVar != null ? afVar.f425135d : 0L, afVar != null ? afVar.f425136e : 0L, 12), 0, 0, (String) null, ahVar.G, ahVar.H, ahVar.I, 0, 0, (String) null, ahVar.M, (String) null, (String) null, ahVar.Q, 1500077);
                            }
                            k kVar2 = kVar;
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("StPoiInfoV2 gps. lat:");
                            n25.i iVar2 = kVar2.C;
                            m3.append(iVar2 != null ? Long.valueOf(iVar2.f418079d) : null);
                            m3.append(", lon:");
                            n25.i iVar3 = kVar2.C;
                            m3.append(iVar3 != null ? Long.valueOf(iVar3.f418080e) : null);
                            kLog.i("NearbyCommonShareHelper", m3.toString());
                            NBPPublishRepository nBPPublishRepository = NBPPublishRepository.INSTANCE;
                            trim = StringsKt__StringsKt.trim((CharSequence) "");
                            String obj = trim.toString();
                            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) listOf2);
                            final NearbyCommonShareHelper nearbyCommonShareHelper3 = NearbyCommonShareHelper.this;
                            Function1<f, Unit> function1 = new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper.shareByFeed.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(f fVar) {
                                    String str9;
                                    l lVar;
                                    byte[] d17;
                                    l lVar2;
                                    f fVar2 = fVar;
                                    String str10 = null;
                                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("publishFeed success, rspModel feedId="), (fVar2 == null || (lVar2 = fVar2.f433139d) == null) ? null : lVar2.f418092d, KLog.INSTANCE, "NearbyCommonShareHelper");
                                    NearbyCommonShareHelper.this.viewModel.setPreparing(false);
                                    NearbyCommonShareHelper.this.onSuccess.invoke(6, Boolean.TRUE, "\u5df2\u53d1\u5e03\u5230\u9644\u8fd1\u52a8\u6001");
                                    com.tencent.kuikly.core.module.k kVar3 = (com.tencent.kuikly.core.module.k) c.f117352a.g().acquireModule("KRNotifyModule");
                                    e eVar = new e();
                                    List<String> list = listOf;
                                    eVar.v("source", "5");
                                    if (fVar2 != null && (lVar = fVar2.f433139d) != null && (d17 = i.d(lVar)) != null) {
                                        str10 = StringsKt__StringsJVMKt.decodeToString(a.b(d17));
                                    }
                                    eVar.v("statusFeed", str10);
                                    if (!list.isEmpty()) {
                                        str9 = "1";
                                    } else {
                                        str9 = "0";
                                    }
                                    eVar.v("isSelectedTheme", str9);
                                    Unit unit = Unit.INSTANCE;
                                    com.tencent.kuikly.core.module.k.d(kVar3, "onPublishFeedFinish", eVar, false, 4, null);
                                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                    return Unit.INSTANCE;
                                }
                            };
                            final NearbyCommonShareHelper nearbyCommonShareHelper4 = NearbyCommonShareHelper.this;
                            nBPPublishRepository.requestPublishFeed(0, 0, 0, obj, kVar2, mutableList, emptyList, listOf, 4, function1, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper.shareByFeed.1.1.2
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(Integer num, String str9) {
                                    KLog.INSTANCE.e("NearbyCommonShareHelper", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("publishFeed failed, errorCode=", num.intValue(), ", errorMsg=", str9));
                                    NearbyCommonShareHelper.this.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$shareByQQZone(final NearbyCommonShareHelper nearbyCommonShareHelper, final int i3) {
        final String str = nearbyCommonShareHelper.viewModel.getPosterConfig().qzoneShareAppId;
        nearbyCommonShareHelper.viewModel.reportElementClick(2);
        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(c.f117352a)) {
            shareByQQZone$shareToQQZone(nearbyCommonShareHelper, str, i3, 2, 2, null);
        } else {
            nearbyCommonShareHelper.viewModel.setPreparing(true);
            QQNearbyModule.Companion.getInstance().viewToImage(i3, nearbyCommonShareHelper.getTmpFileName(), false, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByQQZone$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(String str2) {
                    List listOf;
                    String str3 = str2;
                    NearbyCommonShareHelper.this.viewModel.setPreparing(false);
                    if (str3 == null || str3.length() == 0) {
                        NearbyCommonShareHelper.this.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    } else {
                        NearbyCommonShareHelper nearbyCommonShareHelper2 = NearbyCommonShareHelper.this;
                        String str4 = str;
                        int i16 = i3;
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(str3);
                        NearbyCommonShareHelper.shareByQQZone$shareToQQZone(nearbyCommonShareHelper2, str4, i16, 2, 1, listOf);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public static final void access$shareBySaveFile(final NearbyCommonShareHelper nearbyCommonShareHelper, int i3) {
        String replace$default;
        nearbyCommonShareHelper.viewModel.reportElementClick(7);
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        replace$default = StringsKt__StringsJVMKt.replace$default("QQ_NEARBY_POSTER_[TIMESTAMP].png", "[TIMESTAMP]", Utils.INSTANCE.calendarModule(nearbyCommonShareHelper.pagerId).formatTime(APICallTechReporterKt.NBPCurrentTime()), false, 4, (Object) null);
        companion.viewToImage(i3, replace$default, true, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareBySaveFile$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(String str) {
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    NearbyCommonShareHelper.this.onError.invoke(Boolean.FALSE, "\u4fdd\u5b58\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                } else {
                    NearbyCommonShareHelper.this.onSuccess.invoke(7, Boolean.TRUE, "\u5df2\u4fdd\u5b58\u5230\u624b\u673a\u76f8\u518c");
                }
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$shareByXhs(final NearbyCommonShareHelper nearbyCommonShareHelper, int i3, Object obj, PosterDataHolder posterDataHolder) {
        Pair pair;
        boolean isBlank;
        nearbyCommonShareHelper.viewModel.setPreparing(true);
        nearbyCommonShareHelper.viewModel.reportElementClick(5);
        if ((posterDataHolder instanceof NearbyFeedPosterData) && (obj instanceof NBPThemePosterConfig)) {
            NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) posterDataHolder;
            String str = nearbyFeedPosterData.feedTitle;
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (isBlank) {
                str = ((NBPThemePosterConfig) obj).getWxShareTitle(nearbyFeedPosterData.userId);
            }
            pair = new Pair(str, ((NBPThemePosterConfig) obj).getWxShareDesc(nearbyFeedPosterData.userId));
        } else if ((posterDataHolder instanceof NearbyMiddlePosterData) && (obj instanceof MiddlePageShareConfig)) {
            MiddlePageShareConfig middlePageShareConfig = (MiddlePageShareConfig) obj;
            pair = new Pair(middlePageShareConfig.wxShareTitle, middlePageShareConfig.wxShareDesc);
        } else if (posterDataHolder instanceof NearbyMoodPosterData) {
            pair = new Pair("", "");
        } else if (posterDataHolder instanceof NearbyCalendarPosterData) {
            pair = new Pair("", "");
        } else {
            nearbyCommonShareHelper.viewModel.setPreparing(false);
            nearbyCommonShareHelper.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            return;
        }
        final String str2 = (String) pair.component1();
        final String str3 = (String) pair.component2();
        QQNearbyModule.Companion.getInstance().viewToImage(i3, nearbyCommonShareHelper.getTmpFileName(), false, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByXhs$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0027, code lost:
            
                r13 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r13);
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(String str4) {
                List emptyList;
                String str5 = str4;
                NearbyCommonShareHelper.this.viewModel.setPreparing(false);
                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("shareByXhs: path=", str5, KLog.INSTANCE, "NearbyCommonShareHelper");
                ShareModule shareModule = Utils.INSTANCE.shareModule(NearbyCommonShareHelper.this.pagerId);
                String str6 = str2;
                String str7 = str3;
                if (str5 == null || emptyList == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                ShareContentData shareContentData = new ShareContentData(0, null, str6, str7, emptyList, null, null, 0, 0, 4066);
                final NearbyCommonShareHelper nearbyCommonShareHelper2 = NearbyCommonShareHelper.this;
                shareModule.doShareAction(218, null, shareContentData, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByXhs$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Integer num) {
                        int intValue = num.intValue();
                        NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleShare: retCode=", intValue, KLog.INSTANCE, "NearbyCommonShareHelper");
                        if (intValue == 0) {
                            NearbyCommonShareHelper.this.onSuccess.invoke(5, Boolean.TRUE, null);
                        } else {
                            NearbyCommonShareHelper.this.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    public static final void shareByWechat$shareToWechat(final NearbyCommonShareHelper nearbyCommonShareHelper, ShareContentData shareContentData) {
        Utils.INSTANCE.shareModule(nearbyCommonShareHelper.pagerId).doShareAction(9, null, shareContentData, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByWechat$shareToWechat$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleShare: retCode=", intValue, KLog.INSTANCE, "NearbyCommonShareHelper");
                if (intValue == 0) {
                    NearbyCommonShareHelper.this.onSuccess.invoke(3, Boolean.TRUE, null);
                } else {
                    NearbyCommonShareHelper.this.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final String getTmpFileName() {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default("QQ_NEARBY_POSTER_ARK_[TIMESTAMP].png", "[TIMESTAMP]", Utils.INSTANCE.calendarModule(this.pagerId).formatTime(APICallTechReporterKt.NBPCurrentTime()), false, 4, (Object) null);
        return replace$default;
    }

    public final void getWechatShareImage(final NBPThemePosterConfig nBPThemePosterConfig, NearbyFeedPosterData nearbyFeedPosterData, int i3, final Function1<? super String, Unit> function1) {
        if (nearbyFeedPosterData.feedImage == null) {
            if (!(nearbyFeedPosterData.feedFallbackImage.length() > 0)) {
                if (nearbyFeedPosterData.feedTitle.length() > 0) {
                    QQNearbyModule.Companion.getInstance().viewToImage(i3, getTmpFileName(), false, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getWechatShareImage$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(String str) {
                            String str2 = str;
                            if (str2 == null || str2.length() == 0) {
                                KLog.INSTANCE.e("NearbyCommonShareHelper", "save photo failed, path is null");
                                function1.invoke(nBPThemePosterConfig.wxShareImageFallbackUrl);
                            } else {
                                function1.invoke("file://" + str2);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                } else {
                    function1.invoke(nBPThemePosterConfig.wxShareImageFallbackUrl);
                    return;
                }
            }
        }
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getWechatShareImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(String str) {
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    function1.invoke(nBPThemePosterConfig.wxShareImageFallbackUrl);
                } else {
                    function1.invoke(str2);
                }
                return Unit.INSTANCE;
            }
        };
        v vVar = nearbyFeedPosterData.feedImage;
        if (vVar != null) {
            BDHService.INSTANCE.reqDownPhoto(vVar, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$downloadFeedImage$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(String str) {
                    String str2 = str;
                    if (str2.length() > 0) {
                        function12.invoke(str2);
                    } else {
                        function12.invoke(null);
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            function12.invoke(nearbyFeedPosterData.feedFallbackImage);
        }
    }

    public static final void shareByQQZone$shareToQQZone(final NearbyCommonShareHelper nearbyCommonShareHelper, String str, int i3, final int i16, int i17, List<String> list) {
        List<String> list2;
        List<String> emptyList;
        ShareModule shareModule = Utils.INSTANCE.shareModule(nearbyCommonShareHelper.pagerId);
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
        shareModule.doShareAction(3, null, new ShareContentData(i17, null, null, null, list2, null, str, i3, d.b(false), 1646), new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByQQZone$shareToQQZone$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleShare: retCode=", intValue, KLog.INSTANCE, "NearbyCommonShareHelper");
                if (intValue == 0) {
                    NearbyCommonShareHelper.this.onSuccess.invoke(Integer.valueOf(i16), Boolean.TRUE, "\u5206\u4eab\u6210\u529f");
                }
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$shareByQQ(final NearbyCommonShareHelper nearbyCommonShareHelper, final int i3, int i16, final Object obj, final PosterDataHolder posterDataHolder) {
        nearbyCommonShareHelper.viewModel.setPreparing(true);
        final long NBPCurrentTime = APICallTechReporterKt.NBPCurrentTime();
        nearbyCommonShareHelper.viewModel.reportElementClick(1);
        if ((posterDataHolder instanceof NearbyFeedPosterData) && (obj instanceof NBPThemePosterConfig)) {
            String tmpFileName = nearbyCommonShareHelper.getTmpFileName();
            final Function2<w, String, Unit> function2 = new Function2<w, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByQQ$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(w wVar, String str) {
                    c45.e gVar;
                    w wVar2 = wVar;
                    String str2 = str;
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4e0a\u4f20\u56fe\u7247\u8017\u65f6 ");
                    m3.append(APICallTechReporterKt.NBPCurrentTime() - NBPCurrentTime);
                    m3.append("ms");
                    kLog.i("NearbyCommonShareHelper", m3.toString());
                    if (wVar2 == null) {
                        nearbyCommonShareHelper.viewModel.setPreparing(false);
                        nearbyCommonShareHelper.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    } else {
                        if (i3 == 2) {
                            gVar = new j35.c(1, new b(((NearbyFeedPosterData) posterDataHolder).feedId, wVar2), (j35.k) null, (j35.i) null, (j35.a) null, (j) null, 121);
                        } else {
                            gVar = new g(6, new b(((NearbyFeedPosterData) posterDataHolder).feedId, wVar2), null, 4);
                        }
                        NearbyCommonShareHelper nearbyCommonShareHelper2 = nearbyCommonShareHelper;
                        PosterDataHolder<?> posterDataHolder2 = posterDataHolder;
                        Object obj2 = obj;
                        long NBPCurrentTime2 = APICallTechReporterKt.NBPCurrentTime();
                        nearbyCommonShareHelper2.repo.getArkMsg(gVar, new NearbyCommonShareHelper$getArkMsgAndShare$1(NBPCurrentTime2, nearbyCommonShareHelper2, posterDataHolder2, obj2, str2));
                    }
                    return Unit.INSTANCE;
                }
            };
            final long NBPCurrentTime2 = APICallTechReporterKt.NBPCurrentTime();
            QQNearbyModule.Companion.getInstance().viewToImage(i16, tmpFileName, false, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.utils.ShareUtils$uploadViewAsImage$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(String str) {
                    final String str2 = str;
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4fdd\u5b58\u56fe\u7247\u8017\u65f6 ");
                    m3.append(APICallTechReporterKt.NBPCurrentTime() - NBPCurrentTime2);
                    m3.append("ms");
                    kLog.i("NearbyFeedShareHelper", m3.toString());
                    if (str2 == null) {
                        kLog.e(ShareUtils.TAG, "save photo failed, path is null");
                        function2.invoke(null, null);
                    } else {
                        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                        final Function2<w, String, Unit> function22 = function2;
                        companion.uploadImage(str2, new Function1<byte[], Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.utils.ShareUtils$uploadViewAsImage$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(byte[] bArr) {
                                byte[] bArr2 = bArr;
                                if (bArr2 == null) {
                                    KLog.INSTANCE.e(ShareUtils.TAG, "upload photo failed, photoUploadResult is null");
                                    function22.invoke(null, null);
                                } else {
                                    function22.invoke((w) i.b(new w(null, null, 3, null), bArr2), str2);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if ((posterDataHolder instanceof NearbyMiddlePosterData) && (obj instanceof MiddlePageShareConfig)) {
            nearbyCommonShareHelper.repo.getArkMsg(new j35.c(8, (b) null, (j35.k) null, (j35.i) null, (j35.a) null, new j(((NearbyMiddlePosterData) posterDataHolder).poiData), 61), new NearbyCommonShareHelper$getArkMsgAndShare$1(APICallTechReporterKt.NBPCurrentTime(), nearbyCommonShareHelper, posterDataHolder, obj, null));
            return;
        }
        if (posterDataHolder instanceof NearbyMoodPosterData) {
            nearbyCommonShareHelper.repo.getArkMsg(new j35.c(3, (b) null, (j35.k) null, new j35.i(((NearbyMoodPosterData) posterDataHolder).mid, 2), (j35.a) null, (j) null, 109), new NearbyCommonShareHelper$getArkMsgAndShare$1(APICallTechReporterKt.NBPCurrentTime(), nearbyCommonShareHelper, posterDataHolder, obj, null));
            return;
        }
        if (posterDataHolder instanceof NearbyCalendarPosterData) {
            nearbyCommonShareHelper.repo.getArkMsg(new j35.c(5, (b) null, (j35.k) null, (j35.i) null, new j35.a(2, 2), (j) null, 93), new NearbyCommonShareHelper$getArkMsgAndShare$1(APICallTechReporterKt.NBPCurrentTime(), nearbyCommonShareHelper, posterDataHolder, obj, null));
        }
    }

    public static final void access$shareByWechat(final NearbyCommonShareHelper nearbyCommonShareHelper, int i3, final Object obj, final PosterDataHolder posterDataHolder) {
        boolean isBlank;
        nearbyCommonShareHelper.viewModel.setPreparing(true);
        nearbyCommonShareHelper.viewModel.reportElementClick(3);
        if ((posterDataHolder instanceof NearbyFeedPosterData) && (obj instanceof NBPThemePosterConfig)) {
            NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) posterDataHolder;
            final String str = nearbyFeedPosterData.feedTitle;
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (isBlank) {
                str = ((NBPThemePosterConfig) obj).getWxShareTitle(nearbyFeedPosterData.userId);
            }
            nearbyCommonShareHelper.getWechatShareImage((NBPThemePosterConfig) obj, nearbyFeedPosterData, i3, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByWechat$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x002b, code lost:
                
                    r14 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r14);
                 */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(String str2) {
                    List emptyList;
                    String str3 = str2;
                    NearbyCommonShareHelper.this.viewModel.setPreparing(false);
                    DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("shareByWechat: path=", str3, KLog.INSTANCE, "NearbyCommonShareHelper");
                    NearbyCommonShareHelper nearbyCommonShareHelper2 = NearbyCommonShareHelper.this;
                    String str4 = str;
                    String wxShareDesc = ((NBPThemePosterConfig) obj).getWxShareDesc(((NearbyFeedPosterData) posterDataHolder).userId);
                    if (str3 == null || emptyList == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    List list = emptyList;
                    NBPThemePosterConfig nBPThemePosterConfig = (NBPThemePosterConfig) obj;
                    NearbyFeedPosterData nearbyFeedPosterData2 = (NearbyFeedPosterData) posterDataHolder;
                    NearbyCommonShareHelper.shareByWechat$shareToWechat(nearbyCommonShareHelper2, new ShareContentData(0, null, str4, wxShareDesc, list, nBPThemePosterConfig.getWxShareH5Url(nearbyFeedPosterData2.appId, nearbyFeedPosterData2.userId, nearbyFeedPosterData2.feedId), null, 0, d.b(false), 1986));
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if ((posterDataHolder instanceof NearbyMiddlePosterData) && (obj instanceof MiddlePageShareConfig)) {
            MiddlePageShareConfig middlePageShareConfig = (MiddlePageShareConfig) obj;
            shareByWechat$shareToWechat(nearbyCommonShareHelper, new ShareContentData(2, null, middlePageShareConfig.wxShareTitle, middlePageShareConfig.wxShareDesc, null, null, null, i3, d.b(false), 1778));
        } else if (!(posterDataHolder instanceof NearbyMoodPosterData) && !(posterDataHolder instanceof NearbyCalendarPosterData)) {
            nearbyCommonShareHelper.viewModel.setPreparing(false);
            nearbyCommonShareHelper.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        } else {
            shareByWechat$shareToWechat(nearbyCommonShareHelper, new ShareContentData(2, null, null, null, null, null, null, i3, d.b(false), 1790));
        }
    }

    public static final void access$shareByWechatMoment(final NearbyCommonShareHelper nearbyCommonShareHelper, int i3, final Object obj, final PosterDataHolder posterDataHolder) {
        String str;
        String str2;
        boolean isBlank;
        nearbyCommonShareHelper.viewModel.setPreparing(true);
        nearbyCommonShareHelper.viewModel.reportElementClick(4);
        if ((posterDataHolder instanceof NearbyFeedPosterData) && (obj instanceof NBPThemePosterConfig)) {
            NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) posterDataHolder;
            final String str3 = nearbyFeedPosterData.feedTitle;
            isBlank = StringsKt__StringsJVMKt.isBlank(str3);
            if (isBlank) {
                str3 = ((NBPThemePosterConfig) obj).getWxShareTitle(nearbyFeedPosterData.userId);
            }
            nearbyCommonShareHelper.getWechatShareImage((NBPThemePosterConfig) obj, nearbyFeedPosterData, i3, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByWechatMoment$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x0033, code lost:
                
                    r14 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r14);
                 */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(String str4) {
                    List emptyList;
                    String str5 = str4;
                    NearbyCommonShareHelper.this.viewModel.setPreparing(false);
                    DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("shareByWechatMoment: path=", str5, KLog.INSTANCE, "NearbyCommonShareHelper");
                    ShareModule shareModule = Utils.INSTANCE.shareModule(NearbyCommonShareHelper.this.pagerId);
                    String str6 = str3;
                    String wxShareDesc = ((NBPThemePosterConfig) obj).getWxShareDesc(((NearbyFeedPosterData) posterDataHolder).userId);
                    if (str5 == null || emptyList == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    List list = emptyList;
                    NBPThemePosterConfig nBPThemePosterConfig = (NBPThemePosterConfig) obj;
                    NearbyFeedPosterData nearbyFeedPosterData2 = (NearbyFeedPosterData) posterDataHolder;
                    ShareContentData shareContentData = new ShareContentData(0, null, str6, wxShareDesc, list, nBPThemePosterConfig.getWxShareH5Url(nearbyFeedPosterData2.appId, nearbyFeedPosterData2.userId, nearbyFeedPosterData2.feedId), null, 0, d.b(false), 1986);
                    final NearbyCommonShareHelper nearbyCommonShareHelper2 = NearbyCommonShareHelper.this;
                    shareModule.doShareAction(10, null, shareContentData, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByWechatMoment$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Integer num) {
                            int intValue = num.intValue();
                            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("shareByWechatMoment: retCode=", intValue, KLog.INSTANCE, "NearbyCommonShareHelper");
                            if (intValue == 0) {
                                NearbyCommonShareHelper.this.onSuccess.invoke(4, Boolean.TRUE, null);
                            } else {
                                NearbyCommonShareHelper.this.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (!(posterDataHolder instanceof NearbyMiddlePosterData) && !(posterDataHolder instanceof NearbyMoodPosterData) && !(posterDataHolder instanceof NearbyCalendarPosterData)) {
            nearbyCommonShareHelper.viewModel.setPreparing(false);
            nearbyCommonShareHelper.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            return;
        }
        nearbyCommonShareHelper.viewModel.setPreparing(true);
        if (obj instanceof MiddlePageShareConfig) {
            MiddlePageShareConfig middlePageShareConfig = (MiddlePageShareConfig) obj;
            String str4 = middlePageShareConfig.wxShareTitle;
            str2 = middlePageShareConfig.wxShareDesc;
            str = str4;
        } else {
            str = "";
            str2 = str;
        }
        Utils.INSTANCE.shareModule(nearbyCommonShareHelper.pagerId).doShareAction(10, null, new ShareContentData(2, null, str, str2, null, null, null, i3, d.b(false), 1778), new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$shareByWechatMoment$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("shareByWechatMoment: retCode=", intValue, KLog.INSTANCE, "NearbyCommonShareHelper");
                if (intValue == 0) {
                    NearbyCommonShareHelper.this.onSuccess.invoke(4, Boolean.TRUE, null);
                } else {
                    NearbyCommonShareHelper.this.onError.invoke(Boolean.FALSE, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                }
                return Unit.INSTANCE;
            }
        });
    }
}
