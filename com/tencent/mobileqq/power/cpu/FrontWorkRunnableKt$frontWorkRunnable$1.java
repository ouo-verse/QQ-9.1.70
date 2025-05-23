package com.tencent.mobileqq.power.cpu;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.power.cpu.FrontWorkRunnableKt", f = "FrontWorkRunnable.kt", i = {0, 0, 0, 0, 0, 0}, l = {34}, m = "frontWorkRunnable", n = {"level", "cpuData", "procManager", "count", "repeatTimes", "intervals"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "J$0"})
/* loaded from: classes16.dex */
public final class FrontWorkRunnableKt$frontWorkRunnable$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrontWorkRunnableKt$frontWorkRunnable$1(Continuation<? super FrontWorkRunnableKt$frontWorkRunnable$1> continuation) {
        super(continuation);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FrontWorkRunnableKt.a(0.0d, this);
    }
}
