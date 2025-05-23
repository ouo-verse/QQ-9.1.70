package com.tencent.tmdownloader;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends com.tencent.tmdownloader.a<com.tencent.tmdownloader.internal.remote.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f380597a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
                c.this.getServiceInterface();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (c.this.mServiceInterface != 0) {
                try {
                    synchronized (c.this) {
                        com.tencent.tmdownloader.internal.remote.a aVar = (com.tencent.tmdownloader.internal.remote.a) c.this.mServiceInterface;
                        if (aVar != null) {
                            aVar.b();
                        }
                    }
                    return;
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                    return;
                } catch (NullPointerException unused) {
                    r.a("RemoteOpProxy", "initSDKReportManager2 failed,mServiceInterface");
                    return;
                }
            }
            try {
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.b();
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tmdownloader.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class RunnableC10000c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f380600a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f380601b;

        RunnableC10000c(int i3, String str) {
            this.f380600a = i3;
            this.f380601b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Integer.valueOf(i3), str);
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
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.a(this.f380600a, this.f380601b);
                } else {
                    c.this.initTMAssistantDownloadSDK();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements Runnable {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.d();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class e implements Runnable {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.f();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class f implements Runnable {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.e();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class g implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380606a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f380607b;

        g(String str, byte[] bArr) {
            this.f380606a = str;
            this.f380607b = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, bArr);
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
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.a(this.f380606a, this.f380607b);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class h implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380609a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f380610b;

        h(String str, String str2) {
            this.f380609a = str;
            this.f380610b = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, str2);
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
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.b(this.f380609a, this.f380610b);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class i implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380612a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f380613b;

        i(String str, long j3) {
            this.f380612a = str;
            this.f380613b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, Long.valueOf(j3));
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
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.a(this.f380612a, this.f380613b);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class j implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380615a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f380616b;

        j(String str, int i3) {
            this.f380615a = str;
            this.f380616b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, Integer.valueOf(i3));
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
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.a(this.f380615a, this.f380616b);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class k implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380618a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f380619b;

        k(String str, boolean z16) {
            this.f380618a = str;
            this.f380619b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, Boolean.valueOf(z16));
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
                com.tencent.tmdownloader.internal.remote.a serviceInterface = c.this.getServiceInterface();
                if (serviceInterface != null) {
                    serviceInterface.a(this.f380618a, this.f380619b);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    c() {
        super(GlobalUtil.getInstance().getContext(), "com.tencent.tmdownloader.RemoteOpProxy", "com.tencent.tmdownloader.internal.remote.RemoteOpService");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            initTMAssistantDownloadSDK();
        }
    }

    public static c a() {
        if (f380597a == null) {
            synchronized (c.class) {
                if (f380597a == null) {
                    f380597a = new c();
                }
            }
        }
        return f380597a;
    }

    public boolean b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        if (this.mServiceInterface == 0) {
            return false;
        }
        try {
            return ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).c(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.mServiceInterface != 0) {
            try {
                ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).e();
                return;
            } catch (RemoteException e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.tencent.tmassistantbase.util.e.a().post(new f());
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mServiceInterface != 0) {
            try {
                ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).f();
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.tencent.tmassistantbase.util.e.a().post(new e());
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.mServiceInterface != 0) {
            try {
                ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).d();
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.tencent.tmassistantbase.util.e.a().post(new d());
    }

    @Override // com.tencent.tmdownloader.a
    protected Intent getBindServiceIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Intent) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return new Intent(this.mContext, Class.forName(this.mServiceName));
    }

    @Override // com.tencent.tmdownloader.a
    protected void onDownloadSDKServiceInvalid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    @Override // com.tencent.tmdownloader.a
    protected void registerServiceCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    @Override // com.tencent.tmdownloader.a
    protected void stubAsInterface(IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) iBinder);
        } else {
            this.mServiceInterface = a.AbstractBinderC10005a.a(iBinder);
        }
    }

    @Override // com.tencent.tmdownloader.a
    protected void unRegisterServiceCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            com.tencent.tmassistantbase.util.e.a().post(new b());
        } else {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public int c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).intValue();
        }
        if (this.mServiceInterface == 0) {
            return 0;
        }
        try {
            return ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).a(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public long d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).longValue();
        }
        if (this.mServiceInterface == 0) {
            return 0L;
        }
        try {
            return ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).e(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public String e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        if (this.mServiceInterface == 0) {
            return "";
        }
        try {
            return ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).b(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            com.tencent.tmassistantbase.util.e.a().post(new RunnableC10000c(i3, str));
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        }
    }

    public void a(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (this.mServiceInterface != 0) {
            try {
                ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).a(str, bArr);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.tencent.tmassistantbase.util.e.a().post(new g(str, bArr));
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.mServiceInterface != 0) {
            try {
                ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).b(str, str2);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.tencent.tmassistantbase.util.e.a().post(new h(str, str2));
    }

    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Long.valueOf(j3));
            return;
        }
        if (this.mServiceInterface != 0) {
            try {
                ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).a(str, j3);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.tencent.tmassistantbase.util.e.a().post(new i(str, j3));
    }

    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        if (this.mServiceInterface != 0) {
            try {
                ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).a(str, i3);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.tencent.tmassistantbase.util.e.a().post(new j(str, i3));
    }

    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
            return;
        }
        if (this.mServiceInterface != 0) {
            try {
                ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).a(str, z16);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.tencent.tmassistantbase.util.e.a().post(new k(str, z16));
    }

    public byte[] a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (byte[]) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        if (this.mServiceInterface != 0) {
            try {
                return ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).d(str);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        com.tencent.tmassistantbase.util.e.a().post(new a());
        return new byte[0];
    }

    public int a(AppDetailReqParam appDetailReqParam, IGetAppInfoCallback iGetAppInfoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) appDetailReqParam, (Object) iGetAppInfoCallback)).intValue();
        }
        if (this.mServiceInterface == 0) {
            return -1;
        }
        try {
            return ((com.tencent.tmdownloader.internal.remote.a) this.mServiceInterface).a(appDetailReqParam, iGetAppInfoCallback);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }
}
