package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes.dex */
public interface a extends IInterface {
    void d0(int i3, String str, String str2) throws RemoteException;

    /* compiled from: P */
    /* renamed from: o.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC10875a extends Binder implements a {
        public AbstractBinderC10875a() {
            attachInterface(this, "com.android.vending.licensing.ILicenseResultListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.android.vending.licensing.ILicenseResultListener");
                return true;
            }
            parcel.enforceInterface("com.android.vending.licensing.ILicenseResultListener");
            d0(parcel.readInt(), parcel.readString(), parcel.readString());
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
