package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
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
public final class QSearchGrayBorderButtonView extends ComposeView<QSearchGrayBorderButtonAttr, QSearchGrayBorderButtonEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchGrayBorderButtonAttr access$getAttr(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
        return (QSearchGrayBorderButtonAttr) qSearchGrayBorderButtonView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final float f16 = QSearchGrayBorderButtonView.access$getAttr(QSearchGrayBorderButtonView.this).status == 2 ? 0.0f : 16.0f;
                final QSearchGrayBorderButtonView qSearchGrayBorderButtonView = QSearchGrayBorderButtonView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f17 = f16;
                        final QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView.body.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h wrapColor;
                                h wrapColor2;
                                t tVar2 = tVar;
                                tVar2.paddingLeft(f17).paddingRight(f17);
                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(14.0f) + 29.0f);
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentCenter();
                                if (QSearchGrayBorderButtonView.access$getAttr(qSearchGrayBorderButtonView2).status != 2) {
                                    boolean z16 = QSearchGrayBorderButtonView.access$getAttr(qSearchGrayBorderButtonView2).status == 0;
                                    tVar2.borderRadius(4.0f);
                                    BorderStyle borderStyle = BorderStyle.SOLID;
                                    if (z16) {
                                        wrapColor = QUISkinColor.INSTANCE.wrapColor("button_border_secondary_default");
                                    } else {
                                        wrapColor = QUISkinColor.INSTANCE.wrapColor("button_border_secondary_disable");
                                    }
                                    tVar2.m136border(new e(1.0f, borderStyle, wrapColor));
                                    if (z16) {
                                        wrapColor2 = QUISkinColor.INSTANCE.wrapColor("button_bg_secondary_default");
                                    } else {
                                        wrapColor2 = QUISkinColor.INSTANCE.wrapColor("button_bg_secondary_disable");
                                    }
                                    tVar2.mo113backgroundColor(wrapColor2);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchGrayBorderButtonView qSearchGrayBorderButtonView3 = qSearchGrayBorderButtonView;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QSearchGrayBorderButtonView qSearchGrayBorderButtonView4 = QSearchGrayBorderButtonView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h wrapColor;
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(QSearchGrayBorderButtonView.access$getAttr(QSearchGrayBorderButtonView.this).text);
                                        int i3 = QSearchGrayBorderButtonView.access$getAttr(QSearchGrayBorderButtonView.this).status;
                                        if (i3 == 0) {
                                            wrapColor = QUISkinColor.INSTANCE.wrapColor("button_text_secondary_default");
                                        } else if (i3 != 1) {
                                            wrapColor = QUISkinColor.INSTANCE.wrapColor("text_secondary_light");
                                        } else {
                                            wrapColor = QUISkinColor.INSTANCE.wrapColor("button_text_secondary_disable");
                                        }
                                        ceVar2.color(wrapColor);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.accessibility(QSearchGrayBorderButtonView.access$getAttr(QSearchGrayBorderButtonView.this).text + "\u6309\u94ae");
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
        return new QSearchGrayBorderButtonAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchGrayBorderButtonEvent();
    }
}
