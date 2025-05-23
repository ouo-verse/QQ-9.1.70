package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchIconModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
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
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchGameTemplateView$buildIconRow$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchGameTemplateView $ctx;
    public final /* synthetic */ List<QSearchIconModel> $iconList;
    public final /* synthetic */ boolean $needPlaceholder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchGameTemplateView$buildIconRow$1(List<QSearchIconModel> list, QSearchGameTemplateView qSearchGameTemplateView, boolean z16) {
        super(1);
        this.$iconList = list;
        this.$ctx = qSearchGameTemplateView;
        this.$needPlaceholder = z16;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final List<QSearchIconModel> list = this.$iconList;
        final QSearchGameTemplateView qSearchGameTemplateView = this.$ctx;
        final boolean z16 = this.$needPlaceholder;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildIconRow$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIconRow.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        tVar.flexDirectionRow();
                        return Unit.INSTANCE;
                    }
                });
                for (final QSearchIconModel qSearchIconModel : list) {
                    final QSearchGameTemplateView qSearchGameTemplateView2 = qSearchGameTemplateView;
                    KProperty<Object>[] kPropertyArr = QSearchGameTemplateView.$$delegatedProperties;
                    qSearchGameTemplateView2.getClass();
                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildSingleIcon$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                            final QSearchIconModel qSearchIconModel2 = QSearchIconModel.this;
                            final QSearchGameTemplateView qSearchGameTemplateView3 = qSearchGameTemplateView2;
                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildSingleIcon$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    final QSearchIconModel qSearchIconModel3 = QSearchIconModel.this;
                                    final QSearchGameTemplateView qSearchGameTemplateView4 = qSearchGameTemplateView3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildSingleIcon.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.m140flex(1.0f);
                                            tVar2.alignItemsCenter();
                                            QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchIconModel.this.reportInfo;
                                            if (qSearchTemplateReportInfo != null) {
                                                EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchGameTemplateView4.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QSearchIconModel qSearchIconModel4 = QSearchIconModel.this;
                                    if (qSearchIconModel4.jumpInfo != null) {
                                        final QSearchGameTemplateView qSearchGameTemplateView5 = qSearchGameTemplateView3;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildSingleIcon.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final QSearchGameTemplateView qSearchGameTemplateView6 = QSearchGameTemplateView.this;
                                                final QSearchIconModel qSearchIconModel5 = qSearchIconModel4;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildSingleIcon.1.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        QSearchGameTemplateView.this.doJump(qSearchIconModel5.jumpInfo, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                    final QSearchIconModel qSearchIconModel5 = QSearchIconModel.this;
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildSingleIcon.1.1.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final QSearchIconModel qSearchIconModel6 = QSearchIconModel.this;
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildSingleIcon.1.1.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    b.a.b(afVar2, QSearchIconModel.this.url, false, 2, null);
                                                    afVar2.size(24.0f, 24.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    if (QSearchIconModel.this.title.length() > 0) {
                                        final QSearchIconModel qSearchIconModel6 = QSearchIconModel.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildSingleIcon.1.1.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final QSearchIconModel qSearchIconModel7 = QSearchIconModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildSingleIcon.1.1.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.m144maxWidth(70.0f);
                                                        ceVar2.marginTop(4.0f);
                                                        ceVar2.text(QSearchIconModel.this.title);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
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
                            });
                            return Unit.INSTANCE;
                        }
                    }.invoke(vVar2);
                }
                if (z16) {
                    int size = 4 - list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIconRow.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIconRow.1.1.2.1
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
}
