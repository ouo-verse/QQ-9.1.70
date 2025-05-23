package com.tencent.robot.profile.subscribe;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateID;
import java.util.LinkedList;
import java.util.List;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.profile.subscribe.RobotSubscribeSettingViewModel$mergeResponseToLiveData$1", f = "RobotSubscribeSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotSubscribeSettingViewModel$mergeResponseToLiveData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<e<SubscribeMsgTemplateID>> $newConfigList;
    int label;
    final /* synthetic */ RobotSubscribeSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSubscribeSettingViewModel$mergeResponseToLiveData$1(RobotSubscribeSettingViewModel robotSubscribeSettingViewModel, List<e<SubscribeMsgTemplateID>> list, Continuation<? super RobotSubscribeSettingViewModel$mergeResponseToLiveData$1> continuation) {
        super(2, continuation);
        this.this$0 = robotSubscribeSettingViewModel;
        this.$newConfigList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotSubscribeSettingViewModel$mergeResponseToLiveData$1(this.this$0, this.$newConfigList, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0.mConfigListLiveData;
            mutableLiveData2 = this.this$0.mConfigListLiveData;
            List list = (List) mutableLiveData2.getValue();
            if (list == null) {
                list = new LinkedList();
            }
            list.addAll(this.$newConfigList);
            mutableLiveData.setValue(list);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotSubscribeSettingViewModel$mergeResponseToLiveData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
