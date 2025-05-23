package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoSubmitLoading extends ComposeView<JubaoSubmitLoadingAttr, l> {
    public final Lazy loadingPAGToken$delegate;

    public JubaoSubmitLoading() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading$loadingPAGToken$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (JubaoSubmitLoading.this.getPagerData().getIsIOS()) {
                    return "qecommerce_skin_loading_img_sangedian";
                }
                return "ecommerce_skin_loading_img_sangedian";
            }
        });
        this.loadingPAGToken$delegate = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ JubaoSubmitLoadingAttr access$getAttr(JubaoSubmitLoading jubaoSubmitLoading) {
        return (JubaoSubmitLoadingAttr) jubaoSubmitLoading.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePositionAllZero();
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoSubmitLoading jubaoSubmitLoading = JubaoSubmitLoading.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(128.0f, 128.0f);
                                tVar2.mo113backgroundColor(new h(3425644335L));
                                tVar2.borderRadius(12.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoSubmitLoading jubaoSubmitLoading2 = JubaoSubmitLoading.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                JubaoSubmitLoadingAttr access$getAttr = JubaoSubmitLoading.access$getAttr(JubaoSubmitLoading.this);
                                return Boolean.valueOf(((Boolean) access$getAttr.showAnimation$delegate.getValue(access$getAttr, JubaoSubmitLoadingAttr.$$delegatedProperties[2])).booleanValue());
                            }
                        };
                        final JubaoSubmitLoading jubaoSubmitLoading3 = JubaoSubmitLoading.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final JubaoSubmitLoading jubaoSubmitLoading4 = JubaoSubmitLoading.this;
                                PAGViewKt.PAG(conditionView, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGView pAGView) {
                                        final JubaoSubmitLoading jubaoSubmitLoading5 = JubaoSubmitLoading.this;
                                        pAGView.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PAGAttr pAGAttr) {
                                                PAGAttr pAGAttr2 = pAGAttr;
                                                pAGAttr2.marginTop(26.0f);
                                                pAGAttr2.size(40.0f, 40.0f);
                                                pAGAttr2.repeatCount(Integer.MAX_VALUE);
                                                pAGAttr2.autoPlay(true);
                                                pAGAttr2.src((String) JubaoSubmitLoading.this.loadingPAGToken$delegate.getValue());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoSubmitLoading jubaoSubmitLoading4 = JubaoSubmitLoading.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                JubaoSubmitLoadingAttr access$getAttr = JubaoSubmitLoading.access$getAttr(JubaoSubmitLoading.this);
                                return Boolean.valueOf(!((Boolean) access$getAttr.showAnimation$delegate.getValue(access$getAttr, JubaoSubmitLoadingAttr.$$delegatedProperties[2])).booleanValue());
                            }
                        };
                        final JubaoSubmitLoading jubaoSubmitLoading5 = JubaoSubmitLoading.this;
                        ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final JubaoSubmitLoading jubaoSubmitLoading6 = JubaoSubmitLoading.this;
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final JubaoSubmitLoading jubaoSubmitLoading7 = JubaoSubmitLoading.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(40.0f, 40.0f);
                                                afVar2.marginTop(26.0f);
                                                JubaoSubmitLoadingAttr access$getAttr = JubaoSubmitLoading.access$getAttr(JubaoSubmitLoading.this);
                                                b.a.b(afVar2, (String) access$getAttr.icon$delegate.getValue(access$getAttr, JubaoSubmitLoadingAttr.$$delegatedProperties[1]), false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoSubmitLoading jubaoSubmitLoading6 = JubaoSubmitLoading.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final JubaoSubmitLoading jubaoSubmitLoading7 = JubaoSubmitLoading.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSubmitLoading.body.1.3.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        JubaoSubmitLoadingAttr access$getAttr = JubaoSubmitLoading.access$getAttr(JubaoSubmitLoading.this);
                                        ceVar2.text((String) access$getAttr.text$delegate.getValue(access$getAttr, JubaoSubmitLoadingAttr.$$delegatedProperties[0]));
                                        ceVar2.marginTop(16.0f);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight400();
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
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new JubaoSubmitLoadingAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
