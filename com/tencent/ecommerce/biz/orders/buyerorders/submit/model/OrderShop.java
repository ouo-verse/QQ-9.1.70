package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import com.heytap.databaseengine.type.DeviceType;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "id", "b", "name", "c", PhotoCategorySummaryInfo.AVATAR_URL, "d", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "e", DeviceType.DeviceCategory.MOBILE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class OrderShop {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String avatarUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String link;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String mobile;

    public OrderShop(String str, String str2, String str3, String str4, String str5) {
        this.id = str;
        this.name = str2;
        this.avatarUrl = str3;
        this.link = str4;
        this.mobile = str5;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.avatarUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.link;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mobile;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "OrderShop(id=" + this.id + ", name=" + this.name + ", avatarUrl=" + this.avatarUrl + ", link=" + this.link + ", mobile=" + this.mobile + ")";
    }

    public /* synthetic */ OrderShop(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i3 & 16) != 0 ? "" : str5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderShop)) {
            return false;
        }
        OrderShop orderShop = (OrderShop) other;
        return Intrinsics.areEqual(this.id, orderShop.id) && Intrinsics.areEqual(this.name, orderShop.name) && Intrinsics.areEqual(this.avatarUrl, orderShop.avatarUrl) && Intrinsics.areEqual(this.link, orderShop.link) && Intrinsics.areEqual(this.mobile, orderShop.mobile);
    }
}
