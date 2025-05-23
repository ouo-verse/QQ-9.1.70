package com.tencent.mobileqq.msf.core.y;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: g, reason: collision with root package name */
    public static final String f250439g = "MSF.C.BaseEventManager";

    /* renamed from: h, reason: collision with root package name */
    public static final int f250440h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static final int f250441i = 2;

    /* renamed from: j, reason: collision with root package name */
    public static final int f250442j = 3;

    /* renamed from: k, reason: collision with root package name */
    public static final int f250443k = 4;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.y.b f250444a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f250445b;

    /* renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArrayList<d> f250446c;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.y.c> f250447d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f250448e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler.Callback f250449f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.y.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8101a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        C8101a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        a.this.d();
                    } else if (i3 == 4) {
                        a.this.c();
                    }
                } else if (a.this.f250448e.getAndSet(false)) {
                    a.this.a();
                }
            } else if (!a.this.f250448e.getAndSet(true)) {
                a.this.b();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f250451a;

        b(String str) {
            this.f250451a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            j statReporter = MsfService.getCore().getStatReporter();
            if (statReporter != null) {
                statReporter.b(this.f250451a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f250453a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13696);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250453a = new a(null);
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ a(C8101a c8101a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8101a);
    }

    private boolean g() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            String packageName = BaseApplication.getContext().getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                    QLog.d(f250439g, 1, "init app foreground = true");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static a h() {
        return c.f250453a;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f250448e.set(g());
        com.tencent.mobileqq.msf.core.y.b bVar = this.f250444a;
        if (bVar != null) {
            bVar.a(this.f250448e.get());
        }
        BaseApplication.getContext().registerReceiver(this, new IntentFilter(IECScreenReceiver.ACTION_SCREEN_OFF));
        BaseApplication.getContext().registerReceiver(this, new IntentFilter(IECScreenReceiver.ACTION_SCREEN_ON));
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f250448e.get();
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.f250444a != null) {
            return true;
        }
        return false;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            QLog.d(f250439g, 1, "onApplicationBackground");
            this.f250445b.sendEmptyMessage(2);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            QLog.d(f250439g, 1, "onApplicationForeground");
            this.f250445b.sendEmptyMessage(1);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.d(f250439g, 1, "onScreenOff");
            this.f250445b.sendEmptyMessage(4);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.d(f250439g, 1, "onScreenOn");
            this.f250445b.sendEmptyMessage(3);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent == null) {
            QLog.d(f250439g, 1, "onReceive intent==null");
            return;
        }
        String action = intent.getAction();
        QLog.d(f250439g, 1, "onReceive action: " + action);
        if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
            n();
        } else if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
            m();
        }
        this.f250445b.post(new b(action));
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250446c = new CopyOnWriteArrayList<>();
        this.f250447d = new CopyOnWriteArrayList<>();
        this.f250448e = new AtomicBoolean(false);
        C8101a c8101a = new C8101a();
        this.f250449f = c8101a;
        this.f250445b = new Handler(q.a().getLooper(), c8101a);
        if (Build.VERSION.SDK_INT >= 26) {
            com.tencent.mobileqq.msf.core.y.b bVar = new com.tencent.mobileqq.msf.core.y.b();
            this.f250444a = bVar;
            a((com.tencent.mobileqq.msf.core.y.c) bVar);
            a(this.f250444a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f250447d) {
            if (this.f250447d.size() > 0) {
                arrayList.addAll(this.f250447d);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.msf.core.y.c) it.next()).f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ArrayList<d> arrayList = new ArrayList();
        synchronized (this.f250446c) {
            if (this.f250446c.size() > 0) {
                arrayList.addAll(this.f250446c);
            }
        }
        for (d dVar : arrayList) {
            if (dVar != null) {
                dVar.onScreenOff();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ArrayList<d> arrayList = new ArrayList();
        synchronized (this.f250446c) {
            if (this.f250446c.size() > 0) {
                arrayList.addAll(this.f250446c);
            }
        }
        for (d dVar : arrayList) {
            if (dVar != null) {
                dVar.onScreenOn();
            }
        }
    }

    public void a(boolean z16, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Long.valueOf(j3), str);
            return;
        }
        QLog.d(f250439g, 1, "onProcessViewableChanged process: " + str + ", state: " + z16 + ", at: " + j3);
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.y.b bVar = this.f250444a;
        if (bVar != null) {
            return bVar.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f250447d) {
            if (this.f250447d.size() > 0) {
                arrayList.addAll(this.f250447d);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.msf.core.y.c) it.next()).h();
        }
    }

    public void b(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) dVar);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unregisterScreenEventObserver ");
        sb5.append(dVar == null ? "null" : Integer.toHexString(dVar.hashCode()));
        QLog.d(f250439g, 1, sb5.toString());
        if (dVar == null) {
            return;
        }
        synchronized (this.f250446c) {
            this.f250446c.remove(dVar);
        }
    }

    public void a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) dVar);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerScreenEventObserver ");
        sb5.append(dVar == null ? "null" : Integer.toHexString(dVar.hashCode()));
        QLog.d(f250439g, 1, sb5.toString());
        synchronized (this.f250446c) {
            if (dVar != null) {
                this.f250446c.add(dVar);
            }
        }
    }

    public void b(com.tencent.mobileqq.msf.core.y.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) cVar);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unregisterAppEventObserver ");
        sb5.append(cVar == null ? "null" : Integer.toHexString(cVar.hashCode()));
        QLog.d(f250439g, 1, sb5.toString());
        if (cVar == null) {
            return;
        }
        synchronized (this.f250447d) {
            this.f250447d.remove(cVar);
        }
    }

    public void a(com.tencent.mobileqq.msf.core.y.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) cVar);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerAppEventObserver ");
        sb5.append(cVar == null ? "null" : Integer.toHexString(cVar.hashCode()));
        QLog.d(f250439g, 1, sb5.toString());
        synchronized (this.f250447d) {
            if (cVar != null) {
                this.f250447d.add(cVar);
            }
        }
    }
}
