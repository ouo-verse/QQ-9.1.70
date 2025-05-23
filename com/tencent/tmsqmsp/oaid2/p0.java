package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tmsqmsp.oaid2.o0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class p0 {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final p0 f380852f;

    /* renamed from: a, reason: collision with root package name */
    public o0 f380853a;

    /* renamed from: b, reason: collision with root package name */
    public String f380854b;

    /* renamed from: c, reason: collision with root package name */
    public String f380855c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f380856d;

    /* renamed from: e, reason: collision with root package name */
    public ServiceConnection f380857e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    final class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p0.this);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            p0.this.f380853a = o0.a.a(iBinder);
            synchronized (p0.this.f380856d) {
                p0.this.f380856d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                p0.this.f380853a = null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60756);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f380852f = new p0();
        }
    }

    public p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f380856d = new Object();
            this.f380857e = new a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r6.versionCode > 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Context context) {
        PackageInfo packageInfo;
        long longVersionCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        boolean z16 = false;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.heytap.openid", 0);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (Build.VERSION.SDK_INT < 28) {
            if (packageInfo != null) {
            }
            return z16;
        }
        if (packageInfo != null) {
            longVersionCode = packageInfo.getLongVersionCode();
            if (longVersionCode < 1) {
            }
            z16 = true;
        }
        return z16;
        th5.printStackTrace();
        return z16;
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) str);
        }
        if (TextUtils.isEmpty(this.f380854b)) {
            this.f380854b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f380855c)) {
            String str2 = null;
            try {
                signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), this.f380854b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e16) {
                e16.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb5 = new StringBuilder();
                        for (byte b16 : digest) {
                            sb5.append(Integer.toHexString((b16 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb5.toString();
                    }
                } catch (NoSuchAlgorithmException e17) {
                    e17.printStackTrace();
                }
            }
            this.f380855c = str2;
        }
        String a16 = ((o0.a.C10011a) this.f380853a).a(this.f380854b, this.f380855c, str);
        if (TextUtils.isEmpty(a16)) {
            return "";
        }
        return a16;
    }

    public String a(Context context, String str) {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) str);
        }
        synchronized (this) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (this.f380853a == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                    intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                    try {
                        if (context.bindService(intent, this.f380857e, 1)) {
                            synchronized (this.f380856d) {
                                try {
                                    this.f380856d.wait(3000L);
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    if (this.f380853a != null) {
                        try {
                            b16 = b(context, str);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                    b16 = "";
                } else {
                    try {
                        b16 = b(context, str);
                    } catch (Exception th5) {
                    }
                }
            } else {
                throw new IllegalStateException("Cannot run on MainThread");
            }
        }
        return b16;
    }
}
