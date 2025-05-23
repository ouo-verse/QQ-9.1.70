package com.tencent.ecommerce.repo.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/repo/live/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/repo/live/g;", "a", "Lcom/tencent/ecommerce/repo/live/g;", "baseInfo", "<init>", "(Lcom/tencent/ecommerce/repo/live/g;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.h, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopDetail {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECShopBaseInfo baseInfo;

    public ECShopDetail(ECShopBaseInfo eCShopBaseInfo) {
        this.baseInfo = eCShopBaseInfo;
    }

    public int hashCode() {
        ECShopBaseInfo eCShopBaseInfo = this.baseInfo;
        if (eCShopBaseInfo != null) {
            return eCShopBaseInfo.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ECShopDetail(baseInfo=" + this.baseInfo + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ECShopDetail) && Intrinsics.areEqual(this.baseInfo, ((ECShopDetail) other).baseInfo);
        }
        return true;
    }
}
