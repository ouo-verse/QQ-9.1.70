package com.tencent.mobileqq.msf.core.net.u.b;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k implements b, d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f249420c = "UdpTimeCostReportFilter";

    /* renamed from: d, reason: collision with root package name */
    private static final String f249421d = "UdpTimeCost";

    /* renamed from: e, reason: collision with root package name */
    private static final String f249422e = "UdpRetryCount";

    /* renamed from: f, reason: collision with root package name */
    private static final String f249423f = "UdpOnlySuccess";

    /* renamed from: g, reason: collision with root package name */
    private static final String f249424g = "UdpFirstSend";

    /* renamed from: h, reason: collision with root package name */
    private static volatile k f249425h;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f249426a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.quicksend.b f249427b;

    k(com.tencent.mobileqq.msf.core.quicksend.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f249426a = new ConcurrentHashMap();
            this.f249427b = bVar;
        }
    }

    public static k a(com.tencent.mobileqq.msf.core.quicksend.b bVar) {
        if (f249425h == null) {
            synchronized (k.class) {
                if (f249425h == null) {
                    f249425h = new k(bVar);
                }
            }
        }
        return f249425h;
    }

    private boolean b(ToServiceMsg toServiceMsg) {
        t a16;
        if (toServiceMsg == null) {
            return false;
        }
        com.tencent.mobileqq.msf.core.quicksend.b bVar = this.f249427b;
        boolean z16 = true;
        if (bVar != null) {
            com.tencent.mobileqq.msf.core.f0.d.a b16 = bVar.b();
            if (b16 != null && b16.r() != null && (a16 = b16.r().a(toServiceMsg.getServiceCmd())) != null) {
                z16 = a16.f250077b.contains(toServiceMsg);
            }
            this.f249427b.e(toServiceMsg);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.msf.core.net.u.b.b
    public FromServiceMsg a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FromServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if (fromServiceMsg == null) {
            return null;
        }
        if (!fromServiceMsg.isSuccess()) {
            return fromServiceMsg;
        }
        this.f249426a.put(f249423f, b(toServiceMsg) + "");
        MsfCore.sCore.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.f247752t3, fromServiceMsg.isSuccess(), 0L, 0L, this.f249426a, false, false);
        Long l3 = (Long) toServiceMsg.getAttribute(MsfConstants.ATTR_UDP_SEND_TIME);
        if (l3 != null) {
            long uptimeMillis = SystemClock.uptimeMillis() - l3.longValue();
            this.f249426a.put(f249421d, String.valueOf(uptimeMillis));
            Integer num = (Integer) toServiceMsg.getAttribute(MsfConstants.ATTR_UDP_RETRY_COUNT);
            this.f249426a.put(f249422e, String.valueOf(num));
            MsfCore.sCore.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.f247757u3, fromServiceMsg.isSuccess(), 0L, 0L, this.f249426a, false, false);
            QLog.d(f249420c, 1, "[filter] report udp cost time: ", Long.valueOf(uptimeMillis), com.tencent.mobileqq.msf.core.z.a.a(fromServiceMsg), ", retryCount: ", num, ", wait send:", Boolean.valueOf(b(toServiceMsg)));
        }
        return fromServiceMsg;
    }

    @Override // com.tencent.mobileqq.msf.core.net.u.b.d
    public ToServiceMsg a(ToServiceMsg toServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
        }
        if (toServiceMsg == null) {
            return null;
        }
        Long l3 = (Long) toServiceMsg.getAttribute(MsfConstants.ATTR_UDP_SEND_TIME);
        if (l3 == null) {
            l3 = Long.valueOf(SystemClock.uptimeMillis());
            toServiceMsg.addAttribute(MsfConstants.ATTR_UDP_SEND_TIME, l3);
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(f249420c, 2, "[filter] sendTime: ", l3, com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg), ", firstSend: ", Boolean.valueOf(z16));
        this.f249426a.put(f249424g, z16 + "");
        MsfCore.sCore.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.f247747s3, true, 0L, 0L, this.f249426a, false, false);
        return toServiceMsg;
    }
}
