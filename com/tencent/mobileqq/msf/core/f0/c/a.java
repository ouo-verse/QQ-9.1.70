package com.tencent.mobileqq.msf.core.f0.c;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msfcore.MSFKernel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements com.tencent.mobileqq.msf.core.y.d, IWeakNetStatusHandler {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    public static final String f248021f = "MSFMultiNetworkChannelManager";

    /* renamed from: g, reason: collision with root package name */
    public static final int f248022g = 60000;

    /* renamed from: h, reason: collision with root package name */
    public static final int f248023h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static final int f248024i = 2;

    /* renamed from: a, reason: collision with root package name */
    private final MSFKernel f248025a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f248026b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Network f248027c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f248028d;

    /* renamed from: e, reason: collision with root package name */
    private final C8076a f248029e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.f0.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C8076a extends ConnectivityManager.NetworkCallback {
        static IPatchRedirector $redirector_;

        public C8076a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) network);
                return;
            }
            QLog.d(a.f248021f, 1, "[MobileNetworkCallBack] onAvailable, Network:" + network);
            a.this.a(network);
            a.this.f248026b.removeMessages(2);
            Message obtainMessage = a.this.f248026b.obtainMessage(1);
            obtainMessage.obj = Long.valueOf(network.getNetworkHandle());
            a.this.f248026b.sendMessageAtFrontOfQueue(obtainMessage);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                try {
                    Network c16 = a.this.c();
                    QLog.d(a.f248021f, 1, "[MobileNetworkCallBack] onLost, Network:" + network + ", mBindNetwork: " + c16);
                    if (c16 != null && network != null && c16.getNetworkHandle() == network.getNetworkHandle()) {
                        a.this.b();
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e(a.f248021f, 1, "MobileNetworkCallBack, onLost error,", e16);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d(a.f248021f, 1, "[MobileNetworkCallBack] onUnavailable");
                a.this.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class b extends Handler {
        static IPatchRedirector $redirector_;

        public b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) looper);
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
                try {
                    a.this.f248025a.updateSidewayNetId(((Long) message.obj).longValue());
                    return;
                } catch (Exception e16) {
                    QLog.d(a.f248021f, 1, "handleMessage MOBILE_NETWORK_AVAILABLE error", e16);
                    return;
                }
            }
            try {
                if (i3 == 2) {
                    try {
                        a.this.a((Network) null);
                        a.this.f248025a.updateSidewayNetId(0L);
                    } catch (Exception e17) {
                        QLog.d(a.f248021f, 1, "handleMessage MOBILE_NETWORK_CLOSE error", e17);
                    }
                }
            } finally {
                a.this.e();
            }
        }
    }

    public a(MSFKernel mSFKernel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mSFKernel);
            return;
        }
        this.f248027c = null;
        this.f248028d = new AtomicInteger(0);
        this.f248029e = new C8076a();
        this.f248025a = mSFKernel;
        com.tencent.mobileqq.msf.core.y.a.h().a(this);
        AppNetConnInfo.registerWeakNetStatusHandler(BaseApplication.getContext(), this);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(q.f249799n);
        baseHandlerThread.start();
        this.f248026b = new b(baseHandlerThread.getLooper());
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onNormalToWeakNet(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            d();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            a(60000);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (a(c(), 0)) {
            a();
        }
        if (MsfService.getCore().isWeakNet()) {
            d();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onWeakNetToNormal(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            a(60000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f248026b.removeMessages(1);
        this.f248026b.removeMessages(2);
        this.f248026b.sendMessageAtFrontOfQueue(this.f248026b.obtainMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Network c() {
        return this.f248027c;
    }

    private void d() {
        ConnectivityManager connectivityManager;
        NetConnInfoCenter.checkConnInfo();
        if (NetConnInfoCenter.isMobileConn() || (connectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")) == null) {
            return;
        }
        try {
            if (this.f248028d.compareAndSet(0, 1)) {
                connectivityManager.requestNetwork(new NetworkRequest.Builder().addCapability(12).addTransportType(0).build(), this.f248029e);
                QLog.d(f248021f, 1, "requestMobileNetwork refCount=" + this.f248028d.get() + ", mobileCallbackObj=" + Integer.toHexString(this.f248029e.hashCode()));
            }
        } catch (Exception e16) {
            this.f248028d.set(0);
            QLog.e(f248021f, 1, "requestMobileNetwork error, ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity");
            if (connectivityManager != null && this.f248028d.compareAndSet(1, 0)) {
                connectivityManager.unregisterNetworkCallback(this.f248029e);
                QLog.i(f248021f, 2, "unregisterMobileNetworkCallback refCount=" + this.f248028d.get() + ", mobileCallbackObj=" + Integer.toHexString(this.f248029e.hashCode()));
            }
        } catch (Throwable th5) {
            this.f248028d.set(0);
            QLog.e(f248021f, 1, "unregisterMobileNetworkCallback error, ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Network network) {
        this.f248027c = network;
    }

    private void a(int i3) {
        this.f248026b.removeMessages(2);
        this.f248026b.sendEmptyMessageDelayed(2, i3);
    }

    private void a() {
        this.f248026b.removeMessages(2);
    }

    @SuppressLint({"MissingPermission"})
    private boolean a(Network network, int i3) {
        ConnectivityManager connectivityManager;
        if (network == null || (connectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return false;
            }
            return NetworkMonitor.hasTransport(networkCapabilities, i3);
        } catch (Exception e16) {
            QLog.e(f248021f, 1, "isNetworkOpened error", e16);
            return false;
        }
    }
}
