package com.tencent.state.config;

import com.tencent.state.api.INetworkDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/config/NetworkConfig;", "", "()V", "delegate", "Lcom/tencent/state/api/INetworkDelegate;", "getNetworkDelegate", "setupNetworkDelegate", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class NetworkConfig {
    public static final NetworkConfig INSTANCE = new NetworkConfig();
    private static INetworkDelegate delegate;

    NetworkConfig() {
    }

    public final INetworkDelegate getNetworkDelegate() {
        return delegate;
    }

    public final void setupNetworkDelegate(INetworkDelegate delegate2) {
        Intrinsics.checkNotNullParameter(delegate2, "delegate");
        delegate = delegate2;
    }
}
