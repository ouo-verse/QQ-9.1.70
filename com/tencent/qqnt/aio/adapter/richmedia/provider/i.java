package com.tencent.qqnt.aio.adapter.richmedia.provider;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "", "", "path", "", CoverDBCacheData.URLS, "domain", "", "b", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "", "result", "a", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface i {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static void a(@NotNull i iVar, int i3, @NotNull String path) {
            Intrinsics.checkNotNullParameter(path, "path");
        }
    }

    void a(int result, @NotNull String path);

    void b(@NotNull String path, @NotNull String[] urls, @NotNull String domain);
}
