package com.tencent.superplayer.seamless.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface h extends IInterface {
    void onVideoPrepared() throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements h {
        public a() {
            attachInterface(this, "com.tencent.superplayer.seamless.ipc.OnVideoPreparedListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.tencent.superplayer.seamless.ipc.OnVideoPreparedListener");
                return true;
            }
            parcel.enforceInterface("com.tencent.superplayer.seamless.ipc.OnVideoPreparedListener");
            onVideoPrepared();
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
