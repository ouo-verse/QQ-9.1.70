package com.tencent.ecommerce.biz.orders.buyerorders.detail.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "url", "b", "I", "width", "c", "height", "<init>", "(Ljava/lang/String;II)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.model.c, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class OrderSpuPicInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int height;

    public OrderSpuPicInfo(String str, int i3, int i16) {
        this.url = str;
        this.width = i3;
        this.height = i16;
    }

    public int hashCode() {
        String str = this.url;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "OrderSpuPicInfo(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderSpuPicInfo)) {
            return false;
        }
        OrderSpuPicInfo orderSpuPicInfo = (OrderSpuPicInfo) other;
        return Intrinsics.areEqual(this.url, orderSpuPicInfo.url) && this.width == orderSpuPicInfo.width && this.height == orderSpuPicInfo.height;
    }
}
