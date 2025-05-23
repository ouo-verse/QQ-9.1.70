package cooperation.qqindividuality.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface a extends IInterface {
    void c(int i3, Bundle bundle) throws RemoteException;

    /* compiled from: P */
    /* renamed from: cooperation.qqindividuality.ipc.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static abstract class AbstractBinderC10117a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: cooperation.qqindividuality.ipc.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public static class C10118a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f390758e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f390759d;

            C10118a(IBinder iBinder) {
                this.f390759d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f390759d;
            }

            @Override // cooperation.qqindividuality.ipc.a
            public void c(int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f390759d, 1, obtain, obtain2, 0) && AbstractBinderC10117a.v() != null) {
                        AbstractBinderC10117a.v().c(i3, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public AbstractBinderC10117a() {
            attachInterface(this, "cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C10118a(iBinder);
        }

        public static a v() {
            return C10118a.f390758e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            Bundle bundle;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
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
            parcel2.writeString("cooperation.qqindividuality.ipc.IQQIndividualityRemoteProxyInterface");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
