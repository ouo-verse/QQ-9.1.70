package com.tencent.guild.aio.util;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContact;", "peer", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/msg/api/c;", "", "a", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class NTServiceApiKt {
    @NotNull
    public static final Flow<com.tencent.qqnt.msg.api.c<Long>> a(@NotNull GProContact peer) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        return FlowKt.callbackFlow(new NTServiceApiKt$getFirstUnreadMsgSeq$1(peer, null));
    }
}
