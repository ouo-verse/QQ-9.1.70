package com.tencent.ecommerce.repo.buyerorder.orderlist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;", "", "Lorg/json/JSONObject;", "ptsJSONObject", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", "c", "()Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.buyerorder.orderlist.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECOrderListItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final JSONObject ptsJSONObject;

    public ECOrderListItem(JSONObject jSONObject) {
        this.ptsJSONObject = jSONObject;
    }

    public final ECOrderListItem a(JSONObject ptsJSONObject) {
        return new ECOrderListItem(ptsJSONObject);
    }

    /* renamed from: c, reason: from getter */
    public final JSONObject getPtsJSONObject() {
        return this.ptsJSONObject;
    }

    public int hashCode() {
        JSONObject jSONObject = this.ptsJSONObject;
        if (jSONObject != null) {
            return jSONObject.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ECOrderListItem(ptsJSONObject=" + this.ptsJSONObject + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ECOrderListItem) && Intrinsics.areEqual(this.ptsJSONObject, ((ECOrderListItem) other).ptsJSONObject);
        }
        return true;
    }

    public static /* synthetic */ ECOrderListItem b(ECOrderListItem eCOrderListItem, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            jSONObject = eCOrderListItem.ptsJSONObject;
        }
        return eCOrderListItem.a(jSONObject);
    }
}
