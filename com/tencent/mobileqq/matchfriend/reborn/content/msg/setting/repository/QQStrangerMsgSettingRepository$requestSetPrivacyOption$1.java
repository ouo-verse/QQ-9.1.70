package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository;

import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$Options;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$PrivacyOption;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$SetOptionsReq;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$SetOptionsRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/QQStrangerMsgSettingRepository$b;", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$SetOptionsRsp;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetPrivacyOption$1", f = "QQStrangerMsgSettingRepository.kt", i = {}, l = {153, 153}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerMsgSettingRepository$requestSetPrivacyOption$1 extends SuspendLambda implements Function2<FlowCollector<? super QQStrangerMsgSettingRepository.b<UserConfig$SetOptionsRsp>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $switch;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerMsgSettingRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerMsgSettingRepository$requestSetPrivacyOption$1(QQStrangerMsgSettingRepository qQStrangerMsgSettingRepository, boolean z16, Continuation<? super QQStrangerMsgSettingRepository$requestSetPrivacyOption$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerMsgSettingRepository;
        this.$switch = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerMsgSettingRepository$requestSetPrivacyOption$1 qQStrangerMsgSettingRepository$requestSetPrivacyOption$1 = new QQStrangerMsgSettingRepository$requestSetPrivacyOption$1(this.this$0, this.$switch, continuation);
        qQStrangerMsgSettingRepository$requestSetPrivacyOption$1.L$0 = obj;
        return qQStrangerMsgSettingRepository$requestSetPrivacyOption$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        List<Integer> listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            QQStrangerMsgSettingRepository qQStrangerMsgSettingRepository = this.this$0;
            UserConfig$SetOptionsReq userConfig$SetOptionsReq = new UserConfig$SetOptionsReq();
            boolean z16 = this.$switch;
            PBRepeatField<Integer> pBRepeatField = userConfig$SetOptionsReq.option_ids;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Boxing.boxInt(3));
            pBRepeatField.set(listOf);
            UserConfig$Options userConfig$Options = userConfig$SetOptionsReq.options;
            UserConfig$Options userConfig$Options2 = new UserConfig$Options();
            UserConfig$PrivacyOption userConfig$PrivacyOption = userConfig$Options2.privacy_option;
            UserConfig$PrivacyOption userConfig$PrivacyOption2 = new UserConfig$PrivacyOption();
            userConfig$PrivacyOption2.is_not_disturb.set(z16);
            userConfig$PrivacyOption.set(userConfig$PrivacyOption2);
            userConfig$Options.set(userConfig$Options2);
            this.L$0 = flowCollector;
            this.label = 1;
            obj = qQStrangerMsgSettingRepository.k(userConfig$SetOptionsReq, this);
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
    public final Object invoke(FlowCollector<? super QQStrangerMsgSettingRepository.b<UserConfig$SetOptionsRsp>> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerMsgSettingRepository$requestSetPrivacyOption$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
