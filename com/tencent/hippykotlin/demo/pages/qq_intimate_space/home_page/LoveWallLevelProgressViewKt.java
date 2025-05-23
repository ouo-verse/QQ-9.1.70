package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.MathUtilsKt;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import uo3.c;

/* loaded from: classes37.dex */
public final class LoveWallLevelProgressViewKt {
    public static final void LoveWallLProgressBar(final i iVar, final MutableState<Float> mutableState, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1148816250);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1148816250, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLProgressBar (LoveWallLevelProgressView.kt:220)");
        }
        BoxKt.a(iVar, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -209353292, true, new LoveWallLevelProgressViewKt$LoveWallLProgressBar$1(mutableState)), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt$LoveWallLProgressBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallLevelProgressViewKt.LoveWallLProgressBar(i.this, mutableState, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallLevelProgressView(final i iVar, final LevelProgressModel levelProgressModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-784460113);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-784460113, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressView (LoveWallLevelProgressView.kt:69)");
        }
        BoxKt.a(iVar, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 387011637, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt$LoveWallLevelProgressView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(387011637, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressView.<anonymous> (LoveWallLevelProgressView.kt:70)");
                    }
                    i q16 = ModifiersKt.q(ModifiersKt.f(ModifiersKt.e(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), Direction.TO_RIGHT, new j(new h(4291424595L), 0.0f), new j(new h(4294967295L), 1.0f)), 1, h.INSTANCE.m(), BorderStyle.SOLID), c.a(18.0f));
                    final LevelProgressModel levelProgressModel2 = LevelProgressModel.this;
                    BoxKt.a(q16, null, null, ComposableLambdaKt.composableLambda(composer3, -1129195717, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt$LoveWallLevelProgressView$1.1

                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt$LoveWallLevelProgressView$1$1$1", f = "LoveWallLevelProgressView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt$LoveWallLevelProgressView$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes37.dex */
                        public final class C45961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            public final /* synthetic */ Animatable<Float> $heightOpacityAnimation;
                            public final /* synthetic */ Animatable<Float> $heightYOffsetAnimation;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C45961(Animatable<Float> animatable, Animatable<Float> animatable2, Continuation<? super C45961> continuation) {
                                super(2, continuation);
                                this.$heightOpacityAnimation = animatable;
                                this.$heightYOffsetAnimation = animatable2;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C45961(this.$heightOpacityAnimation, this.$heightYOffsetAnimation, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C45961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                ResultKt.throwOnFailure(obj);
                                Animatable.b(this.$heightOpacityAnimation, Boxing.boxFloat(1.0f), com.tencent.ntcompose.animation.b.d(500, 0, null, null, 14, null), null, false, 12, null);
                                Animatable.b(this.$heightYOffsetAnimation, Boxing.boxFloat(0.0f), com.tencent.ntcompose.animation.b.d(500, 0, null, null, 14, null), null, false, 12, null);
                                return Unit.INSTANCE;
                            }
                        }

                        {
                            super(3);
                        }

                        /* JADX WARN: Type inference failed for: r14v10 */
                        /* JADX WARN: Type inference failed for: r14v2 */
                        /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.runtime.SnapshotMutationPolicy, kotlin.coroutines.Continuation, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                            int i16;
                            String str;
                            int i17;
                            ?? r142;
                            String str2;
                            MutableState mutableState;
                            Animatable animatable;
                            Animatable animatable2;
                            MutableState mutableState2;
                            i.Companion companion;
                            Composer composer5;
                            Composer composer6;
                            i.Companion companion2;
                            bp3.c f16;
                            bp3.c f17;
                            b bVar3 = bVar2;
                            Composer composer7 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer7.changed(bVar3) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer7.getSkipping()) {
                                composer7.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1129195717, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressView.<anonymous>.<anonymous> (LoveWallLevelProgressView.kt:80)");
                                }
                                if (LevelProgressModel.this.treeProgress.getValue().f395446f.length() > 0) {
                                    str = "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_y2CejW7rLU4.png";
                                } else {
                                    str = "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_P2QThaWosn1.png";
                                }
                                i.Companion companion3 = i.INSTANCE;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.h(companion3, 0.0f, 1, null), null, 0, null, null, str, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2096095);
                                composer7.startReplaceableGroup(-492369756);
                                Object rememberedValue = composer7.rememberedValue();
                                Composer.Companion companion4 = Composer.INSTANCE;
                                if (rememberedValue == companion4.getEmpty()) {
                                    i17 = 2;
                                    r142 = 0;
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                                    composer7.updateRememberedValue(rememberedValue);
                                } else {
                                    i17 = 2;
                                    r142 = 0;
                                }
                                composer7.endReplaceableGroup();
                                MutableState mutableState3 = (MutableState) rememberedValue;
                                composer7.startReplaceableGroup(-492369756);
                                Object rememberedValue2 = composer7.rememberedValue();
                                if (rememberedValue2 == companion4.getEmpty()) {
                                    rememberedValue2 = new Animatable(Float.valueOf(1.0f));
                                    composer7.updateRememberedValue(rememberedValue2);
                                }
                                composer7.endReplaceableGroup();
                                Animatable animatable3 = (Animatable) rememberedValue2;
                                composer7.startReplaceableGroup(-492369756);
                                Object rememberedValue3 = composer7.rememberedValue();
                                if (rememberedValue3 == companion4.getEmpty()) {
                                    rememberedValue3 = new Animatable(Float.valueOf(0.0f));
                                    composer7.updateRememberedValue(rememberedValue3);
                                }
                                composer7.endReplaceableGroup();
                                Animatable animatable4 = (Animatable) rememberedValue3;
                                composer7.startReplaceableGroup(-492369756);
                                Object rememberedValue4 = composer7.rememberedValue();
                                if (rememberedValue4 == companion4.getEmpty()) {
                                    rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, r142, i17, r142);
                                    composer7.updateRememberedValue(rememberedValue4);
                                }
                                composer7.endReplaceableGroup();
                                MutableState mutableState4 = (MutableState) rememberedValue4;
                                composer7.startReplaceableGroup(-492369756);
                                Object rememberedValue5 = composer7.rememberedValue();
                                if (rememberedValue5 == companion4.getEmpty()) {
                                    rememberedValue5 = new Animatable(Float.valueOf(0.0f));
                                    composer7.updateRememberedValue(rememberedValue5);
                                }
                                composer7.endReplaceableGroup();
                                Animatable animatable5 = (Animatable) rememberedValue5;
                                composer7.startReplaceableGroup(-492369756);
                                Object rememberedValue6 = composer7.rememberedValue();
                                if (rememberedValue6 == companion4.getEmpty()) {
                                    rememberedValue6 = new Animatable(Float.valueOf(10.0f));
                                    composer7.updateRememberedValue(rememberedValue6);
                                }
                                composer7.endReplaceableGroup();
                                Animatable animatable6 = (Animatable) rememberedValue6;
                                composer7.startReplaceableGroup(1824232996);
                                if (!((Boolean) mutableState4.getValue()).booleanValue()) {
                                    str2 = "DINPro-Bold";
                                    mutableState = mutableState4;
                                    animatable = animatable4;
                                    animatable2 = animatable3;
                                    mutableState2 = mutableState3;
                                    companion = companion3;
                                    composer5 = composer7;
                                } else {
                                    C45961 c45961 = new C45961(animatable5, animatable6, r142);
                                    int i18 = Animatable.f339143c;
                                    EffectsKt.LaunchedEffect(animatable5, animatable6, c45961, composer7, (i18 << 3) | i18 | 512);
                                    String str3 = "\u5f53\u524d\u7231\u60c5\u9ad8\u5ea6" + MathUtilsKt.roundToDecimalPlaces(LevelProgressModel.this.treeProgress.getValue().f395444d) + 'm';
                                    i D = ModifiersKt.D(ComposeLayoutPropUpdaterKt.o(bVar3.a(companion3, Alignment.TopStart), 12, ((Number) animatable6.f()).floatValue() + 4), ((Number) animatable5.f()).floatValue());
                                    n nVar = new n("DINPro-Bold");
                                    float f18 = 13;
                                    if (com.tencent.ntcompose.activity.b.a().getPageData().getIsIOS()) {
                                        f17 = bp3.c.INSTANCE.a();
                                    } else {
                                        f17 = bp3.c.INSTANCE.f();
                                    }
                                    str2 = "DINPro-Bold";
                                    mutableState = mutableState4;
                                    animatable = animatable4;
                                    animatable2 = animatable3;
                                    mutableState2 = mutableState3;
                                    companion = companion3;
                                    composer5 = composer7;
                                    TextKt.a(str3, D, null, null, null, null, null, nVar, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_primary"), Float.valueOf(f18), f17, null, null, null, null, null, null, Float.valueOf(23), null, null, null, null, 15864, null), null, null, null, null, null, false, composer5, (n.f339436b << 21) | 64, 0, k.f28903n, 133169020);
                                }
                                composer5.endReplaceableGroup();
                                Composer composer8 = composer5;
                                composer8.startReplaceableGroup(1824234176);
                                if (((Boolean) mutableState2.getValue()).booleanValue()) {
                                    i.Companion companion5 = companion;
                                    i D2 = ModifiersKt.D(ComposeLayoutPropUpdaterKt.o(bVar3.a(companion5, Alignment.TopStart), 12, ((Number) animatable.f()).floatValue() + 4), ((Number) animatable2.f()).floatValue());
                                    n nVar2 = new n(str2);
                                    float f19 = 13;
                                    if (com.tencent.ntcompose.activity.b.a().getPageData().getIsIOS()) {
                                        f16 = bp3.c.INSTANCE.a();
                                    } else {
                                        f16 = bp3.c.INSTANCE.f();
                                    }
                                    companion2 = companion5;
                                    composer6 = composer8;
                                    TextKt.a("\u957f\u8d8a\u9ad8 \u60c5\u8d8a\u957f", D2, null, null, null, null, null, nVar2, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_primary"), Float.valueOf(f19), f16, null, null, null, null, null, null, Float.valueOf(23), null, null, null, null, 15864, null), null, null, null, null, null, false, composer6, (n.f339436b << 21) | 70, 0, k.f28903n, 133169020);
                                    final Animatable animatable7 = animatable;
                                    final Animatable animatable8 = animatable2;
                                    final MutableState mutableState5 = mutableState2;
                                    final MutableState mutableState6 = mutableState;
                                    TimerKt.c(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt.LoveWallLevelProgressView.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            mutableState6.setValue(Boolean.TRUE);
                                            Animatable<Float> animatable9 = animatable8;
                                            Float valueOf = Float.valueOf(0.0f);
                                            m d16 = com.tencent.ntcompose.animation.b.d(500, 0, null, null, 14, null);
                                            final MutableState<Boolean> mutableState7 = mutableState5;
                                            Animatable.b(animatable9, valueOf, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt.LoveWallLevelProgressView.1.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Float f26) {
                                                    f26.floatValue();
                                                    mutableState7.setValue(Boolean.FALSE);
                                                    return Unit.INSTANCE;
                                                }
                                            }, false, 8, null);
                                            Animatable.b(animatable7, Float.valueOf(-10.0f), com.tencent.ntcompose.animation.b.d(500, 0, null, null, 14, null), null, false, 12, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    composer6 = composer8;
                                    companion2 = companion;
                                }
                                composer6.endReplaceableGroup();
                                i.Companion companion6 = companion2;
                                i a16 = bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion6, 0.0f, 1, null), 33), 0.0f, 0.0f, 8, 0.0f, 11, null), Alignment.TopCenter);
                                a.d c16 = a.f339245a.c();
                                Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                                final LevelProgressModel levelProgressModel3 = LevelProgressModel.this;
                                Composer composer9 = composer6;
                                RowKt.a(a16, c16, vertical, null, null, ComposableLambdaKt.composableLambda(composer9, 1530615517, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt.LoveWallLevelProgressView.1.1.3
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar3, Composer composer10, Integer num3) {
                                        Composer composer11 = composer10;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer11.getSkipping()) {
                                            composer11.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1530615517, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressView.<anonymous>.<anonymous>.<anonymous> (LoveWallLevelProgressView.kt:155)");
                                            }
                                            String str4 = LevelProgressModel.this.treeProgress.getValue().f395447h;
                                            i.Companion companion7 = i.INSTANCE;
                                            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion7, 20), null, 0, null, null, str4, null, null, null, null, null, null, null, null, null, null, composer11, 262144, 0, 0, 2096095);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion7, 2), composer11, 8, 0);
                                            String str5 = LevelProgressModel.this.treeProgress.getValue().f395446f;
                                            QUIToken qUIToken = QUIToken.INSTANCE;
                                            TextKt.a(str5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_primary"), Float.valueOf(13), null, null, null, null, null, null, null, null, null, null, null, null, 16380, null), null, null, null, null, null, false, composer11, 0, 0, k.f28903n, 133169150);
                                            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion7, 12), null, 0, null, null, qUIToken.image("chevron_right", QUIToken.color$default("text_primary")), null, null, null, null, null, null, null, null, null, null, composer11, 262144, 0, 0, 2096095);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer9, 197064, 24);
                                float f26 = 12;
                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion6, 0.0f, 1, null), f26, 42, 0.0f, f26, 4, null);
                                Alignment.Vertical c17 = Alignment.INSTANCE.c();
                                final LevelProgressModel levelProgressModel4 = LevelProgressModel.this;
                                RowKt.a(n3, null, c17, null, null, ComposableLambdaKt.composableLambda(composer9, -629877292, true, new Function3<com.tencent.ntcompose.foundation.layout.n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt.LoveWallLevelProgressView.1.1.4
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.n nVar3, Composer composer10, Integer num3) {
                                        int i19;
                                        com.tencent.ntcompose.foundation.layout.n nVar4 = nVar3;
                                        Composer composer11 = composer10;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i19 = (composer11.changed(nVar4) ? 4 : 2) | intValue3;
                                        } else {
                                            i19 = intValue3;
                                        }
                                        if ((i19 & 91) == 18 && composer11.getSkipping()) {
                                            composer11.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-629877292, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressView.<anonymous>.<anonymous>.<anonymous> (LoveWallLevelProgressView.kt:177)");
                                            }
                                            i.Companion companion7 = i.INSTANCE;
                                            i f27 = ComposeLayoutPropUpdaterKt.f(companion7, 0.0f, 1, null);
                                            a aVar = a.f339245a;
                                            a.e b16 = aVar.b();
                                            final LevelProgressModel levelProgressModel5 = LevelProgressModel.this;
                                            ColumnKt.a(f27, b16, null, null, ComposableLambdaKt.composableLambda(composer11, 868070219, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt.LoveWallLevelProgressView.1.1.4.1
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer12, Integer num4) {
                                                    Composer composer13 = composer12;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer13.getSkipping()) {
                                                        composer13.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(868070219, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallLevelProgressView.kt:181)");
                                                        }
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Lv.");
                                                        m3.append(LevelProgressModel.this.treeProgress.getValue().f395448i);
                                                        TextKt.a(m3.toString(), null, null, null, null, null, null, new n("DINPro-Bold"), null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_primary"), Float.valueOf(13), bp3.c.INSTANCE.a(), null, null, null, null, null, null, null, null, null, null, null, 16376, null), null, null, null, null, null, false, composer13, n.f339436b << 21, 0, k.f28903n, 133169022);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer11, 24648, 12);
                                            float f28 = 4;
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion7, f28), composer11, 8, 0);
                                            LoveWallLevelProgressViewKt.LoveWallLProgressBar(ComposeLayoutPropUpdaterKt.f(nVar4.a(companion7, 1.0f), 0.0f, 1, null), LevelProgressModel.this.heightProgress, composer11, 8);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion7, f28), composer11, 8, 0);
                                            i f29 = ComposeLayoutPropUpdaterKt.f(companion7, 0.0f, 1, null);
                                            a.e b17 = aVar.b();
                                            final LevelProgressModel levelProgressModel6 = LevelProgressModel.this;
                                            ColumnKt.a(f29, b17, null, null, ComposableLambdaKt.composableLambda(composer11, 1253287682, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt.LoveWallLevelProgressView.1.1.4.2
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer12, Integer num4) {
                                                    Composer composer13 = composer12;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer13.getSkipping()) {
                                                        composer13.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1253287682, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallLevelProgressView.kt:201)");
                                                        }
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Lv.");
                                                        m3.append(LevelProgressModel.this.treeProgress.getValue().C);
                                                        TextKt.a(m3.toString(), null, null, null, null, null, null, new n("DINPro-Bold"), null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_primary"), Float.valueOf(13), bp3.c.INSTANCE.a(), null, null, null, null, null, null, null, null, null, null, null, 16376, null), null, null, null, null, null, false, composer13, n.f339436b << 21, 0, k.f28903n, 133169022);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer11, 24648, 12);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion7, 12), composer11, 8, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer9, 196616, 26);
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
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt$LoveWallLevelProgressView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallLevelProgressViewKt.LoveWallLevelProgressView(i.this, levelProgressModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
