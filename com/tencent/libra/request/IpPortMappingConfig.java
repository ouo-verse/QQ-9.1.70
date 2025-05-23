package com.tencent.libra.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\r\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/libra/request/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "ip", "b", "I", "getPort", "()I", "(I)V", "port", "<init>", "(Ljava/lang/String;I)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.libra.request.c, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class IpPortMappingConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String ip;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int port;

    public IpPortMappingConfig(@NotNull String ip5, int i3) {
        Intrinsics.checkNotNullParameter(ip5, "ip");
        this.ip = ip5;
        this.port = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getIp() {
        return this.ip;
    }

    public final void b(int i3) {
        this.port = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof IpPortMappingConfig) {
                IpPortMappingConfig ipPortMappingConfig = (IpPortMappingConfig) other;
                if (!Intrinsics.areEqual(this.ip, ipPortMappingConfig.ip) || this.port != ipPortMappingConfig.port) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        String str = this.ip;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (i3 * 31) + this.port;
    }

    @NotNull
    public String toString() {
        return "IpPortMappingConfig(ip=" + this.ip + ", port=" + this.port + ")";
    }
}
