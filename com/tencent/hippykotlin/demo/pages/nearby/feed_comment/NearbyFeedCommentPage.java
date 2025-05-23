package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.extension.QQThemeMode$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p35.ac;
import p35.g;

/* loaded from: classes31.dex */
public final class NearbyFeedCommentPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedCommentPage.class, "loadFailed", "getLoadFailed()Z", 0)};
    public aa<NBPFeedCommentExtraView> commentsExtraViewRef;
    public aa<NBPFeedCommentsView> commentsViewRef;
    public NearbyFeedCommentPageData data;
    public aa<NBPHalfScreenModalView> modalViewRef;
    public boolean pageClosed;
    public NearbyFeedCommentPageViewModel pageVm;
    public final ReadWriteProperty loadFailed$delegate = c.a(Boolean.FALSE);
    public final Function1<ViewContainer<?, ?>, Unit> contentHeader = new NearbyFeedCommentPage$contentHeader$1(this);
    public final Function1<ViewContainer<?, ?>, Unit> contentBody = new NearbyFeedCommentPage$contentBody$1(this);
    public final Function1<ViewContainer<?, ?>, Unit> contentEmpty = NearbyFeedCommentPage$contentEmpty$1.INSTANCE;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = 34.0f;
        if (getPagerData().getIsAndroid()) {
            float g16 = getPagerData().g() - getPagerData().l();
            float f16 = floatRef.element;
            floatRef.element = f16 > g16 ? f16 - g16 : 0.0f;
        }
        final float min = Math.min(getPagerData().l() * 0.8f, 620.0f);
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NearbyFeedCommentPage nearbyFeedCommentPage = NearbyFeedCommentPage.this;
                final float f17 = min;
                final Ref.FloatRef floatRef2 = floatRef;
                NBPHalfScreenModalViewKt.NBPHalfScreenModal(viewContainer, new Function1<NBPHalfScreenModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPHalfScreenModalView nBPHalfScreenModalView) {
                        NBPHalfScreenModalView nBPHalfScreenModalView2 = nBPHalfScreenModalView;
                        final NearbyFeedCommentPage nearbyFeedCommentPage2 = NearbyFeedCommentPage.this;
                        nBPHalfScreenModalView2.ref(nBPHalfScreenModalView2, new Function1<aa<NBPHalfScreenModalView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPHalfScreenModalView> aaVar) {
                                NearbyFeedCommentPage.this.modalViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final float f18 = f17;
                        nBPHalfScreenModalView2.attr(new Function1<NBPHalfScreenModalAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPHalfScreenModalAttr nBPHalfScreenModalAttr) {
                                NBPHalfScreenModalAttr nBPHalfScreenModalAttr2 = nBPHalfScreenModalAttr;
                                nBPHalfScreenModalAttr2.mo153width(nBPHalfScreenModalAttr2.getPagerData().m());
                                nBPHalfScreenModalAttr2.mo141height(nBPHalfScreenModalAttr2.getPagerData().l());
                                nBPHalfScreenModalAttr2.contentHeight = f18;
                                nBPHalfScreenModalAttr2.contentBorderRadius = 8.0f;
                                return Unit.INSTANCE;
                            }
                        });
                        nBPHalfScreenModalView2.event(new Function1<NBPHalfScreenModalEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPHalfScreenModalEvent nBPHalfScreenModalEvent) {
                                nBPHalfScreenModalEvent.onCloseHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFeedCommentPage nearbyFeedCommentPage3 = NearbyFeedCommentPage.this;
                        final Ref.FloatRef floatRef3 = floatRef2;
                        nBPHalfScreenModalView2.contentBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                final Ref.FloatRef floatRef4 = floatRef3;
                                viewContainer3.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(m mVar) {
                                        m mVar2 = mVar;
                                        mVar2.paddingBottom(Ref.FloatRef.this.element);
                                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                NearbyFeedCommentPage.this.contentHeader.invoke(viewContainer3);
                                final NearbyFeedCommentPage nearbyFeedCommentPage4 = NearbyFeedCommentPage.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.4.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NearbyFeedCommentPage nearbyFeedCommentPage5 = NearbyFeedCommentPage.this;
                                        return Boolean.valueOf(((Boolean) nearbyFeedCommentPage5.loadFailed$delegate.getValue(nearbyFeedCommentPage5, NearbyFeedCommentPage.$$delegatedProperties[0])).booleanValue());
                                    }
                                };
                                final NearbyFeedCommentPage nearbyFeedCommentPage5 = NearbyFeedCommentPage.this;
                                ConditionViewKt.c(viewContainer3, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        NearbyFeedCommentPage.this.contentEmpty.invoke(conditionView);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFeedCommentPage nearbyFeedCommentPage6 = NearbyFeedCommentPage.this;
                                ConditionViewKt.a(viewContainer3, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.4.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        NearbyFeedCommentPage.this.contentBody.invoke(conditionView);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        };
                        final NearbyFeedCommentPage nearbyFeedCommentPage4 = NearbyFeedCommentPage.this;
                        nBPHalfScreenModalView2.topLevelExtraBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                NearbyFeedCommentPageData nearbyFeedCommentPageData = NearbyFeedCommentPage.this.data;
                                int i3 = nearbyFeedCommentPageData != null ? nearbyFeedCommentPageData.appId : 0;
                                String pagerId = viewContainer3.getPagerId();
                                final NearbyFeedCommentPage nearbyFeedCommentPage5 = NearbyFeedCommentPage.this;
                                viewContainer3.addChild(new NBPFeedCommentExtraView(i3, pagerId), new Function1<NBPFeedCommentExtraView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedCommentExtraView nBPFeedCommentExtraView) {
                                        NBPFeedCommentExtraView nBPFeedCommentExtraView2 = nBPFeedCommentExtraView;
                                        final NearbyFeedCommentPage nearbyFeedCommentPage6 = NearbyFeedCommentPage.this;
                                        nBPFeedCommentExtraView2.ref(nBPFeedCommentExtraView2, new Function1<aa<NBPFeedCommentExtraView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage.body.1.1.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<NBPFeedCommentExtraView> aaVar) {
                                                NearbyFeedCommentPage.this.commentsExtraViewRef = aaVar;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        };
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (r0.onBack() == true) goto L12;
     */
    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceivePagerEvent(String str, e eVar) {
        boolean z16;
        NBPHalfScreenModalView b16;
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            aa<NBPFeedCommentExtraView> aaVar = this.commentsExtraViewRef;
            if (aaVar != null && (r0 = aaVar.b()) != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                super.onReceivePagerEvent(str, eVar);
                aa<NBPHalfScreenModalView> aaVar2 = this.modalViewRef;
                if (aaVar2 == null || (b16 = aaVar2.b()) == null) {
                    return;
                }
                b16.setAnimationOpen(false);
                return;
            }
            return;
        }
        super.onReceivePagerEvent(str, eVar);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        NBPFeedCommentExtraView b16;
        super.pageDidAppear();
        aa<NBPFeedCommentExtraView> aaVar = this.commentsExtraViewRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel = b16.f114216vm;
            if (nBPFeedCommentExtraViewModel.userInIdentifying) {
                nBPFeedCommentExtraViewModel.userInIdentifying = false;
                nBPFeedCommentExtraViewModel.loadUserIdentity();
            }
        }
        k.d(IPagerIdKtxKt.getNotifyModule(this), "NEARBY_FEED_COMMENT_PAGE_OPEN_EVENT", new e(), false, 4, null);
        TimerKt.e(getPagerId(), 0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage$pageDidAppear$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                IPagerIdKtxKt.getBridgeModule(NearbyFeedCommentPage.this).setWhiteStatusBarStyle();
                return Unit.INSTANCE;
            }
        });
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NearbyFeedCommentPage init, quiTokenThemeMode=");
        m3.append(QUITokenThemeMode.ONLY_DAY_AND_NIGHT);
        m3.append(", isNight=");
        QUIToken qUIToken = QUIToken.INSTANCE;
        m3.append(qUIToken.isNightMode());
        m3.append(", isDark=");
        m3.append(qUIToken.isDarkMode());
        m3.append(", qqThemeMode=");
        int k3 = getPagerData().n().k("qqThemeMode", 0);
        int i3 = 1;
        if (k3 < BoxType$EnumUnboxingSharedUtility.values(4).length) {
            for (int i16 : BoxType$EnumUnboxingSharedUtility.values(4)) {
                if (BoxType$EnumUnboxingSharedUtility.ordinal(i16) == k3) {
                    i3 = i16;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        m3.append(QQThemeMode$EnumUnboxingLocalUtility.stringValueOf(i3));
        kLog.i("NearbyFeedCommentPage", m3.toString());
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        this.pageClosed = true;
        NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = this.pageVm;
        if (nearbyFeedCommentPageViewModel != null) {
            nearbyFeedCommentPageViewModel.dtReportPageExposure(false);
        }
        AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.getNotifyModule(this), "NEARBY_FEED_COMMENT_PAGE_CLOSE_EVENT", false, 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00e8, code lost:
    
        if ((r5.length() == 0) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0091, code lost:
    
        if ((r5.length() == 0) != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x014b  */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void created() {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        NearbyFeedCommentPageData nearbyFeedCommentPageData;
        ac acVar;
        g gVar;
        g gVar2;
        ac acVar2;
        super.created();
        com.tencent.kuikly.core.pager.g pagerData = getPagerData();
        int j3 = pagerData.n().j("app_id");
        String p16 = pagerData.n().p("viewer_user_id");
        String p17 = pagerData.n().p("viewer_nickname");
        String p18 = pagerData.n().p("viewer_avatar");
        String p19 = pagerData.n().p("poster_user_id");
        String p26 = pagerData.n().p("feed_id");
        boolean f16 = pagerData.n().f("with_keyboard");
        int j16 = pagerData.n().j("nbp_source");
        if (j3 != 1) {
            if (j3 == 2) {
                if (!(p16.length() == 0)) {
                    if (!(p17.length() == 0)) {
                    }
                }
                NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                z16 = f16;
                if (p16.length() == 0) {
                    p16 = String.valueOf(userSelfInfo.tid);
                }
                if (p18.length() == 0) {
                    p18 = userSelfInfo.avatarUrl;
                }
                if (p17.length() == 0) {
                    p17 = userSelfInfo.nickName;
                }
            }
            z16 = f16;
        } else {
            z16 = f16;
            if (!(p16.length() == 0)) {
                if (!(p17.length() == 0)) {
                }
            }
            UserSelfBaseInfo matchFriendBaseInfo = QQNearbyModule.Companion.getInstance().getMatchFriendBaseInfo();
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u7f13\u5b58\u83b7\u53d6\u7ed3\u4f34\u7528\u6237\u6570\u636e ");
            m3.append(matchFriendBaseInfo.accountId);
            kLog.i("NearbyFeedCommentPageData", m3.toString());
            if ((p16.length() == 0) && (p16 = matchFriendBaseInfo.accountId) == null) {
                p16 = "";
            }
            if ((p18.length() == 0) && (p18 = matchFriendBaseInfo.avatarUrl) == null) {
                p18 = "";
            }
            if ((p17.length() == 0) && (p17 = matchFriendBaseInfo.nick) == null) {
                str = p18;
                p17 = "";
                if (j3 != 0) {
                    if (!(p16.length() == 0)) {
                        if (!(p19.length() == 0)) {
                            if (!(p26.length() == 0)) {
                                Object[] sharePenetratePageData = QQNearbyModule.Companion.getInstance().getSharePenetratePageData();
                                if (sharePenetratePageData != null && sharePenetratePageData.length == 2) {
                                    try {
                                        g gVar3 = new g(false, 15);
                                        Object obj = sharePenetratePageData[0];
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                                        gVar2 = (g) i.b(gVar3, (byte[]) obj);
                                    } catch (Exception unused) {
                                        gVar2 = null;
                                    }
                                    try {
                                        acVar2 = new ac(null, 0, null, 0, 63);
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        Object obj2 = sharePenetratePageData[1];
                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
                                        acVar = (ac) i.b(acVar2, (byte[]) obj2);
                                    } catch (Exception unused3) {
                                        acVar = null;
                                        if (gVar2 != null) {
                                            gVar = gVar2;
                                            String str5 = p17;
                                            str2 = ", viewerUserId=";
                                            ac acVar3 = acVar;
                                            str4 = ", feedId=";
                                            nearbyFeedCommentPageData = new NearbyFeedCommentPageData(j3, j16, p16, str5, str, p19, p26, gVar, acVar3, z16);
                                            str3 = ", posterUserId=";
                                            if (nearbyFeedCommentPageData != null) {
                                            }
                                        }
                                        acVar = null;
                                        gVar = null;
                                        String str52 = p17;
                                        str2 = ", viewerUserId=";
                                        ac acVar32 = acVar;
                                        str4 = ", feedId=";
                                        nearbyFeedCommentPageData = new NearbyFeedCommentPageData(j3, j16, p16, str52, str, p19, p26, gVar, acVar32, z16);
                                        str3 = ", posterUserId=";
                                        if (nearbyFeedCommentPageData != null) {
                                        }
                                    }
                                    if (gVar2 != null && acVar != null) {
                                        gVar = gVar2;
                                        String str522 = p17;
                                        str2 = ", viewerUserId=";
                                        ac acVar322 = acVar;
                                        str4 = ", feedId=";
                                        nearbyFeedCommentPageData = new NearbyFeedCommentPageData(j3, j16, p16, str522, str, p19, p26, gVar, acVar322, z16);
                                        str3 = ", posterUserId=";
                                        if (nearbyFeedCommentPageData != null) {
                                            KLog.INSTANCE.e("NearbyFeedCommentPage", "created: \u9875\u9762\u542f\u52a8\u6570\u636e\u9519\u8bef\uff0c\u53c2\u6570\u89e3\u6790\u5931\u8d25");
                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                            return;
                                        }
                                        KLog kLog2 = KLog.INSTANCE;
                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("page opened: appId=");
                                        m16.append(nearbyFeedCommentPageData.appId);
                                        m16.append(str2);
                                        m16.append(nearbyFeedCommentPageData.viewerUserId);
                                        m16.append(", viewerAvatar=");
                                        m16.append(nearbyFeedCommentPageData.viewerAvatar);
                                        m16.append(str3);
                                        m16.append(nearbyFeedCommentPageData.posterUserId);
                                        m16.append(str4);
                                        m16.append(nearbyFeedCommentPageData.feedId);
                                        m16.append(", withKeyboard=");
                                        m16.append(nearbyFeedCommentPageData.withKeyboard);
                                        m16.append(", source=");
                                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m16, nearbyFeedCommentPageData.source, kLog2, "NearbyFeedCommentPage");
                                        this.data = nearbyFeedCommentPageData;
                                        NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = new NearbyFeedCommentPageViewModel(nearbyFeedCommentPageData);
                                        this.pageVm = nearbyFeedCommentPageViewModel;
                                        nearbyFeedCommentPageViewModel.dtReportPageExposure(true);
                                        return;
                                    }
                                }
                                acVar = null;
                                gVar = null;
                                String str5222 = p17;
                                str2 = ", viewerUserId=";
                                ac acVar3222 = acVar;
                                str4 = ", feedId=";
                                nearbyFeedCommentPageData = new NearbyFeedCommentPageData(j3, j16, p16, str5222, str, p19, p26, gVar, acVar3222, z16);
                                str3 = ", posterUserId=";
                                if (nearbyFeedCommentPageData != null) {
                                }
                            }
                        }
                    }
                }
                str2 = ", viewerUserId=";
                str3 = ", posterUserId=";
                str4 = ", feedId=";
                KLog kLog3 = KLog.INSTANCE;
                StringBuilder m17 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("parse: \u9875\u9762\u542f\u52a8\u6570\u636e\u9519\u8bef appId=", j3, str2, p16, str3);
                m17.append(p19);
                m17.append(str4);
                m17.append(p26);
                kLog3.e("NearbyFeedCommentPageData", m17.toString());
                nearbyFeedCommentPageData = null;
                if (nearbyFeedCommentPageData != null) {
                }
            }
        }
        str = p18;
        if (j3 != 0) {
        }
        str2 = ", viewerUserId=";
        str3 = ", posterUserId=";
        str4 = ", feedId=";
        KLog kLog32 = KLog.INSTANCE;
        StringBuilder m172 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("parse: \u9875\u9762\u542f\u52a8\u6570\u636e\u9519\u8bef appId=", j3, str2, p16, str3);
        m172.append(p19);
        m172.append(str4);
        m172.append(p26);
        kLog32.e("NearbyFeedCommentPageData", m172.toString());
        nearbyFeedCommentPageData = null;
        if (nearbyFeedCommentPageData != null) {
        }
    }
}
