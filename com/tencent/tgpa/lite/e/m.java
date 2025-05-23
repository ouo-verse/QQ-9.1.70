package com.tencent.tgpa.lite.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tgpa.lite.e.n;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f375947a;

    /* renamed from: b, reason: collision with root package name */
    private j f375948b;

    /* renamed from: c, reason: collision with root package name */
    private n f375949c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f375950d;

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f375951e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
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
                m.this.f375949c = n.a.a(iBinder);
                if (m.this.b()) {
                    com.tencent.tgpa.lite.g.h.a("MSA OPPO supported, oaid:" + m.this.a("OUID"), new Object[0]);
                    if (m.this.f375948b != null) {
                        m.this.f375948b.a(m.this.a("OUID"));
                    }
                } else {
                    com.tencent.tgpa.lite.g.h.d("MSA OPPO not supported", new Object[0]);
                }
            } catch (Throwable th5) {
                com.tencent.tgpa.lite.g.h.b("MSA OPPO oaid get exception.", new Object[0]);
                th5.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                Log.d("TGPA_MID", "OPPO MSA onServiceDisconnected ");
            }
        }
    }

    public m(Context context, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) jVar);
            return;
        }
        this.f375951e = new a();
        this.f375947a = context;
        this.f375948b = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long longVersionCode;
        try {
            PackageManager packageManager = this.f375947a.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, "com.heytap.openid", 0);
                if (Build.VERSION.SDK_INT < 28) {
                    return packageInfo != null && packageInfo.versionCode >= 1;
                }
                if (packageInfo != null) {
                    longVersionCode = packageInfo.getLongVersionCode();
                    if (longVersionCode >= 1) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e16) {
                e16.printStackTrace();
                return false;
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        Signature[] signatureArr;
        String str2 = "";
        if (!b() || !this.f375950d) {
            return "";
        }
        String packageName = this.f375947a.getPackageName();
        try {
            signatureArr = InstalledAppListMonitor.getPackageInfo(this.f375947a.getPackageManager(), packageName, 64).signatures;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest == null) {
                    return "";
                }
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb5 = new StringBuilder();
                for (byte b16 : digest) {
                    sb5.append(Integer.toHexString((b16 & 255) | 256).substring(1, 3));
                }
                str2 = sb5.toString();
            } catch (NoSuchAlgorithmException e17) {
                e17.printStackTrace();
            }
        }
        return this.f375949c.a(packageName, str2, str);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean bindService = this.f375947a.bindService(intent, this.f375951e, 1);
            this.f375950d = bindService;
            if (bindService) {
                com.tencent.tgpa.lite.g.h.c("bind OPPO service success!", new Object[0]);
            } else {
                com.tencent.tgpa.lite.g.h.b("bind OPPO service failed!", new Object[0]);
            }
        } catch (Exception e16) {
            com.tencent.tgpa.lite.g.h.b("bind OPPO service exception. ", new Object[0]);
            e16.printStackTrace();
        }
    }
}
