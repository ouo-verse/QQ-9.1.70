package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitListItem;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ai;
import com.tencent.kuikly.core.views.am;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.layout.RowView;
import com.tencent.kuikly.core.views.layout.c;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverSearchBar extends ComposeView<QPPromoteReceiverSearchBarAttr, l> {
    public float minInputBarWidth = 80.0f;
    public float iconSize = 40.0f;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPPromoteReceiverSearchBarAttr access$getAttr(QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar) {
        return (QPPromoteReceiverSearchBarAttr) qPPromoteReceiverSearchBar.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar = QPPromoteReceiverSearchBar.this;
                final float f16 = 46.0f;
                c.b(viewContainer, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(RowView rowView) {
                        RowView rowView2 = rowView;
                        rowView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(m mVar) {
                                h hVar;
                                m mVar2 = mVar;
                                mVar2.mo153width(mVar2.getPagerData().m());
                                mVar2.mo141height(56.0f);
                                mVar2.justifyContentFlexStart();
                                mVar2.alignItemsCenter();
                                hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                mVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar2 = QPPromoteReceiverSearchBar.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().getSelectedCount());
                            }
                        };
                        final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar3 = QPPromoteReceiverSearchBar.this;
                        final float f17 = f16;
                        BindDirectivesViewKt.a(rowView2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                if (QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().getSelectedCount() == 0) {
                                    ah.a(bindDirectivesView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.size(18.0f, 18.0f);
                                                    afVar2.marginLeft(16.0f);
                                                    afVar2.marginRight(5.0f);
                                                    b.a.b(afVar2, "qecommerce_skin_icon_general_search_light", false, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar4 = QPPromoteReceiverSearchBar.this;
                                    final float f18 = f17;
                                    c.b(bindDirectivesView2, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(RowView rowView3) {
                                            RowView rowView4 = rowView3;
                                            rowView4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(m mVar) {
                                                    mVar.marginLeft(16.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar5 = QPPromoteReceiverSearchBar.this;
                                            final float f19 = f18;
                                            ar.a(rowView4, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(aq<?, ?> aqVar) {
                                                    aq<?, ?> aqVar2 = aqVar;
                                                    final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar6 = QPPromoteReceiverSearchBar.this;
                                                    final float f26 = f19;
                                                    aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ao aoVar) {
                                                            ao aoVar2 = aoVar;
                                                            aoVar2.flexDirectionRow();
                                                            aoVar2.mo153width(QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().getSelectedCount() * f26);
                                                            aoVar2.m134animation(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.3f, null, 2, null), (Object) Integer.valueOf(QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().getSelectedCount()));
                                                            aoVar2.mo141height(40.0f);
                                                            aoVar2.showScrollerIndicator(false);
                                                            aoVar2.m144maxWidth(aoVar2.getPagerData().m() - QPPromoteReceiverSearchBar.this.minInputBarWidth);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar7 = QPPromoteReceiverSearchBar.this;
                                                    Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2.2.2
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            return Integer.valueOf(QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().getSelectedCount());
                                                        }
                                                    };
                                                    final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar8 = QPPromoteReceiverSearchBar.this;
                                                    BindDirectivesViewKt.a(aqVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2.2.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(BindDirectivesView bindDirectivesView3) {
                                                            BindDirectivesView bindDirectivesView4 = bindDirectivesView3;
                                                            Iterator<QPPromoteReceiverPortraitListItem> it = QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().getSelectedList().iterator();
                                                            while (it.hasNext()) {
                                                                final QPPromoteReceiverPortraitListItem next = it.next();
                                                                final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar9 = QPPromoteReceiverSearchBar.this;
                                                                ah.a(bindDirectivesView4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2.2.3.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        ImageView imageView2 = imageView;
                                                                        final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar10 = QPPromoteReceiverSearchBar.this;
                                                                        final QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem = next;
                                                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2.2.3.1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                float f27 = QPPromoteReceiverSearchBar.this.iconSize;
                                                                                afVar2.size(f27, f27);
                                                                                afVar2.borderRadius(QPPromoteReceiverSearchBar.this.iconSize / 2);
                                                                                afVar2.marginRight(6.0f);
                                                                                if (qPPromoteReceiverPortraitListItem.icon.length() > 0) {
                                                                                    ImageAttrExtKt.srcUrl(afVar2, qPPromoteReceiverPortraitListItem.icon, null);
                                                                                } else if (qPPromoteReceiverPortraitListItem.groupType == 1) {
                                                                                    ImageAttrExtKt.srcUrl(afVar2, QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).groupDefaultAvatar, null);
                                                                                } else {
                                                                                    ImageAttrExtKt.srcUrl(afVar2, QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).userDefaultAvatar, null);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar11 = QPPromoteReceiverSearchBar.this;
                                                                        final QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem2 = next;
                                                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2.2.3.1.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageEvent imageEvent) {
                                                                                final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar12 = QPPromoteReceiverSearchBar.this;
                                                                                final QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem3 = qPPromoteReceiverPortraitListItem2;
                                                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.3.2.2.3.1.2.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().onSwitchItemStatus(qPPromoteReceiverPortraitListItem3);
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
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar4 = QPPromoteReceiverSearchBar.this;
                        final float f18 = f16;
                        am.a(rowView2, new Function1<InputView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(InputView inputView) {
                                InputView inputView2 = inputView;
                                final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar5 = QPPromoteReceiverSearchBar.this;
                                inputView2.ref(inputView2, new Function1<aa<InputView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<InputView> aaVar) {
                                        QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().searchBarInputViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar6 = QPPromoteReceiverSearchBar.this;
                                final float f19 = f18;
                                inputView2.attr(new Function1<ai, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.4.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ai aiVar) {
                                        h hVar;
                                        ai aiVar2 = aiVar;
                                        aiVar2.z();
                                        ai.m(aiVar2, 17.0f, null, 2, null);
                                        aiVar2.mo141height(24.0f);
                                        aiVar2.u("\u641c\u7d22");
                                        hVar = IPagerIdKtxKt.getSkinColor(aiVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                        aiVar2.i(hVar);
                                        aiVar2.v(IPagerIdKtxKt.getSkinColor(aiVar2).getPrimaryTextColor());
                                        if (QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().getSelectedCount() > 0) {
                                            aiVar2.mo153width(((aiVar2.getPagerData().m() - (f19 * QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().getSelectedCount())) - 16.0f) - 16.0f);
                                            aiVar2.m142left(5.0f);
                                        } else {
                                            aiVar2.mo153width(((aiVar2.getPagerData().m() - 23.0f) - 16.0f) - 16.0f);
                                            aiVar2.m142left(-1.0f);
                                        }
                                        aiVar2.m146minWidth(QPPromoteReceiverSearchBar.this.minInputBarWidth);
                                        aiVar2.marginRight(16.0f);
                                        aiVar2.m134animation(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.3f, null, 2, null), (Object) Integer.valueOf(QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().getSelectedCount()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar7 = QPPromoteReceiverSearchBar.this;
                                inputView2.event(new Function1<InputEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(InputEvent inputEvent) {
                                        InputEvent inputEvent2 = inputEvent;
                                        final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar8 = QPPromoteReceiverSearchBar.this;
                                        inputEvent2.o(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InputParams inputParams) {
                                                InputParams inputParams2 = inputParams;
                                                if (inputParams2.getText().length() > 0) {
                                                    QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().onBeginSearch(inputParams2.getText());
                                                }
                                                Utils.INSTANCE.currentBridgeModule().callNativeMethod("closeKeyboard", null, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar9 = QPPromoteReceiverSearchBar.this;
                                        InputEvent.q(inputEvent2, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar.body.1.1.4.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InputParams inputParams) {
                                                if (inputParams.getText().length() == 0) {
                                                    QPPromoteReceiverSearchBar.access$getAttr(QPPromoteReceiverSearchBar.this).getViewModel().onEndSearch(false);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, 1, null);
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
        return new QPPromoteReceiverSearchBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
