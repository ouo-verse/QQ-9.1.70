package b3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface b extends IInterface {
    void onEvent(String str, String str2) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.ihoc.tgpa.bgdownload.IPreDownloadCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("com.ihoc.tgpa.bgdownload.IPreDownloadCallback");
                onEvent(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.ihoc.tgpa.bgdownload.IPreDownloadCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
