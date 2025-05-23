package com.tencent.mobileqq.msf.core.i0.d;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends j.d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    public static final String f248568f = "WeakNetReport";

    /* renamed from: g, reason: collision with root package name */
    private static final String f248569g = "dim_msf_EvtWeakNetworkNetConnQuality";

    /* renamed from: h, reason: collision with root package name */
    private static final String f248570h = "dim_msf_EvtWeakNetworkNetChatMsgCost";

    /* renamed from: b, reason: collision with root package name */
    public a f248571b;

    /* renamed from: c, reason: collision with root package name */
    public a f248572c;

    /* renamed from: d, reason: collision with root package name */
    public a f248573d;

    /* renamed from: e, reason: collision with root package name */
    public a f248574e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f248575a;

        /* renamed from: b, reason: collision with root package name */
        public long f248576b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f248575a = 0;
                this.f248576b = 0L;
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248571b = new a();
        this.f248572c = new a();
        this.f248573d = new a();
        this.f248574e = new a();
    }

    public void a(boolean z16, com.tencent.mobileqq.msf.core.i0.c.c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
            return;
        }
        a();
        if (z16) {
            long j3 = this.f248572c.f248576b;
            long j16 = this.f248574e.f248576b;
            long j17 = aVar.f248529v - aVar.f248528u;
            a("weaknetReason", Integer.toHexString(aVar.b()));
            a("weaknetCost", String.valueOf(j17));
            a("sendTotal", String.valueOf(this.f248571b.f248575a));
            a("ssoCount", String.valueOf(this.f248572c.f248575a));
            a("ssoAvgCost", String.valueOf(j3));
            a("msgSendTotal", String.valueOf(this.f248573d.f248575a));
            a("msgCount", String.valueOf(this.f248574e.f248575a));
            a("msgAvgCost", String.valueOf(j16));
            a("screen", String.valueOf(aVar.f248532y));
            a(BaseConstants.KEY_CONN_COST, String.valueOf(aVar.f248512e));
            a(BaseConstants.KEY_PING_COST, String.valueOf(aVar.f248515h - aVar.f248514g));
            a("Trtt", String.valueOf(aVar.f248522o));
            a("RTTm", String.valueOf(aVar.f248523p));
            String str = aVar.f248526s;
            if (str == null) {
                str = "null";
            }
            a(TPDownloadProxyEnum.USER_SSID, str);
            String str2 = aVar.f248530w;
            a("networks", str2 != null ? str2 : "null");
            a("isCrossOper", String.valueOf(d.a.f392523f));
            a(BaseConstants.KEY_WEAK_NET_STRATEGY, String.valueOf(com.tencent.mobileqq.msf.core.i0.a.v().t()));
            a("dim_msf_EvtWeakNetworkNetConnQuality", aVar.b() > 0, j17, 0L);
            a("EvtWeakNetwork", aVar.b() > 0, j17, 0L);
            if (QLog.isColorLevel()) {
                QLog.d(f248568f, 2, "report EventCode=dim_msf_EvtWeakNetworkNetConnQuality reason=" + Integer.toHexString(aVar.b()) + " weaknetCost=" + (aVar.f248529v - aVar.f248528u) + " screen=" + aVar.f248532y + " connCost=" + aVar.f248512e + " pingCost=" + (aVar.f248515h - aVar.f248514g) + " ssoTotal=" + this.f248571b.f248575a + " ssoSucc=" + this.f248572c.f248575a + "/" + this.f248571b.f248575a + " msgSucc=" + this.f248574e.f248575a + "/" + this.f248573d.f248575a + " ssoAvgCost=" + this.f248572c.f248576b + " msgAvgCost=" + this.f248574e.f248576b);
            }
        }
        b();
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f248572c.a();
        this.f248574e.a();
        this.f248571b.a();
        this.f248573d.a();
    }

    public void a(FromServiceMsg fromServiceMsg, com.tencent.mobileqq.msf.core.i0.c.c.a aVar, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fromServiceMsg, aVar, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            boolean booleanValue = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, Boolean.FALSE)).booleanValue();
            HashMap hashMap = new HashMap();
            hashMap.put("weaknetReason", Integer.toHexString(aVar.b()));
            hashMap.put("quickSend", String.valueOf(z16));
            hashMap.put("quickSuccTime", String.valueOf(j3));
            hashMap.put("sentByXG", String.valueOf(booleanValue));
            if (!z16) {
                hashMap.put("quickSendByXg", "0");
            } else if (booleanValue) {
                hashMap.put("quickSendByXg", "1");
            } else {
                hashMap.put("quickSendByXg", "2");
            }
            if (MsfCore.sCore.getStatReporter() != null) {
                MsfCore.sCore.getStatReporter().a("dim_msf_EvtWeakNetworkNetChatMsgCost", aVar.b() > 0, j3, 0L, (Map<String, String>) hashMap, false, false);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f248568f, 2, "report EventCode=dim_msf_EvtWeakNetworkNetChatMsgCost reason=" + Integer.toHexString(aVar.b()) + " quickSend=" + z16 + " quickSuccTime=" + j3 + " sentByXG=" + booleanValue);
            }
        }
    }
}
