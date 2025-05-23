package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model;

import c01.c;
import c45.a;
import c45.i;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyFollowRepo$setFollowState$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TacitKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$fetchFollowData$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$fetchTacitList$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.MemoryCacheModule;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import org.slf4j.Marker;
import p35.aa;
import p35.ab;
import p35.ac;
import p35.n;
import s35.af;
import s35.d;
import s35.j;
import s35.k;
import s35.p;
import s35.q;
import s35.w;
import s35.x;
import s35.y;
import s35.z;
import u35.b;

/* loaded from: classes31.dex */
public class NBPHomePageBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "tagsExpanded", "getTagsExpanded()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "tagViewLines", "getTagViewLines()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, ITVKPlayerEventListener.KEY_USER_INFO, "getUserInfo()Lkuikly/com/tencent/trpcprotocol/qqstranger/common/qqstranger_user_info/UserInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "userInfoState", "getUserInfoState()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/view_model/FetchStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "tacitState", "getTacitState()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/view_model/FetchStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "tacitMyList", "getTacitMyList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "tacitAllMyList", "getTacitAllMyList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "tacitGuestList", "getTacitGuestList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "tacitGuestTitle", "getTacitGuestTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "tagList", "getTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "feedList", "getFeedList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "feedState", "getFeedState()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/view_model/FetchStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "likedFeedList", "getLikedFeedList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "likedFeedState", "getLikedFeedState()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/view_model/FetchStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "likesOnlySelf", "getLikesOnlySelf()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "followState", "getFollowState()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/view_model/FollowStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "followOnlySelf", "getFollowOnlySelf()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "totalFansCount", "getTotalFansCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "totalFollowsCount", "getTotalFollowsCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomePageBaseViewModel.class, "isLoadingFansCount", "isLoadingFansCount()Z", 0)};
    public static final Companion Companion = new Companion();
    public static final FastClickUtils fastClickUtils = new FastClickUtils(500);
    public final int accountType;
    public int calculateProgressCount;
    public final FastClickUtils fastClickUtils$1;
    public final ReadWriteProperty feedList$delegate;
    public final ReadWriteProperty feedState$delegate;
    public final ReadWriteProperty followOnlySelf$delegate;
    public final ReadWriteProperty followState$delegate;
    public boolean hasJumpTacitH5;
    public boolean isCurrentLikedPage;
    public boolean isFirstEntry;
    public final ReadWriteProperty isLoadingFansCount$delegate;
    public boolean isLoadingLikedFeeds;
    public final boolean isModal;
    public boolean isScrolling;
    public boolean isSelf;
    public a likedAttachInfo;
    public final ReadWriteProperty likedFeedList$delegate;
    public final ReadWriteProperty likedFeedState$delegate;
    public final ReadWriteProperty likesOnlySelf$delegate;
    public CacheDiskLru lruCache;
    public a mAttachInfo;
    public float pageViewWidth;
    public final List<n> pendingFeedList;
    public a roundParam;
    public final ReadWriteProperty tacitAllMyList$delegate;
    public int tacitAllMyListSize;
    public final ReadWriteProperty tacitGuestList$delegate;
    public final ReadWriteProperty tacitGuestTitle$delegate;
    public int tacitListTodaySize;
    public final ReadWriteProperty tacitMyList$delegate;
    public final ReadWriteProperty tacitState$delegate;
    public final ReadWriteProperty tagList$delegate;
    public final ReadWriteProperty tagViewLines$delegate;
    public final ReadWriteProperty tagsExpanded$delegate;
    public final ReadWriteProperty totalFansCount$delegate;
    public final ReadWriteProperty totalFollowsCount$delegate;
    public final ReadWriteProperty userInfo$delegate;
    public final ReadWriteProperty userInfoState$delegate;
    public String accountId = "";
    public String sourceId = "";
    public String traceId = "";
    public String fromId = "";

    public NBPHomePageBaseViewModel(boolean z16) {
        this.isModal = z16;
        Boolean bool = Boolean.FALSE;
        this.tagsExpanded$delegate = c.a(bool);
        this.tagViewLines$delegate = c.a(0);
        this.userInfo$delegate = c.a(null);
        FetchStatus fetchStatus = FetchStatus.NULL_STATE;
        this.userInfoState$delegate = c.a(fetchStatus);
        this.tacitState$delegate = c.a(fetchStatus);
        this.tacitMyList$delegate = c.b();
        this.tacitAllMyList$delegate = c.b();
        this.tacitGuestList$delegate = c.b();
        this.tacitGuestTitle$delegate = c.a("");
        this.tagList$delegate = c.b();
        this.pageViewWidth = 375.0f;
        this.feedList$delegate = c.b();
        this.feedState$delegate = c.a(fetchStatus);
        this.pendingFeedList = new ArrayList();
        a aVar = a.f30290b;
        this.mAttachInfo = aVar;
        this.lruCache = new CacheDiskLru(1);
        this.likedFeedList$delegate = c.b();
        this.likedFeedState$delegate = c.a(fetchStatus);
        this.likedAttachInfo = aVar;
        this.likesOnlySelf$delegate = c.a(bool);
        this.followState$delegate = c.a(FollowStatus.NO_FOLLOWED);
        this.followOnlySelf$delegate = c.a(bool);
        this.totalFansCount$delegate = c.a(0);
        this.totalFollowsCount$delegate = c.a(0);
        this.roundParam = aVar;
        this.isLoadingFansCount$delegate = c.a(Boolean.TRUE);
        this.accountType = 2;
        this.fastClickUtils$1 = new FastClickUtils(500L);
    }

    public static final void access$fetchMyAllTacitList(final NBPHomePageBaseViewModel nBPHomePageBaseViewModel) {
        if (nBPHomePageBaseViewModel.isSelf) {
            final int appId = nBPHomePageBaseViewModel.getAppId();
            int accountType = nBPHomePageBaseViewModel.getAccountType();
            final Function1<q, Unit> function1 = new Function1<q, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchMyAllTacitList$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(q qVar) {
                    int collectionSizeOrDefault;
                    NBPHomePageBaseViewModel.access$getTacitAllMyList(NBPHomePageBaseViewModel.this).clear();
                    com.tencent.kuikly.core.reactive.collection.c access$getTacitAllMyList = NBPHomePageBaseViewModel.access$getTacitAllMyList(NBPHomePageBaseViewModel.this);
                    List<z> list = qVar.f433261f;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((z) obj).C != 2) {
                            arrayList.add(obj);
                        }
                    }
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(TacitKt.toTacit((z) it.next()));
                    }
                    access$getTacitAllMyList.addAll(arrayList2);
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel2.tacitAllMyListSize = NBPHomePageBaseViewModel.access$getTacitAllMyList(nBPHomePageBaseViewModel2).size();
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchTacitListHistory size: ");
                    m3.append(NBPHomePageBaseViewModel.access$getTacitAllMyList(NBPHomePageBaseViewModel.this).size());
                    kLog.i("NBPHomePageBaseViewModel", m3.toString());
                    return Unit.INSTANCE;
                }
            };
            final NBPHomePageBaseViewModel$fetchMyAllTacitList$2 nBPHomePageBaseViewModel$fetchMyAllTacitList$2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchMyAllTacitList$2
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str) {
                    KLog.INSTANCE.e("NBPHomePageBaseViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("fetchTacitListHistory fail code: ", num.intValue(), ", msg: ", str));
                    return Unit.INSTANCE;
                }
            };
            p pVar = new p(accountType, 0, 50);
            Function1<PbResponse<b>, Unit> function12 = new Function1<PbResponse<b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$fetchTacitListHistory$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(PbResponse<b> pbResponse) {
                    PbResponse<b> pbResponse2 = pbResponse;
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchTacitListHistory: appId:");
                    m3.append(appId);
                    m3.append(", proxy retcode:");
                    m3.append(pbResponse2.code);
                    m3.append(" rsp return code:");
                    b bVar = pbResponse2.rsp;
                    NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NBPNewHomeRepository");
                    if (pbResponse2.success && pbResponse2.rsp != null) {
                        try {
                            Function1<q, Unit> function13 = function1;
                            q qVar = new q(0, null, null, 0, 15, null);
                            b bVar2 = pbResponse2.rsp;
                            Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                            function13.invoke(i.b(qVar, bVar2.f438203f.f30291a));
                        } catch (Throwable th5) {
                            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchTacitListHistory decode error: ", th5, KLog.INSTANCE, "NBPNewHomeRepository");
                            nBPHomePageBaseViewModel$fetchMyAllTacitList$2.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
                        }
                    } else {
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchTacitListHistory error: ");
                        m16.append(pbResponse2.code);
                        kLog.e("NBPNewHomeRepository", m16.toString());
                        nBPHomePageBaseViewModel$fetchMyAllTacitList$2.invoke(Integer.valueOf(pbResponse2.code), "");
                    }
                    return Unit.INSTANCE;
                }
            };
            QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoGetUserTacitHistory", appId, new a(i.d(pVar))));
            QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(function12);
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
        }
    }

    public static final com.tencent.kuikly.core.reactive.collection.c access$getTacitAllMyList(NBPHomePageBaseViewModel nBPHomePageBaseViewModel) {
        return (com.tencent.kuikly.core.reactive.collection.c) nBPHomePageBaseViewModel.tacitAllMyList$delegate.getValue(nBPHomePageBaseViewModel, $$delegatedProperties[6]);
    }

    public final void assembleFullTags() {
        List<t35.a> list;
        int collectionSizeOrDefault;
        getTagList().clear();
        af userInfo = getUserInfo();
        if (userInfo == null || (list = userInfo.I) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((t35.a) obj).f435362d != 0) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new TagInfo((t35.a) it.next()));
        }
        getTagList().addAll(arrayList2);
    }

    public final int calculateTagLines(af afVar) {
        int i3 = 1;
        if (afVar.I.isEmpty()) {
            return 1;
        }
        float f16 = this.pageViewWidth - 32;
        int tagStartOffset = getTagStartOffset(afVar);
        Iterator<T> it = afVar.I.iterator();
        while (it.hasNext()) {
            int tagWidth = getTagWidth((t35.a) it.next());
            if (tagStartOffset + tagWidth > f16 - 6) {
                i3++;
                tagStartOffset = tagWidth + 12;
            } else {
                tagStartOffset += tagWidth + 12;
            }
        }
        return i3;
    }

    public final void editTacit(Tacit tacit, int i3) {
        final int appId = getAppId();
        int i16 = tacit.f114238id;
        int i17 = tacit.answer;
        final Function1<x, Unit> function1 = new Function1<x, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$editTacit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(x xVar) {
                NBPHomePageBaseViewModel.access$fetchMyAllTacitList(NBPHomePageBaseViewModel.this);
                return Unit.INSTANCE;
            }
        };
        final NBPHomePageBaseViewModel$editTacit$2 nBPHomePageBaseViewModel$editTacit$2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$editTacit$2
            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                num.intValue();
                return Unit.INSTANCE;
            }
        };
        w wVar = new w(i16, i17, i3);
        Function1<PbResponse<b>, Unit> function12 = new Function1<PbResponse<b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$editTacit$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<b> pbResponse) {
                PbResponse<b> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("editTacit: appId:");
                m3.append(appId);
                m3.append(", proxy retcode:");
                m3.append(pbResponse2.code);
                m3.append(" rsp return code:");
                b bVar = pbResponse2.rsp;
                NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NBPNewHomeRepository");
                if (pbResponse2.success && pbResponse2.rsp != null) {
                    try {
                        Function1<x, Unit> function13 = function1;
                        x xVar = new x(0, null, 3, null);
                        b bVar2 = pbResponse2.rsp;
                        Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                        function13.invoke(i.b(xVar, bVar2.f438203f.f30291a));
                    } catch (Throwable th5) {
                        AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("editTacit decode error: ", th5, KLog.INSTANCE, "NBPNewHomeRepository");
                        nBPHomePageBaseViewModel$editTacit$2.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
                    }
                } else {
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("editTacit error: ");
                    m16.append(pbResponse2.code);
                    kLog.e("NBPNewHomeRepository", m16.toString());
                    nBPHomePageBaseViewModel$editTacit$2.invoke(Integer.valueOf(pbResponse2.code), "");
                }
                return Unit.INSTANCE;
            }
        };
        QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoSetUserTacitAnswer", appId, new a(i.d(wVar))));
        QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(function12);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.List<p35.n>, java.util.ArrayList] */
    public final void fetchFeedList(final boolean z16) {
        byte[] a16;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("feed_list_");
        m3.append(this.accountId);
        final String sb5 = m3.toString();
        if (getFeedState() == FetchStatus.FETCH_NO_MORE || getFeedState() == FetchStatus.FETCH_LOADING || this.isCurrentLikedPage) {
            return;
        }
        if (Intrinsics.areEqual(this.mAttachInfo, a.f30290b) && getFeedList().isEmpty()) {
            try {
                String str = this.lruCache.get(sb5);
                if (str != null && (a16 = d45.a.a(str)) != null) {
                    ab abVar = (ab) i.b(new ab((List) null, false, (a) null, 0, (m25.c) null, 0, (String) null, 255), a16);
                    List<n> list = abVar.f425113d;
                    if (this.isScrolling) {
                        this.pendingFeedList.addAll(list);
                    } else {
                        getFeedList().addAll(list);
                    }
                    KLog.INSTANCE.i("NBPHomePageBaseViewModel", "lruCache hit = " + abVar.f425113d.size());
                }
            } catch (Throwable th5) {
                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("lruCache error: ", th5, KLog.INSTANCE, "NBPHomePageBaseViewModel");
            }
        }
        setFeedState(FetchStatus.FETCH_LOADING);
        a aVar = this.mAttachInfo;
        if (aVar != null) {
            final int appId = getAppId();
            final int accountType = getAccountType();
            final String str2 = this.accountId;
            final Function1<ab, Unit> function1 = new Function1<ab, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchFeedList$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Type inference failed for: r2v21, types: [java.util.List<p35.n>, java.util.ArrayList] */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ab abVar2) {
                    FetchStatus fetchStatus;
                    ab abVar3;
                    List take;
                    List mutableList;
                    List take2;
                    List mutableList2;
                    ab abVar4 = abVar2;
                    AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(abVar4.f425113d, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedList size: "), ", isEnd: "), abVar4.f425114e, KLog.INSTANCE, "NBPHomePageBaseViewModel");
                    if (z16) {
                        this.getFeedList().clear();
                    }
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = this;
                    List<n> list2 = abVar4.f425113d;
                    if (nBPHomePageBaseViewModel.isScrolling) {
                        nBPHomePageBaseViewModel.pendingFeedList.addAll(list2);
                    } else {
                        nBPHomePageBaseViewModel.getFeedList().addAll(list2);
                    }
                    if (Intrinsics.areEqual(this.mAttachInfo, a.f30290b)) {
                        if (!abVar4.f425113d.isEmpty()) {
                            if (!this.isModal || abVar4.f425113d.size() <= 6) {
                                take = CollectionsKt___CollectionsKt.take(abVar4.f425113d, 9);
                                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) take);
                                abVar3 = new ab(mutableList, abVar4.f425114e, abVar4.f425115f, abVar4.f425116h, abVar4.f425117i, abVar4.C, abVar4.D, 32);
                            } else {
                                take2 = CollectionsKt___CollectionsKt.take(abVar4.f425113d, 6);
                                mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) take2);
                                abVar3 = new ab(mutableList2, abVar4.f425114e, abVar4.f425115f, abVar4.f425116h, abVar4.f425117i, abVar4.C, abVar4.D, 32);
                            }
                            this.lruCache.add(sb5, i.c(abVar3));
                        } else {
                            this.lruCache.remove(sb5);
                        }
                    }
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = this;
                    nBPHomePageBaseViewModel2.mAttachInfo = abVar4.f425115f;
                    if (abVar4.f425114e) {
                        fetchStatus = FetchStatus.FETCH_NO_MORE;
                    } else {
                        fetchStatus = FetchStatus.FETCH_STATE_SUCCESS;
                    }
                    nBPHomePageBaseViewModel2.setFeedState(fetchStatus);
                    return Unit.INSTANCE;
                }
            };
            final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchFeedList$2$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str3) {
                    num.intValue();
                    NBPHomePageBaseViewModel.this.setFeedState(FetchStatus.FETCH_STATE_NET_ERROR);
                    return Unit.INSTANCE;
                }
            };
            aa aaVar = new aa(str2, accountType, 18, aVar, null, QQNearbyModule.Companion.getInstance().getCommonExtInfo(), new ArrayList(), 16);
            Function1<PbResponse<b>, Unit> function12 = new Function1<PbResponse<b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$fetchFeedList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(PbResponse<b> pbResponse) {
                    PbResponse<b> pbResponse2 = pbResponse;
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedList: appId:");
                    m16.append(appId);
                    m16.append(", accountType:");
                    m16.append(accountType);
                    m16.append(", accountId:");
                    m16.append(str2);
                    m16.append(", proxy retcode:");
                    m16.append(pbResponse2.code);
                    m16.append(" rsp return code:");
                    b bVar = pbResponse2.rsp;
                    NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m16, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NBPNewHomeRepository");
                    if (pbResponse2.success && pbResponse2.rsp != null) {
                        try {
                            Function1<ab, Unit> function13 = function1;
                            ab abVar2 = new ab((List) null, false, (a) null, 0, (m25.c) null, 0, (String) null, 255);
                            b bVar2 = pbResponse2.rsp;
                            Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                            function13.invoke(i.b(abVar2, bVar2.f438203f.f30291a));
                        } catch (Throwable th6) {
                            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchFeedList decode error: ", th6, KLog.INSTANCE, "NBPNewHomeRepository");
                            function2.invoke(Integer.valueOf(pbResponse2.code), th6.toString());
                        }
                    } else {
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedList error: ");
                        m17.append(pbResponse2.code);
                        kLog.e("NBPNewHomeRepository", m17.toString());
                        function2.invoke(Integer.valueOf(pbResponse2.code), "");
                    }
                    return Unit.INSTANCE;
                }
            };
            QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.FeedSvr", "SsoGetFeedList", appId, new a(i.d(aaVar))));
            QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(function12);
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
        }
    }

    public int getAccountType() {
        return this.accountType;
    }

    public int getAppId() {
        return 0;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<n> getFeedList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.feedList$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final FetchStatus getFeedState() {
        return (FetchStatus) this.feedState$delegate.getValue(this, $$delegatedProperties[11]);
    }

    public final boolean getFollowOnlySelf() {
        return ((Boolean) this.followOnlySelf$delegate.getValue(this, $$delegatedProperties[16])).booleanValue();
    }

    public final FollowStatus getFollowState() {
        return (FollowStatus) this.followState$delegate.getValue(this, $$delegatedProperties[15]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<n> getLikedFeedList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.likedFeedList$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final boolean getLikesOnlySelf() {
        return ((Boolean) this.likesOnlySelf$delegate.getValue(this, $$delegatedProperties[14])).booleanValue();
    }

    public UserSelfBaseInfo getSelfBaseInfo() {
        return new UserSelfBaseInfo(0, 15);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<y> getTacitGuestList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tacitGuestList$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final String getTacitGuestTitle() {
        return (String) this.tacitGuestTitle$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<Tacit> getTacitMyList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tacitMyList$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<TagInfo> getTagList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tagList$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final int getTagWidth(t35.a aVar) {
        boolean contains;
        int i3 = aVar.f435362d;
        if (10000 <= i3 && i3 < 11112) {
            contains = StringsKt__StringsKt.contains((CharSequence) aVar.f435363e, (CharSequence) "I", true);
            return contains ? 42 : 46;
        }
        return (aVar.f435363e.length() * 12) + 16;
    }

    public final boolean getTagsExpanded() {
        return ((Boolean) this.tagsExpanded$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final int getTotalFansCount() {
        return ((Number) this.totalFansCount$delegate.getValue(this, $$delegatedProperties[17])).intValue();
    }

    public final af getUserInfo() {
        return (af) this.userInfo$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void handleFollowAreaClick(boolean z16) {
        if (!this.isSelf && getFollowOnlySelf()) {
            Utils.INSTANCE.currentBridgeModule().qToast("\u5bf9\u65b9\u5df2\u9690\u85cf\u7c89\u4e1d\u548c\u5173\u6ce8\u5217\u8868", QToastMode.Info);
            return;
        }
        int i3 = z16 ? 2 : 1;
        int appId = getAppId();
        String str = this.accountId;
        boolean followOnlySelf = getFollowOnlySelf();
        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nbp_follower_page&appid=", appId, "&account_id=", str, "&click_area=");
        m3.append(i3);
        m3.append("&follow_only_self=");
        m3.append(followOnlySelf);
        m3.append("&local_bundle_name=nearbypro");
        String sb5 = m3.toString();
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<p35.n>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<p35.n>, java.util.ArrayList] */
    public final void handlePendingFeeds() {
        List<List> chunked;
        if (this.pendingFeedList.isEmpty()) {
            return;
        }
        chunked = CollectionsKt___CollectionsKt.chunked(this.pendingFeedList, 9);
        for (final List list : chunked) {
            this.pendingFeedList.removeAll(list);
            TimerKt.d(1, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$handlePendingFeeds$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPHomePageBaseViewModel.this.getFeedList().addAll(list);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void homePageBaseReport(String str, String str2) {
        e jsonWithHomePagePgParams = jsonWithHomePagePgParams();
        jsonWithHomePagePgParams.v("dt_eid", str2);
        jsonWithHomePagePgParams.v("cur_pg", jsonWithHomePagePgParams());
        jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, jsonWithHomePagePgParams);
    }

    public final e jsonWithHomePagePgParams() {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_kl_new_profile_view");
        m3.t("open_visit_state", !this.isSelf ? 1 : 0);
        if (getAppId() == 1) {
            m3.v("kl_new_profile_frompage", this.fromId);
        }
        if (getAppId() == 2) {
            m3.v("nearby_source", this.sourceId);
        }
        m3.v("touin", this.accountId);
        m3.v("recom_trace", this.traceId);
        m3.t("nearby_kl_appid", getAppId());
        return m3;
    }

    public final void openEditPage() {
        String str;
        String str2;
        String replace$default;
        String str3;
        String replace$default2;
        d dVar;
        d dVar2;
        d dVar3;
        if (this.fastClickUtils$1.isFastDoubleClick() || !this.isSelf || getUserInfo() == null) {
            return;
        }
        com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
        Iterator<TagInfo> it = getTagList().iterator();
        while (it.hasNext()) {
            TagInfo next = it.next();
            e eVar = new e();
            eVar.t("tagId", next.tag.f435362d);
            eVar.v("tagName", next.tag.f435363e);
            bVar.t(eVar);
        }
        Utils utils = Utils.INSTANCE;
        BridgeModule currentBridgeModule = utils.currentBridgeModule();
        af userInfo = getUserInfo();
        if (userInfo == null || (str = userInfo.E) == null) {
            str = "";
        }
        String urlEncode = currentBridgeModule.urlEncode(str);
        BridgeModule currentBridgeModule2 = utils.currentBridgeModule();
        af userInfo2 = getUserInfo();
        if (userInfo2 == null || (str2 = userInfo2.f433209f) == null) {
            str2 = "";
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(currentBridgeModule2.base64Code(str2, true), Marker.ANY_NON_NULL_MARKER, "%2B", false, 4, (Object) null);
        BridgeModule currentBridgeModule3 = utils.currentBridgeModule();
        af userInfo3 = getUserInfo();
        if (userInfo3 == null || (str3 = userInfo3.F) == null) {
            str3 = "";
        }
        replace$default2 = StringsKt__StringsJVMKt.replace$default(currentBridgeModule3.base64Code(str3, true), Marker.ANY_NON_NULL_MARKER, "%2B", false, 4, (Object) null);
        af userInfo4 = getUserInfo();
        int i3 = (userInfo4 == null || (dVar3 = userInfo4.C) == null) ? 0 : dVar3.f433229d;
        af userInfo5 = getUserInfo();
        int i16 = (userInfo5 == null || (dVar2 = userInfo5.C) == null) ? 0 : dVar2.f433230e;
        af userInfo6 = getUserInfo();
        int i17 = (userInfo6 == null || (dVar = userInfo6.C) == null) ? 0 : dVar.f433231f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_new_profile_edit&appid=");
        sb5.append(getAppId());
        sb5.append("&completed_tacit_count=");
        sb5.append(this.tacitAllMyListSize);
        sb5.append("&avatar=");
        sb5.append(urlEncode);
        sb5.append("&dress_border=");
        StringBuilder m3 = VasBusinessReportData$$ExternalSyntheticOutline0.m(sb5, "", "&nick=", replace$default, "&gender=");
        af userInfo7 = getUserInfo();
        m3.append(userInfo7 != null ? Integer.valueOf(userInfo7.f433218m) : null);
        m3.append("&declaration=");
        m3.append(replace$default2);
        m3.append("&year=");
        m3.append(i3);
        m3.append("&month=");
        m3.append(i16);
        m3.append("&day=");
        m3.append(i17);
        m3.append("&constellation=");
        af userInfo8 = getUserInfo();
        m3.append(userInfo8 != null ? userInfo8.f433214i : null);
        m3.append("&likes_only_self=");
        sb5.append(getLikesOnlySelf());
        sb5.append("&tags=");
        sb5.append(bVar);
        String sb6 = sb5.toString();
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(sb6, false, 6);
    }

    public final void prepareCollapsedTags() {
        List<t35.a> list;
        if (!shouldShowTagsToggle()) {
            assembleFullTags();
            return;
        }
        getTagList().clear();
        float f16 = this.pageViewWidth - 32;
        int tagStartOffset = getTagStartOffset(getUserInfo());
        af userInfo = getUserInfo();
        if (userInfo == null || (list = userInfo.I) == null) {
            return;
        }
        ArrayList<t35.a> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((t35.a) next).f435362d != 0) {
                arrayList.add(next);
            }
        }
        int i3 = 1;
        for (t35.a aVar : arrayList) {
            int tagWidth = getTagWidth(aVar);
            if (tagStartOffset + tagWidth > f16 - 6) {
                i3++;
                tagStartOffset = tagWidth + 12;
                if (i3 <= 2) {
                    getTagList().add(new TagInfo(aVar));
                }
            } else {
                tagStartOffset += tagWidth + 12;
                if (i3 == 1 || (i3 == 2 && ((float) (tagStartOffset + 60)) < f16)) {
                    getTagList().add(new TagInfo(aVar));
                }
            }
        }
    }

    public final void refreshFeedList() {
        if (this.isSelf) {
            TimerKt.c(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$refreshFeedList$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPHomePageBaseViewModel.this.setFeedState(FetchStatus.NULL_STATE);
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel.mAttachInfo = a.f30290b;
                    nBPHomePageBaseViewModel.fetchFeedList(true);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void refreshSelfInfo() {
        if (this.isSelf && this.hasJumpTacitH5) {
            KLog.INSTANCE.i("NBPHomePageBaseViewModel", "refreshSelfInfo from hasJumpTacitH5");
            NBPNewHomeRepository.fetchUserInfo$default(getAppId(), getAccountType(), this.accountId, new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$refreshSelfInfo$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(af afVar) {
                    int collectionSizeOrDefault;
                    NBPHomePageBaseViewModel.this.getTagList().clear();
                    List<t35.a> list = afVar.I;
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((t35.a) next).f435362d != 0) {
                            arrayList.add(next);
                        }
                    }
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        arrayList2.add(new TagInfo((t35.a) it5.next()));
                    }
                    NBPHomePageBaseViewModel.this.getTagList().addAll(arrayList2);
                    int appId = NBPHomePageBaseViewModel.this.getAppId();
                    int accountType = NBPHomePageBaseViewModel.this.getAccountType();
                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomePageBaseViewModel.this;
                    String str = nBPHomePageBaseViewModel.accountId;
                    Function1<k, Unit> function1 = new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$refreshSelfInfo$1.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(k kVar) {
                            int collectionSizeOrDefault2;
                            List sortedDescending;
                            Object obj;
                            List<z> list2 = kVar.f433248f;
                            ArrayList arrayList3 = new ArrayList();
                            Iterator<T> it6 = list2.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    break;
                                }
                                Object next2 = it6.next();
                                if (((z) next2).C == 0) {
                                    arrayList3.add(next2);
                                }
                            }
                            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
                            Iterator it7 = arrayList3.iterator();
                            while (it7.hasNext()) {
                                arrayList4.add(TacitKt.toTacit((z) it7.next()));
                            }
                            ArrayList arrayList5 = new ArrayList();
                            com.tencent.kuikly.core.reactive.collection.c<Tacit> tacitMyList = NBPHomePageBaseViewModel.this.getTacitMyList();
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomePageBaseViewModel.this;
                            Iterator<Tacit> it8 = tacitMyList.iterator();
                            int i3 = 0;
                            while (it8.hasNext()) {
                                Tacit next3 = it8.next();
                                int i16 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                Tacit tacit = next3;
                                Iterator it9 = arrayList4.iterator();
                                while (true) {
                                    if (!it9.hasNext()) {
                                        obj = null;
                                        break;
                                    }
                                    obj = it9.next();
                                    if (((Tacit) obj).f114238id == tacit.f114238id) {
                                        break;
                                    }
                                }
                                Tacit tacit2 = (Tacit) obj;
                                if (tacit2 != null) {
                                    nBPHomePageBaseViewModel2.getTacitMyList().set(i3, tacit2);
                                } else {
                                    arrayList5.add(Integer.valueOf(i3));
                                }
                                i3 = i16;
                            }
                            sortedDescending = CollectionsKt___CollectionsKt.sortedDescending(arrayList5);
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomePageBaseViewModel.this;
                            Iterator it10 = sortedDescending.iterator();
                            while (it10.hasNext()) {
                                try {
                                    nBPHomePageBaseViewModel3.getTacitMyList().remove(((Number) it10.next()).intValue());
                                } catch (Throwable th5) {
                                    AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("indicesToRemove.sortedDescending: ", th5, KLog.INSTANCE, "NBPHomePageBaseViewModel");
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    AnonymousClass5 anonymousClass5 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$refreshSelfInfo$1.5
                        @Override // kotlin.jvm.functions.Function2
                        public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                            num.intValue();
                            return Unit.INSTANCE;
                        }
                    };
                    j jVar = new j();
                    NBPNewHomeRepository$fetchTacitList$1 nBPNewHomeRepository$fetchTacitList$1 = new NBPNewHomeRepository$fetchTacitList$1(appId, accountType, str, function1, anonymousClass5);
                    QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoGetDailyQuestion", appId, new a(i.d(jVar))));
                    QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(nBPNewHomeRepository$fetchTacitList$1);
                    APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
                    NBPHomePageBaseViewModel.access$fetchMyAllTacitList(NBPHomePageBaseViewModel.this);
                    return Unit.INSTANCE;
                }
            }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$refreshSelfInfo$2
                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    num.intValue();
                    return Unit.INSTANCE;
                }
            });
            this.hasJumpTacitH5 = false;
        }
    }

    public final boolean removeTacit(Tacit tacit) {
        Iterator<Tacit> it = getTacitMyList().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next(), tacit)) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            return false;
        }
        editTacit(tacit, 1);
        getTacitMyList().remove(i3);
        return true;
    }

    public final void reportUser() {
        if (this.fastClickUtils$1.isFastDoubleClick()) {
            return;
        }
        if (getAppId() == 2) {
            QQNearbyModule.Companion.getInstance().jumpReportPage(100521, this.accountId, "", null);
        } else {
            af userInfo = getUserInfo();
            QQNearbyModule.Companion.getInstance().jumpReportPage(10132, String.valueOf(userInfo != null ? Long.valueOf(userInfo.f433207e) : null), "", null);
        }
    }

    public final void setFeedState(FetchStatus fetchStatus) {
        this.feedState$delegate.setValue(this, $$delegatedProperties[11], fetchStatus);
    }

    public final void setFollowState(FollowStatus followStatus) {
        this.followState$delegate.setValue(this, $$delegatedProperties[15], followStatus);
    }

    public final void setLikedFeedState(FetchStatus fetchStatus) {
        this.likedFeedState$delegate.setValue(this, $$delegatedProperties[13], fetchStatus);
    }

    public final void setTacitState(FetchStatus fetchStatus) {
        this.tacitState$delegate.setValue(this, $$delegatedProperties[4], fetchStatus);
    }

    public final void setTotalFansCount(int i3) {
        this.totalFansCount$delegate.setValue(this, $$delegatedProperties[17], Integer.valueOf(i3));
    }

    public final void setUserInfo(af afVar) {
        this.userInfo$delegate.setValue(this, $$delegatedProperties[2], afVar);
    }

    public final void setUserInfoState(FetchStatus fetchStatus) {
        this.userInfoState$delegate.setValue(this, $$delegatedProperties[3], fetchStatus);
    }

    public final boolean shouldShowTagsToggle() {
        return !this.isSelf && ((Number) this.tagViewLines$delegate.getValue(this, $$delegatedProperties[1])).intValue() >= 3;
    }

    public final boolean tacitFaqGuestNotAnswer() {
        s35.aa aaVar;
        af userInfo = getUserInfo();
        return (userInfo == null || (aaVar = userInfo.f433202a0) == null || aaVar.f433190d != 2) ? false : true;
    }

    public final boolean tacitFaqOwnerNotAnswer() {
        s35.aa aaVar;
        af userInfo = getUserInfo();
        return (userInfo == null || (aaVar = userInfo.f433202a0) == null || aaVar.f433190d != 1) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0024 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean tacitShow() {
        if (this.isSelf) {
            return ((FetchStatus) this.tacitState$delegate.getValue(this, $$delegatedProperties[4])) == FetchStatus.FETCH_STATE_SUCCESS;
        }
        af userInfo = getUserInfo();
        if ((userInfo != null ? userInfo.f433202a0 : null) != null) {
        }
    }

    public final void updateUserInfo(e eVar) {
        int j3 = eVar.j("itemId");
        if (j3 == 1) {
            af userInfo = getUserInfo();
            if (userInfo != null) {
                setUserInfo(NBPNewHomeRepository.copyUserInfo$default(userInfo, null, null, 0, null, eVar.p("value"), null, null, null, -514, 63));
            }
        } else if (j3 == 2) {
            af userInfo2 = getUserInfo();
            if (userInfo2 != null) {
                setUserInfo(NBPNewHomeRepository.copyUserInfo$default(userInfo2, eVar.p("value"), null, 0, null, null, null, null, null, -10, 63));
            }
        } else if (j3 == 3) {
            String p16 = eVar.p("value");
            d dVar = new d(eVar.j("year"), eVar.j("month"), eVar.j("day"));
            af userInfo3 = getUserInfo();
            if (userInfo3 != null) {
                setUserInfo(NBPNewHomeRepository.copyUserInfo$default(userInfo3, null, p16, 0, dVar, null, null, null, null, -162, 63));
            }
        } else if (j3 == 6) {
            af userInfo4 = getUserInfo();
            if (userInfo4 != null) {
                setUserInfo(NBPNewHomeRepository.copyUserInfo$default(userInfo4, null, null, 0, null, null, eVar.p("value"), null, null, -1026, 63));
            }
        } else if (j3 == 7) {
            af userInfo5 = getUserInfo();
            if (userInfo5 != null) {
                setUserInfo(NBPNewHomeRepository.copyUserInfo$default(userInfo5, null, null, eVar.j("value"), null, null, null, null, null, -66, 63));
            }
        } else if (j3 == 9) {
            getTagList().clear();
            getTagList().addAll(NBPNewHomeRepository.INSTANCE.decodeTags(eVar.l("value")));
        }
        if (getAppId() == 1) {
            af userInfo6 = getUserInfo();
            if (userInfo6 != null && i.d(userInfo6) != null) {
                AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((com.tencent.kuikly.core.module.k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "JIEBAN_SELF_USERINFO_CHANGED_EVENT", false, 4, null);
            }
            QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
            getAppId();
            String str = this.accountId;
            af userInfo7 = getUserInfo();
            String str2 = userInfo7 != null ? userInfo7.f433209f : null;
            af userInfo8 = getUserInfo();
            String str3 = userInfo8 != null ? userInfo8.E : null;
            companion.getClass();
            e eVar2 = new e();
            eVar2.v("accountId", str);
            eVar2.v("nick", str2);
            eVar2.v(PhotoCategorySummaryInfo.AVATAR_URL, str3);
            companion.asyncToNativeMethod("setMatchFriendBaseInfo", eVar2, (Function1<? super e, Unit>) null);
        }
    }

    public final void setFollowState(final int i3, String str) {
        final String str2 = i3 == 0 ? "\u53d6\u5173" : "\u5173\u6ce8";
        int appId = getAppId();
        Function1<q35.b, Unit> function1 = new Function1<q35.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$setFollowState$1

            /* loaded from: classes31.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[FollowStatus.values().length];
                    try {
                        iArr[3] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[2] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(q35.b bVar) {
                FollowStatus followStatus;
                Utils.INSTANCE.currentBridgeModule().qToast(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), str2, "\u6210\u529f"), QToastMode.Success);
                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = this;
                if (i3 == 0) {
                    if (WhenMappings.$EnumSwitchMapping$0[nBPHomePageBaseViewModel.getFollowState().ordinal()] == 1) {
                        followStatus = FollowStatus.FOLLOW_BACK;
                    } else {
                        followStatus = FollowStatus.NO_FOLLOWED;
                    }
                } else {
                    if (WhenMappings.$EnumSwitchMapping$0[nBPHomePageBaseViewModel.getFollowState().ordinal()] == 2) {
                        followStatus = FollowStatus.MUTUAL_FOLLOW;
                    } else {
                        followStatus = FollowStatus.FOLLOWED;
                    }
                }
                nBPHomePageBaseViewModel.setFollowState(followStatus);
                return Unit.INSTANCE;
            }
        };
        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$setFollowState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                num.intValue();
                Utils.INSTANCE.currentBridgeModule().qToast(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), str2, "\u5931\u8d25"), QToastMode.Warning);
                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("setFollowState: error. msg: ", str3, KLog.INSTANCE, "NBPHomePageBaseViewModel");
                return Unit.INSTANCE;
            }
        };
        q35.a aVar = new q35.a(QQNearbyModule.Companion.getInstance().getCommonExtInfo(), i3, str, 2);
        NearbyFollowRepo$setFollowState$1 nearbyFollowRepo$setFollowState$1 = new NearbyFollowRepo$setFollowState$1(appId, function1, function2, str, i3);
        QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.follow", "SsoDoFollow", appId, new a(i.d(aVar))));
        QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(nearbyFollowRepo$setFollowState$1);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
    }

    public final void fetchUserLikedList() {
        if (this.isLoadingLikedFeeds || ((FetchStatus) this.likedFeedState$delegate.getValue(this, $$delegatedProperties[13])) == FetchStatus.FETCH_NO_MORE) {
            return;
        }
        this.isLoadingLikedFeeds = true;
        setLikedFeedState(FetchStatus.FETCH_LOADING);
        a aVar = this.likedAttachInfo;
        if (aVar != null) {
            final int appId = getAppId();
            final int accountType = getAccountType();
            final String str = this.accountId;
            final Function1<ab, Unit> function1 = new Function1<ab, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchUserLikedList$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ab abVar) {
                    FetchStatus fetchStatus;
                    ab abVar2 = abVar;
                    NBPHomePageBaseViewModel.this.isLoadingLikedFeeds = false;
                    AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(NearbyFDPageViewModel$$ExternalSyntheticOutline0.m(abVar2.f425113d, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch user liked feedList size: "), ", isEnd: "), abVar2.f425114e, KLog.INSTANCE, "NBPHomePageBaseViewModel");
                    NBPHomePageBaseViewModel.this.getLikedFeedList().addAll(abVar2.f425113d);
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel.likedAttachInfo = abVar2.f425115f;
                    if (abVar2.f425114e) {
                        fetchStatus = FetchStatus.FETCH_NO_MORE;
                    } else {
                        fetchStatus = FetchStatus.FETCH_STATE_SUCCESS;
                    }
                    nBPHomePageBaseViewModel.setLikedFeedState(fetchStatus);
                    return Unit.INSTANCE;
                }
            };
            final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchUserLikedList$1$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str2) {
                    NBPHomePageBaseViewModel.this.isLoadingLikedFeeds = false;
                    KLog.INSTANCE.e("NBPHomePageBaseViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("fetchUserLikedList error. code:", num.intValue(), ", msg: ", str2));
                    NBPHomePageBaseViewModel.this.setLikedFeedState(FetchStatus.FETCH_STATE_NET_ERROR);
                    return Unit.INSTANCE;
                }
            };
            aa aaVar = new aa(str, accountType, 15, aVar, "", QQNearbyModule.Companion.getInstance().getCommonExtInfo(), null, 64);
            Function1<PbResponse<b>, Unit> function12 = new Function1<PbResponse<b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$fetchUserLikedList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(PbResponse<b> pbResponse) {
                    PbResponse<b> pbResponse2 = pbResponse;
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchUserLikedList: appId:");
                    m3.append(appId);
                    m3.append(", accountType:");
                    m3.append(accountType);
                    m3.append(", accountId:");
                    m3.append(str);
                    m3.append(", proxy retcode:");
                    m3.append(pbResponse2.code);
                    m3.append(" rsp return code:");
                    b bVar = pbResponse2.rsp;
                    NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NBPNewHomeRepository");
                    if (pbResponse2.success && pbResponse2.rsp != null) {
                        try {
                            Function1<ab, Unit> function13 = function1;
                            ab abVar = new ab((List) null, false, (a) null, 0, (m25.c) null, 0, (String) null, 255);
                            b bVar2 = pbResponse2.rsp;
                            Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                            function13.invoke(i.b(abVar, bVar2.f438203f.f30291a));
                        } catch (Throwable th5) {
                            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchUserLikedList decode error: ", th5, KLog.INSTANCE, "NBPNewHomeRepository");
                            function2.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
                        }
                    } else {
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchUserLikedList error: ");
                        m16.append(pbResponse2.code);
                        kLog.e("NBPNewHomeRepository", m16.toString());
                        function2.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                    }
                    return Unit.INSTANCE;
                }
            };
            QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.FeedSvr", "SsoGetUserLikedFeedList", appId, new a(i.d(aaVar))));
            QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(function12);
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
        }
    }

    public final void reportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e jsonWithHomePagePgParams = jsonWithHomePagePgParams();
        jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, jsonWithHomePagePgParams);
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public static final String access$getParamValue(Companion companion, g gVar, String str) {
            Sequence asSequence;
            Object obj;
            String q16;
            boolean equals;
            companion.getClass();
            asSequence = SequencesKt__SequencesKt.asSequence(gVar.n().c());
            Iterator it = asSequence.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                equals = StringsKt__StringsJVMKt.equals((String) obj, str, true);
                if (equals) {
                    break;
                }
            }
            String str2 = (String) obj;
            return (str2 == null || (q16 = gVar.n().q(str2, "")) == null) ? "" : q16;
        }

        public final void openTagEditPage(int i3, List<TagInfo> list) {
            if (NBPHomePageBaseViewModel.fastClickUtils.isFastDoubleClick()) {
                return;
            }
            com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
            if (list != null) {
                for (TagInfo tagInfo : list) {
                    e eVar = new e();
                    eVar.t("tagId", tagInfo.tag.f435362d);
                    eVar.v("tagName", tagInfo.tag.f435363e);
                    bVar.t(eVar);
                }
            }
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_profile_tag_edit&custom_back_pressed=1&custom_back_pressed_ios=1&appid=" + i3 + "&tags=" + bVar, false, 6);
        }

        public final NBPHomePageBaseViewModel created(g gVar, boolean z16) {
            final NBPHomePageBaseViewModel nBPHomePageNearbyProViewModel;
            af afVar;
            List<t35.a> list;
            int collectionSizeOrDefault;
            List mutableList;
            if (gVar.n().j("bu_type") == 1) {
                nBPHomePageNearbyProViewModel = new NBPHomePageMatchFriendViewModel(z16);
            } else {
                nBPHomePageNearbyProViewModel = new NBPHomePageNearbyProViewModel(z16);
            }
            nBPHomePageNearbyProViewModel.pageViewWidth = gVar.m();
            Companion companion = NBPHomePageBaseViewModel.Companion;
            nBPHomePageNearbyProViewModel.accountId = access$getParamValue(companion, gVar, "tinyid");
            nBPHomePageNearbyProViewModel.isSelf = gVar.n().j("self") == 1 || Intrinsics.areEqual(nBPHomePageNearbyProViewModel.accountId, String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid));
            nBPHomePageNearbyProViewModel.sourceId = access$getParamValue(companion, gVar, "source_id");
            nBPHomePageNearbyProViewModel.traceId = access$getParamValue(companion, gVar, "trace_id");
            nBPHomePageNearbyProViewModel.fromId = access$getParamValue(companion, gVar, "from_id");
            e m3 = gVar.n().m("user_info");
            if (m3 != null) {
                String urlDecode = Utils.INSTANCE.currentBridgeModule().urlDecode(m3.p("avatar"));
                String p16 = m3.p("nick");
                String p17 = m3.p("declaration");
                int j3 = m3.j("gender");
                String p18 = m3.p(LpReport_UserInfo_dc02148.CONSTELLATION);
                List<TagInfo> decodeTags = NBPNewHomeRepository.INSTANCE.decodeTags(m3.l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS));
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(decodeTags, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = ((ArrayList) decodeTags).iterator();
                while (it.hasNext()) {
                    arrayList.add(((TagInfo) it.next()).tag);
                }
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                nBPHomePageNearbyProViewModel.setUserInfo(new af(null, 0L, p16, 0, p18, j3, null, null, urlDecode, p17, null, null, mutableList, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -4917, 255));
            }
            af userInfo = nBPHomePageNearbyProViewModel.getUserInfo();
            if (userInfo != null) {
                nBPHomePageNearbyProViewModel.tagViewLines$delegate.setValue(nBPHomePageNearbyProViewModel, NBPHomePageBaseViewModel.$$delegatedProperties[1], Integer.valueOf(nBPHomePageNearbyProViewModel.calculateTagLines(userInfo)));
                if (!nBPHomePageNearbyProViewModel.isSelf) {
                    nBPHomePageNearbyProViewModel.prepareCollapsedTags();
                } else {
                    nBPHomePageNearbyProViewModel.assembleFullTags();
                }
            }
            KLog kLog = KLog.INSTANCE;
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("parseData, tinyId: ");
            af userInfo2 = nBPHomePageNearbyProViewModel.getUserInfo();
            m16.append(userInfo2 != null ? Long.valueOf(userInfo2.f433207e) : null);
            m16.append(", tag size: ");
            af userInfo3 = nBPHomePageNearbyProViewModel.getUserInfo();
            m16.append((userInfo3 == null || (list = userInfo3.I) == null) ? null : Integer.valueOf(list.size()));
            kLog.i("NBPHomePageBaseViewModel", m16.toString());
            int appId = nBPHomePageNearbyProViewModel.getAppId();
            int accountType = nBPHomePageNearbyProViewModel.getAccountType();
            String str = nBPHomePageNearbyProViewModel.accountId;
            final String str2 = QQNearbyModule.Companion.getInstance().getMatchFriendBaseInfo().avatarUrl;
            if (str2 == null) {
                str2 = "";
            }
            if (appId != 1) {
                str2 = UserDataManager.INSTANCE.getUserSelfInfo().avatarUrl;
            }
            if (nBPHomePageNearbyProViewModel.isSelf) {
                MemoryCacheModule memoryCacheModule = (MemoryCacheModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRMemoryCacheModule");
                String str3 = "SelfUserInfoByteArray_" + appId + util.base64_pad_url + str;
                NearbyConst nearbyConst = NearbyConst.INSTANCE;
                Object b16 = memoryCacheModule.b("nearbypro", str3);
                if (b16 != null) {
                    byte[] bArr = b16 instanceof byte[] ? (byte[]) b16 : null;
                    if (bArr != null) {
                        try {
                            afVar = (af) i.b(new af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255), bArr);
                        } catch (Throwable unused) {
                            afVar = null;
                        }
                        if (afVar != null) {
                            nBPHomePageNearbyProViewModel.setUserInfo(NBPNewHomeRepository.copyUserInfo$default(afVar, null, null, 0, null, str2, null, null, null, -514, 63));
                        }
                        nBPHomePageNearbyProViewModel.assembleFullTags();
                    }
                }
            }
            FetchStatus fetchStatus = FetchStatus.FETCH_LOADING;
            nBPHomePageNearbyProViewModel.setUserInfoState(fetchStatus);
            NBPNewHomeRepository.fetchUserInfo$default(appId, accountType, str, new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchUserInfo$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(af afVar2) {
                    FollowStatus followStatus;
                    s35.aa aaVar;
                    af afVar3 = afVar2;
                    NBPHomePageBaseViewModel.this.setUserInfoState(FetchStatus.FETCH_STATE_SUCCESS);
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomePageBaseViewModel.this;
                    boolean z17 = afVar3.f433215i0;
                    ReadWriteProperty readWriteProperty = nBPHomePageBaseViewModel.likesOnlySelf$delegate;
                    KProperty<?>[] kPropertyArr = NBPHomePageBaseViewModel.$$delegatedProperties;
                    readWriteProperty.setValue(nBPHomePageBaseViewModel, kPropertyArr[14], Boolean.valueOf(z17));
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel2.followOnlySelf$delegate.setValue(nBPHomePageBaseViewModel2, kPropertyArr[16], Boolean.valueOf(afVar3.f433216j0));
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomePageBaseViewModel.this;
                    int i3 = afVar3.f433217k0;
                    FollowStatus[] values = FollowStatus.values();
                    int length = values.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length) {
                            followStatus = null;
                            break;
                        }
                        followStatus = values[i16];
                        if (followStatus.value == i3) {
                            break;
                        }
                        i16++;
                    }
                    if (followStatus == null) {
                        followStatus = FollowStatus.NO_FOLLOWED;
                    }
                    nBPHomePageBaseViewModel3.setFollowState(followStatus);
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel4.setUserInfo(nBPHomePageBaseViewModel4.isSelf ? NBPNewHomeRepository.copyUserInfo$default(afVar3, null, null, 0, null, str2, null, null, null, -514, 63) : afVar3);
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = NBPHomePageBaseViewModel.this;
                    if (!nBPHomePageBaseViewModel5.isSelf) {
                        int calculateTagLines = nBPHomePageBaseViewModel5.calculateTagLines(afVar3);
                        ReadWriteProperty readWriteProperty2 = nBPHomePageBaseViewModel5.tagViewLines$delegate;
                        KProperty<?>[] kPropertyArr2 = NBPHomePageBaseViewModel.$$delegatedProperties;
                        readWriteProperty2.setValue(nBPHomePageBaseViewModel5, kPropertyArr2[1], Integer.valueOf(calculateTagLines));
                        NBPHomePageBaseViewModel.this.prepareCollapsedTags();
                        af userInfo4 = NBPHomePageBaseViewModel.this.getUserInfo();
                        if (userInfo4 != null && (aaVar = userInfo4.f433202a0) != null) {
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel6 = NBPHomePageBaseViewModel.this;
                            nBPHomePageBaseViewModel6.getTacitGuestList().addAll(aaVar.f433192f);
                            nBPHomePageBaseViewModel6.tacitGuestTitle$delegate.setValue(nBPHomePageBaseViewModel6, kPropertyArr2[8], aaVar.f433191e);
                        }
                    } else {
                        nBPHomePageBaseViewModel5.assembleFullTags();
                    }
                    return Unit.INSTANCE;
                }
            }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchUserInfo$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str4) {
                    num.intValue();
                    NBPHomePageBaseViewModel.this.setUserInfoState(FetchStatus.FETCH_STATE_NET_ERROR);
                    return Unit.INSTANCE;
                }
            });
            a aVar = nBPHomePageNearbyProViewModel.roundParam;
            Function1<q35.d, Unit> function1 = new Function1<q35.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchFollowData$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(q35.d dVar) {
                    q35.d dVar2 = dVar;
                    NBPHomePageBaseViewModel.this.setTotalFansCount(dVar2.f428319f);
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomePageBaseViewModel.this;
                    int i3 = dVar2.f428318e;
                    ReadWriteProperty readWriteProperty = nBPHomePageBaseViewModel.totalFollowsCount$delegate;
                    KProperty<?>[] kPropertyArr = NBPHomePageBaseViewModel.$$delegatedProperties;
                    readWriteProperty.setValue(nBPHomePageBaseViewModel, kPropertyArr[18], Integer.valueOf(i3));
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel2.roundParam = dVar2.f428320h;
                    nBPHomePageBaseViewModel2.isLoadingFansCount$delegate.setValue(nBPHomePageBaseViewModel2, kPropertyArr[19], Boolean.FALSE);
                    return Unit.INSTANCE;
                }
            };
            Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchFollowData$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str4) {
                    num.intValue();
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel.isLoadingFansCount$delegate.setValue(nBPHomePageBaseViewModel, NBPHomePageBaseViewModel.$$delegatedProperties[19], Boolean.FALSE);
                    KLog.INSTANCE.e("NBPHomePageBaseViewModel", "fetchFollowData: error. msg: " + str4);
                    return Unit.INSTANCE;
                }
            };
            q35.c cVar = new q35.c(QQNearbyModule.Companion.getInstance().getCommonExtInfo(), 3, true, true, true, str, aVar, 0, 2);
            NBPNewHomeRepository$fetchFollowData$1 nBPNewHomeRepository$fetchFollowData$1 = new NBPNewHomeRepository$fetchFollowData$1(appId, function1, function2);
            QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.follow", "SsoGetFollowData", appId, new a(i.d(cVar))));
            QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(nBPNewHomeRepository$fetchFollowData$1);
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(qQStrangerSsoRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1), 6);
            nBPHomePageNearbyProViewModel.fetchFeedList(true);
            if (nBPHomePageNearbyProViewModel.isSelf) {
                nBPHomePageNearbyProViewModel.setTacitState(fetchStatus);
                int appId2 = nBPHomePageNearbyProViewModel.getAppId();
                NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle"), new QQStrangerSsoService$sendProxyRequest$1(new NBPNewHomeRepository$fetchTacitList$1(appId2, nBPHomePageNearbyProViewModel.getAccountType(), nBPHomePageNearbyProViewModel.accountId, new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchTacitList$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(k kVar) {
                        int collectionSizeOrDefault2;
                        k kVar2 = kVar;
                        NBPHomePageBaseViewModel.this.tacitListTodaySize = kVar2.f433248f.size();
                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchTacitList size: "), NBPHomePageBaseViewModel.this.tacitListTodaySize, KLog.INSTANCE, "NBPHomePageBaseViewModel");
                        NBPHomePageBaseViewModel.this.getTacitMyList().clear();
                        NBPHomePageBaseViewModel.this.tacitListTodaySize = kVar2.f433248f.size();
                        com.tencent.kuikly.core.reactive.collection.c<Tacit> tacitMyList = NBPHomePageBaseViewModel.this.getTacitMyList();
                        List<z> list2 = kVar2.f433248f;
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : list2) {
                            if (((z) obj).C == 0) {
                                arrayList2.add(obj);
                            }
                        }
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            arrayList3.add(TacitKt.toTacit((z) it5.next()));
                        }
                        tacitMyList.addAll(arrayList3);
                        NBPHomePageBaseViewModel.this.setTacitState(FetchStatus.FETCH_STATE_SUCCESS);
                        return Unit.INSTANCE;
                    }
                }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$fetchTacitList$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Integer num, String str4) {
                        num.intValue();
                        NBPHomePageBaseViewModel.this.setTacitState(FetchStatus.FETCH_STATE_NET_ERROR);
                        return Unit.INSTANCE;
                    }
                })), new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoGetDailyQuestion", appId2, new a(i.d(new j())))), null, 6);
            }
            NBPHomePageBaseViewModel.access$fetchMyAllTacitList(nBPHomePageNearbyProViewModel);
            TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$Companion$created$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomePageBaseViewModel.this;
                    NBPHomePageBaseViewModel.Companion companion3 = NBPHomePageBaseViewModel.Companion;
                    nBPHomePageBaseViewModel.getClass();
                    com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
                    com.tencent.kuikly.core.module.k.b((com.tencent.kuikly.core.module.k) cVar2.g().acquireModule("KRNotifyModule"), "NearbyFeedLikeStatusChangedEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$registerFeedLikeStatusChangeEvent$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            e eVar2 = eVar;
                            AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("registerLikeEvent received like status changed notify with data: ", eVar2, KLog.INSTANCE, "NBPHomePageBaseViewModel");
                            if (eVar2 != null) {
                                String p19 = eVar2.p("feedId");
                                boolean z17 = eVar2.k("isLike", 0) == 1;
                                if (!z17) {
                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomePageBaseViewModel.this;
                                    if (nBPHomePageBaseViewModel2.isSelf) {
                                        Iterator<n> it5 = nBPHomePageBaseViewModel2.getLikedFeedList().iterator();
                                        int i3 = 0;
                                        while (true) {
                                            if (!it5.hasNext()) {
                                                i3 = -1;
                                                break;
                                            }
                                            if (Intrinsics.areEqual(p19, it5.next().f425193d)) {
                                                break;
                                            }
                                            i3++;
                                        }
                                        if (i3 != -1) {
                                            NBPHomePageBaseViewModel.this.getLikedFeedList().remove(i3);
                                        }
                                    }
                                }
                                if (z17) {
                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomePageBaseViewModel.this;
                                    if (nBPHomePageBaseViewModel3.isSelf) {
                                        Iterator<n> it6 = nBPHomePageBaseViewModel3.getFeedList().iterator();
                                        int i16 = 0;
                                        while (true) {
                                            if (!it6.hasNext()) {
                                                i16 = -1;
                                                break;
                                            }
                                            if (Intrinsics.areEqual(p19, it6.next().f425193d)) {
                                                break;
                                            }
                                            i16++;
                                        }
                                        Iterator<n> it7 = NBPHomePageBaseViewModel.this.getLikedFeedList().iterator();
                                        int i17 = 0;
                                        while (true) {
                                            if (!it7.hasNext()) {
                                                i17 = -1;
                                                break;
                                            }
                                            if (Intrinsics.areEqual(p19, it7.next().f425193d)) {
                                                break;
                                            }
                                            i17++;
                                        }
                                        if (i17 == -1 && i16 != -1) {
                                            NBPHomePageBaseViewModel.this.getLikedFeedList().add(0, NBPHomePageBaseViewModel.this.getFeedList().get(i16));
                                        }
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel2.getClass();
                    com.tencent.kuikly.core.module.k.b((com.tencent.kuikly.core.module.k) cVar2.g().acquireModule("KRNotifyModule"), "NEARBY_CHANGE_LIKE_LIST_VISIBLE", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$registerChangeLikeListVisible$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            e eVar2 = eVar;
                            if (eVar2 != null) {
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomePageBaseViewModel.this;
                                nBPHomePageBaseViewModel3.likesOnlySelf$delegate.setValue(nBPHomePageBaseViewModel3, NBPHomePageBaseViewModel.$$delegatedProperties[14], Boolean.valueOf(eVar2.f("likesOnlySelf")));
                            }
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomePageBaseViewModel.this;
                    if (nBPHomePageBaseViewModel3.isSelf) {
                        com.tencent.kuikly.core.module.k.b((com.tencent.kuikly.core.module.k) cVar2.g().acquireModule("KRNotifyModule"), "NEARBY_FANS_COUNT_CHANGED_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$addFollowCountChangeEvent$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar) {
                                e eVar2 = eVar;
                                if (eVar2 != null && Intrinsics.areEqual(eVar2.p(ReportDataBuilder.KEY_ACCOUNT_ID), NBPHomePageBaseViewModel.this.accountId)) {
                                    NBPHomePageBaseViewModel.this.setTotalFansCount(eVar2.j(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT));
                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPHomePageBaseViewModel.this;
                                    nBPHomePageBaseViewModel4.totalFollowsCount$delegate.setValue(nBPHomePageBaseViewModel4, NBPHomePageBaseViewModel.$$delegatedProperties[18], Integer.valueOf(eVar2.j("following_count")));
                                }
                                return Unit.INSTANCE;
                            }
                        }, 2, null);
                    }
                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel4.getClass();
                    com.tencent.kuikly.core.module.k.b((com.tencent.kuikly.core.module.k) cVar2.g().acquireModule("KRNotifyModule"), "NEARBY_HOMEPAGE_FOLLOW_STATUS_CHANGED", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$addFollowStateChangeEvent$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            e eVar2 = eVar;
                            if (eVar2 != null) {
                                boolean f16 = eVar2.f("doFollow");
                                String p19 = eVar2.p("accountId");
                                KLog.INSTANCE.i("NBPHomePageBaseViewModel", "Follow state changed to : " + f16 + ", current follow state: " + NBPHomePageBaseViewModel.this.getFollowState() + ", accountId: " + p19);
                                if (Intrinsics.areEqual(NBPHomePageBaseViewModel.this.accountId, p19) && NBPHomePageBaseViewModel.this.getFollowState() == FollowStatus.NO_FOLLOWED && f16) {
                                    NBPHomePageBaseViewModel.this.setFollowState(FollowStatus.FOLLOWED);
                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = NBPHomePageBaseViewModel.this;
                                    nBPHomePageBaseViewModel5.setTotalFansCount(nBPHomePageBaseViewModel5.getTotalFansCount() + 1);
                                } else if (Intrinsics.areEqual(NBPHomePageBaseViewModel.this.accountId, p19) && NBPHomePageBaseViewModel.this.getFollowState() == FollowStatus.FOLLOWED && !f16) {
                                    NBPHomePageBaseViewModel.this.setFollowState(FollowStatus.NO_FOLLOWED);
                                    NBPHomePageBaseViewModel.this.setTotalFansCount(r5.getTotalFansCount() - 1);
                                } else if (Intrinsics.areEqual(NBPHomePageBaseViewModel.this.accountId, p19) && NBPHomePageBaseViewModel.this.getFollowState() == FollowStatus.FOLLOW_BACK && f16) {
                                    NBPHomePageBaseViewModel.this.setFollowState(FollowStatus.MUTUAL_FOLLOW);
                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel6 = NBPHomePageBaseViewModel.this;
                                    nBPHomePageBaseViewModel6.setTotalFansCount(nBPHomePageBaseViewModel6.getTotalFansCount() + 1);
                                } else if (Intrinsics.areEqual(NBPHomePageBaseViewModel.this.accountId, p19) && NBPHomePageBaseViewModel.this.getFollowState() == FollowStatus.MUTUAL_FOLLOW && !f16) {
                                    NBPHomePageBaseViewModel.this.setFollowState(FollowStatus.FOLLOW_BACK);
                                    NBPHomePageBaseViewModel.this.setTotalFansCount(r5.getTotalFansCount() - 1);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = NBPHomePageBaseViewModel.this;
                    nBPHomePageBaseViewModel5.getClass();
                    com.tencent.kuikly.core.module.k.b((com.tencent.kuikly.core.module.k) cVar2.g().acquireModule("KRNotifyModule"), "NEARBY_CHANGE_FANS_LIST_VISIBLE", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$addFollowsOnlySelfChangeEvent$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            e eVar2 = eVar;
                            if (eVar2 != null) {
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel6 = NBPHomePageBaseViewModel.this;
                                nBPHomePageBaseViewModel6.followOnlySelf$delegate.setValue(nBPHomePageBaseViewModel6, NBPHomePageBaseViewModel.$$delegatedProperties[16], Boolean.valueOf(eVar2.f("followsOnlySelf")));
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("followOnlySelf changed to : ");
                                m17.append(NBPHomePageBaseViewModel.this.getFollowOnlySelf());
                                kLog2.i("NBPHomePageBaseViewModel", m17.toString());
                            }
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                    return Unit.INSTANCE;
                }
            });
            return nBPHomePageNearbyProViewModel;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if ((r4.length() > 0) == true) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getTagStartOffset(af afVar) {
        boolean z16 = true;
        int i3 = !(afVar != null && afVar.f433218m == 0) ? 42 : 0;
        if (afVar != null && (r4 = afVar.f433214i) != null) {
        }
        z16 = false;
        return z16 ? i3 + 64 : i3;
    }

    public final void updateLikeNum(e eVar) {
        if (eVar == null) {
            return;
        }
        String q16 = eVar.q("feedId", "");
        int i3 = 0;
        if (q16.length() == 0) {
            return;
        }
        int k3 = eVar.k("count", 0);
        Iterator<n> it = getFeedList().iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().f425193d, q16)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1) {
            n nVar = getFeedList().get(i3);
            ac acVar = nVar.E;
            getFeedList().set(i3, new n(q16, nVar.f425194e, nVar.f425195f, nVar.f425196h, nVar.f425197i, nVar.f425198m, nVar.C, nVar.D, acVar != null ? new ac(acVar.f425119d, k3, acVar.f425121f, acVar.f425122h, acVar.f425123i, acVar.f425124m) : null, nVar.F, nVar.G, nVar.H, nVar.I, nVar.J, nVar.K, nVar.L, 458752));
        }
    }

    public void openMyTacit() {
    }

    public void addFriend(Function0<Unit> function0, Function0<Unit> function02) {
    }

    public void openAio(e eVar, int i3) {
    }
}
