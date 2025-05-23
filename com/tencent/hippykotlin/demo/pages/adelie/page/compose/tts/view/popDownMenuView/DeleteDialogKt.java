package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DeleteDialogKt {
    public static final void ActionButton(final n nVar, final String str, final Function1<? super ClickParams, Unit> function1, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-745082441);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(nVar) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(function1) ? 256 : 128;
        }
        if ((i16 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-745082441, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.ActionButton (DeleteDialog.kt:114)");
            }
            BoxKt.a(ViewEventPropUpdaterKt.d(nVar.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 55.77f), 1.0f), false, null, function1, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2103251983, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt$ActionButton$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    int i17;
                    b bVar2 = bVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i17 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                    } else {
                        i17 = intValue;
                    }
                    if ((i17 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2103251983, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.ActionButton.<anonymous> (DeleteDialog.kt:119)");
                        }
                        h color$default = QUIToken.color$default("text_primary");
                        int a16 = ai.INSTANCE.a();
                        TextKt.a(str, ComposeLayoutPropUpdaterKt.j(bVar2.a(i.INSTANCE, Alignment.Center), 0.0f, 1, null), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, ai.f(a16), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i16 >> 3) & 14) | 1601600, 0, 0, 134216612);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt$ActionButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DeleteDialogKt.ActionButton(n.this, str, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void DeleteDialog(final Function1<? super ClickParams, Unit> function1, final Function1<? super ClickParams, Unit> function12, final boolean z16, Composer composer, final int i3) {
        int i16;
        c e16;
        Composer startRestartGroup = composer.startRestartGroup(1908284378);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function1) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function12) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(z16) ? 256 : 128;
        }
        final int i17 = i16;
        if ((i17 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1908284378, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialog (DeleteDialog.kt:31)");
            }
            final float f16 = z16 ? 168.0f : 127.77f;
            if (z16) {
                e16 = c.INSTANCE.f();
            } else {
                e16 = c.INSTANCE.e();
            }
            final c cVar = e16;
            ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2074203932, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt$DeleteDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                            ComposerKt.traceEventStart(2074203932, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialog.<anonymous> (DeleteDialog.kt:38)");
                        }
                        i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.c(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), h.INSTANCE.j()), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt$DeleteDialog$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        }, 3, null);
                        Alignment alignment = Alignment.Center;
                        final float f17 = f16;
                        final boolean z17 = z16;
                        final c cVar2 = cVar;
                        final Function1<ClickParams, Unit> function13 = function12;
                        final int i18 = i17;
                        final Function1<ClickParams, Unit> function14 = function1;
                        BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 2009409058, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt$DeleteDialog$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2009409058, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialog.<anonymous>.<anonymous> (DeleteDialog.kt:46)");
                                    }
                                    i j3 = ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 296.0f), f17), QUIToken.color$default("bg_top_light")), 6.0f);
                                    final boolean z18 = z17;
                                    final c cVar3 = cVar2;
                                    final Function1<ClickParams, Unit> function15 = function13;
                                    final int i19 = i18;
                                    final Function1<ClickParams, Unit> function16 = function14;
                                    BoxKt.a(j3, null, null, ComposableLambdaKt.composableLambda(composer5, 559094440, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt.DeleteDialog.1.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(559094440, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialog.<anonymous>.<anonymous>.<anonymous> (DeleteDialog.kt:53)");
                                                }
                                                final boolean z19 = z18;
                                                final c cVar4 = cVar3;
                                                final Function1<ClickParams, Unit> function17 = function15;
                                                final int i26 = i19;
                                                final Function1<ClickParams, Unit> function18 = function16;
                                                ColumnKt.a(null, null, null, null, ComposableLambdaKt.composableLambda(composer7, 2125346783, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt.DeleteDialog.1.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(2125346783, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeleteDialog.kt:54)");
                                                            }
                                                            i.Companion companion = i.INSTANCE;
                                                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 296.0f), z19 ? 114.0f : 72.0f);
                                                            final c cVar5 = cVar4;
                                                            final boolean z26 = z19;
                                                            BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer9, 798513893, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt.DeleteDialog.1.2.1.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(b bVar3, Composer composer10, Integer num5) {
                                                                    int i27;
                                                                    b bVar4 = bVar3;
                                                                    Composer composer11 = composer10;
                                                                    int intValue5 = num5.intValue();
                                                                    if ((intValue5 & 14) == 0) {
                                                                        i27 = (composer11.changed(bVar4) ? 4 : 2) | intValue5;
                                                                    } else {
                                                                        i27 = intValue5;
                                                                    }
                                                                    if ((i27 & 91) == 18 && composer11.getSkipping()) {
                                                                        composer11.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(798513893, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeleteDialog.kt:59)");
                                                                        }
                                                                        h color$default = QUIToken.color$default("text_primary");
                                                                        i.Companion companion2 = i.INSTANCE;
                                                                        TextKt.a("\u662f\u5426\u5220\u9664\u58f0\u97f3", ComposeLayoutPropUpdaterKt.n(bVar4.a(companion2, Alignment.TopCenter), 0.0f, 24.0f, 0.0f, 0.0f, 13, null), null, color$default, Float.valueOf(17.0f), null, c.this, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer11, 28742, 48, 0, 134215588);
                                                                        if (z26) {
                                                                            TextKt.a("\u5220\u9664\u8be5\u58f0\u97f3\u540e\uff0c\u6b63\u5728\u4f7f\u7528\u8be5\u58f0\u97f3\u7684\u667a\u80fd\u4f53\u4f1a\u88ab\u91cd\u7f6e\u4e3a\u201c\u65e0\u58f0\u97f3\u201d\u3002", ComposeLayoutPropUpdaterKt.s(companion2, 28.0f, 56.0f, 28.0f, 0.0f, 8, null), null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 2, null, null, null, null, null, null, null, false, composer11, 1601606, 100663344, 0, 133953444);
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer9, 3080, 6);
                                                            i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 296.0f), 54.0f);
                                                            final Function1<ClickParams, Unit> function19 = function17;
                                                            final int i27 = i26;
                                                            final Function1<ClickParams, Unit> function110 = function18;
                                                            BoxKt.a(k16, null, null, ComposableLambdaKt.composableLambda(composer9, -1812526820, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt.DeleteDialog.1.2.1.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(b bVar3, Composer composer10, Integer num5) {
                                                                    Composer composer11 = composer10;
                                                                    int intValue5 = num5.intValue();
                                                                    if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                        composer11.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1812526820, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeleteDialog.kt:86)");
                                                                        }
                                                                        DeleteDialogKt.Divider(composer11, 0);
                                                                        i j16 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                        a.e d17 = a.f339245a.d();
                                                                        Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                                                        final Function1<ClickParams, Unit> function111 = function19;
                                                                        final int i28 = i27;
                                                                        final Function1<ClickParams, Unit> function112 = function110;
                                                                        RowKt.a(j16, d17, c16, null, null, ComposableLambdaKt.composableLambda(composer11, -1802827714, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt.DeleteDialog.1.2.1.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(n nVar, Composer composer12, Integer num6) {
                                                                                n nVar2 = nVar;
                                                                                Composer composer13 = composer12;
                                                                                int intValue6 = num6.intValue();
                                                                                if ((intValue6 & 14) == 0) {
                                                                                    intValue6 |= composer13.changed(nVar2) ? 4 : 2;
                                                                                }
                                                                                if ((intValue6 & 91) == 18 && composer13.getSkipping()) {
                                                                                    composer13.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-1802827714, intValue6, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeleteDialog.kt:92)");
                                                                                    }
                                                                                    int i29 = (intValue6 & 14) | 48;
                                                                                    DeleteDialogKt.ActionButton(nVar2, "\u53d6\u6d88", function111, composer13, ((i28 << 3) & 896) | i29);
                                                                                    DeleteDialogKt.ActionButton(nVar2, "\u5220\u9664", function112, composer13, i29 | ((i28 << 6) & 896));
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer11, 196680, 24);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer9, 3080, 6);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 24576, 15);
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
                        }), composer3, 3128, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24576, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt$DeleteDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DeleteDialogKt.DeleteDialog(function1, function12, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void Divider(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2102806652);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2102806652, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.Divider (DeleteDialog.kt:104)");
            }
            SpacerKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.5f), QUIToken.color$default("border_standard")), startRestartGroup, 8, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.DeleteDialogKt$Divider$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                DeleteDialogKt.Divider(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
