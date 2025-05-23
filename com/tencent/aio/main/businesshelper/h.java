package com.tencent.aio.main.businesshelper;

import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.g;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/e;", "Lcom/tencent/aio/main/businesshelper/g;", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface h extends e, g {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
        public static void a(@NotNull h hVar, @NotNull b param) {
            Intrinsics.checkNotNullParameter(param, "param");
            e.a.a(hVar, param);
        }

        @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
        public static void b(@NotNull h hVar) {
            e.a.b(hVar);
        }

        public static boolean c(@NotNull h hVar) {
            return g.a.a(hVar);
        }
    }
}
