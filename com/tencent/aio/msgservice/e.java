package com.tencent.aio.msgservice;

import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\f\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aio/msgservice/e;", "Lcom/tencent/aio/msgservice/i;", "Lcom/tencent/aio/data/AIOSession;", "a", "Lcom/tencent/aio/data/AIOSession;", "()Lcom/tencent/aio/data/AIOSession;", "aioSession", "", "b", "Ljava/lang/Long;", "()Ljava/lang/Long;", "beginSeq", "c", "endSeq", "<init>", "(Lcom/tencent/aio/data/AIOSession;Ljava/lang/Long;Ljava/lang/Long;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class e extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOSession aioSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Long beginSeq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Long endSeq;

    public e(@NotNull AIOSession aioSession, @Nullable Long l3, @Nullable Long l16) {
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, aioSession, l3, l16);
            return;
        }
        this.aioSession = aioSession;
        this.beginSeq = l3;
        this.endSeq = l16;
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
    public final Long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Long) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.beginSeq;
    }

    @Nullable
    public final Long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Long) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.endSeq;
    }
}
