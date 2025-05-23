package com.tencent.mobileqq.guild.message.lastmsg.api.impl;

import com.tencent.mobileqq.qqguildsdk.data.GProAbstractUpdateData;
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
/* loaded from: classes14.dex */
public /* synthetic */ class GuildLastMsgAdapter$abstractMsgUpdateFlow$1 extends AdaptedFunctionReference implements Function2<GProAbstractUpdateData, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildLastMsgAdapter$abstractMsgUpdateFlow$1(Object obj) {
        super(2, obj, GuildLastMsgAdapter.class, "excuteAbstractUpdateData", "excuteAbstractUpdateData(Lcom/tencent/mobileqq/qqguildsdk/data/GProAbstractUpdateData;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@Nullable GProAbstractUpdateData gProAbstractUpdateData, @NotNull Continuation<? super Unit> continuation) {
        Object e16;
        e16 = GuildLastMsgAdapter.e((GuildLastMsgAdapter) this.receiver, gProAbstractUpdateData, continuation);
        return e16;
    }
}
