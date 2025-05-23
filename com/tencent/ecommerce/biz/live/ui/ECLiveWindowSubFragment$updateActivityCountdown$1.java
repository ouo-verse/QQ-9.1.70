package com.tencent.ecommerce.biz.live.ui;

import android.content.Context;
import com.tencent.ecommerce.biz.live.ui.viewholder.ItemPayload;
import com.tencent.ecommerce.repo.live.ActivityStatus;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveProduct;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$updateActivityCountdown$1", f = "ECLiveWindowSubFragment.kt", i = {0}, l = {1002}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
/* loaded from: classes31.dex */
public final class ECLiveWindowSubFragment$updateActivityCountdown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ECLiveWindowSubFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLiveWindowSubFragment$updateActivityCountdown$1(ECLiveWindowSubFragment eCLiveWindowSubFragment, Context context, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCLiveWindowSubFragment;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECLiveWindowSubFragment$updateActivityCountdown$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECLiveWindowSubFragment$updateActivityCountdown$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0102 -> B:5:0x0108). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List Fi;
        Iterator it;
        ECLiveWindowSubFragment$updateActivityCountdown$1 eCLiveWindowSubFragment$updateActivityCountdown$1;
        ActivityStatus activityStatus;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            cg0.a.b(ECLiveWindowSubFragment.bi(this.this$0), "updateActivityCountdown tick");
            Fi = this.this$0.Fi();
            it = Fi.iterator();
            eCLiveWindowSubFragment$updateActivityCountdown$1 = this;
            while (it.hasNext()) {
            }
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            LiveProduct liveProduct = (LiveProduct) this.L$1;
            Iterator it5 = (Iterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            Iterator it6 = it5;
            LiveProduct liveProduct2 = liveProduct;
            Object obj2 = coroutine_suspended;
            ECLiveWindowSubFragment$updateActivityCountdown$1 eCLiveWindowSubFragment$updateActivityCountdown$12 = this;
            ItemPayload itemPayload = (ItemPayload) obj;
            cg0.a.b(ECLiveWindowSubFragment.bi(eCLiveWindowSubFragment$updateActivityCountdown$12.this$0), "updateActivityCountdown \u53ea\u5237\u65b0\u5012\u8ba1\u65f6 " + itemPayload + ", position:" + liveProduct2.getPositionInList());
            ECLiveWindowSubFragment.Zh(eCLiveWindowSubFragment$updateActivityCountdown$12.this$0).notifyItemChanged(liveProduct2.getPositionInList(), itemPayload);
            eCLiveWindowSubFragment$updateActivityCountdown$1 = eCLiveWindowSubFragment$updateActivityCountdown$12;
            coroutine_suspended = obj2;
            it = it6;
            while (it.hasNext()) {
                LiveProduct liveProduct3 = (LiveProduct) it.next();
                LiveActivity liveActivity = liveProduct3.getLiveActivity();
                if (liveActivity != null) {
                    ActivityStatus activityStatus2 = liveActivity.getActivityStatus();
                    int i16 = a.f102789c[liveProduct3.R().ordinal()];
                    if (i16 == 1) {
                        if (activityStatus2 == ActivityStatus.ACTIVITY_STATUS_PENDING) {
                            cg0.a.b(ECLiveWindowSubFragment.bi(eCLiveWindowSubFragment$updateActivityCountdown$1.this$0), "updateActivityCountdown pending -> running: item\u5237\u65b0, position:" + liveProduct3.getPositionInList() + TokenParser.SP + liveProduct3);
                            liveActivity.l(ActivityStatus.ACTIVITY_STATUS_RUNNING);
                            ECLiveWindowSubFragment.Zh(eCLiveWindowSubFragment$updateActivityCountdown$1.this$0).notifyItemChanged(liveProduct3.getPositionInList());
                        } else {
                            CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                            ECLiveWindowSubFragment$updateActivityCountdown$1$invokeSuspend$$inlined$forEach$lambda$1 eCLiveWindowSubFragment$updateActivityCountdown$1$invokeSuspend$$inlined$forEach$lambda$1 = new ECLiveWindowSubFragment$updateActivityCountdown$1$invokeSuspend$$inlined$forEach$lambda$1(null, liveProduct3, eCLiveWindowSubFragment$updateActivityCountdown$1);
                            eCLiveWindowSubFragment$updateActivityCountdown$1.L$0 = it;
                            eCLiveWindowSubFragment$updateActivityCountdown$1.L$1 = liveProduct3;
                            eCLiveWindowSubFragment$updateActivityCountdown$1.label = 1;
                            Object withContext = BuildersKt.withContext(coroutineDispatcher, eCLiveWindowSubFragment$updateActivityCountdown$1$invokeSuspend$$inlined$forEach$lambda$1, eCLiveWindowSubFragment$updateActivityCountdown$1);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Object obj3 = coroutine_suspended;
                            eCLiveWindowSubFragment$updateActivityCountdown$12 = eCLiveWindowSubFragment$updateActivityCountdown$1;
                            obj = withContext;
                            it6 = it;
                            liveProduct2 = liveProduct3;
                            obj2 = obj3;
                            ItemPayload itemPayload2 = (ItemPayload) obj;
                            cg0.a.b(ECLiveWindowSubFragment.bi(eCLiveWindowSubFragment$updateActivityCountdown$12.this$0), "updateActivityCountdown \u53ea\u5237\u65b0\u5012\u8ba1\u65f6 " + itemPayload2 + ", position:" + liveProduct2.getPositionInList());
                            ECLiveWindowSubFragment.Zh(eCLiveWindowSubFragment$updateActivityCountdown$12.this$0).notifyItemChanged(liveProduct2.getPositionInList(), itemPayload2);
                            eCLiveWindowSubFragment$updateActivityCountdown$1 = eCLiveWindowSubFragment$updateActivityCountdown$12;
                            coroutine_suspended = obj2;
                            it = it6;
                            while (it.hasNext()) {
                            }
                        }
                    } else if (i16 == 2 && activityStatus2 == (activityStatus = ActivityStatus.ACTIVITY_STATUS_RUNNING)) {
                        cg0.a.b(ECLiveWindowSubFragment.bi(eCLiveWindowSubFragment$updateActivityCountdown$1.this$0), "updateActivityCountdown running -> none: item\u5237\u65b0, position:" + liveProduct3.getPositionInList() + TokenParser.SP + liveProduct3);
                        if (liveActivity.getActivityStatus() == activityStatus) {
                            liveActivity.l(ActivityStatus.ACTIVITY_STATUS_END);
                        }
                        ECLiveWindowSubFragment.Zh(eCLiveWindowSubFragment$updateActivityCountdown$1.this$0).notifyItemChanged(liveProduct3.getPositionInList());
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
