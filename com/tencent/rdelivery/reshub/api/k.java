package com.tencent.rdelivery.reshub.api;

import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/k;", "", "Lcom/tencent/rdelivery/reshub/api/a;", "appInfo", "", "b", "", "Ljz3/e;", Constants.Configs.CONFIGS, "", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public interface k {
    void a(@NotNull a appInfo, @NotNull Map<String, jz3.e> configs);

    @NotNull
    String b(@NotNull a appInfo);
}
