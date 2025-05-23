package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import c01.c;
import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$handle$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService$request$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetCommentAndReplyRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CommentPanelState;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentInputOpenEvent;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ListContentView;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ab;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import defpackage.j;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import p35.ac;
import p35.g;
import p35.r;

/* loaded from: classes31.dex */
public final class NBPFeedCommentsView extends ComposeView<NBPFeedCommentsAttr, NBPFeedCommentsEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsView.class, "listHeight", "getListHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentsView.class, "enableLoadingShow", "getEnableLoadingShow()Z", 0)};
    public final String commentPagerId;
    public final NBPFeedCommentsData data;
    public final boolean fitHeight;
    public aa<aq<?, ?>> listRef;
    public final String pageId;
    public final boolean showEmptyTips;
    public final int showLoadingDelayMs;
    public final boolean showTotalCount;

    /* renamed from: vm, reason: collision with root package name */
    public NBPFeedCommentsViewModel f114213vm;
    public final ReadWriteProperty listHeight$delegate = c.a(Float.valueOf(0.0f));
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);
    public final ReadWriteProperty enableLoadingShow$delegate = c.a(Boolean.FALSE);

    public NBPFeedCommentsView(String str, String str2, NBPFeedCommentsData nBPFeedCommentsData, boolean z16, boolean z17, int i3, boolean z18) {
        this.commentPagerId = str;
        this.pageId = str2;
        this.data = nBPFeedCommentsData;
        this.fitHeight = z16;
        this.showEmptyTips = z17;
        this.showLoadingDelayMs = i3;
        this.showTotalCount = z18;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPFeedCommentsEvent access$getEvent(NBPFeedCommentsView nBPFeedCommentsView) {
        return (NBPFeedCommentsEvent) nBPFeedCommentsView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel = this.f114213vm;
        if (nBPFeedCommentsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            nBPFeedCommentsViewModel = null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel2 = NBPFeedCommentsViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPFeedCommentsViewModel nBPFeedCommentsViewModel3 = NBPFeedCommentsViewModel.this;
                        return Boolean.valueOf(((Boolean) nBPFeedCommentsViewModel3.ready$delegate.getValue(nBPFeedCommentsViewModel3, NBPFeedCommentsViewModel.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel3 = NBPFeedCommentsViewModel.this;
                final NBPFeedCommentsView nBPFeedCommentsView = this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel4 = NBPFeedCommentsViewModel.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NBPFeedCommentsViewModel.this.getLikesCount() > 0);
                            }
                        };
                        final NBPFeedCommentsView nBPFeedCommentsView2 = nBPFeedCommentsView;
                        ConditionViewKt.c(conditionView2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                ConditionView conditionView4 = conditionView3;
                                final NBPFeedCommentsView nBPFeedCommentsView3 = NBPFeedCommentsView.this;
                                final NBPFeedCommentsData nBPFeedCommentsData = nBPFeedCommentsView3.data;
                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel5 = nBPFeedCommentsView3.f114213vm;
                                if (nBPFeedCommentsViewModel5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                    nBPFeedCommentsViewModel5 = null;
                                }
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentLikes$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel6 = NBPFeedCommentsViewModel.this;
                                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentLikes$1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(NBPFeedCommentsViewModel.this.getLikesCount() > 0);
                                            }
                                        };
                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel7 = NBPFeedCommentsViewModel.this;
                                        final NBPFeedCommentsView nBPFeedCommentsView4 = nBPFeedCommentsView3;
                                        final NBPFeedCommentsData nBPFeedCommentsData2 = nBPFeedCommentsData;
                                        ConditionViewKt.c(viewContainer3, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentLikes$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView5) {
                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel8 = NBPFeedCommentsViewModel.this;
                                                final NBPFeedCommentsView nBPFeedCommentsView5 = nBPFeedCommentsView4;
                                                final NBPFeedCommentsData nBPFeedCommentsData3 = nBPFeedCommentsData2;
                                                conditionView5.addChild(new NBPFeedLikeBannerView(), new Function1<NBPFeedLikeBannerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentLikes.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPFeedLikeBannerView nBPFeedLikeBannerView) {
                                                        NBPFeedLikeBannerView nBPFeedLikeBannerView2 = nBPFeedLikeBannerView;
                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel9 = NBPFeedCommentsViewModel.this;
                                                        nBPFeedLikeBannerView2.attr(new Function1<NBPFeedLikeBannerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentLikes.1.2.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPFeedLikeBannerAttr nBPFeedLikeBannerAttr) {
                                                                int collectionSizeOrDefault;
                                                                boolean isBlank;
                                                                NBPFeedLikeBannerAttr nBPFeedLikeBannerAttr2 = nBPFeedLikeBannerAttr;
                                                                nBPFeedLikeBannerAttr2.likeCount$delegate.setValue(nBPFeedLikeBannerAttr2, NBPFeedLikeBannerAttr.$$delegatedProperties[0], Integer.valueOf(NBPFeedCommentsViewModel.this.getLikesCount()));
                                                                List<LikeUser> likeUsers = NBPFeedCommentsViewModel.this.getLikeUsers();
                                                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(likeUsers, 10);
                                                                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                                                Iterator<T> it = likeUsers.iterator();
                                                                while (it.hasNext()) {
                                                                    String str = ((LikeUser) it.next()).nickname;
                                                                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                                                                    if (isBlank) {
                                                                        str = "\u9644\u8fd1\u7528\u6237";
                                                                    }
                                                                    arrayList.add(str);
                                                                }
                                                                nBPFeedLikeBannerAttr2.likeUserNicks$delegate.setValue(nBPFeedLikeBannerAttr2, NBPFeedLikeBannerAttr.$$delegatedProperties[1], arrayList);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFeedCommentsView nBPFeedCommentsView6 = nBPFeedCommentsView5;
                                                        final NBPFeedCommentsData nBPFeedCommentsData4 = nBPFeedCommentsData3;
                                                        nBPFeedLikeBannerView2.event(new Function1<NBPFeedLikeBannerEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentLikes.1.2.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPFeedLikeBannerEvent nBPFeedLikeBannerEvent) {
                                                                final NBPFeedCommentsView nBPFeedCommentsView7 = NBPFeedCommentsView.this;
                                                                final NBPFeedCommentsData nBPFeedCommentsData5 = nBPFeedCommentsData4;
                                                                nBPFeedLikeBannerEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentLikes.1.2.1.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        String str;
                                                                        if (!NBPFeedCommentsView.this.fastClickUtils.isFastDoubleClick()) {
                                                                            NBPFeedCommentsData nBPFeedCommentsData6 = nBPFeedCommentsData5;
                                                                            int i3 = nBPFeedCommentsData6.appId;
                                                                            String str2 = nBPFeedCommentsData6.viewerUserId;
                                                                            ac acVar = nBPFeedCommentsData6.likeInfo;
                                                                            if (acVar == null || (str = acVar.f425119d) == null) {
                                                                                str = nBPFeedCommentsData6.feedId;
                                                                            }
                                                                            String str3 = "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&modal_mode=1&page_name=nearbypro_feed_like&user_id=" + str2 + "&app_id=" + i3 + "&like_key=" + str + "&feed_id=" + nBPFeedCommentsData6.feedId + "&custom_back_pressed=1";
                                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                            QQKuiklyPlatformApi.Companion.openPage$default(str3, false, 6);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(conditionView4);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel5 = NBPFeedCommentsViewModel.this;
                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.3
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
                            
                                if ((!r1.getCommentItems().isEmpty()) != false) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                boolean z16 = NBPFeedCommentsViewModel.this.getLikesCount() > 0;
                                return Boolean.valueOf(z16);
                            }
                        };
                        final NBPFeedCommentsView nBPFeedCommentsView3 = nBPFeedCommentsView;
                        ConditionViewKt.c(conditionView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                final NBPFeedCommentsView nBPFeedCommentsView4 = NBPFeedCommentsView.this;
                                w.a(conditionView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        final NBPFeedCommentsView nBPFeedCommentsView5 = NBPFeedCommentsView.this;
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginLeft(16.0f);
                                                tVar2.marginRight(16.0f);
                                                tVar2.marginTop(16.0f);
                                                tVar2.mo141height(0.5f);
                                                if (NBPFeedCommentsView.this.showTotalCount) {
                                                    tVar2.mo113backgroundColor(h.INSTANCE.a(0.07f));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel6 = NBPFeedCommentsViewModel.this;
                        Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(!NBPFeedCommentsViewModel.this.getCommentItems().isEmpty());
                            }
                        };
                        final NBPFeedCommentsView nBPFeedCommentsView4 = nBPFeedCommentsView;
                        ConditionViewKt.c(conditionView2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                ConditionView conditionView4 = conditionView3;
                                final NBPFeedCommentsView nBPFeedCommentsView5 = NBPFeedCommentsView.this;
                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel7 = nBPFeedCommentsView5.f114213vm;
                                if (nBPFeedCommentsViewModel7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                    nBPFeedCommentsViewModel7 = null;
                                }
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final NBPFeedCommentsView nBPFeedCommentsView6 = NBPFeedCommentsView.this;
                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel8 = nBPFeedCommentsViewModel7;
                                        ar.a(viewContainer3, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aq<?, ?> aqVar) {
                                                aq<?, ?> aqVar2 = aqVar;
                                                final NBPFeedCommentsView nBPFeedCommentsView7 = NBPFeedCommentsView.this;
                                                aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                                        NBPFeedCommentsView.this.listRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentsView nBPFeedCommentsView8 = NBPFeedCommentsView.this;
                                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ao aoVar) {
                                                        ao aoVar2 = aoVar;
                                                        NBPFeedCommentsView nBPFeedCommentsView9 = NBPFeedCommentsView.this;
                                                        if (nBPFeedCommentsView9.fitHeight) {
                                                            aoVar2.mo141height(((Number) nBPFeedCommentsView9.listHeight$delegate.getValue(nBPFeedCommentsView9, NBPFeedCommentsView.$$delegatedProperties[0])).floatValue());
                                                            aoVar2.scrollEnable(false);
                                                        } else {
                                                            aoVar2.m140flex(1.0f);
                                                            aoVar2.scrollEnable(true);
                                                        }
                                                        aoVar2.paddingLeft(16.0f);
                                                        aoVar2.paddingRight(16.0f);
                                                        aoVar2.paddingTop(8.0f);
                                                        aoVar2.showScrollerIndicator(false);
                                                        ScrollerAttr.bouncesEnable$default(aoVar2, false, false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentsView nBPFeedCommentsView9 = NBPFeedCommentsView.this;
                                                aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ap apVar) {
                                                        ap apVar2 = apVar;
                                                        final NBPFeedCommentsView nBPFeedCommentsView10 = NBPFeedCommentsView.this;
                                                        apVar2.contentSizeChanged(new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.3.1
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(Float f16, Float f17) {
                                                                f16.floatValue();
                                                                float floatValue = f17.floatValue();
                                                                NBPFeedCommentsView nBPFeedCommentsView11 = NBPFeedCommentsView.this;
                                                                nBPFeedCommentsView11.listHeight$delegate.setValue(nBPFeedCommentsView11, NBPFeedCommentsView.$$delegatedProperties[0], Float.valueOf(floatValue));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        apVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.3.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final /* bridge */ /* synthetic */ Unit invoke(LongPressParams longPressParams) {
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentsView nBPFeedCommentsView10 = NBPFeedCommentsView.this;
                                                Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.4
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return Boolean.valueOf(NBPFeedCommentsView.this.showTotalCount);
                                                    }
                                                };
                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel9 = nBPFeedCommentsViewModel8;
                                                ConditionViewKt.c(aqVar2, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView5) {
                                                        ConditionView conditionView6 = conditionView5;
                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel10 = NBPFeedCommentsViewModel.this;
                                                        com.tencent.kuikly.core.views.ac.a(conditionView6, new Function1<ab, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ab abVar) {
                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel11 = NBPFeedCommentsViewModel.this;
                                                                w.a(abVar, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar) {
                                                                        v vVar2 = vVar;
                                                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5.1.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.flexDirectionRow();
                                                                                tVar2.mo141height(35.0f);
                                                                                tVar2.alignItemsCenter();
                                                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5.1.1.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5.1.1.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_CiW1XBUxnzP.png", false, 2, null);
                                                                                        afVar2.size(20.0f);
                                                                                        afVar2.marginRight(2.0f);
                                                                                        afVar2.t(QUIToken.color$default("text_primary"));
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel12 = NBPFeedCommentsViewModel.this;
                                                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5.1.1.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel13 = NBPFeedCommentsViewModel.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5.1.1.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u8bc4\u8bba");
                                                                                        m3.append(NBPFeedCommentsViewModel.this.getCommentsCount());
                                                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, m3.toString());
                                                                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                                                                        ceVar2.fontWeight400();
                                                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        w.a(conditionView6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar) {
                                                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.5.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.mo141height(16.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel10 = nBPFeedCommentsViewModel8;
                                                Function0<com.tencent.kuikly.core.reactive.collection.c<NBPCommentVO>> function06 = new Function0<com.tencent.kuikly.core.reactive.collection.c<NBPCommentVO>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.6
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final com.tencent.kuikly.core.reactive.collection.c<NBPCommentVO> invoke() {
                                                        return NBPFeedCommentsViewModel.this.getCommentItems();
                                                    }
                                                };
                                                final NBPFeedCommentsView nBPFeedCommentsView11 = NBPFeedCommentsView.this;
                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel11 = nBPFeedCommentsViewModel8;
                                                LoopDirectivesViewKt.b(aqVar2, function06, new Function4<LoopDirectivesView<NBPCommentVO>, NBPCommentVO, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.7
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(4);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function4
                                                    public final Unit invoke(LoopDirectivesView<NBPCommentVO> loopDirectivesView, NBPCommentVO nBPCommentVO, Integer num, Integer num2) {
                                                        final NBPCommentVO nBPCommentVO2 = nBPCommentVO;
                                                        final int intValue = num.intValue();
                                                        num2.intValue();
                                                        final NBPFeedCommentsView nBPFeedCommentsView12 = NBPFeedCommentsView.this;
                                                        int i3 = nBPFeedCommentsView12.data.appId;
                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel12 = nBPFeedCommentsViewModel11;
                                                        loopDirectivesView.addChild(new NBPFeedCommentItemView(i3), new Function1<NBPFeedCommentItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.7.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPFeedCommentItemView nBPFeedCommentItemView) {
                                                                NBPFeedCommentItemView nBPFeedCommentItemView2 = nBPFeedCommentItemView;
                                                                final NBPCommentVO nBPCommentVO3 = NBPCommentVO.this;
                                                                final int i16 = intValue;
                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel13 = nBPFeedCommentsViewModel12;
                                                                nBPFeedCommentItemView2.attr(new Function1<NBPFeedCommentItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.7.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(NBPFeedCommentItemViewAttr nBPFeedCommentItemViewAttr) {
                                                                        List sortedWith;
                                                                        NBPFeedCommentItemViewAttr nBPFeedCommentItemViewAttr2 = nBPFeedCommentItemViewAttr;
                                                                        NBPCommentVO nBPCommentVO4 = NBPCommentVO.this;
                                                                        nBPFeedCommentItemViewAttr2.comment = nBPCommentVO4;
                                                                        nBPFeedCommentItemViewAttr2.getReplies().clear();
                                                                        List<NBPReplyVO> list = nBPCommentVO4.replies;
                                                                        com.tencent.kuikly.core.reactive.collection.c<NBPReplyVO> replies = nBPFeedCommentItemViewAttr2.getReplies();
                                                                        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentItemViewAttr$data$lambda$1$$inlined$sortedBy$1
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            @Override // java.util.Comparator
                                                                            public final int compare(T t16, T t17) {
                                                                                int compareValues;
                                                                                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((NBPReplyVO) t16).cTime), Integer.valueOf(((NBPReplyVO) t17).cTime));
                                                                                return compareValues;
                                                                            }
                                                                        });
                                                                        replies.addAll(sortedWith);
                                                                        if (i16 != nBPFeedCommentsViewModel13.getCommentItems().size() - 1) {
                                                                            nBPFeedCommentItemViewAttr2.marginBottom(20.0f);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel14 = nBPFeedCommentsViewModel12;
                                                                final NBPFeedCommentsView nBPFeedCommentsView13 = nBPFeedCommentsView12;
                                                                nBPFeedCommentItemView2.event(new Function1<NBPFeedCommentItemViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.7.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(NBPFeedCommentItemViewEvent nBPFeedCommentItemViewEvent) {
                                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel15 = NBPFeedCommentsViewModel.this;
                                                                        final NBPFeedCommentsView nBPFeedCommentsView14 = nBPFeedCommentsView13;
                                                                        nBPFeedCommentItemViewEvent.onClickHandler = new Function1<CommentClickInfo, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.7.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Boolean invoke(CommentClickInfo commentClickInfo) {
                                                                                String userId;
                                                                                HomepageSource homepageSource;
                                                                                String userId2;
                                                                                HomepageSource homepageSource2;
                                                                                s35.af afVar;
                                                                                Function1<? super CommentClickInfo, Unit> function1;
                                                                                CommentClickInfo commentClickInfo2 = commentClickInfo;
                                                                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel16 = NBPFeedCommentsViewModel.this;
                                                                                nBPFeedCommentsViewModel16.getClass();
                                                                                KLog kLog = KLog.INSTANCE;
                                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onCommentClick, type=");
                                                                                m3.append(CommentClickInfo$ClickType$EnumUnboxingLocalUtility.stringValueOf(commentClickInfo2.type));
                                                                                m3.append(", isReply=");
                                                                                boolean z16 = true;
                                                                                boolean z17 = false;
                                                                                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m3, commentClickInfo2.reply != null, kLog, "NBPFeedCommentsViewModel");
                                                                                if (nBPFeedCommentsViewModel16.fastClickUtil.isFastDoubleClick()) {
                                                                                    kLog.i("NBPFeedCommentsViewModel", "isFastDoubleClick");
                                                                                } else {
                                                                                    int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(commentClickInfo2.type);
                                                                                    if (ordinal == 0) {
                                                                                        s35.af user = commentClickInfo2.getUser();
                                                                                        if (user != null && (userId = StrangerUtilsKt.getUserId(user, nBPFeedCommentsViewModel16.appId)) != null) {
                                                                                            boolean areEqual = Intrinsics.areEqual(userId, nBPFeedCommentsViewModel16.viewerUserId);
                                                                                            if (commentClickInfo2.reply != null) {
                                                                                                if (Intrinsics.areEqual(nBPFeedCommentsViewModel16.reportPageId, "pg_nearby_dynamic_detail")) {
                                                                                                    homepageSource = HomepageSource.FEED_DETAIL_REPLY_HEAD;
                                                                                                } else {
                                                                                                    homepageSource = HomepageSource.FEED_DETAIL_REPLY_HEAD_FLOT;
                                                                                                }
                                                                                            } else if (Intrinsics.areEqual(nBPFeedCommentsViewModel16.reportPageId, "pg_nearby_dynamic_detail")) {
                                                                                                homepageSource = HomepageSource.FEED_DETAIL_COMMENT_HEAD;
                                                                                            } else {
                                                                                                homepageSource = HomepageSource.FEED_DETAIL_COMMENT_HEAD_FLOT;
                                                                                            }
                                                                                            NBPJumpUtil.jumpPersonaPage$default(nBPFeedCommentsViewModel16.appId, userId, areEqual, false, homepageSource, areEqual ? nBPFeedCommentsViewModel16.feedId : null, 8);
                                                                                        }
                                                                                    } else if (ordinal == 1) {
                                                                                        s35.af user2 = commentClickInfo2.getUser();
                                                                                        if (user2 != null && (userId2 = StrangerUtilsKt.getUserId(user2, nBPFeedCommentsViewModel16.appId)) != null) {
                                                                                            boolean areEqual2 = Intrinsics.areEqual(userId2, nBPFeedCommentsViewModel16.viewerUserId);
                                                                                            if (commentClickInfo2.reply != null) {
                                                                                                if (Intrinsics.areEqual(nBPFeedCommentsViewModel16.reportPageId, "pg_nearby_dynamic_detail")) {
                                                                                                    homepageSource2 = HomepageSource.FEED_DETAIL_REPLY_NICK;
                                                                                                } else {
                                                                                                    homepageSource2 = HomepageSource.FEED_DETAIL_REPLY_NICK_FLOT;
                                                                                                }
                                                                                            } else if (Intrinsics.areEqual(nBPFeedCommentsViewModel16.reportPageId, "pg_nearby_dynamic_detail")) {
                                                                                                homepageSource2 = HomepageSource.FEED_DETAIL_COMMENT_NICK;
                                                                                            } else {
                                                                                                homepageSource2 = HomepageSource.FEED_DETAIL_COMMENT_NICK_FLOT;
                                                                                            }
                                                                                            NBPJumpUtil.jumpPersonaPage$default(nBPFeedCommentsViewModel16.appId, userId2, areEqual2, false, homepageSource2, areEqual2 ? nBPFeedCommentsViewModel16.feedId : null, 8);
                                                                                        }
                                                                                    } else if (ordinal == 2) {
                                                                                        nBPFeedCommentsViewModel16.onShowInput.invoke(commentClickInfo2.comment, commentClickInfo2.reply);
                                                                                    } else if (ordinal == 3) {
                                                                                        nBPFeedCommentsViewModel16.onShowInput.invoke(commentClickInfo2.comment, commentClickInfo2.reply);
                                                                                    } else if (ordinal == 4) {
                                                                                        NBPCommentVO nBPCommentVO4 = commentClickInfo2.comment;
                                                                                        NBPReplyVO nBPReplyVO = commentClickInfo2.reply;
                                                                                        if (nBPCommentVO4.submitted) {
                                                                                            if (nBPReplyVO != null && !nBPReplyVO.submitted) {
                                                                                                z17 = true;
                                                                                            }
                                                                                            if (!z17) {
                                                                                                if ((nBPReplyVO != null && (afVar = nBPReplyVO.user) != null) || (afVar = nBPCommentVO4.user) != null) {
                                                                                                    int i17 = nBPFeedCommentsViewModel16.appId;
                                                                                                    String str = nBPFeedCommentsViewModel16.feedId;
                                                                                                    String str2 = nBPFeedCommentsViewModel16.commentPagerId;
                                                                                                    String str3 = nBPFeedCommentsViewModel16.viewerUserId;
                                                                                                    String str4 = nBPFeedCommentsViewModel16.posterUserId;
                                                                                                    String userId3 = StrangerUtilsKt.getUserId(afVar, i17);
                                                                                                    String str5 = nBPCommentVO4.f114212id;
                                                                                                    String str6 = nBPReplyVO != null ? nBPReplyVO.f114214id : null;
                                                                                                    k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                                                                                                    e eVar = new e();
                                                                                                    eVar.t("appId", i17);
                                                                                                    eVar.v("feedId", str);
                                                                                                    eVar.v("pager_id", str2);
                                                                                                    eVar.v("viewerUserId", str3);
                                                                                                    eVar.v("posterUserId", str4);
                                                                                                    eVar.v("targetUserId", userId3);
                                                                                                    eVar.v("targetCommentId", str5);
                                                                                                    eVar.v("targetReplyId", str6);
                                                                                                    k.d(kVar, "NBPFeedCommentMenuOpenEvent", eVar, false, 4, null);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        Utils.INSTANCE.currentBridgeModule().qToast("\u63d0\u4ea4\u4e2d\uff0c\u8bf7\u7a0d\u5019", QToastMode.Info);
                                                                                    }
                                                                                    if (z16 && (function1 = NBPFeedCommentsView.access$getEvent(nBPFeedCommentsView14).onCommentClickHandler) != null) {
                                                                                        function1.invoke(commentClickInfo2);
                                                                                    }
                                                                                    return Boolean.valueOf(z16);
                                                                                }
                                                                                z16 = false;
                                                                                if (z16) {
                                                                                    function1.invoke(commentClickInfo2);
                                                                                }
                                                                                return Boolean.valueOf(z16);
                                                                            }
                                                                        };
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel12 = nBPFeedCommentsViewModel8;
                                                Function0<Object> function07 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.8
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        boolean z16;
                                                        if (!NBPFeedCommentsViewModel.this.getHasMore()) {
                                                            NBPFeedCommentsViewModel nBPFeedCommentsViewModel13 = NBPFeedCommentsViewModel.this;
                                                            if (!((Boolean) nBPFeedCommentsViewModel13.moreLoaded$delegate.getValue(nBPFeedCommentsViewModel13, NBPFeedCommentsViewModel.$$delegatedProperties[6])).booleanValue()) {
                                                                z16 = false;
                                                                return Boolean.valueOf(z16);
                                                            }
                                                        }
                                                        z16 = true;
                                                        return Boolean.valueOf(z16);
                                                    }
                                                };
                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel13 = nBPFeedCommentsViewModel8;
                                                ConditionViewKt.c(aqVar2, function07, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView5) {
                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel14 = NBPFeedCommentsViewModel.this;
                                                        w.a(conditionView5, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar) {
                                                                v vVar2 = vVar;
                                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel15 = NBPFeedCommentsViewModel.this;
                                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel16 = NBPFeedCommentsViewModel.this;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                final String str;
                                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel17 = NBPFeedCommentsViewModel.this;
                                                                                if (nBPFeedCommentsViewModel17.getHasMore() && !((Boolean) nBPFeedCommentsViewModel17.loading$delegate.getValue(nBPFeedCommentsViewModel17, NBPFeedCommentsViewModel.$$delegatedProperties[8])).booleanValue()) {
                                                                                    nBPFeedCommentsViewModel17.setLoading(true);
                                                                                    StrangerFeedCommentRepo strangerFeedCommentRepo = nBPFeedCommentsViewModel17.commentRepo;
                                                                                    final String str2 = nBPFeedCommentsViewModel17.viewerUserId;
                                                                                    final String str3 = nBPFeedCommentsViewModel17.feedId;
                                                                                    g gVar = nBPFeedCommentsViewModel17.lastCommentsPageData;
                                                                                    if (gVar == null || (str = gVar.f425171f) == null) {
                                                                                        str = "";
                                                                                    }
                                                                                    final Function3<g, Integer, String, Unit> function3 = new Function3<g, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$onLoadMoreBtnClick$1
                                                                                        {
                                                                                            super(3);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function3
                                                                                        public final Unit invoke(g gVar2, Integer num, String str4) {
                                                                                            int collectionSizeOrDefault;
                                                                                            g gVar3 = gVar2;
                                                                                            int intValue = num.intValue();
                                                                                            String str5 = str4;
                                                                                            if (intValue == 0 && gVar3 != null) {
                                                                                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel18 = NBPFeedCommentsViewModel.this;
                                                                                                nBPFeedCommentsViewModel18.lastCommentsPageData = gVar3;
                                                                                                boolean z16 = !gVar3.f425172h;
                                                                                                ReadWriteProperty readWriteProperty = nBPFeedCommentsViewModel18.hasMore$delegate;
                                                                                                KProperty<?>[] kPropertyArr = NBPFeedCommentsViewModel.$$delegatedProperties;
                                                                                                readWriteProperty.setValue(nBPFeedCommentsViewModel18, kPropertyArr[7], Boolean.valueOf(z16));
                                                                                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel19 = NBPFeedCommentsViewModel.this;
                                                                                                nBPFeedCommentsViewModel19.moreLoaded$delegate.setValue(nBPFeedCommentsViewModel19, kPropertyArr[6], Boolean.TRUE);
                                                                                                if (gVar3.f425169d != NBPFeedCommentsViewModel.this.getCommentsCount()) {
                                                                                                    NBPFeedCommentsViewModel nBPFeedCommentsViewModel20 = NBPFeedCommentsViewModel.this;
                                                                                                    nBPFeedCommentsViewModel20.notifyCommentCountChange(nBPFeedCommentsViewModel20.getCommentsCount());
                                                                                                }
                                                                                                com.tencent.kuikly.core.reactive.collection.c<NBPCommentVO> commentItems = NBPFeedCommentsViewModel.this.getCommentItems();
                                                                                                List<p35.h> list = gVar3.f425170e;
                                                                                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel21 = NBPFeedCommentsViewModel.this;
                                                                                                ArrayList arrayList = new ArrayList();
                                                                                                for (Object obj : list) {
                                                                                                    if (!Intrinsics.areEqual(((p35.h) obj).f425175f, nBPFeedCommentsViewModel21.data.replyCommentId)) {
                                                                                                        arrayList.add(obj);
                                                                                                    }
                                                                                                }
                                                                                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel22 = NBPFeedCommentsViewModel.this;
                                                                                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                                                                                                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                                                                                Iterator it = arrayList.iterator();
                                                                                                while (it.hasNext()) {
                                                                                                    arrayList2.add(new NBPCommentVO((p35.h) it.next(), nBPFeedCommentsViewModel22.data.posterUserId, true));
                                                                                                }
                                                                                                commentItems.addAll(arrayList2);
                                                                                                NBPFeedCommentsViewModel.this.setLoading(false);
                                                                                            } else {
                                                                                                if (!NearbyProUtilsKt.isShowBackendErrorMsg(intValue)) {
                                                                                                    str5 = "\u83b7\u53d6\u6570\u636e\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                                                                }
                                                                                                Utils.INSTANCE.currentBridgeModule().qToast(str5, QToastMode.Info);
                                                                                                NBPFeedCommentsViewModel.this.setLoading(false);
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    };
                                                                                    strangerFeedCommentRepo.getClass();
                                                                                    KLog kLog = KLog.INSTANCE;
                                                                                    StringBuilder a16 = j.a("fetchCommentAndReply: userId=", str2, " feedId=", str3, " count=");
                                                                                    a16.append(10);
                                                                                    a16.append(" attachInfo=");
                                                                                    a16.append(str);
                                                                                    kLog.i("StrangerFeedCommentRepo", a16.toString());
                                                                                    GetCommentAndReplyRequest getCommentAndReplyRequest = new GetCommentAndReplyRequest(strangerFeedCommentRepo.appId, str2, str3, str);
                                                                                    Function4<r, byte[], Integer, String, Unit> function4 = new Function4<r, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$fetchCommentAndReply$1
                                                                                        public final /* synthetic */ int $count = 10;

                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(4);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function4
                                                                                        public final Unit invoke(r rVar, byte[] bArr, Integer num, String str4) {
                                                                                            r rVar2 = rVar;
                                                                                            int intValue = num.intValue();
                                                                                            String str5 = str4;
                                                                                            KLog kLog2 = KLog.INSTANCE;
                                                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchCommentAndReply: rspIsNull=");
                                                                                            m3.append(rVar2 == null);
                                                                                            m3.append(" userId=");
                                                                                            m3.append(str2);
                                                                                            m3.append(" feedId=");
                                                                                            m3.append(str3);
                                                                                            m3.append(" count=");
                                                                                            m3.append(this.$count);
                                                                                            m3.append(" attachInfo=");
                                                                                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m3, str, ", code=", intValue, ", msg="), str5, kLog2, "StrangerFeedCommentRepo");
                                                                                            if (intValue != 0) {
                                                                                                function3.invoke(null, Integer.valueOf(intValue), str5);
                                                                                            } else {
                                                                                                function3.invoke(rVar2 != null ? rVar2.f425209d : null, Integer.valueOf(intValue), str5);
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    };
                                                                                    a aVar = new a(i.d(getCommentAndReplyRequest.getRequest()));
                                                                                    int appId = getCommentAndReplyRequest.getAppId();
                                                                                    CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(function4, getCommentAndReplyRequest);
                                                                                    StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", "QQStranger.FeedSvr", " method=");
                                                                                    m3.append("GetCommentAndReply");
                                                                                    kLog.i("CommonProxyService", m3.toString());
                                                                                    APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + "QQStranger.FeedSvr.GetCommentAndReply");
                                                                                    CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, "QQStranger.FeedSvr", "GetCommentAndReply", aVar);
                                                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                                    QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel16 = NBPFeedCommentsViewModel.this;
                                                                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.3
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        NBPFeedCommentsViewModel nBPFeedCommentsViewModel17 = NBPFeedCommentsViewModel.this;
                                                                        return Boolean.valueOf(((Boolean) nBPFeedCommentsViewModel17.loading$delegate.getValue(nBPFeedCommentsViewModel17, NBPFeedCommentsViewModel.$$delegatedProperties[8])).booleanValue());
                                                                    }
                                                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.4
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ConditionView conditionView6) {
                                                                        com.tencent.kuikly.core.views.i.a(conditionView6, new Function1<com.tencent.kuikly.core.views.h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.4.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(com.tencent.kuikly.core.views.h hVar) {
                                                                                hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.4.1.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(f fVar) {
                                                                                        fVar.h(!com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode());
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel17 = NBPFeedCommentsViewModel.this;
                                                                ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.5
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ConditionView conditionView6) {
                                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel18 = NBPFeedCommentsViewModel.this;
                                                                        cg.a(conditionView6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.5.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final String str;
                                                                                TextView textView2 = textView;
                                                                                if (NBPFeedCommentsViewModel.this.getHasMore()) {
                                                                                    str = "\u70b9\u51fb\u52a0\u8f7d\u66f4\u591a";
                                                                                } else if (NBPFeedCommentsViewModel.this.isRealCommentsLessThanTotal()) {
                                                                                    str = "- \u5df2\u8fc7\u6ee4\u90e8\u5206\u8bc4\u8bba -";
                                                                                } else {
                                                                                    NBPFeedCommentsViewModel nBPFeedCommentsViewModel19 = NBPFeedCommentsViewModel.this;
                                                                                    if (((Boolean) nBPFeedCommentsViewModel19.moreLoaded$delegate.getValue(nBPFeedCommentsViewModel19, NBPFeedCommentsViewModel.$$delegatedProperties[6])).booleanValue()) {
                                                                                        str = "- \u6682\u65e0\u66f4\u591a\u8bc4\u8bba -";
                                                                                    } else {
                                                                                        str = "";
                                                                                    }
                                                                                }
                                                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.9.1.5.1.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, str);
                                                                                        ceVar2.textAlignCenter();
                                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                        ceVar2.fontWeight400();
                                                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                                        ceVar2.marginTop(16.0f);
                                                                                        if (str.length() > 0) {
                                                                                            ceVar2.marginBottom(12.0f);
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel14 = nBPFeedCommentsViewModel8;
                                                ConditionViewKt.a(aqVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.10
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView5) {
                                                        ConditionView conditionView6 = conditionView5;
                                                        if (NBPFeedCommentsViewModel.this.isRealCommentsLessThanTotal()) {
                                                            w.a(conditionView6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.10.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar) {
                                                                    v vVar2 = vVar;
                                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.10.1.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            tVar.allCenter();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.10.1.2
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.10.1.2.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    TextViewExtKt.textWithLineHeightFix(ceVar2, "- \u5df2\u8fc7\u6ee4\u90e8\u5206\u8bc4\u8bba -");
                                                                                    ceVar2.textAlignCenter();
                                                                                    ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                    ceVar2.fontWeight400();
                                                                                    ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                                    ceVar2.marginTop(16.0f);
                                                                                    ceVar2.marginBottom(12.0f);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
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
                                                if (!NBPFeedCommentsView.this.fitHeight) {
                                                    w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.11
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentComments.1.1.11.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    tVar.mo141height(40.0f);
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
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(conditionView4);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedCommentsView nBPFeedCommentsView5 = nBPFeedCommentsView;
                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel7 = NBPFeedCommentsViewModel.this;
                        Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NBPFeedCommentsView.this.showEmptyTips && nBPFeedCommentsViewModel7.getCommentItems().isEmpty());
                            }
                        };
                        final NBPFeedCommentsView nBPFeedCommentsView6 = nBPFeedCommentsView;
                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel8 = NBPFeedCommentsViewModel.this;
                        ConditionViewKt.c(conditionView2, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.2.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                final NBPFeedCommentsView nBPFeedCommentsView7 = NBPFeedCommentsView.this;
                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel9 = nBPFeedCommentsViewModel8;
                                KProperty<Object>[] kPropertyArr = NBPFeedCommentsView.$$delegatedProperties;
                                nBPFeedCommentsView7.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentEmpty$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel10 = NBPFeedCommentsViewModel.this;
                                        final NBPFeedCommentsView nBPFeedCommentsView8 = nBPFeedCommentsView7;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentEmpty$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.m145minHeight(280.0f);
                                                        tVar2.alignItems(FlexAlign.CENTER);
                                                        tVar2.justifyContent(FlexJustifyContent.CENTER);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel11 = NBPFeedCommentsViewModel.this;
                                                final NBPFeedCommentsView nBPFeedCommentsView9 = nBPFeedCommentsView8;
                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_eBbVv6UNVeV.png", false, 2, null);
                                                                        afVar2.size(80.0f, 80.0f);
                                                                        afVar2.marginBottom(6.0f);
                                                                        afVar2.t(QUIToken.color$default("icon_primary"));
                                                                        afVar2.m147opacity(0.3f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel12 = NBPFeedCommentsViewModel.this;
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel13 = NBPFeedCommentsViewModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        String str;
                                                                        ce ceVar2 = ceVar;
                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u6210\u4e3a\u7b2c\u4e00\u4e2a");
                                                                        if (NBPFeedCommentsViewModel.this.getLikesCount() == 0) {
                                                                            str = "\u70b9\u8d5e";
                                                                        } else {
                                                                            str = "";
                                                                        }
                                                                        m3.append(str);
                                                                        m3.append("\u8bc4\u8bba\u7684\u4eba\u5427");
                                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, m3.toString());
                                                                        ceVar2.color(QUIToken.color$default("text_secondary_light"));
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.textAlignCenter();
                                                                        ceVar2.lineHeight(22.0f);
                                                                        ceVar2.marginBottom(24.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel13 = NBPFeedCommentsViewModel.this;
                                                        Function0<Object> function06 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.4
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                NBPFeedCommentsData nBPFeedCommentsData = NBPFeedCommentsViewModel.this.data;
                                                                return Boolean.valueOf(!Intrinsics.areEqual(nBPFeedCommentsData.viewerUserId, nBPFeedCommentsData.posterUserId));
                                                            }
                                                        };
                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel14 = NBPFeedCommentsViewModel.this;
                                                        final NBPFeedCommentsView nBPFeedCommentsView10 = nBPFeedCommentsView9;
                                                        ConditionViewKt.c(vVar4, function06, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.5
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView4) {
                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel15 = NBPFeedCommentsViewModel.this;
                                                                final NBPFeedCommentsView nBPFeedCommentsView11 = nBPFeedCommentsView10;
                                                                w.a(conditionView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.5.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar5) {
                                                                        v vVar6 = vVar5;
                                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel16 = NBPFeedCommentsViewModel.this;
                                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.5.1.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo153width(78.0f);
                                                                                tVar2.mo141height(32.0f);
                                                                                tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_secondary_pressed"));
                                                                                tVar2.borderRadius(4.0f);
                                                                                tVar2.allCenter();
                                                                                tVar2.marginBottom(20.0f);
                                                                                tVar2.m147opacity(NBPFeedCommentsViewModel.this.getEmptyViewShowCommentBtn() ? 1.0f : 0.0f);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPFeedCommentsViewModel nBPFeedCommentsViewModel17 = NBPFeedCommentsViewModel.this;
                                                                        final NBPFeedCommentsView nBPFeedCommentsView12 = nBPFeedCommentsView11;
                                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.5.1.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(u uVar) {
                                                                                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel18 = NBPFeedCommentsViewModel.this;
                                                                                final NBPFeedCommentsView nBPFeedCommentsView13 = nBPFeedCommentsView12;
                                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.5.1.2.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        if (NBPFeedCommentsViewModel.this.getEmptyViewShowCommentBtn()) {
                                                                                            NBPFeedCommentsView.showInput$default(nBPFeedCommentsView13, null, null, null, 7);
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.5.1.3
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.contentEmpty.1.1.2.5.1.3.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                        ceVar2.lineHeight(20.0f);
                                                                                        ceVar2.fontWeight500();
                                                                                        ceVar2.color(QUIToken.color$default("button_text_secondary_pressed"));
                                                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, "\u53bb\u8bc4\u8bba");
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(conditionView3);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPFeedCommentsViewModel nBPFeedCommentsViewModel4 = NBPFeedCommentsViewModel.this;
                final NBPFeedCommentsView nBPFeedCommentsView2 = this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPFeedCommentsViewModel nBPFeedCommentsViewModel5 = NBPFeedCommentsViewModel.this;
                        boolean z16 = false;
                        if (!((Boolean) nBPFeedCommentsViewModel5.ready$delegate.getValue(nBPFeedCommentsViewModel5, NBPFeedCommentsViewModel.$$delegatedProperties[0])).booleanValue()) {
                            NBPFeedCommentsView nBPFeedCommentsView3 = nBPFeedCommentsView2;
                            if (((Boolean) nBPFeedCommentsView3.enableLoadingShow$delegate.getValue(nBPFeedCommentsView3, NBPFeedCommentsView.$$delegatedProperties[1])).booleanValue()) {
                                z16 = true;
                            }
                        }
                        return Boolean.valueOf(z16);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        com.tencent.kuikly.core.views.i.a(conditionView, new Function1<com.tencent.kuikly.core.views.h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.h hVar) {
                                hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(f fVar) {
                                        f fVar2 = fVar;
                                        fVar2.h(!com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode());
                                        fVar2.alignSelfCenter();
                                        fVar2.marginTop(24.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPFeedCommentsAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedCommentsEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.f114213vm = new NBPFeedCommentsViewModel(this.commentPagerId, this.pageId, this.data, new Function2<NBPCommentVO, NBPReplyVO, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$created$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(NBPCommentVO nBPCommentVO, NBPReplyVO nBPReplyVO) {
                NBPCommentVO nBPCommentVO2 = nBPCommentVO;
                NBPReplyVO nBPReplyVO2 = nBPReplyVO;
                Function2<? super NBPCommentVO, ? super NBPReplyVO, Unit> function2 = NBPFeedCommentsView.access$getEvent(NBPFeedCommentsView.this).onAddedHandler;
                if (function2 != null) {
                    function2.invoke(nBPCommentVO2, nBPReplyVO2);
                }
                return Unit.INSTANCE;
            }
        }, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$created$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                Function1<? super Integer, Unit> function1 = NBPFeedCommentsView.access$getEvent(NBPFeedCommentsView.this).onCountChangeHandler;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(intValue));
                }
                return Unit.INSTANCE;
            }
        }, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$created$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Boolean bool, Integer num) {
                final boolean booleanValue = bool.booleanValue();
                final int intValue = num.intValue();
                final NBPFeedCommentsView nBPFeedCommentsView = NBPFeedCommentsView.this;
                TimerKt.d(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$created$3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function2<? super Boolean, ? super Integer, Unit> function2 = NBPFeedCommentsView.access$getEvent(NBPFeedCommentsView.this).onFirstPageLoadedHandler;
                        if (function2 != null) {
                            function2.invoke(Boolean.valueOf(booleanValue), Integer.valueOf(intValue));
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, new NBPFeedCommentsView$created$4(this));
        ((NBPFeedCommentsEvent) getEvent()).setPagerId(getPagerId());
        TimerKt.d(this.showLoadingDelayMs, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$created$5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPFeedCommentsView nBPFeedCommentsView = NBPFeedCommentsView.this;
                nBPFeedCommentsView.enableLoadingShow$delegate.setValue(nBPFeedCommentsView, NBPFeedCommentsView.$$delegatedProperties[1], Boolean.TRUE);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void getCommentOffset(long j3, final Long l3, final Function3 function3) {
        aq<?, ?> b16;
        List<DeclarativeBaseView<?, ?>> subviews;
        Object firstOrNull;
        Object obj;
        aa<aq<?, ?>> aaVar;
        aq<?, ?> b17;
        d frame;
        NBPFeedLCommentHighlightView b18;
        aq<?, ?> b19;
        aa<aq<?, ?>> aaVar2 = this.listRef;
        if (aaVar2 == null || (b16 = aaVar2.b()) == null || (subviews = b16.getSubviews()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : subviews) {
            if (obj2 instanceof ListContentView) {
                arrayList.add(obj2);
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        ListContentView listContentView = (ListContentView) firstOrNull;
        if (listContentView != null) {
            List<DeclarativeBaseView<?, ?>> subviews2 = listContentView.getSubviews();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : subviews2) {
                if (obj3 instanceof NBPFeedCommentItemView) {
                    arrayList2.add(obj3);
                }
            }
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                NBPCommentVO nBPCommentVO = ((NBPFeedCommentItemViewAttr) ((NBPFeedCommentItemView) obj).getViewAttr()).comment;
                if (nBPCommentVO != null && nBPCommentVO.key == j3) {
                    break;
                }
            }
            final NBPFeedCommentItemView nBPFeedCommentItemView = (NBPFeedCommentItemView) obj;
            if (nBPFeedCommentItemView == null || (aaVar = this.listRef) == null || (b17 = aaVar.b()) == null || (frame = b17.getFrame()) == null) {
                return;
            }
            final float height = frame.getHeight();
            final float height2 = listContentView.getFrame().getHeight();
            aa<aq<?, ?>> aaVar3 = this.listRef;
            float curOffsetY = (aaVar3 == null || (b19 = aaVar3.b()) == null) ? 0.0f : b19.getCurOffsetY();
            if (l3 == null) {
                float height3 = nBPFeedCommentItemView.getFrame().getHeight();
                float y16 = nBPFeedCommentItemView.getFrame().getY();
                function3.invoke(Float.valueOf(y16), Float.valueOf(getSafeScrollOffset(curOffsetY, height, height2, height3, y16)), Float.valueOf(getListOffsetToComponentTop()));
                aa<NBPFeedLCommentHighlightView> aaVar4 = nBPFeedCommentItemView.highlightRef;
                if (aaVar4 == null || (b18 = aaVar4.b()) == null) {
                    return;
                }
                b18.trigger();
                return;
            }
            nBPFeedCommentItemView.expandReplies();
            final float f16 = curOffsetY;
            TimerKt.d(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$getCommentOffset$1
                public final /* synthetic */ boolean $highlightedComment = true;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Long, com.tencent.kuikly.core.base.aa<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentReplyItemView>>] */
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView;
                    aa<NBPFeedLCommentHighlightView> aaVar5;
                    NBPFeedLCommentHighlightView b26;
                    NBPFeedCommentReplyItemView nBPFeedCommentReplyItemView2;
                    d frame2;
                    aa aaVar6 = (aa) NBPFeedCommentItemView.this.replyViewRefs.get(Long.valueOf(l3.longValue()));
                    float f17 = 0.0f;
                    float f18 = 0.0f;
                    for (ViewContainer<?, ?> viewContainer = aaVar6 != null ? (NBPFeedCommentReplyItemView) aaVar6.b() : null; viewContainer != null && !Intrinsics.areEqual(viewContainer.getParent(), NBPFeedCommentItemView.this); viewContainer = viewContainer.getParent()) {
                        f18 += viewContainer.getFrame().getY();
                    }
                    if (aaVar6 != null && (nBPFeedCommentReplyItemView2 = (NBPFeedCommentReplyItemView) aaVar6.b()) != null && (frame2 = nBPFeedCommentReplyItemView2.getFrame()) != null) {
                        f17 = frame2.getHeight();
                    }
                    float f19 = f17;
                    float y17 = NBPFeedCommentItemView.this.getFrame().getY() + f18;
                    Function3<Float, Float, Float, Unit> function32 = function3;
                    if (function32 != null) {
                        function32.invoke(Float.valueOf(y17), Float.valueOf(this.getSafeScrollOffset(f16, height, height2, f19, y17)), Float.valueOf(this.getListOffsetToComponentTop()));
                    }
                    if (this.$highlightedComment && aaVar6 != null && (nBPFeedCommentReplyItemView = (NBPFeedCommentReplyItemView) aaVar6.b()) != null && (aaVar5 = nBPFeedCommentReplyItemView.highlightRef) != null && (b26 = aaVar5.b()) != null) {
                        b26.trigger();
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final float getListOffsetToComponentTop() {
        aq<?, ?> b16;
        d frame;
        aa<aq<?, ?>> aaVar = this.listRef;
        if (aaVar == null || (b16 = aaVar.b()) == null || (frame = b16.getFrame()) == null) {
            return 0.0f;
        }
        return frame.getY();
    }

    public final float getSafeScrollOffset(float f16, float f17, float f18, float f19, float f26) {
        float f27;
        KLog.INSTANCE.i("NBPFeedCommentsView", "getSafeScrollOffset: containerScrollTop=" + f16 + ", containerHeight=" + f17 + ", contentHeight=" + f18 + ", itemHeight=" + f19 + ", itemOffset=" + f26);
        float f28 = (f17 / ((float) 2)) + f16;
        if (f26 < f16) {
            f27 = f26 - f16;
        } else {
            float f29 = f26 + f19;
            if (f29 <= f28) {
                return f16 + 0.0f;
            }
            f27 = f29 - f28;
        }
        return f27 + f16;
    }

    public final void sendQuickComment(QuickCommentItem quickCommentItem) {
        NBPFeedCommentsViewModel nBPFeedCommentsViewModel = this.f114213vm;
        if (nBPFeedCommentsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            nBPFeedCommentsViewModel = null;
        }
        nBPFeedCommentsViewModel.getClass();
        nBPFeedCommentsViewModel.doSendCommentOrReply(null, null, quickCommentItem.text, true);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewWillUnload() {
        super.viewWillUnload();
        NBPFeedCommentsViewModel nBPFeedCommentsViewModel = this.f114213vm;
        if (nBPFeedCommentsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            nBPFeedCommentsViewModel = null;
        }
        nBPFeedCommentsViewModel.extraManager.onDestroy();
        String str = nBPFeedCommentsViewModel.likeNotifyCallbackRef;
        if (str != null) {
            ((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule")).e("NearbyFeedLikeStatusChangedEvent", str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void showInput$default(NBPFeedCommentsView nBPFeedCommentsView, NBPCommentVO nBPCommentVO, NBPReplyVO nBPReplyVO, CommentPanelState commentPanelState, int i3) {
        s35.af afVar;
        NBPCommentVO nBPCommentVO2 = (i3 & 1) != 0 ? null : nBPCommentVO;
        NBPReplyVO nBPReplyVO2 = (i3 & 2) != 0 ? null : nBPReplyVO;
        CommentPanelState commentPanelState2 = (i3 & 4) != 0 ? CommentPanelState.None : commentPanelState;
        nBPFeedCommentsView.getClass();
        boolean z16 = false;
        if (!((nBPCommentVO2 == null || nBPCommentVO2.submitted) ? false : true)) {
            if (nBPReplyVO2 != null && !nBPReplyVO2.submitted) {
                z16 = true;
            }
            if (!z16) {
                if (nBPReplyVO2 == null || (afVar = nBPReplyVO2.user) == null) {
                    afVar = nBPCommentVO2 != null ? nBPCommentVO2.user : null;
                }
                String u16 = BridgeManager.f117344a.u();
                NBPFeedCommentsData nBPFeedCommentsData = nBPFeedCommentsView.data;
                INBPFeedCommentExtraEvent.DefaultImpls.dispatch(new NBPFeedCommentInputOpenEvent(u16, nBPFeedCommentsData.appId, nBPFeedCommentsData.feedId, nBPFeedCommentsView.commentPagerId, nBPCommentVO2 != null ? nBPCommentVO2.f114212id : null, nBPReplyVO2 != null ? nBPReplyVO2.f114214id : null, afVar != null ? afVar.f433209f : null, null, commentPanelState2, ((NBPFeedCommentsAttr) nBPFeedCommentsView.getAttr()).quickComments, ((NBPFeedCommentsAttr) nBPFeedCommentsView.getAttr()).aiQuickComments));
                return;
            }
        }
        Utils.INSTANCE.currentBridgeModule().qToast("\u63d0\u4ea4\u4e2d\uff0c\u8bf7\u7a0d\u5019", QToastMode.Info);
    }
}
