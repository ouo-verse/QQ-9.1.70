package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
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
public final class JubaoErrorView extends ComposeView<k, l> {
    public Function1<? super Integer, Unit> continueCallback;
    public final ErrorData data;

    public JubaoErrorView(ErrorData errorData) {
        this.data = errorData;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.paddingTop(34.0f);
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, JubaoUtil$O3BgView$1.INSTANCE);
                final JubaoErrorView jubaoErrorView = JubaoErrorView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final JubaoErrorView jubaoErrorView2 = JubaoErrorView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                String str;
                                af afVar2 = afVar;
                                afVar2.mo141height(100.0f);
                                afVar2.mo153width(100.0f);
                                if (JubaoErrorView.this.data.clickType == 1) {
                                    str = "data:image/png;base64,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";
                                } else {
                                    str = "data:image/png;base64,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";
                                }
                                b.a.b(afVar2, str, false, 2, null);
                                afVar2.alignSelfCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoErrorView jubaoErrorView2 = JubaoErrorView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final JubaoErrorView jubaoErrorView3 = JubaoErrorView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(24.0f);
                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                ceVar2.fontWeight500();
                                ceVar2.color(JubaoThemeData.INSTANCE.getItemViewTextColor());
                                ceVar2.text(JubaoErrorView.this.data.title);
                                ceVar2.alignSelfCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoErrorView jubaoErrorView3 = JubaoErrorView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final JubaoErrorView jubaoErrorView4 = JubaoErrorView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(4.0f);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.marginLeft(20.0f);
                                ceVar2.marginRight(20.0f);
                                ceVar2.fontWeight400();
                                ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                ceVar2.text(JubaoErrorView.this.data.content);
                                ceVar2.alignSelfCenter();
                                ceVar2.textAlignCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoErrorView jubaoErrorView4 = JubaoErrorView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final JubaoErrorView jubaoErrorView5 = JubaoErrorView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(45.0f);
                                tVar2.mo153width(168.0f);
                                tVar2.marginTop(152.5f);
                                tVar2.borderRadius(4.0f);
                                tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.j()));
                                tVar2.allCenter();
                                tVar2.alignSelfCenter();
                                tVar2.accessibility(JubaoErrorView.this.data.btnText);
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoErrorView jubaoErrorView6 = JubaoErrorView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final JubaoErrorView jubaoErrorView7 = JubaoErrorView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView.body.1.5.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        JubaoErrorView jubaoErrorView8 = JubaoErrorView.this;
                                        Function1<? super Integer, Unit> function1 = jubaoErrorView8.continueCallback;
                                        if (function1 != null) {
                                            function1.invoke(Integer.valueOf(jubaoErrorView8.data.clickType));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoErrorView jubaoErrorView7 = JubaoErrorView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView.body.1.5.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final JubaoErrorView jubaoErrorView8 = JubaoErrorView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoErrorView.body.1.5.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(JubaoErrorView.this.data.btnText);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
