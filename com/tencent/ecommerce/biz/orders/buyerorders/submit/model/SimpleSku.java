package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "Landroid/os/Parcelable;", "", "skuId", "", "quantity", "b", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "e", "I", "()I", "<init>", "(Ljava/lang/String;I)V", tl.h.F, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SimpleSku implements Parcelable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String skuId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int quantity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final SimpleSku f103589f = new SimpleSku("", 0);
    public static final Parcelable.Creator<SimpleSku> CREATOR = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku$a;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "INVALID", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "a", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final SimpleSku a() {
            return SimpleSku.f103589f;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static class b implements Parcelable.Creator<SimpleSku> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SimpleSku createFromParcel(Parcel parcel) {
            return new SimpleSku(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SimpleSku[] newArray(int i3) {
            return new SimpleSku[i3];
        }
    }

    public SimpleSku(String str, int i3) {
        this.skuId = str;
        this.quantity = i3;
    }

    public final SimpleSku b(String skuId, int quantity) {
        return new SimpleSku(skuId, quantity);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        String str = this.skuId;
        return ((str != null ? str.hashCode() : 0) * 31) + this.quantity;
    }

    public String toString() {
        return "SimpleSku(skuId=" + this.skuId + ", quantity=" + this.quantity + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.skuId);
        parcel.writeInt(this.quantity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleSku)) {
            return false;
        }
        SimpleSku simpleSku = (SimpleSku) other;
        return Intrinsics.areEqual(this.skuId, simpleSku.skuId) && this.quantity == simpleSku.quantity;
    }

    public static /* synthetic */ SimpleSku c(SimpleSku simpleSku, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = simpleSku.skuId;
        }
        if ((i16 & 2) != 0) {
            i3 = simpleSku.quantity;
        }
        return simpleSku.b(str, i3);
    }
}
