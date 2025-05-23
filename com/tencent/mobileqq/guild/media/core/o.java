package com.tencent.mobileqq.guild.media.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/EnterChannelState;", "", "d", "a", "c", "Lcom/tencent/mobileqq/guild/media/core/n;", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class o {
    public static final boolean a(@NotNull EnterChannelState enterChannelState) {
        Intrinsics.checkNotNullParameter(enterChannelState, "<this>");
        if (enterChannelState == EnterChannelState.ENTER_ING) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull n nVar) {
        Intrinsics.checkNotNullParameter(nVar, "<this>");
        EnterChannelState value = nVar.k().getValue();
        Intrinsics.checkNotNull(value);
        EnterChannelState it = value;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!a(it) && !d(it)) {
            return false;
        }
        return true;
    }

    public static final boolean c(@NotNull EnterChannelState enterChannelState) {
        Intrinsics.checkNotNullParameter(enterChannelState, "<this>");
        if (enterChannelState == EnterChannelState.IDLE) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull EnterChannelState enterChannelState) {
        Intrinsics.checkNotNullParameter(enterChannelState, "<this>");
        if (enterChannelState == EnterChannelState.ENTER_SUC) {
            return true;
        }
        return false;
    }
}
