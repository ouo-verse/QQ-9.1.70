package com.tencent.mobileqq.msf.core.e0;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements e, d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f247969a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f247969a = -1L;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
        } else if (toServiceMsg != null && toServiceMsg.getServiceCmd().startsWith("SharpSvr.c2s")) {
            this.f247969a = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.e0.d
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_AV_SHARP)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = this.f247969a;
            if (j3 > 0) {
                long j16 = elapsedRealtime - j3;
                if (j16 > 0 && j16 <= 30000) {
                    fromServiceMsg.addAttribute(BaseConstants.TIME_MSF2NET_BOOT_SHARP_C2S, Long.valueOf(j3));
                    return;
                }
            }
            fromServiceMsg.addAttribute(BaseConstants.TIME_MSF2NET_BOOT_SHARP_C2S, -1);
        }
    }
}
