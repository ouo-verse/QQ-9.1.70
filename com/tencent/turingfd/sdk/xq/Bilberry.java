package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Bilberry extends Betelnut {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final String f382602b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382602b = Ccontinue.a(Ccontinue.f383273i);
        }
    }

    public Bilberry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Betelnut
    public String a(IBinder iBinder) throws Exception {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iBinder);
        }
        synchronized (Celse.class) {
            context = Celse.f383328a;
        }
        String packageName = context.getPackageName();
        Signature[] a16 = Cepheus.a(context, packageName);
        String str = null;
        if (a16 != null && a16.length > 0) {
            byte[] byteArray = a16[0].toByteArray();
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
        String a17 = Ccontinue.a(Ccontinue.f383276j);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, f382602b);
            obtain.writeString(packageName);
            obtain.writeString(str);
            obtain.writeString(a17);
            OaidMonitor.binderTransact(iBinder, 1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }
}
