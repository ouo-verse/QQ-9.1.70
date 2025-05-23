package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model;

import c01.c;
import c45.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPArticleFeedDetailRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyFeedRepo$fetchFeedDetailInfo$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyFeedsFollowRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyFeedsRcmdRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedTimelineItemViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.i;
import n25.k;
import n25.l;
import o25.f;
import p35.ab;
import p35.n;
import s25.d;
import s35.af;
import v25.o;
import v25.p;

/* loaded from: classes31.dex */
public final class NearbyFDPageViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NearbyFDPageViewModel.class, "mainFeedsCardList", "getMainFeedsCardList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NearbyFDPageViewModel.class, "followFeedsCardList", "getFollowFeedsCardList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NearbyFDPageViewModel.class, "recommList", "getRecommList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPageViewModel.class, "showScrollToNextGuideTips", "getShowScrollToNextGuideTips()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPageViewModel.class, "showMoreActionSheet", "getShowMoreActionSheet()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPageViewModel.class, "navTitle", "getNavTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPageViewModel.class, "isLoadingFollowingFeeds", "isLoadingFollowingFeeds()Z", 0)};
    public String accountId;
    public String cameraPositionRspNotifyRef;
    public String commentNotifyRef;
    public a cookie;
    public l currentSelectFeed;
    public f currentTheme;
    public boolean didShowOtherCityTipBarInFeeds;
    public boolean doFollow;
    public final NearbyFDPageViewModel$dtReporter$1 dtReporter;
    public NearbyFDPUserFeedsCardViewModel firstCardModel;
    public final List<String> firstExtraFeedIds;
    public aa<FooterRefreshView> followingFooterRefreshViewRef;
    public List<v25.a> fromExtraFeeds;
    public v25.a fromFeed;
    public k fromFeedPoi;
    public p fromPerson;
    public l fromStatusFeed;
    public boolean hasLoadAllFollowingFeeds;
    public final Lazy hostUser$delegate;
    public boolean isFistTimeOpenFollowingPage;
    public final ReadWriteProperty isLoadingFollowingFeeds$delegate;
    public int lastDidAppearCardIndex;
    public int lastLocalFeedsIndex;
    public String likeNotifyRef;
    public List<FeedCache> localFeedsFromServe;
    public final ReadWriteProperty navTitle$delegate;
    public boolean needToRemoveFollowingFeeds;
    public boolean pageWillDestroy;
    public int retryRequestMaxTimes;
    public final ReadWriteProperty showMoreActionSheet$delegate;
    public String showOtherCityTipBarForFid;
    public String themeId;
    public final ReadWriteProperty mainFeedsCardList$delegate = c.b();
    public final ReadWriteProperty followFeedsCardList$delegate = c.b();
    public final ReadWriteProperty recommList$delegate = c.b();
    public int fetchingState = 1;

    public static final <T> T initFromData$decodeFromPageDataArray(Object[] objArr, int i3, Function1<? super byte[], ? extends T> function1) {
        Object obj = objArr[i3];
        byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
        byte[] bArr2 = bArr;
        if (bArr == null) {
            bArr2 = new byte[0];
        }
        boolean z16 = bArr2.length == 0;
        Object obj2 = bArr2;
        if (!(!z16)) {
            obj2 = null;
        }
        if (obj2 != null) {
            return function1.invoke(obj2);
        }
        return null;
    }

    public final void fetchFollowList(final Function2<? super String, ? super Boolean, Unit> function2) {
        String str;
        v25.a aVar;
        v25.a aVar2;
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("anchorId:");
        NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel = this.firstCardModel;
        m3.append((nearbyFDPUserFeedsCardViewModel == null || (aVar2 = nearbyFDPUserFeedsCardViewModel.fromFeed) == null) ? null : aVar2.f440824d);
        m3.append(", hasLoadAllFollowingFeeds:");
        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m3, this.hasLoadAllFollowingFeeds, kLog, "feed_detail_page");
        if (this.hasLoadAllFollowingFeeds) {
            AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("hasLoad All Following Feeds: "), this.hasLoadAllFollowingFeeds, kLog, "feed_detail_page");
            function2.invoke("\u5df2\u52a0\u8f7d\u5168\u90e8\u5173\u6ce8\u8005\u5e16\u5b50", Boolean.TRUE);
            return;
        }
        long j3 = UserDataManager.INSTANCE.getUserSelfInfo().tid;
        a aVar3 = this.cookie;
        NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2 = this.firstCardModel;
        if (nearbyFDPUserFeedsCardViewModel2 == null || (aVar = nearbyFDPUserFeedsCardViewModel2.fromFeed) == null || (str = aVar.f440824d) == null) {
            str = "";
        }
        final Function1<ab, Unit> function1 = new Function1<ab, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$fetchFollowList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:37:0x00a5  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x00ba  */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(ab abVar) {
                int i3;
                boolean z16;
                boolean z17;
                boolean z18;
                boolean z19;
                List<n> list;
                ab abVar2 = abVar;
                NearbyFDPageViewModel.this.setLoadingFollowingFeeds();
                String str2 = abVar2 != null ? abVar2.f425118m : null;
                if (abVar2 == null || (list = abVar2.f425113d) == null) {
                    i3 = 0;
                } else {
                    Iterator<n> it = list.iterator();
                    i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        if (Intrinsics.areEqual(it.next().f425193d, str2)) {
                            break;
                        }
                        i3++;
                    }
                }
                if ((abVar2 != null ? abVar2.f425115f : null) != null) {
                    NearbyFDPageViewModel nearbyFDPageViewModel = NearbyFDPageViewModel.this;
                    nearbyFDPageViewModel.cookie = abVar2.f425115f;
                    nearbyFDPageViewModel.hasLoadAllFollowingFeeds = abVar2.f425114e;
                    int i16 = 0;
                    for (Object obj : abVar2.f425113d) {
                        int i17 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        n nVar = (n) obj;
                        l statusFeed = NearbyProUtilsKt.toStatusFeed(nVar);
                        af afVar = nVar.f425194e;
                        if (!(afVar != null && afVar.f433217k0 == 1)) {
                            if (!(afVar != null && afVar.f433217k0 == 3)) {
                                z16 = false;
                                NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel3 = new NearbyFDPUserFeedsCardViewModel(null, null, statusFeed, null, "", true, z16, new NearbyFDPageViewModel$fetchFollowList$1$1$firstCardModel$1(nearbyFDPageViewModel), 11);
                                if (i16 >= i3) {
                                    if (str2 != null) {
                                        if (str2.length() == 0) {
                                            z18 = true;
                                            z19 = true;
                                        } else {
                                            z18 = true;
                                            z19 = false;
                                        }
                                        if (z19 == z18) {
                                            z17 = z18;
                                            if (!z17) {
                                                nearbyFDPageViewModel.getRecommList().add(nearbyFDPUserFeedsCardViewModel3);
                                                i16 = i17;
                                            }
                                        }
                                    }
                                    z17 = false;
                                    if (!z17) {
                                    }
                                }
                                nearbyFDPageViewModel.getFollowFeedsCardList().add(nearbyFDPUserFeedsCardViewModel3);
                                i16 = i17;
                            }
                        }
                        z16 = true;
                        NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel32 = new NearbyFDPUserFeedsCardViewModel(null, null, statusFeed, null, "", true, z16, new NearbyFDPageViewModel$fetchFollowList$1$1$firstCardModel$1(nearbyFDPageViewModel), 11);
                        if (i16 >= i3) {
                        }
                        nearbyFDPageViewModel.getFollowFeedsCardList().add(nearbyFDPUserFeedsCardViewModel32);
                        i16 = i17;
                    }
                    KLog kLog2 = KLog.INSTANCE;
                    NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("followFeedsCardList.size:");
                    m16.append(NearbyFDPageViewModel.this.getFollowFeedsCardList().size());
                    m16.append(", recommend List.size:");
                    m16.append(NearbyFDPageViewModel.this.getRecommList().size());
                    kLog2.i("feed_detail_page", m16.toString());
                    if (NearbyFDPageViewModel.this.getFollowFeedsCardList().size() == 0) {
                        function2.invoke("\u60a8\u8fd8\u6ca1\u6709\u5173\u6ce8\u7684\u4eba\u7684\u52a8\u6001", Boolean.FALSE);
                    } else {
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFollowList success, size:");
                        m17.append(abVar2.f425113d.size());
                        kLog2.i("feed_detail_page", m17.toString());
                        Function2<String, Boolean, Unit> function22 = function2;
                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u83b7\u53d6\u6210\u529f size:");
                        m18.append(abVar2.f425113d.size());
                        function22.invoke(m18.toString(), Boolean.TRUE);
                    }
                } else {
                    function2.invoke("\u83b7\u53d6\u5931\u8d25", Boolean.FALSE);
                }
                return Unit.INSTANCE;
            }
        };
        kLog.e("feed_detail_page", "start requestNearbyFeedsFollowed tid:" + j3);
        NearbyFeedsFollowRequest nearbyFeedsFollowRequest = new NearbyFeedsFollowRequest(String.valueOf(j3), aVar3, str);
        Function1<PbResponse<ab>, Unit> function12 = new Function1<PbResponse<ab>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbySsoNearbyFeedsRcmdModel$Companion$requestNearbyFeedsFollowed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<ab> pbResponse) {
                PbResponse<ab> pbResponse2 = pbResponse;
                if (pbResponse2.success) {
                    KLog kLog2 = KLog.INSTANCE;
                    NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                    kLog2.e("feed_detail_page", "requestNearbyFeedsFollowed success");
                } else {
                    KLog kLog3 = KLog.INSTANCE;
                    NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestNearbyFeedsFollowed failure code:");
                    m16.append(pbResponse2.code);
                    m16.append(", message:");
                    m16.append(pbResponse2.f114187msg);
                    m16.append('}');
                    kLog3.e("feed_detail_page", m16.toString());
                }
                function1.invoke(pbResponse2.rsp);
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.feed_svr.StatusRead.SsoGetUserFollowList");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(nearbyFeedsFollowRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
    }

    public final void followingFootRefresh() {
        if (this.hasLoadAllFollowingFeeds && getFollowFeedsCardList().size() < 4) {
            setLoadingFollowingFeeds();
            fetchFeedsFromServerForCache$default(this, true, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$followingFootRefresh$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, Boolean bool2) {
                    FooterRefreshView b16;
                    FooterRefreshView b17;
                    boolean booleanValue = bool.booleanValue();
                    if (!bool2.booleanValue()) {
                        final NearbyFDPageViewModel nearbyFDPageViewModel = NearbyFDPageViewModel.this;
                        TimerKt.d(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$followingFootRefresh$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                FooterRefreshView b18;
                                KLog kLog = KLog.INSTANCE;
                                NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                kLog.e("feed_detail_page", "load next following feeds failed");
                                aa<FooterRefreshView> aaVar = NearbyFDPageViewModel.this.followingFooterRefreshViewRef;
                                if (aaVar != null && (b18 = aaVar.b()) != null) {
                                    b18.t(FooterRefreshEndState.FAILURE);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    } else if (!booleanValue) {
                        KLog kLog = KLog.INSTANCE;
                        NearbyConst nearbyConst = NearbyConst.INSTANCE;
                        kLog.i("feed_detail_page", "there is no more following feeds data");
                        aa<FooterRefreshView> aaVar = NearbyFDPageViewModel.this.followingFooterRefreshViewRef;
                        if (aaVar != null && (b17 = aaVar.b()) != null) {
                            b17.t(FooterRefreshEndState.NONE_MORE_DATA);
                        }
                    } else {
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                        kLog2.i("feed_detail_page", "load next following feeds success");
                        aa<FooterRefreshView> aaVar2 = NearbyFDPageViewModel.this.followingFooterRefreshViewRef;
                        if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                            b16.t(FooterRefreshEndState.SUCCESS);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, 1);
        } else {
            fetchFollowList(new Function2<String, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$followingFootRefresh$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(String str, Boolean bool) {
                    FooterRefreshView b16;
                    FooterRefreshView b17;
                    String str2 = str;
                    boolean booleanValue = bool.booleanValue();
                    NearbyFDPageViewModel.this.setLoadingFollowingFeeds();
                    if (booleanValue) {
                        KLog kLog = KLog.INSTANCE;
                        NearbyConst nearbyConst = NearbyConst.INSTANCE;
                        kLog.i("feed_detail_page", "fetchFollowList feeds success");
                        aa<FooterRefreshView> aaVar = NearbyFDPageViewModel.this.followingFooterRefreshViewRef;
                        if (aaVar != null && (b17 = aaVar.b()) != null) {
                            b17.t(FooterRefreshEndState.SUCCESS);
                        }
                    } else {
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("there is no more recommend feeds data. resultText:", str2, kLog2, "feed_detail_page");
                        aa<FooterRefreshView> aaVar2 = NearbyFDPageViewModel.this.followingFooterRefreshViewRef;
                        if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                            b16.t(FooterRefreshEndState.NONE_MORE_DATA);
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final e getDTPageParam(boolean z16) {
        String str;
        String str2;
        l lVar;
        l lVar2;
        r25.e eVar;
        v25.a aVar;
        v25.a aVar2;
        if (!z16) {
            e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
            nearbyDTBaseParams.v("dt_pgid", "pg_nearby_feed_aggregation");
            QQNearbyModule.UserInfo hostUser = getHostUser();
            Object obj = "";
            if (hostUser == null || (str = hostUser.tid) == null) {
                str = "";
            }
            nearbyDTBaseParams.v("nearby_view_tiny_id", str);
            NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel = this.firstCardModel;
            if ((nearbyFDPUserFeedsCardViewModel == null || (aVar2 = nearbyFDPUserFeedsCardViewModel.fromFeed) == null || (str2 = aVar2.f440824d) == null) && (nearbyFDPUserFeedsCardViewModel == null || (lVar = nearbyFDPUserFeedsCardViewModel.fromStatusFeed) == null || (str2 = lVar.f418092d) == null)) {
                str2 = "";
            }
            nearbyDTBaseParams.v("nearby_feed_id", str2);
            NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2 = this.firstCardModel;
            if (nearbyFDPUserFeedsCardViewModel2 != null && (aVar = nearbyFDPUserFeedsCardViewModel2.fromFeed) != null) {
                obj = Long.valueOf(aVar.f440825e);
            } else if (nearbyFDPUserFeedsCardViewModel2 != null && (lVar2 = nearbyFDPUserFeedsCardViewModel2.fromStatusFeed) != null && (eVar = lVar2.f418093e) != null) {
                obj = Long.valueOf(eVar.f430610d);
            }
            nearbyDTBaseParams.v("nearby_publish_tiny_id", obj.toString());
            return nearbyDTBaseParams;
        }
        e nearbyDTBaseParams2 = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams2.v("dt_pgid", "pg_nearby_feed_focus");
        return nearbyDTBaseParams2;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel> getFollowFeedsCardList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.followFeedsCardList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final QQNearbyModule.UserInfo getHostUser() {
        return (QQNearbyModule.UserInfo) this.hostUser$delegate.getValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel> getMainFeedsCardList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.mainFeedsCardList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel> getRecommList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.recommList$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void onFeedActionSheetShow(l lVar) {
        this.currentSelectFeed = lVar;
        this.showMoreActionSheet$delegate.setValue(this, $$delegatedProperties[4], Boolean.TRUE);
    }

    public final void setLoadingFollowingFeeds() {
        this.isLoadingFollowingFeeds$delegate.setValue(this, $$delegatedProperties[6], Boolean.FALSE);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$dtReporter$1] */
    public NearbyFDPageViewModel() {
        Lazy lazy;
        Boolean bool = Boolean.FALSE;
        c.a(bool);
        this.localFeedsFromServe = new ArrayList();
        this.lastLocalFeedsIndex = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQNearbyModule.UserInfo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$hostUser$2
            @Override // kotlin.jvm.functions.Function0
            public final QQNearbyModule.UserInfo invoke() {
                return QQNearbyModule.Companion.getInstance().getUserInfo();
            }
        });
        this.hostUser$delegate = lazy;
        this.accountId = "";
        this.doFollow = true;
        this.firstExtraFeedIds = new ArrayList();
        this.themeId = "";
        this.currentTheme = new f(null, null, null, null, null, null, null, null, null, null, false, false, 0, 0, false, null, null, 0, 262143, null);
        this.showMoreActionSheet$delegate = c.a(bool);
        this.navTitle$delegate = c.a("\u9644\u8fd1\u5e7f\u573a");
        this.retryRequestMaxTimes = 3;
        this.showOtherCityTipBarForFid = "";
        this.cookie = a.f30290b;
        this.isFistTimeOpenFollowingPage = true;
        this.isLoadingFollowingFeeds$delegate = c.a(Boolean.TRUE);
        this.dtReporter = new INearbyFeedDetailDTReporter() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$dtReporter$1
            @Override // com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter
            public final void dtReportElementClick(String str, String str2, String str3, boolean z16) {
                e dTPageParam = NearbyFDPageViewModel.this.getDTPageParam(z16);
                NearbyFDPageViewModel nearbyFDPageViewModel = NearbyFDPageViewModel.this;
                dTPageParam.v("dt_eid", str3);
                dTPageParam.v("nearby_feed_id", str);
                dTPageParam.v("nearby_publish_tiny_id", str2);
                dTPageParam.v("cur_pg", nearbyFDPageViewModel.getDTPageParam(false));
                dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
            }

            @Override // com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter
            public final void dtReportElementImp(String str, String str2, String str3, boolean z16) {
                e dTPageParam = NearbyFDPageViewModel.this.getDTPageParam(z16);
                NearbyFDPageViewModel nearbyFDPageViewModel = NearbyFDPageViewModel.this;
                dTPageParam.v("dt_eid", str3);
                dTPageParam.v("nearby_feed_id", str);
                dTPageParam.v("nearby_publish_tiny_id", str2);
                dTPageParam.v("cur_pg", nearbyFDPageViewModel.getDTPageParam(false));
                dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTPageParam);
            }

            @Override // com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter
            public final void dtReportNavElementClick(String str, boolean z16) {
                e dTPageParam = NearbyFDPageViewModel.this.getDTPageParam(z16);
                NearbyFDPageViewModel nearbyFDPageViewModel = NearbyFDPageViewModel.this;
                dTPageParam.v("dt_eid", str);
                dTPageParam.v("cur_pg", nearbyFDPageViewModel.getDTPageParam(z16));
                dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTPageParam);
            }
        };
    }

    public final void dtReportPageExposure(boolean z16, boolean z17) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e dTPageParam = getDTPageParam(z17);
        dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, dTPageParam);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x012a, code lost:
    
        if (r12 == false) goto L176;
     */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache>, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean access$handleGenNearRspData(NearbyFDPageViewModel nearbyFDPageViewModel, boolean z16, o oVar, boolean z17) {
        String str;
        String str2;
        int collectionSizeOrDefault;
        boolean z18;
        NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel;
        NearbyFDPUserFeedTimelineItemViewModel contentModel;
        NearbyFDPUserFeedTimelineItemViewModel contentModel2;
        nearbyFDPageViewModel.getClass();
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        StringBuilder m3 = NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(oVar.f440877h, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleGenNearRspData rsp status feeds count "), " feedids:");
        Iterator<T> it = oVar.f440877h.iterator();
        String str3 = "";
        while (it.hasNext()) {
            str3 = LoadFailParams$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(str3), ((l) it.next()).f418092d, QbAddrData.DATA_SPLITER);
        }
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, str3, kLog, "feed_detail_page");
        if (z17) {
            Iterator<T> it5 = oVar.f440877h.iterator();
            while (it5.hasNext()) {
                nearbyFDPageViewModel.getRecommList().add(new NearbyFDPUserFeedsCardViewModel(null, null, (l) it5.next(), null, "", true, false, new NearbyFDPageViewModel$handleGenNearRspData$1$firstCardModel$1(nearbyFDPageViewModel), 11));
            }
        }
        NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2 = nearbyFDPageViewModel.firstCardModel;
        if (nearbyFDPUserFeedsCardViewModel2 == null || (contentModel2 = nearbyFDPUserFeedsCardViewModel2.getContentModel()) == null || (str = contentModel2.getFid()) == null) {
            str = "";
        }
        if (!z16) {
            if (oVar.f440877h.isEmpty()) {
                return false;
            }
            nearbyFDPageViewModel.localFeedsFromServe.clear();
            str = "";
        }
        QQNearbyModule.UserInfo hostUser = nearbyFDPageViewModel.getHostUser();
        if (hostUser == null || (str2 = hostUser.tid) == null) {
            str2 = "";
        }
        l lVar = oVar.f440878i;
        if (lVar != null && (nearbyFDPUserFeedsCardViewModel = nearbyFDPageViewModel.firstCardModel) != null && (contentModel = nearbyFDPUserFeedsCardViewModel.getContentModel()) != null) {
            contentModel.statusFeed = lVar;
            contentModel.feed = null;
            contentModel.refreshData();
        }
        List<l> list = oVar.f440877h;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it6 = list.iterator();
        while (true) {
            boolean z19 = true;
            if (!it6.hasNext()) {
                break;
            }
            Object next = it6.next();
            l lVar2 = (l) next;
            r25.e eVar = lVar2.f418093e;
            if (!Intrinsics.areEqual(str2, String.valueOf(eVar != null ? Long.valueOf(eVar.f430610d) : null)) && !Intrinsics.areEqual(lVar2.f418092d, str)) {
                String str4 = lVar2.f418092d;
                Iterator it7 = nearbyFDPageViewModel.localFeedsFromServe.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        z18 = false;
                        break;
                    }
                    if (Intrinsics.areEqual(((FeedCache) it7.next()).feedId, str4)) {
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                        kLog2.e("feed_detail_page", "containFeedIdInLocalFeedsFromServe with fid : " + str4);
                        z18 = true;
                        break;
                    }
                }
            }
            z19 = false;
            if (z19) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it8 = arrayList.iterator();
        while (it8.hasNext()) {
            Object next2 = it8.next();
            if (((nearbyFDPageViewModel.firstExtraFeedIds.isEmpty() ^ true) && nearbyFDPageViewModel.firstExtraFeedIds.contains(((l) next2).f418092d)) ? false : true) {
                arrayList2.add(next2);
            }
        }
        ?? r65 = nearbyFDPageViewModel.localFeedsFromServe;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it9 = arrayList2.iterator();
        while (it9.hasNext()) {
            l lVar3 = (l) it9.next();
            arrayList3.add(new FeedCache(lVar3.f418092d, lVar3, null));
        }
        r65.addAll(arrayList3);
        if ((!oVar.f440877h.isEmpty()) && arrayList2.isEmpty()) {
            int i3 = nearbyFDPageViewModel.retryRequestMaxTimes - 1;
            nearbyFDPageViewModel.retryRequestMaxTimes = i3;
            return i3 > 0;
        }
        if (!arrayList2.isEmpty()) {
            nearbyFDPageViewModel.retryRequestMaxTimes = 3;
        }
        if (oVar.f440879m) {
            if (nearbyFDPageViewModel.showOtherCityTipBarForFid.length() == 0) {
                String str5 = oVar.C;
                nearbyFDPageViewModel.showOtherCityTipBarForFid = str5 != null ? str5 : "";
                KLog kLog3 = KLog.INSTANCE;
                NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("showOtherCityTipBarForFid:");
                m16.append(nearbyFDPageViewModel.showOtherCityTipBarForFid);
                kLog3.e("feed_detail_page", m16.toString());
            }
        }
        return !arrayList2.isEmpty();
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache>, java.util.ArrayList] */
    public final void loadNextFeedsListFromLocalForDisplay(Function2<? super Boolean, ? super Boolean, Unit> function2) {
        int lastIndex;
        int lastIndex2;
        int lastIndex3;
        final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel;
        int lastIndex4;
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("call loadNextFeedsListFromLocalForDisplay in current feeds size:");
        m3.append(this.localFeedsFromServe.size());
        kLog.i("feed_detail_page", m3.toString());
        if (this.fetchingState == 2) {
            return;
        }
        int i3 = this.lastLocalFeedsIndex + 1;
        if (!this.localFeedsFromServe.isEmpty()) {
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(this.localFeedsFromServe);
            if (i3 <= lastIndex2) {
                for (int i16 = 0; i16 < 3; i16++) {
                    int i17 = i3 + i16;
                    lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(this.localFeedsFromServe);
                    if (i17 > lastIndex3) {
                        break;
                    }
                    FeedCache feedCache = (FeedCache) this.localFeedsFromServe.get(i17);
                    this.lastLocalFeedsIndex = i17;
                    if (feedCache.feedFromServer != null) {
                        nearbyFDPUserFeedsCardViewModel = new NearbyFDPUserFeedsCardViewModel(null, null, feedCache.feedFromServer, getHostUser(), this.themeId, false, false, new NearbyFDPageViewModel$loadNextFeedsListFromLocalForDisplay$cardViewModel$1(this), 99);
                    } else if (feedCache.feedFromExtra != null) {
                        nearbyFDPUserFeedsCardViewModel = new NearbyFDPUserFeedsCardViewModel(null, feedCache.feedFromExtra, null, getHostUser(), this.themeId, false, false, new NearbyFDPageViewModel$loadNextFeedsListFromLocalForDisplay$cardViewModel$vm$1(this), 96);
                        TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$loadNextFeedsListFromLocalForDisplay$cardViewModel$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                final NearbyFDPageViewModel nearbyFDPageViewModel = NearbyFDPageViewModel.this;
                                final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2 = nearbyFDPUserFeedsCardViewModel;
                                nearbyFDPageViewModel.getClass();
                                final v25.a aVar = nearbyFDPUserFeedsCardViewModel2.fromFeed;
                                if (aVar != null) {
                                    String str = aVar.f440824d;
                                    Function2<d, Integer, Unit> function22 = new Function2<d, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$loadExtraFeedsData$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(d dVar, Integer num) {
                                            d dVar2 = dVar;
                                            int intValue = num.intValue();
                                            l lVar = dVar2 != null ? dVar2.f433131d : null;
                                            if (lVar == null) {
                                                KLog kLog2 = KLog.INSTANCE;
                                                NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadFirstExtraFeedsData failed fid=");
                                                m16.append(v25.a.this.f440824d);
                                                m16.append(" code=");
                                                m16.append(intValue);
                                                kLog2.d("feed_detail_page", m16.toString());
                                                com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel> mainFeedsCardList = nearbyFDPageViewModel.getMainFeedsCardList();
                                                final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel3 = nearbyFDPUserFeedsCardViewModel2;
                                                CollectionsKt__MutableCollectionsKt.removeAll((List) mainFeedsCardList, (Function1) new Function1<NearbyFDPUserFeedsCardViewModel, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$loadExtraFeedsData$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Boolean invoke(NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel4) {
                                                        return Boolean.valueOf(Intrinsics.areEqual(nearbyFDPUserFeedsCardViewModel4, NearbyFDPUserFeedsCardViewModel.this));
                                                    }
                                                });
                                            } else {
                                                KLog kLog3 = KLog.INSTANCE;
                                                NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                                                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadFirstExtraFeedsData success fid="), v25.a.this.f440824d, kLog3, "feed_detail_page");
                                                NearbyFDPUserFeedTimelineItemViewModel contentModel = nearbyFDPUserFeedsCardViewModel2.getContentModel();
                                                if (contentModel != null) {
                                                    contentModel.statusFeed = lVar;
                                                    contentModel.feed = null;
                                                    contentModel.refreshData();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    KLog.INSTANCE.i("NearbyFeedRepo", "fetchFeedDetailInfo: " + str);
                                    NBPArticleFeedDetailRequest nBPArticleFeedDetailRequest = new NBPArticleFeedDetailRequest(str);
                                    NearbyFeedRepo$fetchFeedDetailInfo$1 nearbyFeedRepo$fetchFeedDetailInfo$1 = new NearbyFeedRepo$fetchFeedDetailInfo$1(function22);
                                    APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.feed_svr.StatusRead.SsoGetStatusDetail");
                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPArticleFeedDetailRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nearbyFeedRepo$fetchFeedDetailInfo$1), 6);
                                }
                                return Unit.INSTANCE;
                            }
                        }, 1, null);
                    }
                    if (!this.didShowOtherCityTipBarInFeeds) {
                        if ((feedCache.feedId.length() > 0) && Intrinsics.areEqual(this.showOtherCityTipBarForFid, feedCache.feedId)) {
                            nearbyFDPUserFeedsCardViewModel.showOtherCityTipBar$delegate.setValue(nearbyFDPUserFeedsCardViewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[4], Boolean.TRUE);
                            this.didShowOtherCityTipBarInFeeds = true;
                            KLog kLog2 = KLog.INSTANCE;
                            NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("did set show other city tip bar:");
                            m16.append(this.showOtherCityTipBarForFid);
                            kLog2.e("feed_detail_page", m16.toString());
                        }
                    }
                    lastIndex4 = CollectionsKt__CollectionsKt.getLastIndex(getMainFeedsCardList());
                    nearbyFDPUserFeedsCardViewModel.index = lastIndex4 + 1;
                    getMainFeedsCardList().add(nearbyFDPUserFeedsCardViewModel);
                    KLog kLog3 = KLog.INSTANCE;
                    NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("did insert next feed:");
                    m17.append(feedCache.feedId);
                    m17.append("  lastLocalFeedsIndex:");
                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m17, this.lastLocalFeedsIndex, kLog3, "feed_detail_page");
                }
            }
        }
        int i18 = this.lastLocalFeedsIndex;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.localFeedsFromServe);
        boolean z16 = i18 >= lastIndex - 2;
        if (function2 != null) {
            function2.invoke(Boolean.TRUE, Boolean.valueOf(z16));
        }
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache>, java.util.ArrayList] */
    public static void fetchFeedsFromServerForCache$default(NearbyFDPageViewModel nearbyFDPageViewModel, boolean z16, Function2 function2, int i3) {
        k kVar;
        double d16;
        double d17;
        String str;
        List emptyList;
        Float f16;
        Float f17;
        l lVar;
        final boolean z17 = (i3 & 1) != 0;
        final boolean z18 = (i3 & 2) != 0 ? false : z16;
        final Function2 function22 = (i3 & 4) != 0 ? null : function2;
        NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel = nearbyFDPageViewModel.firstCardModel;
        NearbyFDPUserFeedTimelineItemViewModel contentModel = nearbyFDPUserFeedsCardViewModel != null ? nearbyFDPUserFeedsCardViewModel.getContentModel() : null;
        nearbyFDPageViewModel.fetchingState = 2;
        k kVar2 = (contentModel == null || (lVar = contentModel.statusFeed) == null) ? null : lVar.C;
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("call fetchFeedsFromServerForCache in current feeds size:");
        m3.append(nearbyFDPageViewModel.localFeedsFromServe.size());
        m3.append("fromFeedPoi: ");
        k kVar3 = nearbyFDPageViewModel.fromFeedPoi;
        m3.append(kVar3 != null ? kVar3.f418087e : null);
        m3.append(", feedPoiInfo: ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, kVar2 != null ? kVar2.f418087e : null, kLog, "feed_detail_page");
        k kVar4 = nearbyFDPageViewModel.fromFeedPoi;
        if (kVar4 == null) {
            if (kVar2 == null) {
                NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                NBPLatLng nBPLatLng = userSelfInfo.latLng;
                double d18 = 1000000;
                i iVar = new i((long) (nBPLatLng.latitude * d18), (long) (nBPLatLng.longitude * d18), 12);
                String str2 = userSelfInfo.locationAddress;
                String str3 = userSelfInfo.locationCountry;
                String str4 = userSelfInfo.locationProvince;
                String str5 = userSelfInfo.locationCity;
                String str6 = userSelfInfo.locationDistrict;
                String str7 = userSelfInfo.locationName;
                kVar2 = new k((String) null, str7, 0, (String) null, str2, 0, iVar, 0, 0, (String) null, str3, str4, str5, 0, 0, (String) null, str6, (String) null, (String) null, str7, 1500077);
            }
            kVar = kVar2;
        } else {
            kVar = kVar4;
        }
        if (contentModel != null && (f17 = (Float) contentModel.latitude$delegate.getValue(contentModel, NearbyFDPUserFeedTimelineItemViewModel.$$delegatedProperties[1])) != null) {
            d16 = f17.floatValue();
        } else {
            d16 = UserDataManager.INSTANCE.getUserSelfInfo().latLng.latitude;
        }
        if (contentModel != null && (f16 = (Float) contentModel.longitude$delegate.getValue(contentModel, NearbyFDPUserFeedTimelineItemViewModel.$$delegatedProperties[0])) != null) {
            d17 = f16.floatValue();
        } else {
            d17 = UserDataManager.INSTANCE.getUserSelfInfo().latLng.longitude;
        }
        String str8 = nearbyFDPageViewModel.themeId;
        if (contentModel == null || (str = contentModel.getFid()) == null) {
            str = "";
        }
        String str9 = str;
        final Function1<o, Unit> function1 = new Function1<o, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$fetchFeedsFromServerForCache$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(o oVar) {
                o oVar2 = oVar;
                NearbyFDPageViewModel nearbyFDPageViewModel2 = NearbyFDPageViewModel.this;
                if (!nearbyFDPageViewModel2.pageWillDestroy) {
                    if (oVar2 != null) {
                        boolean access$handleGenNearRspData = NearbyFDPageViewModel.access$handleGenNearRspData(nearbyFDPageViewModel2, z17, oVar2, z18);
                        NearbyFDPageViewModel.this.fetchingState = 3;
                        Function2<Boolean, Boolean, Unit> function23 = function22;
                        if (function23 != null) {
                            function23.invoke(Boolean.valueOf(access$handleGenNearRspData), Boolean.TRUE);
                        }
                    } else {
                        nearbyFDPageViewModel2.fetchingState = 4;
                        Function2<Boolean, Boolean, Unit> function24 = function22;
                        if (function24 != null) {
                            function24.invoke(Boolean.TRUE, Boolean.FALSE);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        kLog.i("feed_detail_page", "start requestNearbyFeedsRcmd latitude :" + d16 + ", longitude" + d17 + ", mapThemeId:" + str8);
        NearbyFeedsRcmdRequest nearbyFeedsRcmdRequest = new NearbyFeedsRcmdRequest((float) d16, (float) d17, kVar, str8, str9, emptyList);
        Function1<PbResponse<o>, Unit> function12 = new Function1<PbResponse<o>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbySsoNearbyFeedsRcmdModel$Companion$requestNearbyFeedsRcmd$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<o> pbResponse) {
                List<v25.a> list;
                PbResponse<o> pbResponse2 = pbResponse;
                if (pbResponse2.success) {
                    KLog kLog2 = KLog.INSTANCE;
                    NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestNearbyFeedsRcmd success feedSize:");
                    o oVar = pbResponse2.rsp;
                    m16.append((oVar == null || (list = oVar.f440876f) == null) ? null : Integer.valueOf(list.size()));
                    m16.append(" isOtherCity:");
                    o oVar2 = pbResponse2.rsp;
                    AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m16, oVar2 != null ? oVar2.f440879m : false, kLog2, "feed_detail_page");
                } else {
                    KLog kLog3 = KLog.INSTANCE;
                    NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestNearbyFeedsRcmd failure code:");
                    m17.append(pbResponse2.code);
                    m17.append(", message:");
                    m17.append(pbResponse2.f114187msg);
                    m17.append('}');
                    kLog3.e("feed_detail_page", m17.toString());
                }
                function1.invoke(pbResponse2.rsp);
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoNearbyFeedsRcmd");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(nearbyFeedsRcmdRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
    }
}
