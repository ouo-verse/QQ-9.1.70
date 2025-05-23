package com.tencent.mobileqq.wink.api.impl;

import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.api.impl.ClipServiceBinder$mediaScan$1", f = "ClipServiceBinder.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes21.dex */
final class ClipServiceBinder$mediaScan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.wink.api.a $callback;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClipServiceBinder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipServiceBinder$mediaScan$1(ClipServiceBinder clipServiceBinder, com.tencent.mobileqq.wink.api.a aVar, Continuation<? super ClipServiceBinder$mediaScan$1> continuation) {
        super(2, continuation);
        this.this$0 = clipServiceBinder;
        this.$callback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ClipServiceBinder$mediaScan$1 clipServiceBinder$mediaScan$1 = new ClipServiceBinder$mediaScan$1(this.this$0, this.$callback, continuation);
        clipServiceBinder$mediaScan$1.L$0 = obj;
        return clipServiceBinder$mediaScan$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:5:0x0039). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        ClipServiceBinder$mediaScan$1 clipServiceBinder$mediaScan$1;
        long j3;
        long j16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                clipServiceBinder$mediaScan$1 = this;
                j3 = clipServiceBinder$mediaScan$1.this$0.lastOfferTime;
                w53.b.a("ClipServiceBinder", "check timeout, lastOfferTime: " + j3 + ", currentTime: " + System.currentTimeMillis());
                ArrayList currentBuffer = (ArrayList) clipServiceBinder$mediaScan$1.this$0.resultBuffer.get();
                Intrinsics.checkNotNullExpressionValue(currentBuffer, "currentBuffer");
                if (!currentBuffer.isEmpty()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j16 = clipServiceBinder$mediaScan$1.this$0.lastOfferTime;
                    if (currentTimeMillis - j16 >= 10000) {
                        clipServiceBinder$mediaScan$1.this$0.z1(clipServiceBinder$mediaScan$1.$callback);
                    }
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    clipServiceBinder$mediaScan$1.L$0 = coroutineScope;
                    clipServiceBinder$mediaScan$1.label = 1;
                    if (DelayKt.delay(10000L, clipServiceBinder$mediaScan$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = clipServiceBinder$mediaScan$1.this$0.lastOfferTime;
                    w53.b.a("ClipServiceBinder", "check timeout, lastOfferTime: " + j3 + ", currentTime: " + System.currentTimeMillis());
                    ArrayList currentBuffer2 = (ArrayList) clipServiceBinder$mediaScan$1.this$0.resultBuffer.get();
                    Intrinsics.checkNotNullExpressionValue(currentBuffer2, "currentBuffer");
                    if (!currentBuffer2.isEmpty()) {
                    }
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            clipServiceBinder$mediaScan$1 = this;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ClipServiceBinder$mediaScan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
