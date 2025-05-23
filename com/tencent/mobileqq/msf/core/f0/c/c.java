package com.tencent.mobileqq.msf.core.f0.c;

import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.u;
import com.tencent.mobileqq.msf.core.x.b;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msfcore.MSFExternNetworkInfo;
import com.tencent.mobileqq.msfcore.MSFKernel;
import com.tencent.mobileqq.msfcore.MSFRequestAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msf.service.protocol.kqqconfig.GrayUinCheckResp;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: j, reason: collision with root package name */
    public static final String f248067j = "MSF.C.NewSender";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248068k = "core_network_check";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248069l = "core_network_type";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248070m = "active_network_type";

    /* renamed from: n, reason: collision with root package name */
    private static final int f248071n = 103424;

    /* renamed from: o, reason: collision with root package name */
    private static final int f248072o = 300000;

    /* renamed from: a, reason: collision with root package name */
    private final MsfCore f248073a;

    /* renamed from: b, reason: collision with root package name */
    private final MSFKernel f248074b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedBlockingDeque<ToServiceMsg> f248075c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.c.d.b f248076d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.c.d.a f248077e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f248078f;

    /* renamed from: g, reason: collision with root package name */
    final com.tencent.mobileqq.msf.core.e0.g f248079g;

    /* renamed from: h, reason: collision with root package name */
    private long f248080h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<Integer, ToServiceMsg> f248081i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f248082a;

        a(ToServiceMsg toServiceMsg) {
            this.f248082a = toServiceMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) toServiceMsg);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                if (c.this.f248073a.configManager != null) {
                    c.this.f248073a.configManager.a(this.f248082a.getUin(), System.currentTimeMillis());
                }
                if (com.tencent.mobileqq.msf.core.auth.d.f247429o.containsKey(this.f248082a.getUin())) {
                    c.this.f248073a.getAccountCenter().m(this.f248082a.getUin());
                    com.tencent.mobileqq.msf.core.auth.d.f247429o.remove(this.f248082a.getUin());
                    QLog.d("MSF.C.NewSender", 1, "ReloadKey for uin:" + MsfSdkUtils.getShortUin(this.f248082a.getUin()) + " while ssoSeq=" + this.f248082a.getRequestSsoSeq());
                }
                if (!this.f248082a.getUin().equals("0")) {
                    if (!((Boolean) this.f248082a.getAttribute(com.tencent.mobileqq.msf.core.auth.b.f247387r, Boolean.FALSE)).booleanValue() && this.f248082a.getAppId() != -1 && this.f248082a.getAppId() != 100) {
                        com.tencent.mobileqq.msf.core.e.b().a(this.f248082a);
                    }
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (c.this.f248080h == 0 || uptimeMillis - c.this.f248080h > MiniBoxNoticeInfo.MIN_5) {
                    c.this.f248080h = uptimeMillis;
                    c cVar = c.this;
                    cVar.a(cVar.f248074b.getApnState());
                }
                MSFRequestAdapter a16 = c.this.f248076d.a(this.f248082a);
                if (c.this.f248074b.sendPacket(a16) != a16.getSeq()) {
                    c.this.b(this.f248082a);
                } else {
                    c.this.f248081i.put(Integer.valueOf(this.f248082a.getRequestSsoSeq()), this.f248082a);
                    c.this.f248079g.c(this.f248082a);
                    QLog.d("MSF.C.NewSender", 1, "netSend appSeq:" + this.f248082a.getAppSeq() + " ssoSeq:" + this.f248082a.getRequestSsoSeq() + " MSFRequest Seq:" + a16.getSeq() + " uin:" + MsfSdkUtils.getShortUin(this.f248082a.getUin()) + " uid:" + a16.getUid() + " cmd:" + this.f248082a.getServiceCmd() + " len:" + this.f248082a.getWupBuffer().length + " timeout:" + this.f248082a.getTimeout() + " options: " + a16.getOptions() + " packetType: " + a16.getPacketType());
                }
            } catch (Throwable th5) {
                QLog.d("MSF.C.NewSender", 1, th5.toString(), th5);
                c.this.b(this.f248082a);
            }
            if (this.f248082a.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                try {
                    ToServiceMsg toServiceMsg = this.f248082a;
                    FromServiceMsg fromServiceMsg = (FromServiceMsg) toServiceMsg.getAttribute(toServiceMsg.getServiceCmd());
                    QLog.d("MSF.C.NewSender", 1, Thread.currentThread().getName() + " kick setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                    MsfService.getCore().getAccountCenter().n(fromServiceMsg.getUin());
                    if (BaseApplication.getContext().getMSFInterfaceAdapter().useNtWtLogin()) {
                        com.tencent.mobileqq.msf.core.auth.i.f247480n.ClearUserLoginData(fromServiceMsg.getUin(), 16L);
                        QLog.d("MSF.C.NewSender", 1, "kick and ClearUserLoginData");
                    }
                    fromServiceMsg.setBusinessFail(2012, fromServiceMsg.getBusinessFailMsg());
                    if (this.f248082a.getAttributes().containsKey(BaseConstants.ATTRIBUTE_SAMEDEVICE)) {
                        z16 = ((Boolean) this.f248082a.getAttribute(BaseConstants.ATTRIBUTE_SAMEDEVICE)).booleanValue();
                    } else {
                        z16 = false;
                    }
                    fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_SAMEDEVICE, Boolean.valueOf(z16));
                    MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                    MsfService.getCore().addRespToQuque(null, fromServiceMsg);
                } catch (Exception e16) {
                    QLog.e("MSF.C.NewSender", 1, "send offlineMsg to app error " + e16);
                }
            }
        }
    }

    public c(MSFKernel mSFKernel, com.tencent.mobileqq.msf.core.f0.c.d.b bVar, com.tencent.mobileqq.msf.core.f0.c.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mSFKernel, bVar, aVar);
            return;
        }
        this.f248075c = new LinkedBlockingDeque<>(1000);
        this.f248079g = new com.tencent.mobileqq.msf.core.e0.g();
        this.f248080h = 0L;
        this.f248081i = new ConcurrentHashMap<>();
        this.f248073a = MsfService.getCore();
        this.f248074b = mSFKernel;
        this.f248076d = bVar;
        this.f248077e = aVar;
        this.f248078f = q.f();
    }

    public ToServiceMsg b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f248081i.remove(Integer.valueOf(i3)) : (ToServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(ToServiceMsg toServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        if (this.f248073a.isSuspended()) {
            QLog.d("MSF.C.NewSender", 1, "handleSsoFailCode, MSFCore suspend");
            FromServiceMsg a16 = o.a(toServiceMsg);
            a16.setBusinessFail(2009, "MSF is suspend.");
            this.f248073a.addRespToQuque(toServiceMsg, a16);
            return toServiceMsg.getRequestSsoSeq();
        }
        if (toServiceMsg.getWupBuffer() != null && toServiceMsg.getWupBuffer().length > f248071n) {
            FromServiceMsg a17 = o.a(toServiceMsg);
            a17.setBusinessFail(2019, "check the wupbuf size in range[0, 101kb]");
            this.f248073a.addRespToQuque(toServiceMsg, a17);
            return toServiceMsg.getRequestSsoSeq();
        }
        CopyOnWriteArrayList<b.C8100b> copyOnWriteArrayList = this.f248073a.configManager.f250200e;
        GrayUinCheckResp grayUinCheckResp = null;
        if (copyOnWriteArrayList != null) {
            Iterator<b.C8100b> it = copyOnWriteArrayList.iterator();
            b.C8100b c8100b = null;
            while (it.hasNext()) {
                c8100b = it.next();
                if (c8100b.f250201a + c8100b.f250202b.f25188b < System.currentTimeMillis() / 1000) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NewSender", 2, "OverloadPushNotify item expired sCmd = " + c8100b.f250203c);
                    }
                    this.f248073a.configManager.f250200e.remove(c8100b);
                } else {
                    String serviceCmd = toServiceMsg.getServiceCmd();
                    String str = c8100b.f250203c;
                    if (str.charAt(str.length() - 1) == '*') {
                        String str2 = c8100b.f250203c;
                        if (serviceCmd.startsWith(str2.substring(0, str2.length() - 1))) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.NewSender", 2, "OverloadPushNotify item matched strServiceCmd = " + serviceCmd + " sCmd:" + c8100b.f250203c);
                            }
                            z16 = true;
                        }
                    } else if (c8100b.f250203c.equals(serviceCmd)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MSF.C.NewSender", 2, "OverloadPushNotify item matched strServiceCmd = " + serviceCmd + " sCmd:" + c8100b.f250203c);
                        }
                        z16 = true;
                    }
                    if (z16 && c8100b != null) {
                        if (c8100b.f250202b.f25191e == 1) {
                            FromServiceMsg fromServiceMsg = new FromServiceMsg();
                            fromServiceMsg.setUin("0");
                            fromServiceMsg.setServiceCmd(BaseConstants.CMD_OVER_LOAD_PUSH_NOTIFY);
                            fromServiceMsg.setMsfCommand(MsfCommand.onOverloadPushNotify);
                            fromServiceMsg.setAppId(BaseApplication.getContext().getAppId());
                            fromServiceMsg.setMsgSuccess();
                            fromServiceMsg.setRequestSsoSeq(this.f248073a.getNextSeq());
                            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                            fromServiceMsg.getAttributes().put("msg", new String(c8100b.f250202b.f25190d));
                            this.f248073a.addRespToQuque(null, fromServiceMsg);
                            c8100b.f250202b.f25191e = (byte) 0;
                        }
                        FromServiceMsg a18 = o.a(toServiceMsg);
                        a.a.b.a.a.d.a aVar = c8100b.f250202b;
                        a18.setBusinessFail(aVar.f25189c, new String(aVar.f25190d));
                        this.f248073a.addRespToQuque(toServiceMsg, a18);
                        if (QLog.isColorLevel()) {
                            QLog.d("MSF.C.NewSender", 2, "OverloadPushNotify server overload block tomsg: " + toServiceMsg + " frommsg: " + a18);
                        }
                        return toServiceMsg.getRequestSsoSeq();
                    }
                }
            }
            z16 = false;
            if (z16) {
                if (c8100b.f250202b.f25191e == 1) {
                }
                FromServiceMsg a182 = o.a(toServiceMsg);
                a.a.b.a.a.d.a aVar2 = c8100b.f250202b;
                a182.setBusinessFail(aVar2.f25189c, new String(aVar2.f25190d));
                this.f248073a.addRespToQuque(toServiceMsg, a182);
                if (QLog.isColorLevel()) {
                }
                return toServiceMsg.getRequestSsoSeq();
            }
        }
        if (toServiceMsg.getAppId() <= 0 && toServiceMsg.getMsfCommand() != MsfCommand.openConn && (TextUtils.isEmpty(toServiceMsg.getServiceCmd()) || !toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA_WT))) {
            FromServiceMsg a19 = o.a(toServiceMsg);
            a19.setBusinessFail(1007, "msg appid is " + toServiceMsg.getAppId());
            this.f248073a.addRespToQuque(toServiceMsg, a19);
            return toServiceMsg.getRequestSsoSeq();
        }
        GrayUinCheckResp grayUinCheckResp2 = u.f250109g.get(toServiceMsg.getUin());
        if (grayUinCheckResp2 == null || !toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_WT_LOGIN_AUTH)) {
            grayUinCheckResp = grayUinCheckResp2;
        } else {
            com.tencent.mobileqq.msf.core.e.b().a().remove(toServiceMsg.getUin());
            u.f250109g.remove(toServiceMsg.getUin());
        }
        if (grayUinCheckResp != null && !toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA) && !toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_WT_LOGIN_AUTH) && !toServiceMsg.getServiceCmd().equals("GrayUinPro.Check") && !toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_GRAY_APPLY)) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NewSender", 2, "error, " + toServiceMsg.getUin() + " not in gray list");
            }
            FromServiceMsg a26 = o.a(toServiceMsg);
            try {
                a26.setBusinessFail(2008, new String(grayUinCheckResp.err_msg, "UTF-8"));
            } catch (Exception unused) {
                a26.setBusinessFail(2008, toServiceMsg.getUin() + " not in gray list");
            }
            a26.addAttribute(a26.getServiceCmd(), String.valueOf(grayUinCheckResp.is_yingyongbao));
            this.f248073a.addRespToQuque(toServiceMsg, a26);
            if (this.f248073a.getAccountCenter().k(a26.getUin())) {
                QLog.d("MSF.C.NewSender", 1, Thread.currentThread().getName() + " addSendQueue setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(a26.getUin()));
                this.f248073a.getAccountCenter().n(a26.getUin());
            }
            return toServiceMsg.getRequestSsoSeq();
        }
        if (this.f248073a.getStandByModeManager() != null && this.f248073a.getStandByModeManager().i()) {
            if (!this.f248073a.getStandByModeManager().c(toServiceMsg.getServiceCmd())) {
                QLog.d("MSF.C.NewSender", 1, "refuse to send request cmd: " + toServiceMsg.getServiceCmd() + " ssoseq: " + toServiceMsg.getRequestSsoSeq() + " by standbyMode");
                this.f248073a.getStandByModeManager().b(toServiceMsg);
                FromServiceMsg a27 = o.a(toServiceMsg);
                a27.setBusinessFail(2018, "standby mode force stop request");
                this.f248073a.addRespToQuque(toServiceMsg, a27);
                return toServiceMsg.getRequestSsoSeq();
            }
            this.f248073a.getStandByModeManager().a(toServiceMsg);
        }
        String i3 = this.f248073a.getAccountCenter().i(toServiceMsg.getUin());
        if (i3 != null) {
            toServiceMsg.setUin(i3);
        }
        if (toServiceMsg.getRequestSsoSeq() == -1) {
            toServiceMsg.setRequestSsoSeq(this.f248073a.getNextSeq());
        }
        if (!toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_APP2MSF)) {
            toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_APP2MSF, Long.valueOf(System.currentTimeMillis()));
        }
        if (!toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_ADDSENDQUEUE)) {
            toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE, Long.valueOf(System.currentTimeMillis()));
        }
        a(toServiceMsg);
        return toServiceMsg.getRequestSsoSeq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ToServiceMsg toServiceMsg) {
        QLog.e("MSF.C.NewSender", 1, "sendMsgError, toServiceMsg: " + toServiceMsg);
        this.f248075c.remove(toServiceMsg);
        this.f248081i.remove(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
        FromServiceMsg a16 = o.a(toServiceMsg);
        a16.setBusinessFail(1001, "MSF Send Message fail");
        this.f248073a.addRespToQuque(toServiceMsg, a16);
    }

    public void a(com.tencent.mobileqq.msf.core.e0.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f248079g.a((com.tencent.mobileqq.msf.core.e0.g) eVar);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        }
    }

    private void a(@NonNull ToServiceMsg toServiceMsg) {
        this.f248078f.post(new a(toServiceMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        try {
            NetConnInfoCenter.checkConnInfo();
            int activeNetworkType = NetConnInfoCenter.getActiveNetworkType();
            int a16 = this.f248077e.a(i3);
            if (activeNetworkType != a16) {
                QLog.d("MSF.C.NewSender", 1, "[checkNetworkInfo], MSFCore apnState not right, curActiveNetworkType: " + activeNetworkType + ", msfCoreNetworkType: " + a16);
                if (a16 == 0) {
                    int c16 = this.f248077e.c(activeNetworkType);
                    int a17 = this.f248077e.a(true);
                    MSFExternNetworkInfo mSFExternNetworkInfo = new MSFExternNetworkInfo();
                    if (c16 == 1) {
                        String currentSSID = NetConnInfoCenter.getCurrentSSID(true);
                        mSFExternNetworkInfo.setNetName(this.f248077e.b(currentSSID) ? currentSSID : BaseConstants.DEFAULT_UNKNOWN_SSID);
                        if (!this.f248077e.b(currentSSID)) {
                            currentSSID = BaseConstants.DEFAULT_UNKNOWN_BSSID;
                        }
                        mSFExternNetworkInfo.setNetIdentifier(currentSSID);
                        mSFExternNetworkInfo.setSubType(k.d());
                    } else if (c16 == 2) {
                        String currentAPN = NetConnInfoCenter.getCurrentAPN(true);
                        if (TextUtils.isEmpty(currentAPN)) {
                            currentAPN = BaseConstants.DEFAULT_UNKNOWN_XG_NET_NAME;
                        }
                        mSFExternNetworkInfo.setNetName(currentAPN);
                        mSFExternNetworkInfo.setNetIdentifier(BaseConstants.DEFAULT_UNKNOWN_XG_NET_IDENTIFIER);
                        mSFExternNetworkInfo.setSubType(k.d());
                    }
                    if (c16 != 0 && a17 == 0) {
                        QLog.e("MSF.C.NewSender", 1, "refreshNetworkInfo get error IpFamily, networkType: " + c16 + ", ipFamily: " + a17);
                        com.tencent.mobileqq.msf.core.c0.j statReporter = this.f248073a.getStatReporter();
                        if (statReporter != null) {
                            statReporter.a(c16, a17);
                        }
                        a17 = 1;
                    }
                    this.f248074b.notifyNetworkInfo(c16, a17, mSFExternNetworkInfo);
                    QLog.d("MSF.C.NewSender", 1, "notifyNetworkInfo, networkType: " + c16 + ", ipFamily: " + a17 + ", networkInfo: " + mSFExternNetworkInfo + "]");
                }
                com.tencent.mobileqq.msf.core.c0.j statReporter2 = MsfService.getCore().getStatReporter();
                if (statReporter2 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(f248069l, String.valueOf(a16));
                    hashMap.put(f248070m, String.valueOf(activeNetworkType));
                    statReporter2.a(f248068k, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                }
            }
        } catch (Exception e16) {
            QLog.e("MSF.C.NewSender", 1, "checkNetworkInfo error", e16);
        }
    }
}
