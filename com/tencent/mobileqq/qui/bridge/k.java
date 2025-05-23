package com.tencent.mobileqq.qui.bridge;

import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qui/bridge/k;", "Ltd0/k;", "", "name", "", "priority", "Landroid/os/HandlerThread;", "a", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class k implements td0.k {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // td0.k
    @NotNull
    public HandlerThread a(@NotNull String name, int priority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name, priority);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread(name, priority);
        Intrinsics.checkNotNullExpressionValue(newFreeHandlerThread, "newFreeHandlerThread(name, priority)");
        return newFreeHandlerThread;
    }
}
