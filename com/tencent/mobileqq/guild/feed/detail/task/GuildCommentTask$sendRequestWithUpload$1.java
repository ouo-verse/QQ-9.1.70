package com.tencent.mobileqq.guild.feed.detail.task;

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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.detail.task.GuildCommentTask$sendRequestWithUpload$1", f = "GuildCommentTask.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildCommentTask$sendRequestWithUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GuildCommentTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCommentTask$sendRequestWithUpload$1(GuildCommentTask guildCommentTask, Continuation<? super GuildCommentTask$sendRequestWithUpload$1> continuation) {
        super(2, continuation);
        this.this$0 = guildCommentTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildCommentTask$sendRequestWithUpload$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        in1.c m3;
        GuildCommentTask guildCommentTask;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                guildCommentTask = (GuildCommentTask) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GuildCommentTask guildCommentTask2 = this.this$0;
            m3 = guildCommentTask2.m();
            this.L$0 = guildCommentTask2;
            this.label = 1;
            Object k3 = m3.k(true, this);
            if (k3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            guildCommentTask = guildCommentTask2;
            obj = k3;
        }
        guildCommentTask.v((com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.h) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildCommentTask$sendRequestWithUpload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
