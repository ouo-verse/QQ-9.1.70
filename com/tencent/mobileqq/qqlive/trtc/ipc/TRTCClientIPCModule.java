package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.data.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.trtc.audio.d;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.e;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import eipc.EIPClientConnectListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

/* loaded from: classes17.dex */
public class TRTCClientIPCModule extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.tencent.mobileqq.qqlive.trtc.ipc.a> f273325d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f273326e;

    /* renamed from: f, reason: collision with root package name */
    private b f273327f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements TRTCInitCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TRTCClientIPCModule.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback
        public void onInitEvent(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("Key_trtc_engine_init_state", i3);
            bundle.putInt("Key_trtc_engine_init_code", i16);
            TRTCClientIPCModule.d("Action_Server_Notify_Engine", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b implements EIPClientConnectListener, EIPCOnGetConnectionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        AtomicInteger f273331d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TRTCClientIPCModule.this);
            } else {
                this.f273331d = new AtomicInteger(0);
            }
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            if (this.f273331d.get() == 2) {
                return true;
            }
            return false;
        }

        @Override // eipc.EIPClientConnectListener
        public void connectFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f273331d.set(3);
                QLog.e("TRTCClientIPCModule", 1, "qq live host connectFailed");
            }
        }

        @Override // eipc.EIPClientConnectListener
        public void connectSuccess(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCConnection);
                return;
            }
            this.f273331d.set(2);
            QLog.e("TRTCClientIPCModule", 1, "qq live connectSuccess, server[" + eIPCConnection.procName + "]");
            TRTCClientIPCModule.d("Action_Server_OnBind", null);
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) eIPCConnection);
                return;
            }
            if (eIPCConnection == null) {
                return;
            }
            QLog.e("TRTCClientIPCModule", 1, "ilive onConnectBind, [" + eIPCConnection.procName + "]");
            if (com.tencent.mobileqq.qqlive.trtc.ipc.c.h().j(eIPCConnection.procName)) {
                this.f273331d.set(2);
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) eIPCConnection);
                return;
            }
            if (eIPCConnection == null) {
                return;
            }
            QLog.e("TRTCClientIPCModule", 1, "ilive onConnectUnbind, [" + eIPCConnection.procName + "]");
            if (com.tencent.mobileqq.qqlive.trtc.ipc.c.h().j(eIPCConnection.procName)) {
                this.f273331d.set(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final TRTCClientIPCModule f273333a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61624);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f273333a = new TRTCClientIPCModule("QQLiveClientIPCModule");
            }
        }
    }

    TRTCClientIPCModule(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        CopyOnWriteArrayList<com.tencent.mobileqq.qqlive.trtc.ipc.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f273325d = copyOnWriteArrayList;
        this.f273326e = null;
        this.f273327f = new b();
        copyOnWriteArrayList.add(new d());
        copyOnWriteArrayList.add(new com.tencent.mobileqq.qqlive.trtc.room.b());
        copyOnWriteArrayList.add(new e());
    }

    public static void d(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (QLog.isColorLevel()) {
            QLog.d("TRTCClientIPCModule", 2, "call server " + str);
        }
        QIPCClientHelper.getInstance().getClient().callServer("QQLiveServerIPCModule", str, bundle, null);
    }

    public static TRTCClientIPCModule e() {
        return c.f273333a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, Bundle bundle) {
        Iterator<com.tencent.mobileqq.qqlive.trtc.ipc.a> it = this.f273325d.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.qqlive.trtc.ipc.a next = it.next();
            if (next.h(str, bundle)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TRTCClientIPCModule", 2, "handle " + next.toString());
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, Bundle bundle) {
        if ("Action_Client_Init_SDK".equals(str)) {
            h(bundle);
        } else if ("Action_Client_Destroy_SDK".equals(str)) {
            com.tencent.mobileqq.qqlive.trtc.b.r().h();
        } else {
            return false;
        }
        return true;
    }

    private void h(Bundle bundle) {
        Context context;
        WeakReference<Context> weakReference = this.f273326e;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (bundle != null && context != null) {
            com.tencent.mobileqq.qqlive.trtc.b.r().w(context, bundle.getString(QQLiveIPCConstants.KEY_TRTC_CONFIG_APP_ID), new a());
        }
    }

    private void i() {
        if (this.f273327f.a()) {
            return;
        }
        QLog.d("TRTCClientIPCModule", 1, "qq innerInit live connect, [" + this.f273327f.f273331d.get() + "]");
        try {
            QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
            EIPCClient client = qIPCClientHelper.getClient();
            client.unRegisterModule(this);
            qIPCClientHelper.register(this);
            client.addListener(this.f273327f);
            client.connect(this.f273327f);
        } catch (Throwable th5) {
            QLog.e("TRTCClientIPCModule", 1, "LiteLiveSDKClientIPCModule create error", th5);
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f273325d.clear();
        }
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f273327f = new b();
        this.f273326e = new WeakReference<>(context.getApplicationContext());
        i();
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("TRTCClientIPCModule", 1, "onCall action is empty!");
            return null;
        }
        QLog.i("TRTCClientIPCModule", 1, "======onCall=====action = " + str);
        ThreadManager.getUIHandler().post(new Runnable(str, bundle) { // from class: com.tencent.mobileqq.qqlive.trtc.ipc.TRTCClientIPCModule.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f273328d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f273329e;

            {
                this.f273328d = str;
                this.f273329e = bundle;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TRTCClientIPCModule.this, str, bundle);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (!TRTCClientIPCModule.this.g(this.f273328d, this.f273329e)) {
                    TRTCClientIPCModule.this.f(this.f273328d, this.f273329e);
                }
            }
        });
        return null;
    }
}
