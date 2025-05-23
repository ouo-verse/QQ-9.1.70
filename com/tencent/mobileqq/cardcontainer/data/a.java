package com.tencent.mobileqq.cardcontainer.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H&J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/data/a;", "", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "c", "other", "", "b", "a", "", "d", "<init>", "()V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract boolean a(@NotNull a other);

    public abstract boolean b(@NotNull a other);

    @NotNull
    public abstract CardType c();

    public abstract long d();
}
