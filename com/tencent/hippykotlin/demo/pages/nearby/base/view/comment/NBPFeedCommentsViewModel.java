package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import c01.c;
import c45.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommentAndReplyRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$handle$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$request$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetCommentAndReplyByIdRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerGetFeedDetailRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentDeleteConfirmClickEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentDeleteConfirmOpenEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentInputClosedEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentInputOpenEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentMenuClickEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentMenuOpenEvent;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mm.plugin.appbrand.jsapi.sensor.JsApiEnableDeviceOrientation;
import com.tencent.mobileqq.nearbypro.utils.api.impl.NearbyProJubaoApiImpl;
import com.tencent.qqmini.sdk.widget.ToastView;
import defpackage.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;
import p35.ac;
import p35.ae;
import p35.f;
import p35.g;
import p35.h;
import p35.i;
import p35.n;
import p35.p;
import p35.t;
import r25.b;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPFeedCommentsViewModel implements INBPFeedCommentExtraHandler {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsViewModel.class, "ready", "getReady()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsViewModel.class, "commentsCount", "getCommentsCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsViewModel.class, "commentItems", "getCommentItems()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsViewModel.class, "likesCount", "getLikesCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsViewModel.class, "likeUsers", "getLikeUsers()Ljava/util/List;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsViewModel.class, "isMeLiked", "isMeLiked()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsViewModel.class, "moreLoaded", "getMoreLoaded()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsViewModel.class, "hasMore", "getHasMore()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsViewModel.class, ToastView.ICON_LOADING, "getLoading()Z", 0)};
    public final int appId;
    public boolean autoInputShown;
    public final ReadWriteProperty commentItems$delegate;
    public final String commentPagerId;
    public final StrangerFeedCommentRepo commentRepo;
    public final ReadWriteProperty commentsCount$delegate;
    public final NBPFeedCommentsData data;
    public final NBPFeedCommentExtraManager extraManager;
    public final FastClickUtils fastClickUtil;
    public final String feedId;
    public final StrangerFeedRepo feedRepo;
    public final ReadWriteProperty hasMore$delegate;
    public final ReadWriteProperty isMeLiked$delegate;
    public g lastCommentsPageData;
    public String likeNotifyCallbackRef;
    public final ReadWriteProperty likeUsers$delegate;
    public final ReadWriteProperty likesCount$delegate;
    public final ReadWriteProperty loading$delegate;
    public final ReadWriteProperty moreLoaded$delegate;
    public final Function2<NBPCommentVO, NBPReplyVO, Unit> onAdded;
    public final Function1<Integer, Unit> onCountChange;
    public final Function2<Boolean, Integer, Unit> onFirstPageLoaded;
    public final Function2<NBPCommentVO, NBPReplyVO, Unit> onShowInput;
    public final String posterUserId;
    public final ReadWriteProperty ready$delegate;
    public final String reportPageId;
    public boolean submitting;
    public final String viewerUserId;

    /* JADX WARN: Multi-variable type inference failed */
    public NBPFeedCommentsViewModel(String str, String str2, NBPFeedCommentsData nBPFeedCommentsData, Function2<? super NBPCommentVO, ? super NBPReplyVO, Unit> function2, Function1<? super Integer, Unit> function1, Function2<? super Boolean, ? super Integer, Unit> function22, Function2<? super NBPCommentVO, ? super NBPReplyVO, Unit> function23) {
        List emptyList;
        this.commentPagerId = str;
        this.reportPageId = str2;
        this.data = nBPFeedCommentsData;
        this.onAdded = function2;
        this.onCountChange = function1;
        this.onFirstPageLoaded = function22;
        this.onShowInput = function23;
        Boolean bool = Boolean.FALSE;
        this.ready$delegate = c.a(bool);
        this.feedRepo = new StrangerFeedRepo(nBPFeedCommentsData.getAppId());
        this.commentRepo = new StrangerFeedCommentRepo(nBPFeedCommentsData.getAppId());
        this.commentsCount$delegate = c.a(0);
        this.commentItems$delegate = c.b();
        this.likesCount$delegate = c.a(0);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.likeUsers$delegate = c.a(emptyList);
        this.isMeLiked$delegate = c.a(bool);
        this.moreLoaded$delegate = c.a(bool);
        this.hasMore$delegate = c.a(Boolean.TRUE);
        this.loading$delegate = c.a(bool);
        this.extraManager = new NBPFeedCommentExtraManager(str, this);
        this.appId = nBPFeedCommentsData.getAppId();
        this.feedId = nBPFeedCommentsData.getFeedId();
        this.viewerUserId = nBPFeedCommentsData.getViewerUserId();
        this.posterUserId = nBPFeedCommentsData.getPosterUserId();
        if (nBPFeedCommentsData.getCommentInfo() != null && nBPFeedCommentsData.getLikeInfo() != null) {
            fillFirstPageData(nBPFeedCommentsData.getCommentInfo(), nBPFeedCommentsData.getLikeInfo(), false);
        } else {
            loadFirstPageData();
        }
        registerNotifyCallbacks();
        this.fastClickUtil = new FastClickUtils(500L);
    }

    public static final void access$handleDeleteSuccess(NBPFeedCommentsViewModel nBPFeedCommentsViewModel, NBPCommentVO nBPCommentVO, final NBPReplyVO nBPReplyVO) {
        List mutableList;
        int i3 = -1;
        if (nBPFeedCommentsViewModel.getCommentsCount() > 0) {
            if (nBPReplyVO != null) {
                nBPFeedCommentsViewModel.setCommentsCount(nBPFeedCommentsViewModel.getCommentsCount() - 1);
            } else {
                nBPFeedCommentsViewModel.setCommentsCount(nBPFeedCommentsViewModel.getCommentsCount() - (nBPCommentVO.respNum + 1));
            }
            nBPFeedCommentsViewModel.notifyCommentCountChange(nBPFeedCommentsViewModel.getCommentsCount());
        }
        if (nBPReplyVO == null) {
            nBPFeedCommentsViewModel.getCommentItems().remove(nBPCommentVO);
            return;
        }
        Iterator<NBPCommentVO> it = nBPFeedCommentsViewModel.getCommentItems().iterator();
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (Intrinsics.areEqual(it.next().f114212id, nBPCommentVO.f114212id)) {
                i3 = i16;
                break;
            }
            i16++;
        }
        if (i3 < 0) {
            return;
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) nBPCommentVO.raw.f425178m);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableList, (Function1) new Function1<ae, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$handleDeleteSuccess$newRpt$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ae aeVar) {
                return Boolean.valueOf(Intrinsics.areEqual(aeVar.f425131f, NBPReplyVO.this.f114214id));
            }
        });
        nBPFeedCommentsViewModel.getCommentItems().set(i3, new NBPCommentVO(new h(nBPCommentVO.user, nBPCommentVO.cTime, nBPCommentVO.f114212id, nBPCommentVO.content, nBPCommentVO.respNum - 1, mutableList, 64), nBPFeedCommentsViewModel.data.posterUserId, nBPCommentVO.defaultFoldReplies));
    }

    /* JADX WARN: Type inference failed for: r9v11, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO>, java.util.ArrayList] */
    public static final void access$handleSendFailed(NBPFeedCommentsViewModel nBPFeedCommentsViewModel, int i3, String str, NBPCommentVO nBPCommentVO) {
        int collectionSizeOrDefault;
        List mutableList;
        nBPFeedCommentsViewModel.getClass();
        if (!NearbyProUtilsKt.isShowBackendErrorMsg(i3)) {
            str = "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
        }
        Utils.INSTANCE.currentBridgeModule().qToast(str, QToastMode.Info);
        int i16 = -1;
        nBPFeedCommentsViewModel.setCommentsCount(nBPFeedCommentsViewModel.getCommentsCount() - 1);
        nBPFeedCommentsViewModel.notifyCommentCountChange(nBPFeedCommentsViewModel.getCommentsCount());
        if (!nBPCommentVO.submitted) {
            nBPFeedCommentsViewModel.getCommentItems().remove(nBPCommentVO);
            return;
        }
        Iterator<NBPCommentVO> it = nBPFeedCommentsViewModel.getCommentItems().iterator();
        int i17 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (Intrinsics.areEqual(it.next().f114212id, nBPCommentVO.f114212id)) {
                i16 = i17;
                break;
            }
            i17++;
        }
        af afVar = nBPCommentVO.user;
        int i18 = nBPCommentVO.cTime;
        String str2 = nBPCommentVO.f114212id;
        i iVar = nBPCommentVO.content;
        int i19 = nBPCommentVO.respNum - 1;
        ?? r95 = nBPCommentVO.replies;
        ArrayList arrayList = new ArrayList();
        Iterator it5 = r95.iterator();
        while (it5.hasNext()) {
            Object next = it5.next();
            if (((NBPReplyVO) next).submitted) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it6 = arrayList.iterator();
        while (it6.hasNext()) {
            arrayList2.add(((NBPReplyVO) it6.next()).raw);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        nBPFeedCommentsViewModel.getCommentItems().set(i16, new NBPCommentVO(new h(afVar, i18, str2, iVar, i19, mutableList, 64), nBPFeedCommentsViewModel.data.posterUserId, nBPCommentVO.getRepliesFold()));
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NBPCommentVO> getCommentItems() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.commentItems$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final int getCommentsCount() {
        return ((Number) this.commentsCount$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final boolean getEmptyViewShowCommentBtn() {
        if (getCommentsCount() == 0) {
            NBPFeedCommentsData nBPFeedCommentsData = this.data;
            if (!Intrinsics.areEqual(nBPFeedCommentsData.viewerUserId, nBPFeedCommentsData.posterUserId)) {
                return true;
            }
        }
        return false;
    }

    public final boolean getHasMore() {
        return ((Boolean) this.hasMore$delegate.getValue(this, $$delegatedProperties[7])).booleanValue();
    }

    public final List<LikeUser> getLikeUsers() {
        return (List) this.likeUsers$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final int getLikesCount() {
        return ((Number) this.likesCount$delegate.getValue(this, $$delegatedProperties[3])).intValue();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO>, java.util.ArrayList] */
    public final boolean isRealCommentsLessThanTotal() {
        int size = getCommentItems().size();
        Iterator<NBPCommentVO> it = getCommentItems().iterator();
        while (it.hasNext()) {
            size += it.next().replies.size();
        }
        return size < getCommentsCount();
    }

    public final void loadFirstPageData() {
        final StrangerFeedRepo strangerFeedRepo = this.feedRepo;
        final String str = this.feedId;
        final Function3<n, Integer, String, Unit> function3 = new Function3<n, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$loadFirstPageData$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Integer num, String str2) {
                g gVar;
                ac acVar;
                n nVar2 = nVar;
                int intValue = num.intValue();
                String str3 = str2;
                if (nVar2 == null || (gVar = nVar2.J) == null) {
                    gVar = new g(true, 7);
                }
                if (nVar2 == null || (acVar = nVar2.E) == null) {
                    acVar = new ac(null, 0, null, 0, 63);
                }
                if (intValue != 0) {
                    if (intValue != 5009 && intValue != 16000) {
                        if (!NearbyProUtilsKt.isShowBackendErrorMsg(intValue)) {
                            str3 = "\u83b7\u53d6\u6570\u636e\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                        }
                        if (((Intrinsics.areEqual(NBPFeedCommentsViewModel.this.reportPageId, "pg_nearby_dynamic_detail") && Intrinsics.areEqual(str3, "\u83b7\u53d6\u6570\u636e\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5")) ? 0 : 1) != 0) {
                            Utils.INSTANCE.currentBridgeModule().qToast(str3, QToastMode.Info);
                        }
                    }
                    NBPFeedCommentsViewModel.this.onFirstPageLoaded.invoke(Boolean.FALSE, Integer.valueOf(gVar.f425169d));
                    NBPFeedCommentsViewModel.this.fillFirstPageData(gVar, acVar, true);
                } else {
                    NBPFeedCommentsViewModel.this.fillFirstPageData(NBPFeedCommentsViewModelKt.copy$default(gVar, nVar2 != null ? nVar2.G : 0), acVar, true);
                }
                return Unit.INSTANCE;
            }
        };
        strangerFeedRepo.getClass();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedDetail: appId=");
        m3.append(strangerFeedRepo.appId);
        m3.append(" feedId=");
        m3.append(str);
        kLog.i("StrangerFeedRepo", m3.toString());
        CommonProxyService.INSTANCE.request(new StrangerGetFeedDetailRequest(strangerFeedRepo.appId, str), new Function4<t, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo$fetchFeedDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(t tVar, byte[] bArr, Integer num, String str2) {
                n nVar;
                ac acVar;
                n nVar2;
                ac acVar2;
                t tVar2 = tVar;
                int intValue = num.intValue();
                String str3 = str2;
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedDetail: rspIsNull=");
                m16.append(tVar2 == null);
                m16.append(" appId=");
                m16.append(StrangerFeedRepo.this.appId);
                m16.append(" feedId=");
                StringBuilder m17 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m16, str, ", code=", intValue, ", msg=");
                m17.append(str3);
                m17.append(", bizCode=");
                m17.append(tVar2 != null ? Integer.valueOf(tVar2.f425213d) : null);
                m17.append(", bizMsg=");
                m17.append(tVar2 != null ? tVar2.f425214e : null);
                m17.append(" \u70b9\u8d5e\u6570 ");
                m17.append((tVar2 == null || (nVar2 = tVar2.f425215f) == null || (acVar2 = nVar2.E) == null) ? null : Integer.valueOf(acVar2.f425120e));
                m17.append(" \u6211\u8d5e ");
                m17.append((tVar2 == null || (nVar = tVar2.f425215f) == null || (acVar = nVar.E) == null) ? null : Integer.valueOf(acVar.f425122h));
                m17.append(TokenParser.SP);
                kLog2.i("StrangerFeedRepo", m17.toString());
                if (intValue == 0 && tVar2 != null) {
                    int i3 = tVar2.f425213d;
                    if (i3 != 0) {
                        function3.invoke(null, Integer.valueOf(i3), tVar2.f425214e);
                    } else {
                        function3.invoke(tVar2.f425215f, Integer.valueOf(i3), tVar2.f425214e);
                    }
                } else {
                    function3.invoke(null, Integer.valueOf(intValue), str3);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void notifyCommentCountChange(int i3) {
        k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.v("feedId", this.feedId);
        eVar.t("commentCount", i3);
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "onNearbyProFeedCommentCountChange", eVar, false, 4, null);
        this.onCountChange.invoke(Integer.valueOf(i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onInputClosed(NBPFeedCommentInputClosedEvent nBPFeedCommentInputClosedEvent) {
        NBPReplyVO nBPReplyVO;
        NBPCommentVO nBPCommentVO;
        ?? r06;
        if (nBPFeedCommentInputClosedEvent.submit && Intrinsics.areEqual(nBPFeedCommentInputClosedEvent.openData.feedId, this.feedId) && !this.submitting) {
            Iterator<NBPCommentVO> it = getCommentItems().iterator();
            while (true) {
                nBPReplyVO = null;
                if (!it.hasNext()) {
                    nBPCommentVO = null;
                    break;
                } else {
                    nBPCommentVO = it.next();
                    if (Intrinsics.areEqual(nBPCommentVO.f114212id, nBPFeedCommentInputClosedEvent.openData.targetCommentId)) {
                        break;
                    }
                }
            }
            NBPCommentVO nBPCommentVO2 = nBPCommentVO;
            if (nBPCommentVO2 != null && (r06 = nBPCommentVO2.replies) != 0) {
                Iterator it5 = r06.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (Intrinsics.areEqual(((NBPReplyVO) next).f114214id, nBPFeedCommentInputClosedEvent.openData.targetReplyId)) {
                        nBPReplyVO = next;
                        break;
                    }
                }
                nBPReplyVO = nBPReplyVO;
            }
            doSendCommentOrReply(nBPCommentVO2, nBPReplyVO, nBPFeedCommentInputClosedEvent.inputText, nBPFeedCommentInputClosedEvent.isQuickComment);
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onMenuClick(NBPFeedCommentMenuClickEvent nBPFeedCommentMenuClickEvent) {
        NBPCommentVO nBPCommentVO;
        Object obj;
        i iVar;
        af afVar;
        String str;
        String str2;
        if (Intrinsics.areEqual(nBPFeedCommentMenuClickEvent.openData.feedId, this.feedId)) {
            int ordinal = nBPFeedCommentMenuClickEvent.action.ordinal();
            if (ordinal == 1) {
                String str3 = this.feedId;
                String str4 = this.commentPagerId;
                NBPFeedCommentMenuOpenEvent nBPFeedCommentMenuOpenEvent = nBPFeedCommentMenuClickEvent.openData;
                String str5 = nBPFeedCommentMenuOpenEvent.targetCommentId;
                String str6 = nBPFeedCommentMenuOpenEvent.targetReplyId;
                k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("feedId", str3, "pager_id", str4);
                m3.v("targetCommentId", str5);
                m3.v("targetReplyId", str6);
                k.d(kVar, "NBPFeedCommentDeleteConfirmOpenEvent", m3, false, 4, null);
                return;
            }
            if (ordinal != 2) {
                return;
            }
            Iterator<NBPCommentVO> it = getCommentItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    nBPCommentVO = null;
                    break;
                } else {
                    nBPCommentVO = it.next();
                    if (Intrinsics.areEqual(nBPCommentVO.f114212id, nBPFeedCommentMenuClickEvent.openData.targetCommentId)) {
                        break;
                    }
                }
            }
            NBPCommentVO nBPCommentVO2 = nBPCommentVO;
            if (nBPCommentVO2 == null) {
                return;
            }
            Iterator it5 = nBPCommentVO2.replies.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it5.next();
                    if (Intrinsics.areEqual(((NBPReplyVO) obj).f114214id, nBPFeedCommentMenuClickEvent.openData.targetReplyId)) {
                        break;
                    }
                }
            }
            NBPReplyVO nBPReplyVO = (NBPReplyVO) obj;
            if (nBPReplyVO == null) {
                iVar = nBPCommentVO2.content;
            } else {
                iVar = nBPReplyVO.content;
            }
            if ((nBPReplyVO == null || (afVar = nBPReplyVO.user) == null) && (afVar = nBPCommentVO2.user) == null) {
                return;
            }
            String valueOf = String.valueOf(afVar.f433207e);
            KLog kLog = KLog.INSTANCE;
            StringBuilder m16 = CacheDiskLru$$ExternalSyntheticOutline0.m("do report comment: userId=", valueOf, ", feedId=");
            m16.append(this.feedId);
            m16.append(", commentId=");
            m16.append(nBPCommentVO2.f114212id);
            m16.append(", replyId=");
            m16.append(nBPReplyVO != null ? nBPReplyVO.f114214id : null);
            m16.append(", content=");
            m16.append(iVar);
            kLog.i("NBPFeedCommentsViewModel", m16.toString());
            int i3 = this.appId;
            if (i3 == 1) {
                String str7 = this.feedId;
                String str8 = nBPCommentVO2.f114212id;
                String str9 = nBPReplyVO != null ? nBPReplyVO.f114214id : null;
                if (str9 == null) {
                    str = str7 + '-' + str8;
                } else {
                    str = str7 + '-' + str8 + '-' + str9;
                }
                QQNearbyModule.Companion.getInstance().jumpReportPageV2("100827", valueOf, str);
                return;
            }
            if (i3 != 2) {
                return;
            }
            String str10 = this.feedId;
            String str11 = nBPCommentVO2.f114212id;
            String str12 = nBPReplyVO != null ? nBPReplyVO.f114214id : null;
            if (str12 == null) {
                str2 = str10 + '-' + str11;
            } else {
                str2 = str10 + '-' + str11 + '-' + str12;
            }
            QQNearbyModule.Companion.getInstance().jumpReportPage(NearbyProJubaoApiImpl.KEY_NEARBY_PRO_FEED_COMMENT, valueOf, str2, null);
        }
    }

    public final void registerNotifyCallbacks() {
        this.likeNotifyCallbackRef = k.b((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NearbyFeedLikeStatusChangedEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$registerNotifyCallbacks$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                List listOf;
                List<LikeUser> plus;
                e eVar2 = eVar;
                if (eVar2 != null) {
                    if (Intrinsics.areEqual(NBPFeedCommentsViewModel.this.feedId, eVar2.p("feedId"))) {
                        af viewerUserInfo = NBPFeedCommentsViewModel.this.getViewerUserInfo();
                        boolean z16 = eVar2.k("isLike", 0) == 1;
                        if (z16) {
                            NBPFeedCommentsViewModel nBPFeedCommentsViewModel = NBPFeedCommentsViewModel.this;
                            if (!((Boolean) nBPFeedCommentsViewModel.isMeLiked$delegate.getValue(nBPFeedCommentsViewModel, NBPFeedCommentsViewModel.$$delegatedProperties[5])).booleanValue()) {
                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel2 = NBPFeedCommentsViewModel.this;
                                listOf = CollectionsKt__CollectionsJVMKt.listOf(new LikeUser(nBPFeedCommentsViewModel2.viewerUserId, viewerUserInfo.f433209f));
                                plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) NBPFeedCommentsViewModel.this.getLikeUsers());
                                nBPFeedCommentsViewModel2.setLikeUsers(plus);
                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel3 = NBPFeedCommentsViewModel.this;
                                nBPFeedCommentsViewModel3.setLikesCount(nBPFeedCommentsViewModel3.getLikesCount() + 1);
                            }
                        } else {
                            NBPFeedCommentsViewModel nBPFeedCommentsViewModel4 = NBPFeedCommentsViewModel.this;
                            List<LikeUser> likeUsers = nBPFeedCommentsViewModel4.getLikeUsers();
                            NBPFeedCommentsViewModel nBPFeedCommentsViewModel5 = NBPFeedCommentsViewModel.this;
                            ArrayList arrayList = new ArrayList();
                            for (Object obj : likeUsers) {
                                if (!Intrinsics.areEqual(((LikeUser) obj).userId, nBPFeedCommentsViewModel5.viewerUserId)) {
                                    arrayList.add(obj);
                                }
                            }
                            nBPFeedCommentsViewModel4.setLikeUsers(arrayList);
                            NBPFeedCommentsViewModel nBPFeedCommentsViewModel6 = NBPFeedCommentsViewModel.this;
                            if (((Boolean) nBPFeedCommentsViewModel6.isMeLiked$delegate.getValue(nBPFeedCommentsViewModel6, NBPFeedCommentsViewModel.$$delegatedProperties[5])).booleanValue()) {
                                NBPFeedCommentsViewModel.this.setLikesCount(r0.getLikesCount() - 1);
                            }
                        }
                        NBPFeedCommentsViewModel nBPFeedCommentsViewModel7 = NBPFeedCommentsViewModel.this;
                        nBPFeedCommentsViewModel7.isMeLiked$delegate.setValue(nBPFeedCommentsViewModel7, NBPFeedCommentsViewModel.$$delegatedProperties[5], Boolean.valueOf(z16));
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    public final void setCommentsCount(int i3) {
        this.commentsCount$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }

    public final void setLikeUsers(List<LikeUser> list) {
        this.likeUsers$delegate.setValue(this, $$delegatedProperties[4], list);
    }

    public final void setLikesCount(int i3) {
        this.likesCount$delegate.setValue(this, $$delegatedProperties[3], Integer.valueOf(i3));
    }

    public final void setLoading(boolean z16) {
        this.loading$delegate.setValue(this, $$delegatedProperties[8], Boolean.valueOf(z16));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        if ((r4.length() == 0) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a0, code lost:
    
        if ((r4.length() == 0) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final af getViewerUserInfo() {
        List emptyList;
        String str;
        String str2;
        List mutableList;
        Long longOrNull;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        NBPFeedCommentsData nBPFeedCommentsData = this.data;
        String str3 = nBPFeedCommentsData.viewerNickname;
        String str4 = nBPFeedCommentsData.viewerAvatar;
        int i3 = this.appId;
        if (i3 != 1) {
            str = "";
            if (i3 == 2) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.viewerUserId);
                r6 = longOrNull != null ? longOrNull.longValue() : 0L;
                UserDataManager userDataManager = UserDataManager.INSTANCE;
                String str5 = userDataManager.getUserSelfInfo().avatarDressBorderUrl;
                if (str5.length() > 0) {
                    emptyList = CollectionsKt__CollectionsJVMKt.listOf(new b(1001, new r25.c(str5, 23), 2));
                }
                String str6 = userDataManager.getUserSelfInfo().nickName;
                if (!(str6.length() == 0)) {
                    str3 = str6;
                }
                str2 = userDataManager.getUserSelfInfo().avatarUrl;
            }
        } else {
            str = this.viewerUserId;
            QQNearbyModule.Companion companion = QQNearbyModule.Companion;
            String str7 = companion.getInstance().getKLUserSelfInfo().userNickName;
            if (!(str7.length() == 0)) {
                str3 = str7;
            }
            str2 = companion.getInstance().getKLUserSelfInfo().userAvatar;
        }
        String str8 = str4;
        long j3 = r6;
        String str9 = str3;
        String str10 = str;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) emptyList);
        return new af(str10, j3, str9, 0, null, 0, null, null, str8, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, mutableList, null, null, false, false, -264, 251);
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onDeleteConfirmClick(NBPFeedCommentDeleteConfirmClickEvent nBPFeedCommentDeleteConfirmClickEvent) {
        NBPCommentVO nBPCommentVO;
        Object obj;
        if (Intrinsics.areEqual(nBPFeedCommentDeleteConfirmClickEvent.openData.feedId, this.feedId) && nBPFeedCommentDeleteConfirmClickEvent.f114215ok) {
            Iterator<NBPCommentVO> it = getCommentItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    nBPCommentVO = null;
                    break;
                } else {
                    nBPCommentVO = it.next();
                    if (Intrinsics.areEqual(nBPCommentVO.f114212id, nBPFeedCommentDeleteConfirmClickEvent.openData.targetCommentId)) {
                        break;
                    }
                }
            }
            final NBPCommentVO nBPCommentVO2 = nBPCommentVO;
            if (nBPCommentVO2 == null) {
                return;
            }
            Iterator it5 = nBPCommentVO2.replies.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it5.next();
                    if (Intrinsics.areEqual(((NBPReplyVO) obj).f114214id, nBPFeedCommentDeleteConfirmClickEvent.openData.targetReplyId)) {
                        break;
                    }
                }
            }
            final NBPReplyVO nBPReplyVO = (NBPReplyVO) obj;
            if (this.submitting) {
                return;
            }
            this.submitting = true;
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doDeleteComment: commentId=");
            m3.append(nBPCommentVO2.f114212id);
            m3.append(", replyId=");
            NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, nBPReplyVO != null ? nBPReplyVO.f114214id : null, kLog, "NBPFeedCommentsViewModel");
            if (nBPReplyVO == null) {
                StrangerFeedCommentRepo strangerFeedCommentRepo = this.commentRepo;
                final String str = this.feedId;
                final String str2 = nBPCommentVO2.f114212id;
                final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$doDeleteComment$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Integer num, String str3) {
                        int intValue = num.intValue();
                        String str4 = str3;
                        NBPFeedCommentsViewModel nBPFeedCommentsViewModel = NBPFeedCommentsViewModel.this;
                        nBPFeedCommentsViewModel.submitting = false;
                        if (intValue != 0) {
                            if (!NearbyProUtilsKt.isShowBackendErrorMsg(intValue)) {
                                str4 = "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
                            }
                            Utils.INSTANCE.currentBridgeModule().qToast(str4, QToastMode.Info);
                        } else {
                            NBPFeedCommentsViewModel.access$handleDeleteSuccess(nBPFeedCommentsViewModel, nBPCommentVO2, nBPReplyVO);
                        }
                        return Unit.INSTANCE;
                    }
                };
                strangerFeedCommentRepo.getClass();
                kLog.i("StrangerFeedCommentRepo", QUISkinImage$$ExternalSyntheticOutline0.m("deleteComment: feedId=", str, " commentId=", str2));
                CommentAndReplyRequest commentAndReplyRequest = new CommentAndReplyRequest(strangerFeedCommentRepo.appId, "DelComment", str, null, false, str2, null, null, 0, JsApiEnableDeviceOrientation.CTRL_INDEX);
                Function4<f, byte[], Integer, String, Unit> function4 = new Function4<f, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$deleteComment$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public final Unit invoke(f fVar, byte[] bArr, Integer num, String str3) {
                        f fVar2 = fVar;
                        int intValue = num.intValue();
                        String str4 = str3;
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deleteComment: rspIsNull=");
                        m16.append(fVar2 == null);
                        m16.append(" feedId=");
                        m16.append(str);
                        m16.append(" commentId=");
                        StringBuilder m17 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m16, str2, ", code=", intValue, ", msg=");
                        m17.append(str4);
                        m17.append(", bizCode=");
                        m17.append(fVar2 != null ? Integer.valueOf(fVar2.f425165d) : null);
                        m17.append(", bizMsg=");
                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m17, fVar2 != null ? fVar2.f425166e : null, kLog2, "StrangerFeedCommentRepo");
                        if (intValue != 0) {
                            function2.invoke(Integer.valueOf(intValue), str4);
                        } else if (fVar2 == null) {
                            function2.invoke(-1, "rsp is null");
                        } else {
                            function2.invoke(Integer.valueOf(fVar2.f425165d), fVar2.f425166e);
                        }
                        return Unit.INSTANCE;
                    }
                };
                a aVar = new a(c45.i.d(commentAndReplyRequest.getRequest()));
                int appId = commentAndReplyRequest.getAppId();
                String method = commentAndReplyRequest.getMethod();
                CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(function4, commentAndReplyRequest);
                StringBuilder m16 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", "QQStranger.FeedSvr", " method=");
                m16.append(method);
                kLog.i("CommonProxyService", m16.toString());
                APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + "QQStranger.FeedSvr." + method);
                CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, "QQStranger.FeedSvr", method, aVar);
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
                return;
            }
            StrangerFeedCommentRepo strangerFeedCommentRepo2 = this.commentRepo;
            final String str3 = this.feedId;
            final String str4 = nBPCommentVO2.f114212id;
            final String str5 = nBPReplyVO.f114214id;
            final Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$doDeleteComment$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str6) {
                    int intValue = num.intValue();
                    String str7 = str6;
                    NBPFeedCommentsViewModel nBPFeedCommentsViewModel = NBPFeedCommentsViewModel.this;
                    nBPFeedCommentsViewModel.submitting = false;
                    if (intValue != 0) {
                        if (!NearbyProUtilsKt.isShowBackendErrorMsg(intValue)) {
                            str7 = "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
                        }
                        Utils.INSTANCE.currentBridgeModule().qToast(str7, QToastMode.Info);
                    } else {
                        NBPFeedCommentsViewModel.access$handleDeleteSuccess(nBPFeedCommentsViewModel, nBPCommentVO2, nBPReplyVO);
                    }
                    return Unit.INSTANCE;
                }
            };
            strangerFeedCommentRepo2.getClass();
            StringBuilder a16 = j.a("deleteReply: feedId=", str3, " commentId=", str4, " replyId=");
            a16.append(str5);
            kLog.i("StrangerFeedCommentRepo", a16.toString());
            CommentAndReplyRequest commentAndReplyRequest2 = new CommentAndReplyRequest(strangerFeedCommentRepo2.appId, "DelReply", str3, null, false, str4, str5, null, 0, 408);
            Function4<f, byte[], Integer, String, Unit> function42 = new Function4<f, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$deleteReply$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public final Unit invoke(f fVar, byte[] bArr, Integer num, String str6) {
                    f fVar2 = fVar;
                    int intValue = num.intValue();
                    String str7 = str6;
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deleteReply: rspIsNull=");
                    m17.append(fVar2 == null);
                    m17.append(" feedId=");
                    m17.append(str3);
                    m17.append(" commentId=");
                    m17.append(str4);
                    m17.append(" replyId=");
                    StringBuilder m18 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m17, str5, ", code=", intValue, ", msg=");
                    m18.append(str7);
                    m18.append(", bizCode=");
                    m18.append(fVar2 != null ? Integer.valueOf(fVar2.f425165d) : null);
                    m18.append(", bizMsg=");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m18, fVar2 != null ? fVar2.f425166e : null, kLog2, "StrangerFeedCommentRepo");
                    if (intValue != 0) {
                        function22.invoke(Integer.valueOf(intValue), str7);
                    } else if (fVar2 == null) {
                        function22.invoke(-1, "rsp is null");
                    } else {
                        function22.invoke(Integer.valueOf(fVar2.f425165d), fVar2.f425166e);
                    }
                    return Unit.INSTANCE;
                }
            };
            a aVar2 = new a(c45.i.d(commentAndReplyRequest2.getRequest()));
            int appId2 = commentAndReplyRequest2.getAppId();
            String method2 = commentAndReplyRequest2.getMethod();
            CommonProxyService$request$1 commonProxyService$request$12 = new CommonProxyService$request$1(function42, commentAndReplyRequest2);
            StringBuilder m17 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId2, " service=", "QQStranger.FeedSvr", " method=");
            m17.append(method2);
            kLog.i("CommonProxyService", m17.toString());
            APICallTechReporter aPICallTechReporter2 = new APICallTechReporter(1, appId2 + util.base64_pad_url + "QQStranger.FeedSvr." + method2);
            CommonProxyRequest commonProxyRequest2 = new CommonProxyRequest(appId2, "QQStranger.FeedSvr", method2, aVar2);
            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest2, null, new CommonProxyService$handle$1(aPICallTechReporter2, commonProxyService$request$12), 6);
        }
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO>, java.util.ArrayList] */
    public final void fillFirstPageData(g gVar, ac acVar, boolean z16) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        NBPCommentVO nBPCommentVO;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fillFirstPageData: feedId=");
        m3.append(this.feedId);
        m3.append(" firstPageComments=");
        m3.append(gVar.f425170e.size());
        kLog.i("NBPFeedCommentsViewModel", m3.toString());
        setCommentsCount(gVar.f425169d);
        getCommentItems().clear();
        com.tencent.kuikly.core.reactive.collection.c<NBPCommentVO> commentItems = getCommentItems();
        List<h> list = gVar.f425170e;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new NBPCommentVO((h) it.next(), this.data.posterUserId, true));
        }
        commentItems.addAll(arrayList);
        this.lastCommentsPageData = gVar;
        this.hasMore$delegate.setValue(this, $$delegatedProperties[7], Boolean.valueOf(!gVar.f425172h));
        this.onCountChange.invoke(Integer.valueOf(getCommentsCount()));
        setLikesCount(acVar.f425120e);
        List<af> list2 = acVar.f425121f;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (af afVar : list2) {
            arrayList2.add(new LikeUser(StrangerUtilsKt.getUserId(afVar, this.appId), afVar.f433209f));
        }
        setLikeUsers(arrayList2);
        this.isMeLiked$delegate.setValue(this, $$delegatedProperties[5], Boolean.valueOf(acVar.f425122h == 1));
        if (z16) {
            e eVar = new e();
            eVar.v("feedId", this.feedId);
            eVar.t("commentCount", getCommentsCount());
            com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
            k.d((k) cVar.g().acquireModule("KRNotifyModule"), "onNearbyProFeedCommentCountChange", eVar, false, 4, null);
            KLog kLog2 = KLog.INSTANCE;
            kLog2.d("NBPFeedCommentsViewModel", "\u8bc4\u8bba\u6570\u66f4\u65b0\u901a\u77e5: " + eVar);
            e eVar2 = new e();
            eVar2.t("count", getLikesCount());
            eVar2.v("feedId", this.feedId);
            eVar2.t("isLike", acVar.f425122h);
            k.d((k) cVar.g().acquireModule("KRNotifyModule"), "NearbyFeedLikeStatusChangedEvent", eVar2, false, 4, null);
            kLog2.d("NBPFeedCommentsViewModel", "\u70b9\u8d5e\u6570\u66f4\u65b0\u901a\u77e5: " + eVar2);
        }
        final Function2<NBPCommentVO, NBPReplyVO, Unit> function2 = new Function2<NBPCommentVO, NBPReplyVO, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$fillFirstPageData$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(NBPCommentVO nBPCommentVO2, NBPReplyVO nBPReplyVO) {
                NBPCommentVO nBPCommentVO3 = nBPCommentVO2;
                NBPReplyVO nBPReplyVO2 = nBPReplyVO;
                if (nBPCommentVO3 != null) {
                    NBPFeedCommentsViewModel nBPFeedCommentsViewModel = NBPFeedCommentsViewModel.this;
                    if (nBPFeedCommentsViewModel.data.showReplyInput) {
                        nBPFeedCommentsViewModel.onShowInput.invoke(nBPCommentVO3, nBPReplyVO2);
                    }
                }
                NBPFeedCommentsViewModel nBPFeedCommentsViewModel2 = NBPFeedCommentsViewModel.this;
                nBPFeedCommentsViewModel2.onFirstPageLoaded.invoke(Boolean.TRUE, Integer.valueOf(nBPFeedCommentsViewModel2.getCommentsCount()));
                return Unit.INSTANCE;
            }
        };
        Object obj = null;
        if (this.autoInputShown) {
            function2.invoke(null, null);
        } else {
            this.autoInputShown = true;
            String str = this.data.replyCommentId;
            if (str == null || str.length() == 0) {
                function2.invoke(null, null);
            } else {
                Iterator<NBPCommentVO> it5 = getCommentItems().iterator();
                while (true) {
                    if (it5.hasNext()) {
                        nBPCommentVO = it5.next();
                        if (Intrinsics.areEqual(nBPCommentVO.f114212id, this.data.replyCommentId)) {
                            break;
                        }
                    } else {
                        nBPCommentVO = null;
                        break;
                    }
                }
                NBPCommentVO nBPCommentVO2 = nBPCommentVO;
                if (nBPCommentVO2 != null) {
                    Iterator it6 = nBPCommentVO2.replies.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        Object next = it6.next();
                        if (Intrinsics.areEqual(((NBPReplyVO) next).f114214id, this.data.replyReplyId)) {
                            obj = next;
                            break;
                        }
                    }
                    function2.invoke(nBPCommentVO2, obj);
                } else {
                    StrangerFeedCommentRepo strangerFeedCommentRepo = this.commentRepo;
                    final String str2 = this.feedId;
                    final String str3 = this.data.replyCommentId;
                    final Function1<h, Unit> function1 = new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$loadReplyCommentIfNeed$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO>, java.util.ArrayList] */
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(h hVar) {
                            h hVar2 = hVar;
                            NBPReplyVO nBPReplyVO = null;
                            if (hVar2 == null) {
                                KLog kLog3 = KLog.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadReplyCommentIfNeed: can't find comment: feedId=");
                                m16.append(NBPFeedCommentsViewModel.this.feedId);
                                m16.append(", commentId=");
                                m16.append(NBPFeedCommentsViewModel.this.data.replyCommentId);
                                kLog3.e("NBPFeedCommentsViewModel", m16.toString());
                                function2.invoke(null, null);
                                Utils.INSTANCE.currentBridgeModule().qToast("\u8be5\u8bc4\u8bba\u5df2\u5220\u9664", QToastMode.Info);
                            } else {
                                NBPCommentVO nBPCommentVO3 = new NBPCommentVO(hVar2, NBPFeedCommentsViewModel.this.data.posterUserId, true);
                                NBPFeedCommentsViewModel.this.getCommentItems().add(0, nBPCommentVO3);
                                Function2<NBPCommentVO, NBPReplyVO, Unit> function22 = function2;
                                ?? r26 = nBPCommentVO3.replies;
                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel = NBPFeedCommentsViewModel.this;
                                Iterator it7 = r26.iterator();
                                while (true) {
                                    if (!it7.hasNext()) {
                                        break;
                                    }
                                    Object next2 = it7.next();
                                    if (Intrinsics.areEqual(((NBPReplyVO) next2).f114214id, nBPFeedCommentsViewModel.data.replyReplyId)) {
                                        nBPReplyVO = next2;
                                        break;
                                    }
                                }
                                function22.invoke(nBPCommentVO3, nBPReplyVO);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    strangerFeedCommentRepo.getClass();
                    KLog kLog3 = KLog.INSTANCE;
                    kLog3.i("StrangerFeedCommentRepo", QUISkinImage$$ExternalSyntheticOutline0.m("getCommentAndReplyById: feedId=", str2, " commentId=", str3));
                    GetCommentAndReplyByIdRequest getCommentAndReplyByIdRequest = new GetCommentAndReplyByIdRequest(strangerFeedCommentRepo.appId, str2, str3);
                    Function4<p, byte[], Integer, String, Unit> function4 = new Function4<p, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$getCommentAndReplyById$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public final Unit invoke(p pVar, byte[] bArr, Integer num, String str4) {
                            p pVar2 = pVar;
                            int intValue = num.intValue();
                            String str5 = str4;
                            KLog kLog4 = KLog.INSTANCE;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getCommentAndReplyById: rspIsNull=");
                            m16.append(pVar2 == null);
                            m16.append(" feedId=");
                            m16.append(str2);
                            m16.append(" commentId=");
                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m16, str3, ", code=", intValue, ", msg="), str5, kLog4, "StrangerFeedCommentRepo");
                            if (intValue != 0) {
                                function1.invoke(null);
                            } else {
                                function1.invoke(pVar2 != null ? pVar2.f425202e : null);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    a aVar = new a(c45.i.d(getCommentAndReplyByIdRequest.getRequest()));
                    int appId = getCommentAndReplyByIdRequest.getAppId();
                    CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(function4, getCommentAndReplyByIdRequest);
                    StringBuilder m16 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", "QQStranger.FeedSvr", " method=");
                    m16.append("GetCommentAndReplyById");
                    kLog3.i("CommonProxyService", m16.toString());
                    APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + "QQStranger.FeedSvr.GetCommentAndReplyById");
                    CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, "QQStranger.FeedSvr", "GetCommentAndReplyById", aVar);
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
                }
            }
        }
        this.ready$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
    }

    public final void doSendCommentOrReply(NBPCommentVO nBPCommentVO, NBPReplyVO nBPReplyVO, String str, boolean z16) {
        List plus;
        List mutableList;
        Object last;
        Pair pair;
        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel;
        af afVar;
        String str2;
        String str3;
        if (this.submitting) {
            return;
        }
        this.submitting = true;
        KLog.INSTANCE.i("NBPFeedCommentsViewModel", "doSendCommentOrReply: " + str + ", isQuickComment=" + z16);
        setCommentsCount(getCommentsCount() + 1);
        notifyCommentCountChange(getCommentsCount());
        int i3 = 0;
        if (nBPCommentVO == null) {
            NBPCommentVO nBPCommentVO2 = new NBPCommentVO(new h(getViewerUserInfo(), (int) (zz0.a.f453719a.a() / 1000), "", new i(str), 0, (List) null, 112), this.data.posterUserId, true);
            getCommentItems().add(0, nBPCommentVO2);
            this.onAdded.invoke(nBPCommentVO2, null);
            pair = new Pair(nBPCommentVO2, null);
        } else {
            Iterator<NBPCommentVO> it = getCommentItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().f114212id, nBPCommentVO.f114212id)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                pair = new Pair(null, null);
            } else {
                ae aeVar = new ae(getViewerUserInfo(), (int) (zz0.a.f453719a.a() / 1000), "", new i(str), nBPReplyVO != null ? nBPReplyVO.user : null, 16);
                af afVar2 = nBPCommentVO.user;
                int i16 = nBPCommentVO.cTime;
                String str4 = nBPCommentVO.f114212id;
                i iVar = nBPCommentVO.content;
                int i17 = nBPCommentVO.respNum + 1;
                plus = CollectionsKt___CollectionsKt.plus((Collection<? extends ae>) ((Collection<? extends Object>) nBPCommentVO.raw.f425178m), aeVar);
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) plus);
                NBPCommentVO nBPCommentVO3 = new NBPCommentVO(new h(afVar2, i16, str4, iVar, i17, mutableList, 64), this.data.posterUserId, nBPCommentVO.getRepliesFold());
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) nBPCommentVO3.replies);
                NBPReplyVO nBPReplyVO2 = (NBPReplyVO) last;
                getCommentItems().set(i3, nBPCommentVO3);
                this.onAdded.invoke(nBPCommentVO3, nBPReplyVO2);
                pair = new Pair(nBPCommentVO3, nBPReplyVO2);
            }
        }
        final NBPCommentVO nBPCommentVO4 = (NBPCommentVO) pair.component1();
        final NBPReplyVO nBPReplyVO3 = (NBPReplyVO) pair.component2();
        if (nBPCommentVO4 == null) {
            KLog.INSTANCE.e("NBPFeedCommentsViewModel", "handlePreSend error: addOrUpdateComment is null");
            return;
        }
        if (nBPCommentVO == null) {
            StrangerFeedCommentRepo strangerFeedCommentRepo = this.commentRepo;
            final String str5 = this.feedId;
            final i iVar2 = new i(str);
            int i18 = this.data.source;
            final Function3<String, Integer, String, Unit> function3 = new Function3<String, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$doSendCommentOrReply$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(String str6, Integer num, String str7) {
                    String str8 = str6;
                    int intValue = num.intValue();
                    String str9 = str7;
                    NBPFeedCommentsViewModel.this.submitting = false;
                    if (intValue == 0) {
                        if (!(str8.length() == 0)) {
                            NBPFeedCommentsViewModel nBPFeedCommentsViewModel2 = NBPFeedCommentsViewModel.this;
                            NBPCommentVO nBPCommentVO5 = nBPCommentVO4;
                            NBPReplyVO nBPReplyVO4 = nBPReplyVO3;
                            nBPFeedCommentsViewModel2.getClass();
                            TimerKt.d(1000, new NBPFeedCommentsViewModel$handleSendSuccess$1(nBPReplyVO4, nBPCommentVO5, str8, nBPFeedCommentsViewModel2));
                            return Unit.INSTANCE;
                        }
                    }
                    NBPFeedCommentsViewModel.access$handleSendFailed(NBPFeedCommentsViewModel.this, intValue, str9, nBPCommentVO4);
                    return Unit.INSTANCE;
                }
            };
            strangerFeedCommentRepo.getClass();
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("postComment: feedId=", str5, " content=");
            m3.append(iVar2.f425179d);
            m3.append(", source=");
            m3.append(i18);
            kLog.i("StrangerFeedCommentRepo", m3.toString());
            CommentAndReplyRequest commentAndReplyRequest = new CommentAndReplyRequest(strangerFeedCommentRepo.appId, "Comment", str5, iVar2, z16, null, null, null, i18, 224);
            Function4<f, byte[], Integer, String, Unit> function4 = new Function4<f, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$postComment$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public final Unit invoke(f fVar, byte[] bArr, Integer num, String str6) {
                    f fVar2 = fVar;
                    int intValue = num.intValue();
                    String str7 = str6;
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("postComment: newId=");
                    m16.append(fVar2 != null ? fVar2.f425168h : null);
                    m16.append(" feedId=");
                    m16.append(str5);
                    m16.append(" content=");
                    StringBuilder m17 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m16, iVar2.f425179d, ", code=", intValue, ", msg=");
                    m17.append(str7);
                    m17.append(", bizCode=");
                    m17.append(fVar2 != null ? Integer.valueOf(fVar2.f425165d) : null);
                    m17.append(", bizMsg=");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m17, fVar2 != null ? fVar2.f425166e : null, kLog2, "StrangerFeedCommentRepo");
                    if (intValue != 0) {
                        function3.invoke("", Integer.valueOf(intValue), str7);
                    } else if (fVar2 == null) {
                        function3.invoke("", -1, "rsp is null");
                    } else {
                        function3.invoke(fVar2.f425168h, Integer.valueOf(fVar2.f425165d), fVar2.f425166e);
                    }
                    return Unit.INSTANCE;
                }
            };
            a aVar = new a(c45.i.d(commentAndReplyRequest.getRequest()));
            int appId = commentAndReplyRequest.getAppId();
            String method = commentAndReplyRequest.getMethod();
            CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(function4, commentAndReplyRequest);
            StringBuilder m16 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", "QQStranger.FeedSvr", " method=");
            m16.append(method);
            kLog.i("CommonProxyService", m16.toString());
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + "QQStranger.FeedSvr." + method);
            CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, "QQStranger.FeedSvr", method, aVar);
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
            return;
        }
        if (nBPReplyVO != null) {
            afVar = nBPReplyVO.user;
            nBPFeedCommentsViewModel = this;
        } else {
            nBPFeedCommentsViewModel = this;
            afVar = null;
        }
        StrangerFeedCommentRepo strangerFeedCommentRepo2 = nBPFeedCommentsViewModel.commentRepo;
        final String str6 = nBPFeedCommentsViewModel.feedId;
        final String str7 = nBPCommentVO.f114212id;
        if (nBPReplyVO == null || (str2 = nBPReplyVO.f114214id) == null) {
            str2 = "";
        }
        if (afVar == null || (str3 = StrangerUtilsKt.getUserId(afVar, nBPFeedCommentsViewModel.appId)) == null) {
            str3 = "";
        }
        final i iVar3 = new i(str);
        int i19 = nBPFeedCommentsViewModel.data.source;
        final Function3<String, Integer, String, Unit> function32 = new Function3<String, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$doSendCommentOrReply$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(String str8, Integer num, String str9) {
                String str10 = str8;
                int intValue = num.intValue();
                String str11 = str9;
                NBPFeedCommentsViewModel.this.submitting = false;
                if (intValue == 0) {
                    if (!(str10.length() == 0)) {
                        NBPFeedCommentsViewModel nBPFeedCommentsViewModel2 = NBPFeedCommentsViewModel.this;
                        NBPCommentVO nBPCommentVO5 = nBPCommentVO4;
                        NBPReplyVO nBPReplyVO4 = nBPReplyVO3;
                        nBPFeedCommentsViewModel2.getClass();
                        TimerKt.d(1000, new NBPFeedCommentsViewModel$handleSendSuccess$1(nBPReplyVO4, nBPCommentVO5, str10, nBPFeedCommentsViewModel2));
                        return Unit.INSTANCE;
                    }
                }
                NBPFeedCommentsViewModel.access$handleSendFailed(NBPFeedCommentsViewModel.this, intValue, str11, nBPCommentVO4);
                return Unit.INSTANCE;
            }
        };
        strangerFeedCommentRepo2.getClass();
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m17 = VasBusinessReportData$$ExternalSyntheticOutline0.m(j.a("replyComment: feedId=", str6, " commentId=", str7, " replyId="), str2, " targetTid=", str3, " content=");
        m17.append(iVar3.f425179d);
        m17.append(" source=");
        m17.append(i19);
        kLog2.i("StrangerFeedCommentRepo", m17.toString());
        CommentAndReplyRequest commentAndReplyRequest2 = new CommentAndReplyRequest(strangerFeedCommentRepo2.appId, "Reply", str6, iVar3, false, str7, str2, str3, i19, 16);
        final String str8 = str2;
        final String str9 = str3;
        Function4<f, byte[], Integer, String, Unit> function42 = new Function4<f, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$replyComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(f fVar, byte[] bArr, Integer num, String str10) {
                f fVar2 = fVar;
                int intValue = num.intValue();
                String str11 = str10;
                KLog kLog3 = KLog.INSTANCE;
                StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("replyComment: newId=");
                m18.append(fVar2 != null ? fVar2.f425168h : null);
                m18.append(" feedId=");
                m18.append(str6);
                m18.append(" commentId=");
                m18.append(str7);
                m18.append(" replyId=");
                m18.append(str8);
                m18.append(" targetTid=");
                m18.append(str9);
                m18.append(" content=");
                StringBuilder m19 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m18, iVar3.f425179d, ", code=", intValue, ", msg=");
                m19.append(str11);
                m19.append(", bizCode=");
                m19.append(fVar2 != null ? Integer.valueOf(fVar2.f425165d) : null);
                m19.append(", bizMsg=");
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m19, fVar2 != null ? fVar2.f425166e : null, kLog3, "StrangerFeedCommentRepo");
                if (intValue != 0) {
                    function32.invoke("", Integer.valueOf(intValue), str11);
                } else if (fVar2 == null) {
                    function32.invoke("", -1, "rsp is null");
                } else {
                    function32.invoke(fVar2.f425168h, Integer.valueOf(fVar2.f425165d), fVar2.f425166e);
                }
                return Unit.INSTANCE;
            }
        };
        a aVar2 = new a(c45.i.d(commentAndReplyRequest2.getRequest()));
        int appId2 = commentAndReplyRequest2.getAppId();
        String method2 = commentAndReplyRequest2.getMethod();
        CommonProxyService$request$1 commonProxyService$request$12 = new CommonProxyService$request$1(function42, commentAndReplyRequest2);
        StringBuilder m18 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId2, " service=", "QQStranger.FeedSvr", " method=");
        m18.append(method2);
        kLog2.i("CommonProxyService", m18.toString());
        APICallTechReporter aPICallTechReporter2 = new APICallTechReporter(1, appId2 + util.base64_pad_url + "QQStranger.FeedSvr." + method2);
        CommonProxyRequest commonProxyRequest2 = new CommonProxyRequest(appId2, "QQStranger.FeedSvr", method2, aVar2);
        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest2, null, new CommonProxyService$handle$1(aPICallTechReporter2, commonProxyService$request$12), 6);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onDeleteConfirmOpen(NBPFeedCommentDeleteConfirmOpenEvent nBPFeedCommentDeleteConfirmOpenEvent) {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onInputOpen(NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent) {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onInputOpened() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onMenuOpen(NBPFeedCommentMenuOpenEvent nBPFeedCommentMenuOpenEvent) {
    }
}
