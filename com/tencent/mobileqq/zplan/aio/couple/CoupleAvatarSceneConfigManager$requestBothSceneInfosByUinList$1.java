package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.mobileqq.zplan.servlet.ZPlanCoupleAvatarRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSceneConfigManager$requestBothSceneInfosByUinList$1", f = "CoupleAvatarSceneConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class CoupleAvatarSceneConfigManager$requestBothSceneInfosByUinList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long[] $uinList;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSceneConfigManager$requestBothSceneInfosByUinList$1$a", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.zplan.servlet.b {
        a() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            ConcurrentHashMap concurrentHashMap;
            if (!isSuccess) {
                QLog.e("CoupleAvatarSceneConfigManager", 1, "requestBothSceneInfosByUinList failed");
                return;
            }
            try {
                Map<Long, Integer> sceneIdArray = wv4.b.c(data instanceof byte[] ? (byte[]) data : null).f446592a;
                if (sceneIdArray == null || sceneIdArray.isEmpty()) {
                    QLog.e("CoupleAvatarSceneConfigManager", 1, "requestBothSceneInfosByUinList failed empty resourceConfigArray");
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(sceneIdArray, "sceneIdArray");
                for (Map.Entry<Long, Integer> entry : sceneIdArray.entrySet()) {
                    Long key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value != null && value.intValue() != 0) {
                        concurrentHashMap = CoupleAvatarSceneConfigManager.bothSceneMap;
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        concurrentHashMap.put(key, value);
                    }
                }
            } catch (Exception e16) {
                QLog.e("CoupleAvatarSceneConfigManager", 1, "requestBothSceneInfosByUinList failed.", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarSceneConfigManager$requestBothSceneInfosByUinList$1(long[] jArr, Continuation<? super CoupleAvatarSceneConfigManager$requestBothSceneInfosByUinList$1> continuation) {
        super(2, continuation);
        this.$uinList = jArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoupleAvatarSceneConfigManager$requestBothSceneInfosByUinList$1(this.$uinList, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanCoupleAvatarRequest.f335363a.b(this.$uinList, new a());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarSceneConfigManager$requestBothSceneInfosByUinList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
