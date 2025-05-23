package com.tencent.robot.aio.helper.tts;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTsConfigReq;
import com.tencent.robot.api.IRobotPersonalInfoService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u64.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.aio.helper.tts.RobotTtsAbilityHelper$setAutoTtsSwitchState$1$isSuccess$1", f = "RobotTtsAbilityHelper.kt", i = {}, l = {450}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class RobotTtsAbilityHelper$setAutoTtsSwitchState$1$isSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $targetSwitchOpened;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ RobotTtsAbilityHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a implements IOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RobotTtsAbilityHelper f367095a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f367096b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f367097c;

        /* JADX WARN: Multi-variable type inference failed */
        a(RobotTtsAbilityHelper robotTtsAbilityHelper, boolean z16, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f367095a = robotTtsAbilityHelper;
            this.f367096b = z16;
            this.f367097c = cancellableContinuation;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public final void onResult(int i3, String str) {
            IRuntimeService iRuntimeService;
            boolean z16 = true;
            QLog.i("RobotAutoTtsAbilityHelper", 1, "setRobotTTsConfig result = " + i3 + " errMsg = " + str);
            if (i3 == 0) {
                this.f367095a.J(this.f367096b);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    iRuntimeService = peekAppRuntime.getRuntimeService(IRobotPersonalInfoService.class, "");
                } else {
                    iRuntimeService = null;
                }
                IRobotPersonalInfoService iRobotPersonalInfoService = (IRobotPersonalInfoService) iRuntimeService;
                if (iRobotPersonalInfoService != null) {
                    iRobotPersonalInfoService.updateAutoTtsSwitchState(this.f367096b);
                }
            }
            CancellableContinuation<Boolean> cancellableContinuation = this.f367097c;
            Result.Companion companion = Result.INSTANCE;
            if (i3 != 0) {
                z16 = false;
            }
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotTtsAbilityHelper$setAutoTtsSwitchState$1$isSuccess$1(RobotTtsAbilityHelper robotTtsAbilityHelper, boolean z16, Continuation<? super RobotTtsAbilityHelper$setAutoTtsSwitchState$1$isSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = robotTtsAbilityHelper;
        this.$targetSwitchOpened = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotTtsAbilityHelper$setAutoTtsSwitchState$1$isSuccess$1(this.this$0, this.$targetSwitchOpened, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        String n3;
        Object coroutine_suspended2;
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
            this.this$0.mIsAutoTtsSwitchOpened = this.$targetSwitchOpened;
            this.this$0.K();
            this.this$0.E();
            RobotTtsAbilityHelper robotTtsAbilityHelper = this.this$0;
            boolean z16 = this.$targetSwitchOpened;
            this.L$0 = robotTtsAbilityHelper;
            this.Z$0 = z16;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            ac a16 = h.a();
            if (a16 == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
            } else {
                RobotTTsConfigReq robotTTsConfigReq = new RobotTTsConfigReq();
                n3 = robotTtsAbilityHelper.n();
                robotTTsConfigReq.robotUid = n3;
                robotTTsConfigReq.autoTts = z16 ? 1 : 0;
                a16.setRobotTTsConfig(robotTTsConfigReq, new a(robotTtsAbilityHelper, z16, cancellableContinuationImpl));
            }
            obj = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((RobotTtsAbilityHelper$setAutoTtsSwitchState$1$isSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
