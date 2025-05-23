package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingIconType;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.MotionEvent;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIButtonKt {
    public static final void QUIButton(final i iVar, QUIButtonType qUIButtonType, QUIButtonStatus qUIButtonStatus, final String str, k kVar, final Function1<? super ClickParams, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super QUIButtonStatus, ? extends Pair<? extends i, h>> function12, Composer composer, final int i3, final int i16) {
        k kVar2;
        int i17;
        boolean z16;
        Pair<? extends i, h> pair;
        Composer startRestartGroup = composer.startRestartGroup(550910687);
        QUIButtonType qUIButtonType2 = (i16 & 2) != 0 ? QUIButtonType.PRIMARY : qUIButtonType;
        QUIButtonStatus qUIButtonStatus2 = (i16 & 4) != 0 ? QUIButtonStatus.DEFAULT : qUIButtonStatus;
        if ((i16 & 16) != 0) {
            kVar2 = new k(null, Float.valueOf(17.0f), c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 16377, null);
            i17 = i3 & (-57345);
        } else {
            kVar2 = kVar;
            i17 = i3;
        }
        Function2<? super Composer, ? super Integer, Unit> function22 = (i16 & 64) != 0 ? null : function2;
        Function1<? super QUIButtonStatus, ? extends Pair<? extends i, h>> function13 = (i16 & 128) != 0 ? null : function12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(550910687, i17, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButton (QUIButton.kt:77)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        QUIButtonStatus qUIButtonStatus3 = ((Boolean) mutableState.getValue()).booleanValue() ? QUIButtonStatus.LOADING : qUIButtonStatus2;
        if (function13 == null || (pair = function13.invoke(qUIButtonStatus3)) == null) {
            QUIButtonStatus qUIButtonStatus4 = ((Boolean) mutableState.getValue()).booleanValue() ? QUIButtonStatus.LOADING : qUIButtonStatus2;
            h color$default = QUIToken.color$default("button_bg_primary_default");
            h j3 = h.INSTANCE.j();
            h color$default2 = QUIToken.color$default("button_text_primary_default");
            int ordinal = qUIButtonType2.ordinal();
            float f16 = 0.0f;
            if (ordinal == 0) {
                int ordinal2 = qUIButtonStatus4.ordinal();
                if (ordinal2 != 0) {
                    if (ordinal2 == 1) {
                        color$default = QUIToken.color$default("button_bg_primary_pressed");
                        color$default2 = QUIToken.color$default("button_text_primary_pressed");
                    } else if (ordinal2 == 2) {
                        color$default = QUIToken.color$default("button_bg_primary_disable");
                        color$default2 = QUIToken.color$default("button_text_primary_disable");
                        z16 = false;
                    }
                }
                z16 = true;
            } else if (ordinal == 1) {
                int ordinal3 = qUIButtonStatus4.ordinal();
                if (ordinal3 == 0) {
                    color$default = QUIToken.color$default("button_bg_secondary_default");
                    j3 = QUIToken.color$default("button_border_secondary_default");
                    color$default2 = QUIToken.color$default("button_text_secondary_default");
                } else if (ordinal3 == 1) {
                    color$default = QUIToken.color$default("button_bg_secondary_pressed");
                    j3 = QUIToken.color$default("button_border_secondary_pressed");
                    color$default2 = QUIToken.color$default("button_text_secondary_pressed");
                } else if (ordinal3 == 2) {
                    color$default = QUIToken.color$default("button_bg_secondary_disable");
                    j3 = QUIToken.color$default("button_border_secondary_disable");
                    color$default2 = QUIToken.color$default("button_text_secondary_disable");
                    f16 = 1.0f;
                    z16 = false;
                }
                z16 = true;
                f16 = 1.0f;
            } else if (ordinal != 2) {
                if (ordinal == 3) {
                    int ordinal4 = qUIButtonStatus4.ordinal();
                    if (ordinal4 == 0) {
                        color$default = QUIToken.color$default("button_bg_ghost_default");
                        j3 = QUIToken.color$default("button_border_ghost_default");
                        color$default2 = QUIToken.color$default("button_text_ghost_default");
                    } else if (ordinal4 == 1) {
                        color$default = QUIToken.color$default("button_bg_ghost_pressed");
                        j3 = QUIToken.color$default("button_border_ghost_pressed");
                        color$default2 = QUIToken.color$default("button_text_ghost_pressed");
                    } else if (ordinal4 == 2) {
                        color$default = QUIToken.color$default("button_bg_ghost_disable");
                        j3 = QUIToken.color$default("button_border_ghost_disable");
                        color$default2 = QUIToken.color$default("button_text_ghost_disable");
                        f16 = 1.0f;
                        z16 = false;
                    }
                    z16 = true;
                    f16 = 1.0f;
                }
                z16 = true;
            } else {
                int ordinal5 = qUIButtonStatus4.ordinal();
                if (ordinal5 == 0) {
                    color$default = QUIToken.color$default("button_bg_error_default");
                    j3 = QUIToken.color$default("button_border_error_default");
                    color$default2 = QUIToken.color$default("button_text_error_default");
                } else if (ordinal5 == 1) {
                    color$default = QUIToken.color$default("button_bg_error_pressed");
                    j3 = QUIToken.color$default("button_border_error_pressed");
                    color$default2 = QUIToken.color$default("button_text_error_pressed");
                } else if (ordinal5 == 2) {
                    color$default = QUIToken.color$default("button_bg_error_disable");
                    j3 = QUIToken.color$default("button_border_error_disable");
                    color$default2 = QUIToken.color$default("button_text_error_disable");
                    f16 = 1.0f;
                    z16 = false;
                }
                z16 = true;
                f16 = 1.0f;
            }
            pair = new Pair<>(ModifiersKt.M(ModifiersKt.j(ModifiersKt.g(ModifiersKt.c(i.INSTANCE, color$default), new e(f16, BorderStyle.SOLID, j3)), 4.0f), z16), color$default2);
        }
        final Pair<? extends i, h> pair2 = pair;
        i b16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(iVar, 45.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null).b((i) pair2.getFirst());
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(mutableState);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1<MotionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt$QUIButton$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        mutableState.setValue(Boolean.TRUE);
                    } else if (action == 2) {
                        mutableState.setValue(Boolean.FALSE);
                    } else if (action == 3) {
                        mutableState.setValue(Boolean.FALSE);
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final QUIButtonType qUIButtonType3 = qUIButtonType2;
        final QUIButtonStatus qUIButtonStatus5 = qUIButtonStatus2;
        final int i18 = i17;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
        final k kVar3 = kVar2;
        final Function1<? super QUIButtonStatus, ? extends Pair<? extends i, h>> function14 = function13;
        ButtonKt.a(null, function1, ViewEventPropUpdaterKt.p(b16, (Function1) rememberedValue2), null, ComposableLambdaKt.composableLambda(startRestartGroup, -2110571948, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt$QUIButton$2
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
                        ComposerKt.traceEventStart(-2110571948, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButton.<anonymous> (QUIButton.kt:102)");
                    }
                    QUIButtonType qUIButtonType4 = QUIButtonType.this;
                    QUIButtonStatus qUIButtonStatus6 = qUIButtonStatus5;
                    boolean booleanValue = mutableState.getValue().booleanValue();
                    int i19 = i18 >> 3;
                    QUIButtonKt.access$buildLoadingView(qUIButtonType4, qUIButtonStatus6, booleanValue, composer3, (i19 & 112) | (i19 & 14));
                    if (function23 != null) {
                        composer3.startReplaceableGroup(-1619466408);
                        function23.invoke(composer3, Integer.valueOf((i18 >> 18) & 14));
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(-1619466351);
                        h second = pair2.getSecond();
                        String str2 = str;
                        k kVar4 = kVar3;
                        int i26 = i18;
                        TextKt.a(str2, null, null, second, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, kVar4, null, null, null, null, null, false, composer3, ((i26 >> 9) & 14) | 4096, 0, k.f28903n | ((i26 >> 12) & 14), 133169142);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, ((i17 >> 12) & 112) | 25088, 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final QUIButtonType qUIButtonType4 = qUIButtonType2;
        final QUIButtonStatus qUIButtonStatus6 = qUIButtonStatus2;
        final k kVar4 = kVar2;
        final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt$QUIButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIButtonKt.QUIButton(i.this, qUIButtonType4, qUIButtonStatus6, str, kVar4, function1, function24, function14, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$buildLoadingView(final QUIButtonType qUIButtonType, final QUIButtonStatus qUIButtonStatus, final boolean z16, Composer composer, final int i3) {
        int i16;
        LoadingIconType loadingIconType;
        Composer startRestartGroup = composer.startRestartGroup(474158303);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(qUIButtonType) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(qUIButtonStatus) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(474158303, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.buildLoadingView (QUIButton.kt:210)");
            }
            if (qUIButtonStatus != QUIButtonStatus.LOADING) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt$buildLoadingView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        QUIButtonKt.access$buildLoadingView(QUIButtonType.this, qUIButtonStatus, z16, composer2, i3 | 1);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            boolean z17 = (qUIButtonType == QUIButtonType.PRIMARY || qUIButtonType == QUIButtonType.GHOST) ? false : true;
            i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 19.0f), 0.0f, 0.0f, 2.5f, 0.0f, 11, null);
            if (z17) {
                loadingIconType = LoadingIconType.GRAY;
            } else {
                loadingIconType = LoadingIconType.WHITE;
            }
            LoadingKt.Loading(s16, loadingIconType, startRestartGroup, 8, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt$buildLoadingView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIButtonKt.access$buildLoadingView(QUIButtonType.this, qUIButtonStatus, z16, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
