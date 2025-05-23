package com.tencent.mobileqq.msf.core;

import android.text.TextUtils;
import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msf.service.protocol.kqqconfig.GrayUinCheckReq;
import com.tencent.msf.service.protocol.kqqconfig.GrayUinCheckResp;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String f247959d = "MSF.C.GrayRoleCheckHelper";

    /* renamed from: e, reason: collision with root package name */
    private static final String f247960e = "res";

    /* renamed from: f, reason: collision with root package name */
    private static final String f247961f = "YingYongBao";

    /* renamed from: g, reason: collision with root package name */
    public static final String f247962g = "GrayUinPro.Check";

    /* renamed from: h, reason: collision with root package name */
    private static final int f247963h = 18;

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<String> f247964a;

    /* renamed from: b, reason: collision with root package name */
    private long f247965b;

    /* renamed from: c, reason: collision with root package name */
    private final Random f247966c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final e f247967a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25456);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f247967a = new e(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ e(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static e b() {
        return b.f247967a;
    }

    public synchronized HashSet<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return this.f247964a;
        }
        return (HashSet) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f247964a = new HashSet<>();
        this.f247965b = 0L;
        this.f247966c = new Random(System.currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ToServiceMsg toServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || toServiceMsg.getUin().equals("0") || !toServiceMsg.getUin().equals(MsfService.getCore().getMainAccount()) || f247961f.equals(BaseApplication.getContext().getMSFInterfaceAdapter().getChannel())) {
            return;
        }
        if (!b().a().contains(toServiceMsg.getUin())) {
            long j3 = this.f247965b + 1;
            this.f247965b = j3;
            if (j3 < 2 || this.f247966c.nextInt(20) < 2) {
                z16 = true;
                if (z16) {
                    return;
                }
                b().a(toServiceMsg.getAppId(), toServiceMsg.getUin());
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
            return;
        }
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setRequestId(MsfService.getCore().getNextSeq());
        uniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
        uniPacket.setFuncName("ClientReq");
        GrayUinCheckReq grayUinCheckReq = new GrayUinCheckReq();
        grayUinCheckReq.appid = i3;
        grayUinCheckReq.uin = str;
        grayUinCheckReq.info_machine = a(18);
        QLog.d(f247959d, 1, "[GrayRoleCheck] getInfoMachine = " + grayUinCheckReq.info_machine);
        uniPacket.put("req", grayUinCheckReq);
        ToServiceMsg toServiceMsg = new ToServiceMsg("", str, "GrayUinPro.Check");
        toServiceMsg.setAppId(i3);
        toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
        toServiceMsg.putWupBuffer(uniPacket.encode());
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setMsfCommand(MsfCommand.checkRole);
        MsfService.getCore().sendSsoMsg(toServiceMsg);
        QLog.d(f247959d, 1, "[GrayRoleCheck] role send gray check for " + MsfSdkUtils.getShortUin(str) + " use " + i3 + " to:" + toServiceMsg);
    }

    public void a(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            this.f247964a.add(fromServiceMsg.getUin());
            try {
                byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                if (wupBuffer.length > 4 && wupBuffer[0] == 0 && wupBuffer[1] == 0 && wupBuffer[2] == 0 && wupBuffer[3] == 4) {
                    int length = wupBuffer.length - 4;
                    byte[] bArr = new byte[length];
                    System.arraycopy(wupBuffer, 4, bArr, 0, length);
                    wupBuffer = bArr;
                }
                QLog.d(f247959d, 1, "recv buf:" + HexUtil.bytes2HexStr(wupBuffer));
                UniPacket uniPacket = new UniPacket();
                uniPacket.decode(wupBuffer);
                GrayUinCheckResp grayUinCheckResp = (GrayUinCheckResp) uniPacket.getByClass("res", new GrayUinCheckResp());
                QLog.d(f247959d, 1, "[GrayRoleCheck] role received gray resp uin:" + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()) + " appid:" + fromServiceMsg.getAppId() + " status:" + grayUinCheckResp.status + " yyb:" + grayUinCheckResp.is_yingyongbao + " msg:" + HexUtil.bytes2HexStr(grayUinCheckResp.err_msg));
                if (grayUinCheckResp.status == 1) {
                    if (grayUinCheckResp.new_flag) {
                        a(grayUinCheckResp, fromServiceMsg);
                        return;
                    }
                    MsfService.core.getSsoRespHandler();
                    u.f250109g.put(fromServiceMsg.getUin(), grayUinCheckResp);
                    QLog.d(f247959d, 1, Thread.currentThread().getName() + "[GrayRoleCheck] onRecvCheckRoleResp setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                    MsfService.core.getAccountCenter().n(fromServiceMsg.getUin());
                    return;
                }
                u.f250109g.remove(fromServiceMsg.getUin());
                return;
            } catch (ObjectCreateException e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(f247959d, 4, "role gray check error", e16);
                    return;
                }
                return;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f247959d, 4, "role gray check fail " + fromServiceMsg);
        }
    }

    private String a(int i3) {
        String beaconAppKey = BaseApplication.getContext().getMSFInterfaceAdapter().getBeaconAppKey();
        if (TextUtils.isEmpty(o.k())) {
            return a(QimeiSDK.getInstance(beaconAppKey).getQimei().getQimei36(), i3);
        }
        return a(o.k(), i3);
    }

    private String a(String str, int i3) {
        if (!TextUtils.isEmpty(str) && str.length() >= 18) {
            QLog.d(f247959d, 1, "origin Qimei\uff1a", str);
            String lowerCase = str.toLowerCase();
            StringBuilder sb5 = new StringBuilder(i3);
            for (int i16 = 0; i16 < i3; i16++) {
                char charAt = lowerCase.charAt(i16);
                if (charAt >= 'a' && charAt <= 'z') {
                    sb5.append((charAt - 'a') % 10);
                } else {
                    sb5.append(charAt);
                }
            }
            String sb6 = sb5.toString();
            QLog.d(f247959d, 1, "Qimei to digit\uff1a", sb6);
            return sb6;
        }
        QLog.d(f247959d, 1, "[convertQimeiToDigit] qimei is null or length < 18: ", str);
        return "";
    }

    private void a(GrayUinCheckResp grayUinCheckResp, FromServiceMsg fromServiceMsg) {
        QLog.d(f247959d, 1, "[onRecvCheckRoleRespNew] notify gray check result to PROCESS_QQ");
        fromServiceMsg.setMsfCommand(MsfCommand.onGrayCheckFailed);
        MsfSdkUtils.addFromMsgProcessName(MsfSdkUtils.getMainProcessName(), fromServiceMsg);
        fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_RESP_GRAY_CHECK, grayUinCheckResp);
        MsfService.core.addRespToQuque(null, fromServiceMsg);
    }
}
