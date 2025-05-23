package com.tencent.mobileqq.pendant.downloader;

import com.tencent.cachedrawable.dynamicdrawable.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/pendant/downloader/b;", "Lcom/tencent/cachedrawable/dynamicdrawable/c;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/download/c;", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f257506a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24720);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f257506a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.c
    @NotNull
    public com.tencent.cachedrawable.dynamicdrawable.business.download.c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.cachedrawable.dynamicdrawable.business.download.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.f257503a;
    }
}
