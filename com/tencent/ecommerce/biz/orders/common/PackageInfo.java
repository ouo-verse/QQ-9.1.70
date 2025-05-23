package com.tencent.ecommerce.biz.orders.common;

import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$PackageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\tB1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "productName", "b", "productIcon", "c", "spuId", "d", "getSkuId", "()Ljava/lang/String;", "skuId", "e", "I", "statusIconResId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.common.h, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class PackageInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String spuId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String skuId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public int statusIconResId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/h$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_logistics_common/ECLogisticsCommon$PackageInfo;", "packageInfo", "Lcom/tencent/ecommerce/biz/orders/common/h;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.h$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final PackageInfo a(ECLogisticsCommon$PackageInfo packageInfo) {
            String str = packageInfo.product_icon.get();
            return new PackageInfo(packageInfo.product_name.get(), str, packageInfo.spu_id.get(), packageInfo.sku_id.get(), 0, 16, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PackageInfo(String str, String str2, String str3, String str4, int i3) {
        this.productName = str;
        this.productIcon = str2;
        this.spuId = str3;
        this.skuId = str4;
        this.statusIconResId = i3;
    }

    public int hashCode() {
        String str = this.productName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.productIcon;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.spuId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.skuId;
        return ((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.statusIconResId;
    }

    public String toString() {
        return "PackageInfo(productName=" + this.productName + ", productIcon=" + this.productIcon + ", spuId=" + this.spuId + ", skuId=" + this.skuId + ", statusIconResId=" + this.statusIconResId + ")";
    }

    public /* synthetic */ PackageInfo(String str, String str2, String str3, String str4, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i16 & 16) != 0 ? 0 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PackageInfo)) {
            return false;
        }
        PackageInfo packageInfo = (PackageInfo) other;
        return Intrinsics.areEqual(this.productName, packageInfo.productName) && Intrinsics.areEqual(this.productIcon, packageInfo.productIcon) && Intrinsics.areEqual(this.spuId, packageInfo.spuId) && Intrinsics.areEqual(this.skuId, packageInfo.skuId) && this.statusIconResId == packageInfo.statusIconResId;
    }
}
