package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.common.ECNumberHelper;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.sep_line.QPlusTrafficHomeCardSepLineView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.sep_line.QPlusTrafficHomeCardSepLineViewKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusIndex;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPlanItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusProgress;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.QPlusTrafficHomeCardAttr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.reactive.collection.c;
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
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeOrderView extends QPlusTrafficHomeCardView {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPlusTrafficCardHomeViewModel viewModel = ((QPlusTrafficHomeCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderViewModel");
        final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel = (QPlusTrafficHomeOrderViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                QPlusTrafficHomeCardSepLineViewKt.CardSepLineView(viewContainer2, new Function1<QPlusTrafficHomeCardSepLineView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPlusTrafficHomeCardSepLineView qPlusTrafficHomeCardSepLineView) {
                        return Unit.INSTANCE;
                    }
                });
                final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel2 = QPlusTrafficHomeOrderViewModel.this;
                final QPlusTrafficHomeOrderView qPlusTrafficHomeOrderView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel3 = QPlusTrafficHomeOrderViewModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingRight(16.0f);
                                tVar2.mo153width(tVar2.getPagerData().m());
                                if (QPlusTrafficHomeOrderViewModel.this.getUiState() == QPlusTrafficUIState.COMPLETED) {
                                    tVar2.paddingLeft(16.0f);
                                }
                                GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_default", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel4 = QPlusTrafficHomeOrderViewModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.body.1.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QPlusTrafficHomeOrderViewModel.this.getUiState() == QPlusTrafficUIState.COMPLETED);
                            }
                        };
                        final QPlusTrafficHomeOrderView qPlusTrafficHomeOrderView2 = qPlusTrafficHomeOrderView;
                        final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel5 = QPlusTrafficHomeOrderViewModel.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                QPlusTrafficHomeOrderView qPlusTrafficHomeOrderView3 = QPlusTrafficHomeOrderView.this;
                                final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel6 = qPlusTrafficHomeOrderViewModel5;
                                int i3 = QPlusTrafficHomeOrderView.$r8$clinit;
                                qPlusTrafficHomeOrderView3.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$bodyWithTitle$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel7 = QPlusTrafficHomeOrderViewModel.this;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$bodyWithTitle$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        h hVar;
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirection(FlexDirection.ROW);
                                                        tVar2.justifyContent(FlexJustifyContent.SPACE_BETWEEN);
                                                        tVar2.marginTop(16.0f);
                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                                        tVar2.mo113backgroundColor(hVar);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                h hVar;
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 15.0f, null, 2, null).fontWeightBold();
                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                ceVar2.color(hVar);
                                                                ceVar2.text("\u6700\u8fd1\u8ba2\u5355");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel8 = QPlusTrafficHomeOrderViewModel.this;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirection(FlexDirection.ROW);
                                                                tVar2.alignItemsCenter();
                                                                tVar2.marginRight(4.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel9 = QPlusTrafficHomeOrderViewModel.this;
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel10 = QPlusTrafficHomeOrderViewModel.this;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        QPlusTrafficHomeOrderViewModel.this.getClass();
                                                                        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), "mqqapi://kuikly/open?target=52&page_name=qplus_order_list&src_type=internal&version=1&bundle_name=new_qecommerce", false, null, null, 30);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.3.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.3.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.fontFamily("PingFang SC");
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.text("\u5168\u90e8\u8ba2\u5355");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.3.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithTitle.1.1.3.4.1
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
                                }.invoke(conditionView2);
                                if (!qPlusTrafficHomeOrderViewModel5.getOrderItem().isEmpty()) {
                                    QPlusTrafficHomeOrderView qPlusTrafficHomeOrderView4 = QPlusTrafficHomeOrderView.this;
                                    final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel7 = qPlusTrafficHomeOrderViewModel5;
                                    qPlusTrafficHomeOrderView4.getClass();
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$bodyWithContent$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                            final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel8 = QPlusTrafficHomeOrderViewModel.this;
                                            w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$bodyWithContent$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithContent.1.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.flexDirection(FlexDirection.COLUMN);
                                                            GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_default", false, 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel9 = QPlusTrafficHomeOrderViewModel.this;
                                                    Function0<c<QPlusPlanItem>> function02 = new Function0<c<QPlusPlanItem>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithContent.1.1.2
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final c<QPlusPlanItem> invoke() {
                                                            return QPlusTrafficHomeOrderViewModel.this.getOrderItem();
                                                        }
                                                    };
                                                    final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel10 = QPlusTrafficHomeOrderViewModel.this;
                                                    LoopDirectivesViewKt.a(vVar4, function02, new Function2<LoopDirectivesView<QPlusPlanItem>, QPlusPlanItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithContent.1.1.3
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(LoopDirectivesView<QPlusPlanItem> loopDirectivesView, QPlusPlanItem qPlusPlanItem) {
                                                            final QPlusPlanItem qPlusPlanItem2 = qPlusPlanItem;
                                                            final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel11 = QPlusTrafficHomeOrderViewModel.this;
                                                            loopDirectivesView.addChild(new QPlusTrafficOrderItemView(), new Function1<QPlusTrafficOrderItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithContent.1.1.3.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QPlusTrafficOrderItemView qPlusTrafficOrderItemView) {
                                                                    QPlusTrafficOrderItemView qPlusTrafficOrderItemView2 = qPlusTrafficOrderItemView;
                                                                    final QPlusPlanItem qPlusPlanItem3 = QPlusPlanItem.this;
                                                                    qPlusTrafficOrderItemView2.attr(new Function1<QPlusTrafficOrderItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithContent.1.1.3.1.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QPlusTrafficOrderItemViewAttr qPlusTrafficOrderItemViewAttr) {
                                                                            String joinToString$default;
                                                                            String str;
                                                                            QPlusTrafficOrderItemViewAttr qPlusTrafficOrderItemViewAttr2 = qPlusTrafficOrderItemViewAttr;
                                                                            QPlusPlanItem qPlusPlanItem4 = QPlusPlanItem.this;
                                                                            qPlusTrafficOrderItemViewAttr2.icon = qPlusPlanItem4.icon;
                                                                            qPlusTrafficOrderItemViewAttr2.title = qPlusPlanItem4.title;
                                                                            qPlusTrafficOrderItemViewAttr2.dateStr = qPlusPlanItem4.date;
                                                                            ArrayList arrayList = new ArrayList();
                                                                            ArrayList<QPlusIndex> arrayList2 = qPlusPlanItem4.indexs;
                                                                            int i16 = 0;
                                                                            if (arrayList2 != null) {
                                                                                for (QPlusIndex qPlusIndex : arrayList2) {
                                                                                    arrayList.add(qPlusIndex.indexName + TokenParser.SP + ECNumberHelper.formatString$default(qPlusIndex.cnt, 0, 6));
                                                                                }
                                                                            }
                                                                            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " \u00b7 ", null, null, 0, null, null, 62, null);
                                                                            qPlusTrafficOrderItemViewAttr2.descriptionNumber = joinToString$default;
                                                                            QPlusPlanItem qPlusPlanItem5 = QPlusPlanItem.this;
                                                                            QPlusProgress qPlusProgress = qPlusPlanItem5.progress;
                                                                            int i17 = qPlusProgress != null ? qPlusProgress.percent : 0;
                                                                            int i18 = qPlusPlanItem5.planStatus;
                                                                            if ((i18 == 5 || i18 == 6 || i18 == 7) && i17 < 100) {
                                                                                str = "\u5df2\u7ed3\u675f";
                                                                            } else {
                                                                                int[] values = BoxType$EnumUnboxingSharedUtility.values(7);
                                                                                int length = values.length;
                                                                                int i19 = 0;
                                                                                while (true) {
                                                                                    if (i19 >= length) {
                                                                                        break;
                                                                                    }
                                                                                    int i26 = values[i19];
                                                                                    if (QPlusPlanItemPlanStatusEnum$EnumUnboxingLocalUtility.getType(i26) == i18) {
                                                                                        i16 = i26;
                                                                                        break;
                                                                                    }
                                                                                    i19++;
                                                                                }
                                                                                if (i16 != 0) {
                                                                                    str = QPlusPlanItemPlanStatusEnum$EnumUnboxingLocalUtility.getText(i16);
                                                                                } else {
                                                                                    str = "\u672a\u77e5";
                                                                                }
                                                                            }
                                                                            qPlusTrafficOrderItemViewAttr2.planStatus = str;
                                                                            qPlusTrafficOrderItemViewAttr2.percent = i17;
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel12 = qPlusTrafficHomeOrderViewModel11;
                                                                    final QPlusPlanItem qPlusPlanItem4 = QPlusPlanItem.this;
                                                                    qPlusTrafficOrderItemView2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithContent.1.1.3.1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(l lVar) {
                                                                            final QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel13 = QPlusTrafficHomeOrderViewModel.this;
                                                                            final QPlusPlanItem qPlusPlanItem5 = qPlusPlanItem4;
                                                                            lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithContent.1.1.3.1.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel14 = QPlusTrafficHomeOrderViewModel.this;
                                                                                    QPlusPlanItem qPlusPlanItem6 = qPlusPlanItem5;
                                                                                    qPlusTrafficHomeOrderViewModel14.getClass();
                                                                                    StringBuilder sb5 = new StringBuilder();
                                                                                    sb5.append("mqqapi://kuikly/open?target=52&page_name=qplus_order_detail&plan_id=");
                                                                                    BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb5, qPlusPlanItem6.planId, "&src_type=internal&version=1&bundle_name=new_qecommerce"), false, null, null, 30);
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
                                    }.invoke(conditionView2);
                                    if (QPlusTrafficHomeOrderView.this.getPagerData().getIsIphoneX()) {
                                        QPlusTrafficHomeOrderView.this.getClass();
                                        QPlusTrafficHomeOrderView$bodyWithSafeArea$1.INSTANCE.invoke(conditionView2);
                                    }
                                } else {
                                    QPlusTrafficHomeOrderView.this.getClass();
                                    QPlusTrafficHomeOrderView$bodyWithEmptyContent$1.INSTANCE.invoke(conditionView2);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QPlusTrafficHomeOrderView qPlusTrafficHomeOrderView3 = qPlusTrafficHomeOrderView;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                QPlusTrafficHomeOrderView qPlusTrafficHomeOrderView4 = QPlusTrafficHomeOrderView.this;
                                int i3 = QPlusTrafficHomeOrderView.$r8$clinit;
                                qPlusTrafficHomeOrderView4.getClass();
                                QPlusTrafficHomeOrderView$bodyWithSkeletonView$1.INSTANCE.invoke(conditionView);
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
