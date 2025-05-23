package com.tencent.mobileqq.app.message.cleanup;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000f8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/i;", "", "", "d", "()V", "c", "", "isOptimizeStorageUI", "", "e", "(Z)J", "b", "()J", "Ljava/lang/Object;", "LOCK", "Lcom/tencent/mobileqq/app/message/cleanup/CleanUpThoroughManager;", "Lcom/tencent/mobileqq/app/message/cleanup/CleanUpThoroughManager;", "a", "()Lcom/tencent/mobileqq/app/message/cleanup/CleanUpThoroughManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f195956a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object LOCK;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile CleanUpThoroughManager instance;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18812);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f195956a = new i();
            LOCK = new Object();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final CleanUpThoroughManager a() {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new CleanUpThoroughManager();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return instance;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        CleanUpThoroughManager a16 = a();
        if (a16 != null) {
            return a16.r();
        }
        return 0L;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        CleanUpThoroughManager a16 = a();
        if (a16 != null) {
            a16.t();
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (LOCK) {
            QLog.d("CleanupHelper", 1, "release CleanUpThoroughManager instance");
            instance = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final long e(boolean isOptimizeStorageUI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, isOptimizeStorageUI)).longValue();
        }
        CleanUpThoroughManager a16 = a();
        if (a16 != null) {
            return a16.y(isOptimizeStorageUI);
        }
        return 0L;
    }
}
