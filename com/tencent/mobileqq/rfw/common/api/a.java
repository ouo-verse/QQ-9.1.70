package com.tencent.mobileqq.rfw.common.api;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/rfw/common/api/a;", "", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getConfig", "", "updateConfig", "rfw-common-config-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {
    @NotNull
    String getConfig(@NotNull String key, @NotNull String defaultValue);

    void updateConfig(@NotNull String key, @NotNull Object defaultValue);
}
