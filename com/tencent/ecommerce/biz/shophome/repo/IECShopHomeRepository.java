package com.tencent.ecommerce.biz.shophome.repo;

import bj0.ECShopHomeCategoryListRequest;
import bj0.ECShopHomeProductRequest;
import bj0.ECShopHomeRequest;
import bj0.ECShopHomeSearchResultRecommendRequest;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0011J+\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ=\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/repo/IECShopHomeRepository;", "", "Lbj0/c;", "shopHomeRequest", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lcom/tencent/ecommerce/base/network/api/d;", "Lorg/json/JSONObject;", "getShopHomePageData", "(Lbj0/c;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lbj0/b;", "shopHomeProductRequest", "getShopHomeProductList", "(Lbj0/b;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "shopId", "getShopHomeQualificationData", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unbindShopPromotoer", "Lbj0/d;", "searchResultRecommendRequest", "getShopHomeSearchResultRecommendData", "(Lbj0/d;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lbj0/a;", "categoryListRequest", "getShopHomeCategoryList", "(Lbj0/a;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "shareAction", "appId", "arkViewName", "version", "Lcom/tencent/ecommerce/biz/shophome/repo/b;", "getShopShareInfo", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECShopHomeRepository {
    Object getShopHomeCategoryList(ECShopHomeCategoryListRequest eCShopHomeCategoryListRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super JSONObject> continuation);

    Object getShopHomePageData(ECShopHomeRequest eCShopHomeRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<JSONObject>> continuation);

    Object getShopHomeProductList(ECShopHomeProductRequest eCShopHomeProductRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<JSONObject>> continuation);

    Object getShopHomeQualificationData(String str, CoroutineDispatcher coroutineDispatcher, Continuation<? super JSONObject> continuation);

    Object getShopHomeSearchResultRecommendData(ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<JSONObject>> continuation);

    Object getShopShareInfo(String str, int i3, String str2, String str3, String str4, Continuation<? super ECShareInfo> continuation);

    Object unbindShopPromotoer(String str, CoroutineDispatcher coroutineDispatcher, Continuation<? super ECNetworkResponse<JSONObject>> continuation);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ Object a(IECShopHomeRepository iECShopHomeRepository, ECShopHomeCategoryListRequest eCShopHomeCategoryListRequest, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    coroutineDispatcher = Dispatchers.getIO();
                }
                return iECShopHomeRepository.getShopHomeCategoryList(eCShopHomeCategoryListRequest, coroutineDispatcher, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShopHomeCategoryList");
        }

        public static /* synthetic */ Object b(IECShopHomeRepository iECShopHomeRepository, ECShopHomeRequest eCShopHomeRequest, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    coroutineDispatcher = Dispatchers.getIO();
                }
                return iECShopHomeRepository.getShopHomePageData(eCShopHomeRequest, coroutineDispatcher, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShopHomePageData");
        }

        public static /* synthetic */ Object c(IECShopHomeRepository iECShopHomeRepository, ECShopHomeProductRequest eCShopHomeProductRequest, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    coroutineDispatcher = Dispatchers.getIO();
                }
                return iECShopHomeRepository.getShopHomeProductList(eCShopHomeProductRequest, coroutineDispatcher, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShopHomeProductList");
        }

        public static /* synthetic */ Object d(IECShopHomeRepository iECShopHomeRepository, String str, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    coroutineDispatcher = Dispatchers.getIO();
                }
                return iECShopHomeRepository.getShopHomeQualificationData(str, coroutineDispatcher, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShopHomeQualificationData");
        }

        public static /* synthetic */ Object e(IECShopHomeRepository iECShopHomeRepository, ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    coroutineDispatcher = Dispatchers.getIO();
                }
                return iECShopHomeRepository.getShopHomeSearchResultRecommendData(eCShopHomeSearchResultRecommendRequest, coroutineDispatcher, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShopHomeSearchResultRecommendData");
        }

        public static /* synthetic */ Object f(IECShopHomeRepository iECShopHomeRepository, String str, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    coroutineDispatcher = Dispatchers.getIO();
                }
                return iECShopHomeRepository.unbindShopPromotoer(str, coroutineDispatcher, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unbindShopPromotoer");
        }
    }
}
