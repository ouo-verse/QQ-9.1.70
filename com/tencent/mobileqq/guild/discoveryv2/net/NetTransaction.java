package com.tencent.mobileqq.guild.discoveryv2.net;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\u0006\u0010\u0014\u001a\u00028\u0001\u0012\u0006\u0010\u0018\u001a\u00020\t\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0001H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00d6\u0003R\u0017\u0010\u0012\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007R\u0017\u0010\u0014\u001a\u00028\u00018\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0013\u0010\u0007R\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Req", "Rsp", "", "", "toString", "a", "()Ljava/lang/Object;", "b", "Lcom/tencent/mobileqq/guild/discoveryv2/net/DataType;", "c", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "getReq", "req", "getRsp", "rsp", "Lcom/tencent/mobileqq/guild/discoveryv2/net/DataType;", "d", "()Lcom/tencent/mobileqq/guild/discoveryv2/net/DataType;", "from", "", "J", "getTransCostTime", "()J", "e", "(J)V", "transCostTime", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/tencent/mobileqq/guild/discoveryv2/net/DataType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.net.h, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class NetTransaction<Req, Rsp> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Req req;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Rsp rsp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final DataType from;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long transCostTime;

    public NetTransaction(Req req, Rsp rsp, @NotNull DataType from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.req = req;
        this.rsp = rsp;
        this.from = from;
    }

    public final Req a() {
        return this.req;
    }

    public final Rsp b() {
        return this.rsp;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final DataType getFrom() {
        return this.from;
    }

    @NotNull
    public final DataType d() {
        return this.from;
    }

    public final void e(long j3) {
        this.transCostTime = j3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetTransaction)) {
            return false;
        }
        NetTransaction netTransaction = (NetTransaction) other;
        if (Intrinsics.areEqual(this.req, netTransaction.req) && Intrinsics.areEqual(this.rsp, netTransaction.rsp) && this.from == netTransaction.from) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Req req = this.req;
        int i3 = 0;
        if (req == null) {
            hashCode = 0;
        } else {
            hashCode = req.hashCode();
        }
        int i16 = hashCode * 31;
        Rsp rsp = this.rsp;
        if (rsp != null) {
            i3 = rsp.hashCode();
        }
        return ((i16 + i3) * 31) + this.from.hashCode();
    }

    @NotNull
    public String toString() {
        return "NetTransaction(from=" + this.from + " costTime=" + this.transCostTime + " rsp=" + this.rsp + " req=" + this.req + ")";
    }
}
