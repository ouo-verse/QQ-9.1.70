package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.common.ECNumberHelper;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.Cir_main_page_extensionKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStFeed;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStImage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStVisitor;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.QPlusTrafficHomeCardAttr;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.layout.FlexPositionType;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeVideoList extends QPlusTrafficHomeCardView {
    public static final /* synthetic */ int $r8$clinit = 0;
    public aa<aq<?, ?>> listRef;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPlusTrafficCardHomeViewModel viewModel = ((QPlusTrafficHomeCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoListViewModel");
        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel = (QPlusTrafficHomeVideoListViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList = QPlusTrafficHomeVideoList.this;
                final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel2 = qPlusTrafficHomeVideoListViewModel;
                ar.a(viewContainer, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList2 = QPlusTrafficHomeVideoList.this;
                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                QPlusTrafficHomeVideoList.this.listRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel3 = qPlusTrafficHomeVideoListViewModel2;
                        final QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList3 = QPlusTrafficHomeVideoList.this;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                aa<aq<?, ?>> aaVar;
                                aq<?, ?> b16;
                                ao aoVar2 = aoVar;
                                aoVar2.mo153width(aoVar2.getPagerData().m()).mo141height(FloatExtKt.getTo812(208.0f) + 40.0f + 8.0f);
                                aoVar2.flexDirectionRow();
                                aoVar2.showScrollerIndicator(false);
                                aoVar2.marginTop(16.0f);
                                QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel4 = QPlusTrafficHomeVideoListViewModel.this;
                                if (((Number) qPlusTrafficHomeVideoListViewModel4.scrollTopRefresh$delegate.getValue(qPlusTrafficHomeVideoListViewModel4, QPlusTrafficHomeVideoListViewModel.$$delegatedProperties[0])).intValue() > 0 && (aaVar = qPlusTrafficHomeVideoList3.listRef) != null && (b16 = aaVar.b()) != null) {
                                    ScrollerView.setContentOffset$default(b16, 0.0f, 0.0f, true, null, 8, null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.mo153width(12.0f).mo141height(258.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel4 = qPlusTrafficHomeVideoListViewModel2;
                        Function0<c<QPlusTrafficHomeVideoItemModel>> function0 = new Function0<c<QPlusTrafficHomeVideoItemModel>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<QPlusTrafficHomeVideoItemModel> invoke() {
                                return QPlusTrafficHomeVideoListViewModel.this.getFeeds();
                            }
                        };
                        final QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList4 = QPlusTrafficHomeVideoList.this;
                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel5 = qPlusTrafficHomeVideoListViewModel2;
                        LoopDirectivesViewKt.a(aqVar2, function0, new Function2<LoopDirectivesView<QPlusTrafficHomeVideoItemModel>, QPlusTrafficHomeVideoItemModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<QPlusTrafficHomeVideoItemModel> loopDirectivesView, QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel) {
                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel2 = qPlusTrafficHomeVideoItemModel;
                                final QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList5 = QPlusTrafficHomeVideoList.this;
                                final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel6 = qPlusTrafficHomeVideoListViewModel5;
                                int i3 = QPlusTrafficHomeVideoList.$r8$clinit;
                                qPlusTrafficHomeVideoList5.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList$bodyWithVideoItem$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        final QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList6 = QPlusTrafficHomeVideoList.this;
                                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel7 = qPlusTrafficHomeVideoListViewModel6;
                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel3 = qPlusTrafficHomeVideoItemModel2;
                                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList$bodyWithVideoItem$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoItem.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirection(FlexDirection.COLUMN);
                                                        tVar2.borderRadius(4.0f, 4.0f, 4.0f, 4.0f);
                                                        tVar2.marginLeft(4.0f).marginRight(4.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList7 = QPlusTrafficHomeVideoList.this;
                                                final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel8 = qPlusTrafficHomeVideoListViewModel7;
                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel4 = qPlusTrafficHomeVideoItemModel3;
                                                int i16 = QPlusTrafficHomeVideoList.$r8$clinit;
                                                qPlusTrafficHomeVideoList7.getClass();
                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList$bodyWithVideoContent$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel9 = QPlusTrafficHomeVideoListViewModel.this;
                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel5 = qPlusTrafficHomeVideoItemModel4;
                                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList$bodyWithVideoContent$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar3) {
                                                                v vVar4 = vVar3;
                                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.flexDirection(FlexDirection.COLUMN);
                                                                        tVar2.justifyContent(FlexJustifyContent.FLEX_START);
                                                                        tVar2.alignItems(FlexAlign.CENTER);
                                                                        tVar2.m148positionType(FlexPositionType.RELATIVE);
                                                                        tVar2.borderRadius(4.0f, 4.0f, 4.0f, 4.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel10 = QPlusTrafficHomeVideoListViewModel.this;
                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel6 = qPlusTrafficHomeVideoItemModel5;
                                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel11 = QPlusTrafficHomeVideoListViewModel.this;
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel7 = qPlusTrafficHomeVideoItemModel6;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                QPlusTrafficHomeVideoListViewModel.this.selectItemModel(qPlusTrafficHomeVideoItemModel7);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel7 = qPlusTrafficHomeVideoItemModel5;
                                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel8 = QPlusTrafficHomeVideoItemModel.this;
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                String str;
                                                                                af afVar2 = afVar;
                                                                                afVar2.mo153width(FloatExtKt.getTo375(156.0f)).mo141height(FloatExtKt.getTo812(208.0f));
                                                                                QPlusCirStImage qPlusCirStImage = QPlusTrafficHomeVideoItemModel.this.info.cover;
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
                                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.4
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar5) {
                                                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.4.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo153width(FloatExtKt.getTo375(156.0f)).mo141height(32.0f);
                                                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                                                                tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0, 0, 0, 0.0f), 0.0f), new j(new h(0, 0, 0, 1.0f), 1.0f));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel8 = qPlusTrafficHomeVideoItemModel5;
                                                                final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel11 = QPlusTrafficHomeVideoListViewModel.this;
                                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.5
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar5) {
                                                                        v vVar6 = vVar5;
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel9 = QPlusTrafficHomeVideoItemModel.this;
                                                                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel12 = qPlusTrafficHomeVideoListViewModel11;
                                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.5.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo141height(14.0f);
                                                                                tVar2.alignItems(FlexAlign.CENTER);
                                                                                tVar2.flexDirection(FlexDirection.ROW);
                                                                                Attr.absolutePosition$default(tVar2, 0.0f, 5.5f, 6.0f, 0.0f, 1, null);
                                                                                tVar2.m152visibility(QPlusTrafficHomeVideoItemModel.this.info.visitorInfo != null && Intrinsics.areEqual(qPlusTrafficHomeVideoListViewModel12.uin, Utils.INSTANCE.currentBridgeModule().getCurrentAccount()));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.5.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.5.2.1
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
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel10 = QPlusTrafficHomeVideoItemModel.this;
                                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.5.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel11 = QPlusTrafficHomeVideoItemModel.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.5.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ce.fontSize$default(ceVar2, 11.0f, null, 2, null).fontWeightBold();
                                                                                        ceVar2.marginLeft(2.0f);
                                                                                        ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_white_color_text_primary", false));
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
                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel9 = qPlusTrafficHomeVideoItemModel5;
                                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.6
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel10 = QPlusTrafficHomeVideoItemModel.this;
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.6.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.mo153width(24.0f).mo141height(24.0f);
                                                                                afVar2.m148positionType(FlexPositionType.ABSOLUTE);
                                                                                afVar2.m149right(6.0f).m150top(6.0f);
                                                                                QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel11 = QPlusTrafficHomeVideoItemModel.this;
                                                                                if (((Boolean) qPlusTrafficHomeVideoItemModel11.isSelect$delegate.getValue(qPlusTrafficHomeVideoItemModel11, QPlusTrafficHomeVideoItemModel.$$delegatedProperties[0])).booleanValue()) {
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
                                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel10 = qPlusTrafficHomeVideoItemModel5;
                                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.7
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel11 = QPlusTrafficHomeVideoItemModel.this;
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoContent.1.1.7.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.borderRadius(4.0f);
                                                                                Attr.absolutePosition$default(afVar2, 10.0f, 10.0f, 0.0f, 0.0f, 12, null);
                                                                                afVar2.mo153width(56.0f).mo141height(22.0f);
                                                                                afVar2.m152visibility(QPlusTrafficHomeVideoItemModel.this.isLiveItem());
                                                                                ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_tag_live");
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
                                                }.invoke(vVar2);
                                                final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel5 = qPlusTrafficHomeVideoItemModel3;
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoItem.1.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final QPlusTrafficHomeVideoItemModel qPlusTrafficHomeVideoItemModel6 = QPlusTrafficHomeVideoItemModel.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoItem.1.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                h hVar;
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null).fontWeightBold();
                                                                ceVar2.fontFamily("PingFang SC");
                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                ceVar2.color(hVar);
                                                                ceVar2.mo153width(156.0f).mo141height(40.0f).marginTop(8.0f);
                                                                String filterCirEmoji = Cir_main_page_extensionKt.filterCirEmoji(QPlusTrafficHomeVideoItemModel.this.info.content);
                                                                String str = filterCirEmoji;
                                                                for (MatchResult matchResult : Regex.findAll$default(new Regex("\\{tagName=(.*?)\\}"), filterCirEmoji, 0, 2, null)) {
                                                                    List<String> groupValues = matchResult.getGroupValues();
                                                                    if (groupValues != null && groupValues.size() == 2) {
                                                                        List<String> groupValues2 = matchResult.getGroupValues();
                                                                        String str2 = groupValues2 != null ? groupValues2.get(0) : null;
                                                                        List<String> groupValues3 = matchResult.getGroupValues();
                                                                        String str3 = groupValues3 != null ? groupValues3.get(1) : null;
                                                                        if (str2 != null && str3 != null) {
                                                                            str = StringsKt__StringsJVMKt.replace$default(str, str2, str3, false, 4, (Object) null);
                                                                        }
                                                                    }
                                                                }
                                                                ceVar2.text(str).lines(2);
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
                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel6 = qPlusTrafficHomeVideoListViewModel2;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.6
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel7 = QPlusTrafficHomeVideoListViewModel.this;
                                return Boolean.valueOf(((Boolean) qPlusTrafficHomeVideoListViewModel7.showMostItem$delegate.getValue(qPlusTrafficHomeVideoListViewModel7, QPlusTrafficHomeVideoListViewModel.$$delegatedProperties[1])).booleanValue());
                            }
                        };
                        final QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList5 = QPlusTrafficHomeVideoList.this;
                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel7 = qPlusTrafficHomeVideoListViewModel2;
                        ConditionViewKt.c(aqVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                QPlusTrafficHomeVideoList qPlusTrafficHomeVideoList6 = QPlusTrafficHomeVideoList.this;
                                final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel8 = qPlusTrafficHomeVideoListViewModel7;
                                int i3 = QPlusTrafficHomeVideoList.$r8$clinit;
                                qPlusTrafficHomeVideoList6.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList$bodyWithVideoMoseItem$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel9 = QPlusTrafficHomeVideoListViewModel.this;
                                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList$bodyWithVideoMoseItem$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoMoseItem.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        h hVar;
                                                        t tVar2 = tVar;
                                                        tVar2.allCenter();
                                                        tVar2.borderRadius(4.0f);
                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_tag_selected", false);
                                                        tVar2.mo113backgroundColor(hVar);
                                                        tVar2.mo153width(FloatExtKt.getTo375(156.0f)).mo141height(FloatExtKt.getTo812(208.0f));
                                                        tVar2.marginLeft(4.0f).marginRight(4.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoMoseItem.1.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoMoseItem.1.1.2.1
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
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoMoseItem.1.1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoMoseItem.1.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                h hVar;
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginTop(11.0f);
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.fontFamily("PingFang SC");
                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                ceVar2.color(hVar);
                                                                ceVar2.text("\u67e5\u770b\u66f4\u591a\u4f5c\u54c1");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel10 = QPlusTrafficHomeVideoListViewModel.this;
                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoMoseItem.1.1.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel11 = QPlusTrafficHomeVideoListViewModel.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.bodyWithVideoMoseItem.1.1.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                final QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel12 = QPlusTrafficHomeVideoListViewModel.this;
                                                                qPlusTrafficHomeVideoListViewModel12.getClass();
                                                                IPagerIdKtxKt.openPageForResult$default(com.tencent.kuikly.core.manager.c.f117352a.g(), OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?target=52&channel=2&page_name=promotion_video_select&target_uin="), qPlusTrafficHomeVideoListViewModel12.uin, "&src_type=internal&version=1&bundle_name=new_qecommerce"), null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoListViewModel$goToMoreVideoPage$1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(e eVar) {
                                                                        e eVar2 = eVar;
                                                                        if (eVar2 != null) {
                                                                            QPlusTrafficHomeVideoListViewModel qPlusTrafficHomeVideoListViewModel13 = QPlusTrafficHomeVideoListViewModel.this;
                                                                            QPlusCirStFeed decode = new QPlusCirStFeed(null, null, null, 1023).decode(eVar2);
                                                                            qPlusTrafficHomeVideoListViewModel13.addFeedAtFirst(decode);
                                                                            qPlusTrafficHomeVideoListViewModel13.selectFeed(decode.feedId);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }, 6);
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
                                }.invoke(conditionView);
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.8
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoList.body.1.1.8.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.mo153width(12.0f).mo141height(258.0f);
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
}
