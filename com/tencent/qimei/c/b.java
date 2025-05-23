package com.tencent.qimei.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface b extends IInterface {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f343217a = 0;

        /* compiled from: P */
        /* renamed from: com.tencent.qimei.c.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static class C9314a implements b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f343218a;

            public C9314a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f343218a = iBinder;
                }
            }

            @Override // com.tencent.qimei.c.b
            public String a(String str) {
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.coolpad.deviceidsupport.IDeviceIdManager");
                        obtain.writeString(str);
                        OaidMonitor.binderTransact(this.f343218a, 4, obtain, obtain2, 0);
                        obtain2.readException();
                        str2 = obtain2.readString();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        str2 = null;
                    }
                    return str2;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (IBinder) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return null;
            }

            @Override // com.tencent.qimei.c.b
            public String b(String str) {
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.coolpad.deviceidsupport.IDeviceIdManager");
                        obtain.writeString(str);
                        OaidMonitor.binderTransact(this.f343218a, 2, obtain, obtain2, 0);
                        obtain2.readException();
                        str2 = obtain2.readString();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        str2 = null;
                    }
                    return str2;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }
    }

    String a(String str);

    String b(String str);
}
