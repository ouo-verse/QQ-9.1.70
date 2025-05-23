package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchLabelItemView extends ComposeView<QSearchLabelItemAttr, QSearchLabelItemEvent> {
    public final boolean selected;
    public final String text;

    public QSearchLabelItemView() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchLabelItemAttr access$getAttr(QSearchLabelItemView qSearchLabelItemView) {
        return (QSearchLabelItemAttr) qSearchLabelItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.padding(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                final QSearchLabelItemView qSearchLabelItemView = QSearchLabelItemView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final QSearchLabelItemView qSearchLabelItemView2 = QSearchLabelItemView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                QSearchLabelItemAttr access$getAttr = QSearchLabelItemView.access$getAttr(QSearchLabelItemView.this);
                                ceVar2.text((String) access$getAttr.text$delegate.getValue(access$getAttr, QSearchLabelItemAttr.$$delegatedProperties[0]));
                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QSearchLabelItemView qSearchLabelItemView2 = QSearchLabelItemView.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QSearchLabelItemAttr access$getAttr = QSearchLabelItemView.access$getAttr(QSearchLabelItemView.this);
                        return Boolean.valueOf(((Boolean) access$getAttr.isSelected$delegate.getValue(access$getAttr, QSearchLabelItemAttr.$$delegatedProperties[1])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.alignItemsFlexEnd();
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView.body.1.4.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView.body.1.4.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(20.0f, 20.0f);
                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAFsSURBVHgB7djdTcMwFIbhk7BIR4EN2ABuuGAK2g24y0WH6SodBDD5AgWJxo5jH/+F75WqplWl5kksxbYIY4wxxhgLaDC76eWok60EaC+n6fhD7uS5O8/9bBvgX+zu+5uzDd0++Bp7aRbdS8vZsdbavcNu7MaGdCAWtQeOwKK2wJFY1A5YAYvaACthUf1gRSyqG6yMRfWCE2BRneBEWOQ/tTyaW8lRQizyAx/Ny/hHp+k9ZYmxaHlIf2H3P5/78fipO4h2GbDIDf6LvaSNzoRF7iH9ZrkguAhawzsjFi0P6cHsxxOax8Xe6cxY5PdYSoEugEX+z2FNdCEsWjfx0EAXxKL1M60YdGEsCptahqArwKLwufQadCVYFLd48EFXhEXxqyU3+nUE3UslWKSzPHSh5yuCRXrrYX90MSzS3QBYRhfFIv0dDzu6OBal2eK5RleBRen2tAbzKDfyIMC+y6EGLGOMMcYYY4wx9l/7BBXfA5YrQVT/AAAAAElFTkSuQmCC", false, 2, null);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchLabelItemAttr(this.text, this.selected);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchLabelItemEvent();
    }

    public QSearchLabelItemView(String str, boolean z16) {
        this.text = str;
        this.selected = z16;
    }

    public /* synthetic */ QSearchLabelItemView(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", false);
    }
}
