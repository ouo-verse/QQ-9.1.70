package com.tencent.mobileqq.guild.channellist;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/d;", "Lcom/tencent/mobileqq/guild/channellist/c;", "", "e", "", "d", "newItem", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends c {
    @Override // com.tencent.mobileqq.guild.channellist.c
    public boolean a(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return newItem instanceof d;
    }

    @Override // com.tencent.mobileqq.guild.channellist.c
    public long d() {
        return Objects.hash(Integer.valueOf(e()));
    }

    public int e() {
        return 3;
    }
}
