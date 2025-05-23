package com.tenpay.sdk.net.gateway.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\n\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\f\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/tenpay/sdk/net/gateway/data/ClientExtraData;", "", "isTlsRetry", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class ClientExtraData {
    private final boolean isTlsRetry;

    public ClientExtraData() {
        this(false, 1, null);
    }

    public static /* synthetic */ ClientExtraData copy$default(ClientExtraData clientExtraData, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = clientExtraData.isTlsRetry;
        }
        return clientExtraData.copy(z16);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsTlsRetry() {
        return this.isTlsRetry;
    }

    @NotNull
    public final ClientExtraData copy(boolean isTlsRetry) {
        return new ClientExtraData(isTlsRetry);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ClientExtraData) && this.isTlsRetry == ((ClientExtraData) other).isTlsRetry) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z16 = this.isTlsRetry;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    public final boolean isTlsRetry() {
        return this.isTlsRetry;
    }

    @NotNull
    public String toString() {
        return "ClientExtraData(isTlsRetry=" + this.isTlsRetry + ")";
    }

    public ClientExtraData(boolean z16) {
        this.isTlsRetry = z16;
    }

    public /* synthetic */ ClientExtraData(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
