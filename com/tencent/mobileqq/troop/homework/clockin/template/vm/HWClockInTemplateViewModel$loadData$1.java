package com.tencent.mobileqq.troop.homework.clockin.template.vm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.template.model.c;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/template/model/c;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.template.vm.HWClockInTemplateViewModel$loadData$1", f = "HWClockInTemplateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInTemplateViewModel$loadData$1 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $loadMore;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HWClockInTemplateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInTemplateViewModel$loadData$1(HWClockInTemplateViewModel hWClockInTemplateViewModel, boolean z16, Continuation<? super HWClockInTemplateViewModel$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInTemplateViewModel;
        this.$loadMore = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hWClockInTemplateViewModel, Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInTemplateViewModel$loadData$1 hWClockInTemplateViewModel$loadData$1 = new HWClockInTemplateViewModel$loadData$1(this.this$0, this.$loadMore, continuation);
        hWClockInTemplateViewModel$loadData$1.L$0 = obj;
        return hWClockInTemplateViewModel$loadData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull c cVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInTemplateViewModel$loadData$1) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                c cVar = (c) this.L$0;
                if (QLog.isDebugVersion()) {
                    QLog.d("HW.ClockIn.TEMPLATE.HWClockInTemplateViewModel", 4, "load data on each:" + cVar);
                }
                if (cVar.e()) {
                    arrayList = this.this$0.templateList;
                    arrayList.addAll(cVar.c());
                    this.this$0.S1(cVar.d());
                } else if (!this.$loadMore) {
                    this.this$0.T1();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
