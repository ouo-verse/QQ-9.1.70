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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil$getCommonPSkeyCookie$2", f = "GuildFeedDetailHttpUtil.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedDetailHttpUtil$getCommonPSkeyCookie$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $host;
    final /* synthetic */ Ref.ObjectRef<String> $pskey;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedDetailHttpUtil$getCommonPSkeyCookie$2(String str, Ref.ObjectRef<String> objectRef, Continuation<? super GuildFeedDetailHttpUtil$getCommonPSkeyCookie$2> continuation) {
        super(2, continuation);
        this.$host = str;
        this.$pskey = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedDetailHttpUtil$getCommonPSkeyCookie$2(this.$host, this.$pskey, continuation);
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
            String str = this.$host;
            this.label = 1;
            obj = guildFeedDetailHttpUtil.g(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        com.tencent.qqnt.msg.api.c cVar = (com.tencent.qqnt.msg.api.c) obj;
        if (cVar.d()) {
            this.$pskey.element = cVar.a();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedDetailHttpUtil$getCommonPSkeyCookie$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
