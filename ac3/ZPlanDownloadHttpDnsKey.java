package ac3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lac3/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", com.heytap.mcssdk.a.a.f36102l, "b", "dnsId", "c", "dnsKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ac3.d, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ZPlanDownloadHttpDnsKey {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String appKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String dnsId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String dnsKey;

    public ZPlanDownloadHttpDnsKey(String appKey, String dnsId, String dnsKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(dnsId, "dnsId");
        Intrinsics.checkNotNullParameter(dnsKey, "dnsKey");
        this.appKey = appKey;
        this.dnsId = dnsId;
        this.dnsKey = dnsKey;
    }

    /* renamed from: a, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    /* renamed from: b, reason: from getter */
    public final String getDnsId() {
        return this.dnsId;
    }

    /* renamed from: c, reason: from getter */
    public final String getDnsKey() {
        return this.dnsKey;
    }

    public int hashCode() {
        return (((this.appKey.hashCode() * 31) + this.dnsId.hashCode()) * 31) + this.dnsKey.hashCode();
    }

    public String toString() {
        return "ZPlanDownloadHttpDnsKey(appKey=" + this.appKey + ", dnsId=" + this.dnsId + ", dnsKey=" + this.dnsKey + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanDownloadHttpDnsKey)) {
            return false;
        }
        ZPlanDownloadHttpDnsKey zPlanDownloadHttpDnsKey = (ZPlanDownloadHttpDnsKey) other;
        return Intrinsics.areEqual(this.appKey, zPlanDownloadHttpDnsKey.appKey) && Intrinsics.areEqual(this.dnsId, zPlanDownloadHttpDnsKey.dnsId) && Intrinsics.areEqual(this.dnsKey, zPlanDownloadHttpDnsKey.dnsKey);
    }
}
