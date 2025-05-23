package com.tencent.ecommerce.biz.detail.repo.shop.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0018B\u0011\u0012\b\b\u0002\u0010/\u001a\u00020\n\u00a2\u0006\u0004\b0\u00101J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001b\u0010\b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nJ+\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010&R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0(8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b \u0010*R\u0017\u0010/\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductDetailData;", "", "Lorg/json/JSONObject;", "data", "requestParams", "", "Lcom/tencent/ecommerce/base/ui/b;", "e", "i", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "productId", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "f", "service", "method", tl.h.F, "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shopId", "spuId", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "g", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "b", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "repository", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductDetailRelatedData;", "c", "Lkotlin/Lazy;", "d", "()Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductDetailRelatedData;", "productDetailRelatedData", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_productDetailData", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "productDetailLiveData", "Ljava/lang/String;", "getBizType", "()Ljava/lang/String;", "bizType", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher defaultDispatcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final IECShopProductDetailRepository repository;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy productDetailRelatedData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ECShopProductDetailInfo> _productDetailData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LiveData<ECShopProductDetailInfo> productDetailLiveData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String bizType;

    public ECShopProductDetailData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final ECShopProductDetailRelatedData d() {
        return (ECShopProductDetailRelatedData) this.productDetailRelatedData.getValue();
    }

    public final LiveData<ECShopProductDetailInfo> c() {
        return this.productDetailLiveData;
    }

    public final List<ECBasePtsViewData> e(JSONObject data, JSONObject requestParams) {
        return d().b(data, requestParams);
    }

    public final ECShopProductDetailInfo f(String productId) {
        return IECShopProductDetailRepository.a.a(this.repository, productId, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(String str, String str2, Continuation<? super f> continuation) {
        ECShopProductDetailData$requestLiveStatus$1 eCShopProductDetailData$requestLiveStatus$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECShopProductDetailData$requestLiveStatus$1) {
            eCShopProductDetailData$requestLiveStatus$1 = (ECShopProductDetailData$requestLiveStatus$1) continuation;
            int i16 = eCShopProductDetailData$requestLiveStatus$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailData$requestLiveStatus$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailData$requestLiveStatus$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailData$requestLiveStatus$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("spu_id", str2);
                    jSONObject.put("from", "500002");
                    IECShopProductDetailRepository iECShopProductDetailRepository = this.repository;
                    CoroutineDispatcher coroutineDispatcher = this.defaultDispatcher;
                    eCShopProductDetailData$requestLiveStatus$1.L$0 = str;
                    eCShopProductDetailData$requestLiveStatus$1.label = 1;
                    obj = iECShopProductDetailRepository.getShopLiveStatus(jSONObject, coroutineDispatcher, eCShopProductDetailData$requestLiveStatus$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    str = (String) eCShopProductDetailData$requestLiveStatus$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f fVar = (f) obj;
                d.f102363c.b(str, fVar);
                LifecycleEventBus.f100688b.f(new e(str, fVar));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("rsp live status[shopId:");
                sb5.append(str);
                sb5.append(", info:");
                sb5.append(fVar == null ? fVar.toString() : null);
                sb5.append(']');
                cg0.a.b("ECShopBuyerDetailData", sb5.toString());
                return fVar;
            }
        }
        eCShopProductDetailData$requestLiveStatus$1 = new ECShopProductDetailData$requestLiveStatus$1(this, continuation);
        Object obj2 = eCShopProductDetailData$requestLiveStatus$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailData$requestLiveStatus$1.label;
        if (i3 != 0) {
        }
        f fVar2 = (f) obj2;
        d.f102363c.b(str, fVar2);
        LifecycleEventBus.f100688b.f(new e(str, fVar2));
        StringBuilder sb52 = new StringBuilder();
        sb52.append("rsp live status[shopId:");
        sb52.append(str);
        sb52.append(", info:");
        sb52.append(fVar2 == null ? fVar2.toString() : null);
        sb52.append(']');
        cg0.a.b("ECShopBuyerDetailData", sb52.toString());
        return fVar2;
    }

    public final Object i(JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        return d().c(jSONObject, continuation);
    }

    public ECShopProductDetailData(String str) {
        Lazy lazy;
        this.bizType = str;
        this.defaultDispatcher = Dispatchers.getIO();
        this.repository = com.tencent.ecommerce.biz.detail.repo.shop.a.f102322a.getShopProductDetailRepository();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECShopProductDetailRelatedData>() { // from class: com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailData$productDetailRelatedData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECShopProductDetailRelatedData invoke() {
                return new ECShopProductDetailRelatedData();
            }
        });
        this.productDetailRelatedData = lazy;
        MutableLiveData<ECShopProductDetailInfo> mutableLiveData = new MutableLiveData<>();
        this._productDetailData = mutableLiveData;
        this.productDetailLiveData = mutableLiveData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(String str, String str2, JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        ECShopProductDetailData$requestProductDetailData$1 eCShopProductDetailData$requestProductDetailData$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        if (continuation instanceof ECShopProductDetailData$requestProductDetailData$1) {
            eCShopProductDetailData$requestProductDetailData$1 = (ECShopProductDetailData$requestProductDetailData$1) continuation;
            int i16 = eCShopProductDetailData$requestProductDetailData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailData$requestProductDetailData$1.label = i16 - Integer.MIN_VALUE;
                ECShopProductDetailData$requestProductDetailData$1 eCShopProductDetailData$requestProductDetailData$12 = eCShopProductDetailData$requestProductDetailData$1;
                Object obj = eCShopProductDetailData$requestProductDetailData$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailData$requestProductDetailData$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = new JSONObject();
                    CoroutineDispatcher coroutineDispatcher = this.defaultDispatcher;
                    ECShopProductDetailData$requestProductDetailData$2 eCShopProductDetailData$requestProductDetailData$2 = new ECShopProductDetailData$requestProductDetailData$2(this, str, str2, jSONObject, objectRef2, null);
                    eCShopProductDetailData$requestProductDetailData$12.L$0 = objectRef2;
                    eCShopProductDetailData$requestProductDetailData$12.label = 1;
                    if (BuildersKt.withContext(coroutineDispatcher, eCShopProductDetailData$requestProductDetailData$2, eCShopProductDetailData$requestProductDetailData$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else if (i3 == 1) {
                    objectRef = (Ref.ObjectRef) eCShopProductDetailData$requestProductDetailData$12.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cg0.a.b("ECShopBuyerDetailData", "[requestDataWithModel] data = " + ((JSONObject) objectRef.element));
                return (JSONObject) objectRef.element;
            }
        }
        eCShopProductDetailData$requestProductDetailData$1 = new ECShopProductDetailData$requestProductDetailData$1(this, continuation);
        ECShopProductDetailData$requestProductDetailData$1 eCShopProductDetailData$requestProductDetailData$122 = eCShopProductDetailData$requestProductDetailData$1;
        Object obj2 = eCShopProductDetailData$requestProductDetailData$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailData$requestProductDetailData$122.label;
        if (i3 != 0) {
        }
        cg0.a.b("ECShopBuyerDetailData", "[requestDataWithModel] data = " + ((JSONObject) objectRef.element));
        return (JSONObject) objectRef.element;
    }

    public /* synthetic */ ECShopProductDetailData(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }
}
