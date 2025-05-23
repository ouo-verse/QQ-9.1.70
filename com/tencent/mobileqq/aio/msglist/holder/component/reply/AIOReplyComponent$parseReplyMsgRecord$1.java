package com.tencent.mobileqq.aio.msglist.holder.component.reply;

import com.tencent.mobileqq.aio.msg.u;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyComponent$parseReplyMsgRecord$1", f = "AIOReplyComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOReplyComponent$parseReplyMsgRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ u $msgItem;
    final /* synthetic */ ReplyElement $replyElement;
    int label;
    final /* synthetic */ AIOReplyComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOReplyComponent$parseReplyMsgRecord$1(AIOReplyComponent aIOReplyComponent, u uVar, ReplyElement replyElement, Continuation<? super AIOReplyComponent$parseReplyMsgRecord$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOReplyComponent;
        this.$msgItem = uVar;
        this.$replyElement = replyElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOReplyComponent, uVar, replyElement, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOReplyComponent$parseReplyMsgRecord$1(this.this$0, this.$msgItem, this.$replyElement, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        m mVar;
        m mVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                mVar = this.this$0.mSourceContentBinding;
                m mVar3 = null;
                if (mVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                    mVar = null;
                }
                mVar.f444855l.setVisibility(8);
                mVar2 = this.this$0.mSourceContentBinding;
                if (mVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSourceContentBinding");
                } else {
                    mVar3 = mVar2;
                }
                mVar3.f444851h.setVisibility(8);
                if (this.$msgItem.D2() == null) {
                    QLog.d("AIOReplyComponent", 1, "parseReplyMsgRecord msgItem.replyMsgRecord == null, msgId=" + this.$msgItem.getMsgId());
                    this.this$0.D3(this.$msgItem, this.$replyElement);
                } else if (this.$msgItem.getMsgId() == AIOReplyComponent.B2(this.this$0).getMsgId()) {
                    String simpleUinForPrint = StringUtil.getSimpleUinForPrint(String.valueOf(this.$msgItem.getMsgRecord().peerUin));
                    MsgRecord D2 = this.$msgItem.D2();
                    Intrinsics.checkNotNull(D2);
                    QLog.d("AIOReplyComponent", 1, "parseReplyMsgRecord, peerUin=" + simpleUinForPrint + ", replyMsgRecord.peerUin=" + StringUtil.getSimpleUinForPrint(String.valueOf(D2.peerUin)));
                    AIOReplyComponent aIOReplyComponent = this.this$0;
                    u uVar = this.$msgItem;
                    ReplyElement replyElement = this.$replyElement;
                    MsgRecord D22 = uVar.D2();
                    Intrinsics.checkNotNull(D22);
                    aIOReplyComponent.A3(uVar, replyElement, D22);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOReplyComponent$parseReplyMsgRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
