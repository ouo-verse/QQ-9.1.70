package com.google.android.vending.expansion.downloader.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.d;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.luggage.wxa.ig.l;
import com.tencent.luggage.wxa.ig.s;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.File;
import n1.f;
import n1.g;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class DownloaderService extends CustomIntentService implements f {

    /* renamed from: a0, reason: collision with root package name */
    private static boolean f34563a0;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private int I;
    private ConnectivityManager J;
    private WifiManager K;
    private PackageInfo L;
    long M;
    long N;
    int P;
    long Q;
    long R;
    float S;
    private BroadcastReceiver T;
    private final g U;
    private final Messenger V;
    private Messenger W;
    private b X;
    private PendingIntent Y;
    private PendingIntent Z;

    /* renamed from: i, reason: collision with root package name */
    private boolean f34564i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f34565m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class GenerateSaveFileError extends Exception {
        private static final long serialVersionUID = 3465966015408936540L;
        String mMessage;
        int mStatus;

        public GenerateSaveFileError(int i3, String str) {
            this.mStatus = i3;
            this.mMessage = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class LVLRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final Context f34566d;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.google.android.vending.licensing.b f34567a;

            a(com.google.android.vending.licensing.b bVar) {
                this.f34567a = bVar;
            }

            @Override // com.google.android.vending.licensing.d
            public void allow(int i3) {
                int i16;
                try {
                    int g16 = this.f34567a.g();
                    c a16 = c.a(LVLRunnable.this.f34566d);
                    if (g16 != 0) {
                        i16 = 0;
                        for (int i17 = 0; i17 < g16; i17++) {
                            String d16 = this.f34567a.d(i17);
                            if (d16 != null) {
                                com.google.android.vending.expansion.downloader.impl.a aVar = new com.google.android.vending.expansion.downloader.impl.a(i17, d16, LVLRunnable.this.f34566d.getPackageName());
                                long e16 = this.f34567a.e(i17);
                                if (DownloaderService.this.x(a16, i17, d16, e16)) {
                                    i16 |= -1;
                                    aVar.a();
                                    aVar.f34571a = this.f34567a.f(i17);
                                    aVar.f34575e = e16;
                                    aVar.f34578h = i16;
                                    a16.j(aVar);
                                } else {
                                    com.google.android.vending.expansion.downloader.impl.a c16 = a16.c(aVar.f34573c);
                                    if (c16 == null) {
                                        Log.d("LVLDL", "file " + aVar.f34573c + " found. Not downloading.");
                                        aVar.f34578h = 200;
                                        aVar.f34575e = e16;
                                        aVar.f34576f = e16;
                                        aVar.f34571a = this.f34567a.f(i17);
                                        a16.j(aVar);
                                    } else if (c16.f34578h != 200) {
                                        c16.f34571a = this.f34567a.f(i17);
                                        a16.j(c16);
                                        i16 |= -1;
                                    }
                                }
                            }
                        }
                    } else {
                        i16 = 0;
                    }
                    try {
                        a16.o(InstalledAppListMonitor.getPackageInfo(LVLRunnable.this.f34566d.getPackageManager(), LVLRunnable.this.f34566d.getPackageName(), 0).versionCode, i16);
                        Class<?> cls = DownloaderService.this.getClass();
                        LVLRunnable lVLRunnable = LVLRunnable.this;
                        int G = DownloaderService.G(lVLRunnable.f34566d, DownloaderService.this.Y, cls);
                        if (G != 0) {
                            if (G == 1) {
                                Log.e("LVLDL", "In LVL checking loop!");
                                DownloaderService.this.X.a(15);
                                throw new RuntimeException("Error with LVL checking and database integrity");
                            }
                        } else {
                            DownloaderService.this.X.a(5);
                        }
                    } catch (PackageManager.NameNotFoundException e17) {
                        e17.printStackTrace();
                        throw new RuntimeException("Error with getting information from package name");
                    }
                } finally {
                    DownloaderService.F(false);
                }
            }

            @Override // com.google.android.vending.licensing.d
            public void applicationError(int i3) {
                try {
                    DownloaderService.this.X.a(16);
                } finally {
                    DownloaderService.F(false);
                }
            }

            @Override // com.google.android.vending.licensing.d
            public void dontAllow(int i3) {
                try {
                    if (i3 != 291) {
                        if (i3 == 561) {
                            DownloaderService.this.X.a(15);
                        }
                    }
                    DownloaderService.this.X.a(16);
                } finally {
                    DownloaderService.F(false);
                }
            }
        }

        LVLRunnable(Context context, PendingIntent pendingIntent) {
            this.f34566d = context;
            DownloaderService.this.Y = pendingIntent;
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloaderService.F(true);
            DownloaderService.this.X.a(2);
            com.google.android.vending.licensing.b bVar = new com.google.android.vending.licensing.b(this.f34566d, new com.google.android.vending.licensing.a(DownloaderService.this.v(), this.f34566d.getPackageName(), DeviceInfoMonitor.getString(this.f34566d.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID)));
            bVar.h();
            new LicenseChecker(this.f34566d, bVar, DownloaderService.this.u()).f(new a(bVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final Service f34569a;

        a(Service service) {
            this.f34569a = service;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloaderService.this.D();
            if (DownloaderService.this.G && !DownloaderService.n()) {
                Log.d("LVLDL", "InnerBroadcastReceiver Called");
                Intent intent2 = new Intent(context, this.f34569a.getClass());
                intent2.putExtra("EPI", DownloaderService.this.Y);
                context.startService(intent2);
            }
        }
    }

    public DownloaderService() {
        super("LVLDownloadService");
        g a16 = n1.c.a(this);
        this.U = a16;
        this.V = a16.a();
    }

    public static boolean A(int i3) {
        if ((i3 >= 200 && i3 < 300) || (i3 >= 400 && i3 < 600)) {
            return true;
        }
        return false;
    }

    public static boolean B(int i3) {
        if (i3 >= 400 && i3 < 600) {
            return true;
        }
        return false;
    }

    private void E(long j3) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager == null) {
            Log.e("LVLDL", "couldn't get alarm manager");
            return;
        }
        String r16 = r();
        Intent intent = new Intent("android.intent.action.DOWNLOAD_WAKEUP");
        intent.putExtra("EPI", this.Y);
        intent.setClassName(getPackageName(), r16);
        this.Z = PendingIntent.getBroadcast(this, 0, intent, 1073741824);
        alarmManager.set(0, System.currentTimeMillis() + j3, this.Z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void F(boolean z16) {
        synchronized (DownloaderService.class) {
            f34563a0 = z16;
        }
    }

    public static int G(Context context, PendingIntent pendingIntent, Class<?> cls) throws PackageManager.NameNotFoundException {
        return H(context, pendingIntent, context.getPackageName(), cls.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    public static int H(Context context, PendingIntent pendingIntent, String str, String str2) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
        c a16 = c.a(context);
        ?? y16 = y(a16, packageInfo);
        if (a16.f34604f == 0) {
            com.google.android.vending.expansion.downloader.impl.a[] e16 = a16.e();
            if (e16 != null) {
                for (com.google.android.vending.expansion.downloader.impl.a aVar : e16) {
                    if (!n1.d.a(context, aVar.f34573c, aVar.f34575e, true)) {
                        a16.q(-1);
                    }
                }
            }
            if (y16 != 1 || y16 == 2) {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.putExtra("EPI", pendingIntent);
                context.startService(intent);
            }
            return y16;
        }
        y16 = 2;
        if (y16 != 1) {
        }
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        intent2.putExtra("EPI", pendingIntent);
        context.startService(intent2);
        return y16;
    }

    private void J(NetworkInfo networkInfo) {
        boolean z16 = this.f34564i;
        boolean z17 = this.f34565m;
        boolean z18 = this.C;
        boolean z19 = this.D;
        boolean z26 = this.E;
        boolean z27 = false;
        if (networkInfo != null) {
            this.D = networkInfo.isRoaming();
            this.f34565m = networkInfo.isFailover();
            this.f34564i = networkInfo.isConnected();
            K(NetworkMonitor.getType(networkInfo), NetworkMonitor.getSubtype(networkInfo));
        } else {
            this.D = false;
            this.f34565m = false;
            this.f34564i = false;
            K(-1, -1);
        }
        if (this.G || z16 != this.f34564i || z17 != this.f34565m || z18 != this.C || z19 != this.D || z26 != this.E) {
            z27 = true;
        }
        this.G = z27;
    }

    private void K(int i3, int i16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 6) {
                    if (i3 != 7 && i3 != 9) {
                        return;
                    }
                } else {
                    this.C = true;
                    this.E = true;
                    this.F = true;
                    return;
                }
            }
            this.C = false;
            this.E = false;
            this.F = false;
            return;
        }
        this.C = true;
        switch (i16) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                this.E = false;
                this.F = false;
                return;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
                this.E = true;
                this.F = false;
                return;
            case 12:
            default:
                this.C = false;
                this.E = false;
                this.F = false;
                return;
            case 13:
            case 14:
            case 15:
                this.E = true;
                this.F = true;
                return;
        }
    }

    static /* synthetic */ boolean n() {
        return z();
    }

    private void o() {
        if (this.Z != null) {
            AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager == null) {
                Log.e("LVLDL", "couldn't get alarm manager");
            } else {
                alarmManager.cancel(this.Z);
                this.Z = null;
            }
        }
    }

    private static boolean y(c cVar, PackageInfo packageInfo) {
        if (cVar.f34603e != packageInfo.versionCode) {
            return true;
        }
        return false;
    }

    private static synchronized boolean z() {
        boolean z16;
        synchronized (DownloaderService.class) {
            z16 = f34563a0;
        }
        return z16;
    }

    public void C(long j3) {
        long j16;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j17 = this.R;
        if (0 != j17) {
            float f16 = ((float) (j3 - this.Q)) / ((float) (uptimeMillis - j17));
            float f17 = this.S;
            if (0.0f != f17) {
                this.S = (f16 * 0.005f) + (f17 * 0.995f);
            } else {
                this.S = f16;
            }
            j16 = ((float) (this.N - j3)) / this.S;
        } else {
            j16 = -1;
        }
        this.R = uptimeMillis;
        this.Q = j3;
        this.X.b(new DownloadProgressInfo(this.N, j3, j16, this.S));
    }

    void D() {
        if (this.J == null) {
            this.J = (ConnectivityManager) getSystemService("connectivity");
        }
        if (this.K == null) {
            this.K = (WifiManager) getApplicationContext().getSystemService("wifi");
        }
        ConnectivityManager connectivityManager = this.J;
        if (connectivityManager == null) {
            Log.w("LVLDL", "couldn't get connectivity manager to poll network state");
        } else {
            J(connectivityManager.getActiveNetworkInfo());
        }
    }

    public void I(Context context) {
        Context applicationContext = context.getApplicationContext();
        new Handler(applicationContext.getMainLooper()).post(new LVLRunnable(applicationContext, this.Y));
    }

    @Override // n1.f
    public void a() {
        this.H = 1;
        this.I = 193;
    }

    @Override // n1.f
    public void b(int i3) {
        c.a(this).m(i3);
    }

    @Override // n1.f
    public void c() {
        this.H = 1;
        this.I = P2VGlobalConfig.WATER_MARKER_WIDTH;
    }

    @Override // n1.f
    public void d(Messenger messenger) {
        this.W = messenger;
        this.X.e(messenger);
    }

    @Override // n1.f
    public void e() {
        if (this.H == 1) {
            this.H = 0;
        }
        Intent intent = new Intent(this, getClass());
        intent.putExtra("EPI", this.Y);
        startService(intent);
    }

    @Override // n1.f
    public void f() {
        this.X.c();
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService
    protected void g(Intent intent) {
        int i3;
        int i16;
        boolean z16 = true;
        F(true);
        try {
            c a16 = c.a(this);
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("EPI");
            if (pendingIntent != null) {
                this.X.d(pendingIntent);
                this.Y = pendingIntent;
            } else {
                PendingIntent pendingIntent2 = this.Y;
                if (pendingIntent2 != null) {
                    this.X.d(pendingIntent2);
                } else {
                    Log.e("LVLDL", "Downloader started in bad state without notification intent.");
                    return;
                }
            }
            if (y(a16, this.L)) {
                I(this);
                return;
            }
            com.google.android.vending.expansion.downloader.impl.a[] e16 = a16.e();
            long j3 = 0;
            this.M = 0L;
            this.N = 0L;
            this.P = e16.length;
            for (com.google.android.vending.expansion.downloader.impl.a aVar : e16) {
                if (aVar.f34578h == 200 && !n1.d.a(this, aVar.f34573c, aVar.f34575e, true)) {
                    aVar.f34578h = 0;
                    aVar.f34576f = 0L;
                }
                this.N += aVar.f34575e;
                this.M += aVar.f34576f;
            }
            D();
            if (this.T == null) {
                this.T = new a(this);
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                registerReceiver(this.T, intentFilter);
            }
            int length = e16.length;
            int i17 = 0;
            while (i17 < length) {
                com.google.android.vending.expansion.downloader.impl.a aVar2 = e16[i17];
                long j16 = aVar2.f34576f;
                if (aVar2.f34578h != 200) {
                    DownloadThread downloadThread = new DownloadThread(aVar2, this, this.X);
                    o();
                    E(5000L);
                    downloadThread.u();
                    o();
                }
                a16.n(aVar2);
                int i18 = aVar2.f34578h;
                if (i18 != 200) {
                    if (i18 != 403) {
                        if (i18 != 487) {
                            if (i18 != 490) {
                                if (i18 != 498) {
                                    if (i18 != 499) {
                                        switch (i18) {
                                            case 193:
                                                i16 = 7;
                                                i3 = i16;
                                                z16 = false;
                                                break;
                                            case 194:
                                            case 195:
                                                i3 = 6;
                                                break;
                                            case 196:
                                            case 197:
                                                WifiManager wifiManager = this.K;
                                                if (wifiManager != null && !wifiManager.isWifiEnabled()) {
                                                    i3 = 8;
                                                    break;
                                                } else {
                                                    i3 = 9;
                                                    break;
                                                }
                                                break;
                                            default:
                                                i16 = 19;
                                                i3 = i16;
                                                z16 = false;
                                                break;
                                        }
                                    } else {
                                        i3 = 14;
                                    }
                                } else {
                                    i3 = 17;
                                }
                            } else {
                                i3 = 18;
                            }
                        } else {
                            aVar2.f34576f = j3;
                            a16.j(aVar2);
                            i3 = 13;
                        }
                        if (z16) {
                            E(60000L);
                        } else {
                            o();
                        }
                        this.X.a(i3);
                        return;
                    }
                    I(this);
                    return;
                }
                this.M += aVar2.f34576f - j16;
                a16.o(this.L.versionCode, 0);
                i17++;
                j3 = 0;
            }
            this.X.a(5);
        } finally {
            F(false);
        }
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService
    protected boolean h() {
        if (c.a(this).f34604f == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d("LVLDL", "Service Bound");
        return this.V.getBinder();
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            this.L = InstalledAppListMonitor.getPackageInfo(getPackageManager(), getPackageName(), 0);
            this.X = new b(this, getPackageManager().getApplicationLabel(getApplicationInfo()));
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.google.android.vending.expansion.downloader.impl.CustomIntentService, android.app.Service
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.T;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.T = null;
        }
        this.U.disconnect(this);
        super.onDestroy();
    }

    public String p(String str, long j3) throws GenerateSaveFileError {
        String q16 = q(str);
        File file = new File(q16);
        if (n1.d.j()) {
            if (!file.exists()) {
                if (n1.d.d(n1.d.g(q16)) >= j3) {
                    return q16;
                }
                throw new GenerateSaveFileError(l.CTRL_INDEX, "insufficient space on external storage");
            }
            Log.d("LVLDL", "File already exists: " + q16);
            throw new GenerateSaveFileError(488, "requested destination file already exists");
        }
        Log.d("LVLDL", "External media not mounted: " + q16);
        throw new GenerateSaveFileError(s.CTRL_INDEX, "external media is not yet mounted");
    }

    public String q(String str) {
        return n1.d.h(this) + File.separator + str + ".tmp";
    }

    public abstract String r();

    public int s() {
        return this.H;
    }

    public int t(c cVar) {
        if (this.f34564i) {
            if (!this.C) {
                return 1;
            }
            int i3 = cVar.f34605g;
            if (this.D) {
                return 5;
            }
            if ((i3 & 1) != 0) {
                return 1;
            }
            return 6;
        }
        return 2;
    }

    public abstract String u();

    public abstract byte[] v();

    public int w() {
        return this.I;
    }

    public boolean x(c cVar, int i3, String str, long j3) {
        String str2;
        com.google.android.vending.expansion.downloader.impl.a c16 = cVar.c(str);
        if (c16 != null && (str2 = c16.f34573c) != null) {
            if (str.equals(str2)) {
                return false;
            }
            File file = new File(n1.d.c(this, str2));
            if (file.exists()) {
                file.delete();
            }
        }
        return true ^ n1.d.a(this, str, j3, true);
    }
}
