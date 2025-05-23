package com.tencent.superplayer.seamless.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface i extends IInterface {
    void onVideoSizeChanged(int i3, int i16) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements i {
        public a() {
            attachInterface(this, "com.tencent.superplayer.seamless.ipc.OnVideoSizeChangedListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.tencent.superplayer.seamless.ipc.OnVideoSizeChangedListener");
                return true;
            }
            parcel.enforceInterface("com.tencent.superplayer.seamless.ipc.OnVideoSizeChangedListener");
            onVideoSizeChanged(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
