package com.tencent.mobileqq.msf.core.e0;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.x.o;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h implements e, d {
    static IPatchRedirector $redirector_ = null;
    public static final String A = "v4v6";
    public static final String B = "none";
    public static final String C = "mobileqq_msf_sso_quality_send";
    public static final String D = "mobileqq_msf_sso_quality_recv";
    public static final String E = "key_is_main";
    public static final String F = "val_main";
    public static final String G = "val_sub";
    public static final String H = "cmd";
    public static final String I = "key_sample_by";
    public static final int J = 1;
    public static final int K = 2;
    public static final int L = 3;

    /* renamed from: e, reason: collision with root package name */
    private static final String f247971e = "SendQueuePerformanceReporter";

    /* renamed from: f, reason: collision with root package name */
    public static final String f247972f = "key_udp_switch";

    /* renamed from: g, reason: collision with root package name */
    public static final String f247973g = "key_sub_conn_switch";

    /* renamed from: h, reason: collision with root package name */
    public static final String f247974h = "1";

    /* renamed from: i, reason: collision with root package name */
    public static final String f247975i = "2";

    /* renamed from: j, reason: collision with root package name */
    public static final String f247976j = "key_queue_time";

    /* renamed from: k, reason: collision with root package name */
    public static final String f247977k = "key_is_nodelay";

    /* renamed from: l, reason: collision with root package name */
    public static final String f247978l = "key_is_security_sign";

    /* renamed from: m, reason: collision with root package name */
    public static final String f247979m = "key_security_sign_cost_time";

    /* renamed from: n, reason: collision with root package name */
    public static final String f247980n = "key_security_sign_init_time";

    /* renamed from: o, reason: collision with root package name */
    public static final String f247981o = "key_sso_version";

    /* renamed from: p, reason: collision with root package name */
    public static final String f247982p = "key_is_weak_msg";

    /* renamed from: q, reason: collision with root package name */
    public static final String f247983q = "key_is_weak_env";

    /* renamed from: r, reason: collision with root package name */
    public static final String f247984r = "key_is_nt_version";

    /* renamed from: s, reason: collision with root package name */
    public static final String f247985s = "key_wup_buff_len";

    /* renamed from: t, reason: collision with root package name */
    public static final String f247986t = "key_uid";

    /* renamed from: u, reason: collision with root package name */
    public static final String f247987u = "key_appid";

    /* renamed from: v, reason: collision with root package name */
    public static final String f247988v = "1";

    /* renamed from: w, reason: collision with root package name */
    public static final String f247989w = "2";

    /* renamed from: x, reason: collision with root package name */
    public static final String f247990x = "key_ip_family";

    /* renamed from: y, reason: collision with root package name */
    public static final String f247991y = "IPv4";

    /* renamed from: z, reason: collision with root package name */
    public static final String f247992z = "IPv6";

    /* renamed from: a, reason: collision with root package name */
    private final boolean f247993a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f247994b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f247995c;

    /* renamed from: d, reason: collision with root package name */
    private final Set<String> f247996d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends HashSet<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            } else {
                add(BaseConstants.CMD_MSG_PBSENDMSG);
                add(BaseConstants.CMD_STATUS_SVC_MSF_HELLO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final h f247998a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23546);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f247998a = new h(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ h(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    private static String a(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? "none" : "v4v6" : "IPv6" : "IPv4";
    }

    private boolean d(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return true;
        }
        if (e(toServiceMsg)) {
            return false;
        }
        boolean z16 = this.f247993a;
        if (!z16 && !this.f247995c) {
            return true;
        }
        if (z16) {
            return false;
        }
        return !this.f247996d.contains(toServiceMsg.getServiceCmd());
    }

    private boolean e(ToServiceMsg toServiceMsg) {
        boolean z16;
        Object attribute = toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_MAIN);
        if (attribute instanceof Boolean) {
            z16 = ((Boolean) attribute).booleanValue();
        } else {
            z16 = true;
        }
        if (this.f247994b && !z16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(32:18|(1:20)(1:77)|21|(1:(1:75)(1:76))(1:25)|26|27|28|(25:32|33|34|(1:36)(1:69)|37|(1:39)|40|41|42|43|44|45|(1:47)|48|49|(2:51|52)|53|54|(2:56|57)|58|(1:60)(1:66)|61|62|63|64)|71|34|(0)(0)|37|(0)|40|41|42|43|44|45|(0)|48|49|(0)|53|54|(0)|58|(0)(0)|61|62|63|64) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0160, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0161, code lost:
    
        com.tencent.qphone.base.util.QLog.e("SendQueuePerformanceReporter." + r3, 1, "get sign time error ", r15);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0150 A[Catch: Exception -> 0x0160, TRY_LEAVE, TryCatch #0 {Exception -> 0x0160, blocks: (B:42:0x0103, B:44:0x0110, B:48:0x0121, B:52:0x012f, B:53:0x0136, B:57:0x0141, B:58:0x0148, B:62:0x0158, B:66:0x0150), top: B:41:0x0103 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    @Override // com.tencent.mobileqq.msf.core.e0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(ToServiceMsg toServiceMsg) {
        String str;
        int i3;
        long j3;
        Object obj;
        boolean booleanValue;
        Long l3;
        Long l16;
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (!d(toServiceMsg) && toServiceMsg.isNeedCallback()) {
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (TextUtils.isEmpty(serviceCmd)) {
                return;
            }
            Object attribute = toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_MAIN);
            if (attribute instanceof Boolean) {
                boolean booleanValue2 = ((Boolean) attribute).booleanValue();
                HashMap hashMap = new HashMap();
                hashMap.put("cmd", serviceCmd);
                if (booleanValue2) {
                    str = F;
                } else {
                    str = G;
                }
                hashMap.put(E, str);
                boolean z16 = this.f247993a;
                if (z16 && this.f247995c) {
                    i3 = 3;
                } else if (z16) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                hashMap.put(I, String.valueOf(i3));
                a(hashMap);
                HashMap<String, Object> attributes = toServiceMsg.getAttributes();
                try {
                } catch (Throwable th5) {
                    QLog.e(f247971e, 1, "[onMessageSent] error: ", th5);
                }
                if (attributes.containsKey(BaseConstants.TIMESTAMP_MSF2NET) && attributes.containsKey(BaseConstants.TIMESTAMP_APP2MSF)) {
                    j3 = ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_APP2MSF)).longValue();
                    hashMap.put(f247976j, j3 + "");
                    String str2 = "1";
                    if (!o.x().e().contains(serviceCmd)) {
                        obj = "1";
                    } else {
                        obj = "2";
                    }
                    hashMap.put(f247977k, obj);
                    booleanValue = ((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_IS_SECURITY_SIGN, Boolean.FALSE)).booleanValue();
                    if (toServiceMsg.getSSOVersion() != 0) {
                        hashMap.put(f247981o, String.valueOf(toServiceMsg.getSSOVersion()));
                    }
                    l3 = (Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_SIGN_COST_TIME, -1L);
                    l16 = (Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_INIT_COST_TIME, -1L);
                    if (!booleanValue) {
                        str2 = "2";
                    }
                    hashMap.put(f247978l, str2);
                    if (l3.longValue() != -1) {
                        hashMap.put(f247979m, String.valueOf(l3));
                    }
                    if (l16.longValue() != -1) {
                        hashMap.put(f247980n, String.valueOf(l16));
                    }
                    if (toServiceMsg.getWupBuffer() != null) {
                        length = 0;
                    } else {
                        length = toServiceMsg.getWupBuffer().length;
                    }
                    hashMap.put(f247985s, String.valueOf(length));
                    MsfCore.sCore.statReporter.a(C, true, 0L, 0L, (Map<String, String>) hashMap, true, false);
                }
                j3 = -1;
                hashMap.put(f247976j, j3 + "");
                String str22 = "1";
                if (!o.x().e().contains(serviceCmd)) {
                }
                hashMap.put(f247977k, obj);
                booleanValue = ((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_IS_SECURITY_SIGN, Boolean.FALSE)).booleanValue();
                if (toServiceMsg.getSSOVersion() != 0) {
                }
                l3 = (Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_SIGN_COST_TIME, -1L);
                l16 = (Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_INIT_COST_TIME, -1L);
                if (!booleanValue) {
                }
                hashMap.put(f247978l, str22);
                if (l3.longValue() != -1) {
                }
                if (l16.longValue() != -1) {
                }
                if (toServiceMsg.getWupBuffer() != null) {
                }
                hashMap.put(f247985s, String.valueOf(length));
                MsfCore.sCore.statReporter.a(C, true, 0L, 0L, (Map<String, String>) hashMap, true, false);
            }
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f247996d = new a();
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()) {
            this.f247993a = com.tencent.mobileqq.msf.core.net.utils.e.a(0, com.tencent.mobileqq.msf.core.x.d.v()) < 1;
            this.f247995c = com.tencent.mobileqq.msf.core.net.utils.e.a(0, com.tencent.mobileqq.msf.core.x.d.u()) < 1;
            this.f247994b = true;
        } else if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            this.f247993a = com.tencent.mobileqq.msf.core.net.utils.e.a(0, com.tencent.mobileqq.msf.core.x.d.C0()) < 1;
            this.f247995c = com.tencent.mobileqq.msf.core.net.utils.e.a(0, com.tencent.mobileqq.msf.core.x.d.w()) < 1;
            this.f247994b = com.tencent.mobileqq.msf.core.net.utils.e.a(0, com.tencent.mobileqq.msf.core.x.d.T0()) < 1;
        } else {
            this.f247993a = true;
            this.f247995c = true;
            this.f247994b = true;
        }
        QLog.d(f247971e, 1, "[initSampleRate] rateNormal: ", Boolean.valueOf(this.f247993a), ", rateImport: ", Boolean.valueOf(this.f247995c), ", grayRate: ", Integer.valueOf(com.tencent.mobileqq.msf.core.x.d.v()), ", releaseRate: ", Integer.valueOf(com.tencent.mobileqq.msf.core.x.d.C0()), ", impRate: ", Integer.valueOf(com.tencent.mobileqq.msf.core.x.d.w()), ", subConn: ", Integer.valueOf(com.tencent.mobileqq.msf.core.x.d.T0()));
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
    }

    public static h a() {
        return b.f247998a;
    }

    public static void a(Map<String, String> map) {
        map.put(f247972f, com.tencent.mobileqq.msf.core.x.d.d1() ? "1" : "2");
        map.put(f247983q, MsfService.getCore().isWeakNet() ? "1" : "2");
        map.put("key_appid", String.valueOf(BaseApplication.getContext().getAppId()));
        try {
            String d16 = MsfCore.sCore.getAccountCenter().g().d(MsfCore.sCore.getMainAccount());
            if (TextUtils.isEmpty(d16)) {
                d16 = "none";
            }
            map.put("key_uid", d16);
        } catch (Exception e16) {
            QLog.e(f247971e, 1, "get uid error ", e16);
        }
        map.put(f247973g, com.tencent.mobileqq.msf.core.x.d.c1() && MsfService.core.isSubSenderEnable() ? "1" : "2");
        map.put("key_ip_family", a(MsfService.core.getConnectedIPFamily()));
    }

    @Override // com.tencent.mobileqq.msf.core.e0.d
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (!d(toServiceMsg) && toServiceMsg.isNeedCallback()) {
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (TextUtils.isEmpty(serviceCmd)) {
                return;
            }
            Object attribute = toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SEND_BY_MAIN);
            if (attribute instanceof Boolean) {
                boolean booleanValue = ((Boolean) attribute).booleanValue();
                HashMap hashMap = new HashMap();
                hashMap.put("cmd", serviceCmd);
                hashMap.put(E, booleanValue ? F : G);
                boolean z16 = this.f247993a;
                hashMap.put(I, String.valueOf((z16 && this.f247995c) ? 3 : z16 ? 1 : 2));
                a(hashMap);
                Boolean bool = Boolean.FALSE;
                hashMap.put(f247982p, ((Boolean) toServiceMsg.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249864v, bool)).booleanValue() ? "1" : "2");
                hashMap.put(f247978l, ((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_IS_SECURITY_SIGN, bool)).booleanValue() ? "1" : "2");
                if (fromServiceMsg != null) {
                    HashMap<String, Object> attributes = fromServiceMsg.getAttributes();
                    long j3 = -1;
                    try {
                        if (attributes.containsKey(BaseConstants.TIMESTAMP_NET2MSF) && attributes.containsKey(BaseConstants.TIMESTAMP_MSF2NET)) {
                            j3 = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
                        }
                        hashMap.put(f247985s, String.valueOf(fromServiceMsg.getWupBuffer() == null ? 0 : fromServiceMsg.getWupBuffer().length));
                    } catch (Throwable th5) {
                        QLog.e(f247971e, 1, "[onMessageReceive] error: ", th5);
                    }
                    long j16 = j3;
                    hashMap.put(BaseConstants.KEY_MSF_RET_CODE, String.valueOf(fromServiceMsg.getBusinessFailCode()));
                    if (fromServiceMsg.getAttributes().containsKey(BaseConstants.KEY_SSO_RET_CODE) && (fromServiceMsg.getAttribute(BaseConstants.KEY_SSO_RET_CODE) instanceof String)) {
                        hashMap.put(BaseConstants.KEY_SSO_RET_CODE, (String) fromServiceMsg.getAttribute(BaseConstants.KEY_SSO_RET_CODE));
                    }
                    MsfCore.sCore.statReporter.a(D, fromServiceMsg.getBusinessFailCode() == 1000, j16, 0L, (Map<String, String>) hashMap, true, false);
                }
            }
        }
    }
}
