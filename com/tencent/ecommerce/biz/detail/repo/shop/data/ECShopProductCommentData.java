package com.tencent.ecommerce.biz.detail.repo.shop.data;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.ProductCommentSortType;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0007\u000fB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J/\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductCommentData;", "", "Lorg/json/JSONObject;", "data", "requestParams", "", "Lcom/tencent/ecommerce/base/ui/b;", "a", "", "spuId", "", "sortType", "", "isRefreshFetch", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductCommentData$a;", "b", "(Ljava/lang/String;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "repository", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductCommentData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IECShopProductDetailRepository repository = com.tencent.ecommerce.biz.detail.repo.shop.a.f102322a.getShopProductDetailRepository();

    private final List<ECBasePtsViewData> a(JSONObject data, JSONObject requestParams) {
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(ECProductDetailDataParserType.ECProductComment);
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, new JSONObject());
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(new JSONObject());
        }
        List<ECBasePtsViewData> process = a16.process(processRemoteParserParamsArray, data, requestParams);
        return process != null ? process : new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(String str, @ProductCommentSortType int i3, boolean z16, Continuation<? super CommentListRequestResult> continuation) {
        ECShopProductCommentData$requestCommentList$1 eCShopProductCommentData$requestCommentList$1;
        Object coroutine_suspended;
        int i16;
        String shopDetailCacheCommentCookie;
        ECShopProductCommentData eCShopProductCommentData;
        ECShopProductCommentInfo eCShopProductCommentInfo;
        if (continuation instanceof ECShopProductCommentData$requestCommentList$1) {
            eCShopProductCommentData$requestCommentList$1 = (ECShopProductCommentData$requestCommentList$1) continuation;
            int i17 = eCShopProductCommentData$requestCommentList$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                eCShopProductCommentData$requestCommentList$1.label = i17 - Integer.MIN_VALUE;
                Object obj = eCShopProductCommentData$requestCommentList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = eCShopProductCommentData$requestCommentList$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (z16) {
                        shopDetailCacheCommentCookie = "";
                    } else {
                        shopDetailCacheCommentCookie = this.repository.getShopDetailCacheCommentCookie();
                    }
                    IECShopProductDetailRepository iECShopProductDetailRepository = this.repository;
                    eCShopProductCommentData$requestCommentList$1.L$0 = this;
                    eCShopProductCommentData$requestCommentList$1.label = 1;
                    obj = iECShopProductDetailRepository.getShopProductCommentData(str, i3, shopDetailCacheCommentCookie, eCShopProductCommentData$requestCommentList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCShopProductCommentData = this;
                } else if (i16 == 1) {
                    eCShopProductCommentData = (ECShopProductCommentData) eCShopProductCommentData$requestCommentList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCShopProductCommentInfo = (ECShopProductCommentInfo) obj;
                if (eCShopProductCommentInfo == null) {
                    return new CommentListRequestResult(eCShopProductCommentData.a(eCShopProductCommentInfo.jsonResponse, null), eCShopProductCommentInfo.isEnd, eCShopProductCommentInfo.reviewCount);
                }
                return null;
            }
        }
        eCShopProductCommentData$requestCommentList$1 = new ECShopProductCommentData$requestCommentList$1(this, continuation);
        Object obj2 = eCShopProductCommentData$requestCommentList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = eCShopProductCommentData$requestCommentList$1.label;
        if (i16 != 0) {
        }
        eCShopProductCommentInfo = (ECShopProductCommentInfo) obj2;
        if (eCShopProductCommentInfo == null) {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductCommentData$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/ecommerce/base/ui/b;", "a", "Ljava/util/List;", "()Ljava/util/List;", "ptsItemList", "b", "Z", "isListEnd", "c", "I", "getTotalReviewCount", "()I", "totalReviewCount", "<init>", "(Ljava/util/List;ZI)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductCommentData$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class CommentListRequestResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<ECBasePtsViewData> ptsItemList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isListEnd;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int totalReviewCount;

        public CommentListRequestResult(List<ECBasePtsViewData> list, boolean z16, int i3) {
            this.ptsItemList = list;
            this.isListEnd = z16;
            this.totalReviewCount = i3;
        }

        public final List<ECBasePtsViewData> a() {
            return this.ptsItemList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<ECBasePtsViewData> list = this.ptsItemList;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z16 = this.isListEnd;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.totalReviewCount;
        }

        public String toString() {
            return "CommentListRequestResult(ptsItemList=" + this.ptsItemList + ", isListEnd=" + this.isListEnd + ", totalReviewCount=" + this.totalReviewCount + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommentListRequestResult)) {
                return false;
            }
            CommentListRequestResult commentListRequestResult = (CommentListRequestResult) other;
            return Intrinsics.areEqual(this.ptsItemList, commentListRequestResult.ptsItemList) && this.isListEnd == commentListRequestResult.isListEnd && this.totalReviewCount == commentListRequestResult.totalReviewCount;
        }
    }
}
