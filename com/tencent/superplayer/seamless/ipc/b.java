package com.tencent.superplayer.seamless.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface b extends IInterface {
    boolean S3(Bundle bundle) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.tencent.superplayer.seamless.ipc.ISeamlessService");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            Bundle bundle;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.tencent.superplayer.seamless.ipc.ISeamlessService");
                return true;
            }
            parcel.enforceInterface("com.tencent.superplayer.seamless.ipc.ISeamlessService");
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            } else {
                bundle = null;
            }
            boolean S3 = S3(bundle);
            parcel2.writeNoException();
            parcel2.writeInt(S3 ? 1 : 0);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
