package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.j;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.childvm.MultiSelectMsgListChildVM$handleNavigateByResultEvent$1", f = "MultiSelectMsgListChildVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
final class MultiSelectMsgListChildVM$handleNavigateByResultEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MsgNavigationEvent.NavigationResultNotify $intent;
    int label;
    final /* synthetic */ MultiSelectMsgListChildVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSelectMsgListChildVM$handleNavigateByResultEvent$1(MultiSelectMsgListChildVM multiSelectMsgListChildVM, MsgNavigationEvent.NavigationResultNotify navigationResultNotify, Continuation<? super MultiSelectMsgListChildVM$handleNavigateByResultEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = multiSelectMsgListChildVM;
        this.$intent = navigationResultNotify;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, multiSelectMsgListChildVM, navigationResultNotify, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MultiSelectMsgListChildVM$handleNavigateByResultEvent$1(this.this$0, this.$intent, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MsgList M = this.this$0.d().G().M();
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                MsgNavigationEvent.NavigationResultNotify navigationResultNotify = this.$intent;
                int i3 = 0;
                for (com.tencent.aio.data.msglist.a aVar : M) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar2 = aVar;
                    if ((aVar2 instanceof AIOMsgItem) && aVar2.getMsgSeq() == navigationResultNotify.a()) {
                        AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar2;
                        if (aIOMsgItem.e2()) {
                            ?? cloneNewInstance = aIOMsgItem.cloneNewInstance();
                            cloneNewInstance.B1(cloneNewInstance.V() + 1);
                            objectRef.element = cloneNewInstance;
                            M.set(i3, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                            booleanRef.element = true;
                        }
                    }
                    i3 = i16;
                }
                QLog.i("MultiSelectMsgListChildVM", 1, "[handleNavigateByResultEvent]: match is " + booleanRef.element + ", seq is " + this.$intent.a());
                if (booleanRef.element) {
                    j e16 = this.this$0.c().e();
                    T t16 = objectRef.element;
                    Intrinsics.checkNotNull(t16);
                    e16.h(new MultiSelectEvent.AddSelectMsg((AIOMsgItem) t16, false, 2, null));
                    this.this$0.c().e().h(MultiSelectEvent.UpdateSelectCount.f188678d);
                    e.a(this.this$0, M, "msg_multi_select");
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MultiSelectMsgListChildVM$handleNavigateByResultEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
