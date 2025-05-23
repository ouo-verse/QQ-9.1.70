package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionWholeCardItemView extends QSearchBaseWholeCardItemView<ExpressionWholeCardItemAttr, ExpressionWholeCardItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ExpressionWholeCardItemAttr access$getAttr(ExpressionWholeCardItemView expressionWholeCardItemView) {
        return (ExpressionWholeCardItemAttr) expressionWholeCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItem(boolean z16) {
        final float m3 = (getPagerData().m() - 16) - 32;
        final float f16 = (m3 - 34) / 3;
        final float f17 = ((int) f16) % 2 == 0 ? f16 : 1 + f16;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionWholeCardItemView$buildItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ExpressionWholeCardItemView expressionWholeCardItemView = ExpressionWholeCardItemView.this;
                final float f18 = m3;
                final float f19 = f16;
                final float f26 = f17;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionWholeCardItemView$buildItem$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ExpressionWholeCardItemView expressionWholeCardItemView2 = ExpressionWholeCardItemView.this;
                        final float f27 = f18;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionWholeCardItemView.buildItem.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.paddingTop(16.0f).paddingBottom(ExpressionWholeCardItemView.access$getAttr(ExpressionWholeCardItemView.this).isLastItem() ? 16.0f : 0.0f);
                                tVar2.mo153width(f27);
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentFlexStart();
                                return Unit.INSTANCE;
                            }
                        });
                        ExpressionItemModel expressionItemModel = ExpressionWholeCardItemView.access$getAttr(ExpressionWholeCardItemView.this).data;
                        if (expressionItemModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("data");
                            expressionItemModel = null;
                        }
                        ?? r06 = expressionItemModel.itemList;
                        final ExpressionWholeCardItemView expressionWholeCardItemView3 = ExpressionWholeCardItemView.this;
                        final float f28 = f19;
                        final float f29 = f26;
                        Iterator it = r06.iterator();
                        final int i3 = 0;
                        while (it.hasNext()) {
                            Object next = it.next();
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            final ExpressionInfo expressionInfo = (ExpressionInfo) next;
                            vVar2.addChild(new ExpressionSingleItemView(), new Function1<ExpressionSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionWholeCardItemView$buildItem$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ExpressionSingleItemView expressionSingleItemView) {
                                    final ExpressionWholeCardItemView expressionWholeCardItemView4 = ExpressionWholeCardItemView.this;
                                    final int i17 = i3;
                                    final ExpressionInfo expressionInfo2 = expressionInfo;
                                    final float f36 = f28;
                                    final float f37 = f29;
                                    expressionSingleItemView.attr(new Function1<ExpressionItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionWholeCardItemView$buildItem$1$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ExpressionItemAttr expressionItemAttr) {
                                            ExpressionItemAttr expressionItemAttr2 = expressionItemAttr;
                                            expressionItemAttr2.index = (ExpressionWholeCardItemView.access$getAttr(ExpressionWholeCardItemView.this).lineIndex * 3) + i17;
                                            expressionItemAttr2.expressionInfo = expressionInfo2;
                                            expressionItemAttr2.size = new com.tencent.kuikly.core.base.w(f36, f37);
                                            expressionItemAttr2.keyword = ExpressionWholeCardItemView.access$getAttr(ExpressionWholeCardItemView.this).keyword;
                                            expressionItemAttr2.traceId = ExpressionWholeCardItemView.access$getAttr(ExpressionWholeCardItemView.this).traceId;
                                            expressionItemAttr2.tabData = ExpressionWholeCardItemView.access$getAttr(ExpressionWholeCardItemView.this).getTabData();
                                            ExpressionWholeCardItemAttr access$getAttr = ExpressionWholeCardItemView.access$getAttr(ExpressionWholeCardItemView.this);
                                            expressionItemAttr2.setPageStatus((PageStatus) access$getAttr.pageStatus$delegate.getValue(access$getAttr, ExpressionWholeCardItemAttr.$$delegatedProperties[0]));
                                            if (i17 % 3 == 1) {
                                                expressionItemAttr2.marginLeft(17.0f).marginRight(17.0f);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            i3 = i16;
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ExpressionWholeCardItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ExpressionWholeCardItemEvent();
    }
}
