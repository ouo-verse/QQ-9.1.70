package com.tencent.mobileqq.wink.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.wink.api.a;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface IClipService extends IInterface {
    void doClipForward(List<String> list, com.tencent.mobileqq.wink.api.a aVar) throws RemoteException;

    void mediaScan(int i3, com.tencent.mobileqq.wink.api.a aVar) throws RemoteException;

    void stopScan() throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class a extends Binder implements IClipService {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.wink.api.IClipService$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static class C9011a implements IClipService {

            /* renamed from: e, reason: collision with root package name */
            public static IClipService f317955e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f317956d;

            C9011a(IBinder iBinder) {
                this.f317956d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f317956d;
            }

            @Override // com.tencent.mobileqq.wink.api.IClipService
            public void doClipForward(List<String> list, com.tencent.mobileqq.wink.api.a aVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.wink.api.IClipService");
                    obtain.writeStringList(list);
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f317956d, 3, obtain, obtain2, 0) && a.v() != null) {
                        a.v().doClipForward(list, aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.wink.api.IClipService
            public void mediaScan(int i3, com.tencent.mobileqq.wink.api.a aVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.wink.api.IClipService");
                    obtain.writeInt(i3);
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f317956d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().mediaScan(i3, aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.wink.api.IClipService
            public void stopScan() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.wink.api.IClipService");
                    if (!OaidMonitor.binderTransact(this.f317956d, 2, obtain, obtain2, 0) && a.v() != null) {
                        a.v().stopScan();
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
            attachInterface(this, "com.tencent.mobileqq.wink.api.IClipService");
        }

        public static IClipService j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.wink.api.IClipService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IClipService)) {
                return (IClipService) queryLocalInterface;
            }
            return new C9011a(iBinder);
        }

        public static IClipService v() {
            return C9011a.f317955e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 1598968902) {
                            return super.onTransact(i3, parcel, parcel2, i16);
                        }
                        parcel2.writeString("com.tencent.mobileqq.wink.api.IClipService");
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.mobileqq.wink.api.IClipService");
                    doClipForward(parcel.createStringArrayList(), a.AbstractBinderC9012a.j(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.tencent.mobileqq.wink.api.IClipService");
                stopScan();
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.tencent.mobileqq.wink.api.IClipService");
            mediaScan(parcel.readInt(), a.AbstractBinderC9012a.j(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
