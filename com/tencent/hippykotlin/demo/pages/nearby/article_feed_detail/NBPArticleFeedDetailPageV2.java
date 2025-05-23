package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import c01.c;
import c45.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.view.QQRichTextView;
import com.tencent.hippykotlin.demo.pages.base.view.QQTextView;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.MatchFriendUserSelfData;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.BDHService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.ReportReadFeedsRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo$fetchFeedList$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerGetFeedListRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewEvent$onFeedDeleteResult$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.i;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.y;
import com.tencent.kuikly.core.views.z;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p35.ab;
import p35.n;

/* loaded from: classes31.dex */
public final class NBPArticleFeedDetailPageV2 extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedDetailPageV2.class, "keyboardHeight", "getKeyboardHeight()F", 0)};
    public String closePageNotifyRef;
    public float firstCardHeight;
    public final ReadWriteProperty keyboardHeight$delegate;
    public float listHeight;

    /* renamed from: vm, reason: collision with root package name */
    public final Lazy<NBPArticleFeedDetailVM> f114201vm;

    public NBPArticleFeedDetailPageV2() {
        Lazy<NBPArticleFeedDetailVM> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<NBPArticleFeedDetailVM>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$vm$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NBPArticleFeedDetailVM invoke() {
                return new NBPArticleFeedDetailVM(NBPArticleFeedDetailPageV2.this.getPagerId(), NBPArticleFeedDetailPageV2.this.getPagerData().n().j("nbp_source"));
            }
        });
        this.f114201vm = lazy;
        this.keyboardHeight$delegate = c.a(Float.valueOf(0.0f));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPArticleFeedDetailVM value = this.f114201vm.getValue();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(h.INSTANCE.m());
                        return Unit.INSTANCE;
                    }
                });
                final Lazy<NBPArticleFeedDetailVM> lazy = NBPArticleFeedDetailPageV2.this.f114201vm;
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$NavBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final Lazy<NBPArticleFeedDetailVM> lazy2 = lazy;
                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$NavBar$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPager().getPageData().m(), tVar2.getPager().getPageData().getNavigationBarHeight());
                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_nav_secondary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final Lazy<NBPArticleFeedDetailVM> lazy3 = lazy2;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginTop(tVar2.getPager().getPageData().getStatusBarHeight());
                                                tVar2.m140flex(1.0f);
                                                tVar2.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo153width(55.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.2.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.2.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(25.0f, 25.0f);
                                                                afVar2.marginLeft(-8.0f);
                                                                afVar2.o();
                                                                b.a.b(afVar2, QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default("text_nav_secondary")), false, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final Lazy<NBPArticleFeedDetailVM> lazy4 = lazy3;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo153width(tVar2.getPagerData().m() - 110.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final Lazy<NBPArticleFeedDetailVM> lazy5 = lazy4;
                                                RichTextViewKt.b(vVar6, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.3.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(RichTextView richTextView) {
                                                        final Lazy<NBPArticleFeedDetailVM> lazy6 = lazy5;
                                                        richTextView.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.3.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RichTextAttr richTextAttr) {
                                                                RichTextAttr richTextAttr2 = richTextAttr;
                                                                ce.fontSize$default(richTextAttr2, 17.0f, null, 2, null);
                                                                richTextAttr2.fontWeightMedium();
                                                                richTextAttr2.color(QUIToken.color$default("text_nav_secondary"));
                                                                NBPArticleFeedDetailVM value2 = lazy6.getValue();
                                                                richTextAttr2.text((String) value2.navTitle$delegate.getValue(value2, NBPArticleFeedDetailVM.$$delegatedProperties[6]));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.NavBar.1.1.2.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo153width(43.0f);
                                                        tVar2.allCenter();
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
                }.invoke(viewContainer2);
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM = value;
                final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV2 = NBPArticleFeedDetailPageV2.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = NBPArticleFeedDetailVM.this;
                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                NBPArticleFeedDetailVM.this.listViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.m140flex(1.0f);
                                aoVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV22 = nBPArticleFeedDetailPageV2;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = NBPArticleFeedDetailVM.this;
                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ap apVar) {
                                ap apVar2 = apVar;
                                final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV23 = NBPArticleFeedDetailPageV2.this;
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = nBPArticleFeedDetailVM3;
                                apVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        ScrollParams scrollParams2 = scrollParams;
                                        NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV24 = NBPArticleFeedDetailPageV2.this;
                                        float max = Math.max((nBPArticleFeedDetailPageV24.firstCardHeight + 150.0f) - nBPArticleFeedDetailPageV24.listHeight, 0.0f);
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = nBPArticleFeedDetailVM4;
                                        nBPArticleFeedDetailVM5.getClass();
                                        float max2 = Math.max(max, 10.0f);
                                        if (scrollParams2.getOffsetY() > max2 && nBPArticleFeedDetailVM5.getShowBottomBar()) {
                                            nBPArticleFeedDetailVM5.showBottomBar$delegate.setValue(nBPArticleFeedDetailVM5, NBPArticleFeedDetailVM.$$delegatedProperties[3], Boolean.FALSE);
                                        } else if (scrollParams2.getOffsetY() <= max2 && !nBPArticleFeedDetailVM5.getShowBottomBar()) {
                                            nBPArticleFeedDetailVM5.showBottomBar$delegate.setValue(nBPArticleFeedDetailVM5, NBPArticleFeedDetailVM.$$delegatedProperties[3], Boolean.TRUE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = nBPArticleFeedDetailVM3;
                                apVar2.contentSizeChanged(new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.3.2
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Float f16, Float f17) {
                                        f16.floatValue();
                                        float floatValue = f17.floatValue();
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                        ReadWriteProperty readWriteProperty = nBPArticleFeedDetailVM6.firstScreenHasBack$delegate;
                                        KProperty<?>[] kPropertyArr = NBPArticleFeedDetailVM.$$delegatedProperties;
                                        if (((Boolean) readWriteProperty.getValue(nBPArticleFeedDetailVM6, kPropertyArr[8])).booleanValue()) {
                                            if (nBPArticleFeedDetailVM6.filterContentSizeChanged) {
                                                nBPArticleFeedDetailVM6.filterContentSizeChanged = false;
                                            } else {
                                                float l3 = (nBPArticleFeedDetailVM6.pageData.l() - nBPArticleFeedDetailVM6.pageData.getNavigationBarHeight()) + 70.0f;
                                                if (floatValue - nBPArticleFeedDetailVM6.getBottomContentInsertHeight() < l3) {
                                                    nBPArticleFeedDetailVM6.bottomContentInsertHeight$delegate.setValue(nBPArticleFeedDetailVM6, kPropertyArr[9], Float.valueOf(l3 - (floatValue - nBPArticleFeedDetailVM6.getBottomContentInsertHeight())));
                                                    nBPArticleFeedDetailVM6.filterContentSizeChanged = true;
                                                } else {
                                                    nBPArticleFeedDetailVM6.bottomContentInsertHeight$delegate.setValue(nBPArticleFeedDetailVM6, kPropertyArr[9], Float.valueOf(0.0f));
                                                    nBPArticleFeedDetailVM6.filterContentSizeChanged = true;
                                                }
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV24 = NBPArticleFeedDetailPageV2.this;
                                FrameEventKt.d(apVar2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(d dVar) {
                                        NBPArticleFeedDetailPageV2.this.listHeight = dVar.getHeight();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = NBPArticleFeedDetailVM.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = NBPArticleFeedDetailVM.this;
                                return Integer.valueOf(((Number) nBPArticleFeedDetailVM5.pageState$delegate.getValue(nBPArticleFeedDetailVM5, NBPArticleFeedDetailVM.$$delegatedProperties[5])).intValue());
                            }
                        };
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = NBPArticleFeedDetailVM.this;
                        final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV23 = nBPArticleFeedDetailPageV2;
                        BindDirectivesViewKt.a(aqVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                int intValue = ((Number) nBPArticleFeedDetailVM6.pageState$delegate.getValue(nBPArticleFeedDetailVM6, NBPArticleFeedDetailVM.$$delegatedProperties[5])).intValue();
                                if (intValue == 0) {
                                    w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.mo153width(tVar2.getPagerData().m());
                                                    tVar2.mo141height(tVar2.getPagerData().l() - tVar2.getPagerData().getNavigationBarHeight());
                                                    tVar2.allCenter();
                                                    tVar2.flexDirectionRow();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            i.a(vVar2, new Function1<com.tencent.kuikly.core.views.h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.1.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(com.tencent.kuikly.core.views.h hVar) {
                                                    hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.1.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(f fVar) {
                                                            f fVar2 = fVar;
                                                            fVar2.size(20.0f, 20.0f);
                                                            fVar2.h(!com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode());
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.1.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.1.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginLeft(4.0f);
                                                            ceVar2.text("\u52a0\u8f7d\u4e2d,\u8bf7\u7a0d\u540e...");
                                                            ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                            ceVar2.color(new h(9211020L, 1.0f));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (intValue == 1) {
                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                                    w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.mo153width(tVar2.getPagerData().m());
                                                    tVar2.mo141height(tVar2.getPagerData().l() - tVar2.getPagerData().getNavigationBarHeight());
                                                    tVar2.allCenter();
                                                    tVar2.flexDirectionColumn();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = NBPArticleFeedDetailVM.this;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.2.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = NBPArticleFeedDetailVM.this;
                                                            nBPArticleFeedDetailVM10.getClass();
                                                            KLog.INSTANCE.i("NBPArticleFeedDetailVM", "on reload page");
                                                            nBPArticleFeedDetailVM10.setPageState(0);
                                                            nBPArticleFeedDetailVM10.fetchFirstScreenArticleFeedList();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.2.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.2.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.size(86.0f, 86.0f);
                                                            b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAMAAACahl6sAAAATlBMVEUAAABMTExMTExQUFBMTExMTExISEhLS0tLS0tMTExQUFBAQEBLS0tKSkpLS0tNTU1MTExMTExMTExMTExKSkpJSUlMTExLS0tMTExMTEzb8illAAAAGXRSTlMA3+8gv4AgX5BAEBBwMKCfz2+vUI9QQc4/sIny8wAAB+NJREFUeNrtndty2yAQhlkOAnSWHLvV+79oJ8TxOnXqALuScEf/XWbSKp/2wAILEocOHTp06NChQ4cOHSJKddYMgwaAJUjCqGdnzr4Wr6K6m4ZRLv+U1G7yonDV3mm5xEi7cm2jJr0kSU9KFCdv4KsDjYObrFdKiaBGdf40ufkvg4EriqX+YgsYptOTP6/x03wPPdpSWPwsEcLZRkSoOvUjsvQlBL/VuT5fWX1nFrGragNI0YhkNcgCe6JM8vOFmmQKtAvsjXKGT2N4YpANe6L4q1NIVwmyqhvK1hmsdlcM9CkmlH5TFHsNDocYDCib+5fS19hAp2JC2dYo5w9zgBfsOsFGRsHokEasIrMEvTViZSlAr1pFFayevjDKZStWEhpFruZe+AzoxHpCoxixluo+JefS43Be6UFqRLdaW+2KgaIA3Wp9dYAka3CMldhIFZKswKEbsZnqGUm4OXqxqRyS8HIYsbHMB8nLc9xIXp6DmaQmctBJRp4cE7KHEzspVBMD2zuZxW7STP5gg5c2YjfVoTKy5ECX7xzU8Zw+xkvFEeid2FWdRKcgDa6t2FltmP2SA8SJ3RXe55k4EkIjdleNYZKfwytRgEKYaJJjGVGEQphYgmONohDpd+dqXtyx3lXJ3MylCnKsW6nkRbpCxhIFCfLi3X6k7oJ0yfuLIFTPRUnn+IjliXTvYAkae0WPd6yXCAahbNBxbRU4TMGbGqQekYJlxlpLTKRbGsQtf+mNIwXDlgbBgQh8c7ep5skmSSxURg6D9F9K5xo4TOLSxhJPNAi+jdPXYQDIiSvNrj3LGPL+TIGq8WfiWDInObfnBhEsID4lA9vgBGWCBIdtE37Xlgpi4sNd0UO9ewbSiUxhqHWEFBet+jzI5RnIAv25poW7iR7VLa1T8znIu+YzZfYO0Z7VZLY4BoofQYKgV/m+pSKJdZ4xsH35GUiAJfQz6ci8pfM8y+sbhfPPs5Z3EIFCfdN1Vs5SPVLEpF8/QDZKFXw/auj8lRsbemqixxH7iZLcFglRhYdLr7M83LXNRoOgN4JNL4FdVIiccuaz2qeP7BfI8S8bFSQYIknmkDavRLGQ3iBZxxSOPrFgnLBvNgcEuxhNYpB0EbltTmh8wfeZB4INc1olzZfaiEBqEzs1XUOsfk1im1kbkZB0wpyqkyE6PK2Mx6CXsQ8+RQwRMr7QshJb0YggohqDUWz8kCgjEkIkx4dbcU2sTErIyx/rRh9ZMeKDM0DoJCOmrSfeN8dzWM6pro0n6X90QxO5r94hBxuI8CHofkcWKYYn+xrk4ADBNGh48u8cXWkZ5KCDIImJTjQD1zDSrbEcVMXvwunYdFDoutZtIIEfyzH1P4CEgf1/AOF5mIVnIMC0HLs6iAVcv2q+XdcC+wIgXZiI4xrBY8n6UbKXDmJwpdE9br0NuNJoigZR+u6v9OHVnz8wLnBbDPg8AarKBfESz/Y92Z6uhgUZ6SD848iEE/gfGgYsUNwLp038IBgec/NjCwcaxZQ4sn87Mar6q1XA+dh5VOQs4ldE0ZjNIRPc/iSfkFCKRpx6ZXNAl9bzHkGSPpFFkDbrf8azAIkk58ztt7eIqW6eRSRyJJCY3JYUEzH1yiPpchqsp+xDRqeIdJClivcfEXISruEVL5w2Pf2VUm5XIgzs2GTFpdpoWBbJeCcYDiOp+ZdWDRM21QnZF5e+WNRK5OA50o9Ja4qoYkDwyCwo1lscIGJlteZbR2nx9rAu1O3otAztq0kdHPQTjHJCN2M4TYj1kE7Zjad3y8ru8ZgUXT3Getz+NN3+04Or0bwWhwhPaIci94dperxjQxlXO1RcrBE6wQgdHLyPk7iu/zDTpr+iidIORV+wiUibnA1l8O5b5YJgezVbi3DqekzHMkfQ0aceOqpvYc5IjFJ6ezUhTSbYFTBKaZ71K2EIGFlisn0YECsOl7UpB4A8g289ligDy6nKKqXe1yynhGX7tWisOOqsIe1okmK6tcx2QqhWhx8mllD/neYWrsSJVY+hHp0aZMM91Z146kWbmhuMYLqdlO/m0z65WjNoEiLKpOWygMa+8c0Mghn4TRQmNEhKyilvyRENkn4xQVFCgyRv3VxEQTplXo2iS7y8AkS6fInXiVTZFxMUE+9V/l10tSwp3oFw85ot4pawO8eyxClFAULHylIlS7ooDCpK6i6jUnHBsY7L9IJNCwiTjnrnJYaJEjtKActs3xIvy2G63NYyZXAtdtPMVir11Ouw6Qlr5rHtuOvFxYxDWbX3VdKVEC9OcuN4cRLkYCTZoVjpkYObZN7ykwT6W45iP9rwL6kROZhJtv5sB3Lwk2xWC7d4MptbeJ/A21aftuk5HkS6CoDuVqtneyvXf0YrIz7/VP73spReIsOc7r9rGsXIjeIQzxXBSbDrAkvCMZRiP/dH+DwhwSiIwuizyVFe3pcxayMJtwKTUIARRbkrhv4ttpcFpi8uX0JsEI5Y8qGAVfk+NRIaCvhRFm3rDIoWP9lsGrGr7LggS5JdFFIs2or95e/6NMb+HAVTWwfYpDL/FmWosuOCgnm61E8McW4HWFB6KmADBlWFN4ySenbT+dKpK5JS6mJbN4xyuReYIjbEHvpnliTpqZg947/VeBcHI7XzRXnUd/KT0/IJwzhMXfEQd7Y5GTfrEa5IAKCHwdiuWG86dOjQoUOHDh06dOhl9Aea9iC3qxu2fAAAAABJRU5ErkJggg==", false, 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.2.4
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.2.4.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginTop(24.0f);
                                                            ceVar2.text("\u7f51\u7edc\u5f02\u5e38\uff0c\u70b9\u51fb\u91cd\u8bd5");
                                                            ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                            ceVar2.color(h.INSTANCE.b());
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (intValue == 2) {
                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                    Function0<com.tencent.kuikly.core.reactive.collection.c<NBPArticleFeedModel>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<NBPArticleFeedModel>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.3
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final com.tencent.kuikly.core.reactive.collection.c<NBPArticleFeedModel> invoke() {
                                            return NBPArticleFeedDetailVM.this.getFeedList();
                                        }
                                    };
                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = NBPArticleFeedDetailVM.this;
                                    final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV24 = nBPArticleFeedDetailPageV23;
                                    LoopDirectivesViewKt.a(bindDirectivesView2, function02, new Function2<LoopDirectivesView<NBPArticleFeedModel>, NBPArticleFeedModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(LoopDirectivesView<NBPArticleFeedModel> loopDirectivesView, NBPArticleFeedModel nBPArticleFeedModel) {
                                            LoopDirectivesView<NBPArticleFeedModel> loopDirectivesView2 = loopDirectivesView;
                                            final NBPArticleFeedModel nBPArticleFeedModel2 = nBPArticleFeedModel;
                                            int i3 = nBPArticleFeedModel2.type;
                                            if (i3 == 1) {
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = NBPArticleFeedDetailVM.this;
                                                final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV25 = nBPArticleFeedDetailPageV24;
                                                w.a(loopDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        v vVar2 = vVar;
                                                        final NBPArticleFeedModel nBPArticleFeedModel3 = NBPArticleFeedModel.this;
                                                        ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1.1
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                return Boolean.valueOf(NBPArticleFeedModel.this.getFeedHadDeleted());
                                                            }
                                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                final ConditionView conditionView2 = conditionView;
                                                                conditionView2.addChild(new NBPArticleFeedDeletedView(), new Function1<NBPArticleFeedDeletedView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final /* bridge */ /* synthetic */ Unit invoke(NBPArticleFeedDeletedView nBPArticleFeedDeletedView) {
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1.2.2
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        KLog.INSTANCE.e("NBPArticleFeedDeleted", "did send NBPCloseCommentInputPage");
                                                                        AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((k) ConditionView.this.acquireModule("KRNotifyModule"), "NBPCloseCommentInputPage", false, 4, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                                TimerKt.e(conditionView2.getPagerId(), 600, function03);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPArticleFeedModel nBPArticleFeedModel4 = NBPArticleFeedModel.this;
                                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = nBPArticleFeedDetailVM10;
                                                        final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV26 = nBPArticleFeedDetailPageV25;
                                                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                final NBPArticleFeedModel nBPArticleFeedModel5 = NBPArticleFeedModel.this;
                                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM12 = nBPArticleFeedDetailVM11;
                                                                final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV27 = nBPArticleFeedDetailPageV26;
                                                                conditionView.addChild(new NBPArticleFeedItemView(), new Function1<NBPArticleFeedItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1.3.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(NBPArticleFeedItemView nBPArticleFeedItemView) {
                                                                        NBPArticleFeedItemView nBPArticleFeedItemView2 = nBPArticleFeedItemView;
                                                                        final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                                                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM13 = nBPArticleFeedDetailVM12;
                                                                        nBPArticleFeedItemView2.attr(new Function1<NBPArticleFeedItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1.3.1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(NBPArticleFeedItemViewAttr nBPArticleFeedItemViewAttr) {
                                                                                NBPArticleFeedItemViewAttr nBPArticleFeedItemViewAttr2 = nBPArticleFeedItemViewAttr;
                                                                                nBPArticleFeedItemViewAttr2.feed = NBPArticleFeedModel.this;
                                                                                nBPArticleFeedItemViewAttr2.f114203vm = nBPArticleFeedDetailVM13;
                                                                                nBPArticleFeedItemViewAttr2.mo113backgroundColor(QUIToken.color$default("fill_light_primary"));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPArticleFeedModel nBPArticleFeedModel7 = NBPArticleFeedModel.this;
                                                                        final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV28 = nBPArticleFeedDetailPageV27;
                                                                        nBPArticleFeedItemView2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1.3.1.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(l lVar) {
                                                                                l lVar2 = lVar;
                                                                                if (NBPArticleFeedModel.this.isHeadFeed) {
                                                                                    final NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV29 = nBPArticleFeedDetailPageV28;
                                                                                    FrameEventKt.d(lVar2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.1.3.1.2.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(d dVar) {
                                                                                            NBPArticleFeedDetailPageV2.this.firstCardHeight = dVar.getHeight();
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
                                            } else if (i3 == 2) {
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = NBPArticleFeedDetailVM.this;
                                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return Boolean.valueOf(NBPArticleFeedDetailVM.this.getFeedList().size() > 2);
                                                    }
                                                };
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM12 = NBPArticleFeedDetailVM.this;
                                                ConditionViewKt.c(loopDirectivesView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM13 = NBPArticleFeedDetailVM.this;
                                                        conditionView.addChild(new NBPArticleFeedDetailFooterView(), new Function1<NBPArticleFeedDetailFooterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPArticleFeedDetailFooterView nBPArticleFeedDetailFooterView) {
                                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM14 = NBPArticleFeedDetailVM.this;
                                                                nBPArticleFeedDetailFooterView.attr(new Function1<NBPArticleFeedDetailFooterViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.4.3.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(NBPArticleFeedDetailFooterViewAttr nBPArticleFeedDetailFooterViewAttr) {
                                                                        NBPArticleFeedDetailFooterViewAttr nBPArticleFeedDetailFooterViewAttr2 = nBPArticleFeedDetailFooterViewAttr;
                                                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM15 = NBPArticleFeedDetailVM.this;
                                                                        nBPArticleFeedDetailFooterViewAttr2.text$delegate.setValue(nBPArticleFeedDetailFooterViewAttr2, NBPArticleFeedDetailFooterViewAttr.$$delegatedProperties[0], (String) nBPArticleFeedDetailVM15.headFeedFooterTitle$delegate.getValue(nBPArticleFeedDetailVM15, NBPArticleFeedDetailVM.$$delegatedProperties[7]));
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
                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = NBPArticleFeedDetailVM.this;
                                    Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.5
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = NBPArticleFeedDetailVM.this;
                                            return Boolean.valueOf(((Boolean) nBPArticleFeedDetailVM11.firstScreenHasBack$delegate.getValue(nBPArticleFeedDetailVM11, NBPArticleFeedDetailVM.$$delegatedProperties[8])).booleanValue());
                                        }
                                    };
                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = NBPArticleFeedDetailVM.this;
                                    ConditionViewKt.c(bindDirectivesView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ConditionView conditionView) {
                                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM12 = NBPArticleFeedDetailVM.this;
                                            z.a(conditionView, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(FooterRefreshView footerRefreshView) {
                                                    FooterRefreshView footerRefreshView2 = footerRefreshView;
                                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM13 = NBPArticleFeedDetailVM.this;
                                                    footerRefreshView2.ref(footerRefreshView2, new Function1<aa<FooterRefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(aa<FooterRefreshView> aaVar) {
                                                            NBPArticleFeedDetailVM.this.footerRef = aaVar;
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM14 = NBPArticleFeedDetailVM.this;
                                                    footerRefreshView2.event(new Function1<y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6.1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(y yVar) {
                                                            y yVar2 = yVar;
                                                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM15 = NBPArticleFeedDetailVM.this;
                                                            yVar2.i(new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6.1.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(FooterRefreshState footerRefreshState) {
                                                                    FooterRefreshView b16;
                                                                    FooterRefreshState footerRefreshState2 = footerRefreshState;
                                                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM16 = NBPArticleFeedDetailVM.this;
                                                                    if (nBPArticleFeedDetailVM16.isEnd) {
                                                                        nBPArticleFeedDetailVM16.setFooterText("\u5df2\u52a0\u8f7d\u5168\u90e8\u52a8\u6001");
                                                                        aa<FooterRefreshView> aaVar = nBPArticleFeedDetailVM16.footerRef;
                                                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                            b16.t(FooterRefreshEndState.NONE_MORE_DATA);
                                                                        }
                                                                    } else {
                                                                        int i3 = NBPArticleFeedDetailVM.WhenMappings.$EnumSwitchMapping$0[footerRefreshState2.ordinal()];
                                                                        if (i3 == 1) {
                                                                            nBPArticleFeedDetailVM16.setFooterText("\u4e0a\u62c9\u52a0\u8f7d\u66f4\u591a");
                                                                        } else if (i3 == 2) {
                                                                            nBPArticleFeedDetailVM16.setFooterText("\u52a0\u8f7d\u66f4\u591a\u52a8\u6001...");
                                                                            final Function1<FooterRefreshEndState, Unit> function1 = new Function1<FooterRefreshEndState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$onFooterStateChanged$1

                                                                                /* loaded from: classes31.dex */
                                                                                public /* synthetic */ class WhenMappings {
                                                                                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                                                    static {
                                                                                        int[] iArr = new int[FooterRefreshEndState.values().length];
                                                                                        try {
                                                                                            iArr[FooterRefreshEndState.NONE_MORE_DATA.ordinal()] = 1;
                                                                                        } catch (NoSuchFieldError unused) {
                                                                                        }
                                                                                        try {
                                                                                            iArr[FooterRefreshEndState.FAILURE.ordinal()] = 2;
                                                                                        } catch (NoSuchFieldError unused2) {
                                                                                        }
                                                                                        $EnumSwitchMapping$0 = iArr;
                                                                                    }
                                                                                }

                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(FooterRefreshEndState footerRefreshEndState) {
                                                                                    FooterRefreshView b17;
                                                                                    FooterRefreshEndState footerRefreshEndState2 = footerRefreshEndState;
                                                                                    int i16 = WhenMappings.$EnumSwitchMapping$0[footerRefreshEndState2.ordinal()];
                                                                                    if (i16 == 1) {
                                                                                        NBPArticleFeedDetailVM.this.setFooterText("\u5df2\u52a0\u8f7d\u5168\u90e8\u52a8\u6001");
                                                                                    } else if (i16 == 2) {
                                                                                        NBPArticleFeedDetailVM.this.setFooterText("\u7f51\u7edc\u4e0d\u7ed9\u529b, \u8bf7\u70b9\u51fb\u91cd\u8bd5");
                                                                                    }
                                                                                    aa<FooterRefreshView> aaVar2 = NBPArticleFeedDetailVM.this.footerRef;
                                                                                    if (aaVar2 != null && (b17 = aaVar2.b()) != null) {
                                                                                        b17.t(footerRefreshEndState2);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            StrangerFeedRepo strangerFeedRepo = nBPArticleFeedDetailVM16.repo;
                                                                            if (strangerFeedRepo != null) {
                                                                                String str = nBPArticleFeedDetailVM16.posterUserId;
                                                                                a aVar = nBPArticleFeedDetailVM16.cookie;
                                                                                String str2 = nBPArticleFeedDetailVM16.feedId;
                                                                                CommonProxyService.INSTANCE.request(new StrangerGetFeedListRequest(strangerFeedRepo.appId, str, aVar, str2), new StrangerFeedRepo$fetchFeedList$1(strangerFeedRepo, str, str2, new Function3<ab, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$fetchArticleFeedList$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(ab abVar, Integer num, String str3) {
                                                                                        a aVar2;
                                                                                        FooterRefreshEndState footerRefreshEndState;
                                                                                        ab abVar2 = abVar;
                                                                                        if (num.intValue() == 0) {
                                                                                            if ((abVar2 != null ? abVar2.f425113d : null) != null && (!abVar2.f425113d.isEmpty())) {
                                                                                                NBPArticleFeedDetailVM.this.appendData(abVar2.f425113d);
                                                                                                if (NBPArticleFeedDetailVM.this.getFeedList().size() > 2) {
                                                                                                    NBPArticleFeedDetailVM.this.getFeedList().get(NBPArticleFeedDetailVM.this.getFeedList().size() - 1).setShowDivider(true);
                                                                                                }
                                                                                            }
                                                                                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM17 = NBPArticleFeedDetailVM.this;
                                                                                            if (abVar2 == null || (aVar2 = abVar2.f425115f) == null) {
                                                                                                aVar2 = a.f30290b;
                                                                                            }
                                                                                            nBPArticleFeedDetailVM17.cookie = aVar2;
                                                                                            boolean z16 = abVar2 != null && abVar2.f425114e;
                                                                                            nBPArticleFeedDetailVM17.isEnd = z16;
                                                                                            Function1<FooterRefreshEndState, Unit> function12 = function1;
                                                                                            if (function12 != null) {
                                                                                                if (z16) {
                                                                                                    footerRefreshEndState = FooterRefreshEndState.NONE_MORE_DATA;
                                                                                                } else {
                                                                                                    footerRefreshEndState = FooterRefreshEndState.SUCCESS;
                                                                                                }
                                                                                                function12.invoke(footerRefreshEndState);
                                                                                            }
                                                                                        } else {
                                                                                            Function1<FooterRefreshEndState, Unit> function13 = function1;
                                                                                            if (function13 != null) {
                                                                                                function13.invoke(FooterRefreshEndState.FAILURE);
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }));
                                                                            }
                                                                        } else if (i3 == 3) {
                                                                            nBPArticleFeedDetailVM16.setFooterText("\u5df2\u52a0\u8f7d\u5168\u90e8\u52a8\u6001");
                                                                        } else if (i3 == 4) {
                                                                            nBPArticleFeedDetailVM16.setFooterText("\u7f51\u7edc\u4e0d\u7ed9\u529b, \u8bf7\u70b9\u51fb\u91cd\u8bd5");
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM16 = NBPArticleFeedDetailVM.this;
                                                            yVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6.1.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    aa<FooterRefreshView> aaVar;
                                                                    FooterRefreshView b16;
                                                                    FooterRefreshView b17;
                                                                    NBPArticleFeedDetailVM nBPArticleFeedDetailVM17 = NBPArticleFeedDetailVM.this;
                                                                    aa<FooterRefreshView> aaVar2 = nBPArticleFeedDetailVM17.footerRef;
                                                                    if (((aaVar2 == null || (b17 = aaVar2.b()) == null) ? null : b17.getRefreshState()) == FooterRefreshState.FAILURE && (aaVar = nBPArticleFeedDetailVM17.footerRef) != null && (b16 = aaVar.b()) != null) {
                                                                        b16.p();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM15 = NBPArticleFeedDetailVM.this;
                                                    Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6.1.3
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            return Boolean.valueOf(NBPArticleFeedDetailVM.this.getFeedList().size() > 2);
                                                        }
                                                    };
                                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM16 = NBPArticleFeedDetailVM.this;
                                                    ConditionViewKt.c(footerRefreshView2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6.1.4
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ConditionView conditionView2) {
                                                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM17 = NBPArticleFeedDetailVM.this;
                                                            conditionView2.addChild(new NBPArticleFeedDetailFooterView(), new Function1<NBPArticleFeedDetailFooterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6.1.4.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPArticleFeedDetailFooterView nBPArticleFeedDetailFooterView) {
                                                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM18 = NBPArticleFeedDetailVM.this;
                                                                    nBPArticleFeedDetailFooterView.attr(new Function1<NBPArticleFeedDetailFooterViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.5.6.1.4.1.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(NBPArticleFeedDetailFooterViewAttr nBPArticleFeedDetailFooterViewAttr) {
                                                                            NBPArticleFeedDetailFooterViewAttr nBPArticleFeedDetailFooterViewAttr2 = nBPArticleFeedDetailFooterViewAttr;
                                                                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM19 = NBPArticleFeedDetailVM.this;
                                                                            nBPArticleFeedDetailFooterViewAttr2.text$delegate.setValue(nBPArticleFeedDetailFooterViewAttr2, NBPArticleFeedDetailFooterViewAttr.$$delegatedProperties[0], (String) nBPArticleFeedDetailVM19.footerText$delegate.getValue(nBPArticleFeedDetailVM19, NBPArticleFeedDetailVM.$$delegatedProperties[2]));
                                                                            nBPArticleFeedDetailFooterViewAttr2.marginBottom(NBPArticleFeedDetailVM.this.getBottomContentInsertHeight());
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
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.6
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.2.6.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.mo141height(120.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = value;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean z16 = false;
                        if (NBPArticleFeedDetailVM.this.getHeadFeed() != null) {
                            NBPArticleFeedModel headFeed = NBPArticleFeedDetailVM.this.getHeadFeed();
                            if (!(headFeed != null && headFeed.getFeedHadDeleted())) {
                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = NBPArticleFeedDetailVM.this;
                                if (!((Boolean) nBPArticleFeedDetailVM3.isHeadFeedManualDelete$delegate.getValue(nBPArticleFeedDetailVM3, NBPArticleFeedDetailVM.$$delegatedProperties[14])).booleanValue()) {
                                    z16 = true;
                                }
                            }
                        }
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = value;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = NBPArticleFeedDetailVM.this;
                        conditionView.addChild(new NBPArticleHeadFeedOperationBarView(), new Function1<NBPArticleHeadFeedOperationBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView) {
                                NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView2 = nBPArticleHeadFeedOperationBarView;
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = NBPArticleFeedDetailVM.this;
                                nBPArticleHeadFeedOperationBarView2.attr(new Function1<NBPArticleHeadFeedOperationBarViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPArticleHeadFeedOperationBarViewAttr nBPArticleHeadFeedOperationBarViewAttr) {
                                        NBPArticleHeadFeedOperationBarViewAttr nBPArticleHeadFeedOperationBarViewAttr2 = nBPArticleHeadFeedOperationBarViewAttr;
                                        Attr.absolutePosition$default(nBPArticleHeadFeedOperationBarViewAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                        nBPArticleHeadFeedOperationBarViewAttr2.f114205vm = nBPArticleFeedDetailVM6;
                                        NBPArticleFeedModel headFeed = nBPArticleFeedDetailVM6.getHeadFeed();
                                        Intrinsics.checkNotNull(headFeed);
                                        nBPArticleHeadFeedOperationBarViewAttr2.feedModel = headFeed;
                                        if (NBPArticleFeedDetailVM.this.getShowBottomBar()) {
                                            nBPArticleHeadFeedOperationBarViewAttr2.transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                                        } else {
                                            nBPArticleHeadFeedOperationBarViewAttr2.transform(new com.tencent.kuikly.core.base.y(0.0f, 1.0f, 0.0f, 0.0f, 12, null));
                                        }
                                        nBPArticleHeadFeedOperationBarViewAttr2.animate(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.25f, null, 2, null), Boolean.valueOf(NBPArticleFeedDetailVM.this.getShowBottomBar()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                nBPArticleHeadFeedOperationBarView2.event(new Function1<NBPArticleHeadFeedOperationBarViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPArticleHeadFeedOperationBarViewEvent nBPArticleHeadFeedOperationBarViewEvent) {
                                        NBPArticleHeadFeedOperationBarViewEvent nBPArticleHeadFeedOperationBarViewEvent2 = nBPArticleHeadFeedOperationBarViewEvent;
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                                        nBPArticleHeadFeedOperationBarViewEvent2.onQuickReplySelectHandler = new Function1<QuickCommentItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.4.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QuickCommentItem quickCommentItem) {
                                                NBPFeedCommentsView b16;
                                                QuickCommentItem quickCommentItem2 = quickCommentItem;
                                                if (quickCommentItem2 != null) {
                                                    aa<NBPFeedCommentsView> aaVar = NBPArticleFeedDetailVM.this.topFeedCommentsViewRef;
                                                    if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                        b16.sendQuickComment(quickCommentItem2);
                                                    }
                                                    NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                                    String str = nBPArticleFeedDetailVM8.feedId;
                                                    e eVar = new e();
                                                    eVar.v("nearby_comment_id", quickCommentItem2.f114209id);
                                                    Unit unit = Unit.INSTANCE;
                                                    nBPArticleFeedDetailVM8.dtReportElementClick(str, "em_nearby_quic_comment", eVar);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                        nBPArticleHeadFeedOperationBarViewEvent2.onQuickReplyExposeHandler = new Function1<QuickCommentItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.4.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QuickCommentItem quickCommentItem) {
                                                QuickCommentItem quickCommentItem2 = quickCommentItem;
                                                if (quickCommentItem2 != null) {
                                                    NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = NBPArticleFeedDetailVM.this;
                                                    String str = nBPArticleFeedDetailVM9.feedId;
                                                    e eVar = new e();
                                                    eVar.v("nearby_comment_id", quickCommentItem2.f114209id);
                                                    Unit unit = Unit.INSTANCE;
                                                    nBPArticleFeedDetailVM9.dtReportElementImp(str, "em_nearby_quic_comment", eVar);
                                                }
                                                return Unit.INSTANCE;
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
                int i3 = value.appId;
                String pagerId = viewContainer2.getPagerId();
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = value;
                viewContainer2.addChild(new NBPFeedCommentExtraView(i3, pagerId), new Function1<NBPFeedCommentExtraView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPFeedCommentExtraView nBPFeedCommentExtraView) {
                        NBPFeedCommentExtraView nBPFeedCommentExtraView2 = nBPFeedCommentExtraView;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = NBPArticleFeedDetailVM.this;
                        nBPFeedCommentExtraView2.ref(nBPFeedCommentExtraView2, new Function1<aa<NBPFeedCommentExtraView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPFeedCommentExtraView> aaVar) {
                                NBPArticleFeedDetailVM.this.commentExtraRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = value;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                        return Boolean.valueOf(((Boolean) nBPArticleFeedDetailVM6.showMoreActionSheet$delegate.getValue(nBPArticleFeedDetailVM6, NBPArticleFeedDetailVM.$$delegatedProperties[4])).booleanValue());
                    }
                };
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = value;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                        NBPFeedActionSheetViewKt.NBPFeedActionSheet(conditionView, new Function1<NBPFeedActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.7.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedActionSheetView nBPFeedActionSheetView) {
                                NBPFeedActionSheetView nBPFeedActionSheetView2 = nBPFeedActionSheetView;
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                nBPFeedActionSheetView2.attr(new Function1<NBPFeedActionSheetViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.7.1.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:35:0x0072, code lost:
                                    
                                        if (kotlin.jvm.internal.Intrinsics.areEqual((r3 == null || (r3 = r3.f425194e) == null) ? null : com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt.getUserId(r3, r2.appId), r2.viewerUserId) == false) goto L46;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(NBPFeedActionSheetViewAttr nBPFeedActionSheetViewAttr) {
                                        String str;
                                        boolean z16;
                                        n nVar;
                                        s35.af afVar;
                                        String l3;
                                        s35.af afVar2;
                                        String userId;
                                        NBPFeedActionSheetViewAttr nBPFeedActionSheetViewAttr2 = nBPFeedActionSheetViewAttr;
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = NBPArticleFeedDetailVM.this;
                                        int i16 = nBPArticleFeedDetailVM9.appId;
                                        n nVar2 = nBPArticleFeedDetailVM9.currentSelectFeed;
                                        if (nVar2 == null || (str = nVar2.f425193d) == null) {
                                            str = "";
                                        }
                                        String str2 = nBPArticleFeedDetailVM9.viewerUserId;
                                        String str3 = (nVar2 == null || (afVar2 = nVar2.f425194e) == null || (userId = StrangerUtilsKt.getUserId(afVar2, i16)) == null) ? "" : userId;
                                        n nVar3 = NBPArticleFeedDetailVM.this.currentSelectFeed;
                                        String str4 = (nVar3 == null || (afVar = nVar3.f425194e) == null || (l3 = Long.valueOf(afVar.f433207e).toString()) == null) ? "" : l3;
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = NBPArticleFeedDetailVM.this;
                                        if (nBPArticleFeedDetailVM10.appId == 2 && (nVar = nBPArticleFeedDetailVM10.currentSelectFeed) != null) {
                                            List<String> list = nVar.I;
                                            z16 = true;
                                            if (list != null && (list.isEmpty() ^ true)) {
                                                n nVar4 = nBPArticleFeedDetailVM10.currentSelectFeed;
                                            }
                                        }
                                        z16 = false;
                                        nBPFeedActionSheetViewAttr2.params(i16, str, str2, str3, str4, z16);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = NBPArticleFeedDetailVM.this;
                                nBPFeedActionSheetView2.event(new Function1<NBPFeedActionSheetViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.7.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedActionSheetViewEvent nBPFeedActionSheetViewEvent) {
                                        NBPFeedActionSheetViewEvent nBPFeedActionSheetViewEvent2 = nBPFeedActionSheetViewEvent;
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = NBPArticleFeedDetailVM.this;
                                        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.7.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(String str) {
                                                String str2 = str;
                                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = NBPArticleFeedDetailVM.this;
                                                nBPArticleFeedDetailVM11.getClass();
                                                KLog kLog = KLog.INSTANCE;
                                                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("onFeedDelete: ", str2, kLog, "NBPArticleFeedDetailVM");
                                                NBPArticleFeedModel findFeedModel = nBPArticleFeedDetailVM11.findFeedModel(str2);
                                                if (findFeedModel != null) {
                                                    kLog.i("NBPArticleFeedDetailVM", "onFindFeed: " + str2);
                                                    nBPArticleFeedDetailVM11.getFeedList().remove(findFeedModel);
                                                    if (Intrinsics.areEqual(str2, nBPArticleFeedDetailVM11.feedId)) {
                                                        nBPArticleFeedDetailVM11.isHeadFeedManualDelete$delegate.setValue(nBPArticleFeedDetailVM11, NBPArticleFeedDetailVM.$$delegatedProperties[14], Boolean.TRUE);
                                                    }
                                                }
                                                NBPArticleFeedDetailVM.this.onFeedActionSheetClose();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        nBPFeedActionSheetViewEvent2.getClass();
                                        nBPFeedActionSheetViewEvent2.register("EVENT_DELETE_STATUS_FEED", new NBPFeedActionSheetViewEvent$onFeedDeleteResult$1(function1));
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = NBPArticleFeedDetailVM.this;
                                        nBPFeedActionSheetViewEvent2.closedActionSheet(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2.body.1.7.1.2.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPArticleFeedDetailVM.this.onFeedActionSheetClose();
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
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (r3.onBack() == true) goto L12;
     */
    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceivePagerEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            NBPArticleFeedDetailVM value = this.f114201vm.getValue();
            value.getClass();
            KLog.INSTANCE.i("NBPArticleFeedDetailVM", "onModalModeBackPressed");
            aa<NBPFeedCommentExtraView> aaVar = value.commentExtraRef;
            boolean z16 = (aaVar == null || (r3 = aaVar.b()) == null) ? false : true;
            if (z16) {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
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
        aa<NBPFeedCommentExtraView> aaVar = this.f114201vm.getValue().commentExtraRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel = b16.f114216vm;
        if (nBPFeedCommentExtraViewModel.userInIdentifying) {
            nBPFeedCommentExtraViewModel.userInIdentifying = false;
            nBPFeedCommentExtraViewModel.loadUserIdentity();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        List list;
        super.pageWillDestroy();
        this.f114201vm.getValue().dtReportPageExposure(false);
        NBPArticleFeedDetailVM value = this.f114201vm.getValue();
        value.getClass();
        KLog.INSTANCE.i("NBPArticleFeedDetailVM", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (!value.appearItemIds.isEmpty()) {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            list = CollectionsKt___CollectionsKt.toList(value.appearItemIds);
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(new ReportReadFeedsRequest(4, list), null, new Function1<PbResponse<s25.h>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$reportFeedExport$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(PbResponse<s25.h> pbResponse) {
                    PbResponse<s25.h> pbResponse2 = pbResponse;
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("reportFeedDetailExport code: ");
                    m3.append(pbResponse2.code);
                    m3.append(", msg: ");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "NBPArticleFeedDetailVM");
                    return Unit.INSTANCE;
                }
            }, 6);
        }
        String str = this.closePageNotifyRef;
        if (str != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("JIEBAN_OPEN_MY_PROFILE_EVENT", str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
    
        r6 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r6);
     */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void created() {
        String str;
        Object orNull;
        s35.af afVar;
        String str2;
        super.created();
        final NBPArticleFeedDetailVM value = this.f114201vm.getValue();
        g pageData = getPageData();
        value.getClass();
        KLog kLog = KLog.INSTANCE;
        kLog.i("NBPArticleFeedDetailVM", "nbp article feed detail init");
        value.pageData = pageData;
        QQNearbyModule.Companion companion = QQNearbyModule.Companion;
        Object[] sharePenetratePageData = companion.getInstance().getSharePenetratePageData();
        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("initPageConfigData size: "), sharePenetratePageData != null ? Integer.valueOf(sharePenetratePageData.length) : null, kLog, "NBPArticleFeedDetailVM");
        Object firstOrNull = sharePenetratePageData != null ? ArraysKt___ArraysKt.firstOrNull(sharePenetratePageData) : null;
        byte[] bArr = firstOrNull instanceof byte[] ? (byte[]) firstOrNull : null;
        if (bArr == null || str == null) {
            str = "{}";
        }
        e eVar = new e(str);
        int k3 = eVar.k("app_id", 2);
        value.appId = k3;
        if (k3 == 1) {
            MatchFriendUserSelfData kLUserSelfInfo = companion.getInstance().getKLUserSelfInfo();
            value.viewerUserId = kLUserSelfInfo.userId;
            value.viewerNickName = kLUserSelfInfo.userNickName;
            value.viewerAvatar = kLUserSelfInfo.userAvatar;
            value.viewerConstellation = kLUserSelfInfo.userConstellation;
        } else {
            UserDataManager userDataManager = UserDataManager.INSTANCE;
            value.viewerUserId = String.valueOf(userDataManager.getUserSelfInfo().tid);
            value.viewerNickName = userDataManager.getUserSelfInfo().nickName;
            value.viewerAvatar = userDataManager.getUserSelfInfo().avatarUrl;
        }
        value.feedId = eVar.p("feed_id");
        value.posterUserId = eVar.p("poster_user_id");
        value.updatePosterGenderTitle(eVar.j("poster_gender"));
        value.commentId = eVar.p("comment_id");
        value.commentReplyId = eVar.p("comment_reply_id");
        value.showReplyInput = Intrinsics.areEqual(eVar.p("show_reply_input"), "1");
        value.firstFeedImageUrl = eVar.p("feed_image_url");
        value.hasFollowed = eVar.f("has_followed");
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (defpackage.k.a(cVar)) {
            e m3 = eVar.m("ext");
            if (m3 == null) {
                m3 = new e();
            }
            int j3 = m3.j("width");
            int j16 = m3.j("height");
            kLog.i("NBPArticleFeedDetailVM", "first feed image w: " + j3 + ", h: " + j16);
            if (j3 != 0 && j16 != 0) {
                float dpScaleDensity = PageDataExtKt.getDpScaleDensity(cVar.g().getPageData());
                value.firstFeedImageSize = new Pair<>(Float.valueOf(j3 / dpScaleDensity), Float.valueOf(j16 / dpScaleDensity));
            }
        }
        if (value.hasFollowed) {
            value.setButtonText("\u5df2\u5173\u6ce8");
        }
        if (sharePenetratePageData != null && sharePenetratePageData.length >= 2) {
            orNull = ArraysKt___ArraysKt.getOrNull(sharePenetratePageData, 1);
            byte[] bArr2 = orNull instanceof byte[] ? (byte[]) orNull : null;
            if (bArr2 != null) {
                try {
                    n nVar = (n) c45.i.b(new n(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287), bArr2);
                    NBPArticleFeedModel createHeadFeedModel = value.createHeadFeedModel(nVar, true);
                    if (createHeadFeedModel.appId == 2 && createHeadFeedModel.isHeadFeed) {
                        s35.af afVar2 = nVar.f425194e;
                        if (afVar2 == null || (str2 = afVar2.E) == null) {
                            str2 = "";
                        }
                        createHeadFeedModel.headAvatar = str2;
                    }
                    BDHService bDHService = BDHService.INSTANCE;
                    Object imageUrl = createHeadFeedModel.getImageUrl();
                    n35.v vVar = imageUrl instanceof n35.v ? (n35.v) imageUrl : null;
                    String str3 = value.firstFeedImageUrl;
                    if (vVar != null) {
                        if (!(str3.length() == 0)) {
                            BDHService.cacheMap.put(vVar.f418268e, str3);
                        }
                    }
                    value.headFeed$delegate.setValue(value, NBPArticleFeedDetailVM.$$delegatedProperties[1], createHeadFeedModel);
                    n feed = createHeadFeedModel.getFeed();
                    value.updatePosterGenderTitle((feed == null || (afVar = feed.f425194e) == null) ? 0 : afVar.f433218m);
                    value.getFeedList().add(0, createHeadFeedModel);
                    value.getFeedList().add(1, value.createFeedFooterModel());
                    value.setPageState(2);
                    kLog.i("NBPArticleFeedDetailVM", "show from feed pb");
                } catch (Throwable th5) {
                    KLog.INSTANCE.i("NBPArticleFeedDetailVM", "initHeadFeedModel error: " + th5);
                }
            }
        }
        com.tencent.kuikly.core.manager.c cVar2 = com.tencent.kuikly.core.manager.c.f117352a;
        k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "NearbyFeedLikeStatusChangedEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$registerFeedLikeStatusChangeEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                KLog.INSTANCE.i("NBPArticleFeedDetailVM", "registerLikeEvent received like status changed notify with data: " + eVar3 + ", " + NBPArticleFeedDetailVM.this.hashCode());
                if (eVar3 != null && eVar3.j("extInfo") != NBPArticleFeedDetailVM.this.hashCode()) {
                    String p16 = eVar3.p("feedId");
                    boolean z16 = eVar3.k("isLike", 0) == 1;
                    int k16 = eVar3.k("count", -1);
                    NBPArticleFeedModel findFeedModel = NBPArticleFeedDetailVM.this.findFeedModel(p16);
                    if (findFeedModel != null) {
                        NBPArticleFeedDetailVM.this.updateLikeUI(findFeedModel, z16, k16);
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "onNearbyProFeedCommentCountChange", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$registerFeedCommentCountChangeEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                KLog kLog2 = KLog.INSTANCE;
                AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("registerFeedCommentCountChangeEvent received comment count changed notify with data: ", eVar3, kLog2, "NBPArticleFeedDetailVM");
                if (eVar3 != null) {
                    String p16 = eVar3.p("feedId");
                    int j17 = eVar3.j("commentCount");
                    NBPArticleFeedModel findFeedModel = NBPArticleFeedDetailVM.this.findFeedModel(p16);
                    if (findFeedModel != null) {
                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM = NBPArticleFeedDetailVM.this;
                        kLog2.i("NBPArticleFeedDetailVM", "update comment count: " + j17);
                        nBPArticleFeedDetailVM.getClass();
                        findFeedModel.setCommentCount(j17);
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        k.b((k) cVar2.g().acquireModule("KRNotifyModule"), "NEARBY_HOMEPAGE_FOLLOW_STATUS_CHANGED", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$registerHomepageFollowStatusChangeEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                if (eVar3 != null) {
                    String p16 = eVar3.p("accountId");
                    boolean f16 = eVar3.f("doFollow");
                    KLog.INSTANCE.i("NBPArticleFeedDetailVM", "homepage changed followStatus id:" + p16 + ", doFollow: " + f16);
                    if (Intrinsics.areEqual(p16, NBPArticleFeedDetailVM.this.posterUserId)) {
                        if (f16) {
                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM = NBPArticleFeedDetailVM.this;
                            nBPArticleFeedDetailVM.didClickUnFollowButton$delegate.setValue(nBPArticleFeedDetailVM, NBPArticleFeedDetailVM.$$delegatedProperties[10], Boolean.FALSE);
                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = NBPArticleFeedDetailVM.this;
                            TimerKt.d(1200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$registerHomepageFollowStatusChangeEvent$1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    NBPArticleFeedDetailVM.this.setDidClickFollowButton(true);
                                    return Unit.INSTANCE;
                                }
                            });
                        } else {
                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = NBPArticleFeedDetailVM.this;
                            nBPArticleFeedDetailVM3.didClickUnFollowButton$delegate.setValue(nBPArticleFeedDetailVM3, NBPArticleFeedDetailVM.$$delegatedProperties[10], Boolean.TRUE);
                            NBPArticleFeedDetailVM.this.setDidClickFollowButton(false);
                            NBPArticleFeedDetailVM.this.setButtonText("\u5173\u6ce8");
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        value.repo = new StrangerFeedRepo(value.appId);
        if (QQKuiklyPlatformApi.Companion.getNetworkType() == QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
            KLog.INSTANCE.i("NBPArticleFeedDetailVM", "network not connected");
            if (value.getHeadFeed() == null) {
                value.setPageState(1);
            }
            Utils.INSTANCE.currentBridgeModule().qToast("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5", QToastMode.Warning);
        } else {
            value.fetchFirstScreenArticleFeedList();
            NBPCommentUtils.INSTANCE.loadQuickCommentsData(value.appId, value.feedId, new Function2<List<? extends QuickCommentItem>, List<? extends QuickCommentItem>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailVM$loadQuickCommentsData$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(List<? extends QuickCommentItem> list, List<? extends QuickCommentItem> list2) {
                    NBPArticleFeedDetailVM nBPArticleFeedDetailVM = NBPArticleFeedDetailVM.this;
                    ReadWriteProperty readWriteProperty = nBPArticleFeedDetailVM.quickComments$delegate;
                    KProperty<?>[] kPropertyArr = NBPArticleFeedDetailVM.$$delegatedProperties;
                    readWriteProperty.setValue(nBPArticleFeedDetailVM, kPropertyArr[12], list);
                    NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = NBPArticleFeedDetailVM.this;
                    nBPArticleFeedDetailVM2.aiQuickComments$delegate.setValue(nBPArticleFeedDetailVM2, kPropertyArr[13], list2);
                    return Unit.INSTANCE;
                }
            });
        }
        this.f114201vm.getValue().dtReportPageExposure(true);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQKuiklyPlatformApi.Companion.setEdgePopWidth(NBPArticleFeedDetailPageV2.this.getPageData().m());
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 16, function0);
        if (getPagerData().getIsAndroid()) {
            registerViewCreator("TextView", new com.tencent.kuikly.core.pager.f() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$created$2
                @Override // com.tencent.kuikly.core.pager.f
                public final DeclarativeBaseView<?, ?> createView() {
                    return new QQTextView();
                }
            });
            registerViewCreator("RichTextView", new com.tencent.kuikly.core.pager.f() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$created$3
                @Override // com.tencent.kuikly.core.pager.f
                public final DeclarativeBaseView<?, ?> createView() {
                    return new QQRichTextView();
                }
            });
        }
        k.b((k) acquireModule("KRNotifyModule"), "NBPFeedInputKeyBoardChangeEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$created$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                double h16 = eVar3 != null ? eVar3.h("height") : 0.0d;
                NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV2 = NBPArticleFeedDetailPageV2.this;
                ReadWriteProperty readWriteProperty = nBPArticleFeedDetailPageV2.keyboardHeight$delegate;
                KProperty<?>[] kPropertyArr2 = NBPArticleFeedDetailPageV2.$$delegatedProperties;
                if (!(h16 == ((double) ((Number) readWriteProperty.getValue(nBPArticleFeedDetailPageV2, kPropertyArr2[0])).floatValue()))) {
                    NBPArticleFeedDetailPageV2 nBPArticleFeedDetailPageV22 = NBPArticleFeedDetailPageV2.this;
                    nBPArticleFeedDetailPageV22.keyboardHeight$delegate.setValue(nBPArticleFeedDetailPageV22, kPropertyArr2[0], Float.valueOf((float) h16));
                    if (h16 <= 0.0d && NBPArticleFeedDetailPageV2.this.f114201vm.getValue().restoreOffsetWhenKeyBoardHide != null) {
                        Float f16 = NBPArticleFeedDetailPageV2.this.f114201vm.getValue().restoreOffsetWhenKeyBoardHide;
                        if (f16 != null) {
                            NBPArticleFeedDetailPageV2.this.f114201vm.getValue().scrollToPosition(Math.max(f16.floatValue(), 0.0f));
                        }
                        NBPArticleFeedDetailPageV2.this.f114201vm.getValue().restoreOffsetWhenKeyBoardHide = null;
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        this.closePageNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(this), "JIEBAN_OPEN_MY_PROFILE_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$created$5
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
                return Unit.INSTANCE;
            }
        }, 2, null);
    }
}
