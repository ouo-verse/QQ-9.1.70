package com.tencent.mobileqq.msf.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_ = null;
    public static final String A = "msf_ipc_is_app_connected";
    public static final String B = "msf_ipc_is_half_close_status";
    public static final String C = "msf_ipc_uin";

    /* renamed from: q, reason: collision with root package name */
    private static final String f250855q = "MSF.S.AppProcessInfo";

    /* renamed from: r, reason: collision with root package name */
    public static final int f250856r = 15000;

    /* renamed from: s, reason: collision with root package name */
    public static final int f250857s = 5000;

    /* renamed from: t, reason: collision with root package name */
    public static final int f250858t = 1;

    /* renamed from: u, reason: collision with root package name */
    public static final int f250859u = 2;

    /* renamed from: v, reason: collision with root package name */
    public static final String f250860v = "msf_ipc_is_exception";

    /* renamed from: w, reason: collision with root package name */
    public static final String f250861w = "msf_ipc_exception_message";

    /* renamed from: x, reason: collision with root package name */
    public static final String f250862x = "msf_ipc_exception_is_process_died";

    /* renamed from: y, reason: collision with root package name */
    public static final String f250863y = "msf_ipc_trigger_cmd";

    /* renamed from: z, reason: collision with root package name */
    public static final String f250864z = "msf_ipc_process_name";

    /* renamed from: a, reason: collision with root package name */
    volatile boolean f250865a;

    /* renamed from: b, reason: collision with root package name */
    volatile long f250866b;

    /* renamed from: c, reason: collision with root package name */
    volatile boolean f250867c;

    /* renamed from: d, reason: collision with root package name */
    volatile long f250868d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f250869e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicLong f250870f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicInteger f250871g;

    /* renamed from: h, reason: collision with root package name */
    String f250872h;

    /* renamed from: i, reason: collision with root package name */
    String f250873i;

    /* renamed from: j, reason: collision with root package name */
    ConcurrentLinkedQueue<MsfMessagePair> f250874j;

    /* renamed from: k, reason: collision with root package name */
    private IMsfServiceCallbacker f250875k;

    /* renamed from: l, reason: collision with root package name */
    public o f250876l;

    /* renamed from: m, reason: collision with root package name */
    volatile boolean f250877m;

    /* renamed from: n, reason: collision with root package name */
    private IBinder.DeathRecipient f250878n;

    /* renamed from: o, reason: collision with root package name */
    private final Object f250879o;

    /* renamed from: p, reason: collision with root package name */
    private volatile b f250880p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements IBinder.DeathRecipient {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            boolean Y0 = com.tencent.mobileqq.msf.core.x.d.Y0();
            d dVar = d.this;
            QLog.w(d.f250855q, 1, String.format("binderDied appProcessName = %s, keepProcessAlive = %s, isBinderConnectOptEnable = %b", dVar.f250872h, Boolean.valueOf(dVar.f250877m), Boolean.valueOf(Y0)));
            MsfCore msfCore = MsfCore.sCore;
            if (msfCore != null && msfCore.getAccountCenter() != null) {
                str = MsfCore.sCore.getAccountCenter().e();
            } else {
                str = "";
            }
            if (d.this.f250877m) {
                BaseApplication context = BaseApplication.getContext();
                d dVar2 = d.this;
                n.a(context, dVar2.f250872h, str, dVar2.f250873i, 0, 1, null);
            }
            d.this.f250877m = false;
            if (Y0) {
                d dVar3 = d.this;
                dVar3.a(dVar3.d());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("process", d.this.f250872h);
            hashMap.put("isUseNewProxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
            hashMap.put("isProcess_exist", String.valueOf(MsfSdkUtils.isProcessExist(BaseApplication.getContext(), d.this.f250872h)));
            hashMap.put("account_uin", str);
            hashMap.put("isBinderConnectOptEnable", String.valueOf(Y0));
            if (MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a("msf_binder_died_b", false, 0L, 0L, (Map<String, String>) hashMap, true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends Handler {
        static IPatchRedirector $redirector_;

        public b(Looper looper) {
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
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                Bundle data = message.getData();
                Intent intent = new Intent();
                intent.putExtra(d.f250860v, true);
                intent.putExtra(d.f250861w, data.getString(d.f250861w, ""));
                intent.putExtra(d.f250862x, data.getBoolean(d.f250862x, false));
                intent.putExtra(d.f250863y, data.getString(d.f250863y, ""));
                d.this.a(intent);
                return;
            }
            if (i3 == 2) {
                Bundle data2 = message.getData();
                Intent intent2 = new Intent();
                intent2.putExtra(d.f250863y, data2.getString(d.f250863y, ""));
                d.this.a(intent2);
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250865a = true;
        this.f250866b = 0L;
        this.f250867c = false;
        this.f250868d = 0L;
        this.f250869e = false;
        this.f250870f = new AtomicLong(0L);
        this.f250871g = new AtomicInteger(0);
        this.f250874j = new ConcurrentLinkedQueue<>();
        this.f250876l = null;
        this.f250877m = false;
        this.f250879o = new Object();
    }

    private boolean e() {
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || !com.tencent.mobileqq.msf.core.x.m.a())) {
            return false;
        }
        return true;
    }

    private void f() {
        try {
            if (this.f250875k != null) {
                if (this.f250878n == null) {
                    this.f250878n = new a();
                }
                this.f250875k.asBinder().linkToDeath(this.f250878n, 0);
            }
        } catch (Throwable th5) {
            QLog.e(f250855q, 1, "registerCallbackDeathRecipient fail.", th5);
        }
    }

    private void h() {
        try {
            IMsfServiceCallbacker iMsfServiceCallbacker = this.f250875k;
            if (iMsfServiceCallbacker != null && this.f250878n != null) {
                iMsfServiceCallbacker.asBinder().unlinkToDeath(this.f250878n, 0);
            }
        } catch (Throwable th5) {
            QLog.e(f250855q, 1, "unregisterCallbackDeathRecipient fail.", th5);
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f250872h : (String) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    public b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f250880p == null) {
            synchronized (d.class) {
                if (this.f250880p == null) {
                    this.f250880p = new b(q.t().getLooper());
                }
            }
        }
        return this.f250880p;
    }

    public IMsfServiceCallbacker d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IMsfServiceCallbacker) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f250875k;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f250872h + "," + a() + "," + this.f250865a;
    }

    public void a(String str, String str2, IMsfServiceCallbacker iMsfServiceCallbacker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, iMsfServiceCallbacker);
            return;
        }
        this.f250872h = str;
        b(str2);
        if (iMsfServiceCallbacker != null) {
            c(iMsfServiceCallbacker);
            this.f250865a = true;
        } else if (d() == null) {
            this.f250865a = false;
        } else {
            this.f250865a = true;
        }
        this.f250868d = 0L;
        this.f250871g.set(0);
        this.f250867c = false;
        if (QLog.isColorLevel()) {
            QLog.d(f250855q, 2, String.format("onAppBind appProcessName=%s isAppConnected=%s halfCloseStatus=%s keepProcessAlive=%s", str, Boolean.valueOf(this.f250865a), Boolean.valueOf(this.f250867c), Boolean.valueOf(this.f250877m)));
        }
        if (MsfService.getCore() != null && MsfService.getCore().getStatReporter() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("appProcessName", str);
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                if (MsfService.getCore().getStatReporter() != null) {
                    MsfService.getCore().getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247775y3, this.f250865a, 0L, 0L, (Map<String, String>) hashMap, false, false);
                }
            } else if (!this.f250865a && MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247775y3, this.f250865a, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        }
        o oVar = this.f250876l;
        if (oVar != null) {
            oVar.a(iMsfServiceCallbacker);
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f250873i = str;
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    private void b(IMsfServiceCallbacker iMsfServiceCallbacker) {
        h();
        this.f250875k = iMsfServiceCallbacker;
        f();
    }

    private void c(IMsfServiceCallbacker iMsfServiceCallbacker) {
        synchronized (this.f250879o) {
            b(iMsfServiceCallbacker);
        }
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        } else {
            this.f250874j.add(new MsfMessagePair(toServiceMsg, fromServiceMsg));
            e.f250886d.b();
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.f250873i : (String) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public void a(IMsfServiceCallbacker iMsfServiceCallbacker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iMsfServiceCallbacker);
            return;
        }
        if (iMsfServiceCallbacker != this.f250875k || iMsfServiceCallbacker == null) {
            return;
        }
        synchronized (this.f250879o) {
            if (iMsfServiceCallbacker == this.f250875k) {
                b((IMsfServiceCallbacker) null);
                this.f250865a = false;
                this.f250867c = false;
                this.f250877m = false;
                QLog.d(f250855q, 1, String.format("setAppDisConnected appProcessName = %s, isAppConnected = %s, halfCloseStatus = %s, keepProcessAlive = %s, preCallback = %s", this.f250872h, Boolean.valueOf(this.f250865a), Boolean.valueOf(this.f250867c), Boolean.valueOf(this.f250877m), Integer.toHexString(iMsfServiceCallbacker.hashCode())));
            }
        }
    }

    public void a(Exception exc, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) exc, (Object) str);
            return;
        }
        if (e() && this.f250869e && this.f250872h != null && (exc instanceof DeadObjectException)) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean isProcessExist = MsfSdkUtils.isProcessExist(BaseApplication.getContext(), this.f250872h);
            Message obtainMessage = c().obtainMessage(1);
            Bundle bundle = new Bundle();
            bundle.putBoolean(f250862x, isProcessExist);
            bundle.putString(f250861w, exc.getMessage());
            bundle.putString(f250863y, str);
            obtainMessage.setData(bundle);
            long j3 = this.f250870f.get();
            if (j3 != 0 && currentTimeMillis - j3 <= 15000) {
                c().removeMessages(1);
                c().sendMessageDelayed(obtainMessage, (j3 + 15000) - currentTimeMillis);
            } else {
                c().removeMessages(1);
                c().sendMessage(obtainMessage);
            }
        }
    }

    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.f250869e || TextUtils.isEmpty(this.f250872h)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f250870f.get();
        if (j3 != 0 && currentTimeMillis - j3 < 5000) {
            return false;
        }
        Message obtainMessage = c().obtainMessage(2);
        Bundle bundle = new Bundle();
        bundle.putString(f250863y, str);
        obtainMessage.setData(bundle);
        c().removeMessages(2);
        c().sendMessage(obtainMessage);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f250870f.get();
        if (j3 == 0 || currentTimeMillis - j3 >= 5000) {
            String e16 = MsfCore.sCore.getAccountCenter().e();
            intent.setAction(BaseConstants.ACTION_MSF_NOTIFY_REGISTER_SERVICE);
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra(C, e16);
            intent.putExtra(f250864z, this.f250872h);
            intent.putExtra(A, this.f250865a);
            intent.putExtra(B, this.f250867c);
            BaseApplication.getContext().sendBroadcast(intent);
            this.f250870f.set(System.currentTimeMillis());
            int incrementAndGet = this.f250871g.incrementAndGet();
            StringBuilder sb5 = new StringBuilder();
            if (intent.getBooleanExtra(f250860v, false)) {
                sb5.append("isException:");
                sb5.append(true);
                sb5.append(", exceptionMsg:");
                sb5.append(intent.getStringExtra(f250861w));
                sb5.append(", processDied:");
                sb5.append(intent.getBooleanExtra(f250862x, false));
            } else {
                sb5.append("isException:");
                sb5.append(false);
            }
            QLog.i(f250855q, 1, "sendNotifyRegisterMSFBroadcast , action:" + intent.getAction() + " to process:" + this.f250872h + ", broadcastTimes=" + incrementAndGet + ", appConned=" + this.f250865a + ", halfClose=" + this.f250867c + ", " + ((Object) sb5));
        }
    }

    public void a(int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        o oVar = this.f250876l;
        if (oVar != null) {
            oVar.a(i3, j3, j16);
        }
    }

    public void a(int i3, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) fromServiceMsg);
            return;
        }
        String uin = fromServiceMsg.getUin();
        o oVar = this.f250876l;
        if (oVar != null) {
            oVar.a(i3);
        } else {
            if (i3 != 0 || TextUtils.isEmpty(this.f250873i)) {
                return;
            }
            n.a(BaseApplication.getContext(), this.f250872h, uin, this.f250873i, e.f250887e.getUinPushStatus(uin), fromServiceMsg);
            MsfService.getCore().pushManager.f249743j.b();
        }
    }
}
