package com.tencent.mobileqq.guild.message.unread.api.impl;

import com.tencent.mobileqq.qqguildsdk.data.GProUnreadCntUpData;
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
public /* synthetic */ class GuildUnreadCntMsgAdapter$unreadTransToLastMsgFlow$1 extends AdaptedFunctionReference implements Function2<GProUnreadCntUpData, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildUnreadCntMsgAdapter$unreadTransToLastMsgFlow$1(Object obj) {
        super(2, obj, GuildUnreadCntMsgAdapter.class, "unreadCntUpDataTrans", "unreadCntUpDataTrans(Lcom/tencent/mobileqq/qqguildsdk/data/GProUnreadCntUpData;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull GProUnreadCntUpData gProUnreadCntUpData, @NotNull Continuation<? super Unit> continuation) {
        Object y16;
        y16 = GuildUnreadCntMsgAdapter.y((GuildUnreadCntMsgAdapter) this.receiver, gProUnreadCntUpData, continuation);
        return y16;
    }
}
