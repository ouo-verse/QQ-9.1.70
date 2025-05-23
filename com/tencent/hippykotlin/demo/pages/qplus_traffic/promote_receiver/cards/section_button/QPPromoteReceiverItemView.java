package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverItemView extends ComposeView<QPPromoteReceiverItemSectionViewAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPPromoteReceiverItemSectionViewAttr access$getAttr(QPPromoteReceiverItemView qPPromoteReceiverItemView) {
        return (QPPromoteReceiverItemSectionViewAttr) qPPromoteReceiverItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverItemView qPPromoteReceiverItemView = QPPromoteReceiverItemView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).sectionViewModel.getSelectItems();
                    }
                };
                final QPPromoteReceiverItemView qPPromoteReceiverItemView2 = QPPromoteReceiverItemView.this;
                BindDirectivesViewKt.a(viewContainer, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final QPPromoteReceiverItemView qPPromoteReceiverItemView3 = QPPromoteReceiverItemView.this;
                        w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final QPPromoteReceiverItemView qPPromoteReceiverItemView4 = QPPromoteReceiverItemView.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView.body.1.2.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(40.0f);
                                        tVar2.borderRadius(4.0f);
                                        if (QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).viewModel.getHasSelectCustomOption()) {
                                            if (QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).sectionViewModel.hasSelectItem(QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).getItem())) {
                                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_tag_light");
                                            } else {
                                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_tag_normal");
                                            }
                                        } else {
                                            AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_tag_normal");
                                        }
                                        tVar2.allCenter();
                                        tVar2.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverItemView qPPromoteReceiverItemView5 = QPPromoteReceiverItemView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView.body.1.2.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final QPPromoteReceiverItemView qPPromoteReceiverItemView6 = QPPromoteReceiverItemView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView.body.1.2.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                if (QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).viewModel.getHasSelectCustomOption()) {
                                                    final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).sectionViewModel;
                                                    final QPPromoteReceiverItem item = QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).getItem();
                                                    qPPromoteReceiverSectionViewModel.getClass();
                                                    Function3<? super QPPromoteReceiverSectionViewModel, ? super QPPromoteReceiverItem, ? super Function1<? super Boolean, Unit>, Unit> function3 = item.handleDataBlock;
                                                    if (function3 != null) {
                                                        function3.invoke(qPPromoteReceiverSectionViewModel, item, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSectionViewModel$onClickItem$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Boolean bool) {
                                                                if (bool.booleanValue()) {
                                                                    QPPromoteReceiverSectionViewModel.this.didClickItem(item);
                                                                }
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
                                final QPPromoteReceiverItemView qPPromoteReceiverItemView6 = QPPromoteReceiverItemView.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView.body.1.2.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final QPPromoteReceiverItemView qPPromoteReceiverItemView7 = QPPromoteReceiverItemView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView.body.1.2.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.textAlignCenter();
                                                if (QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).viewModel.getHasSelectCustomOption()) {
                                                    if (QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).sectionViewModel.hasSelectItem(QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).getItem())) {
                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_red_brand");
                                                    } else {
                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                    }
                                                } else {
                                                    AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_light");
                                                }
                                                ceVar2.text(QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).getItem().getLabelText());
                                                ceVar2.fontWeight500();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).getItem().hasArrow) {
                                    final QPPromoteReceiverItemView qPPromoteReceiverItemView7 = QPPromoteReceiverItemView.this;
                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView.body.1.2.1.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final QPPromoteReceiverItemView qPPromoteReceiverItemView8 = QPPromoteReceiverItemView.this;
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemView.body.1.2.1.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.size(16.0f, 16.0f);
                                                    if (QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).viewModel.getHasSelectCustomOption()) {
                                                        if (QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).sectionViewModel.hasSelectItem(QPPromoteReceiverItemView.access$getAttr(QPPromoteReceiverItemView.this).getItem())) {
                                                            b.a.b(afVar2, "qecommerce_icon_general_arrow_right_red", false, 2, null);
                                                        } else {
                                                            b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_primary", false, 2, null);
                                                        }
                                                    } else {
                                                        b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_secondary", false, 2, null);
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QPPromoteReceiverItemSectionViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
