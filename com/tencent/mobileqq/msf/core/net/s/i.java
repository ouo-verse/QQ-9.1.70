package com.tencent.mobileqq.msf.core.net.s;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.m;
import com.tencent.mobileqq.msf.core.net.s.a;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i extends k {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: l, reason: collision with root package name */
    private static final String f249103l = "WifiDetector";

    /* renamed from: m, reason: collision with root package name */
    public static final int f249104m = 0;

    /* renamed from: n, reason: collision with root package name */
    public static final int f249105n = -1;

    /* renamed from: o, reason: collision with root package name */
    public static final int f249106o = -2;

    /* renamed from: p, reason: collision with root package name */
    public static final int f249107p = -3;

    /* renamed from: q, reason: collision with root package name */
    public static final int f249108q = -4;

    /* renamed from: r, reason: collision with root package name */
    private static final String f249109r = "_wifi_detect_history";

    /* renamed from: s, reason: collision with root package name */
    private static final long f249110s = 7200000;

    /* renamed from: t, reason: collision with root package name */
    private static final long f249111t = 10000;

    /* renamed from: u, reason: collision with root package name */
    private static final long f249112u = 30000;

    /* renamed from: v, reason: collision with root package name */
    private static final long f249113v = 86400000;

    /* renamed from: w, reason: collision with root package name */
    private static final long f249114w = 5;

    /* renamed from: x, reason: collision with root package name */
    private static final int f249115x = 1000;

    /* renamed from: b, reason: collision with root package name */
    private MsfCore f249116b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.d.a f249117c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f249118d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f249119e;

    /* renamed from: f, reason: collision with root package name */
    private int f249120f;

    /* renamed from: g, reason: collision with root package name */
    private String f249121g;

    /* renamed from: h, reason: collision with root package name */
    private String f249122h;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, j> f249123i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f249124j;

    /* renamed from: k, reason: collision with root package name */
    private final a.InterfaceC8088a f249125k;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1000) {
                String str = (String) message.obj;
                QLog.d(i.f249103l, 1, "WIFI detect delayed try!");
                i.this.d(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements a.InterfaceC8088a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.s.a.InterfaceC8088a
        public void a(com.tencent.mobileqq.msf.core.net.s.a aVar, int i3, int i16, String str, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, aVar, Integer.valueOf(i3), Integer.valueOf(i16), str, obj);
                return;
            }
            if (str != null && str.length() > 10) {
                str = str.substring(0, 10);
            }
            if (QLog.isColorLevel()) {
                QLog.d(i.f249103l, 2, "WIFI detect onEchoResult, taskId: " + i3 + " result: " + i16 + " actualContent: " + str);
            }
            i.this.a(i.this.a(i16), (String) obj);
            i.b(i.this, 1 << i3);
            if (i.this.f249119e == 0) {
                i.this.c((String) aVar.f249041c);
            }
        }
    }

    public i(MsfCore msfCore, com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore, (Object) aVar);
            return;
        }
        this.f249118d = new AtomicBoolean(false);
        this.f249119e = 0;
        this.f249120f = -1;
        this.f249123i = new ConcurrentHashMap<>();
        this.f249124j = new a();
        this.f249125k = new b();
        this.f249116b = msfCore;
        this.f249117c = aVar;
        e();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i3) {
        if (i3 != -3) {
            return i3 != 0 ? -1 : 0;
        }
        return -2;
    }

    static /* synthetic */ int b(i iVar, int i3) {
        int i16 = iVar.f249119e - i3;
        iVar.f249119e = i16;
        return i16;
    }

    private void d() {
        if (NetConnInfoCenter.isWifiConn() && b(NetConnInfoCenter.getLastWifiSSID())) {
            a(NetConnInfoCenter.getLastWifiSSID(), 0);
        }
    }

    private void e() {
        String config = MsfStore.getNativeConfigStore().getConfig(f249109r);
        try {
            if (TextUtils.isEmpty(config)) {
                return;
            }
            for (String str : config.split("#&#")) {
                j a16 = j.a(str);
                if (a16 != null) {
                    this.f249123i.put(a16.f249128a, a16);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void f() {
        this.f249118d.set(false);
        this.f249119e = 0;
        this.f249120f = -1;
        this.f249121g = null;
        this.f249122h = "";
    }

    @Override // com.tencent.mobileqq.msf.core.net.s.k
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.d(f249103l, 1, "WIFI detect onWifiDisconnected!");
            this.f249124j.removeMessages(1000);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.s.k
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.d(f249103l, 1, "WIFI detect onWifiConnFake!");
            b(NetConnInfoCenter.getLastWifiSSID(), 0);
        }
    }

    public void c(String str) {
        j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        int i3 = this.f249120f;
        String str2 = this.f249121g;
        if (NetConnInfoCenter.isWifiConn()) {
            com.tencent.mobileqq.msf.core.e0.i r16 = this.f249117c.r();
            if (r16 == null) {
                f();
                QLog.d(f249103l, 1, "[onRecvDetectResult] senderManager is null");
                return;
            }
            t j3 = r16.j();
            if (i3 == 0) {
                QLog.d(f249103l, 1, "WIFI detect result, WIFI_OK");
                if (str != null && (jVar = this.f249123i.get(str)) != null && jVar.f249131d == 1) {
                    j3.f250076a.i().b(com.tencent.qphone.base.a.netChange);
                }
            } else if (i3 == -1) {
                QLog.d(f249103l, 1, "WIFI detect result, WIFI_EXCEPTION");
            } else if (i3 == -2 && b(this.f249122h)) {
                if (m.i().a() && j3.f250076a.h()) {
                    QLog.d(f249103l, 1, "WIFI detect result, WIFI_NEED_AUTH, but return by isPingOk");
                } else {
                    QLog.d(f249103l, 1, "WIFI detect result, WIFI_NEED_AUTH");
                    FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), MsfService.getCore().getNextSeq(), "0", BaseConstants.CMD_NETNEEDSIGNON);
                    fromServiceMsg.setMsgSuccess();
                    fromServiceMsg.setMsfCommand(MsfCommand.onNetNeedSignon);
                    fromServiceMsg.addAttribute("signonurl", str2);
                    MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                    NetConnInfoCenter.msfCore.addRespToQuque(null, fromServiceMsg);
                }
            } else {
                QLog.d(f249103l, 1, "WIFI detect result, WIFI_OTHER");
            }
        } else {
            QLog.d(f249103l, 1, "WIFI detect result, WIFI_NONE");
        }
        f();
    }

    private synchronized void b(String str, int i3) {
        a(str, System.currentTimeMillis(), false, i3);
        d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(String str) {
        if (!NetConnInfoCenter.isWifiConn()) {
            QLog.d(f249103l, 1, "WIFI detect start failed, wifi is not connected!");
            return;
        }
        if (!b(str)) {
            QLog.d(f249103l, 1, "WIFI detect start failed, ssid is invalid!");
            return;
        }
        if (!this.f249118d.compareAndSet(false, true)) {
            QLog.d(f249103l, 1, "WIFI detect start failed, there is detect running!");
            a(str, 30000L);
            return;
        }
        QLog.d(f249103l, 1, "WIFI detect started!");
        this.f249122h = str;
        b(str, System.currentTimeMillis());
        a(str, 7200000L);
        for (int i3 = 0; i3 < this.f249132a.length; i3++) {
            this.f249119e |= 1 << i3;
            com.tencent.mobileqq.msf.core.net.s.a a16 = a(this.f249132a[i3], i3, this.f249125k);
            a16.f249041c = str;
            BaseThread baseThread = new BaseThread(a16);
            baseThread.setName("WifiDetectEchoThread");
            baseThread.start();
        }
    }

    private boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.equals(NetConnInfoCenter.getLastWifiSSID());
    }

    @Override // com.tencent.mobileqq.msf.core.net.s.k
    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            return;
        }
        QLog.d(f249103l, 1, "WIFI detect onWifiConnected! with " + i3);
        com.tencent.mobileqq.msf.core.x.b bVar = this.f249116b.configManager;
        if (!com.tencent.mobileqq.msf.core.x.b.w0()) {
            QLog.d(f249103l, 1, "WIFI detect onWifiConnected into:  0");
            i3 = 0;
        }
        j jVar = this.f249123i.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (jVar == null) {
            b(str, i3);
            return;
        }
        if (!jVar.f249130c) {
            jVar.f249131d = i3;
            d(str);
            return;
        }
        jVar.f249131d = i3;
        long j3 = 1 == i3 ? 10000L : 7200000L;
        long j16 = currentTimeMillis - jVar.f249129b;
        if (j16 >= j3) {
            d(str);
        } else {
            a(str, j3 - j16);
        }
    }

    public void b(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Long.valueOf(j3));
            return;
        }
        j jVar = this.f249123i.get(str);
        if (jVar != null) {
            a(str, j3, jVar.f249130c, jVar.f249131d);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.s.k
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.d(f249103l, 1, "WIFI detect onWifiAllConnFailed!");
            b(NetConnInfoCenter.getLastWifiSSID(), 0);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.s.k
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            QLog.d(f249103l, 1, "WIFI detect onWifiConnSucc!");
            a(str, true);
        }
    }

    private void a(String str, long j3) {
        this.f249124j.removeMessages(1000);
        Message obtainMessage = this.f249124j.obtainMessage();
        obtainMessage.obj = str;
        this.f249124j.sendMessageDelayed(obtainMessage, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str) {
        if (this.f249120f != -2 || i3 == 0) {
            this.f249120f = i3;
        }
        if (this.f249120f == -2) {
            this.f249121g = str;
        }
    }

    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
            return;
        }
        j jVar = this.f249123i.get(str);
        if (jVar != null) {
            a(str, jVar.f249129b, z16, jVar.f249131d);
        }
    }

    private void a(String str, long j3, boolean z16, int i3) {
        j jVar = new j(str, j3, z16, i3);
        Iterator<Map.Entry<String, j>> it = this.f249123i.entrySet().iterator();
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int i16 = 0;
            while (it.hasNext()) {
                Map.Entry<String, j> next = it.next();
                next.getKey();
                j value = next.getValue();
                if (!value.f249128a.equals(str) && System.currentTimeMillis() - value.f249129b > 86400000) {
                    it.remove();
                } else {
                    String b16 = value.b();
                    if (b16 != null) {
                        if (stringBuffer.length() <= 0) {
                            stringBuffer.append(b16);
                        } else {
                            stringBuffer.append("#&#");
                            stringBuffer.append(b16);
                        }
                    }
                    i16++;
                    if (i16 > 5) {
                        break;
                    }
                }
            }
            this.f249123i.put(str, jVar);
            MsfStore.getNativeConfigStore().setConfig(f249109r, stringBuffer.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
