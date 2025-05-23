package com.google.android.vending.licensing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.vending.licensing.util.Base64DecoderException;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import o.a;
import o.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LicenseChecker implements ServiceConnection {
    private static final SecureRandom F = new SecureRandom();
    private final String C;
    private final Set<e> D = new HashSet();
    private final Queue<e> E = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    private o.b f34610d;

    /* renamed from: e, reason: collision with root package name */
    private PublicKey f34611e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f34612f;

    /* renamed from: h, reason: collision with root package name */
    private final h f34613h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f34614i;

    /* renamed from: m, reason: collision with root package name */
    private final String f34615m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class ResultListener extends a.AbstractBinderC10875a {

        /* renamed from: d, reason: collision with root package name */
        private final e f34616d;

        /* renamed from: e, reason: collision with root package name */
        private Runnable f34617e;

        public ResultListener(e eVar) {
            this.f34616d = eVar;
            this.f34617e = new Runnable() { // from class: com.google.android.vending.licensing.LicenseChecker.ResultListener.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("LicenseChecker", "Check timed out.");
                    ResultListener resultListener = ResultListener.this;
                    LicenseChecker.this.l(resultListener.f34616d);
                    ResultListener resultListener2 = ResultListener.this;
                    LicenseChecker.this.h(resultListener2.f34616d);
                }
            };
            Z();
        }

        private void Z() {
            Log.i("LicenseChecker", "Start monitoring timeout.");
            LicenseChecker.this.f34614i.postDelayed(this.f34617e, 10000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x() {
            Log.i("LicenseChecker", "Clearing timeout.");
            LicenseChecker.this.f34614i.removeCallbacks(this.f34617e);
        }

        @Override // o.a
        public void d0(final int i3, final String str, final String str2) {
            LicenseChecker.this.f34614i.post(new Runnable() { // from class: com.google.android.vending.licensing.LicenseChecker.ResultListener.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("LicenseChecker", "Received response.");
                    if (LicenseChecker.this.D.contains(ResultListener.this.f34616d)) {
                        ResultListener.this.x();
                        ResultListener.this.f34616d.g(LicenseChecker.this.f34611e, i3, str, str2);
                        ResultListener resultListener = ResultListener.this;
                        LicenseChecker.this.h(resultListener.f34616d);
                    }
                }
            });
        }
    }

    public LicenseChecker(Context context, h hVar, String str) {
        this.f34612f = context;
        this.f34613h = hVar;
        this.f34611e = j(str);
        String packageName = context.getPackageName();
        this.f34615m = packageName;
        this.C = k(context, packageName);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("background thread");
        baseHandlerThread.start();
        this.f34614i = new Handler(baseHandlerThread.getLooper());
    }

    private void g() {
        if (this.f34610d != null) {
            try {
                this.f34612f.unbindService(this);
            } catch (IllegalArgumentException unused) {
                Log.e("LicenseChecker", "Unable to unbind from licensing service (already unbound)");
            }
            this.f34610d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(e eVar) {
        this.D.remove(eVar);
        if (this.D.isEmpty()) {
            g();
        }
    }

    private int i() {
        return F.nextInt();
    }

    private static PublicKey j(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(o1.a.a(str)));
        } catch (Base64DecoderException e16) {
            Log.e("LicenseChecker", "Could not decode from Base64.");
            throw new IllegalArgumentException(e16);
        } catch (NoSuchAlgorithmException e17) {
            throw new RuntimeException(e17);
        } catch (InvalidKeySpecException e18) {
            Log.e("LicenseChecker", "Invalid key specification.");
            throw new IllegalArgumentException(e18);
        }
    }

    private static String k(Context context, String str) {
        try {
            return String.valueOf(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("LicenseChecker", "Package not found. could not get version code.");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(e eVar) {
        this.f34613h.a(291, null);
        if (this.f34613h.b()) {
            eVar.a().allow(291);
        } else {
            eVar.a().dontAllow(291);
        }
    }

    private void n() {
        while (true) {
            e poll = this.E.poll();
            if (poll != null) {
                try {
                    Log.i("LicenseChecker", "Calling checkLicense on service for " + poll.c());
                    this.f34610d.V((long) poll.b(), poll.c(), new ResultListener(poll));
                    this.D.add(poll);
                } catch (RemoteException e16) {
                    Log.w("LicenseChecker", "RemoteException in checkLicense call.", e16);
                    l(poll);
                }
            } else {
                return;
            }
        }
    }

    public synchronized void f(d dVar) {
        if (this.f34613h.b()) {
            Log.i("LicenseChecker", "Using cached license response");
            dVar.allow(256);
        } else {
            e eVar = new e(this.f34613h, new f(), dVar, i(), this.f34615m, this.C);
            if (this.f34610d == null) {
                Log.i("LicenseChecker", "Binding to licensing service.");
                try {
                    if (this.f34612f.bindService(new Intent(new String(o1.a.a("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U="))).setPackage(new String(o1.a.a("Y29tLmFuZHJvaWQudmVuZGluZw=="))), this, 1)) {
                        this.E.offer(eVar);
                    } else {
                        Log.e("LicenseChecker", "Could not bind to service.");
                        l(eVar);
                    }
                } catch (Base64DecoderException e16) {
                    e16.printStackTrace();
                } catch (SecurityException unused) {
                    dVar.applicationError(6);
                }
            } else {
                this.E.offer(eVar);
                n();
            }
        }
    }

    public synchronized void m() {
        g();
        this.f34614i.getLooper().quit();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f34610d = b.a.j(iBinder);
        n();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        Log.w("LicenseChecker", "Service unexpectedly disconnected.");
        this.f34610d = null;
    }
}
