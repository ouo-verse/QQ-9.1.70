package com.tencent.mobileqq.msf.service;

import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: j, reason: collision with root package name */
    public static final String f250889j = "MSF.BeforeInfoSyncControl";

    /* renamed from: k, reason: collision with root package name */
    private static final String f250890k = "mobileqq_msf_cmd_before_infosync";

    /* renamed from: l, reason: collision with root package name */
    private static final String f250891l = "cmd";

    /* renamed from: m, reason: collision with root package name */
    private static final String f250892m = "msfCmd";

    /* renamed from: n, reason: collision with root package name */
    private static final String f250893n = "seq";

    /* renamed from: o, reason: collision with root package name */
    private static final String f250894o = "time_interval";

    /* renamed from: p, reason: collision with root package name */
    private static final String f250895p = "nt_flag";

    /* renamed from: q, reason: collision with root package name */
    private static final String f250896q = "key_uid_for_delay_handle";

    /* renamed from: a, reason: collision with root package name */
    private int f250897a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f250898b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedBlockingDeque<ToServiceMsg> f250899c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, b> f250900d;

    /* renamed from: e, reason: collision with root package name */
    private final HashSet<String> f250901e;

    /* renamed from: f, reason: collision with root package name */
    private int f250902f;

    /* renamed from: g, reason: collision with root package name */
    private long f250903g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f250904h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f250905i;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                f.this.a();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f250907a;

        /* renamed from: b, reason: collision with root package name */
        public String f250908b;

        /* renamed from: c, reason: collision with root package name */
        public int f250909c;

        /* renamed from: d, reason: collision with root package name */
        public int f250910d;

        public b(String str, String str2, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f250907a = str;
            this.f250908b = str2;
            this.f250909c = i3;
            this.f250910d = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final f f250911a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14438);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250911a = new f(null);
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ f(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static f c() {
        return c.f250911a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        if (!com.tencent.mobileqq.msf.core.x.a.b().c()) {
            QLog.d(f250889j, 1, "[initControl] return by switch close");
            return;
        }
        if (!TextUtils.isEmpty(str) && MsfSdkUtils.isMainProcess(str)) {
            if (this.f250904h.compareAndSet(false, true)) {
                QLog.d(f250889j, 1, "start control");
                this.f250902f = 1;
                this.f250903g = SystemClock.uptimeMillis();
                this.f250898b.removeCallbacks(this.f250905i);
                this.f250898b.postDelayed(this.f250905i, this.f250897a);
                return;
            }
            return;
        }
        QLog.d(f250889j, 1, "[initControl] return by invalid processName: " + str);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (!com.tencent.mobileqq.msf.core.x.a.b().c()) {
                return;
            }
            QLog.d(f250889j, 1, "onMsgSyncEnd");
            this.f250898b.removeCallbacks(this.f250905i);
            this.f250898b.post(this.f250905i);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        for (Map.Entry<String, b> entry : this.f250900d.entrySet()) {
            HashMap hashMap = new HashMap();
            b value = entry.getValue();
            hashMap.put("cmd", entry.getKey());
            hashMap.put(f250892m, value.f250908b);
            hashMap.put("seq", String.valueOf(value.f250909c));
            hashMap.put(f250895p, String.valueOf(true));
            hashMap.put(f250894o, String.valueOf(entry.getValue().f250910d));
            MsfCore.sCore.statReporter.a(f250890k, true, 0L, 0L, (Map<String, String>) hashMap, true, false);
            QLog.d(f250889j, 1, "[reportCmdDuringControl] NORMAL MSG CMD: " + entry.getKey() + ", MSFCommand: " + entry.getValue().f250908b + ", Seq: " + entry.getValue().f250909c);
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250897a = 3000;
        this.f250898b = null;
        this.f250899c = new LinkedBlockingDeque<>(1000);
        this.f250900d = new HashMap();
        this.f250901e = new HashSet<>();
        this.f250902f = 1;
        this.f250903g = 0L;
        this.f250904h = new AtomicBoolean(false);
        this.f250905i = new a();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(q.f249794i);
        baseHandlerThread.start();
        this.f250898b = new Handler(baseHandlerThread.getLooper());
        b();
        this.f250897a = com.tencent.mobileqq.msf.core.x.a.b().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f250904h.compareAndSet(true, false)) {
            QLog.d(f250889j, 1, "endControlTask");
            try {
                int size = this.f250899c.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ToServiceMsg poll = this.f250899c.poll();
                    if (poll != null) {
                        HashMap<String, Object> attributes = poll.getAttributes();
                        if (attributes.containsKey(f250896q) && (attributes.get(f250896q) instanceof Integer)) {
                            MsfService.getCore().getMsfServiceReqHandler().a(BaseApplication.getContext(), poll, ((Integer) attributes.get(f250896q)).intValue());
                            QLog.d(f250889j, 1, "[endControlTask] handle Msg ssoSeq: " + poll.getRequestSsoSeq() + ", serviceCmd: " + poll.getServiceCmd() + ", MSFCommand: " + poll.getMsfCommand());
                        }
                    }
                }
                e();
            } catch (Exception e16) {
                QLog.e(f250889j, 1, "endControlTask error, ", e16);
            }
        }
    }

    private void b() {
        this.f250901e.add(BaseConstants.CMD_REGISTERMSFSERVICE);
        this.f250901e.add(BaseConstants.CMD_UNREGISTERMSFSERVICE);
        this.f250901e.add(BaseConstants.CMD_LISTEN_MSG_SYNC_END);
        this.f250901e.add(BaseConstants.CMD_SA);
        this.f250901e.add(BaseConstants.CMD_SA_WT);
        this.f250901e.add(BaseConstants.CMD_APPUSEETLOGIN);
        this.f250901e.add(BaseConstants.CMD_REGISTER_CMDCALLBACKER);
        this.f250901e.add(BaseConstants.CMD_PUSH_REGISTERPROXY);
        this.f250901e.add(BaseConstants.CMD_PUSH_UNREGISTERPROXY);
        this.f250901e.add(BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC);
        this.f250901e.add(BaseConstants.CMD_NT_REGPRXSYNC_GROUP_MSG);
        this.f250901e.add(BaseConstants.CMD_NT_REGPRXSYNC_BATCH_GET_MSG);
        this.f250901e.add(BaseConstants.CMD_NT_PUSH_REGISTER);
        this.f250901e.add(BaseConstants.CMD_NT_PUSH_UNREGISTER);
        this.f250901e.add(BaseConstants.CMD_NT_SSO_HEART_BEAT);
        this.f250901e.add(BaseConstants.CMD_MSG_PBSENDMSG);
        this.f250901e.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_C2C_MSG);
        this.f250901e.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_ROAM_MSG);
        this.f250901e.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_MSG);
        this.f250901e.add(BaseConstants.CMD_MSG_UNREAD_MSG_SEQ);
        this.f250901e.add(BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_SHARE_MSG);
        this.f250901e.add(BaseConstants.CMD_NT_SSO_GET_PEER_SEQ);
        this.f250901e.add("trpc.msg.msg_svc.MsgService.SsoReadedReport");
        this.f250901e.add("PushService.settoken");
        this.f250901e.add("PushService.SvcReqForeGround");
        this.f250901e.add("PushService.SvcReqBackGround");
        this.f250901e.add("trpc.group_pro.synclogic.SyncLogic.SyncFirstView");
        this.f250901e.add("MsgProxy.SendMsg");
        this.f250901e.add("trpc.group_pro.synclogic.SyncLogic.SsoGetMultiChannelMsg");
        this.f250901e.add("trpc.group_pro.synclogic.SyncLogic.GetChannelMsg");
        this.f250901e.add("trpc.o3.ecdh_access.EcdhAccess.SsoEstablishShareKey");
        this.f250901e.add("trpc.o3.ecdh_access.EcdhAccess.SsoSecureAccess");
        this.f250901e.add("trpc.login.ecdh.EcdhService.SsoOIDB0x90cd");
        this.f250901e.add("trpc.login.ecdh.EcdhService.SsoOIDB0x90ce");
        this.f250901e.add("trpc.login.ecdh.EcdhService.SsoKeyExchange");
        this.f250901e.add("OidbSvcTrpcTcp.0x9293_0");
        this.f250901e.add("OidbSvcTrpcTcp.0x9294_0");
        this.f250901e.add("OidbSvcTrpcTcp.0x9295_0");
        this.f250901e.add("OidbSvcTrpcTcp.0x9296_0");
        this.f250901e.add("trpc.qq_tab.user_dynamic_tab.UserDynamicTab.GetTabList");
        this.f250901e.addAll(com.tencent.mobileqq.msf.core.x.a.b().a());
    }

    public boolean a(@NonNull ToServiceMsg toServiceMsg, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, i3)).booleanValue();
        }
        if (!com.tencent.mobileqq.msf.core.x.a.b().c() || !this.f250904h.get() || a(toServiceMsg.getServiceCmd())) {
            return false;
        }
        toServiceMsg.addAttribute(f250896q, Integer.valueOf(i3));
        this.f250899c.offer(toServiceMsg);
        int uptimeMillis = (int) (SystemClock.uptimeMillis() - this.f250903g);
        if (this.f250900d.containsKey(toServiceMsg.getServiceCmd())) {
            return true;
        }
        Map<String, b> map = this.f250900d;
        String serviceCmd = toServiceMsg.getServiceCmd();
        String serviceCmd2 = toServiceMsg.getServiceCmd();
        String str = toServiceMsg.getMsfCommand().toString();
        int i16 = this.f250902f;
        this.f250902f = i16 + 1;
        map.put(serviceCmd, new b(serviceCmd2, str, i16, uptimeMillis));
        return true;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f250901e.contains(str)) {
            return true;
        }
        int indexOf = str.indexOf(".");
        if (indexOf > 0) {
            if (this.f250901e.contains(str.substring(0, indexOf) + ".")) {
                return true;
            }
        }
        return false;
    }
}
