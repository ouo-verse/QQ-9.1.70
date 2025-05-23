package com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$RecommendReq;
import com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$RecommendRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.QQStrangerSurpriseMatchingVM$requestRecommend$1", f = "QQStrangerSurpriseMatchingVM.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSurpriseMatchingVM$requestRecommend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QQStrangerSurpriseMatchingVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSurpriseMatchingVM$requestRecommend$1(QQStrangerSurpriseMatchingVM qQStrangerSurpriseMatchingVM, Continuation<? super QQStrangerSurpriseMatchingVM$requestRecommend$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSurpriseMatchingVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSurpriseMatchingVM$requestRecommend$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        PBStringField pBStringField;
        PBUInt32Field pBUInt32Field;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.d("QQStrangerSurpriseMatchingVM", 1, "requestRecommend");
            QQStrangerSurpriseMatchingVM qQStrangerSurpriseMatchingVM = this.this$0;
            MessageMicro<SurpriseMatchPB$RecommendReq> messageMicro = new MessageMicro<SurpriseMatchPB$RecommendReq>() { // from class: com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$RecommendReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SurpriseMatchPB$RecommendReq.class);
            };
            this.label = 1;
            obj = qQStrangerSurpriseMatchingVM.O1("QQStranger.SurpriseMatch.SsoRecommend", messageMicro, SurpriseMatchPB$RecommendRsp.class, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SurpriseMatchPB$RecommendRsp surpriseMatchPB$RecommendRsp = (SurpriseMatchPB$RecommendRsp) obj;
        String str = null;
        Integer boxInt = (surpriseMatchPB$RecommendRsp == null || (pBUInt32Field = surpriseMatchPB$RecommendRsp.ret_code) == null) ? null : Boxing.boxInt(pBUInt32Field.get());
        if (surpriseMatchPB$RecommendRsp != null && (pBStringField = surpriseMatchPB$RecommendRsp.err_msg) != null) {
            str = pBStringField.get();
        }
        QLog.d("QQStrangerSurpriseMatchingVM", 1, "requestRecommend ret_code=" + boxInt + " err_msg=" + str);
        this.this$0.M1().postValue(surpriseMatchPB$RecommendRsp);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerSurpriseMatchingVM$requestRecommend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
