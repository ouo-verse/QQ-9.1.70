package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/c;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "title", "c", "content", "d", "storeId", "e", "a", "()Ljava/lang/String;", "spuId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class BulletinItemData extends p {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String content;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String storeId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String spuId;

    /* renamed from: a, reason: from getter */
    public final String getSpuId() {
        return this.spuId;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.storeId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.spuId;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "BulletinItemData(title=" + this.title + ", content=" + this.content + ", storeId=" + this.storeId + ", spuId=" + this.spuId + ")";
    }

    public BulletinItemData(String str, String str2, String str3, String str4) {
        super(6, null);
        this.title = str;
        this.content = str2;
        this.storeId = str3;
        this.spuId = str4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BulletinItemData)) {
            return false;
        }
        BulletinItemData bulletinItemData = (BulletinItemData) other;
        return Intrinsics.areEqual(this.title, bulletinItemData.title) && Intrinsics.areEqual(this.content, bulletinItemData.content) && Intrinsics.areEqual(this.storeId, bulletinItemData.storeId) && Intrinsics.areEqual(this.spuId, bulletinItemData.spuId);
    }
}
