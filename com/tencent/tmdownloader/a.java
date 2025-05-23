package com.tencent.tmdownloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.q;
import com.tencent.tmassistantbase.util.r;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a<T extends IInterface> implements ServiceConnection {
    static IPatchRedirector $redirector_ = null;
    public static final String CONNTECTSTATE_CONNECTING = "CONNECTING";
    public static final String CONNTECTSTATE_FINISH = "FINISH";
    public static final String CONNTECTSTATE_INIT = "INIT";
    protected static final String TAG = "BaseIPCClient";
    protected String connectState;
    public String mClientKey;
    protected Context mContext;
    protected final Object mObjectLock;
    protected IInterface mServiceCallback;
    protected volatile T mServiceInterface;
    protected String mServiceName;
    protected final Object mThreadlock;

    /* compiled from: P */
    /* renamed from: com.tencent.tmdownloader.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class RunnableC9999a implements Runnable {
        static IPatchRedirector $redirector_;

        RunnableC9999a() {
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
            } else {
                a.this.onDownloadSDKServiceInvalid();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
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
                return;
            }
            try {
                if (a.this.mServiceInterface != null && a.this.mServiceCallback != null) {
                    q.a(a.this.mServiceName + "BaseIPCClient registerServiceCallback");
                    a.this.registerServiceCallback();
                }
            } catch (RemoteException unused) {
                a.this.onDownloadSDKServiceInvalid();
            } catch (Exception e16) {
                r.a(a.TAG, "<onServiceConnected> service wrong, e = " + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (a.this.mServiceInterface != null) {
                a aVar = a.this;
                if (aVar.mServiceCallback != null) {
                    try {
                        aVar.unRegisterServiceCallback();
                    } catch (Exception unused) {
                    }
                }
            }
            a aVar2 = a.this;
            if (aVar2.mContext != null && aVar2.mServiceInterface != null) {
                a aVar3 = a.this;
                aVar3.mContext.unbindService(aVar3);
            }
            a.this.mServiceInterface = null;
            a aVar4 = a.this;
            aVar4.mServiceCallback = null;
            aVar4.connectState = a.CONNTECTSTATE_INIT;
        }
    }

    public a(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, str2);
            return;
        }
        this.mServiceName = null;
        this.connectState = CONNTECTSTATE_INIT;
        this.mServiceInterface = null;
        this.mServiceCallback = null;
        this.mThreadlock = new Object();
        this.mObjectLock = new Object();
        this.mContext = context;
        this.mClientKey = str;
        this.mServiceName = str2;
    }

    protected abstract Intent getBindServiceIntent();

    /* JADX INFO: Access modifiers changed from: protected */
    public T getServiceInterface() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Context context = this.mContext;
        if (context != null && context.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
        }
        if (this.mServiceInterface == null) {
            initTMAssistantDownloadSDK();
            this.connectState = CONNTECTSTATE_CONNECTING;
            synchronized (this.mThreadlock) {
                boolean z17 = true;
                if (this.mServiceInterface != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (this.mServiceInterface != null || !CONNTECTSTATE_INIT.equals(this.connectState)) {
                    z17 = false;
                }
                if (!z16 && !z17) {
                    this.mThreadlock.wait(4999L);
                }
            }
        }
        if (this.mServiceInterface != null) {
            return this.mServiceInterface;
        }
        throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
    }

    public boolean initTMAssistantDownloadSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (CONNTECTSTATE_FINISH.equals(this.connectState)) {
            return true;
        }
        synchronized (this) {
            if (this.mServiceInterface != null) {
                this.connectState = CONNTECTSTATE_FINISH;
            } else {
                this.connectState = CONNTECTSTATE_INIT;
            }
        }
        if (CONNTECTSTATE_FINISH.equals(this.connectState)) {
            return true;
        }
        if (this.mContext == null) {
            this.mContext = GlobalUtil.getInstance().getContext();
        }
        boolean z16 = false;
        if (this.mContext == null || this.mServiceName == null) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Intent bindServiceIntent = getBindServiceIntent();
            if (bindServiceIntent == null) {
                return false;
            }
            z16 = this.mContext.bindService(bindServiceIntent, this, 1);
            q.a(this.mServiceName + ",BaseIPCClient initTMAssistantDownloadSDK bindService end,timeCost=" + (System.currentTimeMillis() - currentTimeMillis) + ",result=" + z16);
            return z16;
        } catch (Exception e16) {
            e16.printStackTrace();
            return z16;
        }
    }

    protected abstract void onDownloadSDKServiceInvalid();

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName, (Object) iBinder);
            return;
        }
        stubAsInterface(iBinder);
        this.connectState = CONNTECTSTATE_FINISH;
        synchronized (this.mThreadlock) {
            this.mThreadlock.notifyAll();
        }
        q.a(this.mServiceName + "BaseIPCClient onServiceConnected");
        com.tencent.tmassistantbase.util.e.a().post(new b());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName);
            return;
        }
        synchronized (this.mObjectLock) {
            this.mServiceInterface = null;
            this.connectState = CONNTECTSTATE_INIT;
        }
        synchronized (this.mThreadlock) {
            this.mThreadlock.notifyAll();
        }
        q.a(this.mServiceName + "BaseIPCClient onServiceDisconnected");
        com.tencent.tmassistantbase.util.e.a().post(new RunnableC9999a());
    }

    protected abstract void registerServiceCallback();

    protected abstract void stubAsInterface(IBinder iBinder);

    public void unInitTMAssistantDownloadSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            com.tencent.tmassistantbase.util.e.a().post(new c());
        }
    }

    protected abstract void unRegisterServiceCallback();
}
