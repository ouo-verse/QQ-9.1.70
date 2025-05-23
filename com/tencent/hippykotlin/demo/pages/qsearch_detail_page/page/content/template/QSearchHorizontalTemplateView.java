package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchHorizontalTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchHorizontalTemplateView extends QSearchBaseTemplateView<QSearchHorizontalTemplateModel, QSearchHorizontalAttr, QSearchHorizontalEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchHorizontalAttr access$getAttr(QSearchHorizontalTemplateView qSearchHorizontalTemplateView) {
        return (QSearchHorizontalAttr) qSearchHorizontalTemplateView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchHorizontalTemplateView qSearchHorizontalTemplateView = QSearchHorizontalTemplateView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildContent$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        if (QSearchHorizontalTemplateView.access$getAttr(QSearchHorizontalTemplateView.this).getData().layoutInfo.showDivider) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildContent.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildContent.1.1.1.1
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
                        final QSearchHorizontalTemplateView qSearchHorizontalTemplateView2 = QSearchHorizontalTemplateView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildContent.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildContent.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.paddingTop(12.0f);
                                        tVar2.paddingBottom(12.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                QSearchHorizontalTemplateView qSearchHorizontalTemplateView3 = QSearchHorizontalTemplateView.this;
                                QSearchTemplateUtilKt.buildTitlePart(qSearchHorizontalTemplateView3, QSearchHorizontalTemplateView.access$getAttr(qSearchHorizontalTemplateView3).getData()).invoke(vVar4);
                                final float m3 = vVar4.getPager().getPageData().m() - 48.0f;
                                if (QSearchHorizontalTemplateView.access$getAttr(QSearchHorizontalTemplateView.this).getData().type == 2) {
                                    final QSearchHorizontalTemplateView qSearchHorizontalTemplateView4 = QSearchHorizontalTemplateView.this;
                                    qSearchHorizontalTemplateView4.getClass();
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildCircleItems$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final float f16 = m3;
                                            final QSearchHorizontalTemplateView qSearchHorizontalTemplateView5 = qSearchHorizontalTemplateView4;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildCircleItems$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildCircleItems.1.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            tVar.flexDirectionRow();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    float f17 = f16 - (3 * 8.0f);
                                                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                                                    float f18 = f17 / 4;
                                                    floatRef.element = f18;
                                                    if (f18 <= 0.0f) {
                                                        floatRef.element = 70.0f;
                                                    }
                                                    for (final int i3 = 0; i3 < 4; i3++) {
                                                        final QSearchHorizontalTemplateView qSearchHorizontalTemplateView6 = qSearchHorizontalTemplateView5;
                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildCircleItems.1.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                Object orNull;
                                                                v vVar8 = vVar7;
                                                                final Ref.FloatRef floatRef2 = floatRef;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildCircleItems.1.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.mo153width(Ref.FloatRef.this.element);
                                                                        tVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                orNull = CollectionsKt___CollectionsKt.getOrNull(QSearchHorizontalTemplateView.access$getAttr(QSearchHorizontalTemplateView.this).getData().items, i3);
                                                                final QSearchListItemModel qSearchListItemModel = (QSearchListItemModel) orNull;
                                                                if (qSearchListItemModel != null) {
                                                                    final QSearchHorizontalTemplateView qSearchHorizontalTemplateView7 = QSearchHorizontalTemplateView.this;
                                                                    float f19 = floatRef.element;
                                                                    qSearchHorizontalTemplateView7.getClass();
                                                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildCircleItem$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                                            ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                                            final QSearchListItemModel qSearchListItemModel2 = QSearchListItemModel.this;
                                                                            final QSearchHorizontalTemplateView qSearchHorizontalTemplateView8 = qSearchHorizontalTemplateView7;
                                                                            viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildCircleItem$1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(m mVar) {
                                                                                    m mVar2 = mVar;
                                                                                    mVar2.paddingTop(8.0f);
                                                                                    mVar2.paddingBottom(8.0f);
                                                                                    mVar2.borderRadius(4.0f);
                                                                                    QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchListItemModel.this.reportInfo;
                                                                                    if (qSearchTemplateReportInfo != null) {
                                                                                        EcommerceExtKt.vr$default(mVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchHorizontalTemplateView8.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final QSearchListItemModel qSearchListItemModel3 = QSearchListItemModel.this;
                                                                            if (qSearchListItemModel3.jumpInfo != null) {
                                                                                final QSearchHorizontalTemplateView qSearchHorizontalTemplateView9 = qSearchHorizontalTemplateView7;
                                                                                viewContainer4.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildCircleItem$1.2
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(Event event) {
                                                                                        final QSearchHorizontalTemplateView qSearchHorizontalTemplateView10 = QSearchHorizontalTemplateView.this;
                                                                                        final QSearchListItemModel qSearchListItemModel4 = qSearchListItemModel3;
                                                                                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildCircleItem.1.2.1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                QSearchHorizontalTemplateView.this.doJump(qSearchListItemModel4.jumpInfo, null);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            }
                                                                            final QSearchListItemModel qSearchListItemModel4 = QSearchListItemModel.this;
                                                                            ah.a(viewContainer4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildCircleItem$1.3
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ImageView imageView) {
                                                                                    final QSearchListItemModel qSearchListItemModel5 = QSearchListItemModel.this;
                                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildCircleItem.1.3.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(af afVar) {
                                                                                            af afVar2 = afVar;
                                                                                            afVar2.size(40.0f, 40.0f);
                                                                                            b.a.b(afVar2, QSearchListItemModel.this.icon, false, 2, null);
                                                                                            afVar2.borderRadius(20.0f);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            if (QSearchListItemModel.this.title.length() > 0) {
                                                                                final QSearchListItemModel qSearchListItemModel5 = QSearchListItemModel.this;
                                                                                cg.a(viewContainer4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildCircleItem$1.4
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final QSearchListItemModel qSearchListItemModel6 = QSearchListItemModel.this;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildCircleItem.1.4.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ceVar2.marginTop(8.0f);
                                                                                                ceVar2.text(QSearchListItemModel.this.title);
                                                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                                                ceVar2.lines(1);
                                                                                                ceVar2.textOverFlowTail();
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            }
                                                                            if (QSearchListItemModel.this.desc.length() > 0) {
                                                                                final QSearchListItemModel qSearchListItemModel6 = QSearchListItemModel.this;
                                                                                cg.a(viewContainer4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildCircleItem$1.5
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final QSearchListItemModel qSearchListItemModel7 = QSearchListItemModel.this;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildCircleItem.1.5.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ceVar2.text(QSearchListItemModel.this.desc);
                                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
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
                                                                    }.invoke(vVar8);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        if (i3 < 3) {
                                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildCircleItems.1.1.3
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar7) {
                                                                    vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildCircleItems.1.1.3.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            tVar.m140flex(1.0f);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }.invoke(vVar4);
                                } else {
                                    final QSearchHorizontalTemplateView qSearchHorizontalTemplateView5 = QSearchHorizontalTemplateView.this;
                                    qSearchHorizontalTemplateView5.getClass();
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildRectItems$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final float f16 = m3;
                                            final QSearchHorizontalTemplateView qSearchHorizontalTemplateView6 = qSearchHorizontalTemplateView5;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildRectItems$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildRectItems.1.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            tVar.flexDirectionRow();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    float f17 = f16 - (2 * 8.0f);
                                                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                                                    float f18 = f17 / 3;
                                                    floatRef.element = f18;
                                                    if (f18 <= 0.0f) {
                                                        floatRef.element = 100.0f;
                                                    }
                                                    for (final int i3 = 0; i3 < 3; i3++) {
                                                        final QSearchHorizontalTemplateView qSearchHorizontalTemplateView7 = qSearchHorizontalTemplateView6;
                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildRectItems.1.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                Object orNull;
                                                                v vVar8 = vVar7;
                                                                final Ref.FloatRef floatRef2 = floatRef;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildRectItems.1.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.mo153width(Ref.FloatRef.this.element);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                orNull = CollectionsKt___CollectionsKt.getOrNull(QSearchHorizontalTemplateView.access$getAttr(QSearchHorizontalTemplateView.this).getData().items, i3);
                                                                final QSearchListItemModel qSearchListItemModel = (QSearchListItemModel) orNull;
                                                                if (qSearchListItemModel != null) {
                                                                    final QSearchHorizontalTemplateView qSearchHorizontalTemplateView8 = QSearchHorizontalTemplateView.this;
                                                                    final float f19 = floatRef.element;
                                                                    qSearchHorizontalTemplateView8.getClass();
                                                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildRectItem$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                                            ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                                            final QSearchListItemModel qSearchListItemModel2 = QSearchListItemModel.this;
                                                                            final QSearchHorizontalTemplateView qSearchHorizontalTemplateView9 = qSearchHorizontalTemplateView8;
                                                                            viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildRectItem$1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(m mVar) {
                                                                                    m mVar2 = mVar;
                                                                                    QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchListItemModel.this.reportInfo;
                                                                                    if (qSearchTemplateReportInfo != null) {
                                                                                        EcommerceExtKt.vr$default(mVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchHorizontalTemplateView9.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final QSearchListItemModel qSearchListItemModel3 = QSearchListItemModel.this;
                                                                            if (qSearchListItemModel3.jumpInfo != null) {
                                                                                final QSearchHorizontalTemplateView qSearchHorizontalTemplateView10 = qSearchHorizontalTemplateView8;
                                                                                viewContainer4.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildRectItem$1.2
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(Event event) {
                                                                                        final QSearchHorizontalTemplateView qSearchHorizontalTemplateView11 = QSearchHorizontalTemplateView.this;
                                                                                        final QSearchListItemModel qSearchListItemModel4 = qSearchListItemModel3;
                                                                                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildRectItem.1.2.1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                QSearchHorizontalTemplateView.this.doJump(qSearchListItemModel4.jumpInfo, null);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            }
                                                                            final QSearchListItemModel qSearchListItemModel4 = QSearchListItemModel.this;
                                                                            final float f26 = f19;
                                                                            ah.a(viewContainer4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildRectItem$1.3
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ImageView imageView) {
                                                                                    final QSearchListItemModel qSearchListItemModel5 = QSearchListItemModel.this;
                                                                                    final float f27 = f26;
                                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildRectItem.1.3.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(af afVar) {
                                                                                            af afVar2 = afVar;
                                                                                            b.a.b(afVar2, QSearchListItemModel.this.icon, false, 2, null);
                                                                                            float f28 = f27;
                                                                                            afVar2.size(f28, f28);
                                                                                            afVar2.borderRadius(4.0f);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            if (QSearchListItemModel.this.title.length() > 0) {
                                                                                final QSearchListItemModel qSearchListItemModel5 = QSearchListItemModel.this;
                                                                                cg.a(viewContainer4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildRectItem$1.4
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final QSearchListItemModel qSearchListItemModel6 = QSearchListItemModel.this;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildRectItem.1.4.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ceVar2.marginTop(4.0f);
                                                                                                ceVar2.text(QSearchListItemModel.this.title);
                                                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                                                ceVar2.lines(1);
                                                                                                ceVar2.textOverFlowTail();
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            }
                                                                            if (QSearchListItemModel.this.desc.length() > 0) {
                                                                                final QSearchListItemModel qSearchListItemModel6 = QSearchListItemModel.this;
                                                                                cg.a(viewContainer4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView$buildRectItem$1.5
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final QSearchListItemModel qSearchListItemModel7 = QSearchListItemModel.this;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildRectItem.1.5.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ceVar2.marginTop(4.0f);
                                                                                                ceVar2.text(QSearchListItemModel.this.desc);
                                                                                                ceVar2.fontWeight700();
                                                                                                ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                                                                                ceVar2.fontFamily("Qvideo Digit");
                                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
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
                                                                    }.invoke(vVar8);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        if (i3 < 2) {
                                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildRectItems.1.1.3
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar7) {
                                                                    vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView.buildRectItems.1.1.3.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            tVar.m140flex(1.0f);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }.invoke(vVar4);
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
        return new QSearchHorizontalAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchHorizontalEvent();
    }
}
