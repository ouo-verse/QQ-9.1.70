package com.tencent.mobileqq.icgame.push;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000*j\u0010\n\"2\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u000322\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003\u00a8\u0006\u000b"}, d2 = {"Lbz0/c;", "", "a", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msgInfo", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMsgExtInfo$MsgSpeed;", "speed", "", "PushMsgCallback", "ic-game-sdk-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull bz0.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        return "msgId=" + cVar.f29441b + ", msgSeq=" + cVar.f29440a + ", msgType=" + cVar.f29444e + ", uid=" + cVar.f29445f + ", msgOrderId=" + cVar.f29446g;
    }
}
