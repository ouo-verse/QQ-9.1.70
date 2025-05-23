package com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view;

import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.pager.g;
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

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BlindBoxOperationBottomBar extends ComposeView<BlindBoxOperationBottomBarAttr, BlindBoxOperationBottomBarEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final String access$assistButtonBgImageToken(BlindBoxOperationBottomBar blindBoxOperationBottomBar) {
        if (((BlindBoxOperationBottomBarAttr) blindBoxOperationBottomBar.getAttr()).secondLotteryButton != null) {
            if (((BlindBoxOperationBottomBarAttr) blindBoxOperationBottomBar.getAttr()).assistButton.enable) {
                return "qecommerce_jiguangshang_btn_blue_small_normal";
            }
        } else if (((BlindBoxOperationBottomBarAttr) blindBoxOperationBottomBar.getAttr()).assistButton.enable) {
            return "qecommerce_jiguangshang_btn_blue_small_normal";
        }
        return "qecommerce_jiguangshang_btn_blue_small_disable";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ BlindBoxOperationBottomBarAttr access$getAttr(BlindBoxOperationBottomBar blindBoxOperationBottomBar) {
        return (BlindBoxOperationBottomBarAttr) blindBoxOperationBottomBar.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final g pageData = c.f117352a.k(BridgeManager.f117344a.u()).getPageData();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final g gVar = g.this;
                final BlindBoxOperationBottomBar blindBoxOperationBottomBar = this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final g gVar2 = g.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(FloatExtKt.getTo375(68.0f));
                                tVar2.mo153width(g.this.m());
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar2 = blindBoxOperationBottomBar;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(FloatExtKt.getTo375(92.0f));
                                        tVar2.mo141height(FloatExtKt.getTo375(67.0f));
                                        tVar2.marginLeft(FloatExtKt.getTo375(12.0f));
                                        tVar2.allCenter();
                                        tVar2.mo113backgroundColor(h.INSTANCE.j());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final BlindBoxOperationBottomBar blindBoxOperationBottomBar3 = BlindBoxOperationBottomBar.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar4 = BlindBoxOperationBottomBar.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                ImageAttrExtKt.urlToken$default(afVar2, BlindBoxOperationBottomBar.access$assistButtonBgImageToken(BlindBoxOperationBottomBar.this));
                                                afVar2.absolutePositionAllZero();
                                                afVar2.q();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final BlindBoxOperationBottomBar blindBoxOperationBottomBar4 = BlindBoxOperationBottomBar.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar5 = BlindBoxOperationBottomBar.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).assistButton.text);
                                                ceVar2.color(h.INSTANCE.m());
                                                ce.fontSize$default(ceVar2, FloatExtKt.getTo375(18.0f), null, 2, null);
                                                ceVar2.fontFamily("FZRuiZhengHeiS-EB-GB");
                                                ceVar2.fontWeight400();
                                                ceVar2.fontWeightBold();
                                                ceVar2.marginTop(FloatExtKt.getTo375(-7.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final BlindBoxOperationBottomBar blindBoxOperationBottomBar5 = BlindBoxOperationBottomBar.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar6 = BlindBoxOperationBottomBar.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                if (BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).assistButton.enable) {
                                                    BlindBoxOperationBottomBar.this.emit("onAssistButtonClick", null);
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
                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar3 = blindBoxOperationBottomBar;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(FloatExtKt.getTo375(68.0f));
                                        tVar2.mo153width(FloatExtKt.getTo375(252.0f));
                                        tVar2.marginLeft(FloatExtKt.getTo375(8.0f));
                                        tVar2.marginRight(FloatExtKt.getTo375(16.0f));
                                        tVar2.m140flex(1.0f);
                                        tVar2.allCenter();
                                        tVar2.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final BlindBoxOperationBottomBar blindBoxOperationBottomBar4 = BlindBoxOperationBottomBar.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar5 = BlindBoxOperationBottomBar.this;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                float to375;
                                                t tVar2 = tVar;
                                                tVar2.mo141height(FloatExtKt.getTo375(67.0f));
                                                if (BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).secondLotteryButton != null) {
                                                    to375 = FloatExtKt.getTo375(126.0f);
                                                } else {
                                                    to375 = FloatExtKt.getTo375(252.0f);
                                                }
                                                tVar2.mo153width(to375);
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                tVar2.mo113backgroundColor(h.INSTANCE.j());
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar6 = BlindBoxOperationBottomBar.this;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final BlindBoxOperationBottomBar blindBoxOperationBottomBar7 = BlindBoxOperationBottomBar.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.absolutePositionAllZero();
                                                        afVar2.q();
                                                        if (BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).firstLotteryButton.enable) {
                                                            if (BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).secondLotteryButton != null) {
                                                                ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_jiguangshang_btn_red_medium1_normal");
                                                            } else {
                                                                ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_jiguangshang_btn_red_medium_normal");
                                                            }
                                                        } else if (BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).secondLotteryButton != null) {
                                                            ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_jiguangshang_btn_red_medium1_disable");
                                                        } else {
                                                            ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_jiguangshang_btn_red_medium_disable");
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar7 = BlindBoxOperationBottomBar.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.alignItemsCenter();
                                                        tVar2.marginTop(FloatExtKt.getTo375(10.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BlindBoxOperationBottomBar blindBoxOperationBottomBar8 = BlindBoxOperationBottomBar.this;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar9 = BlindBoxOperationBottomBar.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.color(h.INSTANCE.m());
                                                                ceVar2.fontFamily("FZRuiZhengHeiS-EB-GB");
                                                                ceVar2.text(BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).firstLotteryButton.text);
                                                                ce.fontSize$default(ceVar2, FloatExtKt.getTo375(18.0f), null, 2, null);
                                                                ceVar2.fontWeight400();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BlindBoxOperationBottomBar blindBoxOperationBottomBar9 = BlindBoxOperationBottomBar.this;
                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar9) {
                                                        v vVar10 = vVar9;
                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        if (BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).firstLotteryButton.isDiscountPrice) {
                                                            cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3.3.2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3.3.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ceVar2.marginTop(ceVar2.getPagerData().getIsIOS() ? -FloatExtKt.getTo375(3.0f) : 0.0f);
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
                                                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar10 = BlindBoxOperationBottomBar.this;
                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3.3.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final BlindBoxOperationBottomBar blindBoxOperationBottomBar11 = BlindBoxOperationBottomBar.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.3.3.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.marginTop(FloatExtKt.getTo375(1.0f));
                                                                        ceVar2.color(h.INSTANCE.m());
                                                                        ce.fontSize$default(ceVar2, FloatExtKt.getTo375(11.0f), null, 2, null);
                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                        ceVar2.text('\u00a5' + BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).firstLotteryButton.price);
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
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BlindBoxOperationBottomBar blindBoxOperationBottomBar8 = BlindBoxOperationBottomBar.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final BlindBoxOperationBottomBar blindBoxOperationBottomBar9 = BlindBoxOperationBottomBar.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.2.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        if (BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).firstLotteryButton.enable) {
                                                            BlindBoxOperationBottomBar.this.emit("onFirstLotteryButtonClick", null);
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
                                final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton = BlindBoxOperationBottomBar.access$getAttr(BlindBoxOperationBottomBar.this).secondLotteryButton;
                                if (blindBoxOperationBottomBarButton != null) {
                                    final BlindBoxOperationBottomBar blindBoxOperationBottomBar5 = BlindBoxOperationBottomBar.this;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.mo141height(FloatExtKt.getTo375(67.0f));
                                                    tVar2.mo153width(FloatExtKt.getTo375(126.0f));
                                                    Attr.absolutePosition$default(tVar2, 0.0f, FloatExtKt.getTo375(126.0f), 0.0f, 0.0f, 12, null);
                                                    tVar2.mo113backgroundColor(h.INSTANCE.j());
                                                    tVar2.allCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton2 = BlindBoxOperationBottomBarButton.this;
                                            ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton3 = BlindBoxOperationBottomBarButton.this;
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.absolutePositionAllZero();
                                                            afVar2.q();
                                                            if (BlindBoxOperationBottomBarButton.this.enable) {
                                                                ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_jiguangshang_btn_red_medium2_normal");
                                                            } else {
                                                                ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_jiguangshang_btn_red_medium2_disable");
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton3 = BlindBoxOperationBottomBarButton.this;
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    v vVar8 = vVar7;
                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.m140flex(1.0f);
                                                            tVar2.alignItemsCenter();
                                                            tVar2.marginTop(FloatExtKt.getTo375(10.0f));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton4 = BlindBoxOperationBottomBarButton.this;
                                                    cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton5 = BlindBoxOperationBottomBarButton.this;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.color(h.INSTANCE.m());
                                                                    ceVar2.fontFamily("FZRuiZhengHeiS-EB-GB");
                                                                    ceVar2.text(BlindBoxOperationBottomBarButton.this.text);
                                                                    ce.fontSize$default(ceVar2, FloatExtKt.getTo375(18.0f), null, 2, null);
                                                                    ceVar2.fontWeight400();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton5 = BlindBoxOperationBottomBarButton.this;
                                                    w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar9) {
                                                            v vVar10 = vVar9;
                                                            vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.flexDirectionRow();
                                                                    tVar2.allCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            if (BlindBoxOperationBottomBarButton.this.isDiscountPrice) {
                                                                cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3.3.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3.3.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.marginTop(ceVar2.getPagerData().getIsIOS() ? -FloatExtKt.getTo375(3.0f) : 0.0f);
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
                                                            final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton6 = BlindBoxOperationBottomBarButton.this;
                                                            cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3.3.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton7 = BlindBoxOperationBottomBarButton.this;
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.3.3.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ceVar2.marginTop(FloatExtKt.getTo375(1.0f));
                                                                            ceVar2.color(h.INSTANCE.m());
                                                                            ce.fontSize$default(ceVar2, FloatExtKt.getTo375(11.0f), null, 2, null);
                                                                            ceVar2.fontFamily("Qvideo Digit");
                                                                            ceVar2.text('\u00a5' + BlindBoxOperationBottomBarButton.this.price);
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
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton4 = BlindBoxOperationBottomBarButton.this;
                                            final BlindBoxOperationBottomBar blindBoxOperationBottomBar6 = blindBoxOperationBottomBar5;
                                            vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton5 = BlindBoxOperationBottomBarButton.this;
                                                    final BlindBoxOperationBottomBar blindBoxOperationBottomBar7 = blindBoxOperationBottomBar6;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar.body.1.1.3.3.4.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            if (BlindBoxOperationBottomBarButton.this.enable) {
                                                                BlindBoxOperationBottomBar blindBoxOperationBottomBar8 = blindBoxOperationBottomBar7;
                                                                int i3 = BlindBoxOperationBottomBar.$r8$clinit;
                                                                blindBoxOperationBottomBar8.emit("onSecondLotteryButtonClick", null);
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new BlindBoxOperationBottomBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new BlindBoxOperationBottomBarEvent();
    }
}
