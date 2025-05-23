package com.tencent.ecommerce.biz.orders.common;

import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$ShipperCompany;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "code", "b", "name", "c", "tel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.common.l, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ShipperCompany {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String tel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/l$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_logistics_common/ECLogisticsCommon$ShipperCompany;", "shipperCompany", "Lcom/tencent/ecommerce/biz/orders/common/l;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.l$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ShipperCompany a(ECLogisticsCommon$ShipperCompany shipperCompany) {
            return new ShipperCompany(shipperCompany.code.get(), shipperCompany.name.get(), shipperCompany.tel.get());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShipperCompany(String str, String str2, String str3) {
        this.code = str;
        this.name = str2;
        this.tel = str3;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.tel;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ShipperCompany(code=" + this.code + ", name=" + this.name + ", tel=" + this.tel + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipperCompany)) {
            return false;
        }
        ShipperCompany shipperCompany = (ShipperCompany) other;
        return Intrinsics.areEqual(this.code, shipperCompany.code) && Intrinsics.areEqual(this.name, shipperCompany.name) && Intrinsics.areEqual(this.tel, shipperCompany.tel);
    }
}
