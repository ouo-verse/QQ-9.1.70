package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageSpan;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QuickJubaoChatEvidenceView extends JubaoAnimationView {
    public Function0<Unit> backClickCallback;
    public final PageModel pageModel;
    public Function0<Unit> selectChatMsgCallback;
    public Function0<Unit> submitCallback;

    public QuickJubaoChatEvidenceView(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    public static final boolean access$getCanSubmit(QuickJubaoChatEvidenceView quickJubaoChatEvidenceView) {
        PageModel pageModel = quickJubaoChatEvidenceView.pageModel;
        return (pageModel.evidenceViewFlag == 0 && pageModel.getEvidenceNum() == 0) ? false : true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        JubaoAnimationView$body$1 jubaoAnimationView$body$1 = new JubaoAnimationView$body$1(this);
        attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(k kVar) {
                k kVar2 = kVar;
                kVar2.flexDirectionColumn();
                EcommerceExtKt.elementVR(kVar2, "em_safe_chat_evidence", QuickJubaoChatEvidenceView.this.pageModel.getDTParams());
                return Unit.INSTANCE;
            }
        });
        w.a(this, JubaoUtil$O3BgView$1.INSTANCE);
        JubaoNavBarKt.JubaoNavBar(this, new Function1<JubaoNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(JubaoNavBar jubaoNavBar) {
                JubaoNavBar jubaoNavBar2 = jubaoNavBar;
                jubaoNavBar2.setBarData(new NavBarData("\u4e3e\u8bc1\u6750\u6599", true, false));
                final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView = QuickJubaoChatEvidenceView.this;
                jubaoNavBar2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function0<Unit> function0 = QuickJubaoChatEvidenceView.this.backClickCallback;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                return Unit.INSTANCE;
            }
        });
        cg.a(this, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.marginTop(16.0f);
                        ceVar2.marginLeft(16.0f);
                        ceVar2.text("\u8865\u5145\u63d0\u4ea4\u804a\u5929\u8bc1\u636e");
                        ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                        ceVar2.color(JubaoThemeData.INSTANCE.getTitleTextColor());
                        ceVar2.fontWeight500();
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        cg.a(this, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$4
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$4.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.marginLeft(16.0f);
                        ceVar2.marginRight(16.0f);
                        ceVar2.marginTop(12.0f);
                        ceVar2.color(JubaoThemeData.INSTANCE.getItemViewTextColor());
                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                        ceVar2.fontWeight400();
                        ceVar2.text("\u804a\u5929\u8bc1\u636e\u662f\u5ba1\u6838\u5224\u65ad\u662f\u5426\u8fdd\u89c4\u7684\u91cd\u8981\u4f9d\u636e\u3002");
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        RichTextViewKt.b(this, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(RichTextView richTextView) {
                RichTextView richTextView2 = richTextView;
                richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$5.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(RichTextAttr richTextAttr) {
                        RichTextAttr richTextAttr2 = richTextAttr;
                        richTextAttr2.marginTop(4.0f);
                        richTextAttr2.marginLeft(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                if (QuickJubaoChatEvidenceView.this.pageModel.getEvidenceNum() > 0) {
                    final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView = QuickJubaoChatEvidenceView.this;
                    RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$5.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(cf cfVar) {
                            cf cfVar2 = cfVar;
                            cfVar2.color(JubaoThemeData.INSTANCE.getItemViewTextColor());
                            cfVar2.text("\u5df2\u9009\u53d6" + QuickJubaoChatEvidenceView.this.pageModel.getEvidenceNum() + "\u6761\u3002");
                            ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                            cfVar2.fontWeight400();
                            return Unit.INSTANCE;
                        }
                    });
                }
                final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView2 = QuickJubaoChatEvidenceView.this;
                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$5.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(cf cfVar) {
                        cf cfVar2 = cfVar;
                        cfVar2.color(new h(4278229503L));
                        ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                        cfVar2.fontWeight400();
                        if (QuickJubaoChatEvidenceView.this.pageModel.getEvidenceNum() > 0) {
                            cfVar2.text("\u91cd\u65b0\u9009\u62e9");
                        } else {
                            cfVar2.text("\u9009\u62e9\u804a\u5929\u8bb0\u5f55");
                        }
                        final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView3 = QuickJubaoChatEvidenceView.this;
                        cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.5.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                Function0<Unit> function0 = QuickJubaoChatEvidenceView.this.selectChatMsgCallback;
                                if (function0 != null) {
                                    function0.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                RichTextViewKt.a(richTextView2, new Function1<ImageSpan, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$5.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageSpan imageSpan) {
                        ImageSpan imageSpan2 = imageSpan;
                        imageSpan2.I(6.0f, 12.0f);
                        b.a.b(imageSpan2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAbBAMAAABRv8j0AAAAD1BMVEUAAAAAnP8Amv8AnP8AnP9rN1d4AAAABHRSTlMA3yBw8MdBCQAAACdJREFUCNdjQAAjKM3sqABhMIkIQYUUaSMkAGfApRCKKReAewfVgwC1bggdrgRe7AAAAABJRU5ErkJggg==", false, 2, null);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(this, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$6.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionRow();
                        tVar2.marginTop(140.0f);
                        tVar2.justifyContentCenter();
                        return Unit.INSTANCE;
                    }
                });
                final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView = QuickJubaoChatEvidenceView.this;
                if (quickJubaoChatEvidenceView.pageModel.evidenceViewFlag == 1) {
                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$6.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar3) {
                            v vVar4 = vVar3;
                            final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView2 = QuickJubaoChatEvidenceView.this;
                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.mo141height(40.0f);
                                    tVar2.mo153width(168.0f);
                                    tVar2.alignSelfCenter();
                                    tVar2.borderRadius(12.0f);
                                    tVar2.m136border(new e(1.0f, BorderStyle.SOLID, JubaoThemeData.INSTANCE.getButtonBorderSecondaryDefault()));
                                    tVar2.allCenter();
                                    tVar2.m151touchEnable(QuickJubaoChatEvidenceView.access$getCanSubmit(QuickJubaoChatEvidenceView.this));
                                    tVar2.accessibility("\u8df3\u8fc7");
                                    tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                    return Unit.INSTANCE;
                                }
                            });
                            final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView3 = QuickJubaoChatEvidenceView.this;
                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.2.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(u uVar) {
                                    final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView4 = QuickJubaoChatEvidenceView.this;
                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.2.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            Function0<Unit> function0 = QuickJubaoChatEvidenceView.this.submitCallback;
                                            if (function0 != null) {
                                                function0.invoke();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.2.3
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.2.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.text("\u8df3\u8fc7");
                                            ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                            ceVar2.fontWeight500();
                                            ceVar2.color(JubaoThemeData.INSTANCE.getButtonTextSecondaryDefault());
                                            ceVar2.m151touchEnable(false);
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
                final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView2 = QuickJubaoChatEvidenceView.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$6.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView3 = QuickJubaoChatEvidenceView.this;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(40.0f);
                                tVar2.mo153width(168.0f);
                                tVar2.alignSelfCenter();
                                tVar2.borderRadius(12.0f);
                                tVar2.marginLeft(7.0f);
                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.j()));
                                tVar2.allCenter();
                                tVar2.m151touchEnable(QuickJubaoChatEvidenceView.access$getCanSubmit(QuickJubaoChatEvidenceView.this));
                                if (QuickJubaoChatEvidenceView.this.pageModel.getEvidenceNum() == 0) {
                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor().n(0.3f));
                                } else {
                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                }
                                com.tencent.kuikly.core.nvi.serialization.json.e dTParams = QuickJubaoChatEvidenceView.this.pageModel.getDTParams();
                                QuickJubaoChatEvidenceView quickJubaoChatEvidenceView4 = QuickJubaoChatEvidenceView.this;
                                dTParams.v("come_from", quickJubaoChatEvidenceView4.pageModel.getPostData().src);
                                dTParams.v("strategyid", quickJubaoChatEvidenceView4.pageModel.getPostData().grayId);
                                Unit unit = Unit.INSTANCE;
                                EcommerceExtKt.elementVR(tVar2, "em_safe_submit_button", dTParams);
                                tVar2.accessibility("\u63d0\u4ea4");
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView4 = QuickJubaoChatEvidenceView.this;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final QuickJubaoChatEvidenceView quickJubaoChatEvidenceView5 = QuickJubaoChatEvidenceView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Function0<Unit> function0;
                                        if (QuickJubaoChatEvidenceView.access$getCanSubmit(QuickJubaoChatEvidenceView.this) && (function0 = QuickJubaoChatEvidenceView.this.submitCallback) != null) {
                                            function0.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.6.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u63d0\u4ea4");
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        ceVar2.color(JubaoThemeData.INSTANCE.getConfirmBtnTextColor());
                                        ceVar2.m151touchEnable(false);
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
        ConditionViewKt.c(this, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$7
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QuickJubaoChatEvidenceView.this.pageModel.getOperateStatus() == 3);
            }
        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$8
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView$body$1$8.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.8.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                tVar2.m150top(0.0f);
                                tVar2.m142left(0.0f);
                                tVar2.m149right(0.0f);
                                tVar2.m138bottom(240.0f);
                                tVar2.m143maxHeight(300.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.8.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.8.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ECLoadingViewKt.ECLoading(vVar2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.8.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECLoadingView eCLoadingView) {
                                eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.QuickJubaoChatEvidenceView.body.1.8.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                        eCLoadingAttr.delayShow = true;
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
