package com.tencent.hippykotlin.demo.pages.qq_intimate_space;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallToastViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallNavigationBarKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWateringFloatViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.GuildState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.ManualState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.SharePanelState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.ToastInfo;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.UserTreeState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallHomepageKt {
    public static final void LoveWallHomepageContent(final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1482321018);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1482321018, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageContent (LoveWallHomepage.kt:196)");
        }
        BoxKt.a(ModifierExtKt.pageVR(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), "pg_qz_love_tree_home", loveWallHomepageViewModel.getPageReportParams()), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -877630028, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt$LoveWallHomepageContent$1
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
                        ComposerKt.traceEventStart(-877630028, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageContent.<anonymous> (LoveWallHomepage.kt:201)");
                    }
                    composer3.startReplaceableGroup(-311677592);
                    UserTreeState value = LoveWallHomepageViewModel.this.userTreeState.getValue();
                    UserTreeState userTreeState = UserTreeState.HAS_TREE;
                    if (value == userTreeState || LoveWallHomepageViewModel.this.userTreeState.getValue() == UserTreeState.CREATED_TREE) {
                        LoveTreeContentViewKt.LoveTreeContentView(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), LoveWallHomepageViewModel.this, composer3, 72);
                    }
                    composer3.endReplaceableGroup();
                    i.Companion companion = i.INSTANCE;
                    i h16 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                    a.e e16 = a.f339245a.e();
                    Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                    final LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                    ColumnKt.a(h16, e16, horizontal, null, ComposableLambdaKt.composableLambda(composer3, 1682628573, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt$LoveWallHomepageContent$1.1
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
                                    ComposerKt.traceEventStart(1682628573, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageContent.<anonymous>.<anonymous> (LoveWallHomepage.kt:215)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                i j3 = ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null);
                                a aVar = a.f339245a;
                                a.k h17 = aVar.h();
                                Alignment.Horizontal horizontal2 = Alignment.Horizontal.CenterHorizontally;
                                final LoveWallHomepageViewModel loveWallHomepageViewModel3 = LoveWallHomepageViewModel.this;
                                ColumnKt.a(j3, h17, horizontal2, null, ComposableLambdaKt.composableLambda(composer5, -2057912442, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt.LoveWallHomepageContent.1.1.1

                                    /* compiled from: P */
                                    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt$LoveWallHomepageContent$1$1$1$5", f = "LoveWallHomepage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt$LoveWallHomepageContent$1$1$1$5, reason: invalid class name */
                                    /* loaded from: classes37.dex */
                                    public final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        public final /* synthetic */ MutableState<Boolean> $hideToast;
                                        public final /* synthetic */ Animatable<Float> $offsetAnimation;
                                        public final /* synthetic */ Animatable<Float> $opacityAnimation;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass5(Animatable<Float> animatable, Animatable<Float> animatable2, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass5> continuation) {
                                            super(2, continuation);
                                            this.$opacityAnimation = animatable;
                                            this.$offsetAnimation = animatable2;
                                            this.$hideToast = mutableState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass5(this.$opacityAnimation, this.$offsetAnimation, this.$hideToast, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            ResultKt.throwOnFailure(obj);
                                            Animatable<Float> animatable = this.$opacityAnimation;
                                            Float boxFloat = Boxing.boxFloat(1.0f);
                                            m d16 = com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null);
                                            final MutableState<Boolean> mutableState = this.$hideToast;
                                            Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt.LoveWallHomepageContent.1.1.1.5.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Float f16) {
                                                    f16.floatValue();
                                                    mutableState.setValue(Boolean.TRUE);
                                                    return Unit.INSTANCE;
                                                }
                                            }, false, 8, null);
                                            Animatable.b(this.$offsetAnimation, Boxing.boxFloat(0.0f), com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null), null, false, 12, null);
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    /* compiled from: P */
                                    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt$LoveWallHomepageContent$1$1$1$6", f = "LoveWallHomepage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt$LoveWallHomepageContent$1$1$1$6, reason: invalid class name */
                                    /* loaded from: classes37.dex */
                                    public final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        public final /* synthetic */ MutableState<Boolean> $hideToast;
                                        public final /* synthetic */ Animatable<Float> $offsetAnimation;
                                        public final /* synthetic */ Animatable<Float> $opacityAnimation;
                                        public final /* synthetic */ LoveWallHomepageViewModel $viewModel;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass6(Animatable<Float> animatable, Animatable<Float> animatable2, LoveWallHomepageViewModel loveWallHomepageViewModel, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass6> continuation) {
                                            super(2, continuation);
                                            this.$opacityAnimation = animatable;
                                            this.$offsetAnimation = animatable2;
                                            this.$viewModel = loveWallHomepageViewModel;
                                            this.$hideToast = mutableState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass6(this.$opacityAnimation, this.$offsetAnimation, this.$viewModel, this.$hideToast, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            ResultKt.throwOnFailure(obj);
                                            Animatable<Float> animatable = this.$opacityAnimation;
                                            Float boxFloat = Boxing.boxFloat(0.0f);
                                            m d16 = com.tencent.ntcompose.animation.b.d(300, 3000, null, null, 12, null);
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel = this.$viewModel;
                                            final MutableState<Boolean> mutableState = this.$hideToast;
                                            Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt.LoveWallHomepageContent.1.1.1.6.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Float f16) {
                                                    f16.floatValue();
                                                    LoveWallHomepageViewModel.this.showNextToast();
                                                    mutableState.setValue(Boolean.FALSE);
                                                    return Unit.INSTANCE;
                                                }
                                            }, false, 8, null);
                                            Animatable.b(this.$offsetAnimation, Boxing.boxFloat(-5.0f), com.tencent.ntcompose.animation.b.d(300, 3000, null, null, 12, null), null, false, 12, null);
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar2, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2057912442, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageContent.<anonymous>.<anonymous>.<anonymous> (LoveWallHomepage.kt:220)");
                                            }
                                            i.Companion companion3 = i.INSTANCE;
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion3, com.tencent.ntcompose.activity.b.a().getPageData().getStatusBarHeight()), composer7, 8, 0);
                                            i k3 = ComposeLayoutPropUpdaterKt.k(companion3, 44);
                                            C45591 c45591 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt.LoveWallHomepageContent.1.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Mqq.INSTANCE.getUi().popBack();
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel4 = LoveWallHomepageViewModel.this;
                                            Function1<ClickParams, Unit> function1 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt.LoveWallHomepageContent.1.1.1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    LoveWallHomepageViewModel.this.sharePanelState.setValue(SharePanelState.SHARE_HOMEPAGE);
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel5 = LoveWallHomepageViewModel.this;
                                            LoveWallNavigationBarKt.LoveWallNavigationBar(k3, false, false, false, c45591, function1, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt.LoveWallHomepageContent.1.1.1.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    LoveWallHomepageViewModel.this.manualState.setValue(ManualState.GROWTH_MANUAL);
                                                    return Unit.INSTANCE;
                                                }
                                            }, composer7, 24584, 14);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion3, 9), composer7, 8, 0);
                                            if (LoveWallHomepageViewModel.this.guildState.getValue() != GuildState.PLANTING_GUILD) {
                                                float f16 = com.tencent.ntcompose.activity.b.a().getPageData().m() < 350.0f ? 16.0f : 56.0f;
                                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 66), f16, 0.0f, f16, 0.0f, 10, null);
                                                final LoveWallHomepageViewModel loveWallHomepageViewModel6 = LoveWallHomepageViewModel.this;
                                                LoveWallLevelProgressViewKt.LoveWallLevelProgressView(ModifierExtKt.elementVR(ViewEventPropUpdaterKt.d(n3, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt.LoveWallHomepageContent.1.1.1.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        LoveWallHomepageViewModel.this.manualState.setValue(ManualState.GROWTH_MANUAL);
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 3, null), "em_qz_planting_handbook_entry", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams()), LoveWallHomepageViewModel.this.progressViewModel.getValue(), composer7, 72);
                                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion3, 16), composer7, 8, 0);
                                                if (LoveWallHomepageViewModel.this.currentToast.getValue() != null) {
                                                    composer7.startReplaceableGroup(-492369756);
                                                    Object rememberedValue = composer7.rememberedValue();
                                                    Composer.Companion companion4 = Composer.INSTANCE;
                                                    if (rememberedValue == companion4.getEmpty()) {
                                                        rememberedValue = new Animatable(Float.valueOf(0.0f));
                                                        composer7.updateRememberedValue(rememberedValue);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    Animatable animatable = (Animatable) rememberedValue;
                                                    composer7.startReplaceableGroup(-492369756);
                                                    Object rememberedValue2 = composer7.rememberedValue();
                                                    if (rememberedValue2 == companion4.getEmpty()) {
                                                        rememberedValue2 = new Animatable(Float.valueOf(-5.0f));
                                                        composer7.updateRememberedValue(rememberedValue2);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    Animatable animatable2 = (Animatable) rememberedValue2;
                                                    composer7.startReplaceableGroup(-492369756);
                                                    Object rememberedValue3 = composer7.rememberedValue();
                                                    if (rememberedValue3 == companion4.getEmpty()) {
                                                        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                                        composer7.updateRememberedValue(rememberedValue3);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    MutableState mutableState = (MutableState) rememberedValue3;
                                                    if (!((Boolean) mutableState.getValue()).booleanValue()) {
                                                        composer7.startReplaceableGroup(-655698943);
                                                        AnonymousClass5 anonymousClass5 = new AnonymousClass5(animatable, animatable2, mutableState, null);
                                                        int i16 = Animatable.f339143c;
                                                        EffectsKt.LaunchedEffect(animatable, animatable2, anonymousClass5, composer7, (i16 << 3) | i16 | 512);
                                                        composer7.endReplaceableGroup();
                                                    } else {
                                                        composer7.startReplaceableGroup(-655698183);
                                                        AnonymousClass6 anonymousClass6 = new AnonymousClass6(animatable, animatable2, LoveWallHomepageViewModel.this, mutableState, null);
                                                        int i17 = Animatable.f339143c;
                                                        EffectsKt.LaunchedEffect(animatable, animatable2, anonymousClass6, composer7, (i17 << 3) | i17 | 512);
                                                        composer7.endReplaceableGroup();
                                                    }
                                                    i p16 = ComposeLayoutPropUpdaterKt.p(ModifiersKt.D(companion3, ((Number) animatable.f()).floatValue()), 0.0f, ((Number) animatable2.f()).floatValue(), 1, null);
                                                    ToastInfo value2 = LoveWallHomepageViewModel.this.currentToast.getValue();
                                                    Intrinsics.checkNotNull(value2);
                                                    LoveWallToastViewKt.LoveWallToastView(p16, value2.text, composer7, 8);
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 25032, 8);
                                i j16 = ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null);
                                a.k a16 = aVar.a();
                                final LoveWallHomepageViewModel loveWallHomepageViewModel4 = LoveWallHomepageViewModel.this;
                                ColumnKt.a(j16, a16, horizontal2, null, ComposableLambdaKt.composableLambda(composer5, -1182285585, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt.LoveWallHomepageContent.1.1.2
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar2, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1182285585, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageContent.<anonymous>.<anonymous>.<anonymous> (LoveWallHomepage.kt:305)");
                                            }
                                            i.Companion companion3 = i.INSTANCE;
                                            float f16 = 16;
                                            LoveWallContributionInfoKt.LoveWallContributionInfo(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 168), f16, 0.0f, f16, 0.0f, 10, null), LoveWallHomepageViewModel.this, composer7, 72);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion3, 19), composer7, 8, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 25032, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 25032, 8);
                    LoveWallWateringFloatViewKt.LoveWallWateringFloatView(LoveWallHomepageViewModel.this, composer3, 8);
                    if (LoveWallHomepageViewModel.this.userTreeState.getValue() == userTreeState || LoveWallHomepageViewModel.this.userTreeState.getValue() == UserTreeState.CREATED_TREE) {
                        LoveWallWaterDropsFloatViewKt.LoveWallWaterDropsFloatView(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), LoveWallHomepageViewModel.this, composer3, 72);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepageKt$LoveWallHomepageContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallHomepageKt.LoveWallHomepageContent(LoveWallHomepageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
