package com.tencent.mobileqq.troop.findTroop.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/findTroop/util/b;", "", "event", "", "R2", "Lcom/tencent/mobileqq/troop/findTroop/util/c;", "F5", "", "af", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        @NotNull
        public static String a(@NotNull b bVar) {
            return String.valueOf(bVar.hashCode());
        }
    }

    @Nullable
    c F5();

    void R2(@NotNull Object event);

    @NotNull
    String af();
}
