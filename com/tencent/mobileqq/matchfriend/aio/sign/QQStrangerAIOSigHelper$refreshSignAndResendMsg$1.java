package com.tencent.mobileqq.matchfriend.aio.sign;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
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
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigHelper$refreshSignAndResendMsg$1", f = "QQStrangerAIOSigHelper.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"needResend"}, s = {"I$0"})
/* loaded from: classes33.dex */
public final class QQStrangerAIOSigHelper$refreshSignAndResendMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $msgId;
    final /* synthetic */ Contact $peer;
    int I$0;
    int label;
    final /* synthetic */ QQStrangerAIOSigHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerAIOSigHelper$refreshSignAndResendMsg$1(long j3, QQStrangerAIOSigHelper qQStrangerAIOSigHelper, Contact contact, Continuation<? super QQStrangerAIOSigHelper$refreshSignAndResendMsg$1> continuation) {
        super(2, continuation);
        this.$msgId = j3;
        this.this$0 = qQStrangerAIOSigHelper;
        this.$peer = contact;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, String str) {
        QLog.d("QQStrangerAIOSigHelper", 1, "resend msg result=" + i3 + " errMsg=" + str);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerAIOSigHelper$refreshSignAndResendMsg$1(this.$msgId, this.this$0, this.$peer, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008f, code lost:
    
        r9 = r8.this$0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        long j3;
        int i3;
        Long longOrNull;
        w i16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 == 0) {
            ResultKt.throwOnFailure(obj);
            long j16 = this.$msgId;
            j3 = this.this$0.lastSendErrorMsgId;
            ?? r95 = j16 != j3 ? 1 : 0;
            this.this$0.lastSendErrorMsgId = this.$msgId;
            String str = this.$peer.peerUid;
            long longValue = (str == null || longOrNull == null) ? 0L : longOrNull.longValue();
            QLog.d("QQStrangerAIOSigHelper", 1, "refreshSignAndResendMsg tinyId=" + longValue + " msgId=" + this.$msgId + " needResend=" + ((boolean) r95));
            QQStrangerAIOSigUtil qQStrangerAIOSigUtil = QQStrangerAIOSigUtil.f243975a;
            int i18 = this.$peer.chatType;
            this.I$0 = r95;
            this.label = 1;
            Object t16 = qQStrangerAIOSigUtil.t(i18, longValue, this);
            if (t16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            i3 = r95;
            obj = t16;
        } else if (i17 == 1) {
            i3 = this.I$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((byte[]) obj) == null) {
            return Unit.INSTANCE;
        }
        if (i3 != 0 && i16 != null) {
            i16.resendMsg(this.$peer, this.$msgId, new IOperateCallback() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i19, String str2) {
                    QQStrangerAIOSigHelper$refreshSignAndResendMsg$1.b(i19, str2);
                }
            });
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerAIOSigHelper$refreshSignAndResendMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
