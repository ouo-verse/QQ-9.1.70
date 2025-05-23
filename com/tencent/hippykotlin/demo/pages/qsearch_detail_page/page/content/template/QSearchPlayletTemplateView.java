package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchPlayletTemplateModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes32.dex */
public final class QSearchPlayletTemplateView extends QSearchBaseTemplateView<QSearchPlayletTemplateModel, QSearchPlayletVideoAttr, QQSearchPlayletVideoEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$buildCover(QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        return new QSearchPlayletTemplateView$buildCover$1(((QSearchPlayletVideoAttr) qSearchPlayletTemplateView.getAttr()).getData().getContentData(), qSearchPlayletTemplateView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$buildDescription(QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        return new QSearchPlayletTemplateView$buildDescription$1(((QSearchPlayletVideoAttr) qSearchPlayletTemplateView.getAttr()).getData().getContentData(), qSearchPlayletTemplateView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$buildItems(QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        return new QSearchPlayletTemplateView$buildItems$1(((QSearchPlayletVideoAttr) qSearchPlayletTemplateView.getAttr()).getData().getContentData(), qSearchPlayletTemplateView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$buildPlayButton(QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        return new QSearchPlayletTemplateView$buildPlayButton$1(((QSearchPlayletVideoAttr) qSearchPlayletTemplateView.getAttr()).getData().getContentData(), qSearchPlayletTemplateView);
    }

    public static final Function1 access$buildSingleItem(QSearchPlayletTemplateView qSearchPlayletTemplateView, QSearchButton qSearchButton, boolean z16) {
        qSearchPlayletTemplateView.getClass();
        return new QSearchPlayletTemplateView$buildSingleItem$1(z16, qSearchButton, qSearchPlayletTemplateView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$buildSubTitle(QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        return new QSearchPlayletTemplateView$buildSubTitle$1(((QSearchPlayletVideoAttr) qSearchPlayletTemplateView.getAttr()).getData().getContentData(), qSearchPlayletTemplateView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$buildTitle(QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        return new QSearchPlayletTemplateView$buildTitle$1(((QSearchPlayletVideoAttr) qSearchPlayletTemplateView.getAttr()).getData().getContentData(), qSearchPlayletTemplateView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchPlayletVideoAttr access$getAttr(QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        return (QSearchPlayletVideoAttr) qSearchPlayletTemplateView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                if (QSearchPlayletTemplateView.access$getAttr(QSearchPlayletTemplateView.this).getData().layoutInfo.showDivider) {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildContent$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildContent.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.mo141height(0.5f);
                                    tVar2.absolutePositionAllZero();
                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                final QSearchPlayletTemplateView qSearchPlayletTemplateView = QSearchPlayletTemplateView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildContent$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildContent.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingTop(12.0f);
                                tVar2.paddingBottom(12.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchPlayletTemplateView qSearchPlayletTemplateView2 = QSearchPlayletTemplateView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildContent.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildContent.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.paddingBottom(12.0f);
                                        tVar2.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                ((QSearchPlayletTemplateView$buildCover$1) QSearchPlayletTemplateView.access$buildCover(QSearchPlayletTemplateView.this)).invoke(vVar4);
                                final QSearchPlayletTemplateView qSearchPlayletTemplateView3 = QSearchPlayletTemplateView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildContent.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildContent.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.paddingLeft(12.0f);
                                                tVar2.paddingRight(12.0f);
                                                tVar2.m140flex(1.0f);
                                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(14.0f) + (FontModuleExtKt.qqFontScaleAddSize(12.0f) * 2) + FontModuleExtKt.qqFontScaleAddSize(14.0f) + FontModuleExtKt.qqFontScaleAddSize(20.0f) + 167.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ((QSearchPlayletTemplateView$buildTitle$1) QSearchPlayletTemplateView.access$buildTitle(QSearchPlayletTemplateView.this)).invoke(vVar6);
                                        ((QSearchPlayletTemplateView$buildSubTitle$1) QSearchPlayletTemplateView.access$buildSubTitle(QSearchPlayletTemplateView.this)).invoke(vVar6);
                                        final QSearchPlayletTemplateView qSearchPlayletTemplateView4 = QSearchPlayletTemplateView.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildContent.1.2.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildContent.1.2.2.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.justifyContentFlexEnd();
                                                        tVar2.m140flex(1.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ((QSearchPlayletTemplateView$buildDescription$1) QSearchPlayletTemplateView.access$buildDescription(QSearchPlayletTemplateView.this)).invoke(vVar8);
                                                ((QSearchPlayletTemplateView$buildPlayButton$1) QSearchPlayletTemplateView.access$buildPlayButton(QSearchPlayletTemplateView.this)).invoke(vVar8);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ((QSearchPlayletTemplateView$buildItems$1) QSearchPlayletTemplateView.access$buildItems(QSearchPlayletTemplateView.this)).invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchPlayletVideoAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QQSearchPlayletVideoEvent();
    }
}
