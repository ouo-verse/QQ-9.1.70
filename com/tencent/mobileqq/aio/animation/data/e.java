package com.tencent.mobileqq.aio.animation.data;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.aio.animation.data.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/e;", "Lcom/tencent/mobileqq/aio/animation/data/d;", "", "c", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "b", "", "type", "a", "Lcom/tencent/aio/data/AIOSession;", "Lcom/tencent/aio/data/AIOSession;", SessionDbHelper.SESSION_ID, "Z", "isGuildSession", "<init>", "(Lcom/tencent/aio/data/AIOSession;)V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOSession session;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isGuildSession;

    public e(@NotNull AIOSession session) {
        boolean z16;
        Intrinsics.checkNotNullParameter(session, "session");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) session);
            return;
        }
        this.session = session;
        if (session.c().f().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isGuildSession = !z16;
    }

    @Override // com.tencent.mobileqq.aio.animation.data.d
    public boolean a(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, type)).booleanValue();
        }
        if (this.isGuildSession) {
            if (type == 10) {
                return true;
            }
            return false;
        }
        return d.a.a(this, type);
    }

    @Override // com.tencent.mobileqq.aio.animation.data.d
    @NotNull
    public Contact b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Contact) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        AIOContact c16 = this.session.c();
        return new Contact(c16.e(), c16.j(), "");
    }

    @Override // com.tencent.mobileqq.aio.animation.data.d
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.session.c().e() == 2) {
            return true;
        }
        return false;
    }
}
