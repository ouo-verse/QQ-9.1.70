package cooperation.qqdataline.ipc;

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
    void a(String str, Bundle bundle) throws RemoteException;

    Bundle transfer(String str, Bundle bundle) throws RemoteException;

    /* compiled from: P */
    /* renamed from: cooperation.qqdataline.ipc.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static abstract class AbstractBinderC10109a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: cooperation.qqdataline.ipc.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public static class C10110a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f390546e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f390547d;

            C10110a(IBinder iBinder) {
                this.f390547d = iBinder;
            }

            @Override // cooperation.qqdataline.ipc.a
            public void a(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "cooperation.qqdataline.ipc.IDatalineService");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f390547d, 2, obtain, obtain2, 0) && AbstractBinderC10109a.v() != null) {
                        AbstractBinderC10109a.v().a(str, bundle);
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
                return this.f390547d;
            }
        }

        public AbstractBinderC10109a() {
            attachInterface(this, "cooperation.qqdataline.ipc.IDatalineService");
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("cooperation.qqdataline.ipc.IDatalineService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C10110a(iBinder);
        }

        public static a v() {
            return C10110a.f390546e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                Bundle bundle = null;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel.enforceInterface("cooperation.qqdataline.ipc.IDatalineService");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    a(readString, bundle);
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("cooperation.qqdataline.ipc.IDatalineService");
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                Bundle transfer = transfer(readString2, bundle);
                parcel2.writeNoException();
                if (transfer != null) {
                    parcel2.writeInt(1);
                    transfer.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            parcel2.writeString("cooperation.qqdataline.ipc.IDatalineService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
