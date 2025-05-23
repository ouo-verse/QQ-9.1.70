package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.QQAvatarViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleStatus;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleTriangleDirection;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.CardShowState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.GuildState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.ManualState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import e25.ai;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import uo3.c;
import yo3.Offset;
import zo3.Shadow;
import zo3.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallContributionInfoKt {
    public static final void LoveWallContributionAvatar(final String str, final Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        final int i17;
        Composer startRestartGroup = composer.startRestartGroup(643295594);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i18 = i16 & 2;
        if (i18 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i17 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i18 != 0) {
                function0 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(643295594, i17, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionAvatar (LoveWallContributionInfo.kt:285)");
            }
            BoxKt.a(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 52.0f), c.b()), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -714873948, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionAvatar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.traceEventStart(-714873948, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionAvatar.<anonymous> (LoveWallContributionInfo.kt:286)");
                        }
                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                        String str2 = "";
                        if (!Intrinsics.areEqual(str, com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n().q("uin", ""))) {
                            str2 = "em_qz_opponent_profile_picture";
                        }
                        i elementVR = ModifierExtKt.elementVR(h16, str2, IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                        final Function0<Unit> function02 = function0;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(function02);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionAvatar$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    Function0<Unit> function03 = function02;
                                    if (function03 != null) {
                                        function03.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        QQAvatarViewKt.QQAvatarView(ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null), null, str, composer3, ((i17 << 6) & 896) | 8, 2);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionAvatar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallContributionInfoKt.LoveWallContributionAvatar(str, function0, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallContributionInfo(final i iVar, final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-49898537);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-49898537, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfo (LoveWallContributionInfo.kt:68)");
        }
        BoxKt.a(iVar, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1599791633, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionInfo$1

            /* compiled from: P */
            @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionInfo$1$2", f = "LoveWallContributionInfo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionInfo$1$2, reason: invalid class name */
            /* loaded from: classes37.dex */
            public final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public final /* synthetic */ MutableState<Boolean> $enlarge;
                public final /* synthetic */ Animatable<Float> $scaleAnimation;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(Animatable<Float> animatable, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$scaleAnimation = animatable;
                    this.$enlarge = mutableState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$scaleAnimation, this.$enlarge, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    ResultKt.throwOnFailure(obj);
                    Animatable<Float> animatable = this.$scaleAnimation;
                    Float boxFloat = Boxing.boxFloat(this.$enlarge.getValue().booleanValue() ? 1.05f : 0.95f);
                    m d16 = com.tencent.ntcompose.animation.b.d(1000, 0, null, null, 14, null);
                    final MutableState<Boolean> mutableState = this.$enlarge;
                    Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Float f16) {
                            f16.floatValue();
                            mutableState.setValue(Boolean.valueOf(!r2.getValue().booleanValue()));
                            return Unit.INSTANCE;
                        }
                    }, false, 8, null);
                    return Unit.INSTANCE;
                }
            }

            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:40:0x02a3  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0312  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                MutableState mutableState;
                i.Companion companion;
                h.Companion companion2;
                Composer composer3;
                char c16;
                String sb5;
                Continuation continuation;
                b bVar2 = bVar;
                Composer composer4 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer4.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1599791633, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfo.<anonymous> (LoveWallContributionInfo.kt:74)");
                    }
                    LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                    composer4.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer4.rememberedValue();
                    Composer.Companion companion3 = Composer.INSTANCE;
                    if (rememberedValue == companion3.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LoveWallContributionInfoViewModel(loveWallHomepageViewModel2), null, 2, null);
                        composer4.updateRememberedValue(rememberedValue);
                    }
                    composer4.endReplaceableGroup();
                    final MutableState mutableState2 = (MutableState) rememberedValue;
                    i.Companion companion4 = i.INSTANCE;
                    i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null), 111), 0.0f, 28, 0.0f, 0.0f, 13, null), c.a(16.0f));
                    float f16 = 1;
                    h.Companion companion5 = h.INSTANCE;
                    i e16 = ModifiersKt.e(ModifiersKt.h(q16, f16, companion5.m(), null, 4, null), Direction.TO_BOTTOM, new j(new h(4291424595L), 0.0f), new j(new h(4294967295L), 0.4009f));
                    final LoveWallHomepageViewModel loveWallHomepageViewModel3 = LoveWallHomepageViewModel.this;
                    BoxKt.a(e16, null, null, ComposableLambdaKt.composableLambda(composer4, -758033717, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionInfo$1.1

                        /* compiled from: P */
                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionInfo$1$1$1", f = "LoveWallContributionInfo.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionInfo$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes37.dex */
                        public final class C45851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            public final /* synthetic */ LoveWallHomepageViewModel $homepageViewModel;
                            public final /* synthetic */ MutableState<LoveWallContributionInfoViewModel> $viewModel;
                            public int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C45851(LoveWallHomepageViewModel loveWallHomepageViewModel, MutableState<LoveWallContributionInfoViewModel> mutableState, Continuation<? super C45851> continuation) {
                                super(2, continuation);
                                this.$homepageViewModel = loveWallHomepageViewModel;
                                this.$viewModel = mutableState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C45851(this.$homepageViewModel, this.$viewModel, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C45851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i3 = this.label;
                                if (i3 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    final LoveWallHomepageViewModel loveWallHomepageViewModel = this.$homepageViewModel;
                                    Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<List<? extends ai>>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final List<? extends ai> invoke() {
                                            List<? extends ai> list;
                                            list = CollectionsKt___CollectionsKt.toList(LoveWallHomepageViewModel.this.userWaterList);
                                            return list;
                                        }
                                    });
                                    final MutableState<LoveWallContributionInfoViewModel> mutableState = this.$viewModel;
                                    FlowCollector<List<? extends ai>> flowCollector = new FlowCollector<List<? extends ai>>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.1.2
                                        @Override // kotlinx.coroutines.flow.FlowCollector
                                        public final Object emit(List<? extends ai> list, Continuation continuation) {
                                            List<? extends ai> list2 = list;
                                            LoveWallContributionInfoViewModel value = mutableState.getValue();
                                            value.getClass();
                                            if (list2.size() >= 2) {
                                                value.leftUserWater.setValue(list2.get(0));
                                                value.rightUserWater.setValue(list2.get(1));
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    this.label = 1;
                                    if (snapshotFlow.collect(flowCollector, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer5, Integer num2) {
                            int i17;
                            b bVar4 = bVar3;
                            Composer composer6 = composer5;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i17 = (composer6.changed(bVar4) ? 4 : 2) | intValue2;
                            } else {
                                i17 = intValue2;
                            }
                            if ((i17 & 91) == 18 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-758033717, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfo.<anonymous>.<anonymous> (LoveWallContributionInfo.kt:86)");
                                }
                                LoveWallHomepageViewModel loveWallHomepageViewModel4 = LoveWallHomepageViewModel.this;
                                EffectsKt.LaunchedEffect(loveWallHomepageViewModel4.userWaterList, new C45851(loveWallHomepageViewModel4, mutableState2, null), composer6, 64);
                                i.Companion companion6 = i.INSTANCE;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.p(bVar4.a(ComposeLayoutPropUpdaterKt.v(companion6, 148.0f, 22.0f), Alignment.BottomCenter), 0.0f, -15.0f, 1, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_O6fcfWIvK4R.png", null, null, null, null, null, null, null, null, null, null, composer6, 262144, 6, 0, 2096095);
                                i m3 = ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.h(companion6, 0.0f, 1, null), 37.0f, 39.0f, 37.0f, 20.0f);
                                final MutableState<LoveWallContributionInfoViewModel> mutableState3 = mutableState2;
                                final LoveWallHomepageViewModel loveWallHomepageViewModel5 = LoveWallHomepageViewModel.this;
                                BoxKt.a(m3, null, null, ComposableLambdaKt.composableLambda(composer6, 1933807109, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar5, Composer composer7, Integer num3) {
                                        int i18;
                                        b bVar6 = bVar5;
                                        Composer composer8 = composer7;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i18 = (composer8.changed(bVar6) ? 4 : 2) | intValue3;
                                        } else {
                                            i18 = intValue3;
                                        }
                                        if ((i18 & 91) == 18 && composer8.getSkipping()) {
                                            composer8.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1933807109, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfo.<anonymous>.<anonymous>.<anonymous> (LoveWallContributionInfo.kt:101)");
                                            }
                                            i.Companion companion7 = i.INSTANCE;
                                            i f17 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.i(companion7, 0.5f), 0.0f, 1, null);
                                            final MutableState<LoveWallContributionInfoViewModel> mutableState4 = mutableState3;
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel6 = loveWallHomepageViewModel5;
                                            BoxKt.a(f17, null, null, ComposableLambdaKt.composableLambda(composer8, -525126721, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar7, Composer composer9, Integer num4) {
                                                    Composer composer10 = composer9;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer10.getSkipping()) {
                                                        composer10.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-525126721, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfo.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallContributionInfo.kt:103)");
                                                        }
                                                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                                        a.d c17 = a.f339245a.c();
                                                        Alignment.Vertical c18 = Alignment.INSTANCE.c();
                                                        final MutableState<LoveWallContributionInfoViewModel> mutableState5 = mutableState4;
                                                        final LoveWallHomepageViewModel loveWallHomepageViewModel7 = loveWallHomepageViewModel6;
                                                        RowKt.a(h16, c17, c18, null, null, ComposableLambdaKt.composableLambda(composer10, 1107017821, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.2.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar, Composer composer11, Integer num5) {
                                                                Composer composer12 = composer11;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer12.getSkipping()) {
                                                                    composer12.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1107017821, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfo.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallContributionInfo.kt:107)");
                                                                    }
                                                                    long j3 = mutableState5.getValue().leftUserWater.getValue().f395457e;
                                                                    final LoveWallHomepageViewModel loveWallHomepageViewModel8 = loveWallHomepageViewModel7;
                                                                    LoveWallContributionInfoKt.LoveWallContributionText(j3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.2.1.1.1
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            LoveWallHomepageViewModel.this.cardShowState.setValue(CardShowState.CONTRIBUTION_CARD);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, composer12, 0);
                                                                    i.Companion companion8 = i.INSTANCE;
                                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion8, 12), composer12, 8, 0);
                                                                    String valueOf = String.valueOf(mutableState5.getValue().leftUserWater.getValue().f395456d);
                                                                    final MutableState<LoveWallContributionInfoViewModel> mutableState6 = mutableState5;
                                                                    final LoveWallHomepageViewModel loveWallHomepageViewModel9 = loveWallHomepageViewModel7;
                                                                    LoveWallContributionInfoKt.LoveWallContributionAvatar(valueOf, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.2.1.1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            if (Intrinsics.areEqual(String.valueOf(mutableState6.getValue().leftUserWater.getValue().f395456d), loveWallHomepageViewModel9.pageData.peerUin)) {
                                                                                mutableState6.getValue().showRemindBubble.setValue(Boolean.TRUE);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, composer12, 0, 0);
                                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion8, 14), composer12, 8, 0);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer10, 196680, 24);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer8, 3080, 6);
                                            i a16 = bVar6.a(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.i(companion7, 0.5f), 0.0f, 1, null), Alignment.TopEnd);
                                            final MutableState<LoveWallContributionInfoViewModel> mutableState5 = mutableState3;
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel7 = loveWallHomepageViewModel5;
                                            BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer8, 1135554664, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar7, Composer composer9, Integer num4) {
                                                    Composer composer10 = composer9;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer10.getSkipping()) {
                                                        composer10.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1135554664, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfo.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallContributionInfo.kt:121)");
                                                        }
                                                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                                        a.d g16 = a.f339245a.g();
                                                        Alignment.Vertical c17 = Alignment.INSTANCE.c();
                                                        final MutableState<LoveWallContributionInfoViewModel> mutableState6 = mutableState5;
                                                        final LoveWallHomepageViewModel loveWallHomepageViewModel8 = loveWallHomepageViewModel7;
                                                        RowKt.a(h16, g16, c17, null, null, ComposableLambdaKt.composableLambda(composer10, 1963396486, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.2.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar, Composer composer11, Integer num5) {
                                                                Composer composer12 = composer11;
                                                                int intValue5 = num5.intValue();
                                                                if ((intValue5 & 81) == 16 && composer12.getSkipping()) {
                                                                    composer12.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1963396486, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfo.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallContributionInfo.kt:125)");
                                                                    }
                                                                    i.Companion companion8 = i.INSTANCE;
                                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion8, 14), composer12, 8, 0);
                                                                    String valueOf = String.valueOf(mutableState6.getValue().rightUserWater.getValue().f395456d);
                                                                    final MutableState<LoveWallContributionInfoViewModel> mutableState7 = mutableState6;
                                                                    final LoveWallHomepageViewModel loveWallHomepageViewModel9 = loveWallHomepageViewModel8;
                                                                    LoveWallContributionInfoKt.LoveWallContributionAvatar(valueOf, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.2.2.1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            if (Intrinsics.areEqual(String.valueOf(mutableState7.getValue().rightUserWater.getValue().f395456d), loveWallHomepageViewModel9.pageData.peerUin)) {
                                                                                mutableState7.getValue().showRemindBubble.setValue(Boolean.TRUE);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, composer12, 0, 0);
                                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion8, 12), composer12, 8, 0);
                                                                    long j3 = mutableState6.getValue().rightUserWater.getValue().f395457e;
                                                                    final LoveWallHomepageViewModel loveWallHomepageViewModel10 = loveWallHomepageViewModel8;
                                                                    LoveWallContributionInfoKt.LoveWallContributionText(j3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.2.2.1.2
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            LoveWallHomepageViewModel.this.cardShowState.setValue(CardShowState.CONTRIBUTION_CARD);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }, composer12, 0);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer10, 196680, 24);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer8, 3080, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer6, 3080, 6);
                                i elementVR = ModifierExtKt.elementVR(bVar4.a(ComposeLayoutPropUpdaterKt.u(companion6, 34.66f), Alignment.TopEnd), "em_qz_contribute_value_module", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                                final LoveWallHomepageViewModel loveWallHomepageViewModel6 = LoveWallHomepageViewModel.this;
                                BoxKt.a(ViewEventPropUpdaterKt.d(elementVR, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        LoveWallHomepageViewModel.this.cardShowState.setValue(CardShowState.CONTRIBUTION_CARD);
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null), null, null, ComposableSingletons$LoveWallContributionInfoKt.f103lambda1, composer6, 3080, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer4, 3080, 6);
                    composer4.startReplaceableGroup(-685523193);
                    if (LoveWallHomepageViewModel.this.guildState.getValue() != GuildState.WATERING_GUILD) {
                        composer4.startReplaceableGroup(-492369756);
                        Object rememberedValue2 = composer4.rememberedValue();
                        if (rememberedValue2 == companion3.getEmpty()) {
                            rememberedValue2 = new Animatable(Float.valueOf(1.0f));
                            composer4.updateRememberedValue(rememberedValue2);
                        }
                        composer4.endReplaceableGroup();
                        final Animatable animatable = (Animatable) rememberedValue2;
                        composer4.startReplaceableGroup(-685522994);
                        if (LoveWallHomepageViewModel.this.allWaterTaskComplete.getValue().booleanValue()) {
                            c16 = 2;
                        } else {
                            composer4.startReplaceableGroup(-492369756);
                            Object rememberedValue3 = composer4.rememberedValue();
                            if (rememberedValue3 == companion3.getEmpty()) {
                                continuation = null;
                                c16 = 2;
                                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                                composer4.updateRememberedValue(rememberedValue3);
                            } else {
                                continuation = null;
                                c16 = 2;
                            }
                            composer4.endReplaceableGroup();
                            MutableState mutableState3 = (MutableState) rememberedValue3;
                            EffectsKt.LaunchedEffect(mutableState3.getValue(), animatable, new AnonymousClass2(animatable, mutableState3, continuation), composer4, (Animatable.f339143c << 3) | 512);
                        }
                        composer4.endReplaceableGroup();
                        i v3 = ComposeLayoutPropUpdaterKt.v(companion4, 210, 56);
                        Alignment alignment = Alignment.TopCenter;
                        i elementVR = ModifierExtKt.elementVR(ModifiersKt.u(bVar2.a(v3, alignment), new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionInfo$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                d dVar2 = dVar;
                                dVar2.n(animatable.f());
                                dVar2.o(animatable.f());
                                return Unit.INSTANCE;
                            }
                        }), "em_qz_watering_button", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                        if (LoveWallHomepageViewModel.this.allWaterTaskComplete.getValue().booleanValue()) {
                            sb5 = "\u517b\u6210\u624b\u518c";
                        } else {
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u53ef\u6d47\u6c34");
                            m3.append(LoveWallHomepageViewModel.this.collectWaterWeight.getValue().longValue());
                            m3.append('g');
                            sb5 = m3.toString();
                        }
                        LoveWallButtonConfig loveWallButtonConfig = new LoveWallButtonConfig(sb5);
                        final LoveWallHomepageViewModel loveWallHomepageViewModel4 = LoveWallHomepageViewModel.this;
                        LoveWallButtonKt.LoveWallButton(elementVR, loveWallButtonConfig, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionInfo$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                if (LoveWallHomepageViewModel.this.allWaterTaskComplete.getValue().booleanValue()) {
                                    LoveWallHomepageViewModel.this.manualState.setValue(ManualState.GROWTH_MANUAL);
                                } else if (LoveWallHomepageViewModel.this.collectWaterWeight.getValue().longValue() == 0) {
                                    final LoveWallHomepageViewModel loveWallHomepageViewModel5 = LoveWallHomepageViewModel.this;
                                    loveWallHomepageViewModel5.unfoldAllWaterBubbles.setValue(Boolean.TRUE);
                                    TimerKt.c(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$showAllWaterBubble$1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            LoveWallHomepageViewModel.this.unfoldAllWaterBubbles.setValue(Boolean.FALSE);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    final LoveWallHomepageViewModel loveWallHomepageViewModel6 = LoveWallHomepageViewModel.this;
                                    loveWallHomepageViewModel6.requestWatering(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt.LoveWallContributionInfo.1.4.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            LoveWallHomepageViewModel.this.collectWaterWeight.setValue(0L);
                                            LoveWallHomepageViewModel.this.updateWaterTaskState();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    LoveWallContributionInfoViewModel value = mutableState2.getValue();
                                    String wateringBtnClickRecordKey = value.wateringBtnClickRecordKey();
                                    com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                    if (!Intrinsics.areEqual(((CacheModule) cVar.g().acquireModule("HRCacheModule")).getItem(wateringBtnClickRecordKey), value.getCurrentDate())) {
                                        ((CacheModule) cVar.g().acquireModule("HRCacheModule")).setItem(value.wateringBtnClickRecordKey(), value.getCurrentDate());
                                        value.showRemindBubble.setValue(Boolean.TRUE);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }, composer4, 8);
                        if (LoveWallHomepageViewModel.this.allWaterTaskComplete.getValue().booleanValue()) {
                            mutableState = mutableState2;
                            companion2 = companion5;
                            companion = companion4;
                            composer3 = composer4;
                            TextKt.a("\u4eca\u65e5\u83b7\u5f97\u6c34\u6ef4\u5df2\u8fbe\u4e0a\u9650", bVar2.a(ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.v(companion4, 120, 17), 0.0f, -25, 1, null), alignment), null, companion5.m(), Float.valueOf(12.0f), null, null, null, null, null, com.tencent.ntcompose.material.ai.f(com.tencent.ntcompose.material.ai.INSTANCE.a()), null, null, null, null, new Shadow(companion5.a(0.35f), new Offset(0, f16), 2.0f), null, null, null, null, null, null, null, null, null, null, false, composer3, 28742, 0, 0, 134183908);
                            composer3.endReplaceableGroup();
                            if (((LoveWallContributionInfoViewModel) mutableState.getValue()).showRemindBubble.getValue().booleanValue()) {
                                LoveWallContributionInfoKt.LoveWallRemindWateringBubble(ModifiersKt.L(ComposeLayoutPropUpdaterKt.p(bVar2.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 186, 39), 0.0f, 15, 0.0f, 0.0f, 13, null), Alignment.TopCenter), Intrinsics.areEqual(String.valueOf(((LoveWallContributionInfoViewModel) mutableState.getValue()).leftUserWater.getValue().f395456d), LoveWallHomepageViewModel.this.pageData.peerUin) ? -40 : 40, 0.0f, 2, null), 0.0f, 2, 6.0f, companion2.a(0.1f)), (LoveWallContributionInfoViewModel) mutableState.getValue(), composer3, 72);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }
                    mutableState = mutableState2;
                    companion = companion4;
                    companion2 = companion5;
                    composer3 = composer4;
                    composer3.endReplaceableGroup();
                    if (((LoveWallContributionInfoViewModel) mutableState.getValue()).showRemindBubble.getValue().booleanValue()) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionInfo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallContributionInfoKt.LoveWallContributionInfo(i.this, loveWallHomepageViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallContributionText(final long j3, final Function0<Unit> function0, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-737233357);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(j3) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-737233357, i16, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionText (LoveWallContributionInfo.kt:239)");
            }
            i elementVR = ModifierExtKt.elementVR(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 52.0f), "em_qz_contribute_value_module", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionText$1$1
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
            ColumnKt.a(ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null), a.f339245a.h(), Alignment.Horizontal.CenterHorizontally, null, ComposableLambdaKt.composableLambda(startRestartGroup, -208265444, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionText$2
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
                            ComposerKt.traceEventStart(-208265444, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionText.<anonymous> (LoveWallContributionInfo.kt:248)");
                        }
                        TextKt.a("\u8d21\u732e\u503c", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_secondary"), Float.valueOf(12), bp3.c.INSTANCE.e(), null, null, null, null, null, com.tencent.ntcompose.material.ai.f(com.tencent.ntcompose.material.ai.INSTANCE.a()), Float.valueOf(17), null, null, null, null, 15608, null), null, null, null, null, null, false, composer3, 6, 0, k.f28903n, 133169150);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 4), composer3, 8, 0);
                        a.e e16 = a.f339245a.e();
                        Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                        final long j16 = j3;
                        RowKt.a(null, e16, vertical, null, null, ComposableLambdaKt.composableLambda(composer3, 852035002, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionText$2.1
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
                                        ComposerKt.traceEventStart(852035002, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionText.<anonymous>.<anonymous> (LoveWallContributionInfo.kt:263)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_wXTvw5SAqep.png", null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262150, 0, 0, 2097118);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 2), composer5, 8, 0);
                                    TextKt.a(GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(new StringBuilder(), j16, 'g'), null, null, null, null, null, null, new com.tencent.ntcompose.material.n("DINPro-Bold"), null, null, null, null, null, null, null, null, null, null, null, null, new k(h.INSTANCE.b(), Float.valueOf(18), bp3.c.INSTANCE.h(), null, null, null, null, null, com.tencent.ntcompose.material.ai.f(com.tencent.ntcompose.material.ai.INSTANCE.a()), Float.valueOf(25), null, null, null, null, 15608, null), null, null, null, null, null, false, composer5, com.tencent.ntcompose.material.n.f339436b << 21, 0, k.f28903n, 133169022);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 197056, 25);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 25032, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallContributionText$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallContributionInfoKt.LoveWallContributionText(j3, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallRemindWateringBubble(final i iVar, final LoveWallContributionInfoViewModel loveWallContributionInfoViewModel, Composer composer, final int i3) {
        e25.b bVar;
        String str;
        String str2;
        Composer startRestartGroup = composer.startRestartGroup(-1441187035);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1441187035, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallRemindWateringBubble (LoveWallContributionInfo.kt:299)");
        }
        float f16 = 186;
        e25.a aVar = loveWallContributionInfoViewModel.rightUserWater.getValue().f395458f;
        String str3 = (aVar == null || (str2 = aVar.f395424f) == null) ? "" : str2;
        BubbleTriangleDirection bubbleTriangleDirection = BubbleTriangleDirection.DOWN_CENTER;
        BubbleStatus bubbleStatus = BubbleStatus.UNFOLD;
        e25.a aVar2 = loveWallContributionInfoViewModel.rightUserWater.getValue().f395458f;
        BubbleConfig bubbleConfig = new BubbleConfig(f16, null, null, str3, bubbleTriangleDirection, bubbleStatus, (aVar2 == null || (bVar = aVar2.f395425h) == null || (str = bVar.f395469e) == null) ? "" : str, 58110);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new BubbleViewModel(bubbleConfig), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Animatable(Float.valueOf(0.0f));
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState2 = (MutableState) rememberedValue3;
        if (!((Boolean) mutableState2.getValue()).booleanValue()) {
            startRestartGroup.startReplaceableGroup(-834158558);
            EffectsKt.LaunchedEffect(animatable, new LoveWallContributionInfoKt$LoveWallRemindWateringBubble$1(animatable, mutableState2, null), startRestartGroup, Animatable.f339143c | 64);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-834158242);
            EffectsKt.LaunchedEffect(animatable, new LoveWallContributionInfoKt$LoveWallRemindWateringBubble$2(animatable, loveWallContributionInfoViewModel, null), startRestartGroup, Animatable.f339143c | 64);
            startRestartGroup.endReplaceableGroup();
        }
        LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView(ModifiersKt.D(iVar, ((Number) animatable.f()).floatValue()), (BubbleViewModel) mutableState.getValue(), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallRemindWateringBubble$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                LoveWallContributionInfoViewModel.this.showRemindBubble.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallRemindWateringBubble$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                LoveWallHomepageViewModel.requestShare$default(LoveWallContributionInfoViewModel.this.homepageViewModel, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoViewModel$remindWatering$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Mqq.INSTANCE.getUi().getClass();
                        QQKuiklyPlatformApi.Companion.qqToast("\u5df2\u9080\u8bf7\u5bf9\u65b9\u6765\u6d47\u6c34", QToastMode.Success);
                        return Unit.INSTANCE;
                    }
                });
                LoveWallContributionInfoViewModel.this.showRemindBubble.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            }
        }, startRestartGroup, 72, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallRemindWateringBubble$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallContributionInfoKt.LoveWallRemindWateringBubble(i.this, loveWallContributionInfoViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
