package com.tencent.upgrade.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upgrade.bean.UpgradeStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/upgrade/core/c;", "", "", "c", "a", "Lcom/tencent/upgrade/bean/UpgradeStrategy;", "cachedStrategy", "", "b", "Lcom/tencent/upgrade/storage/b;", "", "Lcom/tencent/upgrade/storage/b;", "noDisturbStartTS", "<init>", "()V", "upgrade_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.upgrade.storage.b<Long> noDisturbStartTS;

    /* renamed from: b, reason: collision with root package name */
    public static final c f383819b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11036);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f383819b = new c();
        j l3 = j.l();
        Intrinsics.checkExpressionValueIsNotNull(l3, "UpgradeManager.getInstance()");
        noDisturbStartTS = new com.tencent.upgrade.storage.b<>("no_disturb_start_time_stamp", 0L, l3.n());
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            com.tencent.upgrade.util.d.a("NoDisturbHelper", "clearNoDisturbStartTimeStamp");
            noDisturbStartTS.b(null);
        }
    }

    public final boolean b(@Nullable UpgradeStrategy cachedStrategy) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cachedStrategy)).booleanValue();
        }
        Long noDisturbStartTimeStamp = noDisturbStartTS.a();
        boolean z16 = false;
        if (noDisturbStartTimeStamp.longValue() <= 0) {
            com.tencent.upgrade.util.d.a("NoDisturbHelper", "isInNoDisturbPeriod return false for noDisturbStartTS is zero");
            return false;
        }
        if (cachedStrategy != null && cachedStrategy.getUndisturbedDuration() > 0) {
            j3 = cachedStrategy.getUndisturbedDuration() * 1000;
        } else {
            j3 = 259200000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkExpressionValueIsNotNull(noDisturbStartTimeStamp, "noDisturbStartTimeStamp");
        if (currentTimeMillis - noDisturbStartTimeStamp.longValue() < j3) {
            z16 = true;
        }
        com.tencent.upgrade.util.d.a("NoDisturbHelper", "isInNoDisturbPeriod result = " + z16);
        return z16;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        com.tencent.upgrade.storage.b<Long> bVar = noDisturbStartTS;
        if (bVar.a().longValue() > 0) {
            com.tencent.upgrade.util.d.a("NoDisturbHelper", "recordNoDisturbStartTimeStamp return for already set noDisturbStartTS");
        } else {
            com.tencent.upgrade.util.d.a("NoDisturbHelper", "recordNoDisturbStartTimeStamp");
            bVar.b(Long.valueOf(System.currentTimeMillis()));
        }
    }
}
