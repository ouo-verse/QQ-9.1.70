package com.tencent.aio.msgservice;

import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/aio/msgservice/b;", "Lcom/tencent/aio/msgservice/i;", "Lcom/tencent/aio/data/AIOSession;", "a", "Lcom/tencent/aio/data/AIOSession;", "()Lcom/tencent/aio/data/AIOSession;", "aioSession", "Lcom/tencent/aio/data/msglist/a;", "b", "Lcom/tencent/aio/data/msglist/a;", "()Lcom/tencent/aio/data/msglist/a;", "bottomLastMsg", "", "c", "I", "()I", "count", "<init>", "(Lcom/tencent/aio/data/AIOSession;Lcom/tencent/aio/data/msglist/a;I)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOSession aioSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.aio.data.msglist.a bottomLastMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int count;

    public b(@NotNull AIOSession aioSession, @Nullable com.tencent.aio.data.msglist.a aVar, int i3) {
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, aioSession, aVar, Integer.valueOf(i3));
            return;
        }
        this.aioSession = aioSession;
        this.bottomLastMsg = aVar;
        this.count = i3;
    }

    @NotNull
    public final AIOSession a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AIOSession) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.aioSession;
    }

    @Nullable
    public final com.tencent.aio.data.msglist.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bottomLastMsg;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.count;
    }
}
