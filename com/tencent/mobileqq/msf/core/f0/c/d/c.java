package com.tencent.mobileqq.msf.core.f0.c.d;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.e0.d;
import com.tencent.mobileqq.msf.core.e0.f;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.r;
import com.tencent.mobileqq.msf.core.u;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.n;
import com.tencent.mobileqq.msfcore.MSFResponseAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    public static final String f248097e = "MSF.C.SsoRespHandlerAdapter";

    /* renamed from: f, reason: collision with root package name */
    private static final String f248098f = "wait serverResp timeout";

    /* renamed from: g, reason: collision with root package name */
    private static final AtomicBoolean f248099g;

    /* renamed from: a, reason: collision with root package name */
    private final u f248100a;

    /* renamed from: b, reason: collision with root package name */
    private final a f248101b;

    /* renamed from: c, reason: collision with root package name */
    private final b f248102c;

    /* renamed from: d, reason: collision with root package name */
    final f f248103d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f248099g = new AtomicBoolean(false);
        }
    }

    public c(u uVar, a aVar, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uVar, aVar, bVar);
            return;
        }
        this.f248103d = new f();
        this.f248100a = uVar;
        this.f248101b = aVar;
        this.f248102c = bVar;
    }

    private String a(int i3) {
        return (i3 == 1 || i3 == 4) ? com.tencent.mobileqq.msf.core.quicksend.b.A : (i3 == 2 || i3 == 3 || i3 == 5) ? "http" : (i3 == 9 || i3 == 8) ? com.tencent.mobileqq.msf.core.quicksend.b.B : "failed";
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? f248099g.get() : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        a(true);
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), MsfService.getCore().getNextSeq(), "0", BaseConstants.CMD_INVALIDSIGN);
        fromServiceMsg.setBusinessFail(2014, "onInvalidSign");
        fromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        MsfService.getCore().addRespToQuque(null, fromServiceMsg);
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            f248099g.set(z16);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }

    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (toServiceMsg == null) {
            return;
        }
        if (toServiceMsg.isNeedRemindSlowNetwork()) {
            l.a(l.b.f248789a);
        }
        toServiceMsg.addAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, "");
        fromServiceMsg.addAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, "");
        if (toServiceMsg.getAttributes().containsKey(BaseConstants.Attribute_TAG_SOCKET_ADDRESS)) {
            fromServiceMsg.addAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS, toServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS));
        }
        a(toServiceMsg, fromServiceMsg);
    }

    public b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f248102c : (b) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    public void a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f248103d.a(dVar);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
        }
    }

    public void a(@Nullable ToServiceMsg toServiceMsg, MSFResponseAdapter mSFResponseAdapter) {
        long j3;
        long j16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) toServiceMsg, (Object) mSFResponseAdapter);
            return;
        }
        if (toServiceMsg != null) {
            if (mSFResponseAdapter.getState() == 4 && mSFResponseAdapter.getFailReason() == 8 && a(toServiceMsg)) {
                FromServiceMsg constructResponse = MsfSdkUtils.constructResponse(toServiceMsg, BaseConstants.CODE_RESENDMSG, "", null);
                constructResponse.setBusinessFail(BaseConstants.CODE_RESENDMSG);
                MsfService.getCore().addRespToQuque(toServiceMsg, constructResponse);
                return;
            } else if (a(mSFResponseAdapter)) {
                FromServiceMsg a16 = o.a(toServiceMsg);
                a16.setBusinessFail(1002, f248098f);
                b(toServiceMsg, a16);
                return;
            }
        }
        FromServiceMsg a17 = this.f248102c.a(mSFResponseAdapter);
        n.a(a17);
        a17.addAttribute(BaseConstants.TIMESTAMP_NET2MSF, Long.valueOf(System.currentTimeMillis()));
        a17.addAttribute(BaseConstants.TIMESTAMP_NET2MSF_BOOT, Long.valueOf(SystemClock.elapsedRealtime()));
        a17.addAttribute(BaseConstants.ATTRIBUTE_KEY_IS_MSF_CONNECT, Boolean.valueOf(MsfService.getCore().isConnected()));
        if (toServiceMsg != null) {
            a17.setAppSeq(toServiceMsg.getAppSeq());
            a17.setMsfCommand(toServiceMsg.getMsfCommand());
            toServiceMsg.addAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249868z, a(((Integer) a17.getAttribute(BaseConstants.ATTRIBUTE_KEY_RECV_WAY, 0)).intValue()));
        }
        if (a17.getAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_SIGN_FLAG) != null) {
            com.tencent.mobileqq.msf.core.d0.a.c().a(((Integer) a17.getAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_SIGN_FLAG)).intValue());
        }
        if (NetConnInfoCenter.isNeedWifiAuth()) {
            NetConnInfoCenter.setNeedWifiAuth(false);
        }
        if (a17.getAttribute(BaseConstants.ATTRIBUTE_KEY_SEND_TIME) != null) {
            j3 = ((Long) a17.getAttribute(BaseConstants.ATTRIBUTE_KEY_SEND_TIME)).longValue();
            a17.addAttribute(BaseConstants.TIMESTAMP_MSF2NET, Long.valueOf(j3));
            if (toServiceMsg != null) {
                toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_MSF2NET, Long.valueOf(j3));
            }
        } else {
            j3 = 0;
        }
        if (a17.getAttribute(BaseConstants.ATTRIBUTE_KEY_RECV_TIME) != null) {
            j16 = ((Long) a17.getAttribute(BaseConstants.ATTRIBUTE_KEY_RECV_TIME)).longValue();
            a17.addAttribute(BaseConstants.TIMESTAMP_NET2MSF, Long.valueOf(j16));
        } else {
            j16 = 0;
        }
        long j17 = j16 - j3;
        if (j17 < 0 || j17 > TTL.MAX_VALUE) {
            j17 = 0;
        }
        StringBuilder sb5 = new StringBuilder();
        if (j17 == 0) {
            str = String.valueOf(j17);
        } else {
            str = j17 + NetConnInfoCenter.getSignalStrengthsLog();
        }
        sb5.append("netRecv ssoSeq:");
        sb5.append(a17.getRequestSsoSeq());
        sb5.append(" uin:");
        sb5.append(a17.getUin());
        sb5.append(" cmd:");
        sb5.append(a17.getServiceCmd());
        sb5.append(" len:");
        sb5.append(a17.getWupBuffer().length);
        sb5.append(" costTime:");
        sb5.append(str);
        sb5.append(" code:");
        sb5.append(a17.getResultCode());
        sb5.append(" failMsg:");
        sb5.append(a17.getBusinessFailMsg());
        QLog.d(f248097e, 1, sb5.toString());
        a17.addAttribute(BaseConstants.Attribute_TAG_LOGSTR, "");
        a17.addAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS, "");
        if (b()) {
            QLog.e(f248097e, 1, "invalidSign, " + a17 + " is droped.");
        } else {
            a(toServiceMsg, a17);
        }
        MsfService.getCore().getAccountCenter().f247404j.c();
        r.l().h();
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        this.f248100a.a(toServiceMsg, fromServiceMsg);
        this.f248103d.a(toServiceMsg, fromServiceMsg);
        com.tencent.mobileqq.msf.core.push.b msfProbeManager = MsfService.getCore().getMsfProbeManager();
        if (msfProbeManager != null) {
            msfProbeManager.a(toServiceMsg, fromServiceMsg);
        }
    }

    private boolean a(@NonNull ToServiceMsg toServiceMsg) {
        if (!toServiceMsg.isFastResendEnabled()) {
            for (String str : BaseConstants.CMD_NeedResendCmds) {
                if (!toServiceMsg.getServiceCmd().equals(str)) {
                }
            }
            return false;
        }
        return true;
    }

    private boolean a(MSFResponseAdapter mSFResponseAdapter) {
        int state = mSFResponseAdapter.getState();
        int failReason = mSFResponseAdapter.getFailReason();
        int ssoRet = mSFResponseAdapter.getSsoRet();
        if (state == 3 && ssoRet == 0) {
            return false;
        }
        return (state == 4 && failReason == 4) ? false : true;
    }
}
