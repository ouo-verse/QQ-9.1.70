package com.tencent.tgpa.lite.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f375926a;

    /* renamed from: b, reason: collision with root package name */
    private j f375927b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f375928c;

    /* renamed from: d, reason: collision with root package name */
    private g f375929d;

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f375930e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.tgpa.lite.e.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class RunnableC9909a implements Runnable {
            static IPatchRedirector $redirector_;

            RunnableC9909a() {
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
                    if (e.this.f375927b != null) {
                        e.this.f375927b.a(e.this.f375929d.a());
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    com.tencent.tgpa.lite.g.h.b("MSA HW oaid get exception. ", new Object[0]);
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            try {
                e.this.f375929d = new f(iBinder);
                new BaseThread(new RunnableC9909a()).start();
            } catch (Throwable th5) {
                th5.printStackTrace();
                com.tencent.tgpa.lite.g.h.b("MSA HW oaid get exception. ", new Object[0]);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                Log.d("TGPA_MID", "Huawei MSA onServiceDisconnected ");
            }
        }
    }

    public e(Context context, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) jVar);
            return;
        }
        this.f375928c = false;
        this.f375929d = null;
        this.f375930e = new a();
        this.f375926a = context;
        this.f375927b = jVar;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(this.f375926a.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(this.f375926a.getContentResolver(), "pps_track_limit");
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                    com.tencent.tgpa.lite.g.h.a("get huawei device id from setting failed!", new Object[0]);
                    return null;
                }
                com.tencent.tgpa.lite.g.h.a("get huawei device id from setting success!", new Object[0]);
                return string;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            InstalledAppListMonitor.getPackageInfo(this.f375926a.getPackageManager(), "com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            boolean bindService = this.f375926a.bindService(intent, this.f375930e, 1);
            this.f375928c = bindService;
            if (bindService) {
                com.tencent.tgpa.lite.g.h.c("bind huawei service success!", new Object[0]);
            } else {
                com.tencent.tgpa.lite.g.h.b("bind huawei service failed!", new Object[0]);
            }
        } catch (Exception e16) {
            com.tencent.tgpa.lite.g.h.b("bind huawei service exception. ", new Object[0]);
            e16.printStackTrace();
        }
    }
}
