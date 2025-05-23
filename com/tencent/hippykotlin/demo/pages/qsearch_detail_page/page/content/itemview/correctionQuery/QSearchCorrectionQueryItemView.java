package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchCorrectionQueryItemView extends ComposeView<QSearchCorrectionQueryItemAttr, QSearchCorrectionQueryItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchCorrectionQueryItemAttr access$getAttr(QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView) {
        return (QSearchCorrectionQueryItemAttr) qSearchCorrectionQueryItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchCorrectionQueryItemEvent access$getEvent(QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView) {
        return (QSearchCorrectionQueryItemEvent) qSearchCorrectionQueryItemView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.marginTop(8.0f);
                        mVar2.marginLeft(8.0f);
                        mVar2.marginRight(8.0f);
                        mVar2.borderRadius(8.0f);
                        mVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                        return Unit.INSTANCE;
                    }
                });
                final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView = QSearchCorrectionQueryItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView2 = QSearchCorrectionQueryItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.flexWrapWrap();
                                        tVar2.alignItemsCenter();
                                        float qqFontScaleAddSize = (FontModuleExtKt.qqFontScaleAddSize(14.0f) / 2) + 10.0f;
                                        tVar2.padding(qqFontScaleAddSize, 12.0f, qqFontScaleAddSize, 4.0f);
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.margin(4.0f);
                                                ceVar2.fontWeight400();
                                                ceVar2.lineHeight(24.0f);
                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                ceVar2.text("\u641c\u7d22\u8bcd\u5df2\u4fee\u6539\u4e3a");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView3 = QSearchCorrectionQueryItemView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView4 = QSearchCorrectionQueryItemView.this;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(14.0f) + 28.0f);
                                                tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_standard_primary"));
                                                tVar2.margin(4.0f);
                                                tVar2.borderRadius(6.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                EcommerceExtKt.elementVR(tVar2, "em_bas_error_correcting_words", QSearchCorrectionQueryItemView.access$getAttr(QSearchCorrectionQueryItemView.this).reportParams);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView5 = QSearchCorrectionQueryItemView.this;
                                        RichTextViewKt.b(vVar6, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RichTextView richTextView) {
                                                boolean contains$default;
                                                final h wrapColor;
                                                RichTextView richTextView2 = richTextView;
                                                richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                                        RichTextAttr richTextAttr2 = richTextAttr;
                                                        richTextAttr2.marginLeft(8.0f);
                                                        richTextAttr2.marginRight(8.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                QSearchCorrectionQueryItemAttr access$getAttr = QSearchCorrectionQueryItemView.access$getAttr(QSearchCorrectionQueryItemView.this);
                                                String str = (String) access$getAttr.correctionQuery$delegate.getValue(access$getAttr, QSearchCorrectionQueryItemAttr.$$delegatedProperties[0]);
                                                int length = str.length();
                                                for (int i3 = 0; i3 < length; i3++) {
                                                    final char charAt = str.charAt(i3);
                                                    QSearchCorrectionQueryItemAttr access$getAttr2 = QSearchCorrectionQueryItemView.access$getAttr(QSearchCorrectionQueryItemView.this);
                                                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) access$getAttr2.keyWord$delegate.getValue(access$getAttr2, QSearchCorrectionQueryItemAttr.$$delegatedProperties[1]), charAt, false, 2, (Object) null);
                                                    if (contains$default) {
                                                        wrapColor = QUISkinColor.INSTANCE.wrapColor("text_primary");
                                                    } else {
                                                        wrapColor = QUISkinColor.INSTANCE.wrapColor("brand_standard");
                                                    }
                                                    RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.3.2.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(cf cfVar) {
                                                            cf cfVar2 = cfVar;
                                                            cfVar2.text(String.valueOf(charAt));
                                                            ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                                                            cfVar2.fontWeight400();
                                                            cfVar2.color(wrapColor);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView6 = QSearchCorrectionQueryItemView.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView7 = QSearchCorrectionQueryItemView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.2.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function1<? super String, Unit> function1 = QSearchCorrectionQueryItemView.access$getEvent(QSearchCorrectionQueryItemView.this).onClickCorrectionQueryEvent;
                                                        if (function1 != null) {
                                                            QSearchCorrectionQueryItemAttr access$getAttr = QSearchCorrectionQueryItemView.access$getAttr(QSearchCorrectionQueryItemView.this);
                                                            function1.invoke((String) access$getAttr.correctionQuery$delegate.getValue(access$getAttr, QSearchCorrectionQueryItemAttr.$$delegatedProperties[0]));
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
                        final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView3 = QSearchCorrectionQueryItemView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                TextView textView2 = textView;
                                final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView4 = QSearchCorrectionQueryItemView.this;
                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.lineHeight(24.0f);
                                        ceVar2.marginTop(16.0f);
                                        ceVar2.marginRight(16.0f);
                                        ceVar2.marginBottom(16.0f);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_link"));
                                        ceVar2.text("\u53d6\u6d88\u4fee\u6539");
                                        EcommerceExtKt.elementVR(ceVar2, "em_bas_unmodify", QSearchCorrectionQueryItemView.access$getAttr(QSearchCorrectionQueryItemView.this).reportParams);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView5 = QSearchCorrectionQueryItemView.this;
                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextEvent textEvent) {
                                        final QSearchCorrectionQueryItemView qSearchCorrectionQueryItemView6 = QSearchCorrectionQueryItemView.this;
                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.correctionQuery.QSearchCorrectionQueryItemView.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function1<? super String, Unit> function1 = QSearchCorrectionQueryItemView.access$getEvent(QSearchCorrectionQueryItemView.this).onClickCancelModifyEvent;
                                                if (function1 != null) {
                                                    QSearchCorrectionQueryItemAttr access$getAttr = QSearchCorrectionQueryItemView.access$getAttr(QSearchCorrectionQueryItemView.this);
                                                    function1.invoke((String) access$getAttr.keyWord$delegate.getValue(access$getAttr, QSearchCorrectionQueryItemAttr.$$delegatedProperties[1]));
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
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchCorrectionQueryItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchCorrectionQueryItemEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
    }
}
