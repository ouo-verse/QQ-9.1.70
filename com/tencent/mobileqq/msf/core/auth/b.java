package com.tencent.mobileqq.msf.core.auth;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.wtlogin.MsfWtloginPrivacyListenerImpl;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: n, reason: collision with root package name */
    private static final String f247383n = "QQ";

    /* renamed from: o, reason: collision with root package name */
    private static final String f247384o = "MSF.C.AccountCenter";

    /* renamed from: p, reason: collision with root package name */
    private static final String f247385p = "key_account_head_";

    /* renamed from: q, reason: collision with root package name */
    private static final String f247386q = "__loginSdk_uinMapping";

    /* renamed from: r, reason: collision with root package name */
    public static final String f247387r = "grayCheck";

    /* renamed from: s, reason: collision with root package name */
    public static int f247388s = -1;

    /* renamed from: t, reason: collision with root package name */
    public static AtomicBoolean f247389t = null;

    /* renamed from: u, reason: collision with root package name */
    private static final String f247390u = "keys_accounts_invalid";

    /* renamed from: v, reason: collision with root package name */
    private static final String f247391v = "ban_msf_cache_sig";

    /* renamed from: w, reason: collision with root package name */
    private static final String f247392w = "accounts_invalid";

    /* renamed from: x, reason: collision with root package name */
    private static final String f247393x = "key_first_happen";

    /* renamed from: y, reason: collision with root package name */
    private static final String f247394y = "key_userid";

    /* renamed from: a, reason: collision with root package name */
    MsfCore f247395a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f247396b;

    /* renamed from: c, reason: collision with root package name */
    ConcurrentHashMap<String, com.tencent.mobileqq.msf.core.auth.a> f247397c;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, com.tencent.mobileqq.msf.core.auth.a> f247398d;

    /* renamed from: e, reason: collision with root package name */
    public c f247399e;

    /* renamed from: f, reason: collision with root package name */
    private String f247400f;

    /* renamed from: g, reason: collision with root package name */
    private final String f247401g;

    /* renamed from: h, reason: collision with root package name */
    public e f247402h;

    /* renamed from: i, reason: collision with root package name */
    public f f247403i;

    /* renamed from: j, reason: collision with root package name */
    public d f247404j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList<InterfaceC8070b> f247405k;

    /* renamed from: l, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.auth.api.a f247406l;

    /* renamed from: m, reason: collision with root package name */
    int f247407m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            HashMap hashMap = new HashMap();
            MMKVOptionEntity a16 = com.tencent.mobileqq.msf.core.b0.a.b().a();
            if (!a16.decodeBool(b.f247390u, false)) {
                a16.encodeBool(b.f247390u, true);
                hashMap.put(b.f247393x, "true");
            }
            String e16 = b.this.e();
            hashMap.put(b.f247394y, e16);
            BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(e16, b.f247392w, true, hashMap, false);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.auth.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC8070b {
        void a(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29484);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f247389t = new AtomicBoolean();
        }
    }

    public b(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f247396b = new ConcurrentHashMap<>();
        this.f247397c = new ConcurrentHashMap<>();
        this.f247398d = new ConcurrentHashMap<>();
        this.f247400f = "0";
        this.f247401g = "key_main_account";
        this.f247405k = new ArrayList<>();
        this.f247406l = new com.tencent.mobileqq.msf.core.auth.api.b.a();
        this.f247407m = 0;
        this.f247395a = msfCore;
        String config = MsfStore.getNativeConfigStore().getConfig("key_main_account");
        if (!TextUtils.isEmpty(config)) {
            this.f247400f = config;
        }
        this.f247402h = new e(this);
        this.f247403i = new f(this);
        this.f247404j = new d(this);
        this.f247399e = new c(this);
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        ArrayList<com.tencent.mobileqq.msf.core.auth.a> arrayList = new ArrayList<>();
        b(arrayList);
        Iterator<com.tencent.mobileqq.msf.core.auth.a> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.auth.a next = it.next();
            QLog.d(f247384o, 1, "add wt account: " + next.z());
            b(next);
            this.f247406l.c(next.z());
        }
        if (z16) {
            l();
        }
    }

    public void b(com.tencent.mobileqq.msf.core.auth.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        try {
            a(aVar);
            QLog.d(f247384o, 1, Thread.currentThread().getName() + " handleLoadedAccounts setKey " + MsfSdkUtils.getShortUin(aVar.z()));
            this.f247395a.setAccountKey(aVar.z(), 0, aVar.a(), aVar.b(), aVar.c(), aVar.g(), aVar.h(), aVar.v(), aVar.k(), aVar.e(), null);
            String config = MsfStore.getNativeConfigStore().getConfig("__loginSdk_uinMapping_" + aVar.z());
            if (config != null && config.length() > 0) {
                this.f247396b.put(aVar.z(), config);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f247384o, 2, "handle account " + aVar.z() + " logined:" + aVar.B() + " len:" + aVar.k().length);
            }
        } catch (Throwable th5) {
            QLog.w(f247384o, 1, "parse account error " + th5.toString(), th5);
        }
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList<SimpleAccount> i3 = i();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<SimpleAccount> it = i3.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toStoreString() + ";");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith(";") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }

    public long d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str)).longValue();
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null) {
            return 0L;
        }
        return b16.r();
    }

    public long e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str)).longValue();
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null) {
            return 0L;
        }
        return b16.s();
    }

    public long f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).longValue();
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null) {
            return 0L;
        }
        return b16.t();
    }

    public com.tencent.mobileqq.msf.core.auth.api.a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f247406l : (com.tencent.mobileqq.msf.core.auth.api.a) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    public ArrayList<String> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ArrayList) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = this.f247398d.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public ArrayList<SimpleAccount> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ArrayList) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        ArrayList<SimpleAccount> arrayList = new ArrayList<>();
        Iterator<String> it = this.f247398d.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.auth.a aVar = this.f247398d.get(it.next());
            if (aVar != null) {
                arrayList.add(aVar.w());
            }
        }
        return arrayList;
    }

    public boolean j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str)).booleanValue();
        }
        try {
            return Long.parseLong(str) > 10000;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.f247398d.size() > 0) {
            Iterator<String> it = this.f247398d.keySet().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.msf.core.auth.a aVar = this.f247398d.get(it.next());
                if (aVar != null && aVar.B() && aVar.n().equals("QQ")) {
                    try {
                        this.f247395a.getWtLoginCenter().a(aVar, false);
                    } catch (Throwable th5) {
                        QLog.d(f247384o, 1, "load " + MD5.toMD5(aVar.z()) + " set key to wt error " + th5, th5);
                    }
                }
            }
        }
    }

    public boolean l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        if (BaseApplication.getContext().getMSFInterfaceAdapter().useNtWtLogin()) {
            return false;
        }
        ArrayList<com.tencent.mobileqq.msf.core.auth.a> arrayList = new ArrayList<>();
        a(arrayList);
        Iterator<com.tencent.mobileqq.msf.core.auth.a> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.auth.a next = it.next();
            if (next.z().equals(str) && next.B()) {
                z16 = true;
            }
            b(next);
        }
        return z16;
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null) {
            return;
        }
        QLog.i(f247384o, 1, Thread.currentThread().getName() + " reloadKeys setKey " + MsfSdkUtils.getShortUin(b16.z()));
        this.f247395a.setAccountKey(b16.z(), 0, new byte[0], b16.b(), b16.c(), b16.g(), b16.h(), b16.v(), b16.k(), new byte[0], null);
    }

    public synchronized void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
            return;
        }
        if (this.f247400f.equals(str)) {
            d("0", "setNoLogin");
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 != null) {
            b16.a(false);
            o(str);
            this.f247395a.removeAccountKey(str);
        } else {
            QLog.w(f247384o, 1, "setAccountNoLogin can't founded any account, may be BUG");
            this.f247395a.removeAccountKey(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str) {
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        String C = b16.C();
        if (QLog.isDevelopLevel()) {
            QLog.d(f247384o, 4, "storeAccount uin:" + str);
        }
        MsfStore.getNativeConfigStore().n_setConfig(f247385p + b16.z(), C);
    }

    public long g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str)).longValue();
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null) {
            return 0L;
        }
        return b16.u();
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        Iterator<Map.Entry<String, com.tencent.mobileqq.msf.core.auth.a>> it = this.f247398d.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.auth.a value = it.next().getValue();
            if (value != null) {
                this.f247395a.setAccountKey(value.z(), 0, new byte[0], value.b(), value.c(), value.g(), value.h(), value.v(), value.k(), new byte[0], null);
                QLog.i(f247384o, 1, Thread.currentThread().getName() + " reloadAllKeys setKey " + MsfSdkUtils.getShortUin(value.z()));
            }
        }
    }

    public byte[] d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) ? util.get_ksid(BaseApplication.getContext()) : (byte[]) iPatchRedirector.redirect((short) 30, (Object) this);
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 42)) ? this.f247400f : (String) iPatchRedirector.redirect((short) 42, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f247407m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tencent.mobileqq.msf.core.auth.a d(com.tencent.mobileqq.msf.core.auth.a aVar) {
        com.tencent.mobileqq.msf.core.auth.a b16 = b(aVar.z());
        if (b16 == null) {
            c(aVar);
            return aVar;
        }
        if (aVar.b() != null && aVar.b().length > 0) {
            b16.b(aVar.b());
        }
        if (aVar.h() != null && aVar.h().length > 0) {
            b16.f(aVar.h());
        }
        if (aVar.k() != null && aVar.k().length > 0) {
            b16.g(aVar.k());
        }
        if (aVar.A() != null && aVar.A().length > 0) {
            b16.n(aVar.A());
        }
        if (aVar.x() != null && aVar.x().length > 0) {
            b16.l(aVar.x());
        }
        if (aVar.y() != null && aVar.y().length > 0) {
            b16.m(aVar.y());
        }
        if (aVar.n() != null && aVar.n().length() > 0) {
            b16.b(aVar.n());
        }
        c(b16);
        return b16;
    }

    public String h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) ? this.f247396b.get(str) : (String) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
    }

    public String i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        }
        for (Map.Entry<String, String> entry : this.f247396b.entrySet()) {
            String value = entry.getValue();
            if (value.equalsIgnoreCase(str) && j(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void l() {
        try {
            if (MsfSdkUtils.getNewAppUinStoreFile().exists()) {
                return;
            }
            for (Map.Entry<String, com.tencent.mobileqq.msf.core.auth.a> entry : this.f247398d.entrySet()) {
                if (entry.getValue().n().equals("QQ")) {
                    MsfSdkUtils.addSimpleAccount(entry.getValue().z());
                    if (entry.getValue().B()) {
                        MsfSdkUtils.updateSimpleAccount(entry.getValue().z(), true);
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f247384o, 2, "add simpleAccount store error " + e16, e16);
            }
        }
    }

    public boolean k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        return b16 != null && b16.B();
    }

    public void a(InterfaceC8070b interfaceC8070b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) interfaceC8070b);
        } else {
            if (interfaceC8070b == null) {
                return;
            }
            synchronized (this.f247405k) {
                this.f247405k.add(interfaceC8070b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, String str2) {
        if (str == null || str.equals(str2)) {
            return;
        }
        this.f247396b.put(str2, str);
        MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_uinMapping_" + str2, str);
        if (QLog.isColorLevel()) {
            QLog.d(f247384o, 2, "saveUinMapping src:" + str + " real:" + str2);
        }
    }

    private void a(ArrayList<com.tencent.mobileqq.msf.core.auth.a> arrayList) {
        List<WloginLoginInfo> GetAllLoginInfo = i.f247480n.GetAllLoginInfo();
        StringBuilder sb5 = new StringBuilder("loadAccountInfoFromWt");
        for (WloginLoginInfo wloginLoginInfo : GetAllLoginInfo) {
            try {
                String valueOf = String.valueOf(wloginLoginInfo.mUin);
                sb5.append(",uin=");
                sb5.append(MsfSdkUtils.getShortUin(valueOf));
                if (!i.f247480n.IsNeedLoginWithPasswd(valueOf, 16L).booleanValue()) {
                    WUserSigInfo GetLocalSig = i.f247480n.GetLocalSig(valueOf, 16L);
                    byte[] GetTicketSig = WtloginHelper.GetTicketSig(GetLocalSig, 64);
                    byte[] GetTicketSig2 = WtloginHelper.GetTicketSig(GetLocalSig, 262144);
                    byte[] GetTicketSigKey = WtloginHelper.GetTicketSigKey(GetLocalSig, 262144);
                    if (GetLocalSig != null && GetTicketSig != null && GetTicketSig.length != 0 && GetTicketSig2 != null && GetTicketSig2.length != 0 && GetTicketSigKey != null && GetTicketSigKey.length != 0) {
                        com.tencent.mobileqq.msf.core.auth.a aVar = new com.tencent.mobileqq.msf.core.auth.a(valueOf);
                        aVar.b(GetTicketSig);
                        aVar.f(GetTicketSig2);
                        byte[] bArr = new byte[16];
                        e.a(bArr, 0, GetTicketSigKey, GetTicketSigKey.length);
                        aVar.g(bArr);
                        aVar.l(WtloginHelper.GetTicketSig(GetLocalSig, 4096));
                        aVar.m(WtloginHelper.GetTicketSig(GetLocalSig, 32));
                        aVar.a(true);
                        aVar.a(System.currentTimeMillis());
                        long a16 = a(valueOf, 64);
                        long a17 = a(valueOf, 262144);
                        if (a16 > a17) {
                            a16 = a17;
                        }
                        aVar.b(a16);
                        aVar.c(a(valueOf, 524288));
                        long a18 = a(valueOf, 4096);
                        long a19 = a(valueOf, 32);
                        aVar.d(a18);
                        if (a18 > a19) {
                            a18 = a19;
                        }
                        aVar.e(a18);
                        if (wloginLoginInfo.mLoginBitmap == 0) {
                            aVar.b("QQ");
                        }
                        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
                        if (i.f247480n.GetBasicUserInfo(valueOf, wloginSimpleInfo).booleanValue()) {
                            byte[] bArr2 = wloginSimpleInfo._age;
                            if (bArr2 != null && bArr2.length > 0) {
                                aVar.a((int) bArr2[0]);
                            }
                            byte[] bArr3 = wloginSimpleInfo._nick;
                            if (bArr3 != null && bArr3.length > 0) {
                                aVar.j(bArr3);
                            }
                            byte[] bArr4 = wloginSimpleInfo._gender;
                            if (bArr4 != null && bArr4.length > 0) {
                                aVar.d(bArr4[0] == 1 ? 1 : 2);
                            }
                            byte[] bArr5 = wloginSimpleInfo._face;
                            if (bArr5 != null && bArr5.length > 0) {
                                aVar.c(util.buf_to_int16(bArr5, 0));
                            }
                        }
                        sb5.append(",isAlive=");
                        sb5.append(aVar.B());
                        sb5.append(",mLoginBitmap=");
                        sb5.append(wloginLoginInfo.mLoginBitmap);
                        try {
                            arrayList.add(aVar);
                        } catch (Throwable th5) {
                            th = th5;
                            QLog.i(f247384o, 1, "loadAccountInfoFromWt", th);
                        }
                    }
                    sb5.append(",invalid token");
                    sb5.append(",sigInfo=");
                    sb5.append(GetLocalSig == null);
                    MsfSdkUtils.printBytes(",_A2=", GetTicketSig, sb5);
                    MsfSdkUtils.printBytes(",_D2=", GetTicketSig2, sb5);
                    MsfSdkUtils.printBytes(",_D2_Key=", GetTicketSigKey, sb5);
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        QLog.i(f247384o, 1, sb5.toString());
    }

    void c(com.tencent.mobileqq.msf.core.auth.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        aVar.a(true);
        aVar.a(currentTimeMillis);
        QLog.d(f247384o, 1, Thread.currentThread().getName() + " storeAccount setKey " + MsfSdkUtils.getShortUin(aVar.z()));
        this.f247395a.setAccountKey(aVar.z(), 0, new byte[0], aVar.b(), aVar.c(), aVar.g(), aVar.h(), aVar.v(), aVar.k(), new byte[0], null);
        a(aVar);
        o(aVar.z());
    }

    public void b(ArrayList<com.tencent.mobileqq.msf.core.auth.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) arrayList);
            return;
        }
        MMKVOptionEntity a16 = com.tencent.mobileqq.msf.core.b0.a.b().a();
        a(arrayList);
        boolean z16 = BaseApplication.getContext() != null && BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn("106115", false);
        MMKVOptionEntity a17 = com.tencent.mobileqq.msf.core.b0.a.b().a();
        if (z16 && !arrayList.isEmpty()) {
            a17.encodeBool(f247391v, true);
        }
        if (!z16) {
            a17.encodeBool(f247391v, false);
        }
        if (arrayList.isEmpty() && !a17.decodeBool(f247391v, false)) {
            String[] n_getConfigList = MsfStore.getNativeConfigStore().n_getConfigList(f247385p);
            if (n_getConfigList != null && n_getConfigList.length > 0) {
                QLog.d(f247384o, 1, "try load accounts " + n_getConfigList.length);
                for (String str : n_getConfigList) {
                    try {
                        com.tencent.mobileqq.msf.core.auth.a a18 = com.tencent.mobileqq.msf.core.auth.a.a(str);
                        a18.b("QQ");
                        arrayList.add(a18);
                        if (QLog.isColorLevel()) {
                            QLog.d(f247384o, 2, "load account " + a18.z() + " logined:" + a18.B());
                        }
                    } catch (Throwable th5) {
                        QLog.w(f247384o, 1, "parse account error " + th5.toString(), th5);
                    }
                }
                q.s().postDelayed(new a(), 5000L);
                return;
            }
            a16.encodeBool(f247390u, false);
            return;
        }
        a16.encodeBool(f247390u, false);
    }

    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && !this.f247400f.equals(str)) {
            QLog.d(f247384o, 1, "setMainAccount from=" + MsfSdkUtils.getShortUin(this.f247400f) + " to=" + MsfSdkUtils.getShortUin(str) + " src: " + str2);
            this.f247400f = str;
            if (!"0".equals(str)) {
                this.f247404j.a(str);
            }
            MsfStore.getNativeConfigStore().setConfig("key_main_account", this.f247400f);
            Iterator<InterfaceC8070b> it = this.f247405k.iterator();
            while (it.hasNext()) {
                it.next().a(str);
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "setMainAccount: failed " + MsfSdkUtils.getShortUin(str));
        }
    }

    public int c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this, (Object) toServiceMsg)).intValue();
        }
        VerifyCodeInfo verifyCodeInfo = VerifyCodeInfo.getVerifyCodeInfo(toServiceMsg);
        toServiceMsg.putWupBuffer(this.f247402h.a(toServiceMsg.getAppId(), toServiceMsg.getUin(), (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_VERIFY_CODE), verifyCodeInfo));
        return this.f247395a.sendSsoMsg(toServiceMsg);
    }

    public String c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        return b16 != null ? b16.C() : "";
    }

    public boolean b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        QLog.d(f247384o, 1, "removeUser uin=" + MsfSdkUtils.getShortUin(str));
        a(str, str2);
        this.f247395a.removeAccountKey(str);
        QLog.d(f247384o, 1, "del user " + MsfSdkUtils.getShortUin(str) + " succ.");
        return true;
    }

    public void b(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null || Arrays.equals(b16.A(), bArr)) {
            return;
        }
        b16.n(bArr);
        o(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tencent.mobileqq.msf.core.auth.a b(String str) {
        return this.f247398d.get(str);
    }

    public int b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this, (Object) toServiceMsg)).intValue();
        }
        String str = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_LOGIN_CHANGEUIN);
        String uin = toServiceMsg.getUin();
        toServiceMsg.setUin(str);
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_LOGIN_CHANGEUIN, uin);
        HashMap<String, Object> hashMap = new HashMap<>();
        com.tencent.msf.service.protocol.security.e eVar = new com.tencent.msf.service.protocol.security.e();
        eVar.f336646b = 0;
        eVar.f336645a = 1;
        eVar.f336647c = new byte[0];
        hashMap.put("RequestNameExchangeUin", eVar);
        byte[] a16 = this.f247402h.a(toServiceMsg.getAppId(), toServiceMsg.getUin(), 13, hashMap);
        toServiceMsg.setServiceCmd(BaseConstants.CMD_LOGIN_CHANGEUIN_AUTH);
        toServiceMsg.putWupBuffer(a16);
        toServiceMsg.getAttributes().put(f247387r, Boolean.TRUE);
        this.f247395a.sendSsoMsg(toServiceMsg);
        return toServiceMsg.getRequestSsoSeq();
    }

    private long a(String str, int i3) {
        long currentTimeMillis;
        long j3;
        Ticket GetLocalTicket = i.f247480n.GetLocalTicket(str, 16L, i3);
        if (GetLocalTicket != null) {
            long j16 = GetLocalTicket._create_time * 1000;
            if (j16 > 0) {
                return j16;
            }
        }
        if (i3 != 64 && i3 != 262144 && i3 != 524288) {
            currentTimeMillis = System.currentTimeMillis();
            j3 = 21600000;
        } else {
            currentTimeMillis = System.currentTimeMillis();
            j3 = 604800000;
        }
        return currentTimeMillis - j3;
    }

    public int b(ToServiceMsg toServiceMsg, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, this, toServiceMsg, Boolean.valueOf(z16))).intValue();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        com.tencent.msf.service.protocol.security.f fVar = new com.tencent.msf.service.protocol.security.f();
        fVar.f336650a = b(toServiceMsg.getUin()).c();
        fVar.f336651b = "00".getBytes();
        hashMap.put("RequestReFetchSid", fVar);
        toServiceMsg.putWupBuffer(this.f247402h.a(toServiceMsg.getAppId(), toServiceMsg.getUin(), 6, hashMap));
        this.f247395a.sendSsoMsg(toServiceMsg);
        return toServiceMsg.getRequestSsoSeq();
    }

    public synchronized void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        if (!this.f247397c.containsKey(str)) {
            this.f247397c.put(str, new com.tencent.mobileqq.msf.core.auth.a(str));
        }
    }

    public void a(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, bArr, bArr2, bArr3, Long.valueOf(j3));
            return;
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null) {
            return;
        }
        b16.b(bArr);
        b16.f(bArr2);
        b16.g(bArr3);
        b16.b(j3);
        o(str);
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Map.Entry<String, com.tencent.mobileqq.msf.core.auth.a>> it = this.f247398d.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.auth.a value = it.next().getValue();
            stringBuffer.append("UIN=" + value.z() + ",LOGINED=" + value.B() + ",A2=" + HexUtil.bytes2HexStr(value.b()) + ",D2=" + HexUtil.bytes2HexStr(value.h()) + ",KEY=" + HexUtil.bytes2HexStr(value.k()));
            stringBuffer.append(";");
        }
        return stringBuffer.toString();
    }

    public void a(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, Long.valueOf(j3));
            return;
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null) {
            return;
        }
        b16.c(j3);
        o(str);
    }

    public void a(String str, byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, bArr, Long.valueOf(j3));
            return;
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null || Arrays.equals(b16.x(), bArr)) {
            return;
        }
        b16.l(bArr);
        b16.d(j3);
        o(str);
    }

    public void a(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null || Arrays.equals(b16.y(), bArr)) {
            return;
        }
        b16.m(bArr);
        o(str);
    }

    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Long.valueOf(j3));
            return;
        }
        com.tencent.mobileqq.msf.core.auth.a b16 = b(str);
        if (b16 == null) {
            return;
        }
        b16.e(j3);
        o(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, com.tencent.msf.service.protocol.security.k kVar) {
        c(str, kVar.f336667d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i3) {
        this.f247407m = i3;
        QLog.d(f247384o, 1, "set time interv is " + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.tencent.mobileqq.msf.core.auth.a aVar) {
        this.f247398d.put(aVar.z(), aVar);
    }

    private boolean a(String str, String str2) {
        boolean z16 = false;
        if (str == null || str.length() <= 0) {
            return false;
        }
        this.f247398d.remove(str);
        MsfStore.getNativeConfigStore().n_removeConfig(f247385p + str);
        MsfStore.getNativeConfigStore().n_removeConfig("__loginSdk_uinMapping_" + str);
        try {
            WtloginHelper wtloginHelper = new WtloginHelper((Context) BaseApplication.getContext(), (PrivacyListener) MsfWtloginPrivacyListenerImpl.getSingleton());
            z16 = wtloginHelper.ClearUserLoginData(str2, 16L).booleanValue() | wtloginHelper.ClearUserLoginData(str, 16L).booleanValue();
            QLog.d(f247384o, 1, "remove storeConfig and clear wtlogin user data uin=" + MsfSdkUtils.getShortUin(str) + " removed=" + z16);
            return z16;
        } catch (Throwable th5) {
            QLog.d(f247384o, 1, "del wttoken error " + th5);
            return z16;
        }
    }

    public int a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this, (Object) toServiceMsg)).intValue();
        }
        toServiceMsg.putWupBuffer(this.f247402h.a(toServiceMsg.getAppId(), toServiceMsg.getUin(), VerifyCodeInfo.getVerifyCodeInfo(toServiceMsg)));
        return this.f247395a.sendSsoMsg(toServiceMsg);
    }

    public int a(ToServiceMsg toServiceMsg, int i3, int i16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, this, toServiceMsg, Integer.valueOf(i3), Integer.valueOf(i16), bArr)).intValue();
        }
        toServiceMsg.putWupBuffer(this.f247402h.a(toServiceMsg.getAppId(), toServiceMsg.getUin(), (byte[]) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_LOGIN_PWD), i3, i16, bArr));
        toServiceMsg.getAttributes().put(f247387r, Boolean.TRUE);
        return this.f247395a.sendSsoMsg(toServiceMsg);
    }

    public int a(ToServiceMsg toServiceMsg, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, this, toServiceMsg, Boolean.valueOf(z16))).intValue();
        }
        byte[] a16 = this.f247402h.a(toServiceMsg.getAppId(), toServiceMsg.getUin(), ((Integer) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_LOGIN_TOKEN_CMDHEAD)).intValue(), (HashMap<String, Object>) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_LOGIN_TOKEN_MAP));
        toServiceMsg.setServiceCmd(BaseConstants.CMD_CHANGETOKEN);
        toServiceMsg.putWupBuffer(a16);
        this.f247395a.sendSsoMsg(toServiceMsg);
        return toServiceMsg.getRequestSsoSeq();
    }

    public ConcurrentHashMap<String, com.tencent.mobileqq.msf.core.auth.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) ? this.f247398d : (ConcurrentHashMap) iPatchRedirector.redirect((short) 36, (Object) this);
    }
}
