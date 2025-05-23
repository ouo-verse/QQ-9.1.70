package com.tencent.guild.aio.factory;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public /* synthetic */ class GuildFirstScreenTask$onCreate$1 extends AdaptedFunctionReference implements Function2<List<? extends com.tencent.aio.data.msglist.a>, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFirstScreenTask$onCreate$1(Object obj) {
        super(2, obj, GuildFirstScreenTask.class, "onMsgReceive", "onMsgReceive(Ljava/util/List;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull List<? extends com.tencent.aio.data.msglist.a> list, @NotNull Continuation<? super Unit> continuation) {
        Object p16;
        p16 = GuildFirstScreenTask.p((GuildFirstScreenTask) this.receiver, list, continuation);
        return p16;
    }
}
