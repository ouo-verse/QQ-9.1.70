package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleStatus;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleTriangleDirection;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.IntimateSpaceFilamentView;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.IntimateSpaceFilamentViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.PhotoBubble;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveTreeContentViewKt {
    public static final void LoveTreeContentView(final i iVar, final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1483625815);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1483625815, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentView (LoveTreeContentView.kt:40)");
        }
        BoxKt.a(iVar, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 624966673, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$1

            /* compiled from: P */
            @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$1$4", f = "LoveTreeContentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$1$4, reason: invalid class name */
            /* loaded from: classes37.dex */
            public final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public final /* synthetic */ Animatable<Float> $alphaAnimation;
                public final /* synthetic */ MutableState<String> $hideTimerRef;
                public final /* synthetic */ LoveWallHomepageViewModel $homepageViewModel;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass4(MutableState<String> mutableState, Animatable<Float> animatable, LoveWallHomepageViewModel loveWallHomepageViewModel, Continuation<? super AnonymousClass4> continuation) {
                    super(2, continuation);
                    this.$hideTimerRef = mutableState;
                    this.$alphaAnimation = animatable;
                    this.$homepageViewModel = loveWallHomepageViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass4(this.$hideTimerRef, this.$alphaAnimation, this.$homepageViewModel, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    ResultKt.throwOnFailure(obj);
                    String value = this.$hideTimerRef.getValue();
                    if (value != null) {
                        TimerKt.a(value);
                    }
                    this.$alphaAnimation.h(Boxing.boxFloat(0.0f));
                    Animatable<Float> animatable = this.$alphaAnimation;
                    Float boxFloat = Boxing.boxFloat(1.0f);
                    m d16 = com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null);
                    final MutableState<String> mutableState = this.$hideTimerRef;
                    final Animatable<Float> animatable2 = this.$alphaAnimation;
                    final LoveWallHomepageViewModel loveWallHomepageViewModel = this.$homepageViewModel;
                    Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt.LoveTreeContentView.1.4.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Float f16) {
                            f16.floatValue();
                            final MutableState<String> mutableState2 = mutableState;
                            final Animatable<Float> animatable3 = animatable2;
                            final LoveWallHomepageViewModel loveWallHomepageViewModel2 = loveWallHomepageViewModel;
                            mutableState2.setValue(TimerKt.c(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt.LoveTreeContentView.1.4.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    Animatable<Float> animatable4 = animatable3;
                                    Float valueOf = Float.valueOf(0.0f);
                                    m d17 = com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null);
                                    final MutableState<String> mutableState3 = mutableState2;
                                    final LoveWallHomepageViewModel loveWallHomepageViewModel3 = loveWallHomepageViewModel2;
                                    Animatable.b(animatable4, valueOf, d17, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt.LoveTreeContentView.1.4.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Float f17) {
                                            f17.floatValue();
                                            mutableState3.setValue(null);
                                            loveWallHomepageViewModel3.treeBubbleText.setValue(null);
                                            return Unit.INSTANCE;
                                        }
                                    }, false, 8, null);
                                    return Unit.INSTANCE;
                                }
                            }));
                            return Unit.INSTANCE;
                        }
                    }, false, 8, null);
                    return Unit.INSTANCE;
                }
            }

            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                String str;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(624966673, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentView.<anonymous> (LoveTreeContentView.kt:44)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i h16 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                    final LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                    Function2<IntimateSpaceFilamentView, aa<IntimateSpaceFilamentView>, Unit> function2 = new Function2<IntimateSpaceFilamentView, aa<IntimateSpaceFilamentView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(IntimateSpaceFilamentView intimateSpaceFilamentView, aa<IntimateSpaceFilamentView> aaVar) {
                            LoveWallHomepageViewModel.this.filamentViewRef = aaVar;
                            return Unit.INSTANCE;
                        }
                    };
                    final LoveWallHomepageViewModel loveWallHomepageViewModel3 = LoveWallHomepageViewModel.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$1.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            LoveWallHomepageViewModel loveWallHomepageViewModel4 = LoveWallHomepageViewModel.this;
                            loveWallHomepageViewModel4.getClass();
                            KLog.INSTANCE.i("LoveWallHomepage", "onFilamentMessageChannelReady");
                            loveWallHomepageViewModel4.filamentMessageChannelReady.setValue(Boolean.TRUE);
                            if (loveWallHomepageViewModel4.filamentSceneReady.getValue().booleanValue() && loveWallHomepageViewModel4.tree.getValue() != null) {
                                loveWallHomepageViewModel4.loadTree();
                                loveWallHomepageViewModel4.notifyTreeFreeState(1);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    final LoveWallHomepageViewModel loveWallHomepageViewModel4 = LoveWallHomepageViewModel.this;
                    IntimateSpaceFilamentViewKt.IntimateSpaceComposeFilamentView(h16, function2, function0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$1.3
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            LoveWallHomepageViewModel loveWallHomepageViewModel5 = LoveWallHomepageViewModel.this;
                            loveWallHomepageViewModel5.getClass();
                            KLog.INSTANCE.i("LoveWallHomepage", "onFilamentSceneReady");
                            loveWallHomepageViewModel5.filamentSceneReady.setValue(Boolean.TRUE);
                            if (loveWallHomepageViewModel5.filamentMessageChannelReady.getValue().booleanValue() && loveWallHomepageViewModel5.tree.getValue() != null) {
                                loveWallHomepageViewModel5.loadTree();
                                loveWallHomepageViewModel5.notifyTreeFreeState(1);
                            }
                            return Unit.INSTANCE;
                        }
                    }, composer3, 8, 0);
                    composer3.startReplaceableGroup(296980706);
                    if (LoveWallHomepageViewModel.this.treeBubbleText.getValue() != null) {
                        composer3.startReplaceableGroup(-492369756);
                        Object rememberedValue = composer3.rememberedValue();
                        Composer.Companion companion2 = Composer.INSTANCE;
                        if (rememberedValue == companion2.getEmpty()) {
                            rememberedValue = new Animatable(Float.valueOf(0.0f));
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        Animatable animatable = (Animatable) rememberedValue;
                        composer3.startReplaceableGroup(-492369756);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == companion2.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(LoveWallHomepageViewModel.this.treeBubbleText.getValue(), new AnonymousClass4((MutableState) rememberedValue2, animatable, LoveWallHomepageViewModel.this, null), composer3, 64);
                        i b16 = ModifiersKt.b(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.0f, 211, 0.0f, 0.0f, 13, null), ((Number) animatable.f()).floatValue());
                        a.e b17 = a.f339245a.b();
                        final LoveWallHomepageViewModel loveWallHomepageViewModel5 = LoveWallHomepageViewModel.this;
                        RowKt.a(b16, b17, null, null, null, ComposableLambdaKt.composableLambda(composer3, 168081268, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$1.5
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
                                        ComposerKt.traceEventStart(168081268, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentView.<anonymous>.<anonymous> (LoveTreeContentView.kt:86)");
                                    }
                                    i.Companion companion3 = i.INSTANCE;
                                    i w3 = ComposeLayoutPropUpdaterKt.w(companion3, 136);
                                    String value = LoveWallHomepageViewModel.this.treeBubbleText.getValue();
                                    Intrinsics.checkNotNull(value);
                                    LoveWallFeedBackBubbleViewKt.LoveWallFeedBackBubbleView(w3, value, null, composer5, 8, 4);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion3, 50), composer5, 8, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196680, 28);
                    }
                    composer3.endReplaceableGroup();
                    Iterator<PhotoBubble> it = LoveWallHomepageViewModel.this.photoBubbles.iterator();
                    while (it.hasNext()) {
                        final PhotoBubble next = it.next();
                        float f16 = 226;
                        e25.a aVar = next.bubbleTips;
                        String str2 = aVar.f395424f;
                        String str3 = aVar.f395423e;
                        BubbleTriangleDirection bubbleTriangleDirection = BubbleTriangleDirection.DOWN_CENTER;
                        BubbleStatus bubbleStatus = BubbleStatus.UNFOLD;
                        e25.b bVar2 = aVar.f395425h;
                        if (bVar2 == null || (str = bVar2.f395469e) == null) {
                            str = "\u53bb\u53d1\u8868";
                        }
                        BubbleConfig bubbleConfig = new BubbleConfig(f16, null, str3, str2, bubbleTriangleDirection, bubbleStatus, str, 57982);
                        composer3.startReplaceableGroup(-492369756);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new BubbleViewModel(bubbleConfig), null, 2, null);
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        float f17 = 39;
                        i v3 = ComposeLayoutPropUpdaterKt.v(i.INSTANCE, f16, f17);
                        Intrinsics.checkNotNull(next.point.f395428d);
                        float intValue2 = (r3.intValue() / PageDataExtKt.getDpScaleDensity(com.tencent.ntcompose.activity.b.a().getPageData())) - 113;
                        Intrinsics.checkNotNull(next.point.f395429e);
                        i L = ModifiersKt.L(ComposeLayoutPropUpdaterKt.o(v3, intValue2, (r6.intValue() / PageDataExtKt.getDpScaleDensity(com.tencent.ntcompose.activity.b.a().getPageData())) - f17), 0.0f, 2, 6.0f, h.INSTANCE.a(0.1f));
                        BubbleViewModel bubbleViewModel = (BubbleViewModel) ((MutableState) rememberedValue3).getValue();
                        final LoveWallHomepageViewModel loveWallHomepageViewModel6 = LoveWallHomepageViewModel.this;
                        Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$1.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                LoveWallHomepageViewModel.this.photoBubbles.remove(next);
                                return Unit.INSTANCE;
                            }
                        };
                        final LoveWallHomepageViewModel loveWallHomepageViewModel7 = LoveWallHomepageViewModel.this;
                        LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView(L, bubbleViewModel, function02, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$1.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                String str4;
                                LoveWallHomepageViewModel.this.photoBubbles.remove(next);
                                e25.b bVar3 = next.bubbleTips.f395425h;
                                if (bVar3 != null && (str4 = bVar3.f395470f) != null) {
                                    if (str4.length() > 0) {
                                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("click photo frame bubble, jumpUrl: ", str4, KLog.INSTANCE, "LoveWallHomepage");
                                        MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), str4);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }, composer3, 72, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveTreeContentViewKt$LoveTreeContentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveTreeContentViewKt.LoveTreeContentView(i.this, loveWallHomepageViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
