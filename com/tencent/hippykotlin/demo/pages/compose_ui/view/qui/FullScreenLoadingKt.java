package com.tencent.hippykotlin.demo.pages.compose_ui.view.qui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FullScreenLoadingKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullScreenLoading(final LoadingType loadingType, String str, LoadingIconType loadingIconType, Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        int i17;
        String str2;
        int i18;
        LoadingIconType loadingIconType2;
        int i19;
        Function0<Unit> function02;
        String str3;
        final LoadingIconType loadingIconType3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-234965467);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(loadingType) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i26 = i16 & 2;
        if (i26 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            str2 = str;
            i17 |= startRestartGroup.changed(str2) ? 32 : 16;
            i18 = i16 & 4;
            if (i18 == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                loadingIconType2 = loadingIconType;
                i17 |= startRestartGroup.changed(loadingIconType2) ? 256 : 128;
                i19 = i16 & 8;
                if (i19 != 0) {
                    i17 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    function02 = function0;
                    i17 |= startRestartGroup.changed(function02) ? 2048 : 1024;
                    if ((i17 & 5851) != 1170 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        str3 = str2;
                        loadingIconType3 = loadingIconType2;
                    } else {
                        str3 = i26 == 0 ? null : str2;
                        LoadingIconType loadingIconType4 = i18 == 0 ? LoadingIconType.WHITE : loadingIconType2;
                        Function0<Unit> function03 = i19 == 0 ? null : function02;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-234965467, i17, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading (FullScreenLoading.kt:31)");
                        }
                        final Function0<Unit> function04 = function03;
                        final int i27 = i17;
                        final LoadingIconType loadingIconType5 = loadingIconType4;
                        final String str4 = str3;
                        ModalKt.a(ModifiersKt.d(i.INSTANCE, new h(0, 0, 0, 0.5f)), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 299935975, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1
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
                                        ComposerKt.traceEventStart(299935975, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading.<anonymous> (FullScreenLoading.kt:41)");
                                    }
                                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                    final Function0<Unit> function05 = function04;
                                    composer3.startReplaceableGroup(1157296644);
                                    boolean changed = composer3.changed(function05);
                                    Object rememberedValue = composer3.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function06 = function05;
                                                if (function06 != null) {
                                                    function06.invoke();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue);
                                    }
                                    composer3.endReplaceableGroup();
                                    i d16 = ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null);
                                    final LoadingType loadingType2 = loadingType;
                                    final LoadingIconType loadingIconType6 = loadingIconType5;
                                    final int i28 = i27;
                                    final String str5 = str4;
                                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, -1838395795, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                            b bVar2 = bVar;
                                            Composer composer5 = composer4;
                                            int intValue2 = num2.intValue();
                                            if ((intValue2 & 14) == 0) {
                                                intValue2 |= composer5.changed(bVar2) ? 4 : 2;
                                            }
                                            if ((intValue2 & 91) == 18 && composer5.getSkipping()) {
                                                composer5.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1838395795, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading.<anonymous>.<anonymous> (FullScreenLoading.kt:44)");
                                                }
                                                int ordinal = LoadingType.this.ordinal();
                                                if (ordinal == 0) {
                                                    composer5.startReplaceableGroup(-2115778377);
                                                    FullScreenLoadingKt.FullScreenLoading(bVar2, loadingIconType6, composer5, (intValue2 & 14) | ((i28 >> 3) & 112), 0);
                                                    composer5.endReplaceableGroup();
                                                } else if (ordinal != 1) {
                                                    composer5.startReplaceableGroup(-2115778167);
                                                    composer5.endReplaceableGroup();
                                                } else {
                                                    composer5.startReplaceableGroup(-2115778251);
                                                    FullScreenLoadingKt.LoadingWithBottom(bVar2, str5, composer5, (intValue2 & 14) | (i28 & 112), 0);
                                                    composer5.endReplaceableGroup();
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer3, 3080, 6);
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
                        loadingIconType3 = loadingIconType4;
                        function02 = function03;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final String str5 = str3;
                    final Function0<Unit> function05 = function02;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer2, Integer num) {
                            num.intValue();
                            FullScreenLoadingKt.FullScreenLoading(LoadingType.this, str5, loadingIconType3, function05, composer2, i3 | 1, i16);
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                function02 = function0;
                if ((i17 & 5851) != 1170) {
                }
                if (i26 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function0<Unit> function042 = function03;
                final int i272 = i17;
                final LoadingIconType loadingIconType52 = loadingIconType4;
                final String str42 = str3;
                ModalKt.a(ModifiersKt.d(i.INSTANCE, new h(0, 0, 0, 0.5f)), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 299935975, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1
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
                                ComposerKt.traceEventStart(299935975, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading.<anonymous> (FullScreenLoading.kt:41)");
                            }
                            i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                            final Function0<Unit> function052 = function042;
                            composer3.startReplaceableGroup(1157296644);
                            boolean changed = composer3.changed(function052);
                            Object rememberedValue = composer3.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Function0<Unit> function06 = function052;
                                        if (function06 != null) {
                                            function06.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue);
                            }
                            composer3.endReplaceableGroup();
                            i d16 = ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null);
                            final LoadingType loadingType2 = loadingType;
                            final LoadingIconType loadingIconType6 = loadingIconType52;
                            final int i28 = i272;
                            final String str52 = str42;
                            BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, -1838395795, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                    b bVar2 = bVar;
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        intValue2 |= composer5.changed(bVar2) ? 4 : 2;
                                    }
                                    if ((intValue2 & 91) == 18 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1838395795, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading.<anonymous>.<anonymous> (FullScreenLoading.kt:44)");
                                        }
                                        int ordinal = LoadingType.this.ordinal();
                                        if (ordinal == 0) {
                                            composer5.startReplaceableGroup(-2115778377);
                                            FullScreenLoadingKt.FullScreenLoading(bVar2, loadingIconType6, composer5, (intValue2 & 14) | ((i28 >> 3) & 112), 0);
                                            composer5.endReplaceableGroup();
                                        } else if (ordinal != 1) {
                                            composer5.startReplaceableGroup(-2115778167);
                                            composer5.endReplaceableGroup();
                                        } else {
                                            composer5.startReplaceableGroup(-2115778251);
                                            FullScreenLoadingKt.LoadingWithBottom(bVar2, str52, composer5, (intValue2 & 14) | (i28 & 112), 0);
                                            composer5.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 3080, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 24584, 14);
                if (ComposerKt.isTraceInProgress()) {
                }
                loadingIconType3 = loadingIconType4;
                function02 = function03;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            loadingIconType2 = loadingIconType;
            i19 = i16 & 8;
            if (i19 != 0) {
            }
            function02 = function0;
            if ((i17 & 5851) != 1170) {
            }
            if (i26 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function0<Unit> function0422 = function03;
            final int i2722 = i17;
            final LoadingIconType loadingIconType522 = loadingIconType4;
            final String str422 = str3;
            ModalKt.a(ModifiersKt.d(i.INSTANCE, new h(0, 0, 0, 0.5f)), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 299935975, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1
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
                            ComposerKt.traceEventStart(299935975, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading.<anonymous> (FullScreenLoading.kt:41)");
                        }
                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                        final Function0<Unit> function052 = function0422;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(function052);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    Function0<Unit> function06 = function052;
                                    if (function06 != null) {
                                        function06.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        i d16 = ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null);
                        final LoadingType loadingType2 = loadingType;
                        final LoadingIconType loadingIconType6 = loadingIconType522;
                        final int i28 = i2722;
                        final String str52 = str422;
                        BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, -1838395795, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                b bVar2 = bVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    intValue2 |= composer5.changed(bVar2) ? 4 : 2;
                                }
                                if ((intValue2 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1838395795, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading.<anonymous>.<anonymous> (FullScreenLoading.kt:44)");
                                    }
                                    int ordinal = LoadingType.this.ordinal();
                                    if (ordinal == 0) {
                                        composer5.startReplaceableGroup(-2115778377);
                                        FullScreenLoadingKt.FullScreenLoading(bVar2, loadingIconType6, composer5, (intValue2 & 14) | ((i28 >> 3) & 112), 0);
                                        composer5.endReplaceableGroup();
                                    } else if (ordinal != 1) {
                                        composer5.startReplaceableGroup(-2115778167);
                                        composer5.endReplaceableGroup();
                                    } else {
                                        composer5.startReplaceableGroup(-2115778251);
                                        FullScreenLoadingKt.LoadingWithBottom(bVar2, str52, composer5, (intValue2 & 14) | (i28 & 112), 0);
                                        composer5.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24584, 14);
            if (ComposerKt.isTraceInProgress()) {
            }
            loadingIconType3 = loadingIconType4;
            function02 = function03;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        str2 = str;
        i18 = i16 & 4;
        if (i18 == 0) {
        }
        loadingIconType2 = loadingIconType;
        i19 = i16 & 8;
        if (i19 != 0) {
        }
        function02 = function0;
        if ((i17 & 5851) != 1170) {
        }
        if (i26 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function0<Unit> function04222 = function03;
        final int i27222 = i17;
        final LoadingIconType loadingIconType5222 = loadingIconType4;
        final String str4222 = str3;
        ModalKt.a(ModifiersKt.d(i.INSTANCE, new h(0, 0, 0, 0.5f)), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 299935975, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1
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
                        ComposerKt.traceEventStart(299935975, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading.<anonymous> (FullScreenLoading.kt:41)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final Function0<Unit> function052 = function04222;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(function052);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                Function0<Unit> function06 = function052;
                                if (function06 != null) {
                                    function06.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    i d16 = ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null);
                    final LoadingType loadingType2 = loadingType;
                    final LoadingIconType loadingIconType6 = loadingIconType5222;
                    final int i28 = i27222;
                    final String str52 = str4222;
                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer3, -1838395795, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            b bVar2 = bVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                intValue2 |= composer5.changed(bVar2) ? 4 : 2;
                            }
                            if ((intValue2 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1838395795, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading.<anonymous>.<anonymous> (FullScreenLoading.kt:44)");
                                }
                                int ordinal = LoadingType.this.ordinal();
                                if (ordinal == 0) {
                                    composer5.startReplaceableGroup(-2115778377);
                                    FullScreenLoadingKt.FullScreenLoading(bVar2, loadingIconType6, composer5, (intValue2 & 14) | ((i28 >> 3) & 112), 0);
                                    composer5.endReplaceableGroup();
                                } else if (ordinal != 1) {
                                    composer5.startReplaceableGroup(-2115778167);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(-2115778251);
                                    FullScreenLoadingKt.LoadingWithBottom(bVar2, str52, composer5, (intValue2 & 14) | (i28 & 112), 0);
                                    composer5.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
        }
        loadingIconType3 = loadingIconType4;
        function02 = function03;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final void LoadingWithBottom(final b bVar, final String str, Composer composer, final int i3, final int i16) {
        final int i17;
        Composer startRestartGroup = composer.startRestartGroup(681684733);
        if ((Integer.MIN_VALUE & i16) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(bVar) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i18 = i16 & 1;
        if (i18 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i17 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i18 != 0) {
                str = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(681684733, i17, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingWithBottom (FullScreenLoading.kt:64)");
            }
            BoxKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.q(ModifiersKt.d(bVar.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 100.0f), Alignment.Center), QUIToken.color$default("bg_top_dark")), c.a(6.0f)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$LoadingWithBottom$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                    return Unit.INSTANCE;
                }
            }, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1933588355, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$LoadingWithBottom$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar2, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1933588355, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingWithBottom.<anonymous> (FullScreenLoading.kt:74)");
                        }
                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                        a.e b16 = a.f339245a.b();
                        Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                        final String str2 = str;
                        final int i19 = i17;
                        ColumnKt.a(h16, b16, horizontal, null, ComposableLambdaKt.composableLambda(composer3, 36337338, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$LoadingWithBottom$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        ComposerKt.traceEventStart(36337338, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingWithBottom.<anonymous>.<anonymous> (FullScreenLoading.kt:78)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    LoadingKt.Loading(ComposeLayoutPropUpdaterKt.u(companion, 24.0f), null, composer5, 8, 2);
                                    String str3 = str2;
                                    if (str3 != null) {
                                        int i26 = i19;
                                        TextKt.a(str3, ComposeLayoutPropUpdaterKt.x(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 10.5f, 0.0f, 0.0f, 13, null), 0.0f, 96.0f), null, QUIToken.color$default("text_allwhite_primary"), Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(20.0f), null, null, null, null, an.d(an.INSTANCE.b()), null, 1, null, null, null, null, null, null, null, false, composer5, ((i26 >> 3) & 14) | 1601600, 102236208, 0, 133886884);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 25032, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$LoadingWithBottom$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                FullScreenLoadingKt.LoadingWithBottom(b.this, str, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void FullScreenLoading(final b bVar, final LoadingIconType loadingIconType, Composer composer, final int i3, final int i16) {
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(37187691);
        if ((Integer.MIN_VALUE & i16) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(bVar) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i18 = i16 & 1;
        if (i18 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(loadingIconType) ? 32 : 16;
        }
        if ((i17 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i18 != 0) {
                loadingIconType = LoadingIconType.WHITE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(37187691, i17, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoading (FullScreenLoading.kt:57)");
            }
            LoadingKt.Loading(ViewEventPropUpdaterKt.d(bVar.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), Alignment.Center), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$3
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                    return Unit.INSTANCE;
                }
            }, 3, null), loadingIconType, startRestartGroup, (i17 & 112) | 8, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt$FullScreenLoading$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                FullScreenLoadingKt.FullScreenLoading(b.this, loadingIconType, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
