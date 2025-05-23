package com.tencent.mobileqq.msf.core.auth;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f247416b = "MSF.C.TokenChecker";

    /* renamed from: c, reason: collision with root package name */
    public static final int f247417c = 604800000;

    /* renamed from: d, reason: collision with root package name */
    public static final int f247418d = 21600000;

    /* renamed from: e, reason: collision with root package name */
    private static final String f247419e = "_lastchecktokentime";

    /* renamed from: f, reason: collision with root package name */
    public static final int f247420f = 1800000;

    /* renamed from: g, reason: collision with root package name */
    public static final int f247421g = 1000;

    /* renamed from: h, reason: collision with root package name */
    private static final int f247422h = 1800000;

    /* renamed from: i, reason: collision with root package name */
    public static final String f247423i = "wtlogin_get_sig_by_msf";

    /* renamed from: j, reason: collision with root package name */
    public static final String f247424j = "changeToken";

    /* renamed from: k, reason: collision with root package name */
    public static final String f247425k = "101462";

    /* renamed from: l, reason: collision with root package name */
    public static final String f247426l = "wtlogin_refresh_sig_delay";

    /* renamed from: m, reason: collision with root package name */
    private static long f247427m = -1;

    /* renamed from: n, reason: collision with root package name */
    private static int f247428n = 5;

    /* renamed from: o, reason: collision with root package name */
    public static ConcurrentHashMap<String, Boolean> f247429o = null;

    /* renamed from: p, reason: collision with root package name */
    public static final String f247430p = "_new_version_never_change_token";

    /* renamed from: q, reason: collision with root package name */
    public static boolean f247431q;

    /* renamed from: r, reason: collision with root package name */
    private static Handler f247432r;

    /* renamed from: a, reason: collision with root package name */
    com.tencent.mobileqq.msf.core.auth.b f247433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                d.this.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Comparator<SimpleAccount> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SimpleAccount simpleAccount, SimpleAccount simpleAccount2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) simpleAccount, (Object) simpleAccount2)).intValue();
            }
            if (Long.parseLong(simpleAccount2.getAttribute(SimpleAccount._LOGINTIME, "0")) > Long.parseLong(simpleAccount.getAttribute(SimpleAccount._LOGINTIME, "0"))) {
                return 1;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f247436a;

        c(String str) {
            this.f247436a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ToServiceMsg toServiceMsg = new ToServiceMsg("", this.f247436a, BaseConstants.CMD_CHANGETOKEN_A2D2);
            toServiceMsg.setMsfCommand(MsfCommand._msf_refreToken);
            toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_LOGIN_TOKEN_CMDHEAD, 9);
            toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REFRESH_TICKET_SRC, "AccountTokenChecker");
            toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
            toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg.setTimeout(30000L);
            HashMap hashMap = new HashMap();
            RequestCustomSig requestCustomSig = new RequestCustomSig();
            requestCustomSig.ulCustumFlag = 34869344L;
            requestCustomSig.reserved = new byte[0];
            hashMap.put(com.tencent.mobileqq.msf.core.auth.e.f247453m, requestCustomSig);
            toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_LOGIN_TOKEN_MAP, hashMap);
            d.this.f247433a.f247395a.changeTokenAfterLogin(toServiceMsg, true, "changeMainKey");
            QLog.d(d.f247416b, 1, "checkToken renew A/D for " + MsfSdkUtils.getShortUin(this.f247436a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.auth.d$d, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class RunnableC8071d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f247438a;

        RunnableC8071d(String str) {
            this.f247438a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            boolean z16 = false;
            if (d.this.f() && BaseApplication.getContext() != null && BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn("105553", false)) {
                long e16 = d.this.e();
                if (new Random().nextInt(100) == 1) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("delayTime", String.valueOf(e16));
                    hashMap.put(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, String.valueOf(System.currentTimeMillis()));
                    BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(this.f247438a, d.f247426l, true, hashMap, false);
                }
                QLog.d(d.f247416b, 1, "delay again in midnight, delayTime = " + e16);
                d.f247432r.postDelayed(this, e16);
                return;
            }
            Iterator<SimpleAccount> it = d.this.f247433a.i().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleAccount next = it.next();
                if (this.f247438a.equals(next.getUin()) && next.isLogined()) {
                    z16 = true;
                    break;
                }
            }
            if (!z16) {
                QLog.w(d.f247416b, 1, "skip removed uin: " + MsfSdkUtils.getShortUin(this.f247438a));
                return;
            }
            ToServiceMsg toServiceMsg = new ToServiceMsg("", this.f247438a, BaseConstants.CMD_CHANGETOKEN_WEBVIEW_KEY);
            toServiceMsg.setMsfCommand(MsfCommand._msf_refreToken);
            toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
            toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg.setTimeout(30000L);
            toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REFRESH_TICKET_SRC, "AccountTokenChecker");
            d.this.f247433a.f247395a.changeTokenAfterLogin(toServiceMsg, true, "changeWebKey");
            QLog.d(d.f247416b, 1, "refresh webKey indeed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f247440a;

        e(String str) {
            this.f247440a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) str);
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
            long currentTimeMillis = System.currentTimeMillis();
            long c16 = d.this.c(this.f247440a);
            long X0 = com.tencent.mobileqq.msf.core.x.b.X0();
            if (X0 <= 0) {
                X0 = 21600000;
            }
            long d16 = X0 + d.this.d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("changeWebkeyByAccount for ");
            sb5.append(MsfSdkUtils.getShortUin(this.f247440a));
            sb5.append(" now: ");
            sb5.append(currentTimeMillis);
            sb5.append(" lastCheckWebviewKeyTime: ");
            sb5.append(c16);
            sb5.append(" interval: ");
            long j3 = currentTimeMillis - c16;
            sb5.append(j3);
            sb5.append(" needChangeToken: ");
            if (j3 > d16) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(d.f247416b, 1, sb5.toString());
            if (j3 > d16 || d.this.f247433a.f247395a.getWtLoginCenter().c(this.f247440a)) {
                ToServiceMsg toServiceMsg = new ToServiceMsg("", this.f247440a, BaseConstants.CMD_CHANGETOKEN_WEBVIEW_KEY);
                toServiceMsg.setMsfCommand(MsfCommand._msf_refreToken);
                toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
                toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
                toServiceMsg.setTimeout(30000L);
                toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REFRESH_TICKET_SRC, "AccountTokenChecker");
                d.this.f247433a.f247395a.changeTokenAfterLogin(toServiceMsg, true, "changeWebkeyByAccount");
                QLog.d(d.f247416b, 1, "changeWebkeyByAccount for " + MsfSdkUtils.getShortUin(this.f247440a) + " renew webKey");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28995);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f247429o = new ConcurrentHashMap<>();
            f247431q = true;
        }
    }

    public d(com.tencent.mobileqq.msf.core.auth.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f247433a = bVar;
        f247432r = q.q();
        boolean z16 = !TextUtils.isEmpty(MsfStore.getNativeConfigStore().getConfig(f247430p));
        f247431q = z16;
        if (!z16) {
            MsfStore.getNativeConfigStore().n_setConfig(f247419e, String.valueOf(0));
        }
        QLog.d(f247416b, 1, "msf init ct");
    }

    private long d(String str) {
        long b16 = this.f247433a.f247395a.getWtLoginCenter().b(str, 4096);
        long b17 = this.f247433a.f247395a.getWtLoginCenter().b(str, 32);
        long b18 = this.f247433a.f247395a.getWtLoginCenter().b(str, 1048576);
        if (b16 > b17) {
            b16 = b17;
        }
        return b16 > b18 ? b18 : b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long e() {
        long j3;
        try {
            j3 = new Random(SystemClock.elapsedRealtime()).nextInt(1800000);
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f247416b, 4, "WebRandomRevise: " + j3);
        }
        return j3;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = f247427m;
        if (j3 == -1) {
            String config = MsfStore.getNativeConfigStore().getConfig(f247419e);
            if (config != null) {
                long parseLong = Long.parseLong(config);
                f247427m = parseLong;
                if (currentTimeMillis >= parseLong && currentTimeMillis - parseLong < com.tencent.mobileqq.msf.core.x.b.q()) {
                    return;
                }
            }
        } else if (currentTimeMillis >= j3 && currentTimeMillis - j3 < com.tencent.mobileqq.msf.core.x.b.q()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f247416b, 2, "doCheck, lastCheckTime=" + f247427m + ", now=" + currentTimeMillis);
        }
        f247427m = currentTimeMillis;
        MsfStore.getNativeConfigStore().n_setConfig(f247419e, String.valueOf(currentTimeMillis));
        g();
    }

    boolean f() {
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(11);
        int i16 = calendar.get(12);
        if (i3 == 23 && i16 >= 58) {
            return true;
        }
        if (i3 == 0 && i16 <= 3) {
            return true;
        }
        return false;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            f247432r.post(new a());
        }
    }

    void b() {
        char c16;
        String str;
        int i3;
        char c17;
        String str2;
        boolean z16;
        long j3;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<SimpleAccount> i16 = this.f247433a.i();
        ArrayList<SimpleAccount> arrayList = new ArrayList<>();
        boolean b16 = com.tencent.mobileqq.msf.core.x.b.b1();
        int i17 = 2;
        String str3 = f247416b;
        char c18 = 0;
        if (b16) {
            Iterator<SimpleAccount> it = i16.iterator();
            SimpleAccount simpleAccount = null;
            while (it.hasNext()) {
                SimpleAccount next = it.next();
                if (next.isLogined()) {
                    arrayList.add(next);
                }
                if (next.getUin().equals(this.f247433a.e())) {
                    simpleAccount = next;
                }
            }
            if (arrayList.size() > 0) {
                Collections.sort(arrayList, new b());
                int size = arrayList.size();
                int i18 = f247428n;
                i16 = size > i18 ? arrayList.subList(0, i18) : arrayList;
                if (simpleAccount != null && !i16.contains(simpleAccount)) {
                    i16.remove(i16.size() - 1);
                    i16.add(simpleAccount);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(f247416b, 2, "checkToken, no active account");
                    return;
                }
                return;
            }
        }
        boolean isSwitchOn = BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f247425k, false);
        Iterator<SimpleAccount> it5 = i16.iterator();
        while (it5.hasNext()) {
            String uin = it5.next().getUin();
            if (this.f247433a.k(uin)) {
                long b17 = b(uin);
                long k3 = com.tencent.mobileqq.msf.core.x.b.k();
                if (k3 <= 0) {
                    k3 = 604800000;
                }
                long d16 = k3 + d();
                boolean booleanValue = i.f247480n.IsNeedLoginWithPasswd(uin, 16L).booleanValue();
                Object[] objArr = new Object[i17];
                objArr[c18] = "checkToken wtSigLost = " + booleanValue;
                objArr[1] = " changeTokenIfSigLost = " + isSwitchOn;
                QLog.d(str3, 1, objArr);
                if (booleanValue) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(f247424j, String.valueOf(isSwitchOn));
                    z16 = booleanValue;
                    str2 = str3;
                    j3 = 16;
                    BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(uin, f247423i, true, hashMap, false);
                } else {
                    str2 = str3;
                    z16 = booleanValue;
                    j3 = 16;
                }
                if (currentTimeMillis - b17 > d16 || (isSwitchOn && z16)) {
                    f247432r.postDelayed(new c(uin), e());
                    c17 = 1;
                } else {
                    c17 = c18;
                }
                long d17 = d(uin);
                long c19 = c(uin);
                long X0 = com.tencent.mobileqq.msf.core.x.b.X0();
                if (X0 <= 0) {
                    X0 = 21600000;
                }
                boolean z17 = !f247431q || currentTimeMillis - c19 > X0 || this.f247433a.f247395a.getWtLoginCenter().c(uin) || (TextUtils.isEmpty(l.a(uin)) && !i.f247480n.IsNeedLoginWithPasswd(uin, j3).booleanValue());
                i.f247480n.SetUinDeviceToken(true);
                str = str2;
                QLog.d(str, 1, "checkToken for " + MsfSdkUtils.getShortUin(uin) + " now: " + currentTimeMillis + " lastCheckWebviewKeyTime: " + c19 + " needChangeToken: " + z17 + " isInstant:" + (currentTimeMillis > d17 - 1800000));
                if (z17) {
                    RunnableC8071d runnableC8071d = new RunnableC8071d(uin);
                    long e16 = e();
                    f247432r.postDelayed(runnableC8071d, e16);
                    c16 = 0;
                    i3 = 2;
                    QLog.d(str, 1, "checkToken renew webKey for ", MsfSdkUtils.getShortUin(uin), " isNewVersion: ", Boolean.valueOf(f247431q), " delayTime: ", Long.valueOf(e16));
                } else {
                    i3 = 2;
                    c16 = 0;
                }
            } else {
                c16 = c18;
                str = str3;
                i3 = i17;
                c17 = c16;
            }
            if (c17 != 0) {
                try {
                    LockMethodProxy.sleep(com.tencent.mobileqq.msf.core.x.b.p());
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            i17 = i3;
            str3 = str;
            c18 = c16;
        }
        f247431q = true;
        MsfStore.getNativeConfigStore().n_setConfig(f247430p, String.valueOf(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long d() {
        long j3;
        try {
            j3 = new Random(SystemClock.elapsedRealtime()).nextInt(1800000) - 900000;
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f247416b, 4, "RandomRevise: " + j3);
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (this.f247433a.k(str)) {
            long e16 = e();
            if (BaseApplication.getContext() != null && BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn("102811", false)) {
                e16 = 0;
            }
            q.q().postDelayed(new e(str), e16);
        }
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (toServiceMsg == null || fromServiceMsg == null) {
            return;
        }
        String uin = fromServiceMsg.getUin();
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (!fromServiceMsg.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.w(f247416b, 2, "onChangeTokenResult fail, uin=" + uin + ", errorcode=" + fromServiceMsg.getBusinessFailCode());
                return;
            }
            return;
        }
        if (serviceCmd.equals(BaseConstants.CMD_CHANGETOKEN_A2D2)) {
            RespondCustomSig respondCustomSig = (RespondCustomSig) fromServiceMsg.getAttribute(fromServiceMsg.getServiceCmd());
            if (respondCustomSig != null) {
                Iterator<CustomSigContent> it = respondCustomSig.SigList.iterator();
                byte[] bArr = null;
                byte[] bArr2 = null;
                byte[] bArr3 = null;
                while (it.hasNext()) {
                    CustomSigContent next = it.next();
                    if (QLog.isColorLevel()) {
                        QLog.d(f247416b, 2, "onChangeTokenResult, content.ulSigType=" + next.ulSigType + ", uin=" + uin);
                    }
                    QLog.d(f247416b, 1, "iSimplified for " + MsfSdkUtils.getShortUin(uin));
                    long j3 = next.ulSigType;
                    if (j3 == 0) {
                        bArr = next.SigContent;
                    } else if (j3 == 18) {
                        bArr2 = next.SigContent;
                    } else if (j3 == 20) {
                        bArr3 = next.SigContent;
                    }
                }
                if (bArr == null || bArr2 == null || bArr3 == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f247433a.b(uin).r() > 1800000) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f247416b, 2, "renew A2 D2 succ, uin=" + uin);
                    }
                    this.f247433a.a(uin, bArr, bArr2, bArr3, currentTimeMillis);
                    if (com.tencent.mobileqq.msf.core.x.b.i1()) {
                        QLog.d(f247416b, 1, "reloadkey add uin:" + MsfSdkUtils.getShortUin(uin));
                        f247429o.put(uin, Boolean.TRUE);
                        return;
                    }
                    QLog.d(f247416b, 1, "give up reloading key for uin:" + MsfSdkUtils.getShortUin(uin));
                    return;
                }
                return;
            }
            return;
        }
        if (serviceCmd.equals(BaseConstants.CMD_CHANGETOKEN_WEBVIEW_KEY)) {
            QLog.d(f247416b, 1, "RENEW webview key succ for " + MsfSdkUtils.getShortUin(uin));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c(String str) {
        long a16 = this.f247433a.f247395a.getWtLoginCenter().a(str, 4096);
        long a17 = this.f247433a.f247395a.getWtLoginCenter().a(str, 32);
        long a18 = this.f247433a.f247395a.getWtLoginCenter().a(str, 1048576);
        if (a16 > a17) {
            a16 = a17;
        }
        return a16 > a18 ? a18 : a16;
    }

    private long b(String str) {
        long a16 = this.f247433a.f247395a.getWtLoginCenter().a(str, 64);
        long a17 = this.f247433a.f247395a.getWtLoginCenter().a(str, 262144);
        return a16 > a17 ? a17 : a16;
    }
}
