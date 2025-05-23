package com.tencent.minibox.dynamic.api;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/minibox/dynamic/api/IDynamicApiManagerFactory;", "", "createApiManager", "Lcom/tencent/minibox/dynamic/api/IDynamicApiManager;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface IDynamicApiManagerFactory {
    @NotNull
    IDynamicApiManager createApiManager();
}
