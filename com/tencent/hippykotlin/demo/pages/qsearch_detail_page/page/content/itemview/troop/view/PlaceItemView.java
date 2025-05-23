package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes32.dex */
public final class PlaceItemView extends ComposeView<PlaceAttr, PlaceEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PlaceAttr access$getAttr(PlaceItemView placeItemView) {
        return (PlaceAttr) placeItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final PlaceItemView placeItemView = PlaceItemView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceItemView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final PlaceItemView placeItemView2 = PlaceItemView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceItemView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(56.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentCenter();
                                if (PlaceItemView.access$getAttr(PlaceItemView.this).isSelected()) {
                                    tVar2.mo113backgroundColor(PlaceItemView.access$getAttr(PlaceItemView.this).selectedBgColor);
                                } else {
                                    tVar2.mo113backgroundColor(PlaceItemView.access$getAttr(PlaceItemView.this).unselectedBgColor);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final PlaceItemView placeItemView3 = PlaceItemView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceItemView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final PlaceItemView placeItemView4 = PlaceItemView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceItemView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(8.0f);
                                        ceVar2.marginRight(8.0f);
                                        ceVar2.m140flex(1.0f);
                                        ceVar2.text(PlaceItemView.access$getAttr(PlaceItemView.this).text);
                                        ce.fontSize$default(ceVar2, PlaceItemView.access$getAttr(PlaceItemView.this).text.length() > 6 ? 12.0f : 14.0f, null, 2, null);
                                        ceVar2.textAlignCenter();
                                        ceVar2.textOverFlowTail();
                                        ceVar2.lines(1);
                                        if (PlaceItemView.access$getAttr(PlaceItemView.this).isSelected()) {
                                            ceVar2.fontWeightMedium();
                                            ceVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                        } else {
                                            ceVar2.fontWeightNormal();
                                            ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (PlaceItemView.access$getAttr(PlaceItemView.this).showStrip) {
                            final PlaceItemView placeItemView4 = PlaceItemView.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceItemView.body.1.1.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    final PlaceItemView placeItemView5 = PlaceItemView.this;
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceItemView.body.1.1.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.positionAbsolute();
                                            tVar2.m142left(0.0f);
                                            tVar2.m150top(0.0f);
                                            tVar2.m138bottom(0.0f);
                                            tVar2.mo153width(4.0f);
                                            if (PlaceItemView.access$getAttr(PlaceItemView.this).isSelected()) {
                                                tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                            } else {
                                                tVar2.mo113backgroundColor(h.INSTANCE.j());
                                            }
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new PlaceAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new PlaceEvent();
    }
}
