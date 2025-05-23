package com.tencent.tmsqmsp.oaid2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface v extends IInterface {
    String b();

    String c(String str);

    boolean c();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements v {
        public static v a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof v)) {
                return (v) queryLocalInterface;
            }
            return new C10014a(iBinder);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.tmsqmsp.oaid2.v$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        static class C10014a implements v {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f380891d;

            C10014a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f380891d = iBinder;
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.f380891d;
            }

            @Override // com.tencent.tmsqmsp.oaid2.v
            public final String b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.zui.deviceidservice.IDeviceidInterface");
                    OaidMonitor.binderTransact(this.f380891d, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readString;
                } catch (RemoteException unused) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return null;
                } catch (Throwable th5) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th5;
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.v
            public final String c(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.f380891d, 5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readString;
                } catch (RemoteException unused) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return null;
                } catch (Throwable th5) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th5;
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.v
            public final boolean c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z16 = false;
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.zui.deviceidservice.IDeviceidInterface");
                    OaidMonitor.binderTransact(this.f380891d, 3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th5) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th5;
                }
                OaidMonitor.parcelRecycle(obtain2);
                OaidMonitor.parcelRecycle(obtain);
                return z16;
            }
        }
    }
}
