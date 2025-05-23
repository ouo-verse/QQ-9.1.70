package com.tencent.tgpa.lite.e;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class f implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IBinder f375933a;

    public f(IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
        } else {
            this.f375933a = iBinder;
        }
    }

    @Override // com.tencent.tgpa.lite.e.g
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            OaidMonitor.binderTransact(this.f375933a, 1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                OaidMonitor.parcelRecycle(obtain2);
                OaidMonitor.parcelRecycle(obtain);
                return null;
            } finally {
                OaidMonitor.parcelRecycle(obtain2);
                OaidMonitor.parcelRecycle(obtain);
            }
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f375933a;
    }
}
