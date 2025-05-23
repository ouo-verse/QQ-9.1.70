package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.enter_tip.EnterTip;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.enter_tip.NBPUserEnterTipViewModel;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserEnterTipViewNewKt {
    public static final void UserEnterTipViewNew(final NBPMoodGroupViewModel nBPMoodGroupViewModel, Composer composer, final int i3) {
        NBPMoodGroupConfig.IndicatorConfig indicatorConfig;
        final String str;
        Composer startRestartGroup = composer.startRestartGroup(1142925617);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1142925617, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNew (UserEnterTipViewNew.kt:48)");
        }
        g gVar = nBPMoodGroupViewModel.pageData;
        NBPMoodGroupConfig nBPMoodGroupConfig = nBPMoodGroupViewModel.config;
        if (nBPMoodGroupConfig != null && (indicatorConfig = nBPMoodGroupConfig.indicatorConfig) != null && (str = indicatorConfig.moodTitle) != null) {
            BoxKt.a(ComposeLayoutPropUpdaterKt.o(ModifiersKt.E(ModifiersKt.T(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, gVar.m()), 90.0f), 2), true), 16.0f, ((gVar.l() - 200.0f) - 90.0f) - (((a) startRestartGroup.consume(CompositionLocalsKt.d())).l() ? 35.0f : 0.0f)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1217025429, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    float f16;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1217025429, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNew.<anonymous> (UserEnterTipViewNew.kt:63)");
                        }
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel2 = NBPMoodGroupViewModel.this;
                        SnapshotStateList<EnterTip> snapshotStateList = nBPMoodGroupViewModel2.enterTipVM.list;
                        final String str2 = str;
                        Iterator<EnterTip> it = snapshotStateList.iterator();
                        int i16 = 0;
                        while (it.hasNext()) {
                            EnterTip next = it.next();
                            int i17 = i16 + 1;
                            if (i16 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            final EnterTip enterTip = next;
                            composer3.startReplaceableGroup(-492369756);
                            Object rememberedValue = composer3.rememberedValue();
                            Composer.Companion companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(enterTip, null, 2, null);
                                composer3.updateRememberedValue(rememberedValue);
                            }
                            composer3.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue;
                            composer3.startReplaceableGroup(-492369756);
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            final MutableState mutableState2 = (MutableState) rememberedValue2;
                            composer3.startReplaceableGroup(-492369756);
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            final MutableState mutableState3 = (MutableState) rememberedValue3;
                            composer3.startReplaceableGroup(-492369756);
                            Object rememberedValue4 = composer3.rememberedValue();
                            if (rememberedValue4 == companion.getEmpty()) {
                                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                                composer3.updateRememberedValue(rememberedValue4);
                            }
                            composer3.endReplaceableGroup();
                            final MutableState mutableState4 = (MutableState) rememberedValue4;
                            State<Float> c16 = AnimateAsStateKt.c(((Boolean) mutableState3.getValue()).booleanValue() ? 1.0f : 0.0f, com.tencent.ntcompose.animation.b.d(200, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null), new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$1$1$alpha$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Float f17) {
                                    if (f17.floatValue() == 1.0f) {
                                        final NBPMoodGroupViewModel nBPMoodGroupViewModel3 = NBPMoodGroupViewModel.this;
                                        final EnterTip enterTip2 = enterTip;
                                        final MutableState<Boolean> mutableState5 = mutableState3;
                                        final MutableState<String> mutableState6 = mutableState4;
                                        TimerKt.d(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$1$1$alpha$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                mutableState5.setValue(Boolean.FALSE);
                                                NBPUserEnterTipViewModel nBPUserEnterTipViewModel = NBPMoodGroupViewModel.this.enterTipVM;
                                                EnterTip enterTip3 = enterTip2;
                                                nBPUserEnterTipViewModel.getClass();
                                                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("animateEnd: nick= "), enterTip3 != null ? enterTip3.nick : null, KLog.INSTANCE, "EnterTipManger");
                                                TimerKt.b(mutableState6.getValue());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, composer3, 0, 0);
                            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                                int size = nBPMoodGroupViewModel2.enterTipVM.list.size() - i16;
                                f16 = ((-size) * 26.0f) - ((size - 1) * 6.0f);
                            } else {
                                f16 = 0.0f;
                            }
                            m d16 = com.tencent.ntcompose.animation.b.d(200, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null);
                            composer3.startReplaceableGroup(1157296644);
                            final String str3 = "UserEnterTipViewNew";
                            boolean changed = composer3.changed("UserEnterTipViewNew");
                            Object rememberedValue5 = composer3.rememberedValue();
                            if (changed || rememberedValue5 == companion.getEmpty()) {
                                rememberedValue5 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$1$1$animateOffsetY$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Float f17) {
                                        float floatValue = f17.floatValue();
                                        KLog.INSTANCE.i(str3, "cb: " + floatValue);
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue5);
                            }
                            composer3.endReplaceableGroup();
                            i o16 = ComposeLayoutPropUpdaterKt.o(ModifiersKt.Q(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.s(ModifiersKt.b(ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 26.0f)), c16.getValue().floatValue()), 6.0f, 0.0f, 6.0f, 0.0f, 10, null), 26.0f / 2), new h(0L, 0.5f)), new y(0.0f, 0.0f, 0.0f, AnimateAsStateKt.c(f16, d16, (Function1) rememberedValue5, composer3, 0, 0).getValue().floatValue()), null, 2, null), 0.0f, 90.0f);
                            composer3.startReplaceableGroup(511388516);
                            boolean changed2 = composer3.changed(mutableState3) | composer3.changed(mutableState2);
                            Object rememberedValue6 = composer3.rememberedValue();
                            if (changed2 || rememberedValue6 == companion.getEmpty()) {
                                rememberedValue6 = new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ap3.a aVar) {
                                        MutableState<Boolean> mutableState5 = mutableState3;
                                        Boolean bool = Boolean.TRUE;
                                        mutableState5.setValue(bool);
                                        mutableState2.setValue(bool);
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue6);
                            }
                            composer3.endReplaceableGroup();
                            i l3 = ViewEventPropUpdaterKt.l(o16, (Function1) rememberedValue6);
                            composer3.startReplaceableGroup(511388516);
                            boolean changed3 = composer3.changed(mutableState3) | composer3.changed(mutableState4);
                            Object rememberedValue7 = composer3.rememberedValue();
                            if (changed3 || rememberedValue7 == companion.getEmpty()) {
                                rememberedValue7 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        if (mutableState3.getValue().booleanValue()) {
                                            MutableState<String> mutableState5 = mutableState4;
                                            final MutableState<Boolean> mutableState6 = mutableState3;
                                            mutableState5.setValue(TimerKt.d(5000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$1$1$2$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    mutableState6.setValue(Boolean.FALSE);
                                                    return Unit.INSTANCE;
                                                }
                                            }));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue7);
                            }
                            composer3.endReplaceableGroup();
                            RowKt.a(ViewEventPropUpdaterKt.g(l3, (Function1) rememberedValue7), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer3, -1587451403, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$1$1$3
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
                                            ComposerKt.traceEventStart(-1587451403, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNew.<anonymous>.<anonymous>.<anonymous> (UserEnterTipViewNew.kt:131)");
                                        }
                                        i.Companion companion2 = i.INSTANCE;
                                        ImageKt.a(mutableState.getValue().avatar, null, null, null, null, ModifiersKt.g(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion2, 14.0f), 7.0f), 0.0f, 0.0f, 4.0f, 0.0f, 11, null), new e(0.5f, BorderStyle.SOLID, h.INSTANCE.m())), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
                                        i x16 = ComposeLayoutPropUpdaterKt.x(companion2, 0.0f, 180.0f);
                                        h hVar = new h(4294967295L);
                                        TextKt.a(mutableState.getValue().nick, x16, null, hVar, Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, an.d(an.INSTANCE.b()), null, 1, null, null, null, "emoji", null, null, null, false, composer5, 28736, 102236160, MsgConstant.KRMFILETHUMBSIZE384, 129695716);
                                        i D = ModifiersKt.D(companion2, 0.8f);
                                        h hVar2 = new h(4294967295L);
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u52a0\u5165\u4e86");
                                        m3.append(str2);
                                        TextKt.a(m3.toString(), D, null, hVar2, Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "emoji", null, null, null, false, composer5, 28736, 0, MsgConstant.KRMFILETHUMBSIZE384, 130023396);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 196616, 26);
                            i16 = i17;
                        }
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
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    UserEnterTipViewNewKt.UserEnterTipViewNew(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.UserEnterTipViewNewKt$UserEnterTipViewNew$moodTitle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserEnterTipViewNewKt.UserEnterTipViewNew(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
