package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import com.tencent.ecommerce.biz.orders.common.BulletinInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isReachable", "Lcom/tencent/ecommerce/biz/orders/common/a;", "b", "Lcom/tencent/ecommerce/biz/orders/common/a;", "()Lcom/tencent/ecommerce/biz/orders/common/a;", "bulletinInfo", "<init>", "(ZLcom/tencent/ecommerce/biz/orders/common/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class AddressCheckResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isReachable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final BulletinInfo bulletinInfo;

    public AddressCheckResult(boolean z16, BulletinInfo bulletinInfo) {
        this.isReachable = z16;
        this.bulletinInfo = bulletinInfo;
    }

    /* renamed from: a, reason: from getter */
    public final BulletinInfo getBulletinInfo() {
        return this.bulletinInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isReachable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        BulletinInfo bulletinInfo = this.bulletinInfo;
        return i3 + (bulletinInfo != null ? bulletinInfo.hashCode() : 0);
    }

    public String toString() {
        return "AddressCheckResult(isReachable=" + this.isReachable + ", bulletinInfo=" + this.bulletinInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressCheckResult)) {
            return false;
        }
        AddressCheckResult addressCheckResult = (AddressCheckResult) other;
        return this.isReachable == addressCheckResult.isReachable && Intrinsics.areEqual(this.bulletinInfo, addressCheckResult.bulletinInfo);
    }
}
