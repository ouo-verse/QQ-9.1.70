package com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBar;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBarKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.NavBarAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.ticket_detail_page.TicketDetail;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class TicketDetailPage extends BasePager {

    /* renamed from: a, reason: collision with root package name */
    public TicketDetail f118521a;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        return Unit.INSTANCE;
                    }
                });
                ASDNavigationBarKt.NavBar(viewContainer2, new Function1<ASDNavigationBar, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ASDNavigationBar aSDNavigationBar) {
                        aSDNavigationBar.attr(new Function1<NavBarAttr, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NavBarAttr navBarAttr) {
                                navBarAttr.setNavTitle("\u5361\u5238\u8be6\u60c5");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TicketDetailPage ticketDetailPage = TicketDetailPage.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                h hVar;
                                ao aoVar2 = aoVar;
                                aoVar2.m140flex(1.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(aoVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                aoVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        TicketDetail ticketDetail = TicketDetailPage.this.f118521a;
                        TicketDetail ticketDetail2 = null;
                        if (ticketDetail == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("data");
                            ticketDetail = null;
                        }
                        if (ticketDetail.name.length() > 0) {
                            final TicketDetailPage ticketDetailPage2 = TicketDetailPage.this;
                            cg.a(aqVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final TicketDetailPage ticketDetailPage3 = TicketDetailPage.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            h hVar;
                                            ce ceVar2 = ceVar;
                                            ceVar2.m133alignSelf(FlexAlign.CENTER);
                                            TicketDetail ticketDetail3 = null;
                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                            ceVar2.color(hVar);
                                            ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                            ceVar2.fontFamily("PingFang SC");
                                            ceVar2.margin(32.0f, 16.0f, 24.0f, 16.0f);
                                            ceVar2.fontWeightBold();
                                            TicketDetail ticketDetail4 = TicketDetailPage.this.f118521a;
                                            if (ticketDetail4 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("data");
                                            } else {
                                                ticketDetail3 = ticketDetail4;
                                            }
                                            ceVar2.text(ticketDetail3.name);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        TicketDetail ticketDetail3 = TicketDetailPage.this.f118521a;
                        if (ticketDetail3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("data");
                            ticketDetail3 = null;
                        }
                        if (ticketDetail3.f114306id.length() > 0) {
                            final TicketDetailPage ticketDetailPage3 = TicketDetailPage.this;
                            w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.margin(8.0f, 16.0f, 8.0f, 16.0f);
                                            tVar2.flexDirection(FlexDirection.ROW);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                    ceVar2.color(hVar);
                                                    ceVar2.text("\u5361\u5238\u53f7");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    tVar.m140flex(1.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TicketDetailPage ticketDetailPage4 = TicketDetailPage.this;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final TicketDetailPage ticketDetailPage5 = TicketDetailPage.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    TicketDetail ticketDetail4 = null;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                    ceVar2.color(hVar);
                                                    ceVar2.marginRight(8.0f);
                                                    TicketDetail ticketDetail5 = TicketDetailPage.this.f118521a;
                                                    if (ticketDetail5 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("data");
                                                    } else {
                                                        ticketDetail4 = ticketDetail5;
                                                    }
                                                    ceVar2.text(ticketDetail4.f114306id);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TicketDetailPage ticketDetailPage5 = TicketDetailPage.this;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.5
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            TextView textView2 = textView;
                                            textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.5.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_link", false);
                                                    ceVar2.color(hVar);
                                                    ceVar2.text("\u590d\u5236");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final TicketDetailPage ticketDetailPage6 = TicketDetailPage.this;
                                            textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.5.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextEvent textEvent) {
                                                    final TextEvent textEvent2 = textEvent;
                                                    final TicketDetailPage ticketDetailPage7 = TicketDetailPage.this;
                                                    textEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.3.5.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(TextEvent.this);
                                                            TicketDetail ticketDetail4 = ticketDetailPage7.f118521a;
                                                            if (ticketDetail4 == null) {
                                                                Intrinsics.throwUninitializedPropertyAccessException("data");
                                                                ticketDetail4 = null;
                                                            }
                                                            bridgeModule.copyToPasteboard(ticketDetail4.f114306id);
                                                            IPagerIdKtxKt.getBridgeModule(TextEvent.this).toast("\u5361\u5238\u53f7\u5df2\u590d\u5236");
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
                        TicketDetail ticketDetail4 = TicketDetailPage.this.f118521a;
                        if (ticketDetail4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("data");
                            ticketDetail4 = null;
                        }
                        if (ticketDetail4.deadlineStr.length() > 0) {
                            final TicketDetailPage ticketDetailPage4 = TicketDetailPage.this;
                            w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.4.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.margin(8.0f, 16.0f, 8.0f, 16.0f);
                                            tVar2.flexDirection(FlexDirection.ROW);
                                            tVar2.justifyContentSpaceBetween();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.4.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.4.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                    ceVar2.color(hVar);
                                                    ceVar2.text("\u6709\u6548\u671f");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TicketDetailPage ticketDetailPage5 = TicketDetailPage.this;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.4.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final TicketDetailPage ticketDetailPage6 = TicketDetailPage.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.4.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    TicketDetail ticketDetail5 = null;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                    ceVar2.color(hVar);
                                                    TicketDetail ticketDetail6 = TicketDetailPage.this.f118521a;
                                                    if (ticketDetail6 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("data");
                                                    } else {
                                                        ticketDetail5 = ticketDetail6;
                                                    }
                                                    ceVar2.text(ticketDetail5.deadlineStr);
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
                        TicketDetail ticketDetail5 = TicketDetailPage.this.f118521a;
                        if (ticketDetail5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("data");
                            ticketDetail5 = null;
                        }
                        if (ticketDetail5.condition.length() > 0) {
                            final TicketDetailPage ticketDetailPage5 = TicketDetailPage.this;
                            w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.5
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.5.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.margin(8.0f, 16.0f, 8.0f, 16.0f);
                                            tVar2.flexDirection(FlexDirection.ROW);
                                            tVar2.justifyContentSpaceBetween();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.5.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.5.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                    ceVar2.color(hVar);
                                                    ceVar2.text("\u4f7f\u7528\u6761\u4ef6");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TicketDetailPage ticketDetailPage6 = TicketDetailPage.this;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.5.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final TicketDetailPage ticketDetailPage7 = TicketDetailPage.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.5.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.fontFamily("PingFang SC");
                                                    TicketDetail ticketDetail6 = null;
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                    ceVar2.color(hVar);
                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                    TicketDetail ticketDetail7 = TicketDetailPage.this.f118521a;
                                                    if (ticketDetail7 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("data");
                                                    } else {
                                                        ticketDetail6 = ticketDetail7;
                                                    }
                                                    ceVar2.text(ticketDetail6.condition);
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
                        TicketDetail ticketDetail6 = TicketDetailPage.this.f118521a;
                        if (ticketDetail6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("data");
                            ticketDetail6 = null;
                        }
                        if (ticketDetail6.contact.length() > 0) {
                            final TicketDetailPage ticketDetailPage6 = TicketDetailPage.this;
                            w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.margin(8.0f, 16.0f, 8.0f, 16.0f);
                                            tVar2.flexDirection(FlexDirection.ROW);
                                            tVar2.justifyContentSpaceBetween();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                    ceVar2.color(hVar);
                                                    ceVar2.text("\u5ba2\u670d\u7535\u8bdd");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    tVar.m140flex(1.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TicketDetailPage ticketDetailPage7 = TicketDetailPage.this;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final TicketDetailPage ticketDetailPage8 = TicketDetailPage.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    TicketDetail ticketDetail7 = null;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    ceVar2.marginRight(8.0f);
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                    ceVar2.color(hVar);
                                                    TicketDetail ticketDetail8 = TicketDetailPage.this.f118521a;
                                                    if (ticketDetail8 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("data");
                                                    } else {
                                                        ticketDetail7 = ticketDetail8;
                                                    }
                                                    ceVar2.text(ticketDetail7.contact);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TicketDetailPage ticketDetailPage8 = TicketDetailPage.this;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.5
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            TextView textView2 = textView;
                                            textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.5.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_link", false);
                                                    ceVar2.color(hVar);
                                                    ceVar2.text("\u62e8\u6253");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final TicketDetailPage ticketDetailPage9 = TicketDetailPage.this;
                                            textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.5.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextEvent textEvent) {
                                                    final TextEvent textEvent2 = textEvent;
                                                    final TicketDetailPage ticketDetailPage10 = TicketDetailPage.this;
                                                    textEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.6.5.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(TextEvent.this);
                                                            TicketDetail ticketDetail7 = ticketDetailPage10.f118521a;
                                                            if (ticketDetail7 == null) {
                                                                Intrinsics.throwUninitializedPropertyAccessException("data");
                                                                ticketDetail7 = null;
                                                            }
                                                            String str = ticketDetail7.contact;
                                                            bridgeModule.getClass();
                                                            e eVar = new e();
                                                            eVar.v(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, str);
                                                            bridgeModule.callNativeMethod("callPhone", eVar, null);
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
                        TicketDetail ticketDetail7 = TicketDetailPage.this.f118521a;
                        if (ticketDetail7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("data");
                        } else {
                            ticketDetail2 = ticketDetail7;
                        }
                        if (ticketDetail2.note.length() > 0) {
                            final TicketDetailPage ticketDetailPage7 = TicketDetailPage.this;
                            w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.7
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.7.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.margin(8.0f, 16.0f, 8.0f, 16.0f);
                                            tVar2.flexDirection(FlexDirection.ROW);
                                            tVar2.justifyContentSpaceBetween();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.7.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.7.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.fontFamily("PingFang SC");
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                    ceVar2.color(hVar);
                                                    ceVar2.text("\u9886\u53d6\u987b\u77e5");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final TicketDetailPage ticketDetailPage8 = TicketDetailPage.this;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.7.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final TicketDetailPage ticketDetailPage9 = TicketDetailPage.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage.body.1.3.7.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    h hVar;
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.fontFamily("PingFang SC");
                                                    ceVar2.textAlignRight();
                                                    TicketDetail ticketDetail8 = null;
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                    ceVar2.color(hVar);
                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                    ceVar2.mo153width(232.0f);
                                                    TicketDetail ticketDetail9 = TicketDetailPage.this.f118521a;
                                                    if (ticketDetail9 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("data");
                                                    } else {
                                                        ticketDetail8 = ticketDetail9;
                                                    }
                                                    ceVar2.text(ticketDetail8.note);
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
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        e n3 = getPagerData().n();
        this.f118521a = new TicketDetail(n3.p("name"), n3.p("id"), n3.p("deadline_str"), n3.p("condition"), n3.p("contact"), n3.p("note"));
    }
}
