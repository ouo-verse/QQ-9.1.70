package ac3;

import com.tencent.halley.common.ParseDnsServerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u0014\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lac3/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "enablePreDnsParse", "Lcom/tencent/halley/common/ParseDnsServerType;", "b", "Lcom/tencent/halley/common/ParseDnsServerType;", "()Lcom/tencent/halley/common/ParseDnsServerType;", "dnsParseType", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "dnsDomainWhiteList", "d", "enableHttpDns", "Ljava/lang/String;", "()Ljava/lang/String;", "dnsParseTypeConfigString", "<init>", "(ZLcom/tencent/halley/common/ParseDnsServerType;Ljava/util/List;ZLjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ac3.c, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ZPlanDownloadDnsConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enablePreDnsParse;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ParseDnsServerType dnsParseType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> dnsDomainWhiteList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableHttpDns;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String dnsParseTypeConfigString;

    public ZPlanDownloadDnsConfig(boolean z16, ParseDnsServerType parseDnsServerType, List<String> dnsDomainWhiteList, boolean z17, String dnsParseTypeConfigString) {
        Intrinsics.checkNotNullParameter(dnsDomainWhiteList, "dnsDomainWhiteList");
        Intrinsics.checkNotNullParameter(dnsParseTypeConfigString, "dnsParseTypeConfigString");
        this.enablePreDnsParse = z16;
        this.dnsParseType = parseDnsServerType;
        this.dnsDomainWhiteList = dnsDomainWhiteList;
        this.enableHttpDns = z17;
        this.dnsParseTypeConfigString = dnsParseTypeConfigString;
    }

    public final List<String> a() {
        return this.dnsDomainWhiteList;
    }

    /* renamed from: b, reason: from getter */
    public final ParseDnsServerType getDnsParseType() {
        return this.dnsParseType;
    }

    /* renamed from: c, reason: from getter */
    public final String getDnsParseTypeConfigString() {
        return this.dnsParseTypeConfigString;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnableHttpDns() {
        return this.enableHttpDns;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getEnablePreDnsParse() {
        return this.enablePreDnsParse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z16 = this.enablePreDnsParse;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        ParseDnsServerType parseDnsServerType = this.dnsParseType;
        int hashCode = (((i3 + (parseDnsServerType == null ? 0 : parseDnsServerType.hashCode())) * 31) + this.dnsDomainWhiteList.hashCode()) * 31;
        boolean z17 = this.enableHttpDns;
        return ((hashCode + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.dnsParseTypeConfigString.hashCode();
    }

    public String toString() {
        return "ZPlanDownloadDnsConfig(enablePreDnsParse=" + this.enablePreDnsParse + ", dnsParseType=" + this.dnsParseType + ", dnsDomainWhiteList=" + this.dnsDomainWhiteList + ", enableHttpDns=" + this.enableHttpDns + ", dnsParseTypeConfigString=" + this.dnsParseTypeConfigString + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanDownloadDnsConfig)) {
            return false;
        }
        ZPlanDownloadDnsConfig zPlanDownloadDnsConfig = (ZPlanDownloadDnsConfig) other;
        return this.enablePreDnsParse == zPlanDownloadDnsConfig.enablePreDnsParse && this.dnsParseType == zPlanDownloadDnsConfig.dnsParseType && Intrinsics.areEqual(this.dnsDomainWhiteList, zPlanDownloadDnsConfig.dnsDomainWhiteList) && this.enableHttpDns == zPlanDownloadDnsConfig.enableHttpDns && Intrinsics.areEqual(this.dnsParseTypeConfigString, zPlanDownloadDnsConfig.dnsParseTypeConfigString);
    }
}
