package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Lacerta extends Hydra {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final String f375651b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62677);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375651b = Cswitch.a(Cswitch.f375799i);
        }
    }

    public Lacerta() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tfd.sdk.wxa.Hydra
    public final String a(IBinder iBinder) throws Exception {
        Context context;
        Signature[] signatureArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iBinder);
        }
        synchronized (Cgoto.class) {
            context = Cgoto.f375756a;
        }
        String packageName = context.getPackageName();
        String str = null;
        try {
            signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), packageName, 64).signatures;
        } catch (Throwable unused) {
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
                    str = sb5.toString();
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        String a16 = Cswitch.a(Cswitch.f375801j);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, f375651b);
            obtain.writeString(packageName);
            obtain.writeString(str);
            obtain.writeString(a16);
            OaidMonitor.binderTransact(iBinder, 1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }
}
