package com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.common.ECNumberHelper;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache.IQPlusTrafficCache;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache.QPlusTrafficCache;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStGetMainPageCommDataRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStImage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStVisitor;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.setting.card.GapBarAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.setting.card.GrayGapBarView;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBar;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBarKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.NavBarAttr;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cl;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.x;
import com.tencent.kuikly.core.views.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPVideoSelectPage extends BasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final float bottomBarHeight = 98.0f;
    public final float tipsBarHeight = 40.0f;
    public final QPVideoSelectViewModel viewModel = new QPVideoSelectViewModel();

    public static final float access$claItemHeight(QPVideoSelectPage qPVideoSelectPage) {
        return (((qPVideoSelectPage.getPagerData().m() - 4) / 3) * 166) / 124;
    }

    public static final float access$claItemWidth(QPVideoSelectPage qPVideoSelectPage) {
        return (qPVideoSelectPage.getPagerData().m() - 4) / 3;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                ASDNavigationBarKt.NavBar(viewContainer2, new Function1<ASDNavigationBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ASDNavigationBar aSDNavigationBar) {
                        aSDNavigationBar.attr(new Function1<NavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NavBarAttr navBarAttr) {
                                NavBarAttr navBarAttr2 = navBarAttr;
                                navBarAttr2.setNavTitle("\u9009\u62e9\u4f5c\u54c1");
                                navBarAttr2.bgColor$delegate.setValue(navBarAttr2, NavBarAttr.$$delegatedProperties[1], SkinColor.INSTANCE.fgColor(navBarAttr2.getPagerId()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPVideoSelectPage qPVideoSelectPage = QPVideoSelectPage.this;
                qPVideoSelectPage.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$createTipsBar$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final QPVideoSelectPage qPVideoSelectPage2 = QPVideoSelectPage.this;
                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$createTipsBar$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final QPVideoSelectPage qPVideoSelectPage3 = QPVideoSelectPage.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createTipsBar.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m(), QPVideoSelectPage.this.tipsBarHeight);
                                        tVar2.paddingLeft(11.0f);
                                        tVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(tVar2.getPagerId()));
                                        tVar2.justifyContentCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createTipsBar.1.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createTipsBar.1.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                h blackTextColor;
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight400();
                                                ceVar2.lineHeight(19.6f);
                                                ceVar2.fontFamily("PingFang SC");
                                                ceVar2.value("\u4ec5\u5c55\u793a\u8fd190\u5929\u5185\u53ef\u63a8\u5e7f\u7684\u516c\u5f00\u4f5c\u54c1");
                                                blackTextColor = SkinColor.INSTANCE.blackTextColor(BridgeManager.f117344a.u());
                                                ceVar2.color(blackTextColor);
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
                final QPVideoSelectPage qPVideoSelectPage2 = QPVideoSelectPage.this;
                qPVideoSelectPage2.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$createVideoList$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final QPVideoSelectPage qPVideoSelectPage3 = QPVideoSelectPage.this;
                        cn.a(viewContainer3, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$createVideoList$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cm cmVar) {
                                cm cmVar2 = cmVar;
                                final QPVideoSelectPage qPVideoSelectPage4 = QPVideoSelectPage.this;
                                cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ck ckVar) {
                                        ck ckVar2 = ckVar;
                                        ckVar2.w(ckVar2.getPagerData().m());
                                        ckVar2.h(3);
                                        ckVar2.u(2.0f);
                                        ckVar2.t(2.0f);
                                        ckVar2.m140flex(1.0f).alignSelfStretch();
                                        ckVar2.positionAbsolute().m138bottom(QPVideoSelectPage.this.bottomBarHeight);
                                        ckVar2.m150top(ckVar2.getPagerData().getNavigationBarHeight() + QPVideoSelectPage.this.tipsBarHeight);
                                        ScrollerAttr.bouncesEnable$default(ckVar2, false, false, 2, null);
                                        ckVar2.showScrollerIndicator(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPVideoSelectPage qPVideoSelectPage5 = QPVideoSelectPage.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(QPVideoSelectPage.this.viewModel.getUiState() == QPlusTrafficUIState.COMPLETED || QPVideoSelectPage.this.viewModel.getFeeds().size() != 0);
                                    }
                                };
                                final QPVideoSelectPage qPVideoSelectPage6 = QPVideoSelectPage.this;
                                ConditionViewKt.c(cmVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final QPVideoSelectPage qPVideoSelectPage7 = QPVideoSelectPage.this;
                                        Function0<c<QPlusTrafficHomeVideoItemModel>> function02 = new Function0<c<QPlusTrafficHomeVideoItemModel>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.3.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final c<QPlusTrafficHomeVideoItemModel> invoke() {
                                                return QPVideoSelectPage.this.viewModel.getFeeds();
                                            }
                                        };
                                        final QPVideoSelectPage qPVideoSelectPage8 = QPVideoSelectPage.this;
                                        LoopDirectivesViewKt.a(conditionView, function02, new Function2<LoopDirectivesView<QPlusTrafficHomeVideoItemModel>, QPlusTrafficHomeVideoItemModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.3.2
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(LoopDirectivesView<QPlusTrafficHomeVideoItemModel> loopDirectivesView, QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel) {
                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel2 = qPlusTrafficHomeVideoItemModel;
                                                final QPVideoSelectPage qPVideoSelectPage9 = QPVideoSelectPage.this;
                                                final QPVideoSelectViewModel qPVideoSelectViewModel = qPVideoSelectPage9.viewModel;
                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$bodyWithVideoContent$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                        final QPVideoSelectPage qPVideoSelectPage10 = QPVideoSelectPage.this;
                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel3 = qPlusTrafficHomeVideoItemModel2;
                                                        final QPVideoSelectViewModel qPVideoSelectViewModel2 = qPVideoSelectViewModel;
                                                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$bodyWithVideoContent$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar) {
                                                                v vVar2 = vVar;
                                                                final QPVideoSelectPage qPVideoSelectPage11 = QPVideoSelectPage.this;
                                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(QPVideoSelectPage.access$claItemWidth(QPVideoSelectPage.this), QPVideoSelectPage.access$claItemHeight(QPVideoSelectPage.this));
                                                                        tVar2.flexDirectionColumn();
                                                                        tVar2.justifyContentFlexStart();
                                                                        tVar2.alignItemsCenter();
                                                                        tVar2.positionRelative();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPVideoSelectPage qPVideoSelectPage12 = QPVideoSelectPage.this;
                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel4 = qPlusTrafficHomeVideoItemModel3;
                                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        final QPVideoSelectPage qPVideoSelectPage13 = QPVideoSelectPage.this;
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel5 = qPlusTrafficHomeVideoItemModel4;
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                String str;
                                                                                af afVar2 = afVar;
                                                                                afVar2.size(QPVideoSelectPage.access$claItemWidth(QPVideoSelectPage.this), QPVideoSelectPage.access$claItemHeight(QPVideoSelectPage.this));
                                                                                QPlusCirStImage qPlusCirStImage = qPlusTrafficHomeVideoItemModel5.info.cover;
                                                                                if (qPlusCirStImage == null || (str = qPlusCirStImage.picUrl) == null) {
                                                                                    str = "";
                                                                                }
                                                                                b.a.b(afVar2, str, false, 2, null);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPVideoSelectPage qPVideoSelectPage13 = QPVideoSelectPage.this;
                                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        final QPVideoSelectPage qPVideoSelectPage14 = QPVideoSelectPage.this;
                                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo153width(QPVideoSelectPage.access$claItemWidth(QPVideoSelectPage.this)).mo141height(32.0f);
                                                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                                                                tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0, 0, 0, 0.0f), 0.0f), new j(new h(0, 0, 0, 1.0f), 1.0f));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel5 = qPlusTrafficHomeVideoItemModel3;
                                                                final QPVideoSelectViewModel qPVideoSelectViewModel3 = qPVideoSelectViewModel2;
                                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.4
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        v vVar4 = vVar3;
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel6 = QPlusTrafficHomeVideoItemModel.this;
                                                                        final QPVideoSelectViewModel qPVideoSelectViewModel4 = qPVideoSelectViewModel3;
                                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.4.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo141height(15.0f);
                                                                                tVar2.alignItemsCenter();
                                                                                tVar2.flexDirectionRow();
                                                                                Attr.absolutePosition$default(tVar2, 0.0f, 5.5f, 6.0f, 0.0f, 1, null);
                                                                                tVar2.m152visibility(QPlusTrafficHomeVideoItemModel.this.info.visitorInfo != null && Intrinsics.areEqual(qPVideoSelectViewModel4.uin, Utils.INSTANCE.currentBridgeModule().getCurrentAccount()));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.4.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.4.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.size(14.0f, 14.0f);
                                                                                        b.a.b(afVar2, "qecommerce_icon_general_play_primary", false, 2, null);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel7 = QPlusTrafficHomeVideoItemModel.this;
                                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.4.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel8 = QPlusTrafficHomeVideoItemModel.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.4.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ce.fontSize$default(ceVar2, 11.0f, null, 2, null).fontWeightBold();
                                                                                        ceVar2.marginLeft(2.0f);
                                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_white_color_text_primary");
                                                                                        QPlusCirStVisitor qPlusCirStVisitor = QPlusTrafficHomeVideoItemModel.this.info.visitorInfo;
                                                                                        ceVar2.text(ECNumberHelper.formatString$default(qPlusCirStVisitor != null ? qPlusCirStVisitor.viewCount : 0, 0, 6));
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel6 = qPlusTrafficHomeVideoItemModel3;
                                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.5
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel7 = QPlusTrafficHomeVideoItemModel.this;
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.5.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.size(24.0f, 24.0f);
                                                                                afVar2.positionAbsolute();
                                                                                afVar2.m149right(6.0f).m150top(6.0f);
                                                                                QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel8 = QPlusTrafficHomeVideoItemModel.this;
                                                                                if (((Boolean) qPlusTrafficHomeVideoItemModel8.isSelect$delegate.getValue(qPlusTrafficHomeVideoItemModel8, QPlusTrafficHomeVideoItemModel.$$delegatedProperties[0])).booleanValue()) {
                                                                                    b.a.b(afVar2, "qecommerce_checkbox_image_selected", false, 2, null);
                                                                                } else {
                                                                                    b.a.b(afVar2, "qecommerce_checkbox_image_normal", false, 2, null);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPVideoSelectPage qPVideoSelectPage14 = QPVideoSelectPage.this;
                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel7 = qPlusTrafficHomeVideoItemModel3;
                                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.6
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final QPVideoSelectPage qPVideoSelectPage15 = QPVideoSelectPage.this;
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel8 = qPlusTrafficHomeVideoItemModel7;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.bodyWithVideoContent.1.1.6.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                QPVideoSelectViewModel qPVideoSelectViewModel4 = QPVideoSelectPage.this.viewModel;
                                                                                QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel9 = qPlusTrafficHomeVideoItemModel8;
                                                                                QPlusTrafficHomeVideoItemModel selectItem = qPVideoSelectViewModel4.getSelectItem();
                                                                                if (selectItem != null) {
                                                                                    selectItem.setSelect(false);
                                                                                }
                                                                                qPlusTrafficHomeVideoItemModel9.setSelect(true);
                                                                                qPVideoSelectViewModel4.selectItem$delegate.setValue(qPVideoSelectViewModel4, QPVideoSelectViewModel.$$delegatedProperties[4], qPlusTrafficHomeVideoItemModel9);
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
                                                }.invoke(loopDirectivesView);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPVideoSelectPage qPVideoSelectPage7 = QPVideoSelectPage.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(QPVideoSelectPage.this.viewModel.getUiState() == QPlusTrafficUIState.LOADING && QPVideoSelectPage.this.viewModel.getFeeds().size() == 0);
                                    }
                                };
                                final QPVideoSelectPage qPVideoSelectPage8 = QPVideoSelectPage.this;
                                ConditionViewKt.b(cmVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        ConditionView conditionView2 = conditionView;
                                        for (int i3 = 0; i3 < 12; i3++) {
                                            final QPVideoSelectPage qPVideoSelectPage9 = QPVideoSelectPage.this;
                                            int i16 = QPVideoSelectPage.$r8$clinit;
                                            qPVideoSelectPage9.getClass();
                                            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$createSkeletonView$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                    final QPVideoSelectPage qPVideoSelectPage10 = QPVideoSelectPage.this;
                                                    w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$createSkeletonView$1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            final QPVideoSelectPage qPVideoSelectPage11 = QPVideoSelectPage.this;
                                                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createSkeletonView.1.1.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(QPVideoSelectPage.access$claItemWidth(QPVideoSelectPage.this), QPVideoSelectPage.access$claItemHeight(QPVideoSelectPage.this));
                                                                    tVar2.mo113backgroundColor(SkinColor.INSTANCE.bgColor(tVar2.getPagerId()));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            }.invoke(conditionView2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPVideoSelectPage qPVideoSelectPage9 = QPVideoSelectPage.this;
                                z.a(cmVar2, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(FooterRefreshView footerRefreshView) {
                                        FooterRefreshView footerRefreshView2 = footerRefreshView;
                                        final QPVideoSelectPage qPVideoSelectPage10 = QPVideoSelectPage.this;
                                        footerRefreshView2.attr(new Function1<x, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.6.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(x xVar) {
                                                x xVar2 = xVar;
                                                if (!QPVideoSelectPage.this.viewModel.isFinish() && QPVideoSelectPage.this.viewModel.getUiState() != QPlusTrafficUIState.LOADING) {
                                                    xVar2.size(0.0f, 0.0f);
                                                } else {
                                                    xVar2.size(xVar2.getPagerData().m(), 20.0f);
                                                }
                                                xVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPVideoSelectPage qPVideoSelectPage11 = QPVideoSelectPage.this;
                                        cg.a(footerRefreshView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.6.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final QPVideoSelectPage qPVideoSelectPage12 = QPVideoSelectPage.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.6.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.color(new h("qecommerce_skin_color_text_secondary"));
                                                        if (QPVideoSelectPage.this.viewModel.isFinish()) {
                                                            str = "\u6ca1\u6709\u66f4\u591a\u4e86...";
                                                        } else if (QPVideoSelectPage.this.viewModel.getUiState() == QPlusTrafficUIState.LOADING) {
                                                            str = "\u52a0\u8f7d\u4e2d...";
                                                        } else {
                                                            str = "";
                                                        }
                                                        ceVar2.text(str);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPVideoSelectPage qPVideoSelectPage10 = QPVideoSelectPage.this;
                                cmVar2.event(new Function1<cl, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.7
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cl clVar) {
                                        final QPVideoSelectPage qPVideoSelectPage11 = QPVideoSelectPage.this;
                                        clVar.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createVideoList.1.1.7.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                ScrollParams scrollParams2 = scrollParams;
                                                if ((scrollParams2.getContentHeight() - scrollParams2.getOffsetY()) - QPVideoSelectPage.this.getPageData().l() < QPVideoSelectPage.this.getPageData().l()) {
                                                    QPVideoSelectPage.this.viewModel.loadMore();
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
                }.invoke(viewContainer2);
                final QPVideoSelectPage qPVideoSelectPage3 = QPVideoSelectPage.this;
                qPVideoSelectPage3.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$createBottomBar$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final QPVideoSelectPage qPVideoSelectPage4 = QPVideoSelectPage.this;
                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage$createBottomBar$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final QPVideoSelectPage qPVideoSelectPage5 = QPVideoSelectPage.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createBottomBar.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m(), QPVideoSelectPage.this.bottomBarHeight);
                                        tVar2.positionAbsolute().m138bottom(0.0f);
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.addChild(new GrayGapBarView(), new Function1<GrayGapBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createBottomBar.1.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GrayGapBarView grayGapBarView) {
                                        grayGapBarView.attr(new Function1<GapBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createBottomBar.1.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GapBarAttr gapBarAttr) {
                                                gapBarAttr.height = 1.0f;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPVideoSelectPage qPVideoSelectPage6 = QPVideoSelectPage.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createBottomBar.1.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final QPVideoSelectPage qPVideoSelectPage7 = QPVideoSelectPage.this;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createBottomBar.1.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                h hVar;
                                                h hVar2;
                                                t tVar2 = tVar;
                                                tVar2.size(188.0f, 40.0f);
                                                c.a.a(tVar2, 16.5f, 0.0f, 41.5f, 0.0f, 10, null);
                                                tVar2.allCenter();
                                                tVar2.justifyContentCenter();
                                                tVar2.alignSelfCenter();
                                                tVar2.borderRadius(4.0f);
                                                if (QPVideoSelectPage.this.viewModel.getSelectItem() != null) {
                                                    Direction direction = Direction.TO_RIGHT;
                                                    hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient01_normal", false);
                                                    hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient02_normal", false);
                                                    tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                                } else {
                                                    tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_skin_color_btn_gradient01_disable"), 0.0f), new j(new h("qecommerce_skin_color_btn_gradient02_disable"), 1.0f));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createBottomBar.1.1.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createBottomBar.1.1.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                        ceVar2.fontWeight600();
                                                        ceVar2.lineHeight(22.4f);
                                                        ceVar2.fontFamily("PingFang SC");
                                                        ceVar2.text("\u786e\u5b9a");
                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_color_bg_default");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPVideoSelectPage qPVideoSelectPage8 = QPVideoSelectPage.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createBottomBar.1.1.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final QPVideoSelectPage qPVideoSelectPage9 = QPVideoSelectPage.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage.createBottomBar.1.1.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        QPVideoSelectViewModel qPVideoSelectViewModel = QPVideoSelectPage.this.viewModel;
                                                        qPVideoSelectViewModel.getClass();
                                                        Utils utils = Utils.INSTANCE;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QPVideoSelectViewModel [handleConfirmSelect] selectItem is null ");
                                                        m3.append(qPVideoSelectViewModel.getSelectItem() == null);
                                                        utils.logToNative(m3.toString());
                                                        QPlusTrafficHomeVideoItemModel selectItem = qPVideoSelectViewModel.getSelectItem();
                                                        if (selectItem != null) {
                                                            IPagerIdKtxKt.callbackResult(com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()), selectItem.info.encode());
                                                            BridgeModule.closePage$default(utils.currentBridgeModule(), null, null, 3);
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
                }.invoke(viewContainer2);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.viewModel.uin = getPageData().n().p("target_uin");
        final QPVideoSelectViewModel qPVideoSelectViewModel = this.viewModel;
        qPVideoSelectViewModel.setUiState(QPlusTrafficUIState.LOADING);
        String str = qPVideoSelectViewModel.uin;
        if (str.length() == 0) {
            str = Utils.INSTANCE.currentBridgeModule().getCurrentAccount();
        }
        QPlusCirFeedRepository qPlusCirFeedRepository = QPlusCirFeedRepository.INSTANCE;
        qPVideoSelectViewModel.handleReqSuccess((QPlusCirStGetMainPageCommDataRsp) IQPlusTrafficCache.DefaultImpls.getCache$default((QPlusTrafficCache) QPlusCirFeedRepository.videoCache$delegate.getValue(), str, false, 2, null), true);
        qPlusCirFeedRepository.reqCirFeedList(str, qPVideoSelectViewModel.feedAttachInfo, new Function1<QPlusCirStGetMainPageCommDataRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectViewModel$reqData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp) {
                QPVideoSelectViewModel.this.handleReqSuccess(qPlusCirStGetMainPageCommDataRsp, false);
                QPVideoSelectViewModel.this.loadMore();
                return Unit.INSTANCE;
            }
        }, new QPVideoSelectViewModel$handleReqFailure$1(qPVideoSelectViewModel));
    }
}
