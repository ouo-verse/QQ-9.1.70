package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.square.SquareAvatarScene;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.square.SquareAvatarScene$NormalState$bootAsync$1", f = "SquareAvatarScene.kt", i = {0}, l = {366, 369}, m = "invokeSuspend", n = {"bootSpan"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class SquareAvatarScene$NormalState$bootAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.zplan.zplantracing.c $spanContext;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SquareAvatarScene.NormalState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAvatarScene$NormalState$bootAsync$1(SquareAvatarScene.NormalState normalState, com.tencent.zplan.zplantracing.c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = normalState;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SquareAvatarScene$NormalState$bootAsync$1(this.this$0, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SquareAvatarScene$NormalState$bootAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AtomicBoolean atomicBoolean;
        final com.tencent.zplan.zplantracing.b startSpan;
        FilamentUrlTemplate filamentUrlTemplate;
        Continuation intercepted;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            startSpan = (com.tencent.zplan.zplantracing.b) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            atomicBoolean = this.this$0.booted;
            if (atomicBoolean.get()) {
                return Unit.INSTANCE;
            }
            startSpan = ZPlanSpanFactory.INSTANCE.startSpan("boot", this.$spanContext);
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            com.tencent.zplan.zplantracing.c cVar = this.$spanContext;
            filamentUrlTemplate = this.this$0.urlTemplate;
            this.L$0 = startSpan;
            this.label = 1;
            obj = zPlanAvatarResourceHelper.F(cVar, filamentUrlTemplate, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        final BootResourceModel bootResourceModel = (BootResourceModel) obj;
        SquareAvatarScene.NormalState normalState = this.this$0;
        String indirectLightPath = bootResourceModel.getIndirectLightPath();
        if (indirectLightPath == null) {
            indirectLightPath = "";
        }
        normalState.indirectLightPath = indirectLightPath;
        this.L$0 = startSpan;
        this.L$1 = bootResourceModel;
        this.L$2 = this;
        this.label = 2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        SquareAvatarScene.this.k().d("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareAvatarScene$NormalState$bootAsync$1$invokeSuspend$$inlined$suspendCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                AtomicBoolean atomicBoolean2;
                FilamentViewerV2305 viewer = SquareAvatarScene.this.getViewer();
                if (viewer != null) {
                    BootResourceModel bootResourceModel2 = bootResourceModel;
                    FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
                    z16 = viewer.boot(bootResourceModel2, "", false, false, false, filamentFeatureUtil.K(), filamentFeatureUtil.j());
                } else {
                    z16 = false;
                }
                if (!z16) {
                    com.tencent.zplan.zplantracing.b bVar = startSpan;
                    if (bVar != null) {
                        bVar.a("boot fail");
                    }
                    SquareAvatarScene.this.o(201024, "boot fail");
                    Continuation.this.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                    return;
                }
                com.tencent.zplan.zplantracing.b bVar2 = startSpan;
                if (bVar2 != null) {
                    bVar2.b();
                }
                atomicBoolean2 = this.this$0.booted;
                atomicBoolean2.set(true);
                Continuation.this.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended2) {
            DebugProbes.probeCoroutineSuspended(this);
        }
        if (orThrow == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
