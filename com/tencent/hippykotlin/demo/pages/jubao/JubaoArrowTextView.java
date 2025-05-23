package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoArrowTextView extends ComposeView<JubaoArrowTextViewAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ JubaoArrowTextViewAttr access$getAttr(JubaoArrowTextView jubaoArrowTextView) {
        return (JubaoArrowTextViewAttr) jubaoArrowTextView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(55.0f);
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final JubaoArrowTextView jubaoArrowTextView = JubaoArrowTextView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final JubaoArrowTextView jubaoArrowTextView2 = JubaoArrowTextView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.text(JubaoArrowTextView.access$getAttr(JubaoArrowTextView.this).text);
                                ceVar2.color(JubaoArrowTextView.access$getAttr(JubaoArrowTextView.this).textColor);
                                ceVar2.marginLeft(16.0f);
                                ceVar2.fontWeight400();
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.accessibility("");
                                ceVar2.m151touchEnable(false);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoArrowTextView jubaoArrowTextView2 = JubaoArrowTextView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoArrowTextView jubaoArrowTextView3 = JubaoArrowTextView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final JubaoArrowTextView jubaoArrowTextView4 = JubaoArrowTextView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginRight(16.0f);
                                        afVar2.mo141height(16.0f);
                                        afVar2.mo153width(16.0f);
                                        b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_secondary", false, 2, null);
                                        afVar2.m152visibility(JubaoArrowTextView.access$getAttr(JubaoArrowTextView.this).showArrow);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoArrowTextView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(0.6f);
                                tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getPartingLineColor());
                                tVar2.absolutePosition(54.4f, 16.0f, 0.0f, 0.0f);
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
        return new JubaoArrowTextViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
