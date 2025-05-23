package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
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
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPortraitSearchItemCard extends ComposeView<QPPromoteReceiverSearchItemCardAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPPromoteReceiverSearchItemCardAttr access$getAttr(QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard) {
        return (QPPromoteReceiverSearchItemCardAttr) qPPromoteReceiverPortraitSearchItemCard.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard = QPPromoteReceiverPortraitSearchItemCard.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final String str;
                        v vVar2 = vVar;
                        final QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard2 = QPPromoteReceiverPortraitSearchItemCard.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentSpaceBetween();
                                FlexNode flexNode = QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getFlexNode();
                                tVar2.mo153width(flexNode != null ? flexNode.U() : 0.0f);
                                tVar2.alignItemsCenter();
                                tVar2.mo141height(56.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard3 = QPPromoteReceiverPortraitSearchItemCard.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard4 = QPPromoteReceiverPortraitSearchItemCard.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getViewModel().onSwitchItemStatus(QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getItem());
                                        QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getViewModel().onEndSearch(true);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard4 = QPPromoteReceiverPortraitSearchItemCard.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.justifyContentFlexStart();
                                        tVar2.mo141height(56.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard5 = QPPromoteReceiverPortraitSearchItemCard.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard6 = QPPromoteReceiverPortraitSearchItemCard.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(40.0f, 40.0f);
                                                if (QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getItem().icon.length() > 0) {
                                                    ImageAttrExtKt.srcUrl(afVar2, QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getItem().icon, null);
                                                } else if (QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getItem().groupType == 1) {
                                                    ImageAttrExtKt.srcUrl(afVar2, QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).groupDefaultAvatar, null);
                                                } else {
                                                    ImageAttrExtKt.srcUrl(afVar2, QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).userDefaultAvatar, null);
                                                }
                                                afVar2.borderRadius(20.0f);
                                                afVar2.marginLeft(16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard6 = QPPromoteReceiverPortraitSearchItemCard.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard7 = QPPromoteReceiverPortraitSearchItemCard.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(12.0f);
                                                ceVar2.textAlignCenter();
                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                ceVar2.text(QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getItem().name);
                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getItem().groupType != 0) {
                            if (QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getViewModel().hasSelectedItem(QPPromoteReceiverPortraitSearchItemCard.access$getAttr(QPPromoteReceiverPortraitSearchItemCard.this).getItem())) {
                                str = "\u5df2\u9009\u62e9";
                            } else {
                                str = "\u7fa4\u804a";
                            }
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final String str2 = str;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard.body.1.1.4.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.textAlignRight();
                                            ceVar2.marginRight(16.0f);
                                            ceVar2.text(str2);
                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                            AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
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
        return new QPPromoteReceiverSearchItemCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
