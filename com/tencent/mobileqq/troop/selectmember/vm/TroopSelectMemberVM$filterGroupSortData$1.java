package com.tencent.mobileqq.troop.selectmember.vm;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.selectmember.helper.c;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.tencent.mobileqq.troop.selectmember.vm.TroopSelectMemberVM$filterGroupSortData$1", f = "TroopSelectMemberVM.kt", i = {0}, l = {com.tencent.luggage.wxa.v1.b.CTRL_INDEX}, m = "invokeSuspend", n = {"isConsumer"}, s = {"L$0"})
/* loaded from: classes19.dex */
public final class TroopSelectMemberVM$filterGroupSortData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ List<TroopMemberInfo> $memberList;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TroopSelectMemberVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TroopSelectMemberVM$filterGroupSortData$1(TroopSelectMemberVM troopSelectMemberVM, List<? extends TroopMemberInfo> list, Continuation<? super TroopSelectMemberVM$filterGroupSortData$1> continuation) {
        super(2, continuation);
        this.this$0 = troopSelectMemberVM;
        this.$memberList = list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopSelectMemberVM, list, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopSelectMemberVM$filterGroupSortData$1(this.this$0, this.$memberList, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.BooleanRef booleanRef;
        com.tencent.mobileqq.troop.selectmember.inject.b j26;
        Ref.BooleanRef booleanRef2;
        Ref.BooleanRef booleanRef3;
        c o26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    booleanRef2 = (Ref.BooleanRef) this.L$1;
                    booleanRef3 = (Ref.BooleanRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                booleanRef = new Ref.BooleanRef();
                j26 = this.this$0.j2();
                com.tencent.mobileqq.troop.selectmember.inject.a a16 = j26.a();
                if (a16 != null) {
                    List<TroopMemberInfo> list = this.$memberList;
                    TroopSelectMemberVM troopSelectMemberVM = this.this$0;
                    this.L$0 = booleanRef;
                    this.L$1 = booleanRef;
                    this.label = 1;
                    Object a17 = a16.a(list, troopSelectMemberVM, this);
                    if (a17 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    booleanRef2 = booleanRef;
                    obj = a17;
                    booleanRef3 = booleanRef2;
                }
                QLog.i("TroopSelectMemberFrag.VM", 1, "[filterGroupSortData] isConsumer:" + booleanRef.element);
                if (!booleanRef.element) {
                    o26 = this.this$0.o2();
                    o26.b(this.$memberList, this.this$0);
                }
                return Unit.INSTANCE;
            }
            booleanRef2.element = ((Boolean) obj).booleanValue();
            booleanRef = booleanRef3;
            QLog.i("TroopSelectMemberFrag.VM", 1, "[filterGroupSortData] isConsumer:" + booleanRef.element);
            if (!booleanRef.element) {
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopSelectMemberVM$filterGroupSortData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
