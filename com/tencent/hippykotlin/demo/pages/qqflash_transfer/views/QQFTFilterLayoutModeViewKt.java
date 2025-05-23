package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangleOffset;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.FTFilterType;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFTFileListFilterInfo;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterButtonKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionItem;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopoverKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTSwitchModeButtonKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import defpackage.k;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import ws3.ac;
import zz0.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFilterLayoutModeViewKt {
    public static final float kFilterViewContentHeight = 32;

    public static final boolean handleFilterSelection(QQFlashTransferViewModel qQFlashTransferViewModel, QQFTFilterSelectionItem qQFTFilterSelectionItem) {
        FTFilterType fTFilterType;
        if (qQFlashTransferViewModel.isDisableClick()) {
            return false;
        }
        a aVar = a.f453719a;
        if (aVar.a() - qQFlashTransferViewModel.filterTypeClickTimestamp < 500) {
            return false;
        }
        qQFlashTransferViewModel.filterTypeClickTimestamp = aVar.a();
        int ordinal = qQFlashTransferViewModel.filterType.getValue().ordinal();
        int i3 = qQFTFilterSelectionItem.index;
        if (ordinal == i3) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("same type tapped, filterType:");
            m3.append(qQFlashTransferViewModel.filterType.getValue());
            kLog.d("QQFTFilterLayoutModeView", m3.toString());
            return false;
        }
        MutableState<FTFilterType> mutableState = qQFlashTransferViewModel.filterType;
        FTFilterType[] values = FTFilterType.values();
        int length = values.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                fTFilterType = null;
                break;
            }
            fTFilterType = values[i16];
            if (fTFilterType.statusId == i3) {
                break;
            }
            i16++;
        }
        if (fTFilterType == null) {
            fTFilterType = FTFilterType.ALL_FILE;
        }
        mutableState.setValue(fTFilterType);
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleFilterSelection, filterType:");
        m16.append(qQFlashTransferViewModel.filterType.getValue());
        kLog2.d("QQFTFilterLayoutModeView", m16.toString());
        qQFlashTransferViewModel.filterFileType(qQFlashTransferViewModel.filterType.getValue());
        return true;
    }

    public static final void QQFTDetailFilterButton(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        String str;
        String str2;
        ac acVar;
        ac acVar2;
        ac acVar3;
        Composer startRestartGroup = composer.startRestartGroup(920141654);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(920141654, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailFilterButton (QQFTFilterLayoutModeView.kt:155)");
        }
        i.Companion companion = i.INSTANCE;
        if (k.a(c.f117352a)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        i k3 = ViewEventPropUpdaterKt.k(ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(companion, "em_bas_screen", DTReportConstKt.getDTBaseParams(str)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailFilterButton$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                if (!QQFlashTransferViewModel.this.isDisableClick()) {
                    QQFlashTransferViewModel.this.showFilterList.setValue(Boolean.valueOf(!r3.getValue().booleanValue()));
                    KLog.INSTANCE.d("QQFTFilterLayoutModeView", "filter image click");
                }
                return Unit.INSTANCE;
            }
        }, 3, null), new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailFilterButton$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ap3.a aVar) {
                ap3.a aVar2 = aVar;
                QQFlashTransferViewModel.this.filterPopoverPosition.setValue(aVar2);
                KLog kLog = KLog.INSTANCE;
                float f16 = QQFTFilterLayoutModeViewKt.kFilterViewContentHeight;
                kLog.d("QQFTFilterLayoutModeView", "QQFTDetailFilterButton position:" + aVar2);
                return Unit.INSTANCE;
            }
        });
        QQFTFileListFilterInfo selectedCategoryInfo = qQFlashTransferViewModel.getSelectedCategoryInfo();
        boolean z16 = false;
        if ((selectedCategoryInfo == null || (acVar3 = selectedCategoryInfo.categoryInfo) == null || acVar3.f446176a != 0) ? false : true) {
            str2 = "\u7b5b\u9009";
        } else {
            QQFTFileListFilterInfo selectedCategoryInfo2 = qQFlashTransferViewModel.getSelectedCategoryInfo();
            str2 = (selectedCategoryInfo2 == null || (acVar = selectedCategoryInfo2.categoryInfo) == null) ? null : acVar.f446178c;
        }
        QQFTFileListFilterInfo selectedCategoryInfo3 = qQFlashTransferViewModel.getSelectedCategoryInfo();
        if (selectedCategoryInfo3 != null && (acVar2 = selectedCategoryInfo3.categoryInfo) != null && acVar2.f446176a == 0) {
            z16 = true;
        }
        QQFTFilterButtonKt.QQFTFilterButton(k3, str2, z16, qQFlashTransferViewModel.showFilterList.getValue().booleanValue(), startRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailFilterButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFilterLayoutModeViewKt.QQFTDetailFilterButton(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTDetailFilterCategoryItemView(final QQFTFileListFilterInfo qQFTFileListFilterInfo, final Function1<? super QQFTFileListFilterInfo, Unit> function1, Composer composer, final int i3) {
        String str;
        Composer startRestartGroup = composer.startRestartGroup(-570087292);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-570087292, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailFilterCategoryItemView (QQFTFilterLayoutModeView.kt:230)");
        }
        i.Companion companion = i.INSTANCE;
        i y16 = ModifiersKt.y(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 176), 40), ModifiersKt.q(ModifiersKt.d(companion, QUIToken.color$default("overlay_surface_bg")), uo3.c.a(4)), ModifiersKt.q(ModifiersKt.d(companion, QUIToken.color$default("bg_middle_light")), uo3.c.a(0)), 0, false, 12, null);
        if (k.a(c.f117352a)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        e dTBaseParams = DTReportConstKt.getDTBaseParams(str);
        dTBaseParams.v("tag_type", qQFTFileListFilterInfo.categoryInfo.f446178c);
        Unit unit = Unit.INSTANCE;
        RowKt.a(ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(y16, "em_bas_tag_filtering", dTBaseParams), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailFilterCategoryItemView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                KLog kLog = KLog.INSTANCE;
                float f16 = QQFTFilterLayoutModeViewKt.kFilterViewContentHeight;
                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QQFTDetailFilterCategoryItemView onClick:"), QQFTFileListFilterInfo.this.categoryInfo.f446178c, kLog, "QQFTFilterLayoutModeView");
                function1.invoke(QQFTFileListFilterInfo.this);
                return Unit.INSTANCE;
            }
        }, 3, null), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 798760358, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailFilterCategoryItemView$3
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i16;
                int compare;
                Composer composer3;
                int compare2;
                String sb5;
                n nVar2 = nVar;
                Composer composer4 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer4.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(798760358, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailFilterCategoryItemView.<anonymous> (QQFTFilterLayoutModeView.kt:251)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    float f16 = 16;
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion2), f16, 0.0f, 0.0f, 0.0f, 14, null);
                    String str2 = QQFTFileListFilterInfo.this.categoryInfo.f446178c;
                    float f17 = 14;
                    float f18 = 20;
                    c.Companion companion3 = bp3.c.INSTANCE;
                    bp3.c e16 = companion3.e();
                    QUIToken qUIToken = QUIToken.INSTANCE;
                    TextKt.a(str2, n3, null, QUIToken.color$default("text_primary"), Float.valueOf(f17), null, e16, null, null, null, null, Float.valueOf(f18), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer4, 1601600, 48, 0, 134215588);
                    composer4.startReplaceableGroup(940154167);
                    compare = Integer.compare(QQFTFileListFilterInfo.this.categoryInfo.f446177b ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                    if (compare > 0) {
                        i A = ComposeLayoutPropUpdaterKt.A(companion2);
                        compare2 = Integer.compare(QQFTFileListFilterInfo.this.categoryInfo.f446177b ^ Integer.MIN_VALUE, 999 ^ Integer.MIN_VALUE);
                        if (compare2 > 0) {
                            sb5 = " 999+";
                        } else {
                            StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m(TokenParser.SP);
                            m3.append((Object) UInt.m615toStringimpl(QQFTFileListFilterInfo.this.categoryInfo.f446177b));
                            sb5 = m3.toString();
                        }
                        composer3 = composer4;
                        TextKt.a(sb5, A, null, QUIToken.color$default("text_primary"), Float.valueOf(f17), null, companion3.f(), null, null, null, null, Float.valueOf(f18), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 48, 0, 134215588);
                    } else {
                        composer3 = composer4;
                    }
                    composer3.endReplaceableGroup();
                    if (QQFTFileListFilterInfo.this.isSelected.getValue().booleanValue()) {
                        Composer composer5 = composer3;
                        SpacerKt.a(nVar2.a(companion2, 1.0f), composer5, 8, 0);
                        ImageKt.a(qUIToken.image("qui_check", QUIToken.color$default("brand_standard")), null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, f16), 0.0f, 0.0f, 12, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailFilterCategoryItemView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFilterLayoutModeViewKt.QQFTDetailFilterCategoryItemView(QQFTFileListFilterInfo.this, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTDetailFilterCategoryView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1586717477);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1586717477, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailFilterCategoryView (QQFTFilterLayoutModeView.kt:206)");
        }
        QQFTPopoverKt.QQFTPopover(qQFlashTransferViewModel.showFilterList, qQFlashTransferViewModel.filterPopoverPosition.getValue(), new PopoverTriangleOffset(3, -30), ComposableLambdaKt.composableLambda(startRestartGroup, -1724394866, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailFilterCategoryView$1
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
                        ComposerKt.traceEventStart(-1724394866, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailFilterCategoryView.<anonymous> (QQFTFilterLayoutModeView.kt:211)");
                    }
                    i L = ModifiersKt.L(ModifiersKt.q(ModifiersKt.d(ComposeLayoutPropUpdaterKt.q(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), 2), QUIToken.color$default("bg_middle_light")), uo3.c.a(8)), 0.0f, 2.0f, 10.0f, h.INSTANCE.a(0.12f));
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    ColumnKt.a(L, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1306710711, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailFilterCategoryView$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1306710711, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailFilterCategoryView.<anonymous>.<anonymous> (QQFTFilterLayoutModeView.kt:218)");
                                }
                                int size = QQFlashTransferViewModel.this.categoryInfos.size();
                                for (int i16 = 0; i16 < size; i16++) {
                                    final QQFTFileListFilterInfo qQFTFileListFilterInfo = QQFlashTransferViewModel.this.categoryInfos.get(i16);
                                    final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                    QQFTFilterLayoutModeViewKt.QQFTDetailFilterCategoryItemView(qQFTFileListFilterInfo, new Function1<QQFTFileListFilterInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt.QQFTDetailFilterCategoryView.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QQFTFileListFilterInfo qQFTFileListFilterInfo2) {
                                            QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                            QQFTFileListFilterInfo qQFTFileListFilterInfo3 = qQFTFileListFilterInfo;
                                            float f16 = QQFTFilterLayoutModeViewKt.kFilterViewContentHeight;
                                            if (!qQFlashTransferViewModel4.isDisableClick()) {
                                                a aVar = a.f453719a;
                                                if (aVar.a() - qQFlashTransferViewModel4.filterTypeClickTimestamp >= 500) {
                                                    qQFlashTransferViewModel4.filterTypeClickTimestamp = aVar.a();
                                                    Iterator<QQFTFileListFilterInfo> it = qQFlashTransferViewModel4.categoryInfos.iterator();
                                                    while (it.hasNext()) {
                                                        QQFTFileListFilterInfo next = it.next();
                                                        next.isSelected.setValue(Boolean.valueOf(Intrinsics.areEqual(next.categoryInfo.f446178c, qQFTFileListFilterInfo3.categoryInfo.f446178c)));
                                                    }
                                                    qQFlashTransferViewModel4.showFilterList.setValue(Boolean.FALSE);
                                                    int m570constructorimpl = UInt.m570constructorimpl(qQFlashTransferViewModel4.fileCategory.getValue().intValue());
                                                    int i17 = qQFTFileListFilterInfo3.categoryInfo.f446176a;
                                                    if (m570constructorimpl == i17) {
                                                        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("same type tapped, categoryInfo:"), qQFTFileListFilterInfo3.categoryInfo.f446178c, KLog.INSTANCE, "QQFTFilterLayoutModeView");
                                                    } else {
                                                        qQFlashTransferViewModel4.fileCategory.setValue(Integer.valueOf(i17));
                                                        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleFTDetailFilterCategorySelection, categoryInfo:"), qQFTFileListFilterInfo3.categoryInfo.f446178c, KLog.INSTANCE, "QQFTFilterLayoutModeView");
                                                        qQFlashTransferViewModel4.filterFileType(qQFlashTransferViewModel4.filterType.getValue());
                                                    }
                                                }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailFilterCategoryView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFilterLayoutModeViewKt.QQFTDetailFilterCategoryView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTDetailSwitchModeButton(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        String str;
        String str2;
        Composer startRestartGroup = composer.startRestartGroup(-145282569);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-145282569, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailSwitchModeButton (QQFTFilterLayoutModeView.kt:179)");
        }
        i A = ModifiersKt.A(i.INSTANCE, 0.5f, 0.0f, 2, null);
        if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        e dTBaseParams = DTReportConstKt.getDTBaseParams(str);
        if (qQFlashTransferViewModel.isGridMode.getValue().booleanValue()) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        dTBaseParams.v("switching_action", str2);
        Unit unit = Unit.INSTANCE;
        QQFTSwitchModeButtonKt.QQFTSwitchModeButton(ViewEventPropUpdaterKt.d(ModifierExtKt.elementVR(A, "em_bas_view_switch_button", dTBaseParams), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailSwitchModeButton$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                if (!QQFlashTransferViewModel.this.isDisableClick()) {
                    QQFlashTransferViewModel.this.isGridMode.setValue(Boolean.valueOf(!r5.getValue().booleanValue()));
                    com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                    CacheModule cacheModule = (CacheModule) cVar.g().acquireModule("HRCacheModule");
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("qq_flash_transfer_list_mode");
                    m3.append(cVar.g().getPageData().n().q("uin", ""));
                    cacheModule.setInt(m3.toString(), Integer.valueOf(!QQFlashTransferViewModel.this.isGridMode.getValue().booleanValue() ? 1 : 0));
                }
                return Unit.INSTANCE;
            }
        }, 3, null), qQFlashTransferViewModel.isGridMode.getValue().booleanValue(), startRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTDetailSwitchModeButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFilterLayoutModeViewKt.QQFTDetailSwitchModeButton(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM>, java.util.ArrayList] */
    public static final void QQFTFilterLayoutModeView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1930961241);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1930961241, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeView (QQFTFilterLayoutModeView.kt:71)");
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("isLoadingData=");
        m3.append(qQFlashTransferViewModel.isLoadingData.getValue().booleanValue());
        m3.append(" itemVMList=");
        m3.append(qQFlashTransferViewModel.itemVMList.isEmpty());
        kLog.d("QQFTFilterLayoutModeView", m3.toString());
        if (!qQFlashTransferViewModel.canShowAllSelectCheckBox()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTFilterLayoutModeView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    QQFTFilterLayoutModeViewKt.QQFTFilterLayoutModeView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 257597278, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTFilterLayoutModeView$2
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
                        ComposerKt.traceEventStart(257597278, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeView.<anonymous> (QQFTFilterLayoutModeView.kt:76)");
                    }
                    i.Companion companion = i.INSTANCE;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), 0.0f, 1, null), composer3, 8, 0);
                    QQFTFilterLayoutModeViewKt.filterContentView(QQFlashTransferViewModel.this, composer3, 8);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(companion, 12.0f), 0.0f, 1, null), composer3, 8, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$QQFTFilterLayoutModeView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFilterLayoutModeViewKt.QQFTFilterLayoutModeView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void filterContentView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(242734837);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(242734837, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.filterContentView (QQFTFilterLayoutModeView.kt:86)");
        }
        RowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), kFilterViewContentHeight), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 440500243, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$filterContentView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i16;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(440500243, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.filterContentView.<anonymous> (QQFTFilterLayoutModeView.kt:90)");
                    }
                    TextKt.a("\u6587\u4ef6", null, null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601542, 0, 0, 134216614);
                    if (QQFlashTransferViewModel.this.compressedFileFolderId.length() == 0) {
                        composer3.startReplaceableGroup(261314051);
                        i.Companion companion = i.INSTANCE;
                        SpacerKt.a(nVar2.a(companion, 1.0f), composer3, 8, 0);
                        i b16 = ModifiersKt.b(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.B(companion), 0.0f, 1, null), QQFlashTransferViewModel.this.isDisableClick() ? 0.3f : 1.0f);
                        final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                        RowKt.a(b16, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 577878006, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$filterContentView$1.1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar3, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(577878006, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.filterContentView.<anonymous>.<anonymous> (QQFTFilterLayoutModeView.kt:105)");
                                    }
                                    QQFTFilterSelectionViewModel filterSelectionModel = QQFlashTransferViewModel.this.getFilterSelectionModel();
                                    final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                    QQFTFilterSelectionKt.QQFTFilterSelectionView(filterSelectionModel, new Function1<QQFTFilterSelectionItem, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt.filterContentView.1.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Boolean invoke(QQFTFilterSelectionItem qQFTFilterSelectionItem) {
                                            return Boolean.valueOf(QQFTFilterLayoutModeViewKt.handleFilterSelection(QQFlashTransferViewModel.this, qQFTFilterSelectionItem));
                                        }
                                    }, composer5, 8);
                                    composer5.startReplaceableGroup(-644752830);
                                    if (QQFlashTransferViewModel.this.clusterId.length() == 0) {
                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12), composer5, 8, 0);
                                        QQFTFilterLayoutModeViewKt.QQFTDetailFilterButton(QQFlashTransferViewModel.this, composer5, 8);
                                    }
                                    composer5.endReplaceableGroup();
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 4), composer5, 8, 0);
                                    QQFTFilterLayoutModeViewKt.QQFTDetailSwitchModeButton(QQFlashTransferViewModel.this, composer5, 8);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 30);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(261314805);
                        i a16 = nVar2.a(i.INSTANCE, 1.0f);
                        final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                        BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer3, 314243881, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$filterContentView$1.2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                int i17;
                                b bVar2 = bVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i17 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                                } else {
                                    i17 = intValue2;
                                }
                                if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(314243881, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.filterContentView.<anonymous>.<anonymous> (QQFTFilterLayoutModeView.kt:121)");
                                    }
                                    i b17 = ModifiersKt.b(bVar2.a(i.INSTANCE, Alignment.CenterEnd), QQFlashTransferViewModel.this.isDisableClick() ? 0.3f : 1.0f);
                                    final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                    ColumnKt.a(b17, null, null, null, ComposableLambdaKt.composableLambda(composer5, 1990533586, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt.filterContentView.1.2.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1990533586, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.filterContentView.<anonymous>.<anonymous>.<anonymous> (QQFTFilterLayoutModeView.kt:122)");
                                                }
                                                QQFTFilterSelectionViewModel filterSelectionModel = QQFlashTransferViewModel.this.getFilterSelectionModel();
                                                final QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                                                QQFTFilterSelectionKt.QQFTFilterSelectionView(filterSelectionModel, new Function1<QQFTFilterSelectionItem, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt.filterContentView.1.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Boolean invoke(QQFTFilterSelectionItem qQFTFilterSelectionItem) {
                                                        return Boolean.valueOf(QQFTFilterLayoutModeViewKt.handleFilterSelection(QQFlashTransferViewModel.this, qQFTFilterSelectionItem));
                                                    }
                                                }, composer7, 8);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 24584, 14);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        composer3.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt$filterContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFilterLayoutModeViewKt.filterContentView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
