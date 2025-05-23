package com.tencent.mobileqq.aio.msglist.msgrepo;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.msgrepo.AccessibilityMsgRepo$handleRevokeDialogHide$1", f = "AccessibilityMsgRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AccessibilityMsgRepo$handleRevokeDialogHide$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Ref.BooleanRef $match;
    final /* synthetic */ long $msgId;
    int label;
    final /* synthetic */ AccessibilityMsgRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessibilityMsgRepo$handleRevokeDialogHide$1(AccessibilityMsgRepo accessibilityMsgRepo, Ref.BooleanRef booleanRef, long j3, Continuation<? super AccessibilityMsgRepo$handleRevokeDialogHide$1> continuation) {
        super(2, continuation);
        this.this$0 = accessibilityMsgRepo;
        this.$match = booleanRef;
        this.$msgId = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, accessibilityMsgRepo, booleanRef, Long.valueOf(j3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AccessibilityMsgRepo$handleRevokeDialogHide$1(this.this$0, this.$match, this.$msgId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MsgList M = this.this$0.e().M();
                long j3 = this.$msgId;
                Ref.BooleanRef booleanRef = this.$match;
                int i3 = 0;
                for (Object obj2 : M) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj2;
                    if ((aVar instanceof AIOMsgItem) && aVar.getMsgId() == j3) {
                        booleanRef.element = true;
                        AIOMsgItem cloneNewInstance = ((AIOMsgItem) aVar).cloneNewInstance();
                        cloneNewInstance.N1(true);
                        Unit unit = Unit.INSTANCE;
                        M.set(i3, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                    }
                    i3 = i16;
                }
                if (this.$match.element) {
                    BaseMsgRepo.o0(this.this$0.e(), M, "accessibility_focus_change", null, null, 12, null);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AccessibilityMsgRepo$handleRevokeDialogHide$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
