package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import java.util.List;
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
/* synthetic */ class GuildMsgListRepo$registerNotification$4 extends AdaptedFunctionReference implements Function2<List<? extends com.tencent.aio.data.msglist.a>, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildMsgListRepo$registerNotification$4(Object obj) {
        super(2, obj, GuildMsgListRepo.class, "onMsgInfoListAdd", "onMsgInfoListAdd(Ljava/util/List;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull List<? extends com.tencent.aio.data.msglist.a> list, @NotNull Continuation<? super Unit> continuation) {
        Object f16;
        f16 = GuildMsgListRepo.f1((GuildMsgListRepo) this.receiver, list, continuation);
        return f16;
    }
}
