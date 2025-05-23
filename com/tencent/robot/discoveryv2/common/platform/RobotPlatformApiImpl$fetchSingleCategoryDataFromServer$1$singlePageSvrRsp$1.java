package com.tencent.robot.discoveryv2.common.platform;

import com.tencent.robot.discoveryv2.common.data.SingleCategoryFetchArgs;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/robot/discoveryv2/common/data/j;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.discoveryv2.common.platform.RobotPlatformApiImpl$fetchSingleCategoryDataFromServer$1$singlePageSvrRsp$1", f = "RobotPlatformApiImpl.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class RobotPlatformApiImpl$fetchSingleCategoryDataFromServer$1$singlePageSvrRsp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SingleCategoryRsp>, Object> {
    final /* synthetic */ SingleCategoryFetchArgs $fetchArgs;
    final /* synthetic */ byte[] $svrCookie;
    final /* synthetic */ String $svrDataVersion;
    int label;
    final /* synthetic */ RobotPlatformApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotPlatformApiImpl$fetchSingleCategoryDataFromServer$1$singlePageSvrRsp$1(RobotPlatformApiImpl robotPlatformApiImpl, SingleCategoryFetchArgs singleCategoryFetchArgs, byte[] bArr, String str, Continuation<? super RobotPlatformApiImpl$fetchSingleCategoryDataFromServer$1$singlePageSvrRsp$1> continuation) {
        super(2, continuation);
        this.this$0 = robotPlatformApiImpl;
        this.$fetchArgs = singleCategoryFetchArgs;
        this.$svrCookie = bArr;
        this.$svrDataVersion = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotPlatformApiImpl$fetchSingleCategoryDataFromServer$1$singlePageSvrRsp$1(this.this$0, this.$fetchArgs, this.$svrCookie, this.$svrDataVersion, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            RobotPlatformApiImpl robotPlatformApiImpl = this.this$0;
            SingleCategoryFetchArgs singleCategoryFetchArgs = this.$fetchArgs;
            byte[] bArr = this.$svrCookie;
            String str = this.$svrDataVersion;
            this.label = 1;
            obj = robotPlatformApiImpl.j(singleCategoryFetchArgs, bArr, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SingleCategoryRsp> continuation) {
        return ((RobotPlatformApiImpl$fetchSingleCategoryDataFromServer$1$singlePageSvrRsp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
