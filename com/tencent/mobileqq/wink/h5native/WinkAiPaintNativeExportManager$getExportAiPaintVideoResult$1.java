package com.tencent.mobileqq.wink.h5native;

import com.tencent.luggage.wxa.rf.f;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$getExportAiPaintVideoResult$1", f = "WinkAiPaintNativeExportManager.kt", i = {1}, l = {f.CTRL_INDEX, 870}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkAiPaintNativeExportManager$getExportAiPaintVideoResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IQQWinkEditorResAPI.AiPaintResponseListener $listener;
    final /* synthetic */ GetExportAiPaintVideoResultRequest $request;
    final /* synthetic */ SafeReq $safeReq;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiPaintNativeExportManager$getExportAiPaintVideoResult$1(SafeReq safeReq, IQQWinkEditorResAPI.AiPaintResponseListener aiPaintResponseListener, GetExportAiPaintVideoResultRequest getExportAiPaintVideoResultRequest, Continuation<? super WinkAiPaintNativeExportManager$getExportAiPaintVideoResult$1> continuation) {
        super(2, continuation);
        this.$safeReq = safeReq;
        this.$listener = aiPaintResponseListener;
        this.$request = getExportAiPaintVideoResultRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiPaintNativeExportManager$getExportAiPaintVideoResult$1(this.$safeReq, this.$listener, this.$request, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x006d A[Catch: all -> 0x00aa, TryCatch #0 {all -> 0x00aa, blocks: (B:7:0x005f, B:9:0x006d, B:11:0x0073, B:12:0x00a2, B:17:0x0086), top: B:6:0x005f }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Job job;
        Mutex mutex;
        IQQWinkEditorResAPI.AiPaintResponseListener aiPaintResponseListener;
        SafeReq safeReq;
        GetExportAiPaintVideoResultRequest getExportAiPaintVideoResultRequest;
        String traceID;
        String str;
        GetExportAiPaintVideoResultResponse getExportAiPaintVideoResultResponse;
        GetExportAiPaintVideoResultResponse getExportAiPaintVideoResultResponse2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    getExportAiPaintVideoResultRequest = (GetExportAiPaintVideoResultRequest) this.L$3;
                    aiPaintResponseListener = (IQQWinkEditorResAPI.AiPaintResponseListener) this.L$2;
                    safeReq = (SafeReq) this.L$1;
                    mutex = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    try {
                        traceID = safeReq.getTraceID();
                        str = WinkAiPaintNativeExportManager.currentTraceID;
                        if (Intrinsics.areEqual(traceID, str)) {
                            getExportAiPaintVideoResultResponse = WinkAiPaintNativeExportManager.currentExportResult;
                            if (getExportAiPaintVideoResultResponse != null) {
                                String callback = getExportAiPaintVideoResultRequest.getCallback();
                                getExportAiPaintVideoResultResponse2 = WinkAiPaintNativeExportManager.currentExportResult;
                                Intrinsics.checkNotNull(getExportAiPaintVideoResultResponse2);
                                aiPaintResponseListener.onResponse(callback, getExportAiPaintVideoResultResponse2.toJsonStr());
                                Unit unit = Unit.INSTANCE;
                                mutex.unlock(null);
                                return Unit.INSTANCE;
                            }
                        }
                        aiPaintResponseListener.onResponse(getExportAiPaintVideoResultRequest.getCallback(), new GetExportAiPaintVideoResultResponse(8, "traceID inconsistent", null, null, null, 28, null).toJsonStr());
                        Unit unit2 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th5) {
                        mutex.unlock(null);
                        throw th5;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            job = WinkAiPaintNativeExportManager.currentExportJob;
            if (job != null) {
                this.label = 1;
                if (job.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        mutex = WinkAiPaintNativeExportManager.syncMutex;
        SafeReq safeReq2 = this.$safeReq;
        aiPaintResponseListener = this.$listener;
        GetExportAiPaintVideoResultRequest getExportAiPaintVideoResultRequest2 = this.$request;
        this.L$0 = mutex;
        this.L$1 = safeReq2;
        this.L$2 = aiPaintResponseListener;
        this.L$3 = getExportAiPaintVideoResultRequest2;
        this.label = 2;
        if (mutex.lock(null, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        safeReq = safeReq2;
        getExportAiPaintVideoResultRequest = getExportAiPaintVideoResultRequest2;
        traceID = safeReq.getTraceID();
        str = WinkAiPaintNativeExportManager.currentTraceID;
        if (Intrinsics.areEqual(traceID, str)) {
        }
        aiPaintResponseListener.onResponse(getExportAiPaintVideoResultRequest.getCallback(), new GetExportAiPaintVideoResultResponse(8, "traceID inconsistent", null, null, null, 28, null).toJsonStr());
        Unit unit22 = Unit.INSTANCE;
        mutex.unlock(null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAiPaintNativeExportManager$getExportAiPaintVideoResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
