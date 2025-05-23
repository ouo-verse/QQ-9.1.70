package com.tencent.mvi.api.ability;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00028\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00048\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mvi/api/ability/e;", "", "Lcom/tencent/mvi/api/ability/d;", "cmd", "Landroid/os/Bundle;", "result", "", "a", "(Lcom/tencent/mvi/api/ability/d;Landroid/os/Bundle;)V", "", "toString", "<set-?>", "Lcom/tencent/mvi/api/ability/d;", "getCmd", "()Lcom/tencent/mvi/api/ability/d;", "b", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private d cmd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Bundle result;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public final void a(@NotNull d cmd, @NotNull Bundle result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cmd, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(result, "result");
        this.cmd = cmd;
        this.result = result;
    }

    @NotNull
    public final Bundle b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Bundle bundle = this.result;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        return bundle;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cmd ");
        d dVar = this.cmd;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cmd");
        }
        sb5.append(dVar);
        sb5.append(" result ");
        Bundle bundle = this.result;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        sb5.append(bundle);
        return sb5.toString();
    }
}
