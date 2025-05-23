package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.core.CommonRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$enterTRTCRoom$1", f = "MediaEnterExitRequestHelper.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaEnterExitRequestHelper$enterTRTCRoom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.guild.media.core.b $callback;
    final /* synthetic */ j $params;
    final /* synthetic */ long $startTs;
    int label;
    final /* synthetic */ MediaEnterExitRequestHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEnterExitRequestHelper$enterTRTCRoom$1(MediaEnterExitRequestHelper mediaEnterExitRequestHelper, com.tencent.mobileqq.guild.media.core.b bVar, j jVar, long j3, Continuation<? super MediaEnterExitRequestHelper$enterTRTCRoom$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaEnterExitRequestHelper;
        this.$callback = bVar;
        this.$params = jVar;
        this.$startTs = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaEnterExitRequestHelper$enterTRTCRoom$1(this.this$0, this.$callback, this.$params, this.$startTs, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        EnterTrtcRoomReq I0;
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
            MediaEnterExitRequestHelper mediaEnterExitRequestHelper = this.this$0;
            j jVar = this.$params;
            long j3 = this.$startTs;
            I0 = mediaEnterExitRequestHelper.I0(jVar);
            this.label = 1;
            obj = mediaEnterExitRequestHelper.a1(I0, j3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.U0((CommonRsp) obj, this.$callback);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaEnterExitRequestHelper$enterTRTCRoom$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
