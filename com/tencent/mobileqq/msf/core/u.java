package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.c0.f;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msf.service.protocol.kqqconfig.GrayUinCheckResp;
import com.tencent.msf.service.protocol.push.RequestMSFForceOffline;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class u {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f250108f = "MSF.C.SSORespHandler";

    /* renamed from: g, reason: collision with root package name */
    public static ConcurrentHashMap<String, GrayUinCheckResp> f250109g = null;

    /* renamed from: h, reason: collision with root package name */
    public static final int f250110h = 210;

    /* renamed from: i, reason: collision with root package name */
    public static final int f250111i = -12003;

    /* renamed from: j, reason: collision with root package name */
    private static final int f250112j = 1000;

    /* renamed from: k, reason: collision with root package name */
    private static final int f250113k = 1000000;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f250114a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f250115b;

    /* renamed from: c, reason: collision with root package name */
    long f250116c;

    /* renamed from: d, reason: collision with root package name */
    long f250117d;

    /* renamed from: e, reason: collision with root package name */
    private final Random f250118e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f250119a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26419);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MsfCommand.values().length];
            f250119a = iArr;
            try {
                iArr[MsfCommand._msf_RegPush.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f250119a[MsfCommand._msf_UnRegPush.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f250119a[MsfCommand._msf_queryPush.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f250119a[MsfCommand._msf_hello.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f250119a[MsfCommand.checkRole.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f250119a[MsfCommand.accountTokenSyncCheckSign.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f250119a[MsfCommand.getServerTime.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f250119a[MsfCommand.msf_FEKit.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class c extends Handler {
        static IPatchRedirector $redirector_;

        public c(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1000) {
                MsfService.getCore().refreshWebviewTickets((String) message.obj, "SidExpiredPush");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11969);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f250109g = new ConcurrentHashMap<>();
        }
    }

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250114a = new CopyOnWriteArrayList<>();
        this.f250116c = -1L;
        this.f250117d = -1L;
        this.f250118e = new Random();
        this.f250115b = new c(q.n().getLooper());
    }

    protected boolean a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? i3 == -12003 || i3 == 210 || i3 == -10001 || i3 == -10003 || i3 == -10004 || i3 == -10006 || i3 == -10106 : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
    }

    public boolean b(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar)).booleanValue();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unregisterSSOResponseEventListener ");
        sb5.append(bVar == null ? "null" : Integer.toHexString(bVar.hashCode()));
        QLog.d(f250108f, 1, sb5.toString());
        if (bVar == null) {
            return false;
        }
        return this.f250114a.remove(bVar);
    }

    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerSSOResponseEventListener ");
        sb5.append(bVar == null ? "null" : Integer.toHexString(bVar.hashCode()));
        QLog.d(f250108f, 1, sb5.toString());
        if (bVar != null) {
            this.f250114a.add(bVar);
        }
    }

    private void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg == null || fromServiceMsg == null) {
            return;
        }
        int nextInt = this.f250118e.nextInt(1000000);
        com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.getCore().getStatReporter();
        if (nextInt != 0 || statReporter == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(QzoneIPCModule.RESULT_CODE, String.valueOf(fromServiceMsg.getResultCode()));
        statReporter.a("EvtSendSSO", fromServiceMsg.isSuccess(), 0L, 0L, (Map<String, String>) hashMap, true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0233  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        boolean z16;
        boolean z17;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) fromServiceMsg, (Object) toServiceMsg)).booleanValue();
        }
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        boolean a16 = a(businessFailCode);
        if (-10106 == businessFailCode) {
            a(fromServiceMsg, a16);
        }
        if (fromServiceMsg.getUinType() == 6 && ((a16 || businessFailCode == -10005) && MsfService.getCore().isUseNewService() && com.tencent.mobileqq.msf.core.x.m.l())) {
            String str2 = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, "");
            QLog.d(f250108f, 1, Thread.currentThread().getName() + " handleSsoFailCode tokenExpired uin=" + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()) + ", uinType = " + fromServiceMsg.getUinType() + ", businessCode = " + businessFailCode + ", dispatch to process:" + str2);
            fromServiceMsg.setBusinessFail(businessFailCode, fromServiceMsg.getBusinessFailMsg());
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, str2);
            MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
            return true;
        }
        if (!a16 && businessFailCode == -10005) {
            z16 = a16;
            if (this.f250116c == -1) {
                this.f250116c = System.currentTimeMillis();
            }
            if (!com.tencent.mobileqq.msf.core.auth.b.f247389t.get()) {
                if (MsfService.getCore().getAccountCenter().l(fromServiceMsg.getUin())) {
                    z17 = z16;
                } else {
                    QLog.d(f250108f, 1, "reload D2 failed");
                    com.tencent.mobileqq.msf.core.auth.b.f247388s = 1;
                    z17 = true;
                }
                com.tencent.mobileqq.msf.core.auth.b.f247389t.set(true);
            } else {
                if (toServiceMsg == null || com.tencent.mobileqq.msf.core.auth.b.f247388s == -1 || toServiceMsg.getRequestSsoSeq() < com.tencent.mobileqq.msf.core.auth.b.f247388s) {
                    if (this.f250116c != -1 && System.currentTimeMillis() - this.f250116c > 60000) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f250108f, 2, "set userTokenExpired after so long wait. ");
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(f250108f, 2, "set userTokenExpired. afterReloadD2SendSeq is " + com.tencent.mobileqq.msf.core.auth.b.f247388s);
                }
                z17 = true;
            }
            if (!z17) {
                QLog.d(f250108f, 1, Thread.currentThread().getName() + " handleSsoFailCode tokenExpired to setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()) + " businessCode = " + businessFailCode);
                MsfService.getCore().getAccountCenter().n(fromServiceMsg.getUin());
                if (!com.tencent.mobileqq.msf.service.n.c() && (this.f250117d == -1 || System.currentTimeMillis() - this.f250117d > 10000)) {
                    try {
                        com.tencent.mobileqq.msf.service.n.a(BaseApplication.getContext(), BaseApplication.getContext().getPackageName(), fromServiceMsg.getUin(), com.tencent.mobileqq.msf.service.n.a(), MsfService.getCore().getUinPushStatus(fromServiceMsg.getUin()), null);
                        QLog.d(f250108f, 1, "sendBootAction for mainProcess for " + MD5.toMD5(fromServiceMsg.getUin()));
                        this.f250117d = System.currentTimeMillis();
                    } catch (Exception e16) {
                        QLog.d(f250108f, 1, "sendBootAction for mainProcess error " + e16, e16);
                    }
                }
                fromServiceMsg.setBusinessFail(2001, fromServiceMsg.getBusinessFailMsg());
                MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
                if (MsfService.getCore().getStatReporter() != null) {
                    MsfService.getCore().getStatReporter().a(0L, businessFailCode, 0L);
                }
                return true;
            }
            if (businessFailCode == -10101) {
                QLog.d(f250108f, 1, "handleSsoFailCode, sso pop tips");
                fromServiceMsg.setBusinessFail(2011, fromServiceMsg.getBusinessFailMsg());
                MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
                return true;
            }
            if (businessFailCode == -10102) {
                QLog.d(f250108f, 1, "handleSsoFailCode, sso suspent");
                MsfService.getCore().suspend();
                fromServiceMsg.setBusinessFail(2009, fromServiceMsg.getBusinessFailMsg());
                MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
                return true;
            }
            if (businessFailCode == -10103) {
                QLog.d(f250108f, 1, "handleSsoFailCode, sso expired token");
                MsfService.getCore().getAccountCenter().n(fromServiceMsg.getUin());
                fromServiceMsg.setBusinessFail(2012, fromServiceMsg.getBusinessFailMsg());
                MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
                return true;
            }
            if (businessFailCode == -10009) {
                fromServiceMsg.setBusinessFail(2015, fromServiceMsg.getBusinessFailMsg());
                MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag.", 2, Thread.currentThread().getName() + " handleSsoFailCode closeConn ssoInvalidCookie");
                }
                MsfService.getCore().closeConn(com.tencent.qphone.base.a.ssoInvalidCookie);
                return true;
            }
            if (businessFailCode == -10104) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250108f, 2, "get CODE_SSO_FORCEQUIT kill " + BaseApplication.getContext().getPackageName() + ":qq now");
                }
                MsfSdkUtils.killProcess(BaseApplication.getContext(), BaseApplication.getContext().getPackageName());
                return true;
            }
            if (businessFailCode == -10105) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250108f, 2, "get CODE_SSO_FORCEQUITSDK kill " + BaseApplication.getContext().getPackageName() + ":msf now");
                }
                MsfSdkUtils.killProcess(BaseApplication.getContext(), BaseApplication.getContext().getPackageName() + ":MSF");
                return true;
            }
            if (businessFailCode != -10118 && businessFailCode != -10115 && businessFailCode != -10116) {
                if (businessFailCode <= -10300 || businessFailCode >= -10200) {
                    str = f250108f;
                } else {
                    com.tencent.mobileqq.msf.core.d0.a.c().a(fromServiceMsg.getServiceCmd(), fromServiceMsg.getRequestSsoSeq(), businessFailCode);
                    String str3 = "onReceiveSecError, cmd:" + fromServiceMsg.getServiceCmd() + ", businessCode:" + businessFailCode + ", errorMsg:" + fromServiceMsg.getBusinessFailMsg();
                    str = f250108f;
                    QLog.d(str, 1, str3);
                }
                GrayUinCheckResp grayUinCheckResp = toServiceMsg != null ? f250109g.get(toServiceMsg.getUin()) : null;
                if (grayUinCheckResp != null && !fromServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA) && !toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_WT_LOGIN_AUTH) && !toServiceMsg.getServiceCmd().equals("GrayUinPro.Check") && !toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_GRAY_APPLY)) {
                    QLog.d(str, 1, "[GrayRoleCheck] handleSsoFailCode, not in gray list, ", MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                    try {
                        fromServiceMsg.setBusinessFail(2008, new String(grayUinCheckResp.err_msg, "UTF-8"));
                    } catch (Exception unused) {
                        fromServiceMsg.setBusinessFail(2008, toServiceMsg.getUin() + " not in gray list");
                    }
                    fromServiceMsg.addAttribute(fromServiceMsg.getServiceCmd(), String.valueOf(grayUinCheckResp.is_yingyongbao));
                    MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                    MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
                    return true;
                }
                if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_FORCE_LOGOUT)) {
                    try {
                        MsfService.getCore().pushManager.e(fromServiceMsg.getUin());
                        fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_SAMEDEVICE, Boolean.FALSE);
                        fromServiceMsg.setBusinessFail(2013, fromServiceMsg.getBusinessFailMsg());
                        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                        MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
                        com.tencent.mobileqq.msf.core.net.r.a.a(com.tencent.mobileqq.msf.core.net.r.a.f248965q);
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e(str, 2, "handle forceLogout error " + e17);
                        }
                    }
                    return true;
                }
                if (!fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_OFFLINEPUSH)) {
                    return false;
                }
                try {
                    MsfService.getCore().pushManager.e(fromServiceMsg.getUin());
                    UniPacket uniPacket = new UniPacket(true);
                    uniPacket.setEncodeName("utf-8");
                    uniPacket.decode(fromServiceMsg.getWupBuffer());
                    RequestMSFForceOffline requestMSFForceOffline = (RequestMSFForceOffline) uniPacket.getByClass("RequestMSFForceOffline", new RequestMSFForceOffline());
                    com.tencent.msf.service.protocol.push.c cVar = new com.tencent.msf.service.protocol.push.c(requestMSFForceOffline.lUin, requestMSFForceOffline.iSeqno, (byte) 0);
                    ToServiceMsg toServiceMsg2 = new ToServiceMsg("", fromServiceMsg.getUin(), BaseConstants.CMD_FORCEOFFLINERESP);
                    toServiceMsg2.addAttribute(BaseConstants.ATTRIBUTE_SAMEDEVICE, Boolean.FALSE);
                    UniPacket uniPacket2 = new UniPacket(true);
                    uniPacket2.setEncodeName("utf-8");
                    uniPacket2.setServantName("StatSvc");
                    uniPacket2.setFuncName("RspMSFForceOffline");
                    uniPacket2.put("RspMSFForceOffline", cVar);
                    toServiceMsg2.setMsfCommand(MsfCommand._msf_kickedAndCleanTokenResp);
                    toServiceMsg2.setNeedCallback(false);
                    toServiceMsg2.putWupBuffer(uniPacket2.encode());
                    toServiceMsg2.setRequestSsoSeq(MsfService.getCore().getNextSeq());
                    toServiceMsg2.setAppId(BaseApplication.getContext().getAppId());
                    toServiceMsg2.setTimeout(30000L);
                    toServiceMsg2.addAttribute(toServiceMsg2.getServiceCmd(), fromServiceMsg);
                    MsfService.getCore().sendSsoMsg(toServiceMsg2);
                    com.tencent.mobileqq.msf.core.net.r.a.a(com.tencent.mobileqq.msf.core.net.r.a.f248965q);
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.e(str, 2, "send offlineResp error " + e18);
                    }
                }
                return true;
            }
            QLog.d(f250108f, 1, "handleSsoFailCode, businessCode=" + businessFailCode + ", errorMsg: " + fromServiceMsg.getBusinessFailMsg());
            if (toServiceMsg != null && toServiceMsg.isNeedCallback()) {
                MsfService.getCore().addRespToQuque(toServiceMsg, com.tencent.mobileqq.msf.service.n.a(toServiceMsg));
            }
            return true;
        }
        z16 = a16;
        z17 = z16;
        if (!z17) {
        }
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        Iterator<b> it = this.f250114a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                next.a(toServiceMsg, fromServiceMsg);
            }
        }
        if (a(fromServiceMsg, toServiceMsg)) {
            if (fromServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA_WT) && toServiceMsg != null) {
                com.tencent.mobileqq.msf.core.auth.m.a(toServiceMsg, fromServiceMsg);
            }
            b(toServiceMsg, fromServiceMsg);
            return;
        }
        if (com.tencent.mobileqq.msf.core.x.b.f250193x && toServiceMsg != null && toServiceMsg.getMsfCommand() != MsfCommand._msf_RegPush && toServiceMsg.getMsfCommand() != MsfCommand._msf_queryPush && MsfService.getCore().pushManager != null) {
            MsfService.getCore().pushManager.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
        }
        boolean z16 = (toServiceMsg == null || toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_OLDCMD) == null) ? false : true;
        if (fromServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA) && !z16) {
            if (toServiceMsg != null) {
                MsfService.getCore().getAccountCenter().f247403i.a(toServiceMsg, fromServiceMsg);
                return;
            }
            if ((fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_LOGIN_AUTH) || fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_LOGIN_CHANGEUIN_AUTH)) && fromServiceMsg.getResultCode() == 1000 && MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a(fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_LOGIN_CHANGEUIN_AUTH));
            }
            if (QLog.isColorLevel()) {
                QLog.d(f250108f, 2, "found timeoutResp " + fromServiceMsg);
                return;
            }
            return;
        }
        if (fromServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA_WT) && z16) {
            if (toServiceMsg != null) {
                com.tencent.mobileqq.msf.core.auth.m.a(toServiceMsg, fromServiceMsg);
                return;
            }
            if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_WT_LOGIN_AUTH) && fromServiceMsg.getResultCode() == 1000 && MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a(false);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f250108f, 2, "found timeoutResp " + fromServiceMsg);
                return;
            }
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_PUSHCHANGETOKEN)) {
            MsfService.getCore().getAccountCenter().f247404j.g();
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_PUSH_SID_EXPIRED) && fromServiceMsg.isSuccess()) {
            ToServiceMsg toServiceMsg2 = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
            toServiceMsg2.setRequestSsoSeq(fromServiceMsg.getRequestSsoSeq());
            toServiceMsg2.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg2.setNeedCallback(false);
            toServiceMsg2.setTimeout(30000L);
            MsfService.getCore().sendSsoMsg(toServiceMsg2);
            Message obtainMessage = this.f250115b.obtainMessage();
            obtainMessage.what = 1000;
            obtainMessage.obj = fromServiceMsg.getUin();
            if (this.f250115b.hasMessages(1000)) {
                this.f250115b.removeMessages(1000);
            }
            this.f250115b.sendMessageDelayed(obtainMessage, 3000L);
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_PUSHREQ)) {
            MsfService.getCore().pushManager.d(fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_SSOHELLOPUSH)) {
            MsfService.getCore().pushManager.e(fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_QUALITYTEST) && fromServiceMsg.isSuccess()) {
            com.tencent.mobileqq.msf.core.net.t.g.f249396d = MsfService.getCore();
            com.tencent.mobileqq.msf.core.net.t.g.a(fromServiceMsg);
            ToServiceMsg toServiceMsg3 = new ToServiceMsg("", "0", fromServiceMsg.getServiceCmd());
            toServiceMsg3.setMsfCommand(MsfCommand._msf_QualityTest);
            toServiceMsg3.setRequestSsoSeq(fromServiceMsg.getRequestSsoSeq());
            toServiceMsg3.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg3.setNeedCallback(false);
            toServiceMsg3.setTimeout(30000L);
            MsfService.getCore().sendSsoMsg(toServiceMsg3);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_PBPUSHOFFMSG) && fromServiceMsg.isSuccess()) {
            MsfService.getCore().pushManager.a(fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_PUSHREADED) && fromServiceMsg.isSuccess()) {
            MsfService.getCore().pushManager.c(fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.COMMAND_RequestPullUnreadMsgCount) && fromServiceMsg.isSuccess()) {
            MsfService.getCore().pushManager.a(fromServiceMsg, toServiceMsg);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_REGPRXYSVC_INFOLOGIN) || fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_NEW_REGPRXYSVC_PBSYNCMSG)) {
            MsfService.getCore().mbIsInfoLoginGetted.set(true);
        }
        if (toServiceMsg != null && (fromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq") || fromServiceMsg.getServiceCmd().equals("ResourceConfig.ClientReq"))) {
            if (toServiceMsg.getMsfCommand() == MsfCommand._msf_getConfig) {
                MsfService.getCore().configManager.a(fromServiceMsg, toServiceMsg);
                return;
            } else {
                MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
                return;
            }
        }
        if (fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c") && fromServiceMsg.isSuccess()) {
            ToServiceMsg toServiceMsg4 = new ToServiceMsg("", fromServiceMsg.getUin(), "SharpSvr.s2cackMSF");
            toServiceMsg4.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg4.setRequestSsoSeq(fromServiceMsg.getRequestSsoSeq());
            toServiceMsg4.setNeedCallback(false);
            toServiceMsg4.setTimeout(30000L);
            toServiceMsg4.putWupBuffer(fromServiceMsg.getWupBuffer());
            MsfService.getCore().sendSsoMsg(toServiceMsg4);
            if (toServiceMsg == null) {
                com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247650b, fromServiceMsg.getWupBuffer(), 0);
            } else {
                com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247650b, fromServiceMsg.getWupBuffer(), 2);
            }
        }
        if (fromServiceMsg.getServiceCmd().equals(s.C) && toServiceMsg != null && ((Boolean) toServiceMsg.getAttribute("isformsf", Boolean.FALSE)).booleanValue()) {
            s.e().a(toServiceMsg, fromServiceMsg);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg.isSuccess() && BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC.equals(toServiceMsg.getServiceCmd())) {
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_INIT_TIME, Long.valueOf(MsfService.getCore().getServiceInitTime()));
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_READY_TIME, Long.valueOf(MsfService.getCore().getServiceReadyTime()));
            NetConnInfoCenter.onRegProxySvcRsp();
        }
        if (toServiceMsg == null) {
            if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_OVER_LOAD_PUSH_NOTIFY)) {
                MsfService.getCore().configManager.a(fromServiceMsg);
                return;
            }
            if (fromServiceMsg.isSuccess() && fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_OFFLINE_PUSH)) {
                MsfService.getCore().pushManager.e(fromServiceMsg.getUin());
            }
            MsfService.getCore().pushManager.b(fromServiceMsg);
            return;
        }
        switch (a.f250119a[toServiceMsg.getMsfCommand().ordinal()]) {
            case 1:
                MsfService.getCore().pushManager.b(toServiceMsg, fromServiceMsg);
                return;
            case 2:
                MsfService.getCore().pushManager.b(toServiceMsg, fromServiceMsg);
                return;
            case 3:
                MsfService.getCore().pushManager.a(toServiceMsg, fromServiceMsg);
                return;
            case 4:
                if (MsfService.getCore().getMsfProbeManager() != null) {
                    MsfService.getCore().getMsfProbeManager().a(fromServiceMsg);
                    return;
                }
                return;
            case 5:
                e.b().a(fromServiceMsg);
                return;
            case 6:
                MsfService.getCore().getAccountCenter().f247399e.a(toServiceMsg, fromServiceMsg);
                return;
            case 7:
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (QLog.isColorLevel()) {
                    QLog.d(f250108f, 2, "CorrectTime get current time:" + currentTimeMillis);
                }
                try {
                    if (fromServiceMsg.isSuccess()) {
                        currentTimeMillis = MsfSdkUtils.convertBytes2Int(fromServiceMsg.getWupBuffer(), 4);
                    }
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(f250108f, 4, "handle serverTime error " + e16);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f250108f, 2, "CorrectTime get server time:" + currentTimeMillis);
                }
                NetConnInfoCenter.handleGetServerTimeResp(currentTimeMillis);
                return;
            case 8:
                com.tencent.mobileqq.msf.core.d0.a.c().a(toServiceMsg, fromServiceMsg);
                return;
            default:
                fromServiceMsg.setAppId(toServiceMsg.getAppId());
                fromServiceMsg.setAppSeq(toServiceMsg.getAppSeq());
                fromServiceMsg.setMsfCommand(toServiceMsg.getMsfCommand());
                MsfService.getCore().addRespToQuque(toServiceMsg, fromServiceMsg);
                b(toServiceMsg, fromServiceMsg);
                return;
        }
    }

    public static void a(FromServiceMsg fromServiceMsg) {
        fromServiceMsg.setBusinessFail(2002, "verifyCode");
        fromServiceMsg.setMsfCommand(MsfCommand.onRecvVerifyCode);
    }

    private void a(FromServiceMsg fromServiceMsg, boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", fromServiceMsg.getUin());
        try {
            hashMap.put("time", new Date().toString());
        } catch (AssertionError e16) {
            QLog.e(f250108f, 1, "reportReceiveForceQuitForServerParseFail error, ", e16);
        }
        com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.getCore().getStatReporter();
        if (statReporter != null) {
            com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
            statReporter.a(com.tencent.mobileqq.msf.core.c0.g.f247675d0, true, z16 ? 1L : 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }
}
