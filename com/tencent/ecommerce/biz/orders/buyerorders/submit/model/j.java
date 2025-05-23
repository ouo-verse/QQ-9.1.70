package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\bB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "", "", "a", "I", "id", "<init>", "(I)V", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j$a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int id;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j$a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "type", "<init>", "(I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class PhysicalProduct extends j {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int type;

        /* renamed from: hashCode, reason: from getter */
        public int getType() {
            return this.type;
        }

        public String toString() {
            return "PhysicalProduct(type=" + this.type + ")";
        }

        public PhysicalProduct(int i3) {
            super(i3, null);
            this.type = i3;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PhysicalProduct) && this.type == ((PhysicalProduct) other).type;
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J)\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0013\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j$b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "", "d", "", "virtualType", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/k;", "account", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "realNameAccount", "a", "", "toString", "hashCode", "", "other", "equals", "b", "I", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/k;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "()Lcom/tencent/ecommerce/biz/orders/realname/a;", "<init>", "(ILcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/k;Lcom/tencent/ecommerce/biz/orders/realname/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class VirtualProduct extends j {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int virtualType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final VirtualProductAccount account;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final RealNameAccount realNameAccount;

        public /* synthetic */ VirtualProduct(int i3, VirtualProductAccount virtualProductAccount, RealNameAccount realNameAccount, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, virtualProductAccount, (i16 & 4) != 0 ? null : realNameAccount);
        }

        public final VirtualProduct a(int virtualType, VirtualProductAccount account, RealNameAccount realNameAccount) {
            return new VirtualProduct(virtualType, account, realNameAccount);
        }

        /* renamed from: c, reason: from getter */
        public final RealNameAccount getRealNameAccount() {
            return this.realNameAccount;
        }

        public final boolean d() {
            return this.virtualType == 3;
        }

        public int hashCode() {
            int i3 = this.virtualType * 31;
            VirtualProductAccount virtualProductAccount = this.account;
            int hashCode = (i3 + (virtualProductAccount != null ? virtualProductAccount.hashCode() : 0)) * 31;
            RealNameAccount realNameAccount = this.realNameAccount;
            return hashCode + (realNameAccount != null ? realNameAccount.hashCode() : 0);
        }

        public String toString() {
            return "VirtualProduct(virtualType=" + this.virtualType + ", account=" + this.account + ", realNameAccount=" + this.realNameAccount + ")";
        }

        public VirtualProduct(int i3, VirtualProductAccount virtualProductAccount, RealNameAccount realNameAccount) {
            super(i3, null);
            this.virtualType = i3;
            this.account = virtualProductAccount;
            this.realNameAccount = realNameAccount;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VirtualProduct)) {
                return false;
            }
            VirtualProduct virtualProduct = (VirtualProduct) other;
            return this.virtualType == virtualProduct.virtualType && Intrinsics.areEqual(this.account, virtualProduct.account) && Intrinsics.areEqual(this.realNameAccount, virtualProduct.realNameAccount);
        }

        public static /* synthetic */ VirtualProduct b(VirtualProduct virtualProduct, int i3, VirtualProductAccount virtualProductAccount, RealNameAccount realNameAccount, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = virtualProduct.virtualType;
            }
            if ((i16 & 2) != 0) {
                virtualProductAccount = virtualProduct.account;
            }
            if ((i16 & 4) != 0) {
                realNameAccount = virtualProduct.realNameAccount;
            }
            return virtualProduct.a(i3, virtualProductAccount, realNameAccount);
        }
    }

    j(int i3) {
        this.id = i3;
    }

    public /* synthetic */ j(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }
}
