package com.tencent.mobileqq.zplan.couple.manager;

import com.tencent.mobileqq.zplan.couple.config.BubbleType;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleBubbleConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.couple.manager.ZPlanCoupleBubbleDataManager$requestSettingPageBubbles$1", f = "ZPlanCoupleBubbleDataManager.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanCoupleBubbleDataManager$requestSettingPageBubbles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanCoupleBubbleDataManager$requestSettingPageBubbles$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanCoupleBubbleDataManager zPlanCoupleBubbleDataManager = ZPlanCoupleBubbleDataManager.f332649a;
            this.label = 1;
            obj = zPlanCoupleBubbleDataManager.h(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            copyOnWriteArrayList = ZPlanCoupleBubbleDataManager.settingBubbles;
            copyOnWriteArrayList.clear();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (((ZPlanCoupleBubbleConfig) obj2).getType() == BubbleType.SETTING_OPERATION_BUBBLE_TYPE.getValue()) {
                    arrayList.add(obj2);
                }
            }
            copyOnWriteArrayList2 = ZPlanCoupleBubbleDataManager.settingBubbles;
            copyOnWriteArrayList2.addAll(arrayList);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanCoupleBubbleDataManager$requestSettingPageBubbles$1(Continuation<? super ZPlanCoupleBubbleDataManager$requestSettingPageBubbles$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanCoupleBubbleDataManager$requestSettingPageBubbles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
