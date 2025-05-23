package com.tencent.qqnt.kernel.utils;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/kernel/utils/i;", "Lcom/tencent/qqnt/kernel/utils/f;", "Landroid/os/Handler;", "a", "", "obj", "", "b", "", "c", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class i implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final i f359265b;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ f f359266a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54662);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f359265b = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f359266a = j.f359267a.a();
        }
    }

    @Override // com.tencent.qqnt.kernel.utils.f
    @NotNull
    public Handler a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Handler) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f359266a.a();
    }

    @Override // com.tencent.qqnt.kernel.utils.f
    public void b(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        } else {
            this.f359266a.b(obj);
        }
    }

    @Override // com.tencent.qqnt.kernel.utils.f
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f359266a.c();
    }
}
