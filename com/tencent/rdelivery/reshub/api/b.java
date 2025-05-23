package com.tencent.rdelivery.reshub.api;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/b;", "", "", "isAllSuccess", "", "", "Lcom/tencent/rdelivery/reshub/api/g;", "Lcom/tencent/rdelivery/reshub/api/BatchResult;", "resMap", "Lcom/tencent/rdelivery/reshub/api/n;", "Lcom/tencent/rdelivery/reshub/api/BatchError;", "errorMap", "", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public interface b {
    void a(boolean isAllSuccess, @NotNull Map<String, ? extends g> resMap, @NotNull Map<String, ? extends n> errorMap);
}
