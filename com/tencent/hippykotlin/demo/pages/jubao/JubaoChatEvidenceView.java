package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoChatEvidenceView extends JubaoAnimationView {
    public Function0<Unit> backClickCallback;
    public final PageModel pageModel;
    public Function0<Unit> selectChatMsgCallback;
    public Function0<Unit> submitCallback;

    public JubaoChatEvidenceView(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    public static final boolean access$getCanSubmit(JubaoChatEvidenceView jubaoChatEvidenceView) {
        PageModel pageModel = jubaoChatEvidenceView.pageModel;
        return (pageModel.evidenceViewFlag == 0 && pageModel.getEvidenceNum() == 0) ? false : true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        JubaoAnimationView$body$1 jubaoAnimationView$body$1 = new JubaoAnimationView$body$1(this);
        attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(k kVar) {
                k kVar2 = kVar;
                kVar2.flexDirectionColumn();
                EcommerceExtKt.elementVR(kVar2, "em_safe_chat_evidence", JubaoChatEvidenceView.this.pageModel.getDTParams());
                return Unit.INSTANCE;
            }
        });
        w.a(this, JubaoUtil$O3BgView$1.INSTANCE);
        JubaoNavBarKt.JubaoNavBar(this, new Function1<JubaoNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(JubaoNavBar jubaoNavBar) {
                JubaoNavBar jubaoNavBar2 = jubaoNavBar;
                jubaoNavBar2.setBarData(new NavBarData("\u4e3e\u8bc1\u6750\u6599", true, false));
                final JubaoChatEvidenceView jubaoChatEvidenceView = JubaoChatEvidenceView.this;
                jubaoNavBar2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function0<Unit> function0 = JubaoChatEvidenceView.this.backClickCallback;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                return Unit.INSTANCE;
            }
        });
        cg.a(this, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.marginTop(16.0f);
                        ceVar2.marginLeft(16.0f);
                        ceVar2.text("\u8865\u5145\u63d0\u4ea4\u804a\u5929\u8bc1\u636e");
                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                        ceVar2.color(JubaoThemeData.INSTANCE.getTitleTextColor());
                        ceVar2.fontWeight400();
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        cg.a(this, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$4
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$4.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.marginLeft(16.0f);
                        ceVar2.marginRight(16.0f);
                        ceVar2.marginTop(14.0f);
                        ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                        ceVar2.fontWeight400();
                        ceVar2.text("\u63d0\u4ea4\u804a\u5929\u8bc1\u636e\u6709\u52a9\u4e8e\u6838\u5b9e\u8be5" + JubaoConfig.description + "\u662f\u5426\u5b58\u5728\u8fdd\u89c4\u884c\u4e3a\u3002");
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(this, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$5.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo141height(146.0f);
                        tVar2.flexDirectionColumn();
                        tVar2.justifyContentCenter();
                        tVar2.marginLeft(16.0f);
                        tVar2.marginRight(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                final JubaoChatEvidenceView jubaoChatEvidenceView = JubaoChatEvidenceView.this;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$5.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final JubaoChatEvidenceView jubaoChatEvidenceView2 = JubaoChatEvidenceView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.5.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                ceVar2.color(JubaoThemeData.INSTANCE.getItemViewTextColor());
                                if (JubaoChatEvidenceView.this.pageModel.getEvidenceNum() == 0) {
                                    ceVar2.text("\u4f60\u5c1a\u672a\u9009\u62e9\u4efb\u4f55\u804a\u5929\u8bb0\u5f55");
                                } else {
                                    StringBuilder sb5 = new StringBuilder();
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4f60\u5df2\u9009\u62e9\u4e0e\u8be5");
                                    m3.append(JubaoConfig.description);
                                    m3.append("\u6700\u65b0\u7684");
                                    sb5.append(m3.toString());
                                    sb5.append(TokenParser.SP);
                                    sb5.append(JubaoChatEvidenceView.this.pageModel.getEvidenceNum());
                                    sb5.append(" \u6761\u804a\u5929\u8bb0\u5f55");
                                    ceVar2.text(sb5.toString());
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoChatEvidenceView jubaoChatEvidenceView2 = JubaoChatEvidenceView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$5.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(JubaoChatEvidenceView.this.pageModel.getEvidenceNum() < 5);
                    }
                };
                final JubaoChatEvidenceView jubaoChatEvidenceView3 = JubaoChatEvidenceView.this;
                ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$5.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final JubaoChatEvidenceView jubaoChatEvidenceView4 = JubaoChatEvidenceView.this;
                        cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.5.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final JubaoChatEvidenceView jubaoChatEvidenceView5 = JubaoChatEvidenceView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.5.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.marginTop(14.0f);
                                        if (JubaoChatEvidenceView.this.pageModel.getEvidenceNum() == 0 && JubaoChatEvidenceView.this.pageModel.evidenceViewFlag == 0) {
                                            ceVar2.text("\u8bf7\u81f3\u5c11\u63d0\u4ea4 1\u6761\u804a\u5929\u8bc1\u636e\uff0c\u5426\u5219\u5ba1\u6838\u4eba\u5458\u65e0\u6cd5\u5bf9\u4f60\u7684\u4e3e\u62a5\u8fdb\u884c\u7814\u5224\u3002");
                                        } else {
                                            ceVar2.text("\u5f53\u524d\u63d0\u4f9b\u7684\u8bc1\u636e\u592a\u5c11\uff0c\u5ba1\u6838\u4eba\u5458\u65e0\u6cd5\u5bf9\u4e3e\u62a5\u8fdb\u884c\u7814\u5224\uff0c\u5efa\u8bae\u63d0\u4ea4\u66f4\u591a\u804a\u5929\u8bb0\u5f55\u4ee5\u4fbf\u5b89\u5168\u4e2d\u5fc3\u6838\u5b9e\u3002");
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
        w.a(this, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$6.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionRow();
                        tVar2.justifyContentCenter();
                        return Unit.INSTANCE;
                    }
                });
                final JubaoChatEvidenceView jubaoChatEvidenceView = JubaoChatEvidenceView.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$6.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        final JubaoChatEvidenceView jubaoChatEvidenceView2 = JubaoChatEvidenceView.this;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                String str;
                                t tVar2 = tVar;
                                tVar2.mo141height(45.0f);
                                tVar2.mo153width(129.0f);
                                tVar2.borderRadius(4.0f);
                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, JubaoThemeData.INSTANCE.getButtonBorderSecondaryDefault()));
                                tVar2.allCenter();
                                EcommerceExtKt.elementVR(tVar2, "em_safe_select_chat_history", JubaoChatEvidenceView.this.pageModel.getDTParams());
                                if (JubaoChatEvidenceView.this.pageModel.getEvidenceNum() > 0) {
                                    str = "\u8c03\u6574\u804a\u5929\u8bb0\u5f55";
                                } else {
                                    str = "\u9009\u62e9\u804a\u5929\u8bb0\u5f55";
                                }
                                tVar2.accessibility(str);
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoChatEvidenceView jubaoChatEvidenceView3 = JubaoChatEvidenceView.this;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final JubaoChatEvidenceView jubaoChatEvidenceView4 = JubaoChatEvidenceView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Function0<Unit> function0 = JubaoChatEvidenceView.this.selectChatMsgCallback;
                                        if (function0 != null) {
                                            function0.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoChatEvidenceView jubaoChatEvidenceView4 = JubaoChatEvidenceView.this;
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final JubaoChatEvidenceView jubaoChatEvidenceView5 = JubaoChatEvidenceView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        if (JubaoChatEvidenceView.this.pageModel.getEvidenceNum() > 0) {
                                            ceVar2.text("\u8c03\u6574\u804a\u5929\u8bb0\u5f55");
                                        } else {
                                            ceVar2.text("\u9009\u62e9\u804a\u5929\u8bb0\u5f55");
                                        }
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
                final JubaoChatEvidenceView jubaoChatEvidenceView2 = JubaoChatEvidenceView.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$6.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        final JubaoChatEvidenceView jubaoChatEvidenceView3 = JubaoChatEvidenceView.this;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                String str;
                                t tVar2 = tVar;
                                tVar2.mo141height(45.0f);
                                tVar2.mo153width(129.0f);
                                tVar2.marginLeft(12.0f);
                                tVar2.borderRadius(4.0f);
                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.j()));
                                tVar2.allCenter();
                                tVar2.m151touchEnable(JubaoChatEvidenceView.access$getCanSubmit(JubaoChatEvidenceView.this));
                                if (JubaoChatEvidenceView.this.pageModel.getEvidenceNum() == 0) {
                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getDisableBtnBgColor());
                                } else {
                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                }
                                com.tencent.kuikly.core.nvi.serialization.json.e dTParams = JubaoChatEvidenceView.this.pageModel.getDTParams();
                                JubaoChatEvidenceView jubaoChatEvidenceView4 = JubaoChatEvidenceView.this;
                                dTParams.v("come_from", jubaoChatEvidenceView4.pageModel.getPostData().src);
                                dTParams.v("strategyid", jubaoChatEvidenceView4.pageModel.getPostData().grayId);
                                Unit unit = Unit.INSTANCE;
                                EcommerceExtKt.elementVR(tVar2, "em_safe_submit_button", dTParams);
                                PageModel pageModel = JubaoChatEvidenceView.this.pageModel;
                                JubaoReasonData jubaoReasonData = pageModel.selectedReasonData;
                                if (jubaoReasonData != null && jubaoReasonData.moreEvidence) {
                                    str = "\u7ee7\u7eed";
                                } else if (pageModel.getEvidenceNum() == 0 && pageModel.evidenceViewFlag == 1) {
                                    str = "\u8df3\u8fc7";
                                } else {
                                    str = "\u63d0\u4ea4";
                                }
                                tVar2.accessibility(str);
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoChatEvidenceView jubaoChatEvidenceView4 = JubaoChatEvidenceView.this;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final JubaoChatEvidenceView jubaoChatEvidenceView5 = JubaoChatEvidenceView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Function0<Unit> function0;
                                        if (JubaoChatEvidenceView.access$getCanSubmit(JubaoChatEvidenceView.this) && (function0 = JubaoChatEvidenceView.this.submitCallback) != null) {
                                            function0.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoChatEvidenceView jubaoChatEvidenceView5 = JubaoChatEvidenceView.this;
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final JubaoChatEvidenceView jubaoChatEvidenceView6 = JubaoChatEvidenceView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.6.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        ce ceVar2 = ceVar;
                                        PageModel pageModel = JubaoChatEvidenceView.this.pageModel;
                                        JubaoReasonData jubaoReasonData = pageModel.selectedReasonData;
                                        if (jubaoReasonData != null && jubaoReasonData.moreEvidence) {
                                            str = "\u7ee7\u7eed";
                                        } else if (pageModel.getEvidenceNum() == 0 && pageModel.evidenceViewFlag == 1) {
                                            str = "\u8df3\u8fc7";
                                        } else {
                                            str = "\u63d0\u4ea4";
                                        }
                                        ceVar2.text(str);
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
        ConditionViewKt.c(this, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$7
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(JubaoChatEvidenceView.this.pageModel.getOperateStatus() == 3);
            }
        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$8
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView$body$1$8.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.8.1.1
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
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.8.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.8.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ECLoadingViewKt.ECLoading(vVar2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.8.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECLoadingView eCLoadingView) {
                                eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoChatEvidenceView.body.1.8.1.3.1
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
