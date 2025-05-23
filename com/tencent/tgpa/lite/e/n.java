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
public interface n extends IInterface {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements n {

        /* compiled from: P */
        /* renamed from: com.tencent.tgpa.lite.e.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static class C9911a implements n {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f375953a;

            public C9911a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f375953a = iBinder;
                }
            }

            @Override // com.tencent.tgpa.lite.e.n
            public String a(String str, String str2, String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, this, str, str2, str3);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                String str4 = "com.heytap.openid.IOpenID";
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.f375953a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    str4 = obtain2.readString();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return str4;
                } catch (Throwable th5) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    try {
                        throw th5;
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.f375953a;
            }
        }

        public static n a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof n)) {
                return (n) queryLocalInterface;
            }
            return new C9911a(iBinder);
        }
    }

    String a(String str, String str2, String str3);
}
