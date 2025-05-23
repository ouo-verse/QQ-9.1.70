package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static final int f249889c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private static final long f249890d = 1800000;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, b> f249891a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f249892b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1000) {
                try {
                    c.this.a();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                c.this.f249892b.sendEmptyMessageDelayed(1000, 1800000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f249894a;

        /* renamed from: b, reason: collision with root package name */
        public int f249895b;

        /* renamed from: c, reason: collision with root package name */
        public String f249896c;

        /* renamed from: d, reason: collision with root package name */
        public long f249897d;

        /* renamed from: e, reason: collision with root package name */
        public long f249898e;

        /* renamed from: f, reason: collision with root package name */
        public long f249899f;

        /* renamed from: g, reason: collision with root package name */
        public long f249900g;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f249891a = new ConcurrentHashMap<>(1000);
        a aVar = new a(Looper.getMainLooper());
        this.f249892b = aVar;
        aVar.sendEmptyMessageDelayed(1000, 1800000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ConcurrentHashMap<Integer, b> concurrentHashMap = this.f249891a;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return;
        }
        for (Map.Entry<Integer, b> entry : this.f249891a.entrySet()) {
            b value = entry.getValue();
            if (SystemClock.elapsedRealtime() - value.f249897d >= 1800000) {
                if (value.f249899f > 0) {
                    a(value, value.f249900g > 0);
                }
                this.f249891a.remove(entry.getKey());
            }
        }
    }

    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
        } else {
            if (toServiceMsg == null || !this.f249891a.containsKey(Integer.valueOf(toServiceMsg.getRequestSsoSeq()))) {
                return;
            }
            this.f249891a.get(Integer.valueOf(toServiceMsg.getRequestSsoSeq())).f249899f = SystemClock.elapsedRealtime();
        }
    }

    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (toServiceMsg == null || !this.f249891a.containsKey(Integer.valueOf(toServiceMsg.getRequestSsoSeq()))) {
            return;
        }
        b bVar = this.f249891a.get(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
        if (bVar.f249899f > 0) {
            bVar.f249900g = elapsedRealtime;
            long j3 = bVar.f249898e;
            a(bVar, j3 <= 0 || j3 > elapsedRealtime);
        }
        this.f249891a.remove(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
    }

    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg != null) {
            b bVar = new b();
            bVar.f249894a = toServiceMsg.getUin();
            bVar.f249895b = toServiceMsg.getRequestSsoSeq();
            bVar.f249896c = toServiceMsg.getServiceCmd();
            bVar.f249897d = SystemClock.elapsedRealtime();
            this.f249891a.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), bVar);
        }
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (toServiceMsg == null || !this.f249891a.containsKey(Integer.valueOf(toServiceMsg.getRequestSsoSeq()))) {
            return;
        }
        b bVar = this.f249891a.get(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
        if (bVar.f249899f > 0) {
            bVar.f249898e = elapsedRealtime;
            long j3 = bVar.f249900g;
            a(bVar, j3 > 0 && j3 <= bVar.f249897d);
        }
        this.f249891a.remove(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
    }

    private static void a(b bVar, boolean z16) {
        if (bVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", bVar.f249894a);
            hashMap.put("ssoSeq", "" + bVar.f249895b);
            hashMap.put("cmd", "" + bVar.f249896c);
            hashMap.put("normalCost", "" + (bVar.f249898e - bVar.f249897d));
            hashMap.put("quickCostTime", "" + (bVar.f249900g - bVar.f249899f));
            if (MsfService.core.getStatReporter() != null) {
                MsfService.core.getStatReporter().a(g.W, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        }
    }
}
