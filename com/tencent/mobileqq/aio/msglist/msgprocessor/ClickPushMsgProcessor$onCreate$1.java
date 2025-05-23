package com.tencent.mobileqq.aio.msglist.msgprocessor;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.msgprocessor.ClickPushMsgProcessor$onCreate$1", f = "ClickPushMsgProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
final class ClickPushMsgProcessor$onCreate$1 extends SuspendLambda implements Function2<List<? extends MsgRecord>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClickPushMsgProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickPushMsgProcessor$onCreate$1(ClickPushMsgProcessor clickPushMsgProcessor, Continuation<? super ClickPushMsgProcessor$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = clickPushMsgProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) clickPushMsgProcessor, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        ClickPushMsgProcessor$onCreate$1 clickPushMsgProcessor$onCreate$1 = new ClickPushMsgProcessor$onCreate$1(this.this$0, continuation);
        clickPushMsgProcessor$onCreate$1.L$0 = obj;
        return clickPushMsgProcessor$onCreate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends MsgRecord> list, Continuation<? super Unit> continuation) {
        return invoke2((List<MsgRecord>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<MsgRecord> list = (List) this.L$0;
                ClickPushMsgProcessor clickPushMsgProcessor = this.this$0;
                for (MsgRecord msgRecord : list) {
                    j3 = clickPushMsgProcessor.pushMsgSeq;
                    long j16 = msgRecord.msgSeq;
                    if (j3 == j16) {
                        QLog.i("ClickPushMsgProcessor", 1, "push message received, seq=" + j16);
                        com.tencent.qqnt.trace.d.f362331a.g(System.currentTimeMillis());
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull List<MsgRecord> list, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ClickPushMsgProcessor$onCreate$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) continuation);
    }
}
