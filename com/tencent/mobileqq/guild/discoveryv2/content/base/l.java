package com.tencent.mobileqq.guild.discoveryv2.content.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/l;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface l extends h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static boolean a(@NotNull l lVar, @NotNull h newItem) {
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return lVar.getClass().isInstance(newItem);
        }

        public static long b(@NotNull l lVar) {
            return lVar.getClass().hashCode();
        }
    }
}
