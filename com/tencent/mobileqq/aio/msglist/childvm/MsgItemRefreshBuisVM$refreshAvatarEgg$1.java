package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
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
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.childvm.MsgItemRefreshBuisVM$refreshAvatarEgg$1", f = "MsgItemRefreshBuisVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class MsgItemRefreshBuisVM$refreshAvatarEgg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.qqnt.aio.refresher.c $rsp;
    int label;
    final /* synthetic */ MsgItemRefreshBuisVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgItemRefreshBuisVM$refreshAvatarEgg$1(MsgItemRefreshBuisVM msgItemRefreshBuisVM, com.tencent.qqnt.aio.refresher.c cVar, Continuation<? super MsgItemRefreshBuisVM$refreshAvatarEgg$1> continuation) {
        super(2, continuation);
        this.this$0 = msgItemRefreshBuisVM;
        this.$rsp = cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgItemRefreshBuisVM, cVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MsgItemRefreshBuisVM$refreshAvatarEgg$1(this.this$0, this.$rsp, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                MsgList M = this.this$0.d().m().M();
                if (M.isEmpty()) {
                    QLog.i("MsgItemRefreshBuisVM", 1, "[refreshAvatarEgg]: displayList size is 0");
                }
                com.tencent.qqnt.aio.refresher.c cVar = this.$rsp;
                int i16 = 0;
                for (Object obj2 : M) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj2;
                    if ((aVar instanceof AIOMsgItem) && aVar.getMsgId() == cVar.b()) {
                        AIOMsgItem cloneNewInstance = ((AIOMsgItem) aVar).cloneNewInstance();
                        com.tencent.qqnt.aio.avatar.egg.a q16 = cloneNewInstance.q();
                        if (q16 != null) {
                            i3 = q16.d();
                        } else {
                            i3 = 0;
                        }
                        com.tencent.qqnt.aio.avatar.egg.a b16 = com.tencent.qqnt.aio.avatar.egg.a.b(cVar.a(), 0, null, null, null, 0, 31, null);
                        b16.h(i3 + 1);
                        cloneNewInstance.b1(b16);
                        Unit unit = Unit.INSTANCE;
                        M.set(i16, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                        booleanRef.element = true;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("MsgItemRefreshBuisVM", 4, "[refreshAvatarEgg]: msgId is " + aVar.getMsgId());
                        }
                    }
                    i16 = i17;
                }
                if (booleanRef.element) {
                    e.a(this.this$0, M, "avatar_egg");
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgItemRefreshBuisVM$refreshAvatarEgg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
