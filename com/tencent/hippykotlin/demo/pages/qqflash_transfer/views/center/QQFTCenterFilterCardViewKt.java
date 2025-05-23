package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$resetFooterRefresh$1;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangleOffset;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterButtonKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopoverKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTSwitchModeButtonKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFilterCardVM;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.p;
import defpackage.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCenterFilterCardViewKt {
    public static final float kFilterButtonHeight = 32;

    public static final void QQFTCenterFilterButton(final QQFTCenterFilterCardVM qQFTCenterFilterCardVM, Composer composer, final int i3) {
        String str;
        String displayTextForFileSetListType;
        Composer startRestartGroup = composer.startRestartGroup(1406910228);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1406910228, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterButton (QQFTCenterFilterCardView.kt:104)");
        }
        State derivedStateOf = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterButton$isAllSelect$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(QQFTCenterFilterCardVM.this.currentFilterType.getValue().intValue() == 3);
            }
        });
        i b16 = ModifiersKt.b(i.INSTANCE, qQFTCenterFilterCardVM.f114263vm.hasTransferHistory.getValue().booleanValue() ? 1.0f : 0.5f);
        if (k.a(c.f117352a)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        i k3 = ViewEventPropUpdaterKt.k(ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(b16, "em_bas_screen", DTReportConstKt.getDTBaseParams(str)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterButton$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                if (QQFTCenterFilterCardVM.this.f114263vm.hasTransferHistory.getValue().booleanValue()) {
                    QQFTCenterFilterCardVM.this.showFilterContent.setValue(Boolean.valueOf(!r3.getValue().booleanValue()));
                    KLog kLog = KLog.INSTANCE;
                    float f16 = QQFTCenterFilterCardViewKt.kFilterButtonHeight;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QQFTCenterFilterButton click currentValue:");
                    m3.append(QQFTCenterFilterCardVM.this.showFilterContent.getValue().booleanValue());
                    kLog.d("QQFTCenterFilterCardView", m3.toString());
                }
                return Unit.INSTANCE;
            }
        }, 3, null), new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterButton$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(a aVar) {
                a aVar2 = aVar;
                QQFTCenterFilterCardVM.this.filterPopoverPosition.setValue(aVar2);
                KLog kLog = KLog.INSTANCE;
                float f16 = QQFTCenterFilterCardViewKt.kFilterButtonHeight;
                kLog.d("QQFTCenterFilterCardView", "QQFTDetailFilterButton position:" + aVar2);
                return Unit.INSTANCE;
            }
        });
        if (((Boolean) derivedStateOf.getValue()).booleanValue()) {
            displayTextForFileSetListType = "\u7b5b\u9009";
        } else {
            displayTextForFileSetListType = qQFTCenterFilterCardVM.displayTextForFileSetListType(qQFTCenterFilterCardVM.currentFilterType.getValue().intValue());
        }
        QQFTFilterButtonKt.QQFTFilterButton(k3, displayTextForFileSetListType, ((Boolean) derivedStateOf.getValue()).booleanValue(), qQFTCenterFilterCardVM.showFilterContent.getValue().booleanValue(), startRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFilterCardViewKt.QQFTCenterFilterButton(QQFTCenterFilterCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTCenterFilterCardView(final QQFTCenterFilterCardVM qQFTCenterFilterCardVM, Composer composer, final int i3) {
        final float m3;
        Composer startRestartGroup = composer.startRestartGroup(73406135);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(73406135, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardView (QQFTCenterFilterCardView.kt:55)");
        }
        if (qQFTCenterFilterCardVM.listGridMode.getValue().booleanValue()) {
            m3 = c.f117352a.g().getPageData().m() - 32.0f;
        } else {
            m3 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(c.f117352a);
        }
        final float f16 = qQFTCenterFilterCardVM.listGridMode.getValue().booleanValue() ? 0.0f : 16.0f;
        ColumnKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, m3), qQFTCenterFilterCardVM.listGridMode.getValue().booleanValue() ? kFilterButtonHeight : 56), com.tencent.ntcompose.foundation.layout.base.a.f339245a.b(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 334245984, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(334245984, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardView.<anonymous> (QQFTCenterFilterCardView.kt:62)");
                    }
                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, m3), QQFTCenterFilterCardViewKt.kFilterButtonHeight);
                    float f17 = f16;
                    i s16 = ComposeLayoutPropUpdaterKt.s(k3, f17, 0.0f, f17, 0.0f, 10, null);
                    a.d g16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.g();
                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                    final QQFTCenterFilterCardVM qQFTCenterFilterCardVM2 = qQFTCenterFilterCardVM;
                    RowKt.a(s16, g16, vertical, null, null, ComposableLambdaKt.composableLambda(composer3, -631379586, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterCardView$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            int i16;
                            n nVar2 = nVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(nVar2) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-631379586, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardView.<anonymous>.<anonymous> (QQFTCenterFilterCardView.kt:68)");
                                }
                                i.Companion companion = i.INSTANCE;
                                TextKt.a("\u4f20\u8f93\u5386\u53f2", ComposeLayoutPropUpdaterKt.A(companion), null, QUIToken.color$default("text_primary"), Float.valueOf(17), null, bp3.c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601606, 0, 0, 134217636);
                                SpacerKt.a(nVar2.a(companion, 1.0f), composer5, 8, 0);
                                QQFTCenterFilterCardViewKt.QQFTCenterFilterButton(QQFTCenterFilterCardVM.this, composer5, 8);
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 4), composer5, 8, 0);
                                QQFTCenterFilterCardViewKt.QQFTCenterListModeButton(QQFTCenterFilterCardVM.this, composer5, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 197064, 24);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24648, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFilterCardViewKt.QQFTCenterFilterCardView(QQFTCenterFilterCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTCenterFilterCategoryView(final QQFTCenterFilterCardVM qQFTCenterFilterCardVM, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1055445413);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1055445413, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCategoryView (QQFTCenterFilterCardView.kt:160)");
        }
        QQFTPopoverKt.QQFTPopover(qQFTCenterFilterCardVM.showFilterContent, qQFTCenterFilterCardVM.filterPopoverPosition.getValue(), new PopoverTriangleOffset(3, -30), ComposableLambdaKt.composableLambda(startRestartGroup, 668900316, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterCategoryView$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(668900316, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCategoryView.<anonymous> (QQFTCenterFilterCardView.kt:165)");
                    }
                    i L = ModifiersKt.L(ModifiersKt.q(ModifiersKt.d(ComposeLayoutPropUpdaterKt.q(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), 2), QUIToken.color$default("bg_middle_light")), uo3.c.a(8)), 0.0f, 2.0f, 10.0f, h.INSTANCE.a(0.12f));
                    final QQFTCenterFilterCardVM qQFTCenterFilterCardVM2 = QQFTCenterFilterCardVM.this;
                    ColumnKt.a(L, null, null, null, ComposableLambdaKt.composableLambda(composer3, -334869165, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterCategoryView$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            List listOf;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-334869165, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCategoryView.<anonymous>.<anonymous> (QQFTCenterFilterCardView.kt:172)");
                                }
                                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 1, 2});
                                Iterator it = listOf.iterator();
                                while (it.hasNext()) {
                                    int intValue3 = ((Number) it.next()).intValue();
                                    final QQFTCenterFilterCardVM qQFTCenterFilterCardVM3 = QQFTCenterFilterCardVM.this;
                                    QQFTCenterFilterCardViewKt.QQFTCenterFilterItemView(qQFTCenterFilterCardVM3, intValue3, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt.QQFTCenterFilterCategoryView.1.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Integer num3) {
                                            int intValue4 = num3.intValue();
                                            final QQFTCenterFilterCardVM qQFTCenterFilterCardVM4 = QQFTCenterFilterCardVM.this;
                                            float f16 = QQFTCenterFilterCardViewKt.kFilterButtonHeight;
                                            qQFTCenterFilterCardVM4.showFilterContent.setValue(Boolean.FALSE);
                                            if (qQFTCenterFilterCardVM4.currentFilterType.getValue().intValue() != intValue4) {
                                                qQFTCenterFilterCardVM4.currentFilterType.setValue(Integer.valueOf(intValue4));
                                                QQTransferCenterViewModel qQTransferCenterViewModel = qQFTCenterFilterCardVM4.f114263vm;
                                                qQTransferCenterViewModel.paginationInfo = null;
                                                qQTransferCenterViewModel.isLoadDataEnd = false;
                                                qQTransferCenterViewModel.isLoadDataError = false;
                                                ComposeFeedListViewModel composeFeedListViewModel = qQTransferCenterViewModel.feedListViewModel;
                                                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$handleFilterItemClick$1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        p pVar = QQFTCenterFilterCardVM.this.f114263vm.feedListViewModel.footerRefreshState;
                                                        if (pVar != null) {
                                                            pVar.b(true);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composeFeedListViewModel.disableFooterRefresh.setValue(Boolean.TRUE);
                                                composeFeedListViewModel.footerRefreshState = null;
                                                TimerKt.c(17, new ComposeFeedListViewModel$resetFooterRefresh$1(composeFeedListViewModel, function0));
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, composer5, 8);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3136, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterCategoryView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFilterCardViewKt.QQFTCenterFilterCategoryView(QQFTCenterFilterCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTCenterFilterItemView(final QQFTCenterFilterCardVM qQFTCenterFilterCardVM, final int i3, final Function1<? super Integer, Unit> function1, Composer composer, final int i16) {
        String str;
        String str2;
        Composer startRestartGroup = composer.startRestartGroup(-825922230);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-825922230, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterItemView (QQFTCenterFilterCardView.kt:184)");
        }
        final String displayTextForFileSetListType = qQFTCenterFilterCardVM.displayTextForFileSetListType(i3);
        i.Companion companion = i.INSTANCE;
        i y16 = ModifiersKt.y(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 176), 40), ModifiersKt.q(ModifiersKt.d(companion, QUIToken.color$default("overlay_surface_bg")), uo3.c.a(4)), ModifiersKt.q(ModifiersKt.d(companion, QUIToken.color$default("bg_middle_light")), uo3.c.a(0)), 0, false, 12, null);
        if (k.a(c.f117352a)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        e dTBaseParams = DTReportConstKt.getDTBaseParams(str);
        if (i3 == 1) {
            str2 = "2";
        } else if (i3 != 3) {
            str2 = "3";
        } else {
            str2 = "1";
        }
        dTBaseParams.v("function_name", str2);
        Unit unit = Unit.INSTANCE;
        i elementVR = ModifierExtKt.elementVR(y16, "em_bas_screening_function", dTBaseParams);
        Integer valueOf = Integer.valueOf(i3);
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(displayTextForFileSetListType) | startRestartGroup.changed(function1);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterItemView$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    KLog kLog = KLog.INSTANCE;
                    float f16 = QQFTCenterFilterCardViewKt.kFilterButtonHeight;
                    NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QQFTCenterFilterItemView onClick:"), displayTextForFileSetListType, kLog, "QQFTCenterFilterCardView");
                    function1.invoke(Integer.valueOf(i3));
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        RowKt.a(ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2094910696, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterItemView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i17;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2094910696, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterItemView.<anonymous> (QQFTCenterFilterCardView.kt:211)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    float f16 = 16;
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion2), f16, 0.0f, 0.0f, 0.0f, 14, null);
                    bp3.c e16 = bp3.c.INSTANCE.e();
                    QUIToken qUIToken = QUIToken.INSTANCE;
                    TextKt.a(displayTextForFileSetListType, n3, null, QUIToken.color$default("text_primary"), Float.valueOf(14), null, e16, null, null, null, null, Float.valueOf(20), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 48, 0, 134215588);
                    if (qQFTCenterFilterCardVM.currentFilterType.getValue().intValue() == i3) {
                        SpacerKt.a(nVar2.a(companion2, 1.0f), composer3, 8, 0);
                        ImageKt.a(qUIToken.image("qui_check", QUIToken.color$default("brand_standard")), null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, f16), 0.0f, 0.0f, 12, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterFilterItemView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFilterCardViewKt.QQFTCenterFilterItemView(QQFTCenterFilterCardVM.this, i3, function1, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTCenterListModeButton(final QQFTCenterFilterCardVM qQFTCenterFilterCardVM, Composer composer, final int i3) {
        String str;
        Composer startRestartGroup = composer.startRestartGroup(-969180739);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-969180739, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterListModeButton (QQFTCenterFilterCardView.kt:138)");
        }
        i.Companion companion = i.INSTANCE;
        i y16 = ModifiersKt.y(companion, ModifiersKt.b(companion, 0.5f), ModifiersKt.b(companion, qQFTCenterFilterCardVM.f114263vm.hasTransferHistory.getValue().booleanValue() ? 1.0f : 0.5f), 0, false, 12, null);
        if (k.a(c.f117352a)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        QQFTSwitchModeButtonKt.QQFTSwitchModeButton(ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(y16, "em_bas_view_switch_button", DTReportConstKt.getDTBaseParams(str)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterListModeButton$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                if (QQFTCenterFilterCardVM.this.f114263vm.hasTransferHistory.getValue().booleanValue()) {
                    QQFTCenterFilterCardVM.this.listGridMode.setValue(Boolean.valueOf(!r5.getValue().booleanValue()));
                    c cVar = c.f117352a;
                    CacheModule cacheModule = (CacheModule) cVar.g().acquireModule("HRCacheModule");
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("kQQFTCenterListGridModeKey");
                    m3.append(cVar.g().getPageData().n().q("uin", ""));
                    cacheModule.setInt(m3.toString(), Integer.valueOf(!QQFTCenterFilterCardVM.this.listGridMode.getValue().booleanValue() ? 1 : 0));
                }
                return Unit.INSTANCE;
            }
        }, 3, null), qQFTCenterFilterCardVM.listGridMode.getValue().booleanValue(), startRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFilterCardViewKt$QQFTCenterListModeButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCenterFilterCardViewKt.QQFTCenterListModeButton(QQFTCenterFilterCardVM.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
