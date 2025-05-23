package bk0;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lbk0/a;", "", "Lorg/json/JSONObject;", "a", "()Lorg/json/JSONObject;", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "productId", "b", "sellerId", "c", "arkAppId", "d", "arkViewName", "e", "getVersion", "()Ljava/lang/String;", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: bk0.a, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECProductArkShareRequestParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sellerId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String arkAppId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String arkViewName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String version;

    public ECProductArkShareRequestParams(String str, String str2, String str3, String str4, String str5) {
        this.productId = str;
        this.sellerId = str2;
        this.arkAppId = str3;
        this.arkViewName = str4;
        this.version = str5;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, this.productId);
        jSONObject.put("seller_id", this.sellerId);
        jSONObject.put("app", this.arkAppId);
        jSONObject.put("view", this.arkViewName);
        jSONObject.put("ver", this.version);
        return jSONObject;
    }

    public int hashCode() {
        String str = this.productId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sellerId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.arkAppId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.arkViewName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.version;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ECProductArkShareRequestParams(productId=" + this.productId + ", sellerId=" + this.sellerId + ", arkAppId=" + this.arkAppId + ", arkViewName=" + this.arkViewName + ", version=" + this.version + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECProductArkShareRequestParams)) {
            return false;
        }
        ECProductArkShareRequestParams eCProductArkShareRequestParams = (ECProductArkShareRequestParams) other;
        return Intrinsics.areEqual(this.productId, eCProductArkShareRequestParams.productId) && Intrinsics.areEqual(this.sellerId, eCProductArkShareRequestParams.sellerId) && Intrinsics.areEqual(this.arkAppId, eCProductArkShareRequestParams.arkAppId) && Intrinsics.areEqual(this.arkViewName, eCProductArkShareRequestParams.arkViewName) && Intrinsics.areEqual(this.version, eCProductArkShareRequestParams.version);
    }
}
