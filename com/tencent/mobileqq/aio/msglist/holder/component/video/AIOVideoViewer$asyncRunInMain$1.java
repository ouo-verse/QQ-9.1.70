package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer$asyncRunInMain$1", f = "AIOVideoViewer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOVideoViewer$asyncRunInMain$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function0<Unit> $block;
    final /* synthetic */ long $msgId;
    int label;
    final /* synthetic */ AIOVideoViewer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOVideoViewer$asyncRunInMain$1(long j3, AIOVideoViewer aIOVideoViewer, Function0<Unit> function0, Continuation<? super AIOVideoViewer$asyncRunInMain$1> continuation) {
        super(2, continuation);
        this.$msgId = j3;
        this.this$0 = aIOVideoViewer;
        this.$block = function0;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), aIOVideoViewer, function0, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOVideoViewer$asyncRunInMain$1(this.$msgId, this.this$0, this.$block, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                long j3 = this.$msgId;
                ShortVideoMsgItem shortVideoMsgItem = this.this$0.currentMsgItem;
                ShortVideoMsgItem shortVideoMsgItem2 = null;
                if (shortVideoMsgItem == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    shortVideoMsgItem = null;
                }
                if (j3 != shortVideoMsgItem.getMsgId()) {
                    AIOVideoViewer aIOVideoViewer = this.this$0;
                    long j16 = this.$msgId;
                    ShortVideoMsgItem shortVideoMsgItem3 = aIOVideoViewer.currentMsgItem;
                    if (shortVideoMsgItem3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    } else {
                        shortVideoMsgItem2 = shortVideoMsgItem3;
                    }
                    aIOVideoViewer.X("asyncRunInMain, ignored, msgId=" + j16 + "!=" + shortVideoMsgItem2.getMsgId());
                } else {
                    this.$block.invoke();
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOVideoViewer$asyncRunInMain$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
