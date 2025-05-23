package com.tencent.mobileqq.matchfriend.reborn.content.signal;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.api.IQQStrangerSelfSignalInfoService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tJ\u0018\u0010\u000f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/b;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/api/IQQStrangerSelfSignalInfoService;", "c", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/a;", "listener", "", "a", "f", "", "loadCacheFirst", "e", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "signalInfo", "justNowPublish", "d", "b", "<init>", "()V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f244871a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23151);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f244871a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final IQQStrangerSelfSignalInfoService c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IQQStrangerSelfSignalInfoService) peekAppRuntime.getRuntimeService(IQQStrangerSelfSignalInfoService.class, "all");
        }
        return null;
    }

    public final void a(@NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        IQQStrangerSelfSignalInfoService c16 = c();
        if (c16 == null) {
            return;
        }
        c16.addListener(listener);
    }

    @Nullable
    public final SignalPlazaSvrPB$SignalInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SignalPlazaSvrPB$SignalInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        IQQStrangerSelfSignalInfoService c16 = c();
        if (c16 == null) {
            return null;
        }
        return c16.getSelfSignalInfoCache();
    }

    public final void d(@Nullable SignalPlazaSvrPB$SignalInfo signalInfo, boolean justNowPublish) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, signalInfo, Boolean.valueOf(justNowPublish));
            return;
        }
        IQQStrangerSelfSignalInfoService c16 = c();
        if (c16 == null) {
            return;
        }
        c16.upsetSelfSignalInfo(signalInfo, justNowPublish);
    }

    public final void e(boolean loadCacheFirst) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, loadCacheFirst);
            return;
        }
        IQQStrangerSelfSignalInfoService c16 = c();
        if (c16 == null) {
            return;
        }
        c16.refreshSelfSignalInfo(loadCacheFirst);
    }

    public final void f(@NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        IQQStrangerSelfSignalInfoService c16 = c();
        if (c16 == null) {
            return;
        }
        c16.removeListener(listener);
    }
}
