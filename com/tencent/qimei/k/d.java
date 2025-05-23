package com.tencent.qimei.k;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.k.c;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final d f343326f;

    /* renamed from: a, reason: collision with root package name */
    public c f343327a;

    /* renamed from: b, reason: collision with root package name */
    public String f343328b;

    /* renamed from: c, reason: collision with root package name */
    public String f343329c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f343330d;

    /* renamed from: e, reason: collision with root package name */
    public ServiceConnection f343331e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c c9324a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            d dVar = d.this;
            int i3 = c.a.f343324a;
            if (iBinder == null) {
                c9324a = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                    c9324a = (c) queryLocalInterface;
                } else {
                    c9324a = new c.a.C9324a(iBinder);
                }
            }
            dVar.f343327a = c9324a;
            synchronized (d.this.f343330d) {
                d.this.f343330d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                d.this.f343327a = null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18952);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343326f = new d();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f343330d = new Object();
            this.f343331e = new a();
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

    public final String a(Context context, String str) {
        String str2;
        Signature[] signatureArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) str);
        }
        if (TextUtils.isEmpty(this.f343328b)) {
            this.f343328b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f343329c)) {
            String str3 = null;
            try {
                signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), this.f343328b, 64).signatures;
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
                        str3 = sb5.toString();
                    }
                } catch (NoSuchAlgorithmException e17) {
                    e17.printStackTrace();
                }
            }
            this.f343329c = str3;
        }
        c.a.C9324a c9324a = (c.a.C9324a) this.f343327a;
        String str4 = this.f343328b;
        String str5 = this.f343329c;
        c9324a.getClass();
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, "com.heytap.openid.IOpenID");
            obtain.writeString(str4);
            obtain.writeString(str5);
            obtain.writeString(str);
            OaidMonitor.binderTransact(c9324a.f343325a, 1, obtain, obtain2, 0);
            obtain2.readException();
            str2 = obtain2.readString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            str2 = "";
        }
        try {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        } catch (Throwable unused) {
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
