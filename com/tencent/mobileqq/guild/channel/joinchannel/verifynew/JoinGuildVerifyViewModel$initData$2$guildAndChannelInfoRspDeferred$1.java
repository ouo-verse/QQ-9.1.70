package com.tencent.mobileqq.guild.channel.joinchannel.verifynew;

import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/mainframe/util/GuildMainFrameUtils$a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyViewModel$initData$2$guildAndChannelInfoRspDeferred$1", f = "JoinGuildVerifyViewModel.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class JoinGuildVerifyViewModel$initData$2$guildAndChannelInfoRspDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GuildMainFrameUtils.GuildAndChannelInfoRsp>, Object> {
    final /* synthetic */ JumpGuildParam $jumpGuildParam;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinGuildVerifyViewModel$initData$2$guildAndChannelInfoRspDeferred$1(JumpGuildParam jumpGuildParam, Continuation<? super JoinGuildVerifyViewModel$initData$2$guildAndChannelInfoRspDeferred$1> continuation) {
        super(2, continuation);
        this.$jumpGuildParam = jumpGuildParam;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new JoinGuildVerifyViewModel$initData$2$guildAndChannelInfoRspDeferred$1(this.$jumpGuildParam, continuation);
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
            GuildMainFrameUtils guildMainFrameUtils = GuildMainFrameUtils.f227682a;
            String str = this.$jumpGuildParam.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            this.label = 1;
            obj = GuildMainFrameUtils.h(guildMainFrameUtils, str, null, 0, null, this, 14, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super GuildMainFrameUtils.GuildAndChannelInfoRsp> continuation) {
        return ((JoinGuildVerifyViewModel$initData$2$guildAndChannelInfoRspDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
