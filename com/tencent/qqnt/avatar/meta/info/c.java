package com.tencent.qqnt.avatar.meta.info;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/info/c;", "", "Lcom/tencent/qqnt/avatar/meta/info/e;", "b", "Lcom/tencent/qqnt/avatar/meta/info/e;", "a", "()Lcom/tencent/qqnt/avatar/meta/info/e;", "d", "(Lcom/tencent/qqnt/avatar/meta/info/e;)V", "avatarInfoBuilder", "Lcom/tencent/qqnt/avatar/meta/info/f;", "c", "Lcom/tencent/qqnt/avatar/meta/info/f;", "()Lcom/tencent/qqnt/avatar/meta/info/f;", "f", "(Lcom/tencent/qqnt/avatar/meta/info/f;)V", "groupAvatarHelper", "Lcom/tencent/qqnt/avatar/meta/info/d;", "Lcom/tencent/qqnt/avatar/meta/info/d;", "()Lcom/tencent/qqnt/avatar/meta/info/d;", "e", "(Lcom/tencent/qqnt/avatar/meta/info/d;)V", "baseInfoRequestHandler", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f352932a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static e avatarInfoBuilder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static f groupAvatarHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static d baseInfoRequestHandler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40075);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f352932a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final e a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return avatarInfoBuilder;
    }

    @Nullable
    public final d b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return baseInfoRequestHandler;
    }

    @Nullable
    public final f c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return groupAvatarHelper;
    }

    public final void d(@Nullable e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        } else {
            avatarInfoBuilder = eVar;
        }
    }

    public final void e(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar);
        } else {
            baseInfoRequestHandler = dVar;
        }
    }

    public final void f(@Nullable f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fVar);
        } else {
            groupAvatarHelper = fVar;
        }
    }
}
