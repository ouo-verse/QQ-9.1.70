package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.i;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import uo3.c;

/* loaded from: classes37.dex */
public final class LoveWallLevelProgressViewKt$LoveWallLProgressBar$1 extends Lambda implements Function3<b, Composer, Integer, Unit> {
    public final /* synthetic */ MutableState<Float> $progress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallLevelProgressViewKt$LoveWallLProgressBar$1(MutableState<Float> mutableState) {
        super(3);
        this.$progress = mutableState;
    }

    public static final float access$invoke$lambda$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(b bVar, Composer composer, Integer num) {
        Composer composer2 = composer;
        int intValue = num.intValue();
        if ((intValue & 81) == 16 && composer2.getSkipping()) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-209353292, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLProgressBar.<anonymous> (LoveWallLevelProgressView.kt:221)");
            }
            final State<Float> b16 = AnimateAsStateKt.b(this.$progress.getValue().floatValue(), new m(1000, 0, i.c(), false, null, 18, null), null, composer2, 0, 4);
            BoxKt.a(ModifiersKt.e(ModifiersKt.q(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), c.a(14.0f)), Direction.TO_RIGHT, new j(QUIToken.color$default("button_bg_secondary_pressed"), 0.0f), new j(new h(1305267404L), 1.0f)), null, null, ComposableLambdaKt.composableLambda(composer2, -296179090, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt$LoveWallLProgressBar$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar2, Composer composer3, Integer num2) {
                    int i3;
                    b bVar3 = bVar2;
                    Composer composer4 = composer3;
                    int intValue2 = num2.intValue();
                    if ((intValue2 & 14) == 0) {
                        i3 = (composer4.changed(bVar3) ? 4 : 2) | intValue2;
                    } else {
                        i3 = intValue2;
                    }
                    if ((i3 & 91) == 18 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-296179090, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLProgressBar.<anonymous>.<anonymous> (LoveWallLevelProgressView.kt:236)");
                        }
                        if (LoveWallLevelProgressViewKt$LoveWallLProgressBar$1.access$invoke$lambda$0(b16) > 0.01f) {
                            com.tencent.ntcompose.core.i e16 = ModifiersKt.e(bVar3.a(ComposeLayoutPropUpdaterKt.i(ModifiersKt.q(ComposeLayoutPropUpdaterKt.f(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), c.b()), LoveWallLevelProgressViewKt$LoveWallLProgressBar$1.access$invoke$lambda$0(b16)), Alignment.CenterStart), Direction.TO_RIGHT, new j(new h(4294936576L), 0.0f), new j(new h(4294946585L), 0.5f), new j(new h(4294922620L), 1.0f));
                            final State<Float> state = b16;
                            BoxKt.a(e16, null, null, ComposableLambdaKt.composableLambda(composer4, -1375374995, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt.LoveWallLProgressBar.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(b bVar4, Composer composer5, Integer num3) {
                                    int i16;
                                    Continuation continuation;
                                    b bVar5 = bVar4;
                                    Composer composer6 = composer5;
                                    int intValue3 = num3.intValue();
                                    if ((intValue3 & 14) == 0) {
                                        i16 = (composer6.changed(bVar5) ? 4 : 2) | intValue3;
                                    } else {
                                        i16 = intValue3;
                                    }
                                    if ((i16 & 91) == 18 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1375374995, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLProgressBar.<anonymous>.<anonymous>.<anonymous> (LoveWallLevelProgressView.kt:248)");
                                        }
                                        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                        ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_B9vn8TcP7Qa.png", null, null, null, null, ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, 262150, 0, 0, 2097118);
                                        com.tencent.ntcompose.core.i v3 = ComposeLayoutPropUpdaterKt.v(companion, (float) 21.42d, (float) 13.91d);
                                        Alignment alignment = Alignment.CenterEnd;
                                        ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_9oZ3ZevtbN8.png", null, null, null, null, ComposeLayoutPropUpdaterKt.n(bVar5.a(v3, alignment), 0.0f, 0.0f, 8, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, 262150, 0, 0, 2097118);
                                        composer6.startReplaceableGroup(-492369756);
                                        Object rememberedValue = composer6.rememberedValue();
                                        Composer.Companion companion2 = Composer.INSTANCE;
                                        if (rememberedValue == companion2.getEmpty()) {
                                            continuation = null;
                                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                            composer6.updateRememberedValue(rememberedValue);
                                        } else {
                                            continuation = null;
                                        }
                                        composer6.endReplaceableGroup();
                                        final MutableState mutableState = (MutableState) rememberedValue;
                                        Float valueOf = Float.valueOf(LoveWallLevelProgressViewKt$LoveWallLProgressBar$1.access$invoke$lambda$0(state));
                                        composer6.startReplaceableGroup(1157296644);
                                        boolean changed = composer6.changed(mutableState);
                                        Object rememberedValue2 = composer6.rememberedValue();
                                        if (changed || rememberedValue2 == companion2.getEmpty()) {
                                            rememberedValue2 = new LoveWallLevelProgressViewKt$LoveWallLProgressBar$1$1$1$1$1(mutableState, continuation);
                                            composer6.updateRememberedValue(rememberedValue2);
                                        }
                                        composer6.endReplaceableGroup();
                                        EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer6, 64);
                                        if (((Boolean) mutableState.getValue()).booleanValue()) {
                                            com.tencent.ntcompose.core.i a16 = bVar5.a(ComposeLayoutPropUpdaterKt.v(companion, 170, 40), alignment);
                                            composer6.startReplaceableGroup(1157296644);
                                            boolean changed2 = composer6.changed(mutableState);
                                            Object rememberedValue3 = composer6.rememberedValue();
                                            if (changed2 || rememberedValue3 == companion2.getEmpty()) {
                                                rememberedValue3 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt$LoveWallLProgressBar$1$1$1$2$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        mutableState.setValue(Boolean.FALSE);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue3);
                                            }
                                            composer6.endReplaceableGroup();
                                            APNGKt.a(a16, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_4b5FEYNepHT.png", 1, null, null, null, (Function1) rememberedValue3, composer6, 3464, 114);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer4, 3080, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), composer2, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
