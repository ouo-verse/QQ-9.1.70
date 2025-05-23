package com.tencent.mobileqq.guild.media.thirdapp.container.webview;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer$checkIfAttach$1$isAttach$1", f = "GuildMediaWebIPCServer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildMediaWebIPCServer$checkIfAttach$1$isAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $uniqueKey;
    int label;
    final /* synthetic */ GuildMediaWebIPCServer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaWebIPCServer$checkIfAttach$1$isAttach$1(GuildMediaWebIPCServer guildMediaWebIPCServer, String str, Continuation<? super GuildMediaWebIPCServer$checkIfAttach$1$isAttach$1> continuation) {
        super(2, continuation);
        this.this$0 = guildMediaWebIPCServer;
        this.$uniqueKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaWebIPCServer$checkIfAttach$1$isAttach$1(this.this$0, this.$uniqueKey, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean j3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            j3 = this.this$0.j(this.$uniqueKey);
            return Boxing.boxBoolean(j3);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((GuildMediaWebIPCServer$checkIfAttach$1$isAttach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
