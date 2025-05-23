package com.tencent.ecommerce.biz.orders.sellerorders.orderfilter;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0007\u000b\f\rB\u0019\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "", "", "toString", "a", "Ljava/lang/String;", "label", "b", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "d", "e", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$a;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$e;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$d;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$c;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String label;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String key;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$a;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a extends g {

        /* renamed from: c, reason: collision with root package name */
        public static final a f103876c = new a();

        a() {
            super("\u5168\u90e8", "all", null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$b;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "", "c", "J", "beginTimeSeconds", "d", "endTimeSeconds", "<init>", "(JJ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends g {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final long beginTimeSeconds;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final long endTimeSeconds;

        public b(long j3, long j16) {
            super("\u81ea\u5b9a\u4e49", "custom", null);
            this.beginTimeSeconds = j3;
            this.endTimeSeconds = j16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$c;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends g {

        /* renamed from: c, reason: collision with root package name */
        public static final c f103879c = new c();

        c() {
            super("\u8fd1 30 \u5929", "last_30", null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$d;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends g {

        /* renamed from: c, reason: collision with root package name */
        public static final d f103880c = new d();

        d() {
            super("\u8fd1 7 \u5929", "last_7", null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g$e;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e extends g {

        /* renamed from: c, reason: collision with root package name */
        public static final e f103881c = new e();

        e() {
            super("\u4eca\u5929", "today", null);
        }
    }

    g(String str, String str2) {
        this.label = str;
        this.key = str2;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("timeRange:");
        if (this instanceof b) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Custom(");
            b bVar = (b) this;
            sb6.append(bVar.beginTimeSeconds);
            sb6.append(" - ");
            sb6.append(bVar.endTimeSeconds);
            sb6.append(')');
            str = sb6.toString();
        } else {
            str = this.label;
        }
        sb5.append(str);
        return sb5.toString();
    }

    public /* synthetic */ g(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }
}
