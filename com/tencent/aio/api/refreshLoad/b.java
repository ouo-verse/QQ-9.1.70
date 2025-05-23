package com.tencent.aio.api.refreshLoad;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/api/refreshLoad/b;", "", "", "enable", "", "H", "", "preloadNum", "D", "E", "Lcom/tencent/aio/api/refreshLoad/a;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "y", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface b {
    @Deprecated(message = "\u5e9f\u5f03")
    void D(int preloadNum);

    @Deprecated(message = "\u5e9f\u5f03")
    void E(int preloadNum);

    void H(boolean enable);

    void y(@NotNull com.tencent.aio.api.refreshLoad.a strategy);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        @Deprecated(message = "\u5e9f\u5f03")
        public static void a(@NotNull b bVar, int i3) {
        }

        @Deprecated(message = "\u5e9f\u5f03")
        public static void b(@NotNull b bVar, int i3) {
        }
    }
}
