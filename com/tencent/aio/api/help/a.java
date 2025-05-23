package com.tencent.aio.api.help;

import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R.\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@@X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/aio/api/help/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/aio/data/AIOParam;", "<set-?>", "a", "Lcom/tencent/aio/data/AIOParam;", "()Lcom/tencent/aio/data/AIOParam;", "c", "(Lcom/tencent/aio/data/AIOParam;)V", "aioParam", "Lcom/tencent/aio/data/AIOSession;", "b", "Lcom/tencent/aio/data/AIOSession;", "()Lcom/tencent/aio/data/AIOSession;", "aioSession", "<init>", "(Lcom/tencent/aio/data/AIOSession;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOParam aioParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOSession aioSession;

    public a(@NotNull AIOSession aioSession) {
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioSession);
        } else {
            this.aioSession = aioSession;
        }
    }

    @Nullable
    public final AIOParam a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AIOParam) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.aioParam;
    }

    @NotNull
    public final AIOSession b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOSession) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.aioSession;
    }

    public final void c(@Nullable AIOParam aIOParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aIOParam);
        } else {
            this.aioParam = aIOParam;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (!(other instanceof a) || !Intrinsics.areEqual(this.aioSession, ((a) other).aioSession)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        AIOSession aIOSession = this.aioSession;
        if (aIOSession != null) {
            return aIOSession.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "HelperProviderParam(aioSession=" + this.aioSession + ")";
    }
}
