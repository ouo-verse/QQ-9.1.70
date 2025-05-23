package com.tencent.mobileqq.troop.homework.clockin.detail.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@"}, d2 = {"", "isTeacher", "", "authorUin", "", "height", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailUserCase$updateDetailFoldState$1", f = "HWClockInDetailUserCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInDetailUserCase$updateDetailFoldState$1 extends SuspendLambda implements Function4<Boolean, Long, Integer, Continuation<? super Boolean>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ int I$0;
    /* synthetic */ long J$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ HWClockInDetailUserCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailUserCase$updateDetailFoldState$1(HWClockInDetailUserCase hWClockInDetailUserCase, Continuation<? super HWClockInDetailUserCase$updateDetailFoldState$1> continuation) {
        super(4, continuation);
        this.this$0 = hWClockInDetailUserCase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWClockInDetailUserCase, (Object) continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Long l3, Integer num, Continuation<? super Boolean> continuation) {
        return invoke(bool.booleanValue(), l3.longValue(), num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                f16 = this.this$0.f(this.Z$0, this.J$0, this.I$0);
                return Boxing.boxBoolean(f16);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    public final Object invoke(boolean z16, long j3, int i3, @Nullable Continuation<? super Boolean> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), continuation);
        }
        HWClockInDetailUserCase$updateDetailFoldState$1 hWClockInDetailUserCase$updateDetailFoldState$1 = new HWClockInDetailUserCase$updateDetailFoldState$1(this.this$0, continuation);
        hWClockInDetailUserCase$updateDetailFoldState$1.Z$0 = z16;
        hWClockInDetailUserCase$updateDetailFoldState$1.J$0 = j3;
        hWClockInDetailUserCase$updateDetailFoldState$1.I$0 = i3;
        return hWClockInDetailUserCase$updateDetailFoldState$1.invokeSuspend(Unit.INSTANCE);
    }
}
