package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "title", "b", "desc", "c", "()Ljava/lang/String;", "linkUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECExtraJumpInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String desc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String linkUrl;

    public ECExtraJumpInfo(String str, String str2, String str3) {
        this.title = str;
        this.desc = str2;
        this.linkUrl = str3;
    }

    /* renamed from: a, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.desc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.linkUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ECExtraJumpInfo(title=" + this.title + ", desc=" + this.desc + ", linkUrl=" + this.linkUrl + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECExtraJumpInfo)) {
            return false;
        }
        ECExtraJumpInfo eCExtraJumpInfo = (ECExtraJumpInfo) other;
        return Intrinsics.areEqual(this.title, eCExtraJumpInfo.title) && Intrinsics.areEqual(this.desc, eCExtraJumpInfo.desc) && Intrinsics.areEqual(this.linkUrl, eCExtraJumpInfo.linkUrl);
    }
}
