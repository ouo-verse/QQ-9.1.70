package com.tencent.qimei.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static abstract class AbstractBinderC9320a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f343275a = 0;

        /* compiled from: P */
        /* renamed from: com.tencent.qimei.g.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static class C9321a implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f343276a;

            public C9321a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f343276a = iBinder;
                }
            }

            @Override // com.tencent.qimei.g.a
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z16 = false;
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.zui.deviceidservice.IDeviceidInterface");
                    OaidMonitor.binderTransact(this.f343276a, 3, obtain, obtain2, 0);
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.f343276a;
            }

            @Override // com.tencent.qimei.g.a
            public String b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.zui.deviceidservice.IDeviceidInterface");
                    OaidMonitor.binderTransact(this.f343276a, 1, obtain, obtain2, 0);
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

            @Override // com.tencent.qimei.g.a
            public String c(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.f343276a, 5, obtain, obtain2, 0);
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
        }
    }

    boolean a();

    String b();

    String c(String str);
}
