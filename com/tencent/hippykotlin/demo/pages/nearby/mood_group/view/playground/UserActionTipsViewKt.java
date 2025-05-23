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
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.i;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserActionTipsViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void UserActionTipsView(final UserActionTipsInfo userActionTipsInfo, final NBPMoodGroupConfig.UserActionMenuConfig userActionMenuConfig, Composer composer, final int i3) {
        int i16;
        char c16;
        Point point;
        Point point2;
        Composer startRestartGroup = composer.startRestartGroup(355355223);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(userActionTipsInfo) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(userActionMenuConfig) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(355355223, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsView (UserActionTipsView.kt:48)");
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
            if (((UserActionTipsInfo) mutableState3.getValue()) == null) {
                if (userActionTipsInfo != null) {
                    mutableState.setValue(Boolean.TRUE);
                    mutableState3.setValue(userActionTipsInfo);
                    mutableState2.setValue(Float.valueOf(0.0f));
                }
            } else if (userActionTipsInfo == null) {
                mutableState.setValue(Boolean.FALSE);
            } else {
                UserActionTipsInfo userActionTipsInfo2 = (UserActionTipsInfo) mutableState3.getValue();
                if (!(userActionTipsInfo2 != null && userActionTipsInfo.tid == userActionTipsInfo2.tid)) {
                    mutableState.setValue(Boolean.TRUE);
                    mutableState3.setValue(userActionTipsInfo);
                    mutableState2.setValue(Float.valueOf(0.0f));
                }
            }
            UserActionTipsInfo userActionTipsInfo3 = (UserActionTipsInfo) mutableState3.getValue();
            final float f16 = ((userActionTipsInfo3 == null || (point2 = userActionTipsInfo3.userTopCenter) == null) ? 0.0f : point2.f114220x) + userActionMenuConfig.offset.f114220x;
            UserActionTipsInfo userActionTipsInfo4 = (UserActionTipsInfo) mutableState3.getValue();
            float f17 = userActionMenuConfig.offset.f114221y + ((userActionTipsInfo4 == null || (point = userActionTipsInfo4.userTopCenter) == null) ? 0.0f : point.f114221y);
            float f18 = ((Boolean) mutableState.getValue()).booleanValue() ? 1.0f : 0.0f;
            m d16 = b.d(200, 0, i.c(), null, 10, null);
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(mutableState3) | startRestartGroup.changed(mutableState2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsViewKt$UserActionTipsView$alpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Float f19) {
                        if (f19.floatValue() == 0.0f) {
                            mutableState3.setValue(null);
                            mutableState2.setValue(Float.valueOf(0.0f));
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            State<Float> c17 = AnimateAsStateKt.c(f18, d16, (Function1) rememberedValue4, startRestartGroup, 0, 0);
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
            objArr[3] = Float.valueOf(f16);
            startRestartGroup.startReplaceableGroup(-568225417);
            int i17 = 0;
            boolean z16 = false;
            for (int i18 = 4; i17 < i18; i18 = 4) {
                z16 |= startRestartGroup.changed(objArr[i17]);
                i17++;
            }
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z16 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsViewKt$UserActionTipsView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        final float f19 = f16;
                        final MutableState<aa<v>> mutableState5 = mutableState4;
                        final MutableState<Float> mutableState6 = mutableState2;
                        final MutableState<Boolean> mutableState7 = mutableState;
                        TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsViewKt$UserActionTipsView$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                v b16;
                                aa<v> value = mutableState5.getValue();
                                d frame = (value == null || (b16 = value.b()) == null) ? null : b16.getFrame();
                                if (frame != null) {
                                    if ((mutableState6.getValue().floatValue() == 0.0f) && mutableState7.getValue().booleanValue()) {
                                        float f26 = 2;
                                        float width = f19 - (frame.getWidth() / f26);
                                        float width2 = (frame.getWidth() / f26) + f19;
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
            com.tencent.ntcompose.core.i Q = ModifiersKt.Q(ModifiersKt.b(ModifiersKt.c(ModifiersKt.T(ComposeLayoutPropUpdaterKt.A(com.tencent.ntcompose.core.i.INSTANCE), 2), h.INSTANCE.l()), c17.getValue().floatValue()), new y(-0.5f, -1.0f, ((Number) mutableState2.getValue()).floatValue() + f16, f17), null, 2, null);
            a.k a16 = a.f339245a.a();
            Alignment.Horizontal b16 = Alignment.INSTANCE.b();
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed2 = startRestartGroup.changed(mutableState4);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsViewKt$UserActionTipsView$2$1
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
            ColumnKt.a(Q, a16, b16, (Function2) rememberedValue7, ComposableLambdaKt.composableLambda(startRestartGroup, 866778830, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsViewKt$UserActionTipsView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(866778830, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsView.<anonymous> (UserActionTipsView.kt:145)");
                        }
                        com.tencent.ntcompose.core.i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(ModifiersKt.j(ModifiersKt.c(com.tencent.ntcompose.core.i.INSTANCE, new h(4283124813L)), 6.0f)), 50.0f), 12.0f, 0.0f, 12.0f, 0.0f, 10, null);
                        a.e b17 = a.f339245a.b();
                        Alignment.Vertical c18 = Alignment.INSTANCE.c();
                        final MutableState<UserActionTipsInfo> mutableState5 = mutableState3;
                        RowKt.a(s16, b17, c18, null, null, ComposableLambdaKt.composableLambda(composer3, -810309776, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsViewKt$UserActionTipsView$3.1
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
                                        ComposerKt.traceEventStart(-810309776, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsView.<anonymous>.<anonymous> (UserActionTipsView.kt:153)");
                                    }
                                    UserActionTipsInfo value = mutableState5.getValue();
                                    String str = value != null ? value.tipsIcon : null;
                                    i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                    ImageKt.a(str, null, null, null, null, ComposeLayoutPropUpdaterKt.v(companion2, 24.0f, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                                    StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m((char) 0);
                                    UserActionTipsInfo value2 = mutableState5.getValue();
                                    m3.append(value2 != null ? value2.tipsMsg : null);
                                    TextKt.a(m3.toString(), ComposeLayoutPropUpdaterKt.n(companion2, 5.0f, 0.0f, 0.0f, 0.0f, 14, null), null, new h(4294967295L), Float.valueOf(10.0f), null, null, null, null, null, null, Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28736, 48, 0, 134215652);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196680, 24);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionTipsViewKt$UserActionTipsView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserActionTipsViewKt.UserActionTipsView(UserActionTipsInfo.this, userActionMenuConfig, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
