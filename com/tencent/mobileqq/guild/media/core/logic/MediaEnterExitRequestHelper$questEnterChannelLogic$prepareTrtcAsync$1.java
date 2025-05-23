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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/media/core/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$questEnterChannelLogic$prepareTrtcAsync$1", f = "MediaEnterExitRequestHelper.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaEnterExitRequestHelper$questEnterChannelLogic$prepareTrtcAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CommonRsp>, Object> {
    int label;
    final /* synthetic */ MediaEnterExitRequestHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEnterExitRequestHelper$questEnterChannelLogic$prepareTrtcAsync$1(MediaEnterExitRequestHelper mediaEnterExitRequestHelper, Continuation<? super MediaEnterExitRequestHelper$questEnterChannelLogic$prepareTrtcAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaEnterExitRequestHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaEnterExitRequestHelper$questEnterChannelLogic$prepareTrtcAsync$1(this.this$0, continuation);
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
            MediaEnterExitRequestHelper mediaEnterExitRequestHelper = this.this$0;
            this.label = 1;
            obj = mediaEnterExitRequestHelper.X0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return (CommonRsp) obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CommonRsp> continuation) {
        return ((MediaEnterExitRequestHelper$questEnterChannelLogic$prepareTrtcAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
