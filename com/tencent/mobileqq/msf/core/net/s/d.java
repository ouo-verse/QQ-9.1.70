package com.tencent.mobileqq.msf.core.net.s;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: l, reason: collision with root package name */
    private static final String f249052l = "ReqAllFailDetector";

    /* renamed from: m, reason: collision with root package name */
    private static final int f249053m = 10000;

    /* renamed from: n, reason: collision with root package name */
    private static final long f249054n = 180000;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> f249055a;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> f249056b;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<e> f249057c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f249058d;

    /* renamed from: e, reason: collision with root package name */
    private long f249059e;

    /* renamed from: f, reason: collision with root package name */
    private String f249060f;

    /* renamed from: g, reason: collision with root package name */
    private int f249061g;

    /* renamed from: h, reason: collision with root package name */
    private long f249062h;

    /* renamed from: i, reason: collision with root package name */
    private String f249063i;

    /* renamed from: j, reason: collision with root package name */
    private MsfCore f249064j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f249065k;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 10000) {
                d.this.c();
            }
        }
    }

    public d(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f249057c = new CopyOnWriteArrayList<>();
        this.f249058d = new AtomicBoolean(false);
        this.f249059e = 0L;
        this.f249060f = "";
        this.f249061g = 0;
        this.f249062h = 0L;
        this.f249063i = "";
        this.f249065k = new a(Looper.getMainLooper());
        this.f249064j = msfCore;
        b();
    }

    private CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a() {
        if (NetConnInfoCenter.isWifiConn()) {
            return this.f249056b;
        }
        if (NetConnInfoCenter.isMobileConn()) {
            return this.f249055a;
        }
        return null;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            if (com.tencent.mobileqq.msf.core.x.b.h1()) {
                this.f249055a = new CopyOnWriteArrayList<>();
                this.f249056b = new CopyOnWriteArrayList<>();
                String f16 = o.f();
                if (f16 != null) {
                    if (f16.startsWith("460") || f16.startsWith("461")) {
                        if (!f16.startsWith("46000") && !f16.startsWith("46002")) {
                            if (f16.startsWith("46001")) {
                                com.tencent.mobileqq.msf.core.d dVar = new com.tencent.mobileqq.msf.core.d();
                                dVar.b("112.90.82.216");
                                dVar.a(8080);
                                this.f249055a.add(dVar);
                                com.tencent.mobileqq.msf.core.d dVar2 = new com.tencent.mobileqq.msf.core.d();
                                dVar2.b("112.90.83.32");
                                dVar2.a(8080);
                                this.f249055a.add(dVar2);
                            } else if (f16.startsWith("46003")) {
                                com.tencent.mobileqq.msf.core.d dVar3 = new com.tencent.mobileqq.msf.core.d();
                                dVar3.b("183.60.9.149");
                                dVar3.a(8080);
                                this.f249055a.add(dVar3);
                                com.tencent.mobileqq.msf.core.d dVar4 = new com.tencent.mobileqq.msf.core.d();
                                dVar4.b("183.60.15.152");
                                dVar4.a(8080);
                                this.f249055a.add(dVar4);
                            }
                        }
                        com.tencent.mobileqq.msf.core.d dVar5 = new com.tencent.mobileqq.msf.core.d();
                        dVar5.b("120.196.210.210");
                        dVar5.a(8080);
                        this.f249055a.add(dVar5);
                        com.tencent.mobileqq.msf.core.d dVar6 = new com.tencent.mobileqq.msf.core.d();
                        dVar6.b("183.232.95.122");
                        dVar6.a(8080);
                        this.f249055a.add(dVar6);
                    }
                    com.tencent.mobileqq.msf.core.d dVar7 = new com.tencent.mobileqq.msf.core.d();
                    dVar7.b("120.196.210.210");
                    dVar7.a(8080);
                    this.f249056b.add(dVar7);
                    com.tencent.mobileqq.msf.core.d dVar8 = new com.tencent.mobileqq.msf.core.d();
                    dVar8.b("183.232.95.122");
                    dVar8.a(8080);
                    this.f249056b.add(dVar8);
                    com.tencent.mobileqq.msf.core.d dVar9 = new com.tencent.mobileqq.msf.core.d();
                    dVar9.b("112.90.82.216");
                    dVar9.a(8080);
                    this.f249056b.add(dVar9);
                    com.tencent.mobileqq.msf.core.d dVar10 = new com.tencent.mobileqq.msf.core.d();
                    dVar10.b("112.90.83.32");
                    dVar10.a(8080);
                    this.f249056b.add(dVar10);
                    com.tencent.mobileqq.msf.core.d dVar11 = new com.tencent.mobileqq.msf.core.d();
                    dVar11.b("183.60.9.149");
                    dVar11.a(8080);
                    this.f249056b.add(dVar11);
                    com.tencent.mobileqq.msf.core.d dVar12 = new com.tencent.mobileqq.msf.core.d();
                    dVar12.b("183.60.15.152");
                    dVar12.a(8080);
                    this.f249056b.add(dVar12);
                    return;
                }
                return;
            }
            this.f249055a = com.tencent.mobileqq.msf.core.x.b.z0();
            this.f249056b = com.tencent.mobileqq.msf.core.x.b.y0();
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d(f249052l, 1, "loadConfigEndpoint exception", e16);
        }
    }

    public void c() {
        String[] list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d(f249052l, 1, "stopReqFailDetect");
        boolean z16 = false;
        this.f249058d.set(false);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<e> it = this.f249057c.iterator();
            boolean z17 = false;
            boolean z18 = false;
            while (it.hasNext()) {
                e next = it.next();
                String c16 = next.c();
                next.f();
                this.f249057c.remove(next);
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("#");
                }
                stringBuffer.append(c16);
                boolean z19 = next.f249078j;
                if (z19 && (!next.f249076h || !next.f249077i)) {
                    z17 = true;
                }
                if (z19 && next.f249079k > 30000) {
                    z18 = true;
                }
                if (z19 && next.f249080l > 30000) {
                    z18 = true;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f249060f);
            hashMap.put("port", String.valueOf(this.f249061g));
            hashMap.put("reason", String.valueOf(this.f249063i));
            hashMap.put("sendCount", String.valueOf(this.f249062h));
            hashMap.put("connTime", String.valueOf(this.f249059e));
            hashMap.put("detectInfo", stringBuffer.toString());
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/" + BaseApplication.getContext().getPackageName().replace(".", "/") + "/");
            if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                int length = list.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (list[i3].endsWith(".pcap")) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
            }
            com.tencent.mobileqq.msf.core.c0.j jVar = this.f249064j.statReporter;
            if (jVar != null) {
                jVar.a(com.tencent.mobileqq.msf.core.c0.g.f247685f0, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
                if (z17) {
                    this.f249064j.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.f247690g0, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
                }
                if (z18) {
                    this.f249064j.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.f247695h0, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.d(f249052l, 1, "stopReqFailDetect exception", th5);
        }
    }

    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        try {
            if (!this.f249058d.get() || this.f249057c.size() <= 0) {
                return;
            }
            for (int i3 = 0; i3 < this.f249057c.size(); i3++) {
                this.f249057c.get(i3).a(toServiceMsg);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.d(f249052l, 1, "onSendRequest exception", th5);
        }
    }

    public void a(long j3, String str, int i3, String str2, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), str, Integer.valueOf(i3), str2, Long.valueOf(j16));
            return;
        }
        if (!this.f249058d.compareAndSet(false, true)) {
            QLog.d(f249052l, 1, "startReqFailDetect fail by detect running");
            return;
        }
        try {
            QLog.d(f249052l, 1, "startReqFailDetect succ");
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a16 = a();
            if (a16 != null && a16.size() > 0) {
                QLog.d(f249052l, 1, "startReqFailDetect");
                this.f249065k.sendEmptyMessageDelayed(10000, 180000L);
                this.f249059e = j3;
                this.f249060f = str;
                this.f249061g = i3;
                this.f249063i = str2;
                this.f249062h = j16;
                for (int i16 = 0; i16 < a16.size(); i16++) {
                    e eVar = new e(this.f249064j, a16.get(i16), i16);
                    eVar.start();
                    this.f249057c.add(eVar);
                }
                return;
            }
            this.f249058d.set(false);
            QLog.d(f249052l, 1, "stopReqFailDetect by sso empty");
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d(f249052l, 1, "startReqFailDetect fail by except", e16);
        }
    }
}
