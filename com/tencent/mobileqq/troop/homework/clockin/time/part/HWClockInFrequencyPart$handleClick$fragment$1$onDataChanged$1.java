package com.tencent.mobileqq.troop.homework.clockin.time.part;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.time.vm.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.time.part.HWClockInFrequencyPart$handleClick$fragment$1$onDataChanged$1", f = "HWClockInFrequencyPart.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class HWClockInFrequencyPart$handleClick$fragment$1$onDataChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ List<Integer> $frequencyList;
    int label;
    final /* synthetic */ HWClockInFrequencyPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInFrequencyPart$handleClick$fragment$1$onDataChanged$1(HWClockInFrequencyPart hWClockInFrequencyPart, List<Integer> list, Continuation<? super HWClockInFrequencyPart$handleClick$fragment$1$onDataChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInFrequencyPart;
        this.$frequencyList = list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hWClockInFrequencyPart, list, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new HWClockInFrequencyPart$handleClick$fragment$1$onDataChanged$1(this.this$0, this.$frequencyList, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar;
        com.tencent.mobileqq.troop.homework.clockin.time.vm.c E9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                aVar = this.this$0.timeInfo;
                if (aVar != null) {
                    HWClockInFrequencyPart hWClockInFrequencyPart = this.this$0;
                    List<Integer> list = this.$frequencyList;
                    List<Integer> a16 = aVar.a();
                    a16.clear();
                    a16.addAll(list);
                    E9 = hWClockInFrequencyPart.E9();
                    b.C8725b c8725b = new b.C8725b(aVar);
                    this.label = 1;
                    if (E9.sendUserIntent(c8725b, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            this.this$0.J9();
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInFrequencyPart$handleClick$fragment$1$onDataChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
