package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTitleGroupTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTemplateUtilKt {
    public static final Function1<ViewContainer<?, ?>, Unit> buildTitlePart(final QSearchBaseTemplateView<?, ?, ?> qSearchBaseTemplateView, final QSearchBaseTitleGroupTemplateModel qSearchBaseTitleGroupTemplateModel) {
        if (qSearchBaseTitleGroupTemplateModel.title.length() == 0) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt$buildTitlePart$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt$buildTitlePart$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchBaseTitleGroupTemplateModel qSearchBaseTitleGroupTemplateModel2 = QSearchBaseTitleGroupTemplateModel.this;
                final QSearchBaseTemplateView<?, ?, ?> qSearchBaseTemplateView2 = qSearchBaseTemplateView;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt$buildTitlePart$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.paddingBottom(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchBaseTitleGroupTemplateModel qSearchBaseTitleGroupTemplateModel3 = QSearchBaseTitleGroupTemplateModel.this;
                        final QSearchBaseTemplateView<?, ?, ?> qSearchBaseTemplateView3 = qSearchBaseTemplateView2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(14.0f) + 20.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchBaseTitleGroupTemplateModel qSearchBaseTitleGroupTemplateModel4 = QSearchBaseTitleGroupTemplateModel.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final QSearchBaseTitleGroupTemplateModel qSearchBaseTitleGroupTemplateModel5 = QSearchBaseTitleGroupTemplateModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginRight(20.0f);
                                                ceVar2.m140flex(1.0f);
                                                ceVar2.text(QSearchBaseTitleGroupTemplateModel.this.title);
                                                ceVar2.lines(1);
                                                ceVar2.textOverFlowTail();
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchButtonInfo qSearchButtonInfo = QSearchBaseTitleGroupTemplateModel.this.moreJumpInfo;
                                if (qSearchButtonInfo != null) {
                                    final QSearchBaseTemplateView<?, ?, ?> qSearchBaseTemplateView4 = qSearchBaseTemplateView3;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            final QSearchButtonInfo qSearchButtonInfo2 = QSearchButtonInfo.this;
                                            final QSearchBaseTemplateView<?, ?, ?> qSearchBaseTemplateView5 = qSearchBaseTemplateView4;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.3.1
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
                                                        EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchBaseTemplateView5.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QSearchBaseTemplateView<?, ?, ?> qSearchBaseTemplateView6 = qSearchBaseTemplateView4;
                                            final QSearchButtonInfo qSearchButtonInfo3 = QSearchButtonInfo.this;
                                            vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.3.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final QSearchBaseTemplateView<?, ?, ?> qSearchBaseTemplateView7 = qSearchBaseTemplateView6;
                                                    final QSearchButtonInfo qSearchButtonInfo4 = qSearchButtonInfo3;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.3.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            qSearchBaseTemplateView7.clickButton(qSearchButtonInfo4);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.3.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.3.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text("\u66f4\u591a");
                                                            ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                            ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.3.4
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt.buildTitlePart.2.1.2.3.4.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.marginLeft(8.0f);
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
