package com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.n;
import com.tencent.kuikly.core.views.o;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class YiFanShangDetailBottomButtonView extends ComposeView<YiFanShangDetailBottomButtonAttr, YiFanShangDetailBottomButtonEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ YiFanShangDetailBottomButtonAttr access$getAttr(YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView) {
        return (YiFanShangDetailBottomButtonAttr) yiFanShangDetailBottomButtonView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ YiFanShangDetailBottomButtonEvent access$getEvent(YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView) {
        return (YiFanShangDetailBottomButtonEvent) yiFanShangDetailBottomButtonView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView = YiFanShangDetailBottomButtonView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        float to375;
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getBottomButtonMode() == ButtonMode.WITH_TOP_BAR) {
                            to375 = BlindBoxProductDetailBottomBarForYiFanShang.bottomBarHeight$delegate.getValue().floatValue();
                        } else {
                            to375 = FloatExtKt.getTo375(93.0f);
                        }
                        mVar2.mo141height(to375);
                        Attr.absolutePosition$default(mVar2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                        return Unit.INSTANCE;
                    }
                });
                final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView2 = YiFanShangDetailBottomButtonView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getBottomButtonMode();
                    }
                };
                final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView3 = YiFanShangDetailBottomButtonView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        int ordinal = YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getBottomButtonMode().ordinal();
                        if (ordinal == 1 || ordinal == 2) {
                            if (bindDirectivesView2.getPager().getPageData().getIsIOS()) {
                                o.a(bindDirectivesView2, new Function1<n, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(n nVar) {
                                        nVar.attr(new Function1<com.tencent.kuikly.core.views.m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.m mVar) {
                                                com.tencent.kuikly.core.views.m mVar2 = mVar;
                                                mVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                mVar2.i(5.0f);
                                                mVar2.m137borderRadius(new f(16.0f, 16.0f, 0.0f, 0.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView4 = YiFanShangDetailBottomButtonView.this;
                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.flexDirectionColumn();
                                            tVar2.mo153width(tVar2.getPagerData().m());
                                            tVar2.m140flex(1.0f);
                                            if (tVar2.getPager().getPageData().getIsIOS()) {
                                                tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(255, 255, 255, 0.5f), 0.0f), new j(new h(233, 239, 255, 1.0f), 1.0f));
                                            } else {
                                                tVar2.mo113backgroundColor(new h(233, 239, 255, 1.0f));
                                            }
                                            tVar2.m137borderRadius(new f(16.0f, 16.0f, 0.0f, 0.0f));
                                            tVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getBottomButtonMode() == ButtonMode.WITH_TOP_BAR) {
                                        final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView5 = YiFanShangDetailBottomButtonView.this;
                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.mo153width(tVar2.getPagerData().m());
                                                        tVar2.marginTop(FloatExtKt.getTo375(8.0f));
                                                        a.C5863a.a(tVar2, 0.0f, FloatExtKt.getTo375(16.0f), 0.0f, FloatExtKt.getTo375(16.0f), 5, null);
                                                        tVar2.alignItemsCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView6 = YiFanShangDetailBottomButtonView.this;
                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView7 = YiFanShangDetailBottomButtonView.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                YiFanShangDetailBottomButtonAttr access$getAttr = YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this);
                                                                b.a.b(afVar2, (String) access$getAttr.cover$delegate.getValue(access$getAttr, YiFanShangDetailBottomButtonAttr.$$delegatedProperties[5]), false, 2, null);
                                                                afVar2.size(FloatExtKt.getTo375(49.0f), FloatExtKt.getTo375(32.0f));
                                                                afVar2.borderRadius(FloatExtKt.getTo375(2.0f));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView7 = YiFanShangDetailBottomButtonView.this;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView8 = YiFanShangDetailBottomButtonView.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                YiFanShangDetailBottomButtonAttr access$getAttr = YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this);
                                                                ceVar2.text((String) access$getAttr.title$delegate.getValue(access$getAttr, YiFanShangDetailBottomButtonAttr.$$delegatedProperties[6]));
                                                                ceVar2.fontWeight500();
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.color(new h(4281884306L));
                                                                ceVar2.lines(1);
                                                                ceVar2.m140flex(1.0f);
                                                                ceVar2.textOverFlowTail();
                                                                ceVar2.marginLeft(FloatExtKt.getTo375(8.0f));
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
                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView6 = YiFanShangDetailBottomButtonView.this;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView7 = YiFanShangDetailBottomButtonView.this;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.m140flex(1.0f);
                                                    tVar2.mo153width(tVar2.getPagerData().m());
                                                    tVar2.mo141height(FloatExtKt.getTo375(102.0f));
                                                    tVar2.flexDirectionRow();
                                                    if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getBottomButtonMode() == ButtonMode.NO_TOP_BAR) {
                                                        tVar2.marginTop(FloatExtKt.getTo375(4.0f));
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView8 = YiFanShangDetailBottomButtonView.this;
                                            Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.2
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getFirstButton();
                                                }
                                            };
                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView9 = YiFanShangDetailBottomButtonView.this;
                                            BindDirectivesViewKt.a(vVar4, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(BindDirectivesView bindDirectivesView3) {
                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView10 = YiFanShangDetailBottomButtonView.this;
                                                    w.a(bindDirectivesView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            v vVar6 = vVar5;
                                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    Attr.absolutePosition$default(tVar2, 0.0f, FloatExtKt.getTo375(10.0f), FloatExtKt.getTo375(16.0f), 0.0f, 9, null);
                                                                    tVar2.mo153width(FloatExtKt.getTo375(90.0f));
                                                                    tVar2.mo141height(FloatExtKt.getTo375(68.0f));
                                                                    tVar2.alignItemsCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView11 = YiFanShangDetailBottomButtonView.this;
                                                            vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView12 = YiFanShangDetailBottomButtonView.this;
                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getFirstButton().isActive) {
                                                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(YiFanShangDetailBottomButtonView.this);
                                                                                YiFanShangDetailBottomButtonAttr access$getAttr = YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this);
                                                                                BridgeModule.openPage$default(bridgeModule, (String) access$getAttr.firstJumpUrl$delegate.getValue(access$getAttr, YiFanShangDetailBottomButtonAttr.$$delegatedProperties[7]), false, null, null, 30);
                                                                                Function0<Unit> function03 = YiFanShangDetailBottomButtonView.access$getEvent(YiFanShangDetailBottomButtonView.this).onFirstBtnClick;
                                                                                if (function03 != null) {
                                                                                    function03.invoke();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView12 = YiFanShangDetailBottomButtonView.this;
                                                            ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView13 = YiFanShangDetailBottomButtonView.this;
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            String str;
                                                                            af afVar2 = afVar;
                                                                            afVar2.absolutePositionAllZero();
                                                                            if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getFirstButton().isActive) {
                                                                                str = "qecommerce_yifanshang_btn_blue_small1_normal";
                                                                            } else {
                                                                                str = "qecommerce_yifanshang_btn_blue_small1_disable";
                                                                            }
                                                                            ImageAttrExtKt.urlToken$default(afVar2, str);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView13 = YiFanShangDetailBottomButtonView.this;
                                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar7) {
                                                                    v vVar8 = vVar7;
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView14 = YiFanShangDetailBottomButtonView.this;
                                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.m140flex(1.0f);
                                                                            tVar2.alignItemsCenter();
                                                                            tVar2.marginTop(FloatExtKt.getTo375(YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getFirstButton().isActive ? 8.0f : 18.0f));
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView15 = YiFanShangDetailBottomButtonView.this;
                                                                    cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView16 = YiFanShangDetailBottomButtonView.this;
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.text(YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getFirstButton().text);
                                                                                    ce.fontSize$default(ceVar2, FloatExtKt.getTo375(20.0f), null, 2, null);
                                                                                    ceVar2.fontFamily("FZRuiZhengHeiS-EB-GB");
                                                                                    ceVar2.color(h.INSTANCE.m());
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getFirstButton().isActive) {
                                                                        final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView16 = YiFanShangDetailBottomButtonView.this;
                                                                        w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar9) {
                                                                                v vVar10 = vVar9;
                                                                                vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4.3.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.flexDirectionRow();
                                                                                        tVar2.allCenter();
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getFirstButton().isDiscountPrice) {
                                                                                    cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4.3.2
                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(TextView textView) {
                                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4.3.2.1
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ce ceVar) {
                                                                                                    float to375;
                                                                                                    ce ceVar2 = ceVar;
                                                                                                    if (ceVar2.getPagerData().getIsIOS()) {
                                                                                                        to375 = -FloatExtKt.getTo375(2.0f);
                                                                                                    } else {
                                                                                                        to375 = FloatExtKt.getTo375(1.0f);
                                                                                                    }
                                                                                                    ceVar2.marginTop(to375);
                                                                                                    ceVar2.marginRight(FloatExtKt.getTo375(2.0f));
                                                                                                    ceVar2.color(h.INSTANCE.m());
                                                                                                    ce.fontSize$default(ceVar2, FloatExtKt.getTo375(10.0f), null, 2, null);
                                                                                                    ceVar2.fontFamily("PingFang SC");
                                                                                                    ceVar2.text("\u5238\u540e");
                                                                                                    ceVar2.fontWeight400();
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                }
                                                                                final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView17 = YiFanShangDetailBottomButtonView.this;
                                                                                cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4.3.3
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView18 = YiFanShangDetailBottomButtonView.this;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.3.1.4.3.3.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ceVar2.marginTop(FloatExtKt.getTo375(2.0f));
                                                                                                ceVar2.color(h.INSTANCE.m());
                                                                                                ce.fontSize$default(ceVar2, FloatExtKt.getTo375(11.0f), null, 2, null);
                                                                                                ceVar2.fontFamily("Qvideo Digit");
                                                                                                ceVar2.text('\u00a5' + YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getFirstButton().price);
                                                                                                ceVar2.fontWeight700();
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
                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView10 = YiFanShangDetailBottomButtonView.this;
                                            Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.4
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getSecondButton();
                                                }
                                            };
                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView11 = YiFanShangDetailBottomButtonView.this;
                                            BindDirectivesViewKt.a(vVar4, function03, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(BindDirectivesView bindDirectivesView3) {
                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView12 = YiFanShangDetailBottomButtonView.this;
                                                    w.a(bindDirectivesView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            v vVar6 = vVar5;
                                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    Attr.absolutePosition$default(tVar2, 0.0f, FloatExtKt.getTo375(100.0f), FloatExtKt.getTo375(16.0f), 0.0f, 9, null);
                                                                    tVar2.mo153width(FloatExtKt.getTo375(90.0f));
                                                                    tVar2.mo141height(FloatExtKt.getTo375(68.0f));
                                                                    tVar2.alignItemsCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView13 = YiFanShangDetailBottomButtonView.this;
                                                            vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView14 = YiFanShangDetailBottomButtonView.this;
                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getSecondButton().isActive) {
                                                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(YiFanShangDetailBottomButtonView.this);
                                                                                YiFanShangDetailBottomButtonAttr access$getAttr = YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this);
                                                                                BridgeModule.openPage$default(bridgeModule, (String) access$getAttr.secondJumpUrl$delegate.getValue(access$getAttr, YiFanShangDetailBottomButtonAttr.$$delegatedProperties[8]), false, null, null, 30);
                                                                                Function0<Unit> function04 = YiFanShangDetailBottomButtonView.access$getEvent(YiFanShangDetailBottomButtonView.this).onSecondBtnClick;
                                                                                if (function04 != null) {
                                                                                    function04.invoke();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView14 = YiFanShangDetailBottomButtonView.this;
                                                            ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView15 = YiFanShangDetailBottomButtonView.this;
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            String str;
                                                                            af afVar2 = afVar;
                                                                            afVar2.absolutePositionAllZero();
                                                                            if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getSecondButton().isActive) {
                                                                                str = "qecommerce_yifanshang_btn_blue_small2_normal";
                                                                            } else {
                                                                                str = "qecommerce_yifanshang_btn_blue_small2_disable";
                                                                            }
                                                                            ImageAttrExtKt.urlToken$default(afVar2, str);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView15 = YiFanShangDetailBottomButtonView.this;
                                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar7) {
                                                                    v vVar8 = vVar7;
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView16 = YiFanShangDetailBottomButtonView.this;
                                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.m140flex(1.0f);
                                                                            tVar2.alignItemsCenter();
                                                                            tVar2.marginTop(FloatExtKt.getTo375(YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getSecondButton().isActive ? 8.0f : 18.0f));
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView17 = YiFanShangDetailBottomButtonView.this;
                                                                    cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView18 = YiFanShangDetailBottomButtonView.this;
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.text(YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getSecondButton().text);
                                                                                    ce.fontSize$default(ceVar2, FloatExtKt.getTo375(20.0f), null, 2, null);
                                                                                    ceVar2.fontFamily("FZRuiZhengHeiS-EB-GB");
                                                                                    ceVar2.color(h.INSTANCE.m());
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getSecondButton().isActive) {
                                                                        final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView18 = YiFanShangDetailBottomButtonView.this;
                                                                        w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar9) {
                                                                                v vVar10 = vVar9;
                                                                                vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4.3.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.flexDirectionRow();
                                                                                        tVar2.allCenter();
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getSecondButton().isDiscountPrice) {
                                                                                    cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4.3.2
                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(TextView textView) {
                                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4.3.2.1
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ce ceVar) {
                                                                                                    float to375;
                                                                                                    ce ceVar2 = ceVar;
                                                                                                    if (ceVar2.getPagerData().getIsIOS()) {
                                                                                                        to375 = -FloatExtKt.getTo375(2.0f);
                                                                                                    } else {
                                                                                                        to375 = FloatExtKt.getTo375(1.0f);
                                                                                                    }
                                                                                                    ceVar2.marginTop(to375);
                                                                                                    ceVar2.marginRight(FloatExtKt.getTo375(2.0f));
                                                                                                    ceVar2.color(h.INSTANCE.m());
                                                                                                    ce.fontSize$default(ceVar2, FloatExtKt.getTo375(10.0f), null, 2, null);
                                                                                                    ceVar2.fontFamily("PingFang SC");
                                                                                                    ceVar2.text("\u5238\u540e");
                                                                                                    ceVar2.fontWeight400();
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                }
                                                                                final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView19 = YiFanShangDetailBottomButtonView.this;
                                                                                cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4.3.3
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView20 = YiFanShangDetailBottomButtonView.this;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.5.1.4.3.3.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ceVar2.marginTop(FloatExtKt.getTo375(2.0f));
                                                                                                ceVar2.color(h.INSTANCE.m());
                                                                                                ce.fontSize$default(ceVar2, FloatExtKt.getTo375(11.0f), null, 2, null);
                                                                                                ceVar2.fontFamily("Qvideo Digit");
                                                                                                ceVar2.text('\u00a5' + YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getSecondButton().price);
                                                                                                ceVar2.fontWeight700();
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
                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView12 = YiFanShangDetailBottomButtonView.this;
                                            Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.6
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getThirdButton();
                                                }
                                            };
                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView13 = YiFanShangDetailBottomButtonView.this;
                                            BindDirectivesViewKt.a(vVar4, function04, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(BindDirectivesView bindDirectivesView3) {
                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView14 = YiFanShangDetailBottomButtonView.this;
                                                    w.a(bindDirectivesView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            v vVar6 = vVar5;
                                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, FloatExtKt.getTo375(16.0f), FloatExtKt.getTo375(10.0f), 3, null);
                                                                    tVar2.mo153width(FloatExtKt.getTo375(171.0f));
                                                                    tVar2.mo141height(FloatExtKt.getTo375(67.0f));
                                                                    tVar2.alignItemsCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView15 = YiFanShangDetailBottomButtonView.this;
                                                            vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView16 = YiFanShangDetailBottomButtonView.this;
                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getThirdButton().isActive) {
                                                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(YiFanShangDetailBottomButtonView.this);
                                                                                YiFanShangDetailBottomButtonAttr access$getAttr = YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this);
                                                                                BridgeModule.openPage$default(bridgeModule, (String) access$getAttr.thirdJumpUrl$delegate.getValue(access$getAttr, YiFanShangDetailBottomButtonAttr.$$delegatedProperties[9]), false, null, null, 30);
                                                                                Function0<Unit> function05 = YiFanShangDetailBottomButtonView.access$getEvent(YiFanShangDetailBottomButtonView.this).onThirdBtnClick;
                                                                                if (function05 != null) {
                                                                                    function05.invoke();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView16 = YiFanShangDetailBottomButtonView.this;
                                                            ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView17 = YiFanShangDetailBottomButtonView.this;
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            String str;
                                                                            af afVar2 = afVar;
                                                                            afVar2.absolutePositionAllZero();
                                                                            if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getThirdButton().isActive) {
                                                                                str = "qecommerce_yifanshang_btn_red_medium_normal";
                                                                            } else {
                                                                                str = "qecommerce_yifanshang_btn_red_medium_disable";
                                                                            }
                                                                            ImageAttrExtKt.urlToken$default(afVar2, str);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView17 = YiFanShangDetailBottomButtonView.this;
                                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar7) {
                                                                    v vVar8 = vVar7;
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView18 = YiFanShangDetailBottomButtonView.this;
                                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.m140flex(1.0f);
                                                                            tVar2.alignItemsCenter();
                                                                            tVar2.marginTop(FloatExtKt.getTo375(YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getThirdButton().isActive ? 8.0f : 18.0f));
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView19 = YiFanShangDetailBottomButtonView.this;
                                                                    cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView20 = YiFanShangDetailBottomButtonView.this;
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.text(YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getThirdButton().text);
                                                                                    ce.fontSize$default(ceVar2, FloatExtKt.getTo375(20.0f), null, 2, null);
                                                                                    ceVar2.fontFamily("FZRuiZhengHeiS-EB-GB");
                                                                                    ceVar2.color(h.INSTANCE.m());
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getThirdButton().isActive) {
                                                                        final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView20 = YiFanShangDetailBottomButtonView.this;
                                                                        w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar9) {
                                                                                v vVar10 = vVar9;
                                                                                vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4.3.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.flexDirectionRow();
                                                                                        tVar2.allCenter();
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                if (YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getThirdButton().isDiscountPrice) {
                                                                                    cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4.3.2
                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(TextView textView) {
                                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4.3.2.1
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ce ceVar) {
                                                                                                    float to375;
                                                                                                    ce ceVar2 = ceVar;
                                                                                                    if (ceVar2.getPagerData().getIsIOS()) {
                                                                                                        to375 = -FloatExtKt.getTo375(2.0f);
                                                                                                    } else {
                                                                                                        to375 = FloatExtKt.getTo375(1.0f);
                                                                                                    }
                                                                                                    ceVar2.marginTop(to375);
                                                                                                    ceVar2.marginRight(FloatExtKt.getTo375(2.0f));
                                                                                                    ceVar2.color(h.INSTANCE.m());
                                                                                                    ce.fontSize$default(ceVar2, FloatExtKt.getTo375(10.0f), null, 2, null);
                                                                                                    ceVar2.fontFamily("PingFang SC");
                                                                                                    ceVar2.text("\u5238\u540e");
                                                                                                    ceVar2.fontWeight400();
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                }
                                                                                final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView21 = YiFanShangDetailBottomButtonView.this;
                                                                                cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4.3.3
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView22 = YiFanShangDetailBottomButtonView.this;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.2.3.7.1.4.3.3.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ceVar2.marginTop(FloatExtKt.getTo375(2.0f));
                                                                                                ceVar2.color(h.INSTANCE.m());
                                                                                                ce.fontSize$default(ceVar2, FloatExtKt.getTo375(11.0f), null, 2, null);
                                                                                                ceVar2.fontFamily("Qvideo Digit");
                                                                                                ceVar2.text('\u00a5' + YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this).getThirdButton().price);
                                                                                                ceVar2.fontWeight700();
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
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView5 = YiFanShangDetailBottomButtonView.this;
                            Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.3
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    YiFanShangDetailBottomButtonAttr access$getAttr = YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this);
                                    return Boolean.valueOf(((Boolean) access$getAttr.showLastShangTag$delegate.getValue(access$getAttr, YiFanShangDetailBottomButtonAttr.$$delegatedProperties[4])).booleanValue());
                                }
                            };
                            final YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView6 = YiFanShangDetailBottomButtonView.this;
                            BindDirectivesViewKt.a(bindDirectivesView2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(BindDirectivesView bindDirectivesView3) {
                                    BindDirectivesView bindDirectivesView4 = bindDirectivesView3;
                                    YiFanShangDetailBottomButtonAttr access$getAttr = YiFanShangDetailBottomButtonView.access$getAttr(YiFanShangDetailBottomButtonView.this);
                                    if (((Boolean) access$getAttr.showLastShangTag$delegate.getValue(access$getAttr, YiFanShangDetailBottomButtonAttr.$$delegatedProperties[4])).booleanValue()) {
                                        w.a(bindDirectivesView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.4.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo153width(FloatExtKt.getTo375(100.0f));
                                                        tVar2.mo141height(FloatExtKt.getTo375(40.0f));
                                                        tVar2.justifyContentCenter();
                                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, FloatExtKt.getTo375(74.0f), FloatExtKt.getTo375(46.0f), 3, null);
                                                        tVar2.alignItemsCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.4.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.4.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.absolutePositionAllZero();
                                                                ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_yifanshang_btn_red_tag_last");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.4.1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView.body.1.3.4.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text("\u8d60\u9001last\u8d4f!");
                                                                ce.fontSize$default(ceVar2, FloatExtKt.getTo375(12.0f), null, 2, null);
                                                                ceVar2.color(h.INSTANCE.m());
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
        return new YiFanShangDetailBottomButtonAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new YiFanShangDetailBottomButtonEvent();
    }
}
