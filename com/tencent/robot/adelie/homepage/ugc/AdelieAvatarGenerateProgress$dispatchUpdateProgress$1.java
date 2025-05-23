package com.tencent.robot.adelie.homepage.ugc;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateProgress$dispatchUpdateProgress$1", f = "AdelieAvatarGenerateProgress.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AdelieAvatarGenerateProgress$dispatchUpdateProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AdelieAvatarGenerateProgress this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieAvatarGenerateProgress$dispatchUpdateProgress$1(AdelieAvatarGenerateProgress adelieAvatarGenerateProgress, Continuation<? super AdelieAvatarGenerateProgress$dispatchUpdateProgress$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieAvatarGenerateProgress;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdelieAvatarGenerateProgress$dispatchUpdateProgress$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003f -> B:5:0x0042). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AdelieAvatarGenerateProgress$dispatchUpdateProgress$1 adelieAvatarGenerateProgress$dispatchUpdateProgress$1;
        AtomicInteger atomicInteger;
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        AtomicInteger atomicInteger2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                adelieAvatarGenerateProgress$dispatchUpdateProgress$1 = this;
                AdelieAvatarGenerateProgress adelieAvatarGenerateProgress = adelieAvatarGenerateProgress$dispatchUpdateProgress$1.this$0;
                atomicInteger2 = adelieAvatarGenerateProgress.mProgress;
                adelieAvatarGenerateProgress.i(atomicInteger2.get() + 1);
                atomicInteger = adelieAvatarGenerateProgress$dispatchUpdateProgress$1.this$0.mProgress;
                if (atomicInteger.get() < 99) {
                    atomicBoolean2 = adelieAvatarGenerateProgress$dispatchUpdateProgress$1.this$0.isUpdatingProgress;
                    if (atomicBoolean2.get()) {
                        adelieAvatarGenerateProgress$dispatchUpdateProgress$1.label = 1;
                        if (DelayKt.delay(80L, adelieAvatarGenerateProgress$dispatchUpdateProgress$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AdelieAvatarGenerateProgress adelieAvatarGenerateProgress2 = adelieAvatarGenerateProgress$dispatchUpdateProgress$1.this$0;
                        atomicInteger2 = adelieAvatarGenerateProgress2.mProgress;
                        adelieAvatarGenerateProgress2.i(atomicInteger2.get() + 1);
                        atomicInteger = adelieAvatarGenerateProgress$dispatchUpdateProgress$1.this$0.mProgress;
                        if (atomicInteger.get() < 99) {
                        }
                    }
                }
                atomicBoolean = adelieAvatarGenerateProgress$dispatchUpdateProgress$1.this$0.isUpdatingProgress;
                atomicBoolean.set(false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        adelieAvatarGenerateProgress$dispatchUpdateProgress$1 = this;
        atomicInteger = adelieAvatarGenerateProgress$dispatchUpdateProgress$1.this$0.mProgress;
        if (atomicInteger.get() < 99) {
        }
        atomicBoolean = adelieAvatarGenerateProgress$dispatchUpdateProgress$1.this$0.isUpdatingProgress;
        atomicBoolean.set(false);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdelieAvatarGenerateProgress$dispatchUpdateProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
