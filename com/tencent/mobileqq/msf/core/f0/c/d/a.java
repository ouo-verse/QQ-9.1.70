package com.tencent.mobileqq.msf.core.f0.c.d;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: i, reason: collision with root package name */
    public static final String f248085i = "MSF.C.MSFNetworkStateAdapter";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248086j = "http://sqimg.qq.com/qq_product_operations/nettest/index.html";

    /* renamed from: a, reason: collision with root package name */
    private String f248087a;

    /* renamed from: b, reason: collision with root package name */
    private int f248088b;

    /* renamed from: c, reason: collision with root package name */
    private int f248089c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f248090d;

    /* renamed from: e, reason: collision with root package name */
    private String f248091e;

    /* renamed from: f, reason: collision with root package name */
    private int f248092f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f248093g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicInteger f248094h;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248087a = ":";
        this.f248088b = 0;
        this.f248089c = 0;
        this.f248090d = false;
        this.f248091e = "";
        this.f248092f = 0;
        this.f248093g = new AtomicBoolean(false);
        this.f248094h = new AtomicInteger(0);
    }

    private int b(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        return i3 == 3 ? 3 : 0;
    }

    private int d(int i3) {
        int i16 = (i3 & 1) != 0 ? 1 : 0;
        if ((i3 & 2) != 0) {
            i16 |= 2;
        }
        if ((i3 & 4) != 0) {
            i16 |= 8;
        }
        if ((i3 & 8) != 0) {
            i16 |= 4;
        }
        return (i3 & 16) != 0 ? i16 | 32 : i16;
    }

    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, i3)).intValue();
        }
        if (i3 == 1) {
            return 1;
        }
        return i3 == 2 ? 2 : 0;
    }

    public int c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, i3)).intValue();
        }
        if (i3 == 1) {
            return 2;
        }
        return (i3 == 2 || i3 == 3) ? 1 : 0;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f248088b : ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f248087a = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f248088b = i3;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f248093g.get();
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.f248090d = false;
        g(0);
        f(":");
        e(0);
        NetConnInfoCenter.onConnClosed(com.tencent.qphone.base.a.closeByMSFCore);
        if (NetConnInfoCenter.isNetSupport()) {
            NetConnInfoCenter.setNetSupport(false);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            NetConnInfoCenter.onOepnConnAllFailed();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            QLog.d(f248085i, 1, "onStartConnect");
            NetConnInfoCenter.onStartConnect();
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        QLog.d(f248085i, 1, "WIFI detect result, WIFI_NEED_AUTH");
        String str = f248086j + a(f248086j);
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), MsfService.getCore().getNextSeq(), "0", BaseConstants.CMD_NETNEEDSIGNON);
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setMsfCommand(MsfCommand.onNetNeedSignon);
        fromServiceMsg.addAttribute("signonurl", str);
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        NetConnInfoCenter.msfCore.addRespToQuque(null, fromServiceMsg);
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? c(NetConnInfoCenter.getActiveNetworkType()) : ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f248089c : ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.f248091e : (String) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? this.f248092f : ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f248089c = i3;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248087a : (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.f248090d : ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
    }

    public int a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? b(NetConnInfoCenter.getActiveNetIpFamily(z16)) : ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, z16)).intValue();
    }

    public boolean b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) ? (TextUtils.isEmpty(str) || str.equals(BaseConstants.UNKNOWN_SSID_STRING)) ? false : true : ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str)).booleanValue();
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f248085i, 2, "onConnOpened, server:" + str);
        } else {
            QLog.d(f248085i, 1, "onConnOpened, server=" + com.tencent.mobileqq.msf.core.z.a.a(str));
        }
        f(str);
        g(NetConnInfoCenter.getSystemNetworkType());
        e(NetConnInfoCenter.getActiveNetworkType());
        NetConnInfoCenter.onConnOpened();
        if (NetConnInfoCenter.isNetSupport()) {
            return;
        }
        NetConnInfoCenter.setNetSupport(true);
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f248085i, 2, "onPingReceive, GatewayIp:" + str);
        } else {
            QLog.d(f248085i, 1, "onPingReceive, GatewayIp=" + com.tencent.mobileqq.msf.core.z.a.a(str));
        }
        this.f248090d = true;
        e(str);
        NetConnInfoCenter.setGateWayIp(str);
        NetConnInfoCenter.onRecvFirstResp(str);
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.f248091e = str;
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            this.f248092f = i3;
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
    }

    private void b(boolean z16, int i3) {
        Intent intent = new Intent("com.tencent.mobileqq.msf.bd.weaknetchange");
        intent.putExtra(BaseConstants.INTENT_KEY_IS_WEAK_NET, z16);
        intent.putExtra(BaseConstants.INTENT_KEY_WEAK_NET_STATUS_CHANGE_REASON, i3);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        BaseApplication.getContext().sendBroadcast(intent);
        QLog.d(f248085i, 1, "send weakNet status change broadcast, isWeakNet: " + z16 + ", reason: " + i3);
    }

    public void a(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        int i16 = this.f248094h.get();
        int d16 = d(i3);
        if (i16 == 0 && d16 != 0) {
            b(z16, d16);
            QLog.i(f248085i, 1, " WeakNetChanged isBadNet: " + z16 + ", Normal to WeakNet, reason:(" + Integer.toHexString(i16) + ", " + Integer.toHexString(d16) + ")");
        } else if (i16 != 0 && d16 == 0) {
            b(z16, i16);
            QLog.i(f248085i, 1, " WeakNetChanged isBadNet: " + z16 + ", WeakNet to Normal, reason:(" + Integer.toHexString(i16) + ", " + Integer.toHexString(d16) + ")");
        }
        this.f248094h.set(d16);
    }

    private String a(String str) {
        String str2 = "r=" + String.valueOf(new Random(System.currentTimeMillis()).nextInt(100000));
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            if (str.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str + str2;
            }
            return str2 + ContainerUtils.FIELD_DELIMITER + str2;
        }
        return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
    }
}
