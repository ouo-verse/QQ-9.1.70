package com.tencent.ecommerce.biz.orders.sellerorders.orderfilter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/c;", "", "", "toString", "Lorg/json/JSONObject;", "a", "", "hashCode", "other", "", "equals", "I", "goodType", "b", "Ljava/lang/String;", "name", "c", "saasStr", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int goodType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String saasStr;

    public c(int i3, String str, String str2) {
        this.goodType = i3;
        this.name = str;
        this.saasStr = str2;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("goods_type", this.goodType);
        jSONObject.put("saas_name", this.name);
        jSONObject.put("saas_str", this.saasStr);
        return jSONObject;
    }

    public int hashCode() {
        int i3 = this.goodType * 31;
        String str = this.name;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.saasStr;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "platform: " + this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return this.goodType == cVar.goodType && Intrinsics.areEqual(this.name, cVar.name) && Intrinsics.areEqual(this.saasStr, cVar.saasStr);
    }
}
