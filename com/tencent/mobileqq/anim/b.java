package com.tencent.mobileqq.anim;

import com.tencent.mobileqq.app.anim.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/anim/b;", "Lcom/tencent/mobileqq/anim/a;", "Lcom/tencent/mobileqq/app/anim/a$a;", "b", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.anim.a, com.tencent.mobileqq.app.anim.a
    @NotNull
    public a.C7373a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.C7373a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a.C7373a(0, 0);
    }
}
