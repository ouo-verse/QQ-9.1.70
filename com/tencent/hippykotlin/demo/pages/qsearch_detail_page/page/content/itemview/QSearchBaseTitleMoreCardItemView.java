package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.ITabPager;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopTitleMoreCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QSearchBaseTitleMoreCardItemView<A extends QSearchBaseTitleMoreCardItemAttr> extends QSearchReportView<A, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseTitleMoreCardItemView.class, "canShowMore", "getCanShowMore()Z", 0)};
    public final ReadWriteProperty canShowMore$delegate = c.a(Boolean.FALSE);

    public static final ce access$configTitleAttr(QSearchBaseTitleMoreCardItemView qSearchBaseTitleMoreCardItemView, ce ceVar) {
        qSearchBaseTitleMoreCardItemView.getClass();
        ce.fontSize$default(ceVar, 17.0f, null, 2, null);
        ceVar.fontWeight400();
        return ceVar.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchBaseTitleMoreCardItemAttr access$getAttr(QSearchBaseTitleMoreCardItemView qSearchBaseTitleMoreCardItemView) {
        return (QSearchBaseTitleMoreCardItemAttr) qSearchBaseTitleMoreCardItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView$body$1
            public final /* synthetic */ QSearchBaseTitleMoreCardItemView<A> $ctx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$ctx = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchBaseTitleMoreCardItemView<A> qSearchBaseTitleMoreCardItemView = this.$ctx;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView2 = qSearchBaseTitleMoreCardItemView;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.padding(qSearchBaseTitleMoreCardItemView2.paddingTop(), 8.0f, 0.0f, 8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView3 = qSearchBaseTitleMoreCardItemView;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView4 = qSearchBaseTitleMoreCardItemView3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.paddingLeft(16.0f);
                                        tVar2.paddingRight(16.0f);
                                        tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                                        float f16 = qSearchBaseTitleMoreCardItemView4.topBorderRadius();
                                        float f17 = qSearchBaseTitleMoreCardItemView4.topBorderRadius();
                                        qSearchBaseTitleMoreCardItemView4.getClass();
                                        qSearchBaseTitleMoreCardItemView4.getClass();
                                        tVar2.borderRadius(f16, f17, 8.0f, 8.0f);
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (qSearchBaseTitleMoreCardItemView3.needShowTitle()) {
                                    final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView5 = qSearchBaseTitleMoreCardItemView3;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 49.0f);
                                                    tVar2.flexDirectionRow();
                                                    tVar2.alignItemsCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView6 = qSearchBaseTitleMoreCardItemView5;
                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView7 = qSearchBaseTitleMoreCardItemView6;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                            ceVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                                            ceVar2.text(QSearchBaseTitleMoreCardItemView.access$getAttr(qSearchBaseTitleMoreCardItemView7).keyword);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView7 = qSearchBaseTitleMoreCardItemView5;
                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView8 = qSearchBaseTitleMoreCardItemView7;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginLeft(4.0f);
                                                            ceVar2.marginRight(4.0f);
                                                            ceVar2.text("-");
                                                            QSearchBaseTitleMoreCardItemView.access$configTitleAttr(qSearchBaseTitleMoreCardItemView8, ceVar2);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView8 = qSearchBaseTitleMoreCardItemView5;
                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView9 = qSearchBaseTitleMoreCardItemView8;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.4.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text(QSearchBaseTitleMoreCardItemView.access$getAttr(qSearchBaseTitleMoreCardItemView9).tabName);
                                                            QSearchBaseTitleMoreCardItemView.access$configTitleAttr(qSearchBaseTitleMoreCardItemView9, ceVar2);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView9 = qSearchBaseTitleMoreCardItemView5;
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    v vVar8 = vVar7;
                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.m140flex(1.0f);
                                                            tVar2.alignItemsFlexEnd();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView10 = qSearchBaseTitleMoreCardItemView9;
                                                    qSearchBaseTitleMoreCardItemView10.canShowMore$delegate.setValue(qSearchBaseTitleMoreCardItemView10, QSearchBaseTitleMoreCardItemView.$$delegatedProperties[0], Boolean.valueOf(qSearchBaseTitleMoreCardItemView10.canShowMoreText()));
                                                    final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView11 = qSearchBaseTitleMoreCardItemView9;
                                                    Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView12 = qSearchBaseTitleMoreCardItemView11;
                                                            return Boolean.valueOf(((Boolean) qSearchBaseTitleMoreCardItemView12.canShowMore$delegate.getValue(qSearchBaseTitleMoreCardItemView12, QSearchBaseTitleMoreCardItemView.$$delegatedProperties[0])).booleanValue());
                                                        }
                                                    };
                                                    final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView12 = qSearchBaseTitleMoreCardItemView9;
                                                    ConditionViewKt.c(vVar8, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ConditionView conditionView) {
                                                            final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView13 = qSearchBaseTitleMoreCardItemView12;
                                                            w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.3.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar9) {
                                                                    v vVar10 = vVar9;
                                                                    final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView14 = qSearchBaseTitleMoreCardItemView13;
                                                                    vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.3.1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.flexDirectionRow();
                                                                            tVar2.alignItemsCenter();
                                                                            EcommerceExtKt.elementVR(tVar2, "em_search_more_btn", qSearchBaseTitleMoreCardItemView14.getReportParams());
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView15 = qSearchBaseTitleMoreCardItemView13;
                                                                    vVar10.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.3.1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(u uVar) {
                                                                            final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView16 = qSearchBaseTitleMoreCardItemView15;
                                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.3.1.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView17 = qSearchBaseTitleMoreCardItemView16;
                                                                                    Integer jumpTabWhenClickMore = qSearchBaseTitleMoreCardItemView17.getJumpTabWhenClickMore();
                                                                                    if (jumpTabWhenClickMore != null) {
                                                                                        int intValue = jumpTabWhenClickMore.intValue();
                                                                                        b pager = qSearchBaseTitleMoreCardItemView17.getPager();
                                                                                        ITabPager iTabPager = pager instanceof ITabPager ? (ITabPager) pager : null;
                                                                                        if (iTabPager != null) {
                                                                                            iTabPager.jumpToTab(intValue);
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.3.1.3
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.3.1.3.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.text("\u66f4\u591a");
                                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                    ceVar2.fontWeight400();
                                                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    ah.a(vVar10, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.3.1.4
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.2.5.3.1.4.1
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
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.mo141height(0.5f);
                                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                final QSearchBaseTitleMoreCardItemView<QSearchBaseTitleMoreCardItemAttr> qSearchBaseTitleMoreCardItemView6 = qSearchBaseTitleMoreCardItemView3;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView.body.1.1.2.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginTop(6.0f);
                                                tVar2.flexDirectionColumn();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        qSearchBaseTitleMoreCardItemView6.buildItems().invoke(vVar6);
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

    public abstract Function1<ViewContainer<?, ?>, Unit> buildItems();

    public final boolean canShowMoreText() {
        Integer jumpTabWhenClickMore = getJumpTabWhenClickMore();
        if (jumpTabWhenClickMore == null) {
            return false;
        }
        int intValue = jumpTabWhenClickMore.intValue();
        com.tencent.kuikly.core.pager.b pager = getPager();
        ITabPager iTabPager = pager instanceof ITabPager ? (ITabPager) pager : null;
        if (iTabPager != null) {
            return iTabPager.hasTab(intValue);
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        com.tencent.kuikly.core.pager.b pager = getPager();
        final QSearchDetailPage qSearchDetailPage = pager instanceof QSearchDetailPage ? (QSearchDetailPage) pager : null;
        if (qSearchDetailPage != null) {
            bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView$created$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return QSearchDetailPage.this.viewModel.getContentPageViewModel().getTabTypeList();
                }
            }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView$created$1$2
                public final /* synthetic */ QSearchBaseTitleMoreCardItemView<A> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    QSearchBaseTitleMoreCardItemView<A> qSearchBaseTitleMoreCardItemView = this.this$0;
                    qSearchBaseTitleMoreCardItemView.canShowMore$delegate.setValue(qSearchBaseTitleMoreCardItemView, QSearchBaseTitleMoreCardItemView.$$delegatedProperties[0], Boolean.valueOf(qSearchBaseTitleMoreCardItemView.canShowMoreText()));
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public Integer getJumpTabWhenClickMore() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e getReportParams() {
        e baseReportParams = getBaseReportParams();
        baseReportParams.v("search_query_text", ((QSearchBaseTitleMoreCardItemAttr) getAttr()).keyword);
        baseReportParams.v("search_trace_id", ((QSearchBaseTitleMoreCardItemAttr) getAttr()).traceId);
        com.tencent.kuikly.core.pager.b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            baseReportParams.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            baseReportParams.v("user_source", String.valueOf(iSearchReport.getUserSource()));
        }
        return baseReportParams;
    }

    public boolean needShowTitle() {
        return !(this instanceof QSearchTroopTitleMoreCardItemView);
    }

    public float paddingTop() {
        return 8.0f;
    }

    public float topBorderRadius() {
        return 8.0f;
    }
}
