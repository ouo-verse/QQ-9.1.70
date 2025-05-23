package com.tencent.sqshow.zootopia.nativeui.data.cart;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import uv4.az;
import uv4.bc;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000bB)\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u0013\u0010\u001cR\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u000b\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "", "", "f", "d", "", "toString", "", "hashCode", "other", "equals", "a", "Z", "e", "()Z", "i", "(Z)V", "isSelected", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/PriceType;", "b", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/PriceType;", "c", "()Lcom/tencent/sqshow/zootopia/nativeui/data/cart/PriceType;", h.F, "(Lcom/tencent/sqshow/zootopia/nativeui/data/cart/PriceType;)V", "priceType", "Luv4/az;", "Luv4/az;", "()Luv4/az;", "itemData", "I", "()I", "g", "(I)V", "count", "<init>", "(ZLcom/tencent/sqshow/zootopia/nativeui/data/cart/PriceType;Luv4/az;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.data.cart.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class CartGoodsData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private PriceType priceType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final az itemData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int count;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a$a;", "", "Luv4/az;", "itemData", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/PriceType;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.data.cart.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final PriceType a(az itemData) {
            if (itemData == null) {
                return PriceType.NONE;
            }
            bc bcVar = itemData.f440287n;
            Integer valueOf = bcVar != null ? Integer.valueOf(bcVar.f440312a) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                return PriceType.NONE;
            }
            if (valueOf != null && valueOf.intValue() == 1) {
                return PriceType.GOAL_FIRST;
            }
            if (valueOf != null && valueOf.intValue() == 2) {
                return PriceType.SILVER_FIRST;
            }
            if (valueOf != null && valueOf.intValue() == 3) {
                return com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.o().b();
            }
            if (valueOf != null && valueOf.intValue() == 4) {
                return PriceType.GOAL_AND_SILVER;
            }
            return PriceType.NONE;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.data.cart.a$b */
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f370945a;

        static {
            int[] iArr = new int[PriceType.values().length];
            try {
                iArr[PriceType.GOAL_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PriceType.SILVER_FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f370945a = iArr;
        }
    }

    public CartGoodsData(boolean z16, PriceType priceType, az itemData, int i3) {
        Intrinsics.checkNotNullParameter(priceType, "priceType");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        this.isSelected = z16;
        this.priceType = priceType;
        this.itemData = itemData;
        this.count = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: b, reason: from getter */
    public final az getItemData() {
        return this.itemData;
    }

    /* renamed from: c, reason: from getter */
    public final PriceType getPriceType() {
        return this.priceType;
    }

    public final boolean d() {
        az azVar = this.itemData;
        QLog.d("cartData", 1, "itemId = " + azVar.f440275b + " price => " + azVar.f440287n);
        bc bcVar = this.itemData.f440287n;
        if (!((bcVar != null ? bcVar.f440317f : 0L) > System.currentTimeMillis() / ((long) 1000))) {
            return false;
        }
        int i3 = b.f370945a[this.priceType.ordinal()];
        if (i3 == 1) {
            bc bcVar2 = this.itemData.f440287n;
            if (bcVar2.f440315d < bcVar2.f440313b) {
                return true;
            }
        } else if (i3 == 2) {
            bc bcVar3 = this.itemData.f440287n;
            if (bcVar3.f440316e < bcVar3.f440314c) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final boolean f() {
        bc bcVar = this.itemData.f440287n;
        return bcVar != null && bcVar.f440312a == 3;
    }

    public final void g(int i3) {
        this.count = i3;
    }

    public final void h(PriceType priceType) {
        Intrinsics.checkNotNullParameter(priceType, "<set-?>");
        this.priceType = priceType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isSelected;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((r06 * 31) + this.priceType.hashCode()) * 31) + this.itemData.hashCode()) * 31) + this.count;
    }

    public final void i(boolean z16) {
        this.isSelected = z16;
    }

    public String toString() {
        return "CartGoodsData(isSelected=" + this.isSelected + ", priceType=" + this.priceType + ", itemData=" + this.itemData + ", count=" + this.count + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CartGoodsData)) {
            return false;
        }
        CartGoodsData cartGoodsData = (CartGoodsData) other;
        return this.isSelected == cartGoodsData.isSelected && this.priceType == cartGoodsData.priceType && Intrinsics.areEqual(this.itemData, cartGoodsData.itemData) && this.count == cartGoodsData.count;
    }

    public /* synthetic */ CartGoodsData(boolean z16, PriceType priceType, az azVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, priceType, azVar, (i16 & 8) != 0 ? 1 : i3);
    }
}
