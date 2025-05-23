package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import ap3.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.pager.h;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.ModifiersKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.HoverKt;
import com.tencent.ntcompose.material.PagerListKt;
import com.tencent.ntcompose.material.base.d;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import so3.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIDragBackViewKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUIDragBackView(final Function0<Unit> function0, boolean z16, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3, final int i16) {
        int i17;
        boolean z17;
        final int i18;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        boolean z18;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1062623237);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i19 = i16 & 2;
        if (i19 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            z17 = z16;
            i17 |= startRestartGroup.changed(z17) ? 32 : 16;
            if ((i16 & 4) == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i17 |= startRestartGroup.changed(function2) ? 256 : 128;
            }
            i18 = i17;
            if ((i18 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) != 146 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                z18 = z17;
            } else {
                final boolean z19 = i19 == 0 ? true : z17;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1062623237, i18, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView (QUIDragBackView.kt:55)");
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new b(null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                final b bVar = (b) rememberedValue;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new b(null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                final b bVar2 = (b) rememberedValue2;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new b(null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                final b bVar3 = (b) rememberedValue3;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new b(Boolean.FALSE);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceableGroup();
                final b bVar4 = (b) rememberedValue4;
                EffectsKt.LaunchedEffect(Unit.INSTANCE, new QUIDragBackViewKt$QUIDragBackView$1(null), startRestartGroup, 64);
                final boolean z26 = z19;
                z18 = z19;
                PagerListKt.a(d.a(ViewEventPropUpdaterKt.k(ModifiersKt.e(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), "pageFlipThreshold", new Function1<ComposeRenderView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$listPageFlipThreshold$1
                    public final /* synthetic */ float $flipThreshold = 0.19f;

                    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ComposeRenderView composeRenderView) {
                        composeRenderView.b().getViewAttr().with("pageFlipThreshold", Float.valueOf(this.$flipThreshold));
                        return Unit.INSTANCE;
                    }
                }), new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(a aVar) {
                        bVar3.b(c.a(aVar));
                        return Unit.INSTANCE;
                    }
                }), ComposableLambdaKt.composableLambda(startRestartGroup, 149765836, true, new Function3<com.tencent.ntcompose.material.base.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.material.base.b bVar5, Composer composer2, Integer num) {
                        com.tencent.ntcompose.material.base.b bVar6 = bVar5;
                        int intValue = num.intValue();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(149765836, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous> (QUIDragBackView.kt:78)");
                        }
                        bVar2.b(bVar6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 56), null, null, Float.valueOf(((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e()), 1, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, 0.0f, null, new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollParams scrollParams) {
                        float m3;
                        ScrollParams scrollParams2 = scrollParams;
                        com.tencent.kuikly.core.layout.d a16 = bVar3.a();
                        if (a16 != null) {
                            m3 = a16.getWidth();
                        } else {
                            m3 = h.a().getPageData().m();
                        }
                        float min = 1.0f - Math.min(Math.max(scrollParams2.getOffsetX() / m3, 0.0f), 1.0f);
                        if (z26) {
                            float f16 = min > 0.01f ? 5.0f : 0.0f;
                            com.tencent.kuikly.core.base.h a17 = com.tencent.kuikly.core.base.h.INSTANCE.a(min > 0.01f ? (1 - min) * 0.4f : 0.0f);
                            com.tencent.ntcompose.material.base.b a18 = bVar.a();
                            if (a18 != null) {
                                a18.a(com.tencent.ntcompose.material.base.ModifiersKt.l(com.tencent.ntcompose.material.base.ModifiersKt.Q(i.INSTANCE, new y(0.0f, min, 0.0f, 0.0f, 12, null), null, 2, null), new f(f16, f16, 0.0f, 0.0f)));
                            }
                            com.tencent.ntcompose.material.base.b a19 = bVar2.a();
                            if (a19 != null) {
                                a19.a(com.tencent.ntcompose.material.base.ModifiersKt.c(i.INSTANCE, a17));
                            }
                        } else {
                            com.tencent.kuikly.core.base.h a26 = com.tencent.kuikly.core.base.h.INSTANCE.a(min > 0.01f ? (1 - min) * 0.4f : 0.0f);
                            com.tencent.ntcompose.material.base.b a27 = bVar2.a();
                            if (a27 != null) {
                                a27.a(com.tencent.ntcompose.material.base.ModifiersKt.c(i.INSTANCE, a26));
                            }
                        }
                        if (scrollParams2.getOffsetX() < 5.0f && !bVar4.a().booleanValue()) {
                            bVar4.b(Boolean.TRUE);
                            KLog.INSTANCE.i("QUIDragBackView", "did onDismiss");
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                }, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1785682168, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                        com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1785682168, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous> (QUIDragBackView.kt:104)");
                        }
                        i.Companion companion2 = i.INSTANCE;
                        BoxKt.a(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), null, null, ComposableSingletons$QUIDragBackViewKt.f31lambda1, composer3, 3080, 6);
                        i h16 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                        Float valueOf = z19 ? Float.valueOf(0.0f) : null;
                        final b<com.tencent.ntcompose.material.base.b> bVar5 = bVar;
                        final Function2<Composer, Integer, Unit> function22 = function2;
                        final int i26 = i18;
                        HoverKt.a(aVar2, h16, null, null, 0.0f, valueOf, ComposableLambdaKt.composableLambda(composer3, -1358505076, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1358505076, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous>.<anonymous> (QUIDragBackView.kt:110)");
                                    }
                                    i S = com.tencent.ntcompose.material.base.ModifiersKt.S(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f);
                                    final b<com.tencent.ntcompose.material.base.b> bVar6 = bVar5;
                                    i a16 = d.a(S, ComposableLambdaKt.composableLambda(composer5, 529116152, true, new Function3<com.tencent.ntcompose.material.base.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt.QUIDragBackView.5.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.material.base.b bVar7, Composer composer6, Integer num3) {
                                            com.tencent.ntcompose.material.base.b bVar8 = bVar7;
                                            int intValue3 = num3.intValue();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(529116152, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous>.<anonymous>.<anonymous> (QUIDragBackView.kt:113)");
                                            }
                                            bVar6.b(bVar8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 56);
                                    final Function2<Composer, Integer, Unit> function23 = function22;
                                    final int i27 = i26;
                                    BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer5, -72418670, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt.QUIDragBackView.5.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar7, Composer composer6, Integer num3) {
                                            int i28;
                                            com.tencent.ntcompose.foundation.layout.b bVar8 = bVar7;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                i28 = (composer7.changed(bVar8) ? 4 : 2) | intValue3;
                                            } else {
                                                i28 = intValue3;
                                            }
                                            if ((i28 & 91) == 18 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-72418670, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous>.<anonymous>.<anonymous> (QUIDragBackView.kt:115)");
                                                }
                                                function23.invoke(composer7, Integer.valueOf((i27 >> 6) & 14));
                                                BoxKt.a(ViewEventPropUpdaterKt.d(com.tencent.ntcompose.material.base.ModifiersKt.c(bVar8.a(ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 18.0f), 0.0f, 1, null), 0.0f, 120.0f, 1, null), Alignment.TopStart), com.tencent.kuikly.core.base.h.INSTANCE.j()), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt.QUIDragBackView.5.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 3, null), null, null, null, composer7, 8, 14);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 1572936, 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 12607496, 0, 3072, 8257382);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final boolean z27 = z18;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    QUIDragBackViewKt.QUIDragBackView(function0, z27, function2, composer2, i3 | 1, i16);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        z17 = z16;
        if ((i16 & 4) == 0) {
        }
        i18 = i17;
        if ((i18 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) != 146) {
        }
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final b<com.tencent.ntcompose.material.base.b> bVar5 = (b) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final b<com.tencent.ntcompose.material.base.b> bVar22 = (b) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final b<com.tencent.kuikly.core.layout.d> bVar32 = (b) rememberedValue3;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final b<Boolean> bVar42 = (b) rememberedValue4;
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new QUIDragBackViewKt$QUIDragBackView$1(null), startRestartGroup, 64);
        final boolean z262 = z19;
        z18 = z19;
        PagerListKt.a(d.a(ViewEventPropUpdaterKt.k(ModifiersKt.e(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), "pageFlipThreshold", new Function1<ComposeRenderView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$listPageFlipThreshold$1
            public final /* synthetic */ float $flipThreshold = 0.19f;

            /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ComposeRenderView composeRenderView) {
                composeRenderView.b().getViewAttr().with("pageFlipThreshold", Float.valueOf(this.$flipThreshold));
                return Unit.INSTANCE;
            }
        }), new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(a aVar) {
                bVar32.b(c.a(aVar));
                return Unit.INSTANCE;
            }
        }), ComposableLambdaKt.composableLambda(startRestartGroup, 149765836, true, new Function3<com.tencent.ntcompose.material.base.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.material.base.b bVar52, Composer composer2, Integer num) {
                com.tencent.ntcompose.material.base.b bVar6 = bVar52;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(149765836, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous> (QUIDragBackView.kt:78)");
                }
                bVar22.b(bVar6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 56), null, null, Float.valueOf(((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e()), 1, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, 0.0f, null, new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ScrollParams scrollParams) {
                float m3;
                ScrollParams scrollParams2 = scrollParams;
                com.tencent.kuikly.core.layout.d a16 = bVar32.a();
                if (a16 != null) {
                    m3 = a16.getWidth();
                } else {
                    m3 = h.a().getPageData().m();
                }
                float min = 1.0f - Math.min(Math.max(scrollParams2.getOffsetX() / m3, 0.0f), 1.0f);
                if (z262) {
                    float f16 = min > 0.01f ? 5.0f : 0.0f;
                    com.tencent.kuikly.core.base.h a17 = com.tencent.kuikly.core.base.h.INSTANCE.a(min > 0.01f ? (1 - min) * 0.4f : 0.0f);
                    com.tencent.ntcompose.material.base.b a18 = bVar5.a();
                    if (a18 != null) {
                        a18.a(com.tencent.ntcompose.material.base.ModifiersKt.l(com.tencent.ntcompose.material.base.ModifiersKt.Q(i.INSTANCE, new y(0.0f, min, 0.0f, 0.0f, 12, null), null, 2, null), new f(f16, f16, 0.0f, 0.0f)));
                    }
                    com.tencent.ntcompose.material.base.b a19 = bVar22.a();
                    if (a19 != null) {
                        a19.a(com.tencent.ntcompose.material.base.ModifiersKt.c(i.INSTANCE, a17));
                    }
                } else {
                    com.tencent.kuikly.core.base.h a26 = com.tencent.kuikly.core.base.h.INSTANCE.a(min > 0.01f ? (1 - min) * 0.4f : 0.0f);
                    com.tencent.ntcompose.material.base.b a27 = bVar22.a();
                    if (a27 != null) {
                        a27.a(com.tencent.ntcompose.material.base.ModifiersKt.c(i.INSTANCE, a26));
                    }
                }
                if (scrollParams2.getOffsetX() < 5.0f && !bVar42.a().booleanValue()) {
                    bVar42.b(Boolean.TRUE);
                    KLog.INSTANCE.i("QUIDragBackView", "did onDismiss");
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
        }, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1785682168, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1785682168, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous> (QUIDragBackView.kt:104)");
                }
                i.Companion companion2 = i.INSTANCE;
                BoxKt.a(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), null, null, ComposableSingletons$QUIDragBackViewKt.f31lambda1, composer3, 3080, 6);
                i h16 = ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null);
                Float valueOf = z19 ? Float.valueOf(0.0f) : null;
                final b<com.tencent.ntcompose.material.base.b> bVar52 = bVar5;
                final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                final int i26 = i18;
                HoverKt.a(aVar2, h16, null, null, 0.0f, valueOf, ComposableLambdaKt.composableLambda(composer3, -1358505076, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$5.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer4, Integer num2) {
                        Composer composer5 = composer4;
                        int intValue2 = num2.intValue();
                        if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1358505076, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous>.<anonymous> (QUIDragBackView.kt:110)");
                            }
                            i S = com.tencent.ntcompose.material.base.ModifiersKt.S(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f);
                            final b<com.tencent.ntcompose.material.base.b> bVar6 = bVar52;
                            i a16 = d.a(S, ComposableLambdaKt.composableLambda(composer5, 529116152, true, new Function3<com.tencent.ntcompose.material.base.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt.QUIDragBackView.5.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(com.tencent.ntcompose.material.base.b bVar7, Composer composer6, Integer num3) {
                                    com.tencent.ntcompose.material.base.b bVar8 = bVar7;
                                    int intValue3 = num3.intValue();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(529116152, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous>.<anonymous>.<anonymous> (QUIDragBackView.kt:113)");
                                    }
                                    bVar6.b(bVar8);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer5, 56);
                            final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                            final int i27 = i26;
                            BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer5, -72418670, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt.QUIDragBackView.5.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar7, Composer composer6, Integer num3) {
                                    int i28;
                                    com.tencent.ntcompose.foundation.layout.b bVar8 = bVar7;
                                    Composer composer7 = composer6;
                                    int intValue3 = num3.intValue();
                                    if ((intValue3 & 14) == 0) {
                                        i28 = (composer7.changed(bVar8) ? 4 : 2) | intValue3;
                                    } else {
                                        i28 = intValue3;
                                    }
                                    if ((i28 & 91) == 18 && composer7.getSkipping()) {
                                        composer7.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-72418670, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackView.<anonymous>.<anonymous>.<anonymous> (QUIDragBackView.kt:115)");
                                        }
                                        function23.invoke(composer7, Integer.valueOf((i27 >> 6) & 14));
                                        BoxKt.a(ViewEventPropUpdaterKt.d(com.tencent.ntcompose.material.base.ModifiersKt.c(bVar8.a(ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 18.0f), 0.0f, 1, null), 0.0f, 120.0f, 1, null), Alignment.TopStart), com.tencent.kuikly.core.base.h.INSTANCE.j()), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt.QUIDragBackView.5.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                return Unit.INSTANCE;
                                            }
                                        }, 3, null), null, null, null, composer7, 8, 14);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer5, 3080, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 1572936, 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 12607496, 0, 3072, 8257382);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
