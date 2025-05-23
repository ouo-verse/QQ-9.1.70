package com.tencent.robot.profile.subscribe;

import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.profile.subscribe.RobotSubscribeSettingViewModel$modifySubscribeMsgTemplateStatus$1$1", f = "RobotSubscribeSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotSubscribeSettingViewModel$modifySubscribeMsgTemplateStatus$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e<SubscribeMsgTemplateID> $config;
    int label;
    final /* synthetic */ RobotSubscribeSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSubscribeSettingViewModel$modifySubscribeMsgTemplateStatus$1$1(e<SubscribeMsgTemplateID> eVar, RobotSubscribeSettingViewModel robotSubscribeSettingViewModel, Continuation<? super RobotSubscribeSettingViewModel$modifySubscribeMsgTemplateStatus$1$1> continuation) {
        super(2, continuation);
        this.$config = eVar;
        this.this$0 = robotSubscribeSettingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotSubscribeSettingViewModel$modifySubscribeMsgTemplateStatus$1$1(this.$config, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        x.c.f fVar;
        Function1 function1;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            x.c O = this.$config.O();
            if (O instanceof x.c.f) {
                fVar = (x.c.f) O;
            } else {
                fVar = null;
            }
            if (fVar != null) {
                RobotSubscribeSettingViewModel robotSubscribeSettingViewModel = this.this$0;
                e<SubscribeMsgTemplateID> eVar = this.$config;
                fVar.f(!fVar.getIsChecked());
                function1 = robotSubscribeSettingViewModel.mQUISwitchCheckChangeListener;
                if (function1 != null) {
                    function1.invoke(eVar);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotSubscribeSettingViewModel$modifySubscribeMsgTemplateStatus$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
