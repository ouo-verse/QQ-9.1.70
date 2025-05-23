package com.tencent.ecommerce.biz.shophome.repo;

import bj0.ECShopHomeCategoryListRequest;
import bj0.ECShopHomeProductRequest;
import bj0.ECShopHomeRequest;
import bj0.ECShopHomeSearchResultRecommendRequest;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0011J#\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ=\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/repo/ECShopHomeDefaultRepository;", "Lcom/tencent/ecommerce/biz/shophome/repo/IECShopHomeRepository;", "Lbj0/c;", "shopHomeRequest", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lcom/tencent/ecommerce/base/network/api/d;", "Lorg/json/JSONObject;", "getShopHomePageData", "(Lbj0/c;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lbj0/b;", "shopHomeProductRequest", "getShopHomeProductList", "(Lbj0/b;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "shopId", "getShopHomeQualificationData", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lbj0/d;", "searchResultRecommendRequest", "getShopHomeSearchResultRecommendData", "(Lbj0/d;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unbindShopPromotoer", "Lbj0/a;", "categoryListRequest", "getShopHomeCategoryList", "(Lbj0/a;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "shareAction", "appId", "arkViewName", "version", "Lcom/tencent/ecommerce/biz/shophome/repo/b;", "getShopShareInfo", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeDefaultRepository implements IECShopHomeRepository {

    /* renamed from: a, reason: collision with root package name */
    public static final ECShopHomeDefaultRepository f104251a = new ECShopHomeDefaultRepository();

    ECShopHomeDefaultRepository() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopHomeCategoryList(ECShopHomeCategoryListRequest eCShopHomeCategoryListRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super JSONObject> continuation) {
        ECShopHomeDefaultRepository$getShopHomeCategoryList$1 eCShopHomeDefaultRepository$getShopHomeCategoryList$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopHomeDefaultRepository$getShopHomeCategoryList$1) {
            eCShopHomeDefaultRepository$getShopHomeCategoryList$1 = (ECShopHomeDefaultRepository$getShopHomeCategoryList$1) continuation;
            int i16 = eCShopHomeDefaultRepository$getShopHomeCategoryList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopHomeDefaultRepository$getShopHomeCategoryList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopHomeDefaultRepository$getShopHomeCategoryList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopHomeDefaultRepository$getShopHomeCategoryList$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECShopHomeDefaultRepository$getShopHomeCategoryList$response$1 eCShopHomeDefaultRepository$getShopHomeCategoryList$response$1 = new ECShopHomeDefaultRepository$getShopHomeCategoryList$response$1(eCShopHomeCategoryListRequest, null);
                    eCShopHomeDefaultRepository$getShopHomeCategoryList$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopHomeDefaultRepository$getShopHomeCategoryList$response$1, eCShopHomeDefaultRepository$getShopHomeCategoryList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeCategory] code = " + eCNetworkResponse.getCode() + ", data = " + ((JSONObject) eCNetworkResponse.b()));
                if (eCNetworkResponse.getCode() != 0) {
                    JSONObject jSONObject = (JSONObject) eCNetworkResponse.b();
                    return jSONObject != null ? jSONObject : new JSONObject();
                }
                cg0.a.a("ECShopHomeDefaultRepository", "[getShopHomeCategory]", "code = " + eCNetworkResponse.getCode());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", eCNetworkResponse.getCode());
                jSONObject2.put("msg", eCNetworkResponse.getMessage());
                return jSONObject2;
            }
        }
        eCShopHomeDefaultRepository$getShopHomeCategoryList$1 = new ECShopHomeDefaultRepository$getShopHomeCategoryList$1(this, continuation);
        Object obj2 = eCShopHomeDefaultRepository$getShopHomeCategoryList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopHomeDefaultRepository$getShopHomeCategoryList$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeCategory] code = " + eCNetworkResponse.getCode() + ", data = " + ((JSONObject) eCNetworkResponse.b()));
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopHomePageData(ECShopHomeRequest eCShopHomeRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        ECShopHomeDefaultRepository$getShopHomePageData$1 eCShopHomeDefaultRepository$getShopHomePageData$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECShopHomeDefaultRepository$getShopHomePageData$1) {
            eCShopHomeDefaultRepository$getShopHomePageData$1 = (ECShopHomeDefaultRepository$getShopHomePageData$1) continuation;
            int i16 = eCShopHomeDefaultRepository$getShopHomePageData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopHomeDefaultRepository$getShopHomePageData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopHomeDefaultRepository$getShopHomePageData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopHomeDefaultRepository$getShopHomePageData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECShopHomeDefaultRepository$getShopHomePageData$response$1 eCShopHomeDefaultRepository$getShopHomePageData$response$1 = new ECShopHomeDefaultRepository$getShopHomePageData$response$1(eCShopHomeRequest, null);
                    eCShopHomeDefaultRepository$getShopHomePageData$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopHomeDefaultRepository$getShopHomePageData$response$1, eCShopHomeDefaultRepository$getShopHomePageData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomePageData] code = " + eCNetworkResponse.getCode() + ", data = " + ((JSONObject) eCNetworkResponse.b()) + ", msg = " + eCNetworkResponse.getMessage());
                return eCNetworkResponse;
            }
        }
        eCShopHomeDefaultRepository$getShopHomePageData$1 = new ECShopHomeDefaultRepository$getShopHomePageData$1(this, continuation);
        Object obj2 = eCShopHomeDefaultRepository$getShopHomePageData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopHomeDefaultRepository$getShopHomePageData$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomePageData] code = " + eCNetworkResponse2.getCode() + ", data = " + ((JSONObject) eCNetworkResponse2.b()) + ", msg = " + eCNetworkResponse2.getMessage());
        return eCNetworkResponse2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopHomeProductList(ECShopHomeProductRequest eCShopHomeProductRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        ECShopHomeDefaultRepository$getShopHomeProductList$1 eCShopHomeDefaultRepository$getShopHomeProductList$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECShopHomeDefaultRepository$getShopHomeProductList$1) {
            eCShopHomeDefaultRepository$getShopHomeProductList$1 = (ECShopHomeDefaultRepository$getShopHomeProductList$1) continuation;
            int i16 = eCShopHomeDefaultRepository$getShopHomeProductList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopHomeDefaultRepository$getShopHomeProductList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopHomeDefaultRepository$getShopHomeProductList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopHomeDefaultRepository$getShopHomeProductList$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECShopHomeDefaultRepository$getShopHomeProductList$response$1 eCShopHomeDefaultRepository$getShopHomeProductList$response$1 = new ECShopHomeDefaultRepository$getShopHomeProductList$response$1(eCShopHomeProductRequest, null);
                    eCShopHomeDefaultRepository$getShopHomeProductList$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopHomeDefaultRepository$getShopHomeProductList$response$1, eCShopHomeDefaultRepository$getShopHomeProductList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeProductList] code = " + eCNetworkResponse.getCode() + ", data = " + ((JSONObject) eCNetworkResponse.b()) + ", msg = " + eCNetworkResponse.getMessage());
                return eCNetworkResponse;
            }
        }
        eCShopHomeDefaultRepository$getShopHomeProductList$1 = new ECShopHomeDefaultRepository$getShopHomeProductList$1(this, continuation);
        Object obj2 = eCShopHomeDefaultRepository$getShopHomeProductList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopHomeDefaultRepository$getShopHomeProductList$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeProductList] code = " + eCNetworkResponse2.getCode() + ", data = " + ((JSONObject) eCNetworkResponse2.b()) + ", msg = " + eCNetworkResponse2.getMessage());
        return eCNetworkResponse2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopHomeQualificationData(String str, CoroutineDispatcher coroutineDispatcher, Continuation<? super JSONObject> continuation) {
        ECShopHomeDefaultRepository$getShopHomeQualificationData$1 eCShopHomeDefaultRepository$getShopHomeQualificationData$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopHomeDefaultRepository$getShopHomeQualificationData$1) {
            eCShopHomeDefaultRepository$getShopHomeQualificationData$1 = (ECShopHomeDefaultRepository$getShopHomeQualificationData$1) continuation;
            int i16 = eCShopHomeDefaultRepository$getShopHomeQualificationData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopHomeDefaultRepository$getShopHomeQualificationData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopHomeDefaultRepository$getShopHomeQualificationData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopHomeDefaultRepository$getShopHomeQualificationData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECShopHomeDefaultRepository$getShopHomeQualificationData$response$1 eCShopHomeDefaultRepository$getShopHomeQualificationData$response$1 = new ECShopHomeDefaultRepository$getShopHomeQualificationData$response$1(str, null);
                    eCShopHomeDefaultRepository$getShopHomeQualificationData$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopHomeDefaultRepository$getShopHomeQualificationData$response$1, eCShopHomeDefaultRepository$getShopHomeQualificationData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeQualificationData] code = " + eCNetworkResponse.getCode() + ", data = " + ((JSONObject) eCNetworkResponse.b()));
                if (eCNetworkResponse.getCode() != 0) {
                    JSONObject jSONObject = (JSONObject) eCNetworkResponse.b();
                    return jSONObject != null ? jSONObject : new JSONObject();
                }
                cg0.a.a("ECShopHomeDefaultRepository", "[getShopHomeQualificationData]", "code = " + eCNetworkResponse.getCode());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", eCNetworkResponse.getCode());
                jSONObject2.put("msg", eCNetworkResponse.getMessage());
                return jSONObject2;
            }
        }
        eCShopHomeDefaultRepository$getShopHomeQualificationData$1 = new ECShopHomeDefaultRepository$getShopHomeQualificationData$1(this, continuation);
        Object obj2 = eCShopHomeDefaultRepository$getShopHomeQualificationData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopHomeDefaultRepository$getShopHomeQualificationData$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeQualificationData] code = " + eCNetworkResponse.getCode() + ", data = " + ((JSONObject) eCNetworkResponse.b()));
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopHomeSearchResultRecommendData(ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1 eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1) {
            eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1 = (ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1) continuation;
            int i16 = eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1 eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1 = new ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1(eCShopHomeSearchResultRecommendRequest, null);
                    eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1, eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeSearchResultRecommendData] code = " + eCNetworkResponse.getCode() + ", data = " + ((JSONObject) eCNetworkResponse.b()));
                return eCNetworkResponse;
            }
        }
        eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1 = new ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1(this, continuation);
        Object obj2 = eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeSearchResultRecommendData] code = " + eCNetworkResponse2.getCode() + ", data = " + ((JSONObject) eCNetworkResponse2.b()));
        return eCNetworkResponse2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getShopShareInfo(String str, int i3, String str2, String str3, String str4, Continuation<? super ECShareInfo> continuation) {
        ECShopHomeDefaultRepository$getShopShareInfo$1 eCShopHomeDefaultRepository$getShopShareInfo$1;
        Object coroutine_suspended;
        int i16;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECShopHomeDefaultRepository$getShopShareInfo$1) {
            eCShopHomeDefaultRepository$getShopShareInfo$1 = (ECShopHomeDefaultRepository$getShopShareInfo$1) continuation;
            int i17 = eCShopHomeDefaultRepository$getShopShareInfo$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                eCShopHomeDefaultRepository$getShopShareInfo$1.label = i17 - Integer.MIN_VALUE;
                Object obj = eCShopHomeDefaultRepository$getShopShareInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = eCShopHomeDefaultRepository$getShopShareInfo$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", str);
                    jSONObject.put("type", (i3 == 2 || i3 == 72 || i3 == 73) ? 1 : 2);
                    jSONObject.put("app", str2);
                    jSONObject.put("view", str3);
                    jSONObject.put("ver", str4);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCShopHomeDefaultRepository$getShopShareInfo$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.qq_shop_homepage_svr.QQStoreHomePage", "/trpc.ecom.qq_shop_homepage_svr.QQStoreHomePage/ShareHomePage", bVar, jSONObject, eCShopHomeDefaultRepository$getShopShareInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
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
                cg0.a.a("ECShopHomeDefaultRepository", "getShopShareInfo", "get shop share info err, errCode:" + eCNetworkResponse.getCode() + ",errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCShopHomeDefaultRepository$getShopShareInfo$1 = new ECShopHomeDefaultRepository$getShopShareInfo$1(this, continuation);
        Object obj2 = eCShopHomeDefaultRepository$getShopShareInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = eCShopHomeDefaultRepository$getShopShareInfo$1.label;
        if (i16 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        JSONObject jSONObject22 = (JSONObject) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() != 0) {
        }
        cg0.a.a("ECShopHomeDefaultRepository", "getShopShareInfo", "get shop share info err, errCode:" + eCNetworkResponse.getCode() + ",errMsg:" + eCNetworkResponse.getMessage());
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object unbindShopPromotoer(String str, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        ECShopHomeDefaultRepository$unbindShopPromotoer$1 eCShopHomeDefaultRepository$unbindShopPromotoer$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECShopHomeDefaultRepository$unbindShopPromotoer$1) {
            eCShopHomeDefaultRepository$unbindShopPromotoer$1 = (ECShopHomeDefaultRepository$unbindShopPromotoer$1) continuation;
            int i16 = eCShopHomeDefaultRepository$unbindShopPromotoer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopHomeDefaultRepository$unbindShopPromotoer$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopHomeDefaultRepository$unbindShopPromotoer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopHomeDefaultRepository$unbindShopPromotoer$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECShopHomeDefaultRepository$unbindShopPromotoer$response$1 eCShopHomeDefaultRepository$unbindShopPromotoer$response$1 = new ECShopHomeDefaultRepository$unbindShopPromotoer$response$1(str, null);
                    eCShopHomeDefaultRepository$unbindShopPromotoer$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCShopHomeDefaultRepository$unbindShopPromotoer$response$1, eCShopHomeDefaultRepository$unbindShopPromotoer$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECShopHomeDefaultRepository", "[unBindShopPromoter] code = " + eCNetworkResponse.getCode() + ", data = " + ((JSONObject) eCNetworkResponse.b()));
                return eCNetworkResponse;
            }
        }
        eCShopHomeDefaultRepository$unbindShopPromotoer$1 = new ECShopHomeDefaultRepository$unbindShopPromotoer$1(this, continuation);
        Object obj2 = eCShopHomeDefaultRepository$unbindShopPromotoer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopHomeDefaultRepository$unbindShopPromotoer$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        cg0.a.b("ECShopHomeDefaultRepository", "[unBindShopPromoter] code = " + eCNetworkResponse2.getCode() + ", data = " + ((JSONObject) eCNetworkResponse2.b()));
        return eCNetworkResponse2;
    }
}
