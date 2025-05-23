package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository;

import com.tencent.mobileqq.matchfriend.aio.foreground.g;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSuccess", "", "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", "b", "Ljava/util/List;", "()Ljava/util/List;", "signalConfigs", "", "J", "()J", "signalExpire", "<init>", "(ZLjava/util/List;J)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.a, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerSignalConfigResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<SignalPB$SignalConfig> signalConfigs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long signalExpire;

    public QQStrangerSignalConfigResult(boolean z16, List<SignalPB$SignalConfig> signalConfigs, long j3) {
        Intrinsics.checkNotNullParameter(signalConfigs, "signalConfigs");
        this.isSuccess = z16;
        this.signalConfigs = signalConfigs;
        this.signalExpire = j3;
    }

    public final List<SignalPB$SignalConfig> a() {
        return this.signalConfigs;
    }

    /* renamed from: b, reason: from getter */
    public final long getSignalExpire() {
        return this.signalExpire;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.signalConfigs.hashCode()) * 31) + g.a(this.signalExpire);
    }

    public String toString() {
        return "QQStrangerSignalConfigResult(isSuccess=" + this.isSuccess + ", signalConfigs=" + this.signalConfigs + ", signalExpire=" + this.signalExpire + ")";
    }

    public /* synthetic */ QQStrangerSignalConfigResult(boolean z16, List list, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? 0L : j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerSignalConfigResult)) {
            return false;
        }
        QQStrangerSignalConfigResult qQStrangerSignalConfigResult = (QQStrangerSignalConfigResult) other;
        return this.isSuccess == qQStrangerSignalConfigResult.isSuccess && Intrinsics.areEqual(this.signalConfigs, qQStrangerSignalConfigResult.signalConfigs) && this.signalExpire == qQStrangerSignalConfigResult.signalExpire;
    }
}
