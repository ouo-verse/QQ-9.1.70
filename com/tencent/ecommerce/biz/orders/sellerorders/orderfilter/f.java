package com.tencent.ecommerce.biz.orders.sellerorders.orderfilter;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0005\b\rB\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0001\u0003\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f;", "", "", "toString", "", "a", "I", "id", "b", "Ljava/lang/String;", "label", "<init>", "(ILjava/lang/String;)V", "c", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f$a;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f$b;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f$c;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f$a;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a extends f {

        /* renamed from: c, reason: collision with root package name */
        public static final a f103871c = new a();

        a() {
            super(0, "\u5168\u90e8", null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f$b;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends f {

        /* renamed from: c, reason: collision with root package name */
        public static final b f103872c = new b();

        b() {
            super(2, "\u5df2\u7ed3\u7b97", null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f$c;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends f {

        /* renamed from: c, reason: collision with root package name */
        public static final c f103873c = new c();

        c() {
            super(1, "\u672a\u7ed3\u7b97", null);
        }
    }

    f(int i3, String str) {
        this.id = i3;
        this.label = str;
    }

    public String toString() {
        return "Category: " + this.label;
    }

    public /* synthetic */ f(int i3, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str);
    }
}
