package com.tencent.robot.discoveryv2.common.platform;

import com.tencent.robot.discoveryv2.common.data.FirstScreenFetchArgs;
import com.tencent.robot.discoveryv2.common.data.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.discoveryv2.common.platform.RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1", f = "RobotPlatformApiImpl.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FirstScreenFetchArgs $fetchArgs;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotPlatformApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1(RobotPlatformApiImpl robotPlatformApiImpl, FirstScreenFetchArgs firstScreenFetchArgs, Continuation<? super RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1> continuation) {
        super(2, continuation);
        this.this$0 = robotPlatformApiImpl;
        this.$fetchArgs = firstScreenFetchArgs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1 robotPlatformApiImpl$fetchFirstScreenDataFromServer$1 = new RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1(this.this$0, this.$fetchArgs, continuation);
        robotPlatformApiImpl$fetchFirstScreenDataFromServer$1.L$0 = obj;
        return robotPlatformApiImpl$fetchFirstScreenDataFromServer$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        ConcurrentHashMap concurrentHashMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1$serverRspData$1(this.this$0, this.$fetchArgs, null), 3, null);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        b bVar = (b) obj;
        concurrentHashMap = this.this$0.mFirstScreenRspListener;
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            ((Function1) ((Map.Entry) it.next()).getValue()).invoke(bVar);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
