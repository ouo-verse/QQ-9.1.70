package com.tencent.ecommerce.biz.comment;

import com.tencent.ecommerce.biz.comment.ECQShopCommentViewModel;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.comment.ECQShopOrderCommentInfo;
import com.tencent.ecommerce.repo.comment.ECQShopPublishCommentResponse;
import com.tencent.ecommerce.repo.comment.ECQShopPublishCommentResult;
import com.tencent.ecommerce.repo.comment.ECQShopPublishCommentState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel$c;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.comment.ECQShopCommentViewModel$publishComment$1", f = "ECQShopCommentViewModel.kt", i = {0, 0, 2, 3, 4, 5}, l = {59, 63, 69, 73, 76, 79}, m = "invokeSuspend", n = {"$this$flow", "startTime", "$this$flow", "publishCommentResult", "publishCommentResult", "publishCommentResult"}, s = {"L$0", "J$0", "L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes31.dex */
public final class ECQShopCommentViewModel$publishComment$1 extends SuspendLambda implements Function2<FlowCollector<? super ECQShopCommentViewModel.c>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECQShopOrderCommentInfo $commentInfo;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECQShopCommentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECQShopCommentViewModel$publishComment$1(ECQShopCommentViewModel eCQShopCommentViewModel, ECQShopOrderCommentInfo eCQShopOrderCommentInfo, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCQShopCommentViewModel;
        this.$commentInfo = eCQShopOrderCommentInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECQShopCommentViewModel$publishComment$1 eCQShopCommentViewModel$publishComment$1 = new ECQShopCommentViewModel$publishComment$1(this.this$0, this.$commentInfo, continuation);
        eCQShopCommentViewModel$publishComment$1.L$0 = obj;
        return eCQShopCommentViewModel$publishComment$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ECQShopCommentViewModel.c> flowCollector, Continuation<? super Unit> continuation) {
        return ((ECQShopCommentViewModel$publishComment$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088 A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        long currentTimeMillis;
        BatchUploader batchUploader;
        Object h16;
        ECQShopOrderCommentInfo a16;
        Object b16;
        FlowCollector flowCollector;
        ECQShopPublishCommentResponse eCQShopPublishCommentResponse;
        ECQShopCommentViewModel.c.a aVar;
        ECQShopPublishCommentResult eCQShopPublishCommentResult;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r26 = this.label;
        try {
        } catch (UploadFailedException unused) {
            c.f101424a.a(1, System.currentTimeMillis() - currentTimeMillis);
            ECQShopCommentViewModel.c.a aVar2 = new ECQShopCommentViewModel.c.a(ECQShopCommentViewModel.b.a.f101383a);
            this.L$0 = null;
            this.label = 2;
            if (r26.emit(aVar2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        switch (r26) {
            case 0:
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                currentTimeMillis = System.currentTimeMillis();
                batchUploader = this.this$0.batchUploader;
                this.L$0 = flowCollector2;
                this.J$0 = currentTimeMillis;
                this.label = 1;
                h16 = batchUploader.h(this);
                r26 = flowCollector2;
                if (h16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List list = (List) h16;
                c.f101424a.a(0, System.currentTimeMillis() - currentTimeMillis);
                a16 = r8.a((r18 & 1) != 0 ? r8.productInfo : null, (r18 & 2) != 0 ? r8.orderId : null, (r18 & 4) != 0 ? r8.commentTextList : null, (r18 & 8) != 0 ? r8.imageUrls : list, (r18 & 16) != 0 ? r8.productSpecification : null, (r18 & 32) != 0 ? r8.produceQualityScore : 0.0f, (r18 & 64) != 0 ? r8.logisticsServiceScore : 0.0f, (r18 & 128) != 0 ? this.$commentInfo.shopServiceScore : 0.0f);
                com.tencent.ecommerce.repo.comment.f n3 = ServiceLocator.f104891i.n();
                this.L$0 = r26;
                this.label = 3;
                b16 = n3.b(a16, this);
                flowCollector = r26;
                if (b16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ECQShopPublishCommentResult eCQShopPublishCommentResult2 = (ECQShopPublishCommentResult) b16;
                eCQShopPublishCommentResponse = eCQShopPublishCommentResult2.data;
                if (eCQShopPublishCommentResponse != null) {
                    if (!(eCQShopPublishCommentResponse.getCommentId().length() == 0)) {
                        ECQShopPublishCommentResponse eCQShopPublishCommentResponse2 = eCQShopPublishCommentResult2.data;
                        if (eCQShopPublishCommentResponse2.publishState == ECQShopPublishCommentState.WRITE_STATE_REPEATED) {
                            ECQShopCommentViewModel.c.b bVar = new ECQShopCommentViewModel.c.b(eCQShopPublishCommentResponse2.getCommentId());
                            this.L$0 = eCQShopPublishCommentResult2;
                            this.label = 5;
                            if (flowCollector.emit(bVar, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            ECQShopCommentViewModel.c.C1044c c1044c = new ECQShopCommentViewModel.c.C1044c(eCQShopPublishCommentResponse2.getCommentId());
                            this.L$0 = eCQShopPublishCommentResult2;
                            this.label = 6;
                            if (flowCollector.emit(c1044c, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        eCQShopPublishCommentResult = eCQShopPublishCommentResult2;
                        ECOrderSpan.c(ECOrderSpan.f103884c, this.$commentInfo.orderId, ECOrderSpanScene.OrderComment, ECOrderOperation.WriteComment, eCQShopPublishCommentResult.requestInfo, null, 16, null);
                        return Unit.INSTANCE;
                    }
                }
                cg0.a.a("ECQShopCommentViewModel", "publishComment", "publish comment failed");
                aVar = new ECQShopCommentViewModel.c.a(ECQShopCommentViewModel.b.C1043b.f101384a);
                this.L$0 = eCQShopPublishCommentResult2;
                this.label = 4;
                if (flowCollector.emit(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                eCQShopPublishCommentResult = eCQShopPublishCommentResult2;
                ECOrderSpan.c(ECOrderSpan.f103884c, this.$commentInfo.orderId, ECOrderSpanScene.OrderComment, ECOrderOperation.WriteComment, eCQShopPublishCommentResult.requestInfo, null, 16, null);
                return Unit.INSTANCE;
            case 1:
                currentTimeMillis = this.J$0;
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                h16 = obj;
                r26 = flowCollector3;
                List list2 = (List) h16;
                c.f101424a.a(0, System.currentTimeMillis() - currentTimeMillis);
                a16 = r8.a((r18 & 1) != 0 ? r8.productInfo : null, (r18 & 2) != 0 ? r8.orderId : null, (r18 & 4) != 0 ? r8.commentTextList : null, (r18 & 8) != 0 ? r8.imageUrls : list2, (r18 & 16) != 0 ? r8.productSpecification : null, (r18 & 32) != 0 ? r8.produceQualityScore : 0.0f, (r18 & 64) != 0 ? r8.logisticsServiceScore : 0.0f, (r18 & 128) != 0 ? this.$commentInfo.shopServiceScore : 0.0f);
                com.tencent.ecommerce.repo.comment.f n36 = ServiceLocator.f104891i.n();
                this.L$0 = r26;
                this.label = 3;
                b16 = n36.b(a16, this);
                flowCollector = r26;
                if (b16 == coroutine_suspended) {
                }
                ECQShopPublishCommentResult eCQShopPublishCommentResult22 = (ECQShopPublishCommentResult) b16;
                eCQShopPublishCommentResponse = eCQShopPublishCommentResult22.data;
                if (eCQShopPublishCommentResponse != null) {
                }
                cg0.a.a("ECQShopCommentViewModel", "publishComment", "publish comment failed");
                aVar = new ECQShopCommentViewModel.c.a(ECQShopCommentViewModel.b.C1043b.f101384a);
                this.L$0 = eCQShopPublishCommentResult22;
                this.label = 4;
                if (flowCollector.emit(aVar, this) == coroutine_suspended) {
                }
                eCQShopPublishCommentResult = eCQShopPublishCommentResult22;
                ECOrderSpan.c(ECOrderSpan.f103884c, this.$commentInfo.orderId, ECOrderSpanScene.OrderComment, ECOrderOperation.WriteComment, eCQShopPublishCommentResult.requestInfo, null, 16, null);
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 3:
                FlowCollector flowCollector4 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                b16 = obj;
                flowCollector = flowCollector4;
                ECQShopPublishCommentResult eCQShopPublishCommentResult222 = (ECQShopPublishCommentResult) b16;
                eCQShopPublishCommentResponse = eCQShopPublishCommentResult222.data;
                if (eCQShopPublishCommentResponse != null) {
                }
                cg0.a.a("ECQShopCommentViewModel", "publishComment", "publish comment failed");
                aVar = new ECQShopCommentViewModel.c.a(ECQShopCommentViewModel.b.C1043b.f101384a);
                this.L$0 = eCQShopPublishCommentResult222;
                this.label = 4;
                if (flowCollector.emit(aVar, this) == coroutine_suspended) {
                }
                eCQShopPublishCommentResult = eCQShopPublishCommentResult222;
                ECOrderSpan.c(ECOrderSpan.f103884c, this.$commentInfo.orderId, ECOrderSpanScene.OrderComment, ECOrderOperation.WriteComment, eCQShopPublishCommentResult.requestInfo, null, 16, null);
                return Unit.INSTANCE;
            case 4:
            case 5:
            case 6:
                eCQShopPublishCommentResult = (ECQShopPublishCommentResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                ECOrderSpan.c(ECOrderSpan.f103884c, this.$commentInfo.orderId, ECOrderSpanScene.OrderComment, ECOrderOperation.WriteComment, eCQShopPublishCommentResult.requestInfo, null, 16, null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
