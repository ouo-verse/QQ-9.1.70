package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class GuildMsgListRepo$registerNotification$1 extends AdaptedFunctionReference implements Function2<com.tencent.aio.data.msglist.a, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildMsgListRepo$registerNotification$1(Object obj) {
        super(2, obj, GuildMsgListRepo.class, "onAddLocalSendMsg", "onAddLocalSendMsg(Lcom/tencent/aio/data/msglist/IMsgItem;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.aio.data.msglist.a aVar, @NotNull Continuation<? super Unit> continuation) {
        Object e16;
        e16 = GuildMsgListRepo.e1((GuildMsgListRepo) this.receiver, aVar, continuation);
        return e16;
    }
}
