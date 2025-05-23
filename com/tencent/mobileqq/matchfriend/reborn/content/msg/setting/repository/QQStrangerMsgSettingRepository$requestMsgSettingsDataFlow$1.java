package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository;

import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$GetOptionsRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/QQStrangerMsgSettingRepository$b;", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$GetOptionsRsp;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1", f = "QQStrangerMsgSettingRepository.kt", i = {}, l = {58, 58}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super QQStrangerMsgSettingRepository.b<UserConfig$GetOptionsRsp>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerMsgSettingRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1(QQStrangerMsgSettingRepository qQStrangerMsgSettingRepository, Continuation<? super QQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerMsgSettingRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1 qQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1 = new QQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1(this.this$0, continuation);
        qQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1.L$0 = obj;
        return qQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            QQStrangerMsgSettingRepository qQStrangerMsgSettingRepository = this.this$0;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = qQStrangerMsgSettingRepository.j(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super QQStrangerMsgSettingRepository.b<UserConfig$GetOptionsRsp>> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
