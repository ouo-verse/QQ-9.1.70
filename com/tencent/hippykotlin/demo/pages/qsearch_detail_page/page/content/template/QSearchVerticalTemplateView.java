package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchVerticalTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGrayBorderButtonViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
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
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchVerticalTemplateView extends QSearchBaseTemplateView<QSearchVerticalTemplateModel, QSearchVerticalTemplateAttr, QSearchVerticalTemplateEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchVerticalTemplateAttr access$getAttr(QSearchVerticalTemplateView qSearchVerticalTemplateView) {
        return (QSearchVerticalTemplateAttr) qSearchVerticalTemplateView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView$buildContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchVerticalTemplateView qSearchVerticalTemplateView = QSearchVerticalTemplateView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView$buildContent$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        if (QSearchVerticalTemplateView.access$getAttr(QSearchVerticalTemplateView.this).getData().layoutInfo.showDivider) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildContent.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildContent.1.1.1.1
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
                        final QSearchVerticalTemplateView qSearchVerticalTemplateView2 = QSearchVerticalTemplateView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildContent.1.1.2
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildContent.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.paddingTop(12.0f);
                                        tVar2.paddingBottom(12.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                QSearchVerticalTemplateView qSearchVerticalTemplateView3 = QSearchVerticalTemplateView.this;
                                QSearchTemplateUtilKt.buildTitlePart(qSearchVerticalTemplateView3, QSearchVerticalTemplateView.access$getAttr(qSearchVerticalTemplateView3).getData()).invoke(vVar4);
                                ?? r06 = QSearchVerticalTemplateView.access$getAttr(QSearchVerticalTemplateView.this).getData().items;
                                final QSearchVerticalTemplateView qSearchVerticalTemplateView4 = QSearchVerticalTemplateView.this;
                                Iterator it = r06.iterator();
                                final int i3 = 0;
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    int i16 = i3 + 1;
                                    if (i3 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final QSearchListItemModel qSearchListItemModel = (QSearchListItemModel) next;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView$buildContent$1$1$2$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            final int i17 = i3;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView$buildContent$1$1$2$2$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    if (i17 > 0) {
                                                        tVar2.paddingTop(16.0f);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QSearchVerticalTemplateView qSearchVerticalTemplateView5 = QSearchVerticalTemplateView.this;
                                            final QSearchListItemModel qSearchListItemModel2 = qSearchListItemModel;
                                            int i18 = QSearchVerticalTemplateView.$r8$clinit;
                                            qSearchVerticalTemplateView5.getClass();
                                            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView$buildItem$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                                    final QSearchListItemModel qSearchListItemModel3 = QSearchListItemModel.this;
                                                    final QSearchVerticalTemplateView qSearchVerticalTemplateView6 = qSearchVerticalTemplateView5;
                                                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView$buildItem$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar7) {
                                                            v vVar8 = vVar7;
                                                            final QSearchListItemModel qSearchListItemModel4 = QSearchListItemModel.this;
                                                            final QSearchVerticalTemplateView qSearchVerticalTemplateView7 = qSearchVerticalTemplateView6;
                                                            vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(14.0f) + FontModuleExtKt.qqFontScaleAddSize(17.0f) + 48.0f);
                                                                    tVar2.flexDirectionRow();
                                                                    tVar2.alignItemsCenter();
                                                                    QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchListItemModel.this.reportInfo;
                                                                    if (qSearchTemplateReportInfo != null) {
                                                                        EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchVerticalTemplateView7.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final QSearchListItemModel qSearchListItemModel5 = QSearchListItemModel.this;
                                                            if (qSearchListItemModel5.jumpInfo != null) {
                                                                final QSearchVerticalTemplateView qSearchVerticalTemplateView8 = qSearchVerticalTemplateView6;
                                                                vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final QSearchVerticalTemplateView qSearchVerticalTemplateView9 = QSearchVerticalTemplateView.this;
                                                                        final QSearchListItemModel qSearchListItemModel6 = qSearchListItemModel5;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                QSearchVerticalTemplateView.this.doJump(qSearchListItemModel6.jumpInfo, null);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                            }
                                                            if (QSearchListItemModel.this.icon.length() > 0) {
                                                                final QSearchListItemModel qSearchListItemModel6 = QSearchListItemModel.this;
                                                                ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        final QSearchListItemModel qSearchListItemModel7 = QSearchListItemModel.this;
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.marginRight(12.0f);
                                                                                b.a.b(afVar2, QSearchListItemModel.this.icon, false, 2, null);
                                                                                afVar2.size(40.0f, 40.0f);
                                                                                afVar2.borderRadius(4.0f);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                            }
                                                            final QSearchListItemModel qSearchListItemModel7 = QSearchListItemModel.this;
                                                            w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.4
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar9) {
                                                                    v vVar10 = vVar9;
                                                                    vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.4.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            tVar.m140flex(1.0f);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final QSearchListItemModel qSearchListItemModel8 = QSearchListItemModel.this;
                                                                    cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.4.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            final QSearchListItemModel qSearchListItemModel9 = QSearchListItemModel.this;
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.4.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.text(QSearchListItemModel.this.title);
                                                                                    ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                                    ceVar2.lines(1);
                                                                                    ceVar2.textOverFlowTail();
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    if (QSearchListItemModel.this.desc.length() > 0) {
                                                                        final QSearchListItemModel qSearchListItemModel9 = QSearchListItemModel.this;
                                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.4.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final QSearchListItemModel qSearchListItemModel10 = QSearchListItemModel.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.4.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ceVar2.marginTop(4.0f);
                                                                                        ceVar2.text(QSearchListItemModel.this.desc);
                                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                                        ceVar2.lines(1);
                                                                                        ceVar2.textOverFlowTail();
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
                                                            final QSearchButtonInfo qSearchButtonInfo = QSearchListItemModel.this.button;
                                                            if (qSearchButtonInfo != null) {
                                                                final QSearchVerticalTemplateView qSearchVerticalTemplateView9 = qSearchVerticalTemplateView6;
                                                                QSearchGrayBorderButtonViewKt.QSearchGrayBorderButton(vVar8, new Function1<QSearchGrayBorderButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.5
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(QSearchGrayBorderButtonView qSearchGrayBorderButtonView) {
                                                                        QSearchGrayBorderButtonView qSearchGrayBorderButtonView2 = qSearchGrayBorderButtonView;
                                                                        final QSearchButtonInfo qSearchButtonInfo2 = QSearchButtonInfo.this;
                                                                        final QSearchVerticalTemplateView qSearchVerticalTemplateView10 = qSearchVerticalTemplateView9;
                                                                        qSearchGrayBorderButtonView2.attr(new Function1<QSearchGrayBorderButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.5.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr) {
                                                                                QSearchGrayBorderButtonAttr qSearchGrayBorderButtonAttr2 = qSearchGrayBorderButtonAttr;
                                                                                qSearchGrayBorderButtonAttr2.text = QSearchButtonInfo.this.text;
                                                                                qSearchGrayBorderButtonAttr2.status = 0;
                                                                                qSearchGrayBorderButtonAttr2.marginLeft(12.0f);
                                                                                QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchButtonInfo.this.reportInfo;
                                                                                if (qSearchTemplateReportInfo != null) {
                                                                                    EcommerceExtKt.vr$default(qSearchGrayBorderButtonAttr2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchVerticalTemplateView10.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QSearchVerticalTemplateView qSearchVerticalTemplateView11 = qSearchVerticalTemplateView9;
                                                                        final QSearchButtonInfo qSearchButtonInfo3 = QSearchButtonInfo.this;
                                                                        qSearchGrayBorderButtonView2.event(new Function1<QSearchGrayBorderButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.5.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(QSearchGrayBorderButtonEvent qSearchGrayBorderButtonEvent) {
                                                                                final QSearchVerticalTemplateView qSearchVerticalTemplateView12 = QSearchVerticalTemplateView.this;
                                                                                final QSearchButtonInfo qSearchButtonInfo4 = qSearchButtonInfo3;
                                                                                qSearchGrayBorderButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView.buildItem.1.1.5.2.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        QSearchVerticalTemplateView.this.clickButton(qSearchButtonInfo4);
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
                                                    return Unit.INSTANCE;
                                                }
                                            }.invoke(vVar6);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    i3 = i16;
                                }
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
        return new QSearchVerticalTemplateAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchVerticalTemplateEvent();
    }
}
