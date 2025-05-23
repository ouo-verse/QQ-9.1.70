package com.tencent.hippykotlin.demo.pages.nearby.follower_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class NBPFollowerEmptyStateViewKt {
    public static final void NBPGuestFansEmptyState(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1817406885);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1817406885, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPGuestFansEmptyState (NBPFollowerEmptyStateView.kt:104)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), Alignment.Center, null, ComposableSingletons$NBPFollowerEmptyStateViewKt.f39lambda2, startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateViewKt$NBPGuestFansEmptyState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerEmptyStateViewKt.NBPGuestFansEmptyState(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPGuestFollowersEmptyState(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(2112128442);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2112128442, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPGuestFollowersEmptyState (NBPFollowerEmptyStateView.kt:147)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), Alignment.Center, null, ComposableSingletons$NBPFollowerEmptyStateViewKt.f41lambda4, startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateViewKt$NBPGuestFollowersEmptyState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerEmptyStateViewKt.NBPGuestFollowersEmptyState(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPSubjectiveFansEmptyState(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1150612373);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1150612373, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPSubjectiveFansEmptyState (NBPFollowerEmptyStateView.kt:84)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), Alignment.Center, null, ComposableSingletons$NBPFollowerEmptyStateViewKt.f38lambda1, startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateViewKt$NBPSubjectiveFansEmptyState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerEmptyStateViewKt.NBPSubjectiveFansEmptyState(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPSubjectiveFollowersEmptyState(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-948972118);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-948972118, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPSubjectiveFollowersEmptyState (NBPFollowerEmptyStateView.kt:124)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), Alignment.Center, null, ComposableSingletons$NBPFollowerEmptyStateViewKt.f40lambda3, startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateViewKt$NBPSubjectiveFollowersEmptyState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerEmptyStateViewKt.NBPSubjectiveFollowersEmptyState(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void NBPFollowerEmptyStateView(final String str, final String str2, final String str3, final String str4, final Function0<Unit> function0, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(213771302);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(str3) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i16 |= startRestartGroup.changed(str4) ? 2048 : 1024;
        }
        if ((57344 & i3) == 0) {
            i16 |= startRestartGroup.changed(function0) ? 16384 : 8192;
        }
        final int i17 = i16;
        if ((46811 & i17) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(213771302, i17, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateView (NBPFollowerEmptyStateView.kt:25)");
            }
            ColumnKt.a(null, a.f339245a.b(), Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1691125021, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateViewKt$NBPFollowerEmptyStateView$1
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
                            ComposerKt.traceEventStart(1691125021, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateView.<anonymous> (NBPFollowerEmptyStateView.kt:35)");
                        }
                        String str5 = str;
                        i.Companion companion = i.INSTANCE;
                        ImageKt.a(str5, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 100), null, 0, null, null, null, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer3, (i17 & 14) | 262144, 1073741824, 0, 1572830);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 24), composer3, 8, 0);
                        c.Companion companion2 = c.INSTANCE;
                        TextKt.a(str2, null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i17 >> 3) & 14) | 1601536, 0, 0, 134217638);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 4), composer3, 8, 0);
                        TextKt.a(str3, null, null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, companion2.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i17 >> 6) & 14) | 1601536, 0, 0, 134217638);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 25), composer3, 8, 0);
                        if (str4.length() > 0) {
                            i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.j(ModifiersKt.d(companion, QUIToken.color$default("button_bg_secondary_pressed")), 4.0f), 74, 29);
                            final Function0<Unit> function02 = function0;
                            composer3.startReplaceableGroup(1157296644);
                            boolean changed = composer3.changed(function02);
                            Object rememberedValue = composer3.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateViewKt$NBPFollowerEmptyStateView$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        function02.invoke();
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue);
                            }
                            composer3.endReplaceableGroup();
                            Function1 function1 = (Function1) rememberedValue;
                            final String str6 = str4;
                            final int i18 = i17;
                            ButtonKt.a(null, function1, v3, null, ComposableLambdaKt.composableLambda(composer3, -1859575453, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateViewKt$NBPFollowerEmptyStateView$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1859575453, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateView.<anonymous>.<anonymous> (NBPFollowerEmptyStateView.kt:65)");
                                        }
                                        c f16 = c.INSTANCE.f();
                                        TextKt.a(str6, null, null, QUIToken.color$default("button_text_secondary_pressed"), Float.valueOf(14.0f), null, f16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i18 >> 9) & 14) | 1601536, 0, 0, 134217638);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 25088, 9);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 25024, 9);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerEmptyStateViewKt$NBPFollowerEmptyStateView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPFollowerEmptyStateViewKt.NBPFollowerEmptyStateView(str, str2, str3, str4, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
