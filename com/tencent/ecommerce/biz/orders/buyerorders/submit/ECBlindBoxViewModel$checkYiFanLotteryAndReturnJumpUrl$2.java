package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.net.Uri;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.blindbox.ECBlindBoxLotteryResult;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2", f = "ECBlindBoxViewModel.kt", i = {0, 1}, l = {102, 130}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "$this$withTimeoutOrNull"}, s = {"L$0", "L$0"})
/* loaded from: classes31.dex */
public final class ECBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends String>>, Object> {
    final /* synthetic */ String $groupId;
    final /* synthetic */ List $orderIds;
    final /* synthetic */ ECOrderSpanScene $scene;
    final /* synthetic */ String $spuId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2(List list, ECOrderSpanScene eCOrderSpanScene, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.$orderIds = list;
        this.$scene = eCOrderSpanScene;
        this.$groupId = str;
        this.$spuId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2 eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2 = new ECBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2(this.$orderIds, this.$scene, this.$groupId, this.$spuId, continuation);
        eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.L$0 = obj;
        return eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Boolean, ? extends String>> continuation) {
        return ((ECBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0080, code lost:
    
        r9 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(kotlin.TuplesKt.to("shouldRefund", java.lang.String.valueOf(r9.booleanValue())));
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0120 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x011e -> B:7:0x0034). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        ECBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2 eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2;
        String joinToString$default;
        Map<String, String> emptyMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else if (i3 == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            Object obj2 = obj;
            eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2 = this;
            ECNetworkResponse<?> eCNetworkResponse = (ECNetworkResponse) obj2;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.$orderIds, "-", null, null, 0, null, null, 62, null);
            ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
            ECOrderSpanScene eCOrderSpanScene = eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.$scene;
            ECOrderOperation eCOrderOperation = ECOrderOperation.CheckLottery;
            ECOrderSpan.OrderRequestInfo d16 = eCOrderSpan.d(eCNetworkResponse);
            ECBlindBoxLotteryResult eCBlindBoxLotteryResult = (ECBlindBoxLotteryResult) eCNetworkResponse.b();
            if (eCBlindBoxLotteryResult != null || (r9 = Boxing.boxBoolean(eCBlindBoxLotteryResult.getShouldRefund())) == null || emptyMap == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            eCOrderSpan.b(joinToString$default, eCOrderSpanScene, eCOrderOperation, d16, emptyMap);
            ECBlindBoxLotteryResult eCBlindBoxLotteryResult2 = (ECBlindBoxLotteryResult) eCNetworkResponse.b();
            if (eCBlindBoxLotteryResult2 == null && eCBlindBoxLotteryResult2.hasResult) {
                if (eCBlindBoxLotteryResult2.getShouldRefund()) {
                    return new Pair(Boxing.boxBoolean(true), "");
                }
                com.tencent.ecommerce.biz.hr.module.e.f102613b.b("check_yifanshang_result_rsp", eCBlindBoxLotteryResult2.resultData.toString());
                return new Pair(Boxing.boxBoolean(false), Uri.parse("mqqapi://ecommerce/open").buildUpon().appendQueryParameter("target", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE).appendQueryParameter("page_name", "yifanshang_result_page").appendQueryParameter("group_id", eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.$groupId).appendQueryParameter("box_id", eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.$spuId).build().toString());
            }
            eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.L$0 = coroutineScope;
            eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.label = 2;
            if (DelayKt.delay(2000L, eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                com.tencent.ecommerce.repo.blindbox.b e16 = ServiceLocator.f104891i.e();
                List<String> list = eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.$orderIds;
                eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.L$0 = coroutineScope;
                eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.label = 1;
                obj2 = e16.c(list, eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ECNetworkResponse<?> eCNetworkResponse2 = (ECNetworkResponse) obj2;
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.$orderIds, "-", null, null, 0, null, null, 62, null);
                ECOrderSpan eCOrderSpan2 = ECOrderSpan.f103884c;
                ECOrderSpanScene eCOrderSpanScene2 = eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.$scene;
                ECOrderOperation eCOrderOperation2 = ECOrderOperation.CheckLottery;
                ECOrderSpan.OrderRequestInfo d162 = eCOrderSpan2.d(eCNetworkResponse2);
                ECBlindBoxLotteryResult eCBlindBoxLotteryResult3 = (ECBlindBoxLotteryResult) eCNetworkResponse2.b();
                if (eCBlindBoxLotteryResult3 != null) {
                }
                emptyMap = MapsKt__MapsKt.emptyMap();
                eCOrderSpan2.b(joinToString$default, eCOrderSpanScene2, eCOrderOperation2, d162, emptyMap);
                ECBlindBoxLotteryResult eCBlindBoxLotteryResult22 = (ECBlindBoxLotteryResult) eCNetworkResponse2.b();
                if (eCBlindBoxLotteryResult22 == null) {
                }
                eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.L$0 = coroutineScope;
                eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2.label = 2;
                if (DelayKt.delay(2000L, eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2) == coroutine_suspended) {
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return null;
                }
            }
        } else if (i3 == 2) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        eCBlindBoxViewModel$checkYiFanLotteryAndReturnJumpUrl$2 = this;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
        }
    }
}
