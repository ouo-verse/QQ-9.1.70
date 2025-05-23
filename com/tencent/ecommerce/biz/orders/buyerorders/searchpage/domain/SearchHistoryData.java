package com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isFirstInit", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "searchHistories", "<init>", "(ZLjava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class SearchHistoryData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isFirstInit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> searchHistories;

    public SearchHistoryData(boolean z16, List<String> list) {
        this.isFirstInit = z16;
        this.searchHistories = list;
    }

    public final List<String> a() {
        return this.searchHistories;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isFirstInit;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        List<String> list = this.searchHistories;
        return i3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SearchHistoryData(isFirstInit=" + this.isFirstInit + ", searchHistories=" + this.searchHistories + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchHistoryData)) {
            return false;
        }
        SearchHistoryData searchHistoryData = (SearchHistoryData) other;
        return this.isFirstInit == searchHistoryData.isFirstInit && Intrinsics.areEqual(this.searchHistories, searchHistoryData.searchHistories);
    }
}
