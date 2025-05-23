package com.tencent.ecommerce.biz.detail.dataprocessor.processor;

import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.ECTxVideoSellerProductProcessor;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.c;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.d;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.e;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.f;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.g;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/b;", "", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/ECProductDetailDataParserType;", "type", "Lcom/tencent/ecommerce/base/ui/component/IECPTSProcessor;", "a", "", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/a;", "Ljava/util/Map;", "processorMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<ECProductDetailDataParserType, a> processorMap;

    /* renamed from: b, reason: collision with root package name */
    public static final b f102022b = new b();

    static {
        Map<ECProductDetailDataParserType, a> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataUnknown, new com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.a()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataHostGoodsTypeSaas, new g()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataHostGoodsTypeHonorKing, new f()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataHostGoodsTypeTXVideo, new ECTxVideoSellerProductProcessor()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataCustomNormal, new com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.b()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataHostRelated, new e()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataCustomRelated, new d()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataCustomRealtime, new c()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataUnavailable, new h()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataBizTypeShop, new vh0.c()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataBizTypeShopChooseSkuInfo, new vh0.a()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataBizTypeShopRecommend, new vh0.f()), TuplesKt.to(ECProductDetailDataParserType.ECProductComment, new vh0.b()), TuplesKt.to(ECProductDetailDataParserType.ECOrderSnapshot, new com.tencent.ecommerce.biz.orders.buyerorders.snapshot.b()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataBizTypeShopDistributor, new vh0.d()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataBizTypeShopSelect, new vh0.g()), TuplesKt.to(ECProductDetailDataParserType.ECProductDetailDataBizTypeShopOffSale, new vh0.e()));
        processorMap = mapOf;
    }

    b() {
    }

    public final IECPTSProcessor a(ECProductDetailDataParserType type) {
        a aVar = processorMap.get(type);
        return aVar != null ? aVar : new com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas.a();
    }
}
