package com.tencent.hippykotlin.demo.pages.jubao;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.kuikly.core.views.TextAreaEvent;
import com.tencent.kuikly.core.views.TextAreaView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.cc;
import com.tencent.kuikly.core.views.cd;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoReasonAddView extends JubaoAnimationView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoReasonAddView.class, "canClick", "getCanClick()Z", 0)};
    public Function0<Unit> backClickCallback;
    public Function1<? super String, Unit> completeCallback;
    public aa<TextAreaView> inputRef;
    public Function1<? super Float, Unit> keyboardHeightChangeCallBack;
    public final PageModel pageModel;
    public final ReadWriteProperty canClick$delegate = c.a(Boolean.FALSE);
    public String reasonText = "";

    public JubaoReasonAddView(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        JubaoAnimationView$body$1 jubaoAnimationView$body$1 = new JubaoAnimationView$body$1(this);
        attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(k kVar) {
                k kVar2 = kVar;
                kVar2.flexDirectionColumn();
                kVar2.paddingTop(6.0f);
                return Unit.INSTANCE;
            }
        });
        w.a(this, JubaoUtil$O3BgView$1.INSTANCE);
        JubaoNavBarKt.JubaoNavBar(this, new Function1<JubaoNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(JubaoNavBar jubaoNavBar) {
                JubaoNavBar jubaoNavBar2 = jubaoNavBar;
                jubaoNavBar2.setBarData(new NavBarData("\u4e3e\u62a5\u539f\u56e0", true, false));
                final JubaoReasonAddView jubaoReasonAddView = JubaoReasonAddView.this;
                jubaoNavBar2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function0<Unit> function0 = JubaoReasonAddView.this.backClickCallback;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                return Unit.INSTANCE;
            }
        });
        w.a(this, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                final JubaoReasonAddView jubaoReasonAddView = JubaoReasonAddView.this;
                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(u uVar) {
                        final JubaoReasonAddView jubaoReasonAddView2 = JubaoReasonAddView.this;
                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.3.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                aa<TextAreaView> aaVar = JubaoReasonAddView.this.inputRef;
                                if (aaVar == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("inputRef");
                                    aaVar = null;
                                }
                                TextAreaView b16 = aaVar.b();
                                if (b16 != null) {
                                    b16.h();
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$3.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.3.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.text("\u5982\u679c\u4e3e\u62a5\u5bf9\u8c61\u5c5e\u4e8e\u5176\u4ed6\u8fdd\u89c4\u539f\u56e0\uff0c\u53ef\u4ee5\u586b\u5199\u8be6\u7ec6\u60c5\u51b5\u4ee5\u4fbf\u5b89\u5168\u4e2d\u5fc3\u5ba1\u6838\u3002");
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                ceVar2.marginLeft(16.0f);
                                ceVar2.marginRight(16.0f);
                                ceVar2.marginTop(16.0f);
                                ceVar2.fontWeight400();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$3.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.3.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.mo141height(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(this, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$4.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo141height(197.0f);
                        tVar2.marginLeft(16.0f);
                        tVar2.marginRight(16.0f);
                        tVar2.borderRadius(8.0f);
                        tVar2.justifyContentFlexEnd();
                        tVar2.alignItemsFlexEnd();
                        tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getFillStandardBrand());
                        return Unit.INSTANCE;
                    }
                });
                final JubaoReasonAddView jubaoReasonAddView = JubaoReasonAddView.this;
                cd.a(vVar2, new Function1<TextAreaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$4.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextAreaView textAreaView) {
                        TextAreaView textAreaView2 = textAreaView;
                        final JubaoReasonAddView jubaoReasonAddView2 = JubaoReasonAddView.this;
                        textAreaView2.ref(textAreaView2, new Function1<aa<TextAreaView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.4.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<TextAreaView> aaVar) {
                                JubaoReasonAddView.this.inputRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        textAreaView2.attr(new Function1<cc, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.4.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cc ccVar) {
                                h hVar;
                                cc ccVar2 = ccVar;
                                ccVar2.absolutePosition(16.0f, 16.0f, 16.0f, 16.0f);
                                ccVar2.w("\u8f93\u5165\u6587\u672c");
                                JubaoThemeData jubaoThemeData = JubaoThemeData.INSTANCE;
                                if (!VasUIToken.INSTANCE.isDarkMode()) {
                                    hVar = new h(4291611852L);
                                } else {
                                    hVar = new h(4284309089L);
                                }
                                ccVar2.x(hVar);
                                cc.m(ccVar2, 17.0f, null, 2, null);
                                ccVar2.i(jubaoThemeData.getItemViewTextColor());
                                ccVar2.v(100);
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoReasonAddView jubaoReasonAddView3 = JubaoReasonAddView.this;
                        textAreaView2.event(new Function1<TextAreaEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.4.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextAreaEvent textAreaEvent) {
                                TextAreaEvent textAreaEvent2 = textAreaEvent;
                                final JubaoReasonAddView jubaoReasonAddView4 = JubaoReasonAddView.this;
                                TextAreaEvent.o(textAreaEvent2, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.4.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(InputParams inputParams) {
                                        InputParams inputParams2 = inputParams;
                                        JubaoReasonAddView.this.reasonText = inputParams2.getText();
                                        JubaoReasonAddView jubaoReasonAddView5 = JubaoReasonAddView.this;
                                        jubaoReasonAddView5.canClick$delegate.setValue(jubaoReasonAddView5, JubaoReasonAddView.$$delegatedProperties[0], Boolean.valueOf(inputParams2.getText().length() > 0));
                                        return Unit.INSTANCE;
                                    }
                                }, 1, null);
                                if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(com.tencent.kuikly.core.manager.c.f117352a)) {
                                    final JubaoReasonAddView jubaoReasonAddView5 = JubaoReasonAddView.this;
                                    TextAreaEvent.k(textAreaEvent2, false, new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.4.2.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(KeyboardParams keyboardParams) {
                                            KeyboardParams keyboardParams2 = keyboardParams;
                                            Function1<? super Float, Unit> function1 = JubaoReasonAddView.this.keyboardHeightChangeCallBack;
                                            if (function1 != null) {
                                                function1.invoke(Float.valueOf(keyboardParams2.getHeight()));
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, 1, null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$4.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.4.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginRight(16.0f);
                                ceVar2.marginBottom(16.0f);
                                ceVar2.fontWeight400();
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                ceVar2.text("100\u5b57");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(this, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$5.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionRow();
                        tVar2.absolutePosition(0.0f, 0.0f, 50.0f, 0.0f);
                        tVar2.alignItemsFlexEnd();
                        tVar2.justifyContentCenter();
                        return Unit.INSTANCE;
                    }
                });
                final JubaoReasonAddView jubaoReasonAddView = JubaoReasonAddView.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$5.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        final JubaoReasonAddView jubaoReasonAddView2 = JubaoReasonAddView.this;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(45.0f);
                                tVar2.mo153width(129.0f);
                                tVar2.borderRadius(4.0f);
                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, JubaoThemeData.INSTANCE.getButtonBorderSecondaryDefault()));
                                tVar2.allCenter();
                                EcommerceExtKt.elementVR(tVar2, "em_safe_skip", JubaoReasonAddView.this.pageModel.getDTParams());
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoReasonAddView jubaoReasonAddView3 = JubaoReasonAddView.this;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final JubaoReasonAddView jubaoReasonAddView4 = JubaoReasonAddView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Function1<? super String, Unit> function1 = JubaoReasonAddView.this.completeCallback;
                                        if (function1 != null) {
                                            function1.invoke("");
                                        }
                                        aa<TextAreaView> aaVar = JubaoReasonAddView.this.inputRef;
                                        if (aaVar == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("inputRef");
                                            aaVar = null;
                                        }
                                        TextAreaView b16 = aaVar.b();
                                        if (b16 != null) {
                                            b16.h();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u8df3\u8fc7");
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        ceVar2.color(JubaoThemeData.INSTANCE.getButtonTextSecondaryDefault());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoReasonAddView jubaoReasonAddView2 = JubaoReasonAddView.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView$body$1$5.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        final JubaoReasonAddView jubaoReasonAddView3 = JubaoReasonAddView.this;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                boolean booleanValue;
                                boolean booleanValue2;
                                t tVar2 = tVar;
                                tVar2.mo141height(45.0f);
                                tVar2.mo153width(129.0f);
                                tVar2.marginLeft(12.0f);
                                tVar2.borderRadius(4.0f);
                                booleanValue = ((Boolean) r0.canClick$delegate.getValue(JubaoReasonAddView.this, JubaoReasonAddView.$$delegatedProperties[0])).booleanValue();
                                if (booleanValue) {
                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                } else {
                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getDisableBtnBgColor());
                                }
                                booleanValue2 = ((Boolean) r0.canClick$delegate.getValue(JubaoReasonAddView.this, JubaoReasonAddView.$$delegatedProperties[0])).booleanValue();
                                tVar2.m151touchEnable(booleanValue2);
                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.j()));
                                tVar2.allCenter();
                                com.tencent.kuikly.core.nvi.serialization.json.e dTParams = JubaoReasonAddView.this.pageModel.getDTParams();
                                dTParams.v("relation_content", JubaoReasonAddView.this.reasonText);
                                Unit unit = Unit.INSTANCE;
                                EcommerceExtKt.elementVR(tVar2, "em_safe_continue_button", dTParams);
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoReasonAddView jubaoReasonAddView4 = JubaoReasonAddView.this;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final JubaoReasonAddView jubaoReasonAddView5 = JubaoReasonAddView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        boolean booleanValue;
                                        JubaoReasonAddView jubaoReasonAddView6;
                                        Function1<? super String, Unit> function1;
                                        booleanValue = ((Boolean) r2.canClick$delegate.getValue(JubaoReasonAddView.this, JubaoReasonAddView.$$delegatedProperties[0])).booleanValue();
                                        if (booleanValue && (function1 = (jubaoReasonAddView6 = JubaoReasonAddView.this).completeCallback) != null) {
                                            function1.invoke(jubaoReasonAddView6.reasonText);
                                        }
                                        aa<TextAreaView> aaVar = JubaoReasonAddView.this.inputRef;
                                        if (aaVar == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("inputRef");
                                            aaVar = null;
                                        }
                                        TextAreaView b16 = aaVar.b();
                                        if (b16 != null) {
                                            b16.h();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoReasonAddView.body.1.5.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u7ee7\u7eed");
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        ceVar2.color(JubaoThemeData.INSTANCE.getConfirmBtnTextColor());
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
        return jubaoAnimationView$body$1;
    }
}
