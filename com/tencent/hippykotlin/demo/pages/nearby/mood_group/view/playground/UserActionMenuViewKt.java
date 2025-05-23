package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserActionMenuViewKt {
    public static final void access$ActionItem(final String str, final String str2, final Function0 function0, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1806736492);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(function0) ? 256 : 128;
        }
        if ((i16 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1806736492, i16, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.ActionItem (UserActionMenuView.kt:184)");
            }
            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 47.0f), 45.0f);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$ActionItem$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        function0.invoke();
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            ColumnKt.a(ViewEventPropUpdaterKt.d(k3, false, null, (Function1) rememberedValue, 3, null), a.f339245a.b(), Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -2143138549, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$ActionItem$2
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
                            ComposerKt.traceEventStart(-2143138549, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.ActionItem.<anonymous> (UserActionMenuView.kt:189)");
                        }
                        String str3 = str2;
                        i.Companion companion = i.INSTANCE;
                        ImageKt.a(str3, null, null, null, null, ComposeLayoutPropUpdaterKt.v(companion, 20.0f, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, ((i16 >> 3) & 14) | 262144, 0, 0, 2097118);
                        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m((char) 0);
                        m3.append(str);
                        TextKt.a(m3.toString(), ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 2.0f, 0.0f, 0.0f, 13, null), null, new h(4294967295L), Float.valueOf(10.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 28736, 0, 0, 134217700);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24648, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$ActionItem$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserActionMenuViewKt.access$ActionItem(str, str2, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void UserActionMenuView(final UserActionMenuInfo userActionMenuInfo, final NBPMoodGroupConfig.UserActionMenuConfig userActionMenuConfig, final Function2<? super UserActionMenuInfo, ? super NBPMoodGroupConfig.UserActionMenuInteraction, Unit> function2, final Function1<? super String, Unit> function1, Composer composer, final int i3) {
        int i16;
        NBPMoodGroupConfig.UserActionMenuConfig userActionMenuConfig2;
        float f16;
        char c16;
        Point point;
        Point point2;
        Composer startRestartGroup = composer.startRestartGroup(-1859142347);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(userActionMenuInfo) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(userActionMenuConfig) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i16 |= startRestartGroup.changed(function1) ? 2048 : 1024;
        }
        final int i17 = i16;
        if ((i17 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1859142347, i17, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuView (UserActionMenuView.kt:52)");
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
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            if (((UserActionMenuInfo) mutableState3.getValue()) == null) {
                if (userActionMenuInfo != null) {
                    mutableState.setValue(Boolean.TRUE);
                    mutableState3.setValue(userActionMenuInfo);
                    mutableState2.setValue(Float.valueOf(0.0f));
                }
            } else if (userActionMenuInfo == null) {
                mutableState.setValue(Boolean.FALSE);
            } else {
                UserActionMenuInfo userActionMenuInfo2 = (UserActionMenuInfo) mutableState3.getValue();
                if (!(userActionMenuInfo2 != null && userActionMenuInfo.tid == userActionMenuInfo2.tid)) {
                    mutableState.setValue(Boolean.TRUE);
                    mutableState3.setValue(userActionMenuInfo);
                    mutableState2.setValue(Float.valueOf(0.0f));
                }
            }
            UserActionMenuInfo userActionMenuInfo3 = (UserActionMenuInfo) mutableState3.getValue();
            if (userActionMenuInfo3 == null || (point2 = userActionMenuInfo3.userTopCenter) == null) {
                userActionMenuConfig2 = userActionMenuConfig;
                f16 = 0.0f;
            } else {
                f16 = point2.f114220x;
                userActionMenuConfig2 = userActionMenuConfig;
            }
            final float f17 = f16 + userActionMenuConfig2.offset.f114220x;
            UserActionMenuInfo userActionMenuInfo4 = (UserActionMenuInfo) mutableState3.getValue();
            float f18 = ((userActionMenuInfo4 == null || (point = userActionMenuInfo4.userTopCenter) == null) ? 0.0f : point.f114221y) + userActionMenuConfig2.offset.f114221y;
            UserDataManager userDataManager = UserDataManager.INSTANCE;
            UserActionMenuInfo userActionMenuInfo5 = (UserActionMenuInfo) mutableState3.getValue();
            final boolean isHostTid = userDataManager.isHostTid(userActionMenuInfo5 != null ? Long.valueOf(userActionMenuInfo5.tid) : null);
            float f19 = ((Boolean) mutableState.getValue()).booleanValue() ? 1.0f : 0.0f;
            m d16 = b.d(200, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null);
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(mutableState3) | startRestartGroup.changed(mutableState2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$UserActionMenuView$alpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Float f26) {
                        if (f26.floatValue() == 0.0f) {
                            mutableState3.setValue(null);
                            mutableState2.setValue(Float.valueOf(0.0f));
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            State<Float> c17 = AnimateAsStateKt.c(f19, d16, (Function1) rememberedValue4, startRestartGroup, 0, 0);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                c16 = 2;
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            } else {
                c16 = 2;
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState4 = (MutableState) rememberedValue5;
            Object[] objArr = new Object[4];
            objArr[0] = mutableState4;
            objArr[1] = mutableState2;
            objArr[c16] = mutableState;
            objArr[3] = Float.valueOf(f17);
            startRestartGroup.startReplaceableGroup(-568225417);
            boolean z16 = false;
            int i18 = 0;
            for (int i19 = 4; i18 < i19; i19 = 4) {
                z16 |= startRestartGroup.changed(objArr[i18]);
                i18++;
            }
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z16 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$UserActionMenuView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        final float f26 = f17;
                        final MutableState<aa<v>> mutableState5 = mutableState4;
                        final MutableState<Float> mutableState6 = mutableState2;
                        final MutableState<Boolean> mutableState7 = mutableState;
                        TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$UserActionMenuView$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                v b16;
                                aa<v> value = mutableState5.getValue();
                                com.tencent.kuikly.core.layout.d frame = (value == null || (b16 = value.b()) == null) ? null : b16.getFrame();
                                if (frame != null) {
                                    if ((mutableState6.getValue().floatValue() == 0.0f) && mutableState7.getValue().booleanValue()) {
                                        float f27 = 2;
                                        float width = f26 - (frame.getWidth() / f27);
                                        float width2 = (frame.getWidth() / f27) + f26;
                                        if (width < 0.0f) {
                                            mutableState6.setValue(Float.valueOf((-width) + 2.0f));
                                        } else {
                                            c cVar = c.f117352a;
                                            if (width2 > GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar)) {
                                                mutableState6.setValue(Float.valueOf((cVar.g().getPageData().m() - width2) - 2.0f));
                                            }
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }, 1, null);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue6, startRestartGroup, 0);
            i Q = ModifiersKt.Q(ModifiersKt.b(ModifiersKt.c(ModifiersKt.T(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), 2), h.INSTANCE.l()), c17.getValue().floatValue()), new y(-0.5f, -1.0f, ((Number) mutableState2.getValue()).floatValue() + f17, f18), null, 2, null);
            a.k a16 = a.f339245a.a();
            Alignment.Horizontal b16 = Alignment.INSTANCE.b();
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed2 = startRestartGroup.changed(mutableState4);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$UserActionMenuView$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(v vVar, aa<v> aaVar) {
                        mutableState4.setValue(aaVar);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceableGroup();
            ColumnKt.a(Q, a16, b16, (Function2) rememberedValue7, ComposableLambdaKt.composableLambda(startRestartGroup, 199462956, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$UserActionMenuView$3
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
                            ComposerKt.traceEventStart(199462956, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuView.<anonymous> (UserActionMenuView.kt:154)");
                        }
                        RowKt.a(ComposeLayoutPropUpdaterKt.r(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), new h(4283124813L)), 6.0f), 4.0f, 2.5f, 4.0f, 2.5f), null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1554738226, true, new Function3<n, Composer, Integer, Unit>(isHostTid, userActionMenuConfig, function1, mutableState3, i17, function2) { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$UserActionMenuView$3.1
                            public final /* synthetic */ NBPMoodGroupConfig.UserActionMenuConfig $config;
                            public final /* synthetic */ MutableState<UserActionMenuInfo> $displayInfo$delegate;
                            public final /* synthetic */ boolean $isHost;
                            public final /* synthetic */ Function2<UserActionMenuInfo, NBPMoodGroupConfig.UserActionMenuInteraction, Unit> $onInteraction;
                            public final /* synthetic */ Function1<String, Unit> $onOpenProfile;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                                this.$onInteraction = r6;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1554738226, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuView.<anonymous>.<anonymous> (UserActionMenuView.kt:160)");
                                    }
                                    composer5.startReplaceableGroup(1409081235);
                                    if (!this.$isHost) {
                                        List<NBPMoodGroupConfig.UserActionMenuInteraction> list = this.$config.interactions;
                                        final MutableState<UserActionMenuInfo> mutableState5 = this.$displayInfo$delegate;
                                        final Function2<UserActionMenuInfo, NBPMoodGroupConfig.UserActionMenuInteraction, Unit> function22 = this.$onInteraction;
                                        for (final NBPMoodGroupConfig.UserActionMenuInteraction userActionMenuInteraction : list) {
                                            String str = userActionMenuInteraction.name;
                                            String str2 = userActionMenuInteraction.icon.src;
                                            composer5.startReplaceableGroup(1618982084);
                                            boolean changed3 = composer5.changed(mutableState5) | composer5.changed(function22) | composer5.changed(userActionMenuInteraction);
                                            Object rememberedValue8 = composer5.rememberedValue();
                                            if (changed3 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue8 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$UserActionMenuView$3$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        UserActionMenuInfo value = mutableState5.getValue();
                                                        if (value != null) {
                                                            function22.invoke(value, userActionMenuInteraction);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer5.updateRememberedValue(rememberedValue8);
                                            }
                                            composer5.endReplaceableGroup();
                                            UserActionMenuViewKt.access$ActionItem(str, str2, (Function0) rememberedValue8, composer5, 0);
                                        }
                                    }
                                    composer5.endReplaceableGroup();
                                    final Function1<String, Unit> function12 = this.$onOpenProfile;
                                    final MutableState<UserActionMenuInfo> mutableState6 = this.$displayInfo$delegate;
                                    composer5.startReplaceableGroup(511388516);
                                    boolean changed4 = composer5.changed(function12) | composer5.changed(mutableState6);
                                    Object rememberedValue9 = composer5.rememberedValue();
                                    if (changed4 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue9 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$UserActionMenuView$3$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                Function1<String, Unit> function13 = function12;
                                                UserActionMenuInfo value = mutableState6.getValue();
                                                function13.invoke(String.valueOf(value != null ? Long.valueOf(value.tid) : null));
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue9);
                                    }
                                    composer5.endReplaceableGroup();
                                    UserActionMenuViewKt.access$ActionItem("\u8d44\u6599\u5361", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_yGksmbdXKVA.png", (Function0) rememberedValue9, composer5, 54);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 30);
                        BubbleArrowKt.BubbleArrow(17.0f, 8.0f, 1.5f, new h(4283124813L), -mutableState2.getValue().floatValue(), 0.0f, null, composer3, 4534, 96);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24648, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuViewKt$UserActionMenuView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserActionMenuViewKt.UserActionMenuView(UserActionMenuInfo.this, userActionMenuConfig, function2, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
