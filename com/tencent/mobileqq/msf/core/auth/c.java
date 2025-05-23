package com.tencent.mobileqq.msf.core.auth;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f247409c = "invalidPackageName";

    /* renamed from: d, reason: collision with root package name */
    static String f247410d = "AccountSyncManager";

    /* renamed from: e, reason: collision with root package name */
    static HashSet<Integer> f247411e = null;

    /* renamed from: f, reason: collision with root package name */
    static HashSet<Integer> f247412f = null;

    /* renamed from: g, reason: collision with root package name */
    private static final String f247413g = "checkSign_ReqUin";

    /* renamed from: a, reason: collision with root package name */
    b f247414a;

    /* renamed from: b, reason: collision with root package name */
    private final String f247415b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29209);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f247411e = new HashSet<>();
            f247412f = new HashSet<>();
        }
    }

    public c(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f247415b = "arrtibute_uid";
            this.f247414a = bVar;
        }
    }

    public static Signature[] a(PackageManager packageManager, int i3) {
        try {
            return a(packageManager, packageManager.getPackagesForUid(i3));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Signature[] a(PackageManager packageManager, String[] strArr) {
        try {
            for (String str : strArr) {
                try {
                    Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(packageManager, str, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        return signatureArr;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void a(ToServiceMsg toServiceMsg, String[] strArr, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, strArr, str, Integer.valueOf(i3));
            return;
        }
        if (f247412f.contains(Integer.valueOf(i3))) {
            return;
        }
        if (f247411e.contains(Integer.valueOf(i3))) {
            a(toServiceMsg);
            return;
        }
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                QLog.d(f247410d, 2, "found accountSyncRequest from the same packeName application,");
                f247411e.add(Integer.valueOf(i3));
                a(toServiceMsg);
                return;
            }
        }
        String str3 = "";
        for (String str4 : strArr) {
            str3 = str3 + " " + str4 + ";";
        }
        toServiceMsg.addAttribute(f247409c, str3);
        a(toServiceMsg, i3);
    }

    private void a(ToServiceMsg toServiceMsg, int i3) {
        Signature[] a16 = a(BaseApplication.getContext().getPackageManager(), i3);
        if (a16 == null || a16.length <= 0) {
            return;
        }
        int length = a16.length;
        String[] strArr = new String[length];
        for (int i16 = 0; i16 < a16.length; i16++) {
            strArr[i16] = MD5.toMD5(a16[i16].toCharsString()).toLowerCase();
        }
        toServiceMsg.addAttribute("arrtibute_uid", Integer.valueOf(i3));
        com.tencent.msf.service.protocol.kqqconfig.f fVar = new com.tencent.msf.service.protocol.kqqconfig.f();
        fVar.f336504a = new ArrayList<>();
        for (int i17 = 0; i17 < length; i17++) {
            fVar.f336504a.add(strArr[i17]);
        }
        ArrayList<SimpleAccount> i18 = this.f247414a.i();
        if (i18 != null) {
            fVar.f336506c = new ArrayList<>();
            Iterator<SimpleAccount> it = i18.iterator();
            while (it.hasNext()) {
                fVar.f336506c.add(it.next().getUin());
            }
        }
        fVar.f336507d = (byte) 1;
        fVar.f336505b = toServiceMsg.getAppId();
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setServantName("t");
        uniPacket.setFuncName("t");
        uniPacket.put("req", fVar);
        toServiceMsg.putWupBuffer(uniPacket.encode());
        toServiceMsg.setServiceCmd(BaseConstants.CMD_REQ_CHECKSIGNATURE);
        toServiceMsg.addAttribute(f247413g, toServiceMsg.getUin());
        toServiceMsg.setUin("0");
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.setTimeout(60000L);
        toServiceMsg.setMsfCommand(MsfCommand.accountTokenSyncCheckSign);
        this.f247414a.f247395a.sendSsoMsg(toServiceMsg);
    }

    private void a(ToServiceMsg toServiceMsg) {
        QLog.d(f247410d, 2, "received accountSyncReq " + toServiceMsg);
        String c16 = this.f247414a.c(toServiceMsg.getUin());
        FromServiceMsg fromServiceMsg = new FromServiceMsg(toServiceMsg.getUin(), toServiceMsg.getServiceCmd());
        fromServiceMsg.addAttribute(toServiceMsg.getServiceCmd(), c16);
        fromServiceMsg.addAttribute(BaseConstants.CMD_SYNC_SYNCUSER_SERVICE, "");
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setFromVersion((byte) 0);
        try {
            toServiceMsg.actionListener.onActionResult(fromServiceMsg);
        } catch (Exception e16) {
            QLog.w(f247410d, 2, "send account sync resp error", e16);
        }
    }

    private void a(ToServiceMsg toServiceMsg, int i3, String str) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(toServiceMsg.getUin(), toServiceMsg.getServiceCmd());
        fromServiceMsg.addAttribute(toServiceMsg.getServiceCmd(), "");
        fromServiceMsg.addAttribute(BaseConstants.CMD_SYNC_SYNCUSER_SERVICE, "");
        fromServiceMsg.setBusinessFail(i3, str);
        fromServiceMsg.setFromVersion((byte) 0);
        try {
            toServiceMsg.actionListener.onActionResult(fromServiceMsg);
        } catch (Exception e16) {
            QLog.w(f247410d, 2, "send account sync resp error", e16);
        }
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.decode(wupBuffer);
            com.tencent.msf.service.protocol.kqqconfig.g gVar = (com.tencent.msf.service.protocol.kqqconfig.g) uniPacket.getByClass("res", new com.tencent.msf.service.protocol.kqqconfig.g());
            int intValue = ((Integer) toServiceMsg.getAttribute("arrtibute_uid")).intValue();
            QLog.d(f247410d, 2, intValue + "role " + gVar.f336509a);
            toServiceMsg.setUin((String) toServiceMsg.getAttribute(f247413g));
            if (gVar.f336509a == 1) {
                f247411e.add(Integer.valueOf(intValue));
                a(toServiceMsg);
                return;
            }
            a(toServiceMsg, 2014, "signError");
            f247412f.add(Integer.valueOf(intValue));
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247805h, (String) toServiceMsg.getAttribute(f247409c, ""));
                hashMap.put("method", "accountSync");
                if (this.f247414a.f247395a.getStatReporter() != null) {
                    this.f247414a.f247395a.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247776z, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.d(f247410d, 2, "send invaild call error " + e16, e16);
                return;
            }
        }
        if (fromServiceMsg.getResultCode() == 1002) {
            a(toServiceMsg, 1002, "timeout");
        }
    }
}
