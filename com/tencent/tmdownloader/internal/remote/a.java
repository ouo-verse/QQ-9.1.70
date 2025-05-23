package com.tencent.tmdownloader.internal.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface a extends IInterface {
    int a(AppDetailReqParam appDetailReqParam, IGetAppInfoCallback iGetAppInfoCallback);

    int a(String str);

    void a(int i3, String str);

    void a(String str, int i3);

    void a(String str, long j3);

    void a(String str, boolean z16);

    void a(String str, byte[] bArr);

    String b(String str);

    void b();

    void b(String str, String str2);

    boolean c(String str);

    void d();

    byte[] d(String str);

    long e(String str);

    void e();

    void f();

    /* compiled from: P */
    /* renamed from: com.tencent.tmdownloader.internal.remote.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static abstract class AbstractBinderC10005a extends Binder implements a {
        static IPatchRedirector $redirector_;

        public AbstractBinderC10005a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C10006a(iBinder);
        }

        public static a i() {
            return C10006a.f380748b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
            AppDetailReqParam appDetailReqParam;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        a(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        b();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        d();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        f();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        e();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        a(parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        a(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        a(parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        b(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        a(readString, z16);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        byte[] d16 = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(d16);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        int a16 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(a16);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        long e16 = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(e16);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        String b16 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b16);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        boolean c16 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(c16 ? 1 : 0);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                        if (parcel.readInt() != 0) {
                            appDetailReqParam = AppDetailReqParam.CREATOR.createFromParcel(parcel);
                        } else {
                            appDetailReqParam = null;
                        }
                        int a17 = a(appDetailReqParam, IGetAppInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(a17);
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.tmdownloader.internal.remote.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static class C10006a implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            public static a f380748b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f380749a;

            C10006a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f380749a = iBinder;
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void a(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f380749a, 1, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().a(i3, str);
                    } else {
                        obtain2.readException();
                    }
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
                return this.f380749a;
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    if (!OaidMonitor.binderTransact(this.f380749a, 2, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().b();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public boolean c(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f380749a, 15, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        return AbstractBinderC10005a.i().c(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    if (!OaidMonitor.binderTransact(this.f380749a, 3, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().d();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    if (!OaidMonitor.binderTransact(this.f380749a, 5, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().e();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    if (!OaidMonitor.binderTransact(this.f380749a, 4, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().f();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void b(String str, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.f380749a, 9, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().b(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public byte[] d(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                    return (byte[]) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f380749a, 11, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        return AbstractBinderC10005a.i().d(str);
                    }
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public long e(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                    return ((Long) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).longValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f380749a, 13, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        return AbstractBinderC10005a.i().e(str);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void a(String str, byte[] bArr) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) bArr);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    if (!OaidMonitor.binderTransact(this.f380749a, 6, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().a(str, bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public String b(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                    return (String) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f380749a, 14, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        return AbstractBinderC10005a.i().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void a(String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f380749a, 7, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().a(str, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void a(String str, long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3));
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    if (!OaidMonitor.binderTransact(this.f380749a, 8, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().a(str, j3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public void a(String str, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                    iPatchRedirector.redirect((short) 12, this, str, Boolean.valueOf(z16));
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    obtain.writeInt(z16 ? 1 : 0);
                    if (!OaidMonitor.binderTransact(this.f380749a, 10, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        AbstractBinderC10005a.i().a(str, z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public int a(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f380749a, 12, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        return AbstractBinderC10005a.i().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmdownloader.internal.remote.a
            public int a(AppDetailReqParam appDetailReqParam, IGetAppInfoCallback iGetAppInfoCallback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                    return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) appDetailReqParam, (Object) iGetAppInfoCallback)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
                    if (appDetailReqParam != null) {
                        obtain.writeInt(1);
                        appDetailReqParam.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iGetAppInfoCallback != null ? iGetAppInfoCallback.asBinder() : null);
                    if (!OaidMonitor.binderTransact(this.f380749a, 16, obtain, obtain2, 0) && AbstractBinderC10005a.i() != null) {
                        return AbstractBinderC10005a.i().a(appDetailReqParam, iGetAppInfoCallback);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }
    }
}
