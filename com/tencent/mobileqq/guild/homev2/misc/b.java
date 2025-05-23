package com.tencent.mobileqq.guild.homev2.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/a;", "", "initGuildId", "Lkotlin/properties/ReadWriteProperty;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    @NotNull
    public static final ReadWriteProperty<a, String> a(@NotNull a aVar, @NotNull String initGuildId) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(initGuildId, "initGuildId");
        return new c(initGuildId);
    }

    public static /* synthetic */ ReadWriteProperty b(a aVar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        return a(aVar, str);
    }
}
