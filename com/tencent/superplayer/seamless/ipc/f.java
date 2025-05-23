package com.tencent.superplayer.seamless.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface f extends IInterface {
    boolean l0(int i3, long j3, long j16, ParcelableVideoSeiInfo parcelableVideoSeiInfo) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements f {
        public a() {
            attachInterface(this, "com.tencent.superplayer.seamless.ipc.OnInfoListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            ParcelableVideoSeiInfo parcelableVideoSeiInfo;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.tencent.superplayer.seamless.ipc.OnInfoListener");
                return true;
            }
            parcel.enforceInterface("com.tencent.superplayer.seamless.ipc.OnInfoListener");
            int readInt = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            if (parcel.readInt() != 0) {
                parcelableVideoSeiInfo = ParcelableVideoSeiInfo.CREATOR.createFromParcel(parcel);
            } else {
                parcelableVideoSeiInfo = null;
            }
            boolean l06 = l0(readInt, readLong, readLong2, parcelableVideoSeiInfo);
            parcel2.writeNoException();
            parcel2.writeInt(l06 ? 1 : 0);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
