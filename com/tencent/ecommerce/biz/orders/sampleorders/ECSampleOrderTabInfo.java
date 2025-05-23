package com.tencent.ecommerce.biz.orders.sampleorders;

import com.tencent.ecommerce.repo.sampleorder.ECApplySampleQueryType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", "a", "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", "type", "b", "Ljava/lang/String;", "tabName", "<init>", "(Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.sampleorders.d, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECSampleOrderTabInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECApplySampleQueryType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String tabName;

    public ECSampleOrderTabInfo(ECApplySampleQueryType eCApplySampleQueryType, String str) {
        this.type = eCApplySampleQueryType;
        this.tabName = str;
    }

    public int hashCode() {
        ECApplySampleQueryType eCApplySampleQueryType = this.type;
        int hashCode = (eCApplySampleQueryType != null ? eCApplySampleQueryType.hashCode() : 0) * 31;
        String str = this.tabName;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ECSampleOrderTabInfo(type=" + this.type + ", tabName=" + this.tabName + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECSampleOrderTabInfo)) {
            return false;
        }
        ECSampleOrderTabInfo eCSampleOrderTabInfo = (ECSampleOrderTabInfo) other;
        return Intrinsics.areEqual(this.type, eCSampleOrderTabInfo.type) && Intrinsics.areEqual(this.tabName, eCSampleOrderTabInfo.tabName);
    }
}
