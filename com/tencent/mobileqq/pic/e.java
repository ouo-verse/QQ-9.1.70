package com.tencent.mobileqq.pic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface e extends IInterface {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static abstract class a extends Binder implements e {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.pic.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public static class C8224a implements e {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            public static e f258706e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f258707d;

            C8224a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f258707d = iBinder;
                }
            }

            @Override // com.tencent.mobileqq.pic.e
            public void E1(String str, int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.pic.IPresendPicMgr");
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f258707d, 2, obtain, obtain2, 0) && a.v() != null) {
                        a.v().E1(str, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pic.e
            public void M2(String str, String str2, boolean z16, int i3, int i16) throws RemoteException {
                int i17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.pic.IPresendPicMgr");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z16) {
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                    obtain.writeInt(i17);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.f258707d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().M2(str, str2, z16, i3, i16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pic.e
            public void N() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.pic.IPresendPicMgr");
                    if (!OaidMonitor.binderTransact(this.f258707d, 4, obtain, obtain2, 0) && a.v() != null) {
                        a.v().N();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pic.e
            public int[] P() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    return (int[]) iPatchRedirector.redirect((short) 10, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.pic.IPresendPicMgr");
                    if (!OaidMonitor.binderTransact(this.f258707d, 7, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().P();
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
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
                return this.f258707d;
            }

            @Override // com.tencent.mobileqq.pic.e
            public boolean[] b4() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    return (boolean[]) iPatchRedirector.redirect((short) 9, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.pic.IPresendPicMgr");
                    if (!OaidMonitor.binderTransact(this.f258707d, 6, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().b4();
                    }
                    obtain2.readException();
                    return obtain2.createBooleanArray();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pic.e
            public int getUinType() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.pic.IPresendPicMgr");
                    if (!OaidMonitor.binderTransact(this.f258707d, 5, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().getUinType();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pic.e
            public void p1(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, i3);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.pic.IPresendPicMgr");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f258707d, 3, obtain, obtain2, 0) && a.v() != null) {
                        a.v().p1(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, "com.tencent.mobileqq.pic.IPresendPicMgr");
            }
        }

        public static e j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
            if (queryLocalInterface != null && (queryLocalInterface instanceof e)) {
                return (e) queryLocalInterface;
            }
            return new C8224a(iBinder);
        }

        public static e v() {
            return C8224a.f258706e;
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
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        M2(readString, readString2, z16, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
                        E1(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
                        p1(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
                        N();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
                        int uinType = getUinType();
                        parcel2.writeNoException();
                        parcel2.writeInt(uinType);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
                        boolean[] b46 = b4();
                        parcel2.writeNoException();
                        parcel2.writeBooleanArray(b46);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
                        int[] P = P();
                        parcel2.writeNoException();
                        parcel2.writeIntArray(P);
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.mobileqq.pic.IPresendPicMgr");
            return true;
        }
    }

    void E1(String str, int i3) throws RemoteException;

    void M2(String str, String str2, boolean z16, int i3, int i16) throws RemoteException;

    void N() throws RemoteException;

    int[] P() throws RemoteException;

    boolean[] b4() throws RemoteException;

    int getUinType() throws RemoteException;

    void p1(int i3) throws RemoteException;
}
