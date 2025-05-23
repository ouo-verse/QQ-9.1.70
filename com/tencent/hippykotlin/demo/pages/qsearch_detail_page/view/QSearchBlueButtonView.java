package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchBlueButtonView extends ComposeView<QSearchBlueButtonAttr, QSearchBlueButtonEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchBlueButtonAttr access$getAttr(QSearchBlueButtonView qSearchBlueButtonView) {
        return (QSearchBlueButtonAttr) qSearchBlueButtonView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchBlueButtonView qSearchBlueButtonView = QSearchBlueButtonView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(14.0f) + 29.0f);
                                tVar2.paddingLeft(16.0f);
                                tVar2.paddingRight(16.0f);
                                tVar2.allCenter();
                                tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("button_bg_primary_default"));
                                tVar2.borderRadius(4.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchBlueButtonView qSearchBlueButtonView2 = QSearchBlueButtonView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QSearchBlueButtonView qSearchBlueButtonView3 = QSearchBlueButtonView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(QSearchBlueButtonView.access$getAttr(QSearchBlueButtonView.this).text);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("button_text_primary_default"));
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
        return new QSearchBlueButtonAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchBlueButtonEvent();
    }
}
