package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultMatchFriendViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultShareViewKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShootResultViewKt {
    public static final void ShootResultView(final NBPMoodGroupViewModel nBPMoodGroupViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1594739849);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1594739849, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ShootResultView (ShootResultView.kt:15)");
        }
        BoxKt.a(ModifiersKt.T(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 4), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -17979453, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ShootResultViewKt$ShootResultView$1

            /* compiled from: P */
            @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ShootResultViewKt$ShootResultView$1$1", f = "ShootResultView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ShootResultViewKt$ShootResultView$1$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public final /* synthetic */ NBPMoodGroupViewModel $vm;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(NBPMoodGroupViewModel nBPMoodGroupViewModel, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$vm = nBPMoodGroupViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$vm, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    ResultKt.throwOnFailure(obj);
                    this.$vm.getResultVM().isResultViewPopable = this.$vm.isResultViewPopable.getValue().booleanValue();
                    return Unit.INSTANCE;
                }
            }

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
                        ComposerKt.traceEventStart(-17979453, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ShootResultView.<anonymous> (ShootResultView.kt:20)");
                    }
                    EffectsKt.LaunchedEffect(NBPMoodGroupViewModel.this.isResultViewPopable.getValue(), new AnonymousClass1(NBPMoodGroupViewModel.this, null), composer3, 64);
                    composer3.startReplaceableGroup(289676607);
                    if (NBPMoodGroupViewModel.this.getResultVM().showDefaultResult.getValue().booleanValue()) {
                        ShootResultDefaultViewKt.ShootResultDefaultView(NBPMoodGroupViewModel.this.getResultVM(), composer3, 8);
                    }
                    composer3.endReplaceableGroup();
                    int ordinal = NBPMoodGroupViewModel.this.getResultVM().resultViewState.getValue().ordinal();
                    if (ordinal == 1) {
                        composer3.startReplaceableGroup(289676925);
                        LoadingViewKt.LoadingView(composer3, 0);
                        composer3.endReplaceableGroup();
                    } else if (ordinal == 2) {
                        composer3.startReplaceableGroup(289676805);
                        final NBPMoodGroupViewModel nBPMoodGroupViewModel2 = NBPMoodGroupViewModel.this;
                        ErrorViewKt.ErrorView(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ShootResultViewKt$ShootResultView$1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPMoodGroupViewModel.this.getResultVM().loadPageData();
                                return Unit.INSTANCE;
                            }
                        }, composer3, 0);
                        composer3.endReplaceableGroup();
                    } else if (ordinal == 4) {
                        composer3.startReplaceableGroup(289677024);
                        ShootResultMatchFriendViewKt.ShootResultMatchFriendView(NBPMoodGroupViewModel.this.getResultVM(), composer3, 8);
                        composer3.endReplaceableGroup();
                    } else if (ordinal != 5) {
                        composer3.startReplaceableGroup(289677235);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(289677149);
                        ShootResultShareViewKt.ShootResultShareView(NBPMoodGroupViewModel.this.getResultVM(), composer3, 8);
                        composer3.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ShootResultViewKt$ShootResultView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootResultViewKt.ShootResultView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
