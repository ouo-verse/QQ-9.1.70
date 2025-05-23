package com.tencent.ecommerce.biz.detail.repo.shop;

import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductCommentInfo;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailBuyFloatPageInfo;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailRelatedInfo;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailSkuStockInfo;
import com.tencent.ecommerce.biz.detail.repo.shop.data.d;
import com.tencent.ecommerce.biz.detail.repo.shop.data.f;
import com.tencent.ecommerce.biz.hr.module.e;
import com.tencent.ecommerce.biz.shophome.repo.ECShareInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J'\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0012J%\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001dJ=\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'J-\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,J%\u0010/\u001a\u0004\u0018\u00010\u000e2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\rJ#\u00101\u001a\u0002002\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\rJ/\u00103\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00108R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b:\u0010<\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006@"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/ECShopProductDetailRepository;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "detailInfo", "", "b", "", "getShopDetailCacheCommentCookie", "productId", "extKeyString", "getShopDetailCacheData", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;", "updateSkuInfoDataToCache", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "params", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/g;", "getShopProductDetailRelatedData", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/j;", "getSkuStockInfoData", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "getShopLiveStatus", "(Lorg/json/JSONObject;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "service", "method", "getShopProductDetailData", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "spuId", "", "shareAction", "appId", "arkViewName", "version", "Lcom/tencent/ecommerce/biz/shophome/repo/b;", "getShopProductShareInfo", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sortType", "cookie", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/a;", "getShopProductCommentData", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shopId", "brandId", "getBrandQuaLinks", "Lxh0/a;", "checkApplySampleQualified", "activeId", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Ljava/lang/String;", "commentCookie", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/d;", "c", "Lkotlin/Lazy;", "()Lcom/tencent/ecommerce/biz/detail/repo/shop/data/d;", "cache", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailRepository implements IECShopProductDetailRepository {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy cache;

    /* renamed from: d, reason: collision with root package name */
    public static final ECShopProductDetailRepository f102321d = new ECShopProductDetailRepository();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static String commentCookie = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.ecommerce.biz.detail.repo.shop.ECShopProductDetailRepository$cache$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return d.f102363c;
            }
        });
        cache = lazy;
    }

    ECShopProductDetailRepository() {
    }

    private final void b(ECShopProductDetailInfo detailInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("detail", detailInfo.infoData);
        jSONObject.put("comment", new JSONObject().toString());
        e.f102613b.b(detailInfo.productID, jSONObject.toString());
    }

    private final d c() {
        return (d) cache.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object checkApplySampleQualified(String str, String str2, Continuation<? super xh0.a> continuation) {
        ECShopProductDetailRepository$checkApplySampleQualified$1 eCShopProductDetailRepository$checkApplySampleQualified$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopProductDetailRepository$checkApplySampleQualified$1) {
            eCShopProductDetailRepository$checkApplySampleQualified$1 = (ECShopProductDetailRepository$checkApplySampleQualified$1) continuation;
            int i16 = eCShopProductDetailRepository$checkApplySampleQualified$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$checkApplySampleQualified$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$checkApplySampleQualified$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRepository$checkApplySampleQualified$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? jSONObject = new JSONObject();
                    jSONObject.put("shop_id", str);
                    jSONObject.put("spu_id", str2);
                    Unit unit = Unit.INSTANCE;
                    objectRef.element = jSONObject;
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECShopProductDetailRepository$checkApplySampleQualified$response$1 eCShopProductDetailRepository$checkApplySampleQualified$response$1 = new ECShopProductDetailRepository$checkApplySampleQualified$response$1(objectRef, null);
                    eCShopProductDetailRepository$checkApplySampleQualified$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailRepository$checkApplySampleQualified$response$1, eCShopProductDetailRepository$checkApplySampleQualified$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                xh0.a aVar = new xh0.a();
                aVar.a(eCNetworkResponse.getCode());
                aVar.b(eCNetworkResponse.getMessage());
                if (eCNetworkResponse.getCode() == 0) {
                    aVar.decodeData((JSONObject) eCNetworkResponse.b());
                }
                return aVar;
            }
        }
        eCShopProductDetailRepository$checkApplySampleQualified$1 = new ECShopProductDetailRepository$checkApplySampleQualified$1(this, continuation);
        Object obj2 = eCShopProductDetailRepository$checkApplySampleQualified$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRepository$checkApplySampleQualified$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        xh0.a aVar2 = new xh0.a();
        aVar2.a(eCNetworkResponse.getCode());
        aVar2.b(eCNetworkResponse.getMessage());
        if (eCNetworkResponse.getCode() == 0) {
        }
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object d(String str, String str2, String str3, Continuation<? super ECShopProductDetailBuyFloatPageInfo> continuation) {
        ECShopProductDetailRepository$updateSkuInfoDataToCache$3 eCShopProductDetailRepository$updateSkuInfoDataToCache$3;
        Object coroutine_suspended;
        int i3;
        ECShopProductDetailRepository eCShopProductDetailRepository;
        ECShopProductDetailBuyFloatPageInfo eCShopProductDetailBuyFloatPageInfo;
        if (continuation instanceof ECShopProductDetailRepository$updateSkuInfoDataToCache$3) {
            eCShopProductDetailRepository$updateSkuInfoDataToCache$3 = (ECShopProductDetailRepository$updateSkuInfoDataToCache$3) continuation;
            int i16 = eCShopProductDetailRepository$updateSkuInfoDataToCache$3.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$updateSkuInfoDataToCache$3.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$updateSkuInfoDataToCache$3.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRepository$updateSkuInfoDataToCache$3.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("spu_id", str2);
                    jSONObject.put("active_id", str3 != null ? str3 : "");
                    eCShopProductDetailRepository$updateSkuInfoDataToCache$3.L$0 = this;
                    eCShopProductDetailRepository$updateSkuInfoDataToCache$3.L$1 = str3;
                    eCShopProductDetailRepository$updateSkuInfoDataToCache$3.label = 1;
                    obj = e("trpc.ecom.qq_shop_detail_svr.ProductCard", str, jSONObject, eCShopProductDetailRepository$updateSkuInfoDataToCache$3);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCShopProductDetailRepository = this;
                } else if (i3 == 1) {
                    str3 = (String) eCShopProductDetailRepository$updateSkuInfoDataToCache$3.L$1;
                    eCShopProductDetailRepository = (ECShopProductDetailRepository) eCShopProductDetailRepository$updateSkuInfoDataToCache$3.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCShopProductDetailBuyFloatPageInfo = (ECShopProductDetailBuyFloatPageInfo) obj;
                if (eCShopProductDetailBuyFloatPageInfo != null) {
                    eCShopProductDetailRepository.c().g(eCShopProductDetailBuyFloatPageInfo.productID, eCShopProductDetailBuyFloatPageInfo, str3);
                }
                return eCShopProductDetailBuyFloatPageInfo;
            }
        }
        eCShopProductDetailRepository$updateSkuInfoDataToCache$3 = new ECShopProductDetailRepository$updateSkuInfoDataToCache$3(this, continuation);
        Object obj2 = eCShopProductDetailRepository$updateSkuInfoDataToCache$3.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRepository$updateSkuInfoDataToCache$3.label;
        if (i3 != 0) {
        }
        eCShopProductDetailBuyFloatPageInfo = (ECShopProductDetailBuyFloatPageInfo) obj2;
        if (eCShopProductDetailBuyFloatPageInfo != null) {
        }
        return eCShopProductDetailBuyFloatPageInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object e(String str, String str2, JSONObject jSONObject, Continuation<? super ECShopProductDetailBuyFloatPageInfo> continuation) {
        ECShopProductDetailRepository$updateSkuInfoDataToCache$2 eCShopProductDetailRepository$updateSkuInfoDataToCache$2;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopProductDetailRepository$updateSkuInfoDataToCache$2) {
            eCShopProductDetailRepository$updateSkuInfoDataToCache$2 = (ECShopProductDetailRepository$updateSkuInfoDataToCache$2) continuation;
            int i16 = eCShopProductDetailRepository$updateSkuInfoDataToCache$2.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$updateSkuInfoDataToCache$2.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$updateSkuInfoDataToCache$2.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRepository$updateSkuInfoDataToCache$2.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECShopProductDetailRepository$updateSkuInfoDataToCache$response$1 eCShopProductDetailRepository$updateSkuInfoDataToCache$response$1 = new ECShopProductDetailRepository$updateSkuInfoDataToCache$response$1(str, str2, jSONObject, null);
                    eCShopProductDetailRepository$updateSkuInfoDataToCache$2.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailRepository$updateSkuInfoDataToCache$response$1, eCShopProductDetailRepository$updateSkuInfoDataToCache$2);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    return (ECShopProductDetailBuyFloatPageInfo) eCNetworkResponse.b();
                }
                cg0.a.a("ECShopDetailRepository", "updateSkuInfoDataToCache", "update sku info error,[errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage() + ']');
                return null;
            }
        }
        eCShopProductDetailRepository$updateSkuInfoDataToCache$2 = new ECShopProductDetailRepository$updateSkuInfoDataToCache$2(this, continuation);
        Object obj2 = eCShopProductDetailRepository$updateSkuInfoDataToCache$2.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRepository$updateSkuInfoDataToCache$2.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject, T] */
    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getBrandQuaLinks(String str, String str2, Continuation<? super JSONObject> continuation) {
        ECShopProductDetailRepository$getBrandQuaLinks$1 eCShopProductDetailRepository$getBrandQuaLinks$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopProductDetailRepository$getBrandQuaLinks$1) {
            eCShopProductDetailRepository$getBrandQuaLinks$1 = (ECShopProductDetailRepository$getBrandQuaLinks$1) continuation;
            int i16 = eCShopProductDetailRepository$getBrandQuaLinks$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$getBrandQuaLinks$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$getBrandQuaLinks$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRepository$getBrandQuaLinks$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    int i17 = TextUtils.isDigitsOnly(str2) ? 1 : 2;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? jSONObject = new JSONObject();
                    jSONObject.put("shop_id", str);
                    jSONObject.put("brand_id", str2);
                    jSONObject.put("brand_type", i17);
                    Unit unit = Unit.INSTANCE;
                    objectRef.element = jSONObject;
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECShopProductDetailRepository$getBrandQuaLinks$response$1 eCShopProductDetailRepository$getBrandQuaLinks$response$1 = new ECShopProductDetailRepository$getBrandQuaLinks$response$1(objectRef, null);
                    eCShopProductDetailRepository$getBrandQuaLinks$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailRepository$getBrandQuaLinks$response$1, eCShopProductDetailRepository$getBrandQuaLinks$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    return eCNetworkResponse.b();
                }
                cg0.a.a("ECShopDetailRepository", "getBrandQuaLinks", "getBrandQuaLinks error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCShopProductDetailRepository$getBrandQuaLinks$1 = new ECShopProductDetailRepository$getBrandQuaLinks$1(this, continuation);
        Object obj2 = eCShopProductDetailRepository$getBrandQuaLinks$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRepository$getBrandQuaLinks$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    public String getShopDetailCacheCommentCookie() {
        return commentCookie;
    }

    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    public ECShopProductDetailInfo getShopDetailCacheData(String productId, String extKeyString) {
        return c().e(productId, extKeyString);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopLiveStatus(JSONObject jSONObject, CoroutineDispatcher coroutineDispatcher, Continuation<? super f> continuation) {
        ECShopProductDetailRepository$getShopLiveStatus$1 eCShopProductDetailRepository$getShopLiveStatus$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopProductDetailRepository$getShopLiveStatus$1) {
            eCShopProductDetailRepository$getShopLiveStatus$1 = (ECShopProductDetailRepository$getShopLiveStatus$1) continuation;
            int i16 = eCShopProductDetailRepository$getShopLiveStatus$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$getShopLiveStatus$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$getShopLiveStatus$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRepository$getShopLiveStatus$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECShopProductDetailRepository$getShopLiveStatus$response$1 eCShopProductDetailRepository$getShopLiveStatus$response$1 = new ECShopProductDetailRepository$getShopLiveStatus$response$1(jSONObject, null);
                    eCShopProductDetailRepository$getShopLiveStatus$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailRepository$getShopLiveStatus$response$1, eCShopProductDetailRepository$getShopLiveStatus$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    return eCNetworkResponse.b();
                }
                cg0.a.a("ECShopDetailRepository", "getShopLiveStatus", "get shop detail live status error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCShopProductDetailRepository$getShopLiveStatus$1 = new ECShopProductDetailRepository$getShopLiveStatus$1(this, continuation);
        Object obj2 = eCShopProductDetailRepository$getShopLiveStatus$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRepository$getShopLiveStatus$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopProductCommentData(String str, int i3, String str2, Continuation<? super ECShopProductCommentInfo> continuation) {
        ECShopProductDetailRepository$getShopProductCommentData$1 eCShopProductDetailRepository$getShopProductCommentData$1;
        Object coroutine_suspended;
        int i16;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopProductDetailRepository$getShopProductCommentData$1) {
            eCShopProductDetailRepository$getShopProductCommentData$1 = (ECShopProductDetailRepository$getShopProductCommentData$1) continuation;
            int i17 = eCShopProductDetailRepository$getShopProductCommentData$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$getShopProductCommentData$1.label = i17 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$getShopProductCommentData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = eCShopProductDetailRepository$getShopProductCommentData$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? jSONObject = new JSONObject();
                    jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, str);
                    jSONObject.put("sort_type", i3);
                    jSONObject.put("cookie", str2);
                    Unit unit = Unit.INSTANCE;
                    objectRef.element = jSONObject;
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECShopProductDetailRepository$getShopProductCommentData$response$1 eCShopProductDetailRepository$getShopProductCommentData$response$1 = new ECShopProductDetailRepository$getShopProductCommentData$response$1(objectRef, null);
                    eCShopProductDetailRepository$getShopProductCommentData$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailRepository$getShopProductCommentData$response$1, eCShopProductDetailRepository$getShopProductCommentData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i16 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    return eCNetworkResponse.b();
                }
                cg0.a.a("ECShopDetailRepository", "getShopDetailCommentData", "getShopDetailCommentData error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCShopProductDetailRepository$getShopProductCommentData$1 = new ECShopProductDetailRepository$getShopProductCommentData$1(this, continuation);
        Object obj2 = eCShopProductDetailRepository$getShopProductCommentData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = eCShopProductDetailRepository$getShopProductCommentData$1.label;
        if (i16 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopProductDetailData(String str, String str2, JSONObject jSONObject, Continuation<? super ECShopProductDetailInfo> continuation) {
        ECShopProductDetailRepository$getShopProductDetailData$1 eCShopProductDetailRepository$getShopProductDetailData$1;
        Object coroutine_suspended;
        int i3;
        ECShopProductDetailRepository eCShopProductDetailRepository;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopProductDetailRepository$getShopProductDetailData$1) {
            eCShopProductDetailRepository$getShopProductDetailData$1 = (ECShopProductDetailRepository$getShopProductDetailData$1) continuation;
            int i16 = eCShopProductDetailRepository$getShopProductDetailData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$getShopProductDetailData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$getShopProductDetailData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRepository$getShopProductDetailData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECShopProductDetailRepository$getShopProductDetailData$response$1 eCShopProductDetailRepository$getShopProductDetailData$response$1 = new ECShopProductDetailRepository$getShopProductDetailData$response$1(str, str2, jSONObject, null);
                    eCShopProductDetailRepository$getShopProductDetailData$1.L$0 = this;
                    eCShopProductDetailRepository$getShopProductDetailData$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailRepository$getShopProductDetailData$response$1, eCShopProductDetailRepository$getShopProductDetailData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCShopProductDetailRepository = this;
                } else if (i3 == 1) {
                    eCShopProductDetailRepository = (ECShopProductDetailRepository) eCShopProductDetailRepository$getShopProductDetailData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    ECShopProductDetailInfo eCShopProductDetailInfo = (ECShopProductDetailInfo) eCNetworkResponse.b();
                    if (eCShopProductDetailInfo != null) {
                        eCShopProductDetailRepository.c().a(eCShopProductDetailInfo.productID, eCShopProductDetailInfo);
                        eCShopProductDetailRepository.b(eCShopProductDetailInfo);
                    }
                    return eCShopProductDetailInfo;
                }
                cg0.a.a("ECShopDetailRepository", "getShopProductDetailData", "get shop detail error, [errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage() + ']');
                return null;
            }
        }
        eCShopProductDetailRepository$getShopProductDetailData$1 = new ECShopProductDetailRepository$getShopProductDetailData$1(this, continuation);
        Object obj2 = eCShopProductDetailRepository$getShopProductDetailData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRepository$getShopProductDetailData$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopProductDetailRelatedData(JSONObject jSONObject, Continuation<? super ECShopProductDetailRelatedInfo> continuation) {
        ECShopProductDetailRepository$getShopProductDetailRelatedData$1 eCShopProductDetailRepository$getShopProductDetailRelatedData$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopProductDetailRepository$getShopProductDetailRelatedData$1) {
            eCShopProductDetailRepository$getShopProductDetailRelatedData$1 = (ECShopProductDetailRepository$getShopProductDetailRelatedData$1) continuation;
            int i16 = eCShopProductDetailRepository$getShopProductDetailRelatedData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$getShopProductDetailRelatedData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$getShopProductDetailRelatedData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRepository$getShopProductDetailRelatedData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECShopProductDetailRepository$getShopProductDetailRelatedData$response$1 eCShopProductDetailRepository$getShopProductDetailRelatedData$response$1 = new ECShopProductDetailRepository$getShopProductDetailRelatedData$response$1(jSONObject, null);
                    eCShopProductDetailRepository$getShopProductDetailRelatedData$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailRepository$getShopProductDetailRelatedData$response$1, eCShopProductDetailRepository$getShopProductDetailRelatedData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    return eCNetworkResponse.b();
                }
                cg0.a.a("ECShopDetailRepository", "getSellerShopDetailRelatedData", "get seller shop related detail error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCShopProductDetailRepository$getShopProductDetailRelatedData$1 = new ECShopProductDetailRepository$getShopProductDetailRelatedData$1(this, continuation);
        Object obj2 = eCShopProductDetailRepository$getShopProductDetailRelatedData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRepository$getShopProductDetailRelatedData$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopProductShareInfo(String str, int i3, String str2, String str3, String str4, Continuation<? super ECShareInfo> continuation) {
        ECShopProductDetailRepository$getShopProductShareInfo$1 eCShopProductDetailRepository$getShopProductShareInfo$1;
        Object coroutine_suspended;
        int i16;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopProductDetailRepository$getShopProductShareInfo$1) {
            eCShopProductDetailRepository$getShopProductShareInfo$1 = (ECShopProductDetailRepository$getShopProductShareInfo$1) continuation;
            int i17 = eCShopProductDetailRepository$getShopProductShareInfo$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$getShopProductShareInfo$1.label = i17 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$getShopProductShareInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = eCShopProductDetailRepository$getShopProductShareInfo$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? jSONObject = new JSONObject();
                    jSONObject.put("spu_id", str);
                    int i18 = 2;
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 9) {
                                i18 = 3;
                            } else if (i3 == 10) {
                                i18 = 4;
                            } else if (i3 != 72 && i3 != 73) {
                                i18 = 0;
                            }
                        }
                        jSONObject.put("type", i18);
                        jSONObject.put("app", str2);
                        jSONObject.put("view", str3);
                        jSONObject.put("ver", str4);
                        Unit unit = Unit.INSTANCE;
                        objectRef.element = jSONObject;
                        CoroutineDispatcher coroutineDispatcher = dispatcher;
                        ECShopProductDetailRepository$getShopProductShareInfo$response$1 eCShopProductDetailRepository$getShopProductShareInfo$response$1 = new ECShopProductDetailRepository$getShopProductShareInfo$response$1(objectRef, null);
                        eCShopProductDetailRepository$getShopProductShareInfo$1.label = 1;
                        obj = BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailRepository$getShopProductShareInfo$response$1, eCShopProductDetailRepository$getShopProductShareInfo$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    i18 = 1;
                    jSONObject.put("type", i18);
                    jSONObject.put("app", str2);
                    jSONObject.put("view", str3);
                    jSONObject.put("ver", str4);
                    Unit unit2 = Unit.INSTANCE;
                    objectRef.element = jSONObject;
                    CoroutineDispatcher coroutineDispatcher2 = dispatcher;
                    ECShopProductDetailRepository$getShopProductShareInfo$response$1 eCShopProductDetailRepository$getShopProductShareInfo$response$12 = new ECShopProductDetailRepository$getShopProductShareInfo$response$1(objectRef, null);
                    eCShopProductDetailRepository$getShopProductShareInfo$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher2, eCShopProductDetailRepository$getShopProductShareInfo$response$12, eCShopProductDetailRepository$getShopProductShareInfo$1);
                    if (obj == coroutine_suspended) {
                    }
                } else if (i16 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                JSONObject jSONObject2 = (JSONObject) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0 && jSONObject2 != null) {
                    return ECShareInfo.INSTANCE.a(jSONObject2);
                }
                cg0.a.a("ECShopDetailRepository", "getShopProductShareInfo", "get product share info err, errCode:" + eCNetworkResponse.getCode() + ",errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCShopProductDetailRepository$getShopProductShareInfo$1 = new ECShopProductDetailRepository$getShopProductShareInfo$1(this, continuation);
        Object obj2 = eCShopProductDetailRepository$getShopProductShareInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = eCShopProductDetailRepository$getShopProductShareInfo$1.label;
        if (i16 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        JSONObject jSONObject22 = (JSONObject) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() != 0) {
        }
        cg0.a.a("ECShopDetailRepository", "getShopProductShareInfo", "get product share info err, errCode:" + eCNetworkResponse.getCode() + ",errMsg:" + eCNetworkResponse.getMessage());
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getSkuStockInfoData(JSONObject jSONObject, Continuation<? super ECShopProductDetailSkuStockInfo> continuation) {
        ECShopProductDetailRepository$getSkuStockInfoData$1 eCShopProductDetailRepository$getSkuStockInfoData$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopProductDetailRepository$getSkuStockInfoData$1) {
            eCShopProductDetailRepository$getSkuStockInfoData$1 = (ECShopProductDetailRepository$getSkuStockInfoData$1) continuation;
            int i16 = eCShopProductDetailRepository$getSkuStockInfoData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$getSkuStockInfoData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$getSkuStockInfoData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRepository$getSkuStockInfoData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECShopProductDetailRepository$getSkuStockInfoData$response$1 eCShopProductDetailRepository$getSkuStockInfoData$response$1 = new ECShopProductDetailRepository$getSkuStockInfoData$response$1(jSONObject, null);
                    eCShopProductDetailRepository$getSkuStockInfoData$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailRepository$getSkuStockInfoData$response$1, eCShopProductDetailRepository$getSkuStockInfoData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    return eCNetworkResponse.b();
                }
                cg0.a.a("ECShopDetailRepository", "getSkuStockInfoData", "get shop detail sku info error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCShopProductDetailRepository$getSkuStockInfoData$1 = new ECShopProductDetailRepository$getSkuStockInfoData$1(this, continuation);
        Object obj2 = eCShopProductDetailRepository$getSkuStockInfoData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRepository$getSkuStockInfoData$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateSkuInfoDataToCache(String str, String str2, Continuation<? super ECShopProductDetailBuyFloatPageInfo> continuation) {
        ECShopProductDetailRepository$updateSkuInfoDataToCache$1 eCShopProductDetailRepository$updateSkuInfoDataToCache$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECShopProductDetailRepository$updateSkuInfoDataToCache$1) {
            eCShopProductDetailRepository$updateSkuInfoDataToCache$1 = (ECShopProductDetailRepository$updateSkuInfoDataToCache$1) continuation;
            int i16 = eCShopProductDetailRepository$updateSkuInfoDataToCache$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRepository$updateSkuInfoDataToCache$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRepository$updateSkuInfoDataToCache$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRepository$updateSkuInfoDataToCache$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return (ECShopProductDetailBuyFloatPageInfo) obj;
                    }
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return (ECShopProductDetailBuyFloatPageInfo) obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (str2 != null) {
                    if (str2.length() > 0) {
                        eCShopProductDetailRepository$updateSkuInfoDataToCache$1.label = 1;
                        obj = d("/trpc.ecom.qq_shop_detail_svr.ProductCard/GetActiveBuyFloatPage", str, str2, eCShopProductDetailRepository$updateSkuInfoDataToCache$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return (ECShopProductDetailBuyFloatPageInfo) obj;
                    }
                }
                eCShopProductDetailRepository$updateSkuInfoDataToCache$1.label = 2;
                obj = d("/trpc.ecom.qq_shop_detail_svr.ProductCard/GetBuyFloatPageInfo", str, str2, eCShopProductDetailRepository$updateSkuInfoDataToCache$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (ECShopProductDetailBuyFloatPageInfo) obj;
            }
        }
        eCShopProductDetailRepository$updateSkuInfoDataToCache$1 = new ECShopProductDetailRepository$updateSkuInfoDataToCache$1(this, continuation);
        Object obj2 = eCShopProductDetailRepository$updateSkuInfoDataToCache$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRepository$updateSkuInfoDataToCache$1.label;
        if (i3 == 0) {
        }
    }
}
