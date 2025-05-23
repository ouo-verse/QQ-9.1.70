package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\n\u001a\u00020\u0007*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0015\u0010\f\u001a\u00020\u0007*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "", "a", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;)I", "expandState", "b", "panelState", "", "c", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;)Z", "isExpandOrExpanding", "d", "isFoldedOrFolding", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {
    public static final int a(@NotNull e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        return eVar.getState() & 7;
    }

    public static final int b(@NotNull e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        return eVar.getState() & (-8);
    }

    public static final boolean c(@NotNull e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        if (a(eVar) == 3 || a(eVar) == 1) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        if (a(eVar) != 2 && eVar.getState() != 0) {
            return false;
        }
        return true;
    }
}
