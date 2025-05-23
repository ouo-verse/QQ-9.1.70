package com.tencent.mobileqq.msf.core.g0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.core.x.b;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: l, reason: collision with root package name */
    private static final String f248329l = "StandbyModeManager";

    /* renamed from: m, reason: collision with root package name */
    private static final int f248330m = 10001;

    /* renamed from: n, reason: collision with root package name */
    private static final String f248331n = "standbyMode";

    /* renamed from: o, reason: collision with root package name */
    private static final String f248332o = "enterTime";

    /* renamed from: p, reason: collision with root package name */
    private static final String f248333p = "enterTimeSys";

    /* renamed from: q, reason: collision with root package name */
    private static final String f248334q = "contiousTime";

    /* renamed from: r, reason: collision with root package name */
    private static final String f248335r = "disconnCount";

    /* renamed from: s, reason: collision with root package name */
    public static final String f248336s = "storeflow";

    /* renamed from: t, reason: collision with root package name */
    public static final String f248337t = "key_storeflow";

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f248338a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f248339b;

    /* renamed from: c, reason: collision with root package name */
    private AtomicInteger f248340c;

    /* renamed from: d, reason: collision with root package name */
    private HashSet<String> f248341d;

    /* renamed from: e, reason: collision with root package name */
    private final MsfCore f248342e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f248343f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.g0.b f248344g;

    /* renamed from: h, reason: collision with root package name */
    private long f248345h;

    /* renamed from: i, reason: collision with root package name */
    private long f248346i;

    /* renamed from: j, reason: collision with root package name */
    private String f248347j;

    /* renamed from: k, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.y.d f248348k;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.g0.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8079a implements com.tencent.mobileqq.msf.core.y.d {
        static IPatchRedirector $redirector_;

        C8079a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.y.d
        public void onScreenOff() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (a.this.f248342e.getStatReporter() != null && a.this.f248342e.statReporter.f247848b != null) {
                a.this.f248342e.statReporter.f247848b.f247864e = System.currentTimeMillis();
                a.this.f248342e.statReporter.f247848b.f247865f = 0L;
            }
            a.this.e();
        }

        @Override // com.tencent.mobileqq.msf.core.y.d
        public void onScreenOn() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (a.this.f248342e.getStatReporter() != null && a.this.f248342e.statReporter.f247848b == null) {
                a.this.f248342e.statReporter.f247848b = new j.e();
            }
            if (a.this.f248342e.getStatReporter() != null && a.this.f248342e.statReporter.f247848b != null) {
                a.this.f248342e.statReporter.f247848b.f247864e = 0L;
            }
            a.this.f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements b.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.x.b.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.o();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements Runnable {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.p();
                if (!MsfSdkUtils.isScreenOn()) {
                    a.this.e();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!a.this.g()) {
                a.this.f248343f.sendEmptyMessageDelayed(10001, com.tencent.mobileqq.msf.core.x.b.P0());
            } else {
                QLog.d(a.f248329l, 1, "stop try start standby by lockScreenMsg ON when screenoff");
            }
        }
    }

    public a(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f248338a = new AtomicBoolean(false);
        this.f248339b = new AtomicBoolean(false);
        this.f248340c = new AtomicInteger(0);
        this.f248341d = new HashSet<>(64);
        this.f248345h = 0L;
        this.f248346i = 0L;
        this.f248347j = "0";
        C8079a c8079a = new C8079a();
        this.f248348k = c8079a;
        this.f248342e = msfCore;
        this.f248343f = new Handler(q.j().getLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.msf.core.g0.c
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean a16;
                a16 = a.this.a(message);
                return a16;
            }
        });
        com.tencent.mobileqq.msf.core.y.a.h().a(c8079a);
        com.tencent.mobileqq.msf.core.x.b bVar = msfCore.configManager;
        if (bVar != null) {
            bVar.a(new b());
        }
        d();
        this.f248344g = new com.tencent.mobileqq.msf.core.g0.b(msfCore);
        q.s().post(new c());
    }

    private boolean h() {
        return NetConnInfoCenter.isMobileConn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            a(com.tencent.mobileqq.msf.core.x.b.N0());
        } catch (Exception e16) {
            QLog.d(f248329l, 1, " " + e16, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(f248331n, 0);
        long j3 = sharedPreferences.getLong(f248332o, 0L);
        long j16 = sharedPreferences.getLong(f248333p, 0L);
        long j17 = sharedPreferences.getLong(f248334q, 0L);
        int i3 = sharedPreferences.getInt(f248335r, 0);
        if (j3 > 0 && j16 > 0 && this.f248342e.getStatReporter() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("account", b());
            hashMap.put("contious", String.valueOf(j17));
            hashMap.put(f248335r, String.valueOf(i3));
            hashMap.put("notifyReconnect", String.valueOf(false));
            hashMap.put("exitReason", "crashed");
            hashMap.put("start", String.valueOf(this.f248346i));
            hashMap.put("end", String.valueOf(j16 + j17));
            this.f248342e.getStatReporter().a(g.f247777z0, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
        sharedPreferences.edit().putLong(f248332o, 0L).putLong(f248333p, 0L).putLong(f248333p, 0L).putInt(f248335r, 0).apply();
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (com.tencent.mobileqq.msf.core.x.b.j1() && this.f248338a.get()) {
            return true;
        }
        return false;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.f248338a.get()) {
            BaseApplication.getContext().getSharedPreferences(f248331n, 0).edit().putLong(f248334q, this.f248345h - SystemClock.elapsedRealtime()).putInt(f248335r, this.f248340c.get()).commit();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.f248338a.get()) {
            QLog.d(f248329l, 1, "onConnClosed");
            this.f248340c.incrementAndGet();
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (this.f248338a.get()) {
            QLog.d(f248329l, 1, "onConnOpened");
            this.f248339b.compareAndSet(false, true);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d(f248329l, 1, "onMobileOn");
        if (!this.f248338a.get()) {
            if (!MsfSdkUtils.isScreenOn()) {
                this.f248343f.removeMessages(10001);
                if (!g()) {
                    this.f248343f.obtainMessage().obj = this.f248342e.getAccountCenter().e();
                    this.f248343f.sendEmptyMessageDelayed(10001, com.tencent.mobileqq.msf.core.x.b.P0());
                    return;
                }
                QLog.d(f248329l, 1, "stop try start standby by lockScreenMsg ON when mobileOn");
                return;
            }
            QLog.d(f248329l, 1, "stop try start standby by screenOn ON when mobileOn");
            return;
        }
        QLog.d(f248329l, 1, "stop try start standby by alreadyActive ON when mobileOn");
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.d(f248329l, 1, "onWifiOn");
        this.f248343f.removeMessages(10001);
        a("wifiOn");
    }

    private void d() {
        this.f248341d.add("GrayUinPro.Check");
        this.f248341d.add(BaseConstants.CMD_OPENCONN);
        this.f248341d.add("StatSvc.register");
        this.f248341d.add("StatSvc.SimpleGet");
        this.f248341d.add(BaseConstants.CMD_SA_WT);
        this.f248341d.add(BaseConstants.CMD_SA);
        this.f248341d.add(BaseConstants.CMD_HEARTBEATALIVE);
        this.f248341d.add(BaseConstants.CMD_PUSHRESP);
        this.f248341d.add(BaseConstants.CMD_SSOHELLOPUSH);
        this.f248341d.add("MessageSvc.");
        this.f248341d.add("OnlinePush.");
        this.f248341d.add("PbMessageSvc.");
        this.f248341d.add("ImgStore.GroupPicUp");
        this.f248341d.add(RichMediaConstants.CMD_LONGCONN_GROUPPIC_DOWN);
        this.f248341d.add(RichMediaConstants.CMD_LONGCONN_GROUPPTT_UP);
        this.f248341d.add(RichMediaConstants.CMD_LONGCONN_GROUPPTT_DOWN);
        this.f248341d.add("LongConn.OffPicUp");
        this.f248341d.add(RichMediaConstants.CMD_LONGCONN_OFFPIC_DOWN);
        this.f248341d.add(RichMediaConstants.CMD_TEMP_PTT_UPLOAD);
        this.f248341d.add(RichMediaConstants.CMD_TEMP_PTT_DOWNLOAD);
        this.f248341d.add(RichMediaConstants.CMD_OFFLINEFILE_PTT_DOWN);
        this.f248341d.add(RichMediaConstants.CMD_LONGCONN_MULTIMSG_UP);
        this.f248341d.add(RichMediaConstants.CMD_LONGCONN_MULTIMSG_DOWN);
        this.f248341d.add(RichMediaConstants.CMD_SHORT_VIDEO_UP);
        this.f248341d.add(RichMediaConstants.CMD_SHORT_VIDEO_DOWN);
        this.f248341d.add(RichMediaConstants.CMD_GROUP_SHORT_VIDEO_UP);
        this.f248341d.add(RichMediaConstants.CMD_GROUP_SHORT_VIDEO_DOWN);
        this.f248341d.add("EqqAccountSvc.get_eqq_detail");
        this.f248341d.add("hrtxformqq.getUsrSimpleInfo");
        this.f248341d.add("PubAccountSvc.get_detail_info");
        this.f248341d.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600");
        this.f248341d.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700");
        this.f248341d.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800");
        this.f248341d.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200");
        this.f248341d.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400");
        this.f248341d.add("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100");
        this.f248341d.add("VideoCCSvc.PutInfo");
        this.f248341d.add("SharpSvr.s2cack");
        this.f248341d.add("SharpSvr.c2s");
        this.f248341d.add("MultiVideo.s2cack");
        this.f248341d.add("SharpSvr.s2cackMSF");
        this.f248341d.add("VideoSvc.Ack");
        this.f248341d.add("QQWifiSvc.AvailQQWiFi");
        this.f248341d.add("QQWifiSvc.QQWiFiJarInfo");
        this.f248341d.add("QQWifiSvc.wifiReport");
        this.f248341d.add("QQWifiSvc.getAccount");
        this.f248341d.add("QQWifiSvc.ReportWiFiStatus");
        this.f248341d.add("QQWifiSvc.getNearWiFi");
        this.f248341d.add(s.F);
        a(com.tencent.mobileqq.msf.core.x.b.N0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.f248338a.get()) {
            if (h()) {
                this.f248343f.removeMessages(10001);
                q.a(new d(), null);
                return;
            } else {
                QLog.d(f248329l, 1, "stop try start standby by mobileOff ON when screenoff");
                return;
            }
        }
        QLog.d(f248329l, 1, "stop try start standby by alreadyActive ON when screenoff");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f248343f.removeMessages(10001);
        a("screeOn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        String e16 = this.f248342e.getAccountCenter().e();
        if (!TextUtils.isEmpty(e16) && !"0".equals(e16)) {
            return SettingCloneUtil.readValue((Context) BaseApplication.getContext(), e16, "\u9501\u5c4f\u663e\u793a\u6d88\u606f\u5f39\u6846", AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true);
        }
        QLog.d(f248329l, 1, "can't know current main account");
        return true;
    }

    public boolean b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            return SettingCloneUtil.readValue((Context) BaseApplication.getContext(), str, "\u9501\u5c4f\u663e\u793a\u6d88\u606f\u5f39\u6846", AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true);
        }
        QLog.d(f248329l, 1, "can't know current main account");
        return true;
    }

    public boolean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f248341d.contains(str)) {
            return true;
        }
        int indexOf = str.indexOf(".");
        if (indexOf > 0) {
            if (this.f248341d.contains(str.substring(0, indexOf) + ".")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (message.what != 10001) {
            return false;
        }
        a();
        return false;
    }

    public void a(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) strArr);
            return;
        }
        if (this.f248341d == null || strArr == null) {
            return;
        }
        for (String str : strArr) {
            this.f248341d.add(str);
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? (this.f248342e.getAccountCenter() == null || this.f248342e.getAccountCenter().e() == null || this.f248342e.getAccountCenter().e().length() < 4) ? "0" : this.f248342e.getAccountCenter().e() : (String) iPatchRedirector.redirect((short) 12, (Object) this);
    }

    public HashSet<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f248341d : (HashSet) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    private void a() {
        if (this.f248338a.compareAndSet(false, true)) {
            QLog.d(f248329l, 1, "enterStandbyMode");
            this.f248347j = b();
            this.f248345h = SystemClock.elapsedRealtime();
            this.f248346i = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("account", this.f248347j);
            if (this.f248342e.getStatReporter() != null) {
                this.f248342e.getStatReporter().a(g.f247772y0, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
            BaseApplication.getContext().getSharedPreferences(f248331n, 0).edit().putLong(f248332o, this.f248345h).putLong(f248333p, this.f248346i).putLong(f248333p, 0L).putInt(f248335r, 0).commit();
        }
    }

    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            this.f248344g.b(toServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) toServiceMsg);
        }
    }

    private void a(String str) {
        if (this.f248338a.get()) {
            QLog.d(f248329l, 1, "exitStandbyMode");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("account", b());
            hashMap.put("contious", String.valueOf(elapsedRealtime - this.f248345h));
            hashMap.put(f248335r, String.valueOf(this.f248340c.get()));
            hashMap.put("notifyReconnect", String.valueOf(this.f248339b.get()));
            hashMap.put("exitReason", str);
            hashMap.put("start", String.valueOf(this.f248346i));
            hashMap.put("end", String.valueOf(currentTimeMillis));
            if (this.f248342e.getStatReporter() != null) {
                this.f248342e.getStatReporter().a(g.f247777z0, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
            this.f248344g.a();
            BaseApplication.getContext().getSharedPreferences(f248331n, 0).edit().putLong(f248332o, 0L).putLong(f248333p, 0L).putLong(f248333p, 0L).putInt(f248335r, 0).commit();
            this.f248345h = 0L;
            this.f248347j = "0";
            this.f248340c.set(0);
            this.f248338a.set(false);
            if (this.f248342e.isConnected() && this.f248339b.get()) {
                QLog.d(f248329l, 1, "notifyConnOpened when exitStandbyMode");
                NetConnInfoCenter.onConnOpened();
                if (MsfService.getCore().isFirstMsgReceived()) {
                    QLog.d(f248329l, 1, "notifyFirestMsgRecved when exitStandbyMode");
                    NetConnInfoCenter.onRecvFirstResp();
                }
            }
            this.f248339b.set(false);
        }
    }

    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            this.f248344g.a(toServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) toServiceMsg);
        }
    }
}
