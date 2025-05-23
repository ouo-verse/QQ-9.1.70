package com.tencent.ecommerce.base.permission.api;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/base/permission/api/PermissionListener;", "", "onAllGranted", "", "onDenied", "result", "", "", "", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface PermissionListener {
    void onAllGranted();

    void onDenied(@NotNull Map<String, Boolean> result);
}
