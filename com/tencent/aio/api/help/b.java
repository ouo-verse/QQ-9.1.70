package com.tencent.aio.api.help;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/api/help/b;", "", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", h.F, "i", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface b {
    void h(@NotNull com.tencent.aio.main.businesshelper.b param);

    void i();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @NotNull com.tencent.aio.main.businesshelper.b param) {
            Intrinsics.checkNotNullParameter(param, "param");
        }

        public static void b(@NotNull b bVar) {
        }
    }
}
