package com.tencent.ecommerce.biz.shoplist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/shoplist/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "name", "b", "iconUrl", "c", "url", "d", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.shoplist.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECPromoteShopItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String iconUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String description;

    public ECPromoteShopItem(String str, String str2, String str3, String str4) {
        this.name = str;
        this.iconUrl = str2;
        this.url = str3;
        this.description = str4;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.iconUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ECPromoteShopItem(name=" + this.name + ", iconUrl=" + this.iconUrl + ", url=" + this.url + ", description=" + this.description + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECPromoteShopItem)) {
            return false;
        }
        ECPromoteShopItem eCPromoteShopItem = (ECPromoteShopItem) other;
        return Intrinsics.areEqual(this.name, eCPromoteShopItem.name) && Intrinsics.areEqual(this.iconUrl, eCPromoteShopItem.iconUrl) && Intrinsics.areEqual(this.url, eCPromoteShopItem.url) && Intrinsics.areEqual(this.description, eCPromoteShopItem.description);
    }
}
