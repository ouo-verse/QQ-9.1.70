package com.tencent.mobileqq.troop.homework.homework.submit.vm;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.homework.submit.media.SubmitHomeworkMediaManager;
import com.tencent.mobileqq.troop.homework.homework.submit.sso.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.homework.submit.vm.SubmitHomeWorkVM$submit$1", f = "SubmitHomeWorkVM.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class SubmitHomeWorkVM$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ d $networkHelper;
    final /* synthetic */ long $startTime;
    int label;
    final /* synthetic */ SubmitHomeWorkVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitHomeWorkVM$submit$1(d dVar, SubmitHomeWorkVM submitHomeWorkVM, long j3, Continuation<? super SubmitHomeWorkVM$submit$1> continuation) {
        super(2, continuation);
        this.$networkHelper = dVar;
        this.this$0 = submitHomeWorkVM;
        this.$startTime = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dVar, submitHomeWorkVM, Long.valueOf(j3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new SubmitHomeWorkVM$submit$1(this.$networkHelper, this.this$0, this.$startTime, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        SubmitHomeworkMediaManager S1;
        boolean z16;
        ArrayList arrayList;
        String str2;
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
                d dVar = this.$networkHelper;
                str = this.this$0.homeWorkId;
                S1 = this.this$0.S1();
                this.label = 1;
                obj = dVar.c(str, S1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Pair pair = (Pair) obj;
            int i16 = 0;
            if (((Number) pair.getFirst()).intValue() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.this$0.f2(z16);
            if (z16) {
                com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("SubmitHWSubmitHomeWorkVM", "submit success quit page");
                this.this$0.X1().postValue(Boxing.boxBoolean(true));
                this.this$0.W1().postValue(Boxing.boxBoolean(true));
            }
            com.tencent.mobileqq.troop.homework.utils.a aVar = com.tencent.mobileqq.troop.homework.utils.a.f297343a;
            int intValue = ((Number) pair.getFirst()).intValue();
            String str3 = (String) pair.getSecond();
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.$startTime;
            arrayList = this.this$0.modifyItems;
            if (arrayList != null && arrayList.size() == 0) {
                i16 = 1;
            }
            str2 = this.this$0.troopId;
            aVar.d(intValue, str3, elapsedRealtime, i16 ^ 1, str2);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((SubmitHomeWorkVM$submit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
