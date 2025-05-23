package com.tencent.hippykotlin.demo.pages.nearby.new_homepage;

import c01.c;
import c45.i;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyMineAvatarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyMineAvatarEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyMineAvatarView;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCardAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedListViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.NBPTacitAgreementAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.FetchStatus;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.EventName;
import com.tencent.kuikly.core.base.event.PanGestureParams;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.co;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p35.n;
import s35.a;

/* loaded from: classes31.dex */
public final class NBPNewHomepage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPNewHomepage.class, "isFeedStateFull", "isFeedStateFull()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPNewHomepage.class, "isMinScreen", "isMinScreen()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPNewHomepage.class, "avatarOpacity", "getAvatarOpacity()F", 0)};
    public final ReadWriteProperty avatarOpacity$delegate;
    public aa<NearbyMineAvatarView> avatarViewRef;
    public String feedAddNotifyRef;
    public String feedDeleteNotifyRef;
    public String feedLikeChangeNotifyRef;
    public int feedState;
    public boolean handleContentSizeChangedManually;
    public final ReadWriteProperty isFeedStateFull$delegate;
    public final ReadWriteProperty isMinScreen$delegate;
    public String jieBanPublishNotifyRef;
    public String lastTouchState = "";
    public aa<aq<?, ?>> listViewRef;
    public String userSelfInfoChangeNotifyRef;
    public NBPHomePageBaseViewModel viewModel;

    public NBPNewHomepage() {
        Boolean bool = Boolean.FALSE;
        this.isFeedStateFull$delegate = c.a(bool);
        this.isMinScreen$delegate = c.a(bool);
        this.avatarOpacity$delegate = c.a(Float.valueOf(1.0f));
        this.feedState = 2;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float g16 = (getPagerData().g() * 0.73f) - getBottomBarHeight();
        final float g17 = ((getPagerData().g() * 4) * 0.365f) / 7;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
            
                if (r1.isSelf == true) goto L8;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        mVar2.overflow(true);
                        return Unit.INSTANCE;
                    }
                });
                final NBPNewHomepage nBPNewHomepage = NBPNewHomepage.this;
                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = nBPNewHomepage.viewModel;
                boolean z16 = nBPHomePageBaseViewModel != null;
                if (z16) {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$body$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final NBPNewHomepage nBPNewHomepage2 = NBPNewHomepage.this;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.positionAbsolute();
                                    tVar2.m142left(0.0f);
                                    tVar2.m149right(0.0f);
                                    tVar2.mo153width(tVar2.getPagerData().m());
                                    float g18 = tVar2.getPagerData().g() * 0.74f;
                                    NBPNewHomepage nBPNewHomepage3 = NBPNewHomepage.this;
                                    KProperty<Object>[] kPropertyArr = NBPNewHomepage.$$delegatedProperties;
                                    tVar2.mo141height(g18 - nBPNewHomepage3.getBottomBarHeight());
                                    tVar2.m154zIndex(0);
                                    return Unit.INSTANCE;
                                }
                            });
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.2.2
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.2.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.positionAbsolute();
                                            afVar2.m142left(0.0f);
                                            afVar2.m150top(0.0f);
                                            afVar2.m149right(0.0f);
                                            afVar2.m138bottom(0.0f);
                                            b.a.b(afVar2, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/uMKIUZm4.png", false, 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPNewHomepage nBPNewHomepage3 = NBPNewHomepage.this;
                            vVar2.addChild(new NearbyMineAvatarView(), new Function1<NearbyMineAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.2.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NearbyMineAvatarView nearbyMineAvatarView) {
                                    NearbyMineAvatarView nearbyMineAvatarView2 = nearbyMineAvatarView;
                                    final NBPNewHomepage nBPNewHomepage4 = NBPNewHomepage.this;
                                    nearbyMineAvatarView2.ref(nearbyMineAvatarView2, new Function1<aa<NearbyMineAvatarView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.2.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(aa<NearbyMineAvatarView> aaVar) {
                                            NBPNewHomepage.this.avatarViewRef = aaVar;
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPNewHomepage nBPNewHomepage5 = NBPNewHomepage.this;
                                    nearbyMineAvatarView2.attr(new Function1<NearbyMineAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.2.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NearbyMineAvatarAttr nearbyMineAvatarAttr) {
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2;
                                            s35.af userInfo;
                                            a aVar;
                                            String str;
                                            NearbyMineAvatarAttr nearbyMineAvatarAttr2 = nearbyMineAvatarAttr;
                                            nearbyMineAvatarAttr2.positionAbsolute();
                                            float f16 = 4;
                                            float g18 = (nearbyMineAvatarAttr2.getPagerData().g() / 7) * f16;
                                            float f17 = (g18 / f16) * 3;
                                            float m3 = (nearbyMineAvatarAttr2.getPagerData().m() - f17) / 2;
                                            nearbyMineAvatarAttr2.mo153width(f17);
                                            nearbyMineAvatarAttr2.mo141height(g18);
                                            nearbyMineAvatarAttr2.marginLeft(m3);
                                            nearbyMineAvatarAttr2.with("status", 1);
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPNewHomepage.this.viewModel;
                                            if ((nBPHomePageBaseViewModel3 != null ? (FetchStatus) nBPHomePageBaseViewModel3.userInfoState$delegate.getValue(nBPHomePageBaseViewModel3, NBPHomePageBaseViewModel.$$delegatedProperties[3]) : null) == FetchStatus.FETCH_STATE_SUCCESS && (nBPHomePageBaseViewModel2 = NBPNewHomepage.this.viewModel) != null && (userInfo = nBPHomePageBaseViewModel2.getUserInfo()) != null && (aVar = userInfo.f433206d0) != null && (str = aVar.f433188d) != null) {
                                                nearbyMineAvatarAttr2.with("avatarCharacter", str);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPNewHomepage nBPNewHomepage6 = NBPNewHomepage.this;
                                    nearbyMineAvatarView2.event(new Function1<NearbyMineAvatarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.2.3.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NearbyMineAvatarEvent nearbyMineAvatarEvent) {
                                            final NBPNewHomepage nBPNewHomepage7 = NBPNewHomepage.this;
                                            nearbyMineAvatarEvent.register("updateAvatar", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.2.3.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    List<Integer> listOf;
                                                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPNewHomepage.this.viewModel;
                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                        NBPNewHomeRepository nBPNewHomeRepository = NBPNewHomeRepository.INSTANCE;
                                                        int appId = nBPHomePageBaseViewModel2.getAppId();
                                                        int accountType = nBPHomePageBaseViewModel2.getAccountType();
                                                        String str = nBPHomePageBaseViewModel2.accountId;
                                                        listOf = CollectionsKt__CollectionsJVMKt.listOf(31);
                                                        nBPNewHomeRepository.fetchUserInfo(appId, accountType, str, listOf, new Function1<s35.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$refreshAvatarInfo$1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(s35.af afVar) {
                                                                s35.af afVar2 = afVar;
                                                                s35.af userInfo = NBPHomePageBaseViewModel.this.getUserInfo();
                                                                if (userInfo != null) {
                                                                    NBPHomePageBaseViewModel.this.setUserInfo(NBPNewHomeRepository.copyUserInfo$default(userInfo, null, null, 0, null, null, null, afVar2.f433206d0, null, -2, 61));
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$refreshAvatarInfo$2
                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                                                                num.intValue();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
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
                }
                final NBPNewHomepage nBPNewHomepage2 = NBPNewHomepage.this;
                final float f16 = g16;
                final float f17 = g17;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0023, code lost:
                    
                        if (r1.isSelf == true) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final NBPNewHomepage nBPNewHomepage3 = NBPNewHomepage.this;
                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                NBPNewHomepage.this.listViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewHomepage nBPNewHomepage4 = NBPNewHomepage.this;
                        final float f18 = f16;
                        final float f19 = f17;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                aq<?, ?> b16;
                                ao aoVar2 = aoVar;
                                aoVar2.m140flex(1.0f);
                                aoVar2.mo153width(aoVar2.getPagerData().m());
                                aoVar2.borderRadius(15.0f);
                                boolean z17 = false;
                                aoVar2.overflow(false);
                                ScrollerAttr.bouncesEnable$default(aoVar2, false, false, 2, null);
                                aoVar2.showScrollerIndicator(false);
                                NBPNewHomepage nBPNewHomepage5 = NBPNewHomepage.this;
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = nBPNewHomepage5.viewModel;
                                if (nBPHomePageBaseViewModel2 != null && nBPHomePageBaseViewModel2.isSelf) {
                                    z17 = true;
                                }
                                if (z17) {
                                    aa<aq<?, ?>> aaVar = nBPNewHomepage5.listViewRef;
                                    if (aaVar != null && (b16 = aaVar.b()) != null) {
                                        ScrollerView.setContentOffset$default(b16, 0.0f, f18 - f19, false, null, 8, null);
                                    }
                                    NBPNewHomepage.this.handleContentSizeChangedManually = true;
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewHomepage nBPNewHomepage5 = NBPNewHomepage.this;
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = nBPNewHomepage5.viewModel;
                        boolean z17 = nBPHomePageBaseViewModel2 != null;
                        if (z17) {
                            final float f26 = f16;
                            w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    final float f27 = f26;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.size(tVar2.getPagerData().m(), f27);
                                            tVar2.m154zIndex(0);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPNewHomepage nBPNewHomepage6 = nBPNewHomepage5;
                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            u uVar2 = uVar;
                                            final NBPNewHomepage nBPNewHomepage7 = NBPNewHomepage.this;
                                            uVar2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.3.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TouchParams touchParams) {
                                                    NBPNewHomepage.this.lastTouchState = EventName.TOUCH_DOWN.getValue();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPNewHomepage nBPNewHomepage8 = NBPNewHomepage.this;
                                            uVar2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.3.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TouchParams touchParams) {
                                                    String str = NBPNewHomepage.this.lastTouchState;
                                                    EventName eventName = EventName.TOUCH_UP;
                                                    if (!Intrinsics.areEqual(str, eventName.getValue())) {
                                                        NBPNewHomepage.this.lastTouchState = eventName.getValue();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPNewHomepage nBPNewHomepage9 = NBPNewHomepage.this;
                                            uVar2.pan(new Function1<PanGestureParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.3.2.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(PanGestureParams panGestureParams) {
                                                    NearbyMineAvatarView b16;
                                                    PanGestureParams panGestureParams2 = panGestureParams;
                                                    aa<NearbyMineAvatarView> aaVar = NBPNewHomepage.this.avatarViewRef;
                                                    if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                        e eVar = new e();
                                                        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(panGestureParams2.getX()));
                                                        eVar.v("y", Float.valueOf(panGestureParams2.getY()));
                                                        eVar.v("state", panGestureParams2.getState());
                                                        eVar.v("pageX", Float.valueOf(panGestureParams2.getPageX()));
                                                        eVar.v("pageY", Float.valueOf(panGestureParams2.getPageY()));
                                                        AbstractBaseView.callRenderViewMethod$default(b16, "pan", eVar.toString(), null, 4, null);
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
                        }
                        final NBPNewHomepage nBPNewHomepage6 = NBPNewHomepage.this;
                        aqVar2.addChild(new NBPHomepageProfileCard(), new Function1<NBPHomepageProfileCard, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPHomepageProfileCard nBPHomepageProfileCard) {
                                final NBPNewHomepage nBPNewHomepage7 = NBPNewHomepage.this;
                                nBPHomepageProfileCard.attr(new Function1<NBPHomepageProfileCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPHomepageProfileCardAttr nBPHomepageProfileCardAttr) {
                                        NBPHomepageProfileCardAttr nBPHomepageProfileCardAttr2 = nBPHomepageProfileCardAttr;
                                        nBPHomepageProfileCardAttr2.viewModel = NBPNewHomepage.this.viewModel;
                                        nBPHomepageProfileCardAttr2.borderRadius(16.0f, 16.0f, 0.0f, 0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewHomepage nBPNewHomepage7 = NBPNewHomepage.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPNewHomepage.this.viewModel;
                                if (nBPHomePageBaseViewModel3 != null) {
                                    return Boolean.valueOf(nBPHomePageBaseViewModel3.tacitShow());
                                }
                                return null;
                            }
                        };
                        final NBPNewHomepage nBPNewHomepage8 = NBPNewHomepage.this;
                        ConditionViewKt.c(aqVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPNewHomepage nBPNewHomepage9 = NBPNewHomepage.this;
                                conditionView.addChild(new TacitAgreementView(), new Function1<TacitAgreementView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TacitAgreementView tacitAgreementView) {
                                        final NBPNewHomepage nBPNewHomepage10 = NBPNewHomepage.this;
                                        tacitAgreementView.attr(new Function1<NBPTacitAgreementAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.6.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPTacitAgreementAttr nBPTacitAgreementAttr) {
                                                NBPTacitAgreementAttr nBPTacitAgreementAttr2 = nBPTacitAgreementAttr;
                                                nBPTacitAgreementAttr2.viewModel = NBPNewHomepage.this.viewModel;
                                                nBPTacitAgreementAttr2.marginTop(-0.5f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewHomepage nBPNewHomepage9 = NBPNewHomepage.this;
                        aqVar2.addChild(new HomepageFeedsView(), new Function1<HomepageFeedsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(HomepageFeedsView homepageFeedsView) {
                                final NBPNewHomepage nBPNewHomepage10 = NBPNewHomepage.this;
                                homepageFeedsView.attr(new Function1<FeedListViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.7.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(FeedListViewAttr feedListViewAttr) {
                                        FeedListViewAttr feedListViewAttr2 = feedListViewAttr;
                                        feedListViewAttr2.viewModel = NBPNewHomepage.this.viewModel;
                                        c.a.a(feedListViewAttr2, 0.0f, 0.0f, 30.0f, 0.0f, 11, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPNewHomepage nBPNewHomepage10 = NBPNewHomepage.this;
                        final float f27 = f17;
                        final float f28 = f16;
                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ap apVar) {
                                final ap apVar2 = apVar;
                                final Ref.IntRef intRef = new Ref.IntRef();
                                final NBPNewHomepage nBPNewHomepage11 = NBPNewHomepage.this;
                                apVar2.dragEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        ap apVar3 = ap.this;
                                        final NBPNewHomepage nBPNewHomepage12 = nBPNewHomepage11;
                                        Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPNewHomepage.this.viewModel;
                                                if (nBPHomePageBaseViewModel3 != null) {
                                                    nBPHomePageBaseViewModel3.handlePendingFeeds();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                        TimerKt.e(apVar3.getPagerId(), 1, function02);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewHomepage nBPNewHomepage12 = NBPNewHomepage.this;
                                final float f29 = f27;
                                final float f36 = f28;
                                apVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        NearbyMineAvatarView b16;
                                        NearbyMineAvatarView b17;
                                        ScrollParams scrollParams2 = scrollParams;
                                        aa<NearbyMineAvatarView> aaVar = NBPNewHomepage.this.avatarViewRef;
                                        if (aaVar != null && (b17 = aaVar.b()) != null) {
                                            int offsetY = (int) scrollParams2.getOffsetY();
                                            int i3 = (int) f29;
                                            int i16 = (int) f36;
                                            e eVar = new e();
                                            eVar.t("offsetY", offsetY);
                                            eVar.t("minInsetTop", i3);
                                            eVar.t("maxInsetTop", i16);
                                            AbstractBaseView.callRenderViewMethod$default(b17, "onContentOffsetChanged", eVar.toString(), null, 4, null);
                                        }
                                        boolean z18 = false;
                                        if (((int) scrollParams2.getOffsetY()) < f36 - 60.0f && intRef.element > scrollParams2.getOffsetY()) {
                                            NBPNewHomepage.this.setFeedStateFull(false);
                                        }
                                        if (((int) scrollParams2.getOffsetY()) > ((int) f36) - 60 && intRef.element < scrollParams2.getOffsetY()) {
                                            NBPNewHomepage.this.setFeedStateFull(true);
                                        }
                                        if (((int) scrollParams2.getOffsetY()) < 10.0f && ((int) scrollParams2.getOffsetY()) >= 0.0f) {
                                            NBPNewHomepage.this.setFeedStateFull(false);
                                        }
                                        intRef.element = (int) scrollParams2.getOffsetY();
                                        float f37 = f36;
                                        float f38 = f37 - f29;
                                        float offsetY2 = f37 - scrollParams2.getOffsetY();
                                        float f39 = f29;
                                        if (offsetY2 >= f39) {
                                            float f46 = offsetY2 - f39;
                                            if (f46 <= f38) {
                                                final float f47 = f46 / f38;
                                                aa<NearbyMineAvatarView> aaVar2 = NBPNewHomepage.this.avatarViewRef;
                                                if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                                                    b16.attr(new Function1<NearbyMineAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NearbyMineAvatarAttr nearbyMineAvatarAttr) {
                                                            nearbyMineAvatarAttr.m150top(f47 * 56.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                            }
                                        }
                                        NBPNewHomepage nBPNewHomepage13 = NBPNewHomepage.this;
                                        ReadWriteProperty readWriteProperty = nBPNewHomepage13.isFeedStateFull$delegate;
                                        KProperty<?>[] kPropertyArr = NBPNewHomepage.$$delegatedProperties;
                                        if (((Boolean) readWriteProperty.getValue(nBPNewHomepage13, kPropertyArr[0])).booleanValue()) {
                                            float f48 = NBPNewHomepage.this.getPagerData().getIsIOS() ? 20.0f : 26.0f;
                                            NBPNewHomepage nBPNewHomepage14 = NBPNewHomepage.this;
                                            nBPNewHomepage14.avatarOpacity$delegate.setValue(nBPNewHomepage14, kPropertyArr[2], Float.valueOf(Math.min(1.0f, Math.max(0.0f, (offsetY2 + f48) / (f48 + 30.0f)))));
                                        }
                                        if (scrollParams2.getContentHeight() - scrollParams2.getViewHeight() < scrollParams2.getOffsetY() + 744.0f) {
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPNewHomepage.this.viewModel;
                                            if (nBPHomePageBaseViewModel3 != null) {
                                                nBPHomePageBaseViewModel3.fetchFeedList(false);
                                            }
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPNewHomepage.this.viewModel;
                                            if (nBPHomePageBaseViewModel4 != null && nBPHomePageBaseViewModel4.isCurrentLikedPage) {
                                                z18 = true;
                                            }
                                            if (z18 && nBPHomePageBaseViewModel4 != null) {
                                                nBPHomePageBaseViewModel4.fetchUserLikedList();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewHomepage nBPNewHomepage13 = NBPNewHomepage.this;
                                apVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        ScrollParams scrollParams2 = scrollParams;
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPNewHomepage.this.viewModel;
                                        if (nBPHomePageBaseViewModel3 != null) {
                                            nBPHomePageBaseViewModel3.isScrolling = false;
                                        }
                                        if (scrollParams2.getOffsetY() > 200.0f && scrollParams2.getOffsetY() < 500.0f) {
                                            NBPNewHomepage nBPNewHomepage14 = NBPNewHomepage.this;
                                            if (nBPNewHomepage14.feedState != 2) {
                                                nBPNewHomepage14.setFeedState(2);
                                            }
                                        }
                                        if (scrollParams2.getOffsetY() > 0.0f && scrollParams2.getOffsetY() < 200.0f) {
                                            NBPNewHomepage nBPNewHomepage15 = NBPNewHomepage.this;
                                            if (nBPNewHomepage15.feedState != 1) {
                                                nBPNewHomepage15.setFeedState(1);
                                            }
                                        }
                                        if (((int) scrollParams2.getOffsetY()) == 0) {
                                            NBPNewHomepage.this.setFeedState(1);
                                        }
                                        ap apVar3 = apVar2;
                                        final NBPNewHomepage nBPNewHomepage16 = NBPNewHomepage.this;
                                        Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8.3.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPNewHomepage.this.viewModel;
                                                if (nBPHomePageBaseViewModel4 != null) {
                                                    nBPHomePageBaseViewModel4.handlePendingFeeds();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                        TimerKt.e(apVar3.getPagerId(), 1, function02);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewHomepage nBPNewHomepage14 = NBPNewHomepage.this;
                                apVar2.willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(co coVar) {
                                        co coVar2 = coVar;
                                        NBPNewHomepage nBPNewHomepage15 = NBPNewHomepage.this;
                                        KProperty<Object>[] kPropertyArr = NBPNewHomepage.$$delegatedProperties;
                                        float velocityY = (coVar2.getVelocityY() * (nBPNewHomepage15.getPagerData().getIsIOS() ? 17.0f : 8.85f)) + coVar2.getOffsetY();
                                        float g18 = (nBPNewHomepage15.getPagerData().g() * 0.73f) - nBPNewHomepage15.getBottomBarHeight();
                                        float g19 = ((nBPNewHomepage15.getPagerData().g() * 4) * 0.365f) / 7;
                                        float f37 = (g18 + g19) / 2.0f;
                                        KLog kLog = KLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("willDragEndBySync: result: ");
                                        float f38 = g18 - velocityY;
                                        m3.append(f38);
                                        m3.append(", offsetY:");
                                        m3.append(velocityY);
                                        m3.append(", middleInsetTopMinHeight:");
                                        m3.append(f37);
                                        m3.append(", minContentInsetTop:");
                                        m3.append(g19);
                                        m3.append(", maxContentInsetTop: ");
                                        m3.append(g18);
                                        m3.append(", state:");
                                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, nBPNewHomepage15.feedState, kLog, "NBPNewHomepage");
                                        int i3 = 1;
                                        if (f38 > f37) {
                                            nBPNewHomepage15.setFeedStateFull(false);
                                            nBPNewHomepage15.setMinScreen(true);
                                        } else if (f38 > g19) {
                                            nBPNewHomepage15.setFeedStateFull(false);
                                            nBPNewHomepage15.setMinScreen(false);
                                            i3 = 2;
                                        } else {
                                            if ((nBPNewHomepage15.feedState != 3 || velocityY <= g18) && (f38 >= g19 || velocityY >= g18)) {
                                                nBPNewHomepage15.setFeedStateFull(true);
                                                nBPNewHomepage15.setMinScreen(false);
                                                i3 = 3;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        nBPNewHomepage15.setFeedState(i3);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewHomepage nBPNewHomepage15 = NBPNewHomepage.this;
                                apVar2.contentSizeChanged(new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Float f37, Float f38) {
                                        f37.floatValue();
                                        f38.floatValue();
                                        final NBPNewHomepage nBPNewHomepage16 = NBPNewHomepage.this;
                                        if (nBPNewHomepage16.handleContentSizeChangedManually) {
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = nBPNewHomepage16.viewModel;
                                            if (nBPHomePageBaseViewModel3 != null && nBPHomePageBaseViewModel3.isScrolling) {
                                                nBPNewHomepage16.handleContentSizeChangedManually = false;
                                                if (nBPHomePageBaseViewModel3 != null) {
                                                    nBPHomePageBaseViewModel3.isScrolling = false;
                                                }
                                                ap apVar3 = apVar2;
                                                Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.3.8.5.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPNewHomepage.this.viewModel;
                                                        if (nBPHomePageBaseViewModel4 != null) {
                                                            nBPHomePageBaseViewModel4.handlePendingFeeds();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                TimerKt.e(apVar3.getPagerId(), 1, function02);
                                            }
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
                final NBPNewHomepage nBPNewHomepage3 = NBPNewHomepage.this;
                viewContainer2.addChild(new NBPHomepageNavBar(), new Function1<NBPHomepageNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPHomepageNavBar nBPHomepageNavBar) {
                        final NBPNewHomepage nBPNewHomepage4 = NBPNewHomepage.this;
                        nBPHomepageNavBar.attr(new Function1<NBPHomepageNavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPHomepageNavBarAttr nBPHomepageNavBarAttr) {
                                NBPHomepageNavBarAttr nBPHomepageNavBarAttr2 = nBPHomepageNavBarAttr;
                                nBPHomepageNavBarAttr2.positionAbsolute();
                                NBPNewHomepage nBPNewHomepage5 = NBPNewHomepage.this;
                                ReadWriteProperty readWriteProperty = nBPNewHomepage5.isFeedStateFull$delegate;
                                KProperty<?>[] kPropertyArr = NBPNewHomepage.$$delegatedProperties;
                                boolean booleanValue = ((Boolean) readWriteProperty.getValue(nBPNewHomepage5, kPropertyArr[0])).booleanValue();
                                ReadWriteProperty readWriteProperty2 = nBPHomepageNavBarAttr2.isFullScreen$delegate;
                                KProperty<?>[] kPropertyArr2 = NBPHomepageNavBarAttr.$$delegatedProperties;
                                readWriteProperty2.setValue(nBPHomepageNavBarAttr2, kPropertyArr2[0], Boolean.valueOf(booleanValue));
                                NBPNewHomepage nBPNewHomepage6 = NBPNewHomepage.this;
                                nBPHomepageNavBarAttr2.isMinScreen$delegate.setValue(nBPHomepageNavBarAttr2, kPropertyArr2[2], Boolean.valueOf(((Boolean) nBPNewHomepage6.isMinScreen$delegate.getValue(nBPNewHomepage6, kPropertyArr[1])).booleanValue()));
                                NBPNewHomepage nBPNewHomepage7 = NBPNewHomepage.this;
                                nBPHomepageNavBarAttr2.viewModel = nBPNewHomepage7.viewModel;
                                nBPHomepageNavBarAttr2.avatarOpacity$delegate.setValue(nBPHomepageNavBarAttr2, kPropertyArr2[1], Float.valueOf(1.0f - ((Number) nBPNewHomepage7.avatarOpacity$delegate.getValue(nBPNewHomepage7, kPropertyArr[2])).floatValue()));
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

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.viewModel = NBPHomePageBaseViewModel.Companion.created(getPageData(), false);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NBPNewHomepage nBPNewHomepage = NBPNewHomepage.this;
                nBPNewHomepage.getClass();
                nBPNewHomepage.userSelfInfoChangeNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPNewHomepage), "onNearbyProUserInfoChange", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$initNotify$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel;
                        e eVar2 = eVar;
                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("on user info change: ", eVar2, KLog.INSTANCE, "NBPNewHomepage");
                        if (eVar2 != null && (nBPHomePageBaseViewModel = NBPNewHomepage.this.viewModel) != null) {
                            nBPHomePageBaseViewModel.updateUserInfo(eVar2);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nBPNewHomepage.feedDeleteNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPNewHomepage), "NBPFeedDeleteEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$initNotify$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        n nVar;
                        e eVar2 = eVar;
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPNewHomepage.this.viewModel;
                        if (nBPHomePageBaseViewModel != null && eVar2 != null) {
                            String p16 = eVar2.p("feedId");
                            Iterator<n> it = nBPHomePageBaseViewModel.getFeedList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    nVar = null;
                                    break;
                                }
                                nVar = it.next();
                                if (Intrinsics.areEqual(nVar.f425193d, p16)) {
                                    break;
                                }
                            }
                            n nVar2 = nVar;
                            boolean z16 = nVar2 != null;
                            if (z16) {
                                TypeIntrinsics.asMutableCollection(nBPHomePageBaseViewModel.getFeedList()).remove(nVar2);
                            }
                            KLog.INSTANCE.i("NBPHomePageBaseViewModel", "removeFeedItem: " + p16 + ", canDelete: " + z16);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nBPNewHomepage.feedLikeChangeNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPNewHomepage), "NearbyFeedLikeStatusChangedEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$initNotify$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPNewHomepage.this.viewModel;
                        if (nBPHomePageBaseViewModel != null) {
                            nBPHomePageBaseViewModel.updateLikeNum(eVar2);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nBPNewHomepage.feedAddNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPNewHomepage), "onPublishFeedFinish", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$initNotify$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPNewHomepage.this.viewModel;
                        if (nBPHomePageBaseViewModel != null) {
                            nBPHomePageBaseViewModel.refreshFeedList();
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nBPNewHomepage.jieBanPublishNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nBPNewHomepage), "JIEBAN_PUBLISH_SUCCESS_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$initNotify$5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPNewHomepage.this.viewModel;
                        if (nBPHomePageBaseViewModel != null) {
                            nBPHomePageBaseViewModel.refreshFeedList();
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = nBPNewHomepage.viewModel;
                if (nBPHomePageBaseViewModel != null && nBPHomePageBaseViewModel.getAppId() == 1) {
                    QQNearbyModule.Companion.getInstance().syncToNativeMethod(true, "observeKLSignalMetaChanged", new Object[0], new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$initNotify$6
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Object obj) {
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2;
                            j25.c cVar;
                            byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
                            if (bArr != null && (nBPHomePageBaseViewModel2 = NBPNewHomepage.this.viewModel) != null) {
                                try {
                                    cVar = (j25.c) i.b(new j25.c(0L, null, null, 0L, 0L, null, 63, null), bArr);
                                } catch (Throwable unused) {
                                    cVar = null;
                                }
                                s35.af userInfo = nBPHomePageBaseViewModel2.getUserInfo();
                                if (userInfo != null) {
                                    nBPHomePageBaseViewModel2.setUserInfo(NBPNewHomeRepository.copyUserInfo$default(userInfo, null, null, 0, null, null, null, null, cVar, -2, 59));
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 1, function0);
    }

    public final float getBottomBarHeight() {
        if (getPageData().n().j("bu_type") == 1) {
            return getPageData().getSafeAreaInsets().getBottom() + 49;
        }
        return 0.0f;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        NearbyMineAvatarView b16;
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, Pager.PAGER_EVENT_ROOT_VIEW_SIZE_CHANGED)) {
            float f16 = 4;
            final float g16 = (getPagerData().g() / 7) * f16;
            final float f17 = (g16 / f16) * 3;
            final float m3 = (getPagerData().m() - f17) / 2;
            aa<NearbyMineAvatarView> aaVar = this.avatarViewRef;
            if (aaVar == null || (b16 = aaVar.b()) == null) {
                return;
            }
            b16.attr(new Function1<NearbyMineAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$handleOnSizeChanged$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(NearbyMineAvatarAttr nearbyMineAvatarAttr) {
                    NearbyMineAvatarAttr nearbyMineAvatarAttr2 = nearbyMineAvatarAttr;
                    nearbyMineAvatarAttr2.size(f17, g16);
                    nearbyMineAvatarAttr2.marginLeft(m3);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        NearbyMineAvatarView b16;
        super.pageDidAppear();
        aa<NearbyMineAvatarView> aaVar = this.avatarViewRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            AbstractBaseView.callRenderViewMethod$default(b16, "onResume", null, null, 6, null);
        }
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = this.viewModel;
        if (nBPHomePageBaseViewModel != null) {
            nBPHomePageBaseViewModel.refreshSelfInfo();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidDisappear() {
        NearbyMineAvatarView b16;
        super.pageDidDisappear();
        aa<NearbyMineAvatarView> aaVar = this.avatarViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        AbstractBaseView.callRenderViewMethod$default(b16, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, null, null, 6, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        KLog.INSTANCE.i("NBPNewHomepage", Pager.PAGER_EVENT_WILL_DESTROY);
        String str = this.userSelfInfoChangeNotifyRef;
        if (str != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("onNearbyProUserInfoChange", str);
        }
        String str2 = this.feedDeleteNotifyRef;
        if (str2 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("NBPFeedDeleteEvent", str2);
        }
        String str3 = this.feedLikeChangeNotifyRef;
        if (str3 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("NearbyFeedLikeStatusChangedEvent", str3);
        }
        String str4 = this.feedAddNotifyRef;
        if (str4 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("onPublishFeedFinish", str4);
        }
        String str5 = this.jieBanPublishNotifyRef;
        if (str5 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("JIEBAN_PUBLISH_SUCCESS_EVENT", str5);
        }
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = this.viewModel;
        if (nBPHomePageBaseViewModel != null) {
            nBPHomePageBaseViewModel.reportPageExposure(false);
        }
    }

    public final void setFeedState(final int i3) {
        this.feedState = i3;
        final float g16 = (getPagerData().g() * 0.73f) - getBottomBarHeight();
        final float g17 = ((getPagerData().g() * 4) * 0.365f) / 7;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage$feedState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                e eVar;
                aq<?, ?> b16;
                aa<aq<?, ?>> aaVar;
                aq<?, ?> b17;
                int i16 = i3;
                if (i16 == 1) {
                    aa<aq<?, ?>> aaVar2 = this.listViewRef;
                    if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                        ScrollerView.setContentOffset$default(b16, 0.0f, 0.0f, true, null, 8, null);
                    }
                    this.setMinScreen(true);
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = this.viewModel;
                    if (nBPHomePageBaseViewModel != null) {
                        e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
                        NBPNewHomepage nBPNewHomepage = this;
                        jsonWithHomePagePgParams.v("dt_eid", "em_kl_stand_avatar");
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = nBPNewHomepage.viewModel;
                        if (nBPHomePageBaseViewModel2 != null) {
                            eVar = nBPHomePageBaseViewModel2.jsonWithHomePagePgParams();
                        } else {
                            eVar = new e();
                        }
                        jsonWithHomePagePgParams.v("cur_pg", eVar);
                        jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithHomePagePgParams);
                    }
                } else if (i16 == 2 && (aaVar = this.listViewRef) != null && (b17 = aaVar.b()) != null) {
                    ScrollerView.setContentOffset$default(b17, 0.0f, g16 - g17, true, null, 8, null);
                }
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 16, function0);
    }

    public final void setFeedStateFull(boolean z16) {
        this.isFeedStateFull$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public final void setMinScreen(boolean z16) {
        this.isMinScreen$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = this.viewModel;
        if (nBPHomePageBaseViewModel != null) {
            nBPHomePageBaseViewModel.reportPageExposure(true);
        }
    }
}
