package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager$ShortVideoEncodeListener$onSuccess$1", f = "AIOVideoSendingManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
final class AIOVideoSendingManager$ShortVideoEncodeListener$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ShortVideoMsgItem $msgItem;
    final /* synthetic */ int $videoCodecFormatType;
    final /* synthetic */ String $videoPath;
    int label;
    final /* synthetic */ AIOVideoSendingManager.ShortVideoEncodeListener this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOVideoSendingManager$ShortVideoEncodeListener$onSuccess$1(ShortVideoMsgItem shortVideoMsgItem, int i3, String str, AIOVideoSendingManager.ShortVideoEncodeListener shortVideoEncodeListener, Continuation<? super AIOVideoSendingManager$ShortVideoEncodeListener$onSuccess$1> continuation) {
        super(2, continuation);
        this.$msgItem = shortVideoMsgItem;
        this.$videoCodecFormatType = i3;
        this.$videoPath = str;
        this.this$0 = shortVideoEncodeListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, shortVideoMsgItem, Integer.valueOf(i3), str, shortVideoEncodeListener, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOVideoSendingManager$ShortVideoEncodeListener$onSuccess$1(this.$msgItem, this.$videoCodecFormatType, this.$videoPath, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$msgItem.E2().sourceVideoCodecFormat = u.INSTANCE.b(Boxing.boxInt(this.$videoCodecFormatType));
                k kVar = k.f192240a;
                MsgElement y26 = this.$msgItem.y2();
                String str = this.$videoPath;
                Intrinsics.checkNotNull(str);
                kVar.g(y26, str, true);
                kVar.f(this.$msgItem.y2());
                this.$msgItem.q2();
                this.$msgItem.p2();
                AIOVideoSendingManager.INSTANCE.d().removeEncodeTask(this.$msgItem.getMsgId());
                this.this$0.b().p();
                this.this$0.b().u();
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOVideoSendingManager$ShortVideoEncodeListener$onSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
