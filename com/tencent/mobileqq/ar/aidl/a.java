package com.tencent.mobileqq.ar.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.b;
import com.tencent.mobileqq.ar.aidl.c;
import com.tencent.mobileqq.ar.aidl.d;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface a extends IInterface {
    void A2() throws RemoteException;

    ArConfigInfo D3() throws RemoteException;

    void N2(c cVar) throws RemoteException;

    void N4(d dVar) throws RemoteException;

    void S2(ArConfigInfo arConfigInfo) throws RemoteException;

    void V2(int i3) throws RemoteException;

    void Y() throws RemoteException;

    boolean a3() throws RemoteException;

    void b5() throws RemoteException;

    void cancelDownload() throws RemoteException;

    void f4(b bVar) throws RemoteException;

    boolean l2() throws RemoteException;

    ArEffectConfig m1() throws RemoteException;

    void n0(d dVar) throws RemoteException;

    void onToolScannerActivityStateChanged(int i3) throws RemoteException;

    boolean r1() throws RemoteException;

    ARCommonConfigInfo t1() throws RemoteException;

    void w2(b bVar) throws RemoteException;

    void z4(c cVar) throws RemoteException;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.aidl.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC7399a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.ar.aidl.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C7400a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f197717e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f197718d;

            C7400a(IBinder iBinder) {
                this.f197718d = iBinder;
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void A2() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (!OaidMonitor.binderTransact(this.f197718d, 14, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().A2();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public ArConfigInfo D3() throws RemoteException {
                ArConfigInfo arConfigInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (!OaidMonitor.binderTransact(this.f197718d, 3, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        return AbstractBinderC7399a.v().D3();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        arConfigInfo = ArConfigInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        arConfigInfo = null;
                    }
                    return arConfigInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void N2(c cVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f197718d, 2, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().N2(cVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void N4(d dVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (dVar != null) {
                        iBinder = dVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f197718d, 16, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().N4(dVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void V2(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f197718d, 10, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().V2(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public boolean a3() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f197718d, 13, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        return AbstractBinderC7399a.v().a3();
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f197718d;
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void cancelDownload() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (!OaidMonitor.binderTransact(this.f197718d, 7, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().cancelDownload();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void f4(b bVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f197718d, 9, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().f4(bVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public ArEffectConfig m1() throws RemoteException {
                ArEffectConfig arEffectConfig;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (!OaidMonitor.binderTransact(this.f197718d, 4, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        return AbstractBinderC7399a.v().m1();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        arEffectConfig = ArEffectConfig.CREATOR.createFromParcel(obtain2);
                    } else {
                        arEffectConfig = null;
                    }
                    return arEffectConfig;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void n0(d dVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (dVar != null) {
                        iBinder = dVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f197718d, 15, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().n0(dVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void onToolScannerActivityStateChanged(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f197718d, 19, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().onToolScannerActivityStateChanged(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public boolean r1() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f197718d, 11, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        return AbstractBinderC7399a.v().r1();
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

            @Override // com.tencent.mobileqq.ar.aidl.a
            public ARCommonConfigInfo t1() throws RemoteException {
                ARCommonConfigInfo aRCommonConfigInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (!OaidMonitor.binderTransact(this.f197718d, 5, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        return AbstractBinderC7399a.v().t1();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        aRCommonConfigInfo = ARCommonConfigInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        aRCommonConfigInfo = null;
                    }
                    return aRCommonConfigInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void w2(b bVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f197718d, 8, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().w2(bVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.a
            public void z4(c cVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f197718d, 1, obtain, obtain2, 0) && AbstractBinderC7399a.v() != null) {
                        AbstractBinderC7399a.v().z4(cVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public AbstractBinderC7399a() {
            attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C7400a(iBinder);
        }

        public static a v() {
            return C7400a.f197717e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            ArConfigInfo arConfigInfo;
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        z4(c.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        N2(c.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        ArConfigInfo D3 = D3();
                        parcel2.writeNoException();
                        if (D3 != null) {
                            parcel2.writeInt(1);
                            D3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        ArEffectConfig m16 = m1();
                        parcel2.writeNoException();
                        if (m16 != null) {
                            parcel2.writeInt(1);
                            m16.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        ARCommonConfigInfo t16 = t1();
                        parcel2.writeNoException();
                        if (t16 != null) {
                            parcel2.writeInt(1);
                            t16.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        b5();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        cancelDownload();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        w2(b.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        f4(b.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        V2(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        boolean r16 = r1();
                        parcel2.writeNoException();
                        parcel2.writeInt(r16 ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        if (parcel.readInt() != 0) {
                            arConfigInfo = ArConfigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            arConfigInfo = null;
                        }
                        S2(arConfigInfo);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        boolean a36 = a3();
                        parcel2.writeNoException();
                        parcel2.writeInt(a36 ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        A2();
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        n0(d.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        N4(d.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        boolean l26 = l2();
                        parcel2.writeNoException();
                        parcel2.writeInt(l26 ? 1 : 0);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        Y();
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
                        onToolScannerActivityStateChanged(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.mobileqq.ar.aidl.IArConfigManager");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
