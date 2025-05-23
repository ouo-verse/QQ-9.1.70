package com.tencent.mobileqq.ar.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface c extends IInterface {
    void Q4(ArConfigInfo arConfigInfo, ArEffectConfig arEffectConfig, ARCommonConfigInfo aRCommonConfigInfo) throws RemoteException;

    void e(int i3) throws RemoteException;

    void i(long j3, long j16) throws RemoteException;

    void onDownloadSuccess() throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.ar.aidl.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C7402a implements c {

            /* renamed from: e, reason: collision with root package name */
            public static c f197721e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f197722d;

            C7402a(IBinder iBinder) {
                this.f197722d = iBinder;
            }

            @Override // com.tencent.mobileqq.ar.aidl.c
            public void Q4(ArConfigInfo arConfigInfo, ArEffectConfig arEffectConfig, ARCommonConfigInfo aRCommonConfigInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
                    if (arConfigInfo != null) {
                        obtain.writeInt(1);
                        arConfigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (arEffectConfig != null) {
                        obtain.writeInt(1);
                        arEffectConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aRCommonConfigInfo != null) {
                        obtain.writeInt(1);
                        aRCommonConfigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f197722d, 4, obtain, obtain2, 0) && a.v() != null) {
                        a.v().Q4(arConfigInfo, arEffectConfig, aRCommonConfigInfo);
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
                return this.f197722d;
            }

            @Override // com.tencent.mobileqq.ar.aidl.c
            public void e(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f197722d, 3, obtain, obtain2, 0) && a.v() != null) {
                        a.v().e(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.c
            public void i(long j3, long j16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    if (!OaidMonitor.binderTransact(this.f197722d, 2, obtain, obtain2, 0) && a.v() != null) {
                        a.v().i(j3, j16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.c
            public void onDownloadSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
                    if (!OaidMonitor.binderTransact(this.f197722d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().onDownloadSuccess();
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
            attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
        }

        public static c j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C7402a(iBinder);
        }

        public static c v() {
            return C7402a.f197721e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            ArConfigInfo arConfigInfo;
            ArEffectConfig arEffectConfig;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                return super.onTransact(i3, parcel, parcel2, i16);
                            }
                            parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
                            ARCommonConfigInfo aRCommonConfigInfo = null;
                            if (parcel.readInt() != 0) {
                                arConfigInfo = ArConfigInfo.CREATOR.createFromParcel(parcel);
                            } else {
                                arConfigInfo = null;
                            }
                            if (parcel.readInt() != 0) {
                                arEffectConfig = ArEffectConfig.CREATOR.createFromParcel(parcel);
                            } else {
                                arEffectConfig = null;
                            }
                            if (parcel.readInt() != 0) {
                                aRCommonConfigInfo = ARCommonConfigInfo.CREATOR.createFromParcel(parcel);
                            }
                            Q4(arConfigInfo, arEffectConfig, aRCommonConfigInfo);
                            parcel2.writeNoException();
                            return true;
                        }
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
                        e(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
                    i(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
                onDownloadSuccess();
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
