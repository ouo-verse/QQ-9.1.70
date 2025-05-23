package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsReport;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import yo3.Offset;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TtsListCellKt {
    public static final void TtsListCell(final AdelieTtsInfo adelieTtsInfo, final Function1<? super AdelieTtsInfo, Unit> function1, Function1<? super AdelieTtsInfo, Unit> function12, Function2<? super AdelieTtsInfo, ? super Offset, Unit> function2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(2010918496);
        final Function1<? super AdelieTtsInfo, Unit> function13 = (i16 & 4) != 0 ? null : function12;
        final Function2<? super AdelieTtsInfo, ? super Offset, Unit> function22 = (i16 & 8) != 0 ? null : function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2010918496, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCell (TtsListCell.kt:22)");
        }
        RowKt.a(ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), adelieTtsInfo.type == 1 ? 45.0f : 48.0f), h.INSTANCE.j()), new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellKt$TtsListCell$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(a aVar) {
                AdelieTtsInfo adelieTtsInfo2 = AdelieTtsInfo.this;
                e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
                e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
                m16.v("current_timbre", AdelieTtsReport.currentTimbreId);
                m3.v("cur_pg", m16);
                m3.v("dt_eid", "em_bas_timbre_articles");
                m3.v("timbre_id", adelieTtsInfo2.ttsId);
                m3.t("timbre_type", BoxType$EnumUnboxingSharedUtility.ordinal(adelieTtsInfo2.type));
                ReportKt.reportCustomDTEvent("dt_imp", m3);
                return Unit.INSTANCE;
            }
        }), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellKt$TtsListCell$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                function1.invoke(adelieTtsInfo);
                return Unit.INSTANCE;
            }
        }, 3, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -117569282, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellKt$TtsListCell$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-117569282, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCell.<anonymous> (TtsListCell.kt:40)");
                    }
                    TtsListCellLeftKt.TtsListCellLeft(AdelieTtsInfo.this, composer3, 8);
                    if (AdelieTtsInfo.this.type == 3) {
                        composer3.startReplaceableGroup(-289777121);
                        AdelieTtsInfo adelieTtsInfo2 = AdelieTtsInfo.this;
                        Function1<AdelieTtsInfo, Unit> function14 = function13;
                        Function2<AdelieTtsInfo, Offset, Unit> function23 = function22;
                        int i17 = i3 >> 3;
                        TtsListCellMyOPKt.TtsListCellMyOP(adelieTtsInfo2, function14, function23, composer3, 8 | (i17 & 112) | (i17 & 896), 0);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(-289777050);
                        TtsListCellSelectKt.TtsListCellSelect(AdelieTtsInfo.this, composer3, 8);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196680, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function2<? super AdelieTtsInfo, ? super Offset, Unit> function23 = function22;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellKt$TtsListCell$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsListCellKt.TtsListCell(AdelieTtsInfo.this, function1, function13, function23, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
