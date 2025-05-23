package com.tencent.mobileqq.qqlive.sail.player.state;

import com.tencent.map.geolocation.TencentLocation;
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
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.player.state.InitState", f = "InitState.kt", i = {1}, l = {35, 39, 42, 46}, m = TencentLocation.RUN_MODE, n = {"this"}, s = {"L$0"})
/* loaded from: classes17.dex */
public final class InitState$run$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitState$run$1(InitState initState, Continuation<? super InitState$run$1> continuation) {
        super(continuation);
        this.this$0 = initState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initState, (Object) continuation);
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
        return this.this$0.a(this);
    }
}
