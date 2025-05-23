package com.tencent.mobileqq.troop.flame.surprise;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/surprise/a;", "", "", "b", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f296149a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36606);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f296149a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            com.tencent.mobileqq.troop.config.a.x(com.tencent.mobileqq.troop.config.a.f294689a, "surprise_display_date_cache_key", NetConnInfoCenter.getServerTimeMillis(), false, 4, null);
        }
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        long l3 = com.tencent.mobileqq.troop.config.a.l(com.tencent.mobileqq.troop.config.a.f294689a, "surprise_display_date_cache_key", 0L, false, 4, null);
        String format = DateFormat.getDateInstance().format(Long.valueOf(l3));
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        String format2 = DateFormat.getDateInstance().format(Long.valueOf(serverTimeMillis));
        QLog.i("TroopFlameSurpriseFreLimit", 1, "[isOverSurpriseDateLimit] lastDisplayDate = " + format + " curDate = " + format2);
        if (serverTimeMillis > l3 && !Intrinsics.areEqual(format2, format)) {
            return true;
        }
        return false;
    }
}
