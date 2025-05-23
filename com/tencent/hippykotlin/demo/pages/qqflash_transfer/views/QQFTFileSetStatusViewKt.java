package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import bp3.a;
import bp3.c;
import bp3.j;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQAnimatedImageKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFTFileListFilterInfo;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTPopoverKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
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
import com.tencent.ntcompose.material.ProgressIndicatorKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import defpackage.l;
import java.util.List;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import ws3.br;
import ws3.es;
import ws3.x;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFileSetStatusViewKt {
    public static final void access$expireStatusUI(final float f16, final QQFlashTransferViewModel qQFlashTransferViewModel, final float f17, Composer composer, final int i3) {
        x xVar;
        Composer startRestartGroup = composer.startRestartGroup(830263789);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830263789, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.expireStatusUI (QQFTFileSetStatusView.kt:97)");
        }
        i.Companion companion = i.INSTANCE;
        ImageKt.a(QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error")), null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, f17), 0.0f, 0.0f, 4.0f, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, startRestartGroup, 262144, 0, 0, 2097118);
        br value = qQFlashTransferViewModel.fileSet.getValue();
        String str = value != null && value.f446201o == 7 ? "\u6587\u4ef6\u5df2\u5220\u9664" : "\u6587\u4ef6\u5df2\u8fc7\u671f";
        h color$default = QUIToken.color$default("text_secondary");
        c.Companion companion2 = c.INSTANCE;
        int i16 = (i3 << 12) & 57344;
        int i17 = i16 | 1576960;
        TextKt.a(str, null, null, color$default, Float.valueOf(f16), null, companion2.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, i17, 0, 0, 134215590);
        QQFTCircleDotViewKt.QQFTCircleDotView(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, f17), 2.0f), 2.0f, startRestartGroup, 56);
        TextKt.a(ULong.m693toStringimpl(qQFlashTransferViewModel.m116getCurPageFirstLevelItemCountsVKNKU()), null, null, QUIToken.color$default("text_primary"), Float.valueOf(f16), null, companion2.a(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, i17, 0, 0, 134215590);
        TextKt.a("\u9879", ComposeLayoutPropUpdaterKt.n(companion, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, companion2.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, i16 | 1577030, 0, 0, 134215588);
        QQFTCircleDotViewKt.QQFTCircleDotView(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, f17), 2.0f), 2.0f, startRestartGroup, 56);
        br value2 = qQFlashTransferViewModel.fileSet.getValue();
        TextKt.a(String.valueOf((value2 == null || (xVar = value2.f446198l) == null) ? 0 : UInt.m564boximpl(xVar.f446402b)), null, null, QUIToken.color$default("text_primary"), Float.valueOf(f16), null, companion2.a(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, i17, 0, 0, 134215590);
        TextKt.a(" \u9879\u5df2\u4e0b\u8f7d", null, null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, companion2.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, i16 | 1576966, 0, 0, 134215590);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$expireStatusUI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileSetStatusViewKt.access$expireStatusUI(f16, qQFlashTransferViewModel, f17, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final i access$updateTitleBubblePosition(i iVar, final QQFlashTransferViewModel qQFlashTransferViewModel, boolean z16) {
        h j3;
        if (z16 || qQFlashTransferViewModel.isCompressPage()) {
            return iVar;
        }
        float f16 = 2;
        i s16 = ComposeLayoutPropUpdaterKt.s(iVar, f16, 0.0f, f16, 0.0f, 10, null);
        if (qQFlashTransferViewModel.showTitleBubbleView.getValue().booleanValue()) {
            j3 = QUIToken.color$default("overlay_surface_bg");
        } else {
            j3 = h.INSTANCE.j();
        }
        return ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.k(ModifiersKt.q(ModifiersKt.d(s16, j3), uo3.c.a(4)), new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$updateTitleBubblePosition$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(a aVar) {
                a aVar2 = aVar;
                QQFlashTransferViewModel.this.titleBubblePosition.setValue(aVar2);
                KLog.INSTANCE.d("QQFTFileSetStatusView", "QQFTFileSetStatusView position:" + aVar2);
                return Unit.INSTANCE;
            }
        }), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$updateTitleBubblePosition$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                QQFlashTransferViewModel.this.showTitleBubbleView.setValue(Boolean.TRUE);
                KLog.INSTANCE.d("QQFTFileSetStatusView", "show titleBubble");
                return Unit.INSTANCE;
            }
        }, 3, null);
    }

    public static final void QQFTDetailExpireBubbleView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1096351817);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1096351817, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailExpireBubbleView (QQFTFileSetStatusView.kt:512)");
        }
        QQFTPopoverKt.QQFTPopover(qQFlashTransferViewModel.showExpireBubbleView, qQFlashTransferViewModel.expireBubblePosition.getValue(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 1846727342, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$QQFTDetailExpireBubbleView$1
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
                        ComposerKt.traceEventStart(1846727342, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailExpireBubbleView.<anonymous> (QQFTFileSetStatusView.kt:517)");
                    }
                    float f16 = 16;
                    float f17 = 12;
                    i r16 = ComposeLayoutPropUpdaterKt.r(ModifiersKt.L(ModifiersKt.q(ModifiersKt.d(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), QUIToken.color$default("bg_middle_light")), uo3.c.a(8)), 0.0f, 2.0f, 10.0f, h.INSTANCE.a(0.12f)), f16, f17, f16, f17);
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    ColumnKt.a(r16, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1471111963, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$QQFTDetailExpireBubbleView$1.1
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
                                    ComposerKt.traceEventStart(-1471111963, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailExpireBubbleView.<anonymous>.<anonymous> (QQFTFileSetStatusView.kt:524)");
                                }
                                BridgeModule bridgeModule = (BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule");
                                br value = QQFlashTransferViewModel.this.fileSet.getValue();
                                TextKt.a(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("\u8fc7\u671f\u65f6\u95f4\uff1a", bridgeModule.dateFormatter(value != null ? value.f446195i : 0L, "yyyy/MM/dd HH:mm")), null, null, QUIToken.color$default("text_primary"), Float.valueOf(14), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(20), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601536, 48, 0, 134215590);
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
        }), startRestartGroup, 3520, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$QQFTDetailExpireBubbleView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileSetStatusViewKt.QQFTDetailExpireBubbleView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTDetailTitleBubbleView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1551599818);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1551599818, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailTitleBubbleView (QQFTFileSetStatusView.kt:477)");
        }
        QQFTPopoverKt.QQFTPopover(qQFlashTransferViewModel.showTitleBubbleView, qQFlashTransferViewModel.titleBubblePosition.getValue(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1872303777, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$QQFTDetailTitleBubbleView$1
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
                        ComposerKt.traceEventStart(-1872303777, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailTitleBubbleView.<anonymous> (QQFTFileSetStatusView.kt:482)");
                    }
                    float f16 = 16;
                    float f17 = 12;
                    i r16 = ComposeLayoutPropUpdaterKt.r(ModifiersKt.L(ModifiersKt.q(ModifiersKt.d(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.y(i.INSTANCE, 0.0f, 300, 1, null)), QUIToken.color$default("bg_middle_light")), uo3.c.a(8)), 0.0f, 2.0f, 10.0f, h.INSTANCE.a(0.12f)), f16, f17, f16, f17);
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    ColumnKt.a(r16, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1622899784, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$QQFTDetailTitleBubbleView$1.1
                        {
                            super(3);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:24:0x00fa  */
                        /* JADX WARN: Removed duplicated region for block: B:58:0x024c  */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            String m693toStringimpl;
                            int size;
                            int i16;
                            int compare;
                            Object obj;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1622899784, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTDetailTitleBubbleView.<anonymous>.<anonymous> (QQFTFileSetStatusView.kt:489)");
                                }
                                if (!QQFlashTransferViewModel.this.isSecondaryPage() && QQFlashTransferViewModel.this.fileSet.getValue() != null) {
                                    br value = QQFlashTransferViewModel.this.fileSet.getValue();
                                    Intrinsics.checkNotNull(value);
                                    compare = Integer.compare(value.f446196j ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                                    if (compare > 0) {
                                        br value2 = QQFlashTransferViewModel.this.fileSet.getValue();
                                        if (value2 != null) {
                                            obj = UInt.m564boximpl(value2.f446196j);
                                        } else {
                                            obj = 0;
                                        }
                                        m693toStringimpl = String.valueOf(obj);
                                        TextKt.a(AgreementConsentViewKt$$ExternalSyntheticOutline0.m(m693toStringimpl, " \u9879\u5305\u542b\uff1a"), null, null, QUIToken.color$default("text_primary"), Float.valueOf(14), null, c.INSTANCE.f(), null, null, null, null, Float.valueOf(20), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601536, 48, 0, 134215590);
                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 8), composer5, 8, 0);
                                        QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                        qQFlashTransferViewModel3.getClass();
                                        a.C0144a c0144a = new a.C0144a(0, 1, null);
                                        size = qQFlashTransferViewModel3.categoryInfos.size();
                                        for (i16 = 0; i16 < size; i16++) {
                                            QQFTFileListFilterInfo qQFTFileListFilterInfo = qQFlashTransferViewModel3.categoryInfos.get(i16);
                                            if (qQFTFileListFilterInfo.categoryInfo.f446176a != 0) {
                                                h color$default = QUIToken.color$default("text_primary");
                                                float f18 = 12;
                                                float f19 = 16;
                                                c.Companion companion = c.INSTANCE;
                                                int e16 = c0144a.e(new j(color$default, Float.valueOf(f18), companion.e(), null, null, null, null, null, null, Float.valueOf(f19), null, null, null, null, null, 32248, null));
                                                try {
                                                    c0144a.a(qQFTFileListFilterInfo.categoryInfo.f446178c);
                                                    Unit unit = Unit.INSTANCE;
                                                    c0144a.c(e16);
                                                    e16 = c0144a.e(new j(QUIToken.color$default("text_primary"), Float.valueOf(f18), companion.f(), null, null, null, null, null, null, Float.valueOf(f19), null, null, null, null, null, 32248, null));
                                                    try {
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append(TokenParser.SP);
                                                        sb5.append((Object) UInt.m615toStringimpl(qQFTFileListFilterInfo.categoryInfo.f446177b));
                                                        sb5.append(TokenParser.SP);
                                                        c0144a.a(sb5.toString());
                                                        c0144a.c(e16);
                                                        e16 = c0144a.e(new j(QUIToken.color$default("text_primary"), Float.valueOf(f18), companion.e(), null, null, null, null, null, null, Float.valueOf(f19), null, null, null, null, null, 32248, null));
                                                        try {
                                                            if (i16 == qQFlashTransferViewModel3.categoryInfos.size() - 1) {
                                                                c0144a.a("\u4e2a");
                                                            } else {
                                                                c0144a.a("\u4e2a\uff0c");
                                                            }
                                                        } finally {
                                                        }
                                                    } finally {
                                                    }
                                                } finally {
                                                }
                                            }
                                        }
                                        RichTextKt.b(c0144a.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, composer5, 0, 100663296, 0, 268173310);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }
                                m693toStringimpl = ULong.m693toStringimpl(QQFlashTransferViewModel.this.m115getCurPageFileTotalCountsVKNKU());
                                TextKt.a(AgreementConsentViewKt$$ExternalSyntheticOutline0.m(m693toStringimpl, " \u9879\u5305\u542b\uff1a"), null, null, QUIToken.color$default("text_primary"), Float.valueOf(14), null, c.INSTANCE.f(), null, null, null, null, Float.valueOf(20), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601536, 48, 0, 134215590);
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 8), composer5, 8, 0);
                                QQFlashTransferViewModel qQFlashTransferViewModel32 = QQFlashTransferViewModel.this;
                                qQFlashTransferViewModel32.getClass();
                                a.C0144a c0144a2 = new a.C0144a(0, 1, null);
                                size = qQFlashTransferViewModel32.categoryInfos.size();
                                while (i16 < size) {
                                }
                                RichTextKt.b(c0144a2.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, composer5, 0, 100663296, 0, 268173310);
                                if (ComposerKt.isTraceInProgress()) {
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
        }), startRestartGroup, 3520, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$QQFTDetailTitleBubbleView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileSetStatusViewKt.QQFTDetailTitleBubbleView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$uploadingStatusUI(final float f16, final QQFlashTransferViewModel qQFlashTransferViewModel, final float f17, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(936287667);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(936287667, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.uploadingStatusUI (QQFTFileSetStatusView.kt:323)");
        }
        RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2054051413, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$uploadingStatusUI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i16;
                Object obj;
                Object obj2;
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
                        ComposerKt.traceEventStart(2054051413, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.uploadingStatusUI.<anonymous> (QQFTFileSetStatusView.kt:324)");
                    }
                    if (QQFlashTransferViewModel.this.needShowUploadFinishAnim.getValue().booleanValue()) {
                        composer3.startReplaceableGroup(745804571);
                        QQAnimatedImageKt.QQAnimatedImage("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_gsha0NT3QkL.png", nVar2.b(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f17), Alignment.INSTANCE.c()), true, 1, composer3, 3526, 0);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(745804901);
                        i b16 = nVar2.b(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f17), Alignment.INSTANCE.c());
                        final float f18 = f17;
                        final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                        BoxKt.a(b16, null, null, ComposableLambdaKt.composableLambda(composer3, 1103033343, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$uploadingStatusUI$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        ComposerKt.traceEventStart(1103033343, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.uploadingStatusUI.<anonymous>.<anonymous> (QQFTFileSetStatusView.kt:333)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    i u16 = ComposeLayoutPropUpdaterKt.u(companion, f18);
                                    Alignment alignment = Alignment.Center;
                                    QQAnimatedImageKt.QQAnimatedImage("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_gR8HQsYZIjH.png", bVar2.a(u16, alignment), true, 0, composer5, 3526, 0);
                                    ProgressIndicatorKt.a(qQFlashTransferViewModel2.uploadProcess.getValue().floatValue(), bVar2.a(ComposeLayoutPropUpdaterKt.u(companion, f18 - 2), alignment), new h(4278226175L), QUIToken.color$default("overlay_standard_primary"), 1.5f, l.f413536a.d(qQFlashTransferViewModel2.uploadSpeed.getValue().getData()), composer5, 29248, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        composer3.endReplaceableGroup();
                    }
                    if (QQFlashTransferViewModel.this.isUploadCreator()) {
                        composer3.startReplaceableGroup(745805843);
                        l lVar = l.f413536a;
                        String b17 = lVar.b(QQFlashTransferViewModel.this.uploadedFileSize.getValue().longValue());
                        h color$default = QUIToken.color$default("text_primary");
                        c.Companion companion = c.INSTANCE;
                        TextKt.a(b17, ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, color$default, Float.valueOf(f16), null, companion.a(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i3 << 12) & 57344) | 1577024, 0, 0, 134215588);
                        TextKt.a(lVar.c(QQFlashTransferViewModel.this.uploadedFileSize.getValue().longValue()) + '/', null, null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, companion.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i3 << 12) & 57344) | 1576960, 0, 0, 134215590);
                        br value = QQFlashTransferViewModel.this.fileSet.getValue();
                        Intrinsics.checkNotNull(value);
                        TextKt.a(lVar.b(value.f446190d), null, null, QUIToken.color$default("text_primary"), Float.valueOf(f16), null, companion.a(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i3 << 12) & 57344) | 1576960, 0, 0, 134215590);
                        StringBuilder sb5 = new StringBuilder();
                        br value2 = QQFlashTransferViewModel.this.fileSet.getValue();
                        Intrinsics.checkNotNull(value2);
                        sb5.append(lVar.c(value2.f446190d));
                        sb5.append(" \u5171");
                        TextKt.a(sb5.toString(), null, null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, companion.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i3 << 12) & 57344) | 1576960, 0, 0, 134215590);
                        br value3 = QQFlashTransferViewModel.this.fileSet.getValue();
                        if (value3 != null) {
                            obj2 = UInt.m564boximpl(value3.f446196j);
                        } else {
                            obj2 = 0;
                        }
                        TextKt.a(String.valueOf(obj2), null, null, QUIToken.color$default("text_primary"), Float.valueOf(f16), null, companion.a(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i3 << 12) & 57344) | 1576960, 0, 0, 134215590);
                        TextKt.a("\u9879 \u6587\u4ef6\u4e0a\u4f20\u4e2d", null, null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, companion.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i3 << 12) & 57344) | 1576966, 0, 0, 134215590);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(745807674);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(QQFlashTransferViewModel.this.uploadSucFileCount.getValue().longValue());
                        sb6.append('/');
                        br value4 = QQFlashTransferViewModel.this.fileSet.getValue();
                        if (value4 != null) {
                            obj = ULong.m642boximpl(value4.f446189c);
                        } else {
                            obj = 0;
                        }
                        sb6.append(obj);
                        String sb7 = sb6.toString();
                        h color$default2 = QUIToken.color$default("text_primary");
                        c.Companion companion2 = c.INSTANCE;
                        c a16 = companion2.a();
                        float f19 = f17;
                        i.Companion companion3 = i.INSTANCE;
                        TextKt.a(sb7, ComposeLayoutPropUpdaterKt.n(companion3, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, color$default2, Float.valueOf(f16), null, a16, null, null, null, null, Float.valueOf(f19), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i3 << 12) & 57344) | 1577024, 0, 0, 134215588);
                        TextKt.a("\u6587\u4ef6\u4e0a\u4f20\u4e2d", ComposeLayoutPropUpdaterKt.n(companion3, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, companion2.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i3 << 12) & 57344) | 1577030, 0, 0, 134215588);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196608, 31);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$uploadingStatusUI$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileSetStatusViewKt.access$uploadingStatusUI(f16, qQFlashTransferViewModel, f17, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTFileSetStatusView(final float f16, final float f17, final QQFlashTransferViewModel qQFlashTransferViewModel, float f18, boolean z16, Composer composer, final int i3, final int i16) {
        float f19;
        final int i17;
        x xVar;
        Composer startRestartGroup = composer.startRestartGroup(-1788184433);
        if ((i16 & 8) != 0) {
            f19 = com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().m() - 32.0f;
            i17 = i3 & (-7169);
        } else {
            f19 = f18;
            i17 = i3;
        }
        boolean z17 = (i16 & 16) != 0 ? false : z16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1788184433, i17, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusView (QQFTFileSetStatusView.kt:66)");
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("completedFileCount=");
        br value = qQFlashTransferViewModel.fileSet.getValue();
        m3.append((value == null || (xVar = value.f446198l) == null) ? null : UInt.m564boximpl(xVar.f446402b));
        m3.append(" totalFileCount=");
        br value2 = qQFlashTransferViewModel.fileSet.getValue();
        m3.append(value2 != null ? ULong.m642boximpl(value2.f446189c) : null);
        m3.append(" status=");
        br value3 = qQFlashTransferViewModel.fileSet.getValue();
        m3.append(value3 != null ? Integer.valueOf(value3.f446201o) : null);
        m3.append(" parentId=");
        m3.append(qQFlashTransferViewModel.parentId.getValue());
        m3.append(" expireLeftTime=");
        br value4 = qQFlashTransferViewModel.fileSet.getValue();
        m3.append(value4 != null ? UInt.m564boximpl(value4.f446193g) : null);
        m3.append(" needShowUploadFinishAnim=");
        m3.append(qQFlashTransferViewModel.needShowUploadFinishAnim.getValue().booleanValue());
        kLog.d("QQFTFileSetStatusView", m3.toString());
        final float f26 = f19;
        final boolean z18 = z17;
        RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1436676943, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$QQFTFileSetStatusView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Code restructure failed: missing block: B:47:0x00db, code lost:
            
                if ((r8 != null && r8.f446201o == 7) != false) goto L49;
             */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1436676943, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusView.<anonymous> (QQFTFileSetStatusView.kt:69)");
                    }
                    br value5 = QQFlashTransferViewModel.this.fileSet.getValue();
                    if (value5 != null && value5.f446201o == 6) {
                        composer3.startReplaceableGroup(2090981824);
                        composer3.endReplaceableGroup();
                    } else {
                        if (QQFlashTransferViewModel.this.parentId.getValue().length() > 0) {
                            composer3.startReplaceableGroup(2090981936);
                            float f27 = f16;
                            QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                            float f28 = f17;
                            float f29 = f26;
                            boolean z19 = z18;
                            int i18 = i17;
                            QQFTFileSetStatusViewKt.access$normalStatusUI(f27, qQFlashTransferViewModel2, f28, f29, z19, composer3, (i18 & 14) | 64 | ((i18 << 3) & 896) | (i18 & 7168) | (i18 & 57344));
                            composer3.endReplaceableGroup();
                        } else {
                            if (QQFlashTransferViewModel.this.fileSet.getValue() != null) {
                                br value6 = QQFlashTransferViewModel.this.fileSet.getValue();
                                if (!(value6 != null && value6.f446193g == 0)) {
                                    br value7 = QQFlashTransferViewModel.this.fileSet.getValue();
                                    if (!(value7 != null && value7.f446201o == 5)) {
                                        br value8 = QQFlashTransferViewModel.this.fileSet.getValue();
                                    }
                                }
                                composer3.startReplaceableGroup(2090982272);
                                float f36 = f16;
                                QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                float f37 = f17;
                                int i19 = i17;
                                QQFTFileSetStatusViewKt.access$expireStatusUI(f36, qQFlashTransferViewModel3, f37, composer3, ((i19 << 3) & 896) | (i19 & 14) | 64);
                                composer3.endReplaceableGroup();
                            }
                            if (!(QQFlashTransferViewModel.this.creatorUploadStatus.getValue().intValue() == 4)) {
                                if (!(QQFlashTransferViewModel.this.clusterId.length() > 0)) {
                                    if (QQFlashTransferViewModel.this.isInUploading() || QQFlashTransferViewModel.this.needShowUploadFinishAnim.getValue().booleanValue()) {
                                        if (QQFlashTransferViewModel.this.clusterId.length() == 0) {
                                            if (QQFlashTransferViewModel.this.compressedFileFolderId.length() == 0) {
                                                composer3.startReplaceableGroup(2090982674);
                                                float f38 = f16;
                                                QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                                float f39 = f17;
                                                int i26 = i17;
                                                QQFTFileSetStatusViewKt.access$uploadingStatusUI(f38, qQFlashTransferViewModel4, f39, composer3, ((i26 << 3) & 896) | (i26 & 14) | 64);
                                                if (QQFlashTransferViewModel.this.needShowUploadFinishAnim.getValue().booleanValue()) {
                                                    final QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                                                    TimerKt.c(1500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$QQFTFileSetStatusView$1.1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            QQFlashTransferViewModel.this.needShowUploadFinishAnim.setValue(Boolean.FALSE);
                                                            if (QQFlashTransferViewModel.this.isInUploading()) {
                                                                QQFlashTransferViewModel.this.creatorUploadStatus.setValue(4);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                                composer3.endReplaceableGroup();
                                            }
                                        }
                                    }
                                    composer3.startReplaceableGroup(2090983141);
                                    float f46 = f16;
                                    QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                    float f47 = f17;
                                    float f48 = f26;
                                    boolean z26 = z18;
                                    int i27 = i17;
                                    QQFTFileSetStatusViewKt.access$normalStatusUI(f46, qQFlashTransferViewModel6, f47, f48, z26, composer3, (i27 & 14) | 64 | ((i27 << 3) & 896) | (i27 & 7168) | (i27 & 57344));
                                    composer3.endReplaceableGroup();
                                }
                            }
                            composer3.startReplaceableGroup(2090982422);
                            float f49 = f16;
                            QQFlashTransferViewModel qQFlashTransferViewModel7 = QQFlashTransferViewModel.this;
                            float f56 = f17;
                            float f57 = f26;
                            boolean z27 = z18;
                            int i28 = i17;
                            QQFTFileSetStatusViewKt.access$normalStatusUI(f49, qQFlashTransferViewModel7, f56, f57, z27, composer3, (i28 & 14) | 64 | ((i28 << 3) & 896) | (i28 & 7168) | (i28 & 57344));
                            composer3.endReplaceableGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196608, 31);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final float f27 = f19;
        final boolean z19 = z17;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$QQFTFileSetStatusView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileSetStatusViewKt.QQFTFileSetStatusView(f16, f17, qQFlashTransferViewModel, f27, z19, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$normalStatusUI(final float f16, final QQFlashTransferViewModel qQFlashTransferViewModel, final float f17, final float f18, final boolean z16, Composer composer, final int i3) {
        boolean z17;
        List<es> list;
        Composer startRestartGroup = composer.startRestartGroup(1124945865);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1124945865, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.normalStatusUI (QQFTFileSetStatusView.kt:150)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        float floatValue = (f18 - ((Number) mutableState.getValue()).floatValue()) - 2;
        br value = qQFlashTransferViewModel.fileSet.getValue();
        if (value != null && value.f446199m == 1) {
            startRestartGroup.startReplaceableGroup(398329429);
            z17 = true;
            TextKt.a("\u6211\u4e0a\u4f20\u7684", null, null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, ((i3 << 12) & 57344) | 1576966, 0, 0, 134215590);
            startRestartGroup.endReplaceableGroup();
        } else {
            z17 = true;
            br value2 = qQFlashTransferViewModel.fileSet.getValue();
            if ((value2 == null || (list = value2.f446192f) == null || !(list.isEmpty() ^ true)) ? false : true) {
                startRestartGroup.startReplaceableGroup(398329714);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u6765\u81ea ");
                br value3 = qQFlashTransferViewModel.fileSet.getValue();
                Intrinsics.checkNotNull(value3);
                sb5.append(value3.f446192f.get(0).f446362b);
                TextKt.a(sb5.toString(), ComposeLayoutPropUpdaterKt.x(i.INSTANCE, 0.0f, floatValue), null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, startRestartGroup, ((i3 << 12) & 57344) | 1577024, 100663296, 0, 133953444);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(398330078);
                startRestartGroup.endReplaceableGroup();
            }
        }
        i.Companion companion2 = i.INSTANCE;
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(mutableState);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$normalStatusUI$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(w wVar) {
                    mutableState.setValue(Float.valueOf(wVar.getWidth()));
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        RowKt.a(ViewEventPropUpdaterKt.m(companion2, (Function1) rememberedValue2), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 72695271, z17, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$normalStatusUI$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:42:0x02fd  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x03e7  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x04df  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x044f  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x03b0  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                i.Companion companion3;
                boolean z18;
                Composer composer3;
                i.Companion companion4;
                Composer composer4;
                br value4;
                i iVar;
                h j3;
                int compare;
                Composer composer5;
                Object obj;
                Composer composer6 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer6.getSkipping()) {
                    composer6.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(72695271, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.normalStatusUI.<anonymous> (QQFTFileSetStatusView.kt:176)");
                    }
                    composer6.startReplaceableGroup(637937174);
                    if ((QQFlashTransferViewModel.this.compressedFileFolderId.length() > 0) && QQFlashTransferViewModel.this.dirFileSize.getValue().longValue() == 0 && QQFlashTransferViewModel.this.dirFileCount.getValue().intValue() == 0) {
                        TextKt.a(" ", null, null, QUIToken.color$default("text_primary"), Float.valueOf(f16), null, c.INSTANCE.a(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer6, ((i3 << 12) & 57344) | 1576966, 0, 0, 134215590);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer6.endReplaceableGroup();
                    } else {
                        composer6.endReplaceableGroup();
                        i.Companion companion5 = i.INSTANCE;
                        QQFTCircleDotViewKt.QQFTCircleDotView(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion5, f17), 2.0f), 2.0f, composer6, 56);
                        if (!QQFlashTransferViewModel.this.isSecondaryPage() && QQFlashTransferViewModel.this.fileSet.getValue() != null) {
                            br value5 = QQFlashTransferViewModel.this.fileSet.getValue();
                            Intrinsics.checkNotNull(value5);
                            compare = Integer.compare(value5.f446196j ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                            if (compare > 0) {
                                composer6.startReplaceableGroup(637937785);
                                i access$updateTitleBubblePosition = QQFTFileSetStatusViewKt.access$updateTitleBubblePosition(ComposeLayoutPropUpdaterKt.A(companion5), QQFlashTransferViewModel.this, z16);
                                final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                                final float f19 = f17;
                                final float f26 = f16;
                                final int i16 = i3;
                                RowKt.a(access$updateTitleBubblePosition, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, -1983307149, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$normalStatusUI$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar2, Composer composer7, Integer num2) {
                                        Object obj2;
                                        Composer composer8 = composer7;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 81) == 16 && composer8.getSkipping()) {
                                            composer8.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1983307149, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.normalStatusUI.<anonymous>.<anonymous> (QQFTFileSetStatusView.kt:194)");
                                            }
                                            br value6 = QQFlashTransferViewModel.this.fileSet.getValue();
                                            if (value6 != null) {
                                                obj2 = UInt.m564boximpl(value6.f446196j);
                                            } else {
                                                obj2 = 0;
                                            }
                                            String valueOf = String.valueOf(obj2);
                                            h color$default = QUIToken.color$default("text_primary");
                                            c.Companion companion6 = c.INSTANCE;
                                            TextKt.a(valueOf, null, null, color$default, Float.valueOf(f26), null, companion6.a(), null, null, null, null, Float.valueOf(f19), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i16 << 12) & 57344) | 1576960, 0, 0, 134215590);
                                            TextKt.a("\u9879", ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(f26), null, companion6.e(), null, null, null, null, Float.valueOf(f19), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i16 << 12) & 57344) | 1577030, 0, 0, 134215588);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer6, 196616, 30);
                                Intrinsics.checkNotNull(QQFlashTransferViewModel.this.fileSet.getValue());
                                long m648constructorimpl = ULong.m648constructorimpl(r1.f446196j & 4294967295L);
                                br value6 = QQFlashTransferViewModel.this.fileSet.getValue();
                                Intrinsics.checkNotNull(value6);
                                if (m648constructorimpl == value6.f446189c || z16) {
                                    companion3 = companion5;
                                    z18 = false;
                                    composer5 = composer6;
                                } else {
                                    h color$default = QUIToken.color$default("text_secondary");
                                    c.Companion companion6 = c.INSTANCE;
                                    composer5 = composer6;
                                    companion3 = companion5;
                                    z18 = false;
                                    TextKt.a(" (", ComposeLayoutPropUpdaterKt.n(companion5, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, color$default, Float.valueOf(f16), null, companion6.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i3 << 12) & 57344) | 1577030, 0, 0, 134215588);
                                    br value7 = QQFlashTransferViewModel.this.fileSet.getValue();
                                    if (value7 != null) {
                                        obj = ULong.m642boximpl(value7.f446189c);
                                    } else {
                                        obj = 0;
                                    }
                                    TextKt.a(String.valueOf(obj), null, null, QUIToken.color$default("text_primary"), Float.valueOf(f16), null, companion6.a(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i3 << 12) & 57344) | 1576960, 0, 0, 134215590);
                                    TextKt.a("\u4e2a\u6587\u4ef6)", ComposeLayoutPropUpdaterKt.n(companion3, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, companion6.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i3 << 12) & 57344) | 1577030, 0, 0, 134215588);
                                }
                                composer5.endReplaceableGroup();
                                composer3 = composer5;
                                i.Companion companion7 = companion3;
                                QQFTCircleDotViewKt.QQFTCircleDotView(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion7, f17), 2.0f), 2.0f, composer3, 56);
                                composer3.startReplaceableGroup(637940609);
                                if (QQFlashTransferViewModel.this.getCurPageFileTotalSize() == null) {
                                    l lVar = l.f413536a;
                                    Long curPageFileTotalSize = QQFlashTransferViewModel.this.getCurPageFileTotalSize();
                                    Intrinsics.checkNotNull(curPageFileTotalSize);
                                    String b16 = lVar.b(curPageFileTotalSize.longValue());
                                    h color$default2 = QUIToken.color$default("text_primary");
                                    c.Companion companion8 = c.INSTANCE;
                                    companion4 = companion7;
                                    composer4 = composer3;
                                    TextKt.a(b16, null, null, color$default2, Float.valueOf(f16), null, companion8.a(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer4, ((i3 << 12) & 57344) | 1576960, 0, 0, 134215590);
                                    StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m(TokenParser.SP);
                                    Long curPageFileTotalSize2 = QQFlashTransferViewModel.this.getCurPageFileTotalSize();
                                    Intrinsics.checkNotNull(curPageFileTotalSize2);
                                    m3.append(lVar.c(curPageFileTotalSize2.longValue()));
                                    TextKt.a(m3.toString(), null, null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, companion8.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer4, ((i3 << 12) & 57344) | 1576960, 0, 0, 134215590);
                                } else {
                                    companion4 = companion7;
                                    composer4 = composer3;
                                }
                                composer4.endReplaceableGroup();
                                i.Companion companion9 = companion4;
                                Composer composer7 = composer4;
                                QQFTCircleDotViewKt.QQFTCircleDotView(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion9, f17), 2.0f), 2.0f, composer7, 56);
                                value4 = QQFlashTransferViewModel.this.fileSet.getValue();
                                if (!((value4 == null && (value4.f446201o == 5 || value4.f446193g == 0)) ? true : z18)) {
                                    composer7.startReplaceableGroup(637941439);
                                    TextKt.a("\u5df2\u8fc7\u671f", ComposeLayoutPropUpdaterKt.n(companion9, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(f16), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(f17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i3 << 12) & 57344) | 1577030, 0, 0, 134215588);
                                    composer7.endReplaceableGroup();
                                } else {
                                    composer7.startReplaceableGroup(637941748);
                                    final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                    if (z16 || qQFlashTransferViewModel3.isCompressPage()) {
                                        iVar = companion9;
                                    } else {
                                        float f27 = 2;
                                        i s16 = ComposeLayoutPropUpdaterKt.s(companion9, f27, 0.0f, f27, 0.0f, 10, null);
                                        if (qQFlashTransferViewModel3.showExpireBubbleView.getValue().booleanValue()) {
                                            j3 = QUIToken.color$default("overlay_surface_bg");
                                        } else {
                                            j3 = h.INSTANCE.j();
                                        }
                                        iVar = ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.k(ModifiersKt.q(ModifiersKt.d(s16, j3), uo3.c.a(4)), new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$updateExpireBubblePosition$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ap3.a aVar) {
                                                ap3.a aVar2 = aVar;
                                                QQFlashTransferViewModel.this.expireBubblePosition.setValue(aVar2);
                                                KLog.INSTANCE.d("QQFTFileSetStatusView", "QQFTFileSetStatusView position:" + aVar2);
                                                return Unit.INSTANCE;
                                            }
                                        }), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$updateExpireBubblePosition$2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QQFlashTransferViewModel.this.showExpireBubbleView.setValue(Boolean.TRUE);
                                                KLog.INSTANCE.d("QQFTFileSetStatusView", "show expireBubble");
                                                return Unit.INSTANCE;
                                            }
                                        }, 3, null);
                                    }
                                    final QQFlashTransferViewModel qQFlashTransferViewModel4 = QQFlashTransferViewModel.this;
                                    final float f28 = f17;
                                    final float f29 = f16;
                                    final int i17 = i3;
                                    RowKt.a(iVar, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, -1228916728, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$normalStatusUI$2.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar2, Composer composer8, Integer num2) {
                                            String valueOf;
                                            String str;
                                            Composer composer9 = composer8;
                                            int intValue2 = num2.intValue();
                                            if ((intValue2 & 81) == 16 && composer9.getSkipping()) {
                                                composer9.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1228916728, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.normalStatusUI.<anonymous>.<anonymous> (QQFTFileSetStatusView.kt:298)");
                                                }
                                                br value8 = QQFlashTransferViewModel.this.fileSet.getValue();
                                                int i18 = value8 != null ? value8.f446193g : 0;
                                                if (i18 > 86400) {
                                                    valueOf = String.valueOf(((i18 / 3600) / 24) + 1);
                                                } else if (i18 >= 3600) {
                                                    valueOf = String.valueOf((i18 / 3600) + 1);
                                                } else {
                                                    valueOf = String.valueOf((i18 / 60) + 1);
                                                }
                                                h color$default3 = QUIToken.color$default("text_primary");
                                                c.Companion companion10 = c.INSTANCE;
                                                TextKt.a(valueOf, null, null, color$default3, Float.valueOf(f29), null, companion10.a(), null, null, null, null, Float.valueOf(f28), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, ((i17 << 12) & 57344) | 1576960, 0, 0, 134215590);
                                                StringBuilder sb6 = new StringBuilder();
                                                br value9 = QQFlashTransferViewModel.this.fileSet.getValue();
                                                int i19 = value9 != null ? value9.f446193g : 0;
                                                if (i19 > 86400) {
                                                    str = "\u5929";
                                                } else if (i19 >= 3600) {
                                                    str = "\u5c0f\u65f6";
                                                } else {
                                                    str = "\u5206\u949f";
                                                }
                                                TextKt.a(OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb6, str, "\u540e\u8fc7\u671f"), ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(f29), null, companion10.e(), null, null, null, null, Float.valueOf(f28), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, ((i17 << 12) & 57344) | 1577024, 0, 0, 134215588);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer7, 196616, 30);
                                    composer7.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }
                        companion3 = companion5;
                        z18 = false;
                        composer3 = composer6;
                        composer3.startReplaceableGroup(637939706);
                        i access$updateTitleBubblePosition2 = QQFTFileSetStatusViewKt.access$updateTitleBubblePosition(ComposeLayoutPropUpdaterKt.A(companion3), QQFlashTransferViewModel.this, z16);
                        final QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                        final float f36 = f17;
                        final float f37 = f16;
                        final int i18 = i3;
                        RowKt.a(access$updateTitleBubblePosition2, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -259026230, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$normalStatusUI$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar2, Composer composer8, Integer num2) {
                                Composer composer9 = composer8;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer9.getSkipping()) {
                                    composer9.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-259026230, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.normalStatusUI.<anonymous>.<anonymous> (QQFTFileSetStatusView.kt:243)");
                                    }
                                    String m693toStringimpl = ULong.m693toStringimpl(QQFlashTransferViewModel.this.m115getCurPageFileTotalCountsVKNKU());
                                    h color$default3 = QUIToken.color$default("text_primary");
                                    c.Companion companion10 = c.INSTANCE;
                                    TextKt.a(m693toStringimpl, null, null, color$default3, Float.valueOf(f37), null, companion10.a(), null, null, null, null, Float.valueOf(f36), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, ((i18 << 12) & 57344) | 1576960, 0, 0, 134215590);
                                    TextKt.a("\u9879\u6587\u4ef6", ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(f37), null, companion10.e(), null, null, null, null, Float.valueOf(f36), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, ((i18 << 12) & 57344) | 1577030, 0, 0, 134215588);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 30);
                        composer3.endReplaceableGroup();
                        i.Companion companion72 = companion3;
                        QQFTCircleDotViewKt.QQFTCircleDotView(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion72, f17), 2.0f), 2.0f, composer3, 56);
                        composer3.startReplaceableGroup(637940609);
                        if (QQFlashTransferViewModel.this.getCurPageFileTotalSize() == null) {
                        }
                        composer4.endReplaceableGroup();
                        i.Companion companion92 = companion4;
                        Composer composer72 = composer4;
                        QQFTCircleDotViewKt.QQFTCircleDotView(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion92, f17), 2.0f), 2.0f, composer72, 56);
                        value4 = QQFlashTransferViewModel.this.fileSet.getValue();
                        if (!((value4 == null && (value4.f446201o == 5 || value4.f446193g == 0)) ? true : z18)) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 30);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt$normalStatusUI$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFileSetStatusViewKt.access$normalStatusUI(f16, qQFlashTransferViewModel, f17, f18, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
