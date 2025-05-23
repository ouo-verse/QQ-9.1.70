package com.tencent.mobileqq.aio.input.draft;

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
@DebugMetadata(c = "com.tencent.mobileqq.aio.input.draft.InputDraftVMDelegate", f = "InputDraftVMDelegate.kt", i = {0, 0, 0, 0}, l = {214}, m = "mergeOpAndUpdateUI", n = {"this", "content", "offset", "insertIndex"}, s = {"L$0", "L$1", "I$0", "I$1"})
/* loaded from: classes10.dex */
public final class InputDraftVMDelegate$mergeOpAndUpdateUI$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InputDraftVMDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputDraftVMDelegate$mergeOpAndUpdateUI$1(InputDraftVMDelegate inputDraftVMDelegate, Continuation<? super InputDraftVMDelegate$mergeOpAndUpdateUI$1> continuation) {
        super(continuation);
        this.this$0 = inputDraftVMDelegate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputDraftVMDelegate, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        o16 = this.this$0.o(null, null, this);
        return o16;
    }
}
