package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTitleTemplateModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTitleTemplateView extends QSearchBaseTemplateView<QSearchTitleTemplateModel, QSearchTitleTemplateAttr, QSearchTitleTemplateEvent> {
    public static final ce access$configTitleAttr(QSearchTitleTemplateView qSearchTitleTemplateView, ce ceVar) {
        qSearchTitleTemplateView.getClass();
        ce.fontSize$default(ceVar, 17.0f, null, 2, null);
        ceVar.fontWeight400();
        return ceVar.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTitleTemplateAttr access$getAttr(QSearchTitleTemplateView qSearchTitleTemplateView) {
        return (QSearchTitleTemplateAttr) qSearchTitleTemplateView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView$buildContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchTitleTemplateView qSearchTitleTemplateView = QSearchTitleTemplateView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView$buildContent$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QSearchTitleTemplateView qSearchTitleTemplateView2 = QSearchTitleTemplateView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                int indexOf$default;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 49.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str = QSearchTitleTemplateView.access$getAttr(QSearchTitleTemplateView.this).getData().title;
                                final String str2 = QSearchTitleTemplateView.access$getAttr(QSearchTitleTemplateView.this).getData().layoutInfo.highlight;
                                final Ref.IntRef intRef = new Ref.IntRef();
                                intRef.element = -1;
                                if (str2.length() > 0) {
                                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, true, 2, (Object) null);
                                    intRef.element = indexOf$default;
                                }
                                if (intRef.element < 0) {
                                    final QSearchTitleTemplateView qSearchTitleTemplateView3 = QSearchTitleTemplateView.this;
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final QSearchTitleTemplateView qSearchTitleTemplateView4 = QSearchTitleTemplateView.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.m144maxWidth(150.0f);
                                                    ceVar2.lines(1);
                                                    ceVar2.textOverFlowTail();
                                                    ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                    ceVar2.fontWeight400();
                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                    ceVar2.text(QSearchTitleTemplateView.access$getAttr(QSearchTitleTemplateView.this).getData().title);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    RichTextViewKt.b(vVar4, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(RichTextView richTextView) {
                                            RichTextView richTextView2 = richTextView;
                                            richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(RichTextAttr richTextAttr) {
                                                    RichTextAttr richTextAttr2 = richTextAttr;
                                                    richTextAttr2.m144maxWidth(150.0f);
                                                    ce.fontSize$default(richTextAttr2, 17.0f, null, 2, null);
                                                    richTextAttr2.fontWeight400();
                                                    richTextAttr2.lines(1);
                                                    richTextAttr2.textOverFlowTail();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final String str3 = str;
                                            final Ref.IntRef intRef2 = intRef;
                                            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.3.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(cf cfVar) {
                                                    cf cfVar2 = cfVar;
                                                    String substring = str3.substring(0, intRef2.element);
                                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                    cfVar2.text(substring);
                                                    cfVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final String str4 = str;
                                            final Ref.IntRef intRef3 = intRef;
                                            final String str5 = str2;
                                            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.3.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(cf cfVar) {
                                                    cf cfVar2 = cfVar;
                                                    String str6 = str4;
                                                    int i3 = intRef3.element;
                                                    String substring = str6.substring(i3, str5.length() + i3);
                                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                    cfVar2.text(substring);
                                                    cfVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final String str6 = str;
                                            final Ref.IntRef intRef4 = intRef;
                                            final String str7 = str2;
                                            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.3.4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(cf cfVar) {
                                                    cf cfVar2 = cfVar;
                                                    String substring = str6.substring(str7.length() + intRef4.element);
                                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                                    cfVar2.text(substring);
                                                    cfVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                if (QSearchTitleTemplateView.access$getAttr(QSearchTitleTemplateView.this).getData().subTitle.length() > 0) {
                                    final QSearchTitleTemplateView qSearchTitleTemplateView4 = QSearchTitleTemplateView.this;
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final QSearchTitleTemplateView qSearchTitleTemplateView5 = QSearchTitleTemplateView.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.marginLeft(4.0f);
                                                    ceVar2.marginRight(4.0f);
                                                    ceVar2.text("-");
                                                    QSearchTitleTemplateView.access$configTitleAttr(QSearchTitleTemplateView.this, ceVar2);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QSearchTitleTemplateView qSearchTitleTemplateView5 = QSearchTitleTemplateView.this;
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.5
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final QSearchTitleTemplateView qSearchTitleTemplateView6 = QSearchTitleTemplateView.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.5.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.text(QSearchTitleTemplateView.access$getAttr(QSearchTitleTemplateView.this).getData().subTitle);
                                                    QSearchTitleTemplateView.access$configTitleAttr(QSearchTitleTemplateView.this, ceVar2);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.6.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchButtonInfo qSearchButtonInfo = QSearchTitleTemplateView.access$getAttr(QSearchTitleTemplateView.this).getData().moreJumpInfo;
                                if (qSearchButtonInfo != null) {
                                    final QSearchTitleTemplateView qSearchTitleTemplateView6 = QSearchTitleTemplateView.this;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.7
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            final QSearchButtonInfo qSearchButtonInfo2 = QSearchButtonInfo.this;
                                            final QSearchTitleTemplateView qSearchTitleTemplateView7 = qSearchTitleTemplateView6;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.7.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionRow();
                                                    tVar2.alignItemsCenter();
                                                    QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchButtonInfo.this.reportInfo;
                                                    if (qSearchTemplateReportInfo != null) {
                                                        EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchTitleTemplateView7.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QSearchTitleTemplateView qSearchTitleTemplateView8 = qSearchTitleTemplateView6;
                                            final QSearchButtonInfo qSearchButtonInfo3 = QSearchButtonInfo.this;
                                            vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.7.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final QSearchTitleTemplateView qSearchTitleTemplateView9 = QSearchTitleTemplateView.this;
                                                    final QSearchButtonInfo qSearchButtonInfo4 = qSearchButtonInfo3;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.7.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            QSearchTitleTemplateView.this.clickButton(qSearchButtonInfo4);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QSearchButtonInfo qSearchButtonInfo4 = QSearchButtonInfo.this;
                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.7.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final QSearchButtonInfo qSearchButtonInfo5 = QSearchButtonInfo.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.7.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text(QSearchButtonInfo.this.text);
                                                            ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                            ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.7.4
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.1.7.4.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.marginLeft(1.0f);
                                                            afVar2.size(9.0f, 15.0f);
                                                            b.a.b(afVar2, QUISkinImage.INSTANCE.viewMoreArrow(), false, 2, null);
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
                                return Unit.INSTANCE;
                            }
                        });
                        if (QSearchTitleTemplateView.access$getAttr(QSearchTitleTemplateView.this).getData().layoutInfo.showDivider) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.2
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView.buildContent.1.1.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.mo141height(0.5f);
                                            Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                            tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchTitleTemplateAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchTitleTemplateEvent();
    }
}
