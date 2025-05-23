package com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise;

import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$ReportReq;
import com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$ReportRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.QQStrangerSurpriseMatchingVM$reportAction$1", f = "QQStrangerSurpriseMatchingVM.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSurpriseMatchingVM$reportAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cookies;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ QQStrangerSurpriseMatchingVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSurpriseMatchingVM$reportAction$1(int i3, QQStrangerSurpriseMatchingVM qQStrangerSurpriseMatchingVM, String str, Continuation<? super QQStrangerSurpriseMatchingVM$reportAction$1> continuation) {
        super(2, continuation);
        this.$type = i3;
        this.this$0 = qQStrangerSurpriseMatchingVM;
        this.$cookies = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSurpriseMatchingVM$reportAction$1(this.$type, this.this$0, this.$cookies, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.d("QQStrangerSurpriseMatchingVM", 1, "reportAction type=" + this.$type);
            QQStrangerSurpriseMatchingVM qQStrangerSurpriseMatchingVM = this.this$0;
            SurpriseMatchPB$ReportReq surpriseMatchPB$ReportReq = new SurpriseMatchPB$ReportReq();
            String str = this.$cookies;
            int i16 = this.$type;
            surpriseMatchPB$ReportReq.cookies.set(str);
            surpriseMatchPB$ReportReq.operation_type.set(i16);
            Unit unit = Unit.INSTANCE;
            this.label = 1;
            obj = qQStrangerSurpriseMatchingVM.O1("QQStranger.SurpriseMatch.SsoReport", surpriseMatchPB$ReportReq, SurpriseMatchPB$ReportRsp.class, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SurpriseMatchPB$ReportRsp surpriseMatchPB$ReportRsp = (SurpriseMatchPB$ReportRsp) obj;
        if (surpriseMatchPB$ReportRsp != null) {
            QLog.d("QQStrangerSurpriseMatchingVM", 1, "reportAction ret_code=" + surpriseMatchPB$ReportRsp.ret_code.get() + " err_msg=" + surpriseMatchPB$ReportRsp.err_msg.get());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerSurpriseMatchingVM$reportAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
