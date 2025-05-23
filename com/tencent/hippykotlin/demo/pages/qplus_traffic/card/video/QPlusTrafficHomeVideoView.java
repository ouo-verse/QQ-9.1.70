package com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.model.KTVAlertInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoListViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.IQPlusTrafficSkeletonItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonGroupItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonGroupRepeatItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonViewAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonViewKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.QPlusTrafficHomeCardAttr;
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
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeVideoView extends QPlusTrafficHomeCardView {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPlusTrafficCardHomeViewModel viewModel = ((QPlusTrafficHomeCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel");
        final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel = (QPlusTrafficHomeVideoViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.flexDirection(FlexDirection.COLUMN);
                        mVar2.justifyContent(FlexJustifyContent.FLEX_START);
                        mVar2.mo153width(mVar2.getPagerData().m());
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel2 = QPlusTrafficHomeVideoViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel3 = QPlusTrafficHomeVideoViewModel.this;
                        return Boolean.valueOf(((QPlusTrafficUIState) qPlusTrafficHomeVideoViewModel3.uiState$delegate.getValue(qPlusTrafficHomeVideoViewModel3, QPlusTrafficHomeVideoViewModel.$$delegatedProperties[0])) == QPlusTrafficUIState.COMPLETED);
                    }
                };
                final QPlusTrafficHomeVideoView qPlusTrafficHomeVideoView = this;
                final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel3 = QPlusTrafficHomeVideoViewModel.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        Function1 function1;
                        ConditionView conditionView2 = conditionView;
                        QPlusTrafficHomeVideoView qPlusTrafficHomeVideoView2 = QPlusTrafficHomeVideoView.this;
                        final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel4 = qPlusTrafficHomeVideoViewModel3;
                        int i3 = QPlusTrafficHomeVideoView.$r8$clinit;
                        qPlusTrafficHomeVideoView2.getClass();
                        if (!qPlusTrafficHomeVideoViewModel4.showTitle) {
                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithTopView$1
                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithTopView$2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel5 = QPlusTrafficHomeVideoViewModel.this;
                                    w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithTopView$2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirection(FlexDirection.ROW);
                                                    tVar2.justifyContent(FlexJustifyContent.SPACE_BETWEEN);
                                                    tVar2.marginRight(20.0f).marginLeft(16.0f).marginTop(16.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel6 = QPlusTrafficHomeVideoViewModel.this;
                                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            tVar.flexDirectionRow().alignItemsCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.2.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.2.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    h hVar;
                                                                    ce ceVar2 = ceVar;
                                                                    ce.fontSize$default(ceVar2, 15.0f, null, 2, null).fontWeightBold();
                                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                    ceVar2.color(hVar);
                                                                    ceVar2.text("\u9009\u62e9\u8981\u63a8\u5e7f\u7684\u4f5c\u54c1");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel7 = QPlusTrafficHomeVideoViewModel.this;
                                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.2.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            ImageView imageView2 = imageView;
                                                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.2.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.marginLeft(2.5f).mo153width(15.0f).mo141height(15.0f);
                                                                    b.a.b(afVar2, "qecommerce_skin_icon_general_question_secondary", false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel8 = QPlusTrafficHomeVideoViewModel.this;
                                                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.2.3.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageEvent imageEvent) {
                                                                    final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel9 = QPlusTrafficHomeVideoViewModel.this;
                                                                    imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.2.3.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            QPlusTrafficHomeVideoViewModel.this.getClass();
                                                                            Utils.INSTANCE.currentBridgeModule().showAlert(new KTVAlertInfo("\u4f5c\u54c1\u63a8\u5e7f\u89c4\u5219", "\u4ec5\u9650\u53d1\u5e03\u65f6\u95f4\u572890\u5929\u4e4b\u5185\u7684\u516c\u5f00\u4f5c\u54c1\u53ef\u4f7f\u7528\u4f5c\u54c1\u63a8\u5e7f\u529f\u80fd", 14.0f, 2), null, "\u6211\u77e5\u9053\u4e86", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel$handlePromptAction$1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final /* bridge */ /* synthetic */ Unit invoke(e eVar) {
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
                                            final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel7 = QPlusTrafficHomeVideoViewModel.this;
                                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            tVar.flexDirectionRow().alignItemsCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel8 = QPlusTrafficHomeVideoViewModel.this;
                                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel9 = QPlusTrafficHomeVideoViewModel.this;
                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    QPlusTrafficHomeVideoViewModel.this.getClass();
                                                                    BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), "mqqapi://kuikly/open?target=52&page_name=qplus_traffic_promote_others&source_from=2&src_type=internal&version=1&bundle_name=new_qecommerce", false, null, null, 30);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.3.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.3.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    h hVar;
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.fontFamily("PingFang SC");
                                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                    ceVar2.color(hVar);
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                    ceVar2.text("\u5e2e\u4ed6\u4eba\u63a8\u5e7f");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.3.4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithTopView.2.1.3.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.size(16.0f, 16.0f);
                                                                    b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_secondary", false, 2, null);
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
                        function1.invoke(conditionView2);
                        if (!qPlusTrafficHomeVideoViewModel3.getListViewModel().getFeeds().isEmpty()) {
                            final QPlusTrafficHomeVideoView qPlusTrafficHomeVideoView3 = QPlusTrafficHomeVideoView.this;
                            final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel5 = qPlusTrafficHomeVideoViewModel3;
                            qPlusTrafficHomeVideoView3.getClass();
                            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithVideoContent$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    Function1 function12;
                                    ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                    QPlusTrafficHomeVideoViewModel.this.getListViewModel().getClass();
                                    QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList = new QPlusTrafficHomeVideoList();
                                    final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel6 = QPlusTrafficHomeVideoViewModel.this;
                                    viewContainer4.addChild(qPlusTrafficHomeVideoList, new Function1<QPlusTrafficHomeCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithVideoContent$1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QPlusTrafficHomeCardView qPlusTrafficHomeCardView) {
                                            final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel7 = QPlusTrafficHomeVideoViewModel.this;
                                            qPlusTrafficHomeCardView.attr(new Function1<QPlusTrafficHomeCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithVideoContent.1.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QPlusTrafficHomeCardAttr qPlusTrafficHomeCardAttr) {
                                                    qPlusTrafficHomeCardAttr.viewModel = QPlusTrafficHomeVideoViewModel.this.getListViewModel();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    QPlusTrafficHomeVideoView qPlusTrafficHomeVideoView4 = qPlusTrafficHomeVideoView3;
                                    final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel7 = QPlusTrafficHomeVideoViewModel.this;
                                    qPlusTrafficHomeVideoView4.getClass();
                                    if (!qPlusTrafficHomeVideoViewModel7.showBottom) {
                                        function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithBottomView$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer5) {
                                                return Unit.INSTANCE;
                                            }
                                        };
                                    } else {
                                        function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithBottomView$2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer5) {
                                                final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel8 = QPlusTrafficHomeVideoViewModel.this;
                                                w.a(viewContainer5, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithBottomView$2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        v vVar2 = vVar;
                                                        final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel9 = QPlusTrafficHomeVideoViewModel.this;
                                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithBottomView.2.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                h hVar;
                                                                h hVar2;
                                                                String str;
                                                                t tVar2 = tVar;
                                                                tVar2.mo141height(40.0f);
                                                                tVar2.allCenter();
                                                                c.a.a(tVar2, 12.0f, 16.0f, 0.0f, 16.0f, 4, null);
                                                                if (QPlusTrafficHomeVideoViewModel.this.getListViewModel().getSelectItem() != null) {
                                                                    QPlusTrafficHomeVideoListViewModel listViewModel = QPlusTrafficHomeVideoViewModel.this.getListViewModel();
                                                                    listViewModel.getClass();
                                                                    e eVar = new e();
                                                                    if (!Intrinsics.areEqual(listViewModel.getSelectItem().info.feedId, "live_feed_id")) {
                                                                        eVar.v("xsj_feed_id", listViewModel.getSelectItem().info.feedId);
                                                                    } else if (listViewModel.getSelectItem().isLiveItem()) {
                                                                        eVar.u(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_ROOM_ID, listViewModel.getSelectItem().live.roomId);
                                                                    }
                                                                    if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                        str = "00000QG6YX3H5PLX";
                                                                    } else {
                                                                        str = "00000QG6YX3X0LZH";
                                                                    }
                                                                    eVar.v(DTParamKey.REPORT_KEY_APPKEY, str);
                                                                    EcommerceExtKt.elementVR(tVar2, "em_xsj_popularize_button", eVar);
                                                                }
                                                                Direction direction = Direction.TO_RIGHT;
                                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient01_normal", false);
                                                                hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient02_normal", false);
                                                                tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                                                tVar2.borderRadius(4.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel10 = QPlusTrafficHomeVideoViewModel.this;
                                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithBottomView.2.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel11 = QPlusTrafficHomeVideoViewModel.this;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithBottomView.2.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        e eVar;
                                                                        QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel12 = QPlusTrafficHomeVideoViewModel.this;
                                                                        qPlusTrafficHomeVideoViewModel12.getClass();
                                                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                                        currentBridgeModule.getClass();
                                                                        String syncToNativeMethod = currentBridgeModule.syncToNativeMethod("getUserInfo", new e(), (Function1<? super e, Unit>) null);
                                                                        try {
                                                                            eVar = new e(syncToNativeMethod);
                                                                        } catch (Throwable unused) {
                                                                            KLog.INSTANCE.e("BridgeModule", "parseUserInfoError, error string: " + syncToNativeMethod);
                                                                            eVar = new e();
                                                                        }
                                                                        eVar.n("uin");
                                                                        String q16 = eVar.q("nickName", "");
                                                                        eVar.q("headUrl", "");
                                                                        Utils utils = Utils.INSTANCE;
                                                                        utils.currentBridgeModule().urlEncode(q16);
                                                                        BridgeModule currentBridgeModule2 = utils.currentBridgeModule();
                                                                        String m3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?target=52&page_name=qplus_promotion_setting&source_from=2&single_mode=1&feed_id="), qPlusTrafficHomeVideoViewModel12.getListViewModel().getSelectItem().info.feedId, "&src_type=internal&version=1&bundle_name=new_qecommerce");
                                                                        e eVar2 = new e();
                                                                        if (qPlusTrafficHomeVideoViewModel12.getListViewModel().getSelectItem().info.feedId.length() > 0) {
                                                                            eVar2.v(QCircleScheme.AttrDetail.FEED_INFO, qPlusTrafficHomeVideoViewModel12.getListViewModel().getSelectItem().info.encode());
                                                                        }
                                                                        Unit unit = Unit.INSTANCE;
                                                                        BridgeModule.openPage$default(currentBridgeModule2, m3, false, eVar2, null, 26);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithBottomView.2.1.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithBottomView.2.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_color_bg_default", false);
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null).fontWeightBold();
                                                                        ceVar2.text("\u53bb\u63a8\u5e7f");
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
                                    function12.invoke(viewContainer4);
                                    return Unit.INSTANCE;
                                }
                            }.invoke(conditionView2);
                        } else {
                            QPlusTrafficHomeVideoView qPlusTrafficHomeVideoView4 = QPlusTrafficHomeVideoView.this;
                            final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel6 = qPlusTrafficHomeVideoViewModel3;
                            qPlusTrafficHomeVideoView4.getClass();
                            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithEmptyContent$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel7 = QPlusTrafficHomeVideoViewModel.this;
                                    w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithEmptyContent$1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    h hVar;
                                                    t tVar2 = tVar;
                                                    tVar2.alignItemsCenter();
                                                    hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                                    tVar2.mo113backgroundColor(hVar);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.size(FloatExtKt.getTo375(176.0f), FloatExtKt.getTo812(132.0f));
                                                            ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_skin_emptystate_img_dongtai");
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            h hVar;
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginTop(16.0f);
                                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                            ceVar2.color(hVar);
                                                            ce.fontSize$default(ceVar2, 17.0f, null, 2, null).fontWeightBold();
                                                            ceVar2.text("\u6682\u65e0\u53ef\u63a8\u5e7f\u7684\u4f5c\u54c1");
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.4
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.4.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            h hVar;
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginTop(7.0f);
                                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                            ceVar2.color(hVar);
                                                            ce.fontSize$default(ceVar2, 14.0f, null, 2, null).fontWeight400();
                                                            ceVar2.fontFamily("PingFang SC");
                                                            ceVar2.text("\u53d1\u5e03\u4f5c\u54c1\uff0c\u8ba9\u66f4\u591a\u540c\u597d\u627e\u5230\u4f60\uff5e");
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel8 = QPlusTrafficHomeVideoViewModel.this;
                                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.5
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel9 = QPlusTrafficHomeVideoViewModel.this;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.5.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.allCenter();
                                                            tVar2.marginTop(16.0f);
                                                            tVar2.size(116.0f, 29.0f);
                                                            tVar2.borderRadius(4.0f);
                                                            tVar2.m152visibility(QPlusTrafficHomeVideoViewModel.this.showBottom);
                                                            GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_btn_primary_red_normal", false, 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel10 = QPlusTrafficHomeVideoViewModel.this;
                                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.5.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel11 = QPlusTrafficHomeVideoViewModel.this;
                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.5.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    QPlusTrafficHomeVideoViewModel.this.getClass();
                                                                    BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), "mqqapi://qcircle/openqqpublish", false, null, null, 30);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.5.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithEmptyContent.1.1.5.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    h hVar;
                                                                    ce ceVar2 = ceVar;
                                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_color_bg_default", false);
                                                                    ceVar2.color(hVar);
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null).fontWeight400();
                                                                    ceVar2.fontFamily("PingFang SC");
                                                                    ceVar2.text("\u7acb\u5373\u53d1\u8868\u4f5c\u54c1");
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
                            }.invoke(conditionView2);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel4 = QPlusTrafficHomeVideoViewModel.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel5 = QPlusTrafficHomeVideoViewModel.this;
                        return Boolean.valueOf(((QPlusTrafficUIState) qPlusTrafficHomeVideoViewModel5.uiState$delegate.getValue(qPlusTrafficHomeVideoViewModel5, QPlusTrafficHomeVideoViewModel.$$delegatedProperties[0])) == QPlusTrafficUIState.LOADING);
                    }
                };
                final QPlusTrafficHomeVideoView qPlusTrafficHomeVideoView2 = this;
                final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel5 = QPlusTrafficHomeVideoViewModel.this;
                ConditionViewKt.b(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$body$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        QPlusTrafficHomeVideoView qPlusTrafficHomeVideoView3 = QPlusTrafficHomeVideoView.this;
                        final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel6 = qPlusTrafficHomeVideoViewModel5;
                        int i3 = QPlusTrafficHomeVideoView.$r8$clinit;
                        qPlusTrafficHomeVideoView3.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithSkeletonView$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                if (QPlusTrafficHomeVideoViewModel.this.showTitle) {
                                    QPlusTrafficSkeletonViewKt.SkeletonView(viewContainer4, new Function1<QPlusTrafficSkeletonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithSkeletonView$1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QPlusTrafficSkeletonView qPlusTrafficSkeletonView) {
                                            qPlusTrafficSkeletonView.attr(new Function1<QPlusTrafficSkeletonViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithSkeletonView.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QPlusTrafficSkeletonViewAttr qPlusTrafficSkeletonViewAttr) {
                                                    ArrayList arrayListOf;
                                                    ArrayList<IQPlusTrafficSkeletonItemData> arrayListOf2;
                                                    FlexJustifyContent flexJustifyContent = FlexJustifyContent.SPACE_BETWEEN;
                                                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonItemData(120.0f, 20.0f, 16.0f, 0.0f, 0.0f, 0.0f, 56), new QPlusTrafficSkeletonItemData(84.0f, 20.0f, 0.0f, 16.0f, 0.0f, 0.0f, 52));
                                                    arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonGroupItemData(arrayListOf, null, flexJustifyContent, 62));
                                                    qPlusTrafficSkeletonViewAttr.viewData = arrayListOf2;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                QPlusTrafficSkeletonViewKt.SkeletonView(viewContainer4, new Function1<QPlusTrafficSkeletonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithSkeletonView$1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPlusTrafficSkeletonView qPlusTrafficSkeletonView) {
                                        qPlusTrafficSkeletonView.attr(new Function1<QPlusTrafficSkeletonViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithSkeletonView.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QPlusTrafficSkeletonViewAttr qPlusTrafficSkeletonViewAttr) {
                                                ArrayList<IQPlusTrafficSkeletonItemData> arrayListOf;
                                                QPlusTrafficSkeletonViewAttr qPlusTrafficSkeletonViewAttr2 = qPlusTrafficSkeletonViewAttr;
                                                qPlusTrafficSkeletonViewAttr2.marginLeft(8.0f);
                                                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonGroupRepeatItemData(new QPlusTrafficSkeletonItemData(156.0f, 252.0f, 8.0f, 0.0f, 16.0f, 0.0f, 40), 3, 0.0f, null, null, 252));
                                                qPlusTrafficSkeletonViewAttr2.viewData = arrayListOf;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (QPlusTrafficHomeVideoViewModel.this.showBottom) {
                                    QPlusTrafficSkeletonViewKt.SkeletonView(viewContainer4, new Function1<QPlusTrafficSkeletonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView$bodyWithSkeletonView$1.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QPlusTrafficSkeletonView qPlusTrafficSkeletonView) {
                                            qPlusTrafficSkeletonView.attr(new Function1<QPlusTrafficSkeletonViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView.bodyWithSkeletonView.1.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QPlusTrafficSkeletonViewAttr qPlusTrafficSkeletonViewAttr) {
                                                    ArrayList<IQPlusTrafficSkeletonItemData> arrayListOf;
                                                    QPlusTrafficSkeletonViewAttr qPlusTrafficSkeletonViewAttr2 = qPlusTrafficSkeletonViewAttr;
                                                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonItemData(qPlusTrafficSkeletonViewAttr2.getPagerData().m() - 32.0f, 40.0f, 16.0f, 0.0f, 16.0f, 0.0f, 40));
                                                    qPlusTrafficSkeletonViewAttr2.viewData = arrayListOf;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        }.invoke(conditionView);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
