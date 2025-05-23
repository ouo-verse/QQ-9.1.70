package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.TextKt;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import g25.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HotViewKt {
    public static final void HotView(final k kVar, final int i3, Composer composer, final int i16, final int i17) {
        Composer startRestartGroup = composer.startRestartGroup(2076189053);
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2076189053, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotView (HotView.kt:34)");
        }
        SurfaceKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), 21.0f), new b(8.0f, 0.0f, 0.0f, 0.0f), null, QUIToken.color$default("fill_allblack_medium"), ComposableLambdaKt.composableLambda(startRestartGroup, 1997521471, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$HotView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.traceEventStart(1997521471, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotView.<anonymous> (HotView.kt:41)");
                    }
                    i k3 = ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 21.0f);
                    Alignment.Vertical c16 = Alignment.INSTANCE.c();
                    final int i18 = i3;
                    final k kVar2 = kVar;
                    RowKt.a(k3, null, c16, null, null, ComposableLambdaKt.composableLambda(composer3, -668821407, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$HotView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            String str;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-668821407, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotView.<anonymous>.<anonymous> (HotView.kt:46)");
                                }
                                if (i18 == 3) {
                                    str = QCircleAlphaUserReporter.KEY_USER;
                                } else {
                                    str = QCircleDaTongConstant.ElementParamValue.OPERATION;
                                }
                                i.Companion companion = i.INSTANCE;
                                ImageKt.a(QUIToken.INSTANCE.image(str, QUIToken.color$default("icon_allwhite_primary")), null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, 14.0f), 14.0f), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                                TextKt.a(HotViewKt.getHotString(kVar2, i18, false), ComposeLayoutPropUpdaterKt.n(companion, 2.0f, 0.0f, 4.0f, 0.0f, 10, null), null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(12.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28736, 48, 0, 134215652);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 26);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 28680, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$HotView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HotViewKt.HotView(k.this, i3, composer2, i16 | 1, i17);
                return Unit.INSTANCE;
            }
        });
    }

    public static final String getHotString(k kVar, int i3, boolean z16) {
        String formatString;
        if (i3 == 3) {
            formatString = formatString((int) kVar.X) + "\u4e2a\u597d\u53cb\u5728\u73a9";
        } else {
            formatString = formatString((int) kVar.U);
        }
        if (!z16) {
            return formatString;
        }
        StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m(formatString, "   ");
        m3.append(kVar.W);
        return m3.toString();
    }

    public static final String formatString(int i3) {
        if (i3 < 10000) {
            return String.valueOf(i3);
        }
        double rint = Math.rint((i3 / 10000.0d) * 10) / 10.0d;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(rint);
        sb5.append('\u4e07');
        return sb5.toString();
    }

    public static final void LightHotView(final i iVar, final k kVar, int i3, boolean z16, Composer composer, final int i16, final int i17) {
        Composer startRestartGroup = composer.startRestartGroup(-174063148);
        final int i18 = (i17 & 4) != 0 ? 0 : i3;
        final boolean z17 = (i17 & 8) != 0 ? false : z16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-174063148, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LightHotView (HotView.kt:68)");
        }
        RowKt.a(iVar, null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 23702258, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$LightHotView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                String str;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(23702258, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LightHotView.<anonymous> (HotView.kt:72)");
                    }
                    if (i18 == 3) {
                        str = QCircleAlphaUserReporter.KEY_USER;
                    } else {
                        str = QCircleDaTongConstant.ElementParamValue.OPERATION;
                    }
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a(QUIToken.INSTANCE.image(str, QUIToken.color$default("icon_tertiary")), null, null, null, null, ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(companion, 14.0f), 14.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    TextKt.a(HotViewKt.getHotString(kVar, i18, z17), ComposeLayoutPropUpdaterKt.n(companion, 2.0f, 0.0f, 4.0f, 0.0f, 10, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 28736, 48, 0, 134215652);
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
        final int i19 = i18;
        final boolean z18 = z17;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$LightHotView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HotViewKt.LightHotView(i.this, kVar, i19, z18, composer2, i16 | 1, i17);
                return Unit.INSTANCE;
            }
        });
    }
}
