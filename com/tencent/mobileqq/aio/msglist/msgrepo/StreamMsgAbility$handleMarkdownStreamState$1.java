package com.tencent.mobileqq.aio.msglist.msgrepo;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.msgrepo.StreamMsgAbility$handleMarkdownStreamState$1", f = "StreamMsgAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class StreamMsgAbility$handleMarkdownStreamState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ StreamMsgEvent.UpdateAnimStatus $intent;
    int label;
    final /* synthetic */ StreamMsgAbility this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamMsgAbility$handleMarkdownStreamState$1(StreamMsgAbility streamMsgAbility, StreamMsgEvent.UpdateAnimStatus updateAnimStatus, Continuation<? super StreamMsgAbility$handleMarkdownStreamState$1> continuation) {
        super(2, continuation);
        this.this$0 = streamMsgAbility;
        this.$intent = updateAnimStatus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, streamMsgAbility, updateAnimStatus, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new StreamMsgAbility$handleMarkdownStreamState$1(this.this$0, this.$intent, continuation);
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
                MsgList M = this.this$0.e().M();
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                StreamMsgEvent.UpdateAnimStatus updateAnimStatus = this.$intent;
                StreamMsgAbility streamMsgAbility = this.this$0;
                int i3 = 0;
                for (com.tencent.aio.data.msglist.a aVar : M) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar2 = aVar;
                    if ((aVar2 instanceof com.tencent.mobileqq.aio.msg.l) && aVar2.getMsgId() == updateAnimStatus.a()) {
                        if (((com.tencent.mobileqq.aio.msg.l) aVar2).d() != updateAnimStatus.b()) {
                            com.tencent.aio.data.msglist.a cloneNewInstance = aVar2.cloneNewInstance();
                            com.tencent.aio.data.msglist.a aVar3 = null;
                            if (!(cloneNewInstance instanceof com.tencent.aio.data.msglist.a)) {
                                cloneNewInstance = null;
                            }
                            if (cloneNewInstance != null) {
                                if (cloneNewInstance instanceof com.tencent.mobileqq.aio.msg.l) {
                                    ((com.tencent.mobileqq.aio.msg.l) cloneNewInstance).a(updateAnimStatus.b());
                                }
                                booleanRef.element = true;
                                Unit unit = Unit.INSTANCE;
                                aVar3 = cloneNewInstance;
                            }
                            M.set(i3, aVar3);
                        }
                        if (booleanRef.element) {
                            BaseMsgRepo.o0(streamMsgAbility.e(), M, "markdown_stream_change", null, null, 12, null);
                        }
                    }
                    i3 = i16;
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((StreamMsgAbility$handleMarkdownStreamState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
