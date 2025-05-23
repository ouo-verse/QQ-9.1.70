package com.tencent.ecommerce.base.network.api;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J<\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/network/api/IECSender;", "", "sendPackage", "", "service", "", "method", "data", "", "codingType", "ext", "", "callback", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "sendQQPackage", "cmd", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECSender {
    int sendPackage(@NotNull String service, @NotNull String method, @Nullable byte[] data, int codingType, @Nullable Map<Object, ? extends Object> ext, @Nullable IECSendPackageCallback callback);

    int sendQQPackage(@NotNull String cmd, @Nullable byte[] data, @Nullable Map<Object, ? extends Object> ext, @Nullable IECSendPackageCallback callback);
}
