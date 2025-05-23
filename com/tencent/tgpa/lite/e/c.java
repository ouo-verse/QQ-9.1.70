package com.tencent.tgpa.lite.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface c extends IInterface {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements c {

        /* compiled from: P */
        /* renamed from: com.tencent.tgpa.lite.e.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        private static class C9908a implements c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f375921a;

            C9908a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f375921a = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f375921a;
            }

            @Override // com.tencent.tgpa.lite.e.c
            public String c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.bun.lib.MsaIdInterface");
                    try {
                        OaidMonitor.binderTransact(this.f375921a, 3, obtain, obtain2, 0);
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C9908a(iBinder);
        }
    }

    String c();
}
