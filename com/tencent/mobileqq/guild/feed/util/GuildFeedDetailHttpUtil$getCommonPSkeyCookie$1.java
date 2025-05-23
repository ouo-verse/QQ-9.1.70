package com.tencent.mobileqq.guild.feed.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil$getCommonPSkeyCookie$1", f = "GuildFeedDetailHttpUtil.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedDetailHttpUtil$getCommonPSkeyCookie$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $a2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedDetailHttpUtil$getCommonPSkeyCookie$1(Ref.ObjectRef<String> objectRef, Continuation<? super GuildFeedDetailHttpUtil$getCommonPSkeyCookie$1> continuation) {
        super(2, continuation);
        this.$a2 = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedDetailHttpUtil$getCommonPSkeyCookie$1(this.$a2, continuation);
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.Object] */
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
            GuildFeedDetailHttpUtil guildFeedDetailHttpUtil = GuildFeedDetailHttpUtil.f223767a;
            this.label = 1;
            obj = guildFeedDetailHttpUtil.f(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        com.tencent.qqnt.msg.api.c cVar = (com.tencent.qqnt.msg.api.c) obj;
        if (cVar.d()) {
            this.$a2.element = cVar.a();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedDetailHttpUtil$getCommonPSkeyCookie$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
