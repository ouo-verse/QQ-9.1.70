package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelWholeCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelWholeCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.ContentRule;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchGuildTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.RankRule;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchGuildTabContentView extends QSearchTabContentView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchGuildTabContentView.class, "menuStatus", "getMenuStatus()I", 0)};
    public final ReadWriteProperty menuStatus$delegate = c.a(0);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTabContentAttr access$getAttr(QSearchGuildTabContentView qSearchGuildTabContentView) {
        return (QSearchTabContentAttr) qSearchGuildTabContentView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final QSearchGuildTabContentViewModel access$getViewModel(QSearchGuildTabContentView qSearchGuildTabContentView) {
        QSearchTabContentViewModel viewModel = ((QSearchTabContentAttr) qSearchGuildTabContentView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchGuildTabContentViewModel");
        return (QSearchGuildTabContentViewModel) viewModel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchGuildTabContentView qSearchGuildTabContentView = QSearchGuildTabContentView.this;
                final QSearchGuildTabContentView qSearchGuildTabContentView2 = this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionColumn();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchGuildTabContentView qSearchGuildTabContentView3 = QSearchGuildTabContentView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.padding(0.0f, 16.0f, 12.0f, 16.0f);
                                        tVar2.alignItemsCenter();
                                        tVar2.flexDirectionRow();
                                        tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_primary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchGuildTabContentView qSearchGuildTabContentView4 = QSearchGuildTabContentView.this;
                                QSearchLabelViewKt.QSearchLabelView(vVar4, new Function1<QSearchLabelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchLabelView qSearchLabelView) {
                                        QSearchLabelView qSearchLabelView2 = qSearchLabelView;
                                        final QSearchGuildTabContentView qSearchGuildTabContentView5 = QSearchGuildTabContentView.this;
                                        qSearchLabelView2.attr(new Function1<QSearchLabelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchLabelAttr qSearchLabelAttr) {
                                                int intValue;
                                                QSearchLabelAttr qSearchLabelAttr2 = qSearchLabelAttr;
                                                qSearchLabelAttr2.m140flex(1.0f);
                                                qSearchLabelAttr2.setLabel(QSearchGuildTabContentView.access$getViewModel(QSearchGuildTabContentView.this).getSelectedRankRule().text);
                                                intValue = ((Number) r9.menuStatus$delegate.getValue(QSearchGuildTabContentView.this, QSearchGuildTabContentView.$$delegatedProperties[0])).intValue();
                                                qSearchLabelAttr2.setSelected(intValue == 1);
                                                e baseReportParams = QSearchGuildTabContentView.this.getBaseReportParams();
                                                baseReportParams.t("sort_type", 0);
                                                Unit unit = Unit.INSTANCE;
                                                EcommerceExtKt.vr$default(qSearchLabelAttr2, null, "em_bas_channel_tab_sort_area", baseReportParams, null, null, false, 57);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchGuildTabContentView qSearchGuildTabContentView6 = QSearchGuildTabContentView.this;
                                        qSearchLabelView2.event(new Function1<QSearchLabelEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchLabelEvent qSearchLabelEvent) {
                                                final QSearchGuildTabContentView qSearchGuildTabContentView7 = QSearchGuildTabContentView.this;
                                                qSearchLabelEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        int intValue;
                                                        QSearchGuildTabContentView qSearchGuildTabContentView8 = QSearchGuildTabContentView.this;
                                                        intValue = ((Number) qSearchGuildTabContentView8.menuStatus$delegate.getValue(qSearchGuildTabContentView8, QSearchGuildTabContentView.$$delegatedProperties[0])).intValue();
                                                        qSearchGuildTabContentView8.menuStatus$delegate.setValue(qSearchGuildTabContentView8, QSearchGuildTabContentView.$$delegatedProperties[0], Integer.valueOf(intValue == 1 ? 0 : 1));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchGuildTabContentView qSearchGuildTabContentView5 = QSearchGuildTabContentView.this;
                                QSearchLabelViewKt.QSearchLabelView(vVar4, new Function1<QSearchLabelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchLabelView qSearchLabelView) {
                                        QSearchLabelView qSearchLabelView2 = qSearchLabelView;
                                        final QSearchGuildTabContentView qSearchGuildTabContentView6 = QSearchGuildTabContentView.this;
                                        qSearchLabelView2.attr(new Function1<QSearchLabelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchLabelAttr qSearchLabelAttr) {
                                                int intValue;
                                                QSearchLabelAttr qSearchLabelAttr2 = qSearchLabelAttr;
                                                qSearchLabelAttr2.m140flex(1.0f);
                                                qSearchLabelAttr2.margin(0.0f, 8.0f, 0.0f, 8.0f);
                                                qSearchLabelAttr2.setLabel(QSearchGuildTabContentView.access$getViewModel(QSearchGuildTabContentView.this).getSelectedContentRule().text);
                                                intValue = ((Number) r9.menuStatus$delegate.getValue(QSearchGuildTabContentView.this, QSearchGuildTabContentView.$$delegatedProperties[0])).intValue();
                                                qSearchLabelAttr2.setSelected(intValue == 2);
                                                e baseReportParams = QSearchGuildTabContentView.this.getBaseReportParams();
                                                baseReportParams.t("sort_type", 1);
                                                Unit unit = Unit.INSTANCE;
                                                EcommerceExtKt.vr$default(qSearchLabelAttr2, null, "em_bas_channel_tab_sort_area", baseReportParams, null, null, false, 57);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchGuildTabContentView qSearchGuildTabContentView7 = QSearchGuildTabContentView.this;
                                        qSearchLabelView2.event(new Function1<QSearchLabelEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchLabelEvent qSearchLabelEvent) {
                                                final QSearchGuildTabContentView qSearchGuildTabContentView8 = QSearchGuildTabContentView.this;
                                                qSearchLabelEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        int intValue;
                                                        QSearchGuildTabContentView qSearchGuildTabContentView9 = QSearchGuildTabContentView.this;
                                                        intValue = ((Number) qSearchGuildTabContentView9.menuStatus$delegate.getValue(qSearchGuildTabContentView9, QSearchGuildTabContentView.$$delegatedProperties[0])).intValue();
                                                        qSearchGuildTabContentView9.menuStatus$delegate.setValue(qSearchGuildTabContentView9, QSearchGuildTabContentView.$$delegatedProperties[0], Integer.valueOf(intValue == 2 ? 0 : 2));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.2.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.paddingLeft(16.0f);
                                                tVar2.paddingRight(16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchGuildTabContentView qSearchGuildTabContentView4 = qSearchGuildTabContentView2;
                        final QSearchGuildTabContentView qSearchGuildTabContentView5 = QSearchGuildTabContentView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                QSearchGuildTabContentView qSearchGuildTabContentView6 = QSearchGuildTabContentView.this;
                                KProperty<Object>[] kPropertyArr = QSearchGuildTabContentView.$$delegatedProperties;
                                qSearchGuildTabContentView6.getClass();
                                new QSearchTabContentView$body$1(qSearchGuildTabContentView6).invoke(vVar4);
                                final QSearchGuildTabContentView qSearchGuildTabContentView7 = qSearchGuildTabContentView5;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        int intValue;
                                        intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchGuildTabContentView.this, QSearchGuildTabContentView.$$delegatedProperties[0])).intValue();
                                        return Boolean.valueOf(intValue != 0);
                                    }
                                };
                                final QSearchGuildTabContentView qSearchGuildTabContentView8 = qSearchGuildTabContentView5;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final QSearchGuildTabContentView qSearchGuildTabContentView9 = QSearchGuildTabContentView.this;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m154zIndex(20);
                                                        tVar2.absolutePositionAllZero();
                                                        tVar2.flexDirectionColumn();
                                                        tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("overlay_dark"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchGuildTabContentView qSearchGuildTabContentView10 = QSearchGuildTabContentView.this;
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final QSearchGuildTabContentView qSearchGuildTabContentView11 = QSearchGuildTabContentView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                r2.menuStatus$delegate.setValue(QSearchGuildTabContentView.this, QSearchGuildTabContentView.$$delegatedProperties[0], Integer.valueOf(0));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchGuildTabContentView qSearchGuildTabContentView11 = QSearchGuildTabContentView.this;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionColumn();
                                                                tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("bg_bottom_light"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchGuildTabContentView qSearchGuildTabContentView12 = QSearchGuildTabContentView.this;
                                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.3.2
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                int intValue;
                                                                intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchGuildTabContentView.this, QSearchGuildTabContentView.$$delegatedProperties[0])).intValue();
                                                                return Boolean.valueOf(intValue == 1);
                                                            }
                                                        };
                                                        final QSearchGuildTabContentView qSearchGuildTabContentView13 = QSearchGuildTabContentView.this;
                                                        ConditionViewKt.c(vVar8, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.3.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView2) {
                                                                ConditionView conditionView3 = conditionView2;
                                                                List<RankRule> list = QSearchGuildTabContentView.access$getViewModel(QSearchGuildTabContentView.this).rankRules;
                                                                final QSearchGuildTabContentView qSearchGuildTabContentView14 = QSearchGuildTabContentView.this;
                                                                for (final RankRule rankRule : list) {
                                                                    QSearchLabelItemViewKt.QSearchLabelItemView(conditionView3, rankRule.text, Intrinsics.areEqual(rankRule, QSearchGuildTabContentView.access$getViewModel(qSearchGuildTabContentView14).getSelectedRankRule()), new Function1<QSearchLabelItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$body$1$1$3$3$1$3$3$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QSearchLabelItemView qSearchLabelItemView) {
                                                                            QSearchLabelItemView qSearchLabelItemView2 = qSearchLabelItemView;
                                                                            final QSearchGuildTabContentView qSearchGuildTabContentView15 = QSearchGuildTabContentView.this;
                                                                            final RankRule rankRule2 = rankRule;
                                                                            qSearchLabelItemView2.attr(new Function1<QSearchLabelItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$body$1$1$3$3$1$3$3$1$1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(QSearchLabelItemAttr qSearchLabelItemAttr) {
                                                                                    QSearchLabelItemAttr qSearchLabelItemAttr2 = qSearchLabelItemAttr;
                                                                                    QSearchGuildTabContentView qSearchGuildTabContentView16 = QSearchGuildTabContentView.this;
                                                                                    KProperty<Object>[] kPropertyArr2 = QSearchGuildTabContentView.$$delegatedProperties;
                                                                                    e baseReportParams = qSearchGuildTabContentView16.getBaseReportParams();
                                                                                    RankRule rankRule3 = rankRule2;
                                                                                    baseReportParams.t("sort_type", 0);
                                                                                    baseReportParams.v("filter_tag", rankRule3.text);
                                                                                    Unit unit = Unit.INSTANCE;
                                                                                    EcommerceExtKt.vr$default(qSearchLabelItemAttr2, null, "em_bas_screening_panel", baseReportParams, null, null, false, 57);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final QSearchGuildTabContentView qSearchGuildTabContentView16 = QSearchGuildTabContentView.this;
                                                                            final RankRule rankRule3 = rankRule;
                                                                            qSearchLabelItemView2.event(new Function1<QSearchLabelItemEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$body$1$1$3$3$1$3$3$1$1.2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(QSearchLabelItemEvent qSearchLabelItemEvent) {
                                                                                    final QSearchGuildTabContentView qSearchGuildTabContentView17 = QSearchGuildTabContentView.this;
                                                                                    final RankRule rankRule4 = rankRule3;
                                                                                    qSearchLabelItemEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.3.3.1.1.2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                            r9.menuStatus$delegate.setValue(QSearchGuildTabContentView.this, QSearchGuildTabContentView.$$delegatedProperties[0], Integer.valueOf(0));
                                                                                            QSearchGuildTabContentViewModel access$getViewModel = QSearchGuildTabContentView.access$getViewModel(QSearchGuildTabContentView.this);
                                                                                            RankRule rankRule5 = rankRule4;
                                                                                            access$getViewModel.getClass();
                                                                                            if (rankRule5.f114296id != access$getViewModel.getSelectedRankRule().f114296id) {
                                                                                                access$getViewModel.selectedRankRule$delegate.setValue(access$getViewModel, QSearchGuildTabContentViewModel.$$delegatedProperties[0], rankRule5);
                                                                                                access$getViewModel.reset();
                                                                                                access$getViewModel.loadData(access$getViewModel.keyword, access$getViewModel.querySource, false, null);
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
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchGuildTabContentView qSearchGuildTabContentView14 = QSearchGuildTabContentView.this;
                                                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.3.4
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                int intValue;
                                                                intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchGuildTabContentView.this, QSearchGuildTabContentView.$$delegatedProperties[0])).intValue();
                                                                return Boolean.valueOf(2 == intValue);
                                                            }
                                                        };
                                                        final QSearchGuildTabContentView qSearchGuildTabContentView15 = QSearchGuildTabContentView.this;
                                                        ConditionViewKt.b(vVar8, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.3.5
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView2) {
                                                                ConditionView conditionView3 = conditionView2;
                                                                List<ContentRule> list = QSearchGuildTabContentView.access$getViewModel(QSearchGuildTabContentView.this).contentRules;
                                                                final QSearchGuildTabContentView qSearchGuildTabContentView16 = QSearchGuildTabContentView.this;
                                                                for (final ContentRule contentRule : list) {
                                                                    QSearchLabelItemViewKt.QSearchLabelItemView(conditionView3, contentRule.text, Intrinsics.areEqual(contentRule, QSearchGuildTabContentView.access$getViewModel(qSearchGuildTabContentView16).getSelectedContentRule()), new Function1<QSearchLabelItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$body$1$1$3$3$1$3$5$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QSearchLabelItemView qSearchLabelItemView) {
                                                                            QSearchLabelItemView qSearchLabelItemView2 = qSearchLabelItemView;
                                                                            final QSearchGuildTabContentView qSearchGuildTabContentView17 = QSearchGuildTabContentView.this;
                                                                            final ContentRule contentRule2 = contentRule;
                                                                            qSearchLabelItemView2.attr(new Function1<QSearchLabelItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$body$1$1$3$3$1$3$5$1$1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(QSearchLabelItemAttr qSearchLabelItemAttr) {
                                                                                    QSearchLabelItemAttr qSearchLabelItemAttr2 = qSearchLabelItemAttr;
                                                                                    QSearchGuildTabContentView qSearchGuildTabContentView18 = QSearchGuildTabContentView.this;
                                                                                    KProperty<Object>[] kPropertyArr2 = QSearchGuildTabContentView.$$delegatedProperties;
                                                                                    e baseReportParams = qSearchGuildTabContentView18.getBaseReportParams();
                                                                                    ContentRule contentRule3 = contentRule2;
                                                                                    baseReportParams.t("sort_type", 1);
                                                                                    baseReportParams.v("filter_tag", contentRule3.text);
                                                                                    Unit unit = Unit.INSTANCE;
                                                                                    EcommerceExtKt.vr$default(qSearchLabelItemAttr2, null, "em_bas_screening_panel", baseReportParams, null, null, false, 57);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final QSearchGuildTabContentView qSearchGuildTabContentView18 = QSearchGuildTabContentView.this;
                                                                            final ContentRule contentRule3 = contentRule;
                                                                            qSearchLabelItemView2.event(new Function1<QSearchLabelItemEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$body$1$1$3$3$1$3$5$1$1.2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(QSearchLabelItemEvent qSearchLabelItemEvent) {
                                                                                    final QSearchGuildTabContentView qSearchGuildTabContentView19 = QSearchGuildTabContentView.this;
                                                                                    final ContentRule contentRule4 = contentRule3;
                                                                                    qSearchLabelItemEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.body.1.1.3.3.1.3.5.1.1.2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                            r8.menuStatus$delegate.setValue(QSearchGuildTabContentView.this, QSearchGuildTabContentView.$$delegatedProperties[0], Integer.valueOf(0));
                                                                                            QSearchGuildTabContentViewModel access$getViewModel = QSearchGuildTabContentView.access$getViewModel(QSearchGuildTabContentView.this);
                                                                                            ContentRule contentRule5 = contentRule4;
                                                                                            access$getViewModel.getClass();
                                                                                            if (contentRule5.f114293id != access$getViewModel.getSelectedContentRule().f114293id) {
                                                                                                access$getViewModel.selectedContentRule$delegate.setValue(access$getViewModel, QSearchGuildTabContentViewModel.$$delegatedProperties[1], contentRule5);
                                                                                                access$getViewModel.reset();
                                                                                                access$getViewModel.loadData(access$getViewModel.keyword, access$getViewModel.querySource, false, null);
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
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final Function1<ViewContainer<?, ?>, Unit> configItemView(final ISearchItemModel iSearchItemModel, final int i3) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$configItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ISearchItemModel iSearchItemModel2 = ISearchItemModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$configItemView$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ISearchItemModel.this instanceof SearchGuildChannelItemModel);
                    }
                };
                final ISearchItemModel iSearchItemModel3 = ISearchItemModel.this;
                final QSearchGuildTabContentView qSearchGuildTabContentView = this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$configItemView$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                        Intrinsics.checkNotNull(iSearchItemModel4, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel");
                        final SearchGuildChannelItemModel searchGuildChannelItemModel = (SearchGuildChannelItemModel) iSearchItemModel4;
                        final QSearchGuildTabContentView qSearchGuildTabContentView2 = qSearchGuildTabContentView;
                        conditionView.addChild(new GuildChannelWholeCardItemView(), new Function1<GuildChannelWholeCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.configItemView.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildChannelWholeCardItemView guildChannelWholeCardItemView) {
                                final SearchGuildChannelItemModel searchGuildChannelItemModel2 = SearchGuildChannelItemModel.this;
                                final QSearchGuildTabContentView qSearchGuildTabContentView3 = qSearchGuildTabContentView2;
                                guildChannelWholeCardItemView.attr(new Function1<GuildChannelWholeCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView.configItemView.1.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildChannelWholeCardItemAttr guildChannelWholeCardItemAttr) {
                                        GuildChannelWholeCardItemAttr guildChannelWholeCardItemAttr2 = guildChannelWholeCardItemAttr;
                                        guildChannelWholeCardItemAttr2.data = SearchGuildChannelItemModel.this;
                                        guildChannelWholeCardItemAttr2.isFirstItem = true;
                                        guildChannelWholeCardItemAttr2.setLastItem(true);
                                        guildChannelWholeCardItemAttr2.keyword = QSearchGuildTabContentView.access$getAttr(qSearchGuildTabContentView3).getViewModel().keyword;
                                        guildChannelWholeCardItemAttr2.traceId = QSearchGuildTabContentView.access$getAttr(qSearchGuildTabContentView3).getViewModel().repo.currentTraceId;
                                        guildChannelWholeCardItemAttr2.tabData = QSearchGuildTabContentView.access$getAttr(qSearchGuildTabContentView3).tabData;
                                        guildChannelWholeCardItemAttr2.filterTag = QSearchGuildTabContentView.access$getViewModel(qSearchGuildTabContentView3).getSelectedRankRule().text + ", " + QSearchGuildTabContentView.access$getViewModel(qSearchGuildTabContentView3).getSelectedContentRule().text;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QSearchGuildTabContentView qSearchGuildTabContentView2 = this;
                final ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                final int i16 = i3;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchGuildTabContentView$configItemView$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        QSearchGuildTabContentView qSearchGuildTabContentView3 = QSearchGuildTabContentView.this;
                        ISearchItemModel iSearchItemModel5 = iSearchItemModel4;
                        int i17 = i16;
                        KProperty<Object>[] kPropertyArr = QSearchGuildTabContentView.$$delegatedProperties;
                        qSearchGuildTabContentView3.getClass();
                        new QSearchTabContentView$configItemView$1(iSearchItemModel5, i17, qSearchGuildTabContentView3).invoke(conditionView);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final void onKeywordChanged() {
        super.onKeywordChanged();
        this.menuStatus$delegate.setValue(this, $$delegatedProperties[0], 0);
    }
}
