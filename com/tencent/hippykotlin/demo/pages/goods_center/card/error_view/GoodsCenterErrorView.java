package com.tencent.hippykotlin.demo.pages.goods_center.card.error_view;

import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterErrorView extends ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> {
    public final Function0<Unit> buttonAction;
    public final String msgText;

    public GoodsCenterErrorView(String str, Function0<Unit> function0) {
        this.msgText = str;
        this.buttonAction = function0;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.flexDirectionColumn();
                        mVar2.justifyContentFlexStart();
                        mVar2.alignItemsCenter();
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(200.0f, 200.0f);
                                afVar2.marginTop(30.0f);
                                ImageAttrExtKt.srcUrl(afVar2, "qecommerce_skin_emptystate_img_wuwangluo", null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterErrorView goodsCenterErrorView = GoodsCenterErrorView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final GoodsCenterErrorView goodsCenterErrorView2 = GoodsCenterErrorView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                ceVar2.marginTop(20.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                ceVar2.color(hVar);
                                ceVar2.text(GoodsCenterErrorView.this.msgText);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterErrorView goodsCenterErrorView2 = GoodsCenterErrorView.this;
                if (goodsCenterErrorView2.buttonAction != null) {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView$body$1.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView.body.1.4.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.size(78.0f, 38.0f);
                                    tVar2.marginTop(10.0f);
                                    tVar2.m137borderRadius(new f(4.0f, 4.0f, 4.0f, 4.0f));
                                    tVar2.mo139boxShadow(new g(0.0f, 0.0f, 5.0f, h.INSTANCE.b()));
                                    tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_color_btn_gradient01_normal"), 0.0f), new j(new h("qecommerce_color_btn_gradient02_normal"), 1.0f));
                                    tVar2.allCenter();
                                    return Unit.INSTANCE;
                                }
                            });
                            final GoodsCenterErrorView goodsCenterErrorView3 = GoodsCenterErrorView.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView.body.1.4.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    TextView textView2 = textView;
                                    textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView.body.1.4.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.color(h.INSTANCE.m());
                                            ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                            ceVar2.fontWeightBold();
                                            ceVar2.text("\u70b9\u51fb\u91cd\u8bd5");
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final GoodsCenterErrorView goodsCenterErrorView4 = GoodsCenterErrorView.this;
                                    textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView.body.1.4.2.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextEvent textEvent) {
                                            final GoodsCenterErrorView goodsCenterErrorView5 = GoodsCenterErrorView.this;
                                            textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView.body.1.4.2.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function0 = GoodsCenterErrorView.this.buttonAction;
                                                    if (function0 != null) {
                                                        function0.invoke();
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
                }
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView$body$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorView.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 20.0f);
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
