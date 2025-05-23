package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.trtc.engine.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c implements com.tencent.mobileqq.qqlive.trtc.ipc.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final ArrayList<String> f273344c;

    /* renamed from: a, reason: collision with root package name */
    private final Queue<b> f273345a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.ipc.b f273346b;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final c f273347a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61637);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f273347a = new c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f273348a;

        /* renamed from: b, reason: collision with root package name */
        String f273349b;

        /* renamed from: c, reason: collision with root package name */
        Bundle f273350c;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        f273344c = arrayList;
        arrayList.add("Action_Client_Init_SDK");
        arrayList.add("Action_Client_Room_Enter_Room");
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273345a = new ConcurrentLinkedQueue();
            this.f273346b = null;
        }
    }

    public static c h() {
        return a.f273347a;
    }

    private boolean k() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    private boolean l() {
        boolean z16;
        if (MobileQQ.sProcessId == 7) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("TRTCIPCManager", 1, "isRealHost: " + z16);
        return z16;
    }

    private boolean m(b bVar) {
        if (System.currentTimeMillis() - bVar.f273348a <= 10000) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.ipc.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TRTCIPCManager", 2, "onConnectUnbind");
        }
        com.tencent.mobileqq.qqlive.trtc.ipc.b bVar = this.f273346b;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.ipc.b
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TRTCIPCManager", 2, "onConnectBind " + str);
        }
        com.tencent.mobileqq.qqlive.trtc.ipc.b bVar = this.f273346b;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    public boolean c(@NonNull String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        if (!f273344c.contains(str)) {
            QLog.e("TRTCIPCManager", 1, "not support pending task " + str);
            return false;
        }
        for (b bVar : this.f273345a) {
            if (str.equals(bVar.f273349b)) {
                QLog.e("TRTCIPCManager", 1, "addPendingTask----action = " + str + " already exist, update and return");
                bVar.f273348a = System.currentTimeMillis();
                bVar.f273350c = bundle;
                return true;
            }
        }
        QLog.i("TRTCIPCManager", 1, "addPendingTask----action = " + str);
        b bVar2 = new b();
        bVar2.f273348a = System.currentTimeMillis();
        bVar2.f273349b = str;
        bVar2.f273350c = bundle;
        return this.f273345a.add(bVar2);
    }

    public synchronized void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f273345a.clear();
        this.f273346b = null;
        TRTCClientIPCModule.e().destroy();
        TRTCServerIPCModule.h().destroy();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("TRTCIPCManager", 1, "doPendingIPCTask enter----size = " + this.f273345a.size());
        int size = this.f273345a.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(this.f273345a.poll());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (m(bVar)) {
                QLog.i("TRTCIPCManager", 1, "doPendingIPCTask action = " + bVar.f273349b + " will Run");
                TRTCServerIPCModule.g(bVar.f273349b, bVar.f273350c, null);
            } else {
                QLog.i("TRTCIPCManager", 1, "doPendingIPCTask action = " + bVar.f273349b + " already expire, will discard");
            }
        }
        QLog.i("TRTCIPCManager", 1, "doPendingIPCTask end----size = " + this.f273345a.size());
    }

    public com.tencent.mobileqq.qqlive.trtc.a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.qqlive.trtc.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (l()) {
            QLog.d("TRTCIPCManager", 1, "return host engine!");
            return new com.tencent.mobileqq.qqlive.trtc.engine.b();
        }
        if (k()) {
            QLog.d("TRTCIPCManager", 1, "return not host, fake engine!");
            return new d();
        }
        throw new RuntimeException("don't support process");
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "com.tencent.mobileqq:tool";
    }

    public Class i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Class) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return TRTCPreloadService.class;
    }

    public boolean j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        QLog.d("TRTCIPCManager", 1, "isClientProcess: " + str);
        return "com.tencent.mobileqq".equals(str);
    }

    public void n(@NonNull String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        for (b bVar : this.f273345a) {
            if (str.equals(bVar.f273349b)) {
                QLog.e("TRTCIPCManager", 1, "updateTask----action = " + str);
                bVar.f273348a = System.currentTimeMillis();
                if (bundle != null) {
                    bVar.f273350c = bundle;
                }
            }
        }
    }
}
