package com.tencent.mobileqq.zplan.couple.manager;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleBubbleConfig;
import com.tencent.qphone.base.util.QLog;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/zplan/couple/config/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.couple.manager.ZPlanCoupleGuideBubblePlayManager$getBubbleConfig$2", f = "ZPlanCoupleGuideBubblePlayManager.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanCoupleGuideBubblePlayManager$getBubbleConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanCoupleBubbleConfig>, Object> {
    int label;
    final /* synthetic */ ZPlanCoupleGuideBubblePlayManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCoupleGuideBubblePlayManager$getBubbleConfig$2(ZPlanCoupleGuideBubblePlayManager zPlanCoupleGuideBubblePlayManager, Continuation<? super ZPlanCoupleGuideBubblePlayManager$getBubbleConfig$2> continuation) {
        super(2, continuation);
        this.this$0 = zPlanCoupleGuideBubblePlayManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanCoupleGuideBubblePlayManager$getBubbleConfig$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        Object orNull;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanCoupleBubbleDataManager zPlanCoupleBubbleDataManager = ZPlanCoupleBubbleDataManager.f332649a;
            this.label = 1;
            obj = zPlanCoupleBubbleDataManager.f(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        if (list.isEmpty()) {
            QLog.e("ZPlanCoupleGuideBubblePlayManager", 1, "getAvatarGuideBubbles failed.");
            return null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        String currentUin = peekAppRuntime.getCurrentUin();
        IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
        str = this.this$0.GUIDE_SHOW_INDEX_MMKV_KEY;
        int i16 = iZPlanMMKVApi.getInt(str + "_" + currentUin, -1);
        int i17 = i16 != -1 ? i16 + 1 : 0;
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, i17);
        ZPlanCoupleBubbleConfig zPlanCoupleBubbleConfig = (ZPlanCoupleBubbleConfig) orNull;
        if (zPlanCoupleBubbleConfig == null) {
            return null;
        }
        IZPlanMMKVApi iZPlanMMKVApi2 = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
        str2 = this.this$0.GUIDE_SHOW_INDEX_MMKV_KEY;
        iZPlanMMKVApi2.setInt(str2 + "_" + currentUin, i17);
        QLog.i("ZPlanCoupleGuideBubblePlayManager", 1, "getBubbleConfig, showIndex: " + i17 + ", richText: " + zPlanCoupleBubbleConfig.getRichText());
        return zPlanCoupleBubbleConfig;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanCoupleBubbleConfig> continuation) {
        return ((ZPlanCoupleGuideBubblePlayManager$getBubbleConfig$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
