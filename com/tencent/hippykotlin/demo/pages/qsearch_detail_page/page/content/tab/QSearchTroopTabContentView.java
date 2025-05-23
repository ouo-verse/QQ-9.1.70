package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelItemViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopWholeCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopWholeCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view.PlaceItemViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.City;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.County;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.PlaceInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.Province;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTroopTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTroopTabContentViewModelKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.SortRule;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.TroopLabel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTroopTabContentView extends QSearchTabContentView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTroopTabContentView.class, "menuStatus", "getMenuStatus()I", 0)};
    public final ReadWriteProperty menuStatus$delegate = c.a(0);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTabContentAttr access$getAttr(QSearchTroopTabContentView qSearchTroopTabContentView) {
        return (QSearchTabContentAttr) qSearchTroopTabContentView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final Function1<ViewContainer<?, ?>, Unit> appendEmptyView(e eVar) {
        final Function1<ViewContainer<?, ?>, Unit> createFooterView = createFooterView(eVar);
        if (createFooterView == null) {
            return null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$appendEmptyView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final Function1<ViewContainer<?, ?>, Unit> function1 = createFooterView;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$appendEmptyView$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.appendEmptyView.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 40.0f, 0.0f, 9, null);
                                tVar2.m154zIndex(10);
                                return Unit.INSTANCE;
                            }
                        });
                        function1.invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchTroopTabContentView qSearchTroopTabContentView = QSearchTroopTabContentView.this;
                final QSearchTroopTabContentView qSearchTroopTabContentView2 = this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionColumn();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchTroopTabContentView qSearchTroopTabContentView3 = QSearchTroopTabContentView.this;
                        KProperty<Object>[] kPropertyArr = QSearchTroopTabContentView.$$delegatedProperties;
                        qSearchTroopTabContentView3.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configMenu$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                final QSearchTroopTabContentView qSearchTroopTabContentView4 = QSearchTroopTabContentView.this;
                                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configMenu$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.1
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
                                        final QSearchTroopTabContentView qSearchTroopTabContentView5 = QSearchTroopTabContentView.this;
                                        QSearchLabelViewKt.QSearchLabelView(vVar4, new Function1<QSearchLabelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchLabelView qSearchLabelView) {
                                                QSearchLabelView qSearchLabelView2 = qSearchLabelView;
                                                final QSearchTroopTabContentView qSearchTroopTabContentView6 = QSearchTroopTabContentView.this;
                                                qSearchLabelView2.attr(new Function1<QSearchLabelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchLabelAttr qSearchLabelAttr) {
                                                        int intValue;
                                                        QSearchLabelAttr qSearchLabelAttr2 = qSearchLabelAttr;
                                                        qSearchLabelAttr2.m140flex(1.0f);
                                                        QSearchTroopTabContentViewModel viewModel = QSearchTroopTabContentView.this.getViewModel();
                                                        if (viewModel != null) {
                                                            qSearchLabelAttr2.setLabel(viewModel.getSelectedSortRule().text);
                                                        }
                                                        intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                        qSearchLabelAttr2.setSelected(intValue == 1);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchTroopTabContentView qSearchTroopTabContentView7 = QSearchTroopTabContentView.this;
                                                qSearchLabelView2.event(new Function1<QSearchLabelEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchLabelEvent qSearchLabelEvent) {
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView8 = QSearchTroopTabContentView.this;
                                                        qSearchLabelEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                int intValue;
                                                                intValue = ((Number) r3.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                                if (intValue == 1) {
                                                                    QSearchTroopTabContentView.this.setMenuStatus(0);
                                                                } else {
                                                                    QSearchTroopTabContentView.this.setMenuStatus(1);
                                                                }
                                                                QSearchTroopTabContentView.this.reportLabelDTEvent(1, true);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchTroopTabContentView qSearchTroopTabContentView6 = QSearchTroopTabContentView.this;
                                        QSearchLabelViewKt.QSearchLabelView(vVar4, new Function1<QSearchLabelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchLabelView qSearchLabelView) {
                                                QSearchLabelView qSearchLabelView2 = qSearchLabelView;
                                                final QSearchTroopTabContentView qSearchTroopTabContentView7 = QSearchTroopTabContentView.this;
                                                qSearchLabelView2.attr(new Function1<QSearchLabelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchLabelAttr qSearchLabelAttr) {
                                                        int intValue;
                                                        QSearchLabelAttr qSearchLabelAttr2 = qSearchLabelAttr;
                                                        qSearchLabelAttr2.m140flex(1.0f);
                                                        qSearchLabelAttr2.margin(0.0f, 8.0f, 0.0f, 8.0f);
                                                        QSearchTroopTabContentViewModel viewModel = QSearchTroopTabContentView.this.getViewModel();
                                                        if (viewModel != null) {
                                                            qSearchLabelAttr2.setLabel(viewModel.getSelectedTroopLabel().text);
                                                        }
                                                        intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                        qSearchLabelAttr2.setSelected(intValue == 2);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchTroopTabContentView qSearchTroopTabContentView8 = QSearchTroopTabContentView.this;
                                                qSearchLabelView2.event(new Function1<QSearchLabelEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchLabelEvent qSearchLabelEvent) {
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView9 = QSearchTroopTabContentView.this;
                                                        qSearchLabelEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                int intValue;
                                                                intValue = ((Number) r3.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                                if (intValue == 2) {
                                                                    QSearchTroopTabContentView.this.setMenuStatus(0);
                                                                } else {
                                                                    QSearchTroopTabContentView.this.setMenuStatus(2);
                                                                }
                                                                QSearchTroopTabContentView.this.reportLabelDTEvent(2, true);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchTroopTabContentView qSearchTroopTabContentView7 = QSearchTroopTabContentView.this;
                                        QSearchLabelViewKt.QSearchLabelView(vVar4, new Function1<QSearchLabelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchLabelView qSearchLabelView) {
                                                QSearchLabelView qSearchLabelView2 = qSearchLabelView;
                                                final QSearchTroopTabContentView qSearchTroopTabContentView8 = QSearchTroopTabContentView.this;
                                                qSearchLabelView2.attr(new Function1<QSearchLabelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchLabelAttr qSearchLabelAttr) {
                                                        int intValue;
                                                        QSearchLabelAttr qSearchLabelAttr2 = qSearchLabelAttr;
                                                        qSearchLabelAttr2.m140flex(1.0f);
                                                        QSearchTroopTabContentViewModel viewModel = QSearchTroopTabContentView.this.getViewModel();
                                                        if (viewModel != null) {
                                                            qSearchLabelAttr2.setLabel(viewModel.getSelectedPlace().displayText);
                                                        }
                                                        intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                        qSearchLabelAttr2.setSelected(intValue == 3);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchTroopTabContentView qSearchTroopTabContentView9 = QSearchTroopTabContentView.this;
                                                qSearchLabelView2.event(new Function1<QSearchLabelEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QSearchLabelEvent qSearchLabelEvent) {
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView10 = QSearchTroopTabContentView.this;
                                                        qSearchLabelEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenu.1.1.4.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                int intValue;
                                                                intValue = ((Number) r3.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                                if (intValue == 3) {
                                                                    QSearchTroopTabContentView.this.setMenuStatus(0);
                                                                } else {
                                                                    QSearchTroopTabContentView.this.setMenuStatus(3);
                                                                }
                                                                QSearchTroopTabContentView.this.reportLabelDTEvent(3, true);
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
                        }.invoke(vVar2);
                        final QSearchTroopTabContentView qSearchTroopTabContentView4 = qSearchTroopTabContentView2;
                        final QSearchTroopTabContentView qSearchTroopTabContentView5 = QSearchTroopTabContentView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                QSearchTroopTabContentView qSearchTroopTabContentView6 = QSearchTroopTabContentView.this;
                                KProperty<Object>[] kPropertyArr2 = QSearchTroopTabContentView.$$delegatedProperties;
                                qSearchTroopTabContentView6.getClass();
                                new QSearchTabContentView$body$1(qSearchTroopTabContentView6).invoke(vVar4);
                                final QSearchTroopTabContentView qSearchTroopTabContentView7 = qSearchTroopTabContentView5;
                                qSearchTroopTabContentView7.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configMenuPanel$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        final QSearchTroopTabContentView qSearchTroopTabContentView8 = QSearchTroopTabContentView.this;
                                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configMenuPanel$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.absolutePositionAllZero();
                                                        tVar2.m154zIndex(20);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchTroopTabContentView qSearchTroopTabContentView9 = QSearchTroopTabContentView.this;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("bg_bottom_light"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView10 = QSearchTroopTabContentView.this;
                                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.2.2
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                int intValue;
                                                                intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                                return Boolean.valueOf(intValue == 1);
                                                            }
                                                        };
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView11 = QSearchTroopTabContentView.this;
                                                        ConditionViewKt.c(vVar8, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                final QSearchTroopTabContentView qSearchTroopTabContentView12 = QSearchTroopTabContentView.this;
                                                                KProperty<Object>[] kPropertyArr3 = QSearchTroopTabContentView.$$delegatedProperties;
                                                                qSearchTroopTabContentView12.getClass();
                                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configSortMenuPanel$1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                                        final QSearchTroopTabContentViewModel viewModel = QSearchTroopTabContentView.this.getViewModel();
                                                                        if (viewModel != null) {
                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView13 = QSearchTroopTabContentView.this;
                                                                            Iterator<SortRule> it = viewModel.getSortRules().iterator();
                                                                            while (it.hasNext()) {
                                                                                final SortRule next = it.next();
                                                                                QSearchLabelItemViewKt.QSearchLabelItemView(viewContainer4, next.text, Intrinsics.areEqual(next, viewModel.getSelectedSortRule()), new Function1<QSearchLabelItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configSortMenuPanel$1$1$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(QSearchLabelItemView qSearchLabelItemView) {
                                                                                        final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel = QSearchTroopTabContentViewModel.this;
                                                                                        final SortRule sortRule = next;
                                                                                        final QSearchTroopTabContentView qSearchTroopTabContentView14 = qSearchTroopTabContentView13;
                                                                                        qSearchLabelItemView.event(new Function1<QSearchLabelItemEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configSortMenuPanel$1$1$1.1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(QSearchLabelItemEvent qSearchLabelItemEvent) {
                                                                                                final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel2 = QSearchTroopTabContentViewModel.this;
                                                                                                final SortRule sortRule2 = sortRule;
                                                                                                final QSearchTroopTabContentView qSearchTroopTabContentView15 = qSearchTroopTabContentView14;
                                                                                                qSearchLabelItemEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configSortMenuPanel.1.1.1.1.1
                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                                        QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel3 = QSearchTroopTabContentViewModel.this;
                                                                                                        SortRule sortRule3 = sortRule2;
                                                                                                        if (qSearchTroopTabContentViewModel3.getSelectedSortRule().f114297id != sortRule3.f114297id) {
                                                                                                            qSearchTroopTabContentViewModel3.setSelectedSortRule(sortRule3);
                                                                                                            qSearchTroopTabContentViewModel3.isConditionUpdated = true;
                                                                                                            qSearchTroopTabContentViewModel3.reset();
                                                                                                            qSearchTroopTabContentViewModel3.loadData(qSearchTroopTabContentViewModel3.keyword, qSearchTroopTabContentViewModel3.querySource, false, null);
                                                                                                        }
                                                                                                        QSearchTroopTabContentView qSearchTroopTabContentView16 = qSearchTroopTabContentView15;
                                                                                                        KProperty<Object>[] kPropertyArr4 = QSearchTroopTabContentView.$$delegatedProperties;
                                                                                                        qSearchTroopTabContentView16.setMenuStatus(0);
                                                                                                        qSearchTroopTabContentView15.reportTagDTClick(1, sortRule2.text);
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
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }.invoke(conditionView);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView12 = QSearchTroopTabContentView.this;
                                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.2.4
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                int intValue;
                                                                intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                                return Boolean.valueOf(intValue == 2);
                                                            }
                                                        };
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView13 = QSearchTroopTabContentView.this;
                                                        ConditionViewKt.b(vVar8, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.2.5
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                final QSearchTroopTabContentView qSearchTroopTabContentView14 = QSearchTroopTabContentView.this;
                                                                KProperty<Object>[] kPropertyArr3 = QSearchTroopTabContentView.$$delegatedProperties;
                                                                qSearchTroopTabContentView14.getClass();
                                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configLabelMenuPanel$1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                                        final QSearchTroopTabContentViewModel viewModel = QSearchTroopTabContentView.this.getViewModel();
                                                                        if (viewModel != null) {
                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView15 = QSearchTroopTabContentView.this;
                                                                            ConditionViewKt.c(viewContainer4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configLabelMenuPanel$1$1$1
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                public final Object invoke() {
                                                                                    return Boolean.valueOf(!QSearchTroopTabContentViewModel.this.getTroopLabels().isEmpty());
                                                                                }
                                                                            }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configLabelMenuPanel$1$1$2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ConditionView conditionView2) {
                                                                                    final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel = QSearchTroopTabContentViewModel.this;
                                                                                    final QSearchTroopTabContentView qSearchTroopTabContentView16 = qSearchTroopTabContentView15;
                                                                                    w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configLabelMenuPanel$1$1$2.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(v vVar9) {
                                                                                            v vVar10 = vVar9;
                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel2 = QSearchTroopTabContentViewModel.this;
                                                                                            vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.1
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(t tVar) {
                                                                                                    t tVar2 = tVar;
                                                                                                    tVar2.padding(4.0f, 16.0f, 16.0f, 16.0f);
                                                                                                    tVar2.flexDirectionColumn();
                                                                                                    float size = (QSearchTroopTabContentViewModel.this.getTroopLabels().size() / 3.0f) + (QSearchTroopTabContentViewModel.this.getTroopLabels().size() % 3 == 0 ? 0 : 1);
                                                                                                    tVar2.mo141height(((size - 1) * 8.0f) + ((FontModuleExtKt.qqFontScaleAddSize(12.0f) + 25.0f) * size) + 8.0f);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel3 = QSearchTroopTabContentViewModel.this;
                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView17 = qSearchTroopTabContentView16;
                                                                                            cn.a(vVar10, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(cm cmVar) {
                                                                                                    cm cmVar2 = cmVar;
                                                                                                    cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2.1
                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(ck ckVar) {
                                                                                                            ck ckVar2 = ckVar;
                                                                                                            ckVar2.m140flex(1.0f);
                                                                                                            ckVar2.w(ckVar2.getPagerData().m() - 32.0f);
                                                                                                            ckVar2.h(3);
                                                                                                            ckVar2.t(8.0f);
                                                                                                            ckVar2.u(8.0f);
                                                                                                            ckVar2.scrollEnable(true);
                                                                                                            ScrollerAttr.bouncesEnable$default(ckVar2, false, false, 2, null);
                                                                                                            ckVar2.showScrollerIndicator(false);
                                                                                                            return Unit.INSTANCE;
                                                                                                        }
                                                                                                    });
                                                                                                    final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel4 = QSearchTroopTabContentViewModel.this;
                                                                                                    Function0<com.tencent.kuikly.core.reactive.collection.c<TroopLabel>> function03 = new Function0<com.tencent.kuikly.core.reactive.collection.c<TroopLabel>>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2.2
                                                                                                        {
                                                                                                            super(0);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                                        public final com.tencent.kuikly.core.reactive.collection.c<TroopLabel> invoke() {
                                                                                                            return QSearchTroopTabContentViewModel.this.getTroopLabels();
                                                                                                        }
                                                                                                    };
                                                                                                    final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel5 = QSearchTroopTabContentViewModel.this;
                                                                                                    final QSearchTroopTabContentView qSearchTroopTabContentView18 = qSearchTroopTabContentView17;
                                                                                                    LoopDirectivesViewKt.a(cmVar2, function03, new Function2<LoopDirectivesView<TroopLabel>, TroopLabel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2.3
                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                        {
                                                                                                            super(2);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function2
                                                                                                        public final Unit invoke(LoopDirectivesView<TroopLabel> loopDirectivesView, TroopLabel troopLabel) {
                                                                                                            final TroopLabel troopLabel2 = troopLabel;
                                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel6 = QSearchTroopTabContentViewModel.this;
                                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView19 = qSearchTroopTabContentView18;
                                                                                                            w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2.3.1
                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                {
                                                                                                                    super(1);
                                                                                                                }

                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                public final Unit invoke(v vVar11) {
                                                                                                                    v vVar12 = vVar11;
                                                                                                                    final TroopLabel troopLabel3 = TroopLabel.this;
                                                                                                                    final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel7 = qSearchTroopTabContentViewModel6;
                                                                                                                    vVar12.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2.3.1.1
                                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                        {
                                                                                                                            super(1);
                                                                                                                        }

                                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                                        public final Unit invoke(t tVar) {
                                                                                                                            t tVar2 = tVar;
                                                                                                                            tVar2.flexDirectionRow();
                                                                                                                            tVar2.allCenter();
                                                                                                                            tVar2.padding(4.0f, 8.0f, 4.0f, 8.0f);
                                                                                                                            tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + 25.0f);
                                                                                                                            tVar2.borderRadius(6.0f);
                                                                                                                            if (Intrinsics.areEqual(TroopLabel.this.text, qSearchTroopTabContentViewModel7.getSelectedTroopLabel().text)) {
                                                                                                                                tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.blueLabelBackground());
                                                                                                                            } else {
                                                                                                                                tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_standard_primary"));
                                                                                                                            }
                                                                                                                            return Unit.INSTANCE;
                                                                                                                        }
                                                                                                                    });
                                                                                                                    final TroopLabel troopLabel4 = TroopLabel.this;
                                                                                                                    final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel8 = qSearchTroopTabContentViewModel6;
                                                                                                                    final QSearchTroopTabContentView qSearchTroopTabContentView20 = qSearchTroopTabContentView19;
                                                                                                                    cg.a(vVar12, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2.3.1.2
                                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                        {
                                                                                                                            super(1);
                                                                                                                        }

                                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                                        public final Unit invoke(TextView textView) {
                                                                                                                            TextView textView2 = textView;
                                                                                                                            final TroopLabel troopLabel5 = TroopLabel.this;
                                                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel9 = qSearchTroopTabContentViewModel8;
                                                                                                                            textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2.3.1.2.1
                                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                                {
                                                                                                                                    super(1);
                                                                                                                                }

                                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                                public final Unit invoke(ce ceVar) {
                                                                                                                                    ce ceVar2 = ceVar;
                                                                                                                                    ceVar2.m140flex(1.0f);
                                                                                                                                    ceVar2.textAlignCenter();
                                                                                                                                    ceVar2.text(TroopLabel.this.text);
                                                                                                                                    ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                                                                    ceVar2.fontWeight400();
                                                                                                                                    if (Intrinsics.areEqual(TroopLabel.this.text, qSearchTroopTabContentViewModel9.getSelectedTroopLabel().text)) {
                                                                                                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                                                                                                                    } else {
                                                                                                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                                                                                                    }
                                                                                                                                    return Unit.INSTANCE;
                                                                                                                                }
                                                                                                                            });
                                                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel10 = qSearchTroopTabContentViewModel8;
                                                                                                                            final TroopLabel troopLabel6 = TroopLabel.this;
                                                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView21 = qSearchTroopTabContentView20;
                                                                                                                            textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2.3.1.2.2
                                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                                {
                                                                                                                                    super(1);
                                                                                                                                }

                                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                                public final Unit invoke(TextEvent textEvent) {
                                                                                                                                    final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel11 = QSearchTroopTabContentViewModel.this;
                                                                                                                                    final TroopLabel troopLabel7 = troopLabel6;
                                                                                                                                    final QSearchTroopTabContentView qSearchTroopTabContentView22 = qSearchTroopTabContentView21;
                                                                                                                                    textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configLabelMenuPanel.1.1.2.1.2.3.1.2.2.1
                                                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                                        {
                                                                                                                                            super(1);
                                                                                                                                        }

                                                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                                                                            QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel12 = QSearchTroopTabContentViewModel.this;
                                                                                                                                            TroopLabel troopLabel8 = troopLabel7;
                                                                                                                                            if (!Intrinsics.areEqual(qSearchTroopTabContentViewModel12.getSelectedTroopLabel().text, troopLabel8.text)) {
                                                                                                                                                qSearchTroopTabContentViewModel12.selectedTroopLabel$delegate.setValue(qSearchTroopTabContentViewModel12, QSearchTroopTabContentViewModel.$$delegatedProperties[4], troopLabel8);
                                                                                                                                                qSearchTroopTabContentViewModel12.isConditionUpdated = true;
                                                                                                                                                qSearchTroopTabContentViewModel12.reset();
                                                                                                                                                qSearchTroopTabContentViewModel12.loadData(qSearchTroopTabContentViewModel12.keyword, qSearchTroopTabContentViewModel12.querySource, false, null);
                                                                                                                                            }
                                                                                                                                            QSearchTroopTabContentView qSearchTroopTabContentView23 = qSearchTroopTabContentView22;
                                                                                                                                            KProperty<Object>[] kPropertyArr4 = QSearchTroopTabContentView.$$delegatedProperties;
                                                                                                                                            qSearchTroopTabContentView23.setMenuStatus(0);
                                                                                                                                            qSearchTroopTabContentView22.reportTagDTClick(2, troopLabel7.text);
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
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }.invoke(conditionView);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView14 = QSearchTroopTabContentView.this;
                                                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.2.6
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                int intValue;
                                                                intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                                return Boolean.valueOf(intValue == 3);
                                                            }
                                                        };
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView15 = QSearchTroopTabContentView.this;
                                                        ConditionViewKt.b(vVar8, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.2.7
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                final QSearchTroopTabContentView qSearchTroopTabContentView16 = QSearchTroopTabContentView.this;
                                                                KProperty<Object>[] kPropertyArr3 = QSearchTroopTabContentView.$$delegatedProperties;
                                                                qSearchTroopTabContentView16.getClass();
                                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                                        final QSearchTroopTabContentView qSearchTroopTabContentView17 = QSearchTroopTabContentView.this;
                                                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar9) {
                                                                                v vVar10 = vVar9;
                                                                                vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.mo141height(392.0f);
                                                                                        tVar2.flexDirectionRow();
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final QSearchTroopTabContentViewModel viewModel = QSearchTroopTabContentView.this.getViewModel();
                                                                                if (viewModel != null) {
                                                                                    final QSearchTroopTabContentView qSearchTroopTabContentView18 = QSearchTroopTabContentView.this;
                                                                                    ar.a(vVar10, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(aq<?, ?> aqVar) {
                                                                                            aq<?, ?> aqVar2 = aqVar;
                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView19 = QSearchTroopTabContentView.this;
                                                                                            aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$1.1
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                                                                                    QSearchTroopTabContentView qSearchTroopTabContentView20 = QSearchTroopTabContentView.this;
                                                                                                    KProperty<Object>[] kPropertyArr4 = QSearchTroopTabContentView.$$delegatedProperties;
                                                                                                    qSearchTroopTabContentView20.getClass();
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$1.2
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ao aoVar) {
                                                                                                    ao aoVar2 = aoVar;
                                                                                                    aoVar2.m140flex(1.0f);
                                                                                                    aoVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("bg_bottom_standard"));
                                                                                                    aoVar2.showScrollerIndicator(false);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel = viewModel;
                                                                                            Function0<com.tencent.kuikly.core.reactive.collection.c<Province>> function04 = new Function0<com.tencent.kuikly.core.reactive.collection.c<Province>>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$1.3
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final com.tencent.kuikly.core.reactive.collection.c<Province> invoke() {
                                                                                                    return QSearchTroopTabContentViewModel.this.getProvinceList();
                                                                                                }
                                                                                            };
                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel2 = viewModel;
                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView20 = QSearchTroopTabContentView.this;
                                                                                            LoopDirectivesViewKt.a(aqVar2, function04, new Function2<LoopDirectivesView<Province>, Province, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$1.4
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(2);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function2
                                                                                                public final Unit invoke(LoopDirectivesView<Province> loopDirectivesView, Province province) {
                                                                                                    final Province province2 = province;
                                                                                                    final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel3 = QSearchTroopTabContentViewModel.this;
                                                                                                    final QSearchTroopTabContentView qSearchTroopTabContentView21 = qSearchTroopTabContentView20;
                                                                                                    PlaceItemViewKt.PlaceItem(loopDirectivesView, new Function1<PlaceItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.1.4.1
                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                        {
                                                                                                            super(1);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(PlaceItemView placeItemView) {
                                                                                                            PlaceItemView placeItemView2 = placeItemView;
                                                                                                            final Province province3 = Province.this;
                                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel4 = qSearchTroopTabContentViewModel3;
                                                                                                            placeItemView2.attr(new Function1<PlaceAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.1.4.1.1
                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                {
                                                                                                                    super(1);
                                                                                                                }

                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                public final Unit invoke(PlaceAttr placeAttr) {
                                                                                                                    PlaceAttr placeAttr2 = placeAttr;
                                                                                                                    placeAttr2.text = Province.this.text;
                                                                                                                    placeAttr2.selectedBgColor = QUISkinColor.INSTANCE.wrapColor("bg_bottom_light");
                                                                                                                    placeAttr2.showStrip = true;
                                                                                                                    placeAttr2.setSelected(Intrinsics.areEqual(qSearchTroopTabContentViewModel4.getHighlightProvince(), Province.this));
                                                                                                                    return Unit.INSTANCE;
                                                                                                                }
                                                                                                            });
                                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel5 = qSearchTroopTabContentViewModel3;
                                                                                                            final Province province4 = Province.this;
                                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView22 = qSearchTroopTabContentView21;
                                                                                                            placeItemView2.event(new Function1<PlaceEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.1.4.1.2
                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                {
                                                                                                                    super(1);
                                                                                                                }

                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                public final Unit invoke(PlaceEvent placeEvent) {
                                                                                                                    final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel6 = QSearchTroopTabContentViewModel.this;
                                                                                                                    final Province province5 = province4;
                                                                                                                    final QSearchTroopTabContentView qSearchTroopTabContentView23 = qSearchTroopTabContentView22;
                                                                                                                    placeEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.1.4.1.2.1
                                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                        {
                                                                                                                            super(1);
                                                                                                                        }

                                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                                                            Object first;
                                                                                                                            Object first2;
                                                                                                                            QSearchTroopTabContentViewModel.this.setHighlightProvince(province5);
                                                                                                                            QSearchTroopTabContentViewModel.this.setHighlightCity(QSearchTroopTabContentViewModelKt.emptyCity);
                                                                                                                            if (province5.cityList.size() == 1) {
                                                                                                                                QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel7 = QSearchTroopTabContentViewModel.this;
                                                                                                                                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) province5.cityList);
                                                                                                                                qSearchTroopTabContentViewModel7.setHighlightCity((City) first);
                                                                                                                                QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel8 = QSearchTroopTabContentViewModel.this;
                                                                                                                                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) qSearchTroopTabContentViewModel8.getHighlightCity().countyList);
                                                                                                                                qSearchTroopTabContentViewModel8.setHighlightCounty((County) first2);
                                                                                                                                QSearchTroopTabContentView.access$onSelectPlace(qSearchTroopTabContentView23);
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
                                                                                    ar.a(vVar10, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$2
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(aq<?, ?> aqVar) {
                                                                                            aq<?, ?> aqVar2 = aqVar;
                                                                                            aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$2.1
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ao aoVar) {
                                                                                                    ao aoVar2 = aoVar;
                                                                                                    aoVar2.m140flex(1.0f);
                                                                                                    aoVar2.showScrollerIndicator(false);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView19 = QSearchTroopTabContentView.this;
                                                                                            aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$2.2
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                                                                                    QSearchTroopTabContentView qSearchTroopTabContentView20 = QSearchTroopTabContentView.this;
                                                                                                    KProperty<Object>[] kPropertyArr4 = QSearchTroopTabContentView.$$delegatedProperties;
                                                                                                    qSearchTroopTabContentView20.getClass();
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel = viewModel;
                                                                                            Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$2.3
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final Object invoke() {
                                                                                                    return QSearchTroopTabContentViewModel.this.getHighlightProvince();
                                                                                                }
                                                                                            };
                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel2 = viewModel;
                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView20 = QSearchTroopTabContentView.this;
                                                                                            BindDirectivesViewKt.a(aqVar2, function04, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$2.4
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                                                    BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                                                                                    for (final City city : QSearchTroopTabContentViewModel.this.getHighlightProvince().cityList) {
                                                                                                        final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel3 = QSearchTroopTabContentViewModel.this;
                                                                                                        final QSearchTroopTabContentView qSearchTroopTabContentView21 = qSearchTroopTabContentView20;
                                                                                                        PlaceItemViewKt.PlaceItem(bindDirectivesView2, new Function1<PlaceItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.2.4.1
                                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                            {
                                                                                                                super(1);
                                                                                                            }

                                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                                            public final Unit invoke(PlaceItemView placeItemView) {
                                                                                                                PlaceItemView placeItemView2 = placeItemView;
                                                                                                                final City city2 = City.this;
                                                                                                                final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel4 = qSearchTroopTabContentViewModel3;
                                                                                                                placeItemView2.attr(new Function1<PlaceAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.2.4.1.1
                                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                    {
                                                                                                                        super(1);
                                                                                                                    }

                                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                                    public final Unit invoke(PlaceAttr placeAttr) {
                                                                                                                        PlaceAttr placeAttr2 = placeAttr;
                                                                                                                        placeAttr2.text = City.this.text;
                                                                                                                        placeAttr2.setSelected(Intrinsics.areEqual(qSearchTroopTabContentViewModel4.getHighlightCity(), City.this));
                                                                                                                        return Unit.INSTANCE;
                                                                                                                    }
                                                                                                                });
                                                                                                                final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel5 = qSearchTroopTabContentViewModel3;
                                                                                                                final City city3 = City.this;
                                                                                                                final QSearchTroopTabContentView qSearchTroopTabContentView22 = qSearchTroopTabContentView21;
                                                                                                                placeItemView2.event(new Function1<PlaceEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.2.4.1.2
                                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                    {
                                                                                                                        super(1);
                                                                                                                    }

                                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                                    public final Unit invoke(PlaceEvent placeEvent) {
                                                                                                                        final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel6 = QSearchTroopTabContentViewModel.this;
                                                                                                                        final City city4 = city3;
                                                                                                                        final QSearchTroopTabContentView qSearchTroopTabContentView23 = qSearchTroopTabContentView22;
                                                                                                                        placeEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.2.4.1.2.1
                                                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                            {
                                                                                                                                super(1);
                                                                                                                            }

                                                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                                                Object first;
                                                                                                                                QSearchTroopTabContentViewModel.this.setHighlightCity(city4);
                                                                                                                                QSearchTroopTabContentViewModel.this.setHighlightCounty(QSearchTroopTabContentViewModelKt.emptyCounty);
                                                                                                                                if (city4.countyList.size() == 1) {
                                                                                                                                    QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel7 = QSearchTroopTabContentViewModel.this;
                                                                                                                                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) qSearchTroopTabContentViewModel7.getHighlightCity().countyList);
                                                                                                                                    qSearchTroopTabContentViewModel7.setHighlightCounty((County) first);
                                                                                                                                    QSearchTroopTabContentView.access$onSelectPlace(qSearchTroopTabContentView23);
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
                                                                                    ar.a(vVar10, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$3
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(aq<?, ?> aqVar) {
                                                                                            aq<?, ?> aqVar2 = aqVar;
                                                                                            aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$3.1
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ao aoVar) {
                                                                                                    ao aoVar2 = aoVar;
                                                                                                    aoVar2.m140flex(1.0f);
                                                                                                    aoVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("bg_bottom_standard"));
                                                                                                    aoVar2.showScrollerIndicator(false);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView19 = QSearchTroopTabContentView.this;
                                                                                            aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$3.2
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                                                                                    QSearchTroopTabContentView qSearchTroopTabContentView20 = QSearchTroopTabContentView.this;
                                                                                                    KProperty<Object>[] kPropertyArr4 = QSearchTroopTabContentView.$$delegatedProperties;
                                                                                                    qSearchTroopTabContentView20.getClass();
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel = viewModel;
                                                                                            Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$3.3
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final Object invoke() {
                                                                                                    return QSearchTroopTabContentViewModel.this.getHighlightCity();
                                                                                                }
                                                                                            };
                                                                                            final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel2 = viewModel;
                                                                                            final QSearchTroopTabContentView qSearchTroopTabContentView20 = QSearchTroopTabContentView.this;
                                                                                            BindDirectivesViewKt.a(aqVar2, function04, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configPlaceMenuPanel$1$1$2$3.4
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                                                    BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                                                                                    for (final County county : QSearchTroopTabContentViewModel.this.getHighlightCity().countyList) {
                                                                                                        final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel3 = QSearchTroopTabContentViewModel.this;
                                                                                                        final QSearchTroopTabContentView qSearchTroopTabContentView21 = qSearchTroopTabContentView20;
                                                                                                        PlaceItemViewKt.PlaceItem(bindDirectivesView2, new Function1<PlaceItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.3.4.1
                                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                            {
                                                                                                                super(1);
                                                                                                            }

                                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                                            public final Unit invoke(PlaceItemView placeItemView) {
                                                                                                                PlaceItemView placeItemView2 = placeItemView;
                                                                                                                final County county2 = County.this;
                                                                                                                final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel4 = qSearchTroopTabContentViewModel3;
                                                                                                                placeItemView2.attr(new Function1<PlaceAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.3.4.1.1
                                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                    {
                                                                                                                        super(1);
                                                                                                                    }

                                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                                    public final Unit invoke(PlaceAttr placeAttr) {
                                                                                                                        PlaceAttr placeAttr2 = placeAttr;
                                                                                                                        placeAttr2.text = County.this.text;
                                                                                                                        placeAttr2.setSelected(Intrinsics.areEqual(qSearchTroopTabContentViewModel4.getHighlightCounty(), County.this));
                                                                                                                        return Unit.INSTANCE;
                                                                                                                    }
                                                                                                                });
                                                                                                                final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel5 = qSearchTroopTabContentViewModel3;
                                                                                                                final County county3 = County.this;
                                                                                                                final QSearchTroopTabContentView qSearchTroopTabContentView22 = qSearchTroopTabContentView21;
                                                                                                                placeItemView2.event(new Function1<PlaceEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.3.4.1.2
                                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                    {
                                                                                                                        super(1);
                                                                                                                    }

                                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                                    public final Unit invoke(PlaceEvent placeEvent) {
                                                                                                                        final QSearchTroopTabContentViewModel qSearchTroopTabContentViewModel6 = QSearchTroopTabContentViewModel.this;
                                                                                                                        final County county4 = county3;
                                                                                                                        final QSearchTroopTabContentView qSearchTroopTabContentView23 = qSearchTroopTabContentView22;
                                                                                                                        placeEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configPlaceMenuPanel.1.1.2.3.4.1.2.1
                                                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                            {
                                                                                                                                super(1);
                                                                                                                            }

                                                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                                                QSearchTroopTabContentViewModel.this.setHighlightCounty(county4);
                                                                                                                                QSearchTroopTabContentView.access$onSelectPlace(qSearchTroopTabContentView23);
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
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }.invoke(conditionView);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchTroopTabContentView qSearchTroopTabContentView10 = QSearchTroopTabContentView.this;
                                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.3
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        int intValue;
                                                        intValue = ((Number) r0.menuStatus$delegate.getValue(QSearchTroopTabContentView.this, QSearchTroopTabContentView.$$delegatedProperties[0])).intValue();
                                                        return Boolean.valueOf(intValue != 0);
                                                    }
                                                };
                                                final QSearchTroopTabContentView qSearchTroopTabContentView11 = QSearchTroopTabContentView.this;
                                                ConditionViewKt.c(vVar6, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final QSearchTroopTabContentView qSearchTroopTabContentView12 = QSearchTroopTabContentView.this;
                                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                v vVar8 = vVar7;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.4.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.m140flex(1.0f);
                                                                        tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("overlay_dark"));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QSearchTroopTabContentView qSearchTroopTabContentView13 = QSearchTroopTabContentView.this;
                                                                vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.4.1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final QSearchTroopTabContentView qSearchTroopTabContentView14 = QSearchTroopTabContentView.this;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configMenuPanel.1.1.4.1.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                QSearchTroopTabContentView qSearchTroopTabContentView15 = QSearchTroopTabContentView.this;
                                                                                KProperty<Object>[] kPropertyArr3 = QSearchTroopTabContentView.$$delegatedProperties;
                                                                                qSearchTroopTabContentView15.setMenuStatus(0);
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
                                }.invoke(vVar4);
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
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ISearchItemModel iSearchItemModel2 = ISearchItemModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configItemView$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ISearchItemModel.this instanceof SearchTroopItemModel);
                    }
                };
                final ISearchItemModel iSearchItemModel3 = ISearchItemModel.this;
                final QSearchTroopTabContentView qSearchTroopTabContentView = this;
                final int i16 = i3;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configItemView$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                        Intrinsics.checkNotNull(iSearchItemModel4, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel");
                        final SearchTroopItemModel searchTroopItemModel = (SearchTroopItemModel) iSearchItemModel4;
                        final QSearchTroopTabContentView qSearchTroopTabContentView2 = qSearchTroopTabContentView;
                        final int i17 = i16;
                        conditionView.addChild(new QSearchTroopWholeCardItemView(), new Function1<QSearchTroopWholeCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configItemView.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchTroopWholeCardItemView qSearchTroopWholeCardItemView) {
                                final SearchTroopItemModel searchTroopItemModel2 = SearchTroopItemModel.this;
                                final QSearchTroopTabContentView qSearchTroopTabContentView3 = qSearchTroopTabContentView2;
                                final int i18 = i17;
                                qSearchTroopWholeCardItemView.attr(new Function1<QSearchTroopWholeCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.configItemView.1.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchTroopWholeCardItemAttr qSearchTroopWholeCardItemAttr) {
                                        QSearchTroopWholeCardItemAttr qSearchTroopWholeCardItemAttr2 = qSearchTroopWholeCardItemAttr;
                                        qSearchTroopWholeCardItemAttr2.data = SearchTroopItemModel.this;
                                        qSearchTroopWholeCardItemAttr2.keyword = QSearchTroopTabContentView.access$getAttr(qSearchTroopTabContentView3).getViewModel().keyword;
                                        int i19 = i18;
                                        qSearchTroopWholeCardItemAttr2.isFirstItem = i19 == 0;
                                        qSearchTroopWholeCardItemAttr2.setLastItem(i19 == QSearchTroopTabContentView.access$getAttr(qSearchTroopTabContentView3).getViewModel().getDataList().size() - 1);
                                        qSearchTroopWholeCardItemAttr2.index = i18;
                                        qSearchTroopWholeCardItemAttr2.viewModel = qSearchTroopTabContentView3.getViewModel();
                                        qSearchTroopWholeCardItemAttr2.tabData = QSearchTroopTabContentView.access$getAttr(qSearchTroopTabContentView3).tabData;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QSearchTroopTabContentView qSearchTroopTabContentView2 = this;
                final ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                final int i17 = i3;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$configItemView$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        QSearchTroopTabContentView qSearchTroopTabContentView3 = QSearchTroopTabContentView.this;
                        ISearchItemModel iSearchItemModel5 = iSearchItemModel4;
                        int i18 = i17;
                        KProperty<Object>[] kPropertyArr = QSearchTroopTabContentView.$$delegatedProperties;
                        qSearchTroopTabContentView3.getClass();
                        new QSearchTabContentView$configItemView$1(iSearchItemModel5, i18, qSearchTroopTabContentView3).invoke(conditionView);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final float correctionItemMarginBottom() {
        return 8.0f;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final Function1<ViewContainer<?, ?>, Unit> createFooterView(final e eVar) {
        final String str;
        kuikly.com.tencent.trpcprotocol.search.unifysearch.e emptyPageExtraInfo;
        String str2;
        kuikly.com.tencent.trpcprotocol.search.unifysearch.e emptyPageExtraInfo2;
        QSearchTroopTabContentViewModel viewModel = getViewModel();
        final String str3 = "";
        if (viewModel == null || (emptyPageExtraInfo2 = viewModel.getEmptyPageExtraInfo()) == null || (str = emptyPageExtraInfo2.f413189d) == null) {
            str = "";
        }
        QSearchTroopTabContentViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (emptyPageExtraInfo = viewModel2.getEmptyPageExtraInfo()) != null && (str2 = emptyPageExtraInfo.f413190e) != null) {
            str3 = str2;
        }
        if (str.length() == 0) {
            return null;
        }
        if (str3.length() == 0) {
            return null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$createFooterView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final e eVar2 = e.this;
                final String str4 = str;
                final String str5 = str3;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView$createFooterView$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final e eVar3 = e.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.createFooterView.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(60.0f);
                                tVar2.paddingTop(12.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentCenter();
                                tVar2.alignItemsCenter();
                                EcommerceExtKt.elementVR(tVar2, "em_bas_group_chat_feedback_portal", e.this);
                                return Unit.INSTANCE;
                            }
                        });
                        final String str6 = str4;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.createFooterView.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final String str7 = str6;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.createFooterView.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(str7);
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_link"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.createFooterView.1.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.createFooterView.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginLeft(1.0f);
                                        afVar2.size(FontModuleExtKt.qqFontScale() * 12.0f, FontModuleExtKt.qqFontScale() * 12.0f);
                                        b.a.b(afVar2, QUISkinImage.INSTANCE.viewMoreArrow(), false, 2, null);
                                        afVar2.o();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final String str7 = str5;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.createFooterView.1.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final String str8 = str7;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTroopTabContentView.createFooterView.1.1.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), str8, false, null, null, 30);
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
    public final e getEmptyOrErrorViewReportParams(String str, String str2, String str3) {
        List listOf;
        String joinToString$default;
        e emptyOrErrorViewReportParams = super.getEmptyOrErrorViewReportParams(str, str2, "");
        QSearchTroopTabContentViewModel viewModel = getViewModel();
        if (viewModel != null) {
            emptyOrErrorViewReportParams.v("sort_type", viewModel.getSelectedSortRule().text);
            emptyOrErrorViewReportParams.v("tag_type", viewModel.getSelectedTroopLabel().text);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{viewModel.getHighlightProvince().text, viewModel.getHighlightCity().text, viewModel.getHighlightCounty().text});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listOf) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
            emptyOrErrorViewReportParams.v("regional_type", joinToString$default);
            emptyOrErrorViewReportParams.t("grp_search_exist_grp", viewModel.getDataList().size() > 0 ? 1 : 0);
        }
        return emptyOrErrorViewReportParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final QSearchTroopTabContentViewModel getViewModel() {
        QSearchTabContentViewModel viewModel = ((QSearchTabContentAttr) getAttr()).getViewModel();
        if (viewModel instanceof QSearchTroopTabContentViewModel) {
            return (QSearchTroopTabContentViewModel) viewModel;
        }
        return null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final void onActive() {
        super.onActive();
        reportLabelDTEvent(0, false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final void onKeywordChanged() {
        super.onKeywordChanged();
        setMenuStatus(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void reportLabelDTEvent(int i3, boolean z16) {
        e eVar = new e();
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        eVar.v("pageId", "pg_qq_network_search_result_level2_page");
        eVar.v("dt_pgid", "pg_qq_network_search_result_level2_page");
        eVar.v("dt_eid", "em_bas_group_screening_box");
        eVar.v("search_query_text", ((QSearchTabContentAttr) getAttr()).getKeyword());
        eVar.v("search_trace_id", ((QSearchTabContentAttr) getAttr()).getViewModel().repo.currentTraceId);
        eVar.t("query_source", ((QSearchTabContentAttr) getAttr()).getQuerySource());
        if (z16) {
            eVar.t("first_tag", i3);
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("clck", eVar);
        } else {
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("imp", eVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void reportTagDTClick(int i3, String str) {
        e eVar = new e();
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        eVar.v("pageId", "pg_qq_network_search_result_level2_page");
        eVar.v("dt_pgid", "pg_qq_network_search_result_level2_page");
        eVar.v("dt_eid", "em_bas_group_search_secondary_tag");
        eVar.v("search_query_text", ((QSearchTabContentAttr) getAttr()).getKeyword());
        eVar.v("search_trace_id", ((QSearchTabContentAttr) getAttr()).getViewModel().repo.currentTraceId);
        eVar.t("query_source", ((QSearchTabContentAttr) getAttr()).getQuerySource());
        eVar.t("first_tag", i3);
        eVar.v("tag_text", str);
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("clck", eVar);
    }

    public final void setMenuStatus(int i3) {
        this.menuStatus$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }

    public static final void access$onSelectPlace(QSearchTroopTabContentView qSearchTroopTabContentView) {
        qSearchTroopTabContentView.setMenuStatus(0);
        QSearchTroopTabContentViewModel viewModel = qSearchTroopTabContentView.getViewModel();
        if (viewModel != null) {
            PlaceInfo placeInfo = new PlaceInfo(viewModel.getHighlightProvince(), viewModel.getHighlightCity(), viewModel.getHighlightCounty());
            if (!Intrinsics.areEqual(placeInfo, viewModel.getSelectedPlace())) {
                viewModel.setSelectedPlace(placeInfo);
                viewModel.isConditionUpdated = true;
                viewModel.reset();
                viewModel.loadData(viewModel.keyword, viewModel.querySource, false, null);
            }
            qSearchTroopTabContentView.reportTagDTClick(3, viewModel.getSelectedPlace().province.text + '-' + viewModel.getSelectedPlace().city.text + '-' + viewModel.getSelectedPlace().county.text);
        }
    }
}
