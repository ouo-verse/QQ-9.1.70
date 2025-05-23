package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository;

import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.qphone.base.util.QLog;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1", f = "QQStrangerMsgSettingRepository.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super QQStrangerMsgSettingOptionResult>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerMsgSettingRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1(QQStrangerMsgSettingRepository qQStrangerMsgSettingRepository, Continuation<? super QQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerMsgSettingRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1 qQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1 = new QQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1(this.this$0, continuation);
        qQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1.L$0 = obj;
        return qQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        a e16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            e16 = this.this$0.e();
            UserConfig$GetOptionsRsp a16 = e16.a();
            QLog.i("QQStrangerMsgSettingRepository", 1, "[loadMsgSettingDataCacheFlow] cache=" + (a16 != null ? Proto2JsonUtil.proto2Json(a16) : null));
            QQStrangerMsgSettingOptionResult qQStrangerMsgSettingOptionResult = new QQStrangerMsgSettingOptionResult(true, true, a16);
            this.label = 1;
            if (flowCollector.emit(qQStrangerMsgSettingOptionResult, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super QQStrangerMsgSettingOptionResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
