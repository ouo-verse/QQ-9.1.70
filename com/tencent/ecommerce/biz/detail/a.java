package com.tencent.ecommerce.biz.detail;

import hg0.b;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ&\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/a;", "", "", "d", "", "shareAction", "", "productId", "", "isShareSucceed", "c", "sellerId", "isSucceed", "b", "Lhg0/b;", "a", "Lhg0/b;", "shareSpan", "Ljava/lang/String;", "spanName", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b shareSpan = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String spanName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f102017c = new AtomicInteger(1);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/a$a;", "", "", "a", "()Ljava/lang/String;", "spanName", "GOODS_DETAIL_SHARE_ACTION", "Ljava/lang/String;", "GOODS_DETAIL_SHARE_PRODUCT_ID", "GOODS_DETAIL_SHARE_PRODUCT_SELLER_ID", "GOODS_DETAIL_SHARE_TRACE_INFO", "REQUEST_ARK_DATA_STATUS", "REQUEST_ARK_DATA_STATUS_CODE", "Ljava/util/concurrent/atomic/AtomicInteger;", "shareSpanNum", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.detail.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final String a() {
            return "goods.detail.share_" + a.f102017c.getAndIncrement();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String str) {
        this.spanName = str;
    }

    public final void d() {
        b.f(this.shareSpan, this.spanName, null, 2, null);
    }

    public final void c(int shareAction, String productId, boolean isShareSucceed) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("goods.detail.share.action", String.valueOf(shareAction)), TuplesKt.to("goods.detail.share.product.id", productId));
        this.shareSpan.d(this.spanName, mapOf);
        this.shareSpan.b(this.spanName, 1 ^ (isShareSucceed ? 1 : 0));
    }

    public final void b(int shareAction, String productId, String sellerId, boolean isSucceed) {
        String str;
        Map<String, String> mapOf;
        if (isSucceed) {
            str = "0";
        } else {
            str = "1";
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("goods.detail.share.action", String.valueOf(shareAction)), TuplesKt.to("goods.detail.share.product.id", productId), TuplesKt.to("goods.detail.share.product.seller.id", sellerId), TuplesKt.to("requestArkDataStatusCode", str), TuplesKt.to("goods.detail.share.trace.info", this.shareSpan.c(this.spanName)));
        this.shareSpan.a(this.spanName, "requestArkDataStatus", mapOf);
    }
}
