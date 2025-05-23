package com.tencent.mobileqq.activity.home.chats.avatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
final class AvatarRefreshHelper$lastRunnable$2 extends Lambda implements Function0<Runnable> {
    static IPatchRedirector $redirector_;
    public static final AvatarRefreshHelper$lastRunnable$2 INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50669);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new AvatarRefreshHelper$lastRunnable$2();
        }
    }

    AvatarRefreshHelper$lastRunnable$2() {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        AvatarRefreshHelper.f182873a.d();
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.avatar.a
            @Override // java.lang.Runnable
            public final void run() {
                AvatarRefreshHelper$lastRunnable$2.c();
            }
        } : (Runnable) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
