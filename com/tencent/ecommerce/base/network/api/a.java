package com.tencent.ecommerce.base.network.api;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JJ\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J:\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/base/network/api/a;", "Lcom/tencent/ecommerce/base/network/api/IECSender;", "", "service", "method", "", "data", "", "codingType", "", "", "ext", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "callback", "sendPackage", "cmd", "sendQQPackage", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECSender {
    @Override // com.tencent.ecommerce.base.network.api.IECSender
    public int sendPackage(@NotNull String service, @NotNull String method, @Nullable byte[] data, int codingType, @Nullable Map<Object, ? extends Object> ext, @Nullable IECSendPackageCallback callback) {
        throw new IllegalArgumentException("IECSender not yet implemented");
    }

    @Override // com.tencent.ecommerce.base.network.api.IECSender
    public int sendQQPackage(@NotNull String cmd, @Nullable byte[] data, @Nullable Map<Object, ? extends Object> ext, @Nullable IECSendPackageCallback callback) {
        throw new IllegalArgumentException("IECSender not yet implemented");
    }
}
