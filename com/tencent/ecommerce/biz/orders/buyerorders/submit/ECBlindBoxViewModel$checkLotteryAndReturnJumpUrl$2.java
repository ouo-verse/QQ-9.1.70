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
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2", f = "ECBlindBoxViewModel.kt", i = {0, 0, 1, 1, 2}, l = {51, 53, 78}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "isMultiLottery", "$this$withTimeoutOrNull", "isMultiLottery", "$this$withTimeoutOrNull"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0"})
/* loaded from: classes31.dex */
final class ECBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ List $orderIds;
    final /* synthetic */ ECOrderSpanScene $scene;
    final /* synthetic */ String $spuId;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2(List list, ECOrderSpanScene eCOrderSpanScene, String str, Continuation continuation) {
        super(2, continuation);
        this.$orderIds = list;
        this.$scene = eCOrderSpanScene;
        this.$spuId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2 eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2 = new ECBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2(this.$orderIds, this.$scene, this.$spuId, continuation);
        eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.L$0 = obj;
        return eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ECBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0136 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0137 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0134 -> B:8:0x0049). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        int i3;
        CoroutineScope coroutineScope2;
        ECBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2 eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2;
        ECNetworkResponse<?> eCNetworkResponse;
        String joinToString$default;
        ECBlindBoxLotteryResult eCBlindBoxLotteryResult;
        Object obj2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else if (i16 == 1) {
            int i17 = this.I$0;
            coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            i3 = i17;
            eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2 = this;
            eCNetworkResponse = (ECNetworkResponse) obj2;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$orderIds, "-", null, null, 0, null, null, 62, null);
            ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
            ECOrderSpan.c(eCOrderSpan, joinToString$default, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$scene, ECOrderOperation.CheckLottery, eCOrderSpan.d(eCNetworkResponse), null, 16, null);
            eCBlindBoxLotteryResult = (ECBlindBoxLotteryResult) eCNetworkResponse.b();
            if (eCBlindBoxLotteryResult == null) {
            }
            eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.L$0 = coroutineScope2;
            eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.label = 3;
            if (DelayKt.delay(2000L, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2) == coroutine_suspended) {
            }
            if (!CoroutineScopeKt.isActive(coroutineScope2)) {
            }
        } else if (i16 == 2) {
            int i18 = this.I$0;
            coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            Object obj3 = obj;
            i3 = i18;
            eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2 = this;
            eCNetworkResponse = (ECNetworkResponse) obj3;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$orderIds, "-", null, null, 0, null, null, 62, null);
            ECOrderSpan eCOrderSpan2 = ECOrderSpan.f103884c;
            ECOrderSpan.c(eCOrderSpan2, joinToString$default, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$scene, ECOrderOperation.CheckLottery, eCOrderSpan2.d(eCNetworkResponse), null, 16, null);
            eCBlindBoxLotteryResult = (ECBlindBoxLotteryResult) eCNetworkResponse.b();
            if (eCBlindBoxLotteryResult == null && eCBlindBoxLotteryResult.hasResult) {
                com.tencent.ecommerce.biz.hr.module.e.f102613b.b("check_lottery_result_rsp", eCBlindBoxLotteryResult.resultData.toString());
                String str = "1";
                Uri.Builder appendQueryParameter = Uri.parse("mqqapi://ecommerce/open").buildUpon().appendQueryParameter("target", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE).appendQueryParameter("page_name", "blind_box_lottery_result").appendQueryParameter("lottery_type", "1").appendQueryParameter("order_id", joinToString$default).appendQueryParameter("box_id", eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$spuId);
                if (i3 == 0) {
                    str = "0";
                }
                return appendQueryParameter.appendQueryParameter("is_multi_lottery", str).build().toString();
            }
            eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.L$0 = coroutineScope2;
            eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.label = 3;
            if (DelayKt.delay(2000L, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                return null;
            }
            i3 = eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$orderIds.size() > 1 ? 1 : 0;
            if (i3 != 0) {
                com.tencent.ecommerce.repo.blindbox.b e16 = ServiceLocator.f104891i.e();
                List<String> list = eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$orderIds;
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.L$0 = coroutineScope2;
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.I$0 = i3;
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.label = 1;
                obj2 = e16.b(list, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                eCNetworkResponse = (ECNetworkResponse) obj2;
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$orderIds, "-", null, null, 0, null, null, 62, null);
                ECOrderSpan eCOrderSpan22 = ECOrderSpan.f103884c;
                ECOrderSpan.c(eCOrderSpan22, joinToString$default, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$scene, ECOrderOperation.CheckLottery, eCOrderSpan22.d(eCNetworkResponse), null, 16, null);
                eCBlindBoxLotteryResult = (ECBlindBoxLotteryResult) eCNetworkResponse.b();
                if (eCBlindBoxLotteryResult == null) {
                }
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.L$0 = coroutineScope2;
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.label = 3;
                if (DelayKt.delay(2000L, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2) == coroutine_suspended) {
                }
                if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                }
            } else {
                com.tencent.ecommerce.repo.blindbox.b e17 = ServiceLocator.f104891i.e();
                String str2 = (String) eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$orderIds.get(0);
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.L$0 = coroutineScope2;
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.I$0 = i3;
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.label = 2;
                obj3 = e17.a(str2, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2);
                if (obj3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                eCNetworkResponse = (ECNetworkResponse) obj3;
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$orderIds, "-", null, null, 0, null, null, 62, null);
                ECOrderSpan eCOrderSpan222 = ECOrderSpan.f103884c;
                ECOrderSpan.c(eCOrderSpan222, joinToString$default, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.$scene, ECOrderOperation.CheckLottery, eCOrderSpan222.d(eCNetworkResponse), null, 16, null);
                eCBlindBoxLotteryResult = (ECBlindBoxLotteryResult) eCNetworkResponse.b();
                if (eCBlindBoxLotteryResult == null) {
                }
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.L$0 = coroutineScope2;
                eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2.label = 3;
                if (DelayKt.delay(2000L, eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2) == coroutine_suspended) {
                }
                if (!CoroutineScopeKt.isActive(coroutineScope2)) {
                }
            }
        } else if (i16 == 3) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        coroutineScope2 = coroutineScope;
        eCBlindBoxViewModel$checkLotteryAndReturnJumpUrl$2 = this;
        if (!CoroutineScopeKt.isActive(coroutineScope2)) {
        }
    }
}
