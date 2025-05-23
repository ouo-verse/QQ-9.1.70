package com.tencent.qimei.l;

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
    /* renamed from: com.tencent.qimei.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static abstract class AbstractBinderC9325a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f343333a = 0;

        /* compiled from: P */
        /* renamed from: com.tencent.qimei.l.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static class C9326a implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f343334a;

            public C9326a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f343334a = iBinder;
                }
            }

            @Override // com.tencent.qimei.l.a
            public String a(String str) {
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.samsung.android.deviceidservice.IDeviceIdService");
                        obtain.writeString(str);
                        OaidMonitor.binderTransact(this.f343334a, 3, obtain, obtain2, 0);
                        obtain2.readException();
                        str2 = obtain2.readString();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
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
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f343334a;
            }

            @Override // com.tencent.qimei.l.a
            public String c() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.samsung.android.deviceidservice.IDeviceIdService");
                        OaidMonitor.binderTransact(this.f343334a, 1, obtain, obtain2, 0);
                        obtain2.readException();
                        str = obtain2.readString();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        str = null;
                    }
                    return str;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }
    }

    String a(String str);

    String c();
}
