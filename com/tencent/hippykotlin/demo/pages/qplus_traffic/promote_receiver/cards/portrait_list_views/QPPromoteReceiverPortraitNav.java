package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitListItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPortraitNav extends ComposeView<QPPromoteReceiverPortraitNavAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPPromoteReceiverPortraitNavAttr access$getAttr(QPPromoteReceiverPortraitNav qPPromoteReceiverPortraitNav) {
        return (QPPromoteReceiverPortraitNavAttr) qPPromoteReceiverPortraitNav.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel = ((QPPromoteReceiverPortraitNavAttr) getAttr()).viewModel;
        if (qPPromoteReceiverPortraitPageModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qPPromoteReceiverPortraitPageModel = null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel2 = QPPromoteReceiverPortraitPageModel.this;
                final QPPromoteReceiverPortraitNav qPPromoteReceiverPortraitNav = this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPager().getPageData().getNavigationBarHeight());
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                tVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel3 = QPPromoteReceiverPortraitPageModel.this;
                        final QPPromoteReceiverPortraitNav qPPromoteReceiverPortraitNav2 = qPPromoteReceiverPortraitNav;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.padding(0.0f, 16.0f, 0.0f, 16.0f);
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.alignItemsCenter();
                                        tVar2.flexDirectionRow();
                                        tVar2.marginTop(tVar2.getPager().getPageData().getStatusBarHeight());
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel4 = QPPromoteReceiverPortraitPageModel.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(110.0f);
                                                tVar2.justifyContentFlexStart();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel5 = QPPromoteReceiverPortraitPageModel.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel6 = QPPromoteReceiverPortraitPageModel.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel7 = QPPromoteReceiverPortraitPageModel.this;
                                                        if (qPPromoteReceiverPortraitPageModel7.getSearchStatus() == 0) {
                                                            BridgeModule.closePage$default(Utils.INSTANCE.currentBridgeModule(), null, null, 3);
                                                        } else {
                                                            qPPromoteReceiverPortraitPageModel7.onEndSearch(true);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u53d6\u6d88");
                                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 17.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_primary", false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPortraitNav qPPromoteReceiverPortraitNav3 = qPPromoteReceiverPortraitNav2;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        final QPPromoteReceiverPortraitNav qPPromoteReceiverPortraitNav4 = QPPromoteReceiverPortraitNav.this;
                                        cg.a(vVar5, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final QPPromoteReceiverPortraitNav qPPromoteReceiverPortraitNav5 = QPPromoteReceiverPortraitNav.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.3.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        h hVar;
                                                        ce ceVar2 = ceVar;
                                                        QPPromoteReceiverPortraitNavAttr access$getAttr = QPPromoteReceiverPortraitNav.access$getAttr(QPPromoteReceiverPortraitNav.this);
                                                        ceVar2.text((String) access$getAttr.titleText$delegate.getValue(access$getAttr, QPPromoteReceiverPortraitNavAttr.$$delegatedProperties[0]));
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.fontWeightMedium();
                                                        ceVar2.fontFamily(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_MEDIUM);
                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                        ceVar2.color(hVar);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel5 = QPPromoteReceiverPortraitPageModel.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(29.0f);
                                                tVar2.mo153width(110.0f);
                                                tVar2.justifyContentFlexEnd();
                                                tVar2.alignItemsCenter();
                                                tVar2.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel6 = QPPromoteReceiverPortraitPageModel.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel7 = QPPromoteReceiverPortraitPageModel.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel8 = QPPromoteReceiverPortraitPageModel.this;
                                                        if (qPPromoteReceiverPortraitPageModel8.getSelectedList().size() != 0) {
                                                            b k3 = c.f117352a.k(BridgeManager.f117344a.u());
                                                            e eVar = new e();
                                                            String str = qPPromoteReceiverPortraitPageModel8.dataParam;
                                                            com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                                            Iterator<QPPromoteReceiverPortraitListItem> it = qPPromoteReceiverPortraitPageModel8.getSelectedList().iterator();
                                                            while (it.hasNext()) {
                                                                bVar.t(it.next().encode());
                                                            }
                                                            Unit unit = Unit.INSTANCE;
                                                            eVar.v(str, bVar);
                                                            IPagerIdKtxKt.callbackResult(k3, eVar);
                                                            BridgeModule.closePage$default(Utils.INSTANCE.currentBridgeModule(), null, null, 3);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel7 = QPPromoteReceiverPortraitPageModel.this;
                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return QPPromoteReceiverPortraitPageModel.this.getSelectedList();
                                            }
                                        };
                                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel8 = QPPromoteReceiverPortraitPageModel.this;
                                        BindDirectivesViewKt.a(vVar6, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel9 = QPPromoteReceiverPortraitPageModel.this;
                                                w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel10 = QPPromoteReceiverPortraitPageModel.this;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4.4.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.borderRadius(4.0f);
                                                                tVar2.justifyContentFlexEnd();
                                                                tVar2.alignItemsCenter();
                                                                tVar2.flexDirectionRow();
                                                                tVar2.m140flex(0.0f);
                                                                if (QPPromoteReceiverPortraitPageModel.this.getSelectedList().size() > 0) {
                                                                    AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_btn_primary_blue_normal");
                                                                } else {
                                                                    AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_btn_primary_blue_disable");
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel11 = QPPromoteReceiverPortraitPageModel.this;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4.4.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel12 = QPPromoteReceiverPortraitPageModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav.body.1.1.2.4.4.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        if (QPPromoteReceiverPortraitPageModel.this.getSelectedList().size() > 0) {
                                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u786e\u5b9a(");
                                                                            m3.append(QPPromoteReceiverPortraitPageModel.this.getSelectedList().size());
                                                                            m3.append('/');
                                                                            m3.append(QPPromoteReceiverPortraitPageModel.this.selectedMaxNum);
                                                                            m3.append(')');
                                                                            ceVar2.text(m3.toString());
                                                                        } else {
                                                                            ceVar2.text("\u786e\u5b9a");
                                                                        }
                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_white_color_text_primary");
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.margin(4.0f, 16.0f, 4.0f, 16.0f);
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
        return new QPPromoteReceiverPortraitNavAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
