package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u0016\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;", "", "Lcom/tencent/aio/data/msglist/a;", "a", "Lcom/tencent/aio/data/msglist/a;", "e", "()Lcom/tencent/aio/data/msglist/a;", "k", "(Lcom/tencent/aio/data/msglist/a;)V", "lastDisplayMsg", "b", "getFirstDisplayMsg", "j", "firstDisplayMsg", "c", "d", "i", "aioLastShowMsg", "g", "aioFirstShowMsg", "f", "aioFirstRecMsg", tl.h.F, "aioLastRecMsg", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a lastDisplayMsg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a firstDisplayMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a aioLastShowMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a aioFirstShowMsg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a aioFirstRecMsg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a aioLastRecMsg;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Nullable
    public final com.tencent.aio.data.msglist.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.aioFirstRecMsg;
    }

    @Nullable
    public final com.tencent.aio.data.msglist.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.aioFirstShowMsg;
    }

    @Nullable
    public final com.tencent.aio.data.msglist.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.aioLastRecMsg;
    }

    @Nullable
    public final com.tencent.aio.data.msglist.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.aioLastShowMsg;
    }

    @Nullable
    public final com.tencent.aio.data.msglist.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.lastDisplayMsg;
    }

    public final void f(@Nullable com.tencent.aio.data.msglist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
        } else {
            this.aioFirstRecMsg = aVar;
        }
    }

    public final void g(@Nullable com.tencent.aio.data.msglist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            this.aioFirstShowMsg = aVar;
        }
    }

    public final void h(@Nullable com.tencent.aio.data.msglist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            this.aioLastRecMsg = aVar;
        }
    }

    public final void i(@Nullable com.tencent.aio.data.msglist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            this.aioLastShowMsg = aVar;
        }
    }

    public final void j(@Nullable com.tencent.aio.data.msglist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.firstDisplayMsg = aVar;
        }
    }

    public final void k(@Nullable com.tencent.aio.data.msglist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.lastDisplayMsg = aVar;
        }
    }
}
