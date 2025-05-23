package com.tencent.mobileqq.qqnt.videoplay.api.component;

import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqnt.videoplay.api.component.TimeAndMutePanel$startUpdatingTime$1", f = "TimeAndMutePanel.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class TimeAndMutePanel$startUpdatingTime$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ TimeAndMutePanel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeAndMutePanel$startUpdatingTime$1(TimeAndMutePanel timeAndMutePanel, Continuation<? super TimeAndMutePanel$startUpdatingTime$1> continuation) {
        super(2, continuation);
        this.this$0 = timeAndMutePanel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) timeAndMutePanel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TimeAndMutePanel$startUpdatingTime$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0063 -> B:12:0x0066). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        TimeAndMutePanel timeAndMutePanel;
        TimeAndMutePanel$startUpdatingTime$1 timeAndMutePanel$startUpdatingTime$1;
        int i3;
        int i16;
        boolean z16;
        TextView textView;
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i17 = this.label;
            if (i17 != 0) {
                if (i17 == 1) {
                    i16 = this.I$1;
                    i3 = this.I$0;
                    timeAndMutePanel = (TimeAndMutePanel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    timeAndMutePanel$startUpdatingTime$1 = this;
                    i16++;
                    if (i16 < i3) {
                        z16 = timeAndMutePanel.isProgressCancelled;
                        if (!z16) {
                            textView = timeAndMutePanel.videoTimeLeft;
                            f16 = timeAndMutePanel.f();
                            textView.setText(f16);
                            timeAndMutePanel$startUpdatingTime$1.L$0 = timeAndMutePanel;
                            timeAndMutePanel$startUpdatingTime$1.I$0 = i3;
                            timeAndMutePanel$startUpdatingTime$1.I$1 = i16;
                            timeAndMutePanel$startUpdatingTime$1.label = 1;
                            if (DelayKt.delay(500L, timeAndMutePanel$startUpdatingTime$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i16++;
                            if (i16 < i3) {
                                return Unit.INSTANCE;
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                timeAndMutePanel = this.this$0;
                timeAndMutePanel$startUpdatingTime$1 = this;
                i3 = Integer.MAX_VALUE;
                i16 = 0;
                if (i16 < i3) {
                }
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TimeAndMutePanel$startUpdatingTime$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
