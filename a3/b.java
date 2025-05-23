package a3;

import a3.a;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface b extends IInterface {
    void M3(String str) throws RemoteException;

    void i1(a3.a aVar) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.ihoc.mgpa.dataforwardsdk.IDataForward");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 1598968902) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel2.writeString("com.ihoc.mgpa.dataforwardsdk.IDataForward");
                    return true;
                }
                parcel.enforceInterface("com.ihoc.mgpa.dataforwardsdk.IDataForward");
                M3(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.ihoc.mgpa.dataforwardsdk.IDataForward");
            i1(a.AbstractBinderC0006a.j(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
