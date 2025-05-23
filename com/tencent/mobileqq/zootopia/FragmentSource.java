package com.tencent.mobileqq.zootopia;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/FragmentSource;", "Ljava/io/Serializable;", "current", "Lcom/tencent/mobileqq/zootopia/Source;", "from", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "(Lcom/tencent/mobileqq/zootopia/Source;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "getCurrent", "()Lcom/tencent/mobileqq/zootopia/Source;", "getFrom", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class FragmentSource implements Serializable {

    @NotNull
    private final Source current;

    @NotNull
    private final ZootopiaSource from;

    public FragmentSource(@NotNull Source current, @NotNull ZootopiaSource from) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(from, "from");
        this.current = current;
        this.from = from;
    }

    @NotNull
    public final Source getCurrent() {
        return this.current;
    }

    @NotNull
    public final ZootopiaSource getFrom() {
        return this.from;
    }
}
