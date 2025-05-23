package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.msglist.uistate.AIOMsgListViewState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.childvm.PttMsgListChildVM$handlePlayNextUnread$1", f = "PttMsgListChildVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class PttMsgListChildVM$handlePlayNextUnread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $msgId;
    final /* synthetic */ float $speed;
    int label;
    final /* synthetic */ PttMsgListChildVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PttMsgListChildVM$handlePlayNextUnread$1(PttMsgListChildVM pttMsgListChildVM, long j3, float f16, Continuation<? super PttMsgListChildVM$handlePlayNextUnread$1> continuation) {
        super(2, continuation);
        this.this$0 = pttMsgListChildVM;
        this.$msgId = j3;
        this.$speed = f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, pttMsgListChildVM, Long.valueOf(j3), Float.valueOf(f16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new PttMsgListChildVM$handlePlayNextUnread$1(this.this$0, this.$msgId, this.$speed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PttMsgItem pttMsgItem;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                MsgList M = this.this$0.d().m().M();
                long j3 = this.$msgId;
                float f16 = this.$speed;
                PttMsgListChildVM pttMsgListChildVM = this.this$0;
                int i3 = 0;
                for (com.tencent.aio.data.msglist.a aVar : M) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar2 = aVar;
                    if (aVar2.getViewType() == 12) {
                        if (!booleanRef.element) {
                            if (j3 == aVar2.getMsgId()) {
                                booleanRef.element = true;
                                QLog.d("PttMsgListChildVM", 1, "find target ptt msg, msgId:" + aVar2.getMsgId() + ", msgSeq:" + aVar2.getMsgSeq());
                            }
                        } else {
                            if (aVar2 instanceof PttMsgItem) {
                                pttMsgItem = (PttMsgItem) aVar2;
                            } else {
                                pttMsgItem = null;
                            }
                            if (pttMsgItem != null && !pttMsgItem.D2()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                HashMap<AIOMsgItemPayloadType, com.tencent.mobileqq.aio.msglist.payload.a> a16 = new com.tencent.mobileqq.aio.msglist.payload.b().b(AIOMsgItemPayloadType.PTT_PLAY_NEXT_PAYLOAD, new a.an(f16)).a();
                                QLog.d("PttMsgListChildVM", 1, "handlePlayNextUnread msgId:" + aVar2.getMsgId() + ", msgSeq:" + aVar2.getMsgSeq());
                                pttMsgListChildVM.f(new AIOMsgListViewState.AIOMsgItemChangedState(i3, 1, a16));
                                return Unit.INSTANCE;
                            }
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PttMsgListChildVM$handlePlayNextUnread$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
