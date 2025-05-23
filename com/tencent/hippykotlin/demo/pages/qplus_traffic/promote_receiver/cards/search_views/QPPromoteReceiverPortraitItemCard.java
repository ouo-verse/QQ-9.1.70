package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
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

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPortraitItemCard extends ComposeView<QPPromoteReceiverSearchItemCardAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPPromoteReceiverSearchItemCardAttr access$getAttr(QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard) {
        return (QPPromoteReceiverSearchItemCardAttr) qPPromoteReceiverPortraitItemCard.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard = QPPromoteReceiverPortraitItemCard.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard2 = QPPromoteReceiverPortraitItemCard.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexStart();
                                FlexNode flexNode = QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getFlexNode();
                                tVar2.mo153width(flexNode != null ? flexNode.U() : 0.0f);
                                tVar2.alignItemsCenter();
                                tVar2.mo141height(56.0f);
                                tVar2.marginLeft(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard3 = QPPromoteReceiverPortraitItemCard.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard4 = QPPromoteReceiverPortraitItemCard.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getViewModel().onSwitchItemStatus(QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getItem());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard4 = QPPromoteReceiverPortraitItemCard.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getViewModel().getSelectedList();
                            }
                        };
                        final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard5 = QPPromoteReceiverPortraitItemCard.this;
                        BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard6 = QPPromoteReceiverPortraitItemCard.this;
                                ah.a(bindDirectivesView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard7 = QPPromoteReceiverPortraitItemCard.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                if (QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getViewModel().hasSelectedItem(QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getItem())) {
                                                    b.a.b(afVar2, "qecommerce_skin_checkbox_general_selected_qq", false, 2, null);
                                                } else {
                                                    b.a.b(afVar2, "qecommerce_skin_checkbox_general_normal", false, 2, null);
                                                }
                                                afVar2.borderRadius(12.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard6 = QPPromoteReceiverPortraitItemCard.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard7 = QPPromoteReceiverPortraitItemCard.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(40.0f, 40.0f);
                                        if (QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getItem().icon.length() > 0) {
                                            ImageAttrExtKt.srcUrl(afVar2, QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getItem().icon, null);
                                        } else if (QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getItem().groupType == 1) {
                                            ImageAttrExtKt.srcUrl(afVar2, QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).groupDefaultAvatar, null);
                                        } else {
                                            ImageAttrExtKt.srcUrl(afVar2, QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).userDefaultAvatar, null);
                                        }
                                        afVar2.borderRadius(20.0f);
                                        afVar2.marginLeft(8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard7 = QPPromoteReceiverPortraitItemCard.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard8 = QPPromoteReceiverPortraitItemCard.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard.body.1.1.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(12.0f);
                                        ceVar2.textAlignCenter();
                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                        ceVar2.text(QPPromoteReceiverPortraitItemCard.access$getAttr(QPPromoteReceiverPortraitItemCard.this).getItem().name);
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
        return new QPPromoteReceiverSearchItemCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
