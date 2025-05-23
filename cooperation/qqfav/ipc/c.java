package cooperation.qqfav.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface c extends IInterface {
    void c(int i3, Bundle bundle) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: cooperation.qqfav.ipc.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public static class C10114a implements c {

            /* renamed from: e, reason: collision with root package name */
            public static c f390654e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f390655d;

            C10114a(IBinder iBinder) {
                this.f390655d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f390655d;
            }

            @Override // cooperation.qqfav.ipc.c
            public void c(int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "cooperation.qqfav.ipc.IQfavRemoteProxyInterface");
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f390655d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().c(i3, bundle);
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
            attachInterface(this, "cooperation.qqfav.ipc.IQfavRemoteProxyInterface");
        }

        public static c j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("cooperation.qqfav.ipc.IQfavRemoteProxyInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C10114a(iBinder);
        }

        public static c v() {
            return C10114a.f390654e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            Bundle bundle;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("cooperation.qqfav.ipc.IQfavRemoteProxyInterface");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                c(readInt, bundle);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("cooperation.qqfav.ipc.IQfavRemoteProxyInterface");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
