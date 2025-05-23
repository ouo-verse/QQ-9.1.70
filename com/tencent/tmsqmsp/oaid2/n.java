package com.tencent.tmsqmsp.oaid2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface n extends IInterface {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements n {

        /* compiled from: P */
        /* renamed from: com.tencent.tmsqmsp.oaid2.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static class C10010a implements n {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f380841a;

            public C10010a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f380841a = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.f380841a;
            }

            @Override // com.tencent.tmsqmsp.oaid2.n
            public boolean b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z16 = true;
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    OaidMonitor.binderTransact(this.f380841a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z16 = false;
                    }
                } catch (Exception unused) {
                } catch (Throwable th5) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th5;
                }
                OaidMonitor.parcelRecycle(obtain2);
                OaidMonitor.parcelRecycle(obtain);
                return z16;
            }

            @Override // com.tencent.tmsqmsp.oaid2.n
            public String c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    OaidMonitor.binderTransact(this.f380841a, 3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readString;
                } catch (Throwable unused) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return "";
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.n
            public String i() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    OaidMonitor.binderTransact(this.f380841a, 5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readString;
                } catch (Throwable unused) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return "";
                }
            }
        }

        public static n a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof n)) {
                return (n) queryLocalInterface;
            }
            return new C10010a(iBinder);
        }
    }

    boolean b();

    String c();

    String i();
}
