package com.tencent.hlyyb.downloader.g.a;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.Collections;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void e(Context context) {
        try {
            IBinder iBinder = (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "account");
            if (iBinder == null) {
                k.m(context, d(), 20, null);
                return;
            }
            int b16 = k.b("android.accounts.IAccountManager$Stub", "TRANSACTION_addAccount");
            if (b16 == -1) {
                k.m(context, d(), 27, null);
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            Binder binder = new Binder();
            OaidMonitor.writeParcelToken(obtain, "android.accounts.IAccountManager");
            obtain.writeStrongBinder(binder);
            HashSet hashSet = new HashSet(2);
            Collections.addAll(hashSet, "com.tencent.android.qqdownloader.YYBLiveAccountProvider.account");
            obtain.writeString((String) hashSet.iterator().next());
            obtain.writeString(null);
            obtain.writeStringArray(null);
            obtain.writeInt(1);
            Bundle bundle = new Bundle();
            bundle.putBoolean("alivePullStartUp", true);
            bundle.putString("androidPackageName", "android");
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
            if (b16 == -1) {
                try {
                    OaidMonitor.binderTransact(iBinder, 24, obtain, obtain2, 0);
                } catch (Throwable unused) {
                }
                try {
                    OaidMonitor.binderTransact(iBinder, 22, obtain, obtain2, 0);
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            OaidMonitor.binderTransact(iBinder, b16, obtain, obtain2, 0);
        } catch (Throwable unused3) {
            k.m(context, d(), 23, null);
        }
    }

    @Override // com.tencent.hlyyb.downloader.g.a.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            e(this.f114655b);
        }
    }

    @Override // com.tencent.hlyyb.downloader.g.a.a
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d";
    }
}
