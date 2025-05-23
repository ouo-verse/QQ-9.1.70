package com.tencent.mobileqq.aio.msglist.holder.component.reply;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.msg.u;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.t;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "rsp", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyComponentVM$handleReplySourceClick$1", f = "AIOReplyComponentVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
final class AIOReplyComponentVM$handleReplySourceClick$1 extends SuspendLambda implements Function2<com.tencent.aio.msgservice.h<MsgRecord>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ View $clickedView;
    final /* synthetic */ u $msgItem;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOReplyComponentVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOReplyComponentVM$handleReplySourceClick$1(View view, AIOReplyComponentVM aIOReplyComponentVM, u uVar, Continuation<? super AIOReplyComponentVM$handleReplySourceClick$1> continuation) {
        super(2, continuation);
        this.$clickedView = view;
        this.this$0 = aIOReplyComponentVM;
        this.$msgItem = uVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, view, aIOReplyComponentVM, uVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOReplyComponentVM$handleReplySourceClick$1 aIOReplyComponentVM$handleReplySourceClick$1 = new AIOReplyComponentVM$handleReplySourceClick$1(this.$clickedView, this.this$0, this.$msgItem, continuation);
        aIOReplyComponentVM$handleReplySourceClick$1.L$0 = obj;
        return aIOReplyComponentVM$handleReplySourceClick$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.aio.msgservice.h<MsgRecord> hVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOReplyComponentVM$handleReplySourceClick$1) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar, (Object) continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.aio.msgservice.h hVar = (com.tencent.aio.msgservice.h) this.L$0;
                if (!hVar.d()) {
                    QLog.i(FrameworkVM.TAG, 1, "[handleReplySourceClick]: getMultiForwardMsg fail");
                    return Unit.INSTANCE;
                }
                if (hVar.a().isEmpty()) {
                    QLog.i(FrameworkVM.TAG, 1, "[handleReplySourceClick]: getMultiForwardMsg list is empty");
                    return Unit.INSTANCE;
                }
                MsgRecord msgRecord = (MsgRecord) hVar.a().get(0);
                QLog.i(FrameworkVM.TAG, 1, "[handleReplySourceClick]: sourceMsgId is " + msgRecord.msgId);
                t tVar = t.f352318a;
                String a16 = tVar.a(msgRecord);
                Context context = this.$clickedView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "clickedView.context");
                tVar.b(context, (com.tencent.aio.api.runtime.a) this.this$0.getMContext(), a16, msgRecord, this.$msgItem.getMsgRecord());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
