package com.tencent.ecommerce.repo.buyerorder.orderlist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/orderlist/c;", "Lcom/tencent/ecommerce/base/list/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "keyword", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECQueryType;", "d", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECQueryType;", "()Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECQueryType;", "queryType", "e", "b", "()Ljava/lang/String;", "fromScene", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECQueryType;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.buyerorder.orderlist.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECOrderListRequestInfo extends com.tencent.ecommerce.base.list.f {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String keyword;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ECQueryType queryType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String fromScene;

    public ECOrderListRequestInfo(String str, ECQueryType eCQueryType, String str2) {
        this.keyword = str;
        this.queryType = eCQueryType;
        this.fromScene = str2;
    }

    /* renamed from: b, reason: from getter */
    public final String getFromScene() {
        return this.fromScene;
    }

    /* renamed from: c, reason: from getter */
    public final ECQueryType getQueryType() {
        return this.queryType;
    }

    public int hashCode() {
        String str = this.keyword;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ECQueryType eCQueryType = this.queryType;
        int hashCode2 = (hashCode + (eCQueryType != null ? eCQueryType.hashCode() : 0)) * 31;
        String str2 = this.fromScene;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECOrderListRequestInfo(keyword=" + this.keyword + ", queryType=" + this.queryType + ", fromScene=" + this.fromScene + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECOrderListRequestInfo)) {
            return false;
        }
        ECOrderListRequestInfo eCOrderListRequestInfo = (ECOrderListRequestInfo) other;
        return Intrinsics.areEqual(this.keyword, eCOrderListRequestInfo.keyword) && Intrinsics.areEqual(this.queryType, eCOrderListRequestInfo.queryType) && Intrinsics.areEqual(this.fromScene, eCOrderListRequestInfo.fromScene);
    }
}
