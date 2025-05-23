package com.tencent.mobileqq.qcoroutine.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/b;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "", "permanent", "Lcom/tencent/mobileqq/qcoroutine/api/DispatcherType;", "dispatcherType", "<init>", "(ZLcom/tencent/mobileqq/qcoroutine/api/DispatcherType;)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public class b extends i {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(boolean z16, @NotNull DispatcherType dispatcherType) {
        super(1, z16, dispatcherType, null);
        Intrinsics.checkNotNullParameter(dispatcherType, "dispatcherType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), dispatcherType);
        }
    }
}
