package com.tencent.ecommerce.biz.detail.utils;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\nR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/utils/b;", "", "", "a", "Lcom/tencent/ecommerce/biz/detail/utils/a;", "ecDetailPageDuration", "", "e", "f", "d", "", AdMetricTag.EVENT_NAME, "b", "J", "startTime", "Lcom/tencent/ecommerce/biz/detail/utils/a;", "c", "Ljava/lang/String;", GetAdInfoRequest.SOURCE_FROM, "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long startTime = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ECDetailPageDuration ecDetailPageDuration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String sourceFrom;

    public b(String str) {
        this.sourceFrom = str;
    }

    private final long a() {
        return System.currentTimeMillis() - this.startTime;
    }

    public final void d() {
        this.startTime = System.currentTimeMillis();
    }

    public final void e(ECDetailPageDuration ecDetailPageDuration) {
        this.ecDetailPageDuration = ecDetailPageDuration;
    }

    public final void b(String eventName) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        d dVar = d.f102466a;
        ECDetailPageDuration eCDetailPageDuration = this.ecDetailPageDuration;
        int i3 = eCDetailPageDuration != null ? eCDetailPageDuration.pgType : 2;
        if (eCDetailPageDuration == null || (str = eCDetailPageDuration.shopId) == null) {
            str = "";
        }
        if (eCDetailPageDuration == null || (str2 = eCDetailPageDuration.spuId) == null) {
            str2 = "";
        }
        if (eCDetailPageDuration == null || (str3 = eCDetailPageDuration.roomId) == null) {
            str3 = "";
        }
        if (eCDetailPageDuration == null || (str4 = eCDetailPageDuration.busId) == null) {
            str4 = "";
        }
        long j3 = eCDetailPageDuration != null ? eCDetailPageDuration.uin : 0L;
        if (eCDetailPageDuration == null || (str5 = eCDetailPageDuration.sellerId) == null) {
            str5 = "";
        }
        String str15 = (eCDetailPageDuration == null || (str14 = eCDetailPageDuration.buyerId) == null) ? "" : str14;
        String valueOf = String.valueOf(a());
        ECDetailPageDuration eCDetailPageDuration2 = this.ecDetailPageDuration;
        dVar.d(i3, str, str2, str3, str4, j3, str5, str15, valueOf, (eCDetailPageDuration2 == null || (str13 = eCDetailPageDuration2.sassId) == null) ? "0" : str13, (eCDetailPageDuration2 == null || (str12 = eCDetailPageDuration2.productId) == null) ? "" : str12, (eCDetailPageDuration2 == null || (str11 = eCDetailPageDuration2.productName) == null) ? "" : str11, (eCDetailPageDuration2 == null || (str10 = eCDetailPageDuration2.priSortId) == null) ? "" : str10, eCDetailPageDuration2 != null ? eCDetailPageDuration2.productPrice : 0L, eCDetailPageDuration2 != null ? eCDetailPageDuration2.productSales : 0L, (eCDetailPageDuration2 == null || (str9 = eCDetailPageDuration2.sourceFrom) == null) ? "0" : str9, (eCDetailPageDuration2 == null || (str8 = eCDetailPageDuration2.contendId) == null) ? "" : str8, (eCDetailPageDuration2 == null || (str7 = eCDetailPageDuration2.sealTransfer) == null) ? "" : str7, (eCDetailPageDuration2 == null || (str6 = eCDetailPageDuration2.requestId) == null) ? "" : str6, eCDetailPageDuration2 != null ? eCDetailPageDuration2.getRole() : 1, eventName);
    }

    public final void f() {
        this.startTime = 0L;
    }

    public static /* synthetic */ void c(b bVar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "all_product_page_duration_from_video";
        }
        bVar.b(str);
    }
}
