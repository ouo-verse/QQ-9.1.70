package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import c01.c;
import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$handle$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$request$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedLikeRepo$strangerFeedLikeRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedLikeRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo$fetchFeedList$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerGetFeedListRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ClickLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CommentPanelState;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsData;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModelKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentInputOpenEvent;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.aq;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import oicq.wlogin_sdk.tools.util;
import p35.ab;
import p35.ac;
import p35.n;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPArticleFeedDetailVM {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "feedList", "getFeedList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "headFeed", "getHeadFeed()Lcom/tencent/hippykotlin/demo/pages/nearby/article_feed_detail/NBPArticleFeedModel;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "footerText", "getFooterText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "showBottomBar", "getShowBottomBar()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "showMoreActionSheet", "getShowMoreActionSheet()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "pageState", "getPageState()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "navTitle", "getNavTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "headFeedFooterTitle", "getHeadFeedFooterTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "firstScreenHasBack", "getFirstScreenHasBack()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "bottomContentInsertHeight", "getBottomContentInsertHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "didClickUnFollowButton", "getDidClickUnFollowButton()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "didClickFollowButton", "getDidClickFollowButton()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "quickComments", "getQuickComments()Ljava/util/List;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "aiQuickComments", "getAiQuickComments()Ljava/util/List;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "isHeadFeedManualDelete", "isHeadFeedManualDelete()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailVM.class, "buttonText", "getButtonText()Ljava/lang/String;", 0)};
    public final ReadWriteProperty aiQuickComments$delegate;
    public int appId;
    public final Set<String> appearItemIds;
    public final ReadWriteProperty bottomContentInsertHeight$delegate;
    public final ReadWriteProperty buttonText$delegate;
    public aa<NBPFeedCommentExtraView> commentExtraRef;
    public String commentId;
    public final String commentPagerId;
    public String commentReplyId;
    public a cookie;
    public n currentSelectFeed;
    public final ReadWriteProperty didClickFollowButton$delegate;
    public final ReadWriteProperty didClickUnFollowButton$delegate;
    public String feedId;
    public boolean filterContentSizeChanged;
    public Pair<Float, Float> firstFeedImageSize;
    public String firstFeedImageUrl;
    public final ReadWriteProperty firstScreenHasBack$delegate;
    public aa<FooterRefreshView> footerRef;
    public boolean hasFollowed;
    public final ReadWriteProperty headFeedFooterTitle$delegate;
    public boolean isEnd;
    public final ReadWriteProperty isHeadFeedManualDelete$delegate;
    public final FastClickUtils likeFastClickUtils;
    public aa<aq<?, ?>> listViewRef;
    public final ReadWriteProperty navTitle$delegate;
    public g pageData;
    public final ReadWriteProperty pageState$delegate;
    public int posterGender;
    public String posterUserId;
    public final ReadWriteProperty quickComments$delegate;
    public StrangerFeedRepo repo;
    public Float restoreOffsetWhenKeyBoardHide;
    public final ReadWriteProperty showMoreActionSheet$delegate;
    public boolean showReplyInput;
    public final int source;
    public aa<NBPFeedCommentsView> topFeedCommentsViewRef;
    public String viewerAvatar;
    public String viewerConstellation;
    public String viewerNickName;
    public String viewerUserId;
    public final ReadWriteProperty feedList$delegate = c.b();
    public final ReadWriteProperty headFeed$delegate = c.a(null);
    public final ReadWriteProperty footerText$delegate = c.a("\u52a0\u8f7d\u66f4\u591a\u52a8\u6001...");
    public final ReadWriteProperty showBottomBar$delegate = c.a(Boolean.TRUE);

    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FooterRefreshState.values().length];
            try {
                iArr[FooterRefreshState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FooterRefreshState.REFRESHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FooterRefreshState.FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NBPArticleFeedDetailVM(String str, int i3) {
        List emptyList;
        List emptyList2;
        this.commentPagerId = str;
        this.source = i3;
        Boolean bool = Boolean.FALSE;
        this.showMoreActionSheet$delegate = c.a(bool);
        this.pageState$delegate = c.a(0);
        this.navTitle$delegate = c.a("");
        this.headFeedFooterTitle$delegate = c.a("");
        this.firstScreenHasBack$delegate = c.a(bool);
        this.bottomContentInsertHeight$delegate = c.a(Float.valueOf(0.0f));
        this.didClickUnFollowButton$delegate = c.a(bool);
        this.didClickFollowButton$delegate = c.a(bool);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.quickComments$delegate = c.a(emptyList);
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.aiQuickComments$delegate = c.a(emptyList2);
        this.isHeadFeedManualDelete$delegate = c.a(bool);
        this.appId = 2;
        this.feedId = "";
        this.posterUserId = "";
        this.viewerUserId = "";
        this.viewerNickName = "";
        this.viewerAvatar = "";
        this.viewerConstellation = "";
        this.commentId = "";
        this.commentReplyId = "";
        this.firstFeedImageUrl = "";
        this.likeFastClickUtils = new FastClickUtils(200L);
        this.cookie = a.f30290b;
        this.posterGender = -1;
        this.pageData = new g();
        this.appearItemIds = new LinkedHashSet();
        this.buttonText$delegate = c.a("\u5173\u6ce8");
    }

    public final void appendData(List<n> list) {
        int collectionSizeOrDefault;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(createFeedModel$default(this, (n) obj, false, i3 != list.size() - 1, null, null, false, 120));
            i3 = i16;
        }
        getFeedList().addAll(arrayList);
    }

    public final NBPArticleFeedModel createDeletedFeedModel() {
        int i3 = this.appId;
        String str = this.viewerUserId;
        String str2 = this.viewerConstellation;
        getDTReportPageParams();
        NBPArticleFeedModel nBPArticleFeedModel = new NBPArticleFeedModel(i3, str, str2, 1, null, false);
        nBPArticleFeedModel.setFeedHadDeleted();
        return nBPArticleFeedModel;
    }

    public final NBPArticleFeedModel createFeedFooterModel() {
        int i3 = this.appId;
        String str = this.viewerUserId;
        String str2 = this.viewerConstellation;
        getDTReportPageParams();
        NBPArticleFeedModel nBPArticleFeedModel = new NBPArticleFeedModel(i3, str, str2, 2, null, false);
        nBPArticleFeedModel.setShowDivider(false);
        return nBPArticleFeedModel;
    }

    public final void fetchFirstScreenArticleFeedList() {
        StrangerFeedRepo strangerFeedRepo = this.repo;
        if (strangerFeedRepo != null) {
            String str = this.posterUserId;
            a aVar = this.cookie;
            String str2 = this.feedId;
            Function3<ab, Integer, String, Unit> function3 = new Function3<ab, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$fetchFirstScreenArticleFeedList$1
                {
                    super(3);
                }

                /* JADX WARN: Removed duplicated region for block: B:24:0x014e  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x0158  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x0172  */
                @Override // kotlin.jvm.functions.Function3
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(ab abVar, Integer num, String str3) {
                    NBPArticleFeedDetailVM nBPArticleFeedDetailVM;
                    Object first;
                    Object first2;
                    ab abVar2 = abVar;
                    int intValue = num.intValue();
                    NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = NBPArticleFeedDetailVM.this;
                    nBPArticleFeedDetailVM2.getClass();
                    boolean z16 = false;
                    if (intValue == 0) {
                        if ((abVar2 != null ? abVar2.f425113d : null) != null && (!abVar2.f425113d.isEmpty())) {
                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) abVar2.f425113d);
                            n nVar = (n) first;
                            if (nBPArticleFeedDetailVM2.getHeadFeed() != null) {
                                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) nBPArticleFeedDetailVM2.getFeedList());
                                NBPArticleFeedModel nBPArticleFeedModel = (NBPArticleFeedModel) first2;
                                if (!Intrinsics.areEqual(nVar.f425193d, nBPArticleFeedDetailVM2.feedId)) {
                                    nBPArticleFeedModel.setFeedHadDeleted();
                                    NearbyProUtilsKt.postOnNBPArticleFeedDetailFirstFeedDeleted(nBPArticleFeedDetailVM2.appId, nBPArticleFeedDetailVM2.feedId);
                                    KLog.INSTANCE.i("NBPArticleFeedDetailVM", "fetchFirstScreenArticleFeedList had HeadFeed, but feed had delete");
                                } else {
                                    nBPArticleFeedModel.updateFeed(nVar);
                                    NearbyProUtilsKt.postOnGetNBPArticleFeedDetailFirstFeed(nBPArticleFeedDetailVM2.appId, nBPArticleFeedDetailVM2.source, nVar);
                                    KLog.INSTANCE.i("NBPArticleFeedDetailVM", "fetchFirstScreenArticleFeedList had HeadFeed, update HeadFeed");
                                }
                            } else {
                                if (!Intrinsics.areEqual(nVar.f425193d, nBPArticleFeedDetailVM2.feedId)) {
                                    nBPArticleFeedDetailVM2.getFeedList().add(nBPArticleFeedDetailVM2.createDeletedFeedModel());
                                    NearbyProUtilsKt.postOnNBPArticleFeedDetailFirstFeedDeleted(nBPArticleFeedDetailVM2.appId, nBPArticleFeedDetailVM2.feedId);
                                    KLog.INSTANCE.i("NBPArticleFeedDetailVM", "fetchFirstScreenArticleFeedList not had HeadFeed, feed had delete");
                                } else {
                                    KLog.INSTANCE.i("NBPArticleFeedDetailVM", "fetchFirstScreenArticleFeedList not had HeadFeed, create HeadFeed");
                                    com.tencent.kuikly.core.reactive.collection.c<NBPArticleFeedModel> feedList = nBPArticleFeedDetailVM2.getFeedList();
                                    NBPArticleFeedModel createHeadFeedModel = nBPArticleFeedDetailVM2.createHeadFeedModel(nVar, false);
                                    nBPArticleFeedDetailVM2.headFeed$delegate.setValue(nBPArticleFeedDetailVM2, NBPArticleFeedDetailVM.$$delegatedProperties[1], createHeadFeedModel);
                                    feedList.add(createHeadFeedModel);
                                    NearbyProUtilsKt.postOnGetNBPArticleFeedDetailFirstFeed(nBPArticleFeedDetailVM2.appId, nBPArticleFeedDetailVM2.source, nVar);
                                }
                                nBPArticleFeedDetailVM2.getFeedList().add(nBPArticleFeedDetailVM2.createFeedFooterModel());
                            }
                            af afVar = nVar.f425194e;
                            nBPArticleFeedDetailVM2.updatePosterGenderTitle(afVar != null ? afVar.f433218m : 0);
                            List<n> list = abVar2.f425113d;
                            NBPArticleFeedModel headFeed = nBPArticleFeedDetailVM2.getHeadFeed();
                            nBPArticleFeedDetailVM2.appendData(list.subList(((headFeed == null || !headFeed.getFeedHadDeleted()) ? 0 : 1) ^ 1, abVar2.f425113d.size()));
                            nBPArticleFeedDetailVM2.setPageState(2);
                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = NBPArticleFeedDetailVM.this;
                            if (abVar2 != null || (r11 = abVar2.f425115f) == null) {
                                a aVar2 = a.f30290b;
                            }
                            nBPArticleFeedDetailVM3.cookie = aVar2;
                            if (abVar2 != null && abVar2.f425114e) {
                                z16 = true;
                            }
                            nBPArticleFeedDetailVM3.isEnd = z16;
                            nBPArticleFeedDetailVM3.firstScreenHasBack$delegate.setValue(nBPArticleFeedDetailVM3, NBPArticleFeedDetailVM.$$delegatedProperties[8], Boolean.TRUE);
                            nBPArticleFeedDetailVM = NBPArticleFeedDetailVM.this;
                            if (nBPArticleFeedDetailVM.isEnd) {
                                nBPArticleFeedDetailVM.setFooterText("\u5df2\u52a0\u8f7d\u5168\u90e8\u52a8\u6001");
                            }
                            AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFirstScreenArticleFeedList, isEnd: "), NBPArticleFeedDetailVM.this.isEnd, KLog.INSTANCE, "NBPArticleFeedDetailVM");
                            return Unit.INSTANCE;
                        }
                    }
                    if (intValue == 0) {
                        if ((abVar2 != null ? abVar2.f425113d : null) != null && abVar2.f425113d.isEmpty()) {
                            if (nBPArticleFeedDetailVM2.getHeadFeed() != null) {
                                NBPArticleFeedModel headFeed2 = nBPArticleFeedDetailVM2.getHeadFeed();
                                if (headFeed2 != null) {
                                    headFeed2.setFeedHadDeleted();
                                }
                                NearbyProUtilsKt.postOnNBPArticleFeedDetailFirstFeedDeleted(nBPArticleFeedDetailVM2.appId, nBPArticleFeedDetailVM2.feedId);
                            } else {
                                nBPArticleFeedDetailVM2.getFeedList().add(nBPArticleFeedDetailVM2.createDeletedFeedModel());
                            }
                            nBPArticleFeedDetailVM2.setPageState(2);
                            KLog.INSTANCE.i("NBPArticleFeedDetailVM", "onFirstScreenFeedListRspBack: feedList empty");
                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM32 = NBPArticleFeedDetailVM.this;
                            if (abVar2 != null) {
                            }
                            a aVar22 = a.f30290b;
                            nBPArticleFeedDetailVM32.cookie = aVar22;
                            if (abVar2 != null) {
                                z16 = true;
                            }
                            nBPArticleFeedDetailVM32.isEnd = z16;
                            nBPArticleFeedDetailVM32.firstScreenHasBack$delegate.setValue(nBPArticleFeedDetailVM32, NBPArticleFeedDetailVM.$$delegatedProperties[8], Boolean.TRUE);
                            nBPArticleFeedDetailVM = NBPArticleFeedDetailVM.this;
                            if (nBPArticleFeedDetailVM.isEnd) {
                            }
                            AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFirstScreenArticleFeedList, isEnd: "), NBPArticleFeedDetailVM.this.isEnd, KLog.INSTANCE, "NBPArticleFeedDetailVM");
                            return Unit.INSTANCE;
                        }
                    }
                    if (nBPArticleFeedDetailVM2.getHeadFeed() == null) {
                        nBPArticleFeedDetailVM2.setPageState(1);
                    } else {
                        Utils.INSTANCE.currentBridgeModule().qToast("\u62c9\u53d6\u66f4\u591a\u6570\u636e\u5931\u8d25, \u8bf7\u9000\u51fa\u91cd\u8bd5!", QToastMode.Warning);
                    }
                    NBPArticleFeedDetailVM nBPArticleFeedDetailVM322 = NBPArticleFeedDetailVM.this;
                    if (abVar2 != null) {
                    }
                    a aVar222 = a.f30290b;
                    nBPArticleFeedDetailVM322.cookie = aVar222;
                    if (abVar2 != null) {
                    }
                    nBPArticleFeedDetailVM322.isEnd = z16;
                    nBPArticleFeedDetailVM322.firstScreenHasBack$delegate.setValue(nBPArticleFeedDetailVM322, NBPArticleFeedDetailVM.$$delegatedProperties[8], Boolean.TRUE);
                    nBPArticleFeedDetailVM = NBPArticleFeedDetailVM.this;
                    if (nBPArticleFeedDetailVM.isEnd) {
                    }
                    AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFirstScreenArticleFeedList, isEnd: "), NBPArticleFeedDetailVM.this.isEnd, KLog.INSTANCE, "NBPArticleFeedDetailVM");
                    return Unit.INSTANCE;
                }
            };
            CommonProxyService.INSTANCE.request(new StrangerGetFeedListRequest(strangerFeedRepo.appId, str, aVar, str2), new StrangerFeedRepo$fetchFeedList$1(strangerFeedRepo, str, str2, function3));
        }
    }

    public final NBPArticleFeedModel findFeedModel(String str) {
        Object obj;
        Iterator<NBPArticleFeedModel> it = getFeedList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NBPArticleFeedModel next = it.next();
            n feed = next.getFeed();
            if (Intrinsics.areEqual(feed != null ? feed.f425193d : null, str)) {
                obj = next;
                break;
            }
        }
        return (NBPArticleFeedModel) obj;
    }

    public final List<QuickCommentItem> getAiQuickComments() {
        return (List) this.aiQuickComments$delegate.getValue(this, $$delegatedProperties[13]);
    }

    public final float getBottomContentInsertHeight() {
        return ((Number) this.bottomContentInsertHeight$delegate.getValue(this, $$delegatedProperties[9])).floatValue();
    }

    public final e getDTReportPageParams() {
        int i3 = this.source;
        if (i3 == 15) {
            i3 = 1;
        }
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_dynamic_detail");
        nearbyDTBaseParams.t("nearby_kl_appid", this.appId);
        nearbyDTBaseParams.t("nearby_dynamic_detail_entrance", i3);
        nearbyDTBaseParams.v("nearby_kl_first_feed_id", this.feedId);
        nearbyDTBaseParams.v("nearby_kl_user_id", this.posterUserId);
        return nearbyDTBaseParams;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NBPArticleFeedModel> getFeedList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.feedList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final NBPArticleFeedModel getHeadFeed() {
        return (NBPArticleFeedModel) this.headFeed$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final List<QuickCommentItem> getQuickComments() {
        return (List) this.quickComments$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final boolean getShowBottomBar() {
        return ((Boolean) this.showBottomBar$delegate.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final boolean isHost() {
        return Intrinsics.areEqual(this.posterUserId, this.viewerUserId);
    }

    public final boolean isNearby() {
        return this.appId == 2;
    }

    public final void onAvatarClick(NBPArticleFeedModel nBPArticleFeedModel) {
        String str;
        af afVar;
        n feed = nBPArticleFeedModel.getFeed();
        if (feed == null || (afVar = feed.f425194e) == null || (str = StrangerUtilsKt.getUserId(afVar, this.appId)) == null) {
            str = "0";
        }
        String str2 = str;
        boolean isHost = isHost();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onAvatarClick: ");
        m3.append(this.appId);
        m3.append(", ");
        m3.append(isHost);
        m3.append(", ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, str2, kLog, "NBPArticleFeedDetailVM");
        NBPJumpUtil.INSTANCE.jumpPersonaPage(this.appId, str2, isHost, false, HomepageSource.FEED_DETAIL_HEAD, this.feedId);
    }

    public final void onFeedActionSheetClose() {
        KLog.INSTANCE.i("NBPArticleFeedDetailVM", "onFeedActionSheetClose");
        this.currentSelectFeed = null;
        this.showMoreActionSheet$delegate.setValue(this, $$delegatedProperties[4], Boolean.FALSE);
    }

    public final void onFeedLongPress(NBPArticleFeedModel nBPArticleFeedModel) {
        KLog.INSTANCE.i("NBPArticleFeedDetailVM", "onFeedLongPress");
        this.currentSelectFeed = nBPArticleFeedModel.getFeed();
        this.showMoreActionSheet$delegate.setValue(this, $$delegatedProperties[4], Boolean.TRUE);
    }

    public final void onHeadFeedBottomBarClick(NBPArticleFeedModel nBPArticleFeedModel, CommentPanelState commentPanelState) {
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onHeadFeedBottomBarClick: "), this.appId, KLog.INSTANCE, "NBPArticleFeedDetailVM");
        onCommentClick(nBPArticleFeedModel, commentPanelState);
    }

    public final void onLikeIconClick(final NBPArticleFeedModel nBPArticleFeedModel, boolean z16, ClickLocation clickLocation) {
        String str;
        KLog kLog = KLog.INSTANCE;
        kLog.i("NBPArticleFeedDetailVM", "onLikeIconClick");
        if (this.likeFastClickUtils.isFastDoubleClick()) {
            kLog.i("NBPArticleFeedDetailVM", "isFastDoubleClick");
            return;
        }
        if (z16) {
            nBPArticleFeedModel.likeData.doDoubleClickAnimation(clickLocation);
            if (nBPArticleFeedModel.likeData.getIcon().isLiked) {
                return;
            }
        }
        final boolean z17 = !nBPArticleFeedModel.likeData.getIcon().isLiked;
        updateLikeUI(nBPArticleFeedModel, z17, -1);
        int i3 = this.appId;
        int i16 = nBPArticleFeedModel.likeData.getNumberData().number;
        boolean z18 = nBPArticleFeedModel.likeData.getIcon().isLiked;
        n feed = nBPArticleFeedModel.getFeed();
        if (feed == null || (str = feed.f425193d) == null) {
            str = "";
        }
        String str2 = str;
        String str3 = this.posterUserId;
        String valueOf = String.valueOf(hashCode());
        Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$onLikeIconClick$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                if (!bool.booleanValue()) {
                    NBPArticleFeedDetailVM.this.updateLikeUI(nBPArticleFeedModel, !z17, -1);
                }
                return Unit.INSTANCE;
            }
        };
        StrangerFeedLikeRequest strangerFeedLikeRequest = new StrangerFeedLikeRequest(i3, str2, z18 ? 1 : 0, str3);
        StrangerFeedLikeRepo$strangerFeedLikeRequest$1 strangerFeedLikeRepo$strangerFeedLikeRequest$1 = new StrangerFeedLikeRepo$strangerFeedLikeRequest$1(function1, z18, i16, str2, valueOf);
        a aVar = new a(i.d(strangerFeedLikeRequest.getRequest()));
        int appId = strangerFeedLikeRequest.getAppId();
        CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(strangerFeedLikeRepo$strangerFeedLikeRequest$1, strangerFeedLikeRequest);
        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", "QQStranger.FeedSvr", " method=");
        m3.append("SsoDoLike");
        kLog.i("CommonProxyService", m3.toString());
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + "QQStranger.FeedSvr.SsoDoLike");
        CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, "QQStranger.FeedSvr", "SsoDoLike", aVar);
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
        k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.t("count", i16);
        eVar.v("feedId", str2);
        eVar.t("isLike", z18 ? 1 : 0);
        if (valueOf.length() > 0) {
            eVar.v("extInfo", valueOf);
        }
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "NearbyFeedLikeStatusChangedEvent", eVar, false, 4, null);
    }

    public final void scrollToPosition(float f16) {
        aq<?, ?> b16;
        aa<aq<?, ?>> aaVar = this.listViewRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            ScrollerView.setContentOffset$default(b16, 0.0f, f16, true, null, 8, null);
        }
        KLog.INSTANCE.i("NBPArticleFeedDetailVM", "scrollToPosition: " + f16);
    }

    public final void setButtonText(String str) {
        this.buttonText$delegate.setValue(this, $$delegatedProperties[15], str);
    }

    public final void setDidClickFollowButton(boolean z16) {
        this.didClickFollowButton$delegate.setValue(this, $$delegatedProperties[11], Boolean.valueOf(z16));
    }

    public final void setFooterText(String str) {
        this.footerText$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final void setPageState(int i3) {
        this.pageState$delegate.setValue(this, $$delegatedProperties[5], Integer.valueOf(i3));
    }

    public final void updateLikeUI(NBPArticleFeedModel nBPArticleFeedModel, boolean z16, int i3) {
        int i16;
        nBPArticleFeedModel.likeData.updateLiked(z16);
        if (i3 >= 0) {
            nBPArticleFeedModel.likeData.updateNumber(i3);
            return;
        }
        if (z16) {
            i16 = nBPArticleFeedModel.likeData.getNumberData().number + 1;
        } else {
            i16 = nBPArticleFeedModel.likeData.getNumberData().number - 1;
        }
        NBPLikeData.updateData$default(nBPArticleFeedModel.likeData, i16, Boolean.valueOf(z16));
    }

    public final void updatePosterGenderTitle(int i3) {
        String str;
        if (this.posterGender == i3) {
            return;
        }
        this.posterGender = i3;
        if (isHost()) {
            str = "\u6211";
        } else if (this.posterGender == 1) {
            str = "\u4ed6";
        } else {
            str = "\u5979";
        }
        String m3 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(str, "\u7684\u52a8\u6001");
        ReadWriteProperty readWriteProperty = this.navTitle$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[6], m3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u66f4\u591a");
        this.headFeedFooterTitle$delegate.setValue(this, kPropertyArr[7], OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb5, str, "\u7684\u52a8\u6001"));
        KLog kLog = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("updatePosterGenderTitle: ");
        m16.append(isHost());
        m16.append(", ");
        m16.append(i3);
        kLog.i("NBPArticleFeedDetailVM", m16.toString());
    }

    public final NBPArticleFeedModel createHeadFeedModel(n nVar, boolean z16) {
        String str = this.commentId;
        String str2 = str.length() == 0 ? null : str;
        String str3 = this.commentReplyId;
        NBPArticleFeedModel createFeedModel$default = createFeedModel$default(this, nVar, true, false, str2, str3.length() == 0 ? null : str3, z16, 64);
        createFeedModel$default.setShowDivider(false);
        return createFeedModel$default;
    }

    public final void dtReportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e dTReportPageParams = getDTReportPageParams();
        dTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, dTReportPageParams);
    }

    public final void dtReportElementClick(String str, String str2, e eVar) {
        if (str == null) {
            return;
        }
        e dTReportPageParams = getDTReportPageParams();
        dTReportPageParams.v("dt_eid", str2);
        dTReportPageParams.v("nearby_kl_feed_id", str);
        if (eVar != null) {
            Iterator<String> c16 = eVar.c();
            while (c16.hasNext()) {
                String next = c16.next();
                dTReportPageParams.v(next, eVar.e(next));
            }
        }
        dTReportPageParams.v("cur_pg", getDTReportPageParams());
        dTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTReportPageParams);
    }

    public final void dtReportElementImp(String str, String str2, e eVar) {
        if (str == null) {
            return;
        }
        e dTReportPageParams = getDTReportPageParams();
        dTReportPageParams.v("dt_eid", str2);
        dTReportPageParams.v("nearby_kl_feed_id", str);
        if (eVar != null) {
            Iterator<String> c16 = eVar.c();
            while (c16.hasNext()) {
                String next = c16.next();
                dTReportPageParams.v(next, eVar.e(next));
            }
        }
        dTReportPageParams.v("cur_pg", getDTReportPageParams());
        dTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTReportPageParams);
    }

    public final void onCommentClick(NBPArticleFeedModel nBPArticleFeedModel, CommentPanelState commentPanelState) {
        String str;
        String str2;
        af afVar;
        String str3;
        if (nBPArticleFeedModel.isHeadFeed) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("open input view: ");
            n feed = nBPArticleFeedModel.getFeed();
            m3.append(feed != null ? feed.f425193d : null);
            kLog.i("NBPArticleFeedDetailVM", m3.toString());
            String u16 = BridgeManager.f117344a.u();
            int i3 = this.appId;
            n feed2 = nBPArticleFeedModel.getFeed();
            INBPFeedCommentExtraEvent.DefaultImpls.dispatch(new NBPFeedCommentInputOpenEvent(u16, i3, (feed2 == null || (str3 = feed2.f425193d) == null) ? "" : str3, this.commentPagerId, null, null, null, null, commentPanelState, getQuickComments(), getAiQuickComments()));
            return;
        }
        n feed3 = nBPArticleFeedModel.getFeed();
        if (feed3 == null || (afVar = feed3.f425194e) == null || (str = StrangerUtilsKt.getUserId(afVar, this.appId)) == null) {
            str = "0";
        }
        String str4 = str;
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("open comment view: ");
        n feed4 = nBPArticleFeedModel.getFeed();
        StringBuilder m17 = VasBusinessReportData$$ExternalSyntheticOutline0.m(m16, feed4 != null ? feed4.f425193d : null, ", ", str4, ", ");
        m17.append(this.appId);
        m17.append(", ");
        m17.append(this.viewerUserId);
        m17.append(", ");
        m17.append(this.viewerNickName);
        m17.append(", ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m17, this.viewerAvatar, kLog2, "NBPArticleFeedDetailVM");
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        int i16 = this.appId;
        String str5 = this.viewerUserId;
        String str6 = this.viewerNickName;
        String str7 = this.viewerAvatar;
        n feed5 = nBPArticleFeedModel.getFeed();
        companion.openFeedCommentPage(2, i16, str5, str6, str7, str4, (feed5 == null || (str2 = feed5.f425193d) == null) ? "" : str2);
    }

    public final void onItemViewClick(NBPArticleFeedModel nBPArticleFeedModel) {
        String str;
        if (nBPArticleFeedModel.isHeadFeed) {
            return;
        }
        n feed = nBPArticleFeedModel.getFeed();
        if (feed == null || (str = feed.f425193d) == null) {
            str = "0";
        }
        String str2 = str;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onItemViewClick: ");
        m3.append(this.appId);
        m3.append(", ");
        m3.append(str2);
        m3.append(", ");
        m3.append(this.viewerUserId);
        m3.append(", ");
        m3.append(this.viewerNickName);
        m3.append(", ");
        m3.append(this.viewerAvatar);
        m3.append(", ");
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, this.source, kLog, "NBPArticleFeedDetailVM");
        String str3 = this.posterUserId;
        UserSelfBaseInfo userSelfBaseInfo = new UserSelfBaseInfo(this.appId, this.viewerUserId, this.viewerNickName, this.viewerAvatar);
        n feed2 = nBPArticleFeedModel.getFeed();
        NBPJumpUtil.jumpArticleFeedDetailPage$default(str3, str2, userSelfBaseInfo, 6, feed2 == null ? new n(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287) : feed2, null, null, 96);
    }

    public static NBPArticleFeedModel createFeedModel$default(NBPArticleFeedDetailVM nBPArticleFeedDetailVM, n nVar, boolean z16, boolean z17, String str, String str2, boolean z18, int i3) {
        p35.g gVar;
        String str3 = (i3 & 8) != 0 ? null : str;
        String str4 = (i3 & 16) != 0 ? null : str2;
        boolean z19 = (i3 & 32) != 0 ? false : z18;
        nBPArticleFeedDetailVM.getClass();
        p35.g copy$default = (z19 || (gVar = nVar.J) == null) ? null : NBPFeedCommentsViewModelKt.copy$default(gVar, nVar.G);
        ac acVar = z19 ? null : nVar.E;
        int i16 = nBPArticleFeedDetailVM.appId;
        String str5 = nBPArticleFeedDetailVM.viewerUserId;
        String str6 = nBPArticleFeedDetailVM.viewerConstellation;
        NBPFeedCommentsData nBPFeedCommentsData = new NBPFeedCommentsData(i16, 1, str5, nBPArticleFeedDetailVM.viewerNickName, nBPArticleFeedDetailVM.viewerAvatar, nBPArticleFeedDetailVM.posterUserId, nVar.f425193d, copy$default, acVar, str3, str4, nBPArticleFeedDetailVM.showReplyInput);
        nBPArticleFeedDetailVM.getDTReportPageParams();
        NBPArticleFeedModel nBPArticleFeedModel = new NBPArticleFeedModel(i16, str5, str6, 1, nBPFeedCommentsData, z16);
        nBPArticleFeedModel.updateFeed(nVar);
        nBPArticleFeedModel.setShowDivider(z17);
        return nBPArticleFeedModel;
    }
}
