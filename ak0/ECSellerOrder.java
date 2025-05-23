package ak0;

import com.tencent.ecommerce.biz.commission.forecast.b;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJO\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lak0/a;", "", "Lorg/json/JSONObject;", "dataJSONObject", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "state", "", "orderPrice", "saasType", "saasTypeStr", WadlProxyConsts.CREATE_TIME, "a", "toString", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", "b", "Ljava/lang/String;", "c", "I", "d", "J", "e", "f", "g", "<init>", "(Lorg/json/JSONObject;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: ak0.a, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ECSellerOrder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final JSONObject dataJSONObject;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int state;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final long orderPrice;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String saasType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String saasTypeStr;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String createTime;

    public ECSellerOrder(JSONObject jSONObject, String str, int i3, long j3, String str2, String str3, String str4) {
        this.dataJSONObject = jSONObject;
        this.orderId = str;
        this.state = i3;
        this.orderPrice = j3;
        this.saasType = str2;
        this.saasTypeStr = str3;
        this.createTime = str4;
    }

    public final ECSellerOrder a(JSONObject dataJSONObject, String orderId, int state, long orderPrice, String saasType, String saasTypeStr, String createTime) {
        return new ECSellerOrder(dataJSONObject, orderId, state, orderPrice, saasType, saasTypeStr, createTime);
    }

    public int hashCode() {
        JSONObject jSONObject = this.dataJSONObject;
        int hashCode = (jSONObject != null ? jSONObject.hashCode() : 0) * 31;
        String str = this.orderId;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.state) * 31) + b.a(this.orderPrice)) * 31;
        String str2 = this.saasType;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.saasTypeStr;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.createTime;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ECSellerOrder(dataJSONObject=" + this.dataJSONObject + ", orderId=" + this.orderId + ", state=" + this.state + ", orderPrice=" + this.orderPrice + ", saasType=" + this.saasType + ", saasTypeStr=" + this.saasTypeStr + ", createTime=" + this.createTime + ")";
    }

    public /* synthetic */ ECSellerOrder(JSONObject jSONObject, String str, int i3, long j3, String str2, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? 0L : j3, (i16 & 16) != 0 ? "" : str2, (i16 & 32) != 0 ? "" : str3, (i16 & 64) == 0 ? str4 : "");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECSellerOrder)) {
            return false;
        }
        ECSellerOrder eCSellerOrder = (ECSellerOrder) other;
        return Intrinsics.areEqual(this.dataJSONObject, eCSellerOrder.dataJSONObject) && Intrinsics.areEqual(this.orderId, eCSellerOrder.orderId) && this.state == eCSellerOrder.state && this.orderPrice == eCSellerOrder.orderPrice && Intrinsics.areEqual(this.saasType, eCSellerOrder.saasType) && Intrinsics.areEqual(this.saasTypeStr, eCSellerOrder.saasTypeStr) && Intrinsics.areEqual(this.createTime, eCSellerOrder.createTime);
    }
}
