package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqlive.data.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.util.WeakReference;

/* loaded from: classes17.dex */
public class TRTCServerIPCModule extends QIPCModule {
    static IPatchRedirector $redirector_;
    private WeakReference<Context> C;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f273334d;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.tencent.mobileqq.qqlive.trtc.ipc.b> f273335e;

    /* renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.tencent.mobileqq.qqlive.trtc.ipc.a> f273336f;

    /* renamed from: h, reason: collision with root package name */
    private volatile long f273337h;

    /* renamed from: i, reason: collision with root package name */
    private volatile int f273338i;

    /* renamed from: m, reason: collision with root package name */
    private TRTCInitCallback f273339m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final TRTCServerIPCModule f273342a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61654);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f273342a = new TRTCServerIPCModule("QQLiveServerIPCModule");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements EIPCOnGetConnectionListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TRTCServerIPCModule.this);
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCConnection);
            } else {
                QLog.d("TRTCServerIPCModule", 1, "onConnectBind");
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) eIPCConnection);
                return;
            }
            QLog.d("TRTCServerIPCModule", 1, "onConnectUnbind");
            if (eIPCConnection == null) {
                return;
            }
            QLog.e("TRTCServerIPCModule", 1, "qq live onConnectUnbind, [" + eIPCConnection.procName + "]");
            if (TextUtils.equals(eIPCConnection.procName, c.h().g())) {
                TRTCServerIPCModule.this.reset();
                Iterator it = TRTCServerIPCModule.this.f273335e.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mobileqq.qqlive.trtc.ipc.b) it.next()).a();
                }
            }
        }
    }

    TRTCServerIPCModule(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f273334d = new AtomicBoolean(false);
        this.f273335e = new CopyOnWriteArrayList<>();
        this.f273336f = new CopyOnWriteArrayList<>();
        this.f273337h = -1L;
        this.f273338i = 0;
        this.f273339m = null;
        this.C = null;
        m(c.h());
    }

    public static void g(String str, Bundle bundle, EIPCResultCallback eIPCResultCallback) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (h().n()) {
            if (QLog.isColorLevel()) {
                QLog.d("TRTCServerIPCModule", 2, "callClientAsync ========" + str);
            }
            QIPCServerHelper.getInstance().getServer().callClient(c.h().g(), 1, "QQLiveClientIPCModule", str, bundle2, eIPCResultCallback);
            return;
        }
        c.h().c(str, bundle);
    }

    public static TRTCServerIPCModule h() {
        return a.f273342a;
    }

    private boolean i() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f273337h != -1 && currentTimeMillis - this.f273337h <= 2000) {
            return false;
        }
        return true;
    }

    private void init() {
        if (this.f273334d.compareAndSet(false, true)) {
            QIPCServerHelper.getInstance().getServer().addListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bundle bundle) {
        int i3 = bundle.getInt("Key_trtc_engine_init_state");
        int i16 = bundle.getInt("Key_trtc_engine_init_code");
        if (QLog.isColorLevel()) {
            QLog.d("TRTCServerIPCModule", 2, "notifyEngineState " + i3 + ", code " + i16);
        }
        TRTCInitCallback tRTCInitCallback = this.f273339m;
        if (tRTCInitCallback != null) {
            tRTCInitCallback.onInitEvent(i3, i16);
            this.f273339m = null;
        }
        Iterator<com.tencent.mobileqq.qqlive.trtc.ipc.b> it = this.f273335e.iterator();
        while (it.hasNext()) {
            it.next().b(c.h().g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        QLog.e("TRTCServerIPCModule", 1, "---already---onBind---- ");
        this.f273338i = 1;
        c.h().n("Action_Client_Init_SDK", null);
        c.h().e();
    }

    private boolean n() {
        Context context;
        if (this.f273338i == 1) {
            QLog.d("TRTCServerIPCModule", 1, "tryConnect , already bind!");
            return true;
        }
        WeakReference<Context> weakReference = this.C;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context == null) {
            return false;
        }
        QLog.d("TRTCServerIPCModule", 1, "tryConnect startForegroundService " + this.f273337h);
        synchronized (this) {
            if (i()) {
                context.startService(new Intent(context.getApplicationContext(), (Class<?>) c.h().i()));
                this.f273337h = System.currentTimeMillis();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.f273339m = null;
        this.f273337h = -1L;
        this.f273338i = 2;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        reset();
        this.f273335e.clear();
        this.f273336f.clear();
    }

    public void initEngine(@NonNull Context context, @NonNull String str, TRTCInitCallback tRTCInitCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, str, tRTCInitCallback);
            return;
        }
        this.f273339m = tRTCInitCallback;
        this.C = new WeakReference<>(context.getApplicationContext());
        init();
        n();
        QLog.d("TRTCServerIPCModule", 1, "initEngine, bindstate : " + this.f273338i);
        Bundle bundle = new Bundle();
        bundle.putString(QQLiveIPCConstants.KEY_TRTC_CONFIG_APP_ID, str);
        if (n()) {
            g("Action_Client_Init_SDK", bundle, null);
        } else {
            QLog.e("TRTCServerIPCModule", 1, "now wait  init engine!");
            c.h().c("Action_Client_Init_SDK", bundle);
        }
    }

    public synchronized void l(com.tencent.mobileqq.qqlive.trtc.ipc.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            if (!this.f273336f.contains(aVar)) {
                this.f273336f.add(aVar);
            }
        }
    }

    public synchronized void m(@NonNull com.tencent.mobileqq.qqlive.trtc.ipc.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            if (!this.f273335e.contains(bVar)) {
                this.f273335e.add(bVar);
            }
        }
    }

    public synchronized void o(com.tencent.mobileqq.qqlive.trtc.ipc.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            this.f273336f.remove(aVar);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 3, this, str, bundle, Integer.valueOf(i3));
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("TRTCServerIPCModule", 1, "onCall action is empty!");
            return null;
        }
        QLog.i("TRTCServerIPCModule", 1, "======onCall=====action = " + str);
        ThreadManager.getUIHandler().post(new Runnable(str, bundle) { // from class: com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f273340d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f273341e;

            {
                this.f273340d = str;
                this.f273341e = bundle;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TRTCServerIPCModule.this, str, bundle);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if ("Action_Server_OnBind".equals(this.f273340d)) {
                    TRTCServerIPCModule.this.k();
                    return;
                }
                if ("Action_Server_Notify_Engine".equals(this.f273340d)) {
                    TRTCServerIPCModule.this.j(this.f273341e);
                    return;
                }
                Iterator it = TRTCServerIPCModule.this.f273336f.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.qqlive.trtc.ipc.a aVar = (com.tencent.mobileqq.qqlive.trtc.ipc.a) it.next();
                    if (aVar.k(this.f273340d, this.f273341e)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TRTCServerIPCModule", 2, "handle " + aVar.toString());
                            return;
                        }
                        return;
                    }
                }
            }
        });
        return null;
    }
}
