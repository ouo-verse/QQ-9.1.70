package com.tencent.ecommerce.repo.comment;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$ReviewProductID;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$RptData;
import com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read.ECQshopProductReviewRead$GetByReviewIDReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read.ECQshopProductReviewRead$GetByReviewIDRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read.ECQshopProductReviewRead$GetReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read.ECQshopProductReviewRead$ReviewDetail;
import com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_write.ECQshopProductReviewWrite$WriteReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_write.ECQshopProductReviewWrite$WriteRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/repo/comment/ECQShopOrderCommentRepo;", "Lcom/tencent/ecommerce/repo/comment/f;", "", "rsp", "Lcom/tencent/ecommerce/repo/comment/c;", "e", "Lcom/tencent/ecommerce/repo/comment/a;", "commentInfo", "Lcom/tencent/ecommerce/repo/comment/e;", "b", "(Lcom/tencent/ecommerce/repo/comment/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", WSAutoShowCommentParams.KEY_COMMENT_ID, "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "skuId", "spuId", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQShopOrderCommentRepo implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final ECQShopOrderCommentRepo f105029a = new ECQShopOrderCommentRepo();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/comment/ECQShopOrderCommentRepo$a", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/repo/comment/a;", "Lcom/tencent/ecommerce/repo/comment/d;", "", "rsp", "a", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkPBContracts<ECQShopOrderCommentInfo, ECQShopPublishCommentResponse> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECQShopPublishCommentResponse decodeResponse(byte[] rsp) {
            ECQShopPublishCommentState eCQShopPublishCommentState;
            ECQshopProductReviewWrite$WriteRsp mergeFrom = new ECQshopProductReviewWrite$WriteRsp().mergeFrom(rsp);
            int i3 = mergeFrom.state.get();
            if (i3 == 1) {
                eCQShopPublishCommentState = ECQShopPublishCommentState.WRITE_STATE_OK;
            } else if (i3 != 2) {
                eCQShopPublishCommentState = ECQShopPublishCommentState.WRITE_STATE_UNKNOWN;
            } else {
                eCQShopPublishCommentState = ECQShopPublishCommentState.WRITE_STATE_REPEATED;
            }
            return new ECQShopPublishCommentResponse(eCQShopPublishCommentState, mergeFrom.review_id.get());
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(ECQShopOrderCommentInfo params, int channel, JSONObject reqExt) {
            int collectionSizeOrDefault;
            ECQshopProductReviewCommon$ReviewProductID eCQshopProductReviewCommon$ReviewProductID = new ECQshopProductReviewCommon$ReviewProductID();
            eCQshopProductReviewCommon$ReviewProductID.spu_id.set(params.productInfo.spuId);
            eCQshopProductReviewCommon$ReviewProductID.sku_id.set(params.productInfo.getSkuId());
            ECQshopProductReviewWrite$WriteReq eCQshopProductReviewWrite$WriteReq = new ECQshopProductReviewWrite$WriteReq();
            eCQshopProductReviewWrite$WriteReq.order_id.set(params.orderId);
            eCQshopProductReviewWrite$WriteReq.product_id.set(eCQshopProductReviewCommon$ReviewProductID);
            PBRepeatMessageField<ECQshopProductReviewCommon$RptData> pBRepeatMessageField = eCQshopProductReviewWrite$WriteReq.review_content;
            List<h> c16 = params.c();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = c16.iterator();
            while (it.hasNext()) {
                arrayList.add(((h) it.next()).a());
            }
            pBRepeatMessageField.addAll(arrayList);
            eCQshopProductReviewWrite$WriteReq.picture_urls.addAll(params.d());
            eCQshopProductReviewWrite$WriteReq.product_specification.addAll(params.e());
            float f16 = 10;
            eCQshopProductReviewWrite$WriteReq.product_quality_score.set((int) (params.produceQualityScore * f16));
            eCQshopProductReviewWrite$WriteReq.logistics_quality_score.set((int) (params.logisticsServiceScore * f16));
            eCQshopProductReviewWrite$WriteReq.shop_quality_score.set((int) (params.getShopServiceScore() * f16));
            return eCQshopProductReviewWrite$WriteReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/comment/ECQShopOrderCommentRepo$b", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "Lcom/tencent/ecommerce/repo/comment/c;", "", "rsp", "a", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkPBContracts<String, ECQShopOrderReviewCommentInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f105030a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f105031b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f105032c;

        b(String str, String str2, String str3) {
            this.f105030a = str;
            this.f105031b = str2;
            this.f105032c = str3;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECQShopOrderReviewCommentInfo decodeResponse(byte[] rsp) {
            return ECQShopOrderCommentRepo.f105029a.e(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECQshopProductReviewCommon$ReviewProductID eCQshopProductReviewCommon$ReviewProductID = new ECQshopProductReviewCommon$ReviewProductID();
            eCQshopProductReviewCommon$ReviewProductID.sku_id.set(this.f105030a);
            eCQshopProductReviewCommon$ReviewProductID.spu_id.set(this.f105031b);
            ECQshopProductReviewRead$GetReq eCQshopProductReviewRead$GetReq = new ECQshopProductReviewRead$GetReq();
            eCQshopProductReviewRead$GetReq.product_id.set(eCQshopProductReviewCommon$ReviewProductID);
            eCQshopProductReviewRead$GetReq.order_id.set(this.f105032c);
            return eCQshopProductReviewRead$GetReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/comment/ECQShopOrderCommentRepo$c", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "Lcom/tencent/ecommerce/repo/comment/c;", "", "rsp", "a", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECNetworkPBContracts<String, ECQShopOrderReviewCommentInfo> {
        c() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECQShopOrderReviewCommentInfo decodeResponse(byte[] rsp) {
            return ECQShopOrderCommentRepo.f105029a.e(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(String params, int channel, JSONObject reqExt) {
            ECQshopProductReviewRead$GetByReviewIDReq eCQshopProductReviewRead$GetByReviewIDReq = new ECQshopProductReviewRead$GetByReviewIDReq();
            eCQshopProductReviewRead$GetByReviewIDReq.review_id.set(params);
            return eCQshopProductReviewRead$GetByReviewIDReq.toByteArray();
        }
    }

    ECQShopOrderCommentRepo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECQShopOrderReviewCommentInfo e(byte[] rsp) {
        ECQshopProductReviewRead$ReviewDetail eCQshopProductReviewRead$ReviewDetail = new ECQshopProductReviewRead$GetByReviewIDRsp().mergeFrom(rsp).review_detail.get();
        List<ECQshopProductReviewCommon$RptData> list = eCQshopProductReviewRead$ReviewDetail.review_content.get();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            h a16 = com.tencent.ecommerce.repo.comment.b.a((ECQshopProductReviewCommon$RptData) it.next());
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        String str = eCQshopProductReviewRead$ReviewDetail.user_nick.get();
        String str2 = eCQshopProductReviewRead$ReviewDetail.user_icon.get();
        return new ECQShopOrderReviewCommentInfo(str, eCQshopProductReviewRead$ReviewDetail.user_id.get(), str2, eCQshopProductReviewRead$ReviewDetail.order_id.get(), eCQshopProductReviewRead$ReviewDetail.product_id.spu_id.get(), eCQshopProductReviewRead$ReviewDetail.product_id.sku_id.get(), eCQshopProductReviewRead$ReviewDetail.review_type.get(), arrayList, eCQshopProductReviewRead$ReviewDetail.picture_urls.get(), eCQshopProductReviewRead$ReviewDetail.thumb_picture_urls.get(), eCQshopProductReviewRead$ReviewDetail.product_specification.get(), eCQshopProductReviewRead$ReviewDetail.create_time.get(), eCQshopProductReviewRead$ReviewDetail.product_quality_score.get() / 10, eCQshopProductReviewRead$ReviewDetail.logistics_quality_score.get() / 10, eCQshopProductReviewRead$ReviewDetail.shop_quality_score.get() / 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.repo.comment.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, String str2, String str3, Continuation<? super ECQShopOrderReviewCommentInfo> continuation) {
        ECQShopOrderCommentRepo$requestCommentInfo$1 eCQShopOrderCommentRepo$requestCommentInfo$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECQShopOrderCommentRepo$requestCommentInfo$1) {
            eCQShopOrderCommentRepo$requestCommentInfo$1 = (ECQShopOrderCommentRepo$requestCommentInfo$1) continuation;
            int i16 = eCQShopOrderCommentRepo$requestCommentInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCQShopOrderCommentRepo$requestCommentInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCQShopOrderCommentRepo$requestCommentInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCQShopOrderCommentRepo$requestCommentInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    b bVar = new b(str2, str3, str);
                    eCQShopOrderCommentRepo$requestCommentInfo$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_product_review_read.QshopProductReviewRead", "/trpc.ecom.qshop_product_review_read.QshopProductReviewRead/Get", bVar, "", eCQShopOrderCommentRepo$requestCommentInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0 || eCNetworkResponse.b() == null) {
                    cg0.a.a("ECQShopOrderCommentRepo", "requestCommentInfo", "request comment by orderId and productId error,errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse.b();
            }
        }
        eCQShopOrderCommentRepo$requestCommentInfo$1 = new ECQShopOrderCommentRepo$requestCommentInfo$1(this, continuation);
        Object obj2 = eCQShopOrderCommentRepo$requestCommentInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCQShopOrderCommentRepo$requestCommentInfo$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECQShopOrderCommentRepo", "requestCommentInfo", "request comment by orderId and productId error,errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.repo.comment.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(ECQShopOrderCommentInfo eCQShopOrderCommentInfo, Continuation<? super ECQShopPublishCommentResult> continuation) {
        ECQShopOrderCommentRepo$publishComment$1 eCQShopOrderCommentRepo$publishComment$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECQShopOrderCommentRepo$publishComment$1) {
            eCQShopOrderCommentRepo$publishComment$1 = (ECQShopOrderCommentRepo$publishComment$1) continuation;
            int i16 = eCQShopOrderCommentRepo$publishComment$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCQShopOrderCommentRepo$publishComment$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCQShopOrderCommentRepo$publishComment$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCQShopOrderCommentRepo$publishComment$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    a aVar = new a();
                    eCQShopOrderCommentRepo$publishComment$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_product_review_write.QshopProductReviewWrite", "/trpc.ecom.qshop_product_review_write.QshopProductReviewWrite/Write", aVar, eCQShopOrderCommentInfo, eCQShopOrderCommentRepo$publishComment$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                ECQShopPublishCommentResponse eCQShopPublishCommentResponse = (ECQShopPublishCommentResponse) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() == 0 || eCQShopPublishCommentResponse == null) {
                    cg0.a.a("ECQShopOrderCommentRepo", "publishComment", "publish comment error, errCode: " + eCNetworkResponse.getCode() + ", errMsg: " + eCNetworkResponse.getMessage());
                }
                return new ECQShopPublishCommentResult(new ECOrderSpan.OrderRequestInfo(eCNetworkResponse.getCode(), eCNetworkResponse.getTraceInfo()), eCQShopPublishCommentResponse);
            }
        }
        eCQShopOrderCommentRepo$publishComment$1 = new ECQShopOrderCommentRepo$publishComment$1(this, continuation);
        Object obj2 = eCQShopOrderCommentRepo$publishComment$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCQShopOrderCommentRepo$publishComment$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        ECQShopPublishCommentResponse eCQShopPublishCommentResponse2 = (ECQShopPublishCommentResponse) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECQShopOrderCommentRepo", "publishComment", "publish comment error, errCode: " + eCNetworkResponse.getCode() + ", errMsg: " + eCNetworkResponse.getMessage());
        return new ECQShopPublishCommentResult(new ECOrderSpan.OrderRequestInfo(eCNetworkResponse.getCode(), eCNetworkResponse.getTraceInfo()), eCQShopPublishCommentResponse2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.repo.comment.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(String str, Continuation<? super ECQShopOrderReviewCommentInfo> continuation) {
        ECQShopOrderCommentRepo$requestCommentInfoByCommentId$1 eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECQShopOrderCommentRepo$requestCommentInfoByCommentId$1) {
            eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1 = (ECQShopOrderCommentRepo$requestCommentInfoByCommentId$1) continuation;
            int i16 = eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    c cVar = new c();
                    eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_product_review_read.QshopProductReviewRead", "/trpc.ecom.qshop_product_review_read.QshopProductReviewRead/GetByReviewID", cVar, str, eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0 || eCNetworkResponse.b() == null) {
                    cg0.a.a("ECQShopOrderCommentRepo", "requestCommentInfoByCommentId", "request comment by commentId error,errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse.b();
            }
        }
        eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1 = new ECQShopOrderCommentRepo$requestCommentInfoByCommentId$1(this, continuation);
        Object obj2 = eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCQShopOrderCommentRepo$requestCommentInfoByCommentId$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECQShopOrderCommentRepo", "requestCommentInfoByCommentId", "request comment by commentId error,errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse.b();
    }
}
