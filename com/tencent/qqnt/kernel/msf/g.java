package com.tencent.qqnt.kernel.msf;

import com.tencent.mobileqq.inject.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004J&\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/kernel/msf/g;", "", "", "a", "", "uin", "cmd", "oidbCmd", "", "b", "d", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f359158a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54635);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f359158a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
        if (!bVar.isDebugVersion() && (!bVar.isGrayVersion() || Random.INSTANCE.nextInt(1000) != 520)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void c(g gVar, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        gVar.b(str, str2, str3);
    }

    public static /* synthetic */ void e(g gVar, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        gVar.d(str, str2, str3);
    }

    public final void b(@NotNull String uin, @Nullable String cmd, @Nullable String oidbCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uin, cmd, oidbCmd);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!a()) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (cmd != null) {
            hashMap.put("cmd", cmd);
        }
        if (oidbCmd != null) {
            hashMap.put("oidb_cmd", oidbCmd);
        }
        v.c(uin, "report_receive_cmd", hashMap);
    }

    public final void d(@NotNull String uin, @Nullable String cmd, @Nullable String oidbCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uin, cmd, oidbCmd);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!a()) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (cmd != null) {
            hashMap.put("cmd", cmd);
        }
        if (oidbCmd != null) {
            hashMap.put("oidb_cmd", oidbCmd);
        }
        v.c(uin, "report_send_cmd", hashMap);
    }
}
