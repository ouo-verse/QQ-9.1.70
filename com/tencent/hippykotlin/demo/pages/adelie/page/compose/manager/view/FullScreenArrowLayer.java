package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;
import yo3.Offset;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FullScreenArrowLayer {
    public static final FullScreenArrowLayer INSTANCE = new FullScreenArrowLayer();

    public static final void access$ContentContainer(final FullScreenArrowLayer fullScreenArrowLayer, final Offset offset, final Function2 function2, Composer composer, final int i3) {
        final int i16;
        fullScreenArrowLayer.getClass();
        Composer startRestartGroup = composer.startRestartGroup(1049467700);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(offset) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1049467700, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer.ContentContainer (FullScreenArrowLayer.kt:51)");
            }
            ColumnKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.z(ModifiersKt.c(i.INSTANCE, h.INSTANCE.j())), 0.0f, 1, null), 0.0f, offset.getY(), 0.0f, 0.0f, 13, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1673822371, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer$ContentContainer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                            ComposerKt.traceEventStart(-1673822371, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer.ContentContainer.<anonymous> (FullScreenArrowLayer.kt:61)");
                        }
                        i.Companion companion = i.INSTANCE;
                        ImageKt.a(null, null, null, null, null, ModifiersKt.T(ModifiersKt.p(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 11.0f), 5.0f), Offset.this.getX() - (11.0f / 2), 0.0f, 0.0f, 0.0f, 14, null), new g(0.0f, -2.0f, 8.0f, new h(436207616L))), 2), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACEAAAAPBAMAAACYbLsaAAAAGFBMVEUAAAD///////////////////////////8jfp1fAAAAB3RSTlMAgF8w78+/tL6sOgAAAFBJREFUGNNVyjEOgCAQBVHUC9jZ2tlaGC9g4Xk0mn99ILAMO+Xkhdr578E13br8OaTPoVGptz+bcqsjIEhFEBAENKj1lLOIZiMgCMgIyAgoAuhbPKAB1U3ZAAAAAElFTkSuQmCC", null, null, null, null, null, null, null, null, QUIToken.color$default("bg_bottom_light"), null, composer3, 12845056, 1073741830, 0, 1571679);
                        i T = ModifiersKt.T(ModifiersKt.p(ComposeLayoutPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.z(ModifiersKt.c(companion, QUIToken.color$default("bg_bottom_light"))), 0.0f, 1, null), c.a(8.0f)), 32.0f, 0.0f, 32.0f, 0.0f, 10, null), 10.0f, 8.0f, 10.0f, 8.0f), new g(0.0f, -2.0f, 8.0f, new h(436207616L))), 1);
                        final Function2<Composer, Integer, Unit> function22 = function2;
                        final int i17 = i16;
                        BoxKt.a(T, null, null, ComposableLambdaKt.composableLambda(composer3, -470116841, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer$ContentContainer$1.1
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
                                        ComposerKt.traceEventStart(-470116841, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer.ContentContainer.<anonymous>.<anonymous> (FullScreenArrowLayer.kt:81)");
                                    }
                                    function22.invoke(composer5, Integer.valueOf((i17 >> 3) & 14));
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer$ContentContainer$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                FullScreenArrowLayer.access$ContentContainer(FullScreenArrowLayer.this, offset, function2, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void CustomizeBubbleView(final Offset offset, final Function2<? super Composer, ? super Integer, Unit> function2, Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        final int i17;
        Function0<Unit> function02;
        final Function0<Unit> function03;
        boolean changed;
        Object rememberedValue;
        final Function0<Unit> function04;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-195044040);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(offset) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        int i18 = i16 & 4;
        if (i18 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            function02 = function0;
            i17 |= startRestartGroup.changed(function02) ? 256 : 128;
            if ((i17 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) != 146 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                function04 = function02;
            } else {
                function03 = i18 == 0 ? null : function02;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-195044040, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer.CustomizeBubbleView (FullScreenArrowLayer.kt:36)");
                }
                i h16 = ComposeLayoutPropUpdaterKt.h(ModifiersKt.c(i.INSTANCE, h.INSTANCE.j()), 0.0f, 1, null);
                startRestartGroup.startReplaceableGroup(1157296644);
                changed = startRestartGroup.changed(function03);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer$CustomizeBubbleView$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            Function0<Unit> function05 = function03;
                            if (function05 != null) {
                                function05.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                ModalKt.a(ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 121520438, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer$CustomizeBubbleView$2
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
                                ComposerKt.traceEventStart(121520438, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer.CustomizeBubbleView.<anonymous> (FullScreenArrowLayer.kt:45)");
                            }
                            FullScreenArrowLayer fullScreenArrowLayer = FullScreenArrowLayer.INSTANCE;
                            Offset offset2 = Offset.this;
                            Function2<Composer, Integer, Unit> function22 = function2;
                            int i19 = Offset.f450729d | MsgConstant.KRMFILETHUMBSIZE384;
                            int i26 = i17;
                            FullScreenArrowLayer.access$ContentContainer(fullScreenArrowLayer, offset2, function22, composer3, i19 | (i26 & 14) | (i26 & 112));
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
                function04 = function03;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer$CustomizeBubbleView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    FullScreenArrowLayer.this.CustomizeBubbleView(offset, function2, function04, composer2, i3 | 1, i16);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        function02 = function0;
        if ((i17 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) != 146) {
        }
        if (i18 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        i h162 = ComposeLayoutPropUpdaterKt.h(ModifiersKt.c(i.INSTANCE, h.INSTANCE.j()), 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(1157296644);
        changed = startRestartGroup.changed(function03);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer$CustomizeBubbleView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                Function0<Unit> function05 = function03;
                if (function05 != null) {
                    function05.invoke();
                }
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        ModalKt.a(ViewEventPropUpdaterKt.d(h162, false, null, (Function1) rememberedValue, 3, null), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 121520438, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer$CustomizeBubbleView$2
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
                        ComposerKt.traceEventStart(121520438, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.FullScreenArrowLayer.CustomizeBubbleView.<anonymous> (FullScreenArrowLayer.kt:45)");
                    }
                    FullScreenArrowLayer fullScreenArrowLayer = FullScreenArrowLayer.INSTANCE;
                    Offset offset2 = Offset.this;
                    Function2<Composer, Integer, Unit> function22 = function2;
                    int i19 = Offset.f450729d | MsgConstant.KRMFILETHUMBSIZE384;
                    int i26 = i17;
                    FullScreenArrowLayer.access$ContentContainer(fullScreenArrowLayer, offset2, function22, composer3, i19 | (i26 & 14) | (i26 & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
        }
        function04 = function03;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
