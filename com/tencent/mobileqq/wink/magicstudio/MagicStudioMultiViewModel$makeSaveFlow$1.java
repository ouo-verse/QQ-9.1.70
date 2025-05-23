package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$makeSaveFlow$1", f = "MagicStudioMultiViewModel.kt", i = {}, l = {com.tencent.luggage.wxa.rf.d.CTRL_INDEX, 327}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioMultiViewModel$makeSaveFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GenerateInfo $generateInfo;
    final /* synthetic */ int $index;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel$makeSaveFlow$1$a", "Li83/g;", "", "onSuccess", "onFailed", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements i83.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f323680a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f323680a = cancellableContinuation;
        }

        @Override // i83.g
        public void onFailed() {
            CancellableContinuation<Boolean> cancellableContinuation = this.f323680a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }

        @Override // i83.g
        public void onSuccess() {
            CancellableContinuation<Boolean> cancellableContinuation = this.f323680a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioMultiViewModel$makeSaveFlow$1(GenerateInfo generateInfo, int i3, Continuation<? super MagicStudioMultiViewModel$makeSaveFlow$1> continuation) {
        super(2, continuation);
        this.$generateInfo = generateInfo;
        this.$index = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MagicStudioMultiViewModel$makeSaveFlow$1 magicStudioMultiViewModel$makeSaveFlow$1 = new MagicStudioMultiViewModel$makeSaveFlow$1(this.$generateInfo, this.$index, continuation);
        magicStudioMultiViewModel$makeSaveFlow$1.L$0 = obj;
        return magicStudioMultiViewModel$makeSaveFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        Continuation intercepted;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.L$1;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            GenerateInfo generateInfo = this.$generateInfo;
            int i16 = this.$index;
            this.L$0 = generateInfo;
            this.L$1 = flowCollector;
            this.I$0 = i16;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            if (generateInfo.getQrCodeImgPath().length() != 0) {
                z16 = false;
            }
            if (z16) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
            } else {
                MagicStudioDataSource.f323652a.C(i16, generateInfo.getQrCodeImgPath(), new a(cancellableContinuationImpl));
            }
            obj = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Boolean> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioMultiViewModel$makeSaveFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
