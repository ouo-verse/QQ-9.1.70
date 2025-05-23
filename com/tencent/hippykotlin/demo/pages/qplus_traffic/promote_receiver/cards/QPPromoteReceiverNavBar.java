package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverNavBar extends IQPPromoteReceiverCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final QPPromoteReceiverViewModel viewModel = ((QPPromoteReceiverViewAttr) getAttr()).getViewModel();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel = QPPromoteReceiverViewModel.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentSpaceBetween();
                                tVar2.alignItemsCenter();
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(56.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverViewModel qPPromoteReceiverViewModel2 = QPPromoteReceiverViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                TextView textView2 = textView;
                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(16.0f);
                                        ceVar2.text("\u53d6\u6d88");
                                        ceVar2.mo141height(24.0f);
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFangSC");
                                        ceVar2.textAlignCenter();
                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel3 = QPPromoteReceiverViewModel.this;
                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextEvent textEvent) {
                                        final QPPromoteReceiverViewModel qPPromoteReceiverViewModel4 = QPPromoteReceiverViewModel.this;
                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QPPromoteReceiverViewModel.this.closePage(false);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.mo153width(235.0f);
                                        ceVar2.mo141height(24.0f);
                                        ceVar2.text("\u63a8\u5e7f\u7ed9\u8c01");
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.fontFamily(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_MEDIUM);
                                        ceVar2.textAlignCenter();
                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverViewModel qPPromoteReceiverViewModel3 = QPPromoteReceiverViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                TextView textView2 = textView;
                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginRight(16.0f);
                                        ceVar2.text("\u786e\u5b9a");
                                        ceVar2.mo141height(24.0f);
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.textAlignCenter();
                                        ceVar2.fontFamily("PingFangSC");
                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel4 = QPPromoteReceiverViewModel.this;
                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextEvent textEvent) {
                                        final QPPromoteReceiverViewModel qPPromoteReceiverViewModel5 = QPPromoteReceiverViewModel.this;
                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverNavBar.body.1.1.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QPPromoteReceiverViewModel.this.closePage(true);
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
}
