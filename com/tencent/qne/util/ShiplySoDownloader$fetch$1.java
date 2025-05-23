package com.tencent.qne.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.qne.util.ShiplySoDownloader", f = "ShiplySoDownloader.kt", i = {0, 1, 1, 1, 1}, l = {27, 189}, m = "fetch", n = {"this", "this", "downloadResult", "localPath", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes22.dex */
public final class ShiplySoDownloader$fetch$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShiplySoDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShiplySoDownloader$fetch$1(ShiplySoDownloader shiplySoDownloader, Continuation<? super ShiplySoDownloader$fetch$1> continuation) {
        super(continuation);
        this.this$0 = shiplySoDownloader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) shiplySoDownloader, (Object) continuation);
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
        return this.this$0.c(false, this);
    }
}
