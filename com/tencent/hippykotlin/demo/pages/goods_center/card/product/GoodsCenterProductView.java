package com.tencent.hippykotlin.demo.pages.goods_center.card.product;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.module.AddWindowModule;
import com.tencent.hippykotlin.demo.pages.goods_center.report.GoodsCenterReporter;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterLabelInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterShopInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.SCPUtilsKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.layout.ColumnView;
import com.tencent.kuikly.core.views.layout.RowView;
import com.tencent.kuikly.core.views.layout.a;
import com.tencent.kuikly.core.views.layout.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.raft.measure.utils.MeasureConst;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes31.dex */
public final class GoodsCenterProductView extends ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductViewModel");
        final GoodsCenterProductViewModel goodsCenterProductViewModel = (GoodsCenterProductViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GoodsCenterProductViewModel goodsCenterProductViewModel2 = GoodsCenterProductViewModel.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.padding(8.0f, 16.0f, 8.0f, 16.0f);
                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_default");
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterProductViewModel goodsCenterProductViewModel3 = GoodsCenterProductViewModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final GoodsCenterProductViewModel goodsCenterProductViewModel4 = GoodsCenterProductViewModel.this;
                                VisibilityEventKt.e(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        GoodsCenterProductViewModel goodsCenterProductViewModel5 = GoodsCenterProductViewModel.this;
                                        GoodsCenterReporter goodsCenterReporter = GoodsCenterReporter.INSTANCE;
                                        GoodsCenterProductInfo goodsCenterProductInfo = goodsCenterProductViewModel5.productInfo;
                                        List<GoodsCenterFilterCond> list = goodsCenterProductViewModel5.filterCondList;
                                        List<GoodsCenterRangeCond> list2 = goodsCenterProductViewModel5.rangeCondList;
                                        e paramsWithProduct = goodsCenterReporter.paramsWithProduct(goodsCenterProductInfo);
                                        paramsWithProduct.v("current_card_filters", goodsCenterReporter.getReportFilterList(list, list2));
                                        goodsCenterReporter.reportDT("xuanpin_goods_card_exp", paramsWithProduct);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterProductViewModel goodsCenterProductViewModel5 = GoodsCenterProductViewModel.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GoodsCenterProductViewModel goodsCenterProductViewModel6 = GoodsCenterProductViewModel.this;
                                        GoodsCenterReporter goodsCenterReporter = GoodsCenterReporter.INSTANCE;
                                        GoodsCenterProductInfo goodsCenterProductInfo = goodsCenterProductViewModel6.productInfo;
                                        List<GoodsCenterFilterCond> list = goodsCenterProductViewModel6.filterCondList;
                                        List<GoodsCenterRangeCond> list2 = goodsCenterProductViewModel6.rangeCondList;
                                        e paramsWithProduct = goodsCenterReporter.paramsWithProduct(goodsCenterProductInfo);
                                        paramsWithProduct.v("current_card_filters", goodsCenterReporter.getReportFilterList(list, list2));
                                        goodsCenterReporter.reportDT("xuanpin_goods_card_clk", paramsWithProduct);
                                        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), goodsCenterProductViewModel6.productInfo.detailUrl, false, null, null, 30);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterProductViewModel goodsCenterProductViewModel4 = GoodsCenterProductViewModel.this;
                        c.b(vVar2, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RowView rowView) {
                                RowView rowView2 = rowView;
                                rowView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(m mVar) {
                                        m mVar2 = mVar;
                                        mVar2.mo153width(mVar2.getPagerData().m() - 16);
                                        mVar2.mo141height(132.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterProductViewModel goodsCenterProductViewModel5 = GoodsCenterProductViewModel.this;
                                ah.a(rowView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final GoodsCenterProductViewModel goodsCenterProductViewModel6 = GoodsCenterProductViewModel.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
                                            
                                                if (r0 == null) goto L6;
                                             */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(af afVar) {
                                                String str;
                                                Object first;
                                                af afVar2 = afVar;
                                                afVar2.size(132.0f, 132.0f);
                                                ArrayList<String> arrayList = GoodsCenterProductViewModel.this.productInfo.cdnMainPics;
                                                if (arrayList != null) {
                                                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                                                    str = (String) first;
                                                }
                                                str = "";
                                                b.a.b(afVar2, str, false, 2, null);
                                                afVar2.borderRadius(4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float m3 = ((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(com.tencent.kuikly.core.manager.c.f117352a) - 132) - 8) - 16;
                                final GoodsCenterProductViewModel goodsCenterProductViewModel6 = GoodsCenterProductViewModel.this;
                                a.b(rowView2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ColumnView columnView) {
                                        ColumnView columnView2 = columnView;
                                        final float f16 = m3;
                                        columnView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(m mVar) {
                                                m mVar2 = mVar;
                                                mVar2.marginLeft(8.0f);
                                                mVar2.mo153width(f16);
                                                mVar2.mo141height(132.0f);
                                                mVar2.justifyContentSpaceBetween();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterProductViewModel goodsCenterProductViewModel7 = goodsCenterProductViewModel6;
                                        final float f17 = m3;
                                        w.a(columnView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        tVar.alignItemsFlexStart();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterProductViewModel goodsCenterProductViewModel8 = GoodsCenterProductViewModel.this;
                                                final float f18 = f17;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        final Ref.FloatRef floatRef = new Ref.FloatRef();
                                                        ArrayList<GoodsCenterLabelInfo> arrayList = GoodsCenterProductViewModel.this.productInfo.labels;
                                                        if (arrayList == null) {
                                                            arrayList = new ArrayList<>();
                                                        }
                                                        if (!arrayList.isEmpty()) {
                                                            final GoodsCenterProductViewModel goodsCenterProductViewModel9 = GoodsCenterProductViewModel.this;
                                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar7) {
                                                                    v vVar8 = vVar7;
                                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.2.1.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                                            tVar2.mo141height(20.0f);
                                                                            tVar2.alignItemsCenter();
                                                                            tVar2.flexDirectionRow();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    ArrayList<GoodsCenterLabelInfo> arrayList2 = GoodsCenterProductViewModel.this.productInfo.labels;
                                                                    if (arrayList2 == null) {
                                                                        arrayList2 = new ArrayList<>();
                                                                    }
                                                                    Ref.FloatRef floatRef2 = floatRef;
                                                                    for (final GoodsCenterLabelInfo goodsCenterLabelInfo : arrayList2) {
                                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$3$2$2$1$2$1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                final GoodsCenterLabelInfo goodsCenterLabelInfo2 = GoodsCenterLabelInfo.this;
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$3$2$2$1$2$1.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.mo153width(GoodsCenterLabelInfo.this.width);
                                                                                        afVar2.mo141height(GoodsCenterLabelInfo.this.height);
                                                                                        afVar2.marginRight(4.0f);
                                                                                        afVar2.borderRadius(2.0f);
                                                                                        if (GoodsCenterLabelInfo.this.picUrl.length() > 0) {
                                                                                            b.a.b(afVar2, GoodsCenterLabelInfo.this.picUrl, false, 2, null);
                                                                                        } else {
                                                                                            b.a.b(afVar2, GoodsCenterLabelInfo.this.picToken, false, 2, null);
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        floatRef2.element = goodsCenterLabelInfo.width + 4.0f + floatRef2.element;
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        final float f19 = f18;
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel10 = GoodsCenterProductViewModel.this;
                                                        RichTextViewKt.b(vVar6, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RichTextView richTextView) {
                                                                final float f26 = f19;
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel11 = goodsCenterProductViewModel10;
                                                                final Ref.FloatRef floatRef2 = floatRef;
                                                                richTextView.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                                                        RichTextAttr richTextAttr2 = richTextAttr;
                                                                        AttrExtKt.colorToken(richTextAttr2, "qecommerce_skin_color_text_primary");
                                                                        richTextAttr2.mo153width(f26 - 16.0f);
                                                                        richTextAttr2.text(goodsCenterProductViewModel11.productInfo.title);
                                                                        richTextAttr2.fontWeight500();
                                                                        richTextAttr2.marginLeft(0.0f);
                                                                        ce.fontSize$default(richTextAttr2, 14.0f, null, 2, null);
                                                                        richTextAttr2.lineHeight(20.0f);
                                                                        richTextAttr2.lines(2);
                                                                        richTextAttr2.firstLineHeadIndent(floatRef2.element);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterProductViewModel goodsCenterProductViewModel9 = GoodsCenterProductViewModel.this;
                                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.3
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        ArrayList<GoodsCenterLabelInfo> arrayList = GoodsCenterProductViewModel.this.productInfo.serviceTags;
                                                        if (arrayList != null) {
                                                            return Integer.valueOf(arrayList.size());
                                                        }
                                                        return null;
                                                    }
                                                };
                                                final GoodsCenterProductViewModel goodsCenterProductViewModel10 = GoodsCenterProductViewModel.this;
                                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel11 = GoodsCenterProductViewModel.this;
                                                        c.b(conditionView, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RowView rowView3) {
                                                                RowView rowView4 = rowView3;
                                                                rowView4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.4.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(m mVar) {
                                                                        m mVar2 = mVar;
                                                                        mVar2.marginTop(4.0f);
                                                                        mVar2.justifyContentFlexStart();
                                                                        mVar2.flexWrapWrap();
                                                                        mVar2.overflow(true);
                                                                        mVar2.mo153width(((mVar2.getPagerData().m() - 132) - 8) - 16);
                                                                        mVar2.mo141height(16.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                ArrayList<GoodsCenterLabelInfo> arrayList = GoodsCenterProductViewModel.this.productInfo.serviceTags;
                                                                if (arrayList != null) {
                                                                    for (final GoodsCenterLabelInfo goodsCenterLabelInfo : arrayList) {
                                                                        ConditionViewKt.c(rowView4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$3$2$4$1$2$1
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Object invoke() {
                                                                                int i3 = GoodsCenterLabelInfo.this.textStyleType;
                                                                                boolean z16 = true;
                                                                                if (i3 != 0 && i3 != 1) {
                                                                                    z16 = false;
                                                                                }
                                                                                return Boolean.valueOf(z16);
                                                                            }
                                                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$3$2$4$1$2$2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ConditionView conditionView2) {
                                                                                final GoodsCenterLabelInfo goodsCenterLabelInfo2 = GoodsCenterLabelInfo.this;
                                                                                w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$3$2$4$1$2$2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(v vVar5) {
                                                                                        v vVar6 = vVar5;
                                                                                        final GoodsCenterLabelInfo goodsCenterLabelInfo3 = GoodsCenterLabelInfo.this;
                                                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.4.1.2.2.1.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(t tVar) {
                                                                                                t tVar2 = tVar;
                                                                                                tVar2.m136border(new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, new h(GoodsCenterLabelInfo.this.borderColor)));
                                                                                                tVar2.borderRadius(2.0f);
                                                                                                tVar2.paddingLeft(2.0f);
                                                                                                tVar2.paddingRight(2.0f);
                                                                                                tVar2.marginRight(4.0f);
                                                                                                tVar2.allCenter();
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        final GoodsCenterLabelInfo goodsCenterLabelInfo4 = GoodsCenterLabelInfo.this;
                                                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.4.1.2.2.1.2
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(TextView textView) {
                                                                                                final GoodsCenterLabelInfo goodsCenterLabelInfo5 = GoodsCenterLabelInfo.this;
                                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.4.1.2.2.1.2.1
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(ce ceVar) {
                                                                                                        ce ceVar2 = ceVar;
                                                                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                                                        ceVar2.text(GoodsCenterLabelInfo.this.text);
                                                                                                        AttrExtKt.colorToken(ceVar2, GoodsCenterLabelInfo.this.textColor);
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
                                                                        ConditionViewKt.b(rowView4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$3$2$4$1$2$3
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Object invoke() {
                                                                                return Boolean.valueOf(GoodsCenterLabelInfo.this.textStyleType == 2);
                                                                            }
                                                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$3$2$4$1$2$4
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ConditionView conditionView2) {
                                                                                final GoodsCenterLabelInfo goodsCenterLabelInfo2 = GoodsCenterLabelInfo.this;
                                                                                w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$3$2$4$1$2$4.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(v vVar5) {
                                                                                        v vVar6 = vVar5;
                                                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.4.1.2.4.1.1
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(t tVar) {
                                                                                                t tVar2 = tVar;
                                                                                                tVar2.m136border(new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, new h("qecommerce_skin_color_text_red_brand")));
                                                                                                tVar2.borderRadius(2.0f);
                                                                                                tVar2.paddingLeft(2.0f);
                                                                                                tVar2.paddingRight(2.0f);
                                                                                                tVar2.marginRight(4.0f);
                                                                                                tVar2.allCenter();
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        final GoodsCenterLabelInfo goodsCenterLabelInfo3 = GoodsCenterLabelInfo.this;
                                                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.4.1.2.4.1.2
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(TextView textView) {
                                                                                                final GoodsCenterLabelInfo goodsCenterLabelInfo4 = GoodsCenterLabelInfo.this;
                                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.4.1.2.4.1.2.1
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(ce ceVar) {
                                                                                                        ce ceVar2 = ceVar;
                                                                                                        ceVar2.text(GoodsCenterLabelInfo.this.textPrefix + QbAddrData.DATA_SPLITER + GoodsCenterLabelInfo.this.text);
                                                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_red_brand");
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
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterProductViewModel goodsCenterProductViewModel11 = GoodsCenterProductViewModel.this;
                                                c.b(vVar4, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(RowView rowView3) {
                                                        RowView rowView4 = rowView3;
                                                        rowView4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(m mVar) {
                                                                m mVar2 = mVar;
                                                                mVar2.marginTop(4.0f);
                                                                mVar2.mo141height(17.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel12 = GoodsCenterProductViewModel.this;
                                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.2
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                return Boolean.valueOf(GoodsCenterProductViewModel.this.productInfo.delivery_mode == 1);
                                                            }
                                                        };
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel13 = GoodsCenterProductViewModel.this;
                                                        ConditionViewKt.c(rowView4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel14 = GoodsCenterProductViewModel.this;
                                                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel15 = GoodsCenterProductViewModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.3.1.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u9884\u552e\u4ef7\u00a5");
                                                                                m16.append(SCPUtilsKt.priceToStr(GoodsCenterProductViewModel.this.productInfo.price, false));
                                                                                ceVar2.text(m16.toString());
                                                                                ceVar2.marginRight(12.0f);
                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel14 = GoodsCenterProductViewModel.this;
                                                        ConditionViewKt.a(rowView4, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel15 = GoodsCenterProductViewModel.this;
                                                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel16 = GoodsCenterProductViewModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.4.1.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u552e\u4ef7\u00a5");
                                                                                m16.append(SCPUtilsKt.priceToStr(GoodsCenterProductViewModel.this.productInfo.price, false));
                                                                                ceVar2.text(m16.toString());
                                                                                ceVar2.marginRight(12.0f);
                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel15 = GoodsCenterProductViewModel.this;
                                                        cg.a(rowView4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.5
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel16 = GoodsCenterProductViewModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.5.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4f63\u91d1\u7387");
                                                                        m16.append(GoodsCenterProductViewModel.this.productInfo.commissionRateTxt);
                                                                        m16.append('%');
                                                                        ceVar2.text(m16.toString());
                                                                        ceVar2.marginRight(12.0f);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel16 = GoodsCenterProductViewModel.this;
                                                        cg.a(rowView4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.6
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel17 = GoodsCenterProductViewModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.5.6.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u9500\u91cf");
                                                                        m16.append(GoodsCenterProductViewModel.this.productInfo.salesTxt);
                                                                        ceVar2.text(m16.toString());
                                                                        ceVar2.marginRight(12.0f);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterProductViewModel goodsCenterProductViewModel12 = GoodsCenterProductViewModel.this;
                                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.6
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return GoodsCenterProductViewModel.this.productInfo.shopInfo;
                                                    }
                                                };
                                                final GoodsCenterProductViewModel goodsCenterProductViewModel13 = GoodsCenterProductViewModel.this;
                                                ConditionViewKt.c(vVar4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel14 = GoodsCenterProductViewModel.this;
                                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar5) {
                                                                v vVar6 = vVar5;
                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.m140flex(1.0f);
                                                                        tVar2.mo141height(16.0f);
                                                                        tVar2.marginTop(4.0f);
                                                                        tVar2.flexDirectionRow();
                                                                        tVar2.alignItemsCenter();
                                                                        tVar2.borderRadius(2.0f);
                                                                        AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_backplate");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel15 = GoodsCenterProductViewModel.this;
                                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel16 = GoodsCenterProductViewModel.this;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                GoodsCenterShopInfo goodsCenterShopInfo = GoodsCenterProductViewModel.this.productInfo.shopInfo;
                                                                                if (goodsCenterShopInfo != null) {
                                                                                    BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), goodsCenterShopInfo.url, false, null, null, 30);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1.3
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar7) {
                                                                        vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1.3.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo141height(16.0f);
                                                                                tVar2.mo153width(4.0f);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel16 = GoodsCenterProductViewModel.this;
                                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1.4
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel17 = GoodsCenterProductViewModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1.4.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                                ceVar2.mo141height(16.0f);
                                                                                ceVar2.lineHeight(16.0f);
                                                                                ceVar2.lines(1);
                                                                                GoodsCenterShopInfo goodsCenterShopInfo = GoodsCenterProductViewModel.this.productInfo.shopInfo;
                                                                                if (goodsCenterShopInfo != null) {
                                                                                    ceVar2.text(goodsCenterShopInfo.shopName);
                                                                                }
                                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1.5
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.2.7.1.5.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.mo153width(12.0f);
                                                                                afVar2.mo141height(12.0f);
                                                                                afVar2.marginLeft(2.0f);
                                                                                afVar2.marginRight(4.0f);
                                                                                b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_light", false, 2, null);
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
                                        final GoodsCenterProductViewModel goodsCenterProductViewModel8 = goodsCenterProductViewModel6;
                                        w.a(columnView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(28.0f);
                                                        tVar2.mo153width(((tVar2.getPagerData().m() - 132) - 8) - 16);
                                                        tVar2.justifyContentSpaceBetween();
                                                        tVar2.flexDirectionRow();
                                                        tVar2.alignItemsFlexEnd();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterProductViewModel goodsCenterProductViewModel9 = GoodsCenterProductViewModel.this;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.alignItemsFlexEnd();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_red_brand");
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        ceVar2.fontWeight500();
                                                                        ceVar2.mo141height(17.0f);
                                                                        ceVar2.text("\u4f63\u91d1");
                                                                        if (!ceVar2.getPagerData().getIsIOS()) {
                                                                            ceVar2.marginBottom(-2.0f);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_red_brand");
                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                        ceVar2.fontWeight700();
                                                                        ceVar2.text("\u00a5");
                                                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                                                        ceVar2.lineHeight(15.0f);
                                                                        ceVar2.marginLeft(4.0f);
                                                                        if (ceVar2.getPagerData().getIsIOS()) {
                                                                            ceVar2.marginBottom(-2.0f);
                                                                        } else {
                                                                            ceVar2.marginBottom(1.0f);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel10 = GoodsCenterProductViewModel.this;
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel11 = GoodsCenterProductViewModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        Object first;
                                                                        ce ceVar2 = ceVar;
                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_red_brand");
                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                        ceVar2.fontWeight700();
                                                                        ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                                        ceVar2.lineHeight(19.0f);
                                                                        if (ceVar2.getPagerData().getIsIOS()) {
                                                                            ceVar2.marginBottom(-4.0f);
                                                                        }
                                                                        ArrayList<Long> arrayList = GoodsCenterProductViewModel.this.productInfo.commissions;
                                                                        if (arrayList != null) {
                                                                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                                                                            String priceToStr = SCPUtilsKt.priceToStr(((Number) first).longValue(), false);
                                                                            if (priceToStr != null) {
                                                                                ceVar2.text(priceToStr);
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel11 = GoodsCenterProductViewModel.this;
                                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.5
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                ArrayList<Long> arrayList = GoodsCenterProductViewModel.this.productInfo.commissions;
                                                                Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
                                                                Intrinsics.checkNotNull(valueOf);
                                                                return Boolean.valueOf(valueOf.intValue() > 1);
                                                            }
                                                        };
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel12 = GoodsCenterProductViewModel.this;
                                                        ConditionViewKt.c(vVar6, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.6
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                ConditionView conditionView2 = conditionView;
                                                                cg.a(conditionView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.6.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.6.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_red_brand");
                                                                                ceVar2.text("~");
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                cg.a(conditionView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.6.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.6.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_red_brand");
                                                                                ceVar2.fontFamily("Qvideo Digit");
                                                                                ceVar2.fontWeight700();
                                                                                ceVar2.text("\u00a5");
                                                                                ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                                                                ceVar2.lineHeight(15.0f);
                                                                                ceVar2.marginLeft(4.0f);
                                                                                if (ceVar2.getPagerData().getIsIOS()) {
                                                                                    ceVar2.marginBottom(-2.0f);
                                                                                } else {
                                                                                    ceVar2.marginBottom(1.0f);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel13 = GoodsCenterProductViewModel.this;
                                                                cg.a(conditionView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.6.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel14 = GoodsCenterProductViewModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.2.6.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                Object last;
                                                                                ce ceVar2 = ceVar;
                                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_red_brand");
                                                                                ceVar2.fontFamily("Qvideo Digit");
                                                                                ceVar2.fontWeight700();
                                                                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                                                ceVar2.lineHeight(19.0f);
                                                                                if (ceVar2.getPagerData().getIsIOS()) {
                                                                                    ceVar2.marginBottom(-4.0f);
                                                                                }
                                                                                ArrayList<Long> arrayList = GoodsCenterProductViewModel.this.productInfo.commissions;
                                                                                if (arrayList != null) {
                                                                                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                                                                                    ceVar2.text(SCPUtilsKt.priceToStr(((Number) last).longValue(), false));
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
                                                final GoodsCenterProductViewModel goodsCenterProductViewModel10 = GoodsCenterProductViewModel.this;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel11 = GoodsCenterProductViewModel.this;
                                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.1
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                GoodsCenterProductViewModel goodsCenterProductViewModel12 = GoodsCenterProductViewModel.this;
                                                                return Boolean.valueOf(!((Boolean) goodsCenterProductViewModel12.isAdded$delegate.getValue(goodsCenterProductViewModel12, GoodsCenterProductViewModel.$$delegatedProperties[0])).booleanValue());
                                                            }
                                                        };
                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel12 = GoodsCenterProductViewModel.this;
                                                        ConditionViewKt.c(vVar6, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel13 = GoodsCenterProductViewModel.this;
                                                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar7) {
                                                                        v vVar8 = vVar7;
                                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.2.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                h hVar;
                                                                                h hVar2;
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo153width(58.0f);
                                                                                tVar2.mo141height(28.0f);
                                                                                tVar2.justifyContentCenter();
                                                                                tVar2.alignItemsCenter();
                                                                                tVar2.borderRadius(3.0f);
                                                                                tVar2.marginRight(16.0f);
                                                                                Direction direction = Direction.TO_RIGHT;
                                                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient01_normal", false);
                                                                                hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient02_normal", false);
                                                                                tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final GoodsCenterProductViewModel goodsCenterProductViewModel14 = GoodsCenterProductViewModel.this;
                                                                        vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.2.1.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(u uVar) {
                                                                                final GoodsCenterProductViewModel goodsCenterProductViewModel15 = GoodsCenterProductViewModel.this;
                                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.2.1.2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        GoodsCenterProductViewModel goodsCenterProductViewModel16 = GoodsCenterProductViewModel.this;
                                                                                        GoodsCenterReporter goodsCenterReporter = GoodsCenterReporter.INSTANCE;
                                                                                        GoodsCenterProductInfo goodsCenterProductInfo = goodsCenterProductViewModel16.productInfo;
                                                                                        List<GoodsCenterFilterCond> list = goodsCenterProductViewModel16.filterCondList;
                                                                                        List<GoodsCenterRangeCond> list2 = goodsCenterProductViewModel16.rangeCondList;
                                                                                        e paramsWithProduct = goodsCenterReporter.paramsWithProduct(goodsCenterProductInfo);
                                                                                        paramsWithProduct.v("current_card_filters", goodsCenterReporter.getReportFilterList(list, list2));
                                                                                        goodsCenterReporter.reportDT("xuanpin_goods_card_add", paramsWithProduct);
                                                                                        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                                                        AddWindowModule addWindowModule = (AddWindowModule) cVar.k(BridgeManager.f117344a.u()).acquireModule("HRAddWindowModule");
                                                                                        GoodsCenterProductInfo goodsCenterProductInfo2 = goodsCenterProductViewModel16.productInfo;
                                                                                        addWindowModule.addProductToWindow(goodsCenterProductInfo2.saasProductId, goodsCenterProductInfo2.saasTypeStr, goodsCenterProductInfo2.goodsType);
                                                                                        Utils utils = Utils.INSTANCE;
                                                                                        utils.currentBridgeModule().setCachedToNative(AgreementConsentViewKt$$ExternalSyntheticOutline0.m(cVar.g().getPageData().n().p("uin"), "_selectProductsFirstPageCacheKey"), "{}", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRepository$clearFirstPageCache$1
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        ProductDetailDistributionRepository productDetailDistributionRepository = ProductDetailDistributionRepository.INSTANCE;
                                                                                        utils.currentBridgeModule().setCachedToNative(AgreementConsentViewKt$$ExternalSyntheticOutline0.m(MeasureConst.SLI_TYPE_DISTRIBUTION, goodsCenterProductViewModel16.productInfo.saasProductId), "{}", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository$cleanProductInfoCache$1
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
                                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.2.1.3
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.2.1.3.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ceVar2.text("\u52a0\u6a71\u7a97");
                                                                                        ceVar2.color(h.INSTANCE.m());
                                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                        ceVar2.fontFamily("PingFangSC-SemiBold");
                                                                                        ceVar2.fontWeightBold();
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
                                                        ConditionViewKt.a(vVar6, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar7) {
                                                                        v vVar8 = vVar7;
                                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.3.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                h hVar;
                                                                                h hVar2;
                                                                                t tVar2 = tVar;
                                                                                tVar2.mo153width(58.0f);
                                                                                tVar2.mo141height(28.0f);
                                                                                tVar2.justifyContentCenter();
                                                                                tVar2.alignItemsCenter();
                                                                                tVar2.borderRadius(3.0f);
                                                                                tVar2.marginRight(16.0f);
                                                                                Direction direction = Direction.TO_RIGHT;
                                                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient01_disable", false);
                                                                                hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient02_disable", false);
                                                                                tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.3.1.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView.body.1.1.3.3.3.3.3.1.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ceVar2.text("\u5df2\u6dfb\u52a0");
                                                                                        ceVar2.color(h.INSTANCE.m());
                                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                        ceVar2.fontFamily("PingFangSC-SemiBold");
                                                                                        ceVar2.fontWeightBold();
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
        return new GoodsCenterCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }
}
