package com.tencent.libra.request;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J#\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/libra/request/IpConnectConfig;", "", "", "component1", "", "Lcom/tencent/libra/request/c;", "component2", "host", "ipPortList", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "Ljava/util/List;", "getIpPortList", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final /* data */ class IpConnectConfig {

    @NotNull
    private final String host;

    @NotNull
    private final List<IpPortMappingConfig> ipPortList;

    public IpConnectConfig(@NotNull String host, @NotNull List<IpPortMappingConfig> ipPortList) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(ipPortList, "ipPortList");
        this.host = host;
        this.ipPortList = ipPortList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IpConnectConfig copy$default(IpConnectConfig ipConnectConfig, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = ipConnectConfig.host;
        }
        if ((i3 & 2) != 0) {
            list = ipConnectConfig.ipPortList;
        }
        return ipConnectConfig.copy(str, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    @NotNull
    public final List<IpPortMappingConfig> component2() {
        return this.ipPortList;
    }

    @NotNull
    public final IpConnectConfig copy(@NotNull String host, @NotNull List<IpPortMappingConfig> ipPortList) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(ipPortList, "ipPortList");
        return new IpConnectConfig(host, ipPortList);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof IpConnectConfig) {
                IpConnectConfig ipConnectConfig = (IpConnectConfig) other;
                if (!Intrinsics.areEqual(this.host, ipConnectConfig.host) || !Intrinsics.areEqual(this.ipPortList, ipConnectConfig.ipPortList)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getHost() {
        return this.host;
    }

    @NotNull
    public final List<IpPortMappingConfig> getIpPortList() {
        return this.ipPortList;
    }

    public int hashCode() {
        int i3;
        String str = this.host;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        List<IpPortMappingConfig> list = this.ipPortList;
        if (list != null) {
            i16 = list.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "IpConnectConfig(host=" + this.host + ", ipPortList=" + this.ipPortList + ")";
    }

    public /* synthetic */ IpConnectConfig(String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? new ArrayList() : list);
    }
}
