package com.tencent.robot.profile;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.profile.RobotProfileViewModel$initNeedOpenRobotSquareState$1", f = "RobotProfileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotProfileViewModel$initNeedOpenRobotSquareState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RobotProfileViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileViewModel$initNeedOpenRobotSquareState$1(RobotProfileViewModel robotProfileViewModel, Continuation<? super RobotProfileViewModel$initNeedOpenRobotSquareState$1> continuation) {
        super(2, continuation);
        this.this$0 = robotProfileViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotProfileViewModel robotProfileViewModel, boolean z16) {
        MutableLiveData mutableLiveData;
        mutableLiveData = robotProfileViewModel._needShowOpenSquareTipsLiveData;
        mutableLiveData.setValue(Boolean.valueOf(!z16));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotProfileViewModel$initNeedOpenRobotSquareState$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        final boolean L2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            L2 = this.this$0.L2();
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final RobotProfileViewModel robotProfileViewModel = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.robot.profile.h
                @Override // java.lang.Runnable
                public final void run() {
                    RobotProfileViewModel$initNeedOpenRobotSquareState$1.b(RobotProfileViewModel.this, L2);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotProfileViewModel$initNeedOpenRobotSquareState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
