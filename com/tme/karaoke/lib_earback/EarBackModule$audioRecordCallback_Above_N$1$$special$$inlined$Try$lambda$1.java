package com.tme.karaoke.lib_earback;

import android.widget.Toast;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@DebugMetadata(c = "com.tme.karaoke.lib_earback.EarBackModule$audioRecordCallback_Above_N$1$onRecordingConfigChanged$1$2$2$1", f = "EarBackModule.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes27.dex */
public final class EarBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef $audioRecordConfigurationName$inlined;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @DebugMetadata(c = "com.tme.karaoke.lib_earback.EarBackModule$audioRecordCallback_Above_N$1$onRecordingConfigChanged$1$2$2$1$1", f = "EarBackModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tme.karaoke.lib_earback.EarBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1$1, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(completion);
            anonymousClass1.p$ = (CoroutineScope) obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Toast.makeText(com.tme.karaoke.lib_earback.base.b.a(), "\u5e94\u7528:" + ((String) EarBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1.this.$audioRecordConfigurationName$inlined.element) + "\u6b63\u5728\u4f7f\u7528\u5f55\u97f3", 1).show();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1(Continuation continuation, Ref.ObjectRef objectRef) {
        super(2, continuation);
        this.$audioRecordConfigurationName$inlined = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        EarBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1 earBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1 = new EarBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1(completion, this.$audioRecordConfigurationName$inlined);
        earBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1.p$ = (CoroutineScope) obj;
        return earBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EarBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
